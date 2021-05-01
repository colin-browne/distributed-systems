


import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.jmdns.JmDNS;
import javax.jmdns.ServiceEvent;
import javax.jmdns.ServiceInfo;
import javax.jmdns.ServiceListener;

import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

import grpc.examples.canteen.CanteenServiceGrpc;
import grpc.examples.canteen.MenuRequest;
import grpc.examples.canteen.MenuResponse;
import grpc.examples.canteen.OrderMessage;
import grpc.examples.canteen.OrderRequest;
import grpc.examples.canteen.OrderResponse;
import grpc.examples.canteen.ReturnMessage;
import grpc.examples.canteen.CanteenServiceGrpc.CanteenServiceBlockingStub;
import grpc.examples.canteen.CanteenServiceGrpc.CanteenServiceStub;
import grpc.examples.printer.AvailabilityRequest;
import grpc.examples.printer.AvailabilityResponse;
import grpc.examples.printer.PrintRequest;
import grpc.examples.printer.PrintResponse;
import grpc.examples.printer.PrinterServiceGrpc;
import grpc.examples.printer.StatusRequest;
import grpc.examples.printer.PrinterServiceGrpc.PrinterServiceBlockingStub;
import grpc.examples.printer.PrinterServiceGrpc.PrinterServiceStub;
import grpc.examples.roombooking.BookMessage;
import grpc.examples.roombooking.BookRequest;
import grpc.examples.roombooking.DeleteRequest;
import grpc.examples.roombooking.RoomRequest;
import grpc.examples.roombooking.RoomResponse;
import grpc.examples.roombooking.RoombookingServiceGrpc;
import grpc.examples.roombooking.RoombookingServiceGrpc.RoombookingServiceBlockingStub;
import grpc.examples.roombooking.RoombookingServiceGrpc.RoombookingServiceStub;

import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import io.grpc.StatusRuntimeException;
import io.grpc.stub.StreamObserver;

import java.awt.event.ActionListener;
import java.io.IOException;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Iterator;
import java.util.Random;
import java.awt.event.ActionEvent;

public class MainGUIApplication {

	private static PrinterServiceBlockingStub blockingStubPrinter;
	private static PrinterServiceStub asyncStubPrinter;
	
	private static RoombookingServiceBlockingStub blockingStubRoombooking;
	private static RoombookingServiceStub asyncStubRoombooking;
	
	private static CanteenServiceBlockingStub blockingStubCanteen;
	private static CanteenServiceStub asyncStubCanteen;

	private ServiceInfo serviceInfo;
	
	
	private JFrame frame;
	private JLabel label1;
    private JLabel label2;
    private JLabel label3;
    private JLabel label4;
    private JLabel labelMessage;
    
    private JComboBox combo1;
    private JButton button;
    private JTextField text1;
    private JTextField text2;
    private JTextField text3;
    private JTextField text4;
    private JTextArea textArea;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MainGUIApplication window = new MainGUIApplication();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public MainGUIApplication() {
		
		String host;
		int port;
		
		
		//printer service
	    discoverService("_printer._tcp.local.");
		
		host = serviceInfo.getHostAddresses()[0];
		port = serviceInfo.getPort();

	
		ManagedChannel channelPrinter = ManagedChannelBuilder
				.forAddress(host, port)
				.usePlaintext()
				.build();	
		
		//stubs
		blockingStubPrinter = PrinterServiceGrpc.newBlockingStub(channelPrinter);
		asyncStubPrinter = PrinterServiceGrpc.newStub(channelPrinter);
		
		
	

		//canteen service
		discoverService("_canteen._tcp.local.");
		
		host = serviceInfo.getHostAddresses()[0];
		port = serviceInfo.getPort();
		
		ManagedChannel channelCanteen = ManagedChannelBuilder
				.forAddress(host, port)
				.usePlaintext()
				.build();
		//stubs
		blockingStubCanteen = CanteenServiceGrpc.newBlockingStub(channelCanteen);
		asyncStubCanteen = CanteenServiceGrpc.newStub(channelCanteen);
		
		
	
		
		
		//roombooking service
		discoverService("_roombooking._tcp.local.");
		
		host = serviceInfo.getHostAddresses()[0];
		port = serviceInfo.getPort();
		

		ManagedChannel channelRoombooking = ManagedChannelBuilder
				.forAddress(host, port)
				.usePlaintext()
				.build();
		
		//stubs
		blockingStubRoombooking = RoombookingServiceGrpc.newBlockingStub(channelRoombooking);
		asyncStubRoombooking = RoombookingServiceGrpc.newStub(channelRoombooking);

		
		initialize();
	}

	
	//Discover the service
	private void discoverService(String service_type) {
				
		try {
			// Create a JmDNS instance
			JmDNS jmdns = JmDNS.create(InetAddress.getLocalHost());
				
			jmdns.addServiceListener(service_type, new ServiceListener() {
				
				@Override
				public void serviceResolved(ServiceEvent event) {
					System.out.println(" Service resolved: " + event.getInfo());

					serviceInfo = event.getInfo();

					int port = serviceInfo.getPort();
					
					System.out.println("resolving " + service_type + " with properties ...");
					System.out.println("\t port: " + port);
					System.out.println("\t type:"+ event.getType());
					System.out.println("\t name: " + event.getName());
					System.out.println("\t description/properties: " + serviceInfo.getNiceTextString());
					System.out.println("\t host: " + serviceInfo.getHostAddresses()[0]);
				}
				
				@Override
				public void serviceRemoved(ServiceEvent event) {
					System.out.println(" Service removed: " + event.getInfo());
				}
				
				@Override
				public void serviceAdded(ServiceEvent event) {
					System.out.println(" Service added: " + event.getInfo());
				}
			});
			
			// Wait a bit
			Thread.sleep(2000);
			
			jmdns.close();

		} catch (UnknownHostException e) {
			System.out.println(e.getMessage());
		} catch (IOException e) {
			System.out.println(e.getMessage());
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		
	}
	
	
	// Initialize the contents of the frame.
	 
	private void initialize() {
		
		
		
		JPanel panel = new JPanel();
        frame = new JFrame();
        frame.add(panel);
                
    	// set up the frame 
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setTitle("SmartOffice");
        frame.setSize(650,400);
        panel.setLayout(null);

        
        // Username      
        label2 = new JLabel("UserName");
        label2.setBounds(10,20,80,25);
        
        text1 = new JTextField(20);
        text1.setBounds(140,20,165,25);
        
        

        // menu dropdown              
        label1 = new JLabel("Select an option");
        label1.setBounds(10,50,150,25);

        String[] menuoptions =    //Dropdown options
        		{"",
        		"Canteen - View Menu",
        		"Canteen - Order Food",
        		"Canteen - View Orders",
        		"Printer - List Printers",
        		"Printer - Print Document",
        		"Printer - Check Printer Status",
        		"Room Booking - Available Rooms",
        		"Room Booking - Book Room",
        		"Room Booking - Delete Booking"};
        
        combo1 = new JComboBox();
        combo1.setBounds(140,50,350,25);
        combo1.setModel(new DefaultComboBoxModel(menuoptions));
        combo1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {  
			
				// CANTEEN VIEW MENU         	
	        	if (combo1.getSelectedIndex() == 1 ) {
	        		label4.setText("");
	        		labelMessage.setText("Click the GO button");
	        	}

	        	// CANTEEN Order Food        	
	        	if (combo1.getSelectedIndex() == 2 ) {
	        		label4.setText("Menu ID / Quantity");        		
	        		labelMessage.setText("Enter UserName ,Menu ID ,Quantity and click GO");
	        	}

	        	// CANTEEN View Orders       	
	        	if (combo1.getSelectedIndex() == 3 ) {
	        		label4.setText("User List");   
	        		text2.setText("");   
	        		labelMessage.setText("Enter User List (comma separated) and click GO");
	        	}
	        	
	        	// PRINTER LIST        	
	        	if (combo1.getSelectedIndex() == 4 ) {
	        		label4.setText("");   
	        		text2.setText("");   
	        		labelMessage.setText("Click the GO button");
	        	}
	        	
	        	// PRINT DOCUMENT        	
	        	if (combo1.getSelectedIndex() == 5 ) {
	        		label4.setText("File Name");
	        		labelMessage.setText("Enter File Name and click GO");
	        	}

	        	// PRINTER STATUS        	
	        	if (combo1.getSelectedIndex() == 6 ) {
	        		label4.setText("PrinterID");
	        		labelMessage.setText("Enter PrinterID and click GO");
	        	}

	        	// ROOM BOOKING GET ROOMS        	
	        	if (combo1.getSelectedIndex() == 7 ) {
	        		label4.setText("Booking Date");
	        		labelMessage.setText("Enter Booking Date (dd/mm/yyyy) and click GO");
	        	}

	        	// ROOM BOOKING BOOK ROOM         	
	        	if (combo1.getSelectedIndex() == 8 ) {
	        		label4.setText("Book Date/Time/Room");
	        		labelMessage.setText("Enter Booking Date  (dd/mm/yyyy) ,Time ,Room No and click GO");
	        	}
	        	
	        	// ROOM BOOKING - DELETE BOOKING          	
	        	if (combo1.getSelectedIndex() == 9 ) {
	        		label4.setText("BookingID");
	        		labelMessage.setText("Enter  UserName ,BookingID and click GO");
	        	}
	        	
			}
        });
        
        
        // TEXTAREA LIST        
        label3 = new JLabel("Menu");
        label3.setBounds(10,80,150,25);
        
        textArea = new JTextArea(3, 20);
		textArea .setLineWrap(true);
		textArea.setWrapStyleWord(true);
		
		JScrollPane scrollPane = new JScrollPane(textArea);
		scrollPane.setBounds(140,80,350,180);
		
        
		// LINE 4
		label4 = new JLabel("");
	    label4.setBounds(10,270,150,25);
        
	    text2 = new JTextField(200);
	    text2.setBounds(140,270,200,25);
        
	    text3 = new JTextField(10);
	    text3.setBounds(360,270,90,25);
        
	    text4 = new JTextField(10);
	    text4.setBounds(480,270,60,25);

	     // GO button
	    button = new JButton("Go");
	    button.setBounds(10,300,80,25);  
	    button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				String userName = text1.getText();
				
				
				// Canteen - Get Menu         	
	        	if (combo1.getSelectedIndex() == 1 ) {
	        		label3.setText("Menu");
	        		
	        		textArea.setText("");
	        		MenuRequest request = MenuRequest.newBuilder().build();

					try {
						Iterator<MenuResponse> responces = blockingStubCanteen.getMenu(request);

						while(responces.hasNext()) {
							MenuResponse resp = responces.next();
							textArea.append( resp.getId() + "      " + resp.getText() + "         " + resp.getPrice() + "\n");	
						}

					} catch (StatusRuntimeException f) {
						f.printStackTrace();
					}
	        		
	        		
	        		
	        	}
	        	
	        	// Canteen - Order Items         	
	        	if (combo1.getSelectedIndex() == 2 ) {
	        		
	        		if (userName.equals("")) {
	        			labelMessage.setText("UserName cannot be blank");
	        			return;
	        		}

	        		
	        		int menuId;
	        		try {
	        			 menuId = Integer.parseInt(text2.getText());
	        		}
	        		catch (Exception e4) {
	        			labelMessage.setText("Menu ID must be numeric");
	        			return;
	        		}
	        		
	        		int qty;
	        		try {
	        			 qty = Integer.parseInt(text3.getText());
	        		}
	        		catch (Exception e4) {
	        			labelMessage.setText("Quantity must be numeric");
	        			return;
	        		}
	        		
	        		try {

 	        		StreamObserver<ReturnMessage> responseObserver = new StreamObserver<ReturnMessage>() {

	    				@Override
	    				public void onNext(ReturnMessage msg) {
	    					labelMessage.setText(msg.getMessage());
	    				}

	    				@Override
	    				public void onError(Throwable t) {
	    					t.printStackTrace();
	    				}

	    				@Override
	    				public void onCompleted() {
	    					System.out.println("stream is completed ...");
	    				}
	        		};
	    			
	    			StreamObserver<OrderRequest> requestObserver = asyncStubCanteen.orderItems(responseObserver);
	    				requestObserver.onNext(OrderRequest.newBuilder().setId(1).setQuantity(qty).setUsername(userName).build());

	    				// Mark the end of requests
	    				requestObserver.onCompleted();


	    				// Sleep for a bit before sending the next one.
	    				Thread.sleep(new Random().nextInt(1000) + 500);


	    			} catch (RuntimeException eb) {
	    				eb.printStackTrace();
	    			} catch (InterruptedException eb) {			
	    				eb.printStackTrace();
	    			}
	        		
	        	}

	        	
	        	
	        	// Canteen - View Orders         	
	        	if (combo1.getSelectedIndex() == 3 ) {
	        		label3.setText("Orders List");

	        		textArea.setText("");
	        			        		
	        		StreamObserver<OrderResponse> responseObserver = new StreamObserver<OrderResponse>() {

	    				@Override
	    				public void onNext(OrderResponse msg) {
	    					System.out.println("receiving message");
	    					textArea.append(msg.getUsername() + "    " + msg.getId() + "        " + msg.getQuantity() + "\n");
	    				}

	    				@Override
	    				public void onError(Throwable t) {
	    				}

	    				@Override
	    				public void onCompleted() {
	    					System.out.println("Stream is completed");
	    				}
	    			};
	    			
	    			
	    			StreamObserver<OrderMessage> requestObserver = asyncStubCanteen.viewOrders(responseObserver);
	    			
	    			try {
	    				
	    				// Split user list - Allows user to enter more than one username
		        		String userList = text2.getText();
		        		String[] arrSplit = userList.split(",");
		        	    for (int i=0; i < arrSplit.length; i++)
		        	    {
		        	    	requestObserver.onNext(OrderMessage.newBuilder().setUsername(arrSplit[i]).build());
		        	    }

	    				// Mark the end of requests
	    				requestObserver.onCompleted();

	    				// Sleep for a period before sending the next one.
	    				Thread.sleep(new Random().nextInt(1000) + 500);


	    			} catch (RuntimeException ec) {
	    				ec.printStackTrace();
	    			} catch (InterruptedException ec) {			
	    				ec.printStackTrace();
	    			}



	    			try {
	    				Thread.sleep(1500);
	    			} catch (InterruptedException ec) {
	    				ec.printStackTrace();
	    			}

	        	}
	        	        	
	        	
	        	// Printer - List printers        	
	        	if (combo1.getSelectedIndex() == 4 ) {
	        		label3.setText("Printer List");

	        		textArea.setText("");
	        		
	        		
	        		AvailabilityRequest request = AvailabilityRequest.newBuilder().build();

	    			try {
	    				Iterator<AvailabilityResponse> responces = blockingStubPrinter.listPrinters(request);

	    				while(responces.hasNext()) {
	    					AvailabilityResponse resp = responces.next();
	    					textArea.append(resp.getId() + "   " + resp.getLocation() + "\n" );				
	    				}

	    			} catch (StatusRuntimeException e1) {
	    				e1.printStackTrace();
	    			}
	        	}
	        	
	        	
	        	// Printer - Print document    
	        	if (combo1.getSelectedIndex() == 5 ) {
	        		String fileName = text2.getText();
	        		PrintRequest req = PrintRequest.newBuilder().setFilename(fileName).build();
					PrintResponse response = blockingStubPrinter.printDocument(req);

	        		labelMessage.setText(response.getMessage());
	        	}
	        	
	        	
	        	
	        	// Printer - Status   
	        	if (combo1.getSelectedIndex() == 6 ) {
	        		
	        		int printerID;
	        		
	        		try {
	        			 printerID  = Integer.parseInt(text2.getText());
	        		}
	        		catch (Exception e4) {
	        			labelMessage.setText("PrintID must be numeric");
	        			return;
	        		}
	        		
	        		StatusRequest req = StatusRequest.newBuilder().setId(printerID).build();					
					grpc.examples.printer.ReturnMessage response = blockingStubPrinter.printerStatus(req);

					labelMessage.setText(response.getMessage());
	        	}


	        	// Room Booking - Get rooms     
	        	if (combo1.getSelectedIndex() == 7 ) {
	        		label3.setText("Booking List");

	        		// Validate date	        		
	        		String datestr = text2.getText();
	        		if (!validateDate(datestr)) {
	        			labelMessage.setText("Booking Date must be in the format dd/mm/yyyy");
	        			return;
	        		}
	        		
	        		long bookDate;	        		
	        		String dateyyyymmdd = datestr.substring(6, 10) + datestr.substring(3, 5)  + datestr.substring(0, 2);
        			bookDate  = Integer.parseInt(dateyyyymmdd);
	        		
	        		textArea.setText("");	        		

	        		RoomRequest request = RoomRequest.newBuilder().setDate(bookDate).build();

	        		try {
	        			Iterator<RoomResponse> responces = blockingStubRoombooking.getAvailableRooms(request);

	        			while(responces.hasNext()) {
	        				RoomResponse resp = responces.next();
	        				textArea.append(datestr + "     " + "Room" + resp.getNumber() + "    " + resp.getTime() + "\n" );			
	        			}

	        		} catch (StatusRuntimeException e5) {
	        			e5.printStackTrace();
	        		}
	        	}
	        	
	        	
	        	// Room Booking - Book room     
	        	if (combo1.getSelectedIndex() == 8 ) {
	        		
	        		if (userName.equals("")) {
	        			labelMessage.setText("UserName cannot be blank");
	        			return;
	        		}
	        		
	        		// Validate date	        		
	        		String datestr = text2.getText();
	        		if (!validateDate(datestr)) {
	        			labelMessage.setText("Booking Date must be in the format dd/mm/yyyy");
	        			return;
	        		}
	        		
	        		long bookDate;	        		
	        		String dateyyyymmdd = datestr.substring(6, 10) + datestr.substring(3, 5)  + datestr.substring(0, 2);
        			bookDate  = Integer.parseInt(dateyyyymmdd);

	        		
	        		int bookingTime;	        		
	        		try {
	        			bookingTime  = Integer.parseInt(text3.getText());
	        		}
	        		catch (Exception e4) {
	        			labelMessage.setText("Time must be numeric");
	        			return;
	        		}
	        		
	        		int roomNo;
	        		try {
	        			roomNo = Integer.parseInt(text4.getText());
	        		}
	        		catch (Exception e4) {
	        			labelMessage.setText("Room must be numeric");
	        			return;
	        		}
	        		
	        		BookRequest req = BookRequest.newBuilder().setUsername(userName).setDate(bookDate).setNumber(roomNo).setTime(bookingTime).build();
	        		BookMessage response = blockingStubRoombooking.bookRoom(req);
	        		
	        		labelMessage.setText(response.getMessage());
	        	}
	        	
	        	
	        	
	        	// Room booking - Delete the booking    
	        	if (combo1.getSelectedIndex() == 9 ) {
	        		
	        		if (userName.equals("")) {
	        			labelMessage.setText("UserName cannot be blank");
	        			return;
	        		}
	        		
	        		int bookingID;
	        		
	        		try {
	        			bookingID  = Integer.parseInt(text2.getText());
	        		}
	        		catch (Exception e4) {
	        			labelMessage.setText("Booking ID must be numeric");
	        			return;
	        		}
	        		
	        		DeleteRequest req = DeleteRequest.newBuilder().setUsername(userName).setId(bookingID).build();
	        		grpc.examples.roombooking.ReturnMessage response = blockingStubRoombooking.deleteBooking(req);

	        		labelMessage.setText(response.getMessage());
	        	}
	        	
			}
		});
	    
	    
	     
	    labelMessage = new JLabel("");
	    labelMessage.setBounds(140,300,400,25);
	    
	    
	    
        panel.add(label1);
        panel.add(combo1);

        panel.add(label2);
        panel.add(text1);
		
        panel.add(label3);
        panel.add(scrollPane);

        panel.add(label4);
        panel.add(text2);
        panel.add(text3);
        panel.add(text4);

        panel.add(button);
        panel.add(labelMessage);
             
        
	}

	
	//Method to validate the date - returns boolean
	public static boolean validateDate(String dateToValidate) {
		DateFormat dfm = new SimpleDateFormat("dd/MM/yyyy"); //declare format we want it in
		dfm.setLenient(false);
		
		try {
			dfm.parse(dateToValidate);  //parse in our date to be validated
			return true;
	
		} catch (Exception e) {
			return false; 
		} 
	}

}

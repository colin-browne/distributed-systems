package grpc.examples.roombooking;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.InetAddress;
import java.util.Properties;

import javax.jmdns.JmDNS;
import javax.jmdns.ServiceInfo;



import grpc.examples.roombooking.RoombookingServiceGrpc.RoombookingServiceImplBase;
import io.grpc.Server;
import io.grpc.ServerBuilder;
import io.grpc.stub.StreamObserver;

public class RoomBookingServer extends RoombookingServiceImplBase { 
	
	public static void main(String[] args) throws IOException, InterruptedException {
		 
		 //initiate the server
		 RoomBookingServer roombookingserver = new RoomBookingServer();
		 
		 //get the properties
		 Properties prop = roombookingserver.getProperties();
		 
		 //register the service
		 roombookingserver.registerService(prop);
		 
		 //assign value of service_port to port
		 int port = Integer.valueOf( prop.getProperty("service_port") ); //50051
		 
		 try {
			 
		 Server server = ServerBuilder.forPort(port)
			        .addService(roombookingserver)
			        .build()
			        .start();
		 
		 System.out.println("Service-2 has started, it is listening on " + port);

		 server.awaitTermination();
		 
		 } catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
		 } catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
		 }

		 
	 }
	
	
	
	
	

	private void registerService(Properties prop) {
		
		 try {
	            // Create a JmDNS instance
	            JmDNS jmdns = JmDNS.create(InetAddress.getLocalHost());
	            
	            String service_type = prop.getProperty("service_type") ; //assigning type of service
	            String service_name = prop.getProperty("service_name")  ;// assigning name of the service
	           
	            int service_port = Integer.valueOf( prop.getProperty("service_port") );// 50051;

	            
	            String service_description_properties = prop.getProperty("service_description")  ;
	            
	            // Register the service
	            ServiceInfo serviceInfo = ServiceInfo.create(service_type, service_name, service_port, service_description_properties);
	            jmdns.registerService(serviceInfo);
	            
	            System.out.printf("registrering service with type %s and name %s \n", service_type, service_name);
	            
	            // Wait for a period
	            Thread.sleep(1000);  

	            // Unregister all services
	            //jmdns.unregisterAllServices();

	        } catch (IOException e) {
	            System.out.println(e.getMessage());
	        } catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
	        }
		
	}
	
	
	
	
	
	
	

	private Properties getProperties() {
		
		
		 Properties prop = null;		
			
		 try (InputStream input = new FileInputStream("src/main/resources/roombooking.properties")) {

	            prop = new Properties();

	            // load a properties file
	            prop.load(input);

	            // get the property value and print it out
	            System.out.println("Roombooking Service properies: ");
	            System.out.println("\t service_type: " + prop.getProperty("service_type"));
	            System.out.println("\t service_name: " +prop.getProperty("service_name"));
	            System.out.println("\t service_description: " +prop.getProperty("service_description"));
		        System.out.println("\t service_port: " +prop.getProperty("service_port"));

	        } catch (IOException ex) {
	            ex.printStackTrace();
	        }
	
		 return prop;
		 
	}
	
	
	
	
	
	
	
	
	
	@Override
	public void getAvailableRooms(RoomRequest request, StreamObserver<RoomResponse> responseObserver) {
	    System.out.println("Get the available rooms");
	    
	    responseObserver.onNext(RoomResponse.newBuilder().setNumber(3).setTime(1400).build());
	    responseObserver.onNext(RoomResponse.newBuilder().setNumber(5).setTime(1130).build());
	    responseObserver.onNext(RoomResponse.newBuilder().setNumber(6).setTime(1030).build());
	    responseObserver.onNext(RoomResponse.newBuilder().setNumber(8).setTime(1530).build());
	    responseObserver.onNext(RoomResponse.newBuilder().setNumber(9).setTime(1700).build());
	    responseObserver.onCompleted();	    

	}
	
	
	
	
	
	
	public void bookRoom(BookRequest request, 
			StreamObserver<BookMessage> responseObserver) {

		System.out.println("receiving room booking request " + request.getUsername() + " , " + request.getDate() + " , " + request.getNumber() + " , " + request.getTime());

		
		String mes= " Hello " + request.getUsername() + " , your booking is succesfull ";
		
		int bookingID = 000+ request.getTime();

		
			
			
				

		BookMessage reply = BookMessage.newBuilder().setId(bookingID).setMessage(mes).build();

		responseObserver.onNext(reply);

		responseObserver.onCompleted();
	}
	
	
	
	
	
	
	
	
	public void deleteBooking(DeleteRequest request, 
			StreamObserver<ReturnMessage> responseObserver) {

		System.out.println("receiving delete room booking request " + request.getUsername() + " , " + request.getId());

		String mes= " Hello " + request.getUsername() + " , your booking has been succesfully deleted ";
		
		
		

		ReturnMessage reply = ReturnMessage.newBuilder().setMessage(mes).build();

		responseObserver.onNext(reply);

		responseObserver.onCompleted();
	}
}
	



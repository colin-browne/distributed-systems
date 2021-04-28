package grpc.examples.canteen;

import io.grpc.Server;
import io.grpc.ServerBuilder;
import io.grpc.Status;
import io.grpc.StatusRuntimeException;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.InetAddress;
import java.util.ArrayList;
import java.util.Properties;

import javax.jmdns.JmDNS;
import javax.jmdns.ServiceInfo;


import grpc.examples.canteen.CanteenServiceGrpc.CanteenServiceImplBase;

import io.grpc.stub.StreamObserver;

public class CanteenServer extends CanteenServiceImplBase {
	
	
	 public static void main(String[] args) throws IOException, InterruptedException {
		 
		 //initiate the server
		 CanteenServer canteenserver = new CanteenServer();
		 
		 //get the properties
		 Properties prop = canteenserver.getProperties();
		 
		 //register the service
		 canteenserver.registerService(prop);
		 
		 //assign value of service_port to port
		 int port = Integer.valueOf( prop.getProperty("service_port") ); //50051
		 
		 try {
			 
		 Server server = ServerBuilder.forPort(port)
			        .addService(canteenserver)
			        .build()
			        .start();
		 
		 System.out.println("Service-1 has started, it is listening on " + port);

		 server.awaitTermination();
		 
		 } catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
		 } catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
		 }

		 
	 }
	 
	 
	 
	 
	 private Properties getProperties() {
			
		 Properties prop = null;		
			
		 try (InputStream input = new FileInputStream("src/main/resources/canteen.properties")) {

	            prop = new Properties();

	            // load a properties file
	            prop.load(input);

	            // get the property value and print it out
	            System.out.println("Canteen Service properies: ");
	            System.out.println("\t service_type: " + prop.getProperty("service_type"));
	            System.out.println("\t service_name: " +prop.getProperty("service_name"));
	            System.out.println("\t service_description: " +prop.getProperty("service_description"));
		        System.out.println("\t service_port: " +prop.getProperty("service_port"));

	        } catch (IOException ex) {
	            ex.printStackTrace();
	        }
	
		 return prop;
		 
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






	@Override
	public void getMenu(MenuRequest request, StreamObserver<MenuResponse> responseObserver) {
	    System.out.println("Get menu");
	    
	    responseObserver.onNext(MenuResponse.newBuilder().setId(1) .setText("PIZZA").setPrice((float) 10.5).build());
	    responseObserver.onNext(MenuResponse.newBuilder().setId(2) .setText("CURRY").setPrice((float) 20).build());
	    responseObserver.onNext(MenuResponse.newBuilder().setId(3) .setText("TEA").setPrice((float) 2.5).build());
	    responseObserver.onCompleted();	    

	}
	
	

	@Override
	public StreamObserver<OrderRequest> orderItems(StreamObserver<ReturnMessage> responseObserver) {
		
		return new StreamObserver<OrderRequest>() {
			
			String replyMes ="Order successfull";

			

			@Override
			public void onNext( OrderRequest request) {

				System.out.println("receiving username "+ request.getUsername() + " recieving quantity " + request.getQuantity() + " recieving menuID " +request.getId()  );
		           

			}

			@Override
			public void onError(Throwable t) {
				

			}

			@Override
			public void onCompleted() {
				System.out.printf("Order items method complete \n" );

				

				ReturnMessage reply = ReturnMessage.newBuilder().setMessage(replyMes).build();

				;
				responseObserver.onNext(reply);

				responseObserver.onCompleted();

			}
		

		};
	}


	
		
	

  @Override

 public StreamObserver<OrderMessage> viewOrders(StreamObserver<OrderResponse> responseObserver) {

               

                return new StreamObserver<OrderMessage>() {

                               

                               @Override

                                public void onNext(OrderMessage msg) {

                                                System.out.println("Server Recvd username " + msg.getUsername());

                                                String user = msg.getUsername();

                                               

                                                if (user.equals("Colin97")) {

                                                                responseObserver.onNext(OrderResponse.newBuilder().setQuantity(1).setUsername(user).setQuantity(1).build());

                                                                responseObserver.onNext(OrderResponse.newBuilder().setQuantity(1).setUsername(user).setQuantity(2).build());

                                                                responseObserver.onNext(OrderResponse.newBuilder().setQuantity(1).setUsername(user).setQuantity(3).build());                                                                               

                                                }

                                                if (user.equals("Patrick123")) {

                                                                responseObserver.onNext(OrderResponse.newBuilder().setQuantity(1).setUsername(user).setQuantity(10).build());

                                                                responseObserver.onNext(OrderResponse.newBuilder().setQuantity(1).setUsername(user).setQuantity(11).build());

                                                }

                                                if (user.equals("Grace007")) {

                                                                responseObserver.onNext(OrderResponse.newBuilder().setQuantity(1).setUsername(user).setQuantity(1).build());

                                                }

                                }



                                @Override

                                public void onError(Throwable t) {

                                                t.printStackTrace();

                                }



                                @Override

                                public void onCompleted() {

                          responseObserver.onCompleted();

                                }

                               

                               

                };



  }
}
	



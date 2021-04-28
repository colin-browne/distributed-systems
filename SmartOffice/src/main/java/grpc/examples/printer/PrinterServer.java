package grpc.examples.printer;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.InetAddress;
import java.util.Properties;

import javax.jmdns.JmDNS;
import javax.jmdns.ServiceInfo;

import grpc.examples.printer.PrinterServiceGrpc.PrinterServiceImplBase;

import io.grpc.Server;
import io.grpc.ServerBuilder;

public class PrinterServer extends PrinterServiceImplBase {
	
	
	
	public static void main(String[] args) throws IOException, InterruptedException {
		 
		 //initiate the server
		PrinterServer printerserver = new PrinterServer();
		 
		 //get the properties
		 Properties prop = printerserver.getProperties();
		 
		 //register the service
		 printerserver.registerService(prop);
		 
		 //assign value of service_port to port
		 int port = Integer.valueOf( prop.getProperty("service_port") ); //50051
		 
		 try {
			 
		 Server server = ServerBuilder.forPort(port)
			        .addService(printerserver)
			        .build()
			        .start();
		 
		 System.out.println("Service-3 has started, it is listening on " + port);

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
			
		 try (InputStream input = new FileInputStream("src/main/resources/printer.properties")) {

	            prop = new Properties();

	            // load a properties file
	            prop.load(input);

	            // get the property value and print it out
	            System.out.println("Printer Service properies: ");
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
            
            System.out.printf("registering service with type %s and name %s \n", service_type, service_name);
            
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

}

package grpc.examples.printer;

import java.util.Iterator;


import grpc.examples.printer.PrinterServiceGrpc.PrinterServiceBlockingStub;
import grpc.examples.printer.PrinterServiceGrpc.PrinterServiceStub;

import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import io.grpc.StatusRuntimeException;
import io.grpc.stub.StreamObserver;

public class PrinterClient {
	
	
	private static PrinterServiceBlockingStub blockingStub;
	private static PrinterServiceStub asyncStub;
	
	public static void main(String[] args) throws Exception {
		
	ManagedChannel channel = ManagedChannelBuilder
				.forAddress("localhost", 50051)
				.usePlaintext()
				.build();
		
	//stubs -- generate from proto.
		
	blockingStub = PrinterServiceGrpc.newBlockingStub(channel);

	asyncStub = PrinterServiceGrpc.newStub(channel);
	
	//methods
	listPrintersBlocking();
	listPrintersAsyn();	
	
    
    
    channel.shutdownNow();
	
	System.out.println("Finished");
    
	
	}
	
	
	
	
		//blocking server-streaming
		private static void listPrintersBlocking() {
			
			AvailabilityRequest request = AvailabilityRequest.newBuilder().build();

			try {
				Iterator<AvailabilityResponse> responces = blockingStub.listPrinters(request);

				while(responces.hasNext()) {
					AvailabilityResponse temp = responces.next();
					System.out.println(temp.getId());				
				}

			} catch (StatusRuntimeException e) {
				e.printStackTrace();
			}
		}
		
		
		
		
		
		
		
				//asyn server-streaming
				public static void listPrintersAsyn() {

					AvailabilityRequest request = AvailabilityRequest.newBuilder().build();
					
							

					StreamObserver<AvailabilityResponse> responseObserver = new StreamObserver<AvailabilityResponse>() {

						int count =0 ;

						@Override
						public void onNext(AvailabilityResponse value) {
							System.out.println("Printer ID = " + value.getId() + " Location = " + value.getLocation());
							count += 1;
						}

						@Override
						public void onError(Throwable t) {
							t.printStackTrace();

						}

						@Override
						public void onCompleted() {
							System.out.println("stream is completed ... received "+ count+ " available printers");
						}

					};

					asyncStub.listPrinters(request, responseObserver);

					try {
						Thread.sleep(15000);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}

				}
				
				
				
				
				
				
				
				

		
		
		
	

}

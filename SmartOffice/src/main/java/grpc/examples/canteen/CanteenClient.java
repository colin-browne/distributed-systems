package grpc.examples.canteen;


import java.util.Iterator;
import java.util.Random;

import grpc.examples.canteen.CanteenServiceGrpc.CanteenServiceBlockingStub;
import grpc.examples.canteen.CanteenServiceGrpc.CanteenServiceStub;

import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import io.grpc.StatusRuntimeException;
import io.grpc.stub.StreamObserver;

public class CanteenClient {

	
		private static CanteenServiceBlockingStub blockingStub;
		private static CanteenServiceStub asyncStub;
		
		public static void main(String[] args) throws Exception {
			
		ManagedChannel channel = ManagedChannelBuilder
					.forAddress("localhost", 50051)
					.usePlaintext()
					.build();
			
		//stubs -- generate from protofile
			
		blockingStub = CanteenServiceGrpc.newBlockingStub(channel);

		asyncStub = CanteenServiceGrpc.newStub(channel);
		
		
		//methods
		
		getMenuAsyn();
		getMenuBlocking();
		orderItems();
		viewOrders();
		
		channel.shutdownNow();
		
		System.out.println("Finished");	
		

	}
		
		//blocking server-streaming
		public static void getMenuBlocking() {
			MenuRequest request = MenuRequest.newBuilder().build();

			try {
				Iterator<MenuResponse> responces = blockingStub.getMenu(request);

				while(responces.hasNext()) {
					MenuResponse temp = responces.next();
					System.out.println(temp.getText());				
				}

			} catch (StatusRuntimeException e) {
				e.printStackTrace();
			}

		}
		
		
		//server streaming rpc method
		public static void getMenuAsyn() {

			MenuRequest request = MenuRequest.newBuilder().build();

			StreamObserver<MenuResponse> responseObserver = new StreamObserver<MenuResponse>() {

				int count =0 ;

				@Override
				public void onNext(MenuResponse value) {
					System.out.println("Client menu item ID = " + value.getId() + " Text = " + value.getText() + " Price = "+ value.getPrice());
					count += 1;
				}

				@Override
				public void onError(Throwable t) {
					t.printStackTrace();

				}

				@Override
				public void onCompleted() {
					System.out.println("stream is completed ... received "+ count+ " menu items");
				}

			};

			asyncStub.getMenu(request, responseObserver);

			try {
				Thread.sleep(15000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}

				
		
		
		//client streaming rpc method
		public static void orderItems() {
			
			StreamObserver<ReturnMessage> responseObserver = new StreamObserver<ReturnMessage>() {

				@Override
				public void onNext(ReturnMessage msg) {
					System.out.println("Recieving order " + msg.getMessage() );
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
			
			
			StreamObserver<OrderRequest> requestObserver = asyncStub.orderItems(responseObserver);
			
			try {
				requestObserver.onNext(OrderRequest.newBuilder().setUsername("Graham11").setQuantity(4).setId(1).build());
				Thread.sleep(500);

				requestObserver.onNext(OrderRequest.newBuilder().setUsername("David11").setQuantity(12).setId(2).build());
				Thread.sleep(500);

				requestObserver.onNext(OrderRequest.newBuilder().setUsername("Sean211").setQuantity(2).setId(3).build());
				Thread.sleep(500);

				


				// Mark the end of requests
				requestObserver.onCompleted();

				
				Thread.sleep(10000);
				
			} catch (RuntimeException e) {
				e.printStackTrace();
			} catch (InterruptedException e) {			
				e.printStackTrace();
			}


		}	

			
			
		
		
		//bi-directional streaming RPC method
		public static void viewOrders() {
			
			StreamObserver<OrderResponse> responseObserver = new StreamObserver<OrderResponse>() {

				@Override
				public void onNext(OrderResponse msg) {

					System.out.println("recieving username " + msg.getUsername() + " menuId "+msg.getId()+" quantity "+msg.getQuantity());

				}

				@Override
				public void onError(Throwable t) {
					// TODO Auto-generated method stub

				}

				@Override
				public void onCompleted() {
					// TODO Auto-generated method stub
					System.out.println("Stream is completed");
				}
			};
			
			
			StreamObserver<OrderMessage> requestObserver = asyncStub.viewOrders(responseObserver);
			
			try {
				
				requestObserver.onNext(OrderMessage.newBuilder().setUsername("Colin97").build());
				requestObserver.onNext(OrderMessage.newBuilder().setUsername("Patrick123").build());
				requestObserver.onNext(OrderMessage.newBuilder().setUsername("Grace007").build());

				// Mark the end of requests
				requestObserver.onCompleted();


				// Sleep for a period before sending the next one.
				Thread.sleep(new Random().nextInt(1000) + 500);


			} catch (RuntimeException e) {
				e.printStackTrace();
			} catch (InterruptedException e) {			
				e.printStackTrace();
			}



			try {
				Thread.sleep(15000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}	

			
	}

		



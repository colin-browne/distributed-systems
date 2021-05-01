package grpc.examples.roombooking;


import java.util.Iterator;



import grpc.examples.roombooking.RoombookingServiceGrpc.RoombookingServiceBlockingStub;
import grpc.examples.roombooking.RoombookingServiceGrpc.RoombookingServiceStub;
import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import io.grpc.StatusRuntimeException;
import io.grpc.stub.StreamObserver;

public class RoombookingClient  {
	
	
	private static RoombookingServiceBlockingStub blockingStub;
	private static RoombookingServiceStub asyncStub;
	
	public static void main(String[] args) throws Exception {
		
	ManagedChannel channel = ManagedChannelBuilder
				.forAddress("localhost", 50052)
				.usePlaintext()
				.build();
		
	//stubs -- generate from proto.
		
	blockingStub = RoombookingServiceGrpc.newBlockingStub(channel);

	asyncStub = RoombookingServiceGrpc.newStub(channel);
	
	//methods
	
	getAvailableRoomsAsyn();
    getAvailableRoomsBlocking(); 
    bookRoom();  
    deleteBooking();
    
    
    channel.shutdownNow();
	
	System.out.println("Finished");
    
	
	}
	
	
	
	
	
	
	//unary rpc method
	private static void bookRoom() {

		BookRequest req = BookRequest.newBuilder().setUsername("colin12").setDate(20210427).setNumber(3).setTime(1400).build();

		BookMessage response = blockingStub.bookRoom(req);

		System.out.println("Message: " + response.getMessage() + " BookingId: " + response.getId());
	}
	
	

	
	
	//unary prc method
	private static void deleteBooking() {

		DeleteRequest req = DeleteRequest.newBuilder().setUsername("colin12").setId(1400).build();

		ReturnMessage response = blockingStub.deleteBooking(req);

		System.out.println("Message: " + response.getMessage());
		
	}
	
	
	
	
	
	
	
	//blocking server-streaming
	private static void getAvailableRoomsBlocking() {
		
		RoomRequest request = RoomRequest.newBuilder().build();

		try {
			Iterator<RoomResponse> responces = blockingStub.getAvailableRooms(request);

			while(responces.hasNext()) {
				RoomResponse temp = responces.next();
				System.out.println(temp.getNumber());	//code not sure 	maybe add temp.getTime		
			}

		} catch (StatusRuntimeException e) {
			e.printStackTrace();
		}		
	}
	
	

	
	//asyn server streaming rpc method
	private static void getAvailableRoomsAsyn() {
		
		RoomRequest request = RoomRequest.newBuilder().build();

		StreamObserver<RoomResponse> responseObserver = new StreamObserver<RoomResponse>() {

			int count =0 ;

			@Override
			public void onNext(RoomResponse value) {
				System.out.println("Room number = " + value.getNumber() + " Timeslot = " + value.getTime());
				count += 1;
			}

			@Override
			public void onError(Throwable t) {
				t.printStackTrace();

			}

			@Override
			public void onCompleted() {
				System.out.println("stream is completed ... received "+ count+ " available rooms");
			}

		};

		asyncStub.getAvailableRooms(request, responseObserver);

		try {
			Thread.sleep(15000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}

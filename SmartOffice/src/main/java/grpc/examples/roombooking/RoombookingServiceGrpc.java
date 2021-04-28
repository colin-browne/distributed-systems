package grpc.examples.roombooking;

import static io.grpc.MethodDescriptor.generateFullMethodName;
import static io.grpc.stub.ClientCalls.asyncBidiStreamingCall;
import static io.grpc.stub.ClientCalls.asyncClientStreamingCall;
import static io.grpc.stub.ClientCalls.asyncServerStreamingCall;
import static io.grpc.stub.ClientCalls.asyncUnaryCall;
import static io.grpc.stub.ClientCalls.blockingServerStreamingCall;
import static io.grpc.stub.ClientCalls.blockingUnaryCall;
import static io.grpc.stub.ClientCalls.futureUnaryCall;
import static io.grpc.stub.ServerCalls.asyncBidiStreamingCall;
import static io.grpc.stub.ServerCalls.asyncClientStreamingCall;
import static io.grpc.stub.ServerCalls.asyncServerStreamingCall;
import static io.grpc.stub.ServerCalls.asyncUnaryCall;
import static io.grpc.stub.ServerCalls.asyncUnimplementedStreamingCall;
import static io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall;

/**
 */
@javax.annotation.Generated(
    value = "by gRPC proto compiler (version 1.15.0)",
    comments = "Source: roombooking.proto")
public final class RoombookingServiceGrpc {

  private RoombookingServiceGrpc() {}

  public static final String SERVICE_NAME = "RoombookingService";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<grpc.examples.roombooking.RoomRequest,
      grpc.examples.roombooking.RoomResponse> getGetAvailableRoomsMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "getAvailableRooms",
      requestType = grpc.examples.roombooking.RoomRequest.class,
      responseType = grpc.examples.roombooking.RoomResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.SERVER_STREAMING)
  public static io.grpc.MethodDescriptor<grpc.examples.roombooking.RoomRequest,
      grpc.examples.roombooking.RoomResponse> getGetAvailableRoomsMethod() {
    io.grpc.MethodDescriptor<grpc.examples.roombooking.RoomRequest, grpc.examples.roombooking.RoomResponse> getGetAvailableRoomsMethod;
    if ((getGetAvailableRoomsMethod = RoombookingServiceGrpc.getGetAvailableRoomsMethod) == null) {
      synchronized (RoombookingServiceGrpc.class) {
        if ((getGetAvailableRoomsMethod = RoombookingServiceGrpc.getGetAvailableRoomsMethod) == null) {
          RoombookingServiceGrpc.getGetAvailableRoomsMethod = getGetAvailableRoomsMethod = 
              io.grpc.MethodDescriptor.<grpc.examples.roombooking.RoomRequest, grpc.examples.roombooking.RoomResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.SERVER_STREAMING)
              .setFullMethodName(generateFullMethodName(
                  "RoombookingService", "getAvailableRooms"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  grpc.examples.roombooking.RoomRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  grpc.examples.roombooking.RoomResponse.getDefaultInstance()))
                  .setSchemaDescriptor(new RoombookingServiceMethodDescriptorSupplier("getAvailableRooms"))
                  .build();
          }
        }
     }
     return getGetAvailableRoomsMethod;
  }

  private static volatile io.grpc.MethodDescriptor<grpc.examples.roombooking.BookRequest,
      grpc.examples.roombooking.BookMessage> getBookRoomMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "bookRoom",
      requestType = grpc.examples.roombooking.BookRequest.class,
      responseType = grpc.examples.roombooking.BookMessage.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<grpc.examples.roombooking.BookRequest,
      grpc.examples.roombooking.BookMessage> getBookRoomMethod() {
    io.grpc.MethodDescriptor<grpc.examples.roombooking.BookRequest, grpc.examples.roombooking.BookMessage> getBookRoomMethod;
    if ((getBookRoomMethod = RoombookingServiceGrpc.getBookRoomMethod) == null) {
      synchronized (RoombookingServiceGrpc.class) {
        if ((getBookRoomMethod = RoombookingServiceGrpc.getBookRoomMethod) == null) {
          RoombookingServiceGrpc.getBookRoomMethod = getBookRoomMethod = 
              io.grpc.MethodDescriptor.<grpc.examples.roombooking.BookRequest, grpc.examples.roombooking.BookMessage>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(
                  "RoombookingService", "bookRoom"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  grpc.examples.roombooking.BookRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  grpc.examples.roombooking.BookMessage.getDefaultInstance()))
                  .setSchemaDescriptor(new RoombookingServiceMethodDescriptorSupplier("bookRoom"))
                  .build();
          }
        }
     }
     return getBookRoomMethod;
  }

  private static volatile io.grpc.MethodDescriptor<grpc.examples.roombooking.DeleteRequest,
      grpc.examples.roombooking.ReturnMessage> getDeleteBookingMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "deleteBooking",
      requestType = grpc.examples.roombooking.DeleteRequest.class,
      responseType = grpc.examples.roombooking.ReturnMessage.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<grpc.examples.roombooking.DeleteRequest,
      grpc.examples.roombooking.ReturnMessage> getDeleteBookingMethod() {
    io.grpc.MethodDescriptor<grpc.examples.roombooking.DeleteRequest, grpc.examples.roombooking.ReturnMessage> getDeleteBookingMethod;
    if ((getDeleteBookingMethod = RoombookingServiceGrpc.getDeleteBookingMethod) == null) {
      synchronized (RoombookingServiceGrpc.class) {
        if ((getDeleteBookingMethod = RoombookingServiceGrpc.getDeleteBookingMethod) == null) {
          RoombookingServiceGrpc.getDeleteBookingMethod = getDeleteBookingMethod = 
              io.grpc.MethodDescriptor.<grpc.examples.roombooking.DeleteRequest, grpc.examples.roombooking.ReturnMessage>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(
                  "RoombookingService", "deleteBooking"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  grpc.examples.roombooking.DeleteRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  grpc.examples.roombooking.ReturnMessage.getDefaultInstance()))
                  .setSchemaDescriptor(new RoombookingServiceMethodDescriptorSupplier("deleteBooking"))
                  .build();
          }
        }
     }
     return getDeleteBookingMethod;
  }

  /**
   * Creates a new async stub that supports all call types for the service
   */
  public static RoombookingServiceStub newStub(io.grpc.Channel channel) {
    return new RoombookingServiceStub(channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static RoombookingServiceBlockingStub newBlockingStub(
      io.grpc.Channel channel) {
    return new RoombookingServiceBlockingStub(channel);
  }

  /**
   * Creates a new ListenableFuture-style stub that supports unary calls on the service
   */
  public static RoombookingServiceFutureStub newFutureStub(
      io.grpc.Channel channel) {
    return new RoombookingServiceFutureStub(channel);
  }

  /**
   */
  public static abstract class RoombookingServiceImplBase implements io.grpc.BindableService {

    /**
     */
    public void getAvailableRooms(grpc.examples.roombooking.RoomRequest request,
        io.grpc.stub.StreamObserver<grpc.examples.roombooking.RoomResponse> responseObserver) {
      asyncUnimplementedUnaryCall(getGetAvailableRoomsMethod(), responseObserver);
    }

    /**
     */
    public void bookRoom(grpc.examples.roombooking.BookRequest request,
        io.grpc.stub.StreamObserver<grpc.examples.roombooking.BookMessage> responseObserver) {
      asyncUnimplementedUnaryCall(getBookRoomMethod(), responseObserver);
    }

    /**
     */
    public void deleteBooking(grpc.examples.roombooking.DeleteRequest request,
        io.grpc.stub.StreamObserver<grpc.examples.roombooking.ReturnMessage> responseObserver) {
      asyncUnimplementedUnaryCall(getDeleteBookingMethod(), responseObserver);
    }

    @java.lang.Override public final io.grpc.ServerServiceDefinition bindService() {
      return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
          .addMethod(
            getGetAvailableRoomsMethod(),
            asyncServerStreamingCall(
              new MethodHandlers<
                grpc.examples.roombooking.RoomRequest,
                grpc.examples.roombooking.RoomResponse>(
                  this, METHODID_GET_AVAILABLE_ROOMS)))
          .addMethod(
            getBookRoomMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                grpc.examples.roombooking.BookRequest,
                grpc.examples.roombooking.BookMessage>(
                  this, METHODID_BOOK_ROOM)))
          .addMethod(
            getDeleteBookingMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                grpc.examples.roombooking.DeleteRequest,
                grpc.examples.roombooking.ReturnMessage>(
                  this, METHODID_DELETE_BOOKING)))
          .build();
    }
  }

  /**
   */
  public static final class RoombookingServiceStub extends io.grpc.stub.AbstractStub<RoombookingServiceStub> {
    private RoombookingServiceStub(io.grpc.Channel channel) {
      super(channel);
    }

    private RoombookingServiceStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected RoombookingServiceStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new RoombookingServiceStub(channel, callOptions);
    }

    /**
     */
    public void getAvailableRooms(grpc.examples.roombooking.RoomRequest request,
        io.grpc.stub.StreamObserver<grpc.examples.roombooking.RoomResponse> responseObserver) {
      asyncServerStreamingCall(
          getChannel().newCall(getGetAvailableRoomsMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void bookRoom(grpc.examples.roombooking.BookRequest request,
        io.grpc.stub.StreamObserver<grpc.examples.roombooking.BookMessage> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getBookRoomMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void deleteBooking(grpc.examples.roombooking.DeleteRequest request,
        io.grpc.stub.StreamObserver<grpc.examples.roombooking.ReturnMessage> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getDeleteBookingMethod(), getCallOptions()), request, responseObserver);
    }
  }

  /**
   */
  public static final class RoombookingServiceBlockingStub extends io.grpc.stub.AbstractStub<RoombookingServiceBlockingStub> {
    private RoombookingServiceBlockingStub(io.grpc.Channel channel) {
      super(channel);
    }

    private RoombookingServiceBlockingStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected RoombookingServiceBlockingStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new RoombookingServiceBlockingStub(channel, callOptions);
    }

    /**
     */
    public java.util.Iterator<grpc.examples.roombooking.RoomResponse> getAvailableRooms(
        grpc.examples.roombooking.RoomRequest request) {
      return blockingServerStreamingCall(
          getChannel(), getGetAvailableRoomsMethod(), getCallOptions(), request);
    }

    /**
     */
    public grpc.examples.roombooking.BookMessage bookRoom(grpc.examples.roombooking.BookRequest request) {
      return blockingUnaryCall(
          getChannel(), getBookRoomMethod(), getCallOptions(), request);
    }

    /**
     */
    public grpc.examples.roombooking.ReturnMessage deleteBooking(grpc.examples.roombooking.DeleteRequest request) {
      return blockingUnaryCall(
          getChannel(), getDeleteBookingMethod(), getCallOptions(), request);
    }
  }

  /**
   */
  public static final class RoombookingServiceFutureStub extends io.grpc.stub.AbstractStub<RoombookingServiceFutureStub> {
    private RoombookingServiceFutureStub(io.grpc.Channel channel) {
      super(channel);
    }

    private RoombookingServiceFutureStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected RoombookingServiceFutureStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new RoombookingServiceFutureStub(channel, callOptions);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<grpc.examples.roombooking.BookMessage> bookRoom(
        grpc.examples.roombooking.BookRequest request) {
      return futureUnaryCall(
          getChannel().newCall(getBookRoomMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<grpc.examples.roombooking.ReturnMessage> deleteBooking(
        grpc.examples.roombooking.DeleteRequest request) {
      return futureUnaryCall(
          getChannel().newCall(getDeleteBookingMethod(), getCallOptions()), request);
    }
  }

  private static final int METHODID_GET_AVAILABLE_ROOMS = 0;
  private static final int METHODID_BOOK_ROOM = 1;
  private static final int METHODID_DELETE_BOOKING = 2;

  private static final class MethodHandlers<Req, Resp> implements
      io.grpc.stub.ServerCalls.UnaryMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ServerStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ClientStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.BidiStreamingMethod<Req, Resp> {
    private final RoombookingServiceImplBase serviceImpl;
    private final int methodId;

    MethodHandlers(RoombookingServiceImplBase serviceImpl, int methodId) {
      this.serviceImpl = serviceImpl;
      this.methodId = methodId;
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public void invoke(Req request, io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        case METHODID_GET_AVAILABLE_ROOMS:
          serviceImpl.getAvailableRooms((grpc.examples.roombooking.RoomRequest) request,
              (io.grpc.stub.StreamObserver<grpc.examples.roombooking.RoomResponse>) responseObserver);
          break;
        case METHODID_BOOK_ROOM:
          serviceImpl.bookRoom((grpc.examples.roombooking.BookRequest) request,
              (io.grpc.stub.StreamObserver<grpc.examples.roombooking.BookMessage>) responseObserver);
          break;
        case METHODID_DELETE_BOOKING:
          serviceImpl.deleteBooking((grpc.examples.roombooking.DeleteRequest) request,
              (io.grpc.stub.StreamObserver<grpc.examples.roombooking.ReturnMessage>) responseObserver);
          break;
        default:
          throw new AssertionError();
      }
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public io.grpc.stub.StreamObserver<Req> invoke(
        io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        default:
          throw new AssertionError();
      }
    }
  }

  private static abstract class RoombookingServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier, io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    RoombookingServiceBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return grpc.examples.roombooking.RoombookingServiceImpl.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("RoombookingService");
    }
  }

  private static final class RoombookingServiceFileDescriptorSupplier
      extends RoombookingServiceBaseDescriptorSupplier {
    RoombookingServiceFileDescriptorSupplier() {}
  }

  private static final class RoombookingServiceMethodDescriptorSupplier
      extends RoombookingServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final String methodName;

    RoombookingServiceMethodDescriptorSupplier(String methodName) {
      this.methodName = methodName;
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.MethodDescriptor getMethodDescriptor() {
      return getServiceDescriptor().findMethodByName(methodName);
    }
  }

  private static volatile io.grpc.ServiceDescriptor serviceDescriptor;

  public static io.grpc.ServiceDescriptor getServiceDescriptor() {
    io.grpc.ServiceDescriptor result = serviceDescriptor;
    if (result == null) {
      synchronized (RoombookingServiceGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor = result = io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
              .setSchemaDescriptor(new RoombookingServiceFileDescriptorSupplier())
              .addMethod(getGetAvailableRoomsMethod())
              .addMethod(getBookRoomMethod())
              .addMethod(getDeleteBookingMethod())
              .build();
        }
      }
    }
    return result;
  }
}

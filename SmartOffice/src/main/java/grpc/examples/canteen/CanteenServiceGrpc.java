package grpc.examples.canteen;

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
    comments = "Source: canteen.proto")
public final class CanteenServiceGrpc {

  private CanteenServiceGrpc() {}

  public static final String SERVICE_NAME = "CanteenService";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<grpc.examples.canteen.MenuRequest,
      grpc.examples.canteen.MenuResponse> getGetMenuMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "getMenu",
      requestType = grpc.examples.canteen.MenuRequest.class,
      responseType = grpc.examples.canteen.MenuResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.SERVER_STREAMING)
  public static io.grpc.MethodDescriptor<grpc.examples.canteen.MenuRequest,
      grpc.examples.canteen.MenuResponse> getGetMenuMethod() {
    io.grpc.MethodDescriptor<grpc.examples.canteen.MenuRequest, grpc.examples.canteen.MenuResponse> getGetMenuMethod;
    if ((getGetMenuMethod = CanteenServiceGrpc.getGetMenuMethod) == null) {
      synchronized (CanteenServiceGrpc.class) {
        if ((getGetMenuMethod = CanteenServiceGrpc.getGetMenuMethod) == null) {
          CanteenServiceGrpc.getGetMenuMethod = getGetMenuMethod = 
              io.grpc.MethodDescriptor.<grpc.examples.canteen.MenuRequest, grpc.examples.canteen.MenuResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.SERVER_STREAMING)
              .setFullMethodName(generateFullMethodName(
                  "CanteenService", "getMenu"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  grpc.examples.canteen.MenuRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  grpc.examples.canteen.MenuResponse.getDefaultInstance()))
                  .setSchemaDescriptor(new CanteenServiceMethodDescriptorSupplier("getMenu"))
                  .build();
          }
        }
     }
     return getGetMenuMethod;
  }

  private static volatile io.grpc.MethodDescriptor<grpc.examples.canteen.OrderRequest,
      grpc.examples.canteen.ReturnMessage> getOrderItemsMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "orderItems",
      requestType = grpc.examples.canteen.OrderRequest.class,
      responseType = grpc.examples.canteen.ReturnMessage.class,
      methodType = io.grpc.MethodDescriptor.MethodType.CLIENT_STREAMING)
  public static io.grpc.MethodDescriptor<grpc.examples.canteen.OrderRequest,
      grpc.examples.canteen.ReturnMessage> getOrderItemsMethod() {
    io.grpc.MethodDescriptor<grpc.examples.canteen.OrderRequest, grpc.examples.canteen.ReturnMessage> getOrderItemsMethod;
    if ((getOrderItemsMethod = CanteenServiceGrpc.getOrderItemsMethod) == null) {
      synchronized (CanteenServiceGrpc.class) {
        if ((getOrderItemsMethod = CanteenServiceGrpc.getOrderItemsMethod) == null) {
          CanteenServiceGrpc.getOrderItemsMethod = getOrderItemsMethod = 
              io.grpc.MethodDescriptor.<grpc.examples.canteen.OrderRequest, grpc.examples.canteen.ReturnMessage>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.CLIENT_STREAMING)
              .setFullMethodName(generateFullMethodName(
                  "CanteenService", "orderItems"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  grpc.examples.canteen.OrderRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  grpc.examples.canteen.ReturnMessage.getDefaultInstance()))
                  .setSchemaDescriptor(new CanteenServiceMethodDescriptorSupplier("orderItems"))
                  .build();
          }
        }
     }
     return getOrderItemsMethod;
  }

  private static volatile io.grpc.MethodDescriptor<grpc.examples.canteen.OrderMessage,
      grpc.examples.canteen.OrderResponse> getViewOrdersMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "viewOrders",
      requestType = grpc.examples.canteen.OrderMessage.class,
      responseType = grpc.examples.canteen.OrderResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.BIDI_STREAMING)
  public static io.grpc.MethodDescriptor<grpc.examples.canteen.OrderMessage,
      grpc.examples.canteen.OrderResponse> getViewOrdersMethod() {
    io.grpc.MethodDescriptor<grpc.examples.canteen.OrderMessage, grpc.examples.canteen.OrderResponse> getViewOrdersMethod;
    if ((getViewOrdersMethod = CanteenServiceGrpc.getViewOrdersMethod) == null) {
      synchronized (CanteenServiceGrpc.class) {
        if ((getViewOrdersMethod = CanteenServiceGrpc.getViewOrdersMethod) == null) {
          CanteenServiceGrpc.getViewOrdersMethod = getViewOrdersMethod = 
              io.grpc.MethodDescriptor.<grpc.examples.canteen.OrderMessage, grpc.examples.canteen.OrderResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.BIDI_STREAMING)
              .setFullMethodName(generateFullMethodName(
                  "CanteenService", "viewOrders"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  grpc.examples.canteen.OrderMessage.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  grpc.examples.canteen.OrderResponse.getDefaultInstance()))
                  .setSchemaDescriptor(new CanteenServiceMethodDescriptorSupplier("viewOrders"))
                  .build();
          }
        }
     }
     return getViewOrdersMethod;
  }

  /**
   * Creates a new async stub that supports all call types for the service
   */
  public static CanteenServiceStub newStub(io.grpc.Channel channel) {
    return new CanteenServiceStub(channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static CanteenServiceBlockingStub newBlockingStub(
      io.grpc.Channel channel) {
    return new CanteenServiceBlockingStub(channel);
  }

  /**
   * Creates a new ListenableFuture-style stub that supports unary calls on the service
   */
  public static CanteenServiceFutureStub newFutureStub(
      io.grpc.Channel channel) {
    return new CanteenServiceFutureStub(channel);
  }

  /**
   */
  public static abstract class CanteenServiceImplBase implements io.grpc.BindableService {

    /**
     */
    public void getMenu(grpc.examples.canteen.MenuRequest request,
        io.grpc.stub.StreamObserver<grpc.examples.canteen.MenuResponse> responseObserver) {
      asyncUnimplementedUnaryCall(getGetMenuMethod(), responseObserver);
    }

    /**
     */
    public io.grpc.stub.StreamObserver<grpc.examples.canteen.OrderRequest> orderItems(
        io.grpc.stub.StreamObserver<grpc.examples.canteen.ReturnMessage> responseObserver) {
      return asyncUnimplementedStreamingCall(getOrderItemsMethod(), responseObserver);
    }

    /**
     */
    public io.grpc.stub.StreamObserver<grpc.examples.canteen.OrderMessage> viewOrders(
        io.grpc.stub.StreamObserver<grpc.examples.canteen.OrderResponse> responseObserver) {
      return asyncUnimplementedStreamingCall(getViewOrdersMethod(), responseObserver);
    }

    @java.lang.Override public final io.grpc.ServerServiceDefinition bindService() {
      return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
          .addMethod(
            getGetMenuMethod(),
            asyncServerStreamingCall(
              new MethodHandlers<
                grpc.examples.canteen.MenuRequest,
                grpc.examples.canteen.MenuResponse>(
                  this, METHODID_GET_MENU)))
          .addMethod(
            getOrderItemsMethod(),
            asyncClientStreamingCall(
              new MethodHandlers<
                grpc.examples.canteen.OrderRequest,
                grpc.examples.canteen.ReturnMessage>(
                  this, METHODID_ORDER_ITEMS)))
          .addMethod(
            getViewOrdersMethod(),
            asyncBidiStreamingCall(
              new MethodHandlers<
                grpc.examples.canteen.OrderMessage,
                grpc.examples.canteen.OrderResponse>(
                  this, METHODID_VIEW_ORDERS)))
          .build();
    }
  }

  /**
   */
  public static final class CanteenServiceStub extends io.grpc.stub.AbstractStub<CanteenServiceStub> {
    private CanteenServiceStub(io.grpc.Channel channel) {
      super(channel);
    }

    private CanteenServiceStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected CanteenServiceStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new CanteenServiceStub(channel, callOptions);
    }

    /**
     */
    public void getMenu(grpc.examples.canteen.MenuRequest request,
        io.grpc.stub.StreamObserver<grpc.examples.canteen.MenuResponse> responseObserver) {
      asyncServerStreamingCall(
          getChannel().newCall(getGetMenuMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public io.grpc.stub.StreamObserver<grpc.examples.canteen.OrderRequest> orderItems(
        io.grpc.stub.StreamObserver<grpc.examples.canteen.ReturnMessage> responseObserver) {
      return asyncClientStreamingCall(
          getChannel().newCall(getOrderItemsMethod(), getCallOptions()), responseObserver);
    }

    /**
     */
    public io.grpc.stub.StreamObserver<grpc.examples.canteen.OrderMessage> viewOrders(
        io.grpc.stub.StreamObserver<grpc.examples.canteen.OrderResponse> responseObserver) {
      return asyncBidiStreamingCall(
          getChannel().newCall(getViewOrdersMethod(), getCallOptions()), responseObserver);
    }
  }

  /**
   */
  public static final class CanteenServiceBlockingStub extends io.grpc.stub.AbstractStub<CanteenServiceBlockingStub> {
    private CanteenServiceBlockingStub(io.grpc.Channel channel) {
      super(channel);
    }

    private CanteenServiceBlockingStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected CanteenServiceBlockingStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new CanteenServiceBlockingStub(channel, callOptions);
    }

    /**
     */
    public java.util.Iterator<grpc.examples.canteen.MenuResponse> getMenu(
        grpc.examples.canteen.MenuRequest request) {
      return blockingServerStreamingCall(
          getChannel(), getGetMenuMethod(), getCallOptions(), request);
    }
  }

  /**
   */
  public static final class CanteenServiceFutureStub extends io.grpc.stub.AbstractStub<CanteenServiceFutureStub> {
    private CanteenServiceFutureStub(io.grpc.Channel channel) {
      super(channel);
    }

    private CanteenServiceFutureStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected CanteenServiceFutureStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new CanteenServiceFutureStub(channel, callOptions);
    }
  }

  private static final int METHODID_GET_MENU = 0;
  private static final int METHODID_ORDER_ITEMS = 1;
  private static final int METHODID_VIEW_ORDERS = 2;

  private static final class MethodHandlers<Req, Resp> implements
      io.grpc.stub.ServerCalls.UnaryMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ServerStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ClientStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.BidiStreamingMethod<Req, Resp> {
    private final CanteenServiceImplBase serviceImpl;
    private final int methodId;

    MethodHandlers(CanteenServiceImplBase serviceImpl, int methodId) {
      this.serviceImpl = serviceImpl;
      this.methodId = methodId;
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public void invoke(Req request, io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        case METHODID_GET_MENU:
          serviceImpl.getMenu((grpc.examples.canteen.MenuRequest) request,
              (io.grpc.stub.StreamObserver<grpc.examples.canteen.MenuResponse>) responseObserver);
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
        case METHODID_ORDER_ITEMS:
          return (io.grpc.stub.StreamObserver<Req>) serviceImpl.orderItems(
              (io.grpc.stub.StreamObserver<grpc.examples.canteen.ReturnMessage>) responseObserver);
        case METHODID_VIEW_ORDERS:
          return (io.grpc.stub.StreamObserver<Req>) serviceImpl.viewOrders(
              (io.grpc.stub.StreamObserver<grpc.examples.canteen.OrderResponse>) responseObserver);
        default:
          throw new AssertionError();
      }
    }
  }

  private static abstract class CanteenServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier, io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    CanteenServiceBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return grpc.examples.canteen.CanteenServiceImpl.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("CanteenService");
    }
  }

  private static final class CanteenServiceFileDescriptorSupplier
      extends CanteenServiceBaseDescriptorSupplier {
    CanteenServiceFileDescriptorSupplier() {}
  }

  private static final class CanteenServiceMethodDescriptorSupplier
      extends CanteenServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final String methodName;

    CanteenServiceMethodDescriptorSupplier(String methodName) {
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
      synchronized (CanteenServiceGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor = result = io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
              .setSchemaDescriptor(new CanteenServiceFileDescriptorSupplier())
              .addMethod(getGetMenuMethod())
              .addMethod(getOrderItemsMethod())
              .addMethod(getViewOrdersMethod())
              .build();
        }
      }
    }
    return result;
  }
}

package grpc.examples.printer;

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
    comments = "Source: printer.proto")
public final class PrinterServiceGrpc {

  private PrinterServiceGrpc() {}

  public static final String SERVICE_NAME = "PrinterService";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<grpc.examples.printer.AvailabilityRequest,
      grpc.examples.printer.AvailabilityResponse> getListPrintersMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "listPrinters",
      requestType = grpc.examples.printer.AvailabilityRequest.class,
      responseType = grpc.examples.printer.AvailabilityResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.SERVER_STREAMING)
  public static io.grpc.MethodDescriptor<grpc.examples.printer.AvailabilityRequest,
      grpc.examples.printer.AvailabilityResponse> getListPrintersMethod() {
    io.grpc.MethodDescriptor<grpc.examples.printer.AvailabilityRequest, grpc.examples.printer.AvailabilityResponse> getListPrintersMethod;
    if ((getListPrintersMethod = PrinterServiceGrpc.getListPrintersMethod) == null) {
      synchronized (PrinterServiceGrpc.class) {
        if ((getListPrintersMethod = PrinterServiceGrpc.getListPrintersMethod) == null) {
          PrinterServiceGrpc.getListPrintersMethod = getListPrintersMethod = 
              io.grpc.MethodDescriptor.<grpc.examples.printer.AvailabilityRequest, grpc.examples.printer.AvailabilityResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.SERVER_STREAMING)
              .setFullMethodName(generateFullMethodName(
                  "PrinterService", "listPrinters"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  grpc.examples.printer.AvailabilityRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  grpc.examples.printer.AvailabilityResponse.getDefaultInstance()))
                  .setSchemaDescriptor(new PrinterServiceMethodDescriptorSupplier("listPrinters"))
                  .build();
          }
        }
     }
     return getListPrintersMethod;
  }

  private static volatile io.grpc.MethodDescriptor<grpc.examples.printer.PrintRequest,
      grpc.examples.printer.PrintResponse> getPrintDocumentMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "printDocument",
      requestType = grpc.examples.printer.PrintRequest.class,
      responseType = grpc.examples.printer.PrintResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<grpc.examples.printer.PrintRequest,
      grpc.examples.printer.PrintResponse> getPrintDocumentMethod() {
    io.grpc.MethodDescriptor<grpc.examples.printer.PrintRequest, grpc.examples.printer.PrintResponse> getPrintDocumentMethod;
    if ((getPrintDocumentMethod = PrinterServiceGrpc.getPrintDocumentMethod) == null) {
      synchronized (PrinterServiceGrpc.class) {
        if ((getPrintDocumentMethod = PrinterServiceGrpc.getPrintDocumentMethod) == null) {
          PrinterServiceGrpc.getPrintDocumentMethod = getPrintDocumentMethod = 
              io.grpc.MethodDescriptor.<grpc.examples.printer.PrintRequest, grpc.examples.printer.PrintResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(
                  "PrinterService", "printDocument"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  grpc.examples.printer.PrintRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  grpc.examples.printer.PrintResponse.getDefaultInstance()))
                  .setSchemaDescriptor(new PrinterServiceMethodDescriptorSupplier("printDocument"))
                  .build();
          }
        }
     }
     return getPrintDocumentMethod;
  }

  private static volatile io.grpc.MethodDescriptor<grpc.examples.printer.StatusRequest,
      grpc.examples.printer.ReturnMessage> getPrinterStatusMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "printerStatus",
      requestType = grpc.examples.printer.StatusRequest.class,
      responseType = grpc.examples.printer.ReturnMessage.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<grpc.examples.printer.StatusRequest,
      grpc.examples.printer.ReturnMessage> getPrinterStatusMethod() {
    io.grpc.MethodDescriptor<grpc.examples.printer.StatusRequest, grpc.examples.printer.ReturnMessage> getPrinterStatusMethod;
    if ((getPrinterStatusMethod = PrinterServiceGrpc.getPrinterStatusMethod) == null) {
      synchronized (PrinterServiceGrpc.class) {
        if ((getPrinterStatusMethod = PrinterServiceGrpc.getPrinterStatusMethod) == null) {
          PrinterServiceGrpc.getPrinterStatusMethod = getPrinterStatusMethod = 
              io.grpc.MethodDescriptor.<grpc.examples.printer.StatusRequest, grpc.examples.printer.ReturnMessage>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(
                  "PrinterService", "printerStatus"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  grpc.examples.printer.StatusRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  grpc.examples.printer.ReturnMessage.getDefaultInstance()))
                  .setSchemaDescriptor(new PrinterServiceMethodDescriptorSupplier("printerStatus"))
                  .build();
          }
        }
     }
     return getPrinterStatusMethod;
  }

  /**
   * Creates a new async stub that supports all call types for the service
   */
  public static PrinterServiceStub newStub(io.grpc.Channel channel) {
    return new PrinterServiceStub(channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static PrinterServiceBlockingStub newBlockingStub(
      io.grpc.Channel channel) {
    return new PrinterServiceBlockingStub(channel);
  }

  /**
   * Creates a new ListenableFuture-style stub that supports unary calls on the service
   */
  public static PrinterServiceFutureStub newFutureStub(
      io.grpc.Channel channel) {
    return new PrinterServiceFutureStub(channel);
  }

  /**
   */
  public static abstract class PrinterServiceImplBase implements io.grpc.BindableService {

    /**
     */
    public void listPrinters(grpc.examples.printer.AvailabilityRequest request,
        io.grpc.stub.StreamObserver<grpc.examples.printer.AvailabilityResponse> responseObserver) {
      asyncUnimplementedUnaryCall(getListPrintersMethod(), responseObserver);
    }

    /**
     */
    public void printDocument(grpc.examples.printer.PrintRequest request,
        io.grpc.stub.StreamObserver<grpc.examples.printer.PrintResponse> responseObserver) {
      asyncUnimplementedUnaryCall(getPrintDocumentMethod(), responseObserver);
    }

    /**
     */
    public void printerStatus(grpc.examples.printer.StatusRequest request,
        io.grpc.stub.StreamObserver<grpc.examples.printer.ReturnMessage> responseObserver) {
      asyncUnimplementedUnaryCall(getPrinterStatusMethod(), responseObserver);
    }

    @java.lang.Override public final io.grpc.ServerServiceDefinition bindService() {
      return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
          .addMethod(
            getListPrintersMethod(),
            asyncServerStreamingCall(
              new MethodHandlers<
                grpc.examples.printer.AvailabilityRequest,
                grpc.examples.printer.AvailabilityResponse>(
                  this, METHODID_LIST_PRINTERS)))
          .addMethod(
            getPrintDocumentMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                grpc.examples.printer.PrintRequest,
                grpc.examples.printer.PrintResponse>(
                  this, METHODID_PRINT_DOCUMENT)))
          .addMethod(
            getPrinterStatusMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                grpc.examples.printer.StatusRequest,
                grpc.examples.printer.ReturnMessage>(
                  this, METHODID_PRINTER_STATUS)))
          .build();
    }
  }

  /**
   */
  public static final class PrinterServiceStub extends io.grpc.stub.AbstractStub<PrinterServiceStub> {
    private PrinterServiceStub(io.grpc.Channel channel) {
      super(channel);
    }

    private PrinterServiceStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected PrinterServiceStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new PrinterServiceStub(channel, callOptions);
    }

    /**
     */
    public void listPrinters(grpc.examples.printer.AvailabilityRequest request,
        io.grpc.stub.StreamObserver<grpc.examples.printer.AvailabilityResponse> responseObserver) {
      asyncServerStreamingCall(
          getChannel().newCall(getListPrintersMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void printDocument(grpc.examples.printer.PrintRequest request,
        io.grpc.stub.StreamObserver<grpc.examples.printer.PrintResponse> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getPrintDocumentMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void printerStatus(grpc.examples.printer.StatusRequest request,
        io.grpc.stub.StreamObserver<grpc.examples.printer.ReturnMessage> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getPrinterStatusMethod(), getCallOptions()), request, responseObserver);
    }
  }

  /**
   */
  public static final class PrinterServiceBlockingStub extends io.grpc.stub.AbstractStub<PrinterServiceBlockingStub> {
    private PrinterServiceBlockingStub(io.grpc.Channel channel) {
      super(channel);
    }

    private PrinterServiceBlockingStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected PrinterServiceBlockingStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new PrinterServiceBlockingStub(channel, callOptions);
    }

    /**
     */
    public java.util.Iterator<grpc.examples.printer.AvailabilityResponse> listPrinters(
        grpc.examples.printer.AvailabilityRequest request) {
      return blockingServerStreamingCall(
          getChannel(), getListPrintersMethod(), getCallOptions(), request);
    }

    /**
     */
    public grpc.examples.printer.PrintResponse printDocument(grpc.examples.printer.PrintRequest request) {
      return blockingUnaryCall(
          getChannel(), getPrintDocumentMethod(), getCallOptions(), request);
    }

    /**
     */
    public grpc.examples.printer.ReturnMessage printerStatus(grpc.examples.printer.StatusRequest request) {
      return blockingUnaryCall(
          getChannel(), getPrinterStatusMethod(), getCallOptions(), request);
    }
  }

  /**
   */
  public static final class PrinterServiceFutureStub extends io.grpc.stub.AbstractStub<PrinterServiceFutureStub> {
    private PrinterServiceFutureStub(io.grpc.Channel channel) {
      super(channel);
    }

    private PrinterServiceFutureStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected PrinterServiceFutureStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new PrinterServiceFutureStub(channel, callOptions);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<grpc.examples.printer.PrintResponse> printDocument(
        grpc.examples.printer.PrintRequest request) {
      return futureUnaryCall(
          getChannel().newCall(getPrintDocumentMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<grpc.examples.printer.ReturnMessage> printerStatus(
        grpc.examples.printer.StatusRequest request) {
      return futureUnaryCall(
          getChannel().newCall(getPrinterStatusMethod(), getCallOptions()), request);
    }
  }

  private static final int METHODID_LIST_PRINTERS = 0;
  private static final int METHODID_PRINT_DOCUMENT = 1;
  private static final int METHODID_PRINTER_STATUS = 2;

  private static final class MethodHandlers<Req, Resp> implements
      io.grpc.stub.ServerCalls.UnaryMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ServerStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ClientStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.BidiStreamingMethod<Req, Resp> {
    private final PrinterServiceImplBase serviceImpl;
    private final int methodId;

    MethodHandlers(PrinterServiceImplBase serviceImpl, int methodId) {
      this.serviceImpl = serviceImpl;
      this.methodId = methodId;
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public void invoke(Req request, io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        case METHODID_LIST_PRINTERS:
          serviceImpl.listPrinters((grpc.examples.printer.AvailabilityRequest) request,
              (io.grpc.stub.StreamObserver<grpc.examples.printer.AvailabilityResponse>) responseObserver);
          break;
        case METHODID_PRINT_DOCUMENT:
          serviceImpl.printDocument((grpc.examples.printer.PrintRequest) request,
              (io.grpc.stub.StreamObserver<grpc.examples.printer.PrintResponse>) responseObserver);
          break;
        case METHODID_PRINTER_STATUS:
          serviceImpl.printerStatus((grpc.examples.printer.StatusRequest) request,
              (io.grpc.stub.StreamObserver<grpc.examples.printer.ReturnMessage>) responseObserver);
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

  private static abstract class PrinterServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier, io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    PrinterServiceBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return grpc.examples.printer.PrinterServiceImpl.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("PrinterService");
    }
  }

  private static final class PrinterServiceFileDescriptorSupplier
      extends PrinterServiceBaseDescriptorSupplier {
    PrinterServiceFileDescriptorSupplier() {}
  }

  private static final class PrinterServiceMethodDescriptorSupplier
      extends PrinterServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final String methodName;

    PrinterServiceMethodDescriptorSupplier(String methodName) {
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
      synchronized (PrinterServiceGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor = result = io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
              .setSchemaDescriptor(new PrinterServiceFileDescriptorSupplier())
              .addMethod(getListPrintersMethod())
              .addMethod(getPrintDocumentMethod())
              .addMethod(getPrinterStatusMethod())
              .build();
        }
      }
    }
    return result;
  }
}

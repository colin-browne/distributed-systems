// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: roombooking.proto

package grpc.examples.roombooking;

/**
 * Protobuf type {@code BookRequest}
 */
public  final class BookRequest extends
    com.google.protobuf.GeneratedMessageV3 implements
    // @@protoc_insertion_point(message_implements:BookRequest)
    BookRequestOrBuilder {
private static final long serialVersionUID = 0L;
  // Use BookRequest.newBuilder() to construct.
  private BookRequest(com.google.protobuf.GeneratedMessageV3.Builder<?> builder) {
    super(builder);
  }
  private BookRequest() {
    username_ = "";
    date_ = 0L;
    number_ = 0;
    time_ = 0;
  }

  @java.lang.Override
  public final com.google.protobuf.UnknownFieldSet
  getUnknownFields() {
    return this.unknownFields;
  }
  private BookRequest(
      com.google.protobuf.CodedInputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    this();
    if (extensionRegistry == null) {
      throw new java.lang.NullPointerException();
    }
    int mutable_bitField0_ = 0;
    com.google.protobuf.UnknownFieldSet.Builder unknownFields =
        com.google.protobuf.UnknownFieldSet.newBuilder();
    try {
      boolean done = false;
      while (!done) {
        int tag = input.readTag();
        switch (tag) {
          case 0:
            done = true;
            break;
          case 10: {
            java.lang.String s = input.readStringRequireUtf8();

            username_ = s;
            break;
          }
          case 16: {

            date_ = input.readInt64();
            break;
          }
          case 24: {

            number_ = input.readInt32();
            break;
          }
          case 32: {

            time_ = input.readInt32();
            break;
          }
          default: {
            if (!parseUnknownFieldProto3(
                input, unknownFields, extensionRegistry, tag)) {
              done = true;
            }
            break;
          }
        }
      }
    } catch (com.google.protobuf.InvalidProtocolBufferException e) {
      throw e.setUnfinishedMessage(this);
    } catch (java.io.IOException e) {
      throw new com.google.protobuf.InvalidProtocolBufferException(
          e).setUnfinishedMessage(this);
    } finally {
      this.unknownFields = unknownFields.build();
      makeExtensionsImmutable();
    }
  }
  public static final com.google.protobuf.Descriptors.Descriptor
      getDescriptor() {
    return grpc.examples.roombooking.RoombookingServiceImpl.internal_static_BookRequest_descriptor;
  }

  @java.lang.Override
  protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internalGetFieldAccessorTable() {
    return grpc.examples.roombooking.RoombookingServiceImpl.internal_static_BookRequest_fieldAccessorTable
        .ensureFieldAccessorsInitialized(
            grpc.examples.roombooking.BookRequest.class, grpc.examples.roombooking.BookRequest.Builder.class);
  }

  public static final int USERNAME_FIELD_NUMBER = 1;
  private volatile java.lang.Object username_;
  /**
   * <code>string username = 1;</code>
   */
  public java.lang.String getUsername() {
    java.lang.Object ref = username_;
    if (ref instanceof java.lang.String) {
      return (java.lang.String) ref;
    } else {
      com.google.protobuf.ByteString bs = 
          (com.google.protobuf.ByteString) ref;
      java.lang.String s = bs.toStringUtf8();
      username_ = s;
      return s;
    }
  }
  /**
   * <code>string username = 1;</code>
   */
  public com.google.protobuf.ByteString
      getUsernameBytes() {
    java.lang.Object ref = username_;
    if (ref instanceof java.lang.String) {
      com.google.protobuf.ByteString b = 
          com.google.protobuf.ByteString.copyFromUtf8(
              (java.lang.String) ref);
      username_ = b;
      return b;
    } else {
      return (com.google.protobuf.ByteString) ref;
    }
  }

  public static final int DATE_FIELD_NUMBER = 2;
  private long date_;
  /**
   * <code>int64 date = 2;</code>
   */
  public long getDate() {
    return date_;
  }

  public static final int NUMBER_FIELD_NUMBER = 3;
  private int number_;
  /**
   * <code>int32 number = 3;</code>
   */
  public int getNumber() {
    return number_;
  }

  public static final int TIME_FIELD_NUMBER = 4;
  private int time_;
  /**
   * <code>int32 time = 4;</code>
   */
  public int getTime() {
    return time_;
  }

  private byte memoizedIsInitialized = -1;
  @java.lang.Override
  public final boolean isInitialized() {
    byte isInitialized = memoizedIsInitialized;
    if (isInitialized == 1) return true;
    if (isInitialized == 0) return false;

    memoizedIsInitialized = 1;
    return true;
  }

  @java.lang.Override
  public void writeTo(com.google.protobuf.CodedOutputStream output)
                      throws java.io.IOException {
    if (!getUsernameBytes().isEmpty()) {
      com.google.protobuf.GeneratedMessageV3.writeString(output, 1, username_);
    }
    if (date_ != 0L) {
      output.writeInt64(2, date_);
    }
    if (number_ != 0) {
      output.writeInt32(3, number_);
    }
    if (time_ != 0) {
      output.writeInt32(4, time_);
    }
    unknownFields.writeTo(output);
  }

  @java.lang.Override
  public int getSerializedSize() {
    int size = memoizedSize;
    if (size != -1) return size;

    size = 0;
    if (!getUsernameBytes().isEmpty()) {
      size += com.google.protobuf.GeneratedMessageV3.computeStringSize(1, username_);
    }
    if (date_ != 0L) {
      size += com.google.protobuf.CodedOutputStream
        .computeInt64Size(2, date_);
    }
    if (number_ != 0) {
      size += com.google.protobuf.CodedOutputStream
        .computeInt32Size(3, number_);
    }
    if (time_ != 0) {
      size += com.google.protobuf.CodedOutputStream
        .computeInt32Size(4, time_);
    }
    size += unknownFields.getSerializedSize();
    memoizedSize = size;
    return size;
  }

  @java.lang.Override
  public boolean equals(final java.lang.Object obj) {
    if (obj == this) {
     return true;
    }
    if (!(obj instanceof grpc.examples.roombooking.BookRequest)) {
      return super.equals(obj);
    }
    grpc.examples.roombooking.BookRequest other = (grpc.examples.roombooking.BookRequest) obj;

    boolean result = true;
    result = result && getUsername()
        .equals(other.getUsername());
    result = result && (getDate()
        == other.getDate());
    result = result && (getNumber()
        == other.getNumber());
    result = result && (getTime()
        == other.getTime());
    result = result && unknownFields.equals(other.unknownFields);
    return result;
  }

  @java.lang.Override
  public int hashCode() {
    if (memoizedHashCode != 0) {
      return memoizedHashCode;
    }
    int hash = 41;
    hash = (19 * hash) + getDescriptor().hashCode();
    hash = (37 * hash) + USERNAME_FIELD_NUMBER;
    hash = (53 * hash) + getUsername().hashCode();
    hash = (37 * hash) + DATE_FIELD_NUMBER;
    hash = (53 * hash) + com.google.protobuf.Internal.hashLong(
        getDate());
    hash = (37 * hash) + NUMBER_FIELD_NUMBER;
    hash = (53 * hash) + getNumber();
    hash = (37 * hash) + TIME_FIELD_NUMBER;
    hash = (53 * hash) + getTime();
    hash = (29 * hash) + unknownFields.hashCode();
    memoizedHashCode = hash;
    return hash;
  }

  public static grpc.examples.roombooking.BookRequest parseFrom(
      java.nio.ByteBuffer data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static grpc.examples.roombooking.BookRequest parseFrom(
      java.nio.ByteBuffer data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static grpc.examples.roombooking.BookRequest parseFrom(
      com.google.protobuf.ByteString data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static grpc.examples.roombooking.BookRequest parseFrom(
      com.google.protobuf.ByteString data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static grpc.examples.roombooking.BookRequest parseFrom(byte[] data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static grpc.examples.roombooking.BookRequest parseFrom(
      byte[] data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static grpc.examples.roombooking.BookRequest parseFrom(java.io.InputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input);
  }
  public static grpc.examples.roombooking.BookRequest parseFrom(
      java.io.InputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input, extensionRegistry);
  }
  public static grpc.examples.roombooking.BookRequest parseDelimitedFrom(java.io.InputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseDelimitedWithIOException(PARSER, input);
  }
  public static grpc.examples.roombooking.BookRequest parseDelimitedFrom(
      java.io.InputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseDelimitedWithIOException(PARSER, input, extensionRegistry);
  }
  public static grpc.examples.roombooking.BookRequest parseFrom(
      com.google.protobuf.CodedInputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input);
  }
  public static grpc.examples.roombooking.BookRequest parseFrom(
      com.google.protobuf.CodedInputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input, extensionRegistry);
  }

  @java.lang.Override
  public Builder newBuilderForType() { return newBuilder(); }
  public static Builder newBuilder() {
    return DEFAULT_INSTANCE.toBuilder();
  }
  public static Builder newBuilder(grpc.examples.roombooking.BookRequest prototype) {
    return DEFAULT_INSTANCE.toBuilder().mergeFrom(prototype);
  }
  @java.lang.Override
  public Builder toBuilder() {
    return this == DEFAULT_INSTANCE
        ? new Builder() : new Builder().mergeFrom(this);
  }

  @java.lang.Override
  protected Builder newBuilderForType(
      com.google.protobuf.GeneratedMessageV3.BuilderParent parent) {
    Builder builder = new Builder(parent);
    return builder;
  }
  /**
   * Protobuf type {@code BookRequest}
   */
  public static final class Builder extends
      com.google.protobuf.GeneratedMessageV3.Builder<Builder> implements
      // @@protoc_insertion_point(builder_implements:BookRequest)
      grpc.examples.roombooking.BookRequestOrBuilder {
    public static final com.google.protobuf.Descriptors.Descriptor
        getDescriptor() {
      return grpc.examples.roombooking.RoombookingServiceImpl.internal_static_BookRequest_descriptor;
    }

    @java.lang.Override
    protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
        internalGetFieldAccessorTable() {
      return grpc.examples.roombooking.RoombookingServiceImpl.internal_static_BookRequest_fieldAccessorTable
          .ensureFieldAccessorsInitialized(
              grpc.examples.roombooking.BookRequest.class, grpc.examples.roombooking.BookRequest.Builder.class);
    }

    // Construct using grpc.examples.roombooking.BookRequest.newBuilder()
    private Builder() {
      maybeForceBuilderInitialization();
    }

    private Builder(
        com.google.protobuf.GeneratedMessageV3.BuilderParent parent) {
      super(parent);
      maybeForceBuilderInitialization();
    }
    private void maybeForceBuilderInitialization() {
      if (com.google.protobuf.GeneratedMessageV3
              .alwaysUseFieldBuilders) {
      }
    }
    @java.lang.Override
    public Builder clear() {
      super.clear();
      username_ = "";

      date_ = 0L;

      number_ = 0;

      time_ = 0;

      return this;
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.Descriptor
        getDescriptorForType() {
      return grpc.examples.roombooking.RoombookingServiceImpl.internal_static_BookRequest_descriptor;
    }

    @java.lang.Override
    public grpc.examples.roombooking.BookRequest getDefaultInstanceForType() {
      return grpc.examples.roombooking.BookRequest.getDefaultInstance();
    }

    @java.lang.Override
    public grpc.examples.roombooking.BookRequest build() {
      grpc.examples.roombooking.BookRequest result = buildPartial();
      if (!result.isInitialized()) {
        throw newUninitializedMessageException(result);
      }
      return result;
    }

    @java.lang.Override
    public grpc.examples.roombooking.BookRequest buildPartial() {
      grpc.examples.roombooking.BookRequest result = new grpc.examples.roombooking.BookRequest(this);
      result.username_ = username_;
      result.date_ = date_;
      result.number_ = number_;
      result.time_ = time_;
      onBuilt();
      return result;
    }

    @java.lang.Override
    public Builder clone() {
      return (Builder) super.clone();
    }
    @java.lang.Override
    public Builder setField(
        com.google.protobuf.Descriptors.FieldDescriptor field,
        java.lang.Object value) {
      return (Builder) super.setField(field, value);
    }
    @java.lang.Override
    public Builder clearField(
        com.google.protobuf.Descriptors.FieldDescriptor field) {
      return (Builder) super.clearField(field);
    }
    @java.lang.Override
    public Builder clearOneof(
        com.google.protobuf.Descriptors.OneofDescriptor oneof) {
      return (Builder) super.clearOneof(oneof);
    }
    @java.lang.Override
    public Builder setRepeatedField(
        com.google.protobuf.Descriptors.FieldDescriptor field,
        int index, java.lang.Object value) {
      return (Builder) super.setRepeatedField(field, index, value);
    }
    @java.lang.Override
    public Builder addRepeatedField(
        com.google.protobuf.Descriptors.FieldDescriptor field,
        java.lang.Object value) {
      return (Builder) super.addRepeatedField(field, value);
    }
    @java.lang.Override
    public Builder mergeFrom(com.google.protobuf.Message other) {
      if (other instanceof grpc.examples.roombooking.BookRequest) {
        return mergeFrom((grpc.examples.roombooking.BookRequest)other);
      } else {
        super.mergeFrom(other);
        return this;
      }
    }

    public Builder mergeFrom(grpc.examples.roombooking.BookRequest other) {
      if (other == grpc.examples.roombooking.BookRequest.getDefaultInstance()) return this;
      if (!other.getUsername().isEmpty()) {
        username_ = other.username_;
        onChanged();
      }
      if (other.getDate() != 0L) {
        setDate(other.getDate());
      }
      if (other.getNumber() != 0) {
        setNumber(other.getNumber());
      }
      if (other.getTime() != 0) {
        setTime(other.getTime());
      }
      this.mergeUnknownFields(other.unknownFields);
      onChanged();
      return this;
    }

    @java.lang.Override
    public final boolean isInitialized() {
      return true;
    }

    @java.lang.Override
    public Builder mergeFrom(
        com.google.protobuf.CodedInputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws java.io.IOException {
      grpc.examples.roombooking.BookRequest parsedMessage = null;
      try {
        parsedMessage = PARSER.parsePartialFrom(input, extensionRegistry);
      } catch (com.google.protobuf.InvalidProtocolBufferException e) {
        parsedMessage = (grpc.examples.roombooking.BookRequest) e.getUnfinishedMessage();
        throw e.unwrapIOException();
      } finally {
        if (parsedMessage != null) {
          mergeFrom(parsedMessage);
        }
      }
      return this;
    }

    private java.lang.Object username_ = "";
    /**
     * <code>string username = 1;</code>
     */
    public java.lang.String getUsername() {
      java.lang.Object ref = username_;
      if (!(ref instanceof java.lang.String)) {
        com.google.protobuf.ByteString bs =
            (com.google.protobuf.ByteString) ref;
        java.lang.String s = bs.toStringUtf8();
        username_ = s;
        return s;
      } else {
        return (java.lang.String) ref;
      }
    }
    /**
     * <code>string username = 1;</code>
     */
    public com.google.protobuf.ByteString
        getUsernameBytes() {
      java.lang.Object ref = username_;
      if (ref instanceof String) {
        com.google.protobuf.ByteString b = 
            com.google.protobuf.ByteString.copyFromUtf8(
                (java.lang.String) ref);
        username_ = b;
        return b;
      } else {
        return (com.google.protobuf.ByteString) ref;
      }
    }
    /**
     * <code>string username = 1;</code>
     */
    public Builder setUsername(
        java.lang.String value) {
      if (value == null) {
    throw new NullPointerException();
  }
  
      username_ = value;
      onChanged();
      return this;
    }
    /**
     * <code>string username = 1;</code>
     */
    public Builder clearUsername() {
      
      username_ = getDefaultInstance().getUsername();
      onChanged();
      return this;
    }
    /**
     * <code>string username = 1;</code>
     */
    public Builder setUsernameBytes(
        com.google.protobuf.ByteString value) {
      if (value == null) {
    throw new NullPointerException();
  }
  checkByteStringIsUtf8(value);
      
      username_ = value;
      onChanged();
      return this;
    }

    private long date_ ;
    /**
     * <code>int64 date = 2;</code>
     */
    public long getDate() {
      return date_;
    }
    /**
     * <code>int64 date = 2;</code>
     */
    public Builder setDate(long value) {
      
      date_ = value;
      onChanged();
      return this;
    }
    /**
     * <code>int64 date = 2;</code>
     */
    public Builder clearDate() {
      
      date_ = 0L;
      onChanged();
      return this;
    }

    private int number_ ;
    /**
     * <code>int32 number = 3;</code>
     */
    public int getNumber() {
      return number_;
    }
    /**
     * <code>int32 number = 3;</code>
     */
    public Builder setNumber(int value) {
      
      number_ = value;
      onChanged();
      return this;
    }
    /**
     * <code>int32 number = 3;</code>
     */
    public Builder clearNumber() {
      
      number_ = 0;
      onChanged();
      return this;
    }

    private int time_ ;
    /**
     * <code>int32 time = 4;</code>
     */
    public int getTime() {
      return time_;
    }
    /**
     * <code>int32 time = 4;</code>
     */
    public Builder setTime(int value) {
      
      time_ = value;
      onChanged();
      return this;
    }
    /**
     * <code>int32 time = 4;</code>
     */
    public Builder clearTime() {
      
      time_ = 0;
      onChanged();
      return this;
    }
    @java.lang.Override
    public final Builder setUnknownFields(
        final com.google.protobuf.UnknownFieldSet unknownFields) {
      return super.setUnknownFieldsProto3(unknownFields);
    }

    @java.lang.Override
    public final Builder mergeUnknownFields(
        final com.google.protobuf.UnknownFieldSet unknownFields) {
      return super.mergeUnknownFields(unknownFields);
    }


    // @@protoc_insertion_point(builder_scope:BookRequest)
  }

  // @@protoc_insertion_point(class_scope:BookRequest)
  private static final grpc.examples.roombooking.BookRequest DEFAULT_INSTANCE;
  static {
    DEFAULT_INSTANCE = new grpc.examples.roombooking.BookRequest();
  }

  public static grpc.examples.roombooking.BookRequest getDefaultInstance() {
    return DEFAULT_INSTANCE;
  }

  private static final com.google.protobuf.Parser<BookRequest>
      PARSER = new com.google.protobuf.AbstractParser<BookRequest>() {
    @java.lang.Override
    public BookRequest parsePartialFrom(
        com.google.protobuf.CodedInputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return new BookRequest(input, extensionRegistry);
    }
  };

  public static com.google.protobuf.Parser<BookRequest> parser() {
    return PARSER;
  }

  @java.lang.Override
  public com.google.protobuf.Parser<BookRequest> getParserForType() {
    return PARSER;
  }

  @java.lang.Override
  public grpc.examples.roombooking.BookRequest getDefaultInstanceForType() {
    return DEFAULT_INSTANCE;
  }

}

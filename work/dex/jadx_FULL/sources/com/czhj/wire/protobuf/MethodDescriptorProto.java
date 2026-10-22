package com.czhj.wire.protobuf;

import com.czhj.wire.FieldEncoding;
import com.czhj.wire.Message;
import com.czhj.wire.ProtoAdapter;
import com.czhj.wire.ProtoReader;
import com.czhj.wire.ProtoWriter;
import com.czhj.wire.WireField;
import com.czhj.wire.internal.Internal;
import com.czhj.wire.okio.ByteString;
import java.io.IOException;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_08_10593cls.dex */
public final class MethodDescriptorProto extends Message<MethodDescriptorProto, Builder> {
    public static final ProtoAdapter<MethodDescriptorProto> ADAPTER = new ProtoAdapter_MethodDescriptorProto();
    public static final Boolean DEFAULT_CLIENT_STREAMING;
    public static final String DEFAULT_INPUT_TYPE = "";
    public static final String DEFAULT_NAME = "";
    public static final String DEFAULT_OUTPUT_TYPE = "";
    public static final Boolean DEFAULT_SERVER_STREAMING;
    private static final long serialVersionUID = 0;

    @WireField(adapter = "com.squareup.wire.ProtoAdapter#BOOL", tag = 5)
    public final Boolean client_streaming;

    @WireField(adapter = "com.squareup.wire.ProtoAdapter#STRING", tag = 2)
    public final String input_type;

    @WireField(adapter = "com.squareup.wire.ProtoAdapter#STRING", tag = 1)
    public final String name;

    @WireField(adapter = "com.google.protobuf.MethodOptions#ADAPTER", tag = 4)
    public final MethodOptions options;

    @WireField(adapter = "com.squareup.wire.ProtoAdapter#STRING", tag = 3)
    public final String output_type;

    @WireField(adapter = "com.squareup.wire.ProtoAdapter#BOOL", tag = 6)
    public final Boolean server_streaming;

    public static final class Builder extends Message.Builder<MethodDescriptorProto, Builder> {
        public Boolean client_streaming;
        public String input_type;
        public String name;
        public MethodOptions options;
        public String output_type;
        public Boolean server_streaming;

        @Override // com.czhj.wire.Message.Builder
        public MethodDescriptorProto build() {
            return new MethodDescriptorProto(this.name, this.input_type, this.output_type, this.options, this.client_streaming, this.server_streaming, super.buildUnknownFields());
        }

        public Builder client_streaming(Boolean bool) {
            this.client_streaming = bool;
            return this;
        }

        public Builder input_type(String str) {
            this.input_type = str;
            return this;
        }

        public Builder name(String str) {
            this.name = str;
            return this;
        }

        public Builder options(MethodOptions methodOptions) {
            this.options = methodOptions;
            return this;
        }

        public Builder output_type(String str) {
            this.output_type = str;
            return this;
        }

        public Builder server_streaming(Boolean bool) {
            this.server_streaming = bool;
            return this;
        }
    }

    public static final class ProtoAdapter_MethodDescriptorProto extends ProtoAdapter<MethodDescriptorProto> {
        public ProtoAdapter_MethodDescriptorProto() {
            super(FieldEncoding.LENGTH_DELIMITED, MethodDescriptorProto.class);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.czhj.wire.ProtoAdapter
        public MethodDescriptorProto decode(ProtoReader protoReader) throws IOException {
            Builder builder = new Builder();
            long jBeginMessage = protoReader.beginMessage();
            while (true) {
                int iNextTag = protoReader.nextTag();
                if (iNextTag == -1) {
                    protoReader.endMessage(jBeginMessage);
                    return builder.build();
                }
                switch (iNextTag) {
                    case 1:
                        builder.name(ProtoAdapter.STRING.decode(protoReader));
                        break;
                    case 2:
                        builder.input_type(ProtoAdapter.STRING.decode(protoReader));
                        break;
                    case 3:
                        builder.output_type(ProtoAdapter.STRING.decode(protoReader));
                        break;
                    case 4:
                        builder.options(MethodOptions.ADAPTER.decode(protoReader));
                        break;
                    case 5:
                        builder.client_streaming(ProtoAdapter.BOOL.decode(protoReader));
                        break;
                    case 6:
                        builder.server_streaming(ProtoAdapter.BOOL.decode(protoReader));
                        break;
                    default:
                        FieldEncoding fieldEncodingPeekFieldEncoding = protoReader.peekFieldEncoding();
                        builder.addUnknownField(iNextTag, fieldEncodingPeekFieldEncoding, fieldEncodingPeekFieldEncoding.rawProtoAdapter().decode(protoReader));
                        break;
                }
            }
        }

        @Override // com.czhj.wire.ProtoAdapter
        public void encode(ProtoWriter protoWriter, MethodDescriptorProto methodDescriptorProto) throws IOException {
            ProtoAdapter<String> protoAdapter = ProtoAdapter.STRING;
            protoAdapter.encodeWithTag(protoWriter, 1, methodDescriptorProto.name);
            protoAdapter.encodeWithTag(protoWriter, 2, methodDescriptorProto.input_type);
            protoAdapter.encodeWithTag(protoWriter, 3, methodDescriptorProto.output_type);
            MethodOptions.ADAPTER.encodeWithTag(protoWriter, 4, methodDescriptorProto.options);
            ProtoAdapter<Boolean> protoAdapter2 = ProtoAdapter.BOOL;
            protoAdapter2.encodeWithTag(protoWriter, 5, methodDescriptorProto.client_streaming);
            protoAdapter2.encodeWithTag(protoWriter, 6, methodDescriptorProto.server_streaming);
            protoWriter.writeBytes(methodDescriptorProto.unknownFields());
        }

        @Override // com.czhj.wire.ProtoAdapter
        public int encodedSize(MethodDescriptorProto methodDescriptorProto) {
            ProtoAdapter<String> protoAdapter = ProtoAdapter.STRING;
            int iEncodedSizeWithTag = protoAdapter.encodedSizeWithTag(1, methodDescriptorProto.name) + protoAdapter.encodedSizeWithTag(2, methodDescriptorProto.input_type) + protoAdapter.encodedSizeWithTag(3, methodDescriptorProto.output_type) + MethodOptions.ADAPTER.encodedSizeWithTag(4, methodDescriptorProto.options);
            ProtoAdapter<Boolean> protoAdapter2 = ProtoAdapter.BOOL;
            return iEncodedSizeWithTag + protoAdapter2.encodedSizeWithTag(5, methodDescriptorProto.client_streaming) + protoAdapter2.encodedSizeWithTag(6, methodDescriptorProto.server_streaming) + methodDescriptorProto.unknownFields().size();
        }

        @Override // com.czhj.wire.ProtoAdapter
        public MethodDescriptorProto redact(MethodDescriptorProto methodDescriptorProto) {
            Builder builderNewBuilder = methodDescriptorProto.newBuilder();
            MethodOptions methodOptions = builderNewBuilder.options;
            if (methodOptions != null) {
                builderNewBuilder.options = MethodOptions.ADAPTER.redact(methodOptions);
            }
            builderNewBuilder.clearUnknownFields();
            return builderNewBuilder.build();
        }
    }

    static {
        Boolean bool = Boolean.FALSE;
        DEFAULT_CLIENT_STREAMING = bool;
        DEFAULT_SERVER_STREAMING = bool;
    }

    public MethodDescriptorProto(String str, String str2, String str3, MethodOptions methodOptions, Boolean bool, Boolean bool2) {
        this(str, str2, str3, methodOptions, bool, bool2, ByteString.EMPTY);
    }

    public MethodDescriptorProto(String str, String str2, String str3, MethodOptions methodOptions, Boolean bool, Boolean bool2, ByteString byteString) {
        super(ADAPTER, byteString);
        this.name = str;
        this.input_type = str2;
        this.output_type = str3;
        this.options = methodOptions;
        this.client_streaming = bool;
        this.server_streaming = bool2;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof MethodDescriptorProto)) {
            return false;
        }
        MethodDescriptorProto methodDescriptorProto = (MethodDescriptorProto) obj;
        return unknownFields().equals(methodDescriptorProto.unknownFields()) && Internal.equals(this.name, methodDescriptorProto.name) && Internal.equals(this.input_type, methodDescriptorProto.input_type) && Internal.equals(this.output_type, methodDescriptorProto.output_type) && Internal.equals(this.options, methodDescriptorProto.options) && Internal.equals(this.client_streaming, methodDescriptorProto.client_streaming) && Internal.equals(this.server_streaming, methodDescriptorProto.server_streaming);
    }

    public int hashCode() {
        int i = this.hashCode;
        if (i != 0) {
            return i;
        }
        int iHashCode = unknownFields().hashCode() * 37;
        String str = this.name;
        int iHashCode2 = (iHashCode + (str != null ? str.hashCode() : 0)) * 37;
        String str2 = this.input_type;
        int iHashCode3 = (iHashCode2 + (str2 != null ? str2.hashCode() : 0)) * 37;
        String str3 = this.output_type;
        int iHashCode4 = (iHashCode3 + (str3 != null ? str3.hashCode() : 0)) * 37;
        MethodOptions methodOptions = this.options;
        int iHashCode5 = (iHashCode4 + (methodOptions != null ? methodOptions.hashCode() : 0)) * 37;
        Boolean bool = this.client_streaming;
        int iHashCode6 = (iHashCode5 + (bool != null ? bool.hashCode() : 0)) * 37;
        Boolean bool2 = this.server_streaming;
        int iHashCode7 = iHashCode6 + (bool2 != null ? bool2.hashCode() : 0);
        this.hashCode = iHashCode7;
        return iHashCode7;
    }

    @Override // com.czhj.wire.Message
    public Builder newBuilder() {
        Builder builder = new Builder();
        builder.name = this.name;
        builder.input_type = this.input_type;
        builder.output_type = this.output_type;
        builder.options = this.options;
        builder.client_streaming = this.client_streaming;
        builder.server_streaming = this.server_streaming;
        builder.addUnknownFields(unknownFields());
        return builder;
    }

    @Override // com.czhj.wire.Message
    public String toString() {
        StringBuilder sb = new StringBuilder();
        if (this.name != null) {
            sb.append(", name=");
            sb.append(this.name);
        }
        if (this.input_type != null) {
            sb.append(", input_type=");
            sb.append(this.input_type);
        }
        if (this.output_type != null) {
            sb.append(", output_type=");
            sb.append(this.output_type);
        }
        if (this.options != null) {
            sb.append(", options=");
            sb.append(this.options);
        }
        if (this.client_streaming != null) {
            sb.append(", client_streaming=");
            sb.append(this.client_streaming);
        }
        if (this.server_streaming != null) {
            sb.append(", server_streaming=");
            sb.append(this.server_streaming);
        }
        StringBuilder sbReplace = sb.replace(0, 2, "MethodDescriptorProto{");
        sbReplace.append('}');
        return sbReplace.toString();
    }
}

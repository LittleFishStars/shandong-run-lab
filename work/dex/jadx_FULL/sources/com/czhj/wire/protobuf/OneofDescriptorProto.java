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
public final class OneofDescriptorProto extends Message<OneofDescriptorProto, Builder> {
    public static final ProtoAdapter<OneofDescriptorProto> ADAPTER = new ProtoAdapter_OneofDescriptorProto();
    public static final String DEFAULT_NAME = "";
    private static final long serialVersionUID = 0;

    @WireField(adapter = "com.squareup.wire.ProtoAdapter#STRING", tag = 1)
    public final String name;

    public static final class Builder extends Message.Builder<OneofDescriptorProto, Builder> {
        public String name;

        @Override // com.czhj.wire.Message.Builder
        public OneofDescriptorProto build() {
            return new OneofDescriptorProto(this.name, super.buildUnknownFields());
        }

        public Builder name(String str) {
            this.name = str;
            return this;
        }
    }

    public static final class ProtoAdapter_OneofDescriptorProto extends ProtoAdapter<OneofDescriptorProto> {
        public ProtoAdapter_OneofDescriptorProto() {
            super(FieldEncoding.LENGTH_DELIMITED, OneofDescriptorProto.class);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.czhj.wire.ProtoAdapter
        public OneofDescriptorProto decode(ProtoReader protoReader) throws IOException {
            Builder builder = new Builder();
            long jBeginMessage = protoReader.beginMessage();
            while (true) {
                int iNextTag = protoReader.nextTag();
                if (iNextTag == -1) {
                    protoReader.endMessage(jBeginMessage);
                    return builder.build();
                }
                if (iNextTag != 1) {
                    FieldEncoding fieldEncodingPeekFieldEncoding = protoReader.peekFieldEncoding();
                    builder.addUnknownField(iNextTag, fieldEncodingPeekFieldEncoding, fieldEncodingPeekFieldEncoding.rawProtoAdapter().decode(protoReader));
                } else {
                    builder.name(ProtoAdapter.STRING.decode(protoReader));
                }
            }
        }

        @Override // com.czhj.wire.ProtoAdapter
        public void encode(ProtoWriter protoWriter, OneofDescriptorProto oneofDescriptorProto) throws IOException {
            ProtoAdapter.STRING.encodeWithTag(protoWriter, 1, oneofDescriptorProto.name);
            protoWriter.writeBytes(oneofDescriptorProto.unknownFields());
        }

        @Override // com.czhj.wire.ProtoAdapter
        public int encodedSize(OneofDescriptorProto oneofDescriptorProto) {
            return ProtoAdapter.STRING.encodedSizeWithTag(1, oneofDescriptorProto.name) + oneofDescriptorProto.unknownFields().size();
        }

        @Override // com.czhj.wire.ProtoAdapter
        public OneofDescriptorProto redact(OneofDescriptorProto oneofDescriptorProto) {
            Builder builderNewBuilder = oneofDescriptorProto.newBuilder();
            builderNewBuilder.clearUnknownFields();
            return builderNewBuilder.build();
        }
    }

    public OneofDescriptorProto(String str) {
        this(str, ByteString.EMPTY);
    }

    public OneofDescriptorProto(String str, ByteString byteString) {
        super(ADAPTER, byteString);
        this.name = str;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof OneofDescriptorProto)) {
            return false;
        }
        OneofDescriptorProto oneofDescriptorProto = (OneofDescriptorProto) obj;
        return unknownFields().equals(oneofDescriptorProto.unknownFields()) && Internal.equals(this.name, oneofDescriptorProto.name);
    }

    public int hashCode() {
        int i = this.hashCode;
        if (i != 0) {
            return i;
        }
        int iHashCode = unknownFields().hashCode() * 37;
        String str = this.name;
        int iHashCode2 = iHashCode + (str != null ? str.hashCode() : 0);
        this.hashCode = iHashCode2;
        return iHashCode2;
    }

    @Override // com.czhj.wire.Message
    public Builder newBuilder() {
        Builder builder = new Builder();
        builder.name = this.name;
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
        StringBuilder sbReplace = sb.replace(0, 2, "OneofDescriptorProto{");
        sbReplace.append('}');
        return sbReplace.toString();
    }
}

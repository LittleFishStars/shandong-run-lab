package com.czhj.sdk.common.models;

import android.os.Parcelable;
import com.czhj.wire.AndroidMessage;
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
public final class NovaReq extends AndroidMessage<NovaReq, Builder> {
    public static final ProtoAdapter<NovaReq> ADAPTER;
    public static final Parcelable.Creator<NovaReq> CREATOR;
    public static final Integer DEFAULT_BLACK_PACKAGE_STATUS;
    public static final String DEFAULT_QUICKAPP_LAUNCHER_PACKAGE = "";
    public static final String DEFAULT_QUICKAPP_LAUNCHER_VERSION = "";
    private static final long serialVersionUID = 0;

    @WireField(adapter = "com.squareup.wire.ProtoAdapter#UINT32", tag = 3)
    public final Integer black_package_status;

    @WireField(adapter = "com.squareup.wire.ProtoAdapter#STRING", tag = 2)
    public final String quickapp_launcher_package;

    @WireField(adapter = "com.squareup.wire.ProtoAdapter#STRING", tag = 1)
    public final String quickapp_launcher_version;

    public static final class Builder extends Message.Builder<NovaReq, Builder> {
        public Integer black_package_status;
        public String quickapp_launcher_package;
        public String quickapp_launcher_version;

        public Builder black_package_status(Integer num) {
            this.black_package_status = num;
            return this;
        }

        @Override // com.czhj.wire.Message.Builder
        public NovaReq build() {
            return new NovaReq(this.quickapp_launcher_version, this.quickapp_launcher_package, this.black_package_status, super.buildUnknownFields());
        }

        public Builder quickapp_launcher_package(String str) {
            this.quickapp_launcher_package = str;
            return this;
        }

        public Builder quickapp_launcher_version(String str) {
            this.quickapp_launcher_version = str;
            return this;
        }
    }

    public static final class ProtoAdapter_NovaReq extends ProtoAdapter<NovaReq> {
        public ProtoAdapter_NovaReq() {
            super(FieldEncoding.LENGTH_DELIMITED, NovaReq.class);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.czhj.wire.ProtoAdapter
        public NovaReq decode(ProtoReader protoReader) throws IOException {
            Builder builder = new Builder();
            long jBeginMessage = protoReader.beginMessage();
            while (true) {
                int iNextTag = protoReader.nextTag();
                if (iNextTag == -1) {
                    protoReader.endMessage(jBeginMessage);
                    return builder.build();
                }
                if (iNextTag == 1) {
                    builder.quickapp_launcher_version(ProtoAdapter.STRING.decode(protoReader));
                } else if (iNextTag == 2) {
                    builder.quickapp_launcher_package(ProtoAdapter.STRING.decode(protoReader));
                } else if (iNextTag != 3) {
                    FieldEncoding fieldEncodingPeekFieldEncoding = protoReader.peekFieldEncoding();
                    builder.addUnknownField(iNextTag, fieldEncodingPeekFieldEncoding, fieldEncodingPeekFieldEncoding.rawProtoAdapter().decode(protoReader));
                } else {
                    builder.black_package_status(ProtoAdapter.UINT32.decode(protoReader));
                }
            }
        }

        @Override // com.czhj.wire.ProtoAdapter
        public void encode(ProtoWriter protoWriter, NovaReq novaReq) throws IOException {
            ProtoAdapter<String> protoAdapter = ProtoAdapter.STRING;
            protoAdapter.encodeWithTag(protoWriter, 1, novaReq.quickapp_launcher_version);
            protoAdapter.encodeWithTag(protoWriter, 2, novaReq.quickapp_launcher_package);
            ProtoAdapter.UINT32.encodeWithTag(protoWriter, 3, novaReq.black_package_status);
            protoWriter.writeBytes(novaReq.unknownFields());
        }

        @Override // com.czhj.wire.ProtoAdapter
        public int encodedSize(NovaReq novaReq) {
            ProtoAdapter<String> protoAdapter = ProtoAdapter.STRING;
            return protoAdapter.encodedSizeWithTag(1, novaReq.quickapp_launcher_version) + protoAdapter.encodedSizeWithTag(2, novaReq.quickapp_launcher_package) + ProtoAdapter.UINT32.encodedSizeWithTag(3, novaReq.black_package_status) + novaReq.unknownFields().size();
        }

        @Override // com.czhj.wire.ProtoAdapter
        public NovaReq redact(NovaReq novaReq) {
            Builder builderNewBuilder = novaReq.newBuilder();
            builderNewBuilder.clearUnknownFields();
            return builderNewBuilder.build();
        }
    }

    static {
        ProtoAdapter_NovaReq protoAdapter_NovaReq = new ProtoAdapter_NovaReq();
        ADAPTER = protoAdapter_NovaReq;
        CREATOR = AndroidMessage.newCreator(protoAdapter_NovaReq);
        DEFAULT_BLACK_PACKAGE_STATUS = 0;
    }

    public NovaReq(String str, String str2, Integer num) {
        this(str, str2, num, ByteString.EMPTY);
    }

    public NovaReq(String str, String str2, Integer num, ByteString byteString) {
        super(ADAPTER, byteString);
        this.quickapp_launcher_version = str;
        this.quickapp_launcher_package = str2;
        this.black_package_status = num;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof NovaReq)) {
            return false;
        }
        NovaReq novaReq = (NovaReq) obj;
        return unknownFields().equals(novaReq.unknownFields()) && Internal.equals(this.quickapp_launcher_version, novaReq.quickapp_launcher_version) && Internal.equals(this.quickapp_launcher_package, novaReq.quickapp_launcher_package) && Internal.equals(this.black_package_status, novaReq.black_package_status);
    }

    public int hashCode() {
        int i = this.hashCode;
        if (i != 0) {
            return i;
        }
        int iHashCode = unknownFields().hashCode() * 37;
        String str = this.quickapp_launcher_version;
        int iHashCode2 = (iHashCode + (str != null ? str.hashCode() : 0)) * 37;
        String str2 = this.quickapp_launcher_package;
        int iHashCode3 = (iHashCode2 + (str2 != null ? str2.hashCode() : 0)) * 37;
        Integer num = this.black_package_status;
        int iHashCode4 = iHashCode3 + (num != null ? num.hashCode() : 0);
        this.hashCode = iHashCode4;
        return iHashCode4;
    }

    @Override // com.czhj.wire.Message
    public Builder newBuilder() {
        Builder builder = new Builder();
        builder.quickapp_launcher_version = this.quickapp_launcher_version;
        builder.quickapp_launcher_package = this.quickapp_launcher_package;
        builder.black_package_status = this.black_package_status;
        builder.addUnknownFields(unknownFields());
        return builder;
    }

    @Override // com.czhj.wire.Message
    public String toString() {
        StringBuilder sb = new StringBuilder();
        if (this.quickapp_launcher_version != null) {
            sb.append(", quickapp_launcher_version=");
            sb.append(this.quickapp_launcher_version);
        }
        if (this.quickapp_launcher_package != null) {
            sb.append(", quickapp_launcher_package=");
            sb.append(this.quickapp_launcher_package);
        }
        if (this.black_package_status != null) {
            sb.append(", black_package_status=");
            sb.append(this.black_package_status);
        }
        StringBuilder sbReplace = sb.replace(0, 2, "NovaReq{");
        sbReplace.append('}');
        return sbReplace.toString();
    }
}

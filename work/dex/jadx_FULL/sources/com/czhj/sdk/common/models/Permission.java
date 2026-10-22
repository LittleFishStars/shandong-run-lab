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
public final class Permission extends AndroidMessage<Permission, Builder> {
    public static final ProtoAdapter<Permission> ADAPTER;
    public static final Parcelable.Creator<Permission> CREATOR;
    public static final Boolean DEFAULT_ACCELEROMETER;
    private static final long serialVersionUID = 0;

    @WireField(adapter = "com.squareup.wire.ProtoAdapter#BOOL", tag = 1)
    public final Boolean accelerometer;

    public static final class Builder extends Message.Builder<Permission, Builder> {
        public Boolean accelerometer;

        public Builder accelerometer(Boolean bool) {
            this.accelerometer = bool;
            return this;
        }

        @Override // com.czhj.wire.Message.Builder
        public Permission build() {
            return new Permission(this.accelerometer, super.buildUnknownFields());
        }
    }

    public static final class ProtoAdapter_Permission extends ProtoAdapter<Permission> {
        public ProtoAdapter_Permission() {
            super(FieldEncoding.LENGTH_DELIMITED, Permission.class);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.czhj.wire.ProtoAdapter
        public Permission decode(ProtoReader protoReader) throws IOException {
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
                    builder.accelerometer(ProtoAdapter.BOOL.decode(protoReader));
                }
            }
        }

        @Override // com.czhj.wire.ProtoAdapter
        public void encode(ProtoWriter protoWriter, Permission permission) throws IOException {
            ProtoAdapter.BOOL.encodeWithTag(protoWriter, 1, permission.accelerometer);
            protoWriter.writeBytes(permission.unknownFields());
        }

        @Override // com.czhj.wire.ProtoAdapter
        public int encodedSize(Permission permission) {
            return ProtoAdapter.BOOL.encodedSizeWithTag(1, permission.accelerometer) + permission.unknownFields().size();
        }

        @Override // com.czhj.wire.ProtoAdapter
        public Permission redact(Permission permission) {
            Builder builderNewBuilder = permission.newBuilder();
            builderNewBuilder.clearUnknownFields();
            return builderNewBuilder.build();
        }
    }

    static {
        ProtoAdapter_Permission protoAdapter_Permission = new ProtoAdapter_Permission();
        ADAPTER = protoAdapter_Permission;
        CREATOR = AndroidMessage.newCreator(protoAdapter_Permission);
        DEFAULT_ACCELEROMETER = Boolean.FALSE;
    }

    public Permission(Boolean bool) {
        this(bool, ByteString.EMPTY);
    }

    public Permission(Boolean bool, ByteString byteString) {
        super(ADAPTER, byteString);
        this.accelerometer = bool;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof Permission)) {
            return false;
        }
        Permission permission = (Permission) obj;
        return unknownFields().equals(permission.unknownFields()) && Internal.equals(this.accelerometer, permission.accelerometer);
    }

    public int hashCode() {
        int i = this.hashCode;
        if (i != 0) {
            return i;
        }
        int iHashCode = unknownFields().hashCode() * 37;
        Boolean bool = this.accelerometer;
        int iHashCode2 = iHashCode + (bool != null ? bool.hashCode() : 0);
        this.hashCode = iHashCode2;
        return iHashCode2;
    }

    @Override // com.czhj.wire.Message
    public Builder newBuilder() {
        Builder builder = new Builder();
        builder.accelerometer = this.accelerometer;
        builder.addUnknownFields(unknownFields());
        return builder;
    }

    @Override // com.czhj.wire.Message
    public String toString() {
        StringBuilder sb = new StringBuilder();
        if (this.accelerometer != null) {
            sb.append(", accelerometer=");
            sb.append(this.accelerometer);
        }
        StringBuilder sbReplace = sb.replace(0, 2, "Permission{");
        sbReplace.append('}');
        return sbReplace.toString();
    }
}

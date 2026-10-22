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
public final class Version extends AndroidMessage<Version, Builder> {
    public static final ProtoAdapter<Version> ADAPTER;
    public static final Parcelable.Creator<Version> CREATOR;
    public static final Integer DEFAULT_BUILD_VERSION;
    public static final Integer DEFAULT_MAJOR;
    public static final Integer DEFAULT_MICRO;
    public static final Integer DEFAULT_MINOR;
    public static final String DEFAULT_RELEASE_TYPE = "";
    public static final String DEFAULT_VERSION_NAME = "";
    public static final String DEFAULT_VERSION_STR = "";
    private static final long serialVersionUID = 0;

    @WireField(adapter = "com.squareup.wire.ProtoAdapter#UINT32", tag = 5)
    public final Integer build_version;

    @WireField(adapter = "com.squareup.wire.ProtoAdapter#UINT32", tag = 1)
    public final Integer major;

    @WireField(adapter = "com.squareup.wire.ProtoAdapter#UINT32", tag = 3)
    public final Integer micro;

    @WireField(adapter = "com.squareup.wire.ProtoAdapter#UINT32", tag = 2)
    public final Integer minor;

    @WireField(adapter = "com.squareup.wire.ProtoAdapter#STRING", tag = 6)
    public final String release_type;

    @WireField(adapter = "com.squareup.wire.ProtoAdapter#STRING", tag = 7)
    public final String version_name;

    @WireField(adapter = "com.squareup.wire.ProtoAdapter#STRING", tag = 4)
    public final String version_str;

    public static final class Builder extends Message.Builder<Version, Builder> {
        public Integer major = Version.DEFAULT_MAJOR;
        public Integer minor = Version.DEFAULT_MINOR;
        public Integer micro = Version.DEFAULT_MICRO;
        public String version_str = "";
        public Integer build_version = Version.DEFAULT_BUILD_VERSION;
        public String release_type = "";
        public String version_name = "";

        @Override // com.czhj.wire.Message.Builder
        public Version build() {
            return new Version(this.major, this.minor, this.micro, this.version_str, this.build_version, this.release_type, this.version_name, super.buildUnknownFields());
        }

        public Builder build_version(Integer num) {
            this.build_version = num;
            return this;
        }

        public Builder major(Integer num) {
            this.major = num;
            return this;
        }

        public Builder micro(Integer num) {
            this.micro = num;
            return this;
        }

        public Builder minor(Integer num) {
            this.minor = num;
            return this;
        }

        public Builder release_type(String str) {
            this.release_type = str;
            return this;
        }

        public Builder version_name(String str) {
            this.version_name = str;
            return this;
        }

        public Builder version_str(String str) {
            this.version_str = str;
            return this;
        }
    }

    public static final class ProtoAdapter_Version extends ProtoAdapter<Version> {
        public ProtoAdapter_Version() {
            super(FieldEncoding.LENGTH_DELIMITED, Version.class);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.czhj.wire.ProtoAdapter
        public Version decode(ProtoReader protoReader) throws IOException {
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
                        builder.major(ProtoAdapter.UINT32.decode(protoReader));
                        break;
                    case 2:
                        builder.minor(ProtoAdapter.UINT32.decode(protoReader));
                        break;
                    case 3:
                        builder.micro(ProtoAdapter.UINT32.decode(protoReader));
                        break;
                    case 4:
                        builder.version_str(ProtoAdapter.STRING.decode(protoReader));
                        break;
                    case 5:
                        builder.build_version(ProtoAdapter.UINT32.decode(protoReader));
                        break;
                    case 6:
                        builder.release_type(ProtoAdapter.STRING.decode(protoReader));
                        break;
                    case 7:
                        builder.version_name(ProtoAdapter.STRING.decode(protoReader));
                        break;
                    default:
                        FieldEncoding fieldEncodingPeekFieldEncoding = protoReader.peekFieldEncoding();
                        builder.addUnknownField(iNextTag, fieldEncodingPeekFieldEncoding, fieldEncodingPeekFieldEncoding.rawProtoAdapter().decode(protoReader));
                        break;
                }
            }
        }

        @Override // com.czhj.wire.ProtoAdapter
        public void encode(ProtoWriter protoWriter, Version version) throws IOException {
            ProtoAdapter<Integer> protoAdapter = ProtoAdapter.UINT32;
            protoAdapter.encodeWithTag(protoWriter, 1, version.major);
            protoAdapter.encodeWithTag(protoWriter, 2, version.minor);
            protoAdapter.encodeWithTag(protoWriter, 3, version.micro);
            ProtoAdapter<String> protoAdapter2 = ProtoAdapter.STRING;
            protoAdapter2.encodeWithTag(protoWriter, 4, version.version_str);
            protoAdapter.encodeWithTag(protoWriter, 5, version.build_version);
            protoAdapter2.encodeWithTag(protoWriter, 6, version.release_type);
            protoAdapter2.encodeWithTag(protoWriter, 7, version.version_name);
            protoWriter.writeBytes(version.unknownFields());
        }

        @Override // com.czhj.wire.ProtoAdapter
        public int encodedSize(Version version) {
            ProtoAdapter<Integer> protoAdapter = ProtoAdapter.UINT32;
            int iEncodedSizeWithTag = protoAdapter.encodedSizeWithTag(1, version.major) + protoAdapter.encodedSizeWithTag(2, version.minor) + protoAdapter.encodedSizeWithTag(3, version.micro);
            ProtoAdapter<String> protoAdapter2 = ProtoAdapter.STRING;
            return iEncodedSizeWithTag + protoAdapter2.encodedSizeWithTag(4, version.version_str) + protoAdapter.encodedSizeWithTag(5, version.build_version) + protoAdapter2.encodedSizeWithTag(6, version.release_type) + protoAdapter2.encodedSizeWithTag(7, version.version_name) + version.unknownFields().size();
        }

        @Override // com.czhj.wire.ProtoAdapter
        public Version redact(Version version) {
            Builder builderNewBuilder = version.newBuilder();
            builderNewBuilder.clearUnknownFields();
            return builderNewBuilder.build();
        }
    }

    static {
        ProtoAdapter_Version protoAdapter_Version = new ProtoAdapter_Version();
        ADAPTER = protoAdapter_Version;
        CREATOR = AndroidMessage.newCreator(protoAdapter_Version);
        DEFAULT_MAJOR = 0;
        DEFAULT_MINOR = 0;
        DEFAULT_MICRO = 0;
        DEFAULT_BUILD_VERSION = 0;
    }

    public Version(Integer num, Integer num2, Integer num3, String str, Integer num4, String str2, String str3) {
        this(num, num2, num3, str, num4, str2, str3, ByteString.EMPTY);
    }

    public Version(Integer num, Integer num2, Integer num3, String str, Integer num4, String str2, String str3, ByteString byteString) {
        super(ADAPTER, byteString);
        this.major = num;
        this.minor = num2;
        this.micro = num3;
        this.version_str = str;
        this.build_version = num4;
        this.release_type = str2;
        this.version_name = str3;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof Version)) {
            return false;
        }
        Version version = (Version) obj;
        return unknownFields().equals(version.unknownFields()) && Internal.equals(this.major, version.major) && Internal.equals(this.minor, version.minor) && Internal.equals(this.micro, version.micro) && Internal.equals(this.version_str, version.version_str) && Internal.equals(this.build_version, version.build_version) && Internal.equals(this.release_type, version.release_type) && Internal.equals(this.version_name, version.version_name);
    }

    public int hashCode() {
        int i = this.hashCode;
        if (i != 0) {
            return i;
        }
        int iHashCode = unknownFields().hashCode() * 37;
        Integer num = this.major;
        int iHashCode2 = (iHashCode + (num != null ? num.hashCode() : 0)) * 37;
        Integer num2 = this.minor;
        int iHashCode3 = (iHashCode2 + (num2 != null ? num2.hashCode() : 0)) * 37;
        Integer num3 = this.micro;
        int iHashCode4 = (iHashCode3 + (num3 != null ? num3.hashCode() : 0)) * 37;
        String str = this.version_str;
        int iHashCode5 = (iHashCode4 + (str != null ? str.hashCode() : 0)) * 37;
        Integer num4 = this.build_version;
        int iHashCode6 = (iHashCode5 + (num4 != null ? num4.hashCode() : 0)) * 37;
        String str2 = this.release_type;
        int iHashCode7 = (iHashCode6 + (str2 != null ? str2.hashCode() : 0)) * 37;
        String str3 = this.version_name;
        int iHashCode8 = iHashCode7 + (str3 != null ? str3.hashCode() : 0);
        this.hashCode = iHashCode8;
        return iHashCode8;
    }

    @Override // com.czhj.wire.Message
    public Builder newBuilder() {
        Builder builder = new Builder();
        builder.major = this.major;
        builder.minor = this.minor;
        builder.micro = this.micro;
        builder.version_str = this.version_str;
        builder.build_version = this.build_version;
        builder.release_type = this.release_type;
        builder.version_name = this.version_name;
        builder.addUnknownFields(unknownFields());
        return builder;
    }

    @Override // com.czhj.wire.Message
    public String toString() {
        StringBuilder sb = new StringBuilder();
        if (this.major != null) {
            sb.append(", major=");
            sb.append(this.major);
        }
        if (this.minor != null) {
            sb.append(", minor=");
            sb.append(this.minor);
        }
        if (this.micro != null) {
            sb.append(", micro=");
            sb.append(this.micro);
        }
        if (this.version_str != null) {
            sb.append(", version_str=");
            sb.append(this.version_str);
        }
        if (this.build_version != null) {
            sb.append(", build_version=");
            sb.append(this.build_version);
        }
        if (this.release_type != null) {
            sb.append(", release_type=");
            sb.append(this.release_type);
        }
        if (this.version_name != null) {
            sb.append(", version_name=");
            sb.append(this.version_name);
        }
        StringBuilder sbReplace = sb.replace(0, 2, "Version{");
        sbReplace.append('}');
        return sbReplace.toString();
    }
}

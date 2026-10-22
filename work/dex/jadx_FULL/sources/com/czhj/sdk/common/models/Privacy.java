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
public final class Privacy extends AndroidMessage<Privacy, Builder> {
    public static final ProtoAdapter<Privacy> ADAPTER;
    public static final Parcelable.Creator<Privacy> CREATOR;
    public static final Integer DEFAULT_AGE;
    public static final Boolean DEFAULT_ALLOW_ANDROID_ID;
    public static final Boolean DEFAULT_ALLOW_CARRIER_CODE;
    public static final Boolean DEFAULT_ALLOW_GEO;
    public static final Boolean DEFAULT_ALLOW_IMEI;
    public static final Boolean DEFAULT_ALLOW_INSTALLED_APPS;
    public static final Boolean DEFAULT_ALLOW_OAID;
    public static final Boolean DEFAULT_ALLOW_SPACE_SIZE;
    public static final Integer DEFAULT_CHILD_PROTECTION;
    public static final Integer DEFAULT_GDPR_CONSENT;
    private static final long serialVersionUID = 0;

    @WireField(adapter = "com.squareup.wire.ProtoAdapter#UINT32", tag = 3)
    public final Integer age;

    @WireField(adapter = "com.squareup.wire.ProtoAdapter#BOOL", tag = 7)
    public final Boolean allow_android_id;

    @WireField(adapter = "com.squareup.wire.ProtoAdapter#BOOL", tag = 9)
    public final Boolean allow_carrier_code;

    @WireField(adapter = "com.squareup.wire.ProtoAdapter#BOOL", tag = 4)
    public final Boolean allow_geo;

    @WireField(adapter = "com.squareup.wire.ProtoAdapter#BOOL", tag = 5)
    public final Boolean allow_imei;

    @WireField(adapter = "com.squareup.wire.ProtoAdapter#BOOL", tag = 8)
    public final Boolean allow_installed_apps;

    @WireField(adapter = "com.squareup.wire.ProtoAdapter#BOOL", tag = 6)
    public final Boolean allow_oaid;

    @WireField(adapter = "com.squareup.wire.ProtoAdapter#BOOL", tag = 10)
    public final Boolean allow_space_size;

    @WireField(adapter = "com.squareup.wire.ProtoAdapter#UINT32", tag = 2)
    public final Integer child_protection;

    @WireField(adapter = "com.squareup.wire.ProtoAdapter#UINT32", tag = 1)
    public final Integer gdpr_consent;

    public static final class Builder extends Message.Builder<Privacy, Builder> {
        public Integer gdpr_consent = Privacy.DEFAULT_GDPR_CONSENT;
        public Integer child_protection = Privacy.DEFAULT_CHILD_PROTECTION;
        public Integer age = Privacy.DEFAULT_AGE;
        public Boolean allow_geo = Privacy.DEFAULT_ALLOW_GEO;
        public Boolean allow_imei = Privacy.DEFAULT_ALLOW_IMEI;
        public Boolean allow_oaid = Privacy.DEFAULT_ALLOW_OAID;
        public Boolean allow_android_id = Privacy.DEFAULT_ALLOW_ANDROID_ID;
        public Boolean allow_installed_apps = Privacy.DEFAULT_ALLOW_INSTALLED_APPS;
        public Boolean allow_carrier_code = Privacy.DEFAULT_ALLOW_CARRIER_CODE;
        public Boolean allow_space_size = Privacy.DEFAULT_ALLOW_SPACE_SIZE;

        public Builder age(Integer num) {
            this.age = num;
            return this;
        }

        public Builder allow_android_id(Boolean bool) {
            this.allow_android_id = bool;
            return this;
        }

        public Builder allow_carrier_code(Boolean bool) {
            this.allow_carrier_code = bool;
            return this;
        }

        public Builder allow_geo(Boolean bool) {
            this.allow_geo = bool;
            return this;
        }

        public Builder allow_imei(Boolean bool) {
            this.allow_imei = bool;
            return this;
        }

        public Builder allow_installed_apps(Boolean bool) {
            this.allow_installed_apps = bool;
            return this;
        }

        public Builder allow_oaid(Boolean bool) {
            this.allow_oaid = bool;
            return this;
        }

        public Builder allow_space_size(Boolean bool) {
            this.allow_space_size = bool;
            return this;
        }

        @Override // com.czhj.wire.Message.Builder
        public Privacy build() {
            return new Privacy(this.gdpr_consent, this.child_protection, this.age, this.allow_geo, this.allow_imei, this.allow_oaid, this.allow_android_id, this.allow_installed_apps, this.allow_carrier_code, this.allow_space_size, super.buildUnknownFields());
        }

        public Builder child_protection(Integer num) {
            this.child_protection = num;
            return this;
        }

        public Builder gdpr_consent(Integer num) {
            this.gdpr_consent = num;
            return this;
        }
    }

    public static final class ProtoAdapter_Privacy extends ProtoAdapter<Privacy> {
        public ProtoAdapter_Privacy() {
            super(FieldEncoding.LENGTH_DELIMITED, Privacy.class);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.czhj.wire.ProtoAdapter
        public Privacy decode(ProtoReader protoReader) throws IOException {
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
                        builder.gdpr_consent(ProtoAdapter.UINT32.decode(protoReader));
                        break;
                    case 2:
                        builder.child_protection(ProtoAdapter.UINT32.decode(protoReader));
                        break;
                    case 3:
                        builder.age(ProtoAdapter.UINT32.decode(protoReader));
                        break;
                    case 4:
                        builder.allow_geo(ProtoAdapter.BOOL.decode(protoReader));
                        break;
                    case 5:
                        builder.allow_imei(ProtoAdapter.BOOL.decode(protoReader));
                        break;
                    case 6:
                        builder.allow_oaid(ProtoAdapter.BOOL.decode(protoReader));
                        break;
                    case 7:
                        builder.allow_android_id(ProtoAdapter.BOOL.decode(protoReader));
                        break;
                    case 8:
                        builder.allow_installed_apps(ProtoAdapter.BOOL.decode(protoReader));
                        break;
                    case 9:
                        builder.allow_carrier_code(ProtoAdapter.BOOL.decode(protoReader));
                        break;
                    case 10:
                        builder.allow_space_size(ProtoAdapter.BOOL.decode(protoReader));
                        break;
                    default:
                        FieldEncoding fieldEncodingPeekFieldEncoding = protoReader.peekFieldEncoding();
                        builder.addUnknownField(iNextTag, fieldEncodingPeekFieldEncoding, fieldEncodingPeekFieldEncoding.rawProtoAdapter().decode(protoReader));
                        break;
                }
            }
        }

        @Override // com.czhj.wire.ProtoAdapter
        public void encode(ProtoWriter protoWriter, Privacy privacy) throws IOException {
            ProtoAdapter<Integer> protoAdapter = ProtoAdapter.UINT32;
            protoAdapter.encodeWithTag(protoWriter, 1, privacy.gdpr_consent);
            protoAdapter.encodeWithTag(protoWriter, 2, privacy.child_protection);
            protoAdapter.encodeWithTag(protoWriter, 3, privacy.age);
            ProtoAdapter<Boolean> protoAdapter2 = ProtoAdapter.BOOL;
            protoAdapter2.encodeWithTag(protoWriter, 4, privacy.allow_geo);
            protoAdapter2.encodeWithTag(protoWriter, 5, privacy.allow_imei);
            protoAdapter2.encodeWithTag(protoWriter, 6, privacy.allow_oaid);
            protoAdapter2.encodeWithTag(protoWriter, 7, privacy.allow_android_id);
            protoAdapter2.encodeWithTag(protoWriter, 8, privacy.allow_installed_apps);
            protoAdapter2.encodeWithTag(protoWriter, 9, privacy.allow_carrier_code);
            protoAdapter2.encodeWithTag(protoWriter, 10, privacy.allow_space_size);
            protoWriter.writeBytes(privacy.unknownFields());
        }

        @Override // com.czhj.wire.ProtoAdapter
        public int encodedSize(Privacy privacy) {
            ProtoAdapter<Integer> protoAdapter = ProtoAdapter.UINT32;
            int iEncodedSizeWithTag = protoAdapter.encodedSizeWithTag(1, privacy.gdpr_consent) + protoAdapter.encodedSizeWithTag(2, privacy.child_protection) + protoAdapter.encodedSizeWithTag(3, privacy.age);
            ProtoAdapter<Boolean> protoAdapter2 = ProtoAdapter.BOOL;
            return iEncodedSizeWithTag + protoAdapter2.encodedSizeWithTag(4, privacy.allow_geo) + protoAdapter2.encodedSizeWithTag(5, privacy.allow_imei) + protoAdapter2.encodedSizeWithTag(6, privacy.allow_oaid) + protoAdapter2.encodedSizeWithTag(7, privacy.allow_android_id) + protoAdapter2.encodedSizeWithTag(8, privacy.allow_installed_apps) + protoAdapter2.encodedSizeWithTag(9, privacy.allow_carrier_code) + protoAdapter2.encodedSizeWithTag(10, privacy.allow_space_size) + privacy.unknownFields().size();
        }

        @Override // com.czhj.wire.ProtoAdapter
        public Privacy redact(Privacy privacy) {
            Builder builderNewBuilder = privacy.newBuilder();
            builderNewBuilder.clearUnknownFields();
            return builderNewBuilder.build();
        }
    }

    static {
        ProtoAdapter_Privacy protoAdapter_Privacy = new ProtoAdapter_Privacy();
        ADAPTER = protoAdapter_Privacy;
        CREATOR = AndroidMessage.newCreator(protoAdapter_Privacy);
        DEFAULT_GDPR_CONSENT = 0;
        DEFAULT_CHILD_PROTECTION = 0;
        DEFAULT_AGE = 0;
        Boolean bool = Boolean.TRUE;
        DEFAULT_ALLOW_GEO = bool;
        DEFAULT_ALLOW_IMEI = bool;
        DEFAULT_ALLOW_OAID = bool;
        DEFAULT_ALLOW_ANDROID_ID = bool;
        DEFAULT_ALLOW_INSTALLED_APPS = bool;
        DEFAULT_ALLOW_CARRIER_CODE = bool;
        DEFAULT_ALLOW_SPACE_SIZE = bool;
    }

    public Privacy(Integer num, Integer num2, Integer num3, Boolean bool, Boolean bool2, Boolean bool3, Boolean bool4, Boolean bool5, Boolean bool6, Boolean bool7) {
        this(num, num2, num3, bool, bool2, bool3, bool4, bool5, bool6, bool7, ByteString.EMPTY);
    }

    public Privacy(Integer num, Integer num2, Integer num3, Boolean bool, Boolean bool2, Boolean bool3, Boolean bool4, Boolean bool5, Boolean bool6, Boolean bool7, ByteString byteString) {
        super(ADAPTER, byteString);
        this.gdpr_consent = num;
        this.child_protection = num2;
        this.age = num3;
        this.allow_geo = bool;
        this.allow_imei = bool2;
        this.allow_oaid = bool3;
        this.allow_android_id = bool4;
        this.allow_installed_apps = bool5;
        this.allow_carrier_code = bool6;
        this.allow_space_size = bool7;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof Privacy)) {
            return false;
        }
        Privacy privacy = (Privacy) obj;
        return unknownFields().equals(privacy.unknownFields()) && Internal.equals(this.gdpr_consent, privacy.gdpr_consent) && Internal.equals(this.child_protection, privacy.child_protection) && Internal.equals(this.age, privacy.age) && Internal.equals(this.allow_geo, privacy.allow_geo) && Internal.equals(this.allow_imei, privacy.allow_imei) && Internal.equals(this.allow_oaid, privacy.allow_oaid) && Internal.equals(this.allow_android_id, privacy.allow_android_id) && Internal.equals(this.allow_installed_apps, privacy.allow_installed_apps) && Internal.equals(this.allow_carrier_code, privacy.allow_carrier_code) && Internal.equals(this.allow_space_size, privacy.allow_space_size);
    }

    public int hashCode() {
        int i = this.hashCode;
        if (i != 0) {
            return i;
        }
        int iHashCode = unknownFields().hashCode() * 37;
        Integer num = this.gdpr_consent;
        int iHashCode2 = (iHashCode + (num != null ? num.hashCode() : 0)) * 37;
        Integer num2 = this.child_protection;
        int iHashCode3 = (iHashCode2 + (num2 != null ? num2.hashCode() : 0)) * 37;
        Integer num3 = this.age;
        int iHashCode4 = (iHashCode3 + (num3 != null ? num3.hashCode() : 0)) * 37;
        Boolean bool = this.allow_geo;
        int iHashCode5 = (iHashCode4 + (bool != null ? bool.hashCode() : 0)) * 37;
        Boolean bool2 = this.allow_imei;
        int iHashCode6 = (iHashCode5 + (bool2 != null ? bool2.hashCode() : 0)) * 37;
        Boolean bool3 = this.allow_oaid;
        int iHashCode7 = (iHashCode6 + (bool3 != null ? bool3.hashCode() : 0)) * 37;
        Boolean bool4 = this.allow_android_id;
        int iHashCode8 = (iHashCode7 + (bool4 != null ? bool4.hashCode() : 0)) * 37;
        Boolean bool5 = this.allow_installed_apps;
        int iHashCode9 = (iHashCode8 + (bool5 != null ? bool5.hashCode() : 0)) * 37;
        Boolean bool6 = this.allow_carrier_code;
        int iHashCode10 = (iHashCode9 + (bool6 != null ? bool6.hashCode() : 0)) * 37;
        Boolean bool7 = this.allow_space_size;
        int iHashCode11 = iHashCode10 + (bool7 != null ? bool7.hashCode() : 0);
        this.hashCode = iHashCode11;
        return iHashCode11;
    }

    @Override // com.czhj.wire.Message
    public Builder newBuilder() {
        Builder builder = new Builder();
        builder.gdpr_consent = this.gdpr_consent;
        builder.child_protection = this.child_protection;
        builder.age = this.age;
        builder.allow_geo = this.allow_geo;
        builder.allow_imei = this.allow_imei;
        builder.allow_oaid = this.allow_oaid;
        builder.allow_android_id = this.allow_android_id;
        builder.allow_installed_apps = this.allow_installed_apps;
        builder.allow_carrier_code = this.allow_carrier_code;
        builder.allow_space_size = this.allow_space_size;
        builder.addUnknownFields(unknownFields());
        return builder;
    }

    @Override // com.czhj.wire.Message
    public String toString() {
        StringBuilder sb = new StringBuilder();
        if (this.gdpr_consent != null) {
            sb.append(", gdpr_consent=");
            sb.append(this.gdpr_consent);
        }
        if (this.child_protection != null) {
            sb.append(", child_protection=");
            sb.append(this.child_protection);
        }
        if (this.age != null) {
            sb.append(", age=");
            sb.append(this.age);
        }
        if (this.allow_geo != null) {
            sb.append(", allow_geo=");
            sb.append(this.allow_geo);
        }
        if (this.allow_imei != null) {
            sb.append(", allow_imei=");
            sb.append(this.allow_imei);
        }
        if (this.allow_oaid != null) {
            sb.append(", allow_oaid=");
            sb.append(this.allow_oaid);
        }
        if (this.allow_android_id != null) {
            sb.append(", allow_android_id=");
            sb.append(this.allow_android_id);
        }
        if (this.allow_installed_apps != null) {
            sb.append(", allow_installed_apps=");
            sb.append(this.allow_installed_apps);
        }
        if (this.allow_carrier_code != null) {
            sb.append(", allow_carrier_code=");
            sb.append(this.allow_carrier_code);
        }
        if (this.allow_space_size != null) {
            sb.append(", allow_space_size=");
            sb.append(this.allow_space_size);
        }
        StringBuilder sbReplace = sb.replace(0, 2, "Privacy{");
        sbReplace.append('}');
        return sbReplace.toString();
    }
}

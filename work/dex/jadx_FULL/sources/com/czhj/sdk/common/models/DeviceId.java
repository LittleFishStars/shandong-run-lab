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
public final class DeviceId extends AndroidMessage<DeviceId, Builder> {
    public static final ProtoAdapter<DeviceId> ADAPTER;
    public static final Parcelable.Creator<DeviceId> CREATOR;
    public static final String DEFAULT_AAID = "";
    public static final String DEFAULT_ANDROID_ID = "";
    public static final String DEFAULT_ANDROID_ID_MD5 = "";
    public static final String DEFAULT_ANDROID_UUID = "";
    public static final String DEFAULT_BRAND = "";
    public static final String DEFAULT_GAID = "";
    public static final String DEFAULT_GAID_MD5 = "";
    public static final String DEFAULT_IDFA = "";
    public static final String DEFAULT_IDFA_MD5 = "";
    public static final String DEFAULT_IMEI = "";
    public static final String DEFAULT_IMEI1 = "";
    public static final String DEFAULT_IMEI1_MD5 = "";
    public static final String DEFAULT_IMEI2 = "";
    public static final String DEFAULT_IMEI2_MD5 = "";
    public static final String DEFAULT_IMEI_MD5 = "";
    public static final String DEFAULT_IMSI = "";
    public static final Boolean DEFAULT_IS_CUSTOM_ANDROID_ID;
    public static final Boolean DEFAULT_IS_CUSTOM_IDFA;
    public static final Boolean DEFAULT_IS_CUSTOM_IMEI;
    public static final Boolean DEFAULT_IS_CUSTOM_OAID;
    public static final String DEFAULT_MSA_UDID = "";
    public static final String DEFAULT_OAID = "";
    public static final String DEFAULT_OAID_API = "";
    public static final String DEFAULT_OAID_MD5 = "";
    public static final String DEFAULT_UDID = "";
    public static final String DEFAULT_UID = "";
    public static final String DEFAULT_USER_ID = "";
    public static final String DEFAULT_VAID = "";
    private static final long serialVersionUID = 0;

    @WireField(adapter = "com.squareup.wire.ProtoAdapter#STRING", tag = 15)
    public final String aaid;

    @WireField(adapter = "com.squareup.wire.ProtoAdapter#STRING", tag = 5)
    public final String android_id;

    @WireField(adapter = "com.squareup.wire.ProtoAdapter#STRING", tag = 19)
    public final String android_id_md5;

    @WireField(adapter = "com.squareup.wire.ProtoAdapter#STRING", tag = 6)
    public final String android_uuid;

    @WireField(adapter = "com.squareup.wire.ProtoAdapter#STRING", tag = 10)
    public final String brand;

    @WireField(adapter = "com.squareup.wire.ProtoAdapter#STRING", tag = 8)
    public final String gaid;

    @WireField(adapter = "com.squareup.wire.ProtoAdapter#STRING", tag = 20)
    public final String gaid_md5;

    @WireField(adapter = "com.squareup.wire.ProtoAdapter#STRING", tag = 1)
    public final String idfa;

    @WireField(adapter = "com.squareup.wire.ProtoAdapter#STRING", tag = 17)
    public final String idfa_md5;

    @WireField(adapter = "com.squareup.wire.ProtoAdapter#STRING", tag = 4)
    public final String imei;

    @WireField(adapter = "com.squareup.wire.ProtoAdapter#STRING", tag = 11)
    public final String imei1;

    @WireField(adapter = "com.squareup.wire.ProtoAdapter#STRING", tag = 22)
    public final String imei1_md5;

    @WireField(adapter = "com.squareup.wire.ProtoAdapter#STRING", tag = 12)
    public final String imei2;

    @WireField(adapter = "com.squareup.wire.ProtoAdapter#STRING", tag = 23)
    public final String imei2_md5;

    @WireField(adapter = "com.squareup.wire.ProtoAdapter#STRING", tag = 18)
    public final String imei_md5;

    @WireField(adapter = "com.squareup.wire.ProtoAdapter#STRING", tag = 7)
    public final String imsi;

    @WireField(adapter = "com.squareup.wire.ProtoAdapter#BOOL", tag = 27)
    public final Boolean is_custom_android_id;

    @WireField(adapter = "com.squareup.wire.ProtoAdapter#BOOL", tag = 26)
    public final Boolean is_custom_idfa;

    @WireField(adapter = "com.squareup.wire.ProtoAdapter#BOOL", tag = 24)
    public final Boolean is_custom_imei;

    @WireField(adapter = "com.squareup.wire.ProtoAdapter#BOOL", tag = 25)
    public final Boolean is_custom_oaid;

    @WireField(adapter = "com.squareup.wire.ProtoAdapter#STRING", tag = 16)
    public final String msa_udid;

    @WireField(adapter = "com.squareup.wire.ProtoAdapter#STRING", tag = 13)
    public final String oaid;

    @WireField(adapter = "com.squareup.wire.ProtoAdapter#STRING", tag = 32)
    public final String oaid_api;

    @WireField(adapter = "com.squareup.wire.ProtoAdapter#STRING", tag = 21)
    public final String oaid_md5;

    @WireField(adapter = "com.squareup.wire.ProtoAdapter#STRING", tag = 2)
    public final String udid;

    @WireField(adapter = "com.squareup.wire.ProtoAdapter#STRING", tag = 9)
    public final String uid;

    @WireField(adapter = "com.squareup.wire.ProtoAdapter#STRING", tag = 3)
    public final String user_id;

    @WireField(adapter = "com.squareup.wire.ProtoAdapter#STRING", tag = 14)
    public final String vaid;

    public static final class Builder extends Message.Builder<DeviceId, Builder> {
        public String idfa = "";
        public String udid = "";
        public String user_id = "";
        public String imei = "";
        public String android_id = "";
        public String android_uuid = "";
        public String imsi = "";
        public String gaid = "";
        public String uid = "";
        public String brand = "";
        public String imei1 = "";
        public String imei2 = "";
        public String oaid = "";
        public String vaid = "";
        public String aaid = "";
        public String msa_udid = "";
        public String idfa_md5 = "";
        public String imei_md5 = "";
        public String android_id_md5 = "";
        public String gaid_md5 = "";
        public String oaid_md5 = "";
        public String imei1_md5 = "";
        public String imei2_md5 = "";
        public Boolean is_custom_imei = DeviceId.DEFAULT_IS_CUSTOM_IMEI;
        public Boolean is_custom_oaid = DeviceId.DEFAULT_IS_CUSTOM_OAID;
        public Boolean is_custom_idfa = DeviceId.DEFAULT_IS_CUSTOM_IDFA;
        public Boolean is_custom_android_id = DeviceId.DEFAULT_IS_CUSTOM_ANDROID_ID;
        public String oaid_api = "";

        public Builder aaid(String str) {
            this.aaid = str;
            return this;
        }

        public Builder android_id(String str) {
            this.android_id = str;
            return this;
        }

        public Builder android_id_md5(String str) {
            this.android_id_md5 = str;
            return this;
        }

        public Builder android_uuid(String str) {
            this.android_uuid = str;
            return this;
        }

        public Builder brand(String str) {
            this.brand = str;
            return this;
        }

        @Override // com.czhj.wire.Message.Builder
        public DeviceId build() {
            return new DeviceId(this.idfa, this.udid, this.user_id, this.imei, this.android_id, this.android_uuid, this.imsi, this.gaid, this.uid, this.brand, this.imei1, this.imei2, this.oaid, this.vaid, this.aaid, this.msa_udid, this.idfa_md5, this.imei_md5, this.android_id_md5, this.gaid_md5, this.oaid_md5, this.imei1_md5, this.imei2_md5, this.is_custom_imei, this.is_custom_oaid, this.is_custom_idfa, this.is_custom_android_id, this.oaid_api, super.buildUnknownFields());
        }

        public Builder gaid(String str) {
            this.gaid = str;
            return this;
        }

        public Builder gaid_md5(String str) {
            this.gaid_md5 = str;
            return this;
        }

        public Builder idfa(String str) {
            this.idfa = str;
            return this;
        }

        public Builder idfa_md5(String str) {
            this.idfa_md5 = str;
            return this;
        }

        public Builder imei(String str) {
            this.imei = str;
            return this;
        }

        public Builder imei1(String str) {
            this.imei1 = str;
            return this;
        }

        public Builder imei1_md5(String str) {
            this.imei1_md5 = str;
            return this;
        }

        public Builder imei2(String str) {
            this.imei2 = str;
            return this;
        }

        public Builder imei2_md5(String str) {
            this.imei2_md5 = str;
            return this;
        }

        public Builder imei_md5(String str) {
            this.imei_md5 = str;
            return this;
        }

        public Builder imsi(String str) {
            this.imsi = str;
            return this;
        }

        public Builder is_custom_android_id(Boolean bool) {
            this.is_custom_android_id = bool;
            return this;
        }

        public Builder is_custom_idfa(Boolean bool) {
            this.is_custom_idfa = bool;
            return this;
        }

        public Builder is_custom_imei(Boolean bool) {
            this.is_custom_imei = bool;
            return this;
        }

        public Builder is_custom_oaid(Boolean bool) {
            this.is_custom_oaid = bool;
            return this;
        }

        public Builder msa_udid(String str) {
            this.msa_udid = str;
            return this;
        }

        public Builder oaid(String str) {
            this.oaid = str;
            return this;
        }

        public Builder oaid_api(String str) {
            this.oaid_api = str;
            return this;
        }

        public Builder oaid_md5(String str) {
            this.oaid_md5 = str;
            return this;
        }

        public Builder udid(String str) {
            this.udid = str;
            return this;
        }

        public Builder uid(String str) {
            this.uid = str;
            return this;
        }

        public Builder user_id(String str) {
            this.user_id = str;
            return this;
        }

        public Builder vaid(String str) {
            this.vaid = str;
            return this;
        }
    }

    public static final class ProtoAdapter_DeviceId extends ProtoAdapter<DeviceId> {
        public ProtoAdapter_DeviceId() {
            super(FieldEncoding.LENGTH_DELIMITED, DeviceId.class);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.czhj.wire.ProtoAdapter
        public DeviceId decode(ProtoReader protoReader) throws IOException {
            Builder builder = new Builder();
            long jBeginMessage = protoReader.beginMessage();
            while (true) {
                int iNextTag = protoReader.nextTag();
                if (iNextTag == -1) {
                    protoReader.endMessage(jBeginMessage);
                    return builder.build();
                }
                if (iNextTag != 32) {
                    switch (iNextTag) {
                        case 1:
                            builder.idfa(ProtoAdapter.STRING.decode(protoReader));
                            break;
                        case 2:
                            builder.udid(ProtoAdapter.STRING.decode(protoReader));
                            break;
                        case 3:
                            builder.user_id(ProtoAdapter.STRING.decode(protoReader));
                            break;
                        case 4:
                            builder.imei(ProtoAdapter.STRING.decode(protoReader));
                            break;
                        case 5:
                            builder.android_id(ProtoAdapter.STRING.decode(protoReader));
                            break;
                        case 6:
                            builder.android_uuid(ProtoAdapter.STRING.decode(protoReader));
                            break;
                        case 7:
                            builder.imsi(ProtoAdapter.STRING.decode(protoReader));
                            break;
                        case 8:
                            builder.gaid(ProtoAdapter.STRING.decode(protoReader));
                            break;
                        case 9:
                            builder.uid(ProtoAdapter.STRING.decode(protoReader));
                            break;
                        case 10:
                            builder.brand(ProtoAdapter.STRING.decode(protoReader));
                            break;
                        case 11:
                            builder.imei1(ProtoAdapter.STRING.decode(protoReader));
                            break;
                        case 12:
                            builder.imei2(ProtoAdapter.STRING.decode(protoReader));
                            break;
                        case 13:
                            builder.oaid(ProtoAdapter.STRING.decode(protoReader));
                            break;
                        case 14:
                            builder.vaid(ProtoAdapter.STRING.decode(protoReader));
                            break;
                        case 15:
                            builder.aaid(ProtoAdapter.STRING.decode(protoReader));
                            break;
                        case 16:
                            builder.msa_udid(ProtoAdapter.STRING.decode(protoReader));
                            break;
                        case 17:
                            builder.idfa_md5(ProtoAdapter.STRING.decode(protoReader));
                            break;
                        case 18:
                            builder.imei_md5(ProtoAdapter.STRING.decode(protoReader));
                            break;
                        case 19:
                            builder.android_id_md5(ProtoAdapter.STRING.decode(protoReader));
                            break;
                        case 20:
                            builder.gaid_md5(ProtoAdapter.STRING.decode(protoReader));
                            break;
                        case 21:
                            builder.oaid_md5(ProtoAdapter.STRING.decode(protoReader));
                            break;
                        case 22:
                            builder.imei1_md5(ProtoAdapter.STRING.decode(protoReader));
                            break;
                        case 23:
                            builder.imei2_md5(ProtoAdapter.STRING.decode(protoReader));
                            break;
                        case 24:
                            builder.is_custom_imei(ProtoAdapter.BOOL.decode(protoReader));
                            break;
                        case 25:
                            builder.is_custom_oaid(ProtoAdapter.BOOL.decode(protoReader));
                            break;
                        case 26:
                            builder.is_custom_idfa(ProtoAdapter.BOOL.decode(protoReader));
                            break;
                        case 27:
                            builder.is_custom_android_id(ProtoAdapter.BOOL.decode(protoReader));
                            break;
                        default:
                            FieldEncoding fieldEncodingPeekFieldEncoding = protoReader.peekFieldEncoding();
                            builder.addUnknownField(iNextTag, fieldEncodingPeekFieldEncoding, fieldEncodingPeekFieldEncoding.rawProtoAdapter().decode(protoReader));
                            break;
                    }
                } else {
                    builder.oaid_api(ProtoAdapter.STRING.decode(protoReader));
                }
            }
        }

        @Override // com.czhj.wire.ProtoAdapter
        public void encode(ProtoWriter protoWriter, DeviceId deviceId) throws IOException {
            ProtoAdapter<String> protoAdapter = ProtoAdapter.STRING;
            protoAdapter.encodeWithTag(protoWriter, 1, deviceId.idfa);
            protoAdapter.encodeWithTag(protoWriter, 2, deviceId.udid);
            protoAdapter.encodeWithTag(protoWriter, 3, deviceId.user_id);
            protoAdapter.encodeWithTag(protoWriter, 4, deviceId.imei);
            protoAdapter.encodeWithTag(protoWriter, 5, deviceId.android_id);
            protoAdapter.encodeWithTag(protoWriter, 6, deviceId.android_uuid);
            protoAdapter.encodeWithTag(protoWriter, 7, deviceId.imsi);
            protoAdapter.encodeWithTag(protoWriter, 8, deviceId.gaid);
            protoAdapter.encodeWithTag(protoWriter, 9, deviceId.uid);
            protoAdapter.encodeWithTag(protoWriter, 10, deviceId.brand);
            protoAdapter.encodeWithTag(protoWriter, 11, deviceId.imei1);
            protoAdapter.encodeWithTag(protoWriter, 12, deviceId.imei2);
            protoAdapter.encodeWithTag(protoWriter, 13, deviceId.oaid);
            protoAdapter.encodeWithTag(protoWriter, 14, deviceId.vaid);
            protoAdapter.encodeWithTag(protoWriter, 15, deviceId.aaid);
            protoAdapter.encodeWithTag(protoWriter, 16, deviceId.msa_udid);
            protoAdapter.encodeWithTag(protoWriter, 17, deviceId.idfa_md5);
            protoAdapter.encodeWithTag(protoWriter, 18, deviceId.imei_md5);
            protoAdapter.encodeWithTag(protoWriter, 19, deviceId.android_id_md5);
            protoAdapter.encodeWithTag(protoWriter, 20, deviceId.gaid_md5);
            protoAdapter.encodeWithTag(protoWriter, 21, deviceId.oaid_md5);
            protoAdapter.encodeWithTag(protoWriter, 22, deviceId.imei1_md5);
            protoAdapter.encodeWithTag(protoWriter, 23, deviceId.imei2_md5);
            ProtoAdapter<Boolean> protoAdapter2 = ProtoAdapter.BOOL;
            protoAdapter2.encodeWithTag(protoWriter, 24, deviceId.is_custom_imei);
            protoAdapter2.encodeWithTag(protoWriter, 25, deviceId.is_custom_oaid);
            protoAdapter2.encodeWithTag(protoWriter, 26, deviceId.is_custom_idfa);
            protoAdapter2.encodeWithTag(protoWriter, 27, deviceId.is_custom_android_id);
            protoAdapter.encodeWithTag(protoWriter, 32, deviceId.oaid_api);
            protoWriter.writeBytes(deviceId.unknownFields());
        }

        @Override // com.czhj.wire.ProtoAdapter
        public int encodedSize(DeviceId deviceId) {
            ProtoAdapter<String> protoAdapter = ProtoAdapter.STRING;
            int iEncodedSizeWithTag = protoAdapter.encodedSizeWithTag(1, deviceId.idfa) + protoAdapter.encodedSizeWithTag(2, deviceId.udid) + protoAdapter.encodedSizeWithTag(3, deviceId.user_id) + protoAdapter.encodedSizeWithTag(4, deviceId.imei) + protoAdapter.encodedSizeWithTag(5, deviceId.android_id) + protoAdapter.encodedSizeWithTag(6, deviceId.android_uuid) + protoAdapter.encodedSizeWithTag(7, deviceId.imsi) + protoAdapter.encodedSizeWithTag(8, deviceId.gaid) + protoAdapter.encodedSizeWithTag(9, deviceId.uid) + protoAdapter.encodedSizeWithTag(10, deviceId.brand) + protoAdapter.encodedSizeWithTag(11, deviceId.imei1) + protoAdapter.encodedSizeWithTag(12, deviceId.imei2) + protoAdapter.encodedSizeWithTag(13, deviceId.oaid) + protoAdapter.encodedSizeWithTag(14, deviceId.vaid) + protoAdapter.encodedSizeWithTag(15, deviceId.aaid) + protoAdapter.encodedSizeWithTag(16, deviceId.msa_udid) + protoAdapter.encodedSizeWithTag(17, deviceId.idfa_md5) + protoAdapter.encodedSizeWithTag(18, deviceId.imei_md5) + protoAdapter.encodedSizeWithTag(19, deviceId.android_id_md5) + protoAdapter.encodedSizeWithTag(20, deviceId.gaid_md5) + protoAdapter.encodedSizeWithTag(21, deviceId.oaid_md5) + protoAdapter.encodedSizeWithTag(22, deviceId.imei1_md5) + protoAdapter.encodedSizeWithTag(23, deviceId.imei2_md5);
            ProtoAdapter<Boolean> protoAdapter2 = ProtoAdapter.BOOL;
            return iEncodedSizeWithTag + protoAdapter2.encodedSizeWithTag(24, deviceId.is_custom_imei) + protoAdapter2.encodedSizeWithTag(25, deviceId.is_custom_oaid) + protoAdapter2.encodedSizeWithTag(26, deviceId.is_custom_idfa) + protoAdapter2.encodedSizeWithTag(27, deviceId.is_custom_android_id) + protoAdapter.encodedSizeWithTag(32, deviceId.oaid_api) + deviceId.unknownFields().size();
        }

        @Override // com.czhj.wire.ProtoAdapter
        public DeviceId redact(DeviceId deviceId) {
            Builder builderNewBuilder = deviceId.newBuilder();
            builderNewBuilder.clearUnknownFields();
            return builderNewBuilder.build();
        }
    }

    static {
        ProtoAdapter_DeviceId protoAdapter_DeviceId = new ProtoAdapter_DeviceId();
        ADAPTER = protoAdapter_DeviceId;
        CREATOR = AndroidMessage.newCreator(protoAdapter_DeviceId);
        Boolean bool = Boolean.FALSE;
        DEFAULT_IS_CUSTOM_IMEI = bool;
        DEFAULT_IS_CUSTOM_OAID = bool;
        DEFAULT_IS_CUSTOM_IDFA = bool;
        DEFAULT_IS_CUSTOM_ANDROID_ID = bool;
    }

    public DeviceId(String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8, String str9, String str10, String str11, String str12, String str13, String str14, String str15, String str16, String str17, String str18, String str19, String str20, String str21, String str22, String str23, Boolean bool, Boolean bool2, Boolean bool3, Boolean bool4, String str24) {
        this(str, str2, str3, str4, str5, str6, str7, str8, str9, str10, str11, str12, str13, str14, str15, str16, str17, str18, str19, str20, str21, str22, str23, bool, bool2, bool3, bool4, str24, ByteString.EMPTY);
    }

    public DeviceId(String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8, String str9, String str10, String str11, String str12, String str13, String str14, String str15, String str16, String str17, String str18, String str19, String str20, String str21, String str22, String str23, Boolean bool, Boolean bool2, Boolean bool3, Boolean bool4, String str24, ByteString byteString) {
        super(ADAPTER, byteString);
        this.idfa = str;
        this.udid = str2;
        this.user_id = str3;
        this.imei = str4;
        this.android_id = str5;
        this.android_uuid = str6;
        this.imsi = str7;
        this.gaid = str8;
        this.uid = str9;
        this.brand = str10;
        this.imei1 = str11;
        this.imei2 = str12;
        this.oaid = str13;
        this.vaid = str14;
        this.aaid = str15;
        this.msa_udid = str16;
        this.idfa_md5 = str17;
        this.imei_md5 = str18;
        this.android_id_md5 = str19;
        this.gaid_md5 = str20;
        this.oaid_md5 = str21;
        this.imei1_md5 = str22;
        this.imei2_md5 = str23;
        this.is_custom_imei = bool;
        this.is_custom_oaid = bool2;
        this.is_custom_idfa = bool3;
        this.is_custom_android_id = bool4;
        this.oaid_api = str24;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof DeviceId)) {
            return false;
        }
        DeviceId deviceId = (DeviceId) obj;
        return unknownFields().equals(deviceId.unknownFields()) && Internal.equals(this.idfa, deviceId.idfa) && Internal.equals(this.udid, deviceId.udid) && Internal.equals(this.user_id, deviceId.user_id) && Internal.equals(this.imei, deviceId.imei) && Internal.equals(this.android_id, deviceId.android_id) && Internal.equals(this.android_uuid, deviceId.android_uuid) && Internal.equals(this.imsi, deviceId.imsi) && Internal.equals(this.gaid, deviceId.gaid) && Internal.equals(this.uid, deviceId.uid) && Internal.equals(this.brand, deviceId.brand) && Internal.equals(this.imei1, deviceId.imei1) && Internal.equals(this.imei2, deviceId.imei2) && Internal.equals(this.oaid, deviceId.oaid) && Internal.equals(this.vaid, deviceId.vaid) && Internal.equals(this.aaid, deviceId.aaid) && Internal.equals(this.msa_udid, deviceId.msa_udid) && Internal.equals(this.idfa_md5, deviceId.idfa_md5) && Internal.equals(this.imei_md5, deviceId.imei_md5) && Internal.equals(this.android_id_md5, deviceId.android_id_md5) && Internal.equals(this.gaid_md5, deviceId.gaid_md5) && Internal.equals(this.oaid_md5, deviceId.oaid_md5) && Internal.equals(this.imei1_md5, deviceId.imei1_md5) && Internal.equals(this.imei2_md5, deviceId.imei2_md5) && Internal.equals(this.is_custom_imei, deviceId.is_custom_imei) && Internal.equals(this.is_custom_oaid, deviceId.is_custom_oaid) && Internal.equals(this.is_custom_idfa, deviceId.is_custom_idfa) && Internal.equals(this.is_custom_android_id, deviceId.is_custom_android_id) && Internal.equals(this.oaid_api, deviceId.oaid_api);
    }

    public int hashCode() {
        int i = this.hashCode;
        if (i != 0) {
            return i;
        }
        int iHashCode = unknownFields().hashCode() * 37;
        String str = this.idfa;
        int iHashCode2 = (iHashCode + (str != null ? str.hashCode() : 0)) * 37;
        String str2 = this.udid;
        int iHashCode3 = (iHashCode2 + (str2 != null ? str2.hashCode() : 0)) * 37;
        String str3 = this.user_id;
        int iHashCode4 = (iHashCode3 + (str3 != null ? str3.hashCode() : 0)) * 37;
        String str4 = this.imei;
        int iHashCode5 = (iHashCode4 + (str4 != null ? str4.hashCode() : 0)) * 37;
        String str5 = this.android_id;
        int iHashCode6 = (iHashCode5 + (str5 != null ? str5.hashCode() : 0)) * 37;
        String str6 = this.android_uuid;
        int iHashCode7 = (iHashCode6 + (str6 != null ? str6.hashCode() : 0)) * 37;
        String str7 = this.imsi;
        int iHashCode8 = (iHashCode7 + (str7 != null ? str7.hashCode() : 0)) * 37;
        String str8 = this.gaid;
        int iHashCode9 = (iHashCode8 + (str8 != null ? str8.hashCode() : 0)) * 37;
        String str9 = this.uid;
        int iHashCode10 = (iHashCode9 + (str9 != null ? str9.hashCode() : 0)) * 37;
        String str10 = this.brand;
        int iHashCode11 = (iHashCode10 + (str10 != null ? str10.hashCode() : 0)) * 37;
        String str11 = this.imei1;
        int iHashCode12 = (iHashCode11 + (str11 != null ? str11.hashCode() : 0)) * 37;
        String str12 = this.imei2;
        int iHashCode13 = (iHashCode12 + (str12 != null ? str12.hashCode() : 0)) * 37;
        String str13 = this.oaid;
        int iHashCode14 = (iHashCode13 + (str13 != null ? str13.hashCode() : 0)) * 37;
        String str14 = this.vaid;
        int iHashCode15 = (iHashCode14 + (str14 != null ? str14.hashCode() : 0)) * 37;
        String str15 = this.aaid;
        int iHashCode16 = (iHashCode15 + (str15 != null ? str15.hashCode() : 0)) * 37;
        String str16 = this.msa_udid;
        int iHashCode17 = (iHashCode16 + (str16 != null ? str16.hashCode() : 0)) * 37;
        String str17 = this.idfa_md5;
        int iHashCode18 = (iHashCode17 + (str17 != null ? str17.hashCode() : 0)) * 37;
        String str18 = this.imei_md5;
        int iHashCode19 = (iHashCode18 + (str18 != null ? str18.hashCode() : 0)) * 37;
        String str19 = this.android_id_md5;
        int iHashCode20 = (iHashCode19 + (str19 != null ? str19.hashCode() : 0)) * 37;
        String str20 = this.gaid_md5;
        int iHashCode21 = (iHashCode20 + (str20 != null ? str20.hashCode() : 0)) * 37;
        String str21 = this.oaid_md5;
        int iHashCode22 = (iHashCode21 + (str21 != null ? str21.hashCode() : 0)) * 37;
        String str22 = this.imei1_md5;
        int iHashCode23 = (iHashCode22 + (str22 != null ? str22.hashCode() : 0)) * 37;
        String str23 = this.imei2_md5;
        int iHashCode24 = (iHashCode23 + (str23 != null ? str23.hashCode() : 0)) * 37;
        Boolean bool = this.is_custom_imei;
        int iHashCode25 = (iHashCode24 + (bool != null ? bool.hashCode() : 0)) * 37;
        Boolean bool2 = this.is_custom_oaid;
        int iHashCode26 = (iHashCode25 + (bool2 != null ? bool2.hashCode() : 0)) * 37;
        Boolean bool3 = this.is_custom_idfa;
        int iHashCode27 = (iHashCode26 + (bool3 != null ? bool3.hashCode() : 0)) * 37;
        Boolean bool4 = this.is_custom_android_id;
        int iHashCode28 = (iHashCode27 + (bool4 != null ? bool4.hashCode() : 0)) * 37;
        String str24 = this.oaid_api;
        int iHashCode29 = iHashCode28 + (str24 != null ? str24.hashCode() : 0);
        this.hashCode = iHashCode29;
        return iHashCode29;
    }

    @Override // com.czhj.wire.Message
    public Builder newBuilder() {
        Builder builder = new Builder();
        builder.idfa = this.idfa;
        builder.udid = this.udid;
        builder.user_id = this.user_id;
        builder.imei = this.imei;
        builder.android_id = this.android_id;
        builder.android_uuid = this.android_uuid;
        builder.imsi = this.imsi;
        builder.gaid = this.gaid;
        builder.uid = this.uid;
        builder.brand = this.brand;
        builder.imei1 = this.imei1;
        builder.imei2 = this.imei2;
        builder.oaid = this.oaid;
        builder.vaid = this.vaid;
        builder.aaid = this.aaid;
        builder.msa_udid = this.msa_udid;
        builder.idfa_md5 = this.idfa_md5;
        builder.imei_md5 = this.imei_md5;
        builder.android_id_md5 = this.android_id_md5;
        builder.gaid_md5 = this.gaid_md5;
        builder.oaid_md5 = this.oaid_md5;
        builder.imei1_md5 = this.imei1_md5;
        builder.imei2_md5 = this.imei2_md5;
        builder.is_custom_imei = this.is_custom_imei;
        builder.is_custom_oaid = this.is_custom_oaid;
        builder.is_custom_idfa = this.is_custom_idfa;
        builder.is_custom_android_id = this.is_custom_android_id;
        builder.oaid_api = this.oaid_api;
        builder.addUnknownFields(unknownFields());
        return builder;
    }

    @Override // com.czhj.wire.Message
    public String toString() {
        StringBuilder sb = new StringBuilder();
        if (this.idfa != null) {
            sb.append(", idfa=");
            sb.append(this.idfa);
        }
        if (this.udid != null) {
            sb.append(", udid=");
            sb.append(this.udid);
        }
        if (this.user_id != null) {
            sb.append(", user_id=");
            sb.append(this.user_id);
        }
        if (this.imei != null) {
            sb.append(", imei=");
            sb.append(this.imei);
        }
        if (this.android_id != null) {
            sb.append(", android_id=");
            sb.append(this.android_id);
        }
        if (this.android_uuid != null) {
            sb.append(", android_uuid=");
            sb.append(this.android_uuid);
        }
        if (this.imsi != null) {
            sb.append(", imsi=");
            sb.append(this.imsi);
        }
        if (this.gaid != null) {
            sb.append(", gaid=");
            sb.append(this.gaid);
        }
        if (this.uid != null) {
            sb.append(", uid=");
            sb.append(this.uid);
        }
        if (this.brand != null) {
            sb.append(", brand=");
            sb.append(this.brand);
        }
        if (this.imei1 != null) {
            sb.append(", imei1=");
            sb.append(this.imei1);
        }
        if (this.imei2 != null) {
            sb.append(", imei2=");
            sb.append(this.imei2);
        }
        if (this.oaid != null) {
            sb.append(", oaid=");
            sb.append(this.oaid);
        }
        if (this.vaid != null) {
            sb.append(", vaid=");
            sb.append(this.vaid);
        }
        if (this.aaid != null) {
            sb.append(", aaid=");
            sb.append(this.aaid);
        }
        if (this.msa_udid != null) {
            sb.append(", msa_udid=");
            sb.append(this.msa_udid);
        }
        if (this.idfa_md5 != null) {
            sb.append(", idfa_md5=");
            sb.append(this.idfa_md5);
        }
        if (this.imei_md5 != null) {
            sb.append(", imei_md5=");
            sb.append(this.imei_md5);
        }
        if (this.android_id_md5 != null) {
            sb.append(", android_id_md5=");
            sb.append(this.android_id_md5);
        }
        if (this.gaid_md5 != null) {
            sb.append(", gaid_md5=");
            sb.append(this.gaid_md5);
        }
        if (this.oaid_md5 != null) {
            sb.append(", oaid_md5=");
            sb.append(this.oaid_md5);
        }
        if (this.imei1_md5 != null) {
            sb.append(", imei1_md5=");
            sb.append(this.imei1_md5);
        }
        if (this.imei2_md5 != null) {
            sb.append(", imei2_md5=");
            sb.append(this.imei2_md5);
        }
        if (this.is_custom_imei != null) {
            sb.append(", is_custom_imei=");
            sb.append(this.is_custom_imei);
        }
        if (this.is_custom_oaid != null) {
            sb.append(", is_custom_oaid=");
            sb.append(this.is_custom_oaid);
        }
        if (this.is_custom_idfa != null) {
            sb.append(", is_custom_idfa=");
            sb.append(this.is_custom_idfa);
        }
        if (this.is_custom_android_id != null) {
            sb.append(", is_custom_android_id=");
            sb.append(this.is_custom_android_id);
        }
        if (this.oaid_api != null) {
            sb.append(", oaid_api=");
            sb.append(this.oaid_api);
        }
        StringBuilder sbReplace = sb.replace(0, 2, "DeviceId{");
        sbReplace.append('}');
        return sbReplace.toString();
    }
}

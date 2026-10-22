package com.baidu.entity.pb;

import com.google.protobuf.micro.CodedInputStreamMicro;
import com.google.protobuf.micro.CodedOutputStreamMicro;
import com.google.protobuf.micro.InvalidProtocolBufferMicroException;
import com.google.protobuf.micro.MessageMicro;
import java.io.IOException;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_10_7392cls.dex */
public final class UgcEventDynamicInfo extends MessageMicro {
    public static final int EXT_INFO_FIELD_NUMBER = 7;
    public static final int INQUIRY_CONFIG_FIELD_NUMBER = 1;
    public static final int INQUIRY_CONFIG_ID_FIELD_NUMBER = 2;
    public static final int META_FIELD_NUMBER = 3;
    public static final int SUB_TYPE_FIELD_NUMBER = 4;
    public static final int TYPE_FIELD_NUMBER = 5;
    public static final int UGCEXTINFO_FIELD_NUMBER = 6;
    private boolean hasExtInfo;
    private boolean hasInquiryConfig;
    private boolean hasInquiryConfigId;
    private boolean hasMeta;
    private boolean hasSubType;
    private boolean hasType;
    private boolean hasUgcExtInfo;
    private UgcEventInquiryConfig inquiryConfig_ = null;
    private int inquiryConfigId_ = 0;
    private String meta_ = "";
    private int subType_ = 0;
    private int type_ = 0;
    private UgcExtInfo ugcExtInfo_ = null;
    private String extInfo_ = "";
    private int cachedSize = -1;

    public static UgcEventDynamicInfo parseFrom(CodedInputStreamMicro codedInputStreamMicro) throws IOException {
        return new UgcEventDynamicInfo().mergeFrom(codedInputStreamMicro);
    }

    public static UgcEventDynamicInfo parseFrom(byte[] bArr) throws InvalidProtocolBufferMicroException {
        return (UgcEventDynamicInfo) new UgcEventDynamicInfo().mergeFrom(bArr);
    }

    public final UgcEventDynamicInfo clear() {
        clearInquiryConfig();
        clearInquiryConfigId();
        clearMeta();
        clearSubType();
        clearType();
        clearUgcExtInfo();
        clearExtInfo();
        this.cachedSize = -1;
        return this;
    }

    public UgcEventDynamicInfo clearExtInfo() {
        this.hasExtInfo = false;
        this.extInfo_ = "";
        return this;
    }

    public UgcEventDynamicInfo clearInquiryConfig() {
        this.hasInquiryConfig = false;
        this.inquiryConfig_ = null;
        return this;
    }

    public UgcEventDynamicInfo clearInquiryConfigId() {
        this.hasInquiryConfigId = false;
        this.inquiryConfigId_ = 0;
        return this;
    }

    public UgcEventDynamicInfo clearMeta() {
        this.hasMeta = false;
        this.meta_ = "";
        return this;
    }

    public UgcEventDynamicInfo clearSubType() {
        this.hasSubType = false;
        this.subType_ = 0;
        return this;
    }

    public UgcEventDynamicInfo clearType() {
        this.hasType = false;
        this.type_ = 0;
        return this;
    }

    public UgcEventDynamicInfo clearUgcExtInfo() {
        this.hasUgcExtInfo = false;
        this.ugcExtInfo_ = null;
        return this;
    }

    @Override // com.google.protobuf.micro.MessageMicro
    public int getCachedSize() {
        if (this.cachedSize < 0) {
            getSerializedSize();
        }
        return this.cachedSize;
    }

    public String getExtInfo() {
        return this.extInfo_;
    }

    public UgcEventInquiryConfig getInquiryConfig() {
        return this.inquiryConfig_;
    }

    public int getInquiryConfigId() {
        return this.inquiryConfigId_;
    }

    public String getMeta() {
        return this.meta_;
    }

    @Override // com.google.protobuf.micro.MessageMicro
    public int getSerializedSize() {
        int iComputeMessageSize = hasInquiryConfig() ? 0 + CodedOutputStreamMicro.computeMessageSize(1, getInquiryConfig()) : 0;
        if (hasInquiryConfigId()) {
            iComputeMessageSize += CodedOutputStreamMicro.computeInt32Size(2, getInquiryConfigId());
        }
        if (hasMeta()) {
            iComputeMessageSize += CodedOutputStreamMicro.computeStringSize(3, getMeta());
        }
        if (hasSubType()) {
            iComputeMessageSize += CodedOutputStreamMicro.computeInt32Size(4, getSubType());
        }
        if (hasType()) {
            iComputeMessageSize += CodedOutputStreamMicro.computeInt32Size(5, getType());
        }
        if (hasUgcExtInfo()) {
            iComputeMessageSize += CodedOutputStreamMicro.computeMessageSize(6, getUgcExtInfo());
        }
        if (hasExtInfo()) {
            iComputeMessageSize += CodedOutputStreamMicro.computeStringSize(7, getExtInfo());
        }
        this.cachedSize = iComputeMessageSize;
        return iComputeMessageSize;
    }

    public int getSubType() {
        return this.subType_;
    }

    public int getType() {
        return this.type_;
    }

    public UgcExtInfo getUgcExtInfo() {
        return this.ugcExtInfo_;
    }

    public boolean hasExtInfo() {
        return this.hasExtInfo;
    }

    public boolean hasInquiryConfig() {
        return this.hasInquiryConfig;
    }

    public boolean hasInquiryConfigId() {
        return this.hasInquiryConfigId;
    }

    public boolean hasMeta() {
        return this.hasMeta;
    }

    public boolean hasSubType() {
        return this.hasSubType;
    }

    public boolean hasType() {
        return this.hasType;
    }

    public boolean hasUgcExtInfo() {
        return this.hasUgcExtInfo;
    }

    public final boolean isInitialized() {
        if (this.hasInquiryConfig && this.hasInquiryConfigId && getInquiryConfig().isInitialized()) {
            return !hasUgcExtInfo() || getUgcExtInfo().isInitialized();
        }
        return false;
    }

    @Override // com.google.protobuf.micro.MessageMicro
    public UgcEventDynamicInfo mergeFrom(CodedInputStreamMicro codedInputStreamMicro) throws IOException {
        while (true) {
            int tag = codedInputStreamMicro.readTag();
            if (tag == 0) {
                return this;
            }
            if (tag == 10) {
                UgcEventInquiryConfig ugcEventInquiryConfig = new UgcEventInquiryConfig();
                codedInputStreamMicro.readMessage(ugcEventInquiryConfig);
                setInquiryConfig(ugcEventInquiryConfig);
            } else if (tag == 16) {
                setInquiryConfigId(codedInputStreamMicro.readInt32());
            } else if (tag == 26) {
                setMeta(codedInputStreamMicro.readString());
            } else if (tag == 32) {
                setSubType(codedInputStreamMicro.readInt32());
            } else if (tag == 40) {
                setType(codedInputStreamMicro.readInt32());
            } else if (tag == 50) {
                UgcExtInfo ugcExtInfo = new UgcExtInfo();
                codedInputStreamMicro.readMessage(ugcExtInfo);
                setUgcExtInfo(ugcExtInfo);
            } else if (tag == 58) {
                setExtInfo(codedInputStreamMicro.readString());
            } else if (!parseUnknownField(codedInputStreamMicro, tag)) {
                return this;
            }
        }
    }

    public UgcEventDynamicInfo setExtInfo(String str) {
        this.hasExtInfo = true;
        this.extInfo_ = str;
        return this;
    }

    public UgcEventDynamicInfo setInquiryConfig(UgcEventInquiryConfig ugcEventInquiryConfig) {
        if (ugcEventInquiryConfig == null) {
            return clearInquiryConfig();
        }
        this.hasInquiryConfig = true;
        this.inquiryConfig_ = ugcEventInquiryConfig;
        return this;
    }

    public UgcEventDynamicInfo setInquiryConfigId(int i) {
        this.hasInquiryConfigId = true;
        this.inquiryConfigId_ = i;
        return this;
    }

    public UgcEventDynamicInfo setMeta(String str) {
        this.hasMeta = true;
        this.meta_ = str;
        return this;
    }

    public UgcEventDynamicInfo setSubType(int i) {
        this.hasSubType = true;
        this.subType_ = i;
        return this;
    }

    public UgcEventDynamicInfo setType(int i) {
        this.hasType = true;
        this.type_ = i;
        return this;
    }

    public UgcEventDynamicInfo setUgcExtInfo(UgcExtInfo ugcExtInfo) {
        if (ugcExtInfo == null) {
            return clearUgcExtInfo();
        }
        this.hasUgcExtInfo = true;
        this.ugcExtInfo_ = ugcExtInfo;
        return this;
    }

    @Override // com.google.protobuf.micro.MessageMicro
    public void writeTo(CodedOutputStreamMicro codedOutputStreamMicro) throws IOException {
        if (hasInquiryConfig()) {
            codedOutputStreamMicro.writeMessage(1, getInquiryConfig());
        }
        if (hasInquiryConfigId()) {
            codedOutputStreamMicro.writeInt32(2, getInquiryConfigId());
        }
        if (hasMeta()) {
            codedOutputStreamMicro.writeString(3, getMeta());
        }
        if (hasSubType()) {
            codedOutputStreamMicro.writeInt32(4, getSubType());
        }
        if (hasType()) {
            codedOutputStreamMicro.writeInt32(5, getType());
        }
        if (hasUgcExtInfo()) {
            codedOutputStreamMicro.writeMessage(6, getUgcExtInfo());
        }
        if (hasExtInfo()) {
            codedOutputStreamMicro.writeString(7, getExtInfo());
        }
    }
}

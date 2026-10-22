package com.baidu.entity.pb;

import com.google.protobuf.micro.ByteStringMicro;
import com.google.protobuf.micro.CodedInputStreamMicro;
import com.google.protobuf.micro.CodedOutputStreamMicro;
import com.google.protobuf.micro.InvalidProtocolBufferMicroException;
import com.google.protobuf.micro.MessageMicro;
import java.io.IOException;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_10_7392cls.dex */
public final class TransPanelPointPair extends MessageMicro {
    public static final int AUXI_END_INDEX_FIELD_NUMBER = 4;
    public static final int AUXI_START_INDEX_FIELD_NUMBER = 3;
    public static final int CONTENT_FIELD_NUMBER = 8;
    public static final int MAIN_END_INDEX_FIELD_NUMBER = 2;
    public static final int MAIN_START_INDEX_FIELD_NUMBER = 1;
    public static final int MAIN_TRIGGER_DIST_FIELD_NUMBER = 6;
    public static final int POINT_TYPE_FIELD_NUMBER = 7;
    public static final int ROAD_INDEX_FIELD_NUMBER = 5;
    public static final int SUB_CONTENT_FIELD_NUMBER = 9;
    private int cachedSize;
    private ByteStringMicro content_;
    private boolean hasAuxiEndIndex;
    private boolean hasAuxiStartIndex;
    private boolean hasContent;
    private boolean hasMainEndIndex;
    private boolean hasMainStartIndex;
    private boolean hasMainTriggerDist;
    private boolean hasPointType;
    private boolean hasRoadIndex;
    private boolean hasSubContent;
    private ByteStringMicro subContent_;
    private int mainStartIndex_ = 0;
    private int mainEndIndex_ = 0;
    private int auxiStartIndex_ = 0;
    private int auxiEndIndex_ = 0;
    private int roadIndex_ = 0;
    private int mainTriggerDist_ = 0;
    private int pointType_ = 0;

    public TransPanelPointPair() {
        ByteStringMicro byteStringMicro = ByteStringMicro.EMPTY;
        this.content_ = byteStringMicro;
        this.subContent_ = byteStringMicro;
        this.cachedSize = -1;
    }

    public static TransPanelPointPair parseFrom(CodedInputStreamMicro codedInputStreamMicro) throws IOException {
        return new TransPanelPointPair().mergeFrom(codedInputStreamMicro);
    }

    public static TransPanelPointPair parseFrom(byte[] bArr) throws InvalidProtocolBufferMicroException {
        return (TransPanelPointPair) new TransPanelPointPair().mergeFrom(bArr);
    }

    public final TransPanelPointPair clear() {
        clearMainStartIndex();
        clearMainEndIndex();
        clearAuxiStartIndex();
        clearAuxiEndIndex();
        clearRoadIndex();
        clearMainTriggerDist();
        clearPointType();
        clearContent();
        clearSubContent();
        this.cachedSize = -1;
        return this;
    }

    public TransPanelPointPair clearAuxiEndIndex() {
        this.hasAuxiEndIndex = false;
        this.auxiEndIndex_ = 0;
        return this;
    }

    public TransPanelPointPair clearAuxiStartIndex() {
        this.hasAuxiStartIndex = false;
        this.auxiStartIndex_ = 0;
        return this;
    }

    public TransPanelPointPair clearContent() {
        this.hasContent = false;
        this.content_ = ByteStringMicro.EMPTY;
        return this;
    }

    public TransPanelPointPair clearMainEndIndex() {
        this.hasMainEndIndex = false;
        this.mainEndIndex_ = 0;
        return this;
    }

    public TransPanelPointPair clearMainStartIndex() {
        this.hasMainStartIndex = false;
        this.mainStartIndex_ = 0;
        return this;
    }

    public TransPanelPointPair clearMainTriggerDist() {
        this.hasMainTriggerDist = false;
        this.mainTriggerDist_ = 0;
        return this;
    }

    public TransPanelPointPair clearPointType() {
        this.hasPointType = false;
        this.pointType_ = 0;
        return this;
    }

    public TransPanelPointPair clearRoadIndex() {
        this.hasRoadIndex = false;
        this.roadIndex_ = 0;
        return this;
    }

    public TransPanelPointPair clearSubContent() {
        this.hasSubContent = false;
        this.subContent_ = ByteStringMicro.EMPTY;
        return this;
    }

    public int getAuxiEndIndex() {
        return this.auxiEndIndex_;
    }

    public int getAuxiStartIndex() {
        return this.auxiStartIndex_;
    }

    @Override // com.google.protobuf.micro.MessageMicro
    public int getCachedSize() {
        if (this.cachedSize < 0) {
            getSerializedSize();
        }
        return this.cachedSize;
    }

    public ByteStringMicro getContent() {
        return this.content_;
    }

    public int getMainEndIndex() {
        return this.mainEndIndex_;
    }

    public int getMainStartIndex() {
        return this.mainStartIndex_;
    }

    public int getMainTriggerDist() {
        return this.mainTriggerDist_;
    }

    public int getPointType() {
        return this.pointType_;
    }

    public int getRoadIndex() {
        return this.roadIndex_;
    }

    @Override // com.google.protobuf.micro.MessageMicro
    public int getSerializedSize() {
        int iComputeInt32Size = hasMainStartIndex() ? 0 + CodedOutputStreamMicro.computeInt32Size(1, getMainStartIndex()) : 0;
        if (hasMainEndIndex()) {
            iComputeInt32Size += CodedOutputStreamMicro.computeInt32Size(2, getMainEndIndex());
        }
        if (hasAuxiStartIndex()) {
            iComputeInt32Size += CodedOutputStreamMicro.computeInt32Size(3, getAuxiStartIndex());
        }
        if (hasAuxiEndIndex()) {
            iComputeInt32Size += CodedOutputStreamMicro.computeInt32Size(4, getAuxiEndIndex());
        }
        if (hasRoadIndex()) {
            iComputeInt32Size += CodedOutputStreamMicro.computeInt32Size(5, getRoadIndex());
        }
        if (hasMainTriggerDist()) {
            iComputeInt32Size += CodedOutputStreamMicro.computeInt32Size(6, getMainTriggerDist());
        }
        if (hasPointType()) {
            iComputeInt32Size += CodedOutputStreamMicro.computeInt32Size(7, getPointType());
        }
        if (hasContent()) {
            iComputeInt32Size += CodedOutputStreamMicro.computeBytesSize(8, getContent());
        }
        if (hasSubContent()) {
            iComputeInt32Size += CodedOutputStreamMicro.computeBytesSize(9, getSubContent());
        }
        this.cachedSize = iComputeInt32Size;
        return iComputeInt32Size;
    }

    public ByteStringMicro getSubContent() {
        return this.subContent_;
    }

    public boolean hasAuxiEndIndex() {
        return this.hasAuxiEndIndex;
    }

    public boolean hasAuxiStartIndex() {
        return this.hasAuxiStartIndex;
    }

    public boolean hasContent() {
        return this.hasContent;
    }

    public boolean hasMainEndIndex() {
        return this.hasMainEndIndex;
    }

    public boolean hasMainStartIndex() {
        return this.hasMainStartIndex;
    }

    public boolean hasMainTriggerDist() {
        return this.hasMainTriggerDist;
    }

    public boolean hasPointType() {
        return this.hasPointType;
    }

    public boolean hasRoadIndex() {
        return this.hasRoadIndex;
    }

    public boolean hasSubContent() {
        return this.hasSubContent;
    }

    public final boolean isInitialized() {
        return true;
    }

    @Override // com.google.protobuf.micro.MessageMicro
    public TransPanelPointPair mergeFrom(CodedInputStreamMicro codedInputStreamMicro) throws IOException {
        while (true) {
            int tag = codedInputStreamMicro.readTag();
            if (tag == 0) {
                return this;
            }
            if (tag == 8) {
                setMainStartIndex(codedInputStreamMicro.readInt32());
            } else if (tag == 16) {
                setMainEndIndex(codedInputStreamMicro.readInt32());
            } else if (tag == 24) {
                setAuxiStartIndex(codedInputStreamMicro.readInt32());
            } else if (tag == 32) {
                setAuxiEndIndex(codedInputStreamMicro.readInt32());
            } else if (tag == 40) {
                setRoadIndex(codedInputStreamMicro.readInt32());
            } else if (tag == 48) {
                setMainTriggerDist(codedInputStreamMicro.readInt32());
            } else if (tag == 56) {
                setPointType(codedInputStreamMicro.readInt32());
            } else if (tag == 66) {
                setContent(codedInputStreamMicro.readBytes());
            } else if (tag == 74) {
                setSubContent(codedInputStreamMicro.readBytes());
            } else if (!parseUnknownField(codedInputStreamMicro, tag)) {
                return this;
            }
        }
    }

    public TransPanelPointPair setAuxiEndIndex(int i) {
        this.hasAuxiEndIndex = true;
        this.auxiEndIndex_ = i;
        return this;
    }

    public TransPanelPointPair setAuxiStartIndex(int i) {
        this.hasAuxiStartIndex = true;
        this.auxiStartIndex_ = i;
        return this;
    }

    public TransPanelPointPair setContent(ByteStringMicro byteStringMicro) {
        this.hasContent = true;
        this.content_ = byteStringMicro;
        return this;
    }

    public TransPanelPointPair setMainEndIndex(int i) {
        this.hasMainEndIndex = true;
        this.mainEndIndex_ = i;
        return this;
    }

    public TransPanelPointPair setMainStartIndex(int i) {
        this.hasMainStartIndex = true;
        this.mainStartIndex_ = i;
        return this;
    }

    public TransPanelPointPair setMainTriggerDist(int i) {
        this.hasMainTriggerDist = true;
        this.mainTriggerDist_ = i;
        return this;
    }

    public TransPanelPointPair setPointType(int i) {
        this.hasPointType = true;
        this.pointType_ = i;
        return this;
    }

    public TransPanelPointPair setRoadIndex(int i) {
        this.hasRoadIndex = true;
        this.roadIndex_ = i;
        return this;
    }

    public TransPanelPointPair setSubContent(ByteStringMicro byteStringMicro) {
        this.hasSubContent = true;
        this.subContent_ = byteStringMicro;
        return this;
    }

    @Override // com.google.protobuf.micro.MessageMicro
    public void writeTo(CodedOutputStreamMicro codedOutputStreamMicro) throws IOException {
        if (hasMainStartIndex()) {
            codedOutputStreamMicro.writeInt32(1, getMainStartIndex());
        }
        if (hasMainEndIndex()) {
            codedOutputStreamMicro.writeInt32(2, getMainEndIndex());
        }
        if (hasAuxiStartIndex()) {
            codedOutputStreamMicro.writeInt32(3, getAuxiStartIndex());
        }
        if (hasAuxiEndIndex()) {
            codedOutputStreamMicro.writeInt32(4, getAuxiEndIndex());
        }
        if (hasRoadIndex()) {
            codedOutputStreamMicro.writeInt32(5, getRoadIndex());
        }
        if (hasMainTriggerDist()) {
            codedOutputStreamMicro.writeInt32(6, getMainTriggerDist());
        }
        if (hasPointType()) {
            codedOutputStreamMicro.writeInt32(7, getPointType());
        }
        if (hasContent()) {
            codedOutputStreamMicro.writeBytes(8, getContent());
        }
        if (hasSubContent()) {
            codedOutputStreamMicro.writeBytes(9, getSubContent());
        }
    }
}

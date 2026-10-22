package com.baidu.entity.pb;

import com.google.protobuf.micro.ByteStringMicro;
import com.google.protobuf.micro.CodedInputStreamMicro;
import com.google.protobuf.micro.CodedOutputStreamMicro;
import com.google.protobuf.micro.InvalidProtocolBufferMicroException;
import com.google.protobuf.micro.MessageMicro;
import java.io.IOException;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_10_7392cls.dex */
public final class TransVoiceInfo extends MessageMicro {
    public static final int CONTENT_BEG_FIELD_NUMBER = 5;
    public static final int CONTENT_END_FIELD_NUMBER = 6;
    public static final int DISTANCE_FIELD_NUMBER = 7;
    public static final int END_POINT_FIELD_NUMBER = 8;
    public static final int LINK_IDX_FIELD_NUMBER = 2;
    public static final int MIN_BROADCAST_DIST_FIELD_NUMBER = 4;
    public static final int OFFSET_FIELD_NUMBER = 1;
    public static final int POINT_FIELD_NUMBER = 3;
    private int cachedSize;
    private ByteStringMicro contentBeg_;
    private ByteStringMicro contentEnd_;
    private int distance_;
    private TransPanelPoint endPoint_;
    private boolean hasContentBeg;
    private boolean hasContentEnd;
    private boolean hasDistance;
    private boolean hasEndPoint;
    private boolean hasLinkIdx;
    private boolean hasMinBroadcastDist;
    private boolean hasOffset;
    private boolean hasPoint;
    private int offset_ = 0;
    private int linkIdx_ = 0;
    private TransPanelPoint point_ = null;
    private int minBroadcastDist_ = 0;

    public TransVoiceInfo() {
        ByteStringMicro byteStringMicro = ByteStringMicro.EMPTY;
        this.contentBeg_ = byteStringMicro;
        this.contentEnd_ = byteStringMicro;
        this.distance_ = 0;
        this.endPoint_ = null;
        this.cachedSize = -1;
    }

    public static TransVoiceInfo parseFrom(CodedInputStreamMicro codedInputStreamMicro) throws IOException {
        return new TransVoiceInfo().mergeFrom(codedInputStreamMicro);
    }

    public static TransVoiceInfo parseFrom(byte[] bArr) throws InvalidProtocolBufferMicroException {
        return (TransVoiceInfo) new TransVoiceInfo().mergeFrom(bArr);
    }

    public final TransVoiceInfo clear() {
        clearOffset();
        clearLinkIdx();
        clearPoint();
        clearMinBroadcastDist();
        clearContentBeg();
        clearContentEnd();
        clearDistance();
        clearEndPoint();
        this.cachedSize = -1;
        return this;
    }

    public TransVoiceInfo clearContentBeg() {
        this.hasContentBeg = false;
        this.contentBeg_ = ByteStringMicro.EMPTY;
        return this;
    }

    public TransVoiceInfo clearContentEnd() {
        this.hasContentEnd = false;
        this.contentEnd_ = ByteStringMicro.EMPTY;
        return this;
    }

    public TransVoiceInfo clearDistance() {
        this.hasDistance = false;
        this.distance_ = 0;
        return this;
    }

    public TransVoiceInfo clearEndPoint() {
        this.hasEndPoint = false;
        this.endPoint_ = null;
        return this;
    }

    public TransVoiceInfo clearLinkIdx() {
        this.hasLinkIdx = false;
        this.linkIdx_ = 0;
        return this;
    }

    public TransVoiceInfo clearMinBroadcastDist() {
        this.hasMinBroadcastDist = false;
        this.minBroadcastDist_ = 0;
        return this;
    }

    public TransVoiceInfo clearOffset() {
        this.hasOffset = false;
        this.offset_ = 0;
        return this;
    }

    public TransVoiceInfo clearPoint() {
        this.hasPoint = false;
        this.point_ = null;
        return this;
    }

    @Override // com.google.protobuf.micro.MessageMicro
    public int getCachedSize() {
        if (this.cachedSize < 0) {
            getSerializedSize();
        }
        return this.cachedSize;
    }

    public ByteStringMicro getContentBeg() {
        return this.contentBeg_;
    }

    public ByteStringMicro getContentEnd() {
        return this.contentEnd_;
    }

    public int getDistance() {
        return this.distance_;
    }

    public TransPanelPoint getEndPoint() {
        return this.endPoint_;
    }

    public int getLinkIdx() {
        return this.linkIdx_;
    }

    public int getMinBroadcastDist() {
        return this.minBroadcastDist_;
    }

    public int getOffset() {
        return this.offset_;
    }

    public TransPanelPoint getPoint() {
        return this.point_;
    }

    @Override // com.google.protobuf.micro.MessageMicro
    public int getSerializedSize() {
        int iComputeInt32Size = hasOffset() ? 0 + CodedOutputStreamMicro.computeInt32Size(1, getOffset()) : 0;
        if (hasLinkIdx()) {
            iComputeInt32Size += CodedOutputStreamMicro.computeInt32Size(2, getLinkIdx());
        }
        if (hasPoint()) {
            iComputeInt32Size += CodedOutputStreamMicro.computeMessageSize(3, getPoint());
        }
        if (hasMinBroadcastDist()) {
            iComputeInt32Size += CodedOutputStreamMicro.computeInt32Size(4, getMinBroadcastDist());
        }
        if (hasContentBeg()) {
            iComputeInt32Size += CodedOutputStreamMicro.computeBytesSize(5, getContentBeg());
        }
        if (hasContentEnd()) {
            iComputeInt32Size += CodedOutputStreamMicro.computeBytesSize(6, getContentEnd());
        }
        if (hasDistance()) {
            iComputeInt32Size += CodedOutputStreamMicro.computeInt32Size(7, getDistance());
        }
        if (hasEndPoint()) {
            iComputeInt32Size += CodedOutputStreamMicro.computeMessageSize(8, getEndPoint());
        }
        this.cachedSize = iComputeInt32Size;
        return iComputeInt32Size;
    }

    public boolean hasContentBeg() {
        return this.hasContentBeg;
    }

    public boolean hasContentEnd() {
        return this.hasContentEnd;
    }

    public boolean hasDistance() {
        return this.hasDistance;
    }

    public boolean hasEndPoint() {
        return this.hasEndPoint;
    }

    public boolean hasLinkIdx() {
        return this.hasLinkIdx;
    }

    public boolean hasMinBroadcastDist() {
        return this.hasMinBroadcastDist;
    }

    public boolean hasOffset() {
        return this.hasOffset;
    }

    public boolean hasPoint() {
        return this.hasPoint;
    }

    public final boolean isInitialized() {
        if (!hasPoint() || getPoint().isInitialized()) {
            return !hasEndPoint() || getEndPoint().isInitialized();
        }
        return false;
    }

    @Override // com.google.protobuf.micro.MessageMicro
    public TransVoiceInfo mergeFrom(CodedInputStreamMicro codedInputStreamMicro) throws IOException {
        while (true) {
            int tag = codedInputStreamMicro.readTag();
            if (tag == 0) {
                return this;
            }
            if (tag == 8) {
                setOffset(codedInputStreamMicro.readInt32());
            } else if (tag == 16) {
                setLinkIdx(codedInputStreamMicro.readInt32());
            } else if (tag == 26) {
                TransPanelPoint transPanelPoint = new TransPanelPoint();
                codedInputStreamMicro.readMessage(transPanelPoint);
                setPoint(transPanelPoint);
            } else if (tag == 32) {
                setMinBroadcastDist(codedInputStreamMicro.readInt32());
            } else if (tag == 42) {
                setContentBeg(codedInputStreamMicro.readBytes());
            } else if (tag == 50) {
                setContentEnd(codedInputStreamMicro.readBytes());
            } else if (tag == 56) {
                setDistance(codedInputStreamMicro.readInt32());
            } else if (tag == 66) {
                TransPanelPoint transPanelPoint2 = new TransPanelPoint();
                codedInputStreamMicro.readMessage(transPanelPoint2);
                setEndPoint(transPanelPoint2);
            } else if (!parseUnknownField(codedInputStreamMicro, tag)) {
                return this;
            }
        }
    }

    public TransVoiceInfo setContentBeg(ByteStringMicro byteStringMicro) {
        this.hasContentBeg = true;
        this.contentBeg_ = byteStringMicro;
        return this;
    }

    public TransVoiceInfo setContentEnd(ByteStringMicro byteStringMicro) {
        this.hasContentEnd = true;
        this.contentEnd_ = byteStringMicro;
        return this;
    }

    public TransVoiceInfo setDistance(int i) {
        this.hasDistance = true;
        this.distance_ = i;
        return this;
    }

    public TransVoiceInfo setEndPoint(TransPanelPoint transPanelPoint) {
        if (transPanelPoint == null) {
            return clearEndPoint();
        }
        this.hasEndPoint = true;
        this.endPoint_ = transPanelPoint;
        return this;
    }

    public TransVoiceInfo setLinkIdx(int i) {
        this.hasLinkIdx = true;
        this.linkIdx_ = i;
        return this;
    }

    public TransVoiceInfo setMinBroadcastDist(int i) {
        this.hasMinBroadcastDist = true;
        this.minBroadcastDist_ = i;
        return this;
    }

    public TransVoiceInfo setOffset(int i) {
        this.hasOffset = true;
        this.offset_ = i;
        return this;
    }

    public TransVoiceInfo setPoint(TransPanelPoint transPanelPoint) {
        if (transPanelPoint == null) {
            return clearPoint();
        }
        this.hasPoint = true;
        this.point_ = transPanelPoint;
        return this;
    }

    @Override // com.google.protobuf.micro.MessageMicro
    public void writeTo(CodedOutputStreamMicro codedOutputStreamMicro) throws IOException {
        if (hasOffset()) {
            codedOutputStreamMicro.writeInt32(1, getOffset());
        }
        if (hasLinkIdx()) {
            codedOutputStreamMicro.writeInt32(2, getLinkIdx());
        }
        if (hasPoint()) {
            codedOutputStreamMicro.writeMessage(3, getPoint());
        }
        if (hasMinBroadcastDist()) {
            codedOutputStreamMicro.writeInt32(4, getMinBroadcastDist());
        }
        if (hasContentBeg()) {
            codedOutputStreamMicro.writeBytes(5, getContentBeg());
        }
        if (hasContentEnd()) {
            codedOutputStreamMicro.writeBytes(6, getContentEnd());
        }
        if (hasDistance()) {
            codedOutputStreamMicro.writeInt32(7, getDistance());
        }
        if (hasEndPoint()) {
            codedOutputStreamMicro.writeMessage(8, getEndPoint());
        }
    }
}

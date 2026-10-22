package com.baidu.location.pb;

import com.google.protobuf.micro.ByteStringMicro;
import com.google.protobuf.micro.CodedInputStreamMicro;
import com.google.protobuf.micro.CodedOutputStreamMicro;
import com.google.protobuf.micro.InvalidProtocolBufferMicroException;
import com.google.protobuf.micro.MessageMicro;
import java.io.IOException;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_10_7392cls.dex */
public final class OffDataReq extends MessageMicro {
    public static final int AK_FIELD_NUMBER = 2;
    public static final int CLIENT_INFO_FIELD_NUMBER = 6;
    public static final int CU_FIELD_NUMBER = 1;
    public static final int GK_FIELD_NUMBER = 5;
    public static final int SN_FIELD_NUMBER = 3;
    public static final int VKEY_FIELD_NUMBER = 4;
    private ByteStringMicro ak_;
    private int cachedSize;
    private ByteStringMicro clientInfo_;
    private ByteStringMicro cu_;
    private GridKey gk_;
    private boolean hasAk;
    private boolean hasClientInfo;
    private boolean hasCu;
    private boolean hasGk;
    private boolean hasSn;
    private boolean hasVkey;
    private ByteStringMicro sn_;
    private ByteStringMicro vkey_;

    public OffDataReq() {
        ByteStringMicro byteStringMicro = ByteStringMicro.EMPTY;
        this.cu_ = byteStringMicro;
        this.ak_ = byteStringMicro;
        this.sn_ = byteStringMicro;
        this.vkey_ = byteStringMicro;
        this.gk_ = null;
        this.clientInfo_ = byteStringMicro;
        this.cachedSize = -1;
    }

    public static OffDataReq parseFrom(CodedInputStreamMicro codedInputStreamMicro) throws IOException {
        return new OffDataReq().mergeFrom(codedInputStreamMicro);
    }

    public static OffDataReq parseFrom(byte[] bArr) throws InvalidProtocolBufferMicroException {
        return (OffDataReq) new OffDataReq().mergeFrom(bArr);
    }

    public final OffDataReq clear() {
        clearCu();
        clearAk();
        clearSn();
        clearVkey();
        clearGk();
        clearClientInfo();
        this.cachedSize = -1;
        return this;
    }

    public OffDataReq clearAk() {
        this.hasAk = false;
        this.ak_ = ByteStringMicro.EMPTY;
        return this;
    }

    public OffDataReq clearClientInfo() {
        this.hasClientInfo = false;
        this.clientInfo_ = ByteStringMicro.EMPTY;
        return this;
    }

    public OffDataReq clearCu() {
        this.hasCu = false;
        this.cu_ = ByteStringMicro.EMPTY;
        return this;
    }

    public OffDataReq clearGk() {
        this.hasGk = false;
        this.gk_ = null;
        return this;
    }

    public OffDataReq clearSn() {
        this.hasSn = false;
        this.sn_ = ByteStringMicro.EMPTY;
        return this;
    }

    public OffDataReq clearVkey() {
        this.hasVkey = false;
        this.vkey_ = ByteStringMicro.EMPTY;
        return this;
    }

    public ByteStringMicro getAk() {
        return this.ak_;
    }

    @Override // com.google.protobuf.micro.MessageMicro
    public int getCachedSize() {
        if (this.cachedSize < 0) {
            getSerializedSize();
        }
        return this.cachedSize;
    }

    public ByteStringMicro getClientInfo() {
        return this.clientInfo_;
    }

    public ByteStringMicro getCu() {
        return this.cu_;
    }

    public GridKey getGk() {
        return this.gk_;
    }

    @Override // com.google.protobuf.micro.MessageMicro
    public int getSerializedSize() {
        int iComputeBytesSize = hasCu() ? 0 + CodedOutputStreamMicro.computeBytesSize(1, getCu()) : 0;
        if (hasAk()) {
            iComputeBytesSize += CodedOutputStreamMicro.computeBytesSize(2, getAk());
        }
        if (hasSn()) {
            iComputeBytesSize += CodedOutputStreamMicro.computeBytesSize(3, getSn());
        }
        if (hasVkey()) {
            iComputeBytesSize += CodedOutputStreamMicro.computeBytesSize(4, getVkey());
        }
        if (hasGk()) {
            iComputeBytesSize += CodedOutputStreamMicro.computeMessageSize(5, getGk());
        }
        if (hasClientInfo()) {
            iComputeBytesSize += CodedOutputStreamMicro.computeBytesSize(6, getClientInfo());
        }
        this.cachedSize = iComputeBytesSize;
        return iComputeBytesSize;
    }

    public ByteStringMicro getSn() {
        return this.sn_;
    }

    public ByteStringMicro getVkey() {
        return this.vkey_;
    }

    public boolean hasAk() {
        return this.hasAk;
    }

    public boolean hasClientInfo() {
        return this.hasClientInfo;
    }

    public boolean hasCu() {
        return this.hasCu;
    }

    public boolean hasGk() {
        return this.hasGk;
    }

    public boolean hasSn() {
        return this.hasSn;
    }

    public boolean hasVkey() {
        return this.hasVkey;
    }

    public final boolean isInitialized() {
        return true;
    }

    @Override // com.google.protobuf.micro.MessageMicro
    public OffDataReq mergeFrom(CodedInputStreamMicro codedInputStreamMicro) throws IOException {
        while (true) {
            int tag = codedInputStreamMicro.readTag();
            if (tag == 0) {
                return this;
            }
            if (tag == 10) {
                setCu(codedInputStreamMicro.readBytes());
            } else if (tag == 18) {
                setAk(codedInputStreamMicro.readBytes());
            } else if (tag == 26) {
                setSn(codedInputStreamMicro.readBytes());
            } else if (tag == 34) {
                setVkey(codedInputStreamMicro.readBytes());
            } else if (tag == 42) {
                GridKey gridKey = new GridKey();
                codedInputStreamMicro.readMessage(gridKey);
                setGk(gridKey);
            } else if (tag == 50) {
                setClientInfo(codedInputStreamMicro.readBytes());
            } else if (!parseUnknownField(codedInputStreamMicro, tag)) {
                return this;
            }
        }
    }

    public OffDataReq setAk(ByteStringMicro byteStringMicro) {
        this.hasAk = true;
        this.ak_ = byteStringMicro;
        return this;
    }

    public OffDataReq setClientInfo(ByteStringMicro byteStringMicro) {
        this.hasClientInfo = true;
        this.clientInfo_ = byteStringMicro;
        return this;
    }

    public OffDataReq setCu(ByteStringMicro byteStringMicro) {
        this.hasCu = true;
        this.cu_ = byteStringMicro;
        return this;
    }

    public OffDataReq setGk(GridKey gridKey) {
        if (gridKey == null) {
            return clearGk();
        }
        this.hasGk = true;
        this.gk_ = gridKey;
        return this;
    }

    public OffDataReq setSn(ByteStringMicro byteStringMicro) {
        this.hasSn = true;
        this.sn_ = byteStringMicro;
        return this;
    }

    public OffDataReq setVkey(ByteStringMicro byteStringMicro) {
        this.hasVkey = true;
        this.vkey_ = byteStringMicro;
        return this;
    }

    @Override // com.google.protobuf.micro.MessageMicro
    public void writeTo(CodedOutputStreamMicro codedOutputStreamMicro) throws IOException {
        if (hasCu()) {
            codedOutputStreamMicro.writeBytes(1, getCu());
        }
        if (hasAk()) {
            codedOutputStreamMicro.writeBytes(2, getAk());
        }
        if (hasSn()) {
            codedOutputStreamMicro.writeBytes(3, getSn());
        }
        if (hasVkey()) {
            codedOutputStreamMicro.writeBytes(4, getVkey());
        }
        if (hasGk()) {
            codedOutputStreamMicro.writeMessage(5, getGk());
        }
        if (hasClientInfo()) {
            codedOutputStreamMicro.writeBytes(6, getClientInfo());
        }
    }
}

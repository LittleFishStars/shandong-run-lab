package com.baidu.location.pb;

import com.google.protobuf.micro.CodedInputStreamMicro;
import com.google.protobuf.micro.CodedOutputStreamMicro;
import com.google.protobuf.micro.InvalidProtocolBufferMicroException;
import com.google.protobuf.micro.MessageMicro;
import java.io.IOException;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_10_7392cls.dex */
public final class DataValue extends MessageMicro {
    public static final int CL_FIELD_NUMBER = 4;
    public static final int COM_LOC_FIELD_NUMBER = 6;
    public static final int KEY_FIELD_NUMBER = 1;
    public static final int LOC_FIELD_NUMBER = 2;
    public static final int RES_FIELD_NUMBER = 5;
    public static final int R_FIELD_NUMBER = 3;
    private boolean hasCl;
    private boolean hasComLoc;
    private boolean hasKey;
    private boolean hasLoc;
    private boolean hasR;
    private boolean hasRes;
    private long key_ = 0;
    private Loc loc_ = null;
    private int r_ = 0;
    private int cl_ = 0;
    private long res_ = 0;
    private int comLoc_ = 0;
    private int cachedSize = -1;

    public static DataValue parseFrom(CodedInputStreamMicro codedInputStreamMicro) throws IOException {
        return new DataValue().mergeFrom(codedInputStreamMicro);
    }

    public static DataValue parseFrom(byte[] bArr) throws InvalidProtocolBufferMicroException {
        return (DataValue) new DataValue().mergeFrom(bArr);
    }

    public final DataValue clear() {
        clearKey();
        clearLoc();
        clearR();
        clearCl();
        clearRes();
        clearComLoc();
        this.cachedSize = -1;
        return this;
    }

    public DataValue clearCl() {
        this.hasCl = false;
        this.cl_ = 0;
        return this;
    }

    public DataValue clearComLoc() {
        this.hasComLoc = false;
        this.comLoc_ = 0;
        return this;
    }

    public DataValue clearKey() {
        this.hasKey = false;
        this.key_ = 0L;
        return this;
    }

    public DataValue clearLoc() {
        this.hasLoc = false;
        this.loc_ = null;
        return this;
    }

    public DataValue clearR() {
        this.hasR = false;
        this.r_ = 0;
        return this;
    }

    public DataValue clearRes() {
        this.hasRes = false;
        this.res_ = 0L;
        return this;
    }

    @Override // com.google.protobuf.micro.MessageMicro
    public int getCachedSize() {
        if (this.cachedSize < 0) {
            getSerializedSize();
        }
        return this.cachedSize;
    }

    public int getCl() {
        return this.cl_;
    }

    public int getComLoc() {
        return this.comLoc_;
    }

    public long getKey() {
        return this.key_;
    }

    public Loc getLoc() {
        return this.loc_;
    }

    public int getR() {
        return this.r_;
    }

    public long getRes() {
        return this.res_;
    }

    @Override // com.google.protobuf.micro.MessageMicro
    public int getSerializedSize() {
        int iComputeInt64Size = hasKey() ? 0 + CodedOutputStreamMicro.computeInt64Size(1, getKey()) : 0;
        if (hasLoc()) {
            iComputeInt64Size += CodedOutputStreamMicro.computeMessageSize(2, getLoc());
        }
        if (hasR()) {
            iComputeInt64Size += CodedOutputStreamMicro.computeInt32Size(3, getR());
        }
        if (hasCl()) {
            iComputeInt64Size += CodedOutputStreamMicro.computeInt32Size(4, getCl());
        }
        if (hasRes()) {
            iComputeInt64Size += CodedOutputStreamMicro.computeInt64Size(5, getRes());
        }
        if (hasComLoc()) {
            iComputeInt64Size += CodedOutputStreamMicro.computeUInt32Size(6, getComLoc());
        }
        this.cachedSize = iComputeInt64Size;
        return iComputeInt64Size;
    }

    public boolean hasCl() {
        return this.hasCl;
    }

    public boolean hasComLoc() {
        return this.hasComLoc;
    }

    public boolean hasKey() {
        return this.hasKey;
    }

    public boolean hasLoc() {
        return this.hasLoc;
    }

    public boolean hasR() {
        return this.hasR;
    }

    public boolean hasRes() {
        return this.hasRes;
    }

    public final boolean isInitialized() {
        return true;
    }

    @Override // com.google.protobuf.micro.MessageMicro
    public DataValue mergeFrom(CodedInputStreamMicro codedInputStreamMicro) throws IOException {
        while (true) {
            int tag = codedInputStreamMicro.readTag();
            if (tag == 0) {
                return this;
            }
            if (tag == 8) {
                setKey(codedInputStreamMicro.readInt64());
            } else if (tag == 18) {
                Loc loc = new Loc();
                codedInputStreamMicro.readMessage(loc);
                setLoc(loc);
            } else if (tag == 24) {
                setR(codedInputStreamMicro.readInt32());
            } else if (tag == 32) {
                setCl(codedInputStreamMicro.readInt32());
            } else if (tag == 40) {
                setRes(codedInputStreamMicro.readInt64());
            } else if (tag == 48) {
                setComLoc(codedInputStreamMicro.readUInt32());
            } else if (!parseUnknownField(codedInputStreamMicro, tag)) {
                return this;
            }
        }
    }

    public DataValue setCl(int i) {
        this.hasCl = true;
        this.cl_ = i;
        return this;
    }

    public DataValue setComLoc(int i) {
        this.hasComLoc = true;
        this.comLoc_ = i;
        return this;
    }

    public DataValue setKey(long j) {
        this.hasKey = true;
        this.key_ = j;
        return this;
    }

    public DataValue setLoc(Loc loc) {
        if (loc == null) {
            return clearLoc();
        }
        this.hasLoc = true;
        this.loc_ = loc;
        return this;
    }

    public DataValue setR(int i) {
        this.hasR = true;
        this.r_ = i;
        return this;
    }

    public DataValue setRes(long j) {
        this.hasRes = true;
        this.res_ = j;
        return this;
    }

    @Override // com.google.protobuf.micro.MessageMicro
    public void writeTo(CodedOutputStreamMicro codedOutputStreamMicro) throws IOException {
        if (hasKey()) {
            codedOutputStreamMicro.writeInt64(1, getKey());
        }
        if (hasLoc()) {
            codedOutputStreamMicro.writeMessage(2, getLoc());
        }
        if (hasR()) {
            codedOutputStreamMicro.writeInt32(3, getR());
        }
        if (hasCl()) {
            codedOutputStreamMicro.writeInt32(4, getCl());
        }
        if (hasRes()) {
            codedOutputStreamMicro.writeInt64(5, getRes());
        }
        if (hasComLoc()) {
            codedOutputStreamMicro.writeUInt32(6, getComLoc());
        }
    }
}

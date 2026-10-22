package com.baidu.entity.pb;

import com.google.protobuf.micro.CodedInputStreamMicro;
import com.google.protobuf.micro.CodedOutputStreamMicro;
import com.google.protobuf.micro.InvalidProtocolBufferMicroException;
import com.google.protobuf.micro.MessageMicro;
import java.io.IOException;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_10_7392cls.dex */
public final class CloudDataBase extends MessageMicro {
    public static final int DATA_ID_FIELD_NUMBER = 1;
    private boolean hasDataId;
    private long dataId_ = 0;
    private int cachedSize = -1;

    public static CloudDataBase parseFrom(CodedInputStreamMicro codedInputStreamMicro) throws IOException {
        return new CloudDataBase().mergeFrom(codedInputStreamMicro);
    }

    public static CloudDataBase parseFrom(byte[] bArr) throws InvalidProtocolBufferMicroException {
        return (CloudDataBase) new CloudDataBase().mergeFrom(bArr);
    }

    public final CloudDataBase clear() {
        clearDataId();
        this.cachedSize = -1;
        return this;
    }

    public CloudDataBase clearDataId() {
        this.hasDataId = false;
        this.dataId_ = 0L;
        return this;
    }

    @Override // com.google.protobuf.micro.MessageMicro
    public int getCachedSize() {
        if (this.cachedSize < 0) {
            getSerializedSize();
        }
        return this.cachedSize;
    }

    public long getDataId() {
        return this.dataId_;
    }

    @Override // com.google.protobuf.micro.MessageMicro
    public int getSerializedSize() {
        int iComputeUInt64Size = hasDataId() ? 0 + CodedOutputStreamMicro.computeUInt64Size(1, getDataId()) : 0;
        this.cachedSize = iComputeUInt64Size;
        return iComputeUInt64Size;
    }

    public boolean hasDataId() {
        return this.hasDataId;
    }

    public final boolean isInitialized() {
        return true;
    }

    @Override // com.google.protobuf.micro.MessageMicro
    public CloudDataBase mergeFrom(CodedInputStreamMicro codedInputStreamMicro) throws IOException {
        while (true) {
            int tag = codedInputStreamMicro.readTag();
            if (tag == 0) {
                return this;
            }
            if (tag == 8) {
                setDataId(codedInputStreamMicro.readUInt64());
            } else if (!parseUnknownField(codedInputStreamMicro, tag)) {
                return this;
            }
        }
    }

    public CloudDataBase setDataId(long j) {
        this.hasDataId = true;
        this.dataId_ = j;
        return this;
    }

    @Override // com.google.protobuf.micro.MessageMicro
    public void writeTo(CodedOutputStreamMicro codedOutputStreamMicro) throws IOException {
        if (hasDataId()) {
            codedOutputStreamMicro.writeUInt64(1, getDataId());
        }
    }
}

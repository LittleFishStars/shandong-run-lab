package com.google.protobuf.micro;

import java.io.IOException;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_03_8012cls.dex */
public abstract class MessageMicro {
    public abstract int getCachedSize();

    public abstract int getSerializedSize();

    public abstract MessageMicro mergeFrom(CodedInputStreamMicro codedInputStreamMicro) throws IOException;

    public MessageMicro mergeFrom(byte[] bArr) throws InvalidProtocolBufferMicroException {
        return mergeFrom(bArr, 0, bArr.length);
    }

    public boolean parseUnknownField(CodedInputStreamMicro codedInputStreamMicro, int i) throws IOException {
        return codedInputStreamMicro.skipField(i);
    }

    public byte[] toByteArray() {
        int serializedSize = getSerializedSize();
        byte[] bArr = new byte[serializedSize];
        toByteArray(bArr, 0, serializedSize);
        return bArr;
    }

    public abstract void writeTo(CodedOutputStreamMicro codedOutputStreamMicro) throws IOException;

    public MessageMicro mergeFrom(byte[] bArr, int i, int i2) throws InvalidProtocolBufferMicroException {
        try {
            CodedInputStreamMicro codedInputStreamMicroNewInstance = CodedInputStreamMicro.newInstance(bArr, i, i2);
            mergeFrom(codedInputStreamMicroNewInstance);
            codedInputStreamMicroNewInstance.checkLastTagWas(0);
            return this;
        } catch (InvalidProtocolBufferMicroException e) {
            throw e;
        } catch (IOException unused) {
            throw new RuntimeException("Reading from a byte array threw an IOException (should never happen).");
        }
    }

    public void toByteArray(byte[] bArr, int i, int i2) {
        try {
            CodedOutputStreamMicro codedOutputStreamMicroNewInstance = CodedOutputStreamMicro.newInstance(bArr, i, i2);
            writeTo(codedOutputStreamMicroNewInstance);
            codedOutputStreamMicroNewInstance.checkNoSpaceLeft();
        } catch (IOException unused) {
            throw new RuntimeException("Serializing to a byte array threw an IOException (should never happen).");
        }
    }
}

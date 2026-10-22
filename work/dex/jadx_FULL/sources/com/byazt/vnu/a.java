package com.byazt.vnu;

import com.hzchengdun.securityguard.SecExceptionCode;
import java.io.DataInput;
import java.io.IOException;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_11_8719cls.dex */
@com.byazt.zqa.c(c = {0, 1, SecExceptionCode.SEC_ERROR_SIGNATRUE_UNKNOWN, 34})
public abstract class a implements DataInput {
    public final i c;

    public a(i iVar) {
        this.c = iVar;
    }

    @Override // java.io.DataInput
    public boolean readBoolean() throws IOException {
        return this.c.readBoolean();
    }

    @Override // java.io.DataInput
    public byte readByte() throws IOException {
        return this.c.readByte();
    }

    @Override // java.io.DataInput
    public char readChar() throws IOException {
        return this.c.readChar();
    }

    @Override // java.io.DataInput
    public double readDouble() throws IOException {
        return this.c.readDouble();
    }

    @Override // java.io.DataInput
    public float readFloat() throws IOException {
        return this.c.readFloat();
    }

    @Override // java.io.DataInput
    public void readFully(byte[] bArr, int i, int i2) throws IOException {
        this.c.readFully(bArr, i, i2);
    }

    @Override // java.io.DataInput
    public int readInt() throws IOException {
        return this.c.readInt();
    }

    @Override // java.io.DataInput
    public String readLine() throws IOException {
        return this.c.readLine();
    }

    @Override // java.io.DataInput
    public long readLong() throws IOException {
        return this.c.readLong();
    }

    @Override // java.io.DataInput
    public short readShort() throws IOException {
        return this.c.readShort();
    }

    @Override // java.io.DataInput
    public String readUTF() throws IOException {
        return this.c.readUTF();
    }

    @Override // java.io.DataInput
    public int readUnsignedByte() throws IOException {
        return this.c.readUnsignedByte();
    }

    @Override // java.io.DataInput
    public int readUnsignedShort() throws IOException {
        return this.c.readUnsignedShort();
    }

    @Override // java.io.DataInput
    public int skipBytes(int i) throws IOException {
        return this.c.skipBytes(i);
    }

    @Override // java.io.DataInput
    public void readFully(byte[] bArr) throws IOException {
        this.c.readFully(bArr);
    }
}

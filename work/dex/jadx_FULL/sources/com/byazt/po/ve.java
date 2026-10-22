package com.byazt.po;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.io.RandomAccessFile;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_11_8719cls.dex */
@com.byazt.zqa.c(c = {0, 1, 1403, 54})
public class ve {
    public final byte[] c = new byte[2];
    public final byte[] tt = new byte[4];

    public int c(RandomAccessFile randomAccessFile) throws IOException {
        randomAccessFile.readFully(this.tt);
        return tt(this.tt);
    }

    public int tt(RandomAccessFile randomAccessFile) throws IOException {
        randomAccessFile.readFully(this.c);
        return c(this.c);
    }

    private int tt(byte[] bArr) {
        return ((((bArr[3] & 255) << 8) | (bArr[2] & 255)) << 16) | (bArr[0] & 255) | ((bArr[1] & 255) << 8);
    }

    public void c(RandomAccessFile randomAccessFile, int i) throws IOException {
        c(this.c, i);
        randomAccessFile.write(this.c);
    }

    private void tt(byte[] bArr, int i) {
        bArr[3] = (byte) (i >>> 24);
        bArr[2] = (byte) (i >>> 16);
        bArr[1] = (byte) (i >>> 8);
        bArr[0] = (byte) (i & 255);
    }

    public void c(ByteArrayOutputStream byteArrayOutputStream, int i) throws IOException {
        c(this.c, i);
        byteArrayOutputStream.write(this.c);
    }

    public void c(OutputStream outputStream, int i) throws IOException {
        tt(this.tt, i);
        outputStream.write(this.tt);
    }

    private int c(byte[] bArr) {
        return ((bArr[1] & 255) << 8) | (bArr[0] & 255);
    }

    private void c(byte[] bArr, int i) {
        bArr[1] = (byte) (i >>> 8);
        bArr[0] = (byte) (i & 255);
    }
}

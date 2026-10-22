package com.zj.adlib;

import java.io.ByteArrayOutputStream;
import java.io.EOFException;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Arrays;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_08_10593cls.dex */
public final class s51 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final int f44612a = 4096;

    public static final class b extends ByteArrayOutputStream {
        public b() {
        }

        public void a(byte[] bArr, int i) {
            System.arraycopy(((ByteArrayOutputStream) this).buf, 0, bArr, i, ((ByteArrayOutputStream) this).count);
        }
    }

    public static long a(InputStream inputStream, OutputStream outputStream) throws IOException {
        ax6.i(inputStream);
        ax6.i(outputStream);
        byte[] bArr = new byte[4096];
        long j = 0;
        while (true) {
            int i = inputStream.read(bArr);
            if (i == -1) {
                return j;
            }
            outputStream.write(bArr, 0, i);
            j += (long) i;
        }
    }

    public static int b(InputStream inputStream, byte[] bArr, int i, int i2) throws IOException {
        ax6.i(inputStream);
        ax6.i(bArr);
        if (i2 < 0) {
            throw new IndexOutOfBoundsException("len is negative");
        }
        int i3 = 0;
        while (i3 < i2) {
            int i4 = inputStream.read(bArr, i + i3, i2 - i3);
            if (i4 == -1) {
                break;
            }
            i3 += i4;
        }
        return i3;
    }

    public static void c(InputStream inputStream, byte[] bArr, int i, int i2) throws IOException {
        int iB = b(inputStream, bArr, i, i2);
        if (iB == i2) {
            return;
        }
        throw new EOFException("reached end of stream after reading " + iB + " bytes; " + i2 + " bytes expected");
    }

    public static byte[] d(InputStream inputStream) throws IOException {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        a(inputStream, byteArrayOutputStream);
        return byteArrayOutputStream.toByteArray();
    }

    public static byte[] e(InputStream inputStream, int i) throws IOException {
        byte[] bArr = new byte[i];
        int i2 = i;
        while (i2 > 0) {
            int i3 = i - i2;
            int i4 = inputStream.read(bArr, i3, i2);
            if (i4 == -1) {
                return Arrays.copyOf(bArr, i3);
            }
            i2 -= i4;
        }
        int i5 = inputStream.read();
        if (i5 == -1) {
            return bArr;
        }
        b bVar = new b();
        bVar.write(i5);
        a(inputStream, bVar);
        byte[] bArr2 = new byte[bVar.size() + i];
        System.arraycopy(bArr, 0, bArr2, 0, i);
        bVar.a(bArr2, i);
        return bArr2;
    }
}

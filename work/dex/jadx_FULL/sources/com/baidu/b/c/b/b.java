package com.baidu.b.c.b;

import com.alibaba.ariver.resource.parser.a.e;
import com.zj.adlib.aq6;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.IntBuffer;
import java.security.GeneralSecurityException;
import java.util.Random;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_10_7392cls.dex */
public class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final int[] f26284a = a(new byte[]{101, aq6.f40585a, 112, 97, 110, 100, 32, e.l, e.k, com.google.android.exoplayer2.text.cea.a.n, 98, 121, 116, 101, 32, 107});
    private final int b;

    public b(int i) {
        this.b = i;
    }

    private static int a(int i, int i2) {
        return (i >>> (-i2)) | (i << i2);
    }

    private void a(byte[] bArr, byte[] bArr2, ByteBuffer byteBuffer, ByteBuffer byteBuffer2) throws GeneralSecurityException {
        int iRemaining = byteBuffer2.remaining();
        int i = (iRemaining / 64) + 1;
        for (int i2 = 0; i2 < i; i2++) {
            ByteBuffer byteBufferA = a(bArr, bArr2, this.b + i2);
            if (i2 == i - 1) {
                a.a(byteBuffer, byteBuffer2, byteBufferA, iRemaining % 64);
            } else {
                a.a(byteBuffer, byteBuffer2, byteBufferA, 64);
            }
        }
    }

    public static void a(int[] iArr) {
        for (int i = 0; i < 10; i++) {
            a(iArr, 0, 4, 8, 12);
            a(iArr, 1, 5, 9, 13);
            a(iArr, 2, 6, 10, 14);
            a(iArr, 3, 7, 11, 15);
            a(iArr, 0, 5, 10, 15);
            a(iArr, 1, 6, 11, 12);
            a(iArr, 2, 7, 8, 13);
            a(iArr, 3, 4, 9, 14);
        }
    }

    public static void a(int[] iArr, int i, int i2, int i3, int i4) {
        int i5 = iArr[i] + iArr[i2];
        iArr[i] = i5;
        int iA = a(i5 ^ iArr[i4], 16);
        iArr[i4] = iA;
        int i6 = iArr[i3] + iA;
        iArr[i3] = i6;
        int iA2 = a(iArr[i2] ^ i6, 12);
        iArr[i2] = iA2;
        int i7 = iArr[i] + iA2;
        iArr[i] = i7;
        int iA3 = a(iArr[i4] ^ i7, 8);
        iArr[i4] = iA3;
        int i8 = iArr[i3] + iA3;
        iArr[i3] = i8;
        iArr[i2] = a(iArr[i2] ^ i8, 7);
    }

    public static void a(int[] iArr, int[] iArr2) {
        int[] iArr3 = f26284a;
        System.arraycopy(iArr3, 0, iArr, 0, iArr3.length);
        System.arraycopy(iArr2, 0, iArr, iArr3.length, 8);
    }

    public static int[] a(byte[] bArr) {
        IntBuffer intBufferAsIntBuffer = ByteBuffer.wrap(bArr).order(ByteOrder.LITTLE_ENDIAN).asIntBuffer();
        int[] iArr = new int[intBufferAsIntBuffer.remaining()];
        intBufferAsIntBuffer.get(iArr);
        return iArr;
    }

    public int a() {
        return 12;
    }

    public ByteBuffer a(byte[] bArr, byte[] bArr2, int i) {
        int[] iArrA = a(a(bArr), a(bArr2), i);
        int[] iArr = (int[]) iArrA.clone();
        a(iArr);
        for (int i2 = 0; i2 < iArrA.length; i2++) {
            iArrA[i2] = iArrA[i2] + iArr[i2];
        }
        ByteBuffer byteBufferOrder = ByteBuffer.allocate(64).order(ByteOrder.LITTLE_ENDIAN);
        byteBufferOrder.asIntBuffer().put(iArrA, 0, 16);
        return byteBufferOrder;
    }

    public void a(ByteBuffer byteBuffer, byte[] bArr, byte[] bArr2) throws GeneralSecurityException {
        if (byteBuffer.remaining() - a() < bArr.length) {
            throw new IllegalArgumentException("data output is too small");
        }
        if (bArr2 == null) {
            bArr2 = new byte[a()];
            new Random().nextBytes(bArr2);
        }
        byteBuffer.put(bArr2);
        a(bArr2, com.baidu.b.c.c.b.a(), byteBuffer, ByteBuffer.wrap(bArr));
    }

    public byte[] a(ByteBuffer byteBuffer) throws GeneralSecurityException {
        if (byteBuffer.remaining() < a()) {
            throw new GeneralSecurityException("data too short");
        }
        byte[] bArr = new byte[a()];
        byteBuffer.get(bArr);
        ByteBuffer byteBufferAllocate = ByteBuffer.allocate(byteBuffer.remaining());
        a(bArr, com.baidu.b.c.c.b.b(), byteBufferAllocate, byteBuffer);
        return byteBufferAllocate.array();
    }

    public byte[] a(byte[] bArr, byte[] bArr2) throws GeneralSecurityException {
        if (bArr.length > Integer.MAX_VALUE - a()) {
            throw new GeneralSecurityException("data too long");
        }
        ByteBuffer byteBufferAllocate = ByteBuffer.allocate(a() + bArr.length);
        a(byteBufferAllocate, bArr, bArr2);
        return byteBufferAllocate.array();
    }

    public int[] a(int[] iArr, int[] iArr2, int i) {
        if (iArr.length != a() / 4) {
            throw new IllegalArgumentException(String.format("need 96-bit param, but got a %d-bit param", Integer.valueOf(iArr.length * 32)));
        }
        int[] iArr3 = new int[16];
        a(iArr3, iArr2);
        iArr3[12] = i;
        System.arraycopy(iArr, 0, iArr3, 13, iArr.length);
        return iArr3;
    }

    public byte[] b(byte[] bArr) throws GeneralSecurityException {
        return a(bArr, (byte[]) null);
    }

    public byte[] c(byte[] bArr) throws GeneralSecurityException {
        return a(ByteBuffer.wrap(bArr));
    }
}

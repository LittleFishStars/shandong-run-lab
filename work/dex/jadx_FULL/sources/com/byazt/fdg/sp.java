package com.byazt.fdg;

import com.aliyun.openapiutil.Client;
import com.bykv.vk.component.ttvideo.mediakit.medialoader.AVMDLDataLoader;
import java.io.FileDescriptor;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.security.DigestException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_11_8719cls.dex */
@com.byazt.zqa.c(c = {0, 1, AVMDLDataLoader.KeyIsPreloadWaitListType, 91})
public abstract class sp {
    public static final byte[] c = new byte[8];

    @com.byazt.zqa.c(c = {0, 1, AVMDLDataLoader.KeyIsPreloadWaitListType, 180})
    public static class c {
        public final ByteBuffer c;
        public final byte[] tt;

        public c(ByteBuffer byteBuffer, byte[] bArr) {
            this.c = byteBuffer;
            this.tt = bArr;
        }
    }

    @com.byazt.zqa.c(c = {0, 1, AVMDLDataLoader.KeyIsPreloadWaitListType, 904})
    public static class tt implements da {
        public int c;
        public final byte[] n;
        public final ByteBuffer tt;
        public final byte[] uj;
        public final MessageDigest ve;

        /* JADX INFO: Access modifiers changed from: private */
        public void tt() {
            int iPosition = this.tt.position() % 4096;
            if (iPosition == 0) {
                return;
            }
            this.tt.put(ByteBuffer.allocate(4096 - iPosition));
        }

        private tt(byte[] bArr, ByteBuffer byteBuffer) throws NoSuchAlgorithmException {
            this.uj = new byte[32];
            this.n = bArr;
            this.tt = byteBuffer.slice();
            MessageDigest messageDigest = MessageDigest.getInstance(Client.HASH_SHA256);
            this.ve = messageDigest;
            messageDigest.update(bArr);
            this.c = 0;
        }

        @Override // com.byazt.fdg.da
        public void c(ByteBuffer byteBuffer) throws DigestException {
            byteBuffer.position();
            int iRemaining = byteBuffer.remaining();
            while (iRemaining > 0) {
                int iMin = Math.min(iRemaining, 4096 - this.c);
                byteBuffer.limit(byteBuffer.position() + iMin);
                this.ve.update(byteBuffer);
                iRemaining -= iMin;
                int i = this.c + iMin;
                this.c = i;
                if (i == 4096) {
                    MessageDigest messageDigest = this.ve;
                    byte[] bArr = this.uj;
                    messageDigest.digest(bArr, 0, bArr.length);
                    this.tt.put(this.uj);
                    this.ve.update(this.n);
                    this.c = 0;
                }
            }
        }

        public void c() throws DigestException {
            if (this.c == 0) {
                return;
            }
            throw new IllegalStateException("Buffer is not empty: " + this.c);
        }
    }

    public static c c(RandomAccessFile randomAccessFile, u uVar, i iVar) throws NoSuchAlgorithmException, DigestException, IOException, SecurityException {
        int[] iArrTt = tt(randomAccessFile.length() - (uVar.ve - uVar.tt));
        int i = iArrTt[iArrTt.length - 1];
        int i2 = i + 4096;
        ByteBuffer byteBufferC = iVar.c(i2);
        ByteOrder byteOrder = ByteOrder.LITTLE_ENDIAN;
        byteBufferC.order(byteOrder);
        ByteBuffer byteBufferC2 = c(byteBufferC, 0, i);
        int i3 = i + 64;
        ByteBuffer byteBufferC3 = c(byteBufferC, i, i3);
        ByteBuffer byteBufferC4 = c(byteBufferC, i3, i2);
        byte[] bArr = new byte[32];
        ByteBuffer byteBufferWrap = ByteBuffer.wrap(bArr);
        byteBufferWrap.order(byteOrder);
        c(randomAccessFile, uVar, byteBufferC2, byteBufferWrap, byteBufferC3, byteBufferC4);
        byteBufferC.position(i3 + byteBufferC4.limit());
        byteBufferC.putInt(byteBufferC4.limit() + 64 + 4);
        byteBufferC.flip();
        return new c(byteBufferC, bArr);
    }

    private static int[] tt(long j) {
        ArrayList arrayList = new ArrayList();
        do {
            j = c(j, 4096L) * 32;
            arrayList.add(Long.valueOf(c(j, 4096L) * 4096));
        } while (j > 4096);
        int[] iArr = new int[arrayList.size() + 1];
        int i = 0;
        iArr[0] = 0;
        while (i < arrayList.size()) {
            int i2 = i + 1;
            iArr[i2] = iArr[i] + c(((Long) arrayList.get((arrayList.size() - i) - 1)).longValue());
            i = i2;
        }
        return iArr;
    }

    private static void c(RandomAccessFile randomAccessFile, u uVar, ByteBuffer byteBuffer, ByteBuffer byteBuffer2, ByteBuffer byteBuffer3, ByteBuffer byteBuffer4) throws NoSuchAlgorithmException, DigestException, IOException {
        c(uVar);
        long j = uVar.ve - uVar.tt;
        int[] iArrTt = tt(randomAccessFile.length() - j);
        if (byteBuffer != null) {
            byte[] bArrC = c(randomAccessFile, uVar, c, iArrTt, byteBuffer);
            if (byteBuffer2 != null) {
                byteBuffer2.put(bArrC);
                byteBuffer2.flip();
            }
        }
        if (byteBuffer3 != null) {
            byteBuffer3.order(ByteOrder.LITTLE_ENDIAN);
            c(byteBuffer3, randomAccessFile.length(), iArrTt.length - 1, c);
        }
        if (byteBuffer4 != null) {
            byteBuffer4.order(ByteOrder.LITTLE_ENDIAN);
            c(byteBuffer4, uVar.tt, j, uVar.uj);
        }
    }

    private static void c(da daVar, sl slVar, int i) throws DigestException, IOException {
        long jC = slVar.c();
        long j = 0;
        while (jC > 0) {
            int iMin = (int) Math.min(jC, i);
            slVar.c(daVar, j, iMin);
            long j2 = iMin;
            j += j2;
            jC -= j2;
        }
    }

    private static void c(RandomAccessFile randomAccessFile, u uVar, byte[] bArr, ByteBuffer byteBuffer) throws NoSuchAlgorithmException, DigestException, IOException {
        tt ttVar = new tt(bArr, byteBuffer);
        c(ttVar, new t(randomAccessFile.getFD(), 0L, uVar.tt), 1048576);
        long j = uVar.uj + 16;
        FileDescriptor fd = randomAccessFile.getFD();
        long j2 = uVar.ve;
        c(ttVar, new t(fd, j2, j - j2), 1048576);
        ByteBuffer byteBufferOrder = ByteBuffer.allocate(4).order(ByteOrder.LITTLE_ENDIAN);
        byteBufferOrder.putInt(c(uVar.tt));
        byteBufferOrder.flip();
        ttVar.c(byteBufferOrder);
        long j3 = j + 4;
        c(ttVar, new t(randomAccessFile.getFD(), j3, randomAccessFile.length() - j3), 1048576);
        int length = (int) (randomAccessFile.length() % 4096);
        if (length != 0) {
            ttVar.c(ByteBuffer.allocate(4096 - length));
        }
        ttVar.c();
        ttVar.tt();
    }

    private static byte[] c(RandomAccessFile randomAccessFile, u uVar, byte[] bArr, int[] iArr, ByteBuffer byteBuffer) throws NoSuchAlgorithmException, DigestException, IOException {
        c(randomAccessFile, uVar, bArr, c(byteBuffer, iArr[iArr.length - 2], iArr[iArr.length - 1]));
        int length = iArr.length - 3;
        while (true) {
            if (length >= 0) {
                int i = length + 1;
                ByteBuffer byteBufferC = c(byteBuffer, iArr[i], iArr[length + 2]);
                ByteBuffer byteBufferC2 = c(byteBuffer, iArr[length], iArr[i]);
                x xVar = new x(byteBufferC);
                tt ttVar = new tt(bArr, byteBufferC2);
                c(ttVar, xVar, 4096);
                ttVar.c();
                ttVar.tt();
                length--;
            } else {
                byte[] bArr2 = new byte[32];
                tt ttVar2 = new tt(bArr, ByteBuffer.wrap(bArr2));
                ttVar2.c(c(byteBuffer, 0, 4096));
                ttVar2.c();
                return bArr2;
            }
        }
    }

    private static ByteBuffer c(ByteBuffer byteBuffer, long j, int i, byte[] bArr) {
        if (bArr.length == 8) {
            byteBuffer.put("TrueBrew".getBytes());
            byteBuffer.put((byte) 1);
            byteBuffer.put((byte) 0);
            byteBuffer.put((byte) 12);
            byteBuffer.put((byte) 7);
            byteBuffer.putShort((short) 1);
            byteBuffer.putShort((short) 1);
            byteBuffer.putInt(0);
            byteBuffer.putInt(0);
            byteBuffer.putLong(j);
            byteBuffer.put((byte) 2);
            byteBuffer.put((byte) 0);
            byteBuffer.put(bArr);
            c(byteBuffer, 22);
            byteBuffer.flip();
            return byteBuffer;
        }
        throw new IllegalArgumentException("salt is not 8 bytes long");
    }

    private static ByteBuffer c(ByteBuffer byteBuffer, long j, long j2, long j3) {
        byteBuffer.putInt(24);
        byteBuffer.putShort((short) 1);
        c(byteBuffer, 2);
        byteBuffer.putLong(j);
        byteBuffer.putLong(j2);
        byteBuffer.putInt(20);
        byteBuffer.putShort((short) 2);
        c(byteBuffer, 2);
        byteBuffer.putLong(j3 + 16);
        byteBuffer.putInt(c(j));
        c(byteBuffer, 4);
        byteBuffer.flip();
        return byteBuffer;
    }

    private static void c(u uVar) {
        long j = uVar.tt;
        if (j % 4096 != 0) {
            throw new IllegalArgumentException("APK Signing Block does not start at the page  boundary: " + uVar.tt);
        }
        if ((uVar.ve - j) % 4096 == 0) {
            return;
        }
        throw new IllegalArgumentException("Size of APK Signing Block is not a multiple of 4096: " + (uVar.ve - uVar.tt));
    }

    private static ByteBuffer c(ByteBuffer byteBuffer, int i, int i2) {
        ByteBuffer byteBufferDuplicate = byteBuffer.duplicate();
        byteBufferDuplicate.position(0);
        byteBufferDuplicate.limit(i2);
        byteBufferDuplicate.position(i);
        return byteBufferDuplicate.slice();
    }

    private static void c(ByteBuffer byteBuffer, int i) {
        byteBuffer.position(byteBuffer.position() + i);
    }

    private static long c(long j, long j2) {
        return ((j + j2) - 1) / j2;
    }

    public static int c(long j) {
        int i = (int) j;
        if (i == j) {
            return i;
        }
        throw new ArithmeticException("integer overflow");
    }
}

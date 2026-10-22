package com.byazt.fdg;

import android.util.ArrayMap;
import android.util.Pair;
import android.util.SparseArray;
import androidx.annotation.RequiresApi;
import com.aliyun.openapiutil.Client;
import com.baidu.mapauto.auth.util.RSAUtil;
import com.bykv.vk.component.ttvideo.mediakit.medialoader.AVMDLDataLoader;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import java.io.FileDescriptor;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.BufferUnderflowException;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.security.DigestException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.spec.AlgorithmParameterSpec;
import java.security.spec.MGF1ParameterSpec;
import java.security.spec.PSSParameterSpec;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_11_8719cls.dex */
@com.byazt.zqa.c(c = {0, 1, AVMDLDataLoader.KeyIsPreloadWaitListType, 34})
public final class a {
    public static final HashMap<String, SparseArray<u>> c = new HashMap<>();

    @com.byazt.zqa.c(c = {0, 1, AVMDLDataLoader.KeyIsPreloadWaitListType, 464})
    public static class c implements da {
        public final MessageDigest[] c;

        public c(MessageDigest[] messageDigestArr) {
            this.c = messageDigestArr;
        }

        @Override // com.byazt.fdg.da
        public void c(ByteBuffer byteBuffer) {
            ByteBuffer byteBufferSlice = byteBuffer.slice();
            for (MessageDigest messageDigest : this.c) {
                byteBufferSlice.position(0);
                messageDigest.update(byteBufferSlice);
            }
        }
    }

    @RequiresApi(api = 21)
    public static void c(Map<Integer, byte[]> map, RandomAccessFile randomAccessFile, u uVar) throws SecurityException {
        if (map.isEmpty()) {
            throw new SecurityException("No digests provided");
        }
        ArrayMap arrayMap = new ArrayMap();
        boolean z = true;
        if (map.containsKey(1)) {
            arrayMap.put(1, map.get(1));
        }
        if (map.containsKey(2)) {
            arrayMap.put(2, map.get(2));
        }
        boolean z2 = false;
        if (!arrayMap.isEmpty()) {
            try {
                c(arrayMap, randomAccessFile.getFD(), uVar);
                z = false;
            } catch (IOException e) {
                throw new SecurityException("Cannot get FD", e);
            }
        }
        if (map.containsKey(3)) {
            c(map.get(3), randomAccessFile, uVar);
        } else {
            z2 = z;
        }
        if (z2) {
            throw new SecurityException("No known digest exists for integrity check");
        }
    }

    private static int n(int i) {
        if (i == 1) {
            return 32;
        }
        if (i == 2) {
            return 64;
        }
        if (i == 3) {
            return 32;
        }
        throw new IllegalArgumentException("Unknown content digest algorthm: ".concat(String.valueOf(i)));
    }

    private static int tt(int i, int i2) {
        if (i == 1) {
            if (i2 == 1) {
                return 0;
            }
            if (i2 == 2 || i2 == 3) {
                return -1;
            }
            throw new IllegalArgumentException("Unknown digestAlgorithm2: ".concat(String.valueOf(i2)));
        }
        if (i == 2) {
            if (i2 != 1) {
                if (i2 == 2) {
                    return 0;
                }
                if (i2 != 3) {
                    throw new IllegalArgumentException("Unknown digestAlgorithm2: ".concat(String.valueOf(i2)));
                }
            }
            return 1;
        }
        if (i != 3) {
            throw new IllegalArgumentException("Unknown digestAlgorithm1: ".concat(String.valueOf(i)));
        }
        if (i2 == 1) {
            return 1;
        }
        if (i2 == 2) {
            return -1;
        }
        if (i2 == 3) {
            return 0;
        }
        throw new IllegalArgumentException("Unknown digestAlgorithm2: ".concat(String.valueOf(i2)));
    }

    public static Pair<String, ? extends AlgorithmParameterSpec> uj(int i) {
        if (i != 513) {
            if (i == 514) {
                return Pair.create("SHA512withECDSA", null);
            }
            if (i != 769) {
                if (i != 1057) {
                    if (i != 1059) {
                        if (i != 1061) {
                            switch (i) {
                                case 257:
                                    return Pair.create("SHA256withRSA/PSS", new PSSParameterSpec(Client.HASH_SHA256, "MGF1", MGF1ParameterSpec.SHA256, 32, 1));
                                case MediaPlayer.MEDIA_PLAYER_OPTION_RANGE_MODE /* 258 */:
                                    return Pair.create("SHA512withRSA/PSS", new PSSParameterSpec("SHA-512", "MGF1", MGF1ParameterSpec.SHA512, 64, 1));
                                case MediaPlayer.MEDIA_PLAYER_OPTION_VIDEO_RANGE_TIME /* 259 */:
                                    break;
                                case MediaPlayer.MEDIA_PLAYER_OPTION_AUDIO_RANGE_TIME /* 260 */:
                                    return Pair.create("SHA512withRSA", null);
                                default:
                                    throw new IllegalArgumentException("Unknown signature algorithm: 0x" + Long.toHexString(i & (-1)));
                            }
                        }
                    }
                }
                return Pair.create(RSAUtil.SIGNATURE_ALGORITHM, null);
            }
            return Pair.create("SHA256withDSA", null);
        }
        return Pair.create("SHA256withECDSA", null);
    }

    public static String ve(int i) {
        if (i == 513 || i == 514) {
            return "EC";
        }
        if (i == 769) {
            return "DSA";
        }
        if (i == 1057) {
            return "RSA";
        }
        if (i == 1059) {
            return "EC";
        }
        if (i == 1061) {
            return "DSA";
        }
        switch (i) {
            case 257:
            case MediaPlayer.MEDIA_PLAYER_OPTION_RANGE_MODE /* 258 */:
            case MediaPlayer.MEDIA_PLAYER_OPTION_VIDEO_RANGE_TIME /* 259 */:
            case MediaPlayer.MEDIA_PLAYER_OPTION_AUDIO_RANGE_TIME /* 260 */:
                return "RSA";
            default:
                throw new IllegalArgumentException("Unknown signature algorithm: 0x" + Long.toHexString(i & (-1)));
        }
    }

    private static void ve(ByteBuffer byteBuffer) {
        if (byteBuffer.order() != ByteOrder.LITTLE_ENDIAN) {
            throw new IllegalArgumentException("ByteBuffer byte order must be little endian");
        }
    }

    public static String tt(int i) {
        if (i == 1) {
            return Client.HASH_SHA256;
        }
        if (i == 2) {
            return "SHA-512";
        }
        if (i == 3) {
            return Client.HASH_SHA256;
        }
        throw new IllegalArgumentException("Unknown content digest algorthm: ".concat(String.valueOf(i)));
    }

    public static byte[] tt(ByteBuffer byteBuffer) throws IOException {
        int i = byteBuffer.getInt();
        if (i >= 0) {
            if (i <= byteBuffer.remaining()) {
                byte[] bArr = new byte[i];
                byteBuffer.get(bArr);
                return bArr;
            }
            throw new IOException("Underflow while reading length-prefixed value. Length: " + i + ", available: " + byteBuffer.remaining());
        }
        throw new IOException("Negative length");
    }

    private static void c(Map<Integer, byte[]> map, FileDescriptor fileDescriptor, u uVar) throws SecurityException {
        t tVar = new t(fileDescriptor, 0L, uVar.tt);
        long j = uVar.ve;
        t tVar2 = new t(fileDescriptor, j, uVar.uj - j);
        ByteBuffer byteBufferDuplicate = uVar.n.duplicate();
        byteBufferDuplicate.order(ByteOrder.LITTLE_ENDIAN);
        my.c(byteBufferDuplicate, uVar.tt);
        x xVar = new x(byteBufferDuplicate);
        int size = map.size();
        int[] iArr = new int[size];
        Iterator<Integer> it = map.keySet().iterator();
        int i = 0;
        while (it.hasNext()) {
            iArr[i] = it.next().intValue();
            i++;
        }
        try {
            byte[][] bArrC = c(iArr, new sl[]{tVar, tVar2, xVar});
            for (int i2 = 0; i2 < size; i2++) {
                int i3 = iArr[i2];
                if (!MessageDigest.isEqual(map.get(Integer.valueOf(i3)), bArrC[i2])) {
                    throw new SecurityException(tt(i3) + " digest of contents did not verify");
                }
            }
        } catch (DigestException e) {
            throw new SecurityException("Failed to compute digest(s) of contents", e);
        }
    }

    private static byte[][] c(int[] iArr, sl[] slVarArr) throws DigestException {
        String str;
        sl[] slVarArr2 = slVarArr;
        long j = 0;
        long jC = 0;
        for (sl slVar : slVarArr2) {
            jC += c(slVar.c());
        }
        if (jC < 2097151) {
            int i = (int) jC;
            byte[][] bArr = new byte[iArr.length][];
            for (int i2 = 0; i2 < iArr.length; i2++) {
                byte[] bArr2 = new byte[(n(iArr[i2]) * i) + 5];
                bArr2[0] = 90;
                c(i, bArr2, 1);
                bArr[i2] = bArr2;
            }
            byte[] bArr3 = new byte[5];
            bArr3[0] = -91;
            int length = iArr.length;
            MessageDigest[] messageDigestArr = new MessageDigest[length];
            int i3 = 0;
            while (true) {
                str = " digest not supported";
                if (i3 >= iArr.length) {
                    break;
                }
                String strTt = tt(iArr[i3]);
                try {
                    messageDigestArr[i3] = MessageDigest.getInstance(strTt);
                    i3++;
                } catch (NoSuchAlgorithmException e) {
                    throw new RuntimeException(strTt + " digest not supported", e);
                }
            }
            c cVar = new c(messageDigestArr);
            int length2 = slVarArr2.length;
            int i4 = 0;
            int i5 = 0;
            int i6 = 0;
            while (i4 < length2) {
                sl slVar2 = slVarArr2[i4];
                int i7 = length2;
                int i8 = i6;
                c cVar2 = cVar;
                String str2 = str;
                long jC2 = slVar2.c();
                long j2 = j;
                while (jC2 > j) {
                    int iMin = (int) Math.min(jC2, 1048576L);
                    c(iMin, bArr3, 1);
                    for (int i9 = 0; i9 < length; i9++) {
                        messageDigestArr[i9].update(bArr3);
                    }
                    c cVar3 = cVar2;
                    try {
                        slVar2.c(cVar3, j2, iMin);
                        cVar2 = cVar3;
                        int i10 = 0;
                        while (i10 < iArr.length) {
                            int i11 = iArr[i10];
                            byte[] bArr4 = bArr3;
                            byte[] bArr5 = bArr[i10];
                            int iN = n(i11);
                            sl slVar3 = slVar2;
                            MessageDigest messageDigest = messageDigestArr[i10];
                            int i12 = length;
                            int iDigest = messageDigest.digest(bArr5, (i8 * iN) + 5, iN);
                            if (iDigest != iN) {
                                throw new RuntimeException("Unexpected output size of " + messageDigest.getAlgorithm() + " digest: " + iDigest);
                            }
                            i10++;
                            bArr3 = bArr4;
                            slVar2 = slVar3;
                            length = i12;
                        }
                        long j3 = iMin;
                        j2 += j3;
                        jC2 -= j3;
                        i8++;
                        bArr3 = bArr3;
                        j = 0;
                    } catch (IOException e2) {
                        throw new DigestException("Failed to digest chunk #" + i8 + " of section #" + i5, e2);
                    }
                }
                i5++;
                i4++;
                slVarArr2 = slVarArr;
                i6 = i8;
                cVar = cVar2;
                str = str2;
                length2 = i7;
                j = 0;
            }
            String str3 = str;
            byte[][] bArr6 = new byte[iArr.length][];
            for (int i13 = 0; i13 < iArr.length; i13++) {
                int i14 = iArr[i13];
                byte[] bArr7 = bArr[i13];
                String strTt2 = tt(i14);
                try {
                    bArr6[i13] = MessageDigest.getInstance(strTt2).digest(bArr7);
                } catch (NoSuchAlgorithmException e3) {
                    throw new RuntimeException(strTt2 + str3, e3);
                }
            }
            return bArr6;
        }
        throw new DigestException("Too many chunks: ".concat(String.valueOf(jC)));
    }

    public static byte[] c(byte[] bArr, long j, u uVar) throws SecurityException {
        if (bArr.length == 40) {
            ByteBuffer byteBufferOrder = ByteBuffer.wrap(bArr).order(ByteOrder.LITTLE_ENDIAN);
            byteBufferOrder.position(32);
            if (byteBufferOrder.getLong() == j - (uVar.ve - uVar.tt)) {
                return Arrays.copyOfRange(bArr, 0, 32);
            }
            throw new SecurityException("APK content size did not verify");
        }
        throw new SecurityException("Verity digest size is wrong: " + bArr.length);
    }

    private static void c(byte[] bArr, RandomAccessFile randomAccessFile, u uVar) throws SecurityException {
        try {
            if (Arrays.equals(c(bArr, randomAccessFile.length(), uVar), sp.c(randomAccessFile, uVar, new i() { // from class: com.byazt.fdg.a.1
                @Override // com.byazt.fdg.i
                public ByteBuffer c(int i) {
                    return ByteBuffer.allocate(i);
                }
            }).tt)) {
            } else {
                throw new SecurityException("APK verity digest of contents did not verify");
            }
        } catch (IOException | DigestException | NoSuchAlgorithmException e) {
            throw new SecurityException("Error during verification", e);
        }
    }

    public static Pair<ByteBuffer, Long> c(RandomAccessFile randomAccessFile) throws yp, IOException {
        Pair<ByteBuffer, Long> pairC = my.c(randomAccessFile);
        if (pairC != null) {
            return pairC;
        }
        throw new yp("Not an APK file: ZIP End of Central Directory record not found");
    }

    public static long c(ByteBuffer byteBuffer, long j) throws yp {
        long jC = my.c(byteBuffer);
        if (jC <= j) {
            if (my.tt(byteBuffer) + jC == j) {
                return jC;
            }
            throw new yp("ZIP Central Directory is not immediately followed by End of Central Directory");
        }
        throw new yp("ZIP Central Directory offset out of range: " + jC + ". ZIP End of Central Directory offset: " + j);
    }

    private static long c(long j) {
        return ((j + 1048576) - 1) / 1048576;
    }

    public static int c(int i, int i2) {
        return tt(c(i), c(i2));
    }

    public static int c(int i) {
        if (i == 513) {
            return 1;
        }
        if (i == 514) {
            return 2;
        }
        if (i == 769) {
            return 1;
        }
        if (i == 1057 || i == 1059 || i == 1061) {
            return 3;
        }
        switch (i) {
            case 257:
            case MediaPlayer.MEDIA_PLAYER_OPTION_VIDEO_RANGE_TIME /* 259 */:
                return 1;
            case MediaPlayer.MEDIA_PLAYER_OPTION_RANGE_MODE /* 258 */:
            case MediaPlayer.MEDIA_PLAYER_OPTION_AUDIO_RANGE_TIME /* 260 */:
                return 2;
            default:
                throw new IllegalArgumentException("Unknown signature algorithm: 0x" + Long.toHexString(i & (-1)));
        }
    }

    public static ByteBuffer c(ByteBuffer byteBuffer, int i, int i2) {
        if (i < 0) {
            throw new IllegalArgumentException("start: ".concat(String.valueOf(i)));
        }
        if (i2 >= i) {
            int iCapacity = byteBuffer.capacity();
            if (i2 <= byteBuffer.capacity()) {
                int iLimit = byteBuffer.limit();
                int iPosition = byteBuffer.position();
                try {
                    byteBuffer.position(0);
                    byteBuffer.limit(i2);
                    byteBuffer.position(i);
                    ByteBuffer byteBufferSlice = byteBuffer.slice();
                    byteBufferSlice.order(byteBuffer.order());
                    return byteBufferSlice;
                } finally {
                    byteBuffer.position(0);
                    byteBuffer.limit(iLimit);
                    byteBuffer.position(iPosition);
                }
            }
            throw new IllegalArgumentException("end > capacity: " + i2 + " > " + iCapacity);
        }
        throw new IllegalArgumentException("end < start: " + i2 + " < " + i);
    }

    public static ByteBuffer c(ByteBuffer byteBuffer, int i) throws BufferUnderflowException {
        if (i >= 0) {
            int iLimit = byteBuffer.limit();
            int iPosition = byteBuffer.position();
            int i2 = i + iPosition;
            if (i2 >= iPosition && i2 <= iLimit) {
                byteBuffer.limit(i2);
                try {
                    ByteBuffer byteBufferSlice = byteBuffer.slice();
                    byteBufferSlice.order(byteBuffer.order());
                    byteBuffer.position(i2);
                    return byteBufferSlice;
                } finally {
                    byteBuffer.limit(iLimit);
                }
            }
            throw new BufferUnderflowException();
        }
        throw new IllegalArgumentException("size: ".concat(String.valueOf(i)));
    }

    public static ByteBuffer c(ByteBuffer byteBuffer) throws IOException {
        if (byteBuffer.remaining() >= 4) {
            int i = byteBuffer.getInt();
            if (i >= 0) {
                if (i <= byteBuffer.remaining()) {
                    return c(byteBuffer, i);
                }
                throw new IOException("Length-prefixed field longer than remaining buffer. Field length: " + i + ", remaining: " + byteBuffer.remaining());
            }
            throw new IllegalArgumentException("Negative length");
        }
        throw new IOException("Remaining buffer too short to contain length of length-prefixed field. Remaining: " + byteBuffer.remaining());
    }

    public static void c(int i, byte[] bArr, int i2) {
        bArr[i2] = (byte) (i & 255);
        bArr[i2 + 1] = (byte) ((i >>> 8) & 255);
        bArr[i2 + 2] = (byte) ((i >>> 16) & 255);
        bArr[i2 + 3] = (byte) ((i >>> 24) & 255);
    }

    public static Pair<ByteBuffer, Long> c(RandomAccessFile randomAccessFile, long j) throws yp, IOException {
        if (j >= 32) {
            ByteBuffer byteBufferAllocate = ByteBuffer.allocate(24);
            ByteOrder byteOrder = ByteOrder.LITTLE_ENDIAN;
            byteBufferAllocate.order(byteOrder);
            randomAccessFile.seek(j - ((long) byteBufferAllocate.capacity()));
            randomAccessFile.readFully(byteBufferAllocate.array(), byteBufferAllocate.arrayOffset(), byteBufferAllocate.capacity());
            if (byteBufferAllocate.getLong(8) != 2334950737559900225L || byteBufferAllocate.getLong(16) != 3617552046287187010L) {
                return null;
            }
            long j2 = byteBufferAllocate.getLong(0);
            if (j2 < byteBufferAllocate.capacity() || j2 > 2147483639) {
                throw new yp("APK Signing Block size out of range: ".concat(String.valueOf(j2)));
            }
            int i = (int) (8 + j2);
            long j3 = j - ((long) i);
            if (j3 >= 0) {
                ByteBuffer byteBufferAllocate2 = ByteBuffer.allocate(i);
                byteBufferAllocate2.order(byteOrder);
                randomAccessFile.seek(j3);
                randomAccessFile.readFully(byteBufferAllocate2.array(), byteBufferAllocate2.arrayOffset(), byteBufferAllocate2.capacity());
                long j4 = byteBufferAllocate2.getLong(0);
                if (j4 == j2) {
                    return Pair.create(byteBufferAllocate2, Long.valueOf(j3));
                }
                throw new yp("APK Signing Block sizes in header and footer do not match: " + j4 + " vs " + j2);
            }
            throw new yp("APK Signing Block offset out of range: ".concat(String.valueOf(j3)));
        }
        throw new yp("APK too small for APK Signing Block. ZIP Central Directory offset: ".concat(String.valueOf(j)));
    }

    public static void c(String str, RandomAccessFile randomAccessFile, int... iArr) throws yp, IOException {
        ByteBuffer byteBuffer;
        String str2 = str;
        c.put(str2, new SparseArray<>());
        Pair<ByteBuffer, Long> pairC = c(randomAccessFile);
        ByteBuffer byteBuffer2 = (ByteBuffer) pairC.first;
        long jLongValue = ((Long) pairC.second).longValue();
        if (!my.c(randomAccessFile, jLongValue)) {
            long jC = c(byteBuffer2, jLongValue);
            Pair<ByteBuffer, Long> pairC2 = c(randomAccessFile, jC);
            if (pairC2 == null) {
                return;
            }
            ByteBuffer byteBuffer3 = (ByteBuffer) pairC2.first;
            long jLongValue2 = ((Long) pairC2.second).longValue();
            ve(byteBuffer3);
            int i = 8;
            ByteBuffer byteBufferC = c(byteBuffer3, 8, byteBuffer3.capacity() - 24);
            HashSet hashSet = new HashSet();
            for (int i2 : iArr) {
                hashSet.add(Integer.valueOf(i2));
            }
            while (byteBufferC.hasRemaining() && byteBufferC.remaining() >= i) {
                long j = byteBufferC.getLong();
                if (j < 4 || j > 2147483647L) {
                    return;
                }
                int i3 = (int) j;
                int iPosition = byteBufferC.position() + i3;
                if (i3 > byteBufferC.remaining()) {
                    return;
                }
                int i4 = byteBufferC.getInt();
                if (hashSet.contains(Integer.valueOf(i4))) {
                    c.get(str2).put(i4, new u(c(byteBufferC, i3 - 4), jLongValue2, jC, jLongValue, byteBuffer2));
                    byteBuffer = byteBufferC;
                } else {
                    byteBuffer = byteBufferC;
                }
                byteBuffer.position(iPosition);
                hashSet = hashSet;
                byteBufferC = byteBuffer;
                jC = jC;
                i = i;
                str2 = str;
            }
            return;
        }
        throw new yp("ZIP64 APK not supported");
    }
}

package com.baidu.sec.privacy.f;

import android.annotation.SuppressLint;
import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.os.IBinder;
import android.os.Parcel;
import com.google.common.primitives.SignedBytes;
import com.google.common.primitives.UnsignedBytes;
import com.ipd.dsp.internal.q.u;
import com.scwang.smartrefresh.header.internal.MaterialProgressDrawable;
import com.zj.adlib.aq6;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.math.BigInteger;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.IntBuffer;
import java.security.GeneralSecurityException;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_10_7392cls.dex */
public class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final int[] f26817a = a(new byte[]{101, aq6.f40585a, 112, 97, 110, 100, 32, com.alibaba.ariver.resource.parser.a.e.l, com.alibaba.ariver.resource.parser.a.e.k, com.google.android.exoplayer2.text.cea.a.n, 98, 121, 116, 101, 32, 107});
    public static final byte[] b = {34, aq6.f40585a, 93, com.google.common.base.a.F, 86, 125, 58, -72, 104, -79, MaterialProgressDrawable.c, 125, 82, -26, -85, 124, -100, -25, com.google.common.base.a.C, 17, 88, -127, -116, -8, 0, com.google.android.exoplayer2.text.cea.a.e, 70, -4, -1, -110, -69, -85, 5, 81, -70, -27, -98, -7, 42, 124, -74, 47, -120, 124, com.google.common.base.a.x, -14, 74, -107, -69, 116, -101, -8, -89, -71, 99, -124, 9, com.alibaba.ariver.resource.parser.a.e.p, 107, -18, -114, 5, -79, 58, SignedBytes.f32242a, -110, u.x7, 78, -29, 69, u.x7, 63, -77, -73, 106, com.google.android.exoplayer2.text.cea.a.l, 10, -95, -98, -112, u.y7, -87, -98, -91, u.q7, u.D7, 57, -75, u.B7, -85, 80, 89, 42, -25, com.google.android.exoplayer2.text.cea.a.n, -119, -18, -90, -56, -101, -23, 59, -91, -52, 124, 83, 61, -20, 119, -105, -74, 102, -27, 86, 17, -15, -110, 75, u.r7, 123, -24, 42, 117, com.alibaba.ariver.resource.parser.a.e.i, 11, 11, -127, 9, 12, u.t7, 93, -92, -30, -47, -4, 109, -67, 101, com.google.android.exoplayer2.text.cea.a.h, -91, -73, -75, -25, 66, -41, -43, -28, -84, u.y7, com.google.android.exoplayer2.text.cea.a.e, -65, 10, -94, 5, u.z7, -36, SignedBytes.f32242a, -101, 87, -12, 78, 35, -44, 94, u.w7, -28, 115, 107, 117, -81, -6, com.alibaba.ariver.resource.parser.a.e.l, 86, MaterialProgressDrawable.c, -108, -80, 110, -71, -30, -9, com.alibaba.ariver.resource.parser.a.e.j, u.z7, 100, com.alibaba.ariver.resource.parser.a.e.k, -41, com.google.common.base.a.x, -97, 32, -34, -14, 60, -25, com.alibaba.ariver.resource.parser.a.e.n, -97, 35, -37, -122, -122, -80, com.google.android.exoplayer2.text.cea.a.j, com.alibaba.ariver.resource.parser.a.e.o, 0, -9, -111, com.alibaba.ariver.resource.parser.a.e.p, 90, 17, com.google.android.exoplayer2.text.cea.a.j, 82, u.z7, -73, com.alibaba.ariver.resource.parser.a.e.l, 9, MaterialProgressDrawable.d, 92, 97, -126, 85, 4, -114, -48, 109, u.t7, 96, u.B7, -102, -71, -87, -76, -77, -52, 58, 107, 66, -103, 35, 5, 47, -112, com.google.android.exoplayer2.text.cea.a.i, u.s7, 101, 77, -21, 4, u.r7, com.google.android.exoplayer2.text.cea.a.j, -3, 35, -36, com.google.android.exoplayer2.text.cea.a.m, 109, MaterialProgressDrawable.c, -111, 115, com.google.common.base.a.A};
    public static final byte[] c = {0, -70, 42, -20, -46, -12, -1, -114, 74, -47, 126, -90, com.google.common.base.a.A, -7, -79, -117, -90, 82, 94, com.google.common.base.a.z, -56, 34, -71, -22, com.alibaba.ariver.resource.parser.a.e.m, 103, -86, -90, u.s7, -3, 60, -16, 92, com.alibaba.ariver.resource.parser.a.e.p, 73, -24, 47, -125, com.google.common.base.a.r, 17, -96, -42, 96, 93, 61, -90, com.google.android.exoplayer2.text.cea.a.l, -72, -47, 68, 59, -106, u.r7, 67, 103, 34, 69, -88, -92, -19, -15, -112, 58, 17, 94, com.google.android.exoplayer2.text.cea.a.h, -48, 35, u.p7, com.google.common.base.a.A, -56, -65, -2, com.google.android.exoplayer2.text.cea.a.l, 65, -119, u.y7, u.r7, -90, -119, 17, -66, -99, 90, -71, -111, u.n7, 10, -30, u.n7, 70, com.alibaba.ariver.resource.parser.a.e.m, 97, com.google.android.exoplayer2.text.cea.a.e, 114, -15, 63, 71, u.v7, u.v7, -76, -6, 79, u.w7, com.google.common.base.a.B, 79, -81, com.google.common.base.a.B, -48, 1, com.google.common.base.a.A, u.o7, 89, -86, -83, -121, -1, 42, 127, -46, 93, 3, 77, u.D7, -81, 123, 114, com.google.common.base.a.x, 89};
    public static final byte[] d = {0, -113, 121, com.alibaba.ariver.resource.parser.a.e.n, u.D7, -71, -86, -23, -65, -85, -19, -120, 122, u.z7, 73, 81, -74, -13, com.google.android.exoplayer2.text.cea.a.o, u.r7, -98, 59, -81, com.alibaba.ariver.resource.parser.a.e.p, com.google.common.base.a.B, -24, -22, -60, -106, 31, 62, -3, com.alibaba.ariver.resource.parser.a.e.o, 6, -25, 67, 81, -87, -60, com.google.common.base.a.B, com.alibaba.ariver.resource.parser.a.e.l, 57, -72, 9, -25, u.p7, -82, com.google.common.base.a.F, 83, -101, -89, 71, 91, -123, -48, 17, -83, -72, -76, 121, -121, 117, 73, -124, 105, 92, -84, com.google.common.base.a.p, -113, com.google.common.base.a.x, -77, com.alibaba.ariver.resource.parser.a.e.o, 8, MaterialProgressDrawable.c, -94, 47, -6, com.google.android.exoplayer2.text.cea.a.i, 17, 10, 61, 98, -87, -109, 69, com.alibaba.ariver.resource.parser.a.e.m, 9, -96, -2, 105, 108, 70, 88, -8, 75, -35, 32, -127, -100, com.alibaba.ariver.resource.parser.a.e.p, 9, -96, com.google.common.base.a.r, 87, -79, -107, -83, u.x7, 0, 35, 61, -70, 84, -124, -74, com.google.android.exoplayer2.text.cea.a.j, 31, -99, 100, -114, -8, -125, 68, -122, 119, -105, -100, -20, 4, -76, com.alibaba.ariver.resource.parser.a.e.m, -90, -84, com.google.android.exoplayer2.text.cea.a.o, 117, -23, -104, 93, -30, 61, -80, com.google.android.exoplayer2.text.cea.a.j, 47, u.o7, 17, -116, -97, -6, -99, -127, -127, -25, com.alibaba.ariver.resource.parser.a.e.l, -115, -73, -110, -73, com.alibaba.ariver.resource.parser.a.e.i, -41, -71, -29, 73, 89, 47, 104, 9, -104, 114, com.google.common.base.a.y, 57, com.google.common.base.a.y, -22, 61, 107, -117, 70, 83, u.s7, com.alibaba.ariver.resource.parser.a.e.l, 69, -113, UnsignedBytes.f32243a, 59, com.alibaba.ariver.resource.parser.a.e.k, -92, u.p7, -32, -14, 114, -112, com.google.android.exoplayer2.text.cea.a.g, 110, 78, 63, -118, 59, 8, MaterialProgressDrawable.d, -95, -60, 80, -28, u.B7, -116, com.google.common.base.a.D, com.google.android.exoplayer2.text.cea.a.j, -93, 125, -33, 94, -95, 67, -34, 75, 102, -1, 4, -112, 62, -43, u.z7, com.google.common.base.a.z, 35, u.B7, 88, -44, -121, u.s7, 8, -23, 127, com.google.android.exoplayer2.text.cea.a.e, com.google.common.base.a.F, u.m7, com.google.common.base.a.G, u.v7, 35, u.w7, 110, MaterialProgressDrawable.d, 7, 101, -8, 34, -29, 66, -66, 72, 76, 5, 118, 57, 57, 96, com.google.common.base.a.F, -42, 103};

    public static int a(int i, int i2) {
        return (i >>> (-i2)) | (i << i2);
    }

    /* JADX WARN: Code duplicated, block: B:39:0x0083 A[Catch: all -> 0x007f, FINALLY_INSNS, TRY_LEAVE, TryCatch #5 {all -> 0x007f, blocks: (B:35:0x007b, B:39:0x0083), top: B:53:0x007b }] */
    public static String a(Context context) {
        ByteArrayOutputStream byteArrayOutputStream;
        FileInputStream fileInputStream = null;
        try {
            File fileA = com.baidu.sec.privacy.b.b.a(context).a(context.getFilesDir().getParent() + "/.helios/ids/aid/aid.dat");
            byteArrayOutputStream = new ByteArrayOutputStream();
            try {
                FileInputStream fileInputStream2 = new FileInputStream(fileA);
                try {
                    byte[] bArr = new byte[32];
                    while (true) {
                        int i = fileInputStream2.read(bArr);
                        if (i <= 0) {
                            break;
                        }
                        byteArrayOutputStream.write(bArr, 0, i);
                    }
                    String str = new String(a(ByteBuffer.wrap(byteArrayOutputStream.toByteArray())), "UTF-8");
                    try {
                        fileInputStream2.close();
                        byteArrayOutputStream.close();
                    } catch (Throwable th) {
                        c.a(th);
                    }
                    return str;
                } catch (Throwable th2) {
                    th = th2;
                    fileInputStream = fileInputStream2;
                    try {
                        c.a(th);
                        if (fileInputStream != null) {
                            try {
                            } catch (Throwable th3) {
                                return "";
                            }
                        }
                    } finally {
                        if (fileInputStream != null) {
                            try {
                                fileInputStream.close();
                                if (byteArrayOutputStream != null) {
                                    byteArrayOutputStream.close();
                                }
                            } catch (Throwable th4) {
                                c.a(th4);
                            }
                        } else if (byteArrayOutputStream != null) {
                            byteArrayOutputStream.close();
                        }
                    }
                }
            } catch (Throwable th5) {
                th = th5;
            }
        } catch (Throwable th6) {
            th = th6;
            byteArrayOutputStream = null;
        }
    }

    @SuppressLint({"NewApi"})
    public static String b(Context context) {
        try {
            IBinder binder = context.getContentResolver().call(Uri.parse("content://" + context.getPackageName() + ".helios.ipc.default"), "_method_get_bridge", "", new Bundle()).getBinder("bridge_binder");
            Parcel parcelObtain = Parcel.obtain();
            Parcel parcelObtain2 = Parcel.obtain();
            parcelObtain.writeInterfaceToken("com.baidu.helios.bridge.multiprocess.IMultiProcessBridge");
            parcelObtain.writeString("aid");
            binder.transact(1, parcelObtain, parcelObtain2, 0);
            parcelObtain2.readException();
            if (parcelObtain2.readInt() != 0) {
                return ((Bundle) Bundle.CREATOR.createFromParcel(parcelObtain2)).getString("id");
            }
        } catch (Throwable th) {
            c.a(th);
        }
        return "";
    }

    public static byte[] a(ByteBuffer byteBuffer) throws GeneralSecurityException {
        if (byteBuffer.remaining() >= 12) {
            byte[] bArr = new byte[12];
            byteBuffer.get(bArr);
            ByteBuffer byteBufferAllocate = ByteBuffer.allocate(byteBuffer.remaining());
            a(bArr, a(), byteBufferAllocate, byteBuffer);
            return byteBufferAllocate.array();
        }
        throw new GeneralSecurityException("data too short");
    }

    public static void a(ByteBuffer byteBuffer, ByteBuffer byteBuffer2, ByteBuffer byteBuffer3, int i) {
        if (i < 0 || byteBuffer2.remaining() < i || byteBuffer3.remaining() < i || byteBuffer.remaining() < i) {
            throw new IllegalArgumentException("That combination of buffers, offsets and length to xor result in out-of-bond accesses.");
        }
        for (int i2 = 0; i2 < i; i2++) {
            byteBuffer.put((byte) (byteBuffer2.get() ^ byteBuffer3.get()));
        }
    }

    public static void a(byte[] bArr, byte[] bArr2, ByteBuffer byteBuffer, ByteBuffer byteBuffer2) {
        int iRemaining = byteBuffer2.remaining();
        int i = (iRemaining / 64) + 1;
        for (int i2 = 0; i2 < i; i2++) {
            ByteBuffer byteBufferA = a(bArr, bArr2, i2 + 32);
            if (i2 == i - 1) {
                a(byteBuffer, byteBuffer2, byteBufferA, iRemaining % 64);
            } else {
                a(byteBuffer, byteBuffer2, byteBufferA, 64);
            }
        }
    }

    public static ByteBuffer a(byte[] bArr, byte[] bArr2, int i) {
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

    public static byte[] a() {
        return new BigInteger(b).modPow(new BigInteger(c), new BigInteger(d)).toByteArray();
    }

    public static int[] a(int[] iArr, int[] iArr2, int i) {
        if (iArr.length == 3) {
            int[] iArr3 = new int[16];
            a(iArr3, iArr2);
            iArr3[12] = i;
            System.arraycopy(iArr, 0, iArr3, 13, iArr.length);
            return iArr3;
        }
        throw new IllegalArgumentException(String.format("need 96-bit param, but got a %d-bit param", Integer.valueOf(iArr.length * 32)));
    }

    public static int[] a(byte[] bArr) {
        IntBuffer intBufferAsIntBuffer = ByteBuffer.wrap(bArr).order(ByteOrder.LITTLE_ENDIAN).asIntBuffer();
        int[] iArr = new int[intBufferAsIntBuffer.remaining()];
        intBufferAsIntBuffer.get(iArr);
        return iArr;
    }

    public static void a(int[] iArr, int[] iArr2) {
        int[] iArr3 = f26817a;
        System.arraycopy(iArr3, 0, iArr, 0, iArr3.length);
        System.arraycopy(iArr2, 0, iArr, iArr3.length, 8);
    }
}

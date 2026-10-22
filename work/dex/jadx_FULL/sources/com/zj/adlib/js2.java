package com.zj.adlib;

import androidx.annotation.Nullable;
import com.alibaba.ariver.commonability.device.jsapi.wifi.WifiManagerBridgeExtension;
import com.google.android.exoplayer2.d;
import com.google.android.exoplayer2.drm.DrmInitData;
import com.google.android.exoplayer2.source.i;
import com.google.android.exoplayer2.video.spherical.a;
import com.hzchengdun.securityguard.SecExceptionCode;
import java.nio.ByteBuffer;
import java.util.Arrays;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_08_10593cls.dex */
public final class js2 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final byte f42660a = 127;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public static final int f17471a = 192000;
    public static final byte b = 31;

    /* JADX INFO: renamed from: b, reason: collision with other field name */
    public static final int f17473b = 2250000;
    public static final byte c = -2;

    /* JADX INFO: renamed from: c, reason: collision with other field name */
    public static final int f17475c = 2147385345;
    public static final byte d = -1;

    /* JADX INFO: renamed from: d, reason: collision with other field name */
    public static final int f17477d = 536864768;
    public static final int e = -25230976;
    public static final int f = -14745368;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public static final int[] f17472a = {1, 2, 2, 2, 2, 3, 3, 4, 4, 5, 6, 6, 6, 7, 8, 8};

    /* JADX INFO: renamed from: b, reason: collision with other field name */
    public static final int[] f17474b = {-1, 8000, 16000, a.h, -1, -1, 11025, 22050, i.K, -1, -1, WifiManagerBridgeExtension.ERROR_12000, 24000, 48000, -1, -1};

    /* JADX INFO: renamed from: c, reason: collision with other field name */
    public static final int[] f17476c = {64, 112, 128, 192, 224, 256, 384, 448, 512, 640, 768, 896, 1024, 1152, 1280, 1536, 1920, 2048, SecExceptionCode.SEC_ERROR_MIDDLE_TIER_UNSUPPORT_BINARY_DATA_YET, 2560, 2688, y38.h, 2823, 2944, 3072, sd6.b, 4096, 6144, 7680};

    /* JADX WARN: Code duplicated, block: B:15:0x005f  */
    /* JADX WARN: Code duplicated, block: B:17:? A[RETURN, SYNTHETIC] */
    public static int a(byte[] bArr) {
        int i;
        byte b2;
        int i2;
        int i3;
        byte b3;
        boolean z = false;
        byte b4 = bArr[0];
        if (b4 != -2) {
            if (b4 == -1) {
                i3 = ((bArr[7] & 3) << 12) | ((bArr[6] & 255) << 4);
                b3 = bArr[9];
            } else if (b4 != 31) {
                i = ((bArr[5] & 3) << 12) | ((bArr[6] & 255) << 4);
                b2 = bArr[7];
            } else {
                i3 = ((bArr[6] & 3) << 12) | ((bArr[7] & 255) << 4);
                b3 = bArr[8];
            }
            i2 = (((b3 & 60) >> 2) | i3) + 1;
            z = true;
            if (z) {
                return (i2 * 16) / 14;
            }
            return i2;
        }
        i = ((bArr[4] & 3) << 12) | ((bArr[7] & 255) << 4);
        b2 = bArr[6];
        i2 = (((b2 & 240) >> 4) | i) + 1;
        if (z) {
            return (i2 * 16) / 14;
        }
        return i2;
    }

    public static nm6 b(byte[] bArr) {
        if (bArr[0] == 127) {
            return new nm6(bArr);
        }
        byte[] bArrCopyOf = Arrays.copyOf(bArr, bArr.length);
        if (c(bArrCopyOf)) {
            for (int i = 0; i < bArrCopyOf.length - 1; i += 2) {
                byte b2 = bArrCopyOf[i];
                int i2 = i + 1;
                bArrCopyOf[i] = bArrCopyOf[i2];
                bArrCopyOf[i2] = b2;
            }
        }
        nm6 nm6Var = new nm6(bArrCopyOf);
        if (bArrCopyOf[0] == 31) {
            nm6 nm6Var2 = new nm6(bArrCopyOf);
            while (nm6Var2.b() >= 16) {
                nm6Var2.s(2);
                nm6Var.f(nm6Var2.h(14), 14);
            }
        }
        nm6Var.o(bArrCopyOf);
        return nm6Var;
    }

    public static boolean c(byte[] bArr) {
        byte b2 = bArr[0];
        return b2 == -2 || b2 == -1;
    }

    public static boolean d(int i) {
        return i == 2147385345 || i == -25230976 || i == 536864768 || i == -14745368;
    }

    public static int e(ByteBuffer byteBuffer) {
        int i;
        byte b2;
        int i2;
        byte b3;
        int iPosition = byteBuffer.position();
        byte b4 = byteBuffer.get(iPosition);
        if (b4 != -2) {
            if (b4 == -1) {
                i = (byteBuffer.get(iPosition + 4) & 7) << 4;
                b3 = byteBuffer.get(iPosition + 7);
            } else if (b4 != 31) {
                i = (byteBuffer.get(iPosition + 4) & 1) << 6;
                b2 = byteBuffer.get(iPosition + 5);
            } else {
                i = (byteBuffer.get(iPosition + 5) & 7) << 4;
                b3 = byteBuffer.get(iPosition + 6);
            }
            i2 = b3 & 60;
            return (((i2 >> 2) | i) + 1) * 32;
        }
        i = (byteBuffer.get(iPosition + 5) & 1) << 6;
        b2 = byteBuffer.get(iPosition + 4);
        i2 = b2 & 252;
        return (((i2 >> 2) | i) + 1) * 32;
    }

    public static int f(byte[] bArr) {
        int i;
        byte b2;
        int i2;
        byte b3;
        byte b4 = bArr[0];
        if (b4 != -2) {
            if (b4 == -1) {
                i = (bArr[4] & 7) << 4;
                b3 = bArr[7];
            } else if (b4 != 31) {
                i = (bArr[4] & 1) << 6;
                b2 = bArr[5];
            } else {
                i = (bArr[5] & 7) << 4;
                b3 = bArr[6];
            }
            i2 = b3 & 60;
            return (((i2 >> 2) | i) + 1) * 32;
        }
        i = (bArr[5] & 1) << 6;
        b2 = bArr[4];
        i2 = b2 & 252;
        return (((i2 >> 2) | i) + 1) * 32;
    }

    public static d g(byte[] bArr, @Nullable String str, @Nullable String str2, @Nullable DrmInitData drmInitData) {
        nm6 nm6VarB = b(bArr);
        nm6VarB.s(60);
        int i = f17472a[nm6VarB.h(6)];
        int i2 = f17474b[nm6VarB.h(4)];
        int iH = nm6VarB.h(5);
        int[] iArr = f17476c;
        int i3 = iH >= iArr.length ? -1 : (iArr[iH] * 1000) / 2;
        nm6VarB.s(10);
        return new d.b().S(str).e0("audio/vnd.dts").G(i3).H(i + (nm6VarB.h(2) > 0 ? 1 : 0)).f0(i2).M(drmInitData).V(str2).E();
    }
}

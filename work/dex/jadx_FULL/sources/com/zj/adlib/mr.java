package com.zj.adlib;

import androidx.annotation.Nullable;
import com.autonavi.amap.mapcore.tools.GlMapUtil;
import com.google.android.exoplayer2.d;
import com.google.android.exoplayer2.drm.DrmInitData;
import com.google.android.exoplayer2.source.i;
import com.google.common.primitives.SignedBytes;
import com.hzchengdun.securityguard.SecExceptionCode;
import java.nio.ByteBuffer;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_08_10593cls.dex */
public final class mr {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final int f43368a = 44096;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public static final int[] f18285a = {2002, 2000, 1920, SecExceptionCode.SEC_ERROR_SAFETOKEN_INVALID_PARAM, 1600, 1001, 1000, 960, 800, 800, GlMapUtil.DEVICE_DISPLAY_DPI_XHIGH, 400, 400, 2048};
    public static final int b = 44097;
    public static final int c = 336000;
    public static final int d = 2;
    public static final int e = 7;
    public static final int f = 16;

    public static final class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final int f43369a;
        public final int b;
        public final int c;
        public final int d;
        public final int e;

        public b(int i, int i2, int i3, int i4, int i5) {
            this.f43369a = i;
            this.c = i2;
            this.b = i3;
            this.d = i4;
            this.e = i5;
        }
    }

    public static void a(int i, om6 om6Var) {
        om6Var.O(7);
        byte[] bArrD = om6Var.d();
        bArrD[0] = -84;
        bArrD[1] = SignedBytes.f32242a;
        bArrD[2] = -1;
        bArrD[3] = -1;
        bArrD[4] = (byte) ((i >> 16) & 255);
        bArrD[5] = (byte) ((i >> 8) & 255);
        bArrD[6] = (byte) (i & 255);
    }

    public static d b(om6 om6Var, String str, String str2, @Nullable DrmInitData drmInitData) {
        om6Var.T(1);
        return new d.b().S(str).e0("audio/ac4").H(2).f0(((om6Var.G() & 32) >> 5) == 1 ? 48000 : i.K).M(drmInitData).V(str2).E();
    }

    public static int c(ByteBuffer byteBuffer) {
        byte[] bArr = new byte[16];
        int iPosition = byteBuffer.position();
        byteBuffer.get(bArr);
        byteBuffer.position(iPosition);
        return d(new nm6(bArr)).e;
    }

    /* JADX WARN: Code duplicated, block: B:43:0x0088  */
    /* JADX WARN: Code duplicated, block: B:47:0x008f  */
    /* JADX WARN: Code duplicated, block: B:48:0x0092  */
    public static b d(nm6 nm6Var) {
        int i;
        int i2;
        int iH = nm6Var.h(16);
        int iH2 = nm6Var.h(16);
        if (iH2 == 65535) {
            iH2 = nm6Var.h(24);
            i = 7;
        } else {
            i = 4;
        }
        int i3 = iH2 + i;
        if (iH == 44097) {
            i3 += 2;
        }
        int i4 = i3;
        int iH3 = nm6Var.h(2);
        if (iH3 == 3) {
            iH3 += f(nm6Var, 2);
        }
        int i5 = iH3;
        int iH4 = nm6Var.h(10);
        if (nm6Var.g() && nm6Var.h(3) > 0) {
            nm6Var.s(2);
        }
        int i6 = nm6Var.g() ? 48000 : 44100;
        int iH5 = nm6Var.h(4);
        if (i6 == 44100 && iH5 == 13) {
            i2 = f18285a[iH5];
        } else if (i6 == 48000) {
            int[] iArr = f18285a;
            if (iH5 < iArr.length) {
                int i7 = iArr[iH5];
                int i8 = iH4 % 5;
                if (i8 == 1) {
                    if (iH5 != 3 || iH5 == 8) {
                        i7++;
                    }
                } else if (i8 != 2) {
                    if (i8 != 3) {
                        if (i8 == 4 && (iH5 == 3 || iH5 == 8 || iH5 == 11)) {
                            i7++;
                        }
                    } else if (iH5 != 3) {
                        i7++;
                    } else {
                        i7++;
                    }
                } else if (iH5 == 8 || iH5 == 11) {
                    i7++;
                }
                i2 = i7;
            } else {
                i2 = 0;
            }
        } else {
            i2 = 0;
        }
        return new b(i5, 2, i6, i4, i2);
    }

    public static int e(byte[] bArr, int i) {
        int i2 = 7;
        if (bArr.length < 7) {
            return -1;
        }
        int i3 = ((bArr[2] & 255) << 8) | (bArr[3] & 255);
        if (i3 == 65535) {
            i3 = ((bArr[4] & 255) << 16) | ((bArr[5] & 255) << 8) | (bArr[6] & 255);
        } else {
            i2 = 4;
        }
        if (i == 44097) {
            i2 += 2;
        }
        return i3 + i2;
    }

    public static int f(nm6 nm6Var, int i) {
        int i2 = 0;
        while (true) {
            int iH = i2 + nm6Var.h(i);
            if (!nm6Var.g()) {
                return iH;
            }
            i2 = (iH + 1) << i;
        }
    }
}

package com.google.android.exoplayer2.audio;

import com.alibaba.ariver.commonability.device.jsapi.wifi.WifiManagerBridgeExtension;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import com.google.android.exoplayer2.ParserException;
import com.google.android.exoplayer2.util.Log;
import com.zj.adlib.nm6;
import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_08_10593cls.dex */
public final class AacUtil {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final int f30529a = 1024;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public static final String f2340a = "AacUtil";
    public static final int b = 1024;

    /* JADX INFO: renamed from: b, reason: collision with other field name */
    public static final String f2342b = "mp4a.40.";
    public static final int c = 2048;
    public static final int d = 512;
    public static final int e = 100000;
    public static final int f = 16000;
    public static final int g = 7000;
    public static final int h = 256000;
    public static final int i = 8000;
    public static final int j = 15;
    public static final int k = -1;
    public static final int l = 2;
    public static final int m = 5;
    public static final int n = 22;
    public static final int o = 23;
    public static final int p = 29;
    public static final int q = 31;
    public static final int r = 42;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public static final int[] f2341a = {96000, 88200, 64000, 48000, com.google.android.exoplayer2.source.i.K, com.google.android.exoplayer2.video.spherical.a.h, 24000, 22050, 16000, WifiManagerBridgeExtension.ERROR_12000, 11025, 8000, 7350};

    /* JADX INFO: renamed from: b, reason: collision with other field name */
    public static final int[] f2343b = {0, 1, 2, 3, 4, 5, 6, 8, -1, -1, -1, 7, 8, -1, 8, -1};

    @Target({ElementType.TYPE_USE})
    @Documented
    @Retention(RetentionPolicy.SOURCE)
    public @interface AacAudioObjectType {
    }

    public static final class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final int f30530a;

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        public final String f2344a;
        public final int b;

        public b(int i, int i2, String str) {
            this.f30530a = i;
            this.b = i2;
            this.f2344a = str;
        }
    }

    public static byte[] a(int i2, int i3) {
        int i4 = 0;
        int i5 = -1;
        int i6 = 0;
        while (true) {
            int[] iArr = f2341a;
            if (i6 >= iArr.length) {
                break;
            }
            if (i2 == iArr[i6]) {
                i5 = i6;
            }
            i6++;
        }
        int i7 = -1;
        while (true) {
            int[] iArr2 = f2343b;
            if (i4 >= iArr2.length) {
                break;
            }
            if (i3 == iArr2[i4]) {
                i7 = i4;
            }
            i4++;
        }
        if (i2 != -1 && i7 != -1) {
            return b(2, i5, i7);
        }
        throw new IllegalArgumentException("Invalid sample rate or number of channels: " + i2 + ", " + i3);
    }

    public static byte[] b(int i2, int i3, int i4) {
        return new byte[]{(byte) (((i2 << 3) & MediaPlayer.MEDIA_PLAYER_OPTION_ENABLE_SEEK_INTERRUPT) | ((i3 >> 1) & 7)), (byte) (((i3 << 7) & 128) | ((i4 << 3) & 120))};
    }

    public static int c(nm6 nm6Var) {
        int iH = nm6Var.h(5);
        return iH == 31 ? nm6Var.h(6) + 32 : iH;
    }

    public static int d(nm6 nm6Var) throws ParserException {
        int iH = nm6Var.h(4);
        if (iH == 15) {
            return nm6Var.h(24);
        }
        if (iH < 13) {
            return f2341a[iH];
        }
        throw ParserException.createForMalformedContainer(null, null);
    }

    public static b e(nm6 nm6Var, boolean z) throws ParserException {
        int iC = c(nm6Var);
        int iD = d(nm6Var);
        int iH = nm6Var.h(4);
        String str = "mp4a.40." + iC;
        if (iC == 5 || iC == 29) {
            iD = d(nm6Var);
            iC = c(nm6Var);
            if (iC == 22) {
                iH = nm6Var.h(4);
            }
        }
        if (z) {
            if (iC != 1 && iC != 2 && iC != 3 && iC != 4 && iC != 6 && iC != 7 && iC != 17) {
                switch (iC) {
                    case 19:
                    case 20:
                    case 21:
                    case 22:
                    case 23:
                        break;
                    default:
                        throw ParserException.createForUnsupportedContainerFeature("Unsupported audio object type: " + iC);
                }
            }
            g(nm6Var, iC, iH);
            switch (iC) {
                case 17:
                case 19:
                case 20:
                case 21:
                case 22:
                case 23:
                    int iH2 = nm6Var.h(2);
                    if (iH2 == 2 || iH2 == 3) {
                        throw ParserException.createForUnsupportedContainerFeature("Unsupported epConfig: " + iH2);
                    }
                    break;
            }
        }
        int i2 = f2343b[iH];
        if (i2 != -1) {
            return new b(iD, i2, str);
        }
        throw ParserException.createForMalformedContainer(null, null);
    }

    public static b f(byte[] bArr) throws ParserException {
        return e(new nm6(bArr), false);
    }

    public static void g(nm6 nm6Var, int i2, int i3) {
        if (nm6Var.g()) {
            Log.n(f2340a, "Unexpected frameLengthFlag = 1");
        }
        if (nm6Var.g()) {
            nm6Var.s(14);
        }
        boolean zG = nm6Var.g();
        if (i3 == 0) {
            throw new UnsupportedOperationException();
        }
        if (i2 == 6 || i2 == 20) {
            nm6Var.s(3);
        }
        if (zG) {
            if (i2 == 22) {
                nm6Var.s(16);
            }
            if (i2 == 17 || i2 == 19 || i2 == 20 || i2 == 23) {
                nm6Var.s(3);
            }
            nm6Var.s(1);
        }
    }
}

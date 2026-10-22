package com.google.android.exoplayer2.extractor.avi;

import androidx.annotation.Nullable;
import com.google.android.exoplayer2.extractor.mkv.MatroskaExtractor;
import com.google.android.exoplayer2.util.Log;
import com.google.common.collect.ImmutableList;
import com.zj.adlib.gj9;
import com.zj.adlib.om6;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_08_10593cls.dex */
public final class e implements AviChunk {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final String f30635a = "StreamFormatChunk";

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final com.google.android.exoplayer2.d f2733a;

    public e(com.google.android.exoplayer2.d dVar) {
        this.f2733a = dVar;
    }

    @Nullable
    public static String a(int i) {
        switch (i) {
            case 808802372:
            case 877677894:
            case 1145656883:
            case 1145656920:
            case MatroskaExtractor.u1 /* 1482049860 */:
            case 1684633208:
            case 2021026148:
                return "video/mp4v-es";
            case 826496577:
            case 828601953:
            case 875967048:
                return "video/avc";
            case 842289229:
                return "video/mp42";
            case 859066445:
                return "video/mp43";
            case 1196444237:
            case 1735420525:
                return "video/mjpeg";
            default:
                return null;
        }
    }

    @Nullable
    public static String b(int i) {
        if (i == 1) {
            return "audio/raw";
        }
        if (i == 85) {
            return "audio/mpeg";
        }
        if (i == 255) {
            return "audio/mp4a-latm";
        }
        if (i == 8192) {
            return "audio/ac3";
        }
        if (i != 8193) {
            return null;
        }
        return "audio/vnd.dts";
    }

    @Nullable
    public static AviChunk c(om6 om6Var) {
        om6Var.T(4);
        int iR = om6Var.r();
        int iR2 = om6Var.r();
        om6Var.T(4);
        int iR3 = om6Var.r();
        String strA = a(iR3);
        if (strA != null) {
            com.google.android.exoplayer2.d.b bVar = new com.google.android.exoplayer2.d.b();
            bVar.j0(iR).Q(iR2).e0(strA);
            return new e(bVar.E());
        }
        Log.n(f30635a, "Ignoring track with unsupported compression " + iR3);
        return null;
    }

    @Nullable
    public static AviChunk d(int i, om6 om6Var) {
        if (i == 2) {
            return c(om6Var);
        }
        if (i == 1) {
            return e(om6Var);
        }
        Log.n(f30635a, "Ignoring strf box for unsupported track type: " + gj9.x0(i));
        return null;
    }

    @Nullable
    public static AviChunk e(om6 om6Var) {
        int iY = om6Var.y();
        String strB = b(iY);
        if (strB == null) {
            Log.n(f30635a, "Ignoring track with unsupported format tag " + iY);
            return null;
        }
        int iY2 = om6Var.y();
        int iR = om6Var.r();
        om6Var.T(6);
        int iN0 = gj9.n0(om6Var.M());
        int iY3 = om6Var.y();
        byte[] bArr = new byte[iY3];
        om6Var.k(bArr, 0, iY3);
        com.google.android.exoplayer2.d.b bVar = new com.google.android.exoplayer2.d.b();
        bVar.e0(strB).H(iY2).f0(iR);
        if ("audio/raw".equals(strB) && iN0 != 0) {
            bVar.Y(iN0);
        }
        if ("audio/mp4a-latm".equals(strB) && iY3 > 0) {
            bVar.T(ImmutableList.of(bArr));
        }
        return new e(bVar.E());
    }

    @Override // com.google.android.exoplayer2.extractor.avi.AviChunk
    public int getType() {
        return 1718776947;
    }
}

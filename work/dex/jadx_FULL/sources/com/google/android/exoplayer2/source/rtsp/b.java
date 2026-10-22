package com.google.android.exoplayer2.source.rtsp;

import androidx.annotation.Nullable;
import com.google.common.collect.ImmutableMap;
import com.zj.adlib.sb0;
import java.util.Map;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_08_10593cls.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final String f30969a = "AC3";
    public static final String b = "AMR";
    public static final String c = "AMR-WB";
    public static final String d = "MPEG4-GENERIC";
    public static final String e = "MP4V-ES";
    public static final String f = "H263-1998";
    public static final String g = "H263-2000";
    public static final String h = "H264";
    public static final String i = "H265";
    public static final String j = "OPUS";
    public static final String k = "L8";
    public static final String l = "L16";
    public static final String m = "PCMA";
    public static final String n = "PCMU";
    public static final String o = "VP8";
    public static final String p = "VP9";

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final int f4393a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final com.google.android.exoplayer2.d f4394a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final ImmutableMap<String, String> f4395a;

    /* JADX INFO: renamed from: b, reason: collision with other field name */
    public final int f4396b;

    public b(com.google.android.exoplayer2.d dVar, int i2, int i3, Map<String, String> map) {
        this.f4393a = i2;
        this.f4396b = i3;
        this.f4394a = dVar;
        this.f4395a = ImmutableMap.copyOf((Map) map);
    }

    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    public static String a(String str) {
        String strJ = com.google.common.base.a.j(str);
        strJ.hashCode();
        byte b2 = -1;
        switch (strJ.hashCode()) {
            case -1922091719:
                if (strJ.equals(d)) {
                    b2 = 0;
                }
                break;
            case 2412:
                if (strJ.equals(k)) {
                    b2 = 1;
                }
                break;
            case 64593:
                if (strJ.equals(f30969a)) {
                    b2 = 2;
                }
                break;
            case 64934:
                if (strJ.equals(b)) {
                    b2 = 3;
                }
                break;
            case 74609:
                if (strJ.equals(l)) {
                    b2 = 4;
                }
                break;
            case 85182:
                if (strJ.equals(o)) {
                    b2 = 5;
                }
                break;
            case 85183:
                if (strJ.equals(p)) {
                    b2 = 6;
                }
                break;
            case 2194728:
                if (strJ.equals(h)) {
                    b2 = 7;
                }
                break;
            case 2194729:
                if (strJ.equals(i)) {
                    b2 = 8;
                }
                break;
            case 2433087:
                if (strJ.equals(j)) {
                    b2 = 9;
                }
                break;
            case 2450119:
                if (strJ.equals(m)) {
                    b2 = 10;
                }
                break;
            case 2450139:
                if (strJ.equals(n)) {
                    b2 = 11;
                }
                break;
            case 1934494802:
                if (strJ.equals(c)) {
                    b2 = 12;
                }
                break;
            case 1959269366:
                if (strJ.equals(e)) {
                    b2 = 13;
                }
                break;
            case 2137188397:
                if (strJ.equals(f)) {
                    b2 = com.google.common.base.a.p;
                }
                break;
            case 2137209252:
                if (strJ.equals(g)) {
                    b2 = com.google.common.base.a.q;
                }
                break;
        }
        switch (b2) {
            case 0:
                return "audio/mp4a-latm";
            case 1:
            case 4:
                return "audio/raw";
            case 2:
                return "audio/ac3";
            case 3:
                return "audio/3gpp";
            case 5:
                return "video/x-vnd.on2.vp8";
            case 6:
                return "video/x-vnd.on2.vp9";
            case 7:
                return "video/avc";
            case 8:
                return "video/hevc";
            case 9:
                return "audio/opus";
            case 10:
                return "audio/g711-alaw";
            case 11:
                return "audio/g711-mlaw";
            case 12:
                return "audio/amr-wb";
            case 13:
                return "video/mp4v-es";
            case 14:
            case 15:
                return "video/3gpp";
            default:
                throw new IllegalArgumentException(str);
        }
    }

    public static int b(String str) {
        sb0.a(str.equals(k) || str.equals(l));
        return str.equals(k) ? 3 : 268435456;
    }

    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    public static boolean c(MediaDescription mediaDescription) {
        String strJ = com.google.common.base.a.j(mediaDescription.f4304a.f4316a);
        strJ.hashCode();
        byte b2 = -1;
        switch (strJ.hashCode()) {
            case -1922091719:
                if (strJ.equals(d)) {
                    b2 = 0;
                }
                break;
            case 2412:
                if (strJ.equals(k)) {
                    b2 = 1;
                }
                break;
            case 64593:
                if (strJ.equals(f30969a)) {
                    b2 = 2;
                }
                break;
            case 64934:
                if (strJ.equals(b)) {
                    b2 = 3;
                }
                break;
            case 74609:
                if (strJ.equals(l)) {
                    b2 = 4;
                }
                break;
            case 85182:
                if (strJ.equals(o)) {
                    b2 = 5;
                }
                break;
            case 85183:
                if (strJ.equals(p)) {
                    b2 = 6;
                }
                break;
            case 2194728:
                if (strJ.equals(h)) {
                    b2 = 7;
                }
                break;
            case 2194729:
                if (strJ.equals(i)) {
                    b2 = 8;
                }
                break;
            case 2433087:
                if (strJ.equals(j)) {
                    b2 = 9;
                }
                break;
            case 2450119:
                if (strJ.equals(m)) {
                    b2 = 10;
                }
                break;
            case 2450139:
                if (strJ.equals(n)) {
                    b2 = 11;
                }
                break;
            case 1934494802:
                if (strJ.equals(c)) {
                    b2 = 12;
                }
                break;
            case 1959269366:
                if (strJ.equals(e)) {
                    b2 = 13;
                }
                break;
            case 2137188397:
                if (strJ.equals(f)) {
                    b2 = com.google.common.base.a.p;
                }
                break;
            case 2137209252:
                if (strJ.equals(g)) {
                    b2 = com.google.common.base.a.q;
                }
                break;
        }
        switch (b2) {
            case 0:
            case 1:
            case 2:
            case 3:
            case 4:
            case 5:
            case 6:
            case 7:
            case 8:
            case 9:
            case 10:
            case 11:
            case 12:
            case 13:
            case 14:
            case 15:
                return true;
            default:
                return false;
        }
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || b.class != obj.getClass()) {
            return false;
        }
        b bVar = (b) obj;
        return this.f4393a == bVar.f4393a && this.f4396b == bVar.f4396b && this.f4394a.equals(bVar.f4394a) && this.f4395a.equals(bVar.f4395a);
    }

    public int hashCode() {
        return ((((((217 + this.f4393a) * 31) + this.f4396b) * 31) + this.f4394a.hashCode()) * 31) + this.f4395a.hashCode();
    }
}

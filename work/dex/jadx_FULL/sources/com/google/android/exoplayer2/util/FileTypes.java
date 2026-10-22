package com.google.android.exoplayer2.util;

import android.net.Uri;
import androidx.annotation.Nullable;
import androidx.annotation.VisibleForTesting;
import com.zj.adlib.bp5;
import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_08_10593cls.dex */
public final class FileTypes {
    public static final String A = ".ts";
    public static final String B = ".wav";
    public static final String C = ".wave";
    public static final String D = ".vtt";
    public static final String E = ".webvtt";
    public static final String F = ".jpg";
    public static final String G = ".jpeg";
    public static final String H = ".avi";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final int f31154a = -1;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @VisibleForTesting
    public static final String f5237a = "Content-Type";
    public static final int b = 0;

    /* JADX INFO: renamed from: b, reason: collision with other field name */
    public static final String f5238b = ".ac3";
    public static final int c = 1;

    /* JADX INFO: renamed from: c, reason: collision with other field name */
    public static final String f5239c = ".ec3";
    public static final int d = 2;

    /* JADX INFO: renamed from: d, reason: collision with other field name */
    public static final String f5240d = ".ac4";
    public static final int e = 3;

    /* JADX INFO: renamed from: e, reason: collision with other field name */
    public static final String f5241e = ".adts";
    public static final int f = 4;

    /* JADX INFO: renamed from: f, reason: collision with other field name */
    public static final String f5242f = ".aac";
    public static final int g = 5;

    /* JADX INFO: renamed from: g, reason: collision with other field name */
    public static final String f5243g = ".amr";
    public static final int h = 6;

    /* JADX INFO: renamed from: h, reason: collision with other field name */
    public static final String f5244h = ".flac";
    public static final int i = 7;

    /* JADX INFO: renamed from: i, reason: collision with other field name */
    public static final String f5245i = ".flv";
    public static final int j = 8;

    /* JADX INFO: renamed from: j, reason: collision with other field name */
    public static final String f5246j = ".mid";
    public static final int k = 9;

    /* JADX INFO: renamed from: k, reason: collision with other field name */
    public static final String f5247k = ".midi";
    public static final int l = 10;

    /* JADX INFO: renamed from: l, reason: collision with other field name */
    public static final String f5248l = ".smf";
    public static final int m = 11;

    /* JADX INFO: renamed from: m, reason: collision with other field name */
    public static final String f5249m = ".mk";
    public static final int n = 12;

    /* JADX INFO: renamed from: n, reason: collision with other field name */
    public static final String f5250n = ".webm";
    public static final int o = 13;

    /* JADX INFO: renamed from: o, reason: collision with other field name */
    public static final String f5251o = ".og";
    public static final int p = 14;

    /* JADX INFO: renamed from: p, reason: collision with other field name */
    public static final String f5252p = ".opus";
    public static final int q = 15;

    /* JADX INFO: renamed from: q, reason: collision with other field name */
    public static final String f5253q = ".mp3";
    public static final int r = 16;

    /* JADX INFO: renamed from: r, reason: collision with other field name */
    public static final String f5254r = ".mp4";
    public static final String s = ".m4";
    public static final String t = ".mp4";
    public static final String u = ".cmf";
    public static final String v = ".ps";
    public static final String w = ".mpeg";
    public static final String x = ".mpg";
    public static final String y = ".m2p";
    public static final String z = ".ts";

    @Target({ElementType.TYPE_USE})
    @Documented
    @Retention(RetentionPolicy.SOURCE)
    public @interface Type {
    }

    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    public static int a(@Nullable String str) {
        byte b2;
        if (str == null) {
            return -1;
        }
        String strU = bp5.u(str);
        strU.hashCode();
        switch (strU.hashCode()) {
            case -2123537834:
                b2 = !strU.equals("audio/eac3-joc") ? (byte) -1 : (byte) 0;
                break;
            case -1662384011:
                b2 = !strU.equals("video/mp2p") ? (byte) -1 : (byte) 1;
                break;
            case -1662384007:
                b2 = !strU.equals("video/mp2t") ? (byte) -1 : (byte) 2;
                break;
            case -1662095187:
                b2 = !strU.equals("video/webm") ? (byte) -1 : (byte) 3;
                break;
            case -1606874997:
                b2 = !strU.equals("audio/amr-wb") ? (byte) -1 : (byte) 4;
                break;
            case -1487394660:
                b2 = !strU.equals("image/jpeg") ? (byte) -1 : (byte) 5;
                break;
            case -1248337486:
                b2 = !strU.equals("application/mp4") ? (byte) -1 : (byte) 6;
                break;
            case -1079884372:
                b2 = !strU.equals("video/x-msvideo") ? (byte) -1 : (byte) 7;
                break;
            case -1004728940:
                b2 = !strU.equals("text/vtt") ? (byte) -1 : (byte) 8;
                break;
            case -387023398:
                b2 = !strU.equals("audio/x-matroska") ? (byte) -1 : (byte) 9;
                break;
            case -43467528:
                b2 = !strU.equals("application/webm") ? (byte) -1 : (byte) 10;
                break;
            case 13915911:
                b2 = !strU.equals("video/x-flv") ? (byte) -1 : (byte) 11;
                break;
            case 187078296:
                b2 = !strU.equals("audio/ac3") ? (byte) -1 : (byte) 12;
                break;
            case 187078297:
                b2 = !strU.equals("audio/ac4") ? (byte) -1 : (byte) 13;
                break;
            case 187078669:
                b2 = !strU.equals("audio/amr") ? (byte) -1 : (byte) 14;
                break;
            case 187090232:
                b2 = !strU.equals("audio/mp4") ? (byte) -1 : (byte) 15;
                break;
            case 187091926:
                b2 = !strU.equals("audio/ogg") ? (byte) -1 : (byte) 16;
                break;
            case 187099443:
                b2 = !strU.equals("audio/wav") ? (byte) -1 : (byte) 17;
                break;
            case 1331848029:
                b2 = !strU.equals("video/mp4") ? (byte) -1 : com.google.common.base.a.u;
                break;
            case 1503095341:
                b2 = !strU.equals("audio/3gpp") ? (byte) -1 : (byte) 19;
                break;
            case 1504578661:
                b2 = !strU.equals("audio/eac3") ? (byte) -1 : com.google.common.base.a.x;
                break;
            case 1504619009:
                b2 = !strU.equals("audio/flac") ? (byte) -1 : com.google.common.base.a.y;
                break;
            case 1504824762:
                b2 = !strU.equals("audio/midi") ? (byte) -1 : com.google.common.base.a.z;
                break;
            case 1504831518:
                b2 = !strU.equals("audio/mpeg") ? (byte) -1 : com.google.common.base.a.A;
                break;
            case 1505118770:
                b2 = !strU.equals("audio/webm") ? (byte) -1 : com.google.common.base.a.B;
                break;
            case 2039520277:
                b2 = !strU.equals("video/x-matroska") ? (byte) -1 : com.google.common.base.a.C;
                break;
            default:
                b2 = -1;
                break;
        }
        switch (b2) {
            case 0:
            case 12:
            case 20:
                return 0;
            case 1:
                return 10;
            case 2:
                return 11;
            case 3:
            case 9:
            case 10:
            case 24:
            case 25:
                return 6;
            case 4:
            case 14:
            case 19:
                return 3;
            case 5:
                return 14;
            case 6:
            case 15:
            case 18:
                return 8;
            case 7:
                return 16;
            case 8:
                return 13;
            case 11:
                return 5;
            case 13:
                return 1;
            case 16:
                return 9;
            case 17:
                return 12;
            case 21:
                return 4;
            case 22:
                return 15;
            case 23:
                return 7;
            default:
                return -1;
        }
    }

    public static int b(Map<String, List<String>> map) {
        List<String> list = map.get("Content-Type");
        return a((list == null || list.isEmpty()) ? null : list.get(0));
    }

    public static int c(Uri uri) {
        String lastPathSegment = uri.getLastPathSegment();
        if (lastPathSegment == null) {
            return -1;
        }
        if (lastPathSegment.endsWith(f5238b) || lastPathSegment.endsWith(f5239c)) {
            return 0;
        }
        if (lastPathSegment.endsWith(f5240d)) {
            return 1;
        }
        if (lastPathSegment.endsWith(f5241e) || lastPathSegment.endsWith(f5242f)) {
            return 2;
        }
        if (lastPathSegment.endsWith(f5243g)) {
            return 3;
        }
        if (lastPathSegment.endsWith(f5244h)) {
            return 4;
        }
        if (lastPathSegment.endsWith(f5245i)) {
            return 5;
        }
        if (lastPathSegment.endsWith(f5246j) || lastPathSegment.endsWith(f5247k) || lastPathSegment.endsWith(f5248l)) {
            return 15;
        }
        if (lastPathSegment.startsWith(f5249m, lastPathSegment.length() - 4) || lastPathSegment.endsWith(f5250n)) {
            return 6;
        }
        if (lastPathSegment.endsWith(f5253q)) {
            return 7;
        }
        if (lastPathSegment.endsWith(".mp4") || lastPathSegment.startsWith(s, lastPathSegment.length() - 4) || lastPathSegment.startsWith(".mp4", lastPathSegment.length() - 5) || lastPathSegment.startsWith(u, lastPathSegment.length() - 5)) {
            return 8;
        }
        if (lastPathSegment.startsWith(f5251o, lastPathSegment.length() - 4) || lastPathSegment.endsWith(f5252p)) {
            return 9;
        }
        if (lastPathSegment.endsWith(v) || lastPathSegment.endsWith(w) || lastPathSegment.endsWith(x) || lastPathSegment.endsWith(y)) {
            return 10;
        }
        if (lastPathSegment.endsWith(".ts") || lastPathSegment.startsWith(".ts", lastPathSegment.length() - 4)) {
            return 11;
        }
        if (lastPathSegment.endsWith(B) || lastPathSegment.endsWith(C)) {
            return 12;
        }
        if (lastPathSegment.endsWith(D) || lastPathSegment.endsWith(E)) {
            return 13;
        }
        if (lastPathSegment.endsWith(F) || lastPathSegment.endsWith(".jpeg")) {
            return 14;
        }
        return lastPathSegment.endsWith(H) ? 16 : -1;
    }
}

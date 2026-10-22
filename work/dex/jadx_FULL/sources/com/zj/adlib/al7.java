package com.zj.adlib;

import com.google.android.exoplayer2.ParserException;
import com.google.android.exoplayer2.source.rtsp.g;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_08_10593cls.dex */
public final class al7 {

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public static final String f15286a = "npt=%.3f-";
    public static final long c = 0;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final long f15288a;
    public final long b;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final al7 f40549a = new al7(0, -9223372036854775807L);

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public static final Pattern f15287a = Pattern.compile("npt[:=]([.\\d]+|now)\\s?-\\s?([.\\d]+)?");

    public al7(long j, long j2) {
        this.f15288a = j;
        this.b = j2;
    }

    public static String b(long j) {
        return gj9.H(f15286a, Double.valueOf(j / 1000.0d));
    }

    public static al7 d(String str) throws ParserException {
        long j;
        Matcher matcher = f15287a.matcher(str);
        g.a(matcher.matches(), str);
        String strGroup = matcher.group(1);
        g.a(strGroup != null, str);
        long j2 = ((String) gj9.k(strGroup)).equals("now") ? 0L : (long) (Float.parseFloat(strGroup) * 1000.0f);
        String strGroup2 = matcher.group(2);
        if (strGroup2 != null) {
            try {
                j = (long) (Float.parseFloat(strGroup2) * 1000.0f);
                g.a(j >= j2, str);
            } catch (NumberFormatException e) {
                throw ParserException.createForMalformedManifest(strGroup2, e);
            }
        } else {
            j = -9223372036854775807L;
        }
        return new al7(j2, j);
    }

    public long a() {
        return this.b - this.f15288a;
    }

    public boolean c() {
        return this.b == -9223372036854775807L;
    }
}

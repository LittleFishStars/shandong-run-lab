package com.zj.adlib;

import androidx.annotation.Nullable;
import com.google.android.exoplayer2.ParserException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_08_10593cls.dex */
public final class hv9 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final String f42215a = "WEBVTT";

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public static final Pattern f17082a = Pattern.compile("^NOTE([ \t].*)?$");

    @Nullable
    public static Matcher a(om6 om6Var) {
        String strQ;
        while (true) {
            String strQ2 = om6Var.q();
            if (strQ2 == null) {
                return null;
            }
            if (f17082a.matcher(strQ2).matches()) {
                do {
                    strQ = om6Var.q();
                    if (strQ == null) {
                        break;
                    }
                } while (!strQ.isEmpty());
            } else {
                Matcher matcher = dv9.f16125a.matcher(strQ2);
                if (matcher.matches()) {
                    return matcher;
                }
            }
        }
    }

    public static boolean b(om6 om6Var) {
        String strQ = om6Var.q();
        return strQ != null && strQ.startsWith(f42215a);
    }

    public static float c(String str) throws NumberFormatException {
        if (str.endsWith("%")) {
            return Float.parseFloat(str.substring(0, str.length() - 1)) / 100.0f;
        }
        throw new NumberFormatException("Percentages must end with %");
    }

    public static long d(String str) throws NumberFormatException {
        String[] strArrV1 = gj9.v1(str, "\\.");
        long j = 0;
        for (String str2 : gj9.u1(strArrV1[0], u15.f19942b)) {
            j = (j * 60) + Long.parseLong(str2);
        }
        long j2 = j * 1000;
        if (strArrV1.length == 2) {
            j2 += Long.parseLong(strArrV1[1]);
        }
        return j2 * 1000;
    }

    public static void e(om6 om6Var) throws ParserException {
        int iE = om6Var.e();
        if (b(om6Var)) {
            return;
        }
        om6Var.S(iE);
        throw ParserException.createForMalformedContainer("Expected WEBVTT. Got " + om6Var.q(), null);
    }
}

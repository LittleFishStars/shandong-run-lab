package com.google.android.exoplayer2.extractor;

import com.google.android.exoplayer2.util.Log;
import com.zj.adlib.om6;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_08_10593cls.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final int f30627a = 1195456820;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public static final String f2707a = "CeaUtil";
    public static final int b = 3;
    public static final int c = 4;
    public static final int d = 181;
    public static final int e = 49;
    public static final int f = 47;

    public static void a(long j, om6 om6Var, TrackOutput[] trackOutputArr) {
        while (true) {
            if (om6Var.a() <= 1) {
                return;
            }
            int iC = c(om6Var);
            int iC2 = c(om6Var);
            int iE = om6Var.e() + iC2;
            if (iC2 == -1 || iC2 > om6Var.a()) {
                Log.n(f2707a, "Skipping remainder of malformed SEI NAL unit.");
                iE = om6Var.f();
            } else if (iC == 4 && iC2 >= 8) {
                int iG = om6Var.G();
                int iM = om6Var.M();
                int iO = iM == 49 ? om6Var.o() : 0;
                int iG2 = om6Var.G();
                if (iM == 47) {
                    om6Var.T(1);
                }
                boolean z = iG == 181 && (iM == 49 || iM == 47) && iG2 == 3;
                if (iM == 49) {
                    z &= iO == 1195456820;
                }
                if (z) {
                    b(j, om6Var, trackOutputArr);
                }
            }
            om6Var.S(iE);
        }
    }

    public static void b(long j, om6 om6Var, TrackOutput[] trackOutputArr) {
        int iG = om6Var.G();
        if ((iG & 64) != 0) {
            om6Var.T(1);
            int i = (iG & 31) * 3;
            int iE = om6Var.e();
            for (TrackOutput trackOutput : trackOutputArr) {
                om6Var.S(iE);
                trackOutput.c(om6Var, i);
                if (j != -9223372036854775807L) {
                    trackOutput.e(j, 1, i, 0, null);
                }
            }
        }
    }

    public static int c(om6 om6Var) {
        int i = 0;
        while (om6Var.a() != 0) {
            int iG = om6Var.G();
            i += iG;
            if (iG != 255) {
                return i;
            }
        }
        return -1;
    }
}

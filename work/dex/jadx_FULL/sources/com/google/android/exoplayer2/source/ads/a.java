package com.google.android.exoplayer2.source.ads;

import androidx.annotation.CheckResult;
import com.google.android.exoplayer2.Player;
import com.google.android.exoplayer2.Timeline;
import com.zj.adlib.gj9;
import com.zj.adlib.gk5;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_08_10593cls.dex */
public final class a {
    @CheckResult
    public static AdPlaybackState a(AdPlaybackState adPlaybackState, long j, long j2, long... jArr) {
        long jF = f(j, -1, adPlaybackState);
        int i = adPlaybackState.L;
        while (i < adPlaybackState.K && adPlaybackState.e(i).f3768a != Long.MIN_VALUE && adPlaybackState.e(i).f3768a <= jF) {
            i++;
        }
        AdPlaybackState adPlaybackStateS = adPlaybackState.u(i, jF).t(i, true).k(i, jArr.length).l(i, jArr).s(i, j2);
        AdPlaybackState adPlaybackStateY = adPlaybackStateS;
        for (int i2 = 0; i2 < jArr.length && jArr[i2] == 0; i2++) {
            adPlaybackStateY = adPlaybackStateY.y(i, i2);
        }
        return b(adPlaybackStateY, i, gj9.z1(jArr), j2);
    }

    public static AdPlaybackState b(AdPlaybackState adPlaybackState, int i, long j, long j2) {
        long j3 = (-j) + j2;
        while (true) {
            i++;
            if (i >= adPlaybackState.K) {
                return adPlaybackState;
            }
            long j4 = adPlaybackState.e(i).f3768a;
            if (j4 != Long.MIN_VALUE) {
                adPlaybackState = adPlaybackState.n(i, j4 + j3);
            }
        }
    }

    public static int c(AdPlaybackState adPlaybackState, int i) {
        int i2 = adPlaybackState.e(i).K;
        if (i2 == -1) {
            return 0;
        }
        return i2;
    }

    public static long d(long j, gk5 gk5Var, AdPlaybackState adPlaybackState) {
        return gk5Var.c() ? e(j, gk5Var.f41928a, gk5Var.b, adPlaybackState) : f(j, gk5Var.c, adPlaybackState);
    }

    public static long e(long j, int i, int i2, AdPlaybackState adPlaybackState) {
        int i3;
        AdPlaybackState.b bVarE = adPlaybackState.e(i);
        long j2 = j - bVarE.f3768a;
        int i4 = adPlaybackState.L;
        while (true) {
            i3 = 0;
            if (i4 >= i) {
                break;
            }
            AdPlaybackState.b bVarE2 = adPlaybackState.e(i4);
            while (i3 < c(adPlaybackState, i4)) {
                j2 -= bVarE2.f3771a[i3];
                i3++;
            }
            j2 += bVarE2.b;
            i4++;
        }
        if (i2 < c(adPlaybackState, i)) {
            while (i3 < i2) {
                j2 -= bVarE.f3771a[i3];
                i3++;
            }
        }
        return j2;
    }

    public static long f(long j, int i, AdPlaybackState adPlaybackState) {
        if (i == -1) {
            i = adPlaybackState.K;
        }
        long j2 = 0;
        for (int i2 = adPlaybackState.L; i2 < i; i2++) {
            AdPlaybackState.b bVarE = adPlaybackState.e(i2);
            long j3 = bVarE.f3768a;
            if (j3 == Long.MIN_VALUE || j3 > j - j2) {
                break;
            }
            for (int i3 = 0; i3 < c(adPlaybackState, i2); i3++) {
                j2 += bVarE.f3771a[i3];
            }
            long j4 = bVarE.b;
            j2 -= j4;
            long j5 = bVarE.f3768a;
            long j6 = j - j2;
            if (j4 + j5 > j6) {
                return Math.max(j5, j6);
            }
        }
        return j - j2;
    }

    public static long g(long j, gk5 gk5Var, AdPlaybackState adPlaybackState) {
        return gk5Var.c() ? i(j, gk5Var.f41928a, gk5Var.b, adPlaybackState) : j(j, gk5Var.c, adPlaybackState);
    }

    public static long h(Player player, AdPlaybackState adPlaybackState) {
        Timeline timelineA0 = player.a0();
        if (timelineA0.w()) {
            return -9223372036854775807L;
        }
        Timeline.b bVarJ = timelineA0.j(player.getCurrentPeriodIndex(), new Timeline.b());
        if (!gj9.c(bVarJ.l(), adPlaybackState.f3766a)) {
            return -9223372036854775807L;
        }
        if (!player.isPlayingAd()) {
            return j(gj9.Z0(player.getCurrentPosition()) - bVarJ.s(), -1, adPlaybackState);
        }
        return i(gj9.Z0(player.getCurrentPosition()), player.getCurrentAdGroupIndex(), player.getCurrentAdIndexInAdGroup(), adPlaybackState);
    }

    public static long i(long j, int i, int i2, AdPlaybackState adPlaybackState) {
        int i3;
        AdPlaybackState.b bVarE = adPlaybackState.e(i);
        long j2 = j + bVarE.f3768a;
        int i4 = adPlaybackState.L;
        while (true) {
            i3 = 0;
            if (i4 >= i) {
                break;
            }
            AdPlaybackState.b bVarE2 = adPlaybackState.e(i4);
            while (i3 < c(adPlaybackState, i4)) {
                j2 += bVarE2.f3771a[i3];
                i3++;
            }
            j2 -= bVarE2.b;
            i4++;
        }
        if (i2 < c(adPlaybackState, i)) {
            while (i3 < i2) {
                j2 += bVarE.f3771a[i3];
                i3++;
            }
        }
        return j2;
    }

    public static long j(long j, int i, AdPlaybackState adPlaybackState) {
        if (i == -1) {
            i = adPlaybackState.K;
        }
        long j2 = 0;
        for (int i2 = adPlaybackState.L; i2 < i; i2++) {
            AdPlaybackState.b bVarE = adPlaybackState.e(i2);
            long j3 = bVarE.f3768a;
            if (j3 == Long.MIN_VALUE || j3 > j) {
                break;
            }
            long j4 = j3 + j2;
            for (int i3 = 0; i3 < c(adPlaybackState, i2); i3++) {
                j2 += bVarE.f3771a[i3];
            }
            long j5 = bVarE.b;
            j2 -= j5;
            if (bVarE.f3768a + j5 > j) {
                return Math.max(j4, j + j2);
            }
        }
        return j + j2;
    }
}

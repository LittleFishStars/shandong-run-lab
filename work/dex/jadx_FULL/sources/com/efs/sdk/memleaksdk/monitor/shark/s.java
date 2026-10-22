package com.efs.sdk.memleaksdk.monitor.shark;

import android.support.v4.media.session.PlaybackStateCompat;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_08_10593cls.dex */
final class s {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    static r f29885a;
    static long b;

    private s() {
    }

    public static r a() {
        synchronized (s.class) {
            r rVar = f29885a;
            if (rVar == null) {
                return new r();
            }
            f29885a = rVar.f;
            rVar.f = null;
            b -= 8192;
            return rVar;
        }
    }

    public static void a(r rVar) {
        if (rVar.f == null && rVar.g == null) {
            if (rVar.d) {
                return;
            }
            synchronized (s.class) {
                long j = b;
                if (j + 8192 > PlaybackStateCompat.ACTION_PREPARE_FROM_SEARCH) {
                    return;
                }
                b = j + 8192;
                rVar.f = f29885a;
                rVar.c = 0;
                rVar.b = 0;
                f29885a = rVar;
                return;
            }
        }
        throw new IllegalArgumentException();
    }
}

package com.byazt.na;

import android.support.v4.media.session.PlaybackStateCompat;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_11_8719cls.dex */
@com.byazt.zqa.c(c = {0, 1, 662, 91})
public final class sp {
    public static a c;
    public static long tt;

    private sp() {
    }

    public static a c() {
        synchronized (sp.class) {
            a aVar = c;
            if (aVar == null) {
                return new a();
            }
            c = aVar.f28805a;
            aVar.f28805a = null;
            tt -= 8192;
            return aVar;
        }
    }

    public static void c(a aVar) {
        if (aVar.f28805a == null && aVar.sp == null) {
            if (aVar.uj) {
                return;
            }
            synchronized (sp.class) {
                long j = tt;
                if (j + 8192 > PlaybackStateCompat.ACTION_PREPARE_FROM_SEARCH) {
                    return;
                }
                tt = j + 8192;
                aVar.f28805a = c;
                aVar.ve = 0;
                aVar.tt = 0;
                c = aVar;
                return;
            }
        }
        throw new IllegalArgumentException();
    }
}

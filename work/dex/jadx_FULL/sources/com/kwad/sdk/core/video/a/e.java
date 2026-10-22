package com.kwad.sdk.core.video.a;

import android.content.Context;
import androidx.annotation.NonNull;
import com.kwad.sdk.core.report.g;
import com.kwad.sdk.core.report.n;
import com.kwad.sdk.service.ServiceProvider;
import com.kwad.sdk.utils.ax;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
public final class e {
    private static AtomicBoolean aZt = null;
    private static int aZu = -1;
    private static final AtomicBoolean aZv = new AtomicBoolean(false);
    private static final AtomicBoolean aZw = new AtomicBoolean(false);
    private static int aZx = 0;
    private static boolean amw = false;

    public static boolean HZ() {
        return aZw.get() || com.kwad.framework.a.a.OB.booleanValue();
    }

    public static int OK() {
        return aZx;
    }

    public static boolean OL() {
        AtomicBoolean atomicBoolean = aZt;
        if (atomicBoolean != null) {
            return atomicBoolean.get();
        }
        AtomicBoolean atomicBoolean2 = new AtomicBoolean(true);
        aZt = atomicBoolean2;
        return atomicBoolean2.get();
    }

    public static c a(@NonNull Context context, boolean z, boolean z2, boolean z3, int i) {
        boolean z4;
        c cVar;
        c cVar2;
        try {
            if (HZ() && z2 && OL()) {
                com.kwad.sdk.core.d.c.i("MediaPlayerImpl", "constructPlayer KwaiMediaPlayer");
                d dVar = new d(i);
                aZx = 2;
                dVar.bK(z);
                cVar2 = dVar;
            } else {
                com.kwad.sdk.core.d.c.i("MediaPlayerImpl", "constructPlayer AndroidMediaPlayer");
                b bVar = new b();
                aZx = 1;
                cVar2 = bVar;
            }
            z4 = false;
            cVar = cVar2;
        } catch (Throwable th) {
            com.kwad.sdk.core.d.c.e("MediaPlayerImpl", "constructPlayer exception, using AndroidMediaPlayer", th);
            if (!amw) {
                amw = true;
                com.kwad.sdk.service.d.gatherException(th);
            }
            b bVar2 = new b();
            aZx = 1;
            z4 = true;
            cVar = bVar2;
        }
        int iA = ax.a(HZ(), ServiceProvider.get(com.kwad.sdk.service.a.f.class) != null && ((com.kwad.sdk.service.a.f) ServiceProvider.get(com.kwad.sdk.service.a.f.class)).Fu(), z2, OL(), z4, z3, cVar.getMediaPlayerType());
        com.kwad.sdk.core.d.c.W("KwaiPlayHelper", "player v=" + Integer.toBinaryString(iA));
        if (aZu != iA) {
            aZu = iA;
            eL(iA);
        }
        return cVar;
    }

    private static void eL(int i) {
        n nVar = new n(10212L);
        nVar.aVZ = i;
        g.a(nVar);
    }
}

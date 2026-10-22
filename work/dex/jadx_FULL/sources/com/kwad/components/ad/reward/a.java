package com.kwad.components.ad.reward;

import android.os.Looper;
import androidx.annotation.Nullable;
import com.kwad.components.core.playable.PlayableSource;
import com.kwad.sdk.utils.bi;
import com.kwad.sdk.utils.by;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_06_4659cls.dex */
public final class a {
    private final Set<com.kwad.components.ad.reward.e.j> rU;

    /* JADX INFO: renamed from: com.kwad.components.ad.reward.a$a, reason: collision with other inner class name */
    public static class C1161a {
        private static final a rY = new a(0);
    }

    public /* synthetic */ a(byte b) {
        this();
    }

    public static a gs() {
        return C1161a.rY;
    }

    private void gu() {
        if (this.rU.size() == 0) {
            return;
        }
        Iterator<com.kwad.components.ad.reward.e.j> it = this.rU.iterator();
        while (it.hasNext()) {
            it.next().dq();
        }
    }

    private static boolean isMainThread() {
        return Looper.getMainLooper() == Looper.myLooper();
    }

    public final void b(com.kwad.components.ad.reward.e.j jVar) {
        this.rU.remove(jVar);
    }

    public final void c(final PlayableSource playableSource, @Nullable final com.kwad.components.ad.reward.e.n nVar) {
        if (isMainThread()) {
            b(playableSource, nVar);
        } else {
            by.runOnUiThread(new bi() { // from class: com.kwad.components.ad.reward.a.1
                @Override // com.kwad.sdk.utils.bi
                public final void doTask() {
                    a.this.b(playableSource, nVar);
                }
            });
        }
    }

    public final void gt() {
        if (isMainThread()) {
            gu();
        } else {
            by.runOnUiThread(new bi() { // from class: com.kwad.components.ad.reward.a.2
                @Override // com.kwad.sdk.utils.bi
                public final void doTask() {
                    a.this.gt();
                }
            });
        }
    }

    private a() {
        this.rU = new HashSet();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(PlayableSource playableSource, @Nullable com.kwad.components.ad.reward.e.n nVar) {
        if (this.rU.size() == 0) {
            return;
        }
        Iterator<com.kwad.components.ad.reward.e.j> it = this.rU.iterator();
        while (it.hasNext()) {
            it.next().a(playableSource, nVar);
        }
    }

    public final void a(com.kwad.components.ad.reward.e.j jVar) {
        if (jVar != null) {
            this.rU.add(jVar);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(PlayableSource playableSource) {
        if (this.rU.size() == 0) {
            return;
        }
        Iterator<com.kwad.components.ad.reward.e.j> it = this.rU.iterator();
        while (it.hasNext()) {
            it.next().dr();
        }
    }

    public final void a(PlayableSource playableSource) {
        c(playableSource, null);
    }

    public final void b(final PlayableSource playableSource) {
        if (isMainThread()) {
            c(playableSource);
        } else {
            by.runOnUiThread(new bi() { // from class: com.kwad.components.ad.reward.a.3
                @Override // com.kwad.sdk.utils.bi
                public final void doTask() {
                    a.this.c(playableSource);
                }
            });
        }
    }
}

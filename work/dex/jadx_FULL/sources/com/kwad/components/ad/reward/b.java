package com.kwad.components.ad.reward;

import android.os.Looper;
import com.kwad.sdk.utils.bi;
import com.kwad.sdk.utils.by;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_06_4659cls.dex */
public final class b {
    private final Set<com.kwad.components.ad.reward.e.l> rZ;

    public static class a {
        private static final b sb = new b(0);
    }

    public /* synthetic */ b(byte b) {
        this();
    }

    public static b gw() {
        return a.sb;
    }

    private void gx() {
        if (this.rZ.size() == 0) {
            return;
        }
        Iterator<com.kwad.components.ad.reward.e.l> it = this.rZ.iterator();
        while (it.hasNext()) {
            it.next().onRewardVerify();
        }
    }

    private static boolean isMainThread() {
        return Looper.getMainLooper() == Looper.myLooper();
    }

    public final void a(com.kwad.components.ad.reward.e.l lVar) {
        if (lVar != null) {
            this.rZ.add(lVar);
        }
    }

    public final void b(com.kwad.components.ad.reward.e.l lVar) {
        this.rZ.remove(lVar);
    }

    public final void notifyRewardVerify() {
        if (isMainThread()) {
            gx();
        } else {
            by.runOnUiThread(new bi() { // from class: com.kwad.components.ad.reward.b.1
                @Override // com.kwad.sdk.utils.bi
                public final void doTask() {
                    b.this.notifyRewardVerify();
                }
            });
        }
    }

    private b() {
        this.rZ = new HashSet();
    }
}

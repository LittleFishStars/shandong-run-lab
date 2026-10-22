package com.kwad.components.ad.reward;

import androidx.annotation.Nullable;
import com.kwad.components.core.webview.tachikoma.c.r;
import com.kwad.sdk.utils.bi;
import com.kwad.sdk.utils.by;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_06_4659cls.dex */
public final class c {
    private final Set<com.kwad.components.ad.reward.e.m> sc;

    public static class a {
        private static final c sf = new c(0);
    }

    public /* synthetic */ c(byte b) {
        this();
    }

    public static c gz() {
        return a.sf;
    }

    public final void b(com.kwad.components.ad.reward.e.m mVar) {
        this.sc.remove(mVar);
    }

    public final void c(@Nullable final r rVar) {
        by.runOnUiThread(new bi() { // from class: com.kwad.components.ad.reward.c.1
            @Override // com.kwad.sdk.utils.bi
            public final void doTask() {
                c.this.b(rVar);
            }
        });
    }

    private c() {
        this.sc = new HashSet();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(@Nullable r rVar) {
        if (this.sc.size() == 0) {
            return;
        }
        Iterator<com.kwad.components.ad.reward.e.m> it = this.sc.iterator();
        while (it.hasNext()) {
            it.next().a(rVar);
        }
    }

    public final void a(com.kwad.components.ad.reward.e.m mVar) {
        if (mVar != null) {
            this.sc.add(mVar);
        }
    }
}

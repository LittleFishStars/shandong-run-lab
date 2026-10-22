package com.kwad.components.core.proxy;

import android.os.Bundle;
import com.kwad.sdk.service.ServiceProvider;
import com.kwad.sdk.utils.bi;
import com.kwad.sdk.utils.by;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_06_4659cls.dex */
public class l {
    private static volatile l aiP;
    private final List<m> mListeners = new CopyOnWriteArrayList();

    private void d(final com.kwad.sdk.g.a<m> aVar) {
        by.postOnUiThread(new bi() { // from class: com.kwad.components.core.proxy.l.5
            @Override // com.kwad.sdk.utils.bi
            public final void doTask() {
                for (m mVar : l.this.mListeners) {
                    if (mVar != null) {
                        try {
                            aVar.accept(mVar);
                        } catch (Throwable th) {
                            ServiceProvider.reportSdkCaughtException(th);
                        }
                    }
                }
            }
        });
    }

    public static l vC() {
        if (aiP == null) {
            synchronized (l.class) {
                if (aiP == null) {
                    aiP = new l();
                }
            }
        }
        return aiP;
    }

    public final void e(final f fVar) {
        d(new com.kwad.sdk.g.a<m>() { // from class: com.kwad.components.core.proxy.l.2
            /* JADX INFO: Access modifiers changed from: private */
            @Override // com.kwad.sdk.g.a
            /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
            public void accept(m mVar) {
                mVar.d(fVar);
            }
        });
    }

    public final void f(final f fVar) {
        d(new com.kwad.sdk.g.a<m>() { // from class: com.kwad.components.core.proxy.l.3
            /* JADX INFO: Access modifiers changed from: private */
            @Override // com.kwad.sdk.g.a
            /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
            public void accept(m mVar) {
                mVar.c(fVar);
            }
        });
    }

    public final void g(final f fVar) {
        d(new com.kwad.sdk.g.a<m>() { // from class: com.kwad.components.core.proxy.l.4
            @Override // com.kwad.sdk.g.a
            public final /* bridge */ /* synthetic */ void accept(m mVar) {
            }
        });
    }

    public final void a(final f fVar, final Bundle bundle) {
        d(new com.kwad.sdk.g.a<m>() { // from class: com.kwad.components.core.proxy.l.1
            @Override // com.kwad.sdk.g.a
            public final /* bridge */ /* synthetic */ void accept(m mVar) {
            }
        });
    }

    public final void a(m mVar) {
        this.mListeners.add(mVar);
    }
}

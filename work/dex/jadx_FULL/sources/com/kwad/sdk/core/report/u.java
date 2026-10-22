package com.kwad.sdk.core.report;

import android.content.Context;
import com.kwad.sdk.core.network.f;
import com.kwad.sdk.core.report.e;
import com.kwad.sdk.service.ServiceProvider;
import com.kwad.sdk.utils.aq;
import com.kwad.sdk.utils.bt;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
public final class u<T extends e, R extends com.kwad.sdk.core.network.f> implements Runnable {
    private static AtomicLong aWJ = new AtomicLong(-1);
    protected final l<T> aUU;
    protected final b<T, R> aWK;
    protected final AtomicInteger aWL;
    protected final Context mContext;

    public interface a {
        void No();
    }

    public u(Context context, l<T> lVar, b<T, R> bVar, AtomicInteger atomicInteger) {
        this.mContext = context;
        this.aUU = lVar;
        this.aWK = bVar;
        this.aWL = atomicInteger;
    }

    public final void Nn() {
        long jWI = bt.WI();
        if (jWI >= aWJ.get() * 2) {
            try {
                List<T> listEE = this.aUU.eE(200);
                if (listEE.isEmpty()) {
                    return;
                }
                this.aWK.a(listEE, new AtomicBoolean(false), new a() { // from class: com.kwad.sdk.core.report.u.1
                    @Override // com.kwad.sdk.core.report.u.a
                    public final void No() {
                        u.this.Nn();
                    }
                });
            } catch (OutOfMemoryError e) {
                aWJ.set(jWI);
                ((com.kwad.sdk.service.a.e) ServiceProvider.get(com.kwad.sdk.service.a.e.class)).gatherException(e);
            } catch (Throwable th) {
                ((com.kwad.sdk.service.a.e) ServiceProvider.get(com.kwad.sdk.service.a.e.class)).gatherException(th);
            }
        }
    }

    @Override // java.lang.Runnable
    public final void run() {
        if (this.aWL.get() > 0 || !aq.isNetworkConnected(this.mContext)) {
            return;
        }
        Nn();
    }
}

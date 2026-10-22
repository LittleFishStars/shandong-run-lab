package com.kwad.components.core.offline.b;

import android.content.Context;
import com.ksad.annotation.invoker.ForInvoker;
import com.kwad.components.core.offline.b.a.l;
import com.kwad.components.offline.api.OfflineHostProvider;
import com.kwad.components.offline.e.c;
import com.kwad.sdk.utils.bi;
import com.kwad.sdk.utils.i;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_06_4659cls.dex */
public final class b {
    private static final AtomicBoolean mHasInit = new AtomicBoolean();

    @ForInvoker(methodId = "initOC")
    public static void aC(Context context) {
        com.kwad.components.offline.a.b.aV(context);
        com.kwad.components.offline.b.b.aV(context);
        com.kwad.components.offline.c.b.aV(context);
        com.kwad.components.offline.d.b.aV(context);
        c.aV(context);
    }

    public static void init(final Context context) {
        AtomicBoolean atomicBoolean = mHasInit;
        if (atomicBoolean.get()) {
            return;
        }
        atomicBoolean.set(true);
        OfflineHostProvider.get().init(context, new l());
        i.execute(new bi() { // from class: com.kwad.components.core.offline.b.b.1
            @Override // com.kwad.sdk.utils.bi
            public final void doTask() {
                b.aC(context);
            }
        });
    }
}

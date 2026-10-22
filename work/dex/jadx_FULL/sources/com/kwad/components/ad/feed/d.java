package com.kwad.components.ad.feed;

import android.content.Context;
import android.os.SystemClock;
import android.os.Vibrator;
import com.kwad.sdk.core.response.model.AdMatrixInfo;
import com.kwad.sdk.service.ServiceProvider;
import com.kwad.sdk.utils.bi;
import com.kwad.sdk.utils.by;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_06_4659cls.dex */
public final class d {
    private static com.kwad.sdk.core.g.d hu;
    private static com.kwad.sdk.core.g.c hv;
    private static Vibrator hw;
    private static List<c> hx = new CopyOnWriteArrayList();
    private static List<a> hy = new CopyOnWriteArrayList();
    private static long hz;

    public static class a {
        private b hC;
        private Context mContext;

        public a(b bVar, Context context) {
            this.hC = bVar;
            this.mContext = context;
        }
    }

    public interface b {
        boolean u(String str);
    }

    public static class c {
        private InterfaceC1137d hD;
        private Context mContext;

        public c(InterfaceC1137d interfaceC1137d, Context context) {
            this.hD = interfaceC1137d;
            this.mContext = context;
        }
    }

    /* JADX INFO: renamed from: com.kwad.components.ad.feed.d$d, reason: collision with other inner class name */
    public interface InterfaceC1137d {
        boolean b(double d);
    }

    public static void D(Context context) {
        try {
            com.kwad.sdk.core.g.c cVar = hv;
            if (cVar != null) {
                cVar.cc(context);
                hv = null;
            }
        } catch (Throwable th) {
            ServiceProvider.reportSdkCaughtException(th);
        }
    }

    public static void E(Context context) {
        try {
            com.kwad.sdk.core.g.d dVar = hu;
            if (dVar != null) {
                dVar.cc(context);
                hu = null;
            }
        } catch (Throwable th) {
            ServiceProvider.reportSdkCaughtException(th);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static Vibrator F(Context context) {
        if (hw == null) {
            hw = (Vibrator) context.getSystemService("vibrator");
        }
        return hw;
    }

    public static void a(boolean z, float f, Context context, InterfaceC1137d interfaceC1137d, boolean z2) {
        if (hu == null) {
            a(z, f, context, z2);
        }
        hx.add(new c(interfaceC1137d, context));
    }

    public static synchronized boolean ce() {
        long jElapsedRealtime = SystemClock.elapsedRealtime();
        if (!(jElapsedRealtime - hz > 500)) {
            return false;
        }
        hz = jElapsedRealtime;
        return true;
    }

    public static void a(InterfaceC1137d interfaceC1137d) {
        for (c cVar : hx) {
            if (cVar != null && cVar.hD == interfaceC1137d) {
                hx.remove(cVar);
            }
        }
        com.kwad.sdk.core.d.c.d("KSFeedRotateAndShakeManager", "sShakeItems size " + hx.size());
    }

    private static void a(boolean z, float f, Context context, boolean z2) {
        hu = new com.kwad.sdk.core.g.d(z, f);
        hx = new CopyOnWriteArrayList();
        hu.bG(z2);
        hu.a(new com.kwad.sdk.core.g.b() { // from class: com.kwad.components.ad.feed.d.1
            @Override // com.kwad.sdk.core.g.b
            public final void a(double d) {
                if (d.hx != null) {
                    for (c cVar : d.hx) {
                        if (cVar != null && cVar.hD != null && cVar.hD.b(d)) {
                            by.a(cVar.mContext, d.F(cVar.mContext));
                            break;
                        }
                    }
                    by.a(new bi() { // from class: com.kwad.components.ad.feed.d.1.1
                        @Override // com.kwad.sdk.utils.bi
                        public final void doTask() {
                            com.kwad.sdk.core.d.c.d("KSFeedRotateAndShakeManager", "onShakeEvent openGate2");
                            if (d.hu != null) {
                                d.hu.NJ();
                            }
                        }
                    }, null, 500L);
                }
            }

            @Override // com.kwad.sdk.core.g.b
            public final void cj() {
            }
        });
        hu.m(f);
        hu.cb(context);
    }

    public static void a(AdMatrixInfo.RotateInfo rotateInfo, Context context, b bVar) {
        com.kwad.sdk.core.g.c cVar = hv;
        if (cVar == null) {
            a(rotateInfo, context);
        } else {
            cVar.a(rotateInfo);
        }
        hy.add(new a(bVar, context));
    }

    public static void a(b bVar) {
        for (a aVar : hy) {
            if (aVar != null && aVar.hC == bVar) {
                hy.remove(aVar);
            }
        }
        com.kwad.sdk.core.d.c.d("KSFeedRotateAndShakeManager", "sRotateItems size " + hy.size());
    }

    private static void a(AdMatrixInfo.RotateInfo rotateInfo, Context context) {
        com.kwad.sdk.core.g.c cVar = new com.kwad.sdk.core.g.c(rotateInfo);
        hv = cVar;
        cVar.a(new com.kwad.sdk.core.g.a() { // from class: com.kwad.components.ad.feed.d.2
            @Override // com.kwad.sdk.core.g.a
            public final void ck() {
            }

            @Override // com.kwad.sdk.core.g.a
            public final void t(String str) {
                a aVar;
                if (d.hy != null) {
                    Iterator it = d.hy.iterator();
                    while (it.hasNext() && ((aVar = (a) it.next()) == null || aVar.hC == null || !aVar.hC.u(str))) {
                    }
                    by.a(new bi() { // from class: com.kwad.components.ad.feed.d.2.1
                        @Override // com.kwad.sdk.utils.bi
                        public final void doTask() {
                            com.kwad.sdk.core.d.c.d("KSFeedRotateAndShakeManager", "onRotateEvent openGate2");
                            if (d.hv != null) {
                                d.hv.NJ();
                            }
                        }
                    }, null, 1000L);
                }
            }
        });
        hv.cb(context);
    }
}

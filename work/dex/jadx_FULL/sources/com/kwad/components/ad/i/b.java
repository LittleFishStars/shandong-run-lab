package com.kwad.components.ad.i;

import android.app.Activity;
import com.kwad.components.core.proxy.f;
import com.kwad.components.core.proxy.l;
import com.kwad.components.core.proxy.m;
import com.kwad.sdk.core.response.model.AdTemplate;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.WeakHashMap;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_06_4659cls.dex */
public class b implements com.kwad.components.core.internal.api.b {
    private static volatile b rs;
    private Set<Integer> rt = new HashSet();
    private List<c> ru = new ArrayList();
    private Map<com.kwad.components.core.internal.api.a, Object> rv = new WeakHashMap();
    private Map<f, Object> rw = new WeakHashMap();
    private m rx = new m() { // from class: com.kwad.components.ad.i.b.1
        @Override // com.kwad.components.core.proxy.m, com.kwad.sdk.core.c.c
        /* JADX INFO: renamed from: a */
        public final void d(f fVar) {
            super.d(fVar);
            b.this.rw.put(fVar, b.rr);
        }

        @Override // com.kwad.components.core.proxy.m, com.kwad.sdk.core.c.c
        /* JADX INFO: renamed from: b */
        public final void c(f fVar) {
            super.c(fVar);
            b.this.rw.remove(fVar);
            if (b.this.rw.isEmpty()) {
                b.this.ge();
            }
        }
    };
    private static final Object rr = new Object();
    private static final Map<Activity, Object> ry = new WeakHashMap();
    private static a rz = null;

    public interface a {
    }

    private b() {
        l.vC().a(this.rx);
        this.rt.add(2);
        this.rt.add(3);
        this.rt.add(13);
        this.rt.add(6);
    }

    private boolean N(AdTemplate adTemplate) {
        if (adTemplate == null) {
            return false;
        }
        return this.rt.contains(Integer.valueOf(adTemplate.adStyle));
    }

    private void e(com.kwad.components.core.internal.api.a aVar) {
        this.rv.put(aVar, rr);
        if (g(aVar)) {
            c cVar = new c(aVar);
            cVar.gh();
            this.ru.add(cVar);
        }
    }

    private void f(com.kwad.components.core.internal.api.a aVar) {
        this.rv.remove(aVar);
        Iterator<c> it = this.ru.iterator();
        while (it.hasNext()) {
            it.next().d(aVar);
        }
        if (N(aVar.getAdTemplate())) {
            ge();
        }
    }

    private static boolean g(com.kwad.components.core.internal.api.a aVar) {
        if (aVar.supportPushAd()) {
            return com.kwad.sdk.core.response.helper.a.dh(com.kwad.sdk.core.response.helper.e.eO(aVar.getAdTemplate()));
        }
        return false;
    }

    public static b gd() {
        if (rs == null) {
            synchronized (b.class) {
                if (rs == null) {
                    rs = new b();
                }
            }
        }
        return rs;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void ge() {
        boolean zGf = gf();
        com.kwad.sdk.core.d.c.d("KsAdGlobalWatcher", "checkCurrentPage noSDKPage: " + zGf);
        if (zGf) {
            Iterator<c> it = this.ru.iterator();
            while (it.hasNext()) {
                it.next().gj();
            }
        }
    }

    @Override // com.kwad.components.core.internal.api.b
    public final void c(com.kwad.components.core.internal.api.a aVar) {
        e(aVar);
        if (rz != null) {
            if (!this.rw.isEmpty()) {
                Iterator<f> it = this.rw.keySet().iterator();
                while (it.hasNext()) {
                    it.next();
                }
            } else {
                Map<Activity, Object> map = ry;
                if (map.isEmpty()) {
                    return;
                }
                Iterator<Activity> it2 = map.keySet().iterator();
                while (it2.hasNext()) {
                    it2.next();
                }
            }
        }
    }

    @Override // com.kwad.components.core.internal.api.b
    public final void d(com.kwad.components.core.internal.api.a aVar) {
        f(aVar);
        b(aVar);
    }

    public final synchronized boolean gf() {
        Iterator<com.kwad.components.core.internal.api.a> it = this.rv.keySet().iterator();
        while (it.hasNext()) {
            if (N(it.next().getAdTemplate())) {
                return false;
            }
        }
        return this.rw.isEmpty();
    }

    public final void a(com.kwad.components.core.internal.api.a aVar) {
        if (aVar != null) {
            aVar.a(this);
        }
    }

    public final void b(com.kwad.components.core.internal.api.a aVar) {
        if (aVar != null) {
            aVar.b(this);
        }
    }

    public final void a(c cVar) {
        if (cVar != null) {
            this.ru.remove(cVar);
        }
    }
}

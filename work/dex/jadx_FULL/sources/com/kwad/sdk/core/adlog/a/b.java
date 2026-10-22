package com.kwad.sdk.core.adlog.a;

import androidx.annotation.Nullable;
import com.kwad.sdk.service.ServiceProvider;
import com.kwad.sdk.service.a.h;
import com.kwad.sdk.utils.ac;
import com.kwad.sdk.utils.ar;
import com.kwad.sdk.utils.bi;
import com.kwad.sdk.utils.by;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import org.json.JSONObject;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
public final class b {
    private final c aLR;
    private final List<com.kwad.sdk.core.adlog.a.a> aLS;

    public static final class a {
        private static final b aLU = new b(0);
    }

    public /* synthetic */ b(byte b) {
        this();
    }

    public static b IV() {
        return a.aLU;
    }

    @Nullable
    private synchronized com.kwad.sdk.core.adlog.a.a IX() {
        if (ar.R(this.aLS)) {
            return null;
        }
        return this.aLS.remove(0);
    }

    private boolean IZ() {
        c cVar = this.aLR;
        return cVar == null || !cVar.aLV;
    }

    private boolean Ja() {
        c cVar = this.aLR;
        return cVar != null && cVar.aLZ;
    }

    private static boolean d(com.kwad.sdk.core.adlog.c.a aVar) {
        if (aVar == null) {
            return false;
        }
        int i = aVar.aKI;
        return i == 1 || i == 2;
    }

    public final void IW() {
        try {
            if (IZ() || ar.R(this.aLS)) {
                return;
            }
            by.runOnUiThread(new bi() { // from class: com.kwad.sdk.core.adlog.a.b.2
                @Override // com.kwad.sdk.utils.bi
                public final void doTask() {
                    com.kwad.sdk.core.adlog.b.IS();
                }
            });
        } catch (Throwable th) {
            ServiceProvider.reportSdkCaughtException(th);
        }
    }

    @Nullable
    public final com.kwad.sdk.core.adlog.a.a IY() {
        com.kwad.sdk.core.adlog.a.a aVarIX = IX();
        if (aVarIX == null) {
            return null;
        }
        com.kwad.sdk.core.adlog.b.a.d(aVarIX, this.aLR, this.aLS.size());
        long jCurrentTimeMillis = System.currentTimeMillis() - aVarIX.aLO;
        c cVar = this.aLR;
        if (!(jCurrentTimeMillis > cVar.aLX * 1000)) {
            aVarIX.retryCount++;
            com.kwad.sdk.core.adlog.b.a.a(aVarIX, cVar, this.aLS.size(), jCurrentTimeMillis);
            com.kwad.sdk.core.d.c.i("AdLogCacheManager", "getCache success：" + aVarIX);
            return aVarIX;
        }
        com.kwad.sdk.core.adlog.b.a.b(aVarIX, cVar, this.aLS.size(), jCurrentTimeMillis);
        com.kwad.sdk.core.d.c.i("AdLogCacheManager", "getCache fail expired cacheTime: " + jCurrentTimeMillis + ", adLogCache：" + aVarIX);
        return null;
    }

    public final void a(@Nullable com.kwad.sdk.core.adlog.a.a aVar, String str, JSONObject jSONObject, com.kwad.sdk.core.adlog.c.a aVar2, int i, String str2) {
        try {
            if (IZ()) {
                return;
            }
            if (!Ja() || d(aVar2)) {
                if (aVar == null) {
                    if (aVar2 != null) {
                        com.kwad.sdk.core.adlog.a.C1273a c1273a = aVar2.Jg() == null ? new com.kwad.sdk.core.adlog.a.C1273a() : aVar2.Jg();
                        c1273a.aLf = 1;
                        aVar2.a(c1273a);
                        ac.putValue(jSONObject, "clientExtData", aVar2.QZ.toJson().toString());
                    }
                    aVar = com.kwad.sdk.core.adlog.a.a.IU().dW(str).j(jSONObject).c(aVar2).ay(System.currentTimeMillis());
                }
                aVar.dJ(i).dX(str2);
                com.kwad.sdk.core.adlog.b.a.a(aVar, this.aLR, this.aLS.size());
                int i2 = aVar.retryCount;
                c cVar = this.aLR;
                if (i2 >= cVar.aLW) {
                    com.kwad.sdk.core.adlog.b.a.c(aVar, cVar, this.aLS.size());
                    com.kwad.sdk.core.d.c.i("AdLogCacheManager", "addCache fail limit retryCount: " + aVar.retryCount + ", log: " + aVar);
                    return;
                }
                if (this.aLS.size() >= this.aLR.aLY) {
                    com.kwad.sdk.core.adlog.a.a aVarIX = IX();
                    com.kwad.sdk.core.d.c.i("AdLogCacheManager", "addCache limit size: " + this.aLS.size() + ", remove log：" + aVarIX);
                    com.kwad.sdk.core.adlog.b.a.e(aVarIX, this.aLR, this.aLS.size());
                }
                a(aVar);
                com.kwad.sdk.core.d.c.i("AdLogCacheManager", "addCache success size: " + this.aLS.size() + ", log: " + aVar);
                com.kwad.sdk.core.adlog.b.a.b(aVar, this.aLR, this.aLS.size());
            }
        } catch (Throwable th) {
            ServiceProvider.reportSdkCaughtException(th);
        }
    }

    private b() {
        this.aLS = new CopyOnWriteArrayList();
        this.aLR = (c) ac.b(((h) ServiceProvider.get(h.class)).Gh(), new com.kwad.sdk.core.c<c>() { // from class: com.kwad.sdk.core.adlog.a.b.1
            private static c Jb() {
                return new c();
            }

            @Override // com.kwad.sdk.core.c
            public final /* synthetic */ com.kwad.sdk.core.b IA() {
                return Jb();
            }
        });
    }

    private synchronized void a(com.kwad.sdk.core.adlog.a.a aVar) {
        this.aLS.add(aVar);
    }
}

package com.kwad.components.core.c;

import androidx.annotation.NonNull;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.zj.adlib.c49;
import java.lang.ref.WeakReference;
import java.util.concurrent.ConcurrentHashMap;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_06_4659cls.dex */
public class g {
    private static volatile g PB;
    private ConcurrentHashMap<String, WeakReference<Object>> PA = new ConcurrentHashMap<>();

    private static String aD(AdTemplate adTemplate) {
        return com.kwad.sdk.core.response.helper.e.eH(adTemplate) + c49.f40900a + com.kwad.sdk.core.response.helper.e.eY(adTemplate);
    }

    private static String b(i iVar) {
        return iVar.oP() + c49.f40900a + iVar.pc();
    }

    @NonNull
    public static g oV() {
        if (PB == null) {
            synchronized (g.class) {
                if (PB == null) {
                    PB = new g();
                }
            }
        }
        return PB;
    }

    public final boolean a(i iVar) {
        String strB = b(iVar);
        com.kwad.sdk.core.d.c.d("AdMemCachePool", "contains key: " + strB);
        boolean z = false;
        if (!this.PA.containsKey(strB)) {
            return false;
        }
        WeakReference<Object> weakReference = this.PA.get(strB);
        if (weakReference != null && weakReference.get() != null) {
            z = true;
        }
        if (z) {
            com.kwad.sdk.core.d.c.d("AdMemCachePool", "contains ad: " + weakReference.get());
        }
        return z;
    }

    public final void aC(AdTemplate adTemplate) {
        this.PA.remove(aD(adTemplate));
    }

    public final void add(Object obj) {
        if (obj instanceof com.kwad.components.core.internal.api.a) {
            this.PA.put(aD(((com.kwad.components.core.internal.api.a) obj).getAdTemplate()), new WeakReference<>(obj));
        }
    }
}

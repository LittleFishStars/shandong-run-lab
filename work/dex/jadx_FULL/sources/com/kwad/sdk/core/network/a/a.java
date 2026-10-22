package com.kwad.sdk.core.network.a;

import android.util.Log;
import com.kwad.sdk.export.proxy.AdHttpProxy;
import com.kwad.sdk.export.proxy.AdHttpResponseListener;
import com.kwad.sdk.service.ServiceProvider;
import com.kwad.sdk.service.a.h;
import java.io.OutputStream;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
public final class a {
    private static AdHttpProxy aUa;

    /* JADX INFO: renamed from: com.kwad.sdk.core.network.a.a$a, reason: collision with other inner class name */
    public static class C1286a {
        public String msg;
    }

    private static boolean Ml() {
        h hVar = (h) ServiceProvider.get(h.class);
        if (hVar != null) {
            return hVar.FV();
        }
        return false;
    }

    public static boolean a(String str, OutputStream outputStream, C1286a c1286a, long j, boolean z, AdHttpResponseListener adHttpResponseListener) {
        boolean zMl = Ml();
        AdHttpProxy adHttpProxyEG = aUa;
        if (adHttpProxyEG == null) {
            com.kwad.sdk.core.d.c.d("VideoCacheHelper", "isAdCacheEnable:" + zMl);
            adHttpProxyEG = zMl ? com.kwad.sdk.h.EG() : new com.kwad.sdk.core.network.c.a();
            aUa = adHttpProxyEG;
        }
        AdHttpProxy adHttpProxy = adHttpProxyEG;
        if (com.kwad.framework.b.a.pe.booleanValue()) {
            if (adHttpProxy instanceof com.kwad.sdk.core.network.c.b) {
                com.kwad.sdk.core.d.c.d("VideoCacheHelper", "okHttp");
            } else {
                com.kwad.sdk.core.d.c.d("VideoCacheHelper", "Http");
            }
        }
        try {
            com.kwad.sdk.core.d.c.d("VideoCacheHelper", "downloadUrlToStream success size:" + j + " url:" + str);
            adHttpProxy.downloadUrlToStream(str, outputStream, j, z, adHttpResponseListener);
            return true;
        } catch (Exception e) {
            com.kwad.sdk.core.d.c.d("VideoCacheHelper", Log.getStackTraceString(e));
            c1286a.msg = e.getMessage();
            return false;
        }
    }
}

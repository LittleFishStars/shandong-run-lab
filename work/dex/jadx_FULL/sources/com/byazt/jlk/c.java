package com.byazt.jlk;

import android.text.TextUtils;
import android.webkit.WebResourceResponse;
import android.webkit.WebView;
import com.byazt.ete.ic;
import com.byazt.ete.zb;
import com.byazt.nr.m;
import com.byazt.or.da;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_11_8719cls.dex */
@com.byazt.zqa.c(c = {0, 1, 249, 20})
public final class c {

    /* JADX INFO: renamed from: com.byazt.jlk.c$c, reason: collision with other inner class name */
    public interface InterfaceC0443c {
        com.byazt.six.c c(String str, da.c cVar, String str2);

        boolean c();
    }

    public static com.byazt.six.c c(WebView webView, ic icVar, String str, InterfaceC0443c interfaceC0443c) {
        zb next;
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        da.c cVarC = da.c(str);
        boolean z = interfaceC0443c != null && interfaceC0443c.c();
        if (cVarC != da.c.IMAGE && z && icVar != null) {
            Iterator<zb> it = icVar.pa().iterator();
            while (true) {
                if (!it.hasNext()) {
                    next = null;
                    break;
                }
                next = it.next();
                if (!TextUtils.isEmpty(next.c()) && !TextUtils.isEmpty(str)) {
                    String strC = next.c();
                    if (strC.startsWith("https")) {
                        strC = strC.replaceFirst("https", "http");
                    }
                    if ((str.startsWith("https") ? str.replaceFirst("https", "http") : str).equals(strC)) {
                        break;
                    }
                }
            }
        } else {
            next = null;
            break;
        }
        if (cVarC == da.c.IMAGE) {
            com.byazt.six.c cVar = new com.byazt.six.c();
            cVar.c(5);
            cVar.c(c(str, tt.tt(icVar, str)));
            return cVar;
        }
        if (next == null) {
            if (interfaceC0443c == null) {
                return null;
            }
            return interfaceC0443c.c(str, cVarC, "");
        }
        com.byazt.six.c cVar2 = new com.byazt.six.c();
        cVar2.c(c(str, next.sp()));
        cVar2.c(5);
        return cVar2;
    }

    private static WebResourceResponse c(String str, String str2) {
        WebResourceResponse webResourceResponse = null;
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        try {
            InputStream inputStreamC = com.byazt.xky.tt.c(str, str2);
            if (inputStreamC == null) {
                return null;
            }
            WebResourceResponse webResourceResponse2 = new WebResourceResponse(da.c.IMAGE.getType(), "utf-8", inputStreamC);
            try {
                Map<String, String> responseHeaders = webResourceResponse2.getResponseHeaders();
                if (responseHeaders == null) {
                    responseHeaders = new HashMap<>();
                }
                responseHeaders.put("Access-Control-Allow-Origin", "*");
                webResourceResponse2.setResponseHeaders(responseHeaders);
                return webResourceResponse2;
            } catch (Throwable th) {
                th = th;
                webResourceResponse = webResourceResponse2;
            }
        } catch (Throwable th2) {
            th = th2;
        }
        m.ve("CacheInterceptUtil", "get image WebResourceResponse error", th);
        return webResourceResponse;
    }
}

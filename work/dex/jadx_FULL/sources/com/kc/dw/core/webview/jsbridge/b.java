package com.kc.dw.core.webview.jsbridge;

import com.google.gson.Gson;
import com.kc.dw.core.utils.v;
import com.kc.dw.platform.ad_adapter.c;
import com.qihoo.SdkProtected.OSETSDK.Keep;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
@Keep
public class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public com.kc.dw.core.webview.jsbridge.bean.a f39442a;
    public final c b;

    public b(c cVar) {
        this.b = cVar;
        if (cVar != null) {
            try {
                if (cVar.a() != null) {
                    Gson gson = v.f39411a;
                    this.f39442a = (com.kc.dw.core.webview.jsbridge.bean.a) gson.fromJson(gson.toJson(cVar.a()), com.kc.dw.core.webview.jsbridge.bean.a.class);
                }
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }
    }

    public static String a(boolean z, String str) {
        return "{\"open_status\":" + z + ",\"msg\":\"" + str + "\"}";
    }
}

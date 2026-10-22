package com.alibaba.ariver.v8worker;

import android.os.Bundle;
import android.text.TextUtils;
import com.alibaba.ariver.app.api.Page;
import com.alibaba.ariver.kernel.common.RVProxy;
import com.alibaba.ariver.kernel.common.service.RVEnvironmentService;
import com.alibaba.ariver.kernel.common.utils.BundleUtils;
import com.alibaba.ariver.kernel.common.utils.JSONUtils;
import com.alibaba.ariver.kernel.common.utils.RVLogger;
import com.alibaba.fastjson.JSONObject;
import java.util.HashSet;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
class n {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final int f24526a = -1;
    public static final int b = -2;
    public static final int c = 0;
    public static final int d = 1;
    public static final int e = 2;
    public static final int f = 3;
    public static final int g = 4;
    public static final int h = 5;
    public static final int i = 6;
    public static final int j = 7;
    private static final String k = "V8Worker";
    private static final String l = "created";
    private static final String m = "resumed";
    private static final String n = "paused";
    private static final String o = "closed";
    private V8Worker p;
    private boolean q;
    private boolean r = false;
    private String s;
    private String[] t;

    public static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        String f24528a;
    }

    public n(V8Worker v8Worker, Bundle bundle) {
        String[] strArrA;
        this.s = null;
        this.t = null;
        this.p = v8Worker;
        if (o.a("ta_jsi_enable_native_plugin", false)) {
            String appId = v8Worker.getAppId();
            if (TextUtils.isEmpty(appId) || (strArrA = a(appId, bundle)) == null) {
                return;
            }
            this.s = ((RVEnvironmentService) RVProxy.get(RVEnvironmentService.class)).getApplicationContext().getApplicationInfo().nativeLibraryDir;
            HashSet hashSet = new HashSet();
            for (String str : strArrA) {
                String str2 = str + "_jsi";
                try {
                    System.loadLibrary(str2);
                    o.a(hashSet, str2);
                } catch (Throwable th) {
                    RVLogger.e(k, "loadLibrary " + str2, th);
                }
            }
            if (hashSet.isEmpty()) {
                return;
            }
            this.t = (String[]) hashSet.toArray(new String[0]);
        }
    }

    public void b() {
        V8Worker v8Worker = this.p;
        v8Worker._loadV8Plugins(v8Worker.d(), this.s, this.t);
    }

    public void c(Page page) {
        a aVar;
        String str;
        if (a() || (str = (aVar = (a) page.getData(a.class, true)).f24528a) == null || n.equals(str)) {
            return;
        }
        this.p.a(6, page.getPageId());
        aVar.f24528a = n;
    }

    public void d(Page page) {
        a aVar;
        String str;
        if (a() || (str = (aVar = (a) page.getData(a.class, true)).f24528a) == null || o.equals(str)) {
            return;
        }
        this.p.a(7, page.getPageId());
        aVar.f24528a = o;
    }

    public void e() {
        if (a()) {
            return;
        }
        this.q = false;
        V8Worker v8Worker = this.p;
        v8Worker._dispatchPluginEvent(v8Worker.d(), 3, this.p.getAppId(), 0);
    }

    public boolean a() {
        String[] strArr = this.t;
        return strArr == null || strArr.length == 0;
    }

    public void b(Page page) {
        a aVar;
        String str;
        if (a() || (str = (aVar = (a) page.getData(a.class, true)).f24528a) == null || m.equals(str)) {
            return;
        }
        this.p.a(5, page.getPageId());
        aVar.f24528a = m;
    }

    private String[] a(String str, Bundle bundle) {
        try {
            HashSet hashSet = new HashSet();
            String string = BundleUtils.getString(bundle, "v8WorkerPlugins", null);
            if (!TextUtils.isEmpty(string)) {
                RVLogger.e(k, "init plugins from startup params: " + string);
                String[] strArrSplit = string.split(",");
                int length = strArrSplit.length;
                for (int i2 = 0; i2 < length; i2++) {
                    o.a(hashSet, strArrSplit[i2]);
                }
            }
            JSONObject object = JSONUtils.parseObject(o.a().getConfig("ta_v8WorkerPluginConfig", ""));
            if (object != null && !object.isEmpty()) {
                o.a(hashSet, JSONUtils.getJSONArray(object, str, null));
                o.a(hashSet, JSONUtils.getJSONArray(object, "default", null));
            }
            if (!hashSet.isEmpty()) {
                return (String[]) hashSet.toArray(new String[0]);
            }
        } catch (Exception e2) {
            RVLogger.e(k, "getConfig exception", e2);
        }
        return null;
    }

    public void c() {
        if (a() || this.q) {
            return;
        }
        this.q = true;
        V8Worker v8Worker = this.p;
        v8Worker._dispatchPluginEvent(v8Worker.d(), 1, this.p.getAppId(), 0);
    }

    public void d() {
        if (!a() && this.q) {
            this.q = false;
            V8Worker v8Worker = this.p;
            v8Worker._dispatchPluginEvent(v8Worker.d(), 2, this.p.getAppId(), 0);
        }
    }

    public void a(Page page) {
        V8Proxy v8Proxy;
        if (a()) {
            return;
        }
        if (!this.r && (v8Proxy = (V8Proxy) RVProxy.get(V8Proxy.class)) != null) {
            final String sessionId = v8Proxy.getSessionId(page.getRender());
            if (!TextUtils.isEmpty(sessionId)) {
                this.r = true;
                this.p.o().post(new Runnable() { // from class: com.alibaba.ariver.v8worker.n.1
                    @Override // java.lang.Runnable
                    public void run() {
                        if (n.this.p.k()) {
                            return;
                        }
                        n.this.p._dispatchPluginEvent(n.this.p.d(), -2, sessionId, 0);
                        RVLogger.d(n.k, "setSessionId : " + sessionId);
                    }
                });
            }
        }
        a aVar = (a) page.getData(a.class, true);
        if (aVar.f24528a != null) {
            return;
        }
        this.p.a(4, page.getPageId());
        aVar.f24528a = l;
    }
}

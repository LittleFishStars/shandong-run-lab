package com.alibaba.ariver.legacy.v8worker;

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
class l {
    private static final String e = "V8Worker";
    private static final String f = "created";
    private static final String g = "resumed";
    private static final String h = "paused";
    private static final String i = "closed";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    n f24324a;
    boolean b;
    String c;
    String[] d;

    public static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        String f24325a;
    }

    public l(n nVar, Bundle bundle) {
        this.c = null;
        this.d = null;
        this.f24324a = nVar;
        String appId = nVar.getAppId();
        if (TextUtils.isEmpty(appId)) {
            return;
        }
        if (RVProxy.get(V8Proxy.class) != null) {
            String[] v8PluginNameList = ((V8Proxy) RVProxy.get(V8Proxy.class)).getV8PluginNameList(appId, bundle);
            this.d = v8PluginNameList;
            if (v8PluginNameList == null) {
                this.d = a(appId, bundle);
            }
        } else {
            this.d = a(appId, bundle);
        }
        if (this.d != null) {
            this.c = ((RVEnvironmentService) RVProxy.get(RVEnvironmentService.class)).getApplicationContext().getApplicationInfo().nativeLibraryDir;
        }
    }

    public boolean a() {
        String[] strArr = this.d;
        return strArr == null || strArr.length == 0;
    }

    public void b(Page page) {
        a aVar;
        String str;
        if (a() || (str = (aVar = (a) page.getData(a.class, true)).f24325a) == null || g.equals(str)) {
            return;
        }
        this.f24324a.dispatchPageEvent(5, page.getPageId());
        aVar.f24325a = g;
    }

    public void c(Page page) {
        a aVar;
        String str;
        if (a() || (str = (aVar = (a) page.getData(a.class, true)).f24325a) == null || h.equals(str)) {
            return;
        }
        this.f24324a.dispatchPageEvent(6, page.getPageId());
        aVar.f24325a = h;
    }

    public void d(Page page) {
        a aVar;
        String str;
        if (a() || (str = (aVar = (a) page.getData(a.class, true)).f24325a) == null || i.equals(str)) {
            return;
        }
        this.f24324a.dispatchPageEvent(7, page.getPageId());
        aVar.f24325a = i;
    }

    private String[] a(String str, Bundle bundle) {
        try {
            HashSet hashSet = new HashSet();
            String string = BundleUtils.getString(bundle, "v8WorkerPlugins", null);
            if (!TextUtils.isEmpty(string)) {
                RVLogger.e(e, "init plugins from startup params: " + string);
                String[] strArrSplit = string.split(",");
                int length = strArrSplit.length;
                for (int i2 = 0; i2 < length; i2++) {
                    m.a(hashSet, strArrSplit[i2]);
                }
            }
            JSONObject object = JSONUtils.parseObject(m.a().getConfig("ta_v8WorkerPluginConfig", ""));
            if (object != null && !object.isEmpty()) {
                m.a(hashSet, JSONUtils.getJSONArray(object, str, null));
                m.a(hashSet, JSONUtils.getJSONArray(object, "default", null));
            }
            if (!hashSet.isEmpty()) {
                return (String[]) hashSet.toArray(new String[0]);
            }
        } catch (Exception e2) {
            RVLogger.e(e, "getConfig exception", e2);
        }
        return null;
    }

    public void b() {
        if (a() || this.b) {
            return;
        }
        this.b = true;
        this.f24324a.getV8Runtime().dispatchPluginEvent(1, this.f24324a.getAppId(), 0);
    }

    public void c() {
        if (!a() && this.b) {
            this.b = false;
            this.f24324a.getV8Runtime().dispatchPluginEvent(2, this.f24324a.getAppId(), 0);
        }
    }

    public void d() {
        if (a()) {
            return;
        }
        this.b = false;
        this.f24324a.getV8Runtime().dispatchPluginEvent(3, this.f24324a.getAppId(), 0);
    }

    public void a(Page page) {
        if (a()) {
            return;
        }
        a aVar = (a) page.getData(a.class, true);
        if (aVar.f24325a != null) {
            return;
        }
        this.f24324a.dispatchPageEvent(4, page.getPageId());
        aVar.f24325a = f;
    }
}

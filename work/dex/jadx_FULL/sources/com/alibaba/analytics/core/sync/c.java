package com.alibaba.analytics.core.sync;

import android.text.TextUtils;
import com.alibaba.analytics.a.t;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public class c implements com.alibaba.analytics.core.a.d.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static c f23791a;
    private String bb = "https://h-adashx4bc.ut.taobao.com/upload";

    public c() {
        try {
            K(com.alibaba.analytics.a.a.a(com.alibaba.analytics.core.d.a().getContext(), "utanalytics_https_host"));
            K(t.b(com.alibaba.analytics.core.d.a().getContext(), "utanalytics_https_host"));
            K(com.alibaba.analytics.core.a.d.a().get("utanalytics_https_host"));
            com.alibaba.analytics.core.a.d.a().a("utanalytics_https_host", this);
        } catch (Throwable unused) {
        }
    }

    private void K(String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        this.bb = "https://" + str + "/upload";
    }

    public static synchronized c a() {
        if (f23791a == null) {
            f23791a = new c();
        }
        return f23791a;
    }

    @Override // com.alibaba.analytics.core.a.d.a
    public void c(String str, String str2) {
        K(str2);
    }

    public String x() {
        com.alibaba.analytics.a.j.d("", "mHttpsUrl", this.bb);
        return this.bb;
    }
}

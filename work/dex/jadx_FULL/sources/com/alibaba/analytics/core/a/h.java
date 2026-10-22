package com.alibaba.analytics.core.a;

import android.content.Context;
import android.content.Intent;
import com.google.android.exoplayer2.upstream.cache.CachedContentIndex;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public class h {
    private static Map<String, String> l = new HashMap();

    public static synchronized void f(String str, String str2) {
        try {
            Context context = com.alibaba.analytics.core.d.a().getContext();
            if (context == null) {
                context = com.alibaba.analytics.core.a.a().getContext();
            }
            if (context == null) {
                return;
            }
            l.put(str, str2);
            String packageName = context.getPackageName();
            com.alibaba.analytics.a.j.d("UTConfigMgr", "postServerConfig packageName", packageName, CachedContentIndex.a.e, str, "value", str2);
            Intent intent = new Intent("com.alibaba.analytics.config.change");
            intent.setPackage(packageName);
            intent.putExtra(CachedContentIndex.a.e, str);
            intent.putExtra("value", str2);
            context.sendBroadcast(intent);
        } catch (Throwable th) {
            com.alibaba.analytics.a.j.e("UTConfigMgr", th, new Object[0]);
        }
    }

    public static synchronized void v() {
        for (Map.Entry<String, String> entry : l.entrySet()) {
            f(entry.getKey(), entry.getValue());
        }
    }
}

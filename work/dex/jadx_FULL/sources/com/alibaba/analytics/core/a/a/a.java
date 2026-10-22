package com.alibaba.analytics.core.a.a;

import android.content.Context;
import android.text.TextUtils;
import com.alibaba.analytics.a.j;
import com.alibaba.analytics.a.x;
import com.alibaba.analytics.core.d;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ScheduledFuture;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static a f23753a;
    private static Map<String, String> u = Collections.synchronizedMap(new HashMap());

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    private Runnable f625a = new Runnable() { // from class: com.alibaba.analytics.core.a.a.a.1
        @Override // java.lang.Runnable
        public void run() {
            Context context = d.a().getContext();
            if (context == null) {
                j.w("storeTask.run()", "context", context);
                return;
            }
            ArrayList arrayList = new ArrayList(a.u.size());
            for (String str : a.u.keySet()) {
                arrayList.add(new b(str, (String) a.u.get(str)));
            }
            d.a().m112a().clear(b.class);
            d.a().m112a().insert(arrayList);
        }
    };

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    private ScheduledFuture f626a;

    private a() {
        List<? extends com.alibaba.analytics.core.b.b> listFind;
        if (d.a().getContext() == null || (listFind = d.a().m112a().find(b.class, null, null, -1)) == null) {
            return;
        }
        for (int i = 0; i < listFind.size(); i++) {
            u.put(((b) listFind.get(i)).T, ((b) listFind.get(i)).U);
        }
    }

    public static synchronized a a() {
        if (f23753a == null) {
            f23753a = new a();
        }
        return f23753a;
    }

    public String get(String str) {
        String str2 = u.get(str);
        return TextUtils.isEmpty(str2) ? "0" : str2;
    }

    public void put(String str, String str2) {
        u.put(str, str2);
        this.f626a = x.a().schedule(this.f626a, this.f625a, 10000L);
    }
}

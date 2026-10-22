package com.alibaba.triver.open.prefetch;

import com.alibaba.ariver.kernel.common.utils.RVLogger;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.triver.open.prefetch.task.c;
import com.alibaba.triver.open.prefetch.task.d;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final String f25071a = "PrefetchManager";
    private static final int b = 5;

    public static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        static final b f25072a = new b();

        private a() {
        }
    }

    public static b a() {
        return a.f25072a;
    }

    private b() {
    }

    public boolean a(String str, List<JSONObject> list, PrefectchCallback prefectchCallback, Object... objArr) {
        if (list == null || list.isEmpty()) {
            RVLogger.d(f25071a, "no configs");
            return false;
        }
        ArrayList arrayList = new ArrayList();
        Iterator<JSONObject> it = list.iterator();
        while (it.hasNext()) {
            c cVarA = d.a(str, it.next(), prefectchCallback);
            if (cVarA != null) {
                arrayList.add(cVarA);
            }
        }
        if (arrayList.isEmpty()) {
            return false;
        }
        Iterator it2 = arrayList.subList(0, Math.min(5, arrayList.size())).iterator();
        while (it2.hasNext()) {
            ((c) it2.next()).c(str, objArr);
        }
        return true;
    }
}

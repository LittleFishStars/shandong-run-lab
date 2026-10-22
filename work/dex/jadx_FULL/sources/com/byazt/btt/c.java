package com.byazt.btt;

import com.byazt.nc.yp;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_11_8719cls.dex */
@com.byazt.zqa.c(c = {0, 1, 2088, 20})
public final class c {
    public static final Map<Integer, WeakReference<yp>> c = new HashMap();

    public static void c(Integer num, yp ypVar) {
        c.put(num, new WeakReference<>(ypVar));
    }

    public static yp c(Integer num) {
        WeakReference<yp> weakReference = c.get(num);
        if (weakReference == null) {
            return null;
        }
        return weakReference.get();
    }
}

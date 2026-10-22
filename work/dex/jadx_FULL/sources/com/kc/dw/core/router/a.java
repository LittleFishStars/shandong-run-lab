package com.kc.dw.core.router;

import android.util.Log;
import com.kc.dw.core.router.service.d;
import com.qihoo.SdkProtected.OSETSDK.Keep;
import java.util.concurrent.ConcurrentHashMap;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
@Keep
public class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final ConcurrentHashMap<Class<?>, d> f39312a = new ConcurrentHashMap<>();

    public static <T extends d> T a(Class<T> cls) {
        try {
            ConcurrentHashMap<Class<?>, d> concurrentHashMap = f39312a;
            if (concurrentHashMap.containsKey(cls)) {
                return (T) concurrentHashMap.get(cls);
            }
            return null;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public static <T extends d> void a(Class<T> cls, T t) {
        try {
            if (cls == d.class) {
                Log.e("Router", "error. clazz is`not IService");
            } else {
                f39312a.put(cls, t);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

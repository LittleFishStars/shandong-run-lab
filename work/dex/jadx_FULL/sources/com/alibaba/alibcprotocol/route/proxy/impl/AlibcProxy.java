package com.alibaba.alibcprotocol.route.proxy.impl;

import com.alibaba.baichuan.trade.common.utils.AlibcLogger;
import java.lang.reflect.Proxy;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public class AlibcProxy {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final String f23631a = "AlibcProxy";
    private static final Map<Class, Object> b = new ConcurrentHashMap();

    private static <T> void a(Class<? super T> cls, Object obj) {
        if (cls != null) {
            if (obj == null) {
                b.remove(cls);
                return;
            }
            if (!cls.isInterface()) {
                throw new IllegalArgumentException("set proxy class must an Interface: " + cls);
            }
            Map<Class, Object> map = b;
            synchronized (map) {
                map.put(cls, obj);
            }
        }
    }

    public static <T> T get(Class<T> cls) {
        if (!cls.isInterface()) {
            AlibcLogger.e(f23631a, "proxy class must be an Interface: " + cls.getSimpleName());
        }
        T t = (T) b.get(cls);
        if (t != null) {
            return t;
        }
        com.alibaba.alibcprotocol.route.proxy.a aVar = (com.alibaba.alibcprotocol.route.proxy.a) cls.getAnnotation(com.alibaba.alibcprotocol.route.proxy.a.class);
        if (aVar != null) {
            try {
                Class<?> cls2 = Class.forName(aVar.a());
                if (cls.isAssignableFrom(cls2)) {
                    Object objNewInstance = cls2.newInstance();
                    T t2 = (T) Proxy.newProxyInstance(objNewInstance.getClass().getClassLoader(), objNewInstance.getClass().getInterfaces(), new a(objNewInstance, aVar.a()));
                    a(cls, t2);
                    return t2;
                }
            } catch (Throwable th) {
                AlibcLogger.e(f23631a, "InjectExecute initialize exception: " + th.getMessage());
            }
        }
        T t3 = (T) Proxy.newProxyInstance(cls.getClassLoader(), new Class[]{cls}, new a());
        a(cls, t3);
        return t3;
    }
}

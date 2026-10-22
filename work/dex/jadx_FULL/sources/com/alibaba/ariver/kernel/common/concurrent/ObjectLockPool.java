package com.alibaba.ariver.kernel.common.concurrent;

import androidx.annotation.NonNull;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public class ObjectLockPool {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final Map<Object, Object> f24235a = new ConcurrentHashMap();

    public static Object acquire(@NonNull Object obj) {
        Map<Object, Object> map = f24235a;
        Object objValueOf = map.get(obj);
        if (objValueOf == null) {
            synchronized (map) {
                if (map.containsKey(obj)) {
                    objValueOf = map.get(obj);
                } else {
                    objValueOf = Integer.valueOf(obj.hashCode());
                    map.put(obj, objValueOf);
                }
            }
        }
        return objValueOf;
    }

    public static void release(@NonNull Object obj) {
        Map<Object, Object> map = f24235a;
        synchronized (map) {
            map.remove(obj);
        }
    }
}

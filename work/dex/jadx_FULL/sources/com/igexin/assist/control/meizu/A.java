package com.igexin.assist.control.meizu;

import java.util.HashMap;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
public class A {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final HashMap<String, Class<?>> f37784a = new HashMap<>();
    private Class<?> b;
    private String c;
    private Object d;

    private A(Object obj) {
        this.d = obj;
    }

    private A(String str) {
        this.c = str;
    }

    public static A a(String str) {
        return new A(str);
    }

    public c a(String str, Class<?>... clsArr) {
        return new c(this, str, clsArr);
    }

    public Class<?> a() throws ClassNotFoundException {
        Class<?> cls = this.b;
        if (cls != null) {
            return cls;
        }
        Object obj = this.d;
        if (obj != null) {
            return obj.getClass();
        }
        HashMap<String, Class<?>> map = f37784a;
        Class<?> cls2 = map.get(this.c);
        if (cls2 != null) {
            return cls2;
        }
        Class<?> cls3 = Class.forName(this.c);
        map.put(this.c, cls3);
        return cls3;
    }
}

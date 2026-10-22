package com.baidu.b.a;

import java.lang.reflect.Method;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_10_7392cls.dex */
public class e {

    public static class a extends Exception {
        public a(String str) {
            super(str);
        }

        public a(Throwable th) {
            super(th);
        }
    }

    public static String a(byte[] bArr) throws Exception {
        byte[] bArrA = com.baidu.b.c.a.g.a();
        return new String(com.baidu.b.c.a.c.a(bArrA, bArrA, bArr));
    }

    public static Method a(Class cls, String str, Class[] clsArr) throws NoSuchMethodException {
        Method declaredMethod = cls.getDeclaredMethod(str, clsArr);
        declaredMethod.setAccessible(true);
        return declaredMethod;
    }
}

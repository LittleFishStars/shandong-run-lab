package com.beizi.fusion;

import java.lang.reflect.Method;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_10_7392cls.dex */
public abstract class qo {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static Method f27700a;
    private static Method b;
    private static Method c;

    static {
        try {
            for (Method method : Class.forName("android.os.SystemProperties").getMethods()) {
                String name = method.getName();
                if (name.equals("getLong")) {
                    f27700a = method;
                } else if (name.equals(com.acse.ottn.p3.h)) {
                    c = method;
                } else if (name.equals(com.acse.ottn.p3.f)) {
                    b = method;
                }
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public static String a(String str, String str2) {
        try {
            return (String) b.invoke(null, str, str2);
        } catch (Throwable th) {
            th.printStackTrace();
            return str2;
        }
    }
}

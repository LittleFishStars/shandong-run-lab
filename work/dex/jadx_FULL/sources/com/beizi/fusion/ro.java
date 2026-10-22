package com.beizi.fusion;

import java.lang.reflect.Method;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_10_7392cls.dex */
public final class ro {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private Method f27732a;
    private Method b;

    public static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private static ro f27733a = new ro();
    }

    private ro() {
        if (a.f27733a != null) {
            throw new RuntimeException("Singleton ...");
        }
        a();
    }

    private void a() {
        try {
            for (Method method : Class.forName("android.os.SystemProperties").getMethods()) {
                String name = method.getName();
                if (name.equals("getLong")) {
                    this.f27732a = method;
                } else if (name.equals(com.acse.ottn.p3.f)) {
                    this.b = method;
                }
            }
        } catch (ClassNotFoundException unused) {
        }
    }

    public static long a(String str, long j) {
        try {
            Method method = a.f27733a.f27732a;
            if (method != null) {
                return ((Long) method.invoke(null, str, Long.valueOf(j))).longValue();
            }
        } catch (Throwable unused) {
        }
        return j;
    }

    public static String a(String str, String str2) {
        try {
            Method method = a.f27733a.b;
            if (method != null) {
                return method.invoke(null, str, str2).toString();
            }
        } catch (Throwable unused) {
        }
        return str2;
    }
}

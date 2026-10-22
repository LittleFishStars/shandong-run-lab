package com.netease.nis.wrapper;

import java.lang.reflect.Field;
import java.lang.reflect.Method;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/peek/classes.dex */
public final class b extends ClassLoader {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static b f3a;

    private b() {
        try {
            ClassLoader classLoader = MyApplication.class.getClassLoader();
            Field declaredField = ClassLoader.class.getDeclaredField(a.auu.a.c("LQkVFhInBCwJEQ=="));
            declaredField.setAccessible(true);
            Object obj = declaredField.get(classLoader);
            Field declaredField2 = ClassLoader.class.getDeclaredField(a.auu.a.c("LQkVFhInBCwJEQ=="));
            declaredField2.setAccessible(true);
            declaredField2.set(this, obj);
        } catch (Exception e) {
            String str = MyApplication.TAG;
            new StringBuilder(a.auu.a.c("PQAAJg0SFj0xFQcNFkUrFwYKE0lF")).append(e.getMessage());
        }
    }

    private static synchronized b a() {
        if (f3a == null) {
            f3a = new b();
        }
        return f3a;
    }

    private static boolean a(String str) {
        try {
            b bVarA = a();
            Method declaredMethod = ClassLoader.class.getDeclaredMethod(a.auu.a.c("KAwaAS0cBCoAECYNEhY9"), String.class);
            declaredMethod.setAccessible(true);
            return declaredMethod.invoke(bVarA, str) != null;
        } catch (Exception e) {
            String str2 = MyApplication.TAG;
            new StringBuilder(a.auu.a.c("JxY3CQAAFgIKFQEEF0UrFwYKE0lF")).append(e.getMessage());
            return false;
        }
    }

    private void b() {
        try {
            ClassLoader classLoader = MyApplication.class.getClassLoader();
            Field declaredField = ClassLoader.class.getDeclaredField(a.auu.a.c("LQkVFhInBCwJEQ=="));
            declaredField.setAccessible(true);
            Object obj = declaredField.get(classLoader);
            Field declaredField2 = ClassLoader.class.getDeclaredField(a.auu.a.c("LQkVFhInBCwJEQ=="));
            declaredField2.setAccessible(true);
            declaredField2.set(this, obj);
        } catch (Exception e) {
            String str = MyApplication.TAG;
            new StringBuilder(a.auu.a.c("PQAAJg0SFj0xFQcNFkUrFwYKE0lF")).append(e.getMessage());
        }
    }
}

package com.zj.adlib;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_10_7392cls.dex */
public final class s0b {

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public boolean f19482a = false;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public ArrayList<a> f44579a = new ArrayList<>();

    public static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public Object f44580a;

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        public String f19483a;

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        public Class<?>[] f19484a;

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        public Object[] f19485a;

        public a(Object obj, String str, Object... objArr) {
            this.f44580a = obj;
            this.f19483a = str;
            if (objArr == null || objArr.length <= 0) {
                return;
            }
            this.f19484a = new Class[objArr.length];
            for (int i = 0; i < objArr.length; i++) {
                this.f19484a[i] = objArr[i].getClass();
            }
            this.f19485a = new Object[objArr.length];
            for (int i2 = 0; i2 < objArr.length; i2++) {
                this.f19485a[i2] = objArr[i2];
            }
        }
    }

    public final synchronized void a() {
        Method declaredMethod;
        try {
            if (this.f19482a) {
                return;
            }
            this.f19482a = true;
            for (int i = 0; i < this.f44579a.size(); i++) {
                a aVar = this.f44579a.get(i);
                try {
                    try {
                        try {
                            if (aVar.f44580a != null) {
                                Class<?> cls = aVar.f44580a.getClass();
                                try {
                                    declaredMethod = cls.getDeclaredMethod(aVar.f19483a, aVar.f19484a);
                                } catch (NoSuchMethodException unused) {
                                    if (aVar.f19484a.length > 0) {
                                        Class<?>[] clsArr = new Class[aVar.f19484a.length];
                                        for (int i2 = 0; i2 < aVar.f19484a.length; i2++) {
                                            if (aVar.f19484a[i2].getInterfaces().length > 0) {
                                                clsArr[i2] = aVar.f19484a[i2].getInterfaces()[0];
                                            }
                                        }
                                        declaredMethod = cls.getDeclaredMethod(aVar.f19483a, clsArr);
                                    } else {
                                        declaredMethod = null;
                                    }
                                }
                                if (declaredMethod != null) {
                                    declaredMethod.setAccessible(true);
                                    declaredMethod.invoke(aVar.f44580a, aVar.f19485a);
                                }
                            }
                        } catch (NoSuchMethodException e) {
                            e.printStackTrace();
                        }
                    } catch (IllegalAccessException e2) {
                        e2.printStackTrace();
                    } catch (SecurityException e3) {
                        e3.printStackTrace();
                    }
                } catch (IllegalArgumentException e4) {
                    e4.printStackTrace();
                } catch (InvocationTargetException e5) {
                    e5.printStackTrace();
                }
            }
            this.f44579a.clear();
        } catch (Throwable th) {
            throw th;
        }
    }

    public final synchronized void b(Object obj, Object... objArr) {
        try {
            StackTraceElement[] stackTrace = Thread.currentThread().getStackTrace();
            if (stackTrace != null && stackTrace.length >= 3) {
                this.f44579a.add(new a(obj, stackTrace[3].getMethodName(), objArr));
            }
        } catch (Throwable unused) {
        }
        this.f19482a = false;
    }
}

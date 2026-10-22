package com.kuaishou.weapon.p0;

import android.os.Build;
import com.kuaishou.weapon.p0.jni.Engine;
import java.lang.reflect.Method;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_06_4659cls.dex */
public class cr {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static int f40094a;
    private static boolean b;

    public cr() {
        b();
    }

    private int a(Method method) {
        try {
            int i = f40094a;
            if (i <= 1 || method == null) {
                return 0;
            }
            return Engine.mmo(method, i, method.getModifiers());
        } catch (Exception unused) {
            return 0;
        }
    }

    private void b() {
        if (!Engine.loadSuccess || b) {
            return;
        }
        boolean zB = cp.b();
        int i = Build.VERSION.SDK_INT;
        if (zB && i < 29) {
            f40094a = Engine.off();
        }
        b = true;
    }

    private boolean c() {
        return b && f40094a > 1;
    }

    public int a(Class cls, String str, Object... objArr) {
        try {
            if (c()) {
                return a(df.a(cls, str, objArr));
            }
            return 0;
        } catch (Exception unused) {
            return 0;
        }
    }

    public int a(int i, Class cls, String str, Object... objArr) {
        Method methodA;
        try {
            if (!c() || (methodA = df.a(cls, str, objArr)) == null) {
                return 0;
            }
            return Engine.mqc(methodA, i);
        } catch (Exception unused) {
            return 0;
        }
    }

    public int a() {
        if (!c()) {
            return -1;
        }
        long jA = co.b.a();
        long jA2 = co.f40090a.a();
        if (f40094a == jA) {
            return (int) jA2;
        }
        return -1;
    }
}

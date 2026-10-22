package com.acse.ottn;

import android.os.Build;
import android.view.View;
import android.view.animation.Interpolator;
import java.util.WeakHashMap;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public abstract class w4 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final WeakHashMap<View, w4> f23284a = new WeakHashMap<>(0);

    public static w4 a(View view) {
        WeakHashMap<View, w4> weakHashMap = f23284a;
        w4 x4Var = weakHashMap.get(view);
        if (x4Var == null) {
            int iIntValue = Integer.valueOf(Build.VERSION.SDK).intValue();
            if (iIntValue >= 14) {
                x4Var = new y4(view);
            } else {
                x4Var = iIntValue >= 11 ? new x4(view) : new z4(view);
            }
            weakHashMap.put(view, x4Var);
        }
        return x4Var;
    }

    public abstract w4 a(float f);

    public abstract w4 a(long j);

    public abstract w4 a(Interpolator interpolator);

    public abstract w4 a(j.a aVar);

    public abstract void a();

    public abstract long b();

    public abstract w4 b(float f);

    public abstract w4 b(long j);

    public abstract long c();

    public abstract w4 c(float f);

    public abstract w4 d(float f);

    public abstract void d();

    public abstract w4 e(float f);

    public abstract w4 f(float f);

    public abstract w4 g(float f);

    public abstract w4 h(float f);

    public abstract w4 i(float f);

    public abstract w4 j(float f);

    public abstract w4 k(float f);

    public abstract w4 l(float f);

    public abstract w4 m(float f);

    public abstract w4 n(float f);

    public abstract w4 o(float f);

    public abstract w4 p(float f);

    public abstract w4 q(float f);

    public abstract w4 r(float f);

    public abstract w4 s(float f);

    public abstract w4 t(float f);
}

package com.zj.adlib;

import android.content.Context;
import com.facebook.drawee.view.SimpleDraweeView;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_08_10593cls.dex */
public class on3 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static wr6 f43786a;

    public static wr6 a() {
        return f43786a;
    }

    public static s74 b() {
        return c().j();
    }

    public static u74 c() {
        return u74.k();
    }

    public static void d(Context context) {
        u74.v(context);
        f(context);
    }

    public static void e(Context context, t74 t74Var) {
        u74.w(t74Var);
        f(context);
    }

    public static void f(Context context) {
        wr6 wr6Var = new wr6(context);
        f43786a = wr6Var;
        SimpleDraweeView.initialize(wr6Var);
    }

    public static vr6 g() {
        return f43786a.get();
    }

    public static void h() {
        f43786a = null;
        SimpleDraweeView.shutDown();
        u74.x();
    }
}

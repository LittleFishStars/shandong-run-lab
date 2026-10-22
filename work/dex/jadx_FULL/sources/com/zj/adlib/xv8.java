package com.zj.adlib;

import android.content.Context;
import com.google.gson.Gson;
import com.huachenjie.run.bean.SunshineRunFinishData;
import com.huachenjie.run.bean.SunshineRunServiceData;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_01_2010cls.dex */
public class xv8 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static SunshineRunFinishData f45905a = null;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public static SunshineRunServiceData f20742a = null;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public static final String f20743a = "SunshineDataStorage";
    public static final String b = "key_sunshine_data";
    public static final String c = "key_sunshine_finish_data";

    public static SunshineRunFinishData a() {
        if (f45905a == null) {
            SunshineRunFinishData sunshineRunFinishData = (SunshineRunFinishData) new Gson().fromJson((String) zr8.c(f20743a).h(c, ""), SunshineRunFinishData.class);
            f45905a = sunshineRunFinishData;
            if (sunshineRunFinishData == null) {
                return null;
            }
        }
        return f45905a;
    }

    public static SunshineRunServiceData b() {
        if (f20742a == null) {
            SunshineRunServiceData sunshineRunServiceData = (SunshineRunServiceData) new Gson().fromJson((String) zr8.c(f20743a).h(b, ""), SunshineRunServiceData.class);
            f20742a = sunshineRunServiceData;
            if (sunshineRunServiceData == null) {
                return null;
            }
        }
        return f20742a;
    }

    public static void c(Context context) {
        zr8.f(f20743a, new p55(context, f20743a), new wp());
    }

    public static boolean d() {
        return ((Boolean) zr8.c(f20743a).h("notShowPublishAgain", Boolean.FALSE)).booleanValue();
    }

    public static void e() {
        zr8.c(f20743a).l(c);
    }

    public static void f() {
        zr8.c(f20743a).l(b);
    }

    public static void g(boolean notAgain) {
        zr8.c(f20743a).j("notShowPublishAgain", Boolean.valueOf(notAgain));
    }

    public static void h(SunshineRunFinishData sunshineRunServiceData) {
        if (sunshineRunServiceData == null) {
            return;
        }
        f45905a = sunshineRunServiceData;
        zr8.c(f20743a).j(c, new Gson().toJson(sunshineRunServiceData));
    }

    public static void i(SunshineRunServiceData sunshineRunServiceData) {
        if (sunshineRunServiceData == null) {
            return;
        }
        f20742a = sunshineRunServiceData;
        zr8.c(f20743a).j(b, new Gson().toJson(sunshineRunServiceData));
    }
}

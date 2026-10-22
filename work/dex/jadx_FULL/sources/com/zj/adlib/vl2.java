package com.zj.adlib;

import android.content.Context;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_02_3758cls.dex */
public class vl2 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static Boolean f45379a = null;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public static Integer f20243a = null;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public static final String f20244a = "DevConfigStorage";
    public static Boolean b = null;

    /* JADX INFO: renamed from: b, reason: collision with other field name */
    public static final String f20245b = "key_pace_mock";
    public static Boolean c = null;

    /* JADX INFO: renamed from: c, reason: collision with other field name */
    public static final String f20246c = "key_location_mock_switch";
    public static final String d = "key_gps_switch";
    public static final String e = "key_dev_check_switch";

    public static boolean a() {
        return false;
    }

    public static int b() {
        if (f20243a == null) {
            f20243a = (Integer) zr8.c(f20244a).h(f20245b, 0);
        }
        return f20243a.intValue();
    }

    public static void c(Context context) {
        zr8.f(f20244a, new p55(context, f20244a), new wp());
    }

    public static boolean d() {
        return true;
    }

    public static boolean e() {
        return true;
    }

    public static void f(boolean check) {
        c = Boolean.valueOf(check);
        zr8.c(f20244a).j(e, Boolean.valueOf(check));
    }

    public static void g(boolean gpsSwitch) {
        b = Boolean.valueOf(gpsSwitch);
        zr8.c(f20244a).j(d, Boolean.valueOf(gpsSwitch));
    }

    public static void h(boolean locationMockSwitch) {
        f45379a = Boolean.valueOf(locationMockSwitch);
        zr8.c(f20244a).j(f20246c, Boolean.valueOf(locationMockSwitch));
    }

    public static void i(int paceMock) {
        f20243a = Integer.valueOf(paceMock);
        zr8.c(f20244a).j(f20245b, Integer.valueOf(paceMock));
    }
}

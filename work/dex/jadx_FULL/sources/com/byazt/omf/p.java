package com.byazt.omf;

import android.text.TextUtils;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_11_8719cls.dex */
@com.byazt.zqa.c(c = {0, 1, 31, 350})
public final class p {
    public static final int tt = 7611;
    public static final Boolean c = Boolean.TRUE;
    public static boolean ve = false;
    public static int uj = 7611;
    public static String n = "7.6.1.1";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static int f28884a = 1000;
    public static boolean sp = true;
    public static String x = "main";
    public static boolean i = false;
    public static String da = "6.6.0.0";

    public static String a() {
        StringBuilder sb = new StringBuilder();
        sb.append(x);
        sb.append(c() ? "_plugin" : "");
        sb.append(i ? "_open" : "_close");
        return sb.toString();
    }

    public static String c(String str, int i2) {
        return "";
    }

    public static boolean c() {
        return true;
    }

    public static boolean n() {
        return com.byazt.btt.tt.c().isTTVideoOk();
    }

    public static String sp() {
        return c("com.byted.pangle", 7611);
    }

    public static boolean tt() {
        return false;
    }

    public static boolean uj() {
        return false;
    }

    public static boolean ve() {
        return com.byazt.bzd.sp.tt();
    }

    public static boolean x() {
        return TextUtils.equals("internal", x);
    }
}

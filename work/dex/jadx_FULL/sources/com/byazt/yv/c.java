package com.byazt.yv;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_11_8719cls.dex */
@com.byazt.zqa.c(c = {0, 1, 499, 20})
public class c {
    public static String a() {
        return c().getVendor();
    }

    public static com.byazt.dna.u c() {
        return (com.byazt.dna.u) com.byazt.ut.uj.getService("device_info_new");
    }

    public static int i() {
        return c().getScreenWidth();
    }

    public static String n() {
        return c().getDeviceModel();
    }

    public static int sp() {
        return c().getDisplayDpi();
    }

    public static String tt() {
        return c().getWifiMac(null);
    }

    public static String uj() {
        return c().getRom();
    }

    public static int ve() {
        return c().getTimeZoneInt();
    }

    public static int x() {
        return c().getScreenHeight();
    }
}

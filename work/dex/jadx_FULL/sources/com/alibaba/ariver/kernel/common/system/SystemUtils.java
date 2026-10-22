package com.alibaba.ariver.kernel.common.system;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public class SystemUtils {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static String f24273a;

    public static String getManufacturer() {
        if (f24273a == null) {
            f24273a = SystemPropertiesCompat.get("ro.product.manufacturer");
        }
        return f24273a;
    }

    public static boolean isGenie() {
        return "alps".equals(getManufacturer());
    }

    public static boolean isXiaoPeng() {
        return "XiaoPeng".equals(getManufacturer());
    }
}

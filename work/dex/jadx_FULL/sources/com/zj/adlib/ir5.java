package com.zj.adlib;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_02_3758cls.dex */
public class ir5 {
    public static String a(Float money) {
        int iRound = Math.round((money.floatValue() - money.intValue()) * 100.0f);
        if (iRound % 100 == 0) {
            return String.format("%.0f", money);
        }
        return iRound % 10 == 0 ? String.format("%.1f", money) : String.format("%.2f", money);
    }
}

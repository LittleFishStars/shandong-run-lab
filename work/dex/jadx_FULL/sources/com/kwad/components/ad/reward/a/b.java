package com.kwad.components.ad.reward.a;

import com.kwad.sdk.core.response.model.AdInfo;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_06_4659cls.dex */
public final class b {
    public static int hL() {
        return a.uo.getValue().intValue();
    }

    public static String hM() {
        return a.us.getValue();
    }

    public static int hN() {
        return a.up.getValue().intValue();
    }

    public static boolean hO() {
        return a.ur.getValue().booleanValue();
    }

    public static int hP() {
        return a.uq.getValue().intValue();
    }

    private static boolean hQ() {
        return a.uu.getValue().intValue() == 1;
    }

    public static float hR() {
        return a.uz.getValue().floatValue();
    }

    public static boolean hS() {
        return a.uz.getValue().floatValue() > 0.0f && a.uz.getValue().floatValue() < 1.0f;
    }

    public static boolean hT() {
        return a.uA.getValue().booleanValue();
    }

    public static long hU() {
        return a.ux.getValue().intValue();
    }

    public static int hV() {
        return a.uy.getValue().intValue();
    }

    public static int hW() {
        return a.uB.getValue().intValue();
    }

    public static boolean hX() {
        return a.uC.getValue().booleanValue();
    }

    public static boolean hY() {
        return a.uD.getValue().intValue() == 1 || a.uD.getValue().intValue() == 3;
    }

    public static boolean hZ() {
        return a.uE.getValue().booleanValue();
    }

    public static boolean ia() {
        return a.uF.getValue().booleanValue();
    }

    public static boolean j(AdInfo adInfo) {
        return !k(adInfo) && com.kwad.sdk.core.response.helper.a.cW(adInfo) && hQ();
    }

    public static boolean k(AdInfo adInfo) {
        return com.kwad.sdk.core.response.helper.a.cW(adInfo) && a.uw.getValue().intValue() == 1;
    }

    public static boolean l(AdInfo adInfo) {
        return j(adInfo);
    }
}

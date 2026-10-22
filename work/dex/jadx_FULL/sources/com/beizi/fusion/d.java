package com.beizi.fusion;

import com.bytedance.sdk.openadsdk.mediation.MediationConstant;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_10_7392cls.dex */
public enum d {
    BANNER(MediationConstant.RIT_TYPE_BANNER, "4"),
    NATIVE("native", "3"),
    UNIFIED("unified", ""),
    INTERSTITIAL(MediationConstant.RIT_TYPE_INTERSTITIAL, "2"),
    VIDEO("video", ""),
    SPLASH(MediationConstant.RIT_TYPE_SPLASH, "1"),
    S2S("S2S", "");


    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final String f27150a;
    private final String b;

    d(String str, String str2) {
        this.f27150a = str;
        this.b = str2;
    }

    public String b() {
        return this.b;
    }

    public String c() {
        return this.f27150a;
    }
}

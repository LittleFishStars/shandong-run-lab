package com.byazt.yl;

import android.text.TextUtils;
import com.byazt.nbs.da;
import com.bytedance.sdk.openadsdk.mediation.MediationConstant;
import com.ipd.dsp.internal.e1.i;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_11_8719cls.dex */
@com.byazt.zqa.c(c = {0, 1, 509, 20})
public final class c {
    public static String c(int i) {
        if (i == 3) {
            return "gdt";
        }
        if (i == 1) {
            return MediationConstant.ADN_PANGLE;
        }
        if (i == 4) {
            return MediationConstant.ADN_MINTEGRAL;
        }
        if (i == 5) {
            return MediationConstant.ADN_UNITY;
        }
        if (i == 6) {
            return "baidu";
        }
        if (i == 7) {
            return MediationConstant.ADN_KS;
        }
        if (i == 8) {
            return "sigmob";
        }
        if (i == 9) {
            return MediationConstant.ADN_KLEVIN;
        }
        if (i == 10) {
            return "xiaomi";
        }
        return i == -1 ? "custom" : "";
    }

    public static String c(int i, int i2) {
        switch (i) {
            case 1:
                return i.d;
            case 2:
                return "Interstitial";
            case 3:
            case 4:
                return "Splash";
            case 5:
                if (i2 == 4) {
                    return i.g;
                }
                if (i2 == 5) {
                    return i.f;
                }
                return i2 == 3 ? i.d : i.g;
            case 6:
            default:
                return null;
            case 7:
                if (i2 == 6) {
                    return i.b;
                }
                if (i2 == 7) {
                    return "FullVideo";
                }
                return i2 == 8 ? "Interstitial" : i.b;
            case 8:
                return "FullVideo";
            case 9:
                return i.f;
            case 10:
                if (i2 == 1) {
                    return "Interstitial";
                }
                if (i2 == 2) {
                    return "FullVideo";
                }
                return null;
        }
    }

    public static String c(String str) {
        if (TextUtils.isEmpty(str)) {
            return str;
        }
        if (str.equalsIgnoreCase("gdt")) {
            return "gdt";
        }
        if (str.equalsIgnoreCase(MediationConstant.ADN_PANGLE)) {
            return MediationConstant.ADN_PANGLE;
        }
        if (str.equalsIgnoreCase(MediationConstant.ADN_MINTEGRAL)) {
            return MediationConstant.ADN_MINTEGRAL;
        }
        if (str.equalsIgnoreCase(MediationConstant.ADN_UNITY)) {
            return MediationConstant.ADN_UNITY;
        }
        if (str.equalsIgnoreCase("baidu")) {
            return "baidu";
        }
        if (str.equalsIgnoreCase(MediationConstant.ADN_KS)) {
            return MediationConstant.ADN_KS;
        }
        if (str.equalsIgnoreCase("sigmob")) {
            return "sigmob";
        }
        if (str.equalsIgnoreCase(MediationConstant.ADN_KLEVIN)) {
            return MediationConstant.ADN_KLEVIN;
        }
        return str.equalsIgnoreCase("xiaomi") ? "xiaomi" : str;
    }

    public static int tt(String str) {
        if (TextUtils.isEmpty(str)) {
            return 0;
        }
        if (str.startsWith("gdt")) {
            return 3;
        }
        if (str.equalsIgnoreCase(MediationConstant.ADN_PANGLE)) {
            return 1;
        }
        if (str.equalsIgnoreCase(MediationConstant.ADN_MINTEGRAL)) {
            return 4;
        }
        if (str.equalsIgnoreCase(MediationConstant.ADN_UNITY)) {
            return 5;
        }
        if (str.equalsIgnoreCase("baidu")) {
            return 6;
        }
        if (str.equalsIgnoreCase(MediationConstant.ADN_KS)) {
            return 7;
        }
        if (str.equalsIgnoreCase("sigmob")) {
            return 8;
        }
        if (str.equalsIgnoreCase(MediationConstant.ADN_KLEVIN)) {
            return 9;
        }
        return str.equalsIgnoreCase("xiaomi") ? 10 : -1;
    }

    public static String tt(int i) {
        switch (i) {
            case 1:
                return i.d;
            case 2:
                return "Interstitial";
            case 3:
            case 4:
                return "Splash";
            case 5:
                return i.g;
            case 6:
            default:
                return "UnKnow";
            case 7:
                return i.b;
            case 8:
                return "FullVideo";
            case 9:
                return i.f;
            case 10:
                return "InterstitialFull";
        }
    }

    public static String c(int i, int i2, da daVar) {
        switch (i) {
            case 1:
                return i.d;
            case 2:
                return "Interstitial";
            case 3:
            case 4:
                return "Splash";
            case 5:
                if (i2 != 4) {
                    if (i2 == 5) {
                        return "NativeDraw";
                    }
                    return i2 == 3 ? i.d : "Native-自渲染";
                }
                if (daVar == null) {
                    return "Native-自渲染";
                }
                int iDa = daVar.da();
                if (TextUtils.equals(daVar.nu(), "baidu") && (iDa == 1 || iDa == 2)) {
                    return "Native-自渲染";
                }
                return (iDa == 1 || iDa == 3) ? "Native-模板渲染" : "Native-自渲染";
            case 6:
            default:
                return null;
            case 7:
                if (i2 == 6) {
                    return "Reward_RewardVideo";
                }
                if (i2 == 7) {
                    return "Reward_FullVideo";
                }
                return i2 == 8 ? "Reward_Interstitial" : "Reward_RewardVideo";
            case 8:
                return "FullVideo";
            case 9:
                return "NativeDraw";
            case 10:
                if (i2 == 1) {
                    return "InterstitialFull—Interstitial";
                }
                if (i2 == 2) {
                    return "InterstitialFull—FullVideo";
                }
                return null;
        }
    }
}

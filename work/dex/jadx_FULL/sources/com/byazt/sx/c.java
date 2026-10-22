package com.byazt.sx;

import android.text.TextUtils;
import com.byazt.dc.n;
import com.byazt.yf.da;
import com.bytedance.sdk.openadsdk.mediation.MediationConstant;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_11_8719cls.dex */
@com.byazt.zqa.c(c = {0, 1, 928, 20})
public class c {
    public static void c() {
        try {
            if (com.byazt.eu.tt.tt() && da.c()) {
                tt();
            }
        } catch (Throwable unused) {
        }
    }

    private static synchronized void tt() {
        if (com.byazt.bp.tt.getContext() == null) {
            return;
        }
        com.byazt.ck.ve.c().n();
    }

    private static boolean uj(String str, String str2) {
        if (str == null || str2 == null || str.length() == 0 || str2.length() == 0 || str.length() > str2.length()) {
            return false;
        }
        if (str.startsWith("v") || str.startsWith("V")) {
            str = str.substring(1);
        }
        if (str2.startsWith("v") || str2.startsWith("V")) {
            str2 = str2.substring(1);
        }
        String[] strArrSplit = str.split("\\.");
        String[] strArrSplit2 = str2.split("\\.");
        for (int i = 0; i < strArrSplit.length; i++) {
            if (strArrSplit[i].length() == strArrSplit[i].length() && strArrSplit[i].compareTo(strArrSplit2[i]) != 0) {
                return false;
            }
        }
        return true;
    }

    private static int ve(String str, String str2) {
        if (TextUtils.isEmpty(str) && TextUtils.isEmpty(str2)) {
            return 0;
        }
        if (TextUtils.isEmpty(str)) {
            return -1;
        }
        if (TextUtils.isEmpty(str2)) {
            return 1;
        }
        if (str.startsWith("v") || str.startsWith("V")) {
            str = str.substring(1);
        }
        if (str2.startsWith("v") || str2.startsWith("V")) {
            str2 = str2.substring(1);
        }
        String[] strArrSplit = str.split("\\.");
        String[] strArrSplit2 = str2.split("\\.");
        int iMin = Math.min(strArrSplit.length, strArrSplit2.length);
        for (int i = 0; i < iMin; i++) {
            if (strArrSplit[i].length() != strArrSplit2[i].length()) {
                return strArrSplit[i].length() > strArrSplit2[i].length() ? 1 : -1;
            }
            int iCompareTo = strArrSplit[i].compareTo(strArrSplit2[i]);
            if (iCompareTo != 0) {
                return iCompareTo;
            }
        }
        if (strArrSplit.length == strArrSplit2.length) {
            return 0;
        }
        return strArrSplit.length > strArrSplit2.length ? 1 : -1;
    }

    public static boolean c(String str, String str2) {
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            return false;
        }
        if (str.equals("baidu") || str.equals(MediationConstant.ADN_PANGLE)) {
            return true;
        }
        switch (str) {
            case "sigmob":
                if (ve(str2, "4.25.14") != 0) {
                    com.byazt.eu.tt.uj("TTMediationSDK_InitChecker", "sigmob版本不符合, 要求版本等于4.25.14，当前是" + str2);
                    return false;
                }
                com.byazt.eu.tt.c("TTMediationSDK_InitChecker", "sigmob版本正常, 要求版本等于4.25.14，当前是" + str2);
                break;
                break;
            case "xiaomi":
                if (ve(str2, "5.3.3.8") != 0) {
                    com.byazt.eu.tt.uj("TTMediationSDK_InitChecker", "xiaomi版本不符合, 要求版本等于5.3.3.8，当前是" + str2);
                    return false;
                }
                com.byazt.eu.tt.c("TTMediationSDK_InitChecker", "xiaomi版本正常, 要求版本等于5.3.3.8，当前是" + str2);
                break;
                break;
            case "ks":
                if (ve(str2, "5.3.20.1") != 0) {
                    com.byazt.eu.tt.uj("TTMediationSDK_InitChecker", "快手版本不符合, 要求版本等于5.3.20.1，当前是" + str2);
                    return false;
                }
                com.byazt.eu.tt.c("TTMediationSDK_InitChecker", "快手版本正常, 要求版本等于5.3.20.1，当前是" + str2);
                break;
                break;
            case "gdt":
                if (ve(str2, "4.680.1550") != 0) {
                    com.byazt.eu.tt.uj("TTMediationSDK_InitChecker", "gdt版本不符合，要求等于4.680.1550，当前是" + str2);
                    return false;
                }
                com.byazt.eu.tt.c("TTMediationSDK_InitChecker", "gdt版本正常，要求等于4.680.1550，当前是" + str2);
                break;
                break;
            default:
                return false;
        }
        return true;
    }

    public static boolean tt(String str, String str2) {
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            return false;
        }
        if (str.equals(MediationConstant.ADN_PANGLE)) {
            return true;
        }
        switch (str) {
            case "sigmob":
                if (uj("4.25.14", str2)) {
                    c("sigmobAdapter", "4.25.14", str2);
                    break;
                } else {
                    tt("sigmobAdapter", "4.25.14", str2);
                    return false;
                }
                break;
            case "xiaomi":
                if (uj("5.3.3.8", str2)) {
                    c("xiaomiAdapter", "5.3.3.8", str2);
                    break;
                } else {
                    tt("xiaomiAdapter", "5.3.3.8", str2);
                    return false;
                }
                break;
            case "ks":
                if (n.ve(MediationConstant.ADN_KS) != null) {
                    return false;
                }
                if (uj("5.3.20.1", str2)) {
                    c("ksAdapter", "5.3.20.1", str2);
                } else {
                    tt("ksAdapter", "5.3.20.1", str2);
                    return false;
                }
                break;
                break;
            case "gdt":
                if (n.ve("gdt") != null) {
                    return false;
                }
                if (uj("4.680.1550", str2)) {
                    c("gdtAdapter", "4.680.1550", str2);
                } else {
                    tt("gdtAdapter", "4.680.1550", str2);
                    return false;
                }
                break;
                break;
            case "baidu":
                if (uj("9.4503", str2)) {
                    c("baiduAdapter", "9.4503", str2);
                    break;
                } else {
                    tt("baiduAdapter", "9.4503", str2);
                    return false;
                }
                break;
            default:
                return false;
        }
        return true;
    }

    private static void c(String str, String str2, String str3) {
        com.byazt.eu.tt.c("TTMediationSDK_InitChecker", str + "接入版本正常, 要求版为：" + str2 + "，当前版本为：" + str3);
    }

    private static void tt(String str, String str2, String str3) {
        com.byazt.eu.tt.uj("TTMediationSDK_InitChecker", str + "接入版本不符合, 要求版为：" + str2 + ".x，当前版本为：" + str3);
    }
}

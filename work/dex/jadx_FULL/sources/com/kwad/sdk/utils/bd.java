package com.kwad.sdk.utils;

import android.os.Build;
import android.text.TextUtils;
import com.igexin.assist.control.xiaomi.XmSystemUtils;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_04_1967cls.dex */
public final class bd {
    private static String bpZ;
    private static String bqa;

    public static boolean UA() {
        return hZ("OPPO");
    }

    public static boolean UB() {
        return hZ("VIVO");
    }

    public static boolean Wa() {
        return hZ("EMUI");
    }

    public static boolean Wb() {
        return hZ("MIUI");
    }

    public static boolean Wc() {
        return hZ("FLYME");
    }

    public static boolean Wd() {
        return hZ("SMARTISAN");
    }

    public static String getName() {
        if (bpZ == null) {
            hZ("");
        }
        return bpZ;
    }

    public static String getVersion() {
        if (bqa == null) {
            hZ("");
        }
        return bqa;
    }

    private static boolean hZ(String str) {
        String str2 = bpZ;
        if (str2 != null) {
            return str2.contains(str);
        }
        String str3 = bs.get(com.blankj.utilcode.util.e.d);
        bqa = str3;
        if (TextUtils.isEmpty(str3)) {
            String str4 = bs.get("ro.vivo.os.version");
            bqa = str4;
            if (TextUtils.isEmpty(str4)) {
                String str5 = bs.get("ro.build.version.emui");
                bqa = str5;
                if (TextUtils.isEmpty(str5)) {
                    String str6 = bs.get(XmSystemUtils.KEY_VERSION_MIUI);
                    bqa = str6;
                    if (TextUtils.isEmpty(str6)) {
                        String str7 = bs.get("ro.product.system.manufacturer");
                        bqa = str7;
                        if (TextUtils.isEmpty(str7)) {
                            String str8 = bs.get("ro.smartisan.version");
                            bqa = str8;
                            if (!TextUtils.isEmpty(str8)) {
                                bpZ = "SMARTISAN";
                            } else if (bs.get("ro.product.manufacturer").toUpperCase().contains("SAMSUNG")) {
                                bpZ = "SAMSUNG";
                            } else {
                                String str9 = Build.DISPLAY;
                                bqa = str9;
                                if (str9.toUpperCase().contains("FLYME")) {
                                    bpZ = "FLYME";
                                } else {
                                    bqa = "unknown";
                                    bpZ = Build.MANUFACTURER.toUpperCase();
                                }
                            }
                        } else {
                            bpZ = "OnePlus";
                        }
                    } else {
                        bpZ = "MIUI";
                    }
                } else {
                    bpZ = "EMUI";
                }
            } else {
                bpZ = "VIVO";
            }
        } else {
            bpZ = "OPPO";
        }
        return bpZ.contains(str);
    }
}

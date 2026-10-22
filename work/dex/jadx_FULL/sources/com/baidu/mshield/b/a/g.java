package com.baidu.mshield.b.a;

import android.content.Context;
import android.text.TextUtils;
import com.igexin.assist.control.xiaomi.XmSystemUtils;
import java.util.HashMap;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_10_7392cls.dex */
public class g {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final HashMap<String, String> f26701a = new HashMap<>();

    public static String a(Context context) {
        return com.baidu.sec.privacy.e.a.a(context).b();
    }

    public static String b() {
        return a("arv");
    }

    public static String c(Context context) {
        try {
            String strA = a(context);
            String strA2 = com.baidu.sec.privacy.f.g.a("ro.build.display.id", "");
            if (TextUtils.isEmpty(strA)) {
                return strA2;
            }
            if (strA.equalsIgnoreCase("HUAWEI")) {
                return com.baidu.sec.privacy.f.g.a("ro.build.version.emui", strA2);
            }
            if (strA.equalsIgnoreCase("XIAOMI")) {
                return com.baidu.sec.privacy.f.g.a(com.blankj.utilcode.util.e.c, strA2);
            }
            if (strA.equalsIgnoreCase("OPPO")) {
                return com.baidu.sec.privacy.f.g.a(com.blankj.utilcode.util.e.d, strA2);
            }
            if (strA.equalsIgnoreCase("VIVO")) {
                return com.baidu.sec.privacy.f.g.a("ro.vivo.rom.version", strA2);
            }
            if (strA.equalsIgnoreCase("BBK")) {
                return com.baidu.sec.privacy.f.g.a("ro.build.version.bbk", strA2);
            }
            if (strA.equalsIgnoreCase("MEIZU")) {
                return com.baidu.sec.privacy.f.g.a(com.blankj.utilcode.util.e.c, strA2);
            }
            if (strA.equalsIgnoreCase("SAMSUNG") || strA.equalsIgnoreCase("GiONEE")) {
                return strA2;
            }
            if (strA.equalsIgnoreCase("ZTE")) {
                String strA3 = com.baidu.sec.privacy.f.g.a(com.blankj.utilcode.util.e.i, strA2);
                if (!strA2.equals(strA3)) {
                    return strA3;
                }
                String strA4 = com.baidu.sec.privacy.f.g.a("apps.setting.product.release", strA2);
                return strA2.equals(strA4) ? com.baidu.sec.privacy.f.g.a("ro.bliss.display.version", strA2) : strA4;
            }
            if (!strA.equalsIgnoreCase("LeMobile") && !strA.equalsIgnoreCase("Letv")) {
                if (strA.equalsIgnoreCase("LENOVO")) {
                    String strA5 = a();
                    if (!TextUtils.isEmpty(strA5)) {
                        if (strA5.equalsIgnoreCase("Lenovo A5800-D")) {
                            return com.baidu.sec.privacy.f.g.a("ro.build.cmccdisplay.id", strA2);
                        }
                        if (strA5.equalsIgnoreCase("Lenovo K900")) {
                            return com.baidu.sec.privacy.f.g.a(com.blankj.utilcode.util.e.c, strA2);
                        }
                    }
                } else {
                    if (strA.equalsIgnoreCase("YuLong")) {
                        return strA2;
                    }
                    if (strA.equalsIgnoreCase("OnePlus")) {
                        return com.baidu.sec.privacy.f.g.a(com.blankj.utilcode.util.e.h, strA2);
                    }
                    if (strA.equalsIgnoreCase("QiKU")) {
                        return com.baidu.sec.privacy.f.g.a(com.blankj.utilcode.util.e.f, strA2);
                    }
                    if (strA.equalsIgnoreCase("nubia")) {
                        return com.baidu.sec.privacy.f.g.a(com.blankj.utilcode.util.e.i, strA2);
                    }
                    if (strA.equalsIgnoreCase("motorola")) {
                        return strA2;
                    }
                    if (strA.equalsIgnoreCase("HTC")) {
                        return com.baidu.sec.privacy.f.g.a("ro.build.sense.version", strA2);
                    }
                    if (strA.equalsIgnoreCase("ZUK")) {
                        return com.baidu.sec.privacy.f.g.a(com.blankj.utilcode.util.e.c, strA2);
                    }
                    if (strA.equalsIgnoreCase("K-Touch")) {
                        return com.baidu.sec.privacy.f.g.a("ro.yunos.version", strA2);
                    }
                    if (strA.equalsIgnoreCase("MeiTu")) {
                        return com.baidu.sec.privacy.f.g.a("ro.build.version.meios", strA2);
                    }
                    if (strA.equalsIgnoreCase("DOOV")) {
                        return com.baidu.sec.privacy.f.g.a("ro.fota.version", strA2);
                    }
                    if (strA.equalsIgnoreCase("hisense")) {
                        String strA6 = a();
                        if (!TextUtils.isEmpty(strA6)) {
                            if (strA6.equalsIgnoreCase("hisense e76")) {
                                return com.baidu.sec.privacy.f.g.a("ro.hs.ui.style", strA2);
                            }
                            if (strA6.equalsIgnoreCase("hisense e51-m")) {
                                return com.baidu.sec.privacy.f.g.a("hw.cabl.version", strA2);
                            }
                        }
                    } else {
                        if (strA.equalsIgnoreCase("Changhong")) {
                            return com.baidu.sec.privacy.f.g.a("ro.fota.version", strA2);
                        }
                        if (strA.equalsIgnoreCase("smartisan")) {
                            return com.baidu.sec.privacy.f.g.a("ro.smartisan.version", strA2);
                        }
                        if (strA.equalsIgnoreCase("NM")) {
                            return com.baidu.sec.privacy.f.g.a("ro.xh.display.version", strA2);
                        }
                        if (strA.equalsIgnoreCase("HONOR")) {
                            return com.baidu.sec.privacy.f.g.a("ro.build.version.emui", strA2);
                        }
                        if (strA.equalsIgnoreCase("REALME")) {
                            return com.baidu.sec.privacy.f.g.a(com.blankj.utilcode.util.e.d, strA2);
                        }
                    }
                }
                return strA2;
            }
            return com.baidu.sec.privacy.f.g.a(com.blankj.utilcode.util.e.e, strA2);
        } catch (Throwable th) {
            com.baidu.sec.privacy.f.c.a(th);
            return "";
        }
    }

    public static String a() {
        return a("mod");
    }

    public static String b(Context context) {
        try {
            String strA = a(context);
            if (TextUtils.isEmpty(strA)) {
                return "";
            }
            if (strA.equalsIgnoreCase("HUAWEI")) {
                return "EmotionUI";
            }
            if (strA.equalsIgnoreCase("HONOR")) {
                return "MagicUI";
            }
            if (strA.equalsIgnoreCase("XIAOMI")) {
                return com.baidu.sec.privacy.f.g.a(XmSystemUtils.KEY_VERSION_MIUI, "MIUI");
            }
            if (strA.equalsIgnoreCase("OPPO")) {
                return "ColorOS";
            }
            if (strA.equalsIgnoreCase("VIVO")) {
                return com.baidu.sec.privacy.f.g.a("ro.vivo.os.name", "Funtouch");
            }
            if (strA.equalsIgnoreCase("BBK")) {
                return "BBK";
            }
            if (strA.equalsIgnoreCase("MEIZU")) {
                return com.baidu.sec.privacy.f.g.a("ro.build.user", "Flyme");
            }
            if (strA.equalsIgnoreCase("samsung")) {
                return "SAMSUNG";
            }
            if (strA.equalsIgnoreCase("GiONEE")) {
                return com.baidu.sec.privacy.f.g.a("ro.build.display.id", "Amigo");
            }
            if (strA.equalsIgnoreCase("ZTE")) {
                String strA2 = a();
                return (TextUtils.isEmpty(strA2) || !strA2.equalsIgnoreCase("X9180")) ? com.baidu.sec.privacy.f.g.a("ro.build.nubia.rom.name", "ZTE") : "Bliss";
            }
            if (strA.equalsIgnoreCase("LeMobile") || strA.equalsIgnoreCase("Letv")) {
                return "EUI";
            }
            if (strA.equalsIgnoreCase("LENOVO")) {
                return "LENOVO";
            }
            if (strA.equalsIgnoreCase("YuLong")) {
                return "COOLUI";
            }
            if (strA.equalsIgnoreCase("OnePlus")) {
                return "H2OS";
            }
            if (strA.equalsIgnoreCase("QiKU")) {
                return "QIKU";
            }
            if (strA.equalsIgnoreCase("nubia")) {
                return com.baidu.sec.privacy.f.g.a("ro.build.nubia.rom.name", "NUBIAUI");
            }
            if (strA.equalsIgnoreCase("motorola")) {
                return "MOTOROLA";
            }
            if (strA.equalsIgnoreCase("HTC")) {
                return "HTC Sense";
            }
            if (strA.equalsIgnoreCase("ZUK")) {
                return "ZUI";
            }
            if (strA.equalsIgnoreCase("coolpad")) {
                return "COOLPAD";
            }
            if (strA.equalsIgnoreCase("360")) {
                return com.baidu.sec.privacy.f.g.a(com.blankj.utilcode.util.e.f, "360");
            }
            if (strA.equalsIgnoreCase("K-Touch")) {
                return "KTOUCH";
            }
            if (strA.equalsIgnoreCase("MeiTu")) {
                return com.baidu.sec.privacy.f.g.a("ro.build.user", "MEITU");
            }
            if (strA.equalsIgnoreCase("DOOV")) {
                return com.baidu.sec.privacy.f.g.a("ro.fota.oem", "DOOV");
            }
            if (strA.equalsIgnoreCase("TCL")) {
                return "TCL";
            }
            if (strA.equalsIgnoreCase("Yota Devices Limited")) {
                return "Yota";
            }
            if (strA.equalsIgnoreCase("lge")) {
                return com.baidu.sec.privacy.f.g.a("ro.build.product", "LGE");
            }
            if (strA.equalsIgnoreCase("hisense")) {
                return "VISION";
            }
            if (strA.equalsIgnoreCase("Changhong")) {
                return "CHANGHONG";
            }
            if (strA.equalsIgnoreCase("Sony")) {
                return "Sony";
            }
            if (strA.equalsIgnoreCase("smartisan")) {
                return "smartisan";
            }
            if (strA.equalsIgnoreCase("NM")) {
                return "newman";
            }
            return strA.equalsIgnoreCase("REALME") ? "realmeUI" : "";
        } catch (Throwable th) {
            com.baidu.sec.privacy.f.c.a(th);
        }
    }

    public static String a(String str) {
        try {
            HashMap<String, String> map = f26701a;
            if (map.size() <= 0) {
                return "";
            }
            synchronized (map) {
                if (!map.containsKey(str)) {
                    return "";
                }
                return map.get(str);
            }
        } catch (Throwable th) {
            com.baidu.sec.privacy.f.c.a(th);
            return "";
        }
    }

    public static void a(HashMap<String, String> map) {
        if (map != null) {
            HashMap<String, String> map2 = f26701a;
            synchronized (map2) {
                map2.putAll(map);
            }
        }
    }

    /* JADX WARN: Bottom block not found for handler: all -> 0x002f */
    /* JADX WARN: Code restructure failed: missing block: B:19:0x0033, code lost:
    
        return;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static void b(HashMap<String, String> map) {
        if (map != null) {
            if (map.size() == 0) {
                return;
            }
            synchronized (f26701a) {
                try {
                    for (String str : map.keySet()) {
                        f26701a.put(str, map.get(str));
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
    }
}

package com.byazt.sw;

import android.text.TextUtils;
import com.byazt.aas.nb;
import com.byazt.ete.ic;
import com.byazt.nr.m;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_11_8719cls.dex */
@com.byazt.zqa.c(c = {0, 1, 868, 13})
public class tt {
    public static Map<String, Map<String, Map<String, Integer>>> c = new HashMap();

    private static void a(String str, String str2) {
        c(str, str2, "fb_c");
    }

    /* JADX WARN: Code duplicated, block: B:46:0x00a1  */
    public static void c(String str, ic icVar) {
        if (TextUtils.isEmpty(str)) {
        }
        com.byazt.whk.ve veVar = (com.byazt.whk.ve) com.byazt.ut.uj.getService("pitaya");
        if (veVar == null || veVar.isPitayaEnvAvailable()) {
            try {
                String strValueOf = String.valueOf(nb.sl(icVar));
                String strC = nb.c(icVar, "-1");
                switch (str) {
                    case "load_video_start":
                        x(strValueOf, strC);
                        break;
                    case "load_video_cancel":
                        sl(strValueOf, strC);
                        break;
                    case "load_video_success":
                        i(strValueOf, strC);
                        break;
                    case "load_video_error":
                        da(strValueOf, strC);
                        break;
                    case "play_start":
                        tt(strValueOf, strC);
                        break;
                    case "feed_play":
                        ve(strValueOf, strC);
                        break;
                    case "feed_break":
                        a(strValueOf, strC);
                        break;
                    case "feed_pause":
                        n(strValueOf, strC);
                        break;
                    case "feed_over":
                        uj(strValueOf, strC);
                        break;
                    case "play_error":
                        sp(strValueOf, strC);
                        break;
                    case "show":
                        c(strValueOf, strC);
                        break;
                    default:
                        break;
                }
            } catch (Throwable th) {
                m.c(th);
            }
        }
    }

    private static void da(String str, String str2) {
        c(str, str2, "lve_c");
    }

    private static void i(String str, String str2) {
        c(str, str2, "lvsu_c");
    }

    private static void n(String str, String str2) {
        c(str, str2, "fpu_c");
    }

    private static void sl(String str, String str2) {
        c(str, str2, "lvc_c");
    }

    private static void sp(String str, String str2) {
        c(str, str2, "pe_c");
    }

    private static void tt(String str, String str2) {
        c(str, str2, "ps_c");
    }

    private static void uj(String str, String str2) {
        c(str, str2, "fo_c");
    }

    private static void ve(String str, String str2) {
        c(str, str2, "fpl_c");
    }

    private static void x(String str, String str2) {
        c(str, str2, "lvs_c");
    }

    private static void c(String str, String str2) {
        c(str, str2, "show_c");
    }

    private static void c(String str, String str2, String str3) {
        Map<String, Map<String, Integer>> map = c.get(str);
        if (map == null) {
            map = new HashMap<>();
            c.put(str, map);
        }
        Map<String, Integer> map2 = map.get(str2);
        if (map2 == null) {
            map2 = new HashMap<>();
            map.put(str2, map2);
        }
        Integer num = map2.get(str3);
        if (num == null) {
            map2.put(str3, 1);
        } else {
            map2.put(str3, Integer.valueOf(num.intValue() + 1));
        }
    }

    public static JSONObject c() {
        JSONObject jSONObject = new JSONObject();
        if (c.isEmpty()) {
            return jSONObject;
        }
        try {
            for (Map.Entry<String, Map<String, Map<String, Integer>>> entry : c.entrySet()) {
                String key = entry.getKey();
                Map<String, Map<String, Integer>> value = entry.getValue();
                JSONObject jSONObject2 = new JSONObject();
                if (value != null) {
                    for (Map.Entry<String, Map<String, Integer>> entry2 : value.entrySet()) {
                        String key2 = entry2.getKey();
                        Map<String, Integer> value2 = entry2.getValue();
                        JSONObject jSONObject3 = new JSONObject();
                        if (value2 != null) {
                            for (Map.Entry<String, Integer> entry3 : value2.entrySet()) {
                                jSONObject3.put(entry3.getKey(), entry3.getValue());
                            }
                        }
                        jSONObject2.put(key2, jSONObject3);
                    }
                }
                jSONObject.put(key, jSONObject2);
            }
        } catch (Exception e) {
            m.c(e);
        }
        return jSONObject;
    }
}

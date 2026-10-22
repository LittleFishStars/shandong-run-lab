package com.byazt.sy;

import android.view.View;
import com.baidu.mapapi.SDKInitializer;
import com.byazt.ete.gr;
import com.byazt.ete.ic;
import com.byazt.ete.p;
import com.byazt.ete.u;
import org.json.JSONObject;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_11_8719cls.dex */
@com.byazt.zqa.c(c = {0, 1, 528, 54})
public class ve {
    public static void c(ic icVar, u uVar, JSONObject jSONObject) {
        if (icVar == null || uVar == null) {
            return;
        }
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        try {
            jSONObject.put("style_id", uVar.n());
            jSONObject.put("component_type", uVar.c());
            jSONObject.put("render_sequence", uVar.ve());
            jSONObject.put("display_area", uVar.uj());
            if (uVar.tt()) {
                jSONObject.put("style_category", p.uj(icVar));
                jSONObject.put("exp_id", p.n(icVar));
                jSONObject.put("group_id", p.a(icVar));
            }
        } catch (Exception unused) {
        }
    }

    private static boolean c(int i, int i2, int i3, int i4, float f, float f2) {
        return f >= ((float) i) && f <= ((float) (i3 + i)) && f2 >= ((float) i2) && f2 <= ((float) (i4 + i2));
    }

    public static void tt(ic icVar, u uVar) {
        JSONObject jSONObject = new JSONObject();
        c(icVar, uVar, jSONObject);
        com.byazt.ddx.uj.c(icVar, "easy_play_start_render", jSONObject);
    }

    public static void tt(ic icVar, u uVar, boolean z) {
        c(icVar, uVar, z, 0, (String) null);
    }

    public static void tt(ic icVar, u uVar, boolean z, int i, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        try {
            jSONObject.put("success", z ? 1 : 0);
            jSONObject.put(SDKInitializer.SDK_BROADTCAST_INTENT_EXTRA_INFO_KEY_ERROR_CODE, i);
        } catch (Exception unused) {
        }
        c(icVar, uVar, jSONObject);
        com.byazt.ddx.uj.c(icVar, "easy_play_show", jSONObject);
    }

    public static void c(ic icVar, u uVar) {
        JSONObject jSONObject = new JSONObject();
        c(icVar, uVar, jSONObject);
        com.byazt.ddx.uj.c(icVar, "easy_play_start_load", jSONObject);
    }

    public static void tt(ic icVar, u uVar, boolean z, JSONObject jSONObject) {
        c(icVar, uVar, z, jSONObject, false);
    }

    public static void c(ic icVar, u uVar, boolean z) {
        c(icVar, uVar, z, 0, (JSONObject) null);
    }

    public static void c(ic icVar, u uVar, boolean z, int i) {
        c(icVar, uVar, z, i, (JSONObject) null);
    }

    public static void c(ic icVar, u uVar, boolean z, int i, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        try {
            jSONObject.put("success", z ? 1 : 0);
            jSONObject.put(SDKInitializer.SDK_BROADTCAST_INTENT_EXTRA_INFO_KEY_ERROR_CODE, i);
        } catch (Exception unused) {
        }
        c(icVar, uVar, jSONObject);
        com.byazt.ddx.uj.c(icVar, "easy_play_load_result", jSONObject);
    }

    public static void c(ic icVar, u uVar, boolean z, int i, String str) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("success", z ? 1 : 0);
            jSONObject.put(SDKInitializer.SDK_BROADTCAST_INTENT_EXTRA_INFO_KEY_ERROR_CODE, i);
            if (str != null) {
                jSONObject.put("error_msg", str);
            }
        } catch (Exception unused) {
        }
        c(icVar, uVar, jSONObject);
        com.byazt.ddx.uj.c(icVar, "easy_play_render_result", jSONObject);
    }

    public static void c(ic icVar, u uVar, boolean z, JSONObject jSONObject) {
        tt(icVar, uVar, z, 0, jSONObject);
    }

    public static void c(ic icVar, u uVar, boolean z, JSONObject jSONObject, boolean z2) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        int i = 2;
        try {
            jSONObject.put("area_type", z ? 1 : 2);
            int iC = uVar.c();
            if (iC == 1 || iC == 3) {
                if (!z2) {
                    i = 1;
                }
                jSONObject.put("click_type", i);
            }
        } catch (Exception unused) {
        }
        c(icVar, uVar, jSONObject);
        com.byazt.ddx.uj.c(icVar, "easy_play_click", jSONObject);
    }

    public static boolean c(View view, com.byazt.sr.ve veVar) {
        if (view != null) {
            int[] iArr = new int[2];
            view.getLocationOnScreen(iArr);
            int i = iArr[0];
            int i2 = iArr[1];
            int width = view.getWidth();
            int height = view.getHeight();
            if (veVar instanceof gr) {
                gr grVar = (gr) veVar;
                return c(i, i2, width, height, grVar.c, grVar.tt);
            }
        }
        return false;
    }
}

package com.byazt.kdw;

import android.content.Context;
import android.text.TextUtils;
import com.byazt.ete.ic;
import com.byazt.ouz.sl;
import com.byazt.pm.a;
import com.byazt.qx.gu;
import com.byazt.sy.sp;
import com.byazt.xj.ve;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_11_8719cls.dex */
@com.byazt.zqa.c(c = {0, 1, 1710, 20})
public class c {
    public static final HashSet<String> c = new HashSet<>(Arrays.asList("interactiveFinish", "nextVideoCancel", "haptic", "closeWidget", "dismiss", "openNewAdPage"));

    public static void c(sl slVar, tt ttVar, ic icVar, Context context, String str, a.c cVar, sp spVar, ve veVar) {
        if (cVar == null) {
        }
        Map<String, Object> mapVe = cVar.ve();
        str.hashCode();
        int iC = 0;
        switch (str) {
            case "nextVideoCancel":
                if (ttVar != null) {
                    ttVar.c();
                    break;
                }
                break;
            case "openNewAdPage":
                if (mapVe != null) {
                    Object obj = mapVe.get("second_page_type");
                    String strValueOf = obj != null ? String.valueOf(obj) : "";
                    if (!TextUtils.isEmpty(strValueOf)) {
                        try {
                            iC = Integer.parseInt(strValueOf);
                            break;
                        } catch (NumberFormatException unused) {
                        }
                    }
                }
                if (spVar != null) {
                    spVar.c(iC);
                    break;
                }
                break;
            case "haptic":
                if (mapVe != null) {
                    Object obj2 = mapVe.get("params");
                    if ((obj2 instanceof String) && !TextUtils.isEmpty((String) obj2)) {
                        try {
                            com.byazt.fx.ve.c(new JSONObject(String.valueOf(obj2)), context, icVar);
                        } catch (JSONException unused2) {
                            return;
                        }
                        break;
                    }
                }
                break;
            case "closeWidget":
                if (spVar != null) {
                    spVar.n();
                    break;
                }
                break;
            case "interactiveFinish":
                if (mapVe != null) {
                    try {
                        Object obj3 = mapVe.get("reduce_duration");
                        if (obj3 instanceof Integer) {
                            iC = gu.c(icVar, ((Integer) obj3).intValue());
                        }
                    } catch (NumberFormatException unused3) {
                    }
                }
                if (slVar != null) {
                    slVar.tt(iC);
                    break;
                }
                break;
            case "dismiss":
                if (veVar != null) {
                    veVar.tt(8);
                    break;
                }
                break;
        }
    }
}

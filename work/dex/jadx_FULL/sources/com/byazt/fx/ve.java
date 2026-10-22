package com.byazt.fx;

import android.content.Context;
import android.os.Vibrator;
import android.text.TextUtils;
import com.byazt.ete.eo;
import com.byazt.ete.ic;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_11_8719cls.dex */
@com.byazt.zqa.c(c = {0, 1, 839, 54})
public class ve {
    public static boolean c(Context context) {
        return uj(context) && n(context);
    }

    private static boolean n(Context context) {
        Vibrator vibratorVe = ve(context);
        return vibratorVe != null && vibratorVe.hasVibrator();
    }

    public static void tt(Context context) {
        Vibrator vibratorVe = ve(context);
        if (vibratorVe != null) {
            vibratorVe.cancel();
        }
    }

    private static boolean uj(Context context) {
        try {
            return context.getPackageManager().checkPermission("android.permission.VIBRATE", context.getPackageName()) == 0;
        } catch (Exception unused) {
        }
    }

    public static Vibrator ve(Context context) {
        try {
            return (Vibrator) context.getSystemService("vibrator");
        } catch (Exception unused) {
            return null;
        }
    }

    public static void c(Context context, eo eoVar) {
        new c(context, eoVar).tt();
    }

    public static void c(JSONObject jSONObject, Context context, ic icVar) {
        if (jSONObject == null || context == null) {
            return;
        }
        c(jSONObject.optString("id"), jSONObject.optJSONArray("pattern"), context, icVar);
    }

    public static void c(String str, JSONArray jSONArray, Context context, ic icVar) {
        eo eoVarTt;
        if (jSONArray != null && jSONArray.length() > 0) {
            eoVarTt = new eo(str, jSONArray);
        } else {
            eoVarTt = (TextUtils.isEmpty(str) || icVar == null) ? null : icVar.tt(str);
        }
        if (eoVarTt != null) {
            c(context, eoVarTt);
        }
    }
}

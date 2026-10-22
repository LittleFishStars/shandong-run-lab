package com.byazt.bnf;

import android.text.TextUtils;
import com.byazt.iy.n;
import com.byazt.nr.m;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import java.util.HashSet;
import java.util.Set;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_11_8719cls.dex */
@com.byazt.zqa.c(c = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_RENDER_STALL_300, 13})
public class tt {
    public static <T> void c(String str, T t, n nVar) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("min_version", 7611);
            jSONObject.put("data", t);
            nVar.put(c(str, true), jSONObject.toString());
        } catch (Exception unused) {
        }
    }

    public static void tt(String str, n nVar) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        try {
            nVar.remove(c(str, true));
        } catch (Exception unused) {
        }
    }

    private static String ve(String str, n nVar) {
        if (!TextUtils.isEmpty(str) && nVar != null) {
            try {
                if (TextUtils.isEmpty(null)) {
                    return c(c(str, true), nVar);
                }
                return null;
            } catch (Exception e) {
                m.c(e);
            }
        }
        return null;
    }

    public static int c(String str, n nVar, int i) {
        String strVe = ve(str, nVar);
        if (TextUtils.isEmpty(strVe)) {
            return i;
        }
        try {
            return Integer.parseInt(strVe);
        } catch (NumberFormatException e) {
            m.c(e);
            return i;
        }
    }

    public static long c(String str, n nVar, long j) {
        String strVe = ve(str, nVar);
        if (TextUtils.isEmpty(strVe)) {
            return j;
        }
        try {
            return Long.parseLong(strVe);
        } catch (NumberFormatException e) {
            m.c(e);
            return j;
        }
    }

    public static float c(String str, n nVar, float f) {
        String strVe = ve(str, nVar);
        if (TextUtils.isEmpty(strVe)) {
            return f;
        }
        try {
            return Float.parseFloat(strVe);
        } catch (NumberFormatException e) {
            m.c(e);
            return f;
        }
    }

    public static Set<String> c(String str, n nVar, Set<String> set) {
        String strVe = ve(str, nVar);
        if (TextUtils.isEmpty(strVe)) {
            return set;
        }
        try {
            JSONArray jSONArray = new JSONArray(strVe);
            HashSet hashSet = new HashSet();
            for (int i = 0; i < jSONArray.length(); i++) {
                String strOptString = jSONArray.optString(i);
                if (!TextUtils.isEmpty(strOptString)) {
                    hashSet.add(strOptString);
                }
            }
            return hashSet;
        } catch (JSONException e) {
            m.c(e);
            return set;
        }
    }

    public static boolean c(String str, n nVar, boolean z) {
        String strVe = ve(str, nVar);
        if (TextUtils.isEmpty(strVe)) {
            return z;
        }
        try {
            return Boolean.parseBoolean(strVe);
        } catch (NumberFormatException e) {
            m.c(e);
            return z;
        }
    }

    public static String c(String str, n nVar, String str2) {
        String strVe = ve(str, nVar);
        return TextUtils.isEmpty(strVe) ? str2 : strVe;
    }

    public static String c(String str, n nVar) {
        return c(nVar.get(str, (String) null));
    }

    public static String c(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        try {
            JSONObject jSONObject = new JSONObject(str);
            if (7611 < jSONObject.optInt("min_version")) {
                return null;
            }
            String strOptString = jSONObject.optString("data");
            if (TextUtils.isEmpty(strOptString)) {
                return null;
            }
            return strOptString;
        } catch (Exception unused) {
            return null;
        }
    }

    private static String c(String str, boolean z) {
        if (z) {
            return str + "_bst";
        }
        return str + "_pl";
    }
}

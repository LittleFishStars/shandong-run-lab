package com.byazt.rb;

import android.text.TextUtils;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.Interpolator;
import android.view.animation.LinearInterpolator;
import androidx.camera.video.AudioStats;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_11_8719cls.dex */
@com.byazt.zqa.c(c = {0, 1, 23, 15})
public class uj {
    public static int c(int i) {
        if (i < 0) {
            return -1;
        }
        if (i == 0) {
            return Integer.MIN_VALUE;
        }
        return i - 1;
    }

    public static List<ve> c(String str, JSONObject jSONObject) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        try {
            JSONArray jSONArray = new JSONArray(str);
            if (jSONArray.length() <= 0) {
                return null;
            }
            for (int i = 0; i < jSONArray.length(); i++) {
                JSONObject jSONObjectOptJSONObject = jSONArray.optJSONObject(i);
                if (jSONObjectOptJSONObject != null) {
                    arrayList.add(c(jSONObjectOptJSONObject, jSONObject));
                }
            }
            return arrayList;
        } catch (JSONException e) {
            throw new RuntimeException(e);
        }
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Code duplicated, block: B:17:0x0032  */
    public static Interpolator tt(String str) {
        byte b;
        switch (str) {
            case "ease_in":
                b = 0;
                break;
            case "linear":
                b = 3;
                break;
            case "ease_out":
                b = 2;
                break;
            case "ease_in_out":
                b = 1;
                break;
            default:
                b = -1;
                break;
        }
        if (b == 0) {
            return new AccelerateInterpolator();
        }
        if (b != 1) {
            return b != 2 ? new LinearInterpolator() : new DecelerateInterpolator();
        }
        return new AccelerateDecelerateInterpolator();
    }

    private static String uj(String str, JSONObject jSONObject) {
        String strC = com.byazt.wj.tt.c(str, jSONObject);
        return ve(strC) ? Arrays.toString(tt(strC, jSONObject)) : com.byazt.wj.tt.c(strC, jSONObject);
    }

    public static boolean ve(String str) {
        JSONArray jSONArrayC = com.byazt.cd.tt.c(str, (JSONArray) null);
        return jSONArrayC != null && jSONArrayC.length() > 0;
    }

    public static ve.c ve(String str, JSONObject jSONObject) {
        JSONArray jSONArrayC;
        if (TextUtils.isEmpty(str) || (jSONArrayC = com.byazt.cd.tt.c(jSONObject, str, null)) == null || jSONArrayC.length() != 2) {
            return null;
        }
        ve.c cVar = new ve.c();
        cVar.c = com.byazt.wj.tt.c(jSONArrayC.optString(0), jSONObject);
        cVar.tt = com.byazt.wj.tt.c(jSONArrayC.optString(1), jSONObject);
        return cVar;
    }

    public static float[] tt(String str, JSONObject jSONObject) {
        float[] fArr = {0.0f, 0.0f};
        JSONArray jSONArrayC = com.byazt.cd.tt.c(jSONObject, str, null);
        if (jSONArrayC != null && jSONArrayC.length() == 2) {
            fArr[0] = (float) com.byazt.cd.ve.c(com.byazt.wj.tt.c(jSONArrayC.optString(0), jSONObject), AudioStats.AUDIO_AMPLITUDE_NONE);
            fArr[1] = (float) com.byazt.cd.ve.c(com.byazt.wj.tt.c(jSONArrayC.optString(1), jSONObject), AudioStats.AUDIO_AMPLITUDE_NONE);
        }
        return fArr;
    }

    public static ve c(JSONObject jSONObject, JSONObject jSONObject2) {
        if (jSONObject == null) {
            return null;
        }
        ve veVar = new ve();
        veVar.tt(com.byazt.cd.ve.c(com.byazt.wj.tt.c(jSONObject.optString("delay"), jSONObject2), 0L));
        veVar.ve(com.byazt.wj.tt.c(jSONObject.optString("name"), jSONObject2));
        veVar.tt(com.byazt.cd.ve.c(com.byazt.wj.tt.c(jSONObject.optString("playState"), jSONObject2), 1));
        veVar.c(Math.max(com.byazt.cd.ve.c(com.byazt.wj.tt.c(jSONObject.optString("duration"), jSONObject2), 0L), 0L));
        veVar.c(com.byazt.cd.ve.c(com.byazt.wj.tt.c(jSONObject.optString("playCount"), jSONObject2), 1));
        veVar.c(com.byazt.wj.tt.c(jSONObject.optString("playDirection"), jSONObject2));
        veVar.c(ve(jSONObject.optString("transformOrigin"), jSONObject2));
        veVar.tt(com.byazt.wj.tt.c(jSONObject.optString("timingFunction", "linear"), jSONObject2));
        veVar.c(jSONObject.optJSONObject("effect"));
        veVar.c(c(jSONObject.optJSONArray(com.google.android.exoplayer2.extractor.flv.c.f2764c), jSONObject2));
        return veVar;
    }

    public static Map<String, TreeMap<Float, String>> c(JSONArray jSONArray, JSONObject jSONObject) {
        if (jSONArray == null || jSONArray.length() <= 0) {
            return null;
        }
        HashMap map = new HashMap();
        for (int i = 0; i < jSONArray.length(); i++) {
            JSONObject jSONObjectOptJSONObject = jSONArray.optJSONObject(i);
            if (jSONObjectOptJSONObject != null) {
                float fOptDouble = (float) jSONObjectOptJSONObject.optDouble(TypedValues.CycleType.S_WAVE_OFFSET);
                Iterator<String> itKeys = jSONObjectOptJSONObject.keys();
                while (itKeys.hasNext()) {
                    String next = itKeys.next();
                    if (!TextUtils.equals(next, TypedValues.CycleType.S_WAVE_OFFSET)) {
                        TreeMap treeMap = (TreeMap) map.get(next);
                        if (treeMap == null) {
                            treeMap = new TreeMap();
                            map.put(next, treeMap);
                        }
                        treeMap.put(Float.valueOf(fOptDouble), uj(jSONObjectOptJSONObject.optString(next), jSONObject));
                    }
                }
            }
        }
        return map;
    }

    /* JADX WARN: Code duplicated, block: B:13:0x0024  */
    public static int c(String str) {
        byte b;
        int iHashCode = str.hashCode();
        if (iHashCode != -1408024454) {
            if (iHashCode == -1039745817 && str.equals("normal")) {
                b = 1;
            } else {
                b = -1;
            }
        } else if (str.equals("alternate")) {
            b = 0;
        } else {
            b = -1;
        }
        return b != 0 ? 1 : 2;
    }

    public static int c(String str, int i) {
        int i2 = i / 2;
        if (TextUtils.isEmpty(str)) {
            return i2;
        }
        str.hashCode();
        switch (str) {
            case "bottom":
            case "right":
                return i;
            case "center":
                return i2;
            case "top":
            case "left":
                return 0;
            default:
                if (str.endsWith("%")) {
                    try {
                        return (int) ((i * Float.parseFloat(str.substring(0, str.length() - 1))) / 100.0f);
                    } catch (NumberFormatException unused) {
                        return i2;
                    }
                }
                try {
                    return Integer.parseInt(str);
                } catch (NumberFormatException unused2) {
                    return i2;
                }
        }
    }
}

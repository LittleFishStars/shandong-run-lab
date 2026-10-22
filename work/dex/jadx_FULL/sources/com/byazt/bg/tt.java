package com.byazt.bg;

import android.text.TextUtils;
import androidx.annotation.NonNull;
import com.byazt.vx.my;
import com.bytedance.sdk.openadsdk.mediation.MediationConstant;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_11_8719cls.dex */
@com.byazt.zqa.c(c = {0, 1, 1535, 13})
public class tt {
    public int c;
    public final Map<String, Float> tt = new ConcurrentHashMap();
    public final Map<String, uj> ve = new ConcurrentHashMap();

    public tt(JSONObject jSONObject) {
        JSONArray jSONArrayOptJSONArray;
        if (jSONObject != null) {
            this.c = jSONObject.optInt("lt_days");
            JSONObject jSONObjectOptJSONObject = jSONObject.optJSONObject("estimate");
            if (jSONObjectOptJSONObject != null && jSONObjectOptJSONObject.length() > 0) {
                Iterator<String> itKeys = jSONObjectOptJSONObject.keys();
                while (itKeys.hasNext()) {
                    String next = itKeys.next();
                    this.tt.put(next, Float.valueOf((float) jSONObjectOptJSONObject.optDouble(next)));
                }
            }
            JSONObject jSONObjectOptJSONObject2 = jSONObject.optJSONObject("rule_excs");
            if (jSONObjectOptJSONObject2 == null || jSONObjectOptJSONObject2.length() == 0) {
                return;
            }
            Iterator<String> itKeys2 = jSONObjectOptJSONObject2.keys();
            while (itKeys2.hasNext()) {
                String next2 = itKeys2.next();
                JSONObject jSONObjectOptJSONObject3 = jSONObjectOptJSONObject2.optJSONObject(next2);
                if (jSONObjectOptJSONObject3 != null && (jSONArrayOptJSONArray = jSONObjectOptJSONObject3.optJSONArray("prime_rits")) != null && jSONArrayOptJSONArray.length() > 0) {
                    for (int i = 0; i < jSONArrayOptJSONArray.length(); i++) {
                        String strOptString = jSONArrayOptJSONArray.optString(i);
                        this.ve.put(strOptString, new uj(next2, strOptString, jSONObjectOptJSONObject3));
                    }
                }
            }
        }
    }

    public JSONObject c(String str, @NonNull my myVar) {
        n nVar;
        if (!com.byazt.bp.tt.tt().l() || str == null) {
            return null;
        }
        JSONObject jSONObject = new JSONObject();
        if (TextUtils.isEmpty(str)) {
            return jSONObject;
        }
        float fC = c(str);
        uj ujVar = this.ve.get(str);
        if (ujVar != null) {
            Map<String, n> mapN = ujVar.n();
            String[] strArrVe = ujVar.ve();
            if (mapN != null && !mapN.isEmpty() && strArrVe != null && strArrVe.length > 0) {
                for (String str2 : strArrVe) {
                    if (!TextUtils.isEmpty(str2) && (nVar = mapN.get(str2)) != null) {
                        try {
                            jSONObject.putOpt(str2, Integer.valueOf(nVar.c(fC)));
                        } catch (Exception e) {
                            com.byazt.eu.tt.uj("", "calculateRangeByScore计算异常：(tableName：" + str2 + ",primeRit:" + str + "），" + e.getMessage());
                        }
                    }
                }
            }
        }
        myVar.put(MediationConstant.KEY_GM_POLICY, jSONObject);
        myVar.put("adl_scr", Float.valueOf(fC));
        com.byazt.bp.c.t().c(str, fC);
        return jSONObject;
    }

    public uj tt(String str) {
        return this.ve.get(str);
    }

    public String ve(String str) {
        uj ujVarTt;
        if (str == null || (ujVarTt = tt(str)) == null) {
            return null;
        }
        return ujVarTt.c();
    }

    public float c(String str) {
        uj ujVar = this.ve.get(str);
        float fC = -1.0f;
        if (ujVar != null) {
            Map<String, Float> mapTt = ujVar.tt();
            String strUj = ujVar.uj();
            if (mapTt != null) {
                if (mapTt.containsKey("lt_x_times")) {
                    Float f = mapTt.get("lt_x_times");
                    int iTt = c.tt();
                    if (f != null) {
                        fC = c(strUj, f.floatValue() * iTt, -1.0f);
                    }
                }
                if (mapTt.containsKey("active_duration")) {
                    Float f2 = mapTt.get("active_duration");
                    long jA = c.a();
                    if (f2 != null) {
                        fC = c(strUj, f2.floatValue() * jA, fC);
                    }
                }
                if (mapTt.containsKey("active_count")) {
                    Float f3 = mapTt.get("active_count");
                    int iUj = c.uj();
                    if (f3 != null) {
                        fC = c(strUj, f3.floatValue() * iUj, fC);
                    }
                }
                if (mapTt.containsKey("show_period")) {
                    Float f4 = mapTt.get("show_period");
                    long jX = c.x(str);
                    if (f4 != null) {
                        fC = c(strUj, f4.floatValue() * jX, fC);
                    }
                }
                if (mapTt.containsKey("show_count")) {
                    Float f5 = mapTt.get("show_count");
                    int iUj2 = c.uj(str);
                    if (f5 != null) {
                        fC = c(strUj, f5.floatValue() * iUj2, fC);
                    }
                }
                if (mapTt.containsKey("dislike_count")) {
                    Float f6 = mapTt.get("dislike_count");
                    int iTt2 = c.tt(str);
                    if (f6 != null) {
                        fC = c(strUj, f6.floatValue() * iTt2, fC);
                    }
                }
                if (mapTt.containsKey("click_count")) {
                    Float f7 = mapTt.get("click_count");
                    int iA = c.a(str);
                    if (f7 != null) {
                        fC = c(strUj, f7.floatValue() * iA, fC);
                    }
                }
                if (mapTt.containsKey("install_days")) {
                    Float f8 = mapTt.get("install_days");
                    int iN = c.n();
                    if (f8 != null) {
                        fC = c(strUj, f8.floatValue() * iN, fC);
                    }
                }
                if (!this.tt.isEmpty()) {
                    for (Map.Entry<String, Float> entry : this.tt.entrySet()) {
                        if (entry != null) {
                            String key = entry.getKey();
                            float fFloatValue = entry.getValue().floatValue();
                            Float f9 = mapTt.get(key);
                            if (f9 != null) {
                                fC = c(strUj, f9.floatValue() * fFloatValue, fC);
                            }
                        }
                    }
                }
            }
        }
        return fC;
    }

    private float c(String str, float f, float f2) {
        if (f2 == -1.0f) {
            return f;
        }
        str.hashCode();
        switch (str) {
            case "*":
                return f2 * f;
            case "+":
                return f2 + f;
            case "max":
                return Math.max(f, f2);
            case "min":
                return Math.min(f, f2);
            default:
                return f2;
        }
    }

    public int c() {
        return this.c;
    }
}

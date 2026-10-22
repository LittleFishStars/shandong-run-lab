package com.byazt.jze;

import com.byazt.pik.n;
import com.byazt.pik.uj;
import com.byazt.pik.ve;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_11_8719cls.dex */
@com.byazt.zqa.c(c = {0, 1, 250, 20})
public class c {
    public static uj c(JSONObject jSONObject) {
        if (jSONObject == null) {
            return null;
        }
        uj ujVar = new uj();
        ujVar.c(jSONObject.optString("type"));
        ujVar.tt(jSONObject.optString("event"));
        return ujVar;
    }

    private static ve n(JSONObject jSONObject) {
        com.byazt.pik.tt ttVarVe;
        com.byazt.pik.c cVarUj;
        if (jSONObject == null) {
            return null;
        }
        ve veVar = new ve();
        veVar.c(jSONObject.optString("ruleId"));
        veVar.c(jSONObject.optBoolean("getAds"));
        veVar.c((float) jSONObject.optDouble("rate"));
        JSONObject jSONObjectOptJSONObject = jSONObject.optJSONObject("config");
        if (jSONObjectOptJSONObject != null) {
            veVar.tt(jSONObjectOptJSONObject.optString("filter"));
            veVar.ve(jSONObjectOptJSONObject.optString("groupBy"));
            JSONObject jSONObjectOptJSONObject2 = jSONObjectOptJSONObject.optJSONObject("window");
            if (jSONObjectOptJSONObject2 != null) {
                veVar.c(tt(jSONObjectOptJSONObject2));
            }
            JSONArray jSONArrayOptJSONArray = jSONObjectOptJSONObject.optJSONArray("aggregate");
            if (jSONArrayOptJSONArray != null && jSONArrayOptJSONArray.length() > 0) {
                ArrayList arrayList = new ArrayList();
                for (int i = 0; i < jSONArrayOptJSONArray.length(); i++) {
                    JSONObject jSONObjectOptJSONObject3 = jSONArrayOptJSONArray.optJSONObject(i);
                    if (jSONObjectOptJSONObject3 != null && (cVarUj = uj(jSONObjectOptJSONObject3)) != null) {
                        arrayList.add(cVarUj);
                    }
                }
                veVar.c(arrayList);
            }
            JSONArray jSONArrayOptJSONArray2 = jSONObjectOptJSONObject.optJSONArray("outputs");
            if (jSONArrayOptJSONArray2 != null && jSONArrayOptJSONArray2.length() > 0) {
                ArrayList arrayList2 = new ArrayList();
                for (int i2 = 0; i2 < jSONArrayOptJSONArray2.length(); i2++) {
                    JSONObject jSONObjectOptJSONObject4 = jSONArrayOptJSONArray2.optJSONObject(i2);
                    if (jSONObjectOptJSONObject4 != null && (ttVarVe = ve(jSONObjectOptJSONObject4)) != null) {
                        arrayList2.add(ttVarVe);
                    }
                }
                veVar.tt(arrayList2);
            }
        }
        return veVar;
    }

    public static n tt(JSONObject jSONObject) {
        if (jSONObject == null) {
            return null;
        }
        n nVar = new n();
        nVar.c(jSONObject.optString("type"));
        nVar.c(jSONObject.optLong("time"));
        nVar.tt(jSONObject.optLong("updateTime"));
        return nVar;
    }

    private static com.byazt.pik.c uj(JSONObject jSONObject) {
        if (jSONObject == null) {
            return null;
        }
        com.byazt.pik.c cVar = new com.byazt.pik.c();
        cVar.c(jSONObject.optString("function"));
        cVar.tt(jSONObject.optString("as"));
        cVar.ve(jSONObject.optString("filter"));
        JSONObject jSONObjectOptJSONObject = jSONObject.optJSONObject("trigger");
        if (jSONObjectOptJSONObject != null) {
            cVar.c(c(jSONObjectOptJSONObject));
        }
        return cVar;
    }

    public static com.byazt.pik.tt ve(JSONObject jSONObject) {
        if (jSONObject == null) {
            return null;
        }
        com.byazt.pik.tt ttVar = new com.byazt.pik.tt();
        ttVar.c(jSONObject.optString("value"));
        ttVar.tt(jSONObject.optString("as"));
        return ttVar;
    }

    public static List<ve> c(JSONArray jSONArray) {
        ve veVarN;
        if (jSONArray != null && jSONArray.length() != 0) {
            try {
                ArrayList arrayList = new ArrayList();
                for (int i = 0; i < jSONArray.length(); i++) {
                    JSONObject jSONObjectOptJSONObject = jSONArray.optJSONObject(i);
                    if (jSONObjectOptJSONObject != null && (veVarN = n(jSONObjectOptJSONObject)) != null) {
                        arrayList.add(veVarN);
                    }
                }
                return arrayList;
            } catch (Throwable unused) {
            }
        }
        return null;
    }
}

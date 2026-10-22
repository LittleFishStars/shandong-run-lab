package com.byazt.ete;

import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_11_8719cls.dex */
@com.byazt.zqa.c(c = {0, 1, 8, 155})
public class lr {
    public List<ir> c;

    public lr(JSONObject jSONObject) {
        JSONArray jSONArrayOptJSONArray;
        if (jSONObject == null || (jSONArrayOptJSONArray = jSONObject.optJSONArray("components")) == null) {
            return;
        }
        this.c = new ArrayList();
        for (int i = 0; i < jSONArrayOptJSONArray.length(); i++) {
            this.c.add(new ir(jSONArrayOptJSONArray.optJSONObject(i), 3));
        }
    }

    public static List<ir> c(ic icVar) {
        lr lrVarWy;
        if (icVar == null || (lrVarWy = icVar.wy()) == null) {
            return null;
        }
        return lrVarWy.c;
    }

    public static boolean tt(ic icVar) {
        lr lrVarWy;
        List<ir> list;
        return (icVar == null || (lrVarWy = icVar.wy()) == null || (list = lrVarWy.c) == null || list.isEmpty()) ? false : true;
    }
}

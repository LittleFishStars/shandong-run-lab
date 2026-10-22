package com.byazt.dbo;

import android.text.TextUtils;
import com.ali.auth.third.login.LoginConstants;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_11_8719cls.dex */
@com.byazt.zqa.c(c = {0, 1, 961, 46})
public class n {
    public int c;
    public Map<String, JSONObject> tt;

    public boolean c() {
        int i = this.c;
        return i > 20000 && i < 100000;
    }

    public static n c(JSONObject jSONObject) {
        if (jSONObject == null) {
            return null;
        }
        int iOptInt = jSONObject.optInt("code");
        JSONArray jSONArrayOptJSONArray = jSONObject.optJSONArray("result");
        HashMap map = new HashMap();
        if (jSONArrayOptJSONArray != null) {
            for (int i = 0; i < jSONArrayOptJSONArray.length(); i++) {
                JSONObject jSONObjectOptJSONObject = jSONArrayOptJSONArray.optJSONObject(i);
                if (jSONObjectOptJSONObject != null) {
                    String strOptString = jSONObjectOptJSONObject.optString("id", "");
                    String strOptString2 = jSONObjectOptJSONObject.optString("req_id", "");
                    if (!TextUtils.isEmpty(c(strOptString, strOptString2))) {
                        map.put(c(strOptString, strOptString2), jSONObjectOptJSONObject);
                    }
                }
            }
        }
        n nVar = new n();
        nVar.tt = map;
        nVar.c = iOptInt;
        return nVar;
    }

    public static String c(String str, String str2) {
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            return null;
        }
        return str2 + LoginConstants.UNDER_LINE + str;
    }
}

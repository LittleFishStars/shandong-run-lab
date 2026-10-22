package com.byazt.ry;

import android.content.Context;
import com.byakv.z.TTEncryptUtils;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_11_8719cls.dex */
@com.byazt.zqa.c(c = {0, 1, 1005, 13})
public class tt extends com.byazt.se.c {
    public tt(Context context, JSONObject jSONObject) {
        super(context, jSONObject);
    }

    public String c(String[] strArr) {
        try {
            int[] dI0Result = TTEncryptUtils.getDI0Result(strArr);
            if (dI0Result == null || dI0Result.length <= 0) {
                return "";
            }
            JSONObject jSONObject = new JSONObject();
            for (int i = 0; i < dI0Result.length; i++) {
                jSONObject.put(strArr[i], dI0Result[i]);
            }
            return jSONObject.toString();
        } catch (Exception unused) {
            return "";
        }
    }

    @Override // com.byazt.se.c
    public String tt() {
        JSONArray jSONArrayOptJSONArray = this.uj.optJSONArray("path");
        if (jSONArrayOptJSONArray == null || jSONArrayOptJSONArray.length() <= 0) {
            return "";
        }
        int length = jSONArrayOptJSONArray.length();
        String[] strArr = new String[length];
        for (int i = 0; i < jSONArrayOptJSONArray.length(); i++) {
            try {
                strArr[i] = jSONArrayOptJSONArray.getString(i);
            } catch (JSONException e) {
                com.byazt.tf.c.tt("__kite" + ve() + "jsonArray parse error " + e.getMessage());
            }
        }
        if (com.byazt.tf.c.tt()) {
            com.byazt.tf.c.c("__kite" + ve() + " plist size: " + length);
        }
        try {
            return c(strArr);
        } catch (Exception e2) {
            if (e2.getCause() != null) {
                this.ve = e2.getCause().getMessage();
            } else {
                this.ve = e2.getMessage();
            }
            return "";
        }
    }

    @Override // com.byazt.se.c
    public String ve() {
        return "d_i0";
    }
}

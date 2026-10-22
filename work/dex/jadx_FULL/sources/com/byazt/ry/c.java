package com.byazt.ry;

import android.content.Context;
import android.text.TextUtils;
import com.byakv.z.TTEncryptUtils;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_11_8719cls.dex */
@com.byazt.zqa.c(c = {0, 1, 1005, 20})
public class c extends com.byazt.se.c {
    public c(Context context, JSONObject jSONObject) {
        super(context, jSONObject);
    }

    public String c(String str) {
        try {
            String dA0Result = TTEncryptUtils.getDA0Result(str);
            if (com.byazt.tf.c.tt()) {
                com.byazt.tf.c.c("__kite", "p：" + str + " r:" + dA0Result);
            }
            return !TextUtils.isEmpty(dA0Result) ? dA0Result : "";
        } catch (Exception unused) {
            return "";
        }
    }

    @Override // com.byazt.se.c
    public String tt() {
        JSONArray jSONArrayOptJSONArray = this.uj.optJSONArray("path");
        if (jSONArrayOptJSONArray == null) {
            return "";
        }
        JSONObject jSONObject = new JSONObject();
        for (int i = 0; i < jSONArrayOptJSONArray.length(); i++) {
            try {
                String string = jSONArrayOptJSONArray.getString(i);
                jSONObject.put(string, c(string));
            } catch (Exception e) {
                if (e.getCause() != null) {
                    this.ve = e.getCause().getMessage();
                } else {
                    this.ve = e.getMessage();
                }
            }
        }
        return jSONObject.toString();
    }

    @Override // com.byazt.se.c
    public String ve() {
        return "d_a0";
    }
}

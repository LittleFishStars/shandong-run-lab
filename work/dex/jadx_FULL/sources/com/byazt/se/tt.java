package com.byazt.se;

import android.content.Context;
import android.text.TextUtils;
import com.byakv.z.TTEncryptUtils;
import com.byazt.yv.u;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.locks.ReentrantLock;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_11_8719cls.dex */
@com.byazt.zqa.c(c = {0, 1, 671, 13})
public class tt {
    public final com.byazt.az.c c;
    public long tt = 5000;
    public long ve = 1800000;
    public final Map<String, JSONObject> uj = new HashMap();
    public final Map<String, JSONObject> n = new HashMap();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public String f29005a = "";
    public final ReentrantLock sp = new ReentrantLock();

    public tt(Context context, com.byazt.az.c cVar) {
        this.c = cVar;
        tt(u.tt(context).getString("d_data", ""));
    }

    private void c(String str) {
        this.c.tt("d_data", str);
        this.c.c("d_data", str);
    }

    private void tt(String str) {
        if (!this.uj.isEmpty() && !this.n.isEmpty()) {
            com.byazt.tf.c.ve("__kite", " map is empty");
            return;
        }
        byte[] bArrClientUnpackedBase64 = TTEncryptUtils.clientUnpackedBase64(str);
        if (bArrClientUnpackedBase64 == null || bArrClientUnpackedBase64.length == 0) {
            com.byazt.tf.c.ve("__kite", "parse is null");
            return;
        }
        try {
            JSONObject jSONObject = new JSONObject(new String(bArrClientUnpackedBase64));
            if (com.byazt.tf.c.tt()) {
                com.byazt.tf.c.c("__kite", " data:".concat(String.valueOf(jSONObject)));
            }
            this.f29005a = jSONObject.optString("version", "");
            c(jSONObject, "fields", this.uj);
            int iOptInt = jSONObject.optInt("delay_sec", 0);
            if (iOptInt > 0) {
                this.tt = ((long) iOptInt) * 1000;
            }
            int iOptInt2 = jSONObject.optInt("dtrait_mem_ttl_sec", 0);
            if (iOptInt2 > 0) {
                this.ve = ((long) iOptInt2) * 1000;
            }
            c(jSONObject, "dtrait_fields", this.n);
            if (com.byazt.tf.c.tt()) {
                com.byazt.tf.c.c("__kite" + String.format("parseConfigFields# fields: status_collect delay time:%s, dtraitExpireTime:%s", Long.valueOf(this.tt), Long.valueOf(this.ve)));
            }
        } catch (Exception e) {
            com.byazt.tf.c.tt("__kiteparseConfigFields# error: " + e.getMessage());
        }
    }

    private boolean ve(JSONObject jSONObject) {
        if (jSONObject.optString("message", "").equals("ok")) {
            return true;
        }
        com.byazt.tf.c.c("__kite", "error response");
        return false;
    }

    private void c(JSONObject jSONObject, String str, Map<String, JSONObject> map) throws JSONException {
        JSONArray jSONArrayOptJSONArray = jSONObject.optJSONArray(str);
        if (jSONArrayOptJSONArray == null) {
            return;
        }
        for (int i = 0; i < jSONArrayOptJSONArray.length(); i++) {
            JSONObject jSONObject2 = (JSONObject) jSONArrayOptJSONArray.get(i);
            map.put(jSONObject2.optString("name"), jSONObject2);
        }
    }

    public long ve() {
        return this.tt;
    }

    public void c(JSONObject jSONObject) {
        this.sp.lock();
        try {
            try {
                if (!ve(jSONObject)) {
                    com.byazt.tf.c.ve("__kite", "invalid response");
                } else {
                    String strOptString = jSONObject.optString("data");
                    if (TextUtils.isEmpty(strOptString)) {
                        com.byazt.tf.c.ve("__kite", "response is empty");
                    } else {
                        c(strOptString);
                        tt(strOptString);
                        if (com.byazt.tf.c.tt()) {
                            com.byazt.tf.c.c("__kiteconfig parse success");
                        }
                    }
                }
            } catch (Exception e) {
                com.byazt.tf.c.tt("__kiteerror" + e.getMessage());
            }
        } finally {
            this.sp.unlock();
        }
    }

    public void tt(JSONObject jSONObject) {
        try {
            if (ve(jSONObject)) {
                String strOptString = jSONObject.optString("data");
                if (TextUtils.isEmpty(strOptString)) {
                    com.byazt.tf.c.c("__kite", "data is null");
                    return;
                }
                c(strOptString);
                tt(strOptString);
                com.byazt.tf.c.c("__kitesuccess");
            }
        } catch (Exception e) {
            com.byazt.tf.c.tt("__kiteerror " + e.getMessage());
        }
    }

    public Map<String, JSONObject> c() {
        return this.uj;
    }

    public String tt() {
        return this.f29005a;
    }
}

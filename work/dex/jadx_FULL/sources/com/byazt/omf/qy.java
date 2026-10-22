package com.byazt.omf;

import android.os.SystemClock;
import android.text.TextUtils;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_11_8719cls.dex */
@com.byazt.zqa.c(c = {0, 1, 31, 110})
public class qy {
    public String c;
    public long tt;
    public Map<String, Long> uj = new HashMap();
    public long ve;

    private qy(String str, long j) {
        this.c = str;
        this.tt = j;
        this.ve = j;
    }

    public static qy c(String str) {
        return new qy(str, SystemClock.elapsedRealtime());
    }

    public long tt(String str) {
        long jElapsedRealtime = SystemClock.elapsedRealtime();
        long j = jElapsedRealtime - this.ve;
        this.ve = jElapsedRealtime;
        this.uj.put(str, Long.valueOf(j));
        return j;
    }

    public long c() {
        long jElapsedRealtime = SystemClock.elapsedRealtime() - this.tt;
        this.uj.put(this.c, Long.valueOf(jElapsedRealtime));
        return jElapsedRealtime;
    }

    public void c(String str, long j) {
        this.uj.put(str, Long.valueOf(j));
    }

    public void c(JSONObject jSONObject, long j) {
        if (jSONObject == null) {
            return;
        }
        for (Map.Entry<String, Long> entry : this.uj.entrySet()) {
            String key = entry.getKey();
            Long value = entry.getValue();
            if (!TextUtils.isEmpty(key) && (value.longValue() > j || key.equals("armor_load_cost"))) {
                try {
                    jSONObject.put(key, value);
                } catch (JSONException unused) {
                }
            }
        }
    }

    public long tt() {
        return SystemClock.elapsedRealtime() - this.tt;
    }

    public JSONObject c(long j) {
        JSONObject jSONObject = new JSONObject();
        c(jSONObject, j);
        return jSONObject;
    }
}

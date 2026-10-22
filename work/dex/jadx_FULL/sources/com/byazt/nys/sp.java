package com.byazt.nys;

import android.os.SystemClock;
import android.text.TextUtils;
import com.huachenjie.base.interact.bean.WorksInteractEventBean;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_11_8719cls.dex */
@com.byazt.zqa.c(c = {0, 1, WorksInteractEventBean.EVENT_TYPE_COMMENT_ALUMNI_SAY_LIKE, 91})
public class sp {
    public String c;
    public long tt;
    public Map<String, Long> uj = new HashMap();
    public long ve;

    private sp(String str, long j) {
        this.c = str;
        this.tt = j;
        this.ve = j;
    }

    public static sp c(String str) {
        return new sp(str, SystemClock.elapsedRealtime());
    }

    public long tt(String str) {
        long jElapsedRealtime = SystemClock.elapsedRealtime() - this.ve;
        this.ve = SystemClock.elapsedRealtime();
        this.uj.put(str, Long.valueOf(jElapsedRealtime));
        return jElapsedRealtime;
    }

    public long c() {
        long jElapsedRealtime = SystemClock.elapsedRealtime() - this.tt;
        this.uj.put(this.c, Long.valueOf(jElapsedRealtime));
        return jElapsedRealtime;
    }

    public void c(JSONObject jSONObject) {
        c(jSONObject, 0L);
    }

    public void c(JSONObject jSONObject, long j) {
        if (jSONObject == null) {
            return;
        }
        for (Map.Entry<String, Long> entry : this.uj.entrySet()) {
            String key = entry.getKey();
            Long value = entry.getValue();
            if (!TextUtils.isEmpty(key) && value.longValue() > j) {
                try {
                    jSONObject.put(key, value);
                } catch (JSONException unused) {
                }
            }
        }
    }
}

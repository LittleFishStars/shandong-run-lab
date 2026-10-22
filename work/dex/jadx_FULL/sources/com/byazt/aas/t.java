package com.byazt.aas;

import android.content.Intent;
import org.json.JSONObject;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_10_7392cls.dex */
@com.byazt.zqa.c(c = {0, 1, 131, 66})
public class t {
    public static volatile t c;
    public com.byazt.iy.n tt;

    /* JADX INFO: Access modifiers changed from: private */
    public com.byazt.iy.n tt() {
        if (this.tt == null) {
            this.tt = eo.c("hide_recent_activity_recorder");
        }
        return this.tt;
    }

    public static t c() {
        if (c == null) {
            synchronized (t.class) {
                if (c == null) {
                    c = new t();
                }
            }
        }
        return c;
    }

    public void c(Intent intent) {
        if (intent == null) {
            return;
        }
        final boolean z = (intent.getFlags() & 8388608) == 8388608;
        com.byazt.nr.da.c().post(new Runnable() { // from class: com.byazt.aas.t.1
            @Override // java.lang.Runnable
            public void run() {
                int i = 0;
                int i2 = t.this.tt().get("all_activity_count", 0) + 1;
                if (z) {
                    int i3 = t.this.tt().get("hide_activity_count", 0) + 1;
                    if (i3 >= 10) {
                        t.this.c(i2);
                        i2 = 0;
                    } else {
                        i = i3;
                    }
                    t.this.tt().put("hide_activity_count", i);
                }
                t.this.tt().put("all_activity_count", i2);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(final int i) {
        try {
            com.byazt.ukr.yp.c().tt(new com.byazt.ee.c() { // from class: com.byazt.aas.t.2
                @Override // com.byazt.ee.c
                public com.byazt.qal.c c() throws Exception {
                    JSONObject jSONObject = new JSONObject();
                    jSONObject.put("ac", i);
                    return com.byazt.qal.tt.tt().c("hide_activity_record").tt(jSONObject.toString());
                }
            }, "hide_activity_record");
        } catch (Throwable unused) {
        }
    }
}

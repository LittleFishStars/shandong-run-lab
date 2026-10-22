package com.byazt.yp;

import android.annotation.SuppressLint;
import android.content.Context;
import android.text.TextUtils;
import com.byazt.jj.uj;
import java.util.Map;
import java.util.concurrent.TimeUnit;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_11_8719cls.dex */
@com.byazt.zqa.c(c = {0, 1, 215, 13})
public class tt {

    @SuppressLint({"StaticFieldLeak"})
    public static volatile tt c;
    public Context tt;
    public final com.byazt.hm.c ve;

    private tt(Context context) {
        Map<String, Object> map;
        this.tt = context == null ? com.byazt.bp.tt.getContext() : context.getApplicationContext();
        com.byazt.hm.c.C0422c c0422c = new com.byazt.hm.c.C0422c();
        TimeUnit timeUnit = TimeUnit.MILLISECONDS;
        com.byazt.hm.c.C0422c c0422cC = c0422c.c(10000L, timeUnit).tt(10000L, timeUnit).ve(10000L, timeUnit).c(true);
        if (uj.c() && (map = uj.c) != null) {
            Object obj = map.get("case_id");
            if ((obj instanceof String) && !TextUtils.isEmpty((String) obj)) {
                c0422cC.c(new uj.c());
            }
        }
        com.byazt.hm.c cVarC = c0422cC.c();
        this.ve = cVarC;
        com.byazt.gqp.uj ujVarC = cVarC.a().c();
        if (ujVarC != null) {
            ujVarC.c(16);
        }
    }

    public static tt c() {
        if (c == null) {
            synchronized (tt.class) {
                if (c == null) {
                    c = new tt(com.byazt.bp.tt.getContext());
                }
            }
        }
        return c;
    }

    public com.byazt.hm.c tt() {
        return this.ve;
    }
}

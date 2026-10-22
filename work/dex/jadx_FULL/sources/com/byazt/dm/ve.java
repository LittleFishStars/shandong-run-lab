package com.byazt.dm;

import android.text.TextUtils;
import android.util.Log;
import com.byazt.gq.t;
import com.byazt.hu.u;
import com.byazt.i.a;
import org.json.JSONObject;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_11_8719cls.dex */
@com.byazt.zqa.c(c = {0, 1, 204, 54})
public class ve implements com.byazt.pd.c {

    @com.byazt.zqa.c(c = {0, 1, 204, 24})
    public static class c {
        public static ve c = new ve();
    }

    public static ve c() {
        return c.c;
    }

    public void tt(String str) {
        tt(true, str);
    }

    @Override // com.byazt.pd.c
    public void c(Throwable th, String str) {
        c(true, th, str);
    }

    public void tt(boolean z, String str) {
        if (tt()) {
            return;
        }
        if (z) {
            tt(new RuntimeException(str));
        }
        JSONObject jSONObject = new JSONObject();
        u.c(jSONObject, "msg", str);
        u.c(jSONObject, "stack", c(new Throwable()));
        t.x();
    }

    public void c(boolean z, Throwable th, String str) {
        if (tt()) {
            return;
        }
        if (th == null) {
            th = new Throwable();
        }
        if (z) {
            tt(th);
        }
        JSONObject jSONObject = new JSONObject();
        if (TextUtils.isEmpty(str)) {
            str = th.getMessage();
        }
        u.c(jSONObject, "msg", str);
        u.c(jSONObject, "stack", Log.getStackTraceString(th));
        t.x();
    }

    private void tt(Throwable th) {
        if (a.tt(t.getContext())) {
            throw new com.byazt.dm.c(th);
        }
    }

    private boolean tt() {
        return t.i().optInt("enable_monitor", 1) != 1;
    }

    public void c(String str) {
        c(true, str);
    }

    public void c(boolean z, String str) {
        if (tt()) {
            return;
        }
        if (z) {
            tt(new RuntimeException(str));
        }
        JSONObject jSONObject = new JSONObject();
        u.c(jSONObject, "msg", str);
        u.c(jSONObject, "stack", c(new Throwable()));
        t.x();
    }

    public static String c(Throwable th) {
        try {
            return Log.getStackTraceString(th);
        } catch (Exception unused) {
            return null;
        }
    }
}

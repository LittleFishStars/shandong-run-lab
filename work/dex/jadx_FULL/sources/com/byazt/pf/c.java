package com.byazt.pf;

import android.os.Build;
import com.alibaba.ariver.engine.api.bridge.model.RenderCallContext;
import com.byazt.by.uj;
import com.byazt.omf.gt;
import com.byazt.omf.x;
import com.byazt.zpd.tt;
import com.byazt.zpd.ve;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_11_8719cls.dex */
@com.byazt.zqa.c(c = {0, 1, 577, 20})
public class c {
    public static c c = new c();
    public volatile int tt = -1;
    public volatile long ve = 0;
    public volatile long uj = 0;

    private c() {
    }

    public static c c() {
        return c;
    }

    public int a() {
        if (!x.m().uj()) {
            return 0;
        }
        if (this.tt == -1) {
            int iM = uj.c().m();
            if (iM != -1) {
                this.tt = iM;
            } else if (gt.tt().kz() == null) {
                this.tt = 1;
            } else {
                this.tt = 2;
            }
        }
        return this.tt;
    }

    public boolean n() {
        return this.tt == 0 || this.tt == 3;
    }

    public long tt() {
        return this.ve;
    }

    public void uj() {
        JSONObject jSONObjectKz = gt.tt().kz();
        if (jSONObjectKz == null) {
            this.tt = 1;
        }
        if (c(jSONObjectKz)) {
            new ve().c(jSONObjectKz, this.tt);
        } else if (tt(jSONObjectKz)) {
            new tt().c(jSONObjectKz, this.tt);
        } else {
            this.tt = 1;
        }
    }

    public long ve() {
        return this.uj;
    }

    public void c(long j, long j2) {
        this.ve = j;
        this.uj = j2;
    }

    public boolean tt(JSONObject jSONObject) {
        JSONArray jSONArrayOptJSONArray;
        if (jSONObject != null && (jSONArrayOptJSONArray = jSONObject.optJSONArray(RenderCallContext.TYPE_CALLBACK)) != null && jSONArrayOptJSONArray.length() != 0) {
            for (int i = 0; i < jSONArrayOptJSONArray.length(); i++) {
                if (c(jSONArrayOptJSONArray.optString(i))) {
                    return true;
                }
            }
        }
        return false;
    }

    public boolean c(String str) {
        String str2 = Build.MANUFACTURER;
        String str3 = Build.BRAND;
        if (str2 != null && str3 != null) {
            return str2.equalsIgnoreCase(str) || str3.equalsIgnoreCase(str);
        }
        if (str2 != null) {
            return str2.equalsIgnoreCase(str);
        }
        if (str3 != null) {
            return str3.equalsIgnoreCase(str);
        }
        return false;
    }

    public void c(int i) {
        if (this.tt != i) {
            uj.c().a(i);
        }
        this.tt = i;
    }

    public boolean c(JSONObject jSONObject) {
        JSONArray jSONArrayOptJSONArray;
        if (jSONObject != null && (jSONArrayOptJSONArray = jSONObject.optJSONArray("register")) != null && jSONArrayOptJSONArray.length() != 0) {
            for (int i = 0; i < jSONArrayOptJSONArray.length(); i++) {
                if (c(jSONArrayOptJSONArray.optString(i))) {
                    return true;
                }
            }
        }
        return false;
    }
}

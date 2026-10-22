package com.byazt.dl;

import android.text.TextUtils;
import com.ali.auth.third.login.LoginConstants;
import com.aliyun.credentials.utils.AuthConstant;
import com.byazt.nr.m;
import com.byazt.omf.gt;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArraySet;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_11_8719cls.dex */
@com.byazt.zqa.c(c = {0, 1, 465, 34})
public class a {
    public static volatile a c;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public boolean f28414a;
    public boolean tt;
    public int uj;
    public final Set<String> ve = new CopyOnWriteArraySet();
    public final Map<String, Long> n = new ConcurrentHashMap();

    private a() {
    }

    public static a c() {
        if (c == null) {
            synchronized (a.class) {
                if (c == null) {
                    c = new a();
                }
            }
        }
        return c;
    }

    private void ve() {
        if (this.f28414a) {
            return;
        }
        this.f28414a = true;
        gt.tt().m();
    }

    public boolean tt() {
        ve();
        return this.tt;
    }

    public void c(String str, int i, int i2, String str2) {
        String str3;
        if (!tt() || TextUtils.isEmpty(str) || i == 0) {
            return;
        }
        String strValueOf = String.valueOf(i);
        if (i2 != 0) {
            str3 = (strValueOf + LoginConstants.UNDER_LINE) + String.valueOf(i2);
        } else {
            str3 = strValueOf;
        }
        com.byazt.it.ve veVarC = com.byazt.vif.uj.c(str2, "req_exemption_error_code");
        if (this.ve.contains(strValueOf) || this.ve.contains(str3)) {
            long jCurrentTimeMillis = System.currentTimeMillis();
            veVarC.put(str, jCurrentTimeMillis);
            this.n.put(str, Long.valueOf(jCurrentTimeMillis));
        }
    }

    public void c(String str) {
        JSONObject jSONObject;
        if (TextUtils.isEmpty(str)) {
            jSONObject = null;
        } else {
            try {
                jSONObject = new JSONObject(str);
            } catch (JSONException e) {
                m.c(e);
                jSONObject = null;
            }
        }
        c(jSONObject);
    }

    public void c(JSONObject jSONObject) {
        this.ve.clear();
        if (jSONObject != null) {
            this.tt = jSONObject.optBoolean(AuthConstant.INI_ENABLE, false);
            int iOptInt = jSONObject.optInt("duration", 0) * 1000;
            this.uj = iOptInt;
            if (iOptInt <= 0) {
                this.tt = false;
                return;
            }
            JSONArray jSONArrayOptJSONArray = jSONObject.optJSONArray("error_codes");
            if (jSONArrayOptJSONArray != null && jSONArrayOptJSONArray.length() > 0) {
                for (int i = 0; i < jSONArrayOptJSONArray.length(); i++) {
                    String strOptString = jSONArrayOptJSONArray.optString(i);
                    if (!TextUtils.isEmpty(strOptString)) {
                        this.ve.add(strOptString);
                    }
                }
            }
            if (this.ve.isEmpty()) {
                this.tt = false;
                return;
            }
            return;
        }
        this.tt = false;
    }

    public boolean c(String str, String str2) {
        if (!tt() || TextUtils.isEmpty(str)) {
            return false;
        }
        Long lValueOf = this.n.get(str);
        if (lValueOf == null) {
            lValueOf = Long.valueOf(com.byazt.vif.uj.c(str2, "req_exemption_error_code").getLong(str, -1L));
            if (lValueOf.longValue() != -1) {
                this.n.put(str, lValueOf);
            } else {
                lValueOf = null;
            }
        }
        if (lValueOf == null) {
            return true;
        }
        if (System.currentTimeMillis() - lValueOf.longValue() <= this.uj) {
            return false;
        }
        this.n.remove(str);
        com.byazt.vif.uj.c(str2, "req_exemption_error_code").remove(str);
        return true;
    }
}

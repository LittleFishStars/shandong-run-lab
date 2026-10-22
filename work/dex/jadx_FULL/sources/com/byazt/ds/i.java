package com.byazt.ds;

import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.alibaba.ariver.kernel.common.log.ConnectionLog;
import com.alibaba.baichuan.trade.common.constants.AlibcCommonConstant;
import com.zj.adlib.xh9;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_11_8719cls.dex */
@com.byazt.zqa.c(c = {0, 1, 1480, 42})
public class i {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final String[] f28426a = {xh9.WEBSITE_PARAMS_CHANNEL, "package", AlibcCommonConstant.APP_VERSION};
    public boolean c;
    public final SharedPreferences sp;
    public final Context tt;
    public final x ve;
    public final ArrayList<ve> n = new ArrayList<>(32);
    public int x = 0;

    @NonNull
    public JSONObject uj = new JSONObject();

    public i(Context context, x xVar) {
        this.tt = context;
        this.ve = xVar;
        this.sp = xVar.n();
        if (com.byazt.gj.c.tt) {
            com.byazt.vm.sp.c(context);
        }
    }

    @NonNull
    private JSONObject z() {
        return this.uj;
    }

    public boolean a() {
        synchronized (this.n) {
            if (this.n.size() == 0) {
                this.n.add(new uj(this.tt, this.ve));
                this.n.add(new a(this.tt));
                this.n.add(new sp(this.tt, this.ve));
                this.n.add(new da(this.tt));
                this.n.add(new sl(this.tt));
                this.n.add(new t(this.tt, this.ve));
                this.n.add(new u(this.tt));
                this.n.add(new z(this.tt, this.ve));
                this.n.add(new m(this.tt, this.ve));
                this.n.add(new nu());
                this.n.add(new rh(this.ve));
                this.n.add(new my(this.tt));
                this.n.add(new gt(this.tt));
                this.n.add(new rl(this.tt, this.ve));
                this.n.add(new c(this.tt, this.ve));
                this.n.add(new yp(this.tt, this.ve));
                this.n.add(new n(this.tt, this.ve));
            }
        }
        JSONObject jSONObjectZ = z();
        JSONObject jSONObject = new JSONObject();
        com.byazt.yv.u.ve(jSONObject, jSONObjectZ);
        int i = 0;
        int i2 = 0;
        boolean z = true;
        for (ve veVar : this.n) {
            if (!veVar.c || veVar.ve || c(veVar)) {
                try {
                    veVar.c = veVar.c(jSONObject);
                } catch (SecurityException e) {
                    if (!veVar.tt) {
                        i++;
                        com.byazt.yv.da.tt("loadHeader, " + this.x, e);
                        if (!veVar.c && this.x > 10) {
                            veVar.c = true;
                        }
                    }
                } catch (JSONException e2) {
                    com.byazt.yv.da.tt(e2);
                }
                if (!veVar.c && !veVar.tt) {
                    i2++;
                }
            }
            z &= veVar.c || veVar.tt;
        }
        if (z) {
            for (String str : f28426a) {
                z &= !TextUtils.isEmpty(jSONObject.optString(str));
            }
            String strOptString = jSONObject.optString("user_unique_id", null);
            if (!TextUtils.isEmpty(strOptString)) {
                try {
                    jSONObject.put("user_unique_id", strOptString);
                } catch (JSONException unused) {
                }
            }
        }
        this.uj = jSONObject;
        this.c = z;
        if (com.byazt.yv.da.tt) {
            com.byazt.yv.da.c("loadHeader, " + this.c + ", " + this.x + ", " + this.uj.toString(), null);
        } else {
            com.byazt.yv.da.uj("loadHeader, " + this.c + ", " + this.x, null);
        }
        if (i > 0 && i == i2) {
            this.x++;
            if (t() != 0) {
                this.x += 10;
            }
        }
        if (this.c) {
            com.byazt.gj.c.t().c(sp(), i(), da());
        }
        return this.c;
    }

    @Nullable
    public JSONObject c() {
        if (this.c) {
            return z();
        }
        return null;
    }

    public String da() {
        return z().optString("ssid", "");
    }

    public String i() {
        return z().optString("install_id", "");
    }

    public void n() {
        try {
            new yp(this.tt, this.ve).c(this.uj);
        } catch (Exception e) {
            com.byazt.nr.m.ve("od", "e:" + e.getMessage(), e);
        }
    }

    public String sl() {
        return z().optString("user_unique_id", "");
    }

    public String sp() {
        return z().optString("device_id", "");
    }

    public int t() {
        String strOptString = z().optString("device_id", "");
        z().optString("install_id", "");
        if (tt(strOptString)) {
            return this.sp.getInt("version_code", 0) == z().optInt("version_code", -1) ? 1 : 2;
        }
        return 0;
    }

    public int tt() {
        int iOptInt = this.c ? z().optInt("version_code", -1) : -1;
        for (int i = 0; i < 3 && iOptInt == -1; i++) {
            a();
            iOptInt = this.c ? z().optInt("version_code", -1) : -1;
        }
        return iOptInt;
    }

    public long u() {
        return z().optLong("register_time", 0L);
    }

    public void uj() {
        com.byazt.lu.uj.n().x();
    }

    public String ve() {
        String strOptString = this.c ? z().optString(AlibcCommonConstant.APP_VERSION, null) : null;
        for (int i = 0; i < 3 && strOptString == null; i++) {
            a();
            strOptString = this.c ? z().optString(AlibcCommonConstant.APP_VERSION, null) : null;
        }
        return strOptString;
    }

    public String x() {
        return z().optString("aid", "");
    }

    public String yp() {
        return z().optString("ab_sdk_version", "");
    }

    @Nullable
    public <T> T c(String str, T t) {
        Object objOpt;
        JSONObject jSONObjectZ = z();
        if (jSONObjectZ == null || (objOpt = jSONObjectZ.opt(str)) == null) {
            objOpt = null;
        }
        return objOpt == null ? t : (T) objOpt;
    }

    private boolean c(ve veVar) {
        boolean z = !this.ve.nu() && veVar.uj;
        if (com.byazt.yv.da.tt) {
            com.byazt.yv.da.c("needSyncFromSub " + veVar + " " + z, null);
        }
        return z;
    }

    private synchronized void tt(JSONObject jSONObject) {
        if (jSONObject == null) {
            com.byazt.yv.da.tt("null abconfig", null);
            return;
        }
        String strOptString = z().optString("ab_version");
        if (!TextUtils.isEmpty(strOptString)) {
            String[] strArrSplit = strOptString.split(",");
            Set<String> hashSet = new HashSet<>();
            for (String str : strArrSplit) {
                if (!TextUtils.isEmpty(str)) {
                    hashSet.add(str);
                }
            }
            Iterator<String> itKeys = jSONObject.keys();
            HashSet hashSet2 = new HashSet();
            while (itKeys.hasNext()) {
                String next = itKeys.next();
                if (next instanceof String) {
                    String str2 = next;
                    if (!TextUtils.isEmpty(str2)) {
                        try {
                            hashSet2.add(jSONObject.getJSONObject(str2).optString("vid"));
                        } catch (JSONException e) {
                            com.byazt.yv.da.tt(e);
                        }
                    }
                }
            }
            hashSet.retainAll(hashSet2);
            tt("ab_version", c(hashSet));
        }
    }

    public void c(JSONObject jSONObject) {
        this.ve.ve(jSONObject);
        tt(jSONObject);
    }

    private String c(Set<String> set) {
        StringBuilder sb = new StringBuilder();
        Iterator<String> it = set.iterator();
        while (it.hasNext()) {
            sb.append(it.next());
            if (it.hasNext()) {
                sb.append(",");
            }
        }
        return sb.toString();
    }

    public void c(HashMap<String, Object> map) {
        JSONObject jSONObjectOptJSONObject = null;
        if (map != null && !map.isEmpty()) {
            try {
                jSONObjectOptJSONObject = z().optJSONObject("custom");
                if (jSONObjectOptJSONObject == null) {
                    jSONObjectOptJSONObject = new JSONObject();
                }
                for (Map.Entry<String, Object> entry : map.entrySet()) {
                    if (!TextUtils.isEmpty(entry.getKey())) {
                        jSONObjectOptJSONObject.put(entry.getKey(), entry.getValue());
                    }
                }
            } catch (JSONException e) {
                com.byazt.yv.da.tt(e);
            }
        }
        if (tt("custom", jSONObjectOptJSONObject)) {
            this.ve.tt(jSONObjectOptJSONObject);
        }
    }

    public static void c(JSONObject jSONObject, String str, String str2) throws JSONException {
        if (TextUtils.isEmpty(str2)) {
            return;
        }
        jSONObject.put(str, str2);
    }

    public static boolean c(String str) {
        int length = str != null ? str.length() : 0;
        if (length < 13 || length > 128) {
            return false;
        }
        for (int i = 0; i < length; i++) {
            char cCharAt = str.charAt(i);
            if ((cCharAt < '0' || cCharAt > '9') && ((cCharAt < 'a' || cCharAt > 'f') && ((cCharAt < 'A' || cCharAt > 'F') && cCharAt != '-'))) {
                return false;
            }
        }
        return true;
    }

    private boolean tt(String str, Object obj) {
        boolean z;
        Object objOpt = z().opt(str);
        if ((obj == null || obj.equals(objOpt)) && (obj != null || objOpt == null)) {
            z = false;
        } else {
            synchronized (this) {
                try {
                    JSONObject jSONObject = this.uj;
                    JSONObject jSONObject2 = new JSONObject();
                    com.byazt.yv.u.ve(jSONObject2, jSONObject);
                    jSONObject2.put(str, obj);
                    this.uj = jSONObject2;
                } catch (JSONException e) {
                    com.byazt.yv.da.tt(e);
                }
            }
            z = true;
        }
        com.byazt.yv.da.c("updateHeader, " + str + ", " + objOpt + ", " + obj, null);
        return z;
    }

    public boolean c(JSONObject jSONObject, String str, String str2, String str3) {
        boolean z;
        boolean z2;
        if (com.byazt.yv.da.tt) {
            com.byazt.yv.da.c("saveRegisterInfo, " + str + ", " + str2 + ", " + str3 + ", " + jSONObject, null);
        }
        boolean zTt = tt(str);
        boolean zTt2 = tt(str2);
        try {
            boolean zTt3 = tt(str3);
            int i = this.sp.getInt("version_code", 0);
            int iOptInt = z().optInt("version_code", 0);
            SharedPreferences.Editor editorEdit = this.sp.edit();
            if (i != iOptInt) {
                editorEdit.putInt("version_code", iOptInt);
            }
            if (zTt) {
                long jCurrentTimeMillis = System.currentTimeMillis();
                editorEdit.putLong("register_time", jCurrentTimeMillis);
                tt("register_time", Long.valueOf(jCurrentTimeMillis));
            } else if (!zTt) {
                JSONObject jSONObject2 = new JSONObject();
                jSONObject2.put(ConnectionLog.CONN_LOG_STATE_RESPONSE, jSONObject);
                com.byazt.gj.c.c("tt_fetch_did_error", jSONObject2);
            }
            String strOptString = z().optString("device_id", "");
            if (zTt && tt("device_id", str)) {
                editorEdit.putString("device_id", str);
                z = true;
            } else {
                z = false;
            }
            String strOptString2 = z().optString("install_id", "");
            if (zTt2 && tt("install_id", str2)) {
                editorEdit.putString("install_id", str2);
                z = true;
            }
            String strOptString3 = z().optString("ssid", "");
            if (zTt3 && tt("ssid", str3)) {
                editorEdit.putString("ssid", str3);
                z2 = true;
            } else {
                z2 = z;
            }
            com.byazt.gj.c.t().c(z2, strOptString, str, strOptString2, str2, strOptString3, str3);
            editorEdit.apply();
        } catch (JSONException e) {
            com.byazt.yv.da.tt(e);
        }
        return zTt && zTt2;
    }

    /* JADX WARN: Code duplicated, block: B:17:0x002f A[RETURN] */
    public static boolean tt(String str) {
        boolean z;
        if (!TextUtils.isEmpty(str) && !"unknown".equalsIgnoreCase(str) && !"Null".equalsIgnoreCase(str)) {
            for (int i = 0; i < str.length(); i++) {
                if (str.charAt(i) != '0') {
                    z = false;
                    if (!z) {
                        return true;
                    }
                }
            }
            z = true;
            if (!z) {
                return true;
            }
        }
        return false;
    }
}

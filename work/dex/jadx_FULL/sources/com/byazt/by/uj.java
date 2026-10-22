package com.byazt.by;

import android.content.SharedPreferences;
import android.text.TextUtils;
import com.byazt.nr.m;
import com.byazt.nys.PluginConstants;
import com.byazt.omf.gt;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_11_8719cls.dex */
@com.byazt.zqa.c(c = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_FILEPLAY_NO_BUFFRING, 15})
public class uj {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public volatile String f28336a;
    public volatile String c;
    public volatile String da;
    public volatile String gt;
    public volatile String gu;
    public volatile String i;
    public volatile String my;
    public volatile String n;
    public volatile JSONArray qy;
    public volatile String rh;
    public volatile String rl;
    public volatile String sp;
    public volatile String tt;
    public volatile String uj;
    public volatile String ve;
    public volatile String x;
    public volatile String yp;
    public volatile String z;
    public volatile int t = -1;
    public volatile int u = -1;
    public volatile int m = -1;
    public volatile int nu = -1;
    public volatile int gr = -1;
    public volatile SharedPreferences sl = com.byazt.nys.tt.tt(gt.getContext(), my(), 0);

    @com.byazt.zqa.c(c = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_FILEPLAY_NO_BUFFRING, 123})
    public static class c {
        public static uj c = new uj();
    }

    public static uj c() {
        return c.c;
    }

    private void gt() {
        try {
            this.gt = com.byazt.omf.a.c().n();
            JSONObject jSONObject = new JSONObject();
            jSONObject.put(PluginConstants.KEY_PLUGIN_VERSION, 7611);
            jSONObject.put("log_version", this.gt);
            c("logsdk_version", jSONObject.toString());
        } catch (JSONException unused) {
        }
    }

    public String a(String str) {
        if (this.rh == null) {
            this.rh = tt("extra_data", str);
        }
        return this.rh;
    }

    public String da() {
        if (this.sp == null) {
            this.sp = tt("dev17", (String) null);
        }
        return this.sp;
    }

    public String i(String str) {
        if (this.c == null) {
            this.c = tt("dev01", str);
        }
        return this.c;
    }

    public int m() {
        return tt("sp_device_app_direction", -1);
    }

    public String my() {
        return "sp_exec_getad_config";
    }

    public void n(String str) {
        if (str == null || !str.equals(this.rh)) {
            this.rh = str;
            c("extra_data", str);
        }
    }

    public String nu() {
        if (this.gu == null) {
            this.gu = tt("dev16", "");
        }
        return this.gu;
    }

    public void rh() {
        try {
            SharedPreferences.Editor editorEdit = tt().edit();
            editorEdit.clear();
            editorEdit.apply();
        } catch (Throwable unused) {
        }
    }

    public String sl() {
        if (this.x == null) {
            this.x = tt("dev18", (String) null);
        }
        return this.x;
    }

    public void sp(String str) {
        if (str == null || !str.equals(this.my)) {
            this.my = str;
            c("extra_internal_data", str);
        }
    }

    public boolean sp(int i) {
        return i == 3 || i == 4;
    }

    public String t() {
        if (this.i == null) {
            this.i = tt("dev09", (String) null);
        }
        return this.i;
    }

    public SharedPreferences tt() {
        return this.sl;
    }

    public String u() {
        if (this.rl == null) {
            this.rl = tt("dev10", (String) null);
        }
        return this.rl;
    }

    public String uj(String str) {
        if (this.z == null) {
            this.z = tt("keywords", str);
        }
        return this.z;
    }

    public int ve() {
        if (this.t == -1) {
            this.t = tt("live_ad_clk_cnt", 0);
        }
        return this.t;
    }

    public String x(String str) {
        if (this.my == null) {
            this.my = tt("extra_internal_data", str);
        }
        return this.my;
    }

    public String yp() {
        if (this.da == null) {
            this.da = tt("dev11", (String) null);
        }
        return this.da;
    }

    public JSONArray z() {
        String strTt;
        if (this.qy == null && (strTt = tt("dev12", (String) null)) != null) {
            try {
                this.qy = new JSONArray(strTt);
            } catch (JSONException e) {
                m.c(e);
            }
        }
        return this.qy;
    }

    public void c(int i) {
        if (this.t == i) {
            return;
        }
        this.t = i;
        c("live_ad_clk_cnt", i);
    }

    public void tt(String str) {
        this.yp = str;
        c("dev03", str);
    }

    @com.byazt.zqa.c(c = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_FILEPLAY_NO_BUFFRING, 153})
    public static class tt {
        public Map<String, Object> c = new HashMap();

        public tt a(String str) {
            if (str == null || str.equals(uj.c().n)) {
                return this;
            }
            uj.c().n = str;
            this.c.put("dev07", str);
            return this;
        }

        public tt c(String str) {
            if (str == null || str.equals(uj.c().c)) {
                return this;
            }
            uj.c().c = str;
            this.c.put("dev01", str);
            return this;
        }

        public tt da(String str) {
            if (str == null || str.equals(uj.c().i)) {
                return this;
            }
            uj.c().i = str;
            this.c.put("dev09", str);
            return this;
        }

        public tt i(String str) {
            if (str == null || str.equals(uj.c().x)) {
                return this;
            }
            uj.c().x = str;
            this.c.put("dev18", str);
            return this;
        }

        public tt n(String str) {
            if (str == null || str.equals(uj.c().da)) {
                return this;
            }
            uj.c().da = str;
            this.c.put("dev11", str);
            return this;
        }

        public tt sp(String str) {
            if (str == null || str.equals(uj.c().f28336a)) {
                return this;
            }
            uj.c().f28336a = str;
            this.c.put("dev08", str);
            return this;
        }

        public tt tt(String str) {
            if (str == null || str.equals(uj.c().tt)) {
                return this;
            }
            uj.c().tt = str;
            this.c.put("dev02", com.byazt.nr.c.tt(str));
            return this;
        }

        public tt uj(String str) {
            if (str == null || str.equals(uj.c().uj)) {
                return this;
            }
            uj.c().uj = str;
            this.c.put("dev05", str);
            return this;
        }

        public tt ve(String str) {
            if (str == null || str.equals(uj.c().ve)) {
                return this;
            }
            uj.c().ve = str;
            this.c.put("dev04", str);
            return this;
        }

        public tt x(String str) {
            if (str == null || str.equals(uj.c().sp)) {
                return this;
            }
            uj.c().sp = str;
            this.c.put("dev17", str);
            return this;
        }

        public void c() {
            try {
                if (ve.c().tt()) {
                    String strMy = uj.c().my();
                    for (Map.Entry<String, Object> entry : this.c.entrySet()) {
                        String key = entry.getKey();
                        Object value = entry.getValue();
                        if (value instanceof Boolean) {
                            com.byazt.ti.tt.c(strMy, key, (Boolean) value);
                        } else if (value instanceof Long) {
                            com.byazt.ti.tt.c(strMy, key, (Long) value);
                        } else if (value instanceof Float) {
                            com.byazt.ti.tt.c(strMy, key, (Float) value);
                        } else if (value instanceof Integer) {
                            com.byazt.ti.tt.c(strMy, key, (Integer) value);
                        } else if (value instanceof String) {
                            com.byazt.ti.tt.c(strMy, key, (String) value);
                        }
                    }
                    return;
                }
                SharedPreferences.Editor editorEdit = uj.c().tt().edit();
                for (Map.Entry<String, Object> entry2 : this.c.entrySet()) {
                    String key2 = entry2.getKey();
                    Object value2 = entry2.getValue();
                    if (value2 instanceof Boolean) {
                        editorEdit.putBoolean(key2, ((Boolean) value2).booleanValue());
                    } else if (value2 instanceof Long) {
                        editorEdit.putLong(key2, ((Long) value2).longValue());
                    } else if (value2 instanceof Float) {
                        editorEdit.putFloat(key2, ((Float) value2).floatValue());
                    } else if (value2 instanceof Integer) {
                        editorEdit.putInt(key2, ((Integer) value2).intValue());
                    } else if (value2 instanceof String) {
                        editorEdit.putString(key2, (String) value2);
                    }
                }
                editorEdit.apply();
            } catch (Exception e) {
                m.c(e);
            }
        }
    }

    public String a() {
        if (this.ve == null) {
            this.ve = tt("dev04", (String) null);
        }
        return this.ve;
    }

    public void da(String str) {
        if (str == null || str.equals(this.rl)) {
            return;
        }
        this.rl = str;
        c("dev10", str);
    }

    public String i() {
        if (this.f28336a == null) {
            this.f28336a = tt("dev08", (String) null);
        }
        return this.f28336a;
    }

    public String n(int i) {
        if (TextUtils.isEmpty(this.gt)) {
            try {
                String strTt = tt("logsdk_version", "");
                if (!TextUtils.isEmpty(strTt)) {
                    JSONObject jSONObject = new JSONObject(strTt);
                    int iOptInt = jSONObject.optInt(PluginConstants.KEY_PLUGIN_VERSION);
                    this.gt = jSONObject.optString("log_version");
                    if (iOptInt != 7611 || TextUtils.isEmpty(this.gt)) {
                        gt();
                    }
                } else {
                    gt();
                }
            } catch (Exception unused) {
            }
        }
        return this.gt;
    }

    public void sl(String str) {
        if (str == null || !str.equals(this.gu)) {
            this.gu = str;
            c("dev16", str);
        }
    }

    public String sp() {
        if (this.uj == null) {
            this.uj = tt("dev05", (String) null);
        }
        return this.uj;
    }

    public void tt(int i) {
        if (i == this.m) {
            return;
        }
        this.m = i;
        c("age_group", i);
    }

    public int uj() {
        if (this.m == -1) {
            this.m = tt("age_group", Integer.MIN_VALUE);
        }
        return this.m;
    }

    public void ve(String str) {
        if (str == null || !str.equals(this.z)) {
            this.z = str;
            c("keywords", str);
        }
    }

    public String x() {
        if (this.n == null) {
            this.n = tt("dev07", (String) null);
        }
        return this.n;
    }

    public String c(String str) {
        if (this.yp == null) {
            this.yp = tt("dev03", str);
        }
        return this.yp;
    }

    public void a(int i) {
        c("sp_device_app_direction", i);
    }

    public void tt(boolean z) {
        int i = z ? 1 : 2;
        if (this.u != i) {
            this.u = i;
            c("is_use_mediation", i);
        }
    }

    public int uj(int i) {
        if (this.nu == -1) {
            this.nu = tt("sdk_theme_status", i);
        }
        return this.nu;
    }

    public void ve(int i) {
        if (i == this.nu) {
            return;
        }
        this.nu = i;
        c("sdk_theme_status", i);
    }

    public void x(int i) {
        if (this.gr == i) {
            return;
        }
        this.gr = i;
        c("dev_level", i);
    }

    public void c(JSONArray jSONArray) {
        if (jSONArray == null) {
            return;
        }
        if (jSONArray.toString().equals(this.qy == null ? null : this.qy.toString())) {
            return;
        }
        this.qy = jSONArray;
        c("dev12", jSONArray.toString());
    }

    public boolean tt(String str, boolean z) {
        try {
            if (ve.c().tt()) {
                return com.byazt.ti.tt.c(my(), str, z);
            }
            return tt().getBoolean(str, z);
        } catch (Throwable unused) {
            return z;
        }
    }

    public String ve(String str, long j) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        try {
            String strTt = tt(str, "");
            if (TextUtils.isEmpty(strTt)) {
                return null;
            }
            JSONObject jSONObject = new JSONObject(strTt);
            if (System.currentTimeMillis() - jSONObject.getLong("time") <= j) {
                return jSONObject.getString("value");
            }
        } catch (Exception unused) {
        }
        return null;
    }

    public boolean c(boolean z) {
        if (this.u == -1) {
            this.u = tt("is_use_mediation", z ? 1 : 2);
        }
        return this.u == 1;
    }

    public long tt(String str, long j) {
        try {
            if (ve.c().tt()) {
                return com.byazt.ti.tt.c(my(), str, j);
            }
            return tt().getLong(str, j);
        } catch (Throwable unused) {
            return j;
        }
    }

    public String n() {
        if (this.tt == null) {
            this.tt = com.byazt.nr.c.ve(tt("dev02", (String) null));
        }
        return this.tt;
    }

    public void c(String str, boolean z) {
        try {
            if (ve.c().tt()) {
                com.byazt.ti.tt.c(my(), str, Boolean.valueOf(z));
                return;
            }
            SharedPreferences.Editor editorEdit = tt().edit();
            editorEdit.putBoolean(str, z);
            editorEdit.apply();
        } catch (Throwable unused) {
        }
    }

    public int tt(String str, int i) {
        try {
            if (ve.c().tt()) {
                return com.byazt.ti.tt.c(my(), str, i);
            }
            return tt().getInt(str, i);
        } catch (Throwable unused) {
            return i;
        }
    }

    public void ve(String str, String str2) {
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            return;
        }
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("value", str2);
            jSONObject.put("time", System.currentTimeMillis());
            jSONObject.put("p_version", 7611);
            c(str, jSONObject.toString());
        } catch (JSONException e) {
            m.c(e);
        }
    }

    public String tt(String str, String str2) {
        try {
            if (ve.c().tt()) {
                return com.byazt.ti.tt.tt(my(), str, str2);
            }
            return tt().getString(str, str2);
        } catch (Throwable unused) {
            return str2;
        }
    }

    public void c(String str, long j) {
        try {
            if (ve.c().tt()) {
                com.byazt.ti.tt.c(my(), str, Long.valueOf(j));
                return;
            }
            SharedPreferences.Editor editorEdit = tt().edit();
            editorEdit.putLong(str, j);
            editorEdit.apply();
        } catch (Throwable unused) {
        }
    }

    public void c(String str, int i) {
        try {
            if (ve.c().tt()) {
                com.byazt.ti.tt.c(my(), str, Integer.valueOf(i));
                return;
            }
            SharedPreferences.Editor editorEdit = tt().edit();
            editorEdit.putInt(str, i);
            editorEdit.apply();
        } catch (Throwable unused) {
        }
    }

    public void c(String str, String str2) {
        try {
            if (ve.c().tt()) {
                com.byazt.ti.tt.c(my(), str, str2);
                return;
            }
            SharedPreferences.Editor editorEdit = tt().edit();
            editorEdit.putString(str, str2);
            editorEdit.apply();
        } catch (Throwable unused) {
        }
    }
}

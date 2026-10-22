package com.byazt.ete;

import android.text.TextUtils;
import androidx.camera.video.AudioStats;
import com.aliyun.credentials.utils.AuthConstant;
import com.byazt.nys.PluginConstants;
import com.coremedia.iso.boxes.MetaBox;
import java.util.LinkedHashMap;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_11_8719cls.dex */
@com.byazt.zqa.c(c = {0, 1, 8, 71})
public class x {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static ve f28516a;
    public static ve c;
    public static ve n;
    public static ve sp;
    public static ve tt;
    public static ve uj;
    public static ve ve;
    public static final ve x = new ve(null);

    @com.byazt.zqa.c(c = {0, 1, 8, 62})
    public static class c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public String f28517a;
        public JSONObject c;
        public String da;
        public String i;
        public String n;
        public String sp;
        public String tt;
        public String uj;
        public String ve;
        public String x;

        public c(JSONObject jSONObject) {
            this.c = jSONObject;
            if (jSONObject != null) {
                this.tt = jSONObject.optString("mix_ad");
                this.ve = jSONObject.optString("disable_trans_cache");
                this.uj = jSONObject.optString("delete_on_load");
                this.n = jSONObject.optString("load_only_online");
                this.f28517a = jSONObject.optString("forbid_save_cache");
                this.i = jSONObject.optString("forbid_read_cache");
                this.sp = jSONObject.optString("forbid_realtime_use_cache");
                this.x = jSONObject.optString("forbid_realtime");
                this.da = jSONObject.optString("forbid_preload");
            }
        }

        /* JADX WARN: Code duplicated, block: B:64:0x00b5  */
        /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
        private boolean tt(String str, tt ttVar) {
            String str2;
            str.hashCode();
            boolean z = true;
            byte b = -1;
            switch (str.hashCode()) {
                case -1085434702:
                    if (str.equals("delete_on_load")) {
                        b = 0;
                    }
                    break;
                case -1073750810:
                    if (str.equals("mix_ad")) {
                        b = 1;
                    }
                    break;
                case -883700652:
                    if (str.equals("disable_trans_cache")) {
                        b = 2;
                    }
                    break;
                case -707542069:
                    if (str.equals("forbid_save_cache")) {
                        b = 3;
                    }
                    break;
                case -91260031:
                    if (str.equals("forbid_realtime_use_cache")) {
                        b = 4;
                    }
                    break;
                case 899503542:
                    if (str.equals("forbid_realtime")) {
                        b = 5;
                    }
                    break;
                case 1290851437:
                    if (str.equals("load_only_online")) {
                        b = 6;
                    }
                    break;
                case 1816465502:
                    if (str.equals("forbid_preload")) {
                        b = 7;
                    }
                    break;
                case 2017273124:
                    if (str.equals("forbid_read_cache")) {
                        b = 8;
                    }
                    break;
            }
            String strC = null;
            switch (b) {
                case 0:
                    str2 = this.uj;
                    break;
                case 1:
                    str2 = !TextUtils.isEmpty(this.tt) ? this.tt : "${(meta.group_info.group_id != null) || (meta.insert_ad_control == 1) || (meta.refresh_ad_control == 1) || (meta.force_refresh_ad_control == 1) || (meta.refresh_control == 1) || (meta.web_refresh_control == 1)}";
                    break;
                case 2:
                    str2 = this.ve;
                    break;
                case 3:
                    str2 = this.f28517a;
                    break;
                case 4:
                    str2 = this.sp;
                    break;
                case 5:
                    str2 = this.x;
                    break;
                case 6:
                    str2 = this.n;
                    break;
                case 7:
                    str2 = this.da;
                    break;
                case 8:
                    str2 = this.i;
                    break;
                default:
                    str2 = null;
                    break;
            }
            if (TextUtils.isEmpty(str2)) {
                return false;
            }
            if (str2 != null) {
                try {
                    if (!str2.contains("meta.")) {
                        z = false;
                    }
                    JSONObject jSONObjectC = c(ttVar, z);
                    strC = com.byazt.wj.tt.c(str2, jSONObjectC);
                    com.byazt.nr.m.uj("cache_tag", "EL数据源 " + str + " 表达式：" + str2 + " 结果：" + strC + " 数据源：" + jSONObjectC);
                } catch (Exception unused) {
                    com.byazt.nr.m.uj("cache_tag", "EL数据源 " + str + "执行异常");
                }
            } else {
                z = false;
                JSONObject jSONObjectC2 = c(ttVar, z);
                strC = com.byazt.wj.tt.c(str2, jSONObjectC2);
                com.byazt.nr.m.uj("cache_tag", "EL数据源 " + str + " 表达式：" + str2 + " 结果：" + strC + " 数据源：" + jSONObjectC2);
            }
            return TextUtils.equals(strC, "true");
        }

        public JSONObject c() {
            return this.c;
        }

        private JSONObject c(tt ttVar, boolean z) {
            Object obj;
            int iVe;
            int i;
            int i2;
            com.byazt.dj.tt ttVar2 = null;
            if (ttVar != null) {
                com.byazt.dj.tt ttVarC = ttVar.c();
                Object objTt = z ? ttVar.tt() : null;
                iVe = ttVar.ve();
                obj = objTt;
                ttVar2 = ttVarC;
            } else {
                obj = null;
                iVe = 0;
            }
            JSONObject jSONObject = new JSONObject();
            try {
                JSONObject jSONObject2 = new JSONObject();
                jSONObject2.put("os", "android");
                String str = com.byazt.omf.p.n;
                String strOr = "";
                if (TextUtils.isEmpty(str)) {
                    i = 0;
                } else {
                    try {
                        i = Integer.parseInt(str.replaceAll("\\.", ""));
                    } catch (Throwable unused) {
                        i = 0;
                    }
                }
                if (TextUtils.isEmpty("7.6.1.1")) {
                    i2 = 0;
                } else {
                    try {
                        i2 = Integer.parseInt("7.6.1.1".replaceAll("\\.", ""));
                    } catch (Throwable unused2) {
                        i2 = 0;
                    }
                }
                jSONObject2.put("sdk_version", i);
                jSONObject2.put(PluginConstants.KEY_PLUGIN_VERSION, i2);
                jSONObject.put("device", jSONObject2);
                if (ttVar2 != null) {
                    JSONObject jSONObject3 = new JSONObject();
                    jSONObject3.put("adType", ttVar2.gt());
                    jSONObject3.put("adCount", ttVar2.t());
                    jSONObject3.put("userData", com.byazt.bzd.da.c(ttVar2.qy()));
                    jSONObject.put("adSlot", jSONObject3);
                }
                if (obj != null) {
                    jSONObject.put(MetaBox.TYPE, obj);
                }
                JSONObject jSONObject4 = new JSONObject();
                jSONObject4.put("last_net_code", iVe);
                jSONObject4.put("has_cache", ttVar != null && ttVar.uj());
                int iGt = ttVar2 != null ? ttVar2.gt() : 0;
                if (ttVar2 != null) {
                    strOr = ttVar2.or();
                }
                JSONObject jSONObjectC = com.byazt.vvt.ve.c(iGt, strOr);
                if (jSONObjectC != null) {
                    jSONObject4.put("ca_interval_info", jSONObjectC);
                }
                jSONObject.put("state", jSONObject4);
                return jSONObject;
            } catch (JSONException e) {
                throw new RuntimeException(e);
            }
        }

        public boolean c(String str, tt ttVar) {
            return tt(str, ttVar);
        }
    }

    @com.byazt.zqa.c(c = {0, 1, 8, 1178})
    public static class n {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public int f28518a;
        public boolean c;
        public float da;
        public float gt;
        public float i;
        public float m;
        public float my;
        public int n;
        public float nu;
        public float qy;
        public float rh;
        public float rl;
        public float sl;
        public int sp;
        public float t;
        public long tt;
        public float u;
        public int uj;
        public long ve;
        public float x;
        public float yp;
        public float z;

        public n(JSONObject jSONObject) {
            if (jSONObject != null) {
                this.c = jSONObject.optBoolean("tmax_enable", false);
                this.tt = jSONObject.optLong("tmax_max_limit", 0L);
                this.ve = jSONObject.optLong("tmax_min_limit", 0L);
                this.uj = jSONObject.optInt("tmax_calc_type", 0);
                this.n = jSONObject.optInt("tmax_calc_min_count_limit", 30);
                this.f28518a = jSONObject.optInt("tmax_calc_max_count_limit", 500);
                this.sp = jSONObject.optInt("tmax_cache_expire", 600);
                this.x = (float) jSONObject.optDouble("tmax_calc_percent_low", 0.5d);
                this.i = (float) jSONObject.optDouble("tmax_calc_percent_medium", 0.8999999761581421d);
                this.da = (float) jSONObject.optDouble("tmax_calc_percent_high", 0.949999988079071d);
                this.sl = (float) jSONObject.optDouble("tmax_calc_boundary_pct", 0.9800000190734863d);
                this.t = (float) jSONObject.optDouble("tmax_calc_shown_pct_low", 0.8999999761581421d);
                this.u = (float) jSONObject.optDouble("tmax_calc_shown_pct_medium", 0.949999988079071d);
                this.yp = (float) jSONObject.optDouble("tmax_calc_shown_pct_high", 0.9900000095367432d);
                this.z = (float) jSONObject.optDouble("tmax_calc_hard_cap_pct", 0.9950000047683716d);
                this.m = (float) jSONObject.optDouble("tmax_deviation_ratio", 0.30000001192092896d);
                this.nu = (float) jSONObject.optDouble("tmax_marginal_load_rate", 0.05000000074505806d);
                this.rh = (float) jSONObject.optDouble("tmax_utilization_rate", 0.30000001192092896d);
                this.my = (float) jSONObject.optDouble("tmax_too_small_load_success_rate_low", 0.8999999761581421d);
                this.gt = (float) jSONObject.optDouble("tmax_too_small_load_success_rate_high", 0.949999988079071d);
                this.rl = (float) jSONObject.optDouble("tmax_too_small_marginal_load_rate", 0.15000000596046448d);
                this.qy = (float) jSONObject.optDouble("tmax_too_small_deviation_ratio", -0.10000000149011612d);
            } else {
                this.c = false;
                this.tt = 0L;
                this.ve = 0L;
                this.uj = 0;
                this.n = 30;
                this.f28518a = 500;
                this.sp = 600;
                this.x = 0.5f;
                this.i = 0.9f;
                this.da = 0.95f;
                this.sl = 0.98f;
                this.t = 0.9f;
                this.u = 0.95f;
                this.yp = 0.99f;
                this.z = 0.995f;
                this.m = 0.3f;
                this.nu = 0.05f;
                this.rh = 0.3f;
                this.my = 0.9f;
                this.gt = 0.95f;
                this.rl = 0.15f;
                this.qy = -0.1f;
            }
            if (this.tt < 0) {
                this.tt = 0L;
            }
            if (this.ve < 0) {
                this.ve = 0L;
            }
            int i = this.uj;
            if (i == 0 || i == 1) {
                return;
            }
            this.uj = 0;
        }

        public int a() {
            return this.n;
        }

        public JSONObject c() {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("tmax_enable", this.c);
                jSONObject.put("tmax_max_limit", this.tt);
                jSONObject.put("tmax_min_limit", this.ve);
                jSONObject.put("tmax_calc_type", this.uj);
                jSONObject.put("tmax_calc_min_count_limit", this.n);
                jSONObject.put("tmax_calc_max_count_limit", this.f28518a);
                jSONObject.put("tmax_cache_expire", this.sp);
                jSONObject.put("tmax_calc_percent_low", this.x);
                jSONObject.put("tmax_calc_percent_medium", this.i);
                jSONObject.put("tmax_calc_percent_high", this.da);
                jSONObject.put("tmax_calc_boundary_pct", this.sl);
                jSONObject.put("tmax_calc_shown_pct_low", this.t);
                jSONObject.put("tmax_calc_shown_pct_medium", this.u);
                jSONObject.put("tmax_calc_shown_pct_high", this.yp);
                jSONObject.put("tmax_calc_hard_cap_pct", this.z);
                jSONObject.put("tmax_deviation_ratio", this.m);
                jSONObject.put("tmax_marginal_load_rate", this.nu);
                jSONObject.put("tmax_utilization_rate", this.rh);
                jSONObject.put("tmax_too_small_load_success_rate_low", this.my);
                jSONObject.put("tmax_too_small_load_success_rate_high", this.gt);
                jSONObject.put("tmax_too_small_marginal_load_rate", this.rl);
                jSONObject.put("tmax_too_small_deviation_ratio", this.qy);
            } catch (Exception unused) {
            }
            return jSONObject;
        }

        public float da() {
            return this.i;
        }

        public float gt() {
            return this.my;
        }

        public float gu() {
            return this.qy;
        }

        public float i() {
            return this.x;
        }

        public float m() {
            return this.z;
        }

        public float my() {
            return this.rh;
        }

        public int n() {
            return this.uj;
        }

        public float nu() {
            return this.m;
        }

        public float qy() {
            return this.rl;
        }

        public float rh() {
            return this.nu;
        }

        public float rl() {
            return this.gt;
        }

        public float sl() {
            return this.da;
        }

        public int sp() {
            int i = this.f28518a;
            if (i <= 0) {
                return 500;
            }
            return i;
        }

        public float t() {
            return this.sl;
        }

        public boolean tt() {
            return this.c;
        }

        public float u() {
            return this.t;
        }

        public long uj() {
            return this.ve;
        }

        public long ve() {
            return this.tt;
        }

        public int x() {
            return this.sp;
        }

        public float yp() {
            return this.u;
        }

        public float z() {
            return this.yp;
        }
    }

    @com.byazt.zqa.c(c = {0, 1, 8, 865})
    public static class tt {
        public com.byazt.dj.tt c;
        public boolean n;
        public JSONObject tt;
        public int uj;
        public ic ve;

        @com.byazt.zqa.c(c = {0, 1, 8, 229})
        public static class c {
            public com.byazt.dj.tt c;
            public boolean n;
            public JSONObject tt;
            public int uj;
            public ic ve;

            public c c(com.byazt.dj.tt ttVar) {
                this.c = ttVar;
                return this;
            }

            public c c(JSONObject jSONObject) {
                this.tt = jSONObject;
                return this;
            }

            public c c(ic icVar) {
                this.ve = icVar;
                return this;
            }

            public c c(int i) {
                this.uj = i;
                return this;
            }

            public c c(boolean z) {
                this.n = z;
                return this;
            }

            public tt c() {
                return new tt(this);
            }
        }

        public com.byazt.dj.tt c() {
            return this.c;
        }

        public JSONObject tt() {
            JSONObject jSONObject = this.tt;
            if (jSONObject != null) {
                return jSONObject;
            }
            ic icVar = this.ve;
            if (icVar != null) {
                return icVar.yg();
            }
            return null;
        }

        public boolean uj() {
            return this.n;
        }

        public int ve() {
            return this.uj;
        }

        private tt(c cVar) {
            this.c = cVar.c;
            this.ve = cVar.ve;
            this.tt = cVar.tt;
            this.uj = cVar.uj;
            this.n = cVar.n;
        }
    }

    @com.byazt.zqa.c(c = {0, 1, 8, 2452})
    public static class uj {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public LinkedHashMap<Integer, Integer> f28519a;
        public int c;
        public int n;
        public int tt;
        public int uj;
        public int ve;

        public uj(JSONObject jSONObject) {
            if (jSONObject != null) {
                this.c = jSONObject.optInt("device_score_threshold", 0);
                this.tt = jSONObject.optInt("net_type_threshold", 0);
                this.ve = jSONObject.optInt("base_score", 60);
                this.uj = jSONObject.optInt("score_threshold", 60);
                this.n = jSONObject.optInt("backup_score_threshold", 0);
                LinkedHashMap<Integer, Integer> linkedHashMap = new LinkedHashMap<>();
                JSONArray jSONArrayOptJSONArray = jSONObject.optJSONArray("last_cache_score");
                if (jSONArrayOptJSONArray != null && jSONArrayOptJSONArray.length() > 0) {
                    for (int i = 0; i < jSONArrayOptJSONArray.length(); i++) {
                        JSONArray jSONArrayOptJSONArray2 = jSONArrayOptJSONArray.optJSONArray(i);
                        int iOptInt = jSONArrayOptJSONArray2.optInt(0);
                        int iOptInt2 = jSONArrayOptJSONArray2.optInt(1);
                        if (iOptInt > 0) {
                            linkedHashMap.put(Integer.valueOf(iOptInt), Integer.valueOf(iOptInt2));
                        }
                    }
                }
                this.f28519a = linkedHashMap;
            }
        }

        public LinkedHashMap<Integer, Integer> a() {
            return this.f28519a;
        }

        public JSONObject c() {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("device_score_threshold", this.c);
                jSONObject.put("net_type_threshold", this.tt);
                jSONObject.put("base_score", this.ve);
                jSONObject.put("score_threshold", this.uj);
                jSONObject.put("backup_score_threshold", this.n);
                JSONArray jSONArray = new JSONArray();
                LinkedHashMap<Integer, Integer> linkedHashMap = this.f28519a;
                if (linkedHashMap != null && !linkedHashMap.isEmpty()) {
                    for (Integer num : this.f28519a.keySet()) {
                        JSONArray jSONArray2 = new JSONArray();
                        jSONArray2.put(num);
                        jSONArray2.put(this.f28519a.get(num));
                        jSONArray.put(jSONArray2);
                    }
                }
                jSONObject.put("last_cache_score", jSONArray);
            } catch (Exception unused) {
            }
            return jSONObject;
        }

        public int n() {
            return this.n;
        }

        public int sp() {
            return this.ve;
        }

        public int tt() {
            return this.c;
        }

        public int uj() {
            return this.uj;
        }

        public int ve() {
            return this.tt;
        }
    }

    @com.byazt.zqa.c(c = {0, 1, 8, 902})
    public static class ve {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public boolean f28520a;
        public int c;
        public c da;
        public uj i;
        public double m;
        public int n;
        public n nu;
        public int sl;
        public int sp;
        public int t;
        public int tt;
        public int u;
        public int uj;
        public int ve;
        public int x;
        public int yp;
        public boolean z;

        public ve(JSONObject jSONObject) {
            this.c = 1;
            this.tt = 1;
            this.ve = -1;
            this.uj = 0;
            this.n = 10000;
            this.f28520a = false;
            this.sp = -1;
            this.x = 0;
            this.sl = 1;
            this.t = 0;
            this.u = 0;
            this.yp = 0;
            this.z = true;
            this.m = AudioStats.AUDIO_AMPLITUDE_NONE;
            if (jSONObject == null) {
                this.nu = new n(null);
                return;
            }
            this.c = jSONObject.optInt("get_type", 1);
            this.tt = jSONObject.optInt("max_count", 1);
            this.ve = jSONObject.optInt("strategy_type", -1);
            this.uj = jSONObject.optInt("store_type", 0);
            this.n = jSONObject.optInt("online_timeout", 10000);
            this.f28520a = jSONObject.optBoolean(AuthConstant.INI_ENABLE, false);
            this.sp = jSONObject.optInt("load_type", -1);
            this.x = jSONObject.optInt("trans_cache", 0);
            this.sl = jSONObject.optInt("ad_count_max", 1);
            this.t = jSONObject.optInt("libra_group", 0);
            this.u = jSONObject.optInt("record_interval_minute", 0);
            this.yp = jSONObject.optInt("record_cache_minute", 0);
            this.i = new uj(jSONObject.optJSONObject("score_config"));
            this.da = new c(jSONObject.optJSONObject("control_el"));
            this.z = jSONObject.optBoolean("is_filter_version", true);
            this.m = jSONObject.optDouble("cache_available_percent", AudioStats.AUDIO_AMPLITUDE_NONE);
            this.nu = new n(jSONObject.optJSONObject("tmax_config"));
        }

        public int a() {
            return this.n;
        }

        public int da() {
            return this.x;
        }

        public int i() {
            return this.sp;
        }

        public double m() {
            double d = this.m;
            return (d >= AudioStats.AUDIO_AMPLITUDE_NONE && d <= 1.0d) ? d : AudioStats.AUDIO_AMPLITUDE_NONE;
        }

        public int n() {
            return this.uj;
        }

        public n nu() {
            return this.nu;
        }

        public uj sl() {
            return this.i;
        }

        public boolean sp() {
            return this.f28520a;
        }

        public int t() {
            return Math.max(this.sl, 1);
        }

        public int tt() {
            return this.c;
        }

        public int u() {
            return this.t;
        }

        public int uj() {
            return this.ve;
        }

        public int ve() {
            if (this.tt <= 0) {
                this.tt = 1;
            }
            return this.tt;
        }

        public boolean x() {
            return this.z;
        }

        public int yp() {
            return this.u;
        }

        public int z() {
            return this.yp;
        }

        public String c() {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("get_type", this.c);
                jSONObject.put("max_count", this.tt);
                jSONObject.put("strategy_type", this.ve);
                jSONObject.put("store_type", this.uj);
                jSONObject.put("online_timeout", this.n);
                jSONObject.put(AuthConstant.INI_ENABLE, this.f28520a);
                jSONObject.put("is_filter_version", this.z);
                jSONObject.put("load_type", this.sp);
                jSONObject.put("trans_cache", this.x);
                jSONObject.put("score_config", this.i.c());
                jSONObject.put("control_el", this.da.c());
                jSONObject.put("ad_count_max", this.sl);
                jSONObject.put("libra_group", this.t);
                jSONObject.put("record_interval_minute", this.u);
                jSONObject.put("record_cache_minute", this.yp);
                jSONObject.put("cache_available_percent", this.m);
                n nVar = this.nu;
                jSONObject.put("tmax_config", nVar == null ? null : nVar.c());
            } catch (Exception unused) {
            }
            return jSONObject.toString();
        }

        public boolean c(String str, tt ttVar) {
            if (this.da == null) {
                return false;
            }
            System.currentTimeMillis();
            boolean zC = this.da.c(str, ttVar);
            System.currentTimeMillis();
            return zC;
        }
    }

    private static ve a() {
        ve veVar = f28516a;
        return veVar == null ? new ve(new JSONObject()) : veVar;
    }

    public static void c(com.byazt.it.n nVar) {
        try {
            c = new ve(new JSONObject(nVar.get("cache_strategy_reward", "")));
        } catch (JSONException unused) {
        }
        try {
            tt = new ve(new JSONObject(nVar.get("cache_strategy_full", "")));
        } catch (JSONException unused2) {
        }
        try {
            uj = new ve(new JSONObject(nVar.get("cache_strategy_banner", "")));
        } catch (JSONException unused3) {
        }
        try {
            n = new ve(new JSONObject(nVar.get("cache_strategy_feed", "")));
        } catch (JSONException unused4) {
        }
        try {
            f28516a = new ve(new JSONObject(nVar.get("cache_strategy_draw", "")));
        } catch (JSONException unused5) {
        }
        try {
            sp = new ve(new JSONObject(nVar.get("cache_strategy_stream", "")));
        } catch (JSONException unused6) {
        }
        try {
            com.byazt.vvt.ve.c();
        } catch (Exception unused7) {
        }
    }

    private static ve n() {
        ve veVar = n;
        return veVar == null ? new ve(new JSONObject()) : veVar;
    }

    private static ve sp() {
        ve veVar = sp;
        return veVar == null ? new ve(new JSONObject()) : veVar;
    }

    public static void tt(com.byazt.it.n nVar) {
        ve veVar = c;
        if (veVar != null) {
            nVar.put("cache_strategy_reward", veVar.c());
        }
        ve veVar2 = tt;
        if (veVar2 != null) {
            nVar.put("cache_strategy_full", veVar2.c());
        }
        ve veVar3 = uj;
        if (veVar3 != null) {
            nVar.put("cache_strategy_banner", veVar3.c());
        }
        ve veVar4 = n;
        if (veVar4 != null) {
            nVar.put("cache_strategy_feed", veVar4.c());
        }
        ve veVar5 = f28516a;
        if (veVar5 != null) {
            nVar.put("cache_strategy_draw", veVar5.c());
        }
        ve veVar6 = sp;
        if (veVar6 != null) {
            nVar.put("cache_strategy_stream", veVar6.c());
        }
        if (ve != null) {
            com.byazt.by.n.tt ttVar = new com.byazt.by.n.tt();
            ttVar.uj(ve.c());
            ttVar.c();
        }
    }

    private static ve uj() {
        ve veVar = uj;
        return veVar == null ? new ve(new JSONObject()) : veVar;
    }

    private static ve ve() {
        ve veVar = tt;
        return veVar == null ? new ve(new JSONObject()) : veVar;
    }

    public static void c(JSONObject jSONObject) {
        JSONObject jSONObjectOptJSONObject = jSONObject.optJSONObject("app_common_config");
        if (jSONObjectOptJSONObject != null) {
            try {
                JSONObject jSONObjectOptJSONObject2 = jSONObjectOptJSONObject.optJSONObject("cache_strategy_reward");
                if (jSONObjectOptJSONObject2 != null) {
                    c = new ve(jSONObjectOptJSONObject2);
                    com.byazt.eti.n.tt(7);
                }
            } catch (Exception unused) {
            }
            try {
                JSONObject jSONObjectOptJSONObject3 = jSONObjectOptJSONObject.optJSONObject("cache_strategy_full");
                if (jSONObjectOptJSONObject3 != null) {
                    tt = new ve(jSONObjectOptJSONObject3);
                    com.byazt.eti.n.tt(8);
                }
            } catch (Exception unused2) {
            }
            try {
                JSONObject jSONObjectOptJSONObject4 = jSONObjectOptJSONObject.optJSONObject("cache_strategy_banner");
                if (jSONObjectOptJSONObject4 != null) {
                    uj = new ve(jSONObjectOptJSONObject4);
                    com.byazt.eti.n.tt(1);
                }
            } catch (Exception unused3) {
            }
            try {
                JSONObject jSONObjectOptJSONObject5 = jSONObjectOptJSONObject.optJSONObject("cache_strategy_feed");
                if (jSONObjectOptJSONObject5 != null) {
                    n = new ve(jSONObjectOptJSONObject5);
                    com.byazt.eti.n.tt(5);
                }
            } catch (Exception unused4) {
            }
            try {
                JSONObject jSONObjectOptJSONObject6 = jSONObjectOptJSONObject.optJSONObject("cache_strategy_draw");
                if (jSONObjectOptJSONObject6 != null) {
                    f28516a = new ve(jSONObjectOptJSONObject6);
                    com.byazt.eti.n.tt(9);
                }
            } catch (Exception unused5) {
            }
            try {
                JSONObject jSONObjectOptJSONObject7 = jSONObjectOptJSONObject.optJSONObject("cache_strategy_splash");
                if (jSONObjectOptJSONObject7 != null) {
                    ve = new ve(jSONObjectOptJSONObject7);
                    com.byazt.eti.n.tt(3);
                }
            } catch (Exception unused6) {
            }
            try {
                JSONObject jSONObjectOptJSONObject8 = jSONObjectOptJSONObject.optJSONObject("cache_strategy_stream");
                if (jSONObjectOptJSONObject8 != null) {
                    sp = new ve(jSONObjectOptJSONObject8);
                    com.byazt.eti.n.tt(6);
                }
            } catch (Exception unused7) {
            }
        }
    }

    private static ve tt() {
        ve veVar = c;
        return veVar == null ? new ve(new JSONObject()) : veVar;
    }

    public static ve c() {
        if (ve == null) {
            String strZ = com.byazt.by.n.c().z();
            try {
                if (TextUtils.isEmpty(strZ)) {
                    ve veVar = new ve(new JSONObject());
                    ve = veVar;
                    veVar.uj = 0;
                } else {
                    ve = new ve(new JSONObject(strZ));
                }
            } catch (JSONException unused) {
            }
        }
        return ve;
    }

    public static ve c(int i) {
        switch (i) {
            case 1:
                return uj();
            case 2:
            default:
                return x;
            case 3:
            case 4:
                return c();
            case 5:
                return n();
            case 6:
                return sp();
            case 7:
                return tt();
            case 8:
                return ve();
            case 9:
                return a();
        }
    }
}

package com.byazt.qe;

import android.os.SystemClock;
import android.text.TextUtils;
import androidx.camera.video.AudioStats;
import com.byazt.hr.yp;
import com.byazt.it.n;
import com.byazt.nbs.da;
import com.byazt.nbs.uj;
import com.byazt.tjo.a;
import com.byazt.vx.eo;
import com.byazt.vx.qy;
import com.byazt.yf.m;
import com.bytedance.sdk.openadsdk.mediation.MediationConstant;
import com.zj.adlib.bv9;
import com.zj.adlib.ze1;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_11_8719cls.dex */
@com.byazt.zqa.c(c = {0, 1, 697, 54})
public class ve implements c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public String f28971a;
    public String aw;
    public com.byazt.bg.tt bm;
    public int da;
    public int eo;
    public long gt;
    public int hd;
    public String i;
    public int ic;
    public boolean j;
    public int lt;
    public com.byazt.sc.tt ma;
    public long my;
    public long n;
    public volatile JSONObject s;
    public String sl;
    public String sp;
    public int sv;
    public String t;
    public com.byazt.xx.tt to;
    public int u;
    public long uj;
    public String ve;
    public String x;
    public int c = 259200000;
    public final List<Object> tt = new CopyOnWriteArrayList();
    public String yp = null;
    public String z = null;
    public boolean m = false;
    public int nu = 0;
    public String rh = "log-api.pangolin-sdk-toutiao.com/service/2/app_log/";
    public int rl = Integer.MAX_VALUE;
    public final List<m> qy = new CopyOnWriteArrayList();
    public Map<String, Boolean> gu = new HashMap();
    public final AtomicBoolean gr = new AtomicBoolean(false);
    public final AtomicBoolean zm = new AtomicBoolean(false);
    public int yv = 0;
    public Map<String, String> p = new ConcurrentHashMap();
    public Map<String, List<String>> md = new ConcurrentHashMap();
    public double h = AudioStats.AUDIO_AMPLITUDE_NONE;
    public boolean d = false;
    public Map<String, com.byazt.nbs.ve> zb = new ConcurrentHashMap();
    public int or = 0;
    public final Map<String, List<com.byazt.nbs.ve>> cu = new ConcurrentHashMap();
    public final Map<String, uj> qp = new ConcurrentHashMap();
    public final Map<String, Integer> nb = new ConcurrentHashMap();
    public final Map<String, Integer> pf = new ConcurrentHashMap();
    public int bx = 0;
    public int lr = 0;
    public int l = 0;
    public int lo = 0;
    public int pu = 0;
    public int tk = 0;
    public int kp = 0;
    public int b = 0;
    public boolean q = false;
    public boolean kk = false;
    public boolean tx = false;
    public boolean v = false;
    public long os = Long.MIN_VALUE;
    public long oz = Long.MIN_VALUE;
    public long r = Long.MIN_VALUE;
    public int y = 0;
    public final AtomicInteger iu = new AtomicInteger(0);
    public int dz = -1;

    /* JADX INFO: Access modifiers changed from: private */
    public void f() {
        com.byazt.vq.c.c().uj();
        if (bx()) {
            Iterator<m> it = this.qy.iterator();
            while (it.hasNext()) {
                it.next().c();
            }
            this.qy.clear();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void g() {
        com.byazt.rq.c.c().put("app_simple_abtest", this.z);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void ir() {
        n nVarC = com.byazt.rq.c.c();
        nVarC.put("cache_refresh_interval", this.os);
        nVarC.put("splash_ad_timeout", this.oz);
        nVarC.put("non_splash_ad_timeout", this.r);
        nVarC.put("app_simple_abtest", this.z);
    }

    private void ma() {
        this.f28971a = "";
        this.sp = "";
        this.x = "";
        this.i = "";
        this.sl = "0";
        this.t = "0";
        this.gt = 10000L;
        com.byazt.oi.c.c().c(this.my, this.gt);
    }

    private boolean yf() {
        Boolean bool = this.gu.get("active_control");
        return bool == null || !bool.booleanValue();
    }

    public boolean aw() {
        return this.yv == 1;
    }

    public boolean b() {
        return this.sv == 1;
    }

    public double bm() {
        return this.h;
    }

    public boolean dz() {
        com.byazt.eu.tt.tt("TMe", "enable_bid_result_return = " + this.lo);
        com.byazt.eu.tt.tt("TMe", "enable_bid_result_return_for_ks = " + this.tk);
        return this.lo == 1 && this.tk == 1;
    }

    public Map<String, List<String>> hd() {
        return this.md;
    }

    public Map<String, String> ic() {
        return this.p;
    }

    public boolean iu() {
        return this.lo == 1 && this.pu == 1;
    }

    public boolean j() {
        return this.lo == 1 && this.pu == 2;
    }

    public boolean kk() {
        return this.or == 1;
    }

    public Map<String, com.byazt.nbs.ve> kp() {
        return this.zb;
    }

    public boolean l() {
        return this.hd == 1;
    }

    public boolean lo() {
        return this.lt == 1;
    }

    public boolean lr() {
        return this.ic == 1;
    }

    public com.byazt.xx.tt lt() {
        if (lo()) {
            return this.to;
        }
        return null;
    }

    public Map<String, Integer> os() {
        return this.nb;
    }

    public Map<String, Integer> oz() {
        return this.pf;
    }

    public com.byazt.bg.tt pu() {
        return this.bm;
    }

    public String q() {
        return this.aw;
    }

    public int r() {
        return this.lr;
    }

    public int s() {
        return this.l;
    }

    public boolean sv() {
        if (this.rl == Integer.MAX_VALUE) {
            this.rl = 1;
        }
        return this.rl == 1;
    }

    public int tk() {
        return this.eo;
    }

    public boolean to() {
        return this.eo == 1;
    }

    public int tx() {
        return this.c;
    }

    public int v() {
        com.byazt.bg.tt ttVar = this.bm;
        if (ttVar != null) {
            return ttVar.c();
        }
        return 0;
    }

    public boolean y() {
        com.byazt.eu.tt.tt("TMe", "enable_bid_result_return = " + this.lo);
        com.byazt.eu.tt.tt("TMe", "enable_bid_result_return_for_baidu = " + this.pu);
        return iu() || j();
    }

    public boolean a() {
        return this.tx;
    }

    public boolean bx() {
        if (TextUtils.isEmpty(com.byazt.bp.c.t().u())) {
            return false;
        }
        com.byazt.eu.tt.tt("TTMediationSDK_SDK_Init", "--==----- isConfigLoadAndAdnInit: " + i());
        if (com.byazt.ck.uj.c().ve() || !i()) {
            com.byazt.eu.tt.tt("TTMediationSDK_SDK_Init", "--==----- isConfigLoadAndAdnInit 2");
            return false;
        }
        com.byazt.eu.tt.tt("TTMediationSDK_SDK_Init", "--==----- isConfigLoadAndAdnInit 1");
        return true;
    }

    public void c(boolean z) {
        this.tx = z;
    }

    public boolean cu() {
        try {
            return Integer.valueOf(this.sl).intValue() > 1;
        } catch (Exception unused) {
        }
    }

    public boolean d() {
        if (!yf()) {
            return false;
        }
        Boolean bool = this.gu.get("type_full_control");
        return bool == null || !bool.booleanValue();
    }

    public boolean da() {
        return this.b == 1;
    }

    public boolean eo() {
        if (!yf()) {
            return false;
        }
        Boolean bool = this.gu.get("type_native_control");
        return bool == null || !bool.booleanValue();
    }

    public boolean gr() {
        if (!yf()) {
            return false;
        }
        Boolean bool = this.gu.get("type_banner_control");
        return bool == null || !bool.booleanValue();
    }

    public long gt() {
        if (this.os == Long.MIN_VALUE) {
            this.os = com.byazt.rq.c.c().getLong("cache_refresh_interval", 12L);
        }
        return this.os * 60 * 60 * 1000;
    }

    public boolean gu() {
        if (!yf()) {
            return false;
        }
        Boolean bool = this.gu.get("ad_event_control");
        return bool == null || !bool.booleanValue();
    }

    public boolean h() {
        if (!yf()) {
            return false;
        }
        Boolean bool = this.gu.get("type_reward_control");
        return bool == null || !bool.booleanValue();
    }

    public boolean i() {
        return this.gr.get();
    }

    public boolean m() {
        return this.u == 1;
    }

    public boolean md() {
        if (!yf()) {
            return false;
        }
        Boolean bool = this.gu.get("type_feed_control");
        return bool == null || !bool.booleanValue();
    }

    public boolean my() {
        return this.m;
    }

    public boolean n() {
        return this.kk;
    }

    public long nb() {
        return com.byazt.ck.tt.c().ve();
    }

    public String nu() {
        return this.yp;
    }

    public boolean or() {
        try {
            return Integer.valueOf(this.sl).intValue() > 0;
        } catch (Exception unused) {
            return false;
        }
    }

    public boolean p() {
        if (!yf()) {
            return false;
        }
        Boolean bool = this.gu.get("type_splash_control");
        return bool == null || !bool.booleanValue();
    }

    public boolean pf() {
        return (com.byazt.ck.uj.c().ve() || com.byazt.ck.ve.c().uj()) ? false : true;
    }

    public int qp() {
        return com.byazt.ck.tt.c().tt();
    }

    public long qy() {
        if (this.r == Long.MIN_VALUE) {
            this.r = com.byazt.rq.c.c().getLong("non_splash_ad_timeout", 0L);
        }
        return this.r;
    }

    public String rh() {
        return this.z;
    }

    public long rl() {
        if (this.oz == Long.MIN_VALUE) {
            this.oz = com.byazt.rq.c.c().getLong("splash_ad_timeout", 0L);
        }
        return this.oz;
    }

    public int sl() {
        return com.byazt.ck.c.c(this.iu.get());
    }

    public boolean sp() {
        return this.v;
    }

    public String t() {
        return this.x;
    }

    public int tt() {
        return this.kp;
    }

    public String u() {
        return this.i;
    }

    public boolean uj() {
        return this.q;
    }

    public boolean ve() {
        n nVarC;
        if (this.dz == -1 && (nVarC = com.byazt.rq.c.c()) != null) {
            String string = nVarC.getString("app_abtest", null);
            if (!TextUtils.isEmpty(string)) {
                this.yp = string;
                try {
                    x(new JSONObject(this.yp));
                } catch (JSONException e) {
                    com.byazt.nr.m.c(e);
                }
            }
        }
        return this.dz == 1;
    }

    public boolean x() {
        return this.y == 1;
    }

    public String yp() {
        if (this.ve == null) {
            this.ve = com.byazt.rq.c.c().getString("etag", null);
        }
        return this.ve;
    }

    public boolean yv() {
        if (!yf()) {
            return false;
        }
        Boolean bool = this.gu.get("type_interactionfull_control");
        return bool == null || !bool.booleanValue();
    }

    public String z() {
        return this.rh;
    }

    public boolean zb() {
        return this.da > 0;
    }

    public boolean zm() {
        if (!yf()) {
            return false;
        }
        Boolean bool = this.gu.get("type_interaction_control");
        return bool == null || !bool.booleanValue();
    }

    private String a(JSONObject jSONObject) {
        if (jSONObject == null) {
            return null;
        }
        Iterator<String> itKeys = jSONObject.keys();
        while (itKeys.hasNext()) {
            String next = itKeys.next();
            this.zb.put(next, com.byazt.nbs.ve.c(next, jSONObject.optJSONObject(next)));
        }
        return jSONObject.toString();
    }

    private void da(JSONObject jSONObject) {
        this.md.clear();
        if (jSONObject != null) {
            try {
                Iterator<String> itKeys = jSONObject.keys();
                if (itKeys != null) {
                    while (itKeys.hasNext()) {
                        String next = itKeys.next();
                        JSONArray jSONArrayOptJSONArray = jSONObject.optJSONArray(next);
                        ArrayList arrayList = new ArrayList();
                        if (jSONArrayOptJSONArray != null) {
                            for (int i = 0; i < jSONArrayOptJSONArray.length(); i++) {
                                if (jSONArrayOptJSONArray.get(i) != null) {
                                    arrayList.add(jSONArrayOptJSONArray.get(i).toString());
                                }
                            }
                        }
                        if (!TextUtils.isEmpty(next) && !arrayList.isEmpty()) {
                            this.md.put(next, arrayList);
                        }
                    }
                }
            } catch (Exception unused) {
            }
        }
    }

    private void i(JSONObject jSONObject) {
        this.p.clear();
        this.yv = 0;
        if (jSONObject == null) {
            return;
        }
        this.yv = jSONObject.optInt("if_sample", 0);
        JSONObject jSONObjectOptJSONObject = jSONObject.optJSONObject("call_stack_path");
        if (jSONObjectOptJSONObject != null) {
            try {
                Iterator<String> itKeys = jSONObjectOptJSONObject.keys();
                if (itKeys != null) {
                    while (itKeys.hasNext()) {
                        String next = itKeys.next();
                        String strOptString = jSONObjectOptJSONObject.optString(next);
                        if (!TextUtils.isEmpty(next) && !TextUtils.isEmpty(strOptString)) {
                            this.p.put(next, strOptString);
                        }
                    }
                }
            } catch (Exception unused) {
            }
        }
    }

    private String n(JSONObject jSONObject) {
        if (jSONObject == null || jSONObject.length() == 0) {
            return "";
        }
        Iterator<String> itKeys = jSONObject.keys();
        while (itKeys.hasNext()) {
            String next = itKeys.next();
            try {
                JSONArray jSONArray = jSONObject.getJSONArray(next);
                if (jSONArray.length() > 0) {
                    ArrayList arrayList = new ArrayList();
                    for (int i = 0; i < jSONArray.length(); i++) {
                        arrayList.add(com.byazt.nbs.ve.c(next, jSONArray.optJSONObject(i)));
                    }
                    this.cu.put(next, arrayList);
                }
            } catch (Exception e) {
                com.byazt.nr.m.c(e);
            }
        }
        return jSONObject.toString();
    }

    private String sl(JSONObject jSONObject) {
        this.gu.clear();
        if (jSONObject == null) {
            return null;
        }
        try {
            if (jSONObject.optBoolean("ad_event_control")) {
                this.gu.put("ad_event_control", Boolean.TRUE);
            }
            if (jSONObject.optBoolean("type_banner_control")) {
                this.gu.put("type_banner_control", Boolean.TRUE);
            }
            if (jSONObject.optBoolean("type_interaction_control")) {
                this.gu.put("type_interaction_control", Boolean.TRUE);
            }
            if (jSONObject.optBoolean("type_interactionfull_control")) {
                this.gu.put("type_interactionfull_control", Boolean.TRUE);
            }
            if (jSONObject.optBoolean("type_splash_control")) {
                this.gu.put("type_splash_control", Boolean.TRUE);
            }
            if (jSONObject.optBoolean("type_feed_control")) {
                this.gu.put("type_feed_control", Boolean.TRUE);
            }
            if (jSONObject.optBoolean("type_reward_control")) {
                this.gu.put("type_reward_control", Boolean.TRUE);
            }
            if (jSONObject.optBoolean("type_full_control")) {
                this.gu.put("type_full_control", Boolean.TRUE);
            }
            if (jSONObject.optBoolean("type_native_control")) {
                this.gu.put("type_native_control", Boolean.TRUE);
            }
            return jSONObject.toString();
        } catch (Exception unused) {
            return null;
        }
    }

    private String sp(JSONObject jSONObject) {
        if (jSONObject == null) {
            return null;
        }
        this.u = jSONObject.optInt("fetch_ad_type", 0);
        return jSONObject.toString();
    }

    private void t(JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        this.nb.clear();
        Iterator<String> itKeys = jSONObject.keys();
        while (itKeys.hasNext()) {
            String next = itKeys.next();
            this.nb.put(next, Integer.valueOf(jSONObject.optInt(next)));
        }
    }

    private void u(JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        this.pf.clear();
        Iterator<String> itKeys = jSONObject.keys();
        while (itKeys.hasNext()) {
            String next = itKeys.next();
            this.pf.put(next, Integer.valueOf(jSONObject.optInt(next)));
        }
    }

    private String uj(JSONObject jSONObject) {
        if (jSONObject == null) {
            return null;
        }
        this.to = new com.byazt.xx.tt(jSONObject);
        return jSONObject.toString();
    }

    private void x(JSONObject jSONObject) {
        try {
            String strOptString = jSONObject.optString("app_ab_version");
            if (TextUtils.isEmpty(strOptString) || TextUtils.isEmpty(strOptString.trim()) || TextUtils.equals(strOptString.trim(), "null")) {
                jSONObject.remove("app_ab_version");
            }
            JSONObject jSONObject2 = new JSONObject(jSONObject.optString("app_ab_params"));
            JSONObject jSONObjectOptJSONObject = jSONObject2.optJSONObject("mediation_settings");
            if (jSONObjectOptJSONObject != null) {
                this.bx = jSONObjectOptJSONObject.optInt("ad_request_optmize");
                boolean z = true;
                this.q = jSONObjectOptJSONObject.optInt("applog_cypher") == 2;
                this.kk = jSONObjectOptJSONObject.optInt("reward_cypher") == 2;
                this.tx = jSONObjectOptJSONObject.optInt("config_cypher") == 2;
                if (jSONObjectOptJSONObject.optInt("exchange_cypher") != 2) {
                    z = false;
                }
                this.v = z;
            }
            JSONObject jSONObjectOptJSONObject2 = jSONObject2.optJSONObject("init_opt");
            if (jSONObjectOptJSONObject2 != null) {
                this.dz = jSONObjectOptJSONObject2.optInt("init_7600");
            } else {
                this.dz = 0;
            }
            JSONObject jSONObjectOptJSONObject3 = jSONObject2.optJSONObject("event_upload_settings");
            if (jSONObjectOptJSONObject3 != null) {
                this.b = jSONObjectOptJSONObject3.optInt("show_upload");
            }
        } catch (Throwable unused) {
        }
    }

    public com.byazt.nbs.tt c(String str, int i, int i2) {
        return com.byazt.ck.uj.c().c(str, i, i2);
    }

    public com.byazt.nbs.c tt(String str) {
        return com.byazt.ck.ve.c().c(str);
    }

    private void tt(JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        this.os = jSONObject.optLong("cache_refresh_interval", 12L);
        this.oz = jSONObject.optLong("splash_ad_timeout", 0L);
        this.r = jSONObject.optLong("non_splash_ad_timeout", 0L);
    }

    public long c(int i, String str) {
        com.byazt.nbs.tt ttVarC = c(str, i, 101);
        if (ttVarC != null) {
            return ttVarC.ic();
        }
        return 3000L;
    }

    public void uj(String str) {
        try {
            n nVarC = com.byazt.rq.c.c();
            if ("2".equals(str)) {
                this.gu.put("active_control", Boolean.TRUE);
                nVarC.put("all_active_control", true);
            } else {
                this.gu.put("active_control", Boolean.FALSE);
                nVarC.put("all_active_control", false);
            }
        } catch (Exception e) {
            com.byazt.nr.m.c(e);
        }
    }

    public com.byazt.nbs.c c(String str) {
        return com.byazt.ck.ve.c().c(str);
    }

    public boolean c(String str, String str2, int i) {
        List<da> listL;
        com.byazt.nbs.tt ttVarC = com.byazt.ck.uj.c().c(str, i, 101);
        if (ttVarC == null || (listL = ttVarC.l()) == null) {
            return false;
        }
        for (da daVar : listL) {
            if (daVar != null && TextUtils.equals(daVar.rh(), str2)) {
                return daVar.sv();
            }
        }
        return false;
    }

    public boolean tt(String str, int i) {
        return (com.byazt.ck.ve.c().uj() || com.byazt.ck.uj.c().ve() || com.byazt.ck.uj.c().c(str, i, 101) == null) ? false : true;
    }

    private String tt(JSONArray jSONArray) {
        JSONArray jSONArrayOptJSONArray;
        if (jSONArray != null) {
            ConcurrentHashMap<String, com.byazt.hr.tt> concurrentHashMap = new ConcurrentHashMap<>();
            for (int i = 0; i < jSONArray.length(); i++) {
                JSONObject jSONObjectOptJSONObject = jSONArray.optJSONObject(i);
                if (jSONObjectOptJSONObject != null && (jSONArrayOptJSONArray = jSONObjectOptJSONObject.optJSONArray("break_request_error_code")) != null) {
                    ArrayList arrayList = new ArrayList();
                    for (int i2 = 0; i2 < jSONArrayOptJSONArray.length(); i2++) {
                        arrayList.add(jSONArrayOptJSONArray.optString(i2));
                    }
                    com.byazt.hr.tt ttVar = new com.byazt.hr.tt();
                    ttVar.c(jSONObjectOptJSONObject.optLong("break_request_duration"));
                    ttVar.c(arrayList);
                    concurrentHashMap.put(jSONObjectOptJSONObject.optString(MediationConstant.EXTRA_ADN_NAME), ttVar);
                }
            }
            com.byazt.hr.ve.c().c(concurrentHashMap);
            return jSONArray.toString();
        }
        com.byazt.hr.ve.c().c(null);
        return null;
    }

    public List<com.byazt.nbs.ve> a(String str) {
        return this.cu.get(str);
    }

    public boolean ve(String str) {
        return com.byazt.ck.ve.c().tt(str);
    }

    private String ve(JSONObject jSONObject) {
        if (jSONObject == null) {
            return null;
        }
        this.bm = new com.byazt.bg.tt(jSONObject);
        return jSONObject.toString();
    }

    public boolean c(String str, int i) {
        com.byazt.nbs.tt ttVarC;
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        return com.byazt.ck.uj.c().ve() || (ttVarC = com.byazt.ck.uj.c().c(str, i, 101)) == null || ttVarC.pf() == i;
    }

    public void uj(int i) {
        this.eo = i;
    }

    private String ve(JSONArray jSONArray) {
        JSONArray jSONArrayOptJSONArray;
        JSONArray jSONArrayOptJSONArray2;
        if (jSONArray != null) {
            ConcurrentHashMap<String, List<com.byazt.hr.tt>> concurrentHashMap = new ConcurrentHashMap<>();
            for (int i = 0; i < jSONArray.length(); i++) {
                JSONObject jSONObjectOptJSONObject = jSONArray.optJSONObject(i);
                if (jSONObjectOptJSONObject != null) {
                    String strOptString = jSONObjectOptJSONObject.optString(MediationConstant.EXTRA_ADN_NAME);
                    if (!TextUtils.isEmpty(strOptString) && (jSONArrayOptJSONArray = jSONObjectOptJSONObject.optJSONArray("break_request_error_code")) != null && (jSONArrayOptJSONArray2 = jSONObjectOptJSONObject.optJSONArray("rit_list")) != null) {
                        ArrayList arrayList = new ArrayList();
                        for (int i2 = 0; i2 < jSONArrayOptJSONArray.length(); i2++) {
                            arrayList.add(jSONArrayOptJSONArray.optString(i2));
                        }
                        com.byazt.hr.tt ttVar = new com.byazt.hr.tt();
                        ttVar.c(jSONObjectOptJSONObject.optLong("break_request_duration"));
                        ttVar.c(arrayList);
                        ArrayList arrayList2 = new ArrayList();
                        for (int i3 = 0; i3 < jSONArrayOptJSONArray2.length(); i3++) {
                            arrayList2.add(jSONArrayOptJSONArray2.optString(i3));
                        }
                        ttVar.tt(arrayList2);
                        List<com.byazt.hr.tt> arrayList3 = concurrentHashMap.get(strOptString);
                        if (arrayList3 == null) {
                            arrayList3 = new ArrayList<>();
                        }
                        arrayList3.add(ttVar);
                        concurrentHashMap.put(strOptString, arrayList3);
                    }
                }
            }
            yp.c().c(concurrentHashMap);
            return jSONArray.toString();
        }
        yp.c().c(null);
        return null;
    }

    /* JADX WARN: Code duplicated, block: B:85:0x031e A[DONT_GENERATE] */
    /* JADX WARN: Code duplicated, block: B:88:0x0325 A[DONT_GENERATE, DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:89:0x0327 A[DONT_GENERATE] */
    @Override // com.byazt.qe.c
    public void c(JSONObject jSONObject, final boolean z, boolean z2, JSONObject jSONObject2) {
        int i;
        boolean z3;
        com.byazt.sc.tt ttVar;
        JSONObject jSONObject3;
        ve veVar;
        final String strOptString;
        final JSONObject jSONObjectOptJSONObject;
        JSONObject jSONObjectOptJSONObject2;
        final String strTt;
        final String strVe;
        final String strSp;
        final String strSl;
        final JSONObject jSONObjectOptJSONObject3;
        final JSONObject jSONObjectOptJSONObject4;
        final JSONObject jSONObjectOptJSONObject5;
        final JSONObject jSONObjectOptJSONObject6;
        final String strA;
        final String strN;
        final String strC;
        final String strVe2;
        final String strUj;
        final JSONArray jSONArrayOptJSONArray;
        final String str;
        if (jSONObject == null) {
            return;
        }
        boolean z4 = false;
        try {
            try {
                try {
                    if (z2) {
                        try {
                            i = 3;
                            if (this.iu.get() < 3) {
                                this.s = jSONObject;
                            } else if (z2) {
                                if (com.byazt.sx.ve.ve()) {
                                    c(false, jSONObject2, (com.byazt.sc.tt) null);
                                }
                            } else {
                                if (!z) {
                                    com.byazt.tjo.c.c().ve();
                                }
                                c(false, jSONObject2, (com.byazt.sc.tt) null);
                                return;
                            }
                        } catch (Throwable th) {
                            th = th;
                            z3 = false;
                            ttVar = null;
                            jSONObject3 = jSONObject2;
                            veVar = this;
                            try {
                                com.byazt.nr.m.c(th);
                                if (z2) {
                                    return;
                                } else {
                                    return;
                                }
                            } finally {
                                if (z2) {
                                    if (com.byazt.sx.ve.ve()) {
                                        veVar.c(z3, jSONObject3, ttVar);
                                    }
                                    com.byazt.tjo.c.c().tt();
                                }
                                if (!z) {
                                    com.byazt.tjo.c.c().ve();
                                }
                                veVar.c(z3, jSONObject3, ttVar);
                            }
                        }
                        return;
                    }
                    i = z ? 2 : 6;
                    com.byazt.eu.n.uj(new Runnable() { // from class: com.byazt.qe.ve.1
                        @Override // java.lang.Runnable
                        public void run() {
                            String strC2;
                            String strC3;
                            String strC4;
                            String strC5;
                            String strC6;
                            String strC7;
                            String strC8;
                            String strC9;
                            n nVarC = com.byazt.rq.c.c();
                            nVarC.put("is_trusteeship_monetize", ve.this.kp);
                            nVarC.put("share_cache_enable", ve.this.y);
                            nVarC.put("etag", ve.this.ve);
                            nVarC.put("max_age", ve.this.uj);
                            nVarC.put("max_expire_time", ve.this.n);
                            nVarC.put("ab_version", ve.this.f28971a);
                            nVarC.put("ab_params", ve.this.sp);
                            nVarC.put(ze1.s, ve.this.x);
                            nVarC.put("transparent_params", ve.this.i);
                            nVarC.put("if_test", ve.this.eo);
                            nVarC.put("network_permission", ve.this.da);
                            nVarC.put("ecpm_precision_level", ve.this.sl);
                            nVarC.put("fetch_primerit_level", ve.this.t);
                            nVarC.put("cache_refresh_interval", ve.this.os);
                            nVarC.put("splash_ad_timeout", ve.this.oz);
                            nVarC.put("non_splash_ad_timeout", ve.this.r);
                            nVarC.put("app_abtest", ve.this.yp);
                            nVarC.put("module_control", strSl);
                            nVarC.put("tt_app_log_url", ve.this.rh);
                            nVarC.put("break_request_times", ve.this.my);
                            nVarC.put("break_request_hold_time", ve.this.gt);
                            nVarC.put("ex_info", ve.this.sv);
                            nVarC.put("if_enable_label", ve.this.or);
                            nVarC.put("cpm_expire_time", ve.this.c);
                            JSONObject jSONObject4 = jSONObjectOptJSONObject;
                            nVarC.put("key_supervisor_feature", jSONObject4 != null ? jSONObject4.toString() : "");
                            nVarC.put("custom_adn_sample_ratio", (float) ve.this.h);
                            nVarC.put("enable_label_return", ve.this.ic);
                            nVarC.put("dynamic_policy_enable", ve.this.hd);
                            nVarC.put("behavior_policy_enable", ve.this.lt);
                            nVarC.put("limit_p_a", ve.this.lr);
                            nVarC.put("limit_p_r", ve.this.l);
                            nVarC.put("enable_bid_result_return", ve.this.lo);
                            nVarC.put("enable_bid_result_return_for_baidu", ve.this.pu);
                            nVarC.put("enable_bid_result_return_for_ks", ve.this.tk);
                            JSONObject jSONObject5 = jSONObjectOptJSONObject3;
                            if (jSONObject5 != null) {
                                nVarC.put("call_stack", jSONObject5.toString());
                            } else {
                                nVarC.put("call_stack", "");
                            }
                            JSONObject jSONObject6 = jSONObjectOptJSONObject4;
                            if (jSONObject6 != null) {
                                nVarC.put("custom_adn_feature", jSONObject6.toString());
                            } else {
                                nVarC.put("custom_adn_feature", "");
                            }
                            JSONObject jSONObject7 = jSONObjectOptJSONObject5;
                            if (jSONObject7 != null) {
                                nVarC.put("timeout_req", jSONObject7.toString());
                            } else {
                                nVarC.put("timeout_req", "");
                            }
                            JSONObject jSONObject8 = jSONObjectOptJSONObject6;
                            if (jSONObject8 != null) {
                                nVarC.put("is_callback", jSONObject8.toString());
                            } else {
                                nVarC.put("is_callback", "");
                            }
                            String str2 = strOptString;
                            if (str2 == null || TextUtils.isEmpty(str2)) {
                                nVarC.remove("server_dist_host");
                            } else {
                                String strC10 = com.byazt.vx.c.c(strOptString, com.byazt.vx.tt.c());
                                if (strC10 != null) {
                                    nVarC.put("server_dist_host", strC10);
                                }
                            }
                            String str3 = strTt;
                            if (str3 != null && (strC9 = com.byazt.vx.c.c(str3, com.byazt.vx.tt.c())) != null) {
                                nVarC.put("adn_control_conf", strC9);
                            }
                            if (TextUtils.isEmpty(strVe)) {
                                nVarC.remove("rit_adn_control_conf");
                            } else {
                                nVarC.put("rit_adn_control_conf", strVe);
                            }
                            String str4 = strSp;
                            if (str4 != null) {
                                nVarC.put("network_conf", str4);
                            }
                            if (!TextUtils.isEmpty(strA) && (strC8 = com.byazt.vx.c.c(strA, com.byazt.vx.tt.c())) != null) {
                                nVarC.put("label_outputs", strC8);
                            }
                            if (!TextUtils.isEmpty(strN) && (strC7 = com.byazt.vx.c.c(strN, com.byazt.vx.tt.c())) != null) {
                                nVarC.put("label_group_infos", strC7);
                            }
                            if (!TextUtils.isEmpty(strC) && (strC6 = com.byazt.vx.c.c(strC, com.byazt.vx.tt.c())) != null) {
                                nVarC.put("dynamic_rules", strC6);
                            }
                            if (!TextUtils.isEmpty(ve.this.aw) && (strC5 = com.byazt.vx.c.c(ve.this.aw, com.byazt.vx.tt.c())) != null) {
                                nVarC.put("ex_", strC5);
                            }
                            if (!TextUtils.isEmpty(strVe2) && (strC4 = com.byazt.vx.c.c(strVe2, com.byazt.vx.tt.c())) != null) {
                                nVarC.put("dynamic_policy", strC4);
                            }
                            if (!TextUtils.isEmpty(strUj) && (strC3 = com.byazt.vx.c.c(strUj, com.byazt.vx.tt.c())) != null) {
                                nVarC.put("behavior_policy", strC3);
                            }
                            if (!TextUtils.isEmpty(str) && (strC2 = com.byazt.vx.c.c(str, com.byazt.vx.tt.c())) != null) {
                                nVarC.put("inter_full_refresh_cfg", strC2);
                            }
                            JSONArray jSONArray = jSONArrayOptJSONArray;
                            if (jSONArray == null || jSONArray.length() <= 0) {
                                nVarC.remove("gm_req_sr");
                            } else {
                                String strC11 = com.byazt.vx.c.c(jSONArrayOptJSONArray.toString(), com.byazt.vx.tt.c());
                                if (strC11 != null) {
                                    nVarC.put("gm_req_sr", strC11);
                                }
                            }
                            nVarC.put("is_config_from_assert", z);
                            nVarC.put("has_config_in_sp", true);
                        }
                    });
                    if (z2) {
                        if (com.byazt.sx.ve.ve()) {
                            ttVar = null;
                            z3 = false;
                            veVar = this;
                            jSONObject3 = jSONObject2;
                        }
                        return;
                    }
                    if (!z) {
                        com.byazt.tjo.c.c().ve();
                    }
                    c(false, jSONObject2, (com.byazt.sc.tt) null);
                    return;
                } catch (Throwable th2) {
                    th = th2;
                    ttVar = null;
                    z3 = false;
                    veVar = this;
                    jSONObject3 = jSONObject2;
                    com.byazt.nr.m.c(th);
                    if (z2) {
                        return;
                    } else {
                        return;
                    }
                }
                com.byazt.eu.tt.tt("BehaviorPolicy", "mBehaviorPolicyConfigEnable=" + this.lt);
                strUj = uj(jSONObject.optJSONObject("behavior_policy"));
                JSONObject jSONObjectOptJSONObject7 = jSONObject.optJSONObject("inter_full_refresh_cfg");
                String string = jSONObjectOptJSONObject7 != null ? jSONObjectOptJSONObject7.toString() : null;
                com.byazt.cz.c.c(string);
                com.byazt.qv.uj.c(jSONObject.optJSONObject("csj_code_mapping_conf"));
                jSONArrayOptJSONArray = jSONObject.optJSONArray("gm_req_sr");
                com.byazt.qv.n.c(jSONArrayOptJSONArray);
                tt(jSONObjectOptJSONObject2);
                z4 = false;
                com.byazt.jj.c.c(false);
                str = string;
            } catch (Throwable th3) {
                th = th3;
                jSONObject3 = jSONObject2;
                veVar = this;
                ttVar = null;
                z3 = false;
            }
        } catch (Throwable th4) {
            th = th4;
            z3 = z4;
            jSONObject3 = jSONObject2;
            veVar = this;
            ttVar = null;
        }
        c(i);
        JSONObject jSONObjectOptJSONObject8 = jSONObject.optJSONObject("app_abtest");
        if (jSONObjectOptJSONObject8 != null) {
            x(jSONObjectOptJSONObject8);
            this.yp = jSONObjectOptJSONObject8.toString();
        } else {
            this.yp = "";
        }
        this.kp = jSONObject.optInt("is_trusteeship_monetize");
        this.y = jSONObject.optInt("share_cache_enable");
        this.ve = jSONObject.optString("etag");
        this.uj = jSONObject.optLong("max_age");
        this.n = System.currentTimeMillis() + this.uj;
        this.f28971a = jSONObject.optString("ab_version");
        this.sp = jSONObject.optString("ab_params");
        this.x = jSONObject.optString(ze1.s);
        this.i = jSONObject.optString("transparent_params");
        this.eo = jSONObject.optInt("if_test");
        this.da = jSONObject.optInt("if_get_detail_return");
        this.sl = jSONObject.optString("ecpm_precision_level");
        this.t = jSONObject.optString("fetch_primerit_level");
        strOptString = jSONObject.optString("url");
        this.nu = jSONObject.optInt("innerLog", 0);
        this.rh = jSONObject.optString("app_log_url", "log-api.pangolin-sdk-toutiao.com/service/2/app_log/");
        this.my = jSONObject.optLong("break_request_times", 0L);
        this.gt = jSONObject.optLong("break_request_hold_time", 10000L);
        this.sv = jSONObject.optInt("ex_info", 0);
        this.aw = jSONObject.optString("ex_");
        this.or = jSONObject.optInt("if_enable_label", 0);
        this.c = jSONObject.optInt("ecpm_ttl", 259200000);
        int iOptInt = jSONObject.optInt("support_tnc", Integer.MAX_VALUE);
        this.rl = iOptInt;
        if (iOptInt != 0 && iOptInt != 1) {
            this.rl = 1;
        }
        this.h = jSONObject.optDouble("custom_adn_sample_ratio", AudioStats.AUDIO_AMPLITUDE_NONE);
        int iOptInt2 = jSONObject.optInt("enable_label_return", 0);
        this.ic = iOptInt2;
        if (iOptInt2 != 0 && iOptInt2 != 1) {
            this.ic = 0;
        }
        this.hd = jSONObject.optInt("dynamic_policy_enable", 0);
        com.byazt.eu.tt.tt("DynamicPolicy", "mDynamicPolicyEnable=" + this.hd);
        int i2 = this.hd;
        if (i2 != 0 && i2 != 1) {
            this.hd = 0;
        }
        int i3 = this.lr;
        int i4 = this.l;
        JSONObject jSONObjectOptJSONObject9 = jSONObject.optJSONObject("p_c");
        if (jSONObjectOptJSONObject9 != null) {
            this.lr = jSONObjectOptJSONObject9.optInt("l_p_a", 0);
            this.l = jSONObjectOptJSONObject9.optInt("l_p_r", 0);
        } else {
            this.lr = 0;
            this.l = 0;
        }
        if (i3 != this.lr || i4 != this.l) {
            com.byazt.px.n.c();
        }
        com.byazt.oi.c.c().c(this.my, this.gt);
        this.lo = jSONObject.optInt("enable_bid_result_return", 0);
        this.pu = jSONObject.optInt("enable_bid_result_return_for_baidu", 0);
        this.tk = jSONObject.optInt("enable_bid_result_return_for_ks", 0);
        jSONObjectOptJSONObject = jSONObject.optJSONObject("supervisor_feature");
        if (jSONObjectOptJSONObject != null) {
            com.byazt.vx.yp.c(true);
            com.byazt.vx.yp.c(jSONObjectOptJSONObject);
        } else {
            com.byazt.vx.yp.c(false);
        }
        jSONObjectOptJSONObject2 = jSONObject.optJSONObject("app_common_config");
        com.byazt.ck.tt.c().c(jSONObjectOptJSONObject2);
        com.byazt.ck.ve.c().c(jSONObject.optJSONObject("adn_init_conf"));
        strTt = tt(jSONObject.optJSONArray("adn_control_conf"));
        strVe = ve(jSONObject.optJSONArray("rit_adn_control_conf"));
        strSp = sp(jSONObject.optJSONObject("poor_network_config"));
        com.byazt.ck.uj.c().c(jSONObject.optJSONArray("rit_conf"), z, z2);
        strSl = sl(jSONObject.optJSONObject("module_disable_control"));
        jSONObjectOptJSONObject3 = jSONObject.optJSONObject("call_stack_conf");
        i(jSONObjectOptJSONObject3);
        jSONObjectOptJSONObject4 = jSONObject.optJSONObject("custom_adn_feature");
        da(jSONObjectOptJSONObject4);
        jSONObjectOptJSONObject5 = jSONObject.optJSONObject("timeout_req");
        t(jSONObjectOptJSONObject5);
        jSONObjectOptJSONObject6 = jSONObject.optJSONObject("is_callback");
        u(jSONObjectOptJSONObject6);
        strA = a(jSONObject.optJSONObject("label_outputs"));
        strN = n(jSONObject.optJSONObject("label_group_infos"));
        strC = c(jSONObject.optJSONArray("dynamic_rules"));
        strVe2 = ve(jSONObject.optJSONObject("dynamic_policy"));
        this.lt = jSONObject.optInt("behavior_policy_enable", 0);
    }

    public uj n(String str) {
        return this.qp.get(str);
    }

    public boolean tt(int i) {
        if (!yf()) {
            return false;
        }
        if (i == 1) {
            return gr();
        }
        if (i == 2) {
            return zm();
        }
        if (i == 3) {
            return p();
        }
        if (i == 5) {
            return md() && eo();
        }
        if (i == 10) {
            return yv();
        }
        if (i == 7) {
            return h();
        }
        if (i != 8) {
            return true;
        }
        return d();
    }

    public void ve(int i) {
        this.rl = i;
    }

    @Override // com.byazt.qe.c
    public void c(JSONObject jSONObject, JSONObject jSONObject2, boolean z) {
        if (jSONObject == null) {
            return;
        }
        try {
            JSONObject jSONObjectOptJSONObject = jSONObject.optJSONObject("app_abtest");
            if (jSONObjectOptJSONObject != null) {
                this.z = jSONObjectOptJSONObject.toString();
            } else {
                this.z = "";
            }
            if (!z) {
                com.byazt.eu.n.uj(new Runnable() { // from class: com.zj.adlib.cwb
                    @Override // java.lang.Runnable
                    public final void run() {
                        this.f41057a.g();
                    }
                });
                if (z) {
                    if (com.byazt.sx.ve.ve()) {
                        c(false, jSONObject2, (com.byazt.sc.tt) null);
                    }
                    com.byazt.tjo.c.c().tt();
                    return;
                }
                return;
            }
            if (this.iu.get() >= 3) {
                if (z) {
                    if (com.byazt.sx.ve.ve()) {
                        c(false, jSONObject2, (com.byazt.sc.tt) null);
                    }
                    com.byazt.tjo.c.c().tt();
                    return;
                }
                return;
            }
            this.s = jSONObject;
            c(3);
            com.byazt.ck.ve.c().c(jSONObject.optJSONObject("adn_init_conf"));
            com.byazt.ck.uj.c().c(jSONObject.optJSONArray("rit_conf"), false, true);
            tt(jSONObject.optJSONObject("app_common_config"));
            com.byazt.eu.n.uj(new Runnable() { // from class: com.zj.adlib.dwb
                @Override // java.lang.Runnable
                public final void run() {
                    this.f41297a.ir();
                }
            });
            if (z) {
                if (com.byazt.sx.ve.ve()) {
                    c(false, jSONObject2, (com.byazt.sc.tt) null);
                }
                com.byazt.tjo.c.c().tt();
            }
        } catch (Throwable unused) {
            if (!z) {
            } else {
                if (com.byazt.sx.ve.ve()) {
                }
            }
        }
    }

    private String c(JSONArray jSONArray) {
        if (jSONArray == null || jSONArray.length() == 0) {
            return null;
        }
        for (int i = 0; i < jSONArray.length(); i++) {
            try {
                uj.c(jSONArray.optJSONObject(i), this.qp);
            } catch (Exception e) {
                com.byazt.eu.tt.ve(MediationConstant.TAG, "maybe some rit parse dynamic rules fail .....");
                com.byazt.nr.m.c(e);
            }
        }
        return jSONArray.toString();
    }

    public void c(com.byazt.sc.tt ttVar) {
        this.ma = ttVar;
    }

    public void c(final boolean z, final JSONObject jSONObject, com.byazt.sc.tt ttVar) {
        if (ttVar != null) {
            this.ma = ttVar;
        }
        final boolean zPf = pf();
        if (zPf) {
            a.c(jSONObject, "s-config_done");
        }
        final int iSl = sl();
        com.byazt.px.c.tt().c(com.byazt.bp.tt.getContext(), z, zPf, jSONObject, new com.byazt.sc.tt() { // from class: com.byazt.qe.ve.2
            @Override // com.byazt.sc.tt
            public void c() {
                com.byazt.eu.tt.uj("TTMediationSDK_SDK_Init", "MSDK init finish.........hasConfig:" + zPf);
                if (zPf) {
                    ve.this.gr.set(true);
                    ve.this.f();
                    a.c(jSONObject, "s-end");
                    if (ve.this.ma != null) {
                        ve.this.ma.c();
                    }
                    com.byazt.eu.n.uj(new Runnable() { // from class: com.byazt.qe.ve.2.1
                        @Override // java.lang.Runnable
                        public void run() {
                            if (!ve.this.zm.get()) {
                                ve.this.zm.set(true);
                                int iC = com.byazt.px.c.c();
                                long jElapsedRealtime = SystemClock.elapsedRealtime() - com.byazt.sx.ve.c();
                                a.c(jSONObject, "s-event_end");
                                a.c();
                                HashMap map = new HashMap();
                                map.put("config_use_type", Integer.valueOf(iSl));
                                if (ve.this.j) {
                                    map.put("is_import_cfg", Boolean.valueOf(ve.this.j));
                                }
                                if (com.byazt.sx.uj.c()) {
                                    com.byazt.eu.tt.c("TMe", "-----==---- 正常上报sdk_init_end");
                                    AnonymousClass2 anonymousClass2 = AnonymousClass2.this;
                                    com.byazt.sx.uj.c(jElapsedRealtime, iC, z ? 1 : 0, -1L, jSONObject, map);
                                } else {
                                    com.byazt.eu.tt.c("TMe", "-----==---- 延时上报sdk_init_end");
                                    AnonymousClass2 anonymousClass3 = AnonymousClass2.this;
                                    com.byazt.sx.uj.c(jElapsedRealtime, iC, z ? 1 : 0, jSONObject, map);
                                }
                                com.byazt.bg.c.c();
                                com.byazt.eu.tt.c(MediationConstant.TAG, "sdk init end, duration: " + jElapsedRealtime + ", initAdnCount: " + iC + ", isFromLocalConfig: " + z);
                            }
                            tt.c(com.byazt.bp.tt.tt()).c(new com.byazt.yf.n() { // from class: com.byazt.qe.ve.2.1.1
                                @Override // com.byazt.yf.n
                                public void c(List<String> list) {
                                    com.byazt.eu.tt.c("TMe", "初始化更新pangle配置成功");
                                }
                            });
                        }
                    });
                }
            }
        });
    }

    @Override // com.byazt.qe.c
    public void c(JSONObject jSONObject) {
        if (jSONObject == null || jSONObject.optInt("state_code") != 30004) {
            return;
        }
        n nVarC = com.byazt.rq.c.c();
        this.uj = jSONObject.optLong("max_age");
        long jCurrentTimeMillis = System.currentTimeMillis();
        long j = this.uj;
        this.n = jCurrentTimeMillis + j;
        nVarC.put("max_age", j);
        nVarC.put("max_expire_time", this.n);
    }

    public void c(int i) {
        if (i == 3) {
            if (this.iu.get() == 1) {
                i = 5;
            } else if (this.iu.get() == 2) {
                i = 4;
            }
        }
        if (i < this.iu.get()) {
            return;
        }
        this.iu.set(i);
    }

    @Override // com.byazt.qe.c
    public void c(boolean z, JSONObject jSONObject) {
        JSONObject jSONObjectMd;
        try {
            n nVarC = com.byazt.rq.c.c();
            boolean z2 = nVarC.getBoolean("has_config_in_sp", false);
            if (!z2 && (jSONObjectMd = com.byazt.bp.c.t().md()) != null) {
                this.j = true;
                if (jSONObjectMd.optInt("cypher", -1) == 4) {
                    String strOptString = jSONObjectMd.optString("message");
                    com.byazt.dna.n nVarA = eo.a();
                    String strDecryptWithCBC = nVarA != null ? nVarA.decryptWithCBC(strOptString) : null;
                    if (!TextUtils.isEmpty(strDecryptWithCBC)) {
                        try {
                            jSONObjectMd = new JSONObject(strDecryptWithCBC);
                        } catch (Throwable th) {
                            com.byazt.nr.m.c(th);
                            com.byazt.eu.tt.c(MediationConstant.TAG, ">>>>> setting data error: " + th.toString());
                        }
                    }
                }
                int iOptInt = jSONObjectMd.optInt("state_code");
                String strOptString2 = jSONObjectMd.optString("message");
                if (iOptInt == 20000 && !TextUtils.isEmpty(jSONObjectMd.toString())) {
                    if (jSONObjectMd.optString("app_id").equals(com.byazt.bp.c.t().u())) {
                        com.byazt.eu.tt.tt(MediationConstant.TAG, "本地配置解析成功");
                        c(jSONObjectMd, true, false, jSONObject);
                        if (this.s != null) {
                            c(this.s, jSONObject, true);
                        }
                        com.byazt.vq.c.c().n();
                        com.byazt.bp.c.t().c((JSONObject) null);
                        this.s = null;
                        if (!com.byazt.ck.ve.c().uj()) {
                            c(1);
                        }
                        if (!z) {
                            c(true, (JSONObject) null, (com.byazt.sc.tt) null);
                        }
                        if (!com.byazt.ck.uj.c().ve() || qy.c(com.byazt.bp.tt.getContext())) {
                            return;
                        }
                        com.byazt.vq.c.c().c(-2, "本地没有配置/当前网络不可用");
                        return;
                    }
                    com.byazt.eu.tt.tt(MediationConstant.TAG, "本地配置appid或appkey非法");
                } else {
                    com.byazt.eu.tt.tt(MediationConstant.TAG, " 解密错误或者解析错误：stateCode=" + iOptInt + "，msg=" + strOptString2);
                }
            }
            com.byazt.bp.c.t().c((JSONObject) null);
            this.s = null;
            if (z2) {
                c(nVarC);
            } else {
                ma();
            }
            if (z) {
                com.byazt.jj.c.c(true);
            }
            if (!com.byazt.ck.ve.c().uj()) {
                c(1);
            }
            if (!z) {
                c(true, (JSONObject) null, (com.byazt.sc.tt) null);
            }
            if (!com.byazt.ck.uj.c().ve() || qy.c(com.byazt.bp.tt.getContext())) {
                return;
            }
            com.byazt.vq.c.c().c(-2, "本地没有配置/当前网络不可用");
        } catch (Throwable unused) {
            if (!com.byazt.ck.ve.c().uj()) {
                c(1);
            }
            if (!z) {
                c(true, (JSONObject) null, (com.byazt.sc.tt) null);
            }
            if (!com.byazt.ck.uj.c().ve() || qy.c(com.byazt.bp.tt.getContext())) {
                return;
            }
            com.byazt.vq.c.c().c(-2, "本地没有配置/当前网络不可用");
        }
    }

    private void c(n nVar) throws JSONException {
        this.kp = nVar.getInt("is_trusteeship_monetize", 0);
        this.y = nVar.getInt("share_cache_enable", 0);
        this.ve = nVar.getString("etag", null);
        this.uj = nVar.getLong("max_age", 0L);
        this.n = nVar.getLong("max_expire_time", 0L);
        this.f28971a = nVar.getString("ab_version", "");
        this.sp = nVar.getString("ab_params", "");
        this.x = nVar.getString(ze1.s, "");
        this.i = nVar.getString("transparent_params", "");
        this.eo = nVar.getInt("if_test", 0);
        this.da = nVar.getInt("network_permission", 0);
        this.sl = nVar.getString("ecpm_precision_level", "0");
        this.t = nVar.getString("fetch_primerit_level", "0");
        this.rh = nVar.getString("tt_app_log_url", "log-api.pangolin-sdk-toutiao.com/service/2/app_log/");
        this.my = nVar.getLong("break_request_times", 0L);
        this.gt = nVar.getLong("break_request_hold_time", 10000L);
        this.sv = nVar.getInt("ex_info", 0);
        this.or = nVar.getInt("if_enable_label", 0);
        this.c = nVar.getInt("cpm_expire_time", 259200000);
        this.h = nVar.getFloat("custom_adn_sample_ratio", 0.0f);
        this.ic = nVar.getInt("enable_label_return", 0);
        this.hd = nVar.getInt("dynamic_policy_enable", 0);
        this.lt = nVar.getInt("behavior_policy_enable", 0);
        this.lr = nVar.getInt("limit_p_a", 0);
        this.l = nVar.getInt("limit_p_r", 0);
        this.lo = nVar.getInt("enable_bid_result_return", 0);
        this.pu = nVar.getInt("enable_bid_result_return_for_baidu", 0);
        this.tk = nVar.getInt("enable_bid_result_return_for_ks", 0);
        com.byazt.oi.c.c().c(this.my, this.gt);
        String string = nVar.getString("network_conf", null);
        if (!TextUtils.isEmpty(string)) {
            sp(new JSONObject(string));
        }
        String string2 = nVar.getString("adn_control_conf", null);
        if (!TextUtils.isEmpty(string2)) {
            if (!string2.startsWith("[") && !string2.startsWith(bv9.b)) {
                string2 = com.byazt.vx.c.tt(string2, com.byazt.vx.tt.c());
            }
            tt(new JSONArray(string2));
        }
        String string3 = nVar.getString("rit_adn_control_conf", null);
        if (!TextUtils.isEmpty(string3)) {
            ve(new JSONArray(string3));
        }
        String string4 = nVar.getString("module_control", null);
        if (!TextUtils.isEmpty(string4)) {
            sl(new JSONObject(string4));
        }
        boolean z = nVar.getBoolean("all_active_control", false);
        if (z) {
            this.gu.put("active_control", Boolean.valueOf(z));
        }
        String string5 = nVar.getString("call_stack", null);
        if (!TextUtils.isEmpty(string5)) {
            i(new JSONObject(string5));
        }
        String string6 = nVar.getString("custom_adn_feature", null);
        if (!TextUtils.isEmpty(string6)) {
            da(new JSONObject(string6));
        }
        String string7 = nVar.getString("timeout_req", null);
        if (!TextUtils.isEmpty(string7)) {
            t(new JSONObject(string7));
        }
        String string8 = nVar.getString("is_callback", null);
        if (!TextUtils.isEmpty(string8)) {
            u(new JSONObject(string8));
        }
        String string9 = nVar.getString("key_supervisor_feature", null);
        if (!TextUtils.isEmpty(string9)) {
            com.byazt.vx.yp.c(true);
            com.byazt.vx.yp.c(new JSONObject(string9));
        } else {
            com.byazt.vx.yp.c(false);
        }
        String string10 = nVar.getString("label_outputs", null);
        if (!TextUtils.isEmpty(string10)) {
            if (!string10.startsWith("[") && !string10.startsWith(bv9.b)) {
                string10 = com.byazt.vx.c.tt(string10, com.byazt.vx.tt.c());
            }
            if (!TextUtils.isEmpty(string10)) {
                a(new JSONObject(string10));
            }
        }
        String string11 = nVar.getString("label_group_infos", null);
        if (!TextUtils.isEmpty(string11)) {
            if (!string11.startsWith("[") && !string11.startsWith(bv9.b)) {
                string11 = com.byazt.vx.c.tt(string11, com.byazt.vx.tt.c());
            }
            if (!TextUtils.isEmpty(string11)) {
                n(new JSONObject(string11));
            }
        }
        String string12 = nVar.getString("dynamic_rules", null);
        if (!TextUtils.isEmpty(string12)) {
            if (!string12.startsWith("[") && !string12.startsWith(bv9.b)) {
                string12 = com.byazt.vx.c.tt(string12, com.byazt.vx.tt.c());
            }
            if (!TextUtils.isEmpty(string12)) {
                c(new JSONArray(string12));
            }
        }
        String string13 = nVar.getString("dynamic_policy", null);
        if (!TextUtils.isEmpty(string13)) {
            if (!string13.startsWith("[") && !string13.startsWith(bv9.b)) {
                string13 = com.byazt.vx.c.tt(string13, com.byazt.vx.tt.c());
            }
            if (!TextUtils.isEmpty(string13)) {
                ve(new JSONObject(string13));
            }
        }
        String string14 = nVar.getString("behavior_policy", null);
        if (!TextUtils.isEmpty(string14)) {
            if (!string14.startsWith("[") && !string14.startsWith(bv9.b)) {
                string14 = com.byazt.vx.c.tt(string14, com.byazt.vx.tt.c());
            }
            if (!TextUtils.isEmpty(string14)) {
                uj(new JSONObject(string14));
            }
        }
        String string15 = nVar.getString("inter_full_refresh_cfg", null);
        if (!TextUtils.isEmpty(string15)) {
            String strTt = com.byazt.vx.c.tt(string15, com.byazt.vx.tt.c());
            if (!TextUtils.isEmpty(strTt)) {
                com.byazt.cz.c.c(strTt);
            }
        }
        String string16 = nVar.getString("gm_req_sr", null);
        if (!TextUtils.isEmpty(string16)) {
            String strTt2 = com.byazt.vx.c.tt(string16, com.byazt.vx.tt.c());
            if (!TextUtils.isEmpty(strTt2)) {
                try {
                    com.byazt.qv.n.c(new JSONArray(strTt2));
                } catch (JSONException e) {
                    com.byazt.nr.m.c(e);
                }
            }
        }
        String string17 = nVar.getString("ex_", null);
        if (!TextUtils.isEmpty(string17) && !string17.startsWith("[") && !string17.startsWith(bv9.b)) {
            this.aw = com.byazt.vx.c.tt(string17, com.byazt.vx.tt.c());
        }
        String string18 = nVar.getString("app_simple_abtest", null);
        if (!TextUtils.isEmpty(string18)) {
            this.z = string18;
        }
        if (TextUtils.isEmpty(this.yp)) {
            String string19 = nVar.getString("app_abtest", null);
            if (TextUtils.isEmpty(string19)) {
                return;
            }
            this.yp = string19;
            try {
                x(new JSONObject(this.yp));
            } catch (JSONException e2) {
                com.byazt.nr.m.c(e2);
            }
        }
    }

    @Override // com.byazt.qe.c
    public void c() {
        this.m = pf();
    }

    public List<String> c(List<String> list) {
        if (list != null && list.size() > 0) {
            if (com.byazt.ck.uj.c().ve()) {
                return list;
            }
            ArrayList arrayList = new ArrayList();
            for (String str : list) {
                if (com.byazt.ck.uj.c().c(str, 0, 101) == null) {
                    arrayList.add(str);
                }
            }
            if (arrayList.size() > 0) {
                return arrayList;
            }
        }
        return null;
    }

    public void c(m mVar) {
        if (mVar == null) {
            return;
        }
        if (bx()) {
            mVar.c();
            return;
        }
        synchronized (this.qy) {
            if (!this.qy.contains(mVar)) {
                this.qy.add(mVar);
            }
        }
    }

    public boolean c(long j) {
        return j < ((long) this.c);
    }
}

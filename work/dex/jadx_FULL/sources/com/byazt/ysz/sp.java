package com.byazt.ysz;

import android.os.SystemClock;
import android.text.TextUtils;
import android.util.SparseArray;
import com.ali.auth.third.login.LoginConstants;
import com.alibaba.android.arouter.utils.Consts;
import com.alibaba.ariver.engine.api.bridge.model.RenderCallContext;
import com.alipay.sdk.m.m.b;
import com.aliyun.svideosdk.preview.camera.AliyunRecorderProperty;
import com.aliyun.vod.log.core.AliyunLogCommon;
import com.byazt.aas.gu;
import com.byazt.bv.BaseConstants;
import com.byazt.bzd.u;
import com.byazt.bzd.x;
import com.byazt.eia.i;
import com.byazt.ete.aw;
import com.byazt.ete.ic;
import com.byazt.ete.q;
import com.byazt.ete.sv;
import com.byazt.nr.da;
import com.byazt.nr.m;
import com.byazt.ogz.sl;
import com.byazt.omf.gt;
import com.byazt.omf.p;
import com.byazt.omf.rl;
import com.byazt.ukr.yp;
import com.bytedance.sdk.openadsdk.TTAdConstant;
import com.zj.adlib.xh9;
import java.lang.ref.SoftReference;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.Callable;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.function.Function;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_11_8719cls.dex */
@com.byazt.zqa.c(c = {0, 1, 589, 91})
public class sp extends a {
    public volatile Set<String> da;
    public volatile com.byazt.qya.n<Boolean> my;
    public final AtomicBoolean x = new AtomicBoolean(false);
    public volatile com.byazt.qh.uj sp = null;
    public volatile int i = -5;
    public volatile boolean sl = false;
    public final long t = System.currentTimeMillis();
    public volatile boolean u = false;
    public volatile boolean yp = false;
    public long z = -1;
    public long m = -1;
    public long nu = -1;
    public boolean rh = false;
    public final AtomicInteger gt = new AtomicInteger(0);

    /* JADX INFO: renamed from: com.byazt.ysz.sp$3, reason: invalid class name */
    @com.byazt.zqa.c(c = {0, 1, 589, 596})
    public class AnonymousClass3 implements com.byazt.qya.ve.tt {
        public AnonymousClass3() {
        }

        @Override // com.byazt.qya.ve.tt
        public void c() throws Exception {
            if (sp.this.i != -3) {
                return;
            }
            da.ve().postDelayed(new Runnable() { // from class: com.byazt.ysz.sp.3.1
                @Override // java.lang.Runnable
                public void run() {
                    com.byazt.bwm.n.tt(new com.byazt.bwm.sp("live pl retry") { // from class: com.byazt.ysz.sp.3.1.1
                        @Override // java.lang.Runnable
                        public void run() {
                            if (sp.this.i != -3) {
                                return;
                            }
                            sp.this.x.set(false);
                            sp.this.c();
                        }
                    });
                }
            }, 10000L);
        }
    }

    public sp() {
        if (x.c()) {
            x.uj(new Runnable() { // from class: com.byazt.ysz.sp.1
                @Override // java.lang.Runnable
                public void run() {
                    sp.this.i();
                }
            });
        } else {
            i();
        }
    }

    private void da() {
        if (this.u) {
            m.c(com.byazt.we.ve.TAG, "tryLoad saas hasLoaded");
            return;
        }
        if (t()) {
            this.u = true;
            da.ve().postDelayed(new Runnable() { // from class: com.byazt.ysz.sp.2
                @Override // java.lang.Runnable
                public void run() {
                    com.byazt.bwm.n.tt(new com.byazt.bwm.sp("doInitLive") { // from class: com.byazt.ysz.sp.2.1
                        @Override // java.lang.Runnable
                        public void run() {
                            sp.this.u();
                        }
                    });
                }
            }, sl());
        } else {
            m.c(com.byazt.we.ve.TAG, "tryLoad saas failed mHasSaasMetaClicked = " + this.sl);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void i() {
        yp();
        com.byazt.omf.x.m().c("com.byted.live.lite", ve(u.tt("com.byted.live.lite")), this.n, null);
        if (gt.tt().fb()) {
            da();
            this.z = com.byazt.omf.tt.c().get("live_last_init_time", 0L);
        } else {
            this.i = -4;
            m.tt(com.byazt.we.ve.TAG, "forbiddom init live");
        }
    }

    private Map m() {
        JSONObject jSONObjectVe;
        String strTt;
        Map map = new HashMap();
        map.put("app_name", gt.getContext().getPackageName());
        aw awVarCf = gt.tt().cf();
        if (awVarCf != null) {
            map.put(b.z0, awVarCf.ve());
            map.put("p_secret", awVarCf.uj());
            map.put("g_appid", String.valueOf(awVarCf.tt()));
        }
        map.put(xh9.WEBSITE_PARAMS_CHANNEL, "csj_channel");
        map.put(AliyunLogCommon.LogLevel.DEBUG, Boolean.valueOf(m.ve()));
        map.put("ec_host_appid", "1371");
        HashMap map2 = new HashMap();
        map2.put("device_score", com.byazt.whk.c.c().c("DeviceRate", "bytebench_value", com.byazt.vxy.c.uj()));
        if (!com.byazt.omf.x.m().sp()) {
            map2.put("enable_init_oaid", AliyunRecorderProperty.SURFACE_ROTATION_MODE_FALSE);
        }
        if (!com.byazt.omf.x.m().u()) {
            map2.put("can_use_ip", AliyunRecorderProperty.SURFACE_ROTATION_MODE_FALSE);
        }
        if (!com.byazt.omf.x.m().uj()) {
            map2.put("can_use_sensor", AliyunRecorderProperty.SURFACE_ROTATION_MODE_FALSE);
        }
        if (com.byazt.omf.x.m().i()) {
            String oaid = ((com.byazt.dna.ve) com.byazt.ut.uj.getService("embed_applog")).getOAID(false);
            if (!com.byazt.xo.c.ve() || TextUtils.isEmpty(oaid)) {
                strTt = gu.tt(this.sp);
            } else {
                map2.remove("enable_init_oaid");
                strTt = gu.tt(oaid);
            }
            if (!TextUtils.isEmpty(strTt)) {
                map2.put("oaid_object", strTt);
            }
        }
        com.byazt.ogz.tt ttVarKu = gt.tt().ku();
        if (ttVarKu != null) {
            boolean zC = ttVarKu.c();
            m.c(com.byazt.we.ve.TAG, "INIT_SUB_PROCESS=", Boolean.valueOf(zC));
            map.put("sub_process", Boolean.valueOf(zC));
        }
        map.put("c_control", com.byazt.omf.x.m().nu());
        com.byazt.ogz.tt ttVarKu2 = gt.tt().ku();
        if (ttVarKu2 == null || (jSONObjectVe = ttVarKu2.ve()) == null) {
            c(map, map2);
        } else {
            Iterator<String> itKeys = jSONObjectVe.keys();
            while (itKeys.hasNext()) {
                String next = itKeys.next();
                map2.put(next, String.valueOf(jSONObjectVe.opt(next)));
            }
            map.put("live_tob_init_extra", map2);
        }
        return map;
    }

    private void my() {
        if (com.byazt.ogz.da.uj() && this.my != null) {
            this.my.ve();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void nu() {
        Object objTt = tt("getLiveSdkConfig");
        if (objTt == null || !(objTt instanceof JSONObject)) {
            return;
        }
        this.ve = (JSONObject) objTt;
    }

    private void rh() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.putOpt("init_max_count", Integer.valueOf(com.byazt.ogz.da.tt()));
            jSONObject.put("uuid", com.byazt.by.c.ve());
            jSONObject.putOpt("has_install", Boolean.valueOf(this.rh));
            jSONObject.put("retry_count", this.gt.get());
            jSONObject.putOpt("live_plugin_version", this.n);
        } catch (JSONException unused) {
        }
        yp.c().n(jSONObject);
    }

    private long sl() {
        com.byazt.ogz.tt ttVarKu = gt.tt().ku();
        long jTt = com.byazt.ogz.uj.c;
        if (ttVarKu != null) {
            jTt = ttVarKu.tt();
        }
        if (System.currentTimeMillis() - this.t > jTt) {
            return 0L;
        }
        return jTt;
    }

    private boolean t() {
        if (com.byazt.omf.x.m().i() && this.sp == null) {
            return false;
        }
        com.byazt.ogz.tt ttVarKu = gt.tt().ku();
        if (ttVarKu != null) {
            if (ttVarKu.n()) {
                return this.sl;
            }
            return true;
        }
        if (com.byazt.ogz.uj.tt) {
            return this.sl;
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void u() {
        Object objApply;
        m.c(com.byazt.we.ve.TAG, "doInitLive");
        this.nu = SystemClock.elapsedRealtime();
        if (this.c == null) {
            this.c = com.byazt.omf.x.m().a(2);
        }
        boolean zBooleanValue = false;
        if (this.c != null) {
            this.c.apply(com.byazt.yxi.uj.c().c(9).c(Void.class).c(0, new com.byazt.cn.c(this)).tt());
        } else {
            m.tt(com.byazt.we.ve.TAG, "No bridge for live");
        }
        Function<SparseArray<Object>, Object> functionLt = com.byazt.omf.x.m().lt();
        if (functionLt != null && (objApply = functionLt.apply(com.byazt.yxi.uj.c().c(6).c(Boolean.class).c(0, "com.byted.live.lite").tt())) != null) {
            zBooleanValue = ((Boolean) objApply).booleanValue();
        }
        if (zBooleanValue && this.i != 2) {
            this.i = 1;
        }
        com.byazt.zlb.ve.ve(21, tt() > 0 ? "1" : "0");
        com.byazt.zlb.ve.ve(20, tt() != 2 ? "0" : "1");
    }

    private void yp() {
        Function<SparseArray<Object>, Object> functionLt = com.byazt.omf.x.m().lt();
        if (functionLt == null) {
            return;
        }
        a_((String) c(functionLt, 8, String.class));
    }

    private boolean z() {
        try {
            if (p.uj >= 7000) {
                int iVe = Integer.parseInt(this.n.replaceAll("\\.", ""));
                if (iVe == 0) {
                    iVe = u.ve("com.byted.live.lite");
                }
                if (iVe <= 211413) {
                    return false;
                }
            }
        } catch (Exception unused) {
        }
        sl slVarTt = gt.tt();
        aw awVarCf = slVarTt.cf();
        int iTt = com.byazt.omf.x.m().zm().tt();
        return (awVarCf == null || !awVarCf.n() || !slVarTt.fb() || iTt == 4 || iTt == 5) ? false : true;
    }

    @Override // com.byazt.ysz.uj
    public boolean a() {
        return this.i == 2;
    }

    @Override // com.byazt.ysz.uj
    public JSONObject x() {
        return this.ve;
    }

    private String ve(int i) {
        char[] charArray = String.valueOf(i).toCharArray();
        StringBuilder sb = new StringBuilder();
        for (int i2 = 0; i2 < charArray.length; i2++) {
            sb.append(charArray[i2]);
            if (i2 < charArray.length - 1) {
                sb.append(Consts.DOT);
            }
        }
        return sb.toString();
    }

    @Override // com.byazt.ysz.uj
    public int n() {
        Object objTt;
        return (this.c == null || !a() || (objTt = tt("hasAuthenticated")) == null || !(objTt instanceof Boolean)) ? false : ((Boolean) objTt).booleanValue() ? 2 : 1;
    }

    @Override // com.byazt.ysz.uj
    public int tt() {
        return this.i;
    }

    @Override // com.byazt.ysz.uj
    public void uj() {
        if (this.c == null || !a()) {
            return;
        }
        tt("warmingUpBeforeEnter");
    }

    private <T> T c(Function<SparseArray<Object>, Object> function, int i, Class<T> cls) {
        T t = (T) function.apply(com.byazt.yxi.uj.c().c(i).c((Class<?>) cls).c(0, "com.byted.live.lite").tt());
        if (t != null) {
            return t;
        }
        return null;
    }

    private Object tt(String str) {
        if (this.i != 2) {
            m.tt(com.byazt.we.ve.TAG, "callSimpleExpandMethod " + str + " failed for plugin state = " + this.i);
            return null;
        }
        HashMap map = new HashMap();
        map.put("expand_method_name", str);
        if (this.c != null) {
            return this.c.apply(com.byazt.yxi.uj.c().c(7).c(Void.class).c(0, map).tt());
        }
        return null;
    }

    private boolean uj(String str) {
        if (str.startsWith("csj_saas")) {
            return true;
        }
        if (this.da == null) {
            this.da = new HashSet(11);
            this.da.add("saas_easyplayable");
            this.da.add("real_auth_status");
            this.da.add("live_panel");
            this.da.add("live_exit");
            this.da.add("mnpl_user_close");
            this.da.add("clickarea");
            this.da.add("enterSection");
            this.da.add("mini_playable_real_show");
            this.da.add("mnpl_user_close");
            this.da.add("mnpl_sdk_lifecycle_status");
        }
        return this.da.contains(str);
    }

    @Override // com.byazt.ysz.c, com.byazt.ysz.uj
    public void c() {
        if (com.byazt.ogz.da.uj() && this.x.get()) {
            if (this.i != -3) {
                return;
            }
        } else if (this.x.get()) {
            m.tt(com.byazt.we.ve.TAG, "already init!");
            return;
        }
        if (com.byazt.ogz.da.uj()) {
            if (!this.yp) {
                m.tt(com.byazt.we.ve.TAG, "plugin not Load! " + this.i);
                return;
            }
        } else if (this.i != 5) {
            m.tt(com.byazt.we.ve.TAG, "plugin not Load! " + this.i);
            return;
        }
        if (this.i == 2) {
            m.tt(com.byazt.we.ve.TAG, "init started or successed:" + this.i);
            return;
        }
        if (!z()) {
            m.tt(com.byazt.we.ve.TAG, "init live failed！ not valid env！");
            return;
        }
        if (!com.byazt.wu.tt.ve(this.n)) {
            com.byazt.wu.tt.uj(this.n);
            return;
        }
        this.rh = u.x("com.byted.live.lite");
        this.m = SystemClock.elapsedRealtime();
        this.x.set(true);
        com.byazt.wu.tt.c(this.n);
        this.i = 4;
        if (this.c != null) {
            m.c(com.byazt.we.ve.TAG, "liveSDkBridge init invoke 5500");
            this.c.apply(com.byazt.yxi.uj.c().c(5).c(Void.class).c(0, m()).tt());
            this.gt.incrementAndGet();
            rh();
        }
        com.byazt.wu.tt.tt(this.n);
    }

    private void ve(String str) {
        if (com.byazt.ogz.da.uj() && !TextUtils.isEmpty(str)) {
            if (str.contains("UnknownHostException") || str.contains("SocketException")) {
                if (((com.byazt.dna.u) com.byazt.ut.uj.getService("device_info_new")).getRealNetworkType(0L) == 0) {
                    com.byazt.qya.ve.c().c(new AnonymousClass3());
                } else if (this.my == null) {
                    this.my = new com.byazt.qya.n.c(new Callable<Boolean>() { // from class: com.byazt.ysz.sp.4
                        /* JADX WARN: Can't rename method to resolve collision */
                        @Override // java.util.concurrent.Callable
                        public Boolean call() throws Exception {
                            com.byazt.bwm.n.tt(new com.byazt.bwm.sp("live pl retry") { // from class: com.byazt.ysz.sp.4.1
                                @Override // java.lang.Runnable
                                public void run() {
                                    sp.this.x.set(false);
                                    sp.this.c();
                                }
                            });
                            return Boolean.FALSE;
                        }
                    }).c(10000L).c(com.byazt.ogz.da.tt()).c();
                    this.my.tt();
                }
            }
        }
    }

    private JSONObject tt(int i, String str) {
        sv svVarSl;
        JSONArray jSONArrayX;
        if (this.f29213a != null && this.f29213a.get() != null) {
            ic icVar = this.f29213a.get();
            if (TextUtils.equals(icVar.rl(), str) && (svVarSl = icVar.sl()) != null && (jSONArrayX = svVarSl.x()) != null && jSONArrayX.length() != 0) {
                int length = jSONArrayX.length();
                for (int i2 = 0; i2 < length; i2++) {
                    JSONObject jSONObjectOptJSONObject = jSONArrayX.optJSONObject(i2);
                    if (jSONObjectOptJSONObject.optInt("type") == i) {
                        return jSONObjectOptJSONObject;
                    }
                }
            }
        }
        return null;
    }

    private boolean uj(i iVar) {
        JSONObject jSONObjectQ_ = iVar.q_();
        if (jSONObjectQ_ == null) {
            return false;
        }
        if (jSONObjectQ_.optInt("landing_type", 0) != 4 && TextUtils.isEmpty(iVar.da())) {
            return com.byazt.wu.c.c(iVar);
        }
        return true;
    }

    @Override // com.byazt.ysz.c, com.byazt.ysz.uj
    public void ve(i iVar) {
        if (iVar == null || this.sl || !uj(iVar)) {
            return;
        }
        this.sl = true;
        i();
    }

    public void tt(Map<String, String> map) {
        com.byazt.ocd.tt ttVar;
        if (map == null || map.size() == 0) {
            return;
        }
        String str = map.get("type");
        String str2 = map.get("status");
        String str3 = map.get("open_uid");
        String str4 = map.get("task_key");
        if ("1".equals(str2) && !TextUtils.isEmpty(str)) {
            try {
                JSONObject jSONObjectOptJSONObject = tt(Integer.parseInt(str), str4).optJSONObject("extra");
                if (jSONObjectOptJSONObject == null) {
                    return;
                }
                String strOptString = jSONObjectOptJSONObject.optString(RenderCallContext.TYPE_CALLBACK);
                if (TextUtils.isEmpty(strOptString)) {
                    return;
                }
                JSONObject jSONObject = new JSONObject(strOptString);
                if (TextUtils.isEmpty(jSONObject.optString("name")) || (ttVar = (com.byazt.ocd.tt) rl.c(this.uj, com.byazt.ocd.tt.class)) == null) {
                    return;
                }
                HashMap map2 = new HashMap();
                map2.put("open_uid", str3);
                Iterator<String> itKeys = jSONObject.keys();
                while (itKeys.hasNext()) {
                    String next = itKeys.next();
                    map2.put(next, jSONObject.opt(next));
                }
                ttVar.c(3, map2);
                return;
            } catch (Exception e) {
                m.tt(com.byazt.we.ve.TAG, "onTaskFinish parse extra error", e);
                return;
            }
        }
        m.tt(com.byazt.we.ve.TAG, "onTaskFinish status is :" + str2);
    }

    public void ve(Map<String, String> map) {
        com.byazt.ocd.tt ttVar = (com.byazt.ocd.tt) rl.c(this.uj, com.byazt.ocd.tt.class);
        if (ttVar == null) {
            return;
        }
        ttVar.c(4, map);
    }

    @Override // com.byazt.ysz.c, com.byazt.ysz.uj
    public long ve() {
        return this.z;
    }

    private void c(Map map, Map<String, Object> map2) {
        map2.put("allow_apm_init", com.byazt.ogz.uj.ve);
        map2.put("allow_npth_init", com.byazt.ogz.uj.uj);
        map2.put("allow_vlog_init", com.byazt.ogz.uj.n);
        map2.put("sec_init_use_thread", com.byazt.ogz.uj.f28868a);
        map.put("live_tob_init_extra", map2);
    }

    public void c(int i, String str, boolean z, boolean z2) {
        int i2 = this.i;
        this.i = i;
        if (i == -3) {
            if (!z && this.i != i2) {
                c(str, z2, false);
            }
            ve(str);
            return;
        }
        if (i == 5) {
            this.yp = true;
            return;
        }
        if (i == 1) {
            com.byazt.zlb.ve.ve(21, "1");
            return;
        }
        if (i != 2) {
            return;
        }
        my();
        this.z = SystemClock.elapsedRealtime();
        if (!z && this.i != i2) {
            c(str, z2, true);
        }
        com.byazt.zlb.ve.ve(21, "1");
        com.byazt.zlb.ve.ve(20, "1");
        yp();
        nu();
        com.byazt.omf.tt.c().put("live_last_init_time", this.z);
    }

    private void c(String str, boolean z, boolean z2) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.putOpt("msg", str);
            jSONObject.putOpt("has_install", Boolean.valueOf(this.rh));
            jSONObject.putOpt("fake_init", Boolean.valueOf(z));
            long jElapsedRealtime = SystemClock.elapsedRealtime();
            jSONObject.putOpt("init_cost", Long.valueOf(jElapsedRealtime - this.m));
            jSONObject.putOpt("cost", Long.valueOf(jElapsedRealtime - this.nu));
            jSONObject.putOpt("success", Boolean.valueOf(z2));
            jSONObject.putOpt("init_max_count", Integer.valueOf(com.byazt.ogz.da.tt()));
            jSONObject.put("uuid", com.byazt.by.c.ve());
            jSONObject.put("retry_count", this.gt.get());
            jSONObject.putOpt("live_plugin_version", this.n);
        } catch (JSONException unused) {
        }
        yp.c().uj(jSONObject);
    }

    public void c(boolean z, String str) {
        String str2;
        com.byazt.ocd.tt ttVar;
        x.c(new com.byazt.bwm.sp("getLiveSdk") { // from class: com.byazt.ysz.sp.5
            @Override // java.lang.Runnable
            public void run() {
                sp.this.nu();
            }
        });
        if (this.f29213a != null && this.f29213a.get() != null) {
            com.byazt.ddx.uj.c(z ? 2 : 1, this.tt != null ? this.tt : "", this.f29213a.get());
        }
        if (!z || (str2 = this.uj) == null || (ttVar = (com.byazt.ocd.tt) rl.c(str2, com.byazt.ocd.tt.class)) == null) {
            return;
        }
        HashMap map = new HashMap();
        map.put("open_uid", str);
        ttVar.c(1, map);
        c(10002, this.uj);
    }

    private JSONObject c(int i, String str) {
        JSONObject jSONObjectTt = tt(i, str);
        if (jSONObjectTt != null) {
            try {
                jSONObjectTt.putOpt("status", 1);
            } catch (JSONException unused) {
            }
            ic icVar = this.f29213a.get();
            if (icVar != null) {
                com.byazt.fri.c.c(str, icVar.uj() + LoginConstants.UNDER_LINE + i);
            }
        }
        return jSONObjectTt;
    }

    public void c(Map<String, String> map) {
        String str = map.get("label");
        final String str2 = map.get("req_id");
        if (TextUtils.isEmpty(str)) {
            return;
        }
        if (!uj(str)) {
            m.tt(com.byazt.we.ve.TAG, "not valid label " + str);
            return;
        }
        ic icVar = this.f29213a != null ? this.f29213a.get() : null;
        final String str3 = map.get(BaseConstants.EVENT_LABEL_AD_EXTRA_DATA);
        com.byazt.ya.c cVar = new com.byazt.ya.c() { // from class: com.byazt.ysz.sp.6
            @Override // com.byazt.ya.c
            public void onSend(JSONObject jSONObject) throws JSONException {
                if (TextUtils.isEmpty(str3)) {
                    return;
                }
                JSONObject jSONObject2 = new JSONObject(str3);
                jSONObject2.put("req_id", str2);
                jSONObject.put(BaseConstants.EVENT_LABEL_AD_EXTRA_DATA, jSONObject2);
            }
        };
        if (icVar != null) {
            com.byazt.ddx.uj.c(icVar, this.tt, str, cVar);
            String strQy = icVar.qy();
            if (TextUtils.equals(strQy, str2)) {
                return;
            }
            c(str2, str, "mate req is " + strQy);
            return;
        }
        new com.byazt.ddx.c.C0382c().c(this.tt).tt(str).c(cVar);
        c(str2, str, TTAdConstant.MATE_IS_NULL_MSG);
    }

    private void c(String str, String str2, String str3) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.putOpt("req_id", str);
            jSONObject.putOpt("label", str2);
            jSONObject.putOpt("mesage", str3);
        } catch (JSONException unused) {
        }
        yp.c().c("reportPangleEvent", jSONObject, (Throwable) null);
    }

    @Override // com.byazt.ysz.a, com.byazt.ysz.uj
    public int c(final i iVar, final ve veVar, final String str, final Map<String, Object> map) {
        String str2;
        if (iVar == null) {
            return 0;
        }
        final String strT_ = iVar.t_();
        if (TextUtils.isEmpty(strT_)) {
            return 0;
        }
        if (this.i != 2) {
            return -1;
        }
        this.tt = str;
        this.f29213a = new SoftReference<>(com.byazt.ppf.ve.c(iVar, map));
        q qVarC_ = iVar.C_();
        if (2 == n() || qVarC_ == null) {
            str2 = strT_;
        } else {
            boolean z = qVarC_.uj() == 1;
            final AtomicBoolean atomicBoolean = new AtomicBoolean(false);
            final long jCurrentTimeMillis = System.currentTimeMillis();
            final boolean z2 = z;
            if (c(iVar, new a.c() { // from class: com.byazt.ysz.sp.7
                @Override // com.byazt.ysz.a.c
                public void c(boolean z3) {
                    boolean z4;
                    if (atomicBoolean.compareAndSet(false, true)) {
                        sp.this.c(iVar, veVar, strT_, z3, z2, str, 1, map);
                        z4 = false;
                    } else {
                        z4 = true;
                    }
                    yp.c().c(com.byazt.ppf.ve.c(iVar, (Map<String, Object>) map), System.currentTimeMillis() - jCurrentTimeMillis, z3, z4);
                }
            }, true, map)) {
                long jN = qVarC_.n();
                if (jN > 0) {
                    final boolean z3 = z;
                    da.tt().postDelayed(new Runnable() { // from class: com.byazt.ysz.sp.8
                        @Override // java.lang.Runnable
                        public void run() {
                            if (atomicBoolean.compareAndSet(false, true)) {
                                sp.this.c(iVar, veVar, strT_, false, z3, str, 2, map);
                            }
                        }
                    }, jN);
                }
                return 2;
            }
            str2 = strT_;
        }
        int iC = c(str2);
        c(iC, iVar, false, 0);
        return iC;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(i iVar, ve veVar, String str, boolean z, boolean z2, String str2, int i, Map<String, Object> map) {
        int iC = c(str);
        m.c(com.byazt.we.ve.TAG, "auth result:" + z + ", schema handle:" + iC);
        c(iC, iVar, z, i);
        if (iC != 1) {
            if (veVar != null) {
                veVar.c(iC);
            }
        } else {
            if (z || !z2) {
                return;
            }
            new com.byazt.glq.c().c(str2).c(gt.getContext(), map, iVar);
        }
    }

    private void c(int i, i iVar, boolean z, int i2) {
        if (iVar == null) {
            return;
        }
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.putOpt("handle_result", Integer.valueOf(i));
            jSONObject.put("req_id", iVar.qy());
            jSONObject.put("auth", z);
            q qVarC_ = iVar.C_();
            if (qVarC_ != null) {
                jSONObject.put("saas_info", qVarC_.c());
            }
            jSONObject.put("status", i2);
            jSONObject.put(LoginConstants.EXT, iVar.w_());
            jSONObject.put("ec_scheme", iVar.t_());
        } catch (Exception unused) {
        }
        yp.c().tt(jSONObject);
    }

    @Override // com.byazt.ysz.uj
    public void c(com.byazt.qh.uj ujVar) {
        this.sp = ujVar;
        i();
    }
}

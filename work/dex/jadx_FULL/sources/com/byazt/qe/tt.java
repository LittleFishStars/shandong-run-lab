package com.byazt.qe;

import android.annotation.SuppressLint;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Build;
import android.os.Looper;
import android.os.Message;
import android.os.SystemClock;
import android.text.TextUtils;
import android.util.SparseArray;
import com.ali.auth.third.login.LoginConstants;
import com.alibaba.ariver.engine.api.bridge.model.NativeCallContext;
import com.alibaba.baichuan.trade.common.constants.AlibcCommonConstant;
import com.alibaba.sdk.android.oss.common.OSSConstants;
import com.byazt.aas.DeviceUtils;
import com.byazt.aas.my;
import com.byazt.aas.nb;
import com.byazt.dna.qp;
import com.byazt.dna.u;
import com.byazt.nr.d;
import com.byazt.nr.m;
import com.byazt.nys.PluginConstants;
import com.byazt.omf.x;
import com.byazt.sx.uj;
import com.byazt.vx.a;
import com.byazt.vx.eo;
import com.byazt.vx.gr;
import com.byazt.vx.gt;
import com.byazt.vx.qy;
import com.byazt.vx.yv;
import com.byazt.yf.n;
import com.bykv.vk.component.ttvideo.player.MediaFormat;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import com.bykv.vk.openvk.api.proto.PluginValueSet;
import com.bytedance.sdk.openadsdk.mediation.MediationConstant;
import com.kc.aw.lib.constants.PtgRewardConstant;
import com.kc.openset.constant.DeviceIdType;
import com.kuaishou.weapon.p0.t;
import com.zj.adlib.xh9;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_11_8719cls.dex */
@com.byazt.zqa.c(c = {0, 1, 697, 13})
public class tt implements qp.c {
    public static volatile boolean c = false;
    public static boolean da = true;

    @SuppressLint({"StaticFieldLeak"})
    public static volatile tt uj;
    public final com.byazt.qe.c tt;
    public final Context ve;
    public final d x;
    public final AtomicInteger n = new AtomicInteger(0);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final AtomicBoolean f28969a = new AtomicBoolean(false);
    public final AtomicBoolean sp = new AtomicBoolean(false);
    public final AtomicBoolean i = new AtomicBoolean(false);
    public int sl = -1;

    @com.byazt.zqa.c(c = {0, 1, 697, MediaPlayer.MEDIA_PLAYER_OPTION_JX_CODEC_LOW_LATENCY})
    public class c implements Runnable {
        public final n tt;
        public final JSONObject uj;
        public int ve;

        public c(n nVar, int i, JSONObject jSONObject) {
            this.tt = nVar;
            this.ve = i;
            this.uj = jSONObject;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (!qy.c(tt.this.ve)) {
                tt.this.tt.c(false, null);
                return;
            }
            tt.this.f28969a.set(true);
            boolean zPf = com.byazt.bp.tt.tt().pf();
            if (!tt.c) {
                boolean unused = tt.c = true;
                uj.c(zPf);
            }
            if (com.byazt.jj.tt.c()) {
                return;
            }
            tt.this.c(zPf, this.tt, this.ve, this.uj);
        }
    }

    /* JADX INFO: renamed from: com.byazt.qe.tt$tt, reason: collision with other inner class name */
    @com.byazt.zqa.c(c = {0, 1, 697, 240})
    public class C0509tt extends BroadcastReceiver {
        private C0509tt() {
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            if (intent == null || x.m().d()) {
                return;
            }
            com.byazt.eu.tt.c("SdkSettingsHelper", "--==-- settings receiver");
            if (intent.getIntExtra("b_msg_id", -1) == 1) {
                if (TextUtils.equals(intent.getStringExtra("b_msg_process_name"), gr.tt(tt.this.ve))) {
                    com.byazt.eu.tt.c("SdkSettingsHelper", "--==-- settings receiver, same process, return");
                } else if (tt.this.tt != null) {
                    com.byazt.eu.tt.c("SdkSettingsHelper", "--==-- settings receiver loadData");
                    tt.this.tt.c(false, null);
                    com.byazt.ck.uj.c().tt();
                    com.byazt.eu.tt.c("SdkSettingsHelper", "--==-- settings receiver loadData end");
                }
            }
        }
    }

    public interface ve {
        public static final String c = eo.c() + ".openadsdk.permission.TT_PANGOLIN";
    }

    private tt(com.byazt.qe.c cVar) {
        this.tt = cVar == null ? com.byazt.bp.tt.tt() : cVar;
        Context context = com.byazt.bp.tt.getContext();
        this.ve = context;
        this.x = new d(Looper.getMainLooper(), this);
        if (com.byazt.bp.c.t().yp()) {
            try {
                context.registerReceiver(new C0509tt(), new IntentFilter("com.bytedance.msdk.core.setting.SettingsReceiver"), ve.c, null);
            } catch (Throwable th) {
                m.c(th);
            }
        }
    }

    private JSONObject a() {
        JSONObject jSONObject = new JSONObject();
        List<String> listSp = sp();
        if (listSp != null) {
            for (String str : listSp) {
                com.byazt.ly.uj ujVarC = com.byazt.px.tt.c().c(str);
                if (ujVarC != null) {
                    try {
                        jSONObject.put(str, ujVarC.getNetworkSdkVersion());
                    } catch (JSONException e) {
                        m.c(e);
                    }
                }
            }
        }
        return jSONObject;
    }

    private boolean n() {
        long j = com.byazt.rq.c.c().getLong("max_expire_time", 0L);
        if (this.sp.get() && System.currentTimeMillis() > j) {
            com.byazt.eu.tt.tt("SdkSettingsHelper", "setting 缓存过期，再次发起请求...");
            this.sp.set(false);
            c();
        }
        return System.currentTimeMillis() > j;
    }

    private static List<String> sp() {
        ArrayList arrayList = new ArrayList();
        arrayList.add(MediationConstant.ADN_PANGLE);
        arrayList.add("gdt");
        arrayList.add(MediationConstant.ADN_UNITY);
        arrayList.add("baidu");
        arrayList.add("sigmob");
        arrayList.add(MediationConstant.ADN_MINTEGRAL);
        arrayList.add(MediationConstant.ADN_KS);
        arrayList.add(MediationConstant.ADN_KLEVIN);
        arrayList.add("xiaomi");
        return arrayList;
    }

    private static void x() {
        if (x.m().d() || com.byazt.bp.tt.getContext() == null) {
            return;
        }
        Intent intent = new Intent();
        intent.setPackage(eo.c());
        intent.setAction("com.bytedance.msdk.core.setting.SettingsReceiver");
        intent.putExtra("b_msg_id", 1);
        intent.putExtra("b_msg_process_name", gr.tt(com.byazt.bp.tt.getContext()));
        com.byazt.bp.tt.getContext().sendBroadcast(intent, ve.c);
    }

    @Override // com.byazt.dna.qp.c
    public void handleMsg(Message message) {
        if (message.what != 1) {
            return;
        }
        int i = message.arg1;
        int i2 = message.arg2;
        if (i == 3) {
            this.i.set(false);
        }
        com.byazt.eu.tt.uj("SdkSettingsHelper", "setting 发起尝试拉取配置请求... mLoadingSuccess:" + this.sp.get() + "tryCount:" + (i + 1));
        try {
            if (this.sp.get()) {
                return;
            }
            Object obj = message.obj;
            tt(i2, obj instanceof JSONObject ? (JSONObject) obj : null);
        } catch (Throwable unused) {
        }
    }

    private String ve(JSONObject jSONObject) {
        JSONObject jSONObjectC = eo.c(jSONObject);
        if (jSONObjectC != null) {
            return jSONObjectC.toString();
        }
        return null;
    }

    public void tt(int i, JSONObject jSONObject) {
        ((com.byazt.dna.ve) com.byazt.ut.uj.getService("embed_applog")).getDid();
        try {
            if (!n()) {
                com.byazt.eu.tt.tt("SdkSettingsHelper", "setting 缓存未过期，无需再次发起请求...");
            } else if (this.f28969a.get()) {
                com.byazt.eu.tt.tt("SdkSettingsHelper", "setting 正在加载，无需再次发起请求...");
            } else {
                com.byazt.eu.n.uj(new c(null, i, jSONObject));
            }
        } catch (Throwable th) {
            com.byazt.eu.tt.c("SdkSettingsHelper", "load sdk settings error: ", th);
        }
    }

    public static tt c(com.byazt.qe.c cVar) {
        if (uj == null) {
            synchronized (tt.class) {
                if (uj == null) {
                    uj = new tt(cVar);
                }
            }
        }
        return uj;
    }

    private JSONObject tt(JSONObject jSONObject) {
        JSONObject jSONObject2 = new JSONObject();
        try {
            jSONObject2.put("ts", System.currentTimeMillis());
            jSONObject2.put("media_sdk_version", com.byazt.yl.tt.tt());
            jSONObject2.put(PluginConstants.KEY_PLUGIN_VERSION, com.byazt.yl.tt.uj());
            jSONObject2.put("is_fusion", 1);
            jSONObject2.put("app_id", com.byazt.bp.c.t().u());
            jSONObject2.put("package_name", eo.c());
            jSONObject2.put(AlibcCommonConstant.APP_VERSION, eo.ve());
            u uVar = (u) com.byazt.ut.uj.getService("device_info_new");
            com.byazt.dna.ve veVar = (com.byazt.dna.ve) com.byazt.ut.uj.getService("embed_applog");
            JSONObject jSONObject3 = new JSONObject();
            jSONObject3.put("android_id", DeviceUtils.tt());
            String strC = DeviceUtils.c((Boolean) null);
            jSONObject3.put(DeviceIdType.IMEI, strC);
            jSONObject3.put("imei_md5", gt.c(strC));
            jSONObject3.put(DeviceIdType.OAID, veVar.getOAID(false));
            jSONObject3.put("applog_did", veVar.getDid());
            jSONObject3.put("publisher_did", com.byazt.bp.c.t().rh());
            jSONObject3.put("conn_type", com.byazt.aas.qy.c());
            jSONObject3.put("os", uVar.getOs());
            jSONObject3.put("os_version", uVar.getOsVersion());
            jSONObject3.put("vendor", uVar.getVendor());
            jSONObject3.put("device_model", uVar.getDeviceModel());
            jSONObject3.put("mcc", uVar.getMcc());
            jSONObject3.put("mnc", uVar.getMnc());
            jSONObject3.put("time_zone", uVar.getTimeZone());
            jSONObject3.put(LoginConstants.IP, my.c());
            jSONObject3.put("locale_language", uVar.getLocalLanguage());
            jSONObject3.put("total_space", String.valueOf(nb.nu()));
            jSONObject3.put("carrier_name", uVar.getCarrierName());
            jSONObject3.put("device_name", uVar.getDeviceName());
            jSONObject3.put("pb", "");
            jSONObject3.put("boot", uVar.getBoot());
            jSONObject3.put("country_code", com.byazt.bp.tt.tt().t());
            jSONObject3.put("total_mem", nb.t());
            jSONObject3.put("device_type", uVar.getDeviceModel());
            jSONObject3.put(MediaFormat.KEY_LANGUAGE, uVar.getLanguage());
            jSONObject3.put("android_os_version_int", Build.VERSION.SDK_INT);
            jSONObject2.put("device", jSONObject3);
            JSONObject jSONObject4 = new JSONObject();
            jSONObject4.put("init_time", com.byazt.bp.c.t().ve());
            jSONObject2.put(NativeCallContext.DOMAIN_APP, jSONObject4);
            jSONObject2.put("grouping_params", c(com.byazt.bp.c.t().rl()));
            JSONObject jSONObjectTt = tt(com.byazt.bp.c.t().rl());
            if (jSONObjectTt != null) {
                jSONObject2.put("user_defined_grouping_params", jSONObjectTt);
            }
            if (!com.byazt.bp.c.t().sp()) {
                jSONObject2.put("etag", com.byazt.bp.tt.tt().yp());
            }
            com.byazt.vx.n nVarC = a.c(this.ve);
            if (nVarC != null) {
                jSONObject2.put("latitude", nVarC.c);
                jSONObject2.put("longitude", nVarC.tt);
            }
            jSONObject2.put("adn_version_list", a());
            com.byazt.psp.n.uj().c(jSONObject2, jSONObject);
            com.byazt.psp.n.uj().c(jSONObject2);
            List<String> listYv = com.byazt.bp.c.t().yv();
            if (listYv != null && listYv.size() > 0) {
                JSONArray jSONArray = new JSONArray();
                Iterator<String> it = listYv.iterator();
                while (it.hasNext()) {
                    jSONArray.put(it.next());
                }
                jSONObject2.put("primerit_list", jSONArray);
            }
            if (!com.byazt.vx.u.c()) {
                JSONObject jSONObject5 = new JSONObject();
                jSONObject5.put("err_type", 1);
                jSONObject5.put("err_msg", "applog so加载失败");
                jSONObject2.put("monitor_alarm", jSONObject5);
            }
        } catch (Exception e) {
            m.c(e);
        }
        return jSONObject2;
    }

    public tt c() {
        com.byazt.eu.tt.uj("SdkSettingsHelper", "setting resetRetryCount...");
        this.n.set(0);
        this.i.set(false);
        d dVar = this.x;
        if (dVar != null) {
            dVar.removeCallbacksAndMessages(null);
        }
        return this;
    }

    public void c(int i, JSONObject jSONObject) {
        try {
            if (this.f28969a.get()) {
                this.sl = i;
                com.byazt.eu.tt.tt("SdkSettingsHelper", "setting 正在加载，无需再次发起请求...");
            } else {
                com.byazt.eu.n.uj(new c(null, i, jSONObject));
            }
        } catch (Throwable th) {
            com.byazt.eu.tt.c("SdkSettingsHelper", "load sdk settings error: ", th);
        }
    }

    public void c(int i) {
        if (this.i.get()) {
            com.byazt.eu.tt.uj("SdkSettingsHelper", "setting 正在尝试拉取配置中...");
            return;
        }
        com.byazt.eu.tt.uj("SdkSettingsHelper", "setting 尝试拉取配置...");
        c();
        tt(i, null);
    }

    private void c(n nVar, com.byazt.pp.c cVar, int i, JSONObject jSONObject) throws Throwable {
        long j;
        com.byazt.rq.c.c().remove("server_dist_host");
        c(nVar, cVar);
        com.byazt.sx.ve.a();
        com.byazt.eu.tt.uj("SdkSettingsHelper", "setting 配置拉取失败，尝试再次拉取... mLoadingSuccess:" + this.sp.get() + " mRetryCount:" + (this.n.get() + 1));
        this.f28969a.set(false);
        if (this.sp.get()) {
            this.i.set(false);
            this.x.removeCallbacksAndMessages(null);
            return;
        }
        if (this.n.get() > 3) {
            com.byazt.eu.tt.uj("SdkSettingsHelper", "setting 最多尝试四次拉取... ");
            return;
        }
        this.i.set(true);
        Message messageObtain = Message.obtain();
        messageObtain.what = 1;
        messageObtain.arg1 = this.n.get();
        messageObtain.arg2 = i;
        messageObtain.obj = jSONObject;
        int i2 = this.n.get();
        if (i2 < 3) {
            long j2 = 1;
            for (int i3 = 0; i3 <= i2; i3++) {
                j2 *= 3;
            }
            j = j2 * 1000;
        } else {
            j = com.igexin.push.config.c.l;
        }
        this.n.incrementAndGet();
        this.x.removeCallbacksAndMessages(null);
        this.x.sendMessageDelayed(messageObtain, j);
        com.byazt.eu.tt.tt("SdkSettingsHelper", "setting 重试次数:" + (i2 + 1) + "  重试间隔：" + j);
    }

    private Map<String, String> c(Map<String, String> map) {
        if (map == null || map.size() == 0) {
            return null;
        }
        HashMap map2 = new HashMap();
        for (String str : map.keySet()) {
            if (!TextUtils.isEmpty(str)) {
                map2.put(str.toLowerCase(), map.get(str));
            }
        }
        return map2;
    }

    private void c(final n nVar, final com.byazt.pp.c cVar) {
        com.byazt.eu.n.ve(new Runnable() { // from class: com.byazt.qe.tt.1
            @Override // java.lang.Runnable
            public void run() {
            }
        });
    }

    public void c(final n nVar) {
        int i = this.sl;
        if (i == 2 || i == 3) {
            this.sl = -1;
            c(i, (JSONObject) null);
        }
        if (nVar != null) {
            final List<String> listYv = com.byazt.bp.c.t().yv();
            com.byazt.eu.n.ve(new Runnable() { // from class: com.byazt.qe.tt.2
                @Override // java.lang.Runnable
                public void run() {
                    nVar.c(com.byazt.bp.tt.tt().c(listYv));
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(JSONObject jSONObject, String str, long j) {
        try {
            jSONObject.put(str, SystemClock.elapsedRealtime() - j);
        } catch (JSONException e) {
            m.c(e);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(final boolean z, final n nVar, final int i, final JSONObject jSONObject) {
        com.byazt.eu.tt.tt("SdkSettingsHelper", "requestSetting requestType: ".concat(String.valueOf(i)));
        final int[] iArr = {0};
        final int[] iArr2 = new int[1];
        final long jElapsedRealtime = SystemClock.elapsedRealtime();
        final JSONObject jSONObject2 = new JSONObject();
        Map<String, JSONObject> mapTt = com.byazt.psp.n.uj().tt(i);
        final JSONObject jSONObject3 = mapTt.get("event_label_value_root");
        JSONObject jSONObject4 = mapTt.get("config_req_label_value_root");
        com.byazt.va.n nVarTt = com.byazt.yp.tt.c().tt().tt();
        nVarTt.c(com.byazt.bp.ve.c());
        String strX = com.byazt.bp.c.t().x();
        if (!TextUtils.isEmpty(strX)) {
            nVarTt.tt("X-Tt-Env", strX);
            nVarTt.tt("x-use-ppe", "1");
        }
        nVarTt.tt("User-Agent", com.byazt.yl.tt.c);
        try {
            JSONObject jSONObjectTt = tt(jSONObject4);
            c(jSONObject2, "params", jElapsedRealtime);
            final boolean z2 = !com.byazt.bp.tt.tt().a();
            if (z2) {
                nVarTt.tt("x-pglcypher", "4");
                nVarTt.c(OSSConstants.DEFAULT_OBJECT_CONTENT_TYPE, eo.tt(jSONObjectTt.toString()));
                if (nVarTt.n() != null && nVarTt.n().n != null) {
                    eo.c(com.byazt.bp.ve.c(), nVarTt.n().n, true);
                }
            } else {
                nVarTt.ve(ve(jSONObjectTt));
                if (nVarTt.n() != null && nVarTt.n().uj != null) {
                    eo.c(com.byazt.bp.ve.c(), nVarTt.n().uj, true);
                }
            }
            c(jSONObject2, "encrypt", jElapsedRealtime);
            nVarTt.c(new com.byazt.mh.c() { // from class: com.byazt.qe.tt.3
                @Override // com.byazt.mh.c
                public void c(com.byazt.va.uj ujVar, final com.byazt.hm.tt ttVar) {
                    tt.this.c(jSONObject2, "net", jElapsedRealtime);
                    com.byazt.eu.n.c(new Runnable() { // from class: com.byazt.qe.tt.3.1
                        /* JADX WARN: Multi-variable type inference failed */
                        /* JADX WARN: Type inference failed for: r14v0, types: [int[]] */
                        /* JADX WARN: Type inference failed for: r14v1 */
                        /* JADX WARN: Type inference failed for: r14v2 */
                        /* JADX WARN: Type inference failed for: r14v3 */
                        /* JADX WARN: Type inference failed for: r14v5 */
                        /* JADX WARN: Type inference failed for: r14v6 */
                        /* JADX WARN: Type inference failed for: r14v7 */
                        /* JADX WARN: Type inference failed for: r14v8 */
                        /* JADX WARN: Type inference failed for: r14v9 */
                        /* JADX WARN: Type inference failed for: r17v0 */
                        /* JADX WARN: Type inference failed for: r17v1 */
                        /* JADX WARN: Type inference failed for: r17v2 */
                        /* JADX WARN: Type inference failed for: r17v3 */
                        /* JADX WARN: Type inference failed for: r17v4 */
                        /* JADX WARN: Type inference failed for: r17v5 */
                        /* JADX WARN: Type inference failed for: r17v6 */
                        /* JADX WARN: Type inference failed for: r17v7 */
                        /* JADX WARN: Type inference failed for: r17v8 */
                        /* JADX WARN: Type inference failed for: r17v9 */
                        /* JADX WARN: Type inference failed for: r20v0 */
                        /* JADX WARN: Type inference failed for: r20v1 */
                        /* JADX WARN: Type inference failed for: r20v10 */
                        /* JADX WARN: Type inference failed for: r20v11 */
                        /* JADX WARN: Type inference failed for: r20v12 */
                        /* JADX WARN: Type inference failed for: r20v13 */
                        /* JADX WARN: Type inference failed for: r20v2, types: [int[]] */
                        /* JADX WARN: Type inference failed for: r20v3 */
                        /* JADX WARN: Type inference failed for: r20v4 */
                        /* JADX WARN: Type inference failed for: r20v5 */
                        /* JADX WARN: Type inference failed for: r20v6 */
                        /* JADX WARN: Type inference failed for: r20v7 */
                        /* JADX WARN: Type inference failed for: r20v8 */
                        /* JADX WARN: Type inference failed for: r20v9 */
                        /* JADX WARN: Type inference failed for: r2v4, types: [int] */
                        /* JADX WARN: Type inference failed for: r9v1 */
                        /* JADX WARN: Type inference failed for: r9v2, types: [boolean] */
                        /* JADX WARN: Type inference failed for: r9v3 */
                        @Override // java.lang.Runnable
                        public void run() {
                            ?? r17;
                            ?? r20;
                            char c2;
                            ?? r18;
                            JSONObject jSONObject5;
                            String str;
                            ?? r21;
                            char c3;
                            ?? r22;
                            char c4;
                            AnonymousClass3 anonymousClass3 = AnonymousClass3.this;
                            tt.this.c(jSONObject2, "thread", jElapsedRealtime);
                            ?? r14 = {-1};
                            com.byazt.hm.tt ttVar2 = ttVar;
                            if (ttVar2 != null) {
                                iArr2[0] = ttVar2.tt();
                                if (eo.c(ttVar)) {
                                    eo.c(com.byazt.bp.ve.c(), ttVar.sl(), false);
                                    String strC = eo.c(ttVar.sl());
                                    AnonymousClass3 anonymousClass4 = AnonymousClass3.this;
                                    tt.this.c(jSONObject2, "decrypt", jElapsedRealtime);
                                    if (tt.da) {
                                        boolean unused = tt.da = false;
                                        try {
                                            jSONObject2.put("isFirstDecrypt", 1);
                                        } catch (JSONException e) {
                                            m.c(e);
                                        }
                                    }
                                    if (TextUtils.isEmpty(strC)) {
                                        r22 = r14;
                                        c4 = 0;
                                        AnonymousClass3 anonymousClass5 = AnonymousClass3.this;
                                        iArr2[0] = 81015;
                                        tt.this.c(nVar, i, 81015, "response body is null", z2, jSONObject);
                                    } else {
                                        try {
                                            JSONObject jSONObject6 = new JSONObject(strC);
                                            AnonymousClass3 anonymousClass6 = AnonymousClass3.this;
                                            r21 = r14;
                                            c3 = 0;
                                            try {
                                                tt.this.c(iArr2, iArr, ttVar, jSONObject6, strC, r14, nVar, jSONObject2, i, z2, jElapsedRealtime, jSONObject);
                                                c4 = c3;
                                                r22 = r21;
                                            } catch (Throwable th) {
                                                th = th;
                                                AnonymousClass3 anonymousClass7 = AnonymousClass3.this;
                                                iArr2[c3 == true ? 1 : 0] = 81014;
                                                tt ttVar3 = tt.this;
                                                n nVar2 = nVar;
                                                int i2 = i;
                                                String message = th.getMessage();
                                                AnonymousClass3 anonymousClass8 = AnonymousClass3.this;
                                                ttVar3.c(nVar2, i2, 81014, message, z2, jSONObject);
                                                c4 = c3;
                                                r22 = r21;
                                            }
                                        } catch (Throwable th2) {
                                            th = th2;
                                            r21 = r14;
                                            c3 = 0;
                                        }
                                    }
                                    r17 = 1;
                                    c2 = c4;
                                    r20 = r22;
                                } else {
                                    ?? r23 = r14;
                                    char c5 = 0;
                                    if (ttVar.n() != null) {
                                        eo.c(com.byazt.bp.ve.c(), ttVar.n(), false);
                                        try {
                                            JSONObject jSONObject7 = new JSONObject(ttVar.n());
                                            int iOptInt = jSONObject7.optInt("cypher", -1);
                                            try {
                                                try {
                                                    if (iOptInt == 4) {
                                                        String strOptString = jSONObject7.optString("message");
                                                        com.byazt.dna.n nVarA = eo.a();
                                                        String strDecryptWithCBC = nVarA != null ? nVarA.decryptWithCBC(strOptString) : null;
                                                        if (TextUtils.isEmpty(strDecryptWithCBC)) {
                                                            jSONObject5 = jSONObject7;
                                                            str = strDecryptWithCBC;
                                                        } else {
                                                            try {
                                                                jSONObject5 = new JSONObject(strDecryptWithCBC);
                                                            } catch (Throwable th3) {
                                                                m.c(th3);
                                                                com.byazt.eu.tt.c("SdkSettingsHelper", ">>>>> setting data error: " + th3.toString());
                                                                jSONObject5 = jSONObject7;
                                                            }
                                                            str = strDecryptWithCBC;
                                                        }
                                                    } else {
                                                        if (iOptInt == 2) {
                                                            String strC2 = eo.c(jSONObject7.optString("message"));
                                                            if (TextUtils.isEmpty(strC2)) {
                                                                jSONObject5 = jSONObject7;
                                                                str = strC2;
                                                            } else {
                                                                try {
                                                                    jSONObject5 = new JSONObject(strC2);
                                                                } catch (Throwable th4) {
                                                                    com.byazt.eu.tt.c("SdkSettingsHelper", ">>>>> setting data error: " + th4.toString());
                                                                    jSONObject5 = jSONObject7;
                                                                }
                                                                str = strC2;
                                                            }
                                                        } else {
                                                            r14 = 1;
                                                            r14 = 1;
                                                            r14 = 1;
                                                            r14 = 1;
                                                            r14 = 1;
                                                            if (iOptInt == 1) {
                                                                String strTt = com.byazt.vx.c.tt(jSONObject7.optString("message"), com.byazt.vx.tt.c());
                                                                if (TextUtils.isEmpty(strTt)) {
                                                                    jSONObject5 = jSONObject7;
                                                                    str = strTt;
                                                                } else {
                                                                    try {
                                                                        com.byazt.eu.tt.c("SdkSettingsHelper", "setting data : " + strTt.toString());
                                                                        jSONObject5 = new JSONObject(strTt);
                                                                    } catch (Throwable th5) {
                                                                        com.byazt.eu.tt.c("SdkSettingsHelper", "setting data error: ", th5);
                                                                        jSONObject5 = jSONObject7;
                                                                    }
                                                                    str = strTt;
                                                                }
                                                            } else if (iOptInt == 0) {
                                                                String strOptString2 = jSONObject7.optString("message");
                                                                str = strOptString2;
                                                                jSONObject5 = new JSONObject(strOptString2);
                                                            } else {
                                                                jSONObject5 = jSONObject7;
                                                                str = null;
                                                            }
                                                            AnonymousClass3 anonymousClass9 = AnonymousClass3.this;
                                                            tt.this.c(jSONObject2, "decrypt", jElapsedRealtime);
                                                            AnonymousClass3 anonymousClass10 = AnonymousClass3.this;
                                                            r18 = 1;
                                                            r17 = 1;
                                                            tt.this.c(iArr2, iArr, ttVar, jSONObject5, str, r23, nVar, jSONObject2, i, z2, jElapsedRealtime, jSONObject);
                                                            c2 = c5;
                                                            r20 = r23;
                                                        }
                                                        AnonymousClass3 anonymousClass11 = AnonymousClass3.this;
                                                        iArr2[0] = 81006;
                                                        tt ttVar4 = tt.this;
                                                        n nVar3 = nVar;
                                                        int i3 = i;
                                                        String message2 = th.getMessage();
                                                        AnonymousClass3 anonymousClass12 = AnonymousClass3.this;
                                                        ttVar4.c(nVar3, i3, 81006, message2, z2, jSONObject);
                                                        c2 = c5;
                                                        r17 = r18;
                                                        r20 = r23;
                                                    }
                                                    tt.this.c(iArr2, iArr, ttVar, jSONObject5, str, r23, nVar, jSONObject2, i, z2, jElapsedRealtime, jSONObject);
                                                    c2 = c5;
                                                    r20 = r23;
                                                } catch (Throwable th6) {
                                                    th = th6;
                                                    AnonymousClass3 anonymousClass13 = AnonymousClass3.this;
                                                    iArr2[0] = 81006;
                                                    tt ttVar5 = tt.this;
                                                    n nVar4 = nVar;
                                                    int i4 = i;
                                                    String message3 = th.getMessage();
                                                    AnonymousClass3 anonymousClass14 = AnonymousClass3.this;
                                                    ttVar5.c(nVar4, i4, 81006, message3, z2, jSONObject);
                                                    c2 = c5;
                                                    r17 = r18;
                                                    r20 = r23;
                                                }
                                                r14 = 1;
                                                AnonymousClass3 anonymousClass15 = AnonymousClass3.this;
                                                tt.this.c(jSONObject2, "decrypt", jElapsedRealtime);
                                                AnonymousClass3 anonymousClass16 = AnonymousClass3.this;
                                                r18 = 1;
                                                r17 = 1;
                                            } catch (Throwable th7) {
                                                th = th7;
                                                r18 = r14;
                                            }
                                        } catch (Throwable th8) {
                                            th = th8;
                                            r18 = 1;
                                        }
                                    } else {
                                        r17 = 1;
                                        AnonymousClass3 anonymousClass17 = AnonymousClass3.this;
                                        iArr2[0] = 81013;
                                        tt.this.c(nVar, i, 81013, "response body is null", z2, jSONObject);
                                        c2 = c5;
                                        r20 = r23;
                                    }
                                }
                            } else {
                                r17 = 1;
                                r20 = r14;
                                c2 = 0;
                                AnonymousClass3 anonymousClass18 = AnonymousClass3.this;
                                iArr2[0] = 81007;
                                tt.this.c(nVar, i, 81007, "response is null", z2, jSONObject);
                            }
                            AnonymousClass3 anonymousClass19 = AnonymousClass3.this;
                            int i5 = iArr[c2];
                            int i6 = iArr2[c2];
                            long jElapsedRealtime2 = SystemClock.elapsedRealtime();
                            AnonymousClass3 anonymousClass20 = AnonymousClass3.this;
                            uj.c(i5, i6, jElapsedRealtime2 - jElapsedRealtime, z, i == 0 ? r17 : c2, jSONObject3, (long) r20[c2], jSONObject2);
                        }
                    });
                }

                @Override // com.byazt.mh.c
                public void c(com.byazt.va.uj ujVar, final IOException iOException) {
                    com.byazt.eu.n.c(new Runnable() { // from class: com.byazt.qe.tt.3.2
                        @Override // java.lang.Runnable
                        public void run() {
                            com.byazt.eu.tt.uj("SdkSettingsHelper", "----网络错误，服务器无响应，稍后会尝试重新拉取配置----，setting request failed..." + iOException.getMessage());
                            tt.this.f28969a.set(false);
                            AnonymousClass3 anonymousClass3 = AnonymousClass3.this;
                            iArr[0] = 0;
                            iArr2[0] = -2;
                            tt ttVar = tt.this;
                            n nVar2 = nVar;
                            int i2 = i;
                            String str = "request fail：" + iOException.getMessage();
                            AnonymousClass3 anonymousClass4 = AnonymousClass3.this;
                            ttVar.c(nVar2, i2, -2, str, z2, jSONObject);
                            AnonymousClass3 anonymousClass5 = AnonymousClass3.this;
                            int i3 = iArr[0];
                            int i4 = iArr2[0];
                            long jElapsedRealtime2 = SystemClock.elapsedRealtime();
                            AnonymousClass3 anonymousClass6 = AnonymousClass3.this;
                            uj.c(i3, i4, jElapsedRealtime2 - jElapsedRealtime, z, i == 0, jSONObject3, -1L, null);
                        }
                    });
                }
            });
        } catch (UnsatisfiedLinkError e) {
            m.c(e);
            com.byazt.vq.c.c().c(81017, "GM接口请求异常");
        }
    }

    private JSONObject tt(PluginValueSet pluginValueSet) {
        JSONObject jSONObject = new JSONObject();
        if (pluginValueSet == null) {
            return jSONObject;
        }
        try {
            com.byazt.yf.a aVarC = com.byazt.tjo.ve.c(com.byazt.lkb.c.c(pluginValueSet).nu());
            jSONObject.put("need_simple_req", 1);
            jSONObject.put("app_id", pluginValueSet.objectValue(261001, String.class));
            jSONObject.put("media_sdk_version", com.byazt.yl.tt.tt());
            jSONObject.put(PluginConstants.KEY_PLUGIN_VERSION, com.byazt.yl.tt.uj());
            JSONObject jSONObject2 = new JSONObject();
            jSONObject2.put("os", ((u) com.byazt.ut.uj.getService("device_info_new")).getOs());
            jSONObject2.put("android_id", DeviceUtils.tt());
            jSONObject.put("device", jSONObject2);
            if (aVarC != null) {
                jSONObject.put("grouping_params", c(aVarC));
                jSONObject.put("user_defined_grouping_params", tt(aVarC));
            }
        } catch (JSONException unused) {
        }
        return jSONObject;
    }

    public static JSONObject tt(com.byazt.yf.a aVar) {
        Map<String, String> mapC;
        JSONObject jSONObject = new JSONObject();
        if (aVar != null && (mapC = aVar.c()) != null) {
            try {
                for (String str : mapC.keySet()) {
                    jSONObject.put(str, mapC.get(str));
                }
                return jSONObject;
            } catch (Exception e) {
                m.c(e);
            }
        }
        return null;
    }

    public void c(PluginValueSet pluginValueSet, final JSONObject jSONObject) {
        c(pluginValueSet);
        com.byazt.qe.c cVar = this.tt;
        if (cVar != null) {
            cVar.c();
        }
        final long jCurrentTimeMillis = System.currentTimeMillis();
        com.byazt.ng.a.tt();
        com.byazt.va.n nVarTt = com.byazt.yp.tt.c().tt().tt();
        nVarTt.c(com.byazt.bp.ve.c());
        nVarTt.tt("User-Agent", com.byazt.yl.tt.c);
        try {
            JSONObject jSONObjectTt = tt(pluginValueSet);
            nVarTt.tt("x-pglcypher", "4");
            nVarTt.c(OSSConstants.DEFAULT_OBJECT_CONTENT_TYPE, eo.tt(jSONObjectTt.toString()));
            nVarTt.c(new com.byazt.mh.c() { // from class: com.byazt.qe.tt.4
                /* JADX WARN: Code duplicated, block: B:20:0x005a  */
                @Override // com.byazt.mh.c
                public void c(com.byazt.va.uj ujVar, com.byazt.hm.tt ttVar) {
                    JSONObject jSONObject2;
                    long jCurrentTimeMillis2 = System.currentTimeMillis() - jCurrentTimeMillis;
                    if (ttVar == null) {
                        return;
                    }
                    try {
                        if (eo.c(ttVar)) {
                            jSONObject2 = new JSONObject(eo.c(ttVar.sl()));
                        } else if (TextUtils.isEmpty(ttVar.n())) {
                            jSONObject2 = null;
                        } else {
                            JSONObject jSONObject3 = new JSONObject(ttVar.n());
                            if (jSONObject3.optInt("cypher", -1) == 4) {
                                String strOptString = jSONObject3.optString("message");
                                com.byazt.dna.n nVarA = eo.a();
                                String strDecryptWithCBC = nVarA != null ? nVarA.decryptWithCBC(strOptString) : null;
                                if (TextUtils.isEmpty(strDecryptWithCBC)) {
                                    jSONObject2 = null;
                                } else {
                                    jSONObject2 = new JSONObject(strDecryptWithCBC);
                                }
                            } else {
                                jSONObject2 = null;
                            }
                        }
                        if (jSONObject2 == null) {
                            return;
                        }
                        int iOptInt = jSONObject2.optInt("state_code", -80000);
                        if (iOptInt == 20000) {
                            tt.this.tt.c(jSONObject2, jSONObject, true);
                            com.byazt.ng.a.c(jCurrentTimeMillis2, true, "", 1);
                        } else {
                            tt.this.tt.c(jSONObject2, jSONObject, false);
                            com.byazt.ng.a.c(jCurrentTimeMillis2, false, jSONObject2.optString("message"), iOptInt);
                        }
                    } catch (Throwable unused) {
                    }
                }

                @Override // com.byazt.mh.c
                public void c(com.byazt.va.uj ujVar, IOException iOException) {
                    com.byazt.ng.a.c(System.currentTimeMillis() - jCurrentTimeMillis, false, iOException.getMessage(), -2);
                }
            });
        } catch (UnsatisfiedLinkError unused) {
        }
    }

    public static JSONObject tt() {
        JSONObject jSONObject = new JSONObject();
        List<String> listSp = sp();
        if (listSp != null) {
            for (String str : listSp) {
                com.byazt.ly.uj ujVarC = com.byazt.px.tt.c().c(str);
                if (ujVarC != null) {
                    try {
                        String networkSdkVersion = ujVarC.getNetworkSdkVersion();
                        if (!TextUtils.isEmpty(networkSdkVersion)) {
                            jSONObject.put(str, networkSdkVersion);
                        }
                        String adapterVersion = ujVarC.getAdapterVersion();
                        if (!TextUtils.isEmpty(adapterVersion)) {
                            jSONObject.put(str + "Adapter", adapterVersion);
                        }
                    } catch (JSONException e) {
                        m.c(e);
                    }
                }
            }
        }
        return jSONObject;
    }

    private void c(PluginValueSet pluginValueSet) {
        String str = (String) pluginValueSet.objectValue(261001, String.class);
        com.byazt.bp.c.t().ve(str);
        x.m().ve(str);
        SparseArray sparseArray = (SparseArray) pluginValueSet.objectValue(261012, SparseArray.class);
        if (sparseArray != null) {
            x.m().c(new com.byazt.dj.uj(sparseArray));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(int[] iArr, int[] iArr2, com.byazt.hm.tt ttVar, JSONObject jSONObject, String str, int[] iArr3, n nVar, JSONObject jSONObject2, int i, boolean z, long j, JSONObject jSONObject3) {
        String str2;
        String str3;
        String str4;
        long jElapsedRealtime = SystemClock.elapsedRealtime() - j;
        Map<String, String> mapC = c(ttVar.uj());
        if (mapC != null) {
            str3 = mapC.get("active-control");
            str4 = mapC.get("ts");
            str2 = mapC.get(t.s);
        } else {
            str2 = null;
            str3 = null;
            str4 = null;
        }
        String strC = gt.c(str + str3 + str4);
        if (!TextUtils.isEmpty(strC) && strC.equalsIgnoreCase(str2)) {
            com.byazt.bp.tt.tt().uj(str3);
        }
        c(jSONObject);
        int iOptInt = jSONObject.optInt("state_code", -80000);
        String strOptString = jSONObject.optString("message");
        if (iOptInt == 20000) {
            iArr[0] = 20000;
        }
        if (iOptInt == 30004) {
            iArr[0] = 30004;
            this.f28969a.set(false);
            this.i.set(false);
            this.x.removeCallbacksAndMessages(null);
            this.tt.c(jSONObject);
            c(nVar);
            com.byazt.sx.ve.n();
            c(z, jElapsedRealtime);
            return;
        }
        if (iOptInt == 20000 && !TextUtils.isEmpty(jSONObject.toString())) {
            iArr2[0] = 1;
            iArr[0] = 20000;
            String strN = ttVar.n();
            if (strN != null) {
                iArr3[0] = strN.length();
            }
            this.i.set(false);
            this.x.removeCallbacksAndMessages(null);
            this.sp.set(true);
            this.tt.c(jSONObject, false, false, jSONObject3);
            c(jSONObject2, "parse_save", j);
            this.f28969a.set(false);
            c(nVar);
            com.byazt.sx.ve.n();
            if (com.byazt.bp.c.t().yp()) {
                x();
            }
            c(z, jElapsedRealtime);
            return;
        }
        if (iOptInt != -80000) {
            iArr[0] = iOptInt;
        }
        c(nVar, i, iArr[0], (!TextUtils.isEmpty(strOptString) || TextUtils.isEmpty(jSONObject.optString("msg"))) ? strOptString : jSONObject.optString("msg"), z, jSONObject3);
    }

    private void c(boolean z, long j) {
        yv.c(z ? "v4Enc_config" : "v2Enc_config", true, j, "");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(n nVar, int i, int i2, String str, boolean z, JSONObject jSONObject) {
        if (z) {
            try {
                com.byazt.bp.tt.tt().c(true);
            } catch (Throwable th) {
                m.c(th);
                return;
            }
        }
        yv.c(z ? "v4Enc_config" : "v2Enc_config", false, 0L, "code = " + i2 + "，msg = " + str);
        com.byazt.eu.tt.uj("SdkSettingsHelper", "----拉取配置失败: " + i2 + " msg = " + str);
        c(nVar, new com.byazt.pp.c(i2, str), i, jSONObject);
        if (com.byazt.bp.tt.tt().pf()) {
            return;
        }
        com.byazt.vq.c.c().c(i2, "聚合config请求失败 code = " + i2 + " msg = " + str);
    }

    public static String c(Throwable th) {
        StringWriter stringWriter = new StringWriter();
        PrintWriter printWriter = new PrintWriter(stringWriter);
        try {
            try {
                th.printStackTrace(printWriter);
                String string = stringWriter.toString();
                try {
                    stringWriter.close();
                } catch (IOException unused) {
                }
                printWriter.close();
                return string;
            } catch (IOException unused2) {
                printWriter.close();
                return null;
            }
        } catch (Exception unused3) {
            stringWriter.close();
            printWriter.close();
            return null;
        } catch (Throwable th2) {
            try {
                stringWriter.close();
            } catch (IOException unused4) {
            }
            printWriter.close();
            throw th2;
        }
    }

    private void c(JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        try {
            if (jSONObject.optBoolean("remote_log_enabled")) {
                com.byazt.eu.tt.c();
            }
        } catch (Throwable unused) {
        }
    }

    public static JSONObject c(com.byazt.yf.a aVar) {
        String strTt;
        JSONObject jSONObject = new JSONObject();
        if (aVar != null) {
            try {
                strTt = aVar.tt();
            } catch (JSONException e) {
                m.c(e);
            }
        } else {
            strTt = "";
        }
        jSONObject.put(PtgRewardConstant.REWARD_PARAMS.USER_ID, strTt);
        jSONObject.put(xh9.WEBSITE_PARAMS_CHANNEL, aVar != null ? aVar.ve() : "");
        jSONObject.put("sub_channel", aVar != null ? aVar.uj() : "");
        jSONObject.put("age", aVar != null ? aVar.n() : 0);
        jSONObject.put("gender", aVar != null ? aVar.a() : "");
        jSONObject.put("user_value_group", aVar != null ? aVar.sp() : "");
        return jSONObject;
    }
}

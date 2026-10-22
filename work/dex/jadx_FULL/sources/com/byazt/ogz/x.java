package com.byazt.ogz;

import android.annotation.SuppressLint;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Build;
import android.text.TextUtils;
import com.ali.auth.third.login.LoginConstants;
import com.alibaba.baichuan.trade.common.constants.AlibcCommonConstant;
import com.byazt.aas.DeviceUtils;
import com.byazt.aas.eo;
import com.byazt.aas.gu;
import com.byazt.aas.my;
import com.byazt.aas.nb;
import com.byazt.aas.sv;
import com.byazt.dna.u;
import com.byazt.nr.m;
import com.byazt.nr.rh;
import com.byazt.nys.PluginConstants;
import com.byazt.omf.gt;
import com.byazt.omf.p;
import com.byazt.ukr.yp;
import com.kc.openset.constant.DeviceIdType;
import com.zj.adlib.xh9;
import com.zj.adlib.yg3;
import com.zj.adlib.ze1;
import java.io.IOException;
import java.util.Iterator;
import java.util.concurrent.atomic.AtomicLong;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_11_8719cls.dex */
@com.byazt.zqa.c(c = {0, 1, 1190, 71})
public class x extends com.byazt.bwm.sp {

    @SuppressLint({"StaticFieldLeak"})
    public static volatile x uj;
    public final n c;
    public volatile Runnable sp;
    public final Context tt;
    public static final AtomicLong ve = new AtomicLong(0);
    public static boolean n = true;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static volatile boolean f28870a = false;

    @com.byazt.zqa.c(c = {0, 1, 1190, 62})
    public class c extends BroadcastReceiver {
        private c() {
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            if (intent == null) {
                return;
            }
            m.c("SdkSettingsHelper", "onReceive: ");
            int intExtra = intent.getIntExtra("b_msg_id", -1);
            if (intExtra == 1) {
                long longExtra = intent.getLongExtra("b_msg_time", -1L);
                if (longExtra > 0) {
                    x.ve.set(longExtra);
                    return;
                }
                return;
            }
            if (intExtra == 2) {
                try {
                    if (x.this.c != null) {
                        x.this.c.c();
                    }
                } catch (Throwable unused) {
                }
            }
        }
    }

    private x(n nVar) {
        super("SdkSettingsHelper");
        this.c = nVar == null ? gt.tt() : nVar;
        Context context = gt.getContext();
        this.tt = context;
        if (com.byazt.ue.tt.c()) {
            try {
                context.registerReceiver(new c(), new IntentFilter("com.bytedance.openadsdk.settingReceiver"), nb.p(), com.byazt.nr.da.c());
            } catch (Throwable unused) {
            }
        }
    }

    private static JSONObject da() {
        JSONObject jSONObjectOptJSONObject;
        JSONObject jSONObjectCu = com.byazt.omf.x.m().cu();
        if (jSONObjectCu == null) {
            return new JSONObject();
        }
        Iterator<String> itKeys = jSONObjectCu.keys();
        while (itKeys.hasNext()) {
            String next = itKeys.next();
            if (!TextUtils.isEmpty(next) && (jSONObjectOptJSONObject = jSONObjectCu.optJSONObject(next)) != null) {
                try {
                    jSONObjectOptJSONObject.put("plugin_update_network", com.byazt.omf.x.m().zm().c(next));
                } catch (JSONException e) {
                    m.c(e);
                }
            }
        }
        return jSONObjectCu;
    }

    private boolean i() {
        return TextUtils.isEmpty(com.byazt.omf.x.m().rl());
    }

    public static boolean n() {
        return f28870a;
    }

    public static void ve() {
        if (gt.getContext() != null) {
            try {
                Intent intent = new Intent();
                intent.setPackage(nb.x());
                intent.setAction("com.bytedance.openadsdk.settingReceiver");
                intent.putExtra("b_msg_id", 2);
                gt.getContext().sendBroadcast(intent, nb.x() + ".openadsdk.permission.TT_PANGOLIN");
            } catch (Throwable unused) {
            }
        }
    }

    public JSONObject a() {
        JSONObject jSONObject = new JSONObject();
        try {
            u uVar = (u) com.byazt.ut.uj.getService("device_info_new");
            com.byazt.dna.ve veVar = (com.byazt.dna.ve) com.byazt.ut.uj.getService("embed_applog");
            jSONObject.put(LoginConstants.IP, my.c());
            jSONObject.put("ipv6", my.tt());
            jSONObject.put(DeviceIdType.OAID, veVar.getOAID(false));
            jSONObject.put("oaid_source", gu.c());
            jSONObject.put(ze1.k, uVar.getDeviceModel());
            jSONObject.put("conn_type", rh.tt(this.tt));
            jSONObject.put("os", 1);
            jSONObject.put("oversea_version_type", 0);
            jSONObject.put("os_api", Build.VERSION.SDK_INT);
            jSONObject.put("os_version", String.valueOf(Build.VERSION.RELEASE));
            jSONObject.put("sdk_version", p.n);
            jSONObject.put(PluginConstants.KEY_PLUGIN_VERSION, "7.6.1.1");
            jSONObject.put("is_plugin", p.c());
            jSONObject.put("is_boost", true);
            jSONObject.put("sdk_boost_type", com.byazt.xo.c.n());
            jSONObject.put("download_sdk_version", com.byazt.yih.i.ve());
            jSONObject.put("package_name", nb.x());
            jSONObject.put("position", nb.uj() ? 1 : 2);
            jSONObject.put(AlibcCommonConstant.APP_VERSION, nb.da());
            jSONObject.put("app_code", nb.i());
            String str = Build.MANUFACTURER;
            jSONObject.put("vendor", str);
            jSONObject.put("app_id", com.byazt.omf.x.m().rl());
            long jCurrentTimeMillis = System.currentTimeMillis() / 1000;
            jSONObject.put("ts", jCurrentTimeMillis);
            jSONObject.put("req_sign", com.byazt.nr.a.tt(com.byazt.omf.x.m().rl() != null ? com.byazt.omf.x.m().rl().concat(String.valueOf(jCurrentTimeMillis)).concat(p.n) : ""));
            m.c("isApplicationForeground", "app_version:" + nb.da() + "，vendor:" + str);
            jSONObject.put("locale_language", uVar.getLocalLanguage());
            jSONObject.put(xh9.WEBSITE_PARAMS_CHANNEL, p.x);
            jSONObject.put("applog_did", veVar.getDid());
            jSONObject.put("can_use_sensor", com.byazt.omf.x.m().n());
            com.byazt.qh.tt.c(jSONObject);
            com.byazt.qh.tt.ve(jSONObject);
            jSONObject.put("system_app", p.ve());
            if (p.c()) {
                jSONObject.put("plugins", da());
            }
            jSONObject.put(DeviceIdType.IMEI, DeviceUtils.c((Boolean) null));
            jSONObject.put("source", 1);
            jSONObject.put("device_abi", com.byazt.qya.tt.c());
            String strTk = com.byazt.omf.x.m().tk();
            if (!TextUtils.isEmpty(strTk)) {
                jSONObject.put("rit_list", strTk);
            }
            long jQ = gt.tt().q();
            if (jQ > 0) {
                jSONObject.put("data_time", jQ);
            }
            JSONObject jSONObjectB = gt.tt().b();
            if (jSONObjectB != null) {
                jSONObject.put("digest", jSONObjectB);
            }
            try {
                jSONObject.put("device_score", Double.parseDouble(com.byazt.whk.c.c().c("DeviceRate", "bytebench_value", ((sl) this.c).tt())));
            } catch (Exception unused) {
                jSONObject.put("device_score", -1);
            }
            jSONObject.put("csj_type", com.byazt.omf.x.m().bx() ? 1 : 0);
        } catch (Throwable unused2) {
        }
        return jSONObject;
    }

    @Override // java.lang.Runnable
    public void run() {
        if (!rh.c(this.tt)) {
            try {
                this.c.c();
                return;
            } catch (Throwable unused) {
                return;
            }
        }
        if (i()) {
            return;
        }
        if (!i.c() || com.byazt.omf.rh.c) {
            JSONObject jSONObjectA = a();
            sv svVar = new sv(com.byazt.hy.n.c().tt().a());
            svVar.c(com.byazt.tb.ve.c(svVar, nb.sl("/api/ad/union/sdk/settings/")));
            svVar.tt("User-Agent", ((u) com.byazt.ut.uj.getService("device_info_new")).getWebViewUA(false));
            svVar.tt(jSONObjectA, yg3.SOURCE_TYPE_SETTINGS);
            com.byazt.tb.ve.c(jSONObjectA, 1);
            svVar.c(new com.byazt.mh.c() { // from class: com.byazt.ogz.x.2
                @Override // com.byazt.mh.c
                public void c(com.byazt.va.uj ujVar, com.byazt.hm.tt ttVar) {
                    if (ttVar == null || !ttVar.i()) {
                        try {
                            x.this.c.c();
                            gt.tt().d();
                        } catch (Throwable unused2) {
                        }
                        com.byazt.omf.rh.tt();
                        return;
                    }
                    try {
                        try {
                            final JSONObject jSONObject = (JSONObject) com.byazt.by.a.c(ttVar, yg3.SOURCE_TYPE_SETTINGS, false).second;
                            if (jSONObject == null) {
                                return;
                            }
                            try {
                                if (!x.this.c(jSONObject)) {
                                    m.tt("SdkSettingsHelper", "can not update settings");
                                    return;
                                }
                            } catch (Throwable unused3) {
                            }
                            x.this.c.c(jSONObject);
                            if (da.ve() || da.a() || da.uj()) {
                                com.byazt.qya.ve.c();
                            }
                            if (p.sp) {
                                x.this.c.tt(jSONObject);
                            }
                            new com.byazt.xo.tt(64).c(5).c(new Runnable() { // from class: com.byazt.ogz.x.2.1
                                @Override // java.lang.Runnable
                                public void run() {
                                    JSONArray jSONArrayOptJSONArray;
                                    JSONArray jSONArrayOptJSONArray2 = jSONObject.optJSONArray("plugins");
                                    if (jSONArrayOptJSONArray2 != null) {
                                        com.byazt.zj.ve.c().c(jSONArrayOptJSONArray2);
                                    }
                                    JSONObject jSONObjectOptJSONObject = jSONObject.optJSONObject("app_common_config");
                                    if (jSONObjectOptJSONObject == null || (jSONArrayOptJSONArray = jSONObjectOptJSONObject.optJSONArray("plugins")) == null) {
                                        return;
                                    }
                                    com.byazt.zj.ve.c().c(jSONArrayOptJSONArray);
                                }
                            });
                            try {
                                x.this.c.ve(jSONObject);
                                com.byazt.omf.rh.c();
                                if (!x.f28870a) {
                                    boolean unused4 = x.f28870a = true;
                                }
                                com.byazt.omf.x.m().zm().n();
                                com.byazt.jv.c.tt();
                            } catch (Throwable th) {
                                yp.c().c("setting_saveData_failed", x.this.c(th), th);
                            }
                            yp.c().tt();
                            if (com.byazt.ue.tt.c()) {
                                x.ve();
                            }
                            com.byazt.tb.ve.tt(jSONObject, 1);
                        } catch (Throwable th2) {
                            yp.c().c("setting_decrypt", th2);
                        }
                    } catch (Throwable th3) {
                        yp.c().c("setting_parse", th3);
                    }
                }

                @Override // com.byazt.mh.c
                public void c(com.byazt.va.uj ujVar, IOException iOException) {
                    try {
                        Iterator<String> itKeys = com.byazt.omf.x.m().cu().keys();
                        while (itKeys.hasNext()) {
                            com.byazt.zj.ve.c().c(itKeys.next(), 1007);
                        }
                    } catch (Throwable unused2) {
                    }
                    try {
                        x.this.c.c();
                        gt.tt().d();
                    } catch (Throwable unused3) {
                    }
                    com.byazt.omf.rh.tt();
                }
            });
        }
    }

    public void uj() {
        c(false);
    }

    public static void tt() {
        try {
            eo.c("tt_sdk_settings_other").clear();
            eo.c("tt_sdk_settings_other_bst").clear();
            eo.c("tt_sdk_settings_slot").clear();
            eo.c("tt_sdk_settings_slot_bst").clear();
            eo.c("tt_sdk_settings_slot_splash").clear();
            eo.c("tt_sdk_settings_slot_splash_bst").clear();
        } catch (Throwable unused) {
        }
    }

    public static x c(n nVar) {
        if (uj == null) {
            synchronized (x.class) {
                if (uj == null) {
                    uj = new x(nVar);
                }
            }
        }
        return uj;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void tt(long j) {
        ve.set(j);
        if (com.byazt.ue.tt.c()) {
            c(j);
        }
        com.byazt.bwm.n.c(this, 10);
    }

    public static void c(long j) {
        if (j > 0 && gt.getContext() != null) {
            try {
                Intent intent = new Intent();
                intent.setPackage(nb.x());
                intent.setAction("com.bytedance.openadsdk.settingReceiver");
                intent.putExtra("b_msg_id", 1);
                intent.putExtra("b_msg_time", j);
                gt.getContext().sendBroadcast(intent, nb.p());
            } catch (Throwable unused) {
            }
        }
    }

    public void c(boolean z) {
        try {
            if (i()) {
                return;
            }
            long jCurrentTimeMillis = System.currentTimeMillis();
            if (!z) {
                if (jCurrentTimeMillis - ve.get() < 600000) {
                    return;
                }
                tt(jCurrentTimeMillis);
            } else {
                if (this.sp != null) {
                    m.tt("SdkSettingsHelper", "current task is not null !");
                    return;
                }
                long j = (ve.get() + 60000) - jCurrentTimeMillis;
                if (j > 0) {
                    this.sp = new Runnable() { // from class: com.byazt.ogz.x.1
                        @Override // java.lang.Runnable
                        public void run() {
                            x.this.sp = null;
                            x.this.tt(System.currentTimeMillis());
                        }
                    };
                    com.byazt.nr.da.c().postDelayed(this.sp, j);
                } else {
                    this.sp = null;
                    tt(jCurrentTimeMillis);
                }
            }
        } catch (Throwable unused) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean c(JSONObject jSONObject) {
        try {
            JSONObject jSONObjectOptJSONObject = jSONObject.optJSONObject("app_common_config");
            if (jSONObjectOptJSONObject != null) {
                int iOptInt = jSONObjectOptJSONObject.optInt("active_control", 1);
                i.c(iOptInt);
                m.c("SdkSettingsHelper", "sdk status: ".concat(String.valueOf(iOptInt)));
                return iOptInt == 1;
            }
        } catch (Throwable unused) {
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public JSONObject c(Throwable th) {
        JSONObject jSONObject = new JSONObject();
        if (th == null) {
            return jSONObject;
        }
        int i = 0;
        for (StackTraceElement stackTraceElement : th.getStackTrace()) {
            i++;
            if (stackTraceElement != null) {
                try {
                    jSONObject.putOpt(String.valueOf(i), stackTraceElement.toString());
                } catch (JSONException unused) {
                }
            }
        }
        return jSONObject;
    }
}

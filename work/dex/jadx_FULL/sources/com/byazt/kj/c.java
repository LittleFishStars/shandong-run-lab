package com.byazt.kj;

import android.content.Context;
import android.webkit.WebResourceResponse;
import android.webkit.WebView;
import com.alibaba.baichuan.trade.common.constants.AlibcCommonConstant;
import com.byazt.aas.z;
import com.byazt.gqp.da;
import com.byazt.nr.m;
import com.byazt.nr.rh;
import com.byazt.nys.PluginConstants;
import com.byazt.omf.gt;
import com.byazt.omf.p;
import com.byazt.omf.x;
import com.bytedance.sdk.openadsdk.mediation.MediationConstant;
import java.util.Map;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_11_8719cls.dex */
@com.byazt.zqa.c(c = {0, 1, 159, 20})
public abstract class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public JSONObject f28731a;
    public com.byazt.tjs.c c;
    public String sp;
    public String tt;
    public String ve;
    public AtomicBoolean uj = new AtomicBoolean(false);
    public AtomicBoolean n = new AtomicBoolean(false);

    /* JADX INFO: renamed from: com.byazt.kj.c$c, reason: collision with other inner class name */
    public interface InterfaceC0455c {
        void c(boolean z, Map<String, Object> map);
    }

    public c(com.byazt.tjs.c cVar, String str, String str2, JSONObject jSONObject, String str3, String str4) {
        this.c = cVar;
        this.tt = str;
        this.sp = str4;
        this.ve = str2;
        JSONObject jSONObject2 = new JSONObject();
        this.f28731a = jSONObject2;
        try {
            if (this instanceof tt) {
                jSONObject2.putOpt("log_extra", str3);
                this.f28731a.putOpt("resource_type", "union");
                this.f28731a.putOpt("ts", Long.valueOf(System.currentTimeMillis() / 1000));
            } else if (this instanceof ve) {
                jSONObject2.putOpt("timestamp", Long.valueOf(System.currentTimeMillis() / 1000));
                this.f28731a.putOpt(MediationConstant.EXTRA_ADID, jSONObject.optString(MediationConstant.EXTRA_ADID));
                this.f28731a.putOpt("customer_id", jSONObject.optString("customer_id"));
            }
            this.f28731a.putOpt("cid", str);
            this.f28731a.putOpt("ac", Integer.valueOf(rh.ve(gt.getContext())));
            this.f28731a.putOpt("app_name", x.m().qy());
            this.f28731a.putOpt("app_id", x.m().rl());
            this.f28731a.putOpt(AlibcCommonConstant.APP_VERSION, com.byazt.fh.c.n());
            this.f28731a.putOpt("sdk_version", p.n);
            this.f28731a.putOpt(PluginConstants.KEY_PLUGIN_VERSION, "7.6.1.1");
            this.f28731a.putOpt("platform", "Android");
            this.f28731a.putOpt("device_id", z.c());
            this.f28731a.putOpt("web_url", str4);
        } catch (JSONException e) {
            m.c(e);
        }
        c(str, str2);
    }

    public abstract void c();

    public abstract void c(Context context, String str, com.byazt.tjs.tt ttVar, WebResourceResponse webResourceResponse, da daVar, Map<String, Object> map);

    public abstract void c(com.byazt.tjs.tt ttVar, WebResourceResponse webResourceResponse, da daVar, InterfaceC0455c interfaceC0455c);

    public abstract void c(String str);

    public abstract void c(String str, String str2);

    public abstract void c(JSONObject jSONObject, String str, da daVar, String str2, String str3, Map<String, String> map, Map<String, Object> map2);

    public abstract boolean c(WebView webView);

    public abstract boolean c(da daVar);

    public void tt() {
        c();
    }

    public abstract void tt(Context context, String str, com.byazt.tjs.tt ttVar, WebResourceResponse webResourceResponse, da daVar, Map<String, Object> map);

    public abstract void ve();
}

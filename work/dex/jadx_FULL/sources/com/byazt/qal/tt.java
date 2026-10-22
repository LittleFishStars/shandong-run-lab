package com.byazt.qal;

import android.os.Build;
import android.text.TextUtils;
import com.ali.auth.third.login.LoginConstants;
import com.alibaba.baichuan.trade.common.constants.AlibcCommonConstant;
import com.baidu.mapapi.SDKInitializer;
import com.byazt.aas.DeviceUtils;
import com.byazt.aas.my;
import com.byazt.aas.nb;
import com.byazt.dna.u;
import com.byazt.dna.ve;
import com.byazt.nr.m;
import com.byazt.nr.rh;
import com.byazt.nys.PluginConstants;
import com.byazt.omf.gt;
import com.byazt.omf.p;
import com.byazt.omf.x;
import com.byazt.qal.tt;
import com.byazt.ut.uj;
import com.kc.openset.constant.DeviceIdType;
import com.zj.adlib.ze1;
import org.json.JSONObject;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_11_8719cls.dex */
@com.byazt.zqa.c(c = {0, 1, 1484, 13})
public class tt<T extends tt> implements c {
    public String c;
    public String da;
    public String n;
    public String sl;
    public String t;
    public String tt;
    public String u;
    public String ve;
    public String x;
    public String yp;
    public String z;
    public String uj = p.n;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public long f28967a = System.currentTimeMillis() / 1000;
    public int sp = 0;
    public int i = 0;

    private JSONObject nu() {
        JSONObject jSONObject = new JSONObject();
        try {
            u uVar = (u) uj.getService("device_info_new");
            ve veVar = (ve) uj.getService("embed_applog");
            jSONObject.put("os", 1);
            com.byazt.qh.tt.ve(jSONObject);
            jSONObject.put(DeviceIdType.OAID, veVar.getOAID(false));
            jSONObject.put(ze1.k, uVar.getDeviceModel());
            jSONObject.put("android_id", DeviceUtils.tt());
            jSONObject.put("vendor", Build.MANUFACTURER);
            jSONObject.put("package_name", nb.x());
            jSONObject.put("ua", uVar.getWebViewUA(false));
            jSONObject.put("applog_did", veVar.getDid());
            jSONObject.put(LoginConstants.IP, my.c());
        } catch (Exception unused) {
        }
        return jSONObject;
    }

    private T rh() {
        return this;
    }

    public static tt<tt> tt() {
        return new tt<>();
    }

    public String a() {
        return this.uj;
    }

    @Override // com.byazt.qal.c
    public JSONObject c() {
        JSONObject jSONObject = new JSONObject();
        try {
            if (!TextUtils.isEmpty(getType())) {
                jSONObject.put("type", getType());
            }
            if (!TextUtils.isEmpty(uj())) {
                jSONObject.put("rit", uj());
            }
            if (!TextUtils.isEmpty(n())) {
                jSONObject.put("creative_id", n());
            }
            if (!TextUtils.isEmpty(a())) {
                jSONObject.put("ad_sdk_version", a());
            }
            if (TextUtils.isEmpty(x())) {
                jSONObject.put(AlibcCommonConstant.APP_VERSION, nb.da());
            } else {
                jSONObject.put(AlibcCommonConstant.APP_VERSION, x());
            }
            if (i() > 0) {
                jSONObject.put("timestamp", i());
            }
            if (da() > 0) {
                jSONObject.put("adtype", da());
            }
            if (!TextUtils.isEmpty(sl())) {
                jSONObject.put("req_id", sl());
            }
            jSONObject.put(SDKInitializer.SDK_BROADTCAST_INTENT_EXTRA_INFO_KEY_ERROR_CODE, t());
            if (!TextUtils.isEmpty(u())) {
                jSONObject.put("error_msg", u());
            }
            if (!TextUtils.isEmpty(yp())) {
                jSONObject.put("extra", yp());
            }
            if (!TextUtils.isEmpty(z())) {
                jSONObject.put("image_url", z());
            }
            if (!TextUtils.isEmpty(ve())) {
                jSONObject.put("event_extra", ve());
            }
            if (!TextUtils.isEmpty(sp())) {
                jSONObject.put("duration", sp());
            }
            if (!TextUtils.isEmpty(x.m().rl())) {
                jSONObject.put("appid", x.m().rl());
            }
            if (!TextUtils.isEmpty(m())) {
                jSONObject.put("ad_info", m());
            }
            jSONObject.put(PluginConstants.KEY_PLUGIN_VERSION, "7.6.1.1");
            jSONObject.put("is_plugin", p.c());
            jSONObject.put("os_api", Build.VERSION.SDK_INT);
            jSONObject.put("conn_type", rh.tt(gt.getContext()));
        } catch (Exception e) {
            m.c(e);
        }
        try {
            jSONObject.put("device_info", nu());
        } catch (Throwable unused) {
        }
        return jSONObject;
    }

    public int da() {
        return this.sp;
    }

    public String getType() {
        return this.c;
    }

    public long i() {
        return this.f28967a;
    }

    public String m() {
        return this.z;
    }

    public String n() {
        return this.ve;
    }

    public String sl() {
        return this.x;
    }

    public String sp() {
        return this.yp;
    }

    public int t() {
        return this.i;
    }

    public String u() {
        return this.da;
    }

    public String uj() {
        return this.tt;
    }

    public String ve() {
        return this.u;
    }

    public String x() {
        return this.n;
    }

    public String yp() {
        return this.sl;
    }

    public String z() {
        return this.t;
    }

    public T a(String str) {
        this.x = str;
        return (T) rh();
    }

    public T i(String str) {
        this.z = str;
        return (T) rh();
    }

    public T n(String str) {
        this.yp = str;
        return (T) rh();
    }

    public T sp(String str) {
        this.da = str;
        return (T) rh();
    }

    public T tt(String str) {
        this.u = str;
        return (T) rh();
    }

    public T uj(String str) {
        this.ve = str;
        return (T) rh();
    }

    public T ve(String str) {
        this.tt = str;
        return (T) rh();
    }

    public T x(String str) {
        this.sl = str;
        return (T) rh();
    }

    public T tt(int i) {
        this.i = i;
        return (T) rh();
    }

    public T c(String str) {
        this.c = str;
        return (T) rh();
    }

    public T c(long j) {
        this.f28967a = j;
        return (T) rh();
    }

    public T c(int i) {
        this.sp = i;
        return (T) rh();
    }
}

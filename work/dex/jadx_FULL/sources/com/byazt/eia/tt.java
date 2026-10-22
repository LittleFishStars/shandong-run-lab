package com.byazt.eia;

import android.content.Context;
import com.ali.auth.third.login.LoginConstants;
import com.alibaba.ariver.engine.api.bridge.model.NativeCallContext;
import com.byazt.ete.gt;
import com.byazt.su.DownloadStatusChangeListener;
import com.bytedance.sdk.openadsdk.mediation.MediationConstant;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_11_8719cls.dex */
@com.byazt.ls.tt
@com.byazt.zqa.c(c = {0, 1, 1048, 13})
public class tt implements c, sp {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @com.byazt.ls.c(c = "context")
    public Context f28471a;

    @com.byazt.ls.c(c = "id", tt = "DSL")
    public String c;

    @com.byazt.ls.c(c = "is_click_button")
    public volatile boolean da;

    @com.byazt.ls.c(c = "market_url")
    public String gr;

    @com.byazt.ls.c(c = "app_manage")
    public JSONObject gt;

    @com.byazt.ls.c(c = "req_id")
    public String gu;

    @com.byazt.ls.c(c = "is_open_market_intercept_for_dsp")
    public volatile boolean i;

    @com.byazt.ls.c(c = LoginConstants.EXT)
    public String m;

    @com.byazt.ls.c(c = "not_valid_download_url")
    public boolean my;

    @com.byazt.ls.c(c = "download_popup_manager")
    public com.byazt.yzg.ve n;

    @com.byazt.ls.c(c = MediationConstant.EXTRA_ADID)
    public String nu;
    public com.byazt.ete.n p;

    @com.byazt.ls.c(c = "union_session_key")
    public String qy;

    @com.byazt.ls.c(c = "if_both_open")
    public int rh;

    @com.byazt.ls.c(c = "enable_update_download_model")
    public boolean rl;

    @com.byazt.ls.c(c = "download_url")
    public String sl;

    @com.byazt.ls.c(c = "download_conf")
    public JSONObject t;

    @com.byazt.ls.c(c = "url", tt = "DSL")
    public String tt;

    @com.byazt.ls.c(c = NativeCallContext.DOMAIN_APP)
    public JSONObject u;

    @com.byazt.ls.c(c = "download_status_listener")
    public DownloadStatusChangeListener uj;

    @com.byazt.ls.c(c = "event_tag")
    public String ve;

    @com.byazt.ls.c(c = "dialog_to_landing_page_convert")
    public com.byazt.hl.c yp;
    public gt yv;

    @com.byazt.ls.c(c = "pip_controller")
    public com.byazt.zd.tt z;
    public com.byazt.ete.a zm;

    @com.byazt.ls.c(c = "convert_from_landing_page")
    public volatile boolean sp = false;

    @com.byazt.ls.c(c = "need_check_compliance")
    public int x = 0;

    @Override // com.byazt.eia.sp
    public boolean B_() {
        return this.my;
    }

    public void c(String str) {
        this.sl = str;
    }

    public com.byazt.yzg.ve da() {
        return this.n;
    }

    public Context getContext() {
        return this.f28471a;
    }

    @Override // com.byazt.eia.sp
    public String gr() {
        return this.gr;
    }

    public boolean gt() {
        return this.rl;
    }

    @Override // com.byazt.eia.sp
    public String gu() {
        return q_() != null ? q_().optString(MediationConstant.EXTRA_ADID) : "";
    }

    public DownloadStatusChangeListener i() {
        return this.uj;
    }

    public com.byazt.hl.c m() {
        return this.yp;
    }

    public String n() {
        return this.m;
    }

    public com.byazt.zd.tt nu() {
        return this.z;
    }

    @Override // com.byazt.eia.sp
    public JSONObject q_() {
        try {
            return new JSONObject(n());
        } catch (JSONException unused) {
            return null;
        }
    }

    @Override // com.byazt.eia.sp
    public String qy() {
        return this.gu;
    }

    @Override // com.byazt.eia.sp
    public com.byazt.ete.a rh() {
        JSONObject jSONObject;
        if (this.zm == null && (jSONObject = this.gt) != null) {
            this.zm = new com.byazt.ete.a(jSONObject);
        }
        return this.zm;
    }

    @Override // com.byazt.eia.sp
    public String rl() {
        return this.qy;
    }

    public int sl() {
        return this.x;
    }

    public boolean sp() {
        return this.sp;
    }

    public boolean t() {
        return this.i;
    }

    public boolean u() {
        return this.da;
    }

    @Override // com.byazt.eia.sp
    public gt u_() {
        JSONObject jSONObject;
        if (this.yv == null && (jSONObject = this.t) != null) {
            this.yv = new gt(jSONObject);
        }
        return this.yv;
    }

    @Override // com.byazt.eia.sp
    public String uj() {
        return this.nu;
    }

    public String x() {
        return this.ve;
    }

    @Override // com.byazt.eia.sp
    public boolean x_() {
        return this.rh == 1;
    }

    public String yp() {
        return this.sl;
    }

    @Override // com.byazt.eia.sp
    public com.byazt.ete.n z() {
        JSONObject jSONObject;
        if (this.p == null && (jSONObject = this.u) != null) {
            com.byazt.ete.n nVarTt = com.byazt.omf.c.tt(jSONObject);
            this.p = nVarTt;
            nVarTt.uj(this.c);
            this.p.tt(this.tt);
        }
        return this.p;
    }

    @Override // com.byazt.eia.c
    public Map<String, String> c() {
        return new HashMap();
    }
}

package com.byazt.eia;

import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import com.ali.auth.third.login.LoginConstants;
import com.byazt.ete.kk;
import com.byazt.ete.nu;
import com.byazt.ete.q;
import com.byazt.ete.qy;
import com.byazt.ete.sv;
import com.byazt.ete.yp;
import com.bytedance.sdk.openadsdk.mediation.MediationConstant;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_11_8719cls.dex */
@com.byazt.ls.tt
@com.byazt.zqa.c(c = {0, 1, 1048, 46})
public class n implements c, i {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @com.byazt.ls.c(c = "toast", tt = "DSL")
    public String f28470a;

    @com.byazt.ls.c(c = "ec_schema", tt = "DSL")
    public String c;
    public q cu;
    public sv d;

    @com.byazt.ls.c(c = "context")
    public Context da;
    public JSONObject eo;

    @com.byazt.ls.c(c = LoginConstants.EXT)
    public String gr;

    @com.byazt.ls.c(c = "union_session_key")
    public String gt;

    @com.byazt.ls.c(c = "reward_live")
    public JSONObject gu;
    public yp h;

    @com.byazt.ls.c(c = "live_params", tt = "DSL")
    public String i;

    @com.byazt.ls.c(c = "live_info")
    public JSONObject m;

    @com.byazt.ls.c(c = "live_sdk_status_while_first_click")
    public int md;

    @com.byazt.ls.c(c = "saas_info")
    public JSONObject my;

    @com.byazt.ls.c(c = "link_url", tt = "DSL")
    public String n;

    @com.byazt.ls.c(c = "sub_convert_link")
    public JSONObject nu;
    public nu or;

    @com.byazt.ls.c(c = "saas_on_click_material")
    public JSONObject p;
    public kk qp;

    @com.byazt.ls.c(c = MediationConstant.EXTRA_ADID)
    public String qy;

    @com.byazt.ls.c(c = "deep_link")
    public JSONObject rh;

    @com.byazt.ls.c(c = "dynamic_configs")
    public String rl;

    @com.byazt.ls.c(c = "event_tag")
    public String sl;

    @com.byazt.ls.c(c = "live_type", tt = "DSL")
    public int sp;

    @com.byazt.ls.c(c = "dpa_tag")
    public String t;

    @com.byazt.ls.c(c = "coupon_scene", tt = "DSL")
    public int tt;

    @com.byazt.ls.c(c = "live_saas_interaction_type")
    public int u = -1;

    @com.byazt.ls.c(c = "amount", tt = "DSL")
    public int uj;

    @com.byazt.ls.c(c = "has_coupon", tt = "DSL")
    public boolean ve;

    @com.byazt.ls.c(c = "room_id", tt = "DSL")
    public String x;

    @com.byazt.ls.c(c = "view")
    public View yp;

    @com.byazt.ls.c(c = "coupon")
    public JSONObject yv;

    @com.byazt.ls.c(c = "handle_chain_data")
    public Map<String, Object> z;
    public qy zb;

    @com.byazt.ls.c(c = "req_id")
    public String zm;

    @Override // com.byazt.eia.i
    public q C_() {
        JSONObject jSONObject;
        if (this.cu == null && (jSONObject = this.my) != null) {
            this.cu = q.c(jSONObject);
        }
        return this.cu;
    }

    @Override // com.byazt.eia.i
    public kk D_() {
        JSONObject jSONObject = this.p;
        if (jSONObject != null && this.qp == null) {
            this.qp = kk.c(jSONObject);
        }
        return this.qp;
    }

    @Override // com.byazt.eia.c
    public Map<String, String> c() {
        return new HashMap();
    }

    @Override // com.byazt.eia.i
    public String da() {
        return this.x;
    }

    public Context getContext() {
        return this.da;
    }

    public int gu() {
        return this.md;
    }

    public Map<String, Object> i() {
        return this.z;
    }

    @Override // com.byazt.eia.i
    public String m() {
        return this.rl;
    }

    @Override // com.byazt.eia.i
    public yp my() {
        JSONObject jSONObject = this.yv;
        if (jSONObject != null && this.h == null) {
            yp ypVarC = yp.c(jSONObject);
            this.h = ypVarC;
            ypVarC.c(this.f28470a);
            this.h.c(this.tt);
            this.h.c(this.ve);
            this.h.c(this.uj);
        }
        return this.h;
    }

    @Override // com.byazt.eia.i
    public int n() {
        return this.sp;
    }

    @Override // com.byazt.eia.i
    public JSONObject q_() {
        if (this.gr != null && this.eo == null) {
            try {
                this.eo = new JSONObject(this.gr);
            } catch (JSONException unused) {
            }
        }
        return this.eo;
    }

    @Override // com.byazt.eia.i
    public String qy() {
        return this.zm;
    }

    @Override // com.byazt.eia.i
    public String rl() {
        return this.gt;
    }

    @Override // com.byazt.eia.i
    public sv sl() {
        JSONObject jSONObject = this.m;
        if (jSONObject != null && this.d == null) {
            this.d = sv.c(jSONObject);
        }
        return this.d;
    }

    public int sp() {
        return this.u;
    }

    @Override // com.byazt.eia.i
    public String t() {
        return this.i;
    }

    @Override // com.byazt.eia.i
    public String t_() {
        return this.c;
    }

    public String tt() {
        return this.sl;
    }

    @Override // com.byazt.eia.i
    public qy u() {
        JSONObject jSONObject;
        if (this.zb == null && (jSONObject = this.nu) != null) {
            this.zb = new qy(jSONObject, false);
        }
        return this.zb;
    }

    @Override // com.byazt.eia.i
    public String uj() {
        return this.qy;
    }

    public String ve() {
        return this.t;
    }

    @Override // com.byazt.eia.i
    public String w_() {
        return this.gr;
    }

    public View x() {
        return this.yp;
    }

    @Override // com.byazt.eia.i
    public boolean y_() {
        return this.gu != null;
    }

    @Override // com.byazt.eia.i
    public nu yp() {
        if (this.or == null) {
            this.or = new nu(this.rh);
            if (!TextUtils.isEmpty(this.n)) {
                this.or.tt(this.n);
            }
        }
        return this.or;
    }

    public void c(int i) {
        this.md = i;
    }
}

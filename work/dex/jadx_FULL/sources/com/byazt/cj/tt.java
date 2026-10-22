package com.byazt.cj;

import android.content.Context;
import com.byazt.ete.ic;
import com.bytedance.sdk.openadsdk.core.activity.base.TTDelegateActivity;
import com.bytedance.sdk.openadsdk.mediation.MediationConstant;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_11_8719cls.dex */
@com.byazt.ls.tt
@com.byazt.zqa.c(c = {0, 1, 55, 13})
public class tt implements com.byazt.kkb.ve {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @com.byazt.ls.c(c = "confirm_event")
    public String f28361a;

    @com.byazt.ls.c(c = "context")
    public Context c;

    @com.byazt.ls.c(c = "app_manage_model")
    public String n;

    @com.byazt.ls.c(c = "deny_event")
    public String sp;

    @com.byazt.ls.c(c = "material_meta")
    public ic tt;

    @com.byazt.ls.c(c = "function_desc_popup_listener")
    public com.byazt.aas.n.c uj;

    @com.byazt.ls.c(c = MediationConstant.EXTRA_ADID)
    public String ve;

    @com.byazt.ls.c(c = "cancel_event")
    public String x;

    @Override // com.byazt.kkb.ve
    public boolean c(Map<String, Object> map, Map<String, Object> map2, com.byazt.cq.c cVar) {
        com.byazt.aas.n.c(this.ve, c());
        TTDelegateActivity.ve(this.c, this.ve, this.n);
        cVar.c(map2);
        return true;
    }

    private com.byazt.aas.n.c c() {
        return new com.byazt.aas.n.c() { // from class: com.byazt.cj.tt.1
            @Override // com.byazt.aas.n.c
            public void c() {
                if (tt.this.uj == null) {
                    return;
                }
                tt.this.uj.c();
                tt ttVar = tt.this;
                ttVar.c(ttVar.f28361a);
            }

            @Override // com.byazt.aas.n.c
            public void tt() {
                if (tt.this.uj == null) {
                    return;
                }
                tt.this.uj.tt();
                tt ttVar = tt.this;
                ttVar.c(ttVar.sp);
            }

            @Override // com.byazt.aas.n.c
            public void ve() {
                if (tt.this.uj == null) {
                    return;
                }
                tt.this.uj.ve();
                tt ttVar = tt.this;
                ttVar.c(ttVar.x);
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(String str) {
        HashMap map = new HashMap();
        map.put("material_meta", this.tt);
        map.put("context", this.c);
        com.byazt.ppf.ve.c(str, this.tt.yg(), map);
    }
}

package com.byazt.cj;

import android.content.Context;
import android.text.TextUtils;
import com.byazt.ete.ic;
import com.bytedance.sdk.openadsdk.core.activity.base.TTDelegateActivity;
import com.bytedance.sdk.openadsdk.mediation.MediationConstant;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_11_8719cls.dex */
@com.byazt.ls.tt
@com.byazt.zqa.c(c = {0, 1, 55, 46})
public class n implements com.byazt.kkb.ve {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @com.byazt.ls.c(c = "confirm_event")
    public String f28357a;

    @com.byazt.ls.c(c = "context")
    public Context c;

    @com.byazt.ls.c(c = "app_manage_model")
    public String n;

    @com.byazt.ls.c(c = "deny_event")
    public String sp;

    @com.byazt.ls.c(c = "material_meta")
    public ic tt;

    @com.byazt.ls.c(c = "registration_popup_listener")
    public com.byazt.aas.n.c uj;

    @com.byazt.ls.c(c = MediationConstant.EXTRA_ADID)
    public String ve;

    @com.byazt.ls.c(c = "cancel_event")
    public String x;

    @Override // com.byazt.kkb.ve
    public boolean c(Map<String, Object> map, Map<String, Object> map2, com.byazt.cq.c cVar) {
        com.byazt.aas.n.c(this.ve, c());
        TTDelegateActivity.c(this.c, this.ve, this.n, this.tt);
        cVar.c(map2);
        return true;
    }

    private com.byazt.aas.n.c c() {
        return new com.byazt.aas.n.c() { // from class: com.byazt.cj.n.1
            @Override // com.byazt.aas.n.c
            public void c() {
                if (n.this.uj == null) {
                    return;
                }
                n.this.uj.c();
                n nVar = n.this;
                nVar.c(nVar.f28357a);
            }

            @Override // com.byazt.aas.n.c
            public void tt() {
                if (n.this.uj == null) {
                    return;
                }
                n.this.uj.tt();
                n nVar = n.this;
                nVar.c(nVar.sp);
            }

            @Override // com.byazt.aas.n.c
            public void ve() {
                if (n.this.uj == null) {
                    return;
                }
                n.this.uj.ve();
                n nVar = n.this;
                nVar.c(nVar.x);
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(String str) {
        if (this.tt == null || TextUtils.isEmpty(str)) {
            return;
        }
        HashMap map = new HashMap();
        map.put("material_meta", this.tt);
        map.put("context", this.c);
        com.byazt.ppf.ve.c(str, this.tt.yg(), map);
    }
}

package com.byazt.pg;

import android.app.Activity;
import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.ShapeDrawable;
import android.graphics.drawable.shapes.OvalShape;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import com.alibaba.ariver.engine.api.bridge.model.NativeCallContext;
import com.alibaba.ariver.jsapi.multimedia.video.a;
import com.byazt.aas.nb;
import com.byazt.aas.pf;
import com.byazt.bwm.n;
import com.byazt.ddx.sp;
import com.byazt.ete.ic;
import com.byazt.ete.uj;
import com.byazt.ete.xd;
import com.byazt.nr.m;
import com.byazt.nr.z;
import com.byazt.omf.gt;
import com.byazt.omf.gu;
import com.byazt.yih.x;
import com.bytedance.sdk.openadsdk.core.activity.base.TTNativePageActivity;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_11_8719cls.dex */
@com.byazt.zqa.c(c = {0, 1, 1322, 20})
public class c implements tt.c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public sp f28941a;
    public ic c;
    public com.byazt.pop.ve da;
    public com.byazt.xj.ve i;
    public com.byazt.ua.c m;
    public int n;
    public com.byazt.pop.c nu = new com.byazt.pop.c() { // from class: com.byazt.pg.c.1
        @Override // com.byazt.pop.c
        public void c() {
        }

        @Override // com.byazt.pop.c
        public void c(long j, long j2, String str, String str2) {
        }

        @Override // com.byazt.pop.c
        public void c(long j, String str, String str2) {
        }

        @Override // com.byazt.pop.c
        public void c(String str, String str2) {
        }

        @Override // com.byazt.pop.c
        public void tt(long j, long j2, String str, String str2) {
        }

        @Override // com.byazt.pop.c
        public void ve(long j, long j2, String str, String str2) {
        }
    };
    public JSONObject sl;
    public Activity sp;
    public uj t;
    public tt tt;
    public String u;
    public String uj;
    public com.byazt.qj.c ve;
    public ViewGroup x;
    public com.byazt.qzm.tt yp;
    public com.byazt.vn.tt z;

    public c(Activity activity, ViewGroup viewGroup, sp spVar, ic icVar, String str, int i, com.byazt.ua.c cVar) {
        this.c = icVar;
        this.sp = activity;
        this.f28941a = spVar;
        this.x = viewGroup;
        this.uj = str;
        this.n = i;
        this.m = cVar;
    }

    private void i() {
        com.byazt.qzm.tt ttVar = this.yp;
        if (ttVar != null) {
            ttVar.c(this.m);
        }
    }

    private String sp() {
        return nb.my(this.c);
    }

    private void x() {
        if (this.da == null) {
            com.byazt.pop.ve veVarC = x.c(this.sp, this.u, this.c, this.uj);
            this.da = veVarC;
            veVarC.c(com.byazt.wz.x.c(this.c));
            this.da.c(this.nu, false);
            this.da.c(false);
        }
        this.da.c(this.sp, false);
    }

    public void c(com.byazt.xj.ve<View> veVar) {
    }

    public void c(JSONObject jSONObject) {
    }

    private String a() {
        JSONObject jSONObject = this.sl;
        if (jSONObject == null) {
            return sp();
        }
        JSONArray jSONArrayOptJSONArray = jSONObject.optJSONArray("download_buttons");
        if (jSONArrayOptJSONArray == null) {
            return sp();
        }
        JSONObject jSONObjectOptJSONObject = jSONArrayOptJSONArray.optJSONObject(0);
        if (jSONObjectOptJSONObject == null) {
            return sp();
        }
        String strOptString = jSONObjectOptJSONObject.optString("url");
        return TextUtils.isEmpty(strOptString) ? sp() : strOptString;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void n() {
        ic icVar = this.c;
        if (icVar == null || xd.da(icVar) != 200) {
            return;
        }
        com.byazt.xj.ve veVarUj = this.i.uj("video");
        if (veVarUj instanceof com.byazt.qzm.tt) {
            com.byazt.qzm.tt ttVar = (com.byazt.qzm.tt) veVarUj;
            this.yp = ttVar;
            ttVar.n(true);
            i();
        }
        com.byazt.xj.ve veVarUj2 = this.i.uj(a.f);
        if (veVarUj2 instanceof com.byazt.vn.tt) {
            this.z = (com.byazt.vn.tt) veVarUj2;
            ShapeDrawable shapeDrawable = new ShapeDrawable(new OvalShape());
            shapeDrawable.getPaint().setColor(Color.parseColor("#99333333"));
            shapeDrawable.setIntrinsicWidth(pf.ve(this.sp, 28.0f));
            shapeDrawable.setIntrinsicHeight(pf.ve(this.sp, 28.0f));
            this.z.i().setBackground(shapeDrawable);
        }
        com.byazt.ua.c cVar = this.m;
        if (cVar != null) {
            c(cVar.x);
        } else {
            c(true);
        }
    }

    private void uj(final JSONObject jSONObject) {
        if (this.t != null) {
            try {
                JSONObject jSONObject2 = new JSONObject(this.t.x());
                jSONObject2.put("is_support_func_desc", "true");
                jSONObject.put(NativeCallContext.DOMAIN_APP, jSONObject2);
                ve(jSONObject);
                return;
            } catch (Throwable unused) {
                return;
            }
        }
        String strA = a();
        this.u = strA;
        if (!TextUtils.isEmpty(strA)) {
            n.tt(new com.byazt.bwm.sp("tt_pl_download_check") { // from class: com.byazt.pg.c.5
                @Override // java.lang.Runnable
                public void run() {
                    JSONObject jSONObject3;
                    c cVar = c.this;
                    gu<com.byazt.ddx.c> guVarC = gt.c();
                    c cVar2 = c.this;
                    cVar.t = guVarC.c(cVar2.c, cVar2.u);
                    try {
                        if (c.this.t != null) {
                            jSONObject3 = new JSONObject(c.this.t.x());
                        } else {
                            jSONObject3 = c.this.c.fv() != null ? new JSONObject(c.this.c.fv()) : new JSONObject();
                        }
                        jSONObject3.put("is_support_func_desc", "true");
                        jSONObject.put(NativeCallContext.DOMAIN_APP, jSONObject3);
                        jSONObject3.put("download_url", c.this.u);
                        c.this.ve(jSONObject);
                    } catch (Throwable unused2) {
                    }
                }
            });
            return;
        }
        com.byazt.qj.c cVar = this.ve;
        if (cVar != null) {
            cVar.c(-4);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ve(final JSONObject jSONObject) {
        com.byazt.ux.n.c(this.c.lt(), "lp_" + this.c.pu(), this.c.to(), new com.byazt.ux.n.c() { // from class: com.byazt.pg.c.3
            @Override // com.byazt.ux.n.c
            public void c(JSONObject jSONObject2) {
                if (jSONObject2 == null) {
                    c.this.f28941a.c(-1, "template info load fail");
                    com.byazt.qj.c cVar = c.this.ve;
                    if (cVar != null) {
                        cVar.c(-1);
                        return;
                    }
                    return;
                }
                try {
                    jSONObject.put("creative", c.this.c.yg());
                    c.this.c(jSONObject);
                    c.this.c(jSONObject2, jSONObject);
                } catch (JSONException e) {
                    m.c(e);
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void tt(JSONObject jSONObject) {
        this.sl = jSONObject;
        uj(jSONObject);
    }

    private void tt(boolean z) {
        x();
        com.byazt.pop.ve veVar = this.da;
        if (veVar instanceof com.byazt.wz.sp) {
            ((com.byazt.wz.sp) veVar).x().c(z);
        }
    }

    private void ve(boolean z) {
        tt(false);
        uj(z);
    }

    public void c(com.byazt.qj.c cVar) {
        this.ve = cVar;
    }

    private void ve(ic icVar) {
        String strI;
        if (icVar == null) {
            return;
        }
        com.byazt.ete.a aVarRh = icVar.rh();
        uj ujVar = this.t;
        if (ujVar != null) {
            strI = ujVar.n();
        } else {
            strI = aVarRh == null ? "" : aVarRh.i();
        }
        com.byazt.aas.n.tt(this.sp, strI, icVar.uj(), new com.byazt.aas.n.c() { // from class: com.byazt.pg.c.8
            @Override // com.byazt.aas.n.c
            public void c() {
                c.this.uj(true);
                if (c.this.sp instanceof TTNativePageActivity) {
                    ((TTNativePageActivity) c.this.sp).t();
                }
            }

            @Override // com.byazt.aas.n.c
            public void tt() {
                if (c.this.sp instanceof TTNativePageActivity) {
                    ((TTNativePageActivity) c.this.sp).t();
                }
            }

            @Override // com.byazt.aas.n.c
            public void ve() {
                if (c.this.sp instanceof TTNativePageActivity) {
                    ((TTNativePageActivity) c.this.sp).t();
                }
            }
        });
    }

    public void c() {
        this.tt = new tt(this.sp, this.f28941a, this.uj, this.n);
        if (this.c.kp() != null) {
            try {
                tt(new JSONObject(this.c.kp().toString()));
                return;
            } catch (JSONException e) {
                m.c(e);
                return;
            }
        }
        int iPu = this.c.pu();
        if (iPu != 5 && iPu != 4) {
            com.byazt.hy.tt.c(this.c.lo(), new com.byazt.hy.tt.c() { // from class: com.byazt.pg.c.2
                @Override // com.byazt.hy.tt.c
                public void c(JSONObject jSONObject) {
                    c.this.tt(jSONObject);
                }

                @Override // com.byazt.hy.tt.c
                public void c(int i, String str) {
                    c.this.f28941a.c(-3, "ad meta info load fail");
                    com.byazt.qj.c cVar = c.this.ve;
                    if (cVar != null) {
                        cVar.c(-3);
                    }
                }
            });
        } else {
            tt(new JSONObject());
        }
    }

    private boolean tt(com.byazt.sz.m mVar) {
        if (mVar == null) {
            return false;
        }
        View viewI = mVar.c().i();
        if (!(viewI instanceof TextView)) {
            return false;
        }
        CharSequence text = ((TextView) viewI).getText();
        if (TextUtils.isEmpty(text)) {
            return false;
        }
        return text.toString().contains("下载");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void uj(boolean z) {
        x();
        com.byazt.hkv.c cVar = new com.byazt.hkv.c(this.sp, this.c, "embeded_ad_landingpage", this.n);
        ((com.byazt.nat.c) cVar.c(com.byazt.nat.c.class)).ve(true);
        ((com.byazt.nat.c) cVar.c(com.byazt.nat.c.class)).c(true);
        this.da.tt(z);
        this.da.c(this.c, false);
        ((com.byazt.nat.c) cVar.c(com.byazt.nat.c.class)).c(this.da);
        this.da.c(nb.qy(this.c), false);
    }

    public void ve() {
        com.byazt.pop.ve veVar = this.da;
        if (veVar != null) {
            veVar.tt();
        }
        com.byazt.qzm.tt ttVar = this.yp;
        if (ttVar != null) {
            ttVar.q();
        }
    }

    private void tt(ic icVar) {
        String strFv;
        if (icVar == null) {
            return;
        }
        if (this.t != null) {
            com.byazt.ete.a aVarRh = icVar.rh();
            if (aVarRh != null) {
                this.t.c(aVarRh.uj());
                this.t.c(aVarRh.ve());
            }
            strFv = this.t.x();
        } else {
            strFv = icVar.fv();
        }
        Activity activity = this.sp;
        if (activity instanceof TTNativePageActivity) {
            ((TTNativePageActivity) activity).sl();
        }
        com.byazt.aas.n.c(this.sp, icVar.uj(), new com.byazt.aas.n.c() { // from class: com.byazt.pg.c.7
            @Override // com.byazt.aas.n.c
            public void c() {
                c.this.uj(true);
                if (c.this.sp instanceof TTNativePageActivity) {
                    ((TTNativePageActivity) c.this.sp).t();
                }
            }

            @Override // com.byazt.aas.n.c
            public void tt() {
                if (c.this.sp instanceof TTNativePageActivity) {
                    ((TTNativePageActivity) c.this.sp).t();
                }
            }

            @Override // com.byazt.aas.n.c
            public void ve() {
                if (c.this.sp instanceof TTNativePageActivity) {
                    ((TTNativePageActivity) c.this.sp).t();
                }
            }
        }, strFv);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(JSONObject jSONObject, JSONObject jSONObject2) {
        this.f28941a.tt();
        this.tt.c(this);
        this.tt.c(jSONObject, jSONObject2, new com.byazt.ux.sp() { // from class: com.byazt.pg.c.4
            @Override // com.byazt.ux.sp
            public void c(int i, String str) {
                com.byazt.qj.c cVar = c.this.ve;
                if (cVar != null) {
                    cVar.c(i);
                }
            }

            @Override // com.byazt.ux.sp
            public void c(com.byazt.xj.ve<View> veVar) {
                c.this.i = veVar;
                c.this.x.addView(veVar.i(), new FrameLayout.LayoutParams(veVar.or(), veVar.cu()));
                com.byazt.qj.c cVar = c.this.ve;
                if (cVar != null) {
                    cVar.c(veVar.i());
                }
                c.this.n();
                c.this.c(veVar);
            }
        });
    }

    private void c(boolean z) {
        com.byazt.qzm.tt ttVar = this.yp;
        if (ttVar != null) {
            ttVar.uj(z);
        }
        com.byazt.vn.tt ttVar2 = this.z;
        if (ttVar2 == null || ttVar2.i() == null) {
            return;
        }
        z.c((Context) this.sp, z ? "tt_mute" : "tt_unmute", (ImageView) this.z.i(), 320);
    }

    public void uj() {
        com.byazt.pop.ve veVar = this.da;
        if (veVar != null) {
            veVar.ve();
        }
    }

    @Override // com.byazt.pg.tt.c
    public void c(com.byazt.sz.m mVar) {
        JSONObject jSONObjectVe;
        com.byazt.qzm.tt ttVar;
        if (mVar == null || mVar.tt() != 1 || (jSONObjectVe = mVar.ve()) == null) {
            return;
        }
        String strOptString = jSONObjectVe.optString("type");
        strOptString.hashCode();
        switch (strOptString) {
            case "openAppPermission":
                c(this.c);
                break;
            case "clickVideo":
                com.byazt.qzm.tt ttVar2 = this.yp;
                if (ttVar2 != null) {
                    ttVar2.oz();
                    break;
                }
                break;
            case "openAppFunctionDesc":
                ve(this.c);
                break;
            case "downloadEvent":
                tt(true);
                uj(tt(mVar));
                break;
            case "downloadDirect":
                ve(tt(mVar));
                break;
            case "muteVideo":
                if (this.z != null && (ttVar = this.yp) != null) {
                    c(!ttVar.x());
                    break;
                }
                break;
            case "openAppPolicy":
                tt(this.c);
                break;
            case "openInfringement":
                com.byazt.aas.n.c(this.sp, this.uj, this.c);
                break;
        }
    }

    public void tt() {
        com.byazt.qzm.tt ttVar = this.yp;
        if (ttVar != null) {
            ttVar.kk();
        }
    }

    private void c(ic icVar) {
        String strFv;
        if (icVar == null) {
            return;
        }
        if (this.t != null) {
            com.byazt.ete.a aVarRh = icVar.rh();
            if (aVarRh != null) {
                this.t.c(aVarRh.uj());
                this.t.c(aVarRh.ve());
            }
            strFv = this.t.x();
        } else {
            strFv = icVar.fv();
        }
        Activity activity = this.sp;
        if (activity instanceof TTNativePageActivity) {
            ((TTNativePageActivity) activity).sl();
        }
        com.byazt.aas.n.c(this.sp, icVar.uj(), strFv, new com.byazt.aas.n.c() { // from class: com.byazt.pg.c.6
            @Override // com.byazt.aas.n.c
            public void c() {
                c.this.uj(true);
                if (c.this.sp instanceof TTNativePageActivity) {
                    ((TTNativePageActivity) c.this.sp).t();
                }
            }

            @Override // com.byazt.aas.n.c
            public void tt() {
                if (c.this.sp instanceof TTNativePageActivity) {
                    ((TTNativePageActivity) c.this.sp).t();
                }
            }

            @Override // com.byazt.aas.n.c
            public void ve() {
                if (c.this.sp instanceof TTNativePageActivity) {
                    ((TTNativePageActivity) c.this.sp).t();
                }
            }
        });
    }
}

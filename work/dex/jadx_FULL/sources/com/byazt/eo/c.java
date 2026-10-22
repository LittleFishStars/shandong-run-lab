package com.byazt.eo;

import android.app.Activity;
import android.app.Dialog;
import android.view.View;
import com.byazt.cv.da;
import com.byazt.hz.sl;
import com.byazt.nc.sp;
import com.byazt.nc.uj;
import com.byazt.nc.yp;
import com.byazt.sbm.n;
import java.util.Map;
import org.json.JSONObject;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_11_8719cls.dex */
@com.byazt.zqa.c(c = {0, 1, 47, 20})
public class c extends yp {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public com.byazt.ocd.ve f28475a;
    public final sl c;
    public View n = null;
    public com.byazt.ft.ve sp;
    public com.byazt.dhf.c tt;
    public com.byazt.ft.tt uj;
    public com.byazt.ft.c ve;
    public com.byazt.ocd.tt x;

    public c(sl slVar) {
        this.c = slVar;
        c();
    }

    private void uj() {
        com.byazt.ft.ve veVar;
        sl slVar = this.c;
        if (slVar == null || (veVar = this.sp) == null) {
            return;
        }
        slVar.c(veVar);
    }

    @Override // com.byazt.nc.yp
    public void destroy() {
        if (this.n != null) {
            this.n = null;
        }
        sl slVar = this.c;
        if (slVar != null) {
            slVar.ve();
        }
        if (this.f28475a != null) {
            this.f28475a = null;
        }
        if (this.sp != null) {
            this.sp = null;
        }
    }

    @Override // com.byazt.nc.yp
    public sp getDislikeDialog(Activity activity) {
        sl slVar = this.c;
        if (slVar != null) {
            return slVar.c(activity);
        }
        return null;
    }

    @Override // com.byazt.nc.yp
    public uj getDislikeInfo() {
        sl slVar = this.c;
        if (slVar != null) {
            return slVar.yp();
        }
        return null;
    }

    @Override // com.byazt.nc.yp
    public View getExpressAdView() {
        sl slVar;
        if (this.n == null && (slVar = this.c) != null) {
            this.n = slVar.n();
        }
        tt();
        uj();
        ve();
        return this.n;
    }

    @Override // com.byazt.nc.yp
    public int getImageMode() {
        sl slVar = this.c;
        if (slVar != null) {
            return slVar.a();
        }
        return 0;
    }

    @Override // com.byazt.nc.yp
    public int getInteractionType() {
        sl slVar = this.c;
        if (slVar != null) {
            return slVar.u();
        }
        return -1;
    }

    @Override // com.byazt.nc.yp
    public String getLifecycleId() {
        return null;
    }

    @Override // com.byazt.nc.yp
    public Map<String, Object> getMediaExtraInfo() {
        sl slVar = this.c;
        if (slVar != null) {
            return slVar.sp();
        }
        return null;
    }

    @Override // com.byazt.nc.yp
    public n getMediationManager() {
        return new da(new tt(this.c));
    }

    @Override // com.byazt.nc.x
    public void loss(Double d, String str, String str2) {
    }

    @Override // com.byazt.nc.yp
    public void registerClickableRects(JSONObject jSONObject) {
    }

    @Override // com.byazt.nc.yp
    public void render() {
        com.byazt.ft.tt ttVar = this.uj;
        if (ttVar != null) {
            ttVar.c(this.n, 0.0f, 0.0f);
        }
        com.byazt.ft.c cVar = this.ve;
        if (cVar != null) {
            cVar.c(this.n, 0.0f, 0.0f);
        }
    }

    @Override // com.byazt.nc.x
    public void setAdInteractionListener(com.byazt.ocd.tt ttVar) {
        this.x = ttVar;
        sl slVar = this.c;
        if (slVar != null) {
            slVar.c(ttVar);
        }
    }

    @Override // com.byazt.nc.yp
    public void setCanInterruptVideoPlay(boolean z) {
    }

    @Override // com.byazt.nc.yp
    public void setDislikeCallback(Activity activity, com.byazt.dhf.c cVar) {
        this.tt = cVar;
        sl slVar = this.c;
        if (slVar != null) {
            slVar.c(activity, cVar);
        }
    }

    @Override // com.byazt.nc.yp
    public void setDislikeDialog(Dialog dialog, Integer[] numArr) {
        sl slVar = this.c;
        if (slVar != null) {
            slVar.c(dialog, numArr);
        }
    }

    @Override // com.byazt.nc.yp
    public void setDownloadListener(com.byazt.ocd.ve veVar) {
        this.f28475a = veVar;
        tt();
    }

    @Override // com.byazt.nc.yp
    public void setExpressInteractionListener(com.byazt.ft.tt ttVar) {
        this.uj = ttVar;
    }

    @Override // com.byazt.nc.x
    public void setPrice(Double d) {
    }

    @Override // com.byazt.nc.yp
    public void setSlideIntervalTime(int i) {
    }

    @Override // com.byazt.nc.yp
    public void setVideoAdListener(com.byazt.ft.ve veVar) {
        this.sp = veVar;
        uj();
    }

    @Override // com.byazt.nc.yp
    public void showInteractionExpressAd(Activity activity) {
    }

    @Override // com.byazt.nc.yp
    public void unRegisterRects() {
    }

    @Override // com.byazt.nc.yp
    public void uploadDislikeEvent(String str) {
        sl slVar = this.c;
        if (slVar != null) {
            slVar.c(str);
        }
    }

    @Override // com.byazt.nc.x
    public void win(Double d) {
    }

    private void c() {
        sl slVar = this.c;
        if (slVar != null) {
            slVar.c(new com.byazt.oc.c() { // from class: com.byazt.eo.c.1
                @Override // com.byazt.oc.c
                public void c() {
                    if (c.this.tt != null) {
                        c.this.tt.c(0, "ad closed", true);
                    }
                    if (c.this.ve != null) {
                        c.this.ve.c();
                    }
                }

                @Override // com.byazt.oc.c
                public void c(com.byazt.pp.c cVar) {
                }

                @Override // com.byazt.oc.c
                public void tt(View view) {
                    if (c.this.uj != null) {
                        c.this.uj.tt(view, 0);
                    }
                    if (c.this.ve != null) {
                        c.this.ve.tt(view, 0);
                    }
                }

                @Override // com.byazt.oc.c
                public void c(View view) {
                    if (c.this.uj != null) {
                        c.this.uj.c(view, 0);
                    }
                    if (c.this.ve != null) {
                        c.this.ve.c(view, 0);
                    }
                }
            });
        }
    }

    private void tt() {
        com.byazt.ocd.ve veVar;
        sl slVar = this.c;
        if (slVar == null || (veVar = this.f28475a) == null) {
            return;
        }
        slVar.c(veVar);
    }

    private void ve() {
        com.byazt.ocd.tt ttVar;
        sl slVar = this.c;
        if (slVar == null || (ttVar = this.x) == null) {
            return;
        }
        slVar.c(ttVar);
    }

    @Override // com.byazt.nc.yp
    public void setExpressInteractionListener(com.byazt.ft.c cVar) {
        this.ve = cVar;
    }
}

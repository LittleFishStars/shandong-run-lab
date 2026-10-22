package com.byazt.xs;

import android.content.Context;
import android.os.Looper;
import android.view.View;
import com.byazt.sz.m;
import com.byazt.sz.rh;
import com.byazt.sz.yp;
import com.byazt.sz.z;
import org.json.JSONObject;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_11_8719cls.dex */
@com.byazt.zqa.c(c = {0, 1, 468, 71})
public class x implements rh {
    public Context c;
    public com.byazt.xj.ve<View> tt;
    public com.byazt.sgn.ve.c ve;

    public x(Context context) {
        this.c = context;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void tt(JSONObject jSONObject, JSONObject jSONObject2, com.byazt.ux.sp spVar) {
        z zVar = new z(this.c);
        yp ypVar = new yp();
        ypVar.c(this.c);
        zVar.c("ugen_download_dialog", ypVar);
        com.byazt.xj.ve<View> veVarC = zVar.c(jSONObject);
        this.tt = veVarC;
        if (veVarC != null) {
            zVar.c(this);
            zVar.tt(jSONObject2);
        }
        if (spVar == null) {
            return;
        }
        com.byazt.xj.ve<View> veVar = this.tt;
        if (veVar == null) {
            spVar.c(-1, "UGenWidget is null");
        } else {
            spVar.c(veVar);
        }
    }

    @Override // com.byazt.sz.rh
    public void c(com.byazt.xj.ve veVar, String str, com.byazt.pm.a.c cVar) {
    }

    public void c(com.byazt.sgn.ve.c cVar) {
        this.ve = cVar;
    }

    public void c(final JSONObject jSONObject, final JSONObject jSONObject2, final com.byazt.ux.sp spVar) {
        if (Looper.myLooper() == Looper.getMainLooper()) {
            tt(jSONObject, jSONObject2, spVar);
        } else {
            com.byazt.omf.rh.a().post(new Runnable() { // from class: com.byazt.xs.x.1
                @Override // java.lang.Runnable
                public void run() {
                    x.this.tt(jSONObject, jSONObject2, spVar);
                }
            });
        }
    }

    @Override // com.byazt.sz.rh
    public void c(m mVar, rh.tt ttVar, rh.c cVar) {
        JSONObject jSONObjectVe;
        if (mVar == null || this.ve == null) {
            return;
        }
        if (mVar.tt() != 1 || (jSONObjectVe = mVar.ve()) == null) {
        }
        String strOptString = jSONObjectVe.optString("type");
        strOptString.hashCode();
        switch (strOptString) {
            case "openAppPermission":
                this.ve.tt(null);
                break;
            case "openAppFunctionDesc":
                this.ve.n(null);
                break;
            case "closeDialog":
                this.ve.ve(null);
                break;
            case "downloadEvent":
                this.ve.c(null);
                break;
            case "openAppPolicy":
                this.ve.uj(null);
                break;
        }
    }
}

package com.byazt.pg;

import android.content.Context;
import android.os.Looper;
import android.view.MotionEvent;
import android.view.View;
import com.byazt.ddx.sp;
import com.byazt.pm.a;
import com.byazt.sz.gt;
import com.byazt.sz.m;
import com.byazt.sz.rh;
import com.byazt.sz.z;
import org.json.JSONObject;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_11_8719cls.dex */
@com.byazt.zqa.c(c = {0, 1, 1322, 13})
public class tt implements gt, rh {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public String f28942a;
    public Context c;
    public gt n;
    public int sp;
    public sp tt;
    public c uj;
    public com.byazt.xj.ve<View> ve;

    public interface c {
        void c(m mVar);
    }

    public tt(Context context, sp spVar, String str, int i) {
        this.c = context;
        this.tt = spVar;
        this.f28942a = str;
        this.sp = i;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void tt(JSONObject jSONObject, JSONObject jSONObject2, com.byazt.ux.sp spVar) {
        z zVar = new z(this.c);
        com.byazt.xj.ve<View> veVarC = zVar.c(jSONObject);
        this.ve = veVarC;
        if (veVarC == null) {
            sp spVar2 = this.tt;
            if (spVar2 != null) {
                spVar2.c(-1, "ugeno render fail");
            }
            if (spVar != null) {
                spVar.c(-1, "");
                return;
            }
            return;
        }
        zVar.c((gt) this);
        zVar.c((rh) this);
        zVar.tt(jSONObject2);
        this.tt.c(0L);
        if (spVar != null) {
            spVar.c(this.ve);
        }
    }

    @Override // com.byazt.sz.rh
    public void c(com.byazt.xj.ve veVar, String str, a.c cVar) {
    }

    public void c(c cVar) {
        this.uj = cVar;
    }

    public void c(gt gtVar) {
        this.n = gtVar;
    }

    public void c(final JSONObject jSONObject, final JSONObject jSONObject2, final com.byazt.ux.sp spVar) {
        if (Looper.myLooper() == Looper.getMainLooper()) {
            tt(jSONObject, jSONObject2, spVar);
        } else {
            com.byazt.omf.rh.a().post(new Runnable() { // from class: com.byazt.pg.tt.1
                @Override // java.lang.Runnable
                public void run() {
                    tt.this.tt(jSONObject, jSONObject2, spVar);
                }
            });
        }
    }

    @Override // com.byazt.sz.rh
    public void c(m mVar, rh.tt ttVar, rh.c cVar) {
        c cVar2;
        if (mVar == null || mVar.tt() != 1 || (cVar2 = this.uj) == null) {
            return;
        }
        cVar2.c(mVar);
    }

    @Override // com.byazt.sz.gt
    public void c(com.byazt.xj.ve veVar, MotionEvent motionEvent) {
        gt gtVar = this.n;
        if (gtVar != null) {
            gtVar.c(veVar, motionEvent);
        }
    }
}

package com.byazt.pg;

import android.app.Activity;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import com.byazt.aas.pf;
import com.byazt.aas.rl;
import com.byazt.ddx.sp;
import com.byazt.dna.u;
import com.byazt.ete.i;
import com.byazt.ete.ic;
import com.byazt.nr.m;
import com.byazt.omf.x;
import com.byazt.sz.gt;
import com.byazt.ut.uj;
import org.json.JSONObject;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_11_8719cls.dex */
@com.byazt.zqa.c(c = {0, 1, 1322, 54})
public class ve extends c implements gt {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public boolean f28943a;
    public float da;
    public float i;
    public long sl;
    public float sp;
    public com.byazt.xj.ve t;
    public float x;

    public ve(Activity activity, ViewGroup viewGroup, sp spVar, ic icVar, String str, int i, com.byazt.ua.c cVar) {
        super(activity, viewGroup, spVar, icVar, str, i, cVar);
    }

    private void a() {
        Animation animation;
        com.byazt.xj.ve veVar = this.t;
        if (veVar != null) {
            veVar.tt(8);
            View viewI = this.t.i();
            if (viewI == null || (animation = viewI.getAnimation()) == null) {
                return;
            }
            animation.cancel();
        }
    }

    private int n() {
        return (int) (((double) (rl.n(this.c) * this.c.cs())) / 100.0d);
    }

    @Override // com.byazt.pg.c
    public void c(JSONObject jSONObject) {
        this.tt.c((gt) this);
        try {
            jSONObject.put("isPlayable", "true");
            jSONObject.put("remainTime", n());
        } catch (Exception e) {
            m.c(e);
        }
    }

    @Override // com.byazt.pg.c
    public void uj() {
        super.uj();
        a();
    }

    @Override // com.byazt.pg.c
    public void c(com.byazt.xj.ve<View> veVar) {
        this.t = veVar.uj("fl_count_down");
    }

    private void c(MotionEvent motionEvent) {
        if (!this.f28943a) {
            int displayDpi = ((u) uj.getService("device_info_new")).getDisplayDpi();
            com.byazt.ddx.uj.c("click", this.c, new i.c().a(this.sp).n(this.x).uj(this.i).ve(this.da).tt(this.sl).c(motionEvent.getEventTime()).uj(motionEvent.getToolType(0)).n(motionEvent.getDeviceId()).a(this.n).ve(x.m().tt() ? 1 : 2).tt(displayDpi).c(pf.a(com.byazt.omf.gt.getContext())).tt(pf.sp(com.byazt.omf.gt.getContext())).c(com.byazt.wz.x.tt(this.c)).c(), this.uj, true, null, -1, false, false);
        }
        this.f28943a = true;
    }

    @Override // com.byazt.sz.gt
    public void c(com.byazt.xj.ve veVar, MotionEvent motionEvent) {
        if (motionEvent == null || this.f28943a) {
            return;
        }
        int action = motionEvent.getAction();
        if (action == 0) {
            this.sl = motionEvent.getDownTime();
            this.sp = motionEvent.getRawX();
            this.x = motionEvent.getRawY();
            a();
            return;
        }
        if (action != 1) {
            return;
        }
        this.i = motionEvent.getRawX();
        this.da = motionEvent.getRawY();
        c(motionEvent);
    }
}

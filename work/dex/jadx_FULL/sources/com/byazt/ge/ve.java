package com.byazt.ge;

import android.view.View;
import com.byazt.ete.ic;
import com.byazt.ete.kp;
import com.byazt.ete.my;
import com.byazt.lcf.TTBaseVideoActivity;
import com.byazt.qq.da;
import com.byazt.ukr.yp;
import org.json.JSONObject;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_11_8719cls.dex */
@com.byazt.zqa.c(c = {0, 1, 758, 54})
public abstract class ve implements tt {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public TTBaseVideoActivity f28564a;
    public boolean c;
    public com.byazt.kcl.n n;
    public int sp = 0;
    public ic tt;
    public com.byazt.kcl.tt uj;
    public ic ve;

    public ve(TTBaseVideoActivity tTBaseVideoActivity, ic icVar, com.byazt.kcl.tt ttVar, com.byazt.kcl.n nVar, boolean z) {
        this.f28564a = tTBaseVideoActivity;
        this.tt = icVar;
        this.uj = ttVar;
        this.n = nVar;
        this.c = z;
    }

    @Override // com.byazt.ge.tt
    public void a(View view) {
        c(6);
    }

    @Override // com.byazt.ge.tt
    public void c(View view) {
        c(2);
    }

    @Override // com.byazt.ge.tt
    public void n(View view) {
        c(5);
        this.f28564a.x(3);
    }

    @Override // com.byazt.ge.tt
    public void sp(View view) {
        c(7);
    }

    @Override // com.byazt.ge.tt
    public void tt(View view) {
        c(3);
    }

    @Override // com.byazt.ge.tt
    public void uj(View view) {
        c(4);
    }

    @Override // com.byazt.ge.tt
    public void ve(View view) {
        c(1);
    }

    public boolean c() {
        if (my.u(this.tt) || kp.tt() <= 0) {
            return false;
        }
        int i = this.sp;
        this.sp = i + 1;
        if (i < kp.tt()) {
            return false;
        }
        yp.c().c(this.tt, "stats_reward_full_close_force", this.f28564a.lt().c(new JSONObject()));
        this.f28564a.finish();
        return true;
    }

    public void c(int i) {
        this.f28564a.q();
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("topImpl", getClass().getName());
            jSONObject.put("topType", i);
        } catch (Throwable unused) {
        }
        yp.c().c(this.tt, "stats_reward_full_top_handle", jSONObject);
    }

    public void c(ic icVar) {
        this.ve = icVar;
    }

    public boolean c(da daVar) {
        ic icVar = this.ve;
        if (icVar != null) {
            return this.f28564a.c(icVar, daVar);
        }
        return this.f28564a.c(this.tt, daVar);
    }
}

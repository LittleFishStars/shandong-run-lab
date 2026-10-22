package com.byazt.dq;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.byazt.cd.i;
import com.byazt.sz.m;
import com.byazt.sz.rh;
import org.json.JSONObject;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_11_8719cls.dex */
@com.byazt.zqa.c(c = {0, 1, 1212, 34})
public class a implements i.c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public com.byazt.xj.ve f28418a;
    public boolean c;
    public m n;
    public Handler sp = new i(Looper.getMainLooper(), this);
    public int tt;
    public Context uj;
    public rh ve;

    public a(Context context, m mVar, com.byazt.xj.ve veVar) {
        this.uj = context;
        this.n = mVar;
        this.f28418a = veVar;
    }

    public void c(rh rhVar) {
        this.ve = rhVar;
    }

    public void c() {
        m mVar = this.n;
        if (mVar == null) {
            return;
        }
        JSONObject jSONObjectVe = mVar.ve();
        try {
            this.tt = Integer.parseInt(com.byazt.wj.tt.c(jSONObjectVe.optString("interval", "8000"), this.f28418a.da()));
            this.c = jSONObjectVe.optBoolean("repeat");
            this.sp.sendEmptyMessageDelayed(1001, this.tt);
        } catch (NumberFormatException e) {
            com.byazt.nr.m.c(e);
        }
    }

    @Override // com.byazt.cd.i.c
    public void c(Message message) {
        if (message.what != 1001) {
            return;
        }
        rh rhVar = this.ve;
        if (rhVar != null) {
            m mVar = this.n;
            com.byazt.xj.ve veVar = this.f28418a;
            rhVar.c(mVar, veVar, veVar);
        }
        if (this.c) {
            this.sp.sendEmptyMessageDelayed(1001, this.tt);
        } else {
            this.sp.removeMessages(1001);
        }
    }
}

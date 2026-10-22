package com.byazt.dq;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import com.alibaba.ariver.kernel.ipc.IpcMessageConstants;
import com.byazt.cd.i;
import com.byazt.sz.m;
import com.byazt.sz.rh;
import com.byazt.sz.u;
import org.json.JSONObject;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_11_8719cls.dex */
@com.byazt.zqa.c(c = {0, 1, 1212, 13})
public class tt implements i.c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public Handler f28420a = new i(Looper.getMainLooper(), this);
    public int c;
    public com.byazt.xj.ve n;
    public rh tt;
    public m uj;
    public Context ve;

    public tt(Context context, m mVar, com.byazt.xj.ve veVar) {
        this.ve = context;
        this.uj = mVar;
        this.n = veVar;
    }

    public void c(rh rhVar) {
        this.tt = rhVar;
    }

    public void c() {
        m mVar = this.uj;
        if (mVar == null) {
            return;
        }
        try {
            int i = Integer.parseInt(com.byazt.wj.tt.c(mVar.ve().optString("delay"), this.n.da()));
            this.c = i;
            this.f28420a.sendEmptyMessageDelayed(1001, i);
        } catch (NumberFormatException e) {
            com.byazt.nr.m.c(e);
        }
    }

    @Override // com.byazt.cd.i.c
    public void c(Message message) {
        if (message.what != 1001) {
            return;
        }
        JSONObject jSONObjectVe = this.uj.ve();
        if (TextUtils.equals(jSONObjectVe.optString("type"), "onAnimation")) {
            String strOptString = jSONObjectVe.optString(IpcMessageConstants.EXTRA_NODE_ID);
            com.byazt.xj.ve veVar = this.n;
            com.byazt.xj.ve veVarUj = veVar.tt(veVar).uj(strOptString);
            new u(veVarUj.i(), com.byazt.sz.c.c(jSONObjectVe.optJSONObject("animatorSet"), veVarUj)).c();
        } else {
            rh rhVar = this.tt;
            if (rhVar != null) {
                m mVar = this.uj;
                com.byazt.xj.ve veVar2 = this.n;
                rhVar.c(mVar, veVar2, veVar2);
            }
        }
        this.f28420a.removeMessages(1001);
    }
}

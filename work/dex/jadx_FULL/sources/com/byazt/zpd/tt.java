package com.byazt.zpd;

import android.os.Message;
import com.byazt.dna.qp;
import com.byazt.nr.d;
import com.byazt.nr.da;
import com.byazt.nr.m;
import com.byazt.nr.zm;
import com.byazt.omf.gt;
import com.byazt.omf.x;
import org.json.JSONObject;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_11_8719cls.dex */
@com.byazt.zqa.c(c = {0, 1, 1919, 13})
public class tt extends c implements qp.c {
    public final d c = new d(da.c().getLooper(), this);
    public zm tt;

    @Override // com.byazt.dna.qp.c
    public void handleMsg(Message message) {
        int i = message.what;
        if (i != 1) {
            if (i != 2) {
                return;
            }
            zm zmVar = this.tt;
            if (zmVar != null) {
                zmVar.tt(0);
            }
            c(3, 0L, System.currentTimeMillis());
            return;
        }
        zm zmVar2 = this.tt;
        if (zmVar2 == null) {
            return;
        }
        zmVar2.c(new zm.ve() { // from class: com.byazt.zpd.tt.1
            @Override // com.byazt.nr.zm.ve
            public void c() {
                tt.this.c(1, System.currentTimeMillis(), 0L);
                if (tt.this.c != null) {
                    tt.this.c.removeCallbacksAndMessages(null);
                }
                if (tt.this.tt != null) {
                    tt.this.tt.tt(0);
                }
            }
        });
        this.c.sendEmptyMessageDelayed(2, c(gt.tt().kz()));
    }

    public void c(JSONObject jSONObject, int i) {
        int iC = c(i);
        if (tt(i)) {
            c(jSONObject, com.byazt.pf.c.c().tt(), iC);
        } else if (ve(i)) {
            c(jSONObject, com.byazt.pf.c.c().ve(), iC);
        }
    }

    private void c(JSONObject jSONObject, long j, long j2) {
        if (System.currentTimeMillis() - j > j2) {
            this.tt = c();
            this.c.removeCallbacksAndMessages(null);
            this.c.sendEmptyMessage(1);
        }
    }

    private zm c() {
        zm zmVar = new zm(gt.getContext(), 1, x.m().uj());
        boolean zC = zmVar.c(0);
        m.tt("csj_sen", "reg res:".concat(String.valueOf(zC)));
        if (zC) {
            return zmVar;
        }
        c(0, System.currentTimeMillis(), 0L);
        zmVar.tt(0);
        return null;
    }
}

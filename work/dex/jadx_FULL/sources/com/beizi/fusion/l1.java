package com.beizi.fusion;

import android.view.View;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_10_7392cls.dex */
public class l1 extends i1 implements hc {
    @Override // com.beizi.fusion.i1, com.beizi.fusion.aa
    public w9 a() {
        return new ne();
    }

    @Override // com.beizi.fusion.ha, com.beizi.fusion.dc
    public void a(View view, int i) {
        hc.a aVar = this.e;
        if (aVar != null) {
            int iB = aVar.b();
            if (iB == 0) {
                a(view, Integer.valueOf(i));
                return;
            }
            if (!ml.a(this.e.a())) {
                a(view, Integer.valueOf(i));
                return;
            }
            if (iB == 1) {
                super.a(view, i);
            } else if (iB == 2) {
                this.f27001a.a(x9.a.REWARD_TO_PRIVILEGE, view, Integer.valueOf(i));
            } else if (iB == 3) {
                this.f27001a.a(x9.a.REWARD_TO_END_CARD, view, Integer.valueOf(i));
            } else if (iB == 4) {
                this.f27001a.a(x9.a.AD_CLOSE, view, Integer.valueOf(i));
            } else if (iB == 5) {
                this.f27001a.a(x9.a.REWARD_TO_RETAIN, view, Integer.valueOf(i));
            }
            this.e.e();
        }
    }

    private void a(View view, Integer num) {
        hc.a aVar = this.e;
        if (aVar != null) {
            if (aVar.c()) {
                this.f27001a.a(x9.a.REWARD_TO_END_CARD, view, num);
                return;
            } else {
                if (this.e.d()) {
                    this.f27001a.a(x9.a.REWARD_PRIMARY_CLOSE, view, num);
                    return;
                }
                return;
            }
        }
        this.f27001a.a(x9.a.REWARD_PRIMARY_CLOSE, view, num);
    }

    @Override // com.beizi.fusion.hc
    public void a(hc.a aVar) {
        this.e = aVar;
    }
}

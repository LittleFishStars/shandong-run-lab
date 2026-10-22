package com.byazt.ge;

import android.view.View;
import com.byazt.ete.ic;
import com.byazt.lcf.TTBaseVideoActivity;
import com.byazt.qq.da;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_11_8719cls.dex */
@com.byazt.zqa.c(c = {0, 1, 758, 15})
public class uj extends ve {
    public uj(TTBaseVideoActivity tTBaseVideoActivity, ic icVar, com.byazt.kcl.tt ttVar, com.byazt.kcl.n nVar, boolean z) {
        super(tTBaseVideoActivity, icVar, ttVar, nVar, z);
    }

    @Override // com.byazt.ge.ve, com.byazt.ge.tt
    public void a(View view) {
        super.a(view);
        c(view);
    }

    @Override // com.byazt.ge.ve, com.byazt.ge.tt
    public void c(View view) {
        super.c(view);
        if (c()) {
            return;
        }
        this.f28564a.lt().tt();
        if (this.uj.bx()) {
            this.f28564a.tt();
        } else if (this.f28564a.to().to()) {
            tt();
        } else {
            ve();
        }
    }

    @Override // com.byazt.ge.ve, com.byazt.ge.tt
    public void tt(View view) {
        super.tt(view);
        this.f28564a.qp();
    }

    @Override // com.byazt.ge.ve, com.byazt.ge.tt
    public void ve(View view) {
        super.ve(view);
        this.f28564a.ve(this.uj.nb());
    }

    private void tt() {
        da daVar = new da() { // from class: com.byazt.ge.uj.1
            @Override // com.byazt.qq.da
            public void tt() {
                uj.this.f28564a.tt();
            }
        };
        if (c(daVar)) {
            this.sp--;
        } else {
            daVar.tt();
        }
    }

    private void ve() {
        this.f28564a.tt();
    }
}

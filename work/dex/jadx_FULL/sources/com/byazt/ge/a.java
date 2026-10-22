package com.byazt.ge;

import android.view.View;
import com.byazt.ete.ic;
import com.byazt.fcd.x;
import com.byazt.lcf.TTBaseVideoActivity;
import com.byazt.qq.da;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_11_8719cls.dex */
@com.byazt.zqa.c(c = {0, 1, 758, 34})
public class a extends ve {
    public a(TTBaseVideoActivity tTBaseVideoActivity, ic icVar, com.byazt.kcl.tt ttVar, com.byazt.kcl.n nVar, boolean z) {
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
        this.f28564a.lt().c();
        if (this.f28564a.to().to()) {
            tt();
        } else {
            ve();
        }
    }

    @Override // com.byazt.ge.ve, com.byazt.ge.tt
    public void sp(View view) {
        super.sp(view);
        this.f28564a.v();
    }

    @Override // com.byazt.ge.ve, com.byazt.ge.tt
    public void tt(View view) {
        super.tt(view);
        if (this.f28564a.to() instanceof x) {
            this.f28564a.qp();
        }
        this.f28564a.cu();
    }

    @Override // com.byazt.ge.ve, com.byazt.ge.tt
    public void ve(View view) {
        super.ve(view);
        this.f28564a.ve("video_player");
    }

    private void ve() {
        da daVar = new da() { // from class: com.byazt.ge.a.2
            @Override // com.byazt.qq.da
            public void tt() {
                a.this.f28564a.ve();
            }
        };
        if (c(daVar)) {
            return;
        }
        daVar.tt();
    }

    private void tt() {
        da daVar = new da() { // from class: com.byazt.ge.a.1
            @Override // com.byazt.qq.da
            public void tt() {
                a.this.f28564a.yp();
                a.this.f28564a.nb().postDelayed(new Runnable() { // from class: com.byazt.ge.a.1.1
                    @Override // java.lang.Runnable
                    public void run() {
                        a.this.f28564a.tt();
                    }
                }, 100L);
            }
        };
        int i = 2;
        int iN = this.f28564a.n(2);
        if (this.tt.wn() == 7) {
            if (this.tt.dh() && !this.f28564a.tk()) {
                i = 1;
            }
            iN = i;
        }
        if (iN == 1) {
            if (c(daVar)) {
                return;
            }
            daVar.tt();
            return;
        }
        this.f28564a.ve();
    }
}

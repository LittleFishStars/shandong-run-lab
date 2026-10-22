package com.byazt.hc;

import android.app.Activity;
import com.byazt.ete.ic;
import com.byazt.ete.l;
import com.byazt.qq.da;
import com.byazt.sgn.a;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_11_8719cls.dex */
@com.byazt.zqa.c(c = {0, 1, 1504, 13})
public class tt extends c {
    public a tt;

    public tt(Activity activity, ic icVar) {
        super(activity, icVar);
        this.tt = null;
    }

    @Override // com.byazt.hc.c, com.byazt.qq.tt
    public com.byazt.qq.tt.c c(final da daVar) {
        com.byazt.qq.tt.c cVarC = super.c(daVar);
        if (cVarC.ve()) {
            return cVarC;
        }
        final a aVar = new a(this.x);
        this.tt = aVar;
        aVar.n("tt_retain_gift").c(c()).ve(l.c(this.sp, this.sl, this.t)).uj("坚持退出");
        aVar.c(com.byazt.vfu.a.i(this.x));
        this.tt.c(new a.c() { // from class: com.byazt.hc.tt.1
            @Override // com.byazt.sgn.a.c
            public void c() {
                da daVar2 = daVar;
                if (daVar2 != null) {
                    daVar2.c();
                }
            }

            @Override // com.byazt.sgn.a.c
            public void tt() {
                aVar.dismiss();
                da daVar2 = daVar;
                if (daVar2 != null) {
                    daVar2.tt();
                }
            }
        });
        this.tt.show();
        return new com.byazt.qq.tt.c(true, 0, "", this.tt);
    }

    @Override // com.byazt.qq.tt
    public String c() {
        return "恭喜您已经获得奖励，是否要继续观看视频，再得超值奖励";
    }

    @Override // com.byazt.qq.tt
    public void n() {
        a aVar = this.tt;
        if (aVar != null) {
            aVar.tt();
        }
    }

    @Override // com.byazt.qq.tt
    public boolean tt() {
        a aVar = this.tt;
        return aVar != null && aVar.isShowing();
    }

    @Override // com.byazt.qq.tt
    public void uj() {
        a aVar = this.tt;
        if (aVar != null) {
            aVar.c();
        }
    }

    @Override // com.byazt.qq.tt
    public void ve() {
        a aVar = this.tt;
        if (aVar != null) {
            aVar.dismiss();
        }
    }
}

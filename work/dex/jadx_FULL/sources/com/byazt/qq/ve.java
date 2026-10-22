package com.byazt.qq;

import android.app.Activity;
import com.byazt.ete.ic;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_11_8719cls.dex */
@com.byazt.zqa.c(c = {0, 1, 88, 54})
public class ve extends c {
    public com.byazt.sgn.a nu;

    public ve(Activity activity, ic icVar) {
        super(activity, icVar);
        this.nu = null;
    }

    @Override // com.byazt.qq.tt
    public String c() {
        if (!(this.c <= 0) && this.n) {
            return "再看" + this.c + "s，并点击一下广告可领取奖励";
        }
        if (this.n) {
            return "忘记点击广告领取奖励啦～";
        }
        return "再看" + this.c + "s可领取奖励";
    }

    @Override // com.byazt.qq.c, com.byazt.qq.tt
    public tt.c tt(final da daVar) {
        tt.c cVarTt = super.tt(daVar);
        if (cVarTt.ve()) {
            return cVarTt;
        }
        final com.byazt.sgn.a aVar = new com.byazt.sgn.a(this.x);
        this.nu = aVar;
        aVar.n("tt_retain_gift").c(x()).ve("继续观看").uj("坚持退出");
        this.nu.c(com.byazt.vfu.a.i(this.x));
        this.nu.c(new com.byazt.sgn.a.c() { // from class: com.byazt.qq.ve.1
            @Override // com.byazt.sgn.a.c
            public void c() {
                aVar.dismiss();
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
        this.nu.show();
        return new tt.c(true, 0, "", this.nu);
    }

    @Override // com.byazt.qq.tt
    public void ve() {
        com.byazt.sgn.a aVar = this.nu;
        if (aVar != null) {
            aVar.dismiss();
        }
    }

    @Override // com.byazt.qq.tt
    public boolean tt() {
        com.byazt.sgn.a aVar = this.nu;
        return aVar != null && aVar.isShowing();
    }
}

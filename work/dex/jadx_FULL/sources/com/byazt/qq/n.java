package com.byazt.qq;

import android.app.Activity;
import android.view.View;
import com.byazt.ete.ic;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_11_8719cls.dex */
@com.byazt.zqa.c(c = {0, 1, 88, 46})
public class n extends c {
    public com.byazt.sgn.a nu;

    public n(Activity activity, ic icVar) {
        super(activity, icVar);
        this.nu = null;
    }

    @Override // com.byazt.qq.tt
    public String c() {
        return "继续观看" + this.c + "秒可获得奖励\n确定要退出吗？";
    }

    @Override // com.byazt.qq.c, com.byazt.qq.tt
    public tt.c tt(final da daVar) {
        final com.byazt.sgn.a aVar = new com.byazt.sgn.a(this.x);
        this.nu = aVar;
        aVar.n("tt_retain_gift").c(x()).ve("继续观看").uj("坚持退出");
        aVar.c(com.byazt.vfu.a.u(this.x));
        this.nu.c(new com.byazt.sgn.a.c() { // from class: com.byazt.qq.n.1
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
        this.nu.c(new View.OnClickListener() { // from class: com.byazt.qq.n.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                aVar.dismiss();
                da daVar2 = daVar;
                if (daVar2 != null) {
                    daVar2.ve();
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

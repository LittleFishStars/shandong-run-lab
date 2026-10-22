package com.byazt.qq;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Color;
import com.byazt.aas.rl;
import com.byazt.ete.ic;
import com.byazt.ete.lo;
import com.byazt.ete.my;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_11_8719cls.dex */
@com.byazt.zqa.c(c = {0, 1, 88, 71})
public class x extends c {
    public com.byazt.sgn.a nu;
    public String rh;

    public x(Activity activity, ic icVar) {
        super(activity, icVar);
        this.nu = null;
    }

    @Override // com.byazt.qq.tt
    public String c() {
        return this.rh;
    }

    @Override // com.byazt.qq.c, com.byazt.qq.tt
    public tt.c tt(final da daVar) {
        final com.byazt.sgn.a aVar = new com.byazt.sgn.a(this.x);
        this.nu = aVar;
        c(aVar, this.uj);
        this.nu.c(new com.byazt.sgn.a.c() { // from class: com.byazt.qq.x.1
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

    private void c(com.byazt.sgn.a aVar, boolean z) {
        if (rl.tt(this.sp)) {
            int iKa = this.sp.ka();
            int iC = lo.c(this.sp);
            if (iKa == 0) {
                String str = "试玩时长达标才能领取奖励";
                if (iC != 1 && !z && !this.ve) {
                    str = "试玩后才能领取奖励";
                }
                this.rh = str;
                aVar.n("tt_retain_gift").c(x()).ve("继续试玩").uj("坚持退出");
                aVar.c(com.byazt.vfu.a.i(this.x));
                return;
            }
            if (iKa != 1) {
                if (iKa != 3) {
                    return;
                }
                this.rh = "确定退出吗?";
                Activity activity = this.x;
                if (activity != null) {
                    Intent intent = activity.getIntent();
                    this.rh = String.format("再看%s秒可得奖励", Integer.valueOf(intent != null ? intent.getIntExtra("remainTime", 0) : 0));
                }
                c(aVar, x(), "继续观看", "坚持退出");
                aVar.c(Color.parseColor("#FC1D56"));
                return;
            }
            boolean zVe = my.ve(this.sp);
            if (iC != 0 || zVe) {
                this.rh = String.format("再看%s秒可得奖励", Integer.valueOf(this.c));
            } else {
                this.rh = "未满足奖励要求，需要继续浏览";
            }
            if (zVe) {
                aVar.tt("确定退出吗?");
                c(aVar, x(), "继续观看", "坚持退出");
            } else {
                aVar.n("tt_reward_coin").c(Color.parseColor("#FC1D56")).c(x()).ve("继续观看").uj("坚持退出");
                aVar.c(com.byazt.vfu.a.i(this.x));
            }
        }
    }

    @Override // com.byazt.qq.tt
    public boolean tt() {
        com.byazt.sgn.a aVar = this.nu;
        return aVar != null && aVar.isShowing();
    }

    private void c(com.byazt.sgn.a aVar, String str, String str2, String str3) {
        aVar.n("tt_reward_browse_multi_icon").c(str).ve(str2).uj(str3);
        aVar.c(com.byazt.vfu.a.or(this.x));
    }
}

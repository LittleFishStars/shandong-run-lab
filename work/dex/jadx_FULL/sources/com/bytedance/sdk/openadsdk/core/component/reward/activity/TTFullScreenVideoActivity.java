package com.bytedance.sdk.openadsdk.core.component.reward.activity;

import android.os.Bundle;
import com.byazt.cf.tt;
import com.byazt.ete.kp;
import com.byazt.lcf.TTBaseVideoActivity;
import com.byazt.omf.gt;
import com.byazt.rob.c;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_08_10593cls.dex */
public class TTFullScreenVideoActivity extends TTBaseVideoActivity {
    @Override // com.byazt.lcf.TTBaseVideoActivity
    public void bm() {
        String str;
        super.bm();
        if (kp.nu(this.qp) || this.zb.d()) {
            return;
        }
        if (this.cu.eo()) {
            this.eo.c(false, null, null, true, true);
            return;
        }
        int iH = ((int) this.cu.h()) / 1000;
        String str2 = this.bx.a(false) + "s";
        boolean z = iH >= this.bx.lo();
        if (z || !gt.tt().n(String.valueOf(this.ic))) {
            str = null;
        } else {
            str = (this.bx.lo() - iH) + "s后可跳过";
        }
        this.eo.c(false, str2, str, z, z);
    }

    @Override // com.byazt.lcf.TTBaseVideoActivity
    public void p() {
        if (this.ve.getAndSet(true)) {
            return;
        }
        c cVar = this.to;
        if (cVar == null || !cVar.ve()) {
            c("onAdClose", (Bundle) null);
        }
    }

    @Override // com.byazt.lcf.TTBaseVideoActivity
    public void ve(boolean z) {
        byte b = -1;
        if (this.gu) {
            if (gt.tt().hz() == 1) {
                b = 2000;
            }
        } else if (z) {
            b = 0;
        }
        if (b < 0 || this.gt.get()) {
            return;
        }
        if (b != 0) {
            this.tt.postDelayed(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.component.reward.activity.TTFullScreenVideoActivity.1
                @Override // java.lang.Runnable
                public void run() {
                    if (TTFullScreenVideoActivity.this.gt.getAndSet(true)) {
                        return;
                    }
                    tt.c().c(TTFullScreenVideoActivity.this.qp, String.valueOf(TTFullScreenVideoActivity.this.ic));
                }
            }, 2000L);
        } else {
            if (this.gt.getAndSet(true)) {
                return;
            }
            tt.c().c(this.qp, String.valueOf(this.ic));
        }
    }

    @Override // com.byazt.lcf.TTBaseVideoActivity
    public boolean yv() {
        return false;
    }

    @Override // com.byazt.lcf.TTBaseVideoActivity
    public void c(String str, Bundle bundle) {
        com.byazt.yi.c.c(1, this.hd, str, bundle);
    }
}

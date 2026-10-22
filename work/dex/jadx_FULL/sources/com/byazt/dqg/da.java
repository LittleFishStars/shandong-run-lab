package com.byazt.dqg;

import android.widget.FrameLayout;
import com.byazt.aas.nb;
import com.byazt.ete.ic;
import com.byazt.lcf.TTBaseVideoActivity;
import com.byazt.msx.FullSwiperView;
import java.util.List;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_11_8719cls.dex */
@com.byazt.zqa.c(c = {0, 1, 74, 72})
public class da extends tt {
    public FullSwiperView m;
    public float yp;
    public float z;

    public da(TTBaseVideoActivity tTBaseVideoActivity, ic icVar, boolean z) {
        super(tTBaseVideoActivity, icVar, z);
    }

    public void a() {
        FullSwiperView fullSwiperView = this.m;
        if (fullSwiperView != null) {
            fullSwiperView.sp();
        }
    }

    public void c(float[] fArr) {
        this.yp = fArr[0];
        this.z = fArr[1];
    }

    @Override // com.byazt.dqg.tt
    public void da() {
        super.da();
        FullSwiperView fullSwiperView = this.m;
        if (fullSwiperView != null) {
            fullSwiperView.n();
        }
    }

    public int n() {
        FullSwiperView fullSwiperView = this.m;
        if (fullSwiperView != null) {
            return fullSwiperView.getCurrentPosition();
        }
        return 0;
    }

    public void tt() {
        FullSwiperView fullSwiperView = this.m;
        if (fullSwiperView != null) {
            fullSwiperView.tt();
        }
    }

    public void uj() {
        FullSwiperView fullSwiperView = this.m;
        if (fullSwiperView != null) {
            fullSwiperView.uj();
        }
    }

    public void ve() {
        FullSwiperView fullSwiperView = this.m;
        if (fullSwiperView != null) {
            fullSwiperView.ve();
        }
    }

    @Override // com.byazt.dqg.tt
    public void c() {
        super.c();
        this.sp.setBackgroundColor(0);
        this.m = new FullSwiperView(this.tt);
    }

    public void c(List<com.byazt.msx.c> list) {
        if (list == null || list.size() <= 0) {
            return;
        }
        this.m.c(list).c(this.yp).tt(this.z).c(String.valueOf(nb.t(this.ve))).c();
        this.sp.addView(this.m, new FrameLayout.LayoutParams(-1, -1));
    }
}

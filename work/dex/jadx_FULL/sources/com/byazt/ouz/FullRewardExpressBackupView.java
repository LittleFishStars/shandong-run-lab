package com.byazt.ouz;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.byazt.aas.nb;
import com.byazt.aas.pf;
import com.byazt.ete.ic;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_11_8719cls.dex */
@com.byazt.zqa.c(c = {0, 1, 27, 2482})
public class FullRewardExpressBackupView extends BackupView {
    public View u;
    public NativeExpressView yp;
    public FrameLayout z;

    public FullRewardExpressBackupView(Context context) {
        super(context);
        this.c = context;
    }

    private void tt() {
        this.f28915a = pf.ve(this.c, this.yp.getExpectExpressWidth());
        this.sp = pf.ve(this.c, this.yp.getExpectExpressWidth());
        ViewGroup.LayoutParams layoutParams = getLayoutParams();
        if (layoutParams == null) {
            layoutParams = new ViewGroup.LayoutParams(this.f28915a, this.sp);
        }
        layoutParams.width = this.f28915a;
        layoutParams.height = this.sp;
        if (layoutParams instanceof FrameLayout.LayoutParams) {
            ((FrameLayout.LayoutParams) layoutParams).gravity = 17;
        }
        setLayoutParams(layoutParams);
        ve();
    }

    private void ve() {
        FrameLayout frameLayout = new FrameLayout(this.c);
        this.u = frameLayout;
        frameLayout.setId(2114387734);
        addView(this.u);
        FrameLayout frameLayout2 = (FrameLayout) this.u.findViewById(2114387734);
        this.z = frameLayout2;
        frameLayout2.removeAllViews();
    }

    public void c(ic icVar, NativeExpressView nativeExpressView) {
        setBackgroundColor(-1);
        this.tt = icVar;
        this.yp = nativeExpressView;
        if (nb.sl(icVar) == 7) {
            this.n = "rewarded_video";
        } else {
            this.n = "fullscreen_interstitial_ad";
        }
        tt();
        this.yp.addView(this, new ViewGroup.LayoutParams(-2, -2));
    }

    public FrameLayout getVideoContainer() {
        return this.z;
    }

    @Override // com.byazt.ouz.BackupView
    public void c(View view, int i, com.byazt.ete.gr grVar) {
        NativeExpressView nativeExpressView = this.yp;
        if (nativeExpressView != null) {
            nativeExpressView.c(view, i, grVar, -1);
        }
    }
}

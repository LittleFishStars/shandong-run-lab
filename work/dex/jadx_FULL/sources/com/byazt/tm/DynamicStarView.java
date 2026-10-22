package com.byazt.tm;

import android.content.Context;
import android.widget.FrameLayout;
import androidx.camera.video.AudioStats;
import com.byazt.aq.x;
import com.byazt.oq.TTRatingBar2;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_11_8719cls.dex */
@com.byazt.zqa.c(c = {0, 1, 48, 2242})
public class DynamicStarView extends DynamicBaseWidgetImp {
    public int c;

    public DynamicStarView(Context context, DynamicRootView dynamicRootView, x xVar) {
        super(context, dynamicRootView, xVar);
        this.c = 0;
        TTRatingBar2 tTRatingBar2 = new TTRatingBar2(context, null);
        this.z = tTRatingBar2;
        tTRatingBar2.setTag(Integer.valueOf(getClickArea()));
        addView(this.z, getWidgetLayoutParams());
    }

    @Override // com.byazt.tm.DynamicBaseWidgetImp
    public FrameLayout.LayoutParams getWidgetLayoutParams() {
        int iC = (int) ((com.byazt.or.x.c(com.byazt.sr.uj.getContext(), this.t.n()) * 5.0f) + com.byazt.or.x.c(com.byazt.sr.uj.getContext(), this.t.ve() + com.byazt.or.x.c(com.byazt.sr.uj.getContext(), this.t.uj())));
        if (this.sp > iC && 4 == this.t.x()) {
            this.c = (this.sp - iC) / 2;
        }
        this.sp = iC;
        return new FrameLayout.LayoutParams(this.sp, this.x);
    }

    @Override // com.byazt.tm.DynamicBaseWidget
    public void n() {
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(this.sp, this.x);
        layoutParams.topMargin = this.da;
        int i = this.i + this.c;
        layoutParams.leftMargin = i;
        layoutParams.setMarginStart(i);
        layoutParams.setMarginEnd(layoutParams.rightMargin);
        setLayoutParams(layoutParams);
    }

    @Override // com.byazt.tm.DynamicBaseWidgetImp, com.byazt.tm.uj
    public boolean x() {
        DynamicRootView dynamicRootView;
        super.x();
        double dU = this.t.u();
        if (com.byazt.sr.uj.c() && (dU < AudioStats.AUDIO_AMPLITUDE_NONE || dU > 5.0d || ((dynamicRootView = this.yp) != null && dynamicRootView.getRenderRequest() != null && this.yp.getRenderRequest().t() != 4))) {
            this.z.setVisibility(8);
            return true;
        }
        double d = (dU < AudioStats.AUDIO_AMPLITUDE_NONE || dU > 5.0d) ? 5.0d : dU;
        this.z.setVisibility(0);
        ((TTRatingBar2) this.z).c(d, this.t.sp(), (int) this.t.n(), ((int) com.byazt.or.x.c(this.sl, this.t.tt())) + ((int) com.byazt.or.x.c(this.sl, this.t.c())) + ((int) com.byazt.or.x.c(this.sl, this.t.n())));
        return true;
    }
}

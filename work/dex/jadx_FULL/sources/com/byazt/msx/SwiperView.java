package com.byazt.msx;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.byazt.nw.BaseSwiper;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_11_8719cls.dex */
@com.byazt.zqa.c(c = {0, 1, 341, 1070})
public class SwiperView extends BaseSwiper<ViewGroup> {
    public SwiperView(Context context) {
        super(context);
    }

    @Override // com.byazt.nw.BaseSwiper
    public View c(int i, int i2) {
        if (this.c.isEmpty()) {
            return new View(getContext());
        }
        View viewSl = sl(i2);
        FrameLayout frameLayout = new FrameLayout(getContext());
        if (viewSl instanceof ViewGroup) {
            frameLayout.setClipChildren(true);
        }
        if (viewSl.getParent() instanceof ViewGroup) {
            ((ViewGroup) viewSl.getParent()).removeView(viewSl);
        }
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
        layoutParams.gravity = 17;
        frameLayout.addView(viewSl, layoutParams);
        frameLayout.addView(new View(getContext()), new FrameLayout.LayoutParams(-1, -1));
        return frameLayout;
    }

    @Override // com.byazt.nw.BaseSwiper
    public View sl(int i) {
        return (ViewGroup) this.c.get(i);
    }

    @Override // com.byazt.nw.BaseSwiper, com.byazt.an.ViewPager.uj
    public void t(int i) {
        super.t(i);
    }

    @Override // com.byazt.nw.BaseSwiper, com.byazt.an.ViewPager.uj
    public void u(int i) {
        super.u(i);
    }
}

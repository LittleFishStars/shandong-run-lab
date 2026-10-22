package com.byazt.nk;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.byazt.oq.ClickSlideUpShakeView;
import com.byazt.oq.ShakeAnimationView;
import com.byazt.oq.ShakeClickView;
import com.byazt.oq.SlideUpView;
import com.byazt.tm.DynamicBaseWidget;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_11_8719cls.dex */
@com.byazt.zqa.c(c = {0, 1, 234, 34})
public class a extends nu<ClickSlideUpShakeView> implements z {
    public a(Context context, DynamicBaseWidget dynamicBaseWidget, com.byazt.aq.sp spVar, com.byazt.aq.da daVar, boolean z, int i) {
        super(context, dynamicBaseWidget, spVar);
        this.tt = context;
        this.uj = spVar;
        this.ve = dynamicBaseWidget;
        c(daVar, spVar, z, i);
    }

    private void c(com.byazt.aq.da daVar, com.byazt.aq.sp spVar, boolean z, int i) {
        int iLr;
        this.c = new ClickSlideUpShakeView(this.tt, daVar, z, i);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, (int) com.byazt.or.x.c(this.tt, 300.0f));
        layoutParams.gravity = 81;
        Context context = this.tt;
        if (spVar.lr() > 0) {
            iLr = spVar.lr();
        } else {
            iLr = com.byazt.sr.uj.c() ? 0 : 120;
        }
        layoutParams.bottomMargin = (int) com.byazt.or.x.c(context, iLr);
        this.c.setLayoutParams(layoutParams);
        this.c.setClipChildren(false);
        this.c.setSlideText(this.uj.lt());
        SlideUpView slideUpView = this.c;
        if (slideUpView instanceof ClickSlideUpShakeView) {
            ((ClickSlideUpShakeView) slideUpView).setShakeText(this.uj.tk());
            final ShakeClickView shakeView = ((ClickSlideUpShakeView) this.c).getShakeView();
            if (shakeView != null) {
                shakeView.setOnShakeViewListener(new ShakeAnimationView.c() { // from class: com.byazt.nk.a.1
                    @Override // com.byazt.oq.ShakeAnimationView.c
                    public void c(boolean z2) {
                        if (a.this.ve.getDynamicClickListener() != null) {
                            a.this.ve.getDynamicClickListener().c(z2, a.this);
                        }
                        shakeView.performClick();
                    }
                });
                shakeView.setOnClickListener((View.OnClickListener) this.ve.getDynamicClickListener());
            }
        }
    }

    @Override // com.byazt.nk.z
    public void n() {
        if (this.c.getParent() != null) {
            ((ViewGroup) this.c.getParent()).setVisibility(8);
        }
    }

    @Override // com.byazt.nk.nu
    public void uj() {
    }
}

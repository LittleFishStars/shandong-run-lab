package com.byazt.nk;

import android.content.Context;
import android.widget.FrameLayout;
import com.byazt.oq.ClickSlideUpView;
import com.byazt.oq.SlideUpView;
import com.byazt.tm.DynamicBaseWidget;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_11_8719cls.dex */
@com.byazt.zqa.c(c = {0, 1, 234, 15})
public class uj extends nu<ClickSlideUpView> {
    public uj(Context context, DynamicBaseWidget dynamicBaseWidget, com.byazt.aq.sp spVar) {
        super(context, dynamicBaseWidget, spVar);
        c(spVar);
    }

    private void c(com.byazt.aq.sp spVar) {
        this.c = new ClickSlideUpView(this.tt);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -2);
        layoutParams.gravity = 81;
        layoutParams.bottomMargin = (int) com.byazt.or.x.c(this.tt, spVar.lr());
        this.c.setLayoutParams(layoutParams);
        this.c.setSlideText(this.uj.lt());
        SlideUpView slideUpView = this.c;
        if (slideUpView instanceof ClickSlideUpView) {
            ((ClickSlideUpView) slideUpView).setButtonText(this.uj.da());
        }
    }

    @Override // com.byazt.nk.nu, com.byazt.nk.sp
    public void tt() {
        this.c.tt();
    }

    @Override // com.byazt.nk.nu
    public void uj() {
    }

    @Override // com.byazt.nk.nu, com.byazt.nk.sp
    public void c() {
        this.c.c();
    }
}

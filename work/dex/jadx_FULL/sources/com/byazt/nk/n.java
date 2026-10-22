package com.byazt.nk;

import android.content.Context;
import android.widget.FrameLayout;
import com.byazt.oq.ClickSlideUpView;
import com.byazt.oq.ClickSlideUpView2;
import com.byazt.oq.SlideUpView;
import com.byazt.tm.DynamicBaseWidget;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_11_8719cls.dex */
@com.byazt.zqa.c(c = {0, 1, 234, 46})
public class n extends nu<ClickSlideUpView> {
    public n(Context context, DynamicBaseWidget dynamicBaseWidget, com.byazt.aq.sp spVar) {
        super(context, dynamicBaseWidget, spVar);
        c(spVar);
    }

    private void c(com.byazt.aq.sp spVar) {
        this.c = new ClickSlideUpView2(this.tt);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -1);
        layoutParams.gravity = 81;
        this.c.setLayoutParams(layoutParams);
        SlideUpView slideUpView = this.c;
        if (slideUpView instanceof ClickSlideUpView2) {
            ((ClickSlideUpView2) slideUpView).setButtonText(this.uj.lt());
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

package com.byazt.nk;

import android.content.Context;
import android.widget.FrameLayout;
import com.byazt.oq.SlideUpView;
import com.byazt.tm.DynamicBaseWidget;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_11_8719cls.dex */
@com.byazt.zqa.c(c = {0, 1, 234, 137})
public class nu<E extends SlideUpView> implements sp<E> {
    public SlideUpView c;
    public int n;
    public Context tt;
    public com.byazt.aq.sp uj;
    public DynamicBaseWidget ve;

    public nu(Context context, DynamicBaseWidget dynamicBaseWidget, com.byazt.aq.sp spVar, int i) {
        this.n = i;
        this.tt = context;
        this.ve = dynamicBaseWidget;
        this.uj = spVar;
        uj();
    }

    @Override // com.byazt.nk.sp
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public E ve() {
        return (E) this.c;
    }

    @Override // com.byazt.nk.sp
    public void c() {
        this.c.c();
    }

    @Override // com.byazt.nk.sp
    public void tt() {
        this.c.tt();
    }

    public void uj() {
        this.c = new SlideUpView(this.tt, this.uj.aw());
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, (int) com.byazt.or.x.c(this.tt, 200.0f));
        layoutParams.gravity = 81;
        layoutParams.bottomMargin = (int) com.byazt.or.x.c(this.tt, 100 - this.n);
        this.c.setLayoutParams(layoutParams);
        try {
            this.c.setGuideText(this.uj.lt());
        } catch (Throwable unused) {
        }
    }

    public nu(Context context, DynamicBaseWidget dynamicBaseWidget, com.byazt.aq.sp spVar) {
        this(context, dynamicBaseWidget, spVar, 0);
    }
}

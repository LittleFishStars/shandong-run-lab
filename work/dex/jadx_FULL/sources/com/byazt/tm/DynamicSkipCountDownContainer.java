package com.byazt.tm;

import android.content.Context;
import android.widget.FrameLayout;
import com.byazt.aq.x;
import java.util.List;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_11_8719cls.dex */
@com.byazt.zqa.c(c = {0, 1, 48, 2526})
public class DynamicSkipCountDownContainer extends DynamicBaseWidgetImp implements com.byazt.kn.ve {
    public int c;
    public int gt;
    public int tt;

    public DynamicSkipCountDownContainer(Context context, DynamicRootView dynamicRootView, x xVar) {
        super(context, dynamicRootView, xVar);
        setTag(Integer.valueOf(getClickArea()));
        dynamicRootView.setTimeOutListener(this);
        i();
    }

    private void i() {
        List<x> listSl = this.u.sl();
        if (listSl == null || listSl.size() <= 0) {
            return;
        }
        for (x xVar : listSl) {
            if (xVar.da().c() == 21) {
                this.c = (int) (this.sp - com.byazt.or.x.c(this.sl, xVar.x()));
            }
            if (xVar.da().c() == 20) {
                this.tt = (int) (this.sp - com.byazt.or.x.c(this.sl, xVar.x()));
            }
        }
    }

    @Override // com.byazt.kn.ve
    public void c(CharSequence charSequence, boolean z, int i, boolean z2) {
        this.gt = i;
    }

    @Override // com.byazt.tm.DynamicBaseWidgetImp
    public FrameLayout.LayoutParams getWidgetLayoutParams() {
        return new FrameLayout.LayoutParams(-2, -2);
    }

    @Override // com.byazt.tm.DynamicBaseWidget
    public void n() {
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
        int i = this.i;
        layoutParams.leftMargin = i;
        layoutParams.topMargin = this.da;
        layoutParams.setMarginStart(i);
        layoutParams.setMarginEnd(layoutParams.rightMargin);
        setLayoutParams(layoutParams);
    }

    @Override // android.widget.FrameLayout, android.view.View
    public void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        if (this.gt == 0) {
            setMeasuredDimension(this.tt, this.x);
        } else {
            setMeasuredDimension(this.c, this.x);
        }
    }

    @Override // com.byazt.tm.DynamicBaseWidgetImp, com.byazt.tm.uj
    public boolean x() {
        setBackground(getBackgroundDrawable());
        setPadding((int) com.byazt.or.x.c(com.byazt.sr.uj.getContext(), this.t.ve()), (int) com.byazt.or.x.c(com.byazt.sr.uj.getContext(), this.t.tt()), (int) com.byazt.or.x.c(com.byazt.sr.uj.getContext(), this.t.uj()), (int) com.byazt.or.x.c(com.byazt.sr.uj.getContext(), this.t.c()));
        return true;
    }
}

package com.byazt.tm;

import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import android.widget.FrameLayout;
import com.byazt.aq.x;
import com.byazt.or.sp;
import java.util.List;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_11_8719cls.dex */
@com.byazt.zqa.c(c = {0, 1, 48, 1369})
public class DynamicTimeOuterContainerWidgetImp extends DynamicBaseWidgetImp implements com.byazt.kn.ve {
    public int c;
    public int gt;
    public boolean qy;
    public int rl;
    public boolean tt;

    public DynamicTimeOuterContainerWidgetImp(Context context, DynamicRootView dynamicRootView, x xVar) {
        super(context, dynamicRootView, xVar);
        this.rl = 0;
        setTag(Integer.valueOf(getClickArea()));
        i();
        dynamicRootView.setTimeOutListener(this);
        if (dynamicRootView.getRenderRequest() == null || dynamicRootView.getRenderRequest().p()) {
            return;
        }
        View view = this.z;
        if (view != null) {
            view.setVisibility(8);
        }
        setVisibility(8);
    }

    private void i() {
        List<x> listSl = this.u.sl();
        if (listSl == null || listSl.size() <= 0) {
            return;
        }
        for (x xVar : listSl) {
            if (TextUtils.equals("skip-with-time-skip-btn", xVar.da().getType())) {
                int iC = (int) com.byazt.or.x.c(this.sl, xVar.x() + (com.byazt.sr.uj.c() ? xVar.u() : 0));
                this.gt = iC;
                this.c = this.sp - iC;
                break;
            }
        }
        this.rl = this.sp - this.c;
    }

    @Override // com.byazt.kn.ve
    public void c(CharSequence charSequence, boolean z, int i, boolean z2) {
        if (z2 && this.qy != z2) {
            this.qy = z2;
            n();
            return;
        }
        if (z && this.tt != z) {
            this.tt = z;
            n();
        }
        this.tt = z;
    }

    @Override // com.byazt.tm.DynamicBaseWidgetImp
    public FrameLayout.LayoutParams getWidgetLayoutParams() {
        return new FrameLayout.LayoutParams(-2, -2);
    }

    @Override // com.byazt.tm.DynamicBaseWidget
    public void n() {
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
        if (this.tt) {
            layoutParams.leftMargin = this.i;
        } else {
            layoutParams.leftMargin = this.i + this.rl;
        }
        if (this.qy && this.t != null) {
            layoutParams.leftMargin = ((this.i + this.rl) - ((int) com.byazt.or.x.c(com.byazt.sr.uj.getContext(), this.t.ve()))) - ((int) com.byazt.or.x.c(com.byazt.sr.uj.getContext(), this.t.uj()));
        }
        if (com.byazt.sr.uj.c()) {
            layoutParams.topMargin = this.da - ((int) com.byazt.or.x.c(com.byazt.sr.uj.getContext(), this.t.tt()));
        } else {
            layoutParams.topMargin = this.da;
        }
        layoutParams.setMarginStart(layoutParams.leftMargin);
        layoutParams.setMarginEnd(layoutParams.rightMargin);
        setLayoutParams(layoutParams);
    }

    @Override // android.widget.FrameLayout, android.view.View
    public void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        if (this.qy && this.t != null) {
            setMeasuredDimension(this.gt + ((int) com.byazt.or.x.c(com.byazt.sr.uj.getContext(), this.t.ve())) + ((int) com.byazt.or.x.c(com.byazt.sr.uj.getContext(), this.t.uj())), this.x);
        } else if (this.tt) {
            setMeasuredDimension(this.sp, this.x);
        } else {
            setMeasuredDimension(this.c, this.x);
        }
    }

    @Override // com.byazt.tm.DynamicBaseWidgetImp, com.byazt.tm.uj
    public boolean x() {
        if (sp.tt(this.yp.getRenderRequest().a())) {
            return true;
        }
        super.x();
        setPadding((int) com.byazt.or.x.c(com.byazt.sr.uj.getContext(), this.t.ve()), (int) com.byazt.or.x.c(com.byazt.sr.uj.getContext(), this.t.tt()), (int) com.byazt.or.x.c(com.byazt.sr.uj.getContext(), this.t.uj()), (int) com.byazt.or.x.c(com.byazt.sr.uj.getContext(), this.t.c()));
        return true;
    }
}

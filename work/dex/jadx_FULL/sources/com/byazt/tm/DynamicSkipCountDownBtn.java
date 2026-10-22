package com.byazt.tm;

import android.annotation.SuppressLint;
import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.TextView;
import com.byazt.aq.x;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_11_8719cls.dex */
@com.byazt.zqa.c(c = {0, 1, 48, 2520})
public class DynamicSkipCountDownBtn extends DynamicButton implements com.byazt.kn.ve {
    public int[] c;
    public int gt;
    public int tt;

    public DynamicSkipCountDownBtn(Context context, DynamicRootView dynamicRootView, x xVar) {
        super(context, dynamicRootView, xVar);
        dynamicRootView.setTimeOutListener(this);
    }

    private void i() {
        int iC = (int) com.byazt.or.x.c(this.sl, this.t.n());
        this.tt = ((this.x - iC) / 2) - this.t.c();
        this.gt = 0;
    }

    @Override // com.byazt.kn.ve
    @SuppressLint({"SetTextI18n"})
    public void c(CharSequence charSequence, boolean z, int i, boolean z2) {
        if (i == 0) {
            this.z.setVisibility(0);
            ((TextView) this.z).setText("| 跳过");
            this.z.measure(-2, -2);
            this.c = new int[]{this.z.getMeasuredWidth() + 1, this.z.getMeasuredHeight()};
            View view = this.z;
            int[] iArr = this.c;
            view.setLayoutParams(new FrameLayout.LayoutParams(iArr[0], iArr[1]));
            ((TextView) this.z).setGravity(17);
            ((TextView) this.z).setIncludeFontPadding(false);
            i();
            this.z.setPadding(this.t.ve(), this.tt, this.t.uj(), this.gt);
        }
        requestLayout();
    }

    @Override // com.byazt.tm.DynamicBaseWidget
    public void n() {
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(this.sp, this.x);
        layoutParams.gravity = 8388629;
        layoutParams.setMarginStart(layoutParams.leftMargin);
        layoutParams.setMarginEnd(layoutParams.rightMargin);
        setLayoutParams(layoutParams);
    }

    @Override // android.widget.FrameLayout, android.view.View
    public void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        if (TextUtils.isEmpty(((TextView) this.z).getText())) {
            setMeasuredDimension(0, this.x);
        } else {
            setMeasuredDimension(this.sp, this.x);
        }
    }

    @Override // com.byazt.tm.DynamicButton, com.byazt.tm.DynamicBaseWidgetImp, com.byazt.tm.uj
    public boolean x() {
        super.x();
        ((TextView) this.z).setText("");
        return true;
    }
}

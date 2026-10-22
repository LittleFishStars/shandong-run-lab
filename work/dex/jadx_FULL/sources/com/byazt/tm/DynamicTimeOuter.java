package com.byazt.tm;

import android.content.Context;
import android.text.TextUtils;
import android.widget.FrameLayout;
import android.widget.TextView;
import com.byazt.aq.x;
import com.byazt.du.sl;
import com.byazt.or.sp;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_11_8719cls.dex */
@com.byazt.zqa.c(c = {0, 1, 48, 2426})
public class DynamicTimeOuter extends DynamicButton implements com.byazt.kn.ve {
    public boolean c;
    public boolean gt;
    public boolean tt;

    public DynamicTimeOuter(Context context, DynamicRootView dynamicRootView, x xVar) {
        super(context, dynamicRootView, xVar);
        dynamicRootView.setTimeOutListener(this);
        if ("timedown".equals(xVar.da().getType())) {
            dynamicRootView.setTimedown(this.x);
        }
    }

    @Override // com.byazt.kn.ve
    public void c(CharSequence charSequence, boolean z, int i, boolean z2) {
        if (z2 || this.gt) {
            ((TextView) this.z).setText("");
            setVisibility(8);
            return;
        }
        try {
            if (Integer.parseInt((String) charSequence) <= 0) {
                setVisibility(8);
                return;
            }
        } catch (Exception unused) {
        }
        setVisibility(0);
        if (!z && this.yp.getRenderRequest().ve() && sp.tt(this.yp.getRenderRequest().a())) {
            ((TextView) this.z).setText(i + "s");
            this.c = true;
            return;
        }
        if (com.byazt.sr.uj.c() && !"open_ad".equals(this.yp.getRenderRequest().a()) && this.yp.getRenderRequest().ve()) {
            this.gt = true;
            setVisibility(8);
            return;
        }
        if ("timedown".equals(this.u.da().getType())) {
            ((TextView) this.z).setText(charSequence);
            return;
        }
        ((TextView) this.z).setText(((Object) charSequence) + "s");
        this.tt = true;
        if (this.c) {
            CharSequence text = ((TextView) this.z).getText();
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams((int) (sl.tt(text != null ? text.toString() : "", this.t.n(), true)[0] + com.byazt.or.x.c(com.byazt.sr.uj.getContext(), this.t.ve() + this.t.uj())), this.x);
            layoutParams.gravity = 8388629;
            this.z.setLayoutParams(layoutParams);
            this.c = false;
            requestLayout();
        }
    }

    @Override // com.byazt.tm.DynamicBaseWidget
    public void n() {
        if (!TextUtils.equals("skip-with-countdowns-video-countdown", this.u.da().getType()) && !TextUtils.equals("skip-with-time-countdown", this.u.da().getType())) {
            super.n();
            return;
        }
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(this.sp, this.x);
        layoutParams.gravity = 8388627;
        if (com.byazt.sr.uj.c()) {
            layoutParams.leftMargin = this.i;
        }
        layoutParams.setMarginStart(layoutParams.leftMargin);
        layoutParams.setMarginEnd(layoutParams.rightMargin);
        setLayoutParams(layoutParams);
    }

    @Override // android.widget.FrameLayout, android.view.View
    public void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        if (TextUtils.isEmpty(((TextView) this.z).getText())) {
            setMeasuredDimension(0, this.x);
        }
    }

    @Override // com.byazt.tm.DynamicButton, com.byazt.tm.DynamicBaseWidgetImp, com.byazt.tm.uj
    public boolean x() {
        super.x();
        if (sp.tt(this.yp.getRenderRequest().a())) {
            setVisibility(8);
        }
        if ("timedown".equals(this.u.da().getType())) {
            ((TextView) this.z).setText(String.valueOf((int) Double.parseDouble(this.t.da())));
            return true;
        }
        ((TextView) this.z).setText(((int) Double.parseDouble(this.t.da())) + "s");
        return true;
    }
}

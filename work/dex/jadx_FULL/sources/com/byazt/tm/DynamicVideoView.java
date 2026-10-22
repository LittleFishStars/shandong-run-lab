package com.byazt.tm;

import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.GradientDrawable;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.TextView;
import com.byazt.aq.x;
import com.zj.adlib.u15;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_11_8719cls.dex */
@com.byazt.zqa.c(c = {0, 1, 48, 504})
public class DynamicVideoView extends DynamicBaseWidgetImp implements com.byazt.kn.n {
    public TextView c;
    public boolean gt;
    public FrameLayout tt;

    public DynamicVideoView(Context context, DynamicRootView dynamicRootView, x xVar) {
        super(context, dynamicRootView, xVar);
        this.gt = false;
        View view = new View(context);
        this.z = view;
        view.setTag(Integer.valueOf(getClickArea()));
        this.c = new TextView(context);
        this.tt = new FrameLayout(context);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams((int) com.byazt.or.x.c(context, 40.0f), (int) com.byazt.or.x.c(context, 15.0f));
        layoutParams.gravity = 8388693;
        layoutParams.rightMargin = 20;
        layoutParams.bottomMargin = 20;
        this.c.setLayoutParams(layoutParams);
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setShape(0);
        gradientDrawable.setCornerRadius(25.0f);
        gradientDrawable.setColor(Color.parseColor("#57000000"));
        this.c.setBackground(gradientDrawable);
        this.c.setTextSize(10.0f);
        this.c.setGravity(17);
        this.c.setTextColor(-1);
        this.c.setVisibility(8);
        if (com.byazt.sr.uj.c()) {
            addView(this.tt, new FrameLayout.LayoutParams(-1, -1));
        }
        addView(this.c);
        addView(this.z, getWidgetLayoutParams());
        if (!com.byazt.sr.uj.c()) {
            addView(this.tt, getWidgetLayoutParams());
        }
        dynamicRootView.ve = this.tt;
        dynamicRootView.setVideoListener(this);
    }

    private void ve(View view) {
        if (view == this.c || view == ((DynamicBaseWidgetImp) this).my) {
            return;
        }
        try {
            if (((Integer) view.getTag(com.byazt.kn.c.f28734a)).intValue() == 1) {
                return;
            }
        } catch (Throwable unused) {
        }
        int i = 0;
        view.setVisibility(0);
        if (!(view instanceof ViewGroup)) {
            return;
        }
        while (true) {
            ViewGroup viewGroup = (ViewGroup) view;
            if (i >= viewGroup.getChildCount()) {
                return;
            }
            ve(viewGroup.getChildAt(i));
            i++;
        }
    }

    @Override // com.byazt.kn.n
    public void setTimeUpdate(int i) {
        if (!this.u.da().n().w() || i <= 0 || this.gt) {
            this.gt = true;
            for (int i2 = 0; i2 < getChildCount(); i2++) {
                ve(getChildAt(i2));
            }
            this.c.setVisibility(8);
            return;
        }
        String str = (i >= 60 ? "0" + (i / 60) : "00") + u15.f19942b;
        int i3 = i % 60;
        this.c.setText(i3 > 9 ? str + i3 : str + "0" + i3);
        this.c.setVisibility(0);
    }

    @Override // com.byazt.tm.DynamicBaseWidget
    public boolean uj() {
        return true;
    }

    @Override // com.byazt.tm.DynamicBaseWidgetImp, com.byazt.tm.uj
    public boolean x() {
        super.x();
        double dN = 0.0d;
        double dUj = 0.0d;
        for (x xVarT = this.u; xVarT != null; xVarT = xVarT.t()) {
            double dA = dUj + ((double) xVarT.a());
            double dSp = dN + ((double) xVarT.sp());
            dUj = dA - ((double) xVarT.uj());
            dN = dSp - ((double) xVarT.n());
        }
        try {
            float f = (float) dUj;
            int iC = (int) com.byazt.or.x.c(getContext(), f);
            int iC2 = (int) com.byazt.or.x.c(getContext(), f + this.n);
            if (com.byazt.or.ve.c(getContext())) {
                int dynamicWidth = ((DynamicRoot) this.yp.getChildAt(0)).getDynamicWidth();
                int i = dynamicWidth - iC2;
                iC2 = dynamicWidth - iC;
                iC = i;
            }
            if ("open_ad".equals(this.yp.getRenderRequest().a())) {
                this.yp.ve = this.tt;
            } else {
                float f2 = (float) dN;
                ((DynamicRoot) this.yp.getChildAt(0)).c.update(iC, (int) com.byazt.or.x.c(getContext(), f2), iC2, (int) com.byazt.or.x.c(getContext(), f2 + this.f29065a));
            }
        } catch (Exception unused) {
        }
        this.yp.c(dUj, dN, this.n, this.f29065a, this.t.z());
        return true;
    }
}

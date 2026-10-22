package com.kc.dw.ad;

import android.util.DisplayMetrics;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.kc.dw.ad.splash.SplashSkipView;
import com.kc.dw.core.utils.DimensionUtils;
import com.qihoo.SdkProtected.OSETSDK.Keep;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
@Keep
public class j extends com.kc.dw.core.safe.j {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final RelativeLayout f39104a;
    public final ImageView b;
    public final ImageView c;
    public final RelativeLayout d;
    public final ImageView e;
    public final TextView f;
    public final TextView g;
    public final TextView h;
    public final SplashSkipView i;
    public final ImageView j;
    public final k k;

    public j(k kVar, RelativeLayout relativeLayout, ImageView imageView, ImageView imageView2, RelativeLayout relativeLayout2, ImageView imageView3, TextView textView, TextView textView2, TextView textView3, SplashSkipView splashSkipView, ImageView imageView4) {
        this.k = kVar;
        this.f39104a = relativeLayout;
        this.b = imageView;
        this.c = imageView2;
        this.d = relativeLayout2;
        this.e = imageView3;
        this.f = textView;
        this.g = textView2;
        this.h = textView3;
        this.i = splashSkipView;
        this.j = imageView4;
    }

    @Override // com.kc.dw.core.safe.j
    public void safeRun() {
        int splashDesignHeight = DimensionUtils.getSplashDesignHeight(this.k.f39105a);
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.f39104a.getLayoutParams();
        double d = splashDesignHeight;
        double d2 = d * 13.7d;
        int i = ((int) d2) / 100;
        layoutParams.width = i;
        layoutParams.height = i;
        layoutParams.bottomMargin = ((int) (3.8d * d)) / 100;
        this.f39104a.setLayoutParams(layoutParams);
        this.b.setLayoutParams(layoutParams);
        int i2 = ((int) (d2 * 0.592d)) / 100;
        RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) this.c.getLayoutParams();
        layoutParams2.width = i2;
        layoutParams2.height = i2;
        layoutParams2.addRule(13);
        this.c.setLayoutParams(layoutParams2);
        LinearLayout.LayoutParams layoutParams3 = (LinearLayout.LayoutParams) this.d.getLayoutParams();
        layoutParams3.bottomMargin = ((int) (2.8d * d)) / 100;
        layoutParams3.topMargin = i;
        layoutParams3.width = i;
        layoutParams3.height = i;
        this.d.setLayoutParams(layoutParams3);
        RelativeLayout.LayoutParams layoutParams4 = (RelativeLayout.LayoutParams) this.e.getLayoutParams();
        layoutParams4.addRule(12);
        layoutParams4.addRule(14);
        this.e.setLayoutParams(layoutParams4);
        LinearLayout.LayoutParams layoutParams5 = (LinearLayout.LayoutParams) this.f.getLayoutParams();
        layoutParams5.bottomMargin = ((int) (0.9d * d)) / 100;
        this.f.setLayoutParams(layoutParams5);
        LinearLayout.LayoutParams layoutParams6 = (LinearLayout.LayoutParams) this.g.getLayoutParams();
        layoutParams6.bottomMargin = ((int) (4.9d * d)) / 100;
        this.g.setLayoutParams(layoutParams6);
        DisplayMetrics displayMetrics = this.k.f39105a.getResources().getDisplayMetrics();
        LinearLayout.LayoutParams layoutParams7 = (LinearLayout.LayoutParams) this.h.getLayoutParams();
        int i3 = ((int) (((double) displayMetrics.widthPixels) * 13.7d)) / 100;
        layoutParams7.leftMargin = i3;
        layoutParams7.rightMargin = i3;
        layoutParams7.bottomMargin = ((int) (5.7d * d)) / 100;
        layoutParams7.height = (splashDesignHeight * 6) / 100;
        this.h.setLayoutParams(layoutParams7);
        RelativeLayout.LayoutParams layoutParams8 = (RelativeLayout.LayoutParams) this.i.getLayoutParams();
        int i4 = displayMetrics.widthPixels;
        layoutParams8.rightMargin = ((int) (((double) i4) * 3.6d)) / 100;
        layoutParams8.topMargin = (i4 * 10) / 100;
        this.i.setLayoutParams(layoutParams8);
        FrameLayout.LayoutParams layoutParams9 = (FrameLayout.LayoutParams) this.j.getLayoutParams();
        layoutParams9.bottomMargin = ((int) (d * 1.8d)) / 100;
        layoutParams9.rightMargin = ((int) (((double) displayMetrics.widthPixels) * 3.6d)) / 100;
        this.j.setLayoutParams(layoutParams9);
    }
}

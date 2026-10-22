package com.byazt.xjc;

import android.animation.ObjectAnimator;
import android.content.Context;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import com.byazt.aas.pf;
import com.byazt.nr.z;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_11_8719cls.dex */
@com.byazt.zqa.c(c = {0, 1, 511, 895})
public class SmallSlideView extends RelativeLayout {
    public final View c;
    public final tt tt;
    public ObjectAnimator uj;
    public ObjectAnimator ve;

    @com.byazt.zqa.c(c = {0, 1, 511, 2029})
    public static class c extends FrameLayout {
        public c(Context context) {
            super(context);
            ImageView imageView = new ImageView(context);
            z.c(context, "tt_splash_slide_up_finger", imageView, 320);
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -1);
            layoutParams.leftMargin = pf.ve(context, 38.0f);
            layoutParams.bottomMargin = pf.ve(context, 10.0f);
            ImageView imageView2 = new ImageView(context);
            z.c(context, "tt_splash_slide_up_circle", imageView2, 320);
            RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(-1, -1);
            int iVe = pf.ve(context, 30.0f);
            layoutParams2.setMargins(iVe, iVe, iVe, iVe);
            addView(imageView2, layoutParams2);
            addView(imageView, layoutParams);
        }
    }

    @com.byazt.zqa.c(c = {0, 1, 511, 1615})
    public static class tt extends FrameLayout {
        public tt(Context context) {
            super(context);
            ImageView imageView = new ImageView(context);
            z.c(context, "tt_splash_slide_up_bg", (View) imageView, 320);
            addView(imageView);
        }
    }

    public SmallSlideView(Context context) {
        super(context);
        View cVar = new c(context);
        this.c = cVar;
        tt ttVar = new tt(context);
        this.tt = ttVar;
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(pf.ve(context, 10.0f), 0);
        layoutParams.setMargins(0, pf.ve(context, 8.0f), 0, pf.ve(context, 8.0f));
        layoutParams.addRule(14);
        layoutParams.addRule(12);
        addView(ttVar, layoutParams);
        addView(cVar);
        setLayoutParams(new LinearLayout.LayoutParams(pf.ve(context, 80.0f), pf.ve(context, 80.0f)));
    }

    public void c() {
        ObjectAnimator objectAnimatorOfFloat = ObjectAnimator.ofFloat(this.c, "translationY", pf.ve(getContext(), 30.0f), pf.ve(getContext(), -20.0f));
        this.ve = objectAnimatorOfFloat;
        objectAnimatorOfFloat.setDuration(800L);
        this.ve.setRepeatCount(1);
        this.ve.setRepeatMode(1);
        this.ve.start();
        ObjectAnimator objectAnimatorOfInt = ObjectAnimator.ofInt(this.tt, "newHeight", pf.ve(getContext(), 0.0f), pf.ve(getContext(), 48.0f));
        this.uj = objectAnimatorOfInt;
        objectAnimatorOfInt.setDuration(800L);
        this.uj.setRepeatCount(1);
        this.uj.setRepeatMode(1);
        this.uj.start();
    }

    public void tt() {
        ObjectAnimator objectAnimator = this.ve;
        if (objectAnimator != null) {
            objectAnimator.cancel();
        }
        ObjectAnimator objectAnimator2 = this.uj;
        if (objectAnimator2 != null) {
            objectAnimator2.cancel();
        }
    }
}

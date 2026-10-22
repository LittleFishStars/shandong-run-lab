package com.kc.dw.ad;

import android.animation.ObjectAnimator;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import com.kc.dw.core.utils.DimensionUtils;
import com.qihoo.SdkProtected.OSETSDK.Keep;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
@Keep
public class q extends com.kc.dw.core.safe.j {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final RelativeLayout f39147a;
    public final ImageView b;
    public final int c;
    public final k d;

    public q(k kVar, RelativeLayout relativeLayout, ImageView imageView, int i) {
        this.d = kVar;
        this.f39147a = relativeLayout;
        this.b = imageView;
        this.c = i;
    }

    @Override // com.kc.dw.core.safe.j
    public void safeRun() {
        this.f39147a.setVisibility(0);
        this.b.setVisibility(0);
        int splashDesignHeight = DimensionUtils.getSplashDesignHeight(this.d.f39105a);
        int i = ((int) (((double) splashDesignHeight) * 13.7d)) / 100;
        int height = this.b.getHeight();
        if (height == 0) {
            height = (splashDesignHeight * 5) / 100;
        }
        float f = (-i) + height;
        ObjectAnimator objectAnimatorOfFloat = ObjectAnimator.ofFloat(this.b, "translationY", 0.0f, f, f);
        this.d.getClass();
        objectAnimatorOfFloat.setDuration(800L);
        objectAnimatorOfFloat.setRepeatCount(this.c);
        objectAnimatorOfFloat.setRepeatMode(1);
        objectAnimatorOfFloat.start();
        this.d.e.add(objectAnimatorOfFloat);
    }
}

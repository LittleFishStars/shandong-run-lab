package com.kc.dw.ad;

import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.view.animation.DecelerateInterpolator;
import android.widget.ImageView;
import com.qihoo.SdkProtected.OSETSDK.Keep;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
@Keep
public class p extends com.kc.dw.core.safe.j {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ImageView f39146a;
    public final int b;
    public final k c;

    public p(k kVar, ImageView imageView, int i) {
        this.c = kVar;
        this.f39146a = imageView;
        this.b = i;
    }

    @Override // com.kc.dw.core.safe.j
    public void safeRun() {
        AnimatorSet animatorSet = new AnimatorSet();
        ObjectAnimator objectAnimatorOfFloat = ObjectAnimator.ofFloat(this.f39146a, "scaleX", 0.0f, 1.0f);
        ObjectAnimator objectAnimatorOfFloat2 = ObjectAnimator.ofFloat(this.f39146a, "scaleY", 0.0f, 1.0f);
        this.c.getClass();
        animatorSet.setDuration(800L);
        animatorSet.setInterpolator(new DecelerateInterpolator());
        objectAnimatorOfFloat.setRepeatCount(this.b);
        objectAnimatorOfFloat.setRepeatMode(1);
        objectAnimatorOfFloat2.setRepeatCount(this.b);
        objectAnimatorOfFloat2.setRepeatMode(1);
        animatorSet.play(objectAnimatorOfFloat).with(objectAnimatorOfFloat2);
        animatorSet.start();
        this.c.e.add(animatorSet);
    }
}

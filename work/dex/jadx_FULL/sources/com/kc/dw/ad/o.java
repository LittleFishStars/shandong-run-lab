package com.kc.dw.ad;

import android.animation.ObjectAnimator;
import android.widget.ImageView;
import androidx.constraintlayout.motion.widget.Key;
import com.qihoo.SdkProtected.OSETSDK.Keep;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
@Keep
public class o extends com.kc.dw.core.safe.j {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ImageView f39145a;
    public final int b;
    public final k c;

    public o(k kVar, ImageView imageView, int i) {
        this.c = kVar;
        this.f39145a = imageView;
        this.b = i;
    }

    @Override // com.kc.dw.core.safe.j
    public void safeRun() {
        ObjectAnimator objectAnimatorOfFloat = ObjectAnimator.ofFloat(this.f39145a, Key.ROTATION, 0.0f, -45.0f, 0.0f);
        this.c.getClass();
        objectAnimatorOfFloat.setDuration(800L);
        objectAnimatorOfFloat.setRepeatCount(this.b);
        objectAnimatorOfFloat.setRepeatMode(1);
        objectAnimatorOfFloat.start();
        this.c.e.add(objectAnimatorOfFloat);
    }
}

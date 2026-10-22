package com.kc.cw.ad.internal.a;

import android.view.animation.AccelerateInterpolator;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.Interpolator;
import com.qihoo.SdkProtected.OSETSDK.Keep;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
@Keep
public class c implements g {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private Animation f38832a;
    private Animation b;

    public c(long j) {
        AccelerateInterpolator accelerateInterpolator = new AccelerateInterpolator();
        a(accelerateInterpolator, j);
        b(accelerateInterpolator, j);
    }

    private void a(Interpolator interpolator, long j) {
        AlphaAnimation alphaAnimation = new AlphaAnimation(0.0f, 1.0f);
        this.f38832a = alphaAnimation;
        alphaAnimation.setDuration(j);
        this.f38832a.setInterpolator(interpolator);
    }

    private void b(Interpolator interpolator, long j) {
        AlphaAnimation alphaAnimation = new AlphaAnimation(1.0f, 0.0f);
        this.b = alphaAnimation;
        alphaAnimation.setDuration(j);
        this.b.setInterpolator(interpolator);
    }

    @Override // com.kc.cw.ad.internal.a.g
    public Animation a() {
        return this.f38832a;
    }

    @Override // com.kc.cw.ad.internal.a.g
    public Animation b() {
        return this.b;
    }
}

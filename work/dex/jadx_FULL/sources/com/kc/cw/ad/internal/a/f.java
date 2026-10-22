package com.kc.cw.ad.internal.a;

import android.view.animation.AccelerateInterpolator;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.AnimationSet;
import android.view.animation.Interpolator;
import android.view.animation.TranslateAnimation;
import com.qihoo.SdkProtected.OSETSDK.Keep;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
@Keep
public class f implements g {
    private static final float[] c = {0.0f, 0.0f, 0.0f, -1.0f};
    private static final float[] d = {0.0f, 0.0f, 0.0f, 1.0f};
    private static final float[] e = {0.0f, 1.0f, 0.0f, 0.0f};
    private static final float[] f = {0.0f, -1.0f, 0.0f, 0.0f};

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private Animation f38837a;
    private Animation b;

    /* JADX INFO: renamed from: com.kc.cw.ad.internal.a.f$1, reason: invalid class name */
    @Keep
    public static /* synthetic */ class AnonymousClass1 {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        static final int[] f38838a;

        static {
            int[] iArr = new int[h.values().length];
            f38838a = iArr;
            try {
                iArr[h.UP.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f38838a[h.DOWN.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f38838a[h.RIGHT.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f38838a[h.LEFT.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
        }
    }

    public f(long j, h hVar) {
        AccelerateInterpolator accelerateInterpolator = new AccelerateInterpolator();
        a(accelerateInterpolator, j);
        a(a(hVar), accelerateInterpolator, j);
    }

    private void a(Interpolator interpolator, long j) {
        AlphaAnimation alphaAnimation = new AlphaAnimation(0.0f, 1.0f);
        this.f38837a = alphaAnimation;
        alphaAnimation.setDuration(j);
        this.f38837a.setInterpolator(interpolator);
    }

    private void a(float[] fArr, Interpolator interpolator, long j) {
        TranslateAnimation translateAnimation = new TranslateAnimation(2, fArr[0], 2, fArr[1], 2, fArr[2], 2, fArr[3]);
        translateAnimation.setInterpolator(interpolator);
        translateAnimation.setDuration(j);
        AlphaAnimation alphaAnimation = new AlphaAnimation(1.0f, 0.0f);
        alphaAnimation.setDuration(j);
        alphaAnimation.setInterpolator(interpolator);
        AnimationSet animationSet = new AnimationSet(false);
        animationSet.addAnimation(translateAnimation);
        animationSet.addAnimation(alphaAnimation);
        this.b = animationSet;
    }

    private float[] a(h hVar) {
        int i = AnonymousClass1.f38838a[hVar.ordinal()];
        if (i == 1) {
            return c;
        }
        if (i == 2) {
            return d;
        }
        if (i != 3) {
            return i != 4 ? c : f;
        }
        return e;
    }

    @Override // com.kc.cw.ad.internal.a.g
    public Animation a() {
        return this.f38837a;
    }

    @Override // com.kc.cw.ad.internal.a.g
    public Animation b() {
        return this.b;
    }
}

package com.kc.cw.ad.internal.a;

import android.view.animation.AccelerateInterpolator;
import android.view.animation.Animation;
import android.view.animation.Interpolator;
import android.view.animation.TranslateAnimation;
import com.qihoo.SdkProtected.OSETSDK.Keep;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
@Keep
public class e implements g {
    private static final float[] c = {0.0f, 0.0f, 1.0f, 0.0f};
    private static final float[] d = {0.0f, 0.0f, -1.0f, 0.0f};
    private static final float[] e = {-1.0f, 0.0f, 0.0f, 0.0f};
    private static final float[] f = {1.0f, 0.0f, 0.0f, 0.0f};
    private static final float[] g = {0.0f, 0.0f, 0.0f, -1.0f};
    private static final float[] h = {0.0f, 0.0f, 0.0f, 1.0f};
    private static final float[] i = {0.0f, 1.0f, 0.0f, 0.0f};
    private static final float[] j = {0.0f, -1.0f, 0.0f, 0.0f};

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private Animation f38835a;
    private Animation b;

    /* JADX INFO: renamed from: com.kc.cw.ad.internal.a.e$1, reason: invalid class name */
    @Keep
    public static /* synthetic */ class AnonymousClass1 {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        static final int[] f38836a;

        static {
            int[] iArr = new int[h.values().length];
            f38836a = iArr;
            try {
                iArr[h.UP.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f38836a[h.DOWN.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f38836a[h.RIGHT.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f38836a[h.LEFT.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
        }
    }

    public e(long j2, h hVar) {
        AccelerateInterpolator accelerateInterpolator = new AccelerateInterpolator();
        this.f38835a = a(a(hVar), accelerateInterpolator, j2);
        this.b = a(b(hVar), accelerateInterpolator, j2);
    }

    private Animation a(float[] fArr, Interpolator interpolator, long j2) {
        TranslateAnimation translateAnimation = new TranslateAnimation(2, fArr[0], 2, fArr[1], 2, fArr[2], 2, fArr[3]);
        translateAnimation.setInterpolator(interpolator);
        translateAnimation.setDuration(j2);
        return translateAnimation;
    }

    private float[] a(h hVar) {
        int i2 = AnonymousClass1.f38836a[hVar.ordinal()];
        if (i2 == 1) {
            return c;
        }
        if (i2 == 2) {
            return d;
        }
        if (i2 != 3) {
            return i2 != 4 ? c : f;
        }
        return e;
    }

    private float[] b(h hVar) {
        int i2 = AnonymousClass1.f38836a[hVar.ordinal()];
        if (i2 == 1) {
            return g;
        }
        if (i2 == 2) {
            return h;
        }
        if (i2 != 3) {
            return i2 != 4 ? g : j;
        }
        return i;
    }

    @Override // com.kc.cw.ad.internal.a.g
    public Animation a() {
        return this.f38835a;
    }

    @Override // com.kc.cw.ad.internal.a.g
    public Animation b() {
        return this.b;
    }
}

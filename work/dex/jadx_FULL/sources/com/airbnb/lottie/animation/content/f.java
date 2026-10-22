package com.airbnb.lottie.animation.content;

import android.graphics.Path;
import android.graphics.PointF;
import androidx.annotation.Nullable;
import androidx.camera.video.AudioStats;
import com.airbnb.lottie.LottieDrawable;
import com.airbnb.lottie.LottieProperty;
import com.airbnb.lottie.animation.keyframe.BaseKeyframeAnimation;
import com.airbnb.lottie.model.content.PolystarShape;
import com.airbnb.lottie.model.content.ShapeTrimPath;
import com.airbnb.lottie.model.layer.BaseLayer;
import com.zj.adlib.as1;
import com.zj.adlib.ds4;
import com.zj.adlib.j45;
import com.zj.adlib.up5;
import com.zj.adlib.yc9;
import java.util.List;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public class f implements PathContent, BaseKeyframeAnimation.AnimationListener, KeyPathElementContent {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final float f23338a = 0.47829f;
    public static final float b = 0.25f;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final LottieDrawable f421a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final BaseKeyframeAnimation<?, Float> f422a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final PolystarShape.Type f423a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final String f425a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final boolean f426a;

    /* JADX INFO: renamed from: b, reason: collision with other field name */
    public final BaseKeyframeAnimation<?, PointF> f427b;

    /* JADX INFO: renamed from: b, reason: collision with other field name */
    public final boolean f428b;
    public final BaseKeyframeAnimation<?, Float> c;

    /* JADX INFO: renamed from: c, reason: collision with other field name */
    public boolean f429c;

    @Nullable
    public final BaseKeyframeAnimation<?, Float> d;
    public final BaseKeyframeAnimation<?, Float> e;

    @Nullable
    public final BaseKeyframeAnimation<?, Float> f;
    public final BaseKeyframeAnimation<?, Float> g;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final Path f420a = new Path();

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final as1 f424a = new as1();

    public static /* synthetic */ class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f23339a;

        static {
            int[] iArr = new int[PolystarShape.Type.values().length];
            f23339a = iArr;
            try {
                iArr[PolystarShape.Type.STAR.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f23339a[PolystarShape.Type.POLYGON.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
        }
    }

    public f(LottieDrawable lottieDrawable, BaseLayer baseLayer, PolystarShape polystarShape) {
        this.f421a = lottieDrawable;
        this.f425a = polystarShape.d();
        PolystarShape.Type type = polystarShape.getType();
        this.f423a = type;
        this.f426a = polystarShape.j();
        this.f428b = polystarShape.k();
        BaseKeyframeAnimation<Float, Float> baseKeyframeAnimationA = polystarShape.g().a();
        this.f422a = baseKeyframeAnimationA;
        BaseKeyframeAnimation<PointF, PointF> baseKeyframeAnimationA2 = polystarShape.h().a();
        this.f427b = baseKeyframeAnimationA2;
        BaseKeyframeAnimation<Float, Float> baseKeyframeAnimationA3 = polystarShape.i().a();
        this.c = baseKeyframeAnimationA3;
        BaseKeyframeAnimation<Float, Float> baseKeyframeAnimationA4 = polystarShape.e().a();
        this.e = baseKeyframeAnimationA4;
        BaseKeyframeAnimation<Float, Float> baseKeyframeAnimationA5 = polystarShape.f().a();
        this.g = baseKeyframeAnimationA5;
        PolystarShape.Type type2 = PolystarShape.Type.STAR;
        if (type == type2) {
            this.d = polystarShape.b().a();
            this.f = polystarShape.c().a();
        } else {
            this.d = null;
            this.f = null;
        }
        baseLayer.j(baseKeyframeAnimationA);
        baseLayer.j(baseKeyframeAnimationA2);
        baseLayer.j(baseKeyframeAnimationA3);
        baseLayer.j(baseKeyframeAnimationA4);
        baseLayer.j(baseKeyframeAnimationA5);
        if (type == type2) {
            baseLayer.j(this.d);
            baseLayer.j(this.f);
        }
        baseKeyframeAnimationA.a(this);
        baseKeyframeAnimationA2.a(this);
        baseKeyframeAnimationA3.a(this);
        baseKeyframeAnimationA4.a(this);
        baseKeyframeAnimationA5.a(this);
        if (type == type2) {
            this.d.a(this);
            this.f.a(this);
        }
    }

    @Override // com.airbnb.lottie.animation.content.Content
    public void c(List<Content> list, List<Content> list2) {
        for (int i = 0; i < list.size(); i++) {
            Content content = list.get(i);
            if (content instanceof yc9) {
                yc9 yc9Var = (yc9) content;
                if (yc9Var.getType() == ShapeTrimPath.Type.SIMULTANEOUSLY) {
                    this.f424a.a(yc9Var);
                    yc9Var.e(this);
                }
            }
        }
    }

    public final void e() {
        int iFloor = (int) Math.floor(this.f422a.f().floatValue());
        BaseKeyframeAnimation<?, Float> baseKeyframeAnimation = this.c;
        double radians = Math.toRadians((baseKeyframeAnimation == null ? AudioStats.AUDIO_AMPLITUDE_NONE : baseKeyframeAnimation.f().floatValue()) - 90.0d);
        double d = iFloor;
        float fFloatValue = this.g.f().floatValue() / 100.0f;
        float fFloatValue2 = this.e.f().floatValue();
        double d2 = fFloatValue2;
        float fCos = (float) (Math.cos(radians) * d2);
        float fSin = (float) (Math.sin(radians) * d2);
        this.f420a.moveTo(fCos, fSin);
        double d3 = (float) (6.283185307179586d / d);
        double d4 = radians + d3;
        double dCeil = Math.ceil(d);
        int i = 0;
        while (i < dCeil) {
            float fCos2 = (float) (Math.cos(d4) * d2);
            double d5 = dCeil;
            float fSin2 = (float) (d2 * Math.sin(d4));
            if (fFloatValue != 0.0f) {
                double dAtan2 = (float) (Math.atan2(fSin, fCos) - 1.5707963267948966d);
                float fCos3 = (float) Math.cos(dAtan2);
                float fSin3 = (float) Math.sin(dAtan2);
                double dAtan3 = (float) (Math.atan2(fSin2, fCos2) - 1.5707963267948966d);
                float f = fFloatValue2 * fFloatValue * 0.25f;
                this.f420a.cubicTo(fCos - (fCos3 * f), fSin - (fSin3 * f), fCos2 + (((float) Math.cos(dAtan3)) * f), fSin2 + (f * ((float) Math.sin(dAtan3))), fCos2, fSin2);
            } else {
                this.f420a.lineTo(fCos2, fSin2);
            }
            d4 += d3;
            i++;
            fSin = fSin2;
            fCos = fCos2;
            dCeil = d5;
            d2 = d2;
            d3 = d3;
        }
        PointF pointFF = this.f427b.f();
        this.f420a.offset(pointFF.x, pointFF.y);
        this.f420a.close();
    }

    @Override // com.airbnb.lottie.animation.content.PathContent
    public Path f() {
        if (this.f429c) {
            return this.f420a;
        }
        this.f420a.reset();
        if (this.f426a) {
            this.f429c = true;
            return this.f420a;
        }
        int i = a.f23339a[this.f423a.ordinal()];
        if (i == 1) {
            j();
        } else if (i == 2) {
            e();
        }
        this.f420a.close();
        this.f424a.b(this.f420a);
        this.f429c = true;
        return this.f420a;
    }

    @Override // com.airbnb.lottie.model.KeyPathElement
    public void g(ds4 ds4Var, int i, List<ds4> list, ds4 ds4Var2) {
        up5.m(ds4Var, i, list, ds4Var2, this);
    }

    @Override // com.airbnb.lottie.animation.content.Content
    public String getName() {
        return this.f425a;
    }

    @Override // com.airbnb.lottie.animation.keyframe.BaseKeyframeAnimation.AnimationListener
    public void h() {
        k();
    }

    @Override // com.airbnb.lottie.model.KeyPathElement
    public <T> void i(T t, @Nullable j45<T> j45Var) {
        BaseKeyframeAnimation<?, Float> baseKeyframeAnimation;
        BaseKeyframeAnimation<?, Float> baseKeyframeAnimation2;
        if (t == LottieProperty.l) {
            this.f422a.k(j45Var);
            return;
        }
        if (t == LottieProperty.m) {
            this.c.k(j45Var);
            return;
        }
        if (t == LottieProperty.e) {
            this.f427b.k(j45Var);
            return;
        }
        if (t == LottieProperty.n && (baseKeyframeAnimation2 = this.d) != null) {
            baseKeyframeAnimation2.k(j45Var);
            return;
        }
        if (t == LottieProperty.o) {
            this.e.k(j45Var);
            return;
        }
        if (t == LottieProperty.p && (baseKeyframeAnimation = this.f) != null) {
            baseKeyframeAnimation.k(j45Var);
        } else if (t == LottieProperty.q) {
            this.g.k(j45Var);
        }
    }

    public final void j() {
        float f;
        float f2;
        double d;
        float fSin;
        float f3;
        float f4;
        float f5;
        float fFloatValue = this.f422a.f().floatValue();
        BaseKeyframeAnimation<?, Float> baseKeyframeAnimation = this.c;
        double radians = Math.toRadians((baseKeyframeAnimation == null ? AudioStats.AUDIO_AMPLITUDE_NONE : baseKeyframeAnimation.f().floatValue()) - 90.0d);
        double d2 = fFloatValue;
        float f6 = (float) (6.283185307179586d / d2);
        if (this.f428b) {
            f6 *= -1.0f;
        }
        float f7 = f6 / 2.0f;
        float f8 = fFloatValue - ((int) fFloatValue);
        if (f8 != 0.0f) {
            radians += (double) ((1.0f - f8) * f7);
        }
        float fFloatValue2 = this.e.f().floatValue();
        float fFloatValue3 = this.d.f().floatValue();
        BaseKeyframeAnimation<?, Float> baseKeyframeAnimation2 = this.f;
        float fFloatValue4 = baseKeyframeAnimation2 != null ? baseKeyframeAnimation2.f().floatValue() / 100.0f : 0.0f;
        BaseKeyframeAnimation<?, Float> baseKeyframeAnimation3 = this.g;
        float fFloatValue5 = baseKeyframeAnimation3 != null ? baseKeyframeAnimation3.f().floatValue() / 100.0f : 0.0f;
        if (f8 != 0.0f) {
            f3 = ((fFloatValue2 - fFloatValue3) * f8) + fFloatValue3;
            double d3 = f3;
            float fCos = (float) (d3 * Math.cos(radians));
            fSin = (float) (d3 * Math.sin(radians));
            this.f420a.moveTo(fCos, fSin);
            d = radians + ((double) ((f6 * f8) / 2.0f));
            f = fCos;
            f2 = f7;
        } else {
            double d4 = fFloatValue2;
            float fCos2 = (float) (Math.cos(radians) * d4);
            float fSin2 = (float) (d4 * Math.sin(radians));
            this.f420a.moveTo(fCos2, fSin2);
            f = fCos2;
            f2 = f7;
            d = radians + ((double) f2);
            fSin = fSin2;
            f3 = 0.0f;
        }
        double dCeil = Math.ceil(d2) * 2.0d;
        int i = 0;
        float f9 = f2;
        float f10 = f;
        boolean z = false;
        while (true) {
            double d5 = i;
            if (d5 >= dCeil) {
                PointF pointFF = this.f427b.f();
                this.f420a.offset(pointFF.x, pointFF.y);
                this.f420a.close();
                return;
            }
            float f11 = z ? fFloatValue2 : fFloatValue3;
            float f12 = (f3 == 0.0f || d5 != dCeil - 2.0d) ? f9 : (f6 * f8) / 2.0f;
            if (f3 == 0.0f || d5 != dCeil - 1.0d) {
                f3 = f11;
            }
            double d6 = f3;
            double d7 = dCeil;
            float fCos3 = (float) (d6 * Math.cos(d));
            float fSin3 = (float) (d6 * Math.sin(d));
            if (fFloatValue4 == 0.0f && fFloatValue5 == 0.0f) {
                this.f420a.lineTo(fCos3, fSin3);
                f4 = fFloatValue4;
                f5 = fFloatValue5;
            } else {
                f4 = fFloatValue4;
                double dAtan2 = (float) (Math.atan2(fSin, f10) - 1.5707963267948966d);
                float fCos4 = (float) Math.cos(dAtan2);
                float fSin4 = (float) Math.sin(dAtan2);
                f5 = fFloatValue5;
                double dAtan3 = (float) (Math.atan2(fSin3, fCos3) - 1.5707963267948966d);
                float fCos5 = (float) Math.cos(dAtan3);
                float fSin5 = (float) Math.sin(dAtan3);
                float f13 = z ? f4 : f5;
                float f14 = z ? f5 : f4;
                float f15 = (z ? fFloatValue3 : fFloatValue2) * f13 * 0.47829f;
                float f16 = fCos4 * f15;
                float f17 = f15 * fSin4;
                float f18 = (z ? fFloatValue2 : fFloatValue3) * f14 * 0.47829f;
                float f19 = fCos5 * f18;
                float f20 = f18 * fSin5;
                if (f8 != 0.0f) {
                    if (i == 0) {
                        f16 *= f8;
                        f17 *= f8;
                    } else if (d5 == d7 - 1.0d) {
                        f19 *= f8;
                        f20 *= f8;
                    }
                }
                this.f420a.cubicTo(f10 - f16, fSin - f17, fCos3 + f19, fSin3 + f20, fCos3, fSin3);
            }
            d += (double) f12;
            z = !z;
            i++;
            f10 = fCos3;
            fSin = fSin3;
            fFloatValue5 = f5;
            fFloatValue4 = f4;
            f3 = f3;
            f6 = f6;
            dCeil = d7;
        }
    }

    public final void k() {
        this.f429c = false;
        this.f421a.invalidateSelf();
    }
}

package com.airbnb.lottie.animation.keyframe;

import android.view.animation.Interpolator;
import androidx.annotation.FloatRange;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.camera.video.AudioStats;
import com.zj.adlib.j45;
import com.zj.adlib.ps4;
import com.zj.adlib.vs4;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public abstract class BaseKeyframeAnimation<K, A> {

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final KeyframesWrapper<K> f451a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @Nullable
    public j45<A> f452a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final List<AnimationListener> f454a = new ArrayList(1);

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public boolean f455a = false;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public float f23343a = 0.0f;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @Nullable
    public A f453a = null;
    public float b = -1.0f;
    public float c = -1.0f;

    public interface AnimationListener {
        void h();
    }

    public interface KeyframesWrapper<T> {
        ps4<T> a();

        @FloatRange(from = AudioStats.AUDIO_AMPLITUDE_NONE, to = 1.0d)
        float b();

        boolean c(float f);

        boolean d(float f);

        @FloatRange(from = AudioStats.AUDIO_AMPLITUDE_NONE, to = 1.0d)
        float e();

        boolean isEmpty();
    }

    public static final class b<T> implements KeyframesWrapper<T> {
        public b() {
        }

        @Override // com.airbnb.lottie.animation.keyframe.BaseKeyframeAnimation.KeyframesWrapper
        public ps4<T> a() {
            throw new IllegalStateException("not implemented");
        }

        @Override // com.airbnb.lottie.animation.keyframe.BaseKeyframeAnimation.KeyframesWrapper
        public float b() {
            return 0.0f;
        }

        @Override // com.airbnb.lottie.animation.keyframe.BaseKeyframeAnimation.KeyframesWrapper
        public boolean c(float f) {
            throw new IllegalStateException("not implemented");
        }

        @Override // com.airbnb.lottie.animation.keyframe.BaseKeyframeAnimation.KeyframesWrapper
        public boolean d(float f) {
            return false;
        }

        @Override // com.airbnb.lottie.animation.keyframe.BaseKeyframeAnimation.KeyframesWrapper
        public float e() {
            return 1.0f;
        }

        @Override // com.airbnb.lottie.animation.keyframe.BaseKeyframeAnimation.KeyframesWrapper
        public boolean isEmpty() {
            return true;
        }
    }

    public static final class c<T> implements KeyframesWrapper<T> {

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        public final List<? extends ps4<T>> f457a;
        public ps4<T> b = null;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public float f23344a = -1.0f;

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        @NonNull
        public ps4<T> f456a = f(0.0f);

        public c(List<? extends ps4<T>> list) {
            this.f457a = list;
        }

        @Override // com.airbnb.lottie.animation.keyframe.BaseKeyframeAnimation.KeyframesWrapper
        @NonNull
        public ps4<T> a() {
            return this.f456a;
        }

        @Override // com.airbnb.lottie.animation.keyframe.BaseKeyframeAnimation.KeyframesWrapper
        public float b() {
            return this.f457a.get(0).e();
        }

        @Override // com.airbnb.lottie.animation.keyframe.BaseKeyframeAnimation.KeyframesWrapper
        public boolean c(float f) {
            ps4<T> ps4Var = this.b;
            ps4<T> ps4Var2 = this.f456a;
            if (ps4Var == ps4Var2 && this.f23344a == f) {
                return true;
            }
            this.b = ps4Var2;
            this.f23344a = f;
            return false;
        }

        @Override // com.airbnb.lottie.animation.keyframe.BaseKeyframeAnimation.KeyframesWrapper
        public boolean d(float f) {
            if (this.f456a.a(f)) {
                return !this.f456a.h();
            }
            this.f456a = f(f);
            return true;
        }

        @Override // com.airbnb.lottie.animation.keyframe.BaseKeyframeAnimation.KeyframesWrapper
        public float e() {
            List<? extends ps4<T>> list = this.f457a;
            return list.get(list.size() - 1).b();
        }

        public final ps4<T> f(float f) {
            List<? extends ps4<T>> list = this.f457a;
            ps4<T> ps4Var = list.get(list.size() - 1);
            if (f >= ps4Var.e()) {
                return ps4Var;
            }
            for (int size = this.f457a.size() - 2; size >= 1; size--) {
                ps4<T> ps4Var2 = this.f457a.get(size);
                if (this.f456a != ps4Var2 && ps4Var2.a(f)) {
                    return ps4Var2;
                }
            }
            return this.f457a.get(0);
        }

        @Override // com.airbnb.lottie.animation.keyframe.BaseKeyframeAnimation.KeyframesWrapper
        public boolean isEmpty() {
            return false;
        }
    }

    public static final class d<T> implements KeyframesWrapper<T> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public float f23345a = -1.0f;

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        @NonNull
        public final ps4<T> f458a;

        public d(List<? extends ps4<T>> list) {
            this.f458a = list.get(0);
        }

        @Override // com.airbnb.lottie.animation.keyframe.BaseKeyframeAnimation.KeyframesWrapper
        public ps4<T> a() {
            return this.f458a;
        }

        @Override // com.airbnb.lottie.animation.keyframe.BaseKeyframeAnimation.KeyframesWrapper
        public float b() {
            return this.f458a.e();
        }

        @Override // com.airbnb.lottie.animation.keyframe.BaseKeyframeAnimation.KeyframesWrapper
        public boolean c(float f) {
            if (this.f23345a == f) {
                return true;
            }
            this.f23345a = f;
            return false;
        }

        @Override // com.airbnb.lottie.animation.keyframe.BaseKeyframeAnimation.KeyframesWrapper
        public boolean d(float f) {
            return !this.f458a.h();
        }

        @Override // com.airbnb.lottie.animation.keyframe.BaseKeyframeAnimation.KeyframesWrapper
        public float e() {
            return this.f458a.b();
        }

        @Override // com.airbnb.lottie.animation.keyframe.BaseKeyframeAnimation.KeyframesWrapper
        public boolean isEmpty() {
            return false;
        }
    }

    public BaseKeyframeAnimation(List<? extends ps4<K>> list) {
        this.f451a = l(list);
    }

    public static <T> KeyframesWrapper<T> l(List<? extends ps4<T>> list) {
        if (list.isEmpty()) {
            return new b();
        }
        return list.size() == 1 ? new d(list) : new c(list);
    }

    public void a(AnimationListener animationListener) {
        this.f454a.add(animationListener);
    }

    @FloatRange(from = AudioStats.AUDIO_AMPLITUDE_NONE, to = 1.0d)
    public float b() {
        if (this.c == -1.0f) {
            this.c = this.f451a.e();
        }
        return this.c;
    }

    public float c() {
        if (this.f455a) {
            return 0.0f;
        }
        ps4<K> currentKeyframe = getCurrentKeyframe();
        if (currentKeyframe.h()) {
            return 0.0f;
        }
        return (this.f23343a - currentKeyframe.e()) / (currentKeyframe.b() - currentKeyframe.e());
    }

    public float d() {
        return this.f23343a;
    }

    @FloatRange(from = AudioStats.AUDIO_AMPLITUDE_NONE, to = 1.0d)
    public final float e() {
        if (this.b == -1.0f) {
            this.b = this.f451a.b();
        }
        return this.b;
    }

    public A f() {
        float fC = c();
        if (this.f452a == null && this.f451a.c(fC)) {
            return this.f453a;
        }
        ps4<K> currentKeyframe = getCurrentKeyframe();
        Interpolator interpolator = currentKeyframe.f18931b;
        A aG = (interpolator == null || currentKeyframe.f18934c == null) ? g(currentKeyframe, getInterpolatedCurrentKeyframeProgress()) : getValue(currentKeyframe, fC, interpolator.getInterpolation(fC), currentKeyframe.f18934c.getInterpolation(fC));
        this.f453a = aG;
        return aG;
    }

    public abstract A g(ps4<K> ps4Var, float f);

    public ps4<K> getCurrentKeyframe() {
        vs4.a("BaseKeyframeAnimation#getCurrentKeyframe");
        ps4<K> ps4VarA = this.f451a.a();
        vs4.b("BaseKeyframeAnimation#getCurrentKeyframe");
        return ps4VarA;
    }

    public float getInterpolatedCurrentKeyframeProgress() {
        ps4<K> currentKeyframe = getCurrentKeyframe();
        if (currentKeyframe == null || currentKeyframe.h()) {
            return 0.0f;
        }
        return currentKeyframe.f18925a.getInterpolation(c());
    }

    public A getValue(ps4<K> ps4Var, float f, float f2, float f3) {
        throw new UnsupportedOperationException("This animation does not support split dimensions!");
    }

    public void h() {
        for (int i = 0; i < this.f454a.size(); i++) {
            this.f454a.get(i).h();
        }
    }

    public void i() {
        this.f455a = true;
    }

    public void j(@FloatRange(from = AudioStats.AUDIO_AMPLITUDE_NONE, to = 1.0d) float f) {
        if (this.f451a.isEmpty()) {
            return;
        }
        if (f < e()) {
            f = e();
        } else if (f > b()) {
            f = b();
        }
        if (f == this.f23343a) {
            return;
        }
        this.f23343a = f;
        if (this.f451a.d(f)) {
            h();
        }
    }

    public void k(@Nullable j45<A> j45Var) {
        j45<A> j45Var2 = this.f452a;
        if (j45Var2 != null) {
            j45Var2.c(null);
        }
        this.f452a = j45Var;
        if (j45Var != null) {
            j45Var.c(this);
        }
    }
}

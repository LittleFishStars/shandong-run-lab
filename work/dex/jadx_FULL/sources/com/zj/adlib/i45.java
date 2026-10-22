package com.zj.adlib;

import android.view.Choreographer;
import androidx.annotation.FloatRange;
import androidx.annotation.MainThread;
import androidx.annotation.Nullable;
import androidx.annotation.VisibleForTesting;
import androidx.camera.video.AudioStats;
import com.airbnb.lottie.utils.BaseLottieAnimator;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public class i45 extends BaseLottieAnimator implements Choreographer.FrameCallback {

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @Nullable
    public k35 f17140a;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public float f42275a = 1.0f;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public boolean f17141a = false;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public long f17139a = 0;
    public float b = 0.0f;
    public int K = 0;
    public float c = -2.1474836E9f;
    public float d = 2.1474836E9f;

    /* JADX INFO: renamed from: b, reason: collision with other field name */
    @VisibleForTesting
    public boolean f17142b = false;

    public void A(k35 k35Var) {
        boolean z = this.f17140a == null;
        this.f17140a = k35Var;
        if (z) {
            D(Math.max(this.c, k35Var.r()), Math.min(this.d, k35Var.f()));
        } else {
            D((int) k35Var.r(), (int) k35Var.f());
        }
        float f = this.b;
        this.b = 0.0f;
        B((int) f);
        i();
    }

    public void B(float f) {
        if (this.b == f) {
            return;
        }
        this.b = up5.c(f, s(), r());
        this.f17139a = 0L;
        i();
    }

    public void C(float f) {
        D(this.c, f);
    }

    public void D(float f, float f2) {
        if (f > f2) {
            throw new IllegalArgumentException(String.format("minFrame (%s) must be <= maxFrame (%s)", Float.valueOf(f), Float.valueOf(f2)));
        }
        k35 k35Var = this.f17140a;
        float fR = k35Var == null ? -3.4028235E38f : k35Var.r();
        k35 k35Var2 = this.f17140a;
        float f3 = k35Var2 == null ? Float.MAX_VALUE : k35Var2.f();
        float fC = up5.c(f, fR, f3);
        float fC2 = up5.c(f2, fR, f3);
        if (fC == this.c && fC2 == this.d) {
            return;
        }
        this.c = fC;
        this.d = fC2;
        B((int) up5.c(this.b, fC, fC2));
    }

    public void E(int i) {
        D(i, (int) this.d);
    }

    public void F(float f) {
        this.f42275a = f;
    }

    public final void G() {
        if (this.f17140a == null) {
            return;
        }
        float f = this.b;
        if (f < this.c || f > this.d) {
            throw new IllegalStateException(String.format("Frame must be [%f,%f]. It is %f", Float.valueOf(this.c), Float.valueOf(this.d), Float.valueOf(this.b)));
        }
    }

    @Override // com.airbnb.lottie.utils.BaseLottieAnimator
    public void a() {
        super.a();
        b(u());
    }

    @Override // android.animation.ValueAnimator, android.animation.Animator
    @MainThread
    public void cancel() {
        a();
        removeFrameCallback();
    }

    @Override // android.view.Choreographer.FrameCallback
    public void doFrame(long j) {
        postFrameCallback();
        if (this.f17140a == null || !isRunning()) {
            return;
        }
        vs4.a("LottieValueAnimator#doFrame");
        long j2 = this.f17139a;
        float fP = (j2 != 0 ? j - j2 : 0L) / p();
        float f = this.b;
        if (u()) {
            fP = -fP;
        }
        float f2 = f + fP;
        this.b = f2;
        boolean z = !up5.e(f2, s(), r());
        this.b = up5.c(this.b, s(), r());
        this.f17139a = j;
        i();
        if (z) {
            if (getRepeatCount() == -1 || this.K < getRepeatCount()) {
                d();
                this.K++;
                if (getRepeatMode() == 2) {
                    this.f17141a = !this.f17141a;
                    z();
                } else {
                    this.b = u() ? r() : s();
                }
                this.f17139a = j;
            } else {
                this.b = this.f42275a < 0.0f ? s() : r();
                removeFrameCallback();
                b(u());
            }
        }
        G();
        vs4.b("LottieValueAnimator#doFrame");
    }

    @Override // android.animation.ValueAnimator
    @FloatRange(from = AudioStats.AUDIO_AMPLITUDE_NONE, to = 1.0d)
    public float getAnimatedFraction() {
        float fS;
        float fR;
        float fS2;
        if (this.f17140a == null) {
            return 0.0f;
        }
        if (u()) {
            fS = r() - this.b;
            fR = r();
            fS2 = s();
        } else {
            fS = this.b - s();
            fR = r();
            fS2 = s();
        }
        return fS / (fR - fS2);
    }

    @Override // android.animation.ValueAnimator
    public Object getAnimatedValue() {
        return Float.valueOf(m());
    }

    @Override // android.animation.ValueAnimator, android.animation.Animator
    public long getDuration() {
        k35 k35Var = this.f17140a;
        if (k35Var == null) {
            return 0L;
        }
        return (long) k35Var.d();
    }

    @Override // android.animation.ValueAnimator, android.animation.Animator
    public boolean isRunning() {
        return this.f17142b;
    }

    public void k() {
        this.f17140a = null;
        this.c = -2.1474836E9f;
        this.d = 2.1474836E9f;
    }

    @MainThread
    public void l() {
        removeFrameCallback();
        b(u());
    }

    @FloatRange(from = AudioStats.AUDIO_AMPLITUDE_NONE, to = 1.0d)
    public float m() {
        k35 k35Var = this.f17140a;
        if (k35Var == null) {
            return 0.0f;
        }
        return (this.b - k35Var.r()) / (this.f17140a.f() - this.f17140a.r());
    }

    public float o() {
        return this.b;
    }

    public final float p() {
        k35 k35Var = this.f17140a;
        if (k35Var == null) {
            return Float.MAX_VALUE;
        }
        return (1.0E9f / k35Var.i()) / Math.abs(this.f42275a);
    }

    public void postFrameCallback() {
        if (isRunning()) {
            removeFrameCallback(false);
            Choreographer.getInstance().postFrameCallback(this);
        }
    }

    public float r() {
        k35 k35Var = this.f17140a;
        if (k35Var == null) {
            return 0.0f;
        }
        float f = this.d;
        return f == 2.1474836E9f ? k35Var.f() : f;
    }

    @MainThread
    public void removeFrameCallback() {
        removeFrameCallback(true);
    }

    public float s() {
        k35 k35Var = this.f17140a;
        if (k35Var == null) {
            return 0.0f;
        }
        float f = this.c;
        return f == -2.1474836E9f ? k35Var.r() : f;
    }

    @Override // android.animation.ValueAnimator
    public void setRepeatMode(int i) {
        super.setRepeatMode(i);
        if (i == 2 || !this.f17141a) {
            return;
        }
        this.f17141a = false;
        z();
    }

    public float t() {
        return this.f42275a;
    }

    public final boolean u() {
        return t() < 0.0f;
    }

    @MainThread
    public void v() {
        removeFrameCallback();
    }

    @MainThread
    public void x() {
        this.f17142b = true;
        h(u());
        B((int) (u() ? r() : s()));
        this.f17139a = 0L;
        this.K = 0;
        postFrameCallback();
    }

    @MainThread
    public void y() {
        this.f17142b = true;
        postFrameCallback();
        this.f17139a = 0L;
        if (u() && o() == s()) {
            this.b = r();
        } else {
            if (u() || o() != r()) {
                return;
            }
            this.b = s();
        }
    }

    public void z() {
        F(-t());
    }

    @MainThread
    public void removeFrameCallback(boolean z) {
        Choreographer.getInstance().removeFrameCallback(this);
        if (z) {
            this.f17142b = false;
        }
    }
}

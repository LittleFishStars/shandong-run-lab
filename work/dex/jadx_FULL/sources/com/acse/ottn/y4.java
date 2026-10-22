package com.acse.ottn;

import android.animation.Animator;
import android.view.View;
import android.view.ViewPropertyAnimator;
import android.view.animation.Interpolator;
import java.lang.ref.WeakReference;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public class y4 extends w4 {
    public static final long c = -1;
    public final WeakReference<ViewPropertyAnimator> b;

    public class a implements Animator.AnimatorListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ j.a f23307a;

        public a(j.a aVar) {
            this.f23307a = aVar;
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationCancel(Animator animator) {
            this.f23307a.d(null);
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            this.f23307a.b(null);
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationRepeat(Animator animator) {
            this.f23307a.c(null);
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animator) {
            this.f23307a.a(null);
        }
    }

    public y4(View view) {
        this.b = new WeakReference<>(view.animate());
    }

    @Override // com.acse.ottn.w4
    public w4 a(long j) {
        ViewPropertyAnimator viewPropertyAnimator = this.b.get();
        if (viewPropertyAnimator != null) {
            viewPropertyAnimator.setDuration(j);
        }
        return this;
    }

    @Override // com.acse.ottn.w4
    public long b() {
        ViewPropertyAnimator viewPropertyAnimator = this.b.get();
        if (viewPropertyAnimator != null) {
            return viewPropertyAnimator.getDuration();
        }
        return -1L;
    }

    @Override // com.acse.ottn.w4
    public long c() {
        ViewPropertyAnimator viewPropertyAnimator = this.b.get();
        if (viewPropertyAnimator != null) {
            return viewPropertyAnimator.getStartDelay();
        }
        return -1L;
    }

    @Override // com.acse.ottn.w4
    public void d() {
        ViewPropertyAnimator viewPropertyAnimator = this.b.get();
        if (viewPropertyAnimator != null) {
            viewPropertyAnimator.start();
        }
    }

    @Override // com.acse.ottn.w4
    public w4 e(float f) {
        ViewPropertyAnimator viewPropertyAnimator = this.b.get();
        if (viewPropertyAnimator != null) {
            viewPropertyAnimator.rotationX(f);
        }
        return this;
    }

    @Override // com.acse.ottn.w4
    public w4 f(float f) {
        ViewPropertyAnimator viewPropertyAnimator = this.b.get();
        if (viewPropertyAnimator != null) {
            viewPropertyAnimator.rotationXBy(f);
        }
        return this;
    }

    @Override // com.acse.ottn.w4
    public w4 g(float f) {
        ViewPropertyAnimator viewPropertyAnimator = this.b.get();
        if (viewPropertyAnimator != null) {
            viewPropertyAnimator.rotationY(f);
        }
        return this;
    }

    @Override // com.acse.ottn.w4
    public w4 h(float f) {
        ViewPropertyAnimator viewPropertyAnimator = this.b.get();
        if (viewPropertyAnimator != null) {
            viewPropertyAnimator.rotationYBy(f);
        }
        return this;
    }

    @Override // com.acse.ottn.w4
    public w4 i(float f) {
        ViewPropertyAnimator viewPropertyAnimator = this.b.get();
        if (viewPropertyAnimator != null) {
            viewPropertyAnimator.scaleX(f);
        }
        return this;
    }

    @Override // com.acse.ottn.w4
    public w4 j(float f) {
        ViewPropertyAnimator viewPropertyAnimator = this.b.get();
        if (viewPropertyAnimator != null) {
            viewPropertyAnimator.scaleXBy(f);
        }
        return this;
    }

    @Override // com.acse.ottn.w4
    public w4 k(float f) {
        ViewPropertyAnimator viewPropertyAnimator = this.b.get();
        if (viewPropertyAnimator != null) {
            viewPropertyAnimator.scaleY(f);
        }
        return this;
    }

    @Override // com.acse.ottn.w4
    public w4 l(float f) {
        ViewPropertyAnimator viewPropertyAnimator = this.b.get();
        if (viewPropertyAnimator != null) {
            viewPropertyAnimator.scaleYBy(f);
        }
        return this;
    }

    @Override // com.acse.ottn.w4
    public w4 m(float f) {
        ViewPropertyAnimator viewPropertyAnimator = this.b.get();
        if (viewPropertyAnimator != null) {
            viewPropertyAnimator.translationX(f);
        }
        return this;
    }

    @Override // com.acse.ottn.w4
    public w4 n(float f) {
        ViewPropertyAnimator viewPropertyAnimator = this.b.get();
        if (viewPropertyAnimator != null) {
            viewPropertyAnimator.translationXBy(f);
        }
        return this;
    }

    @Override // com.acse.ottn.w4
    public w4 o(float f) {
        ViewPropertyAnimator viewPropertyAnimator = this.b.get();
        if (viewPropertyAnimator != null) {
            viewPropertyAnimator.translationY(f);
        }
        return this;
    }

    @Override // com.acse.ottn.w4
    public w4 p(float f) {
        ViewPropertyAnimator viewPropertyAnimator = this.b.get();
        if (viewPropertyAnimator != null) {
            viewPropertyAnimator.translationYBy(f);
        }
        return this;
    }

    @Override // com.acse.ottn.w4
    public w4 q(float f) {
        ViewPropertyAnimator viewPropertyAnimator = this.b.get();
        if (viewPropertyAnimator != null) {
            viewPropertyAnimator.x(f);
        }
        return this;
    }

    @Override // com.acse.ottn.w4
    public w4 r(float f) {
        ViewPropertyAnimator viewPropertyAnimator = this.b.get();
        if (viewPropertyAnimator != null) {
            viewPropertyAnimator.xBy(f);
        }
        return this;
    }

    @Override // com.acse.ottn.w4
    public w4 s(float f) {
        ViewPropertyAnimator viewPropertyAnimator = this.b.get();
        if (viewPropertyAnimator != null) {
            viewPropertyAnimator.y(f);
        }
        return this;
    }

    @Override // com.acse.ottn.w4
    public w4 t(float f) {
        ViewPropertyAnimator viewPropertyAnimator = this.b.get();
        if (viewPropertyAnimator != null) {
            viewPropertyAnimator.yBy(f);
        }
        return this;
    }

    @Override // com.acse.ottn.w4
    public w4 a(Interpolator interpolator) {
        ViewPropertyAnimator viewPropertyAnimator = this.b.get();
        if (viewPropertyAnimator != null) {
            viewPropertyAnimator.setInterpolator(interpolator);
        }
        return this;
    }

    @Override // com.acse.ottn.w4
    public w4 b(long j) {
        ViewPropertyAnimator viewPropertyAnimator = this.b.get();
        if (viewPropertyAnimator != null) {
            viewPropertyAnimator.setStartDelay(j);
        }
        return this;
    }

    @Override // com.acse.ottn.w4
    public w4 c(float f) {
        ViewPropertyAnimator viewPropertyAnimator = this.b.get();
        if (viewPropertyAnimator != null) {
            viewPropertyAnimator.rotation(f);
        }
        return this;
    }

    @Override // com.acse.ottn.w4
    public w4 d(float f) {
        ViewPropertyAnimator viewPropertyAnimator = this.b.get();
        if (viewPropertyAnimator != null) {
            viewPropertyAnimator.rotationBy(f);
        }
        return this;
    }

    @Override // com.acse.ottn.w4
    public w4 a(j.a aVar) {
        ViewPropertyAnimator viewPropertyAnimator = this.b.get();
        if (viewPropertyAnimator != null) {
            if (aVar == null) {
                viewPropertyAnimator.setListener(null);
            } else {
                viewPropertyAnimator.setListener(new a(aVar));
            }
        }
        return this;
    }

    @Override // com.acse.ottn.w4
    public w4 b(float f) {
        ViewPropertyAnimator viewPropertyAnimator = this.b.get();
        if (viewPropertyAnimator != null) {
            viewPropertyAnimator.alphaBy(f);
        }
        return this;
    }

    @Override // com.acse.ottn.w4
    public void a() {
        ViewPropertyAnimator viewPropertyAnimator = this.b.get();
        if (viewPropertyAnimator != null) {
            viewPropertyAnimator.cancel();
        }
    }

    @Override // com.acse.ottn.w4
    public w4 a(float f) {
        ViewPropertyAnimator viewPropertyAnimator = this.b.get();
        if (viewPropertyAnimator != null) {
            viewPropertyAnimator.alpha(f);
        }
        return this;
    }
}

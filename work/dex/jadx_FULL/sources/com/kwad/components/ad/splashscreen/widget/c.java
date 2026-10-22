package com.kwad.components.ad.splashscreen.widget;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import androidx.annotation.MainThread;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.kwad.sdk.utils.bi;
import com.kwad.sdk.widget.KSFrameLayout;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_06_4659cls.dex */
public abstract class c extends KSFrameLayout {
    private Animator qU;
    private boolean qV;

    public c(@NonNull Context context) {
        this(context, null, 0);
    }

    public void a(@NonNull Context context, @Nullable AttributeSet attributeSet, int i) {
    }

    @Override // com.kwad.sdk.widget.KSFrameLayout
    public final void af() {
        super.af();
        Animator animator = this.qU;
        if (animator != null) {
            animator.cancel();
        }
    }

    @MainThread
    public final void fY() {
        Animator animator = this.qU;
        if (animator != null) {
            animator.cancel();
            this.qU = null;
        }
        Animator animatorFZ = fZ();
        this.qU = animatorFZ;
        if (animatorFZ != null) {
            animatorFZ.addListener(new AnimatorListenerAdapter() { // from class: com.kwad.components.ad.splashscreen.widget.c.1
                @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                public final void onAnimationCancel(Animator animator2) {
                    super.onAnimationCancel(animator2);
                    c.this.ob();
                }

                @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                public final void onAnimationEnd(Animator animator2) {
                    super.onAnimationEnd(animator2);
                    if (c.this.qV) {
                        return;
                    }
                    c.this.getInteractionView().postDelayed(new bi() { // from class: com.kwad.components.ad.splashscreen.widget.c.1.1
                        @Override // com.kwad.sdk.utils.bi
                        public final void doTask() {
                            if (c.this.qU != null) {
                                c.this.qU.start();
                            }
                        }
                    }, c.this.getAnimationDelayTime());
                }
            });
            this.qU.start();
        }
    }

    public abstract Animator fZ();

    public abstract int getAnimationDelayTime();

    public abstract View getInteractionView();

    public abstract void oa();

    public abstract void ob();

    public final void oc() {
        this.qV = true;
        Animator animator = this.qU;
        if (animator != null) {
            animator.cancel();
        }
    }

    public c(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public c(@NonNull Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.qV = false;
        a(context, attributeSet, i);
        oa();
    }
}

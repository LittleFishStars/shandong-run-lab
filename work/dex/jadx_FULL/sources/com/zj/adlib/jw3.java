package com.zj.adlib;

import android.animation.ValueAnimator;
import android.view.View;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_03_8012cls.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0007\u0010\bJ\u0018\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0002H\u0007¨\u0006\t"}, d2 = {"Lcom/zj/adlib/jw3;", "", "Landroid/view/View;", "preView", "curView", "", "b", "<init>", "()V", "base_release"}, k = 1, mv = {1, 8, 0})
public final class jw3 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @NotNull
    public static final jw3 f42687a = new jw3();

    @JvmStatic
    public static final void b(@NotNull final View preView, @NotNull final View curView) {
        Intrinsics.checkNotNullParameter(preView, "preView");
        Intrinsics.checkNotNullParameter(curView, "curView");
        preView.setAlpha(1.0f);
        curView.setAlpha(0.0f);
        float f = 1000L;
        final float f2 = f * 0.75f;
        final float f3 = f * 0.25f;
        ValueAnimator valueAnimatorOfFloat = ValueAnimator.ofFloat(1.0f, 0.5f, 1.0f);
        valueAnimatorOfFloat.setDuration(1000L);
        final long j = 1000;
        valueAnimatorOfFloat.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.zj.adlib.iw3
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                jw3.c(f2, preView, f3, j, curView, valueAnimator);
            }
        });
        valueAnimatorOfFloat.start();
    }

    public static final void c(float f, View view, float f2, long j, View view2, ValueAnimator valueAnimator) {
        Intrinsics.checkNotNullParameter(view, "$preView");
        Intrinsics.checkNotNullParameter(view2, "$curView");
        Intrinsics.checkNotNullParameter(valueAnimator, "animator");
        long currentPlayTime = valueAnimator.getCurrentPlayTime();
        if (currentPlayTime <= ((long) f)) {
            view.setAlpha((f - currentPlayTime) / f);
        }
        boolean z = false;
        if (((long) f2) <= currentPlayTime && currentPlayTime <= j) {
            z = true;
        }
        if (z) {
            view2.setAlpha((currentPlayTime - f2) / f);
        }
    }
}

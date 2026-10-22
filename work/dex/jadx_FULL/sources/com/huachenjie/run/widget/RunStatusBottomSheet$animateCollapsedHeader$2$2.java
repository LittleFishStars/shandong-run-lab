package com.huachenjie.run.widget;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.widget.LinearLayout;
import com.huachenjie.run.widget.RunStatusBottomSheet$animateCollapsedHeader$2$2;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_01_2010cls.dex */
@Metadata(d1 = {"\u0000\u001f\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0016J\u0010\u0010\b\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0016R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\t"}, d2 = {"com/huachenjie/run/widget/RunStatusBottomSheet$animateCollapsedHeader$2$2", "Landroid/animation/AnimatorListenerAdapter;", "canceled", "", "onAnimationCancel", "", com.ipd.dsp.internal.l.a.l, "Landroid/animation/Animator;", "onAnimationEnd", "run_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
@SourceDebugExtension({"SMAP\nRunStatusBottomSheet.kt\nKotlin\n*S Kotlin\n*F\n+ 1 RunStatusBottomSheet.kt\ncom/huachenjie/run/widget/RunStatusBottomSheet$animateCollapsedHeader$2$2\n+ 2 View.kt\nandroidx/core/view/ViewKt\n*L\n1#1,266:1\n262#2,2:267\n*S KotlinDebug\n*F\n+ 1 RunStatusBottomSheet.kt\ncom/huachenjie/run/widget/RunStatusBottomSheet$animateCollapsedHeader$2$2\n*L\n239#1:267,2\n*E\n"})
public final class RunStatusBottomSheet$animateCollapsedHeader$2$2 extends AnimatorListenerAdapter {
    final /* synthetic */ LinearLayout $header;
    final /* synthetic */ boolean $show;
    private boolean canceled;
    final /* synthetic */ RunStatusBottomSheet this$0;

    public RunStatusBottomSheet$animateCollapsedHeader$2$2(RunStatusBottomSheet runStatusBottomSheet, LinearLayout linearLayout, boolean z) {
        this.this$0 = runStatusBottomSheet;
        this.$header = linearLayout;
        this.$show = z;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onAnimationEnd$lambda$0(RunStatusBottomSheet runStatusBottomSheet) {
        Intrinsics.checkNotNullParameter(runStatusBottomSheet, "this$0");
        runStatusBottomSheet.updatePeekHeight();
    }

    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
    public void onAnimationCancel(@NotNull Animator animation) {
        Intrinsics.checkNotNullParameter(animation, com.ipd.dsp.internal.l.a.l);
        this.canceled = true;
    }

    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
    public void onAnimationEnd(@NotNull Animator animation) {
        Intrinsics.checkNotNullParameter(animation, com.ipd.dsp.internal.l.a.l);
        if (this.canceled) {
            return;
        }
        this.this$0.resetHeaderChildren(this.$header);
        this.$header.getLayoutParams().height = -2;
        this.$header.setVisibility(this.$show ? 0 : 8);
        this.$header.requestLayout();
        if (this.$show) {
            final RunStatusBottomSheet runStatusBottomSheet = this.this$0;
            runStatusBottomSheet.post(new Runnable() { // from class: com.zj.adlib.bn7
                @Override // java.lang.Runnable
                public final void run() {
                    RunStatusBottomSheet$animateCollapsedHeader$2$2.onAnimationEnd$lambda$0(runStatusBottomSheet);
                }
            });
        }
    }
}

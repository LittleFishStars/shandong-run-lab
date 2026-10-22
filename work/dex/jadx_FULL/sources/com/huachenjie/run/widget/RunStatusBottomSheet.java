package com.huachenjie.run.widget;

import android.animation.Animator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.content.ContextWrapper;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.PathInterpolator;
import android.widget.LinearLayout;
import androidx.cardview.widget.CardView;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.p002lifecycle.LifecycleOwner;
import androidx.p002lifecycle.ViewModelProvider;
import androidx.p002lifecycle.ViewModelStoreOwner;
import com.google.android.material.bottomsheet.BottomSheetBehavior;
import com.huachenjie.run.databinding.RunLayoutRunStatusSheetBinding;
import com.huachenjie.run.page.sun_run.SunshineRunVM;
import com.huachenjie.run.service.DataComponent;
import com.huachenjie.run.widget.RunStatusBottomSheet;
import com.igexin.push.g.o;
import com.noober.background.view.BLView;
import com.zj.adlib.jj8;
import java.util.Iterator;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.ranges.RangesKt;
import kotlin.sequences.SequencesKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_01_2010cls.dex */
@Metadata(d1 = {"\u0000\u0086\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u0000 R2\u00020\u0001:\u0001RB%\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ\u0010\u0010=\u001a\u00020#2\u0006\u0010>\u001a\u00020\u0010H\u0002J\u0010\u0010?\u001a\u00020#2\u0006\u0010@\u001a\u00020\u0010H\u0002J\u0010\u0010A\u001a\u00020#2\b\u0010B\u001a\u0004\u0018\u00010CJ\b\u0010D\u001a\u00020#H\u0002J\u0006\u0010E\u001a\u00020#J\u0010\u0010F\u001a\u00020\u00102\u0006\u0010G\u001a\u00020HH\u0016J\u0006\u0010I\u001a\u00020.J\u0010\u0010J\u001a\u00020\u00102\u0006\u0010G\u001a\u00020HH\u0002J\b\u0010K\u001a\u00020#H\u0016J\b\u0010L\u001a\u00020#H\u0016J\u0010\u0010M\u001a\u00020#2\u0006\u0010N\u001a\u00020OH\u0002J\u0010\u0010P\u001a\u00020#2\u0006\u0010>\u001a\u00020\u0010H\u0002J\b\u0010Q\u001a\u00020#H\u0002R\u001b\u0010\t\u001a\u00020\n8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\r\u0010\u000e\u001a\u0004\b\u000b\u0010\fR\u000e\u0010\u000f\u001a\u00020\u0010X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0011\u001a\u0004\u0018\u00010\u0012X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0013\u001a\u0004\u0018\u00010\u0014X\u0082\u000e¢\u0006\u0002\n\u0000R\u0016\u0010\u0015\u001a\u0004\u0018\u00010\u00168BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\u0017\u0010\u0018R\u001d\u0010\u0019\u001a\u0004\u0018\u00010\u00038BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u001c\u0010\u000e\u001a\u0004\b\u001a\u0010\u001bR\u0016\u0010\u001d\u001a\u0004\u0018\u00010\u001e8BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\u001f\u0010 R\"\u0010!\u001a\n\u0012\u0004\u0012\u00020#\u0018\u00010\"X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b$\u0010%\"\u0004\b&\u0010'R\"\u0010(\u001a\n\u0012\u0004\u0012\u00020#\u0018\u00010\"X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b)\u0010%\"\u0004\b*\u0010'R\u000e\u0010+\u001a\u00020,X\u0082\u0004¢\u0006\u0002\n\u0000R\u001b\u0010-\u001a\u00020.8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b1\u0010\u000e\u001a\u0004\b/\u00100R!\u00102\u001a\b\u0012\u0004\u0012\u000204038BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b7\u0010\u000e\u001a\u0004\b5\u00106R\u000e\u00108\u001a\u00020,X\u0082\u0004¢\u0006\u0002\n\u0000R\u001b\u00109\u001a\u0002048BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b<\u0010\u000e\u001a\u0004\b:\u0010;¨\u0006S"}, d2 = {"Lcom/huachenjie/run/widget/RunStatusBottomSheet;", "Landroidx/coordinatorlayout/widget/CoordinatorLayout;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "binding", "Lcom/huachenjie/run/databinding/RunLayoutRunStatusSheetBinding;", "getBinding", "()Lcom/huachenjie/run/databinding/RunLayoutRunStatusSheetBinding;", "binding$delegate", "Lkotlin/Lazy;", "expanded", "", "headerAnimRunnable", "Ljava/lang/Runnable;", "headerAnimator", "Landroid/animation/Animator;", "hostLifecycleOwner", "Landroidx/lifecycle/LifecycleOwner;", "getHostLifecycleOwner", "()Landroidx/lifecycle/LifecycleOwner;", "hostOwner", "getHostOwner", "()Landroid/content/Context;", "hostOwner$delegate", "hostViewModelStoreOwner", "Landroidx/lifecycle/ViewModelStoreOwner;", "getHostViewModelStoreOwner", "()Landroidx/lifecycle/ViewModelStoreOwner;", "onPauseClick", "Lkotlin/Function0;", "", "getOnPauseClick", "()Lkotlin/jvm/functions/Function0;", "setOnPauseClick", "(Lkotlin/jvm/functions/Function0;)V", "onQuitConfirm", "getOnQuitConfirm", "setOnQuitConfirm", "peekRect", "Landroid/graphics/Rect;", "scrimView", "Landroid/view/View;", "getScrimView", "()Landroid/view/View;", "scrimView$delegate", "sheetBehavior", "Lcom/google/android/material/bottomsheet/BottomSheetBehavior;", "Landroidx/cardview/widget/CardView;", "getSheetBehavior", "()Lcom/google/android/material/bottomsheet/BottomSheetBehavior;", "sheetBehavior$delegate", "sheetHitRect", "sheetView", "getSheetView", "()Landroidx/cardview/widget/CardView;", "sheetView$delegate", "animateCollapsedHeader", "show", "applyExpanded", "expand", "bind", "dc", "Lcom/huachenjie/run/service/DataComponent;", "cancelHeaderAnim", "collapse", "dispatchTouchEvent", "ev", "Landroid/view/MotionEvent;", "getCollapsedHeaderView", "isTouchOnSheet", "onAttachedToWindow", "onDetachedFromWindow", "resetHeaderChildren", "header", "Landroid/view/ViewGroup;", "scheduleCollapsedHeaderAnim", "updatePeekHeight", "Companion", "run_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
@SourceDebugExtension({"SMAP\nRunStatusBottomSheet.kt\nKotlin\n*S Kotlin\n*F\n+ 1 RunStatusBottomSheet.kt\ncom/huachenjie/run/widget/RunStatusBottomSheet\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n+ 3 View.kt\nandroidx/core/view/ViewKt\n*L\n1#1,266:1\n1#2:267\n260#3:268\n260#3:269\n262#3,2:270\n262#3,2:272\n260#3:274\n262#3,2:275\n*S KotlinDebug\n*F\n+ 1 RunStatusBottomSheet.kt\ncom/huachenjie/run/widget/RunStatusBottomSheet\n*L\n116#1:268\n152#1:269\n163#1:270,2\n189#1:272,2\n204#1:274\n205#1:275,2\n*E\n"})
public final class RunStatusBottomSheet extends CoordinatorLayout {
    private static final long HEADER_ANIM_DURATION = 320;

    /* JADX INFO: renamed from: binding$delegate, reason: from kotlin metadata */
    @NotNull
    private final Lazy binding;
    private boolean expanded;

    @Nullable
    private Runnable headerAnimRunnable;

    @Nullable
    private Animator headerAnimator;

    /* JADX INFO: renamed from: hostOwner$delegate, reason: from kotlin metadata */
    @NotNull
    private final Lazy hostOwner;

    @Nullable
    private Function0<Unit> onPauseClick;

    @Nullable
    private Function0<Unit> onQuitConfirm;

    @NotNull
    private final Rect peekRect;

    /* JADX INFO: renamed from: scrimView$delegate, reason: from kotlin metadata */
    @NotNull
    private final Lazy scrimView;

    /* JADX INFO: renamed from: sheetBehavior$delegate, reason: from kotlin metadata */
    @NotNull
    private final Lazy sheetBehavior;

    @NotNull
    private final Rect sheetHitRect;

    /* JADX INFO: renamed from: sheetView$delegate, reason: from kotlin metadata */
    @NotNull
    private final Lazy sheetView;

    @NotNull
    private static final PathInterpolator HEADER_INTERPOLATOR = new PathInterpolator(0.4f, 0.0f, 0.2f, 1.0f);

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public RunStatusBottomSheet(@NotNull Context context) {
        this(context, null, 0, 6, null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public RunStatusBottomSheet(@NotNull Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0, 4, null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    public /* synthetic */ RunStatusBottomSheet(Context context, AttributeSet attributeSet, int i, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i2 & 2) != 0 ? null : attributeSet, (i2 & 4) != 0 ? 0 : i);
    }

    private final void animateCollapsedHeader(final boolean show) {
        final int measuredHeight;
        final LinearLayout linearLayout = getBinding().f35696a;
        Intrinsics.checkNotNullExpressionValue(linearLayout, "binding.llCollapsedHeader");
        final int i = 0;
        if (!show) {
            int height = linearLayout.getHeight();
            if (height > 0) {
                if (linearLayout.getVisibility() == 0) {
                    measuredHeight = 0;
                    i = height;
                }
            }
            linearLayout.setVisibility(8);
            resetHeaderChildren(linearLayout);
            linearLayout.getLayoutParams().height = -2;
            return;
        }
        linearLayout.getLayoutParams().height = -2;
        linearLayout.setVisibility(0);
        linearLayout.measure(View.MeasureSpec.makeMeasureSpec(getSheetView().getWidth(), 1073741824), View.MeasureSpec.makeMeasureSpec(0, 0));
        measuredHeight = linearLayout.getMeasuredHeight();
        if (measuredHeight <= 0) {
            resetHeaderChildren(linearLayout);
            post(new Runnable() { // from class: com.zj.adlib.ym7
                @Override // java.lang.Runnable
                public final void run() {
                    RunStatusBottomSheet.animateCollapsedHeader$lambda$6(this.f46068a);
                }
            });
            return;
        }
        ValueAnimator valueAnimatorOfFloat = ValueAnimator.ofFloat(0.0f, 1.0f);
        valueAnimatorOfFloat.setDuration(HEADER_ANIM_DURATION);
        valueAnimatorOfFloat.setInterpolator(HEADER_INTERPOLATOR);
        valueAnimatorOfFloat.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.zj.adlib.zm7
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                RunStatusBottomSheet.animateCollapsedHeader$lambda$8$lambda$7(i, measuredHeight, linearLayout, show, valueAnimator);
            }
        });
        valueAnimatorOfFloat.addListener(new RunStatusBottomSheet$animateCollapsedHeader$2$2(this, linearLayout, show));
        valueAnimatorOfFloat.start();
        this.headerAnimator = valueAnimatorOfFloat;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void animateCollapsedHeader$lambda$6(RunStatusBottomSheet runStatusBottomSheet) {
        Intrinsics.checkNotNullParameter(runStatusBottomSheet, "this$0");
        runStatusBottomSheet.updatePeekHeight();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void animateCollapsedHeader$lambda$8$lambda$7(int i, int i2, LinearLayout linearLayout, boolean z, ValueAnimator valueAnimator) {
        Intrinsics.checkNotNullParameter(linearLayout, "$header");
        Intrinsics.checkNotNullParameter(valueAnimator, o.f);
        float animatedFraction = valueAnimator.getAnimatedFraction();
        int iCoerceAtLeast = RangesKt.coerceAtLeast((int) (i + ((i2 - i) * animatedFraction)), 0);
        linearLayout.getLayoutParams().height = iCoerceAtLeast;
        float fMax = Math.max(i, i2) - iCoerceAtLeast;
        if (!z) {
            animatedFraction = 1.0f - animatedFraction;
        }
        int childCount = linearLayout.getChildCount();
        for (int i3 = 0; i3 < childCount; i3++) {
            View childAt = linearLayout.getChildAt(i3);
            childAt.setTranslationY(fMax);
            childAt.setAlpha(animatedFraction);
        }
        linearLayout.requestLayout();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void applyExpanded(boolean expand) {
        if (this.expanded == expand) {
            return;
        }
        this.expanded = expand;
        BLView bLView = getBinding().f12157a.f12118a;
        Intrinsics.checkNotNullExpressionValue(bLView, "binding.pauseHeader.vHandle");
        bLView.setVisibility(expand ? 0 : 8);
        getBinding().f12159a.setTipVisible(expand);
        scheduleCollapsedHeaderAnim(!expand);
    }

    private final void cancelHeaderAnim() {
        Runnable runnable = this.headerAnimRunnable;
        if (runnable != null) {
            removeCallbacks(runnable);
        }
        this.headerAnimRunnable = null;
        Animator animator = this.headerAnimator;
        if (animator != null) {
            animator.cancel();
        }
        this.headerAnimator = null;
    }

    private final RunLayoutRunStatusSheetBinding getBinding() {
        return (RunLayoutRunStatusSheetBinding) this.binding.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final LifecycleOwner getHostLifecycleOwner() {
        Object hostOwner = getHostOwner();
        if (hostOwner instanceof LifecycleOwner) {
            return (LifecycleOwner) hostOwner;
        }
        return null;
    }

    private final Context getHostOwner() {
        return (Context) this.hostOwner.getValue();
    }

    private final ViewModelStoreOwner getHostViewModelStoreOwner() {
        Object hostOwner = getHostOwner();
        if (hostOwner instanceof ViewModelStoreOwner) {
            return (ViewModelStoreOwner) hostOwner;
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final View getScrimView() {
        return (View) this.scrimView.getValue();
    }

    private final BottomSheetBehavior<CardView> getSheetBehavior() {
        return (BottomSheetBehavior) this.sheetBehavior.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final CardView getSheetView() {
        return (CardView) this.sheetView.getValue();
    }

    private final boolean isTouchOnSheet(MotionEvent ev) {
        getSheetView().getHitRect(this.sheetHitRect);
        return this.sheetHitRect.contains((int) ev.getX(), (int) ev.getY());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onAttachedToWindow$lambda$3(RunStatusBottomSheet runStatusBottomSheet) {
        Intrinsics.checkNotNullParameter(runStatusBottomSheet, "this$0");
        runStatusBottomSheet.updatePeekHeight();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void resetHeaderChildren(ViewGroup header) {
        int childCount = header.getChildCount();
        for (int i = 0; i < childCount; i++) {
            View childAt = header.getChildAt(i);
            childAt.setTranslationY(0.0f);
            childAt.setAlpha(1.0f);
        }
    }

    private final void scheduleCollapsedHeaderAnim(final boolean show) {
        cancelHeaderAnim();
        Runnable runnable = new Runnable() { // from class: com.zj.adlib.xm7
            @Override // java.lang.Runnable
            public final void run() {
                RunStatusBottomSheet.scheduleCollapsedHeaderAnim$lambda$4(this.f45852a, show);
            }
        };
        this.headerAnimRunnable = runnable;
        post(runnable);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void scheduleCollapsedHeaderAnim$lambda$4(RunStatusBottomSheet runStatusBottomSheet, boolean z) {
        Intrinsics.checkNotNullParameter(runStatusBottomSheet, "this$0");
        runStatusBottomSheet.animateCollapsedHeader(z);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void updatePeekHeight() {
        LinearLayout linearLayout = getBinding().f35696a;
        Intrinsics.checkNotNullExpressionValue(linearLayout, "binding.llCollapsedHeader");
        if (linearLayout.getVisibility() == 0) {
            linearLayout.getDrawingRect(this.peekRect);
            getSheetView().offsetDescendantRectToMyCoords(linearLayout, this.peekRect);
            if (this.peekRect.bottom > 0) {
                getSheetBehavior().setPeekHeight(this.peekRect.bottom);
            }
        }
    }

    public final void bind(@Nullable DataComponent dc) {
        if (dc == null) {
            return;
        }
        getBinding().f12159a.applyRunMode(dc.v1() > 0, RunActionButton.TipStyle.SHEET);
        getBinding().executePendingBindings();
    }

    public final void collapse() {
        getSheetBehavior().setState(4);
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchTouchEvent(@NotNull MotionEvent ev) {
        Intrinsics.checkNotNullParameter(ev, "ev");
        if (!this.expanded) {
            if (!(getScrimView().getVisibility() == 0) && !isTouchOnSheet(ev)) {
                return false;
            }
        }
        return super.dispatchTouchEvent(ev);
    }

    @NotNull
    public final View getCollapsedHeaderView() {
        LinearLayout linearLayout = getBinding().f35696a;
        Intrinsics.checkNotNullExpressionValue(linearLayout, "binding.llCollapsedHeader");
        return linearLayout;
    }

    @Nullable
    public final Function0<Unit> getOnPauseClick() {
        return this.onPauseClick;
    }

    @Nullable
    public final Function0<Unit> getOnQuitConfirm() {
        return this.onQuitConfirm;
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout, android.view.ViewGroup, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        ViewModelStoreOwner hostViewModelStoreOwner = getHostViewModelStoreOwner();
        if (hostViewModelStoreOwner != null) {
            SunshineRunVM sunshineRunVM = (SunshineRunVM) new ViewModelProvider(hostViewModelStoreOwner).get(SunshineRunVM.class);
            getBinding().k(sunshineRunVM);
            getBinding().f12157a.k(sunshineRunVM);
            getBinding().executePendingBindings();
        }
        post(new Runnable() { // from class: com.zj.adlib.an7
            @Override // java.lang.Runnable
            public final void run() {
                RunStatusBottomSheet.onAttachedToWindow$lambda$3(this.f40560a);
            }
        });
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout, android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        cancelHeaderAnim();
        super.onDetachedFromWindow();
    }

    public final void setOnPauseClick(@Nullable Function0<Unit> function0) {
        this.onPauseClick = function0;
    }

    public final void setOnQuitConfirm(@Nullable Function0<Unit> function0) {
        this.onQuitConfirm = function0;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public RunStatusBottomSheet(@NotNull final Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        Intrinsics.checkNotNullParameter(context, "context");
        this.peekRect = new Rect();
        this.sheetHitRect = new Rect();
        this.hostOwner = LazyKt.lazy(new Function0<Context>() { // from class: com.huachenjie.run.widget.RunStatusBottomSheet$hostOwner$2
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            @Nullable
            /* JADX INFO: renamed from: invoke, reason: merged with bridge method [inline-methods] */
            public final Context m740invoke() {
                Object next;
                Iterator it = SequencesKt.generateSequence(context, new Function1<Context, Context>() { // from class: com.huachenjie.run.widget.RunStatusBottomSheet$hostOwner$2.1
                    @Nullable
                    public final Context invoke(@NotNull Context context2) {
                        Intrinsics.checkNotNullParameter(context2, o.f);
                        ContextWrapper contextWrapper = context2 instanceof ContextWrapper ? (ContextWrapper) context2 : null;
                        if (contextWrapper != null) {
                            return contextWrapper.getBaseContext();
                        }
                        return null;
                    }
                }).iterator();
                while (it.hasNext()) {
                    next = it.next();
                    Context context2 = (Context) next;
                    if ((context2 instanceof LifecycleOwner) && (context2 instanceof ViewModelStoreOwner)) {
                        return (Context) next;
                    }
                }
                next = null;
                return (Context) next;
            }
        });
        this.scrimView = LazyKt.lazy(new Function0<View>() { // from class: com.huachenjie.run.widget.RunStatusBottomSheet$scrimView$2
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            @NotNull
            /* JADX INFO: renamed from: invoke, reason: merged with bridge method [inline-methods] */
            public final View m741invoke() {
                View view = new View(context);
                view.setBackgroundColor(Integer.MIN_VALUE);
                view.setAlpha(0.0f);
                view.setVisibility(8);
                view.setClickable(true);
                return view;
            }
        });
        this.sheetView = LazyKt.lazy(new Function0<CardView>() { // from class: com.huachenjie.run.widget.RunStatusBottomSheet$sheetView$2
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            @NotNull
            /* JADX INFO: renamed from: invoke, reason: merged with bridge method [inline-methods] */
            public final CardView m743invoke() {
                CardView cardView = new CardView(context);
                cardView.setRadius(jj8.a(20.0f));
                cardView.setCardElevation(0.0f);
                cardView.setCardBackgroundColor(-1);
                cardView.setPreventCornerOverlap(false);
                cardView.setClickable(true);
                return cardView;
            }
        });
        this.binding = LazyKt.lazy(new Function0<RunLayoutRunStatusSheetBinding>() { // from class: com.huachenjie.run.widget.RunStatusBottomSheet$binding$2
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            @NotNull
            /* JADX INFO: renamed from: invoke, reason: merged with bridge method [inline-methods] */
            public final RunLayoutRunStatusSheetBinding m737invoke() {
                RunLayoutRunStatusSheetBinding runLayoutRunStatusSheetBindingH = RunLayoutRunStatusSheetBinding.h(LayoutInflater.from(context), this.getSheetView(), true);
                final RunStatusBottomSheet runStatusBottomSheet = this;
                runLayoutRunStatusSheetBindingH.setLifecycleOwner(runStatusBottomSheet.getHostLifecycleOwner());
                runLayoutRunStatusSheetBindingH.f12157a.f12118a.setVisibility(8);
                runLayoutRunStatusSheetBindingH.f12157a.setLifecycleOwner(runStatusBottomSheet.getHostLifecycleOwner());
                runLayoutRunStatusSheetBindingH.f12159a.setOnActionClick(new Function0<Unit>() { // from class: com.huachenjie.run.widget.RunStatusBottomSheet$binding$2$1$1
                    {
                        super(0);
                    }

                    public /* bridge */ /* synthetic */ Object invoke() {
                        m738invoke();
                        return Unit.INSTANCE;
                    }

                    /* JADX INFO: renamed from: invoke, reason: collision with other method in class */
                    public final void m738invoke() {
                        Function0<Unit> onPauseClick = runStatusBottomSheet.getOnPauseClick();
                        if (onPauseClick != null) {
                            onPauseClick.invoke();
                        }
                    }
                });
                runLayoutRunStatusSheetBindingH.f12159a.setOnActionLongPress(new Function0<Unit>() { // from class: com.huachenjie.run.widget.RunStatusBottomSheet$binding$2$1$2
                    {
                        super(0);
                    }

                    public /* bridge */ /* synthetic */ Object invoke() {
                        m739invoke();
                        return Unit.INSTANCE;
                    }

                    /* JADX INFO: renamed from: invoke, reason: collision with other method in class */
                    public final void m739invoke() {
                        Function0<Unit> onQuitConfirm = runStatusBottomSheet.getOnQuitConfirm();
                        if (onQuitConfirm != null) {
                            onQuitConfirm.invoke();
                        }
                    }
                });
                return runLayoutRunStatusSheetBindingH;
            }
        });
        this.sheetBehavior = LazyKt.lazy(new Function0<BottomSheetBehavior<CardView>>() { // from class: com.huachenjie.run.widget.RunStatusBottomSheet$sheetBehavior$2
            {
                super(0);
            }

            @NotNull
            /* JADX INFO: renamed from: invoke, reason: merged with bridge method [inline-methods] */
            public final BottomSheetBehavior<CardView> m742invoke() {
                BottomSheetBehavior<CardView> bottomSheetBehavior = new BottomSheetBehavior<>();
                final RunStatusBottomSheet runStatusBottomSheet = this.this$0;
                bottomSheetBehavior.addBottomSheetCallback(new BottomSheetBehavior.BottomSheetCallback() { // from class: com.huachenjie.run.widget.RunStatusBottomSheet$sheetBehavior$2$1$1
                    @Override // com.google.android.material.bottomsheet.BottomSheetBehavior.BottomSheetCallback
                    public void onSlide(@NotNull View bottomSheet, float slideOffset) {
                        Intrinsics.checkNotNullParameter(bottomSheet, "bottomSheet");
                        float fCoerceIn = RangesKt.coerceIn(slideOffset, 0.0f, 1.0f);
                        runStatusBottomSheet.getScrimView().setVisibility((fCoerceIn > 0.0f ? 1 : (fCoerceIn == 0.0f ? 0 : -1)) > 0 ? 0 : 8);
                        runStatusBottomSheet.getScrimView().setAlpha(fCoerceIn);
                    }

                    @Override // com.google.android.material.bottomsheet.BottomSheetBehavior.BottomSheetCallback
                    public void onStateChanged(@NotNull View bottomSheet, int newState) {
                        Intrinsics.checkNotNullParameter(bottomSheet, "bottomSheet");
                        if (newState == 3) {
                            runStatusBottomSheet.applyExpanded(true);
                        } else {
                            if (newState != 4) {
                                return;
                            }
                            runStatusBottomSheet.applyExpanded(false);
                        }
                    }
                });
                return bottomSheetBehavior;
            }
        });
        addView(getScrimView(), new CoordinatorLayout.LayoutParams(-1, -1));
        CardView sheetView = getSheetView();
        getBinding();
        CoordinatorLayout.LayoutParams layoutParams = new CoordinatorLayout.LayoutParams(-1, -2);
        layoutParams.setBehavior(getSheetBehavior());
        Unit unit = Unit.INSTANCE;
        addView(sheetView, layoutParams);
    }
}

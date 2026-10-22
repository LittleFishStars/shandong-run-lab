package com.huachenjie.run.binding;

import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.view.ViewCompat;
import androidx.coroutines.BindingAdapter;
import com.huachenjie.run.R;
import com.huachenjie.run.widget.PaceErrorView;
import com.ipd.dsp.internal.e1.f;
import com.zj.adlib.PaceErrorBigState;
import com.zj.adlib.jj8;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.ranges.RangesKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_01_2010cls.dex */
@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0007\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\u0005\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u001c\u0010\u001dJ\u001a\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0007J!\u0010\u000b\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\b2\b\u0010\n\u001a\u0004\u0018\u00010\tH\u0007¢\u0006\u0004\b\u000b\u0010\fJ!\u0010\u0010\u001a\u00020\u00062\u0006\u0010\u000e\u001a\u00020\r2\b\u0010\u000f\u001a\u0004\u0018\u00010\tH\u0007¢\u0006\u0004\b\u0010\u0010\u0011R\u0014\u0010\u0014\u001a\u00020\u00128\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u0010\u0010\u0013R\u0014\u0010\u0015\u001a\u00020\u00128\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u000b\u0010\u0013R\u0014\u0010\u0016\u001a\u00020\u00128\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u0007\u0010\u0013R\u0014\u0010\u0018\u001a\u00020\u00128\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u0017\u0010\u0013R\u0014\u0010\u001b\u001a\u00020\u00198\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u0010\u0010\u001a¨\u0006\u001e"}, d2 = {"Lcom/huachenjie/run/binding/RunBindingAdapter;", "", "Lcom/huachenjie/run/widget/PaceErrorView;", "view", "Lcom/zj/adlib/yk6;", "state", "", "c", "Landroid/widget/TextView;", "", "highlight", "b", "(Landroid/widget/TextView;Ljava/lang/Boolean;)V", "Landroidx/constraintlayout/widget/ConstraintLayout;", "container", "unused", "a", "(Landroidx/constraintlayout/widget/ConstraintLayout;Ljava/lang/Boolean;)V", "", "F", "MOOD_BTN_DESIGN_HEIGHT_DP", "MOOD_BTN_TEXT_DP", "MOOD_BTN_COIN_DP", "d", "MOOD_BTN_GAP_DP", "", "I", "MOOD_BTN_SHADOW_COLOR", "<init>", "()V", "run_release"}, k = 1, mv = {1, 8, 0})
@SourceDebugExtension({"SMAP\nRunBindingAdapter.kt\nKotlin\n*S Kotlin\n*F\n+ 1 RunBindingAdapter.kt\ncom/huachenjie/run/binding/RunBindingAdapter\n+ 2 View.kt\nandroidx/core/view/ViewKt\n*L\n1#1,81:1\n68#2,4:82\n40#2:86\n56#2:87\n75#2:88\n*S KotlinDebug\n*F\n+ 1 RunBindingAdapter.kt\ncom/huachenjie/run/binding/RunBindingAdapter\n*L\n77#1:82,4\n77#1:86\n77#1:87\n77#1:88\n*E\n"})
public final class RunBindingAdapter {

    /* JADX INFO: renamed from: a, reason: collision with root package name and from kotlin metadata */
    public static final float MOOD_BTN_DESIGN_HEIGHT_DP = 52.0f;

    /* JADX INFO: renamed from: a, reason: collision with other field name and from kotlin metadata */
    public static final int MOOD_BTN_SHADOW_COLOR = -1712499968;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NotNull
    public static final RunBindingAdapter f11397a = new RunBindingAdapter();

    /* JADX INFO: renamed from: b, reason: from kotlin metadata */
    public static final float MOOD_BTN_TEXT_DP = 16.0f;

    /* JADX INFO: renamed from: c, reason: from kotlin metadata */
    public static final float MOOD_BTN_COIN_DP = 24.0f;

    /* JADX INFO: renamed from: d, reason: from kotlin metadata */
    public static final float MOOD_BTN_GAP_DP = 2.0f;

    @Metadata(d1 = {"\u0000\u001f\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\b\n\u0002\u0010\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001JP\u0010\u000e\u001a\u00020\r2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u00042\u0006\u0010\t\u001a\u00020\u00042\u0006\u0010\n\u001a\u00020\u00042\u0006\u0010\u000b\u001a\u00020\u00042\u0006\u0010\f\u001a\u00020\u0004H\u0016¨\u0006\u000f¸\u0006\u0010"}, d2 = {"androidx/core/view/ViewKt$doOnNextLayout$1", "Landroid/view/View$OnLayoutChangeListener;", "Landroid/view/View;", "view", "", "left", f.l, "right", f.n, "oldLeft", "oldTop", "oldRight", "oldBottom", "", "onLayoutChange", "core-ktx_release", "androidx/core/view/ViewKt$doOnLayout$$inlined$doOnNextLayout$1"}, k = 1, mv = {1, 8, 0})
    @SourceDebugExtension({"SMAP\nView.kt\nKotlin\n*S Kotlin\n*F\n+ 1 View.kt\nandroidx/core/view/ViewKt$doOnNextLayout$1\n+ 2 View.kt\nandroidx/core/view/ViewKt\n+ 3 RunBindingAdapter.kt\ncom/huachenjie/run/binding/RunBindingAdapter\n*L\n1#1,432:1\n72#2:433\n73#2:435\n77#3:434\n*E\n"})
    public static final class a implements View.OnLayoutChangeListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Function0 f35436a;

        public a(Function0 function0) {
            this.f35436a = function0;
        }

        @Override // android.view.View.OnLayoutChangeListener
        public void onLayoutChange(@NotNull View view, int left, int top, int right, int bottom, int oldLeft, int oldTop, int oldRight, int oldBottom) {
            Intrinsics.checkNotNullParameter(view, "view");
            view.removeOnLayoutChangeListener(this);
            this.f35436a.invoke();
        }
    }

    @BindingAdapter({"moodBtnScaleContent"})
    @JvmStatic
    public static final void a(@NotNull final ConstraintLayout container, @Nullable Boolean unused) {
        Intrinsics.checkNotNullParameter(container, "container");
        final ImageView imageView = (ImageView) container.findViewById(R.id.ivMoodBtnBg);
        if (imageView == null) {
            return;
        }
        Function0<ImageView> function0 = new Function0<ImageView>() { // from class: com.huachenjie.run.binding.RunBindingAdapter$bindMoodBtnScaleContent$apply$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            @Nullable
            /* JADX INFO: renamed from: invoke, reason: merged with bridge method [inline-methods] */
            public final ImageView m610invoke() {
                float height = imageView.getHeight() > 0 ? imageView.getHeight() / RangesKt.coerceAtLeast(jj8.a(52.0f), 1.0f) : 1.0f;
                float fA = jj8.a(16.0f) * height;
                int iCoerceAtLeast = RangesKt.coerceAtLeast((int) (jj8.a(24.0f) * height), 1);
                int iA = (int) (jj8.a(2.0f) * height);
                TextView textView = (TextView) container.findViewById(R.id.tvMoodBtnText);
                if (textView != null) {
                    textView.setTextSize(0, fA);
                }
                TextView textView2 = (TextView) container.findViewById(R.id.tvMoodBtnReward);
                if (textView2 != null) {
                    textView2.setTextSize(0, fA);
                    ViewGroup.LayoutParams layoutParams = textView2.getLayoutParams();
                    ViewGroup.MarginLayoutParams marginLayoutParams = layoutParams instanceof ViewGroup.MarginLayoutParams ? (ViewGroup.MarginLayoutParams) layoutParams : null;
                    if (marginLayoutParams != null) {
                        marginLayoutParams.setMarginStart(iA);
                        textView2.setLayoutParams(marginLayoutParams);
                    }
                }
                ImageView imageView2 = (ImageView) container.findViewById(R.id.ivMoodBtnCoin);
                if (imageView2 == null) {
                    return null;
                }
                ViewGroup.LayoutParams layoutParams2 = imageView2.getLayoutParams();
                ViewGroup.MarginLayoutParams marginLayoutParams2 = layoutParams2 instanceof ViewGroup.MarginLayoutParams ? (ViewGroup.MarginLayoutParams) layoutParams2 : null;
                if (marginLayoutParams2 != null) {
                    marginLayoutParams2.width = iCoerceAtLeast;
                    marginLayoutParams2.height = iCoerceAtLeast;
                    marginLayoutParams2.setMarginStart(iA);
                    imageView2.setLayoutParams(marginLayoutParams2);
                }
                return imageView2;
            }
        };
        if (imageView.getHeight() > 0) {
            function0.invoke();
        } else if (!ViewCompat.isLaidOut(imageView) || imageView.isLayoutRequested()) {
            imageView.addOnLayoutChangeListener(new a(function0));
        } else {
            function0.invoke();
        }
    }

    @BindingAdapter({"moodBtnTextShadow"})
    @JvmStatic
    public static final void b(@NotNull TextView view, @Nullable Boolean highlight) {
        Intrinsics.checkNotNullParameter(view, "view");
        if (Intrinsics.areEqual(highlight, Boolean.TRUE)) {
            view.setShadowLayer(3.0f, 0.0f, 0.0f, MOOD_BTN_SHADOW_COLOR);
        } else {
            view.setShadowLayer(0.0f, 0.0f, 0.0f, 0);
        }
    }

    @BindingAdapter({"paceErrorBigState"})
    @JvmStatic
    public static final void c(@NotNull PaceErrorView view, @Nullable PaceErrorBigState state) {
        Intrinsics.checkNotNullParameter(view, "view");
        view.bindState(state);
    }
}

package com.huachenjie.run.widget;

import android.animation.ObjectAnimator;
import android.content.Context;
import android.graphics.Typeface;
import android.os.SystemClock;
import android.text.SpannableStringBuilder;
import android.text.TextPaint;
import android.text.style.MetricAffectingSpan;
import android.util.AttributeSet;
import android.util.Property;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.View;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.widget.FrameLayout;
import android.widget.TextView;
import com.alibaba.ariver.kernel.RVParams;
import com.google.android.material.timepicker.TimeModel;
import com.huachenjie.run.databinding.RunLayoutAutoPauseBinding;
import com.huachenjie.run.widget.AutoPauseView;
import java.util.Arrays;
import java.util.Locale;
import kotlin.Metadata;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.jvm.internal.StringCompanionObject;
import kotlin.ranges.RangesKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_01_2010cls.dex */
@Metadata(d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\r\n\u0002\b\t\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\u0018\u0000 $2\u00020\u0001:\u0001$B%\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ\b\u0010\u0011\u001a\u00020\u0012H\u0002J\u0010\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u0010H\u0002J\u0006\u0010\u0016\u001a\u00020\u0012J\b\u0010\u0017\u001a\u00020\u0012H\u0002J\b\u0010\u0018\u001a\u00020\u0012H\u0014J\u0016\u0010\u0019\u001a\u00020\u00122\u0006\u0010\u0015\u001a\u00020\u00102\u0006\u0010\u001a\u001a\u00020\u0007J\b\u0010\u001b\u001a\u00020\u0012H\u0002J\b\u0010\u001c\u001a\u00020\u0012H\u0002J\b\u0010\u001d\u001a\u00020\u001eH\u0002J\u001c\u0010\u001f\u001a\u00020\u0012*\u00020 2\u0006\u0010!\u001a\u00020\"2\u0006\u0010#\u001a\u00020\"H\u0002R\u000e\u0010\t\u001a\u00020\nX\u0082\u0004¢\u0006\u0002\n\u0000R\u0012\u0010\u000b\u001a\u0004\u0018\u00010\u0007X\u0082\u000e¢\u0006\u0004\n\u0002\u0010\fR\u0010\u0010\r\u001a\u0004\u0018\u00010\u000eX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0010X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006%"}, d2 = {"Lcom/huachenjie/run/widget/AutoPauseView;", "Landroid/widget/FrameLayout;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "binding", "Lcom/huachenjie/run/databinding/RunLayoutAutoPauseBinding;", "boundReason", "Ljava/lang/Integer;", "breathAnimator", "Landroid/animation/ObjectAnimator;", "userDismissUntilElapsed", "", "dismissByUser", "", "formatCountdown", "", "leftSecs", "hide", "hideInternal", "onDetachedFromWindow", "setLastedDuration", "pauseReason", "startBreath", "stopBreath", "unitSpan", "Landroid/text/style/MetricAffectingSpan;", "appendPart", "Landroid/text/SpannableStringBuilder;", "number", "", "unit", "Companion", "run_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
@SourceDebugExtension({"SMAP\nAutoPauseView.kt\nKotlin\n*S Kotlin\n*F\n+ 1 AutoPauseView.kt\ncom/huachenjie/run/widget/AutoPauseView\n+ 2 View.kt\nandroidx/core/view/ViewKt\n*L\n1#1,150:1\n302#2:151\n302#2:152\n302#2:153\n*S KotlinDebug\n*F\n+ 1 AutoPauseView.kt\ncom/huachenjie/run/widget/AutoPauseView\n*L\n84#1:151\n92#1:152\n103#1:153\n*E\n"})
public final class AutoPauseView extends FrameLayout {
    private static final long USER_DISMISS_SUPPRESS_MS = 3000;

    @NotNull
    private final RunLayoutAutoPauseBinding binding;

    @Nullable
    private Integer boundReason;

    @Nullable
    private ObjectAnimator breathAnimator;
    private long userDismissUntilElapsed;

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public AutoPauseView(@NotNull Context context) {
        this(context, null, 0, 6, null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public AutoPauseView(@NotNull Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0, 4, null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    public /* synthetic */ AutoPauseView(Context context, AttributeSet attributeSet, int i, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i2 & 2) != 0 ? null : attributeSet, (i2 & 4) != 0 ? 0 : i);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void _init_$lambda$0(AutoPauseView autoPauseView, View view) {
        Intrinsics.checkNotNullParameter(autoPauseView, "this$0");
        autoPauseView.dismissByUser();
    }

    private final void appendPart(SpannableStringBuilder spannableStringBuilder, String str, String str2) {
        spannableStringBuilder.append((CharSequence) str);
        int length = spannableStringBuilder.length();
        spannableStringBuilder.append((CharSequence) str2);
        spannableStringBuilder.setSpan(unitSpan(), length, spannableStringBuilder.length(), 33);
    }

    private final void dismissByUser() {
        if (getVisibility() == 8) {
            return;
        }
        this.userDismissUntilElapsed = SystemClock.elapsedRealtime() + 3000;
        hideInternal();
    }

    private final CharSequence formatCountdown(long leftSecs) {
        long jCoerceAtLeast = RangesKt.coerceAtLeast(leftSecs, 0L);
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
        long j = 60;
        appendPart(spannableStringBuilder, String.valueOf(jCoerceAtLeast / j), " 分 ");
        StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
        String str = String.format(Locale.US, TimeModel.ZERO_LEADING_NUMBER_FORMAT, Arrays.copyOf(new Object[]{Long.valueOf(jCoerceAtLeast % j)}, 1));
        Intrinsics.checkNotNullExpressionValue(str, "format(locale, format, *args)");
        appendPart(spannableStringBuilder, str, " 秒");
        return spannableStringBuilder;
    }

    private final void hideInternal() {
        if (getVisibility() == 8) {
            return;
        }
        setVisibility(8);
        this.boundReason = null;
        stopBreath();
    }

    private final void startBreath() {
        stopBreath();
        ObjectAnimator objectAnimatorOfFloat = ObjectAnimator.ofFloat(this.binding.b, (Property<View, Float>) FrameLayout.ALPHA, 0.45f, 1.0f);
        objectAnimatorOfFloat.setDuration(1000L);
        objectAnimatorOfFloat.setRepeatCount(-1);
        objectAnimatorOfFloat.setRepeatMode(2);
        objectAnimatorOfFloat.setInterpolator(new AccelerateDecelerateInterpolator());
        objectAnimatorOfFloat.start();
        this.breathAnimator = objectAnimatorOfFloat;
    }

    private final void stopBreath() {
        ObjectAnimator objectAnimator = this.breathAnimator;
        if (objectAnimator != null) {
            objectAnimator.cancel();
        }
        this.breathAnimator = null;
        this.binding.b.setAlpha(1.0f);
    }

    private final MetricAffectingSpan unitSpan() {
        final float fApplyDimension = TypedValue.applyDimension(2, 24.0f, getResources().getDisplayMetrics());
        return new MetricAffectingSpan() { // from class: com.huachenjie.run.widget.AutoPauseView.unitSpan.1
            @Override // android.text.style.CharacterStyle
            public void updateDrawState(@NotNull TextPaint tp) {
                Intrinsics.checkNotNullParameter(tp, RVParams.TITLE_PENETRATE);
                tp.setTextSize(fApplyDimension);
                tp.setTypeface(Typeface.DEFAULT_BOLD);
            }

            @Override // android.text.style.MetricAffectingSpan
            public void updateMeasureState(@NotNull TextPaint tp) {
                Intrinsics.checkNotNullParameter(tp, RVParams.TITLE_PENETRATE);
                updateDrawState(tp);
            }
        };
    }

    public final void hide() {
        this.userDismissUntilElapsed = 0L;
        hideInternal();
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        stopBreath();
        super.onDetachedFromWindow();
    }

    public final void setLastedDuration(long leftSecs, int pauseReason) {
        String str;
        String str2;
        Integer num = this.boundReason;
        if (num == null || num.intValue() != pauseReason) {
            this.boundReason = Integer.valueOf(pauseReason);
            boolean z = (pauseReason & 1) > 0;
            boolean z2 = (pauseReason & 2) > 0;
            TextView textView = this.binding.c;
            if (z) {
                str = "离开围栏了！";
            } else {
                str = z2 ? "请关闭Wi-Fi！" : "跑步已暂停！";
            }
            textView.setText(str);
            TextView textView2 = this.binding.f12004b;
            if (z && z2) {
                str2 = "您已离开有效跑步区域且学校不允许跑步时连接Wi-Fi，请尽快回到围栏且关闭Wi-Fi跑步，否则倒计时结束后跑步自动结束。";
            } else if (z) {
                str2 = "您已离开有效跑步范围，请尽快回到围栏内，否则倒计时结束后跑步自动结束。";
            } else {
                str2 = z2 ? "您的学校不允许跑步时连接Wi-Fi，请关闭Wi-Fi开关跑步，否则倒计时结束后跑步自动结束。" : "请尽快恢复正常跑步状态，否则倒计时结束后跑步自动结束。";
            }
            textView2.setText(str2);
        }
        this.binding.f12003a.setText(formatCountdown(leftSecs));
        if (!(getVisibility() == 8) || SystemClock.elapsedRealtime() < this.userDismissUntilElapsed) {
            return;
        }
        setVisibility(0);
        startBreath();
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public AutoPauseView(@NotNull Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        Intrinsics.checkNotNullParameter(context, "context");
        RunLayoutAutoPauseBinding runLayoutAutoPauseBindingB = RunLayoutAutoPauseBinding.b(LayoutInflater.from(context), this);
        Intrinsics.checkNotNullExpressionValue(runLayoutAutoPauseBindingB, "inflate(LayoutInflater.from(context), this)");
        this.binding = runLayoutAutoPauseBindingB;
        setClickable(false);
        runLayoutAutoPauseBindingB.f12002a.setOnClickListener(new View.OnClickListener() { // from class: com.zj.adlib.ii0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                AutoPauseView._init_$lambda$0(this.f42361a, view);
            }
        });
        setVisibility(8);
    }
}

package com.huachenjie.run.widget;

import android.animation.ObjectAnimator;
import android.content.Context;
import android.graphics.Typeface;
import android.os.Handler;
import android.os.Looper;
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
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import com.google.android.material.timepicker.TimeModel;
import com.huachenjie.common.R;
import com.huachenjie.common.util.VibratorUtils;
import com.huachenjie.run.databinding.RunLayoutPaceErrorBinding;
import com.zj.adlib.PaceErrorBigState;
import com.zj.adlib.nl8;
import java.util.Arrays;
import java.util.Locale;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.jvm.internal.StringCompanionObject;
import kotlin.ranges.RangesKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_01_2010cls.dex */
@Metadata(d1 = {"\u0000q\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\r\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006*\u0001;\u0018\u0000 E2\u00020\u0001:\u0001EB'\b\u0007\u0012\u0006\u0010?\u001a\u00020>\u0012\n\b\u0002\u0010A\u001a\u0004\u0018\u00010@\u0012\b\b\u0002\u0010B\u001a\u00020\t¢\u0006\u0004\bC\u0010DJ\b\u0010\u0003\u001a\u00020\u0002H\u0002J\u0010\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J\b\u0010\b\u001a\u00020\u0006H\u0002J\u0010\u0010\f\u001a\u00020\u000b2\u0006\u0010\n\u001a\u00020\tH\u0002J\u001c\u0010\u0011\u001a\u00020\u0006*\u00020\r2\u0006\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u0010\u001a\u00020\u000eH\u0002J\b\u0010\u0012\u001a\u00020\u0006H\u0002J\b\u0010\u0013\u001a\u00020\u0006H\u0002J\b\u0010\u0014\u001a\u00020\u0006H\u0002J\b\u0010\u0015\u001a\u00020\u0006H\u0002J\b\u0010\u0016\u001a\u00020\u0006H\u0002J\u0010\u0010\u0018\u001a\u00020\u00062\u0006\u0010\u0017\u001a\u00020\tH\u0002J\b\u0010\u0019\u001a\u00020\u0006H\u0002J\b\u0010\u001a\u001a\u00020\u0006H\u0002J\b\u0010\u001b\u001a\u00020\u0006H\u0002J\u0016\u0010\u001e\u001a\u00020\u00062\u000e\u0010\u001d\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u001cJ\u0010\u0010\u001f\u001a\u00020\u00062\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004J\u0006\u0010!\u001a\u00020 J\u0006\u0010\"\u001a\u00020\u0006J\u0006\u0010#\u001a\u00020\u0006J\u0006\u0010$\u001a\u00020\u0006J\b\u0010%\u001a\u00020\u0006H\u0014R\u0014\u0010'\u001a\u00020&8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b'\u0010(R\u0014\u0010*\u001a\u00020)8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b*\u0010+R\u0018\u0010-\u001a\u0004\u0018\u00010,8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b-\u0010.R\u0016\u0010\n\u001a\u00020\t8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\n\u0010/R$\u00101\u001a\u00020\t2\u0006\u00100\u001a\u00020\t8\u0006@BX\u0086\u000e¢\u0006\f\n\u0004\b1\u0010/\u001a\u0004\b2\u00103R\u0016\u00104\u001a\u00020 8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b4\u00105R\u0016\u00106\u001a\u00020 8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b6\u00105R\u0016\u00107\u001a\u00020 8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b7\u00105R\u0016\u00108\u001a\u00020 8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b8\u00105R\u001e\u00109\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u001c8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b9\u0010:R\u0014\u0010<\u001a\u00020;8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b<\u0010=¨\u0006F"}, d2 = {"Lcom/huachenjie/run/widget/PaceErrorView;", "Landroid/widget/FrameLayout;", "Landroid/text/style/MetricAffectingSpan;", "unitSpan", "Lcom/zj/adlib/yk6;", "state", "", "show", "finishByTimeout", "", "leftSecs", "", "formatCountdown", "Landroid/text/SpannableStringBuilder;", "", "number", "unit", "appendPart", "startBreath", "stopBreath", "startTick", "stopTick", "playTickVoiceIfNeeded", "rawId", "playVoice", "stopSound", "startVibrate", "stopVibrate", "Lkotlin/Function0;", ServiceSpecificExtraArgs.CastExtraArgs.f31291a, "setOnTimeout", "bindState", "", "isWorking", "onPause", "onResume", "hide", "onDetachedFromWindow", "Lcom/huachenjie/run/databinding/RunLayoutPaceErrorBinding;", "binding", "Lcom/huachenjie/run/databinding/RunLayoutPaceErrorBinding;", "Landroid/os/Handler;", "handler", "Landroid/os/Handler;", "Landroid/animation/ObjectAnimator;", "breathAnimator", "Landroid/animation/ObjectAnimator;", "I", "<set-?>", "totalSecs", "getTotalSecs", "()I", "isTooFast", "Z", "isSilence", "ticking", "pausedByLifecycle", "onTimeout", "Lkotlin/jvm/functions/Function0;", "com/huachenjie/run/widget/PaceErrorView$tickRunnable$1", "tickRunnable", "Lcom/huachenjie/run/widget/PaceErrorView$tickRunnable$1;", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", "attrs", "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "Companion", "run_release"}, k = 1, mv = {1, 8, 0})
@SourceDebugExtension({"SMAP\nPaceErrorView.kt\nKotlin\n*S Kotlin\n*F\n+ 1 PaceErrorView.kt\ncom/huachenjie/run/widget/PaceErrorView\n+ 2 View.kt\nandroidx/core/view/ViewKt\n+ 3 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,248:1\n260#2:249\n302#2:250\n302#2:251\n260#2:252\n1#3:253\n*S KotlinDebug\n*F\n+ 1 PaceErrorView.kt\ncom/huachenjie/run/widget/PaceErrorView\n*L\n100#1:249\n103#1:250\n123#1:251\n140#1:252\n*E\n"})
public final class PaceErrorView extends FrameLayout {
    private static final int ALARM_VOICE_INTERVAL = 4;
    private static final int BEGIN_VOICE_OFFSET = 2;
    private static final long TICK_MS = 1000;

    @NotNull
    private final RunLayoutPaceErrorBinding binding;

    @Nullable
    private ObjectAnimator breathAnimator;

    @NotNull
    private final Handler handler;
    private boolean isSilence;
    private boolean isTooFast;
    private int leftSecs;

    @Nullable
    private Function0<Unit> onTimeout;
    private boolean pausedByLifecycle;

    @NotNull
    private final PaceErrorView$tickRunnable$1 tickRunnable;
    private boolean ticking;
    private int totalSecs;

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public PaceErrorView(@NotNull Context context) {
        this(context, null, 0, 6, null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public PaceErrorView(@NotNull Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0, 4, null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    public /* synthetic */ PaceErrorView(Context context, AttributeSet attributeSet, int i, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i2 & 2) != 0 ? null : attributeSet, (i2 & 4) != 0 ? 0 : i);
    }

    private final void appendPart(SpannableStringBuilder spannableStringBuilder, String str, String str2) {
        spannableStringBuilder.append((CharSequence) str);
        int length = spannableStringBuilder.length();
        spannableStringBuilder.append((CharSequence) str2);
        spannableStringBuilder.setSpan(unitSpan(), length, spannableStringBuilder.length(), 33);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void finishByTimeout() {
        stopTick();
        stopVibrate();
        stopSound();
        stopBreath();
        setVisibility(8);
        this.pausedByLifecycle = false;
        Function0<Unit> function0 = this.onTimeout;
        if (function0 != null) {
            function0.invoke();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final CharSequence formatCountdown(int leftSecs) {
        int iCoerceAtLeast = RangesKt.coerceAtLeast(leftSecs, 0);
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
        appendPart(spannableStringBuilder, String.valueOf(iCoerceAtLeast / 60), " 分 ");
        StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
        String str = String.format(Locale.US, TimeModel.ZERO_LEADING_NUMBER_FORMAT, Arrays.copyOf(new Object[]{Integer.valueOf(iCoerceAtLeast % 60)}, 1));
        Intrinsics.checkNotNullExpressionValue(str, "format(locale, format, *args)");
        appendPart(spannableStringBuilder, str, " 秒");
        return spannableStringBuilder;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void playTickVoiceIfNeeded() {
        int i = this.leftSecs;
        if (i == 30) {
            playVoice(this.isTooFast ? R.raw.pace_too_fast_30_sec_tips : R.raw.pace_too_low_30_sec_tips);
        } else {
            if (i == 30 || (i - 2) % 4 != 0) {
                return;
            }
            playVoice(R.raw.pace_error_alarm);
        }
    }

    private final void playVoice(int rawId) {
        if (this.isSilence || rawId == 0) {
            return;
        }
        try {
            Result.Companion companion = Result.Companion;
            nl8.e(getContext()).q(rawId);
            Result.constructor-impl(Unit.INSTANCE);
        } catch (Throwable th) {
            Result.Companion companion2 = Result.Companion;
            Result.constructor-impl(ResultKt.createFailure(th));
        }
    }

    private final void show(PaceErrorBigState state) {
        if (getVisibility() == 0) {
            return;
        }
        this.isTooFast = state.l();
        this.isSilence = state.k();
        this.totalSecs = state.i();
        this.leftSecs = state.i();
        this.pausedByLifecycle = false;
        this.binding.d.setText(state.l() ? "跑太快了！" : "跑太慢了！");
        this.binding.c.setText("持续 " + state.i() + " 秒成绩无效");
        this.binding.f12107b.setText(state.h());
        this.binding.f12106a.setText(formatCountdown(this.leftSecs));
        setVisibility(0);
        startBreath();
        startVibrate();
        playVoice(state.l() ? R.raw.pace_too_fast : R.raw.pace_too_slow);
        startTick();
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

    private final void startTick() {
        stopTick();
        this.ticking = true;
        this.handler.postDelayed(this.tickRunnable, 1000L);
    }

    private final void startVibrate() {
        try {
            Result.Companion companion = Result.Companion;
            VibratorUtils.c();
            Result.constructor-impl(Unit.INSTANCE);
        } catch (Throwable th) {
            Result.Companion companion2 = Result.Companion;
            Result.constructor-impl(ResultKt.createFailure(th));
        }
    }

    private final void stopBreath() {
        ObjectAnimator objectAnimator = this.breathAnimator;
        if (objectAnimator != null) {
            objectAnimator.cancel();
        }
        this.breathAnimator = null;
        this.binding.b.setAlpha(1.0f);
    }

    private final void stopSound() {
        try {
            Result.Companion companion = Result.Companion;
            nl8.e(getContext()).v(true);
            Result.constructor-impl(Unit.INSTANCE);
        } catch (Throwable th) {
            Result.Companion companion2 = Result.Companion;
            Result.constructor-impl(ResultKt.createFailure(th));
        }
    }

    private final void stopTick() {
        this.ticking = false;
        this.handler.removeCallbacks(this.tickRunnable);
    }

    private final void stopVibrate() {
        try {
            Result.Companion companion = Result.Companion;
            VibratorUtils.a();
            Result.constructor-impl(Unit.INSTANCE);
        } catch (Throwable th) {
            Result.Companion companion2 = Result.Companion;
            Result.constructor-impl(ResultKt.createFailure(th));
        }
    }

    private final MetricAffectingSpan unitSpan() {
        final float fApplyDimension = TypedValue.applyDimension(2, 24.0f, getResources().getDisplayMetrics());
        return new MetricAffectingSpan() { // from class: com.huachenjie.run.widget.PaceErrorView.unitSpan.1
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

    public final void bindState(@Nullable PaceErrorBigState state) {
        if (state == null || !state.j() || state.i() <= 0) {
            hide();
        } else {
            if (this.pausedByLifecycle) {
                return;
            }
            show(state);
        }
    }

    public final int getTotalSecs() {
        return this.totalSecs;
    }

    public final void hide() {
        if (getVisibility() == 8) {
            return;
        }
        setVisibility(8);
        stopTick();
        stopVibrate();
        stopSound();
        stopBreath();
        this.pausedByLifecycle = false;
    }

    public final boolean isWorking() {
        if (this.ticking) {
            return getVisibility() == 0;
        }
        return false;
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        stopTick();
        stopVibrate();
        stopBreath();
        super.onDetachedFromWindow();
    }

    public final void onPause() {
        if (getVisibility() == 8) {
            return;
        }
        this.pausedByLifecycle = true;
        stopVibrate();
        stopTick();
        stopBreath();
        setVisibility(8);
    }

    public final void onResume() {
        if (this.pausedByLifecycle) {
            this.pausedByLifecycle = false;
            int i = this.leftSecs;
            if (i <= 0 || this.totalSecs <= 0) {
                return;
            }
            this.binding.f12106a.setText(formatCountdown(i));
            setVisibility(0);
            startBreath();
            startVibrate();
            startTick();
        }
    }

    public final void setOnTimeout(@Nullable Function0<Unit> listener) {
        this.onTimeout = listener;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Type inference failed for: r2v4, types: [com.huachenjie.run.widget.PaceErrorView$tickRunnable$1] */
    @JvmOverloads
    public PaceErrorView(@NotNull Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        Intrinsics.checkNotNullParameter(context, "context");
        RunLayoutPaceErrorBinding runLayoutPaceErrorBindingB = RunLayoutPaceErrorBinding.b(LayoutInflater.from(context), this);
        Intrinsics.checkNotNullExpressionValue(runLayoutPaceErrorBindingB, "inflate(LayoutInflater.from(context), this)");
        this.binding = runLayoutPaceErrorBindingB;
        this.handler = new Handler(Looper.getMainLooper());
        this.tickRunnable = new Runnable() { // from class: com.huachenjie.run.widget.PaceErrorView$tickRunnable$1
            @Override // java.lang.Runnable
            public void run() {
                if (this.this$0.leftSecs <= 0) {
                    this.this$0.finishByTimeout();
                    return;
                }
                this.this$0.leftSecs--;
                this.this$0.playTickVoiceIfNeeded();
                TextView textView = this.this$0.binding.f12106a;
                PaceErrorView paceErrorView = this.this$0;
                textView.setText(paceErrorView.formatCountdown(paceErrorView.leftSecs));
                if (this.this$0.leftSecs <= 0) {
                    this.this$0.finishByTimeout();
                } else {
                    this.this$0.handler.postDelayed(this, 1000L);
                }
            }
        };
        setClickable(false);
        setVisibility(8);
    }
}

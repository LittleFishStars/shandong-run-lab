package com.huachenjie.run.widget;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.text.SpannableString;
import android.text.style.ForegroundColorSpan;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.view.ViewPropertyAnimator;
import android.view.animation.OvershootInterpolator;
import android.widget.FrameLayout;
import android.widget.TextView;
import com.airbnb.lottie.LottieAnimationView;
import com.alibaba.ariver.kernel.api.extension.bridge.BridgeDSL;
import com.bumptech.glide.Glide;
import com.huachenjie.common.bean.BrandPromotionConfigBean;
import com.huachenjie.run.R;
import com.huachenjie.run.databinding.RunViewSunRunStartAnimBinding;
import com.huachenjie.run.widget.SunRunStartAnimView;
import com.kuaishou.weapon.p0.t;
import com.zj.adlib.ai9;
import com.zj.adlib.nl8;
import java.io.IOException;
import java.util.Arrays;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.ArraysKt;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.text.StringsKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_01_2010cls.dex */
@Metadata(d1 = {"\u0000d\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\r\n\u0000\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0010\u0015\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000 02\u00020\u0001:\u00010B%\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ\u0010\u0010\u0013\u001a\u00020\u00122\u0006\u0010\u0014\u001a\u00020\u0007H\u0002J\b\u0010\u0015\u001a\u00020\u0012H\u0002J\u0010\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u0019H\u0002J\u0006\u0010\u001a\u001a\u00020\u0012J\b\u0010\u001b\u001a\u00020\u0012H\u0002J\u0010\u0010\u001c\u001a\u00020\u00072\u0006\u0010\u001d\u001a\u00020\u0007H\u0002J\b\u0010\u001e\u001a\u00020\u0012H\u0002J\b\u0010\u001f\u001a\u00020\u0012H\u0014J\u0014\u0010 \u001a\u00020\u00122\n\u0010!\u001a\u00020\"\"\u00020\u0007H\u0002J\u001e\u0010#\u001a\u00020\u00122\u0006\u0010$\u001a\u00020%2\f\u0010&\u001a\b\u0012\u0004\u0012\u00020\u00120\u0011H\u0002J\b\u0010'\u001a\u00020\u0012H\u0002J\u0010\u0010(\u001a\u00020\u00122\u0006\u0010)\u001a\u00020\fH\u0002J\n\u0010*\u001a\u0004\u0018\u00010+H\u0002J\u0010\u0010,\u001a\u00020\u00122\u0006\u0010\u0014\u001a\u00020\u0007H\u0002J\u0014\u0010-\u001a\u00020\u00122\f\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00120\u0011J\u0010\u0010.\u001a\u00020\u00122\u0006\u0010/\u001a\u00020\fH\u0002R\u000e\u0010\t\u001a\u00020\nX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\fX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\fX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000fX\u0082\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\u0010\u001a\n\u0012\u0004\u0012\u00020\u0012\u0018\u00010\u0011X\u0082\u000e¢\u0006\u0002\n\u0000¨\u00061"}, d2 = {"Lcom/huachenjie/run/widget/SunRunStartAnimView;", "Landroid/widget/FrameLayout;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "binding", "Lcom/huachenjie/run/databinding/RunViewSunRunStartAnimBinding;", "brandMode", "", "cancelled", "handler", "Landroid/os/Handler;", "onComplete", "Lkotlin/Function0;", "", "advanceAfterIndex", "index", "applyBrandPromotionUi", "buildBrandRemindText", "", "brandName", "", "cancel", "cancelInternal", t.q, "value", "finishOverlay", "onDetachedFromWindow", "playSound", "rawIds", "", "postAnim", "delayMs", "", "action", "releaseHeavyResources", "resetWarmUpActionLayout", "ready", "resolveBrandPromotionConfig", "Lcom/huachenjie/common/bean/BrandPromotionConfigBean;", "showCountdownAtIndex", "start", "updateWarmUpCardOverhang", "brand", "Companion", "run_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
@SourceDebugExtension({"SMAP\nSunRunStartAnimView.kt\nKotlin\n*S Kotlin\n*F\n+ 1 SunRunStartAnimView.kt\ncom/huachenjie/run/widget/SunRunStartAnimView\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,291:1\n1#2:292\n*E\n"})
public final class SunRunStartAnimView extends FrameLayout {
    private static final int BRAND_NAME_COLOR = -28392;
    private static final int BRAND_OVERHANG_DP = 37;
    private static final int CARD_MIN_WIDTH_DP = 224;
    private static final int CHARACTER_OVERHANG_DP = 3;
    private static final long FADE_MS = 200;
    private static final long GO_HOLD_MS = 720;
    private static final long HOLD_MS = 2000;
    private static final long INTRO_TO_COUNTDOWN_MS = 2560;

    @NotNull
    private static final String LOTTIE_FILE = "sun_run_start_anim.json";
    private static final int REMIND_TEXT_COLOR = -9078407;
    private static final long SPRING_MS = 280;
    private static final int STROKE_DP = 6;

    @NotNull
    private final RunViewSunRunStartAnimBinding binding;
    private boolean brandMode;
    private boolean cancelled;

    @NotNull
    private final Handler handler;

    @Nullable
    private Function0<Unit> onComplete;

    @NotNull
    private static final String[] NUMBERS = {"3", "2", "1", "GO"};

    @NotNull
    private static final int[] CHARACTER_RES = {R.drawable.run_ic_run_start_anim1, R.drawable.run_ic_run_start_anim2, R.drawable.run_ic_run_start_anim3};

    /* JADX INFO: renamed from: com.huachenjie.run.widget.SunRunStartAnimView$advanceAfterIndex$1, reason: invalid class name */
    @Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "", BridgeDSL.INVOKE}, k = 3, mv = {1, 8, 0}, xi = 48)
    public static final class AnonymousClass1 extends Lambda implements Function0<Unit> {
        final /* synthetic */ int $index;
        final /* synthetic */ SunRunStartAnimView this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass1(int i, SunRunStartAnimView sunRunStartAnimView) {
            super(0);
            this.$index = i;
            this.this$0 = sunRunStartAnimView;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void invoke$lambda$0(SunRunStartAnimView sunRunStartAnimView, int i) throws IOException {
            Intrinsics.checkNotNullParameter(sunRunStartAnimView, "this$0");
            if (sunRunStartAnimView.cancelled) {
                return;
            }
            sunRunStartAnimView.showCountdownAtIndex(i + 1);
        }

        public /* bridge */ /* synthetic */ Object invoke() throws IOException {
            m744invoke();
            return Unit.INSTANCE;
        }

        /* JADX INFO: renamed from: invoke, reason: collision with other method in class */
        public final void m744invoke() throws IOException {
            if (this.$index >= ArraysKt.getLastIndex(SunRunStartAnimView.NUMBERS)) {
                this.this$0.finishOverlay();
                return;
            }
            ViewPropertyAnimator interpolator = this.this$0.binding.f12314a.animate().alpha(0.0f).scaleX(1.15f).scaleY(1.15f).setDuration(200L).setInterpolator(null);
            final SunRunStartAnimView sunRunStartAnimView = this.this$0;
            final int i = this.$index;
            interpolator.withEndAction(new Runnable() { // from class: com.huachenjie.run.widget.a
                @Override // java.lang.Runnable
                public final void run() throws IOException {
                    SunRunStartAnimView.AnonymousClass1.invoke$lambda$0(sunRunStartAnimView, i);
                }
            }).start();
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public SunRunStartAnimView(@NotNull Context context) {
        this(context, null, 0, 6, null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public SunRunStartAnimView(@NotNull Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0, 4, null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    public /* synthetic */ SunRunStartAnimView(Context context, AttributeSet attributeSet, int i, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i2 & 2) != 0 ? null : attributeSet, (i2 & 4) != 0 ? 0 : i);
    }

    private final void advanceAfterIndex(int index) {
        postAnim(index == ArraysKt.getLastIndex(NUMBERS) ? GO_HOLD_MS : 2000L, new AnonymousClass1(index, this));
    }

    private final void applyBrandPromotionUi() {
        BrandPromotionConfigBean brandPromotionConfigBeanResolveBrandPromotionConfig = resolveBrandPromotionConfig();
        this.brandMode = brandPromotionConfigBeanResolveBrandPromotionConfig != null;
        if (brandPromotionConfigBeanResolveBrandPromotionConfig != null) {
            this.binding.f12313a.setVisibility(8);
            this.binding.f12310a.setVisibility(0);
            Glide.with(this.binding.f12310a).load(brandPromotionConfigBeanResolveBrandPromotionConfig.getCountdownIconUrl()).into(this.binding.f12310a);
            this.binding.f12318b.setText(buildBrandRemindText(brandPromotionConfigBeanResolveBrandPromotionConfig.getBrandName()));
            updateWarmUpCardOverhang(true);
            return;
        }
        this.binding.f12310a.setVisibility(8);
        this.binding.f12310a.setImageDrawable(null);
        this.binding.f12313a.setVisibility(0);
        this.binding.f12318b.setText(R.string.run_prepareTips);
        this.binding.f12318b.setTextColor(REMIND_TEXT_COLOR);
        updateWarmUpCardOverhang(false);
    }

    private final CharSequence buildBrandRemindText(String brandName) {
        String string = getContext().getString(R.string.run_sun_start_anim_brand_remind);
        Intrinsics.checkNotNullExpressionValue(string, "context.getString(R.stri…_start_anim_brand_remind)");
        String str = brandName + ' ' + string;
        SpannableString spannableString = new SpannableString(str);
        spannableString.setSpan(new ForegroundColorSpan(-28392), 0, brandName.length(), 33);
        spannableString.setSpan(new ForegroundColorSpan(REMIND_TEXT_COLOR), brandName.length(), str.length(), 33);
        return spannableString;
    }

    private final void cancelInternal() throws IOException {
        this.cancelled = true;
        this.onComplete = null;
        this.handler.removeCallbacksAndMessages(null);
        this.binding.f12314a.animate().cancel();
        releaseHeavyResources();
        try {
            Result.Companion companion = Result.Companion;
            nl8.e(getContext()).v(true);
            Result.constructor-impl(Unit.INSTANCE);
        } catch (Throwable th) {
            Result.Companion companion2 = Result.Companion;
            Result.constructor-impl(ResultKt.createFailure(th));
        }
    }

    private final int dp(int value) {
        return (int) TypedValue.applyDimension(1, value, getResources().getDisplayMetrics());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void finishOverlay() throws IOException {
        Function0<Unit> function0 = this.onComplete;
        cancelInternal();
        if (function0 != null) {
            function0.invoke();
        }
    }

    private final void playSound(int... rawIds) {
        try {
            Result.Companion companion = Result.Companion;
            nl8.e(getContext()).q(Arrays.copyOf(rawIds, rawIds.length));
            Result.constructor-impl(Unit.INSTANCE);
        } catch (Throwable th) {
            Result.Companion companion2 = Result.Companion;
            Result.constructor-impl(ResultKt.createFailure(th));
        }
    }

    private final void postAnim(long delayMs, final Function0<Unit> action) {
        this.handler.postDelayed(new Runnable() { // from class: com.zj.adlib.mv8
            @Override // java.lang.Runnable
            public final void run() {
                SunRunStartAnimView.postAnim$lambda$6(this.f43396a, action);
            }
        }, delayMs);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void postAnim$lambda$6(SunRunStartAnimView sunRunStartAnimView, Function0 function0) {
        Intrinsics.checkNotNullParameter(sunRunStartAnimView, "this$0");
        Intrinsics.checkNotNullParameter(function0, "$action");
        if (sunRunStartAnimView.cancelled) {
            return;
        }
        function0.invoke();
    }

    private final void releaseHeavyResources() throws IOException {
        this.binding.f12312a.cancelAnimation();
        this.binding.f12312a.setImageDrawable(null);
        this.binding.f12313a.setImageResource(0);
        Glide.with(this.binding.f12310a).clear(this.binding.f12310a);
        this.binding.f12310a.setImageDrawable(null);
    }

    private final void resetWarmUpActionLayout(boolean ready) {
        ViewGroup.LayoutParams layoutParams = this.binding.c.getLayoutParams();
        Intrinsics.checkNotNull(layoutParams, "null cannot be cast to non-null type android.widget.FrameLayout.LayoutParams");
        FrameLayout.LayoutParams layoutParams2 = (FrameLayout.LayoutParams) layoutParams;
        layoutParams2.topMargin = dp(ready ? 23 : 36);
        layoutParams2.height = dp(ready ? 39 : 34);
        this.binding.c.setLayoutParams(layoutParams2);
    }

    private final BrandPromotionConfigBean resolveBrandPromotionConfig() {
        BrandPromotionConfigBean brandPromotionConfigBeanC = ai9.c();
        if (brandPromotionConfigBeanC == null || StringsKt.isBlank(brandPromotionConfigBeanC.getBrandName()) || StringsKt.isBlank(brandPromotionConfigBeanC.getCountdownIconUrl())) {
            return null;
        }
        return brandPromotionConfigBeanC;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void showCountdownAtIndex(final int index) throws IOException {
        String string;
        String[] strArr = NUMBERS;
        boolean z = index == ArraysKt.getLastIndex(strArr);
        float f = z ? 220.0f : 320.0f;
        ViewGroup.LayoutParams layoutParams = this.binding.f12314a.getLayoutParams();
        Intrinsics.checkNotNull(layoutParams, "null cannot be cast to non-null type android.widget.FrameLayout.LayoutParams");
        FrameLayout.LayoutParams layoutParams2 = (FrameLayout.LayoutParams) layoutParams;
        layoutParams2.topMargin = dp(z ? 222 : 152);
        layoutParams2.width = -1;
        layoutParams2.height = -2;
        this.binding.f12314a.setLayoutParams(layoutParams2);
        this.binding.f12314a.setTextSize(2, f);
        this.binding.f12314a.setStroke(-1, dp(6));
        int iDp = dp(20);
        this.binding.f12314a.setPadding(iDp, iDp, iDp, iDp);
        this.binding.f12314a.setText(strArr[index]);
        if (!this.brandMode) {
            int[] iArr = CHARACTER_RES;
            if (index < iArr.length) {
                this.binding.f12313a.setImageResource(iArr[index]);
            }
        }
        this.binding.f12318b.setVisibility(index < 2 ? 0 : 4);
        this.binding.c.setVisibility(0);
        TextView textView = this.binding.c;
        if (index != 0) {
            string = index != 1 ? getContext().getString(R.string.run_sun_start_anim_ready) : getContext().getString(R.string.run_prepareTips2);
        } else {
            string = getContext().getString(R.string.run_prepareTips3);
        }
        textView.setText(string);
        this.binding.c.setTextSize(2, index >= 2 ? 28.0f : 24.0f);
        resetWarmUpActionLayout(index >= 2);
        if (index == 0) {
            playSound(R.raw.run_run_count_down_interval, R.raw.run_run_count_down_num_3);
        } else if (index == 1) {
            playSound(R.raw.run_run_count_down_interval, R.raw.run_run_count_down_num_2);
        } else if (index != 2) {
            playSound(R.raw.run_run_count_down_go);
        } else {
            playSound(R.raw.run_run_count_down_interval, R.raw.run_run_count_down_ready);
        }
        this.binding.f12314a.animate().cancel();
        this.binding.f12314a.setScaleX(0.45f);
        this.binding.f12314a.setScaleY(0.45f);
        this.binding.f12314a.setAlpha(0.0f);
        this.binding.f12314a.animate().scaleX(1.0f).scaleY(1.0f).alpha(1.0f).setDuration(280L).setInterpolator(new OvershootInterpolator(1.8f)).withEndAction(new Runnable() { // from class: com.zj.adlib.lv8
            @Override // java.lang.Runnable
            public final void run() {
                SunRunStartAnimView.showCountdownAtIndex$lambda$4(this.f43168a, index);
            }
        }).start();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void showCountdownAtIndex$lambda$4(SunRunStartAnimView sunRunStartAnimView, int i) {
        Intrinsics.checkNotNullParameter(sunRunStartAnimView, "this$0");
        if (sunRunStartAnimView.cancelled) {
            return;
        }
        sunRunStartAnimView.advanceAfterIndex(i);
    }

    private final void updateWarmUpCardOverhang(boolean brand) {
        int i = brand ? 37 : 3;
        ViewGroup.LayoutParams layoutParams = this.binding.f12319b.getLayoutParams();
        Intrinsics.checkNotNull(layoutParams, "null cannot be cast to non-null type android.widget.FrameLayout.LayoutParams");
        FrameLayout.LayoutParams layoutParams2 = (FrameLayout.LayoutParams) layoutParams;
        layoutParams2.setMarginStart(dp(i));
        this.binding.f12319b.setLayoutParams(layoutParams2);
        ViewGroup.LayoutParams layoutParams3 = this.binding.f12313a.getLayoutParams();
        Intrinsics.checkNotNull(layoutParams3, "null cannot be cast to non-null type android.widget.FrameLayout.LayoutParams");
        FrameLayout.LayoutParams layoutParams4 = (FrameLayout.LayoutParams) layoutParams3;
        layoutParams4.setMarginStart(0);
        this.binding.f12313a.setLayoutParams(layoutParams4);
        this.binding.b.setMinimumWidth(dp(i + 224));
    }

    public final void cancel() throws IOException {
        if (this.cancelled) {
            return;
        }
        cancelInternal();
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() throws IOException {
        if (!this.cancelled) {
            cancelInternal();
        }
        super.onDetachedFromWindow();
    }

    public final void start(@NotNull Function0<Unit> onComplete) throws IOException {
        Intrinsics.checkNotNullParameter(onComplete, "onComplete");
        cancelInternal();
        this.cancelled = false;
        this.onComplete = onComplete;
        setVisibility(0);
        this.binding.f12314a.animate().cancel();
        this.binding.f12314a.setAlpha(1.0f);
        this.binding.f12314a.setScaleX(1.0f);
        this.binding.f12314a.setScaleY(1.0f);
        resetWarmUpActionLayout(false);
        applyBrandPromotionUi();
        LottieAnimationView lottieAnimationView = this.binding.f12312a;
        lottieAnimationView.setVisibility(0);
        lottieAnimationView.setAnimation(LOTTIE_FILE);
        lottieAnimationView.setRepeatCount(-1);
        lottieAnimationView.playAnimation();
        playSound(R.raw.run_run_count_down_interval, R.raw.run_run_count_down_pre_4);
        postAnim(INTRO_TO_COUNTDOWN_MS, new Function0<Unit>() { // from class: com.huachenjie.run.widget.SunRunStartAnimView.start.2
            {
                super(0);
            }

            public /* bridge */ /* synthetic */ Object invoke() throws IOException {
                m745invoke();
                return Unit.INSTANCE;
            }

            /* JADX INFO: renamed from: invoke, reason: collision with other method in class */
            public final void m745invoke() throws IOException {
                SunRunStartAnimView.this.binding.f12312a.setVisibility(8);
                SunRunStartAnimView.this.showCountdownAtIndex(0);
            }
        });
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public SunRunStartAnimView(@NotNull Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        Intrinsics.checkNotNullParameter(context, "context");
        RunViewSunRunStartAnimBinding runViewSunRunStartAnimBindingB = RunViewSunRunStartAnimBinding.b(LayoutInflater.from(context), this);
        Intrinsics.checkNotNullExpressionValue(runViewSunRunStartAnimBindingB, "inflate(LayoutInflater.from(context), this)");
        this.binding = runViewSunRunStartAnimBindingB;
        this.handler = new Handler(Looper.getMainLooper());
        this.cancelled = true;
        setBackgroundColor(-1);
        setClipChildren(false);
        setClipToPadding(false);
        setClickable(true);
        setFocusable(true);
        setSoundEffectsEnabled(false);
    }
}

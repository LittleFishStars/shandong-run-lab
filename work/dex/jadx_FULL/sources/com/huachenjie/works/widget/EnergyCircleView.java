package com.huachenjie.works.widget;

import android.animation.ValueAnimator;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import android.os.Handler;
import android.os.Looper;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.View;
import android.view.animation.LinearInterpolator;
import com.alibaba.ariver.kernel.RVParams;
import com.beizi.fusion.asnp.adn.ad.model.impl.resp.ad3.ad.nativ.render.layout.LayoutModel;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import com.huachenjie.run.page.run_index.adapter.RunIndexRecordAdapter;
import com.huachenjie.works.R;
import com.huachenjie.works.bean.dorm.DormEnergyBean;
import com.huachenjie.works.page.broadcast_floor.dialog.BroadcastFloorDetailDialog;
import com.huachenjie.works.widget.EnergyCircleView;
import com.kuaishou.weapon.p0.t;
import com.zj.adlib.y6b;
import java.util.Arrays;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.StringCompanionObject;
import kotlin.text.StringsKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
@Metadata(d1 = {"\u0000u\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0007\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006*\u0001'\u0018\u00002\u00020\u0001:\u0001WB'\b\u0007\u0012\u0006\u0010Q\u001a\u00020P\u0012\n\b\u0002\u0010S\u001a\u0004\u0018\u00010R\u0012\b\b\u0002\u0010T\u001a\u00020\u001c¢\u0006\u0004\bU\u0010VJ\u0010\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u0010\u0010\u0006\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0002H\u0002J\b\u0010\b\u001a\u00020\u0007H\u0002J\b\u0010\t\u001a\u00020\u0007H\u0002J\b\u0010\n\u001a\u00020\u0007H\u0002J\u0010\u0010\r\u001a\u00020\u00072\u0006\u0010\f\u001a\u00020\u000bH\u0002J\u0018\u0010\u0010\u001a\u00020\u00072\u0006\u0010\f\u001a\u00020\u000b2\u0006\u0010\u000f\u001a\u00020\u000eH\u0002J \u0010\u0012\u001a\u00020\u00072\u0006\u0010\f\u001a\u00020\u000b2\u0006\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u0011\u001a\u00020\u0002H\u0002J\u0018\u0010\u0014\u001a\u00020\u00072\u0006\u0010\f\u001a\u00020\u000b2\u0006\u0010\u0013\u001a\u00020\u0002H\u0002J(\u0010\u0016\u001a\u00020\u00072\u0006\u0010\f\u001a\u00020\u000b2\u0006\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u0013\u001a\u00020\u00022\u0006\u0010\u0015\u001a\u00020\u0002H\u0002J\u0010\u0010\u0017\u001a\u00020\u00072\b\u0010\u000f\u001a\u0004\u0018\u00010\u000eJ\u0010\u0010\u001a\u001a\u00020\u00072\b\u0010\u0019\u001a\u0004\u0018\u00010\u0018J\u0010\u0010\u001b\u001a\u00020\u00072\u0006\u0010\f\u001a\u00020\u000bH\u0014J\u0018\u0010\u001f\u001a\u00020\u00072\u0006\u0010\u001d\u001a\u00020\u001c2\u0006\u0010\u001e\u001a\u00020\u001cH\u0014J\b\u0010 \u001a\u00020\u0007H\u0014R\u0018\u0010#\u001a\u0004\u0018\u00010\u000e8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b!\u0010\"R\u0014\u0010&\u001a\u00020$8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b!\u0010%R\u0014\u0010)\u001a\u00020'8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b!\u0010(R\u0018\u0010+\u001a\u0004\u0018\u00010\u00188\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b!\u0010*R\u0016\u0010.\u001a\u00020\u001c8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b,\u0010-R\u0016\u00100\u001a\u00020\u00028\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b!\u0010/R\u0016\u00101\u001a\u00020\u00028\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0004\u0010/R\u0016\u00102\u001a\u00020\u00028\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0016\u0010/R\u0018\u00105\u001a\u0004\u0018\u0001038\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b!\u00104R\u001b\u0010:\u001a\u0002068BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b!\u00107\u001a\u0004\b8\u00109R\u001b\u0010<\u001a\u0002068BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0004\u00107\u001a\u0004\b;\u00109R\u0014\u0010?\u001a\u00020=8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b!\u0010>R\u001b\u0010B\u001a\u00020=8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0016\u00107\u001a\u0004\b@\u0010AR\u001b\u0010D\u001a\u00020=8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\r\u00107\u001a\u0004\bC\u0010AR\u001b\u0010F\u001a\u00020=8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0010\u00107\u001a\u0004\bE\u0010AR\u001b\u0010H\u001a\u00020=8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0014\u00107\u001a\u0004\bG\u0010AR\u0014\u0010I\u001a\u00020=8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0004\u0010>R\u001b\u0010K\u001a\u00020=8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0012\u00107\u001a\u0004\bJ\u0010AR\u0014\u0010N\u001a\u00020L8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b!\u0010MR\u0014\u0010O\u001a\u00020L8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0004\u0010M¨\u0006X"}, d2 = {"Lcom/huachenjie/works/widget/EnergyCircleView;", "Landroid/view/View;", "", t.q, "b", RVParams.SHOW_PROGRESS, y6b.g, "", "i", "j", "k", "Landroid/graphics/Canvas;", com.alibaba.triver.triver_render.view.canvas.tinyapp.b.f25229a, "d", "Lcom/huachenjie/works/bean/dorm/DormEnergyBean;", BroadcastFloorDetailDialog.DETAIL_BEAN_KEY, "e", "bottomMargin", y6b.f, LayoutModel.MODEL_KEY_CENTER_X, "f", LayoutModel.MODEL_KEY_CENTER_Y, "c", "setEnergyData", "Lcom/huachenjie/works/widget/EnergyCircleView$OnCountdownListener;", ServiceSpecificExtraArgs.CastExtraArgs.f31291a, "setOnCountdownListener", "onDraw", "", "widthMeasureSpec", "heightMeasureSpec", "onMeasure", "onDetachedFromWindow", "a", "Lcom/huachenjie/works/bean/dorm/DormEnergyBean;", "energyBean", "Landroid/os/Handler;", "Landroid/os/Handler;", "countdownHandler", "com/huachenjie/works/widget/EnergyCircleView$a", "Lcom/huachenjie/works/widget/EnergyCircleView$a;", "countdownRunnable", "Lcom/huachenjie/works/widget/EnergyCircleView$OnCountdownListener;", "countdownListener", "K", "I", "totalCountdownSeconds", "F", "currentCountdownSeconds", "currentAnimatedAngle", "targetAngle", "Landroid/animation/ValueAnimator;", "Landroid/animation/ValueAnimator;", "angleAnimator", "Landroid/graphics/Bitmap;", "Lkotlin/Lazy;", "getEmptyEnergyBitmap", "()Landroid/graphics/Bitmap;", "emptyEnergyBitmap", "getEnergyProgressBitmap", "energyProgressBitmap", "Landroid/graphics/Paint;", "Landroid/graphics/Paint;", "bitmapPaint", "getProgressPaint", "()Landroid/graphics/Paint;", "progressPaint", "getEnergyValuePaint", "energyValuePaint", "getEnergyPrefixPaint", "energyPrefixPaint", "getCountdownTextPaint", "countdownTextPaint", "countdownBgPaint", "getCountdownBorderPaint", "countdownBorderPaint", "Landroid/graphics/RectF;", "Landroid/graphics/RectF;", "rectF", "countdownRectF", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", "attrs", "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "OnCountdownListener", "works_release"}, k = 1, mv = {1, 8, 0})
public final class EnergyCircleView extends View {

    /* JADX INFO: renamed from: K, reason: from kotlin metadata */
    public int totalCountdownSeconds;

    /* JADX INFO: renamed from: a, reason: collision with root package name and from kotlin metadata */
    public float currentCountdownSeconds;

    /* JADX INFO: renamed from: a, reason: collision with other field name and from kotlin metadata */
    @Nullable
    public ValueAnimator angleAnimator;

    /* JADX INFO: renamed from: a, reason: collision with other field name and from kotlin metadata */
    @NotNull
    public final Paint bitmapPaint;

    /* JADX INFO: renamed from: a, reason: collision with other field name and from kotlin metadata */
    @NotNull
    public final RectF rectF;

    /* JADX INFO: renamed from: a, reason: collision with other field name and from kotlin metadata */
    @NotNull
    public final Handler countdownHandler;

    /* JADX INFO: renamed from: a, reason: collision with other field name and from kotlin metadata */
    @Nullable
    public DormEnergyBean energyBean;

    /* JADX INFO: renamed from: a, reason: collision with other field name and from kotlin metadata */
    @Nullable
    public OnCountdownListener countdownListener;

    /* JADX INFO: renamed from: a, reason: collision with other field name and from kotlin metadata */
    @NotNull
    public final a countdownRunnable;

    /* JADX INFO: renamed from: a, reason: collision with other field name and from kotlin metadata */
    @NotNull
    public final Lazy emptyEnergyBitmap;

    /* JADX INFO: renamed from: b, reason: from kotlin metadata */
    public float currentAnimatedAngle;

    /* JADX INFO: renamed from: b, reason: collision with other field name and from kotlin metadata */
    @NotNull
    public final Paint countdownBgPaint;

    /* JADX INFO: renamed from: b, reason: collision with other field name and from kotlin metadata */
    @NotNull
    public final RectF countdownRectF;

    /* JADX INFO: renamed from: b, reason: collision with other field name and from kotlin metadata */
    @NotNull
    public final Lazy energyProgressBitmap;

    /* JADX INFO: renamed from: c, reason: from kotlin metadata */
    public float targetAngle;

    /* JADX INFO: renamed from: c, reason: collision with other field name and from kotlin metadata */
    @NotNull
    public final Lazy progressPaint;

    /* JADX INFO: renamed from: d, reason: from kotlin metadata */
    @NotNull
    public final Lazy energyValuePaint;

    /* JADX INFO: renamed from: e, reason: from kotlin metadata */
    @NotNull
    public final Lazy energyPrefixPaint;

    /* JADX INFO: renamed from: f, reason: from kotlin metadata */
    @NotNull
    public final Lazy countdownTextPaint;

    /* JADX INFO: renamed from: g, reason: from kotlin metadata */
    @NotNull
    public final Lazy countdownBorderPaint;

    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H&¨\u0006\u0004"}, d2 = {"Lcom/huachenjie/works/widget/EnergyCircleView$OnCountdownListener;", "", "onCountdownFinished", "", "works_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public interface OnCountdownListener {
        void onCountdownFinished();
    }

    @Metadata(d1 = {"\u0000\u0011\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0003\u001a\u00020\u0002H\u0016¨\u0006\u0004"}, d2 = {"com/huachenjie/works/widget/EnergyCircleView$a", "Ljava/lang/Runnable;", "", "run", "works_release"}, k = 1, mv = {1, 8, 0})
    public static final class a implements Runnable {
        public a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            DormEnergyBean dormEnergyBean = EnergyCircleView.this.energyBean;
            if (dormEnergyBean != null) {
                EnergyCircleView energyCircleView = EnergyCircleView.this;
                if (!dormEnergyBean.getDigesting() || energyCircleView.currentCountdownSeconds <= 0.0f) {
                    energyCircleView.j();
                    OnCountdownListener onCountdownListener = energyCircleView.countdownListener;
                    if (onCountdownListener != null) {
                        onCountdownListener.onCountdownFinished();
                        return;
                    }
                    return;
                }
                energyCircleView.currentCountdownSeconds -= 0.1f;
                if (energyCircleView.currentCountdownSeconds < 0.0f) {
                    energyCircleView.currentCountdownSeconds = 0.0f;
                }
                dormEnergyBean.setCountdownSeconds((int) Math.ceil(energyCircleView.currentCountdownSeconds));
                energyCircleView.k();
                energyCircleView.countdownHandler.postDelayed(this, 100L);
            }
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public EnergyCircleView(@NotNull Context context) {
        this(context, null, 0, 6, null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public EnergyCircleView(@NotNull Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0, 4, null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    public /* synthetic */ EnergyCircleView(Context context, AttributeSet attributeSet, int i, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i2 & 2) != 0 ? null : attributeSet, (i2 & 4) != 0 ? 0 : i);
    }

    private final Paint getCountdownBorderPaint() {
        return (Paint) this.countdownBorderPaint.getValue();
    }

    private final Paint getCountdownTextPaint() {
        return (Paint) this.countdownTextPaint.getValue();
    }

    private final Bitmap getEmptyEnergyBitmap() {
        Object value = this.emptyEnergyBitmap.getValue();
        Intrinsics.checkNotNullExpressionValue(value, "<get-emptyEnergyBitmap>(...)");
        return (Bitmap) value;
    }

    private final Paint getEnergyPrefixPaint() {
        return (Paint) this.energyPrefixPaint.getValue();
    }

    private final Bitmap getEnergyProgressBitmap() {
        Object value = this.energyProgressBitmap.getValue();
        Intrinsics.checkNotNullExpressionValue(value, "<get-energyProgressBitmap>(...)");
        return (Bitmap) value;
    }

    private final Paint getEnergyValuePaint() {
        return (Paint) this.energyValuePaint.getValue();
    }

    private final Paint getProgressPaint() {
        return (Paint) this.progressPaint.getValue();
    }

    public static final void l(EnergyCircleView energyCircleView, ValueAnimator valueAnimator) {
        Intrinsics.checkNotNullParameter(energyCircleView, "this$0");
        Intrinsics.checkNotNullParameter(valueAnimator, com.ipd.dsp.internal.l.a.l);
        Object animatedValue = valueAnimator.getAnimatedValue();
        Intrinsics.checkNotNull(animatedValue, "null cannot be cast to non-null type kotlin.Float");
        energyCircleView.currentAnimatedAngle = ((Float) animatedValue).floatValue();
        energyCircleView.invalidate();
    }

    public final float b(float dp) {
        return TypedValue.applyDimension(1, dp, getResources().getDisplayMetrics());
    }

    public final void c(Canvas canvas, DormEnergyBean bean, float centerX, float centerY) {
        String string;
        if (bean.getCountdownSeconds() < 60) {
            string = getContext().getString(R.string.works_energy_countdown_seconds, Integer.valueOf(bean.getCountdownSeconds()));
        } else {
            int countdownSeconds = bean.getCountdownSeconds() / 3600;
            int countdownSeconds2 = (bean.getCountdownSeconds() % 3600) / 60;
            StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
            string = String.format("%02d:%02d", Arrays.copyOf(new Object[]{Integer.valueOf(countdownSeconds), Integer.valueOf(countdownSeconds2)}, 2));
            Intrinsics.checkNotNullExpressionValue(string, "format(format, *args)");
        }
        Intrinsics.checkNotNullExpressionValue(string, "if (bean.countdownSecond…hours, minutes)\n        }");
        float fB = b(38.0f);
        float fB2 = b(13.0f);
        float fB3 = b(6.5f);
        float fB4 = b(12.0f);
        float f = fB / 2.0f;
        float height = (getHeight() - fB4) - fB2;
        this.countdownRectF.set(centerX - f, height, f + centerX, getHeight() - fB4);
        canvas.drawRoundRect(this.countdownRectF, fB3, fB3, this.countdownBgPaint);
        canvas.drawRoundRect(this.countdownRectF, fB3, fB3, getCountdownBorderPaint());
        Paint.FontMetrics fontMetrics = getCountdownTextPaint().getFontMetrics();
        canvas.drawText(string, centerX, (height + (fB2 / 2.0f)) - ((fontMetrics.descent + fontMetrics.ascent) / 2.0f), getCountdownTextPaint());
    }

    public final void d(Canvas canvas) {
        canvas.drawBitmap(getEmptyEnergyBitmap(), (getWidth() / 2.0f) - (getEmptyEnergyBitmap().getWidth() / 2.0f), (getHeight() / 2.0f) - (getEmptyEnergyBitmap().getHeight() / 2.0f), this.bitmapPaint);
    }

    public final void e(Canvas canvas, DormEnergyBean bean) {
        float width = getWidth() / 2.0f;
        float height = getHeight() / 2.0f;
        float fMin = ((Math.min(getWidth(), getHeight()) / 2.0f) - (getProgressPaint().getStrokeWidth() / 2.0f)) - b(3.0f);
        this.rectF.set(width - fMin, height - fMin, width + fMin, fMin + height);
        f(canvas, width);
        if (bean.getDigesting() && this.totalCountdownSeconds >= 0) {
            canvas.drawArc(this.rectF, -90.0f, this.currentAnimatedAngle, false, getProgressPaint());
        }
        if (!bean.getDigesting() || bean.getCountdownSeconds() < 0) {
            return;
        }
        c(canvas, bean, width, height);
    }

    public final void f(Canvas canvas, float centerX) {
        canvas.drawBitmap(getEnergyProgressBitmap(), (getWidth() / 2.0f) - (getEmptyEnergyBitmap().getWidth() / 2.0f), (getHeight() / 2.0f) - (getEmptyEnergyBitmap().getHeight() / 2.0f), this.bitmapPaint);
    }

    public final void g(Canvas canvas, DormEnergyBean bean, float bottomMargin) {
        String string = getContext().getString(R.string.works_energy_prefix);
        Intrinsics.checkNotNullExpressionValue(string, "context.getString(R.string.works_energy_prefix)");
        String strValueOf = String.valueOf(bean.getEnergyValue());
        float fMeasureText = getEnergyPrefixPaint().measureText(string);
        float fMeasureText2 = getEnergyValuePaint().measureText(strValueOf);
        float fB = b(2.0f) + fMeasureText + fMeasureText2;
        float height = getHeight() - bottomMargin;
        float width = getWidth() / 2.0f;
        float f = fB / 2.0f;
        canvas.drawText(string, (width - f) + (fMeasureText / 2.0f), height - b(2.0f), getEnergyPrefixPaint());
        canvas.drawText(strValueOf, (width + f) - (fMeasureText2 / 2.0f), height, getEnergyValuePaint());
    }

    public final float h(float sp) {
        return TypedValue.applyDimension(2, sp, getResources().getDisplayMetrics());
    }

    public final void i() {
        this.countdownHandler.removeCallbacks(this.countdownRunnable);
        this.countdownHandler.postDelayed(this.countdownRunnable, 100L);
    }

    public final void j() {
        this.countdownHandler.removeCallbacks(this.countdownRunnable);
        ValueAnimator valueAnimator = this.angleAnimator;
        if (valueAnimator != null) {
            valueAnimator.cancel();
        }
    }

    public final void k() {
        int i;
        if (this.energyBean == null || (i = this.totalCountdownSeconds) <= 0) {
            return;
        }
        this.targetAngle = (this.currentCountdownSeconds / i) * 360.0f;
        ValueAnimator valueAnimator = this.angleAnimator;
        if (valueAnimator != null) {
            valueAnimator.cancel();
        }
        ValueAnimator valueAnimatorOfFloat = ValueAnimator.ofFloat(this.currentAnimatedAngle, this.targetAngle);
        valueAnimatorOfFloat.setDuration(100L);
        valueAnimatorOfFloat.setInterpolator(new LinearInterpolator());
        valueAnimatorOfFloat.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.zj.adlib.e43
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public final void onAnimationUpdate(ValueAnimator valueAnimator2) {
                EnergyCircleView.l(this.f41341a, valueAnimator2);
            }
        });
        valueAnimatorOfFloat.start();
        this.angleAnimator = valueAnimatorOfFloat;
    }

    @Override // android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        j();
        ValueAnimator valueAnimator = this.angleAnimator;
        if (valueAnimator != null) {
            valueAnimator.cancel();
        }
    }

    @Override // android.view.View
    public void onDraw(@NotNull Canvas canvas) {
        Intrinsics.checkNotNullParameter(canvas, com.alibaba.triver.triver_render.view.canvas.tinyapp.b.f25229a);
        super.onDraw(canvas);
        DormEnergyBean dormEnergyBean = this.energyBean;
        if (dormEnergyBean == null) {
            return;
        }
        if (dormEnergyBean.getShowSupplementBtn()) {
            d(canvas);
            g(canvas, dormEnergyBean, b(20.0f));
        } else {
            e(canvas, dormEnergyBean);
            g(canvas, dormEnergyBean, b(28.0f));
        }
    }

    @Override // android.view.View
    public void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        int iMin = Math.min(View.MeasureSpec.getSize(widthMeasureSpec), View.MeasureSpec.getSize(heightMeasureSpec));
        setMeasuredDimension(iMin, iMin);
    }

    public final void setEnergyData(@Nullable DormEnergyBean bean) {
        int countdownSeconds;
        j();
        this.energyBean = bean;
        if (!(bean != null && bean.getDigesting()) || bean.getCountdownSeconds() <= 0) {
            this.totalCountdownSeconds = 0;
            this.currentCountdownSeconds = 0.0f;
            this.currentAnimatedAngle = 0.0f;
            this.targetAngle = 0.0f;
            if ((bean != null && bean.getDigesting()) && bean.getCountdownSeconds() == 0) {
                i();
            }
        } else {
            try {
                Long longOrNull = StringsKt.toLongOrNull(bean.getDigestStartTime());
                long jLongValue = longOrNull != null ? longOrNull.longValue() : 0L;
                Long longOrNull2 = StringsKt.toLongOrNull(bean.getDigestEndTime());
                countdownSeconds = (int) (((longOrNull2 != null ? longOrNull2.longValue() : 0L) - jLongValue) / ((long) 1000));
            } catch (Exception unused) {
                countdownSeconds = bean.getCountdownSeconds();
            }
            if (countdownSeconds <= 0) {
                countdownSeconds = bean.getCountdownSeconds();
            }
            this.totalCountdownSeconds = countdownSeconds;
            float countdownSeconds2 = bean.getCountdownSeconds();
            this.currentCountdownSeconds = countdownSeconds2;
            float f = (countdownSeconds2 / this.totalCountdownSeconds) * 360.0f;
            this.currentAnimatedAngle = f;
            this.targetAngle = f;
            i();
        }
        invalidate();
    }

    public final void setOnCountdownListener(@Nullable OnCountdownListener listener) {
        this.countdownListener = listener;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public EnergyCircleView(@NotNull Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        Intrinsics.checkNotNullParameter(context, "context");
        this.countdownHandler = new Handler(Looper.getMainLooper());
        this.countdownRunnable = new a();
        this.emptyEnergyBitmap = LazyKt.lazy(new Function0<Bitmap>() { // from class: com.huachenjie.works.widget.EnergyCircleView$emptyEnergyBitmap$2
            {
                super(0);
            }

            /* JADX INFO: renamed from: invoke, reason: merged with bridge method [inline-methods] */
            public final Bitmap m981invoke() {
                return BitmapFactory.decodeResource(this.this$0.getResources(), R.drawable.works_ic_dorm_energy_empty);
            }
        });
        this.energyProgressBitmap = LazyKt.lazy(new Function0<Bitmap>() { // from class: com.huachenjie.works.widget.EnergyCircleView$energyProgressBitmap$2
            {
                super(0);
            }

            /* JADX INFO: renamed from: invoke, reason: merged with bridge method [inline-methods] */
            public final Bitmap m983invoke() {
                return BitmapFactory.decodeResource(this.this$0.getResources(), R.drawable.works_ic_dorm_energy_progress);
            }
        });
        this.bitmapPaint = new Paint(1);
        this.progressPaint = LazyKt.lazy(new Function0<Paint>() { // from class: com.huachenjie.works.widget.EnergyCircleView$progressPaint$2
            {
                super(0);
            }

            @NotNull
            /* JADX INFO: renamed from: invoke, reason: merged with bridge method [inline-methods] */
            public final Paint m985invoke() {
                Paint paint = new Paint(1);
                EnergyCircleView energyCircleView = this.this$0;
                paint.setStyle(Paint.Style.STROKE);
                paint.setStrokeWidth(energyCircleView.b(5.0f));
                paint.setStrokeCap(Paint.Cap.ROUND);
                paint.setColor(-14367860);
                return paint;
            }
        });
        this.energyValuePaint = LazyKt.lazy(new Function0<Paint>() { // from class: com.huachenjie.works.widget.EnergyCircleView$energyValuePaint$2
            {
                super(0);
            }

            @NotNull
            /* JADX INFO: renamed from: invoke, reason: merged with bridge method [inline-methods] */
            public final Paint m984invoke() {
                Paint paint = new Paint(1);
                EnergyCircleView energyCircleView = this.this$0;
                paint.setTextAlign(Paint.Align.CENTER);
                paint.setTextSize(energyCircleView.h(16.0f));
                paint.setColor(RunIndexRecordAdapter.K);
                return paint;
            }
        });
        this.energyPrefixPaint = LazyKt.lazy(new Function0<Paint>() { // from class: com.huachenjie.works.widget.EnergyCircleView$energyPrefixPaint$2
            {
                super(0);
            }

            @NotNull
            /* JADX INFO: renamed from: invoke, reason: merged with bridge method [inline-methods] */
            public final Paint m982invoke() {
                Paint paint = new Paint(1);
                EnergyCircleView energyCircleView = this.this$0;
                paint.setTextAlign(Paint.Align.CENTER);
                paint.setTextSize(energyCircleView.h(12.0f));
                paint.setColor(RunIndexRecordAdapter.K);
                return paint;
            }
        });
        this.countdownTextPaint = LazyKt.lazy(new Function0<Paint>() { // from class: com.huachenjie.works.widget.EnergyCircleView$countdownTextPaint$2
            {
                super(0);
            }

            @NotNull
            /* JADX INFO: renamed from: invoke, reason: merged with bridge method [inline-methods] */
            public final Paint m980invoke() {
                Paint paint = new Paint(1);
                EnergyCircleView energyCircleView = this.this$0;
                paint.setTextAlign(Paint.Align.CENTER);
                paint.setTextSize(energyCircleView.h(10.0f));
                paint.setColor(-15358375);
                return paint;
            }
        });
        Paint paint = new Paint(1);
        paint.setStyle(Paint.Style.FILL);
        paint.setColor(-1);
        this.countdownBgPaint = paint;
        this.countdownBorderPaint = LazyKt.lazy(new Function0<Paint>() { // from class: com.huachenjie.works.widget.EnergyCircleView$countdownBorderPaint$2
            {
                super(0);
            }

            @NotNull
            /* JADX INFO: renamed from: invoke, reason: merged with bridge method [inline-methods] */
            public final Paint m979invoke() {
                Paint paint2 = new Paint(1);
                EnergyCircleView energyCircleView = this.this$0;
                paint2.setStyle(Paint.Style.STROKE);
                paint2.setStrokeWidth(energyCircleView.b(1.0f));
                paint2.setColor(-9311867);
                return paint2;
            }
        });
        this.rectF = new RectF();
        this.countdownRectF = new RectF();
    }
}

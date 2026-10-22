package com.huachenjie.run.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.LinearGradient;
import android.graphics.Paint;
import android.graphics.RectF;
import android.graphics.Shader;
import android.util.AttributeSet;
import android.view.View;
import com.alibaba.triver.triver_render.view.canvas.tinyapp.b;
import com.huachenjie.run.R;
import com.zj.adlib.jj8;
import com.zj.adlib.y6b;
import kotlin.Metadata;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_01_2010cls.dex */
@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u0000 $2\u00020\u0001:\u0001$B%\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ\u0010\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\u001d\u001a\u00020\u001eH\u0014J(\u0010\u001f\u001a\u00020\u001c2\u0006\u0010 \u001a\u00020\u00072\u0006\u0010!\u001a\u00020\u00072\u0006\u0010\"\u001a\u00020\u00072\u0006\u0010#\u001a\u00020\u0007H\u0014R$\u0010\n\u001a\u00020\u00072\u0006\u0010\t\u001a\u00020\u0007@FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR$\u0010\u000f\u001a\u00020\u00072\u0006\u0010\t\u001a\u00020\u0007@FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\f\"\u0004\b\u0011\u0010\u000eR\u000e\u0010\u0012\u001a\u00020\u0013X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0015X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\u0013X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0017\u001a\u00020\u0018X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0019\u001a\u00020\u0013X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u001a\u001a\u00020\u0015X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006%"}, d2 = {"Lcom/huachenjie/run/widget/GoalProgressView;", "Landroid/view/View;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "value", "max", "getMax", "()I", "setMax", "(I)V", "progress", "getProgress", "setProgress", "progressPaint", "Landroid/graphics/Paint;", "progressRect", "Landroid/graphics/RectF;", "thumbPaint", "thumbRadius", "", "trackPaint", "trackRect", "onDraw", "", b.f25229a, "Landroid/graphics/Canvas;", "onSizeChanged", "w", y6b.g, "oldw", "oldh", "Companion", "run_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class GoalProgressView extends View {
    private static final float BAR_HEIGHT_DP = 8.0f;
    private static final int DEFAULT_MAX = 100;
    private static final float THUMB_SIZE_DP = 4.0f;
    private static final int TRACK_COLOR = -1;
    private int max;
    private int progress;

    @NotNull
    private final Paint progressPaint;

    @NotNull
    private final RectF progressRect;

    @NotNull
    private final Paint thumbPaint;
    private final float thumbRadius;

    @NotNull
    private final Paint trackPaint;

    @NotNull
    private final RectF trackRect;
    private static final int PROGRESS_START = Color.parseColor("#FF0BD3FF");
    private static final int PROGRESS_END = Color.parseColor("#FF0B95FF");

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public GoalProgressView(@NotNull Context context) {
        this(context, null, 0, 6, null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public GoalProgressView(@NotNull Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0, 4, null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    public /* synthetic */ GoalProgressView(Context context, AttributeSet attributeSet, int i, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i2 & 2) != 0 ? null : attributeSet, (i2 & 4) != 0 ? 0 : i);
    }

    public final int getMax() {
        return this.max;
    }

    public final int getProgress() {
        return this.progress;
    }

    @Override // android.view.View
    public void onDraw(@NotNull Canvas canvas) {
        Intrinsics.checkNotNullParameter(canvas, b.f25229a);
        float width = getWidth();
        float height = getHeight();
        if (width <= 0.0f || height <= 0.0f) {
            return;
        }
        float f = height / 2.0f;
        this.trackRect.set(0.0f, 0.0f, width, height);
        canvas.drawRoundRect(this.trackRect, f, f, this.trackPaint);
        int i = this.progress;
        if (i <= 0) {
            return;
        }
        float fCoerceAtMost = RangesKt.coerceAtMost(RangesKt.coerceAtLeast((i * width) / this.max, height), width);
        this.progressRect.set(0.0f, 0.0f, fCoerceAtMost, height);
        canvas.drawRoundRect(this.progressRect, f, f, this.progressPaint);
        canvas.drawCircle(RangesKt.coerceIn(fCoerceAtMost - f, f, width - f), f, this.thumbRadius, this.thumbPaint);
    }

    @Override // android.view.View
    public void onSizeChanged(int w, int h, int oldw, int oldh) {
        super.onSizeChanged(w, h, oldw, oldh);
        this.progressPaint.setShader(new LinearGradient(0.0f, 0.0f, w, 0.0f, PROGRESS_START, PROGRESS_END, Shader.TileMode.CLAMP));
    }

    public final void setMax(int i) {
        int iCoerceAtLeast = RangesKt.coerceAtLeast(i, 1);
        this.max = iCoerceAtLeast;
        setProgress(RangesKt.coerceIn(this.progress, 0, iCoerceAtLeast));
    }

    public final void setProgress(int i) {
        int iCoerceIn = RangesKt.coerceIn(i, 0, this.max);
        if (this.progress == iCoerceIn) {
            return;
        }
        this.progress = iCoerceIn;
        invalidate();
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public GoalProgressView(@NotNull Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        Intrinsics.checkNotNullParameter(context, "context");
        Paint paint = new Paint(1);
        paint.setColor(-1);
        paint.setStyle(Paint.Style.FILL);
        this.trackPaint = paint;
        Paint paint2 = new Paint(1);
        paint2.setStyle(Paint.Style.FILL);
        this.progressPaint = paint2;
        Paint paint3 = new Paint(1);
        paint3.setColor(-1);
        paint3.setStyle(Paint.Style.FILL);
        this.thumbPaint = paint3;
        this.trackRect = new RectF();
        this.progressRect = new RectF();
        this.thumbRadius = jj8.a(2.0f);
        this.max = 100;
        setMinimumHeight(jj8.a(8.0f));
        if (attributeSet != null) {
            TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.run_GoalProgressView);
            Intrinsics.checkNotNullExpressionValue(typedArrayObtainStyledAttributes, "context.obtainStyledAttr…ble.run_GoalProgressView)");
            setMax(typedArrayObtainStyledAttributes.getInt(R.styleable.run_GoalProgressView_android_max, 100));
            setProgress(typedArrayObtainStyledAttributes.getInt(R.styleable.run_GoalProgressView_android_progress, 0));
            typedArrayObtainStyledAttributes.recycle();
        }
    }
}

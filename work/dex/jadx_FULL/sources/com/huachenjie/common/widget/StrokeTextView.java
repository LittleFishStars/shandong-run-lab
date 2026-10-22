package com.huachenjie.common.widget;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Typeface;
import android.text.TextPaint;
import android.util.AttributeSet;
import androidx.appcompat.widget.AppCompatTextView;
import com.huachenjie.common.R;
import kotlin.Metadata;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_02_3758cls.dex */
@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B%\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ\b\u0010\f\u001a\u00020\rH\u0002J\u0010\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u0011H\u0014J\u0016\u0010\u0012\u001a\u00020\u000f2\u0006\u0010\t\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\u000bR\u000e\u0010\t\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u0013"}, d2 = {"Lcom/huachenjie/common/widget/StrokeTextView;", "Landroidx/appcompat/widget/AppCompatTextView;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "strokeColor", "strokeWidth", "", "isBold", "", "onDraw", "", com.alibaba.triver.triver_render.view.canvas.tinyapp.b.f25229a, "Landroid/graphics/Canvas;", "setStroke", "common_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
@SourceDebugExtension({"SMAP\nStrokeTextView.kt\nKotlin\n*S Kotlin\n*F\n+ 1 StrokeTextView.kt\ncom/huachenjie/common/widget/StrokeTextView\n+ 2 Context.kt\nandroidx/core/content/ContextKt\n*L\n1#1,80:1\n59#2,2:81\n*S KotlinDebug\n*F\n+ 1 StrokeTextView.kt\ncom/huachenjie/common/widget/StrokeTextView\n*L\n26#1:81,2\n*E\n"})
public final class StrokeTextView extends AppCompatTextView {
    private int strokeColor;
    private float strokeWidth;

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public StrokeTextView(@NotNull Context context) {
        this(context, null, 0, 6, null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public StrokeTextView(@NotNull Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0, 4, null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    public /* synthetic */ StrokeTextView(Context context, AttributeSet attributeSet, int i, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i2 & 2) != 0 ? null : attributeSet, (i2 & 4) != 0 ? 0 : i);
    }

    private final boolean isBold() {
        if (getPaint().isFakeBoldText()) {
            return true;
        }
        Typeface typeface = getTypeface();
        return ((typeface != null ? typeface.getStyle() : 0) & 1) != 0;
    }

    @Override // android.widget.TextView, android.view.View
    public void onDraw(@NotNull Canvas canvas) {
        Intrinsics.checkNotNullParameter(canvas, com.alibaba.triver.triver_render.view.canvas.tinyapp.b.f25229a);
        if (this.strokeWidth <= 0.0f) {
            super.onDraw(canvas);
            return;
        }
        TextPaint paint = getPaint();
        ColorStateList textColors = getTextColors();
        Paint.Style style = paint.getStyle();
        float strokeWidth = paint.getStrokeWidth();
        boolean zIsFakeBoldText = paint.isFakeBoldText();
        Paint.Join strokeJoin = paint.getStrokeJoin();
        boolean zIsBold = isBold();
        paint.setStrokeJoin(Paint.Join.ROUND);
        paint.setFakeBoldText(zIsBold);
        paint.setStyle(Paint.Style.STROKE);
        paint.setStrokeWidth(this.strokeWidth);
        setTextColor(this.strokeColor);
        super.onDraw(canvas);
        paint.setStyle(Paint.Style.FILL);
        paint.setStrokeWidth(0.0f);
        setTextColor(textColors);
        super.onDraw(canvas);
        paint.setStyle(style);
        paint.setStrokeWidth(strokeWidth);
        paint.setFakeBoldText(zIsFakeBoldText);
        paint.setStrokeJoin(strokeJoin);
    }

    public final void setStroke(int strokeColor, float strokeWidth) {
        this.strokeColor = strokeColor;
        this.strokeWidth = strokeWidth;
        invalidate();
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public StrokeTextView(@NotNull Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        Intrinsics.checkNotNullParameter(context, "context");
        this.strokeColor = -16777216;
        this.strokeWidth = 2.0f;
        int[] iArr = R.styleable.CommonStrokeTextView;
        Intrinsics.checkNotNullExpressionValue(iArr, "CommonStrokeTextView");
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, iArr, i, 0);
        Intrinsics.checkNotNullExpressionValue(typedArrayObtainStyledAttributes, "obtainStyledAttributes(s…efStyleAttr, defStyleRes)");
        this.strokeColor = typedArrayObtainStyledAttributes.getColor(R.styleable.CommonStrokeTextView_stv_strokeColor, this.strokeColor);
        this.strokeWidth = typedArrayObtainStyledAttributes.getDimension(R.styleable.CommonStrokeTextView_stv_strokeWidth, this.strokeWidth);
        typedArrayObtainStyledAttributes.recycle();
    }
}

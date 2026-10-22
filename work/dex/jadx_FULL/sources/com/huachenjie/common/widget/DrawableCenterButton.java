package com.huachenjie.common.widget;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import com.noober.background.view.BLTextView;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_02_3758cls.dex */
@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0005\u0018\u00002\u00020\u0001B#\b\u0016\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bB\u001b\b\u0016\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0002\u0010\tB\u0011\b\u0016\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\nJ\b\u0010\r\u001a\u00020\u000eH\u0002J\u0010\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u0010\u001a\u00020\u0011H\u0014J0\u0010\u0012\u001a\u00020\u000e2\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u00072\u0006\u0010\u0016\u001a\u00020\u00072\u0006\u0010\u0017\u001a\u00020\u00072\u0006\u0010\u0018\u001a\u00020\u0007H\u0014R\u000e\u0010\u000b\u001a\u00020\fX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u0019"}, d2 = {"Lcom/huachenjie/common/widget/DrawableCenterButton;", "Lcom/noober/background/view/BLTextView;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyle", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "(Landroid/content/Context;)V", "bodyWidth", "", "calBodyWidth", "", "onDraw", com.alibaba.triver.triver_render.view.canvas.tinyapp.b.f25229a, "Landroid/graphics/Canvas;", "onLayout", "changed", "", "left", com.ipd.dsp.internal.e1.f.l, "right", com.ipd.dsp.internal.e1.f.n, "common_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class DrawableCenterButton extends BLTextView {
    private float bodyWidth;

    public DrawableCenterButton(@Nullable Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final void calBodyWidth() {
        Drawable[] compoundDrawables = getCompoundDrawables();
        Intrinsics.checkNotNullExpressionValue(compoundDrawables, "getCompoundDrawables()");
        Drawable drawable = compoundDrawables[0];
        if (drawable != null) {
            this.bodyWidth = getPaint().measureText(getText().toString()) + drawable.getIntrinsicWidth() + getCompoundDrawablePadding();
            setPadding(0, getPaddingTop(), (int) (getWidth() - this.bodyWidth), getPaddingBottom());
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void onDraw(@NotNull Canvas canvas) {
        Intrinsics.checkNotNullParameter(canvas, com.alibaba.triver.triver_render.view.canvas.tinyapp.b.f25229a);
        if (this.bodyWidth > 0.0f) {
            canvas.translate((getWidth() - this.bodyWidth) / 2, 0.0f);
        }
        super/*android.view.View*/.onDraw(canvas);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void onLayout(boolean changed, int left, int top, int right, int bottom) {
        super/*androidx.appcompat.widget.AppCompatTextView*/.onLayout(changed, left, top, right, bottom);
        calBodyWidth();
    }

    public DrawableCenterButton(@Nullable Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public DrawableCenterButton(@Nullable Context context) {
        super(context);
    }
}

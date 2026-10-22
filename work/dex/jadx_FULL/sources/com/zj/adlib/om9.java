package com.zj.adlib;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.drawable.Drawable;
import android.text.style.ImageSpan;
import com.alibaba.triver.triver_render.view.canvas.tinyapp.b;
import com.bytedance.sdk.openadsdk.mediation.MediationConstant;
import com.ipd.dsp.internal.e1.f;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_03_8012cls.dex */
@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\r\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u0013\b\u0016\u0012\b\u0010\u0013\u001a\u0004\u0018\u00010\u0012¢\u0006\u0004\b\u0014\u0010\u0015B\u001b\b\u0016\u0012\b\u0010\u0013\u001a\u0004\u0018\u00010\u0012\u0012\u0006\u0010\u0016\u001a\u00020\u0006¢\u0006\u0004\b\u0014\u0010\u0017JR\u0010\u0011\u001a\u00020\u00102\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\u00062\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\u000b\u001a\u00020\u00062\u0006\u0010\f\u001a\u00020\u00062\u0006\u0010\r\u001a\u00020\u00062\u0006\u0010\u000f\u001a\u00020\u000eH\u0016¨\u0006\u0018"}, d2 = {"Lcom/zj/adlib/om9;", "Landroid/text/style/ImageSpan;", "Landroid/graphics/Canvas;", b.f25229a, "", "text", "", "start", "end", "", "x", f.l, "y", f.n, "Landroid/graphics/Paint;", "paint", "", MediationConstant.RIT_TYPE_DRAW, "Landroid/graphics/drawable/Drawable;", "d", "<init>", "(Landroid/graphics/drawable/Drawable;)V", "verticalAlignment", "(Landroid/graphics/drawable/Drawable;I)V", "base_release"}, k = 1, mv = {1, 8, 0})
public final class om9 extends ImageSpan {
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public om9(@Nullable Drawable drawable) {
        super(drawable);
        Intrinsics.checkNotNull(drawable);
    }

    @Override // android.text.style.DynamicDrawableSpan, android.text.style.ReplacementSpan
    public void draw(@NotNull Canvas canvas, @Nullable CharSequence text, int start, int end, float x, int top, int y, int bottom, @NotNull Paint paint) {
        Intrinsics.checkNotNullParameter(canvas, b.f25229a);
        Intrinsics.checkNotNullParameter(paint, "paint");
        Drawable drawable = getDrawable();
        Paint.FontMetrics fontMetrics = paint.getFontMetrics();
        float f = y;
        int i = (int) (((((fontMetrics.ascent + f) + f) + fontMetrics.descent) / 2) - ((drawable.getBounds().bottom + drawable.getBounds().top) / 2));
        canvas.save();
        canvas.translate(x, i);
        drawable.draw(canvas);
        canvas.restore();
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public om9(@Nullable Drawable drawable, int i) {
        super(drawable, i);
        Intrinsics.checkNotNull(drawable);
    }
}

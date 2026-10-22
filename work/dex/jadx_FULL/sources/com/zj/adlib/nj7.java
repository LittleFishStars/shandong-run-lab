package com.zj.adlib;

import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import com.alibaba.triver.triver_render.view.canvas.tinyapp.b;
import com.bytedance.sdk.openadsdk.mediation.MediationConstant;
import com.google.android.exoplayer2.source.rtsp.j;
import com.kuaishou.weapon.p0.t;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_03_8012cls.dex */
@Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0010\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0014\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u000f\u0018\u00002\u00020\u0001BC\u0012\b\b\u0002\u0010\u0019\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u001c\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u001f\u001a\u00020\u0002\u0012\b\b\u0002\u0010!\u001a\u00020\u0002\u0012\b\b\u0002\u0010\"\u001a\u00020\u0002\u0012\b\b\u0002\u0010$\u001a\u00020\u0002¢\u0006\u0004\b8\u00109J\u000e\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002J\u000e\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002J\u000e\u0010\u0007\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002J\u000e\u0010\b\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002J\u0010\u0010\u000b\u001a\u00020\u00042\u0006\u0010\n\u001a\u00020\tH\u0016J\u0010\u0010\r\u001a\u00020\u00042\u0006\u0010\f\u001a\u00020\u0002H\u0016J\u0012\u0010\u0010\u001a\u00020\u00042\b\u0010\u000f\u001a\u0004\u0018\u00010\u000eH\u0016J\b\u0010\u0011\u001a\u00020\u0002H\u0016J\u0018\u0010\u0015\u001a\u00020\u00142\u0006\u0010\u0012\u001a\u00020\u00022\u0006\u0010\u0013\u001a\u00020\u0002H\u0002R\u0017\u0010\u0019\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0015\u0010\u0016\u001a\u0004\b\u0017\u0010\u0018R\u0017\u0010\u001c\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u001a\u0010\u0016\u001a\u0004\b\u001b\u0010\u0018R\u0017\u0010\u001f\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u001d\u0010\u0016\u001a\u0004\b\u001e\u0010\u0018R\u0017\u0010!\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u001b\u0010\u0016\u001a\u0004\b \u0010\u0018R\u0017\u0010\"\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0017\u0010\u0016\u001a\u0004\b\u001a\u0010\u0018R\u0017\u0010$\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b#\u0010\u0016\u001a\u0004\b\u001d\u0010\u0018R\u0014\u0010'\u001a\u00020%8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0015\u0010&R\u0014\u0010*\u001a\u00020(8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0015\u0010)R\"\u00101\u001a\u00020+8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0015\u0010,\u001a\u0004\b-\u0010.\"\u0004\b/\u00100R\"\u00104\u001a\u00020+8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u001a\u0010,\u001a\u0004\b2\u0010.\"\u0004\b3\u00100R\"\u00107\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b2\u0010\u0016\u001a\u0004\b#\u0010\u0018\"\u0004\b5\u00106¨\u0006:"}, d2 = {"Lcom/zj/adlib/nj7;", "Landroid/graphics/drawable/Drawable;", "", "roundRadius", "", "p", "q", t.d, "k", "Landroid/graphics/Canvas;", b.f25229a, MediationConstant.RIT_TYPE_DRAW, "alpha", "setAlpha", "Landroid/graphics/ColorFilter;", "colorFilter", "setColorFilter", "getOpacity", "width", "height", "Landroid/graphics/Path;", "a", "I", "e", "()I", "radiusColor", "b", "d", "radius", "c", "i", "topLeftRadius", "j", "topRightRadius", "bottomLeftRadius", "f", "bottomRightRadius", "Landroid/graphics/Paint;", "Landroid/graphics/Paint;", "mPaint", "", "[F", "radii", "", "F", y6b.g, "()F", j.b, "(F)V", "strokeWidth", y6b.f, "n", "strokeRadius", "m", "(I)V", "strokeColor", "<init>", "(IIIIII)V", "base_release"}, k = 1, mv = {1, 8, 0})
public final class nj7 extends Drawable {

    /* JADX INFO: renamed from: a, reason: collision with root package name and from kotlin metadata */
    public float strokeWidth;

    /* JADX INFO: renamed from: a, reason: collision with other field name and from kotlin metadata */
    public final int radiusColor;

    /* JADX INFO: renamed from: a, reason: collision with other field name and from kotlin metadata */
    @NotNull
    public final Paint mPaint;

    /* JADX INFO: renamed from: a, reason: collision with other field name and from kotlin metadata */
    @NotNull
    public final float[] radii;

    /* JADX INFO: renamed from: b, reason: from kotlin metadata */
    public float strokeRadius;

    /* JADX INFO: renamed from: b, reason: collision with other field name and from kotlin metadata */
    public final int radius;

    /* JADX INFO: renamed from: c, reason: from kotlin metadata */
    public final int topLeftRadius;

    /* JADX INFO: renamed from: d, reason: from kotlin metadata */
    public final int topRightRadius;

    /* JADX INFO: renamed from: e, reason: from kotlin metadata */
    public final int bottomLeftRadius;

    /* JADX INFO: renamed from: f, reason: from kotlin metadata */
    public final int bottomRightRadius;

    /* JADX INFO: renamed from: g, reason: from kotlin metadata */
    public int strokeColor;

    public nj7() {
        this(0, 0, 0, 0, 0, 0, 63, null);
    }

    public /* synthetic */ nj7(int i, int i2, int i3, int i4, int i5, int i6, int i7, DefaultConstructorMarker defaultConstructorMarker) {
        this((i7 & 1) != 0 ? -16777216 : i, (i7 & 2) != 0 ? 0 : i2, (i7 & 4) != 0 ? 0 : i3, (i7 & 8) != 0 ? 0 : i4, (i7 & 16) != 0 ? 0 : i5, (i7 & 32) == 0 ? i6 : 0);
    }

    public final Path a(int width, int height) {
        Path path = new Path();
        float f = this.strokeWidth;
        path.addRoundRect(new RectF(f, f, width - f, height - f), this.radii, Path.Direction.CW);
        return path;
    }

    /* JADX INFO: renamed from: b, reason: from getter */
    public final int getBottomLeftRadius() {
        return this.bottomLeftRadius;
    }

    /* JADX INFO: renamed from: c, reason: from getter */
    public final int getBottomRightRadius() {
        return this.bottomRightRadius;
    }

    /* JADX INFO: renamed from: d, reason: from getter */
    public final int getRadius() {
        return this.radius;
    }

    @Override // android.graphics.drawable.Drawable
    public void draw(@NotNull Canvas canvas) {
        Intrinsics.checkNotNullParameter(canvas, b.f25229a);
        int iSaveLayer = canvas.saveLayer(0.0f, 0.0f, canvas.getWidth(), canvas.getHeight(), this.mPaint, 31);
        this.mPaint.setColor(this.radiusColor);
        canvas.drawRect(0.0f, 0.0f, canvas.getWidth(), canvas.getHeight(), this.mPaint);
        if (this.strokeWidth > 0.0f) {
            Paint paint = new Paint();
            paint.setColor(this.strokeColor);
            paint.setStrokeWidth(this.strokeWidth);
            paint.setStyle(Paint.Style.STROKE);
            float f = this.strokeWidth;
            float width = canvas.getWidth() - (this.strokeWidth / 2.0f);
            float height = canvas.getHeight() - (this.strokeWidth / 2.0f);
            float f2 = this.strokeRadius;
            canvas.drawRoundRect(f / 2.0f, f / 2.0f, width, height, f2, f2, paint);
        }
        this.mPaint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.CLEAR));
        canvas.drawPath(a(canvas.getWidth(), canvas.getHeight()), this.mPaint);
        this.mPaint.setXfermode(null);
        canvas.restoreToCount(iSaveLayer);
    }

    /* JADX INFO: renamed from: e, reason: from getter */
    public final int getRadiusColor() {
        return this.radiusColor;
    }

    /* JADX INFO: renamed from: f, reason: from getter */
    public final int getStrokeColor() {
        return this.strokeColor;
    }

    /* JADX INFO: renamed from: g, reason: from getter */
    public final float getStrokeRadius() {
        return this.strokeRadius;
    }

    @Override // android.graphics.drawable.Drawable
    public int getOpacity() {
        return -3;
    }

    /* JADX INFO: renamed from: h, reason: from getter */
    public final float getStrokeWidth() {
        return this.strokeWidth;
    }

    /* JADX INFO: renamed from: i, reason: from getter */
    public final int getTopLeftRadius() {
        return this.topLeftRadius;
    }

    /* JADX INFO: renamed from: j, reason: from getter */
    public final int getTopRightRadius() {
        return this.topRightRadius;
    }

    public final void k(int roundRadius) {
        float[] fArr = this.radii;
        float f = roundRadius;
        fArr[6] = f;
        fArr[7] = f;
    }

    public final void l(int roundRadius) {
        float[] fArr = this.radii;
        float f = roundRadius;
        fArr[4] = f;
        fArr[5] = f;
    }

    public final void m(int i) {
        this.strokeColor = i;
    }

    public final void n(float f) {
        this.strokeRadius = f;
    }

    public final void o(float f) {
        this.strokeWidth = f;
    }

    public final void p(int roundRadius) {
        float[] fArr = this.radii;
        float f = roundRadius;
        fArr[0] = f;
        fArr[1] = f;
    }

    public final void q(int roundRadius) {
        float[] fArr = this.radii;
        float f = roundRadius;
        fArr[2] = f;
        fArr[3] = f;
    }

    @Override // android.graphics.drawable.Drawable
    public void setAlpha(int alpha) {
        this.mPaint.setAlpha(alpha);
    }

    @Override // android.graphics.drawable.Drawable
    public void setColorFilter(@Nullable ColorFilter colorFilter) {
        this.mPaint.setColorFilter(colorFilter);
    }

    public nj7(int i, int i2, int i3, int i4, int i5, int i6) {
        this.radiusColor = i;
        this.radius = i2;
        this.topLeftRadius = i3;
        this.topRightRadius = i4;
        this.bottomLeftRadius = i5;
        this.bottomRightRadius = i6;
        Paint paint = new Paint();
        this.mPaint = paint;
        this.radii = new float[]{0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f};
        paint.setStyle(Paint.Style.FILL);
        paint.setAntiAlias(true);
        if (i2 > 0) {
            p(i2);
            q(i2);
            l(i2);
            k(i2);
            return;
        }
        p(i3);
        q(i4);
        l(i6);
        k(i5);
    }
}

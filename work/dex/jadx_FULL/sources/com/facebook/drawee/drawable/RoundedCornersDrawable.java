package com.facebook.drawee.drawable;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import com.facebook.common.internal.VisibleForTesting;
import com.zj.adlib.ax6;
import com.zj.adlib.cl3;
import java.util.Arrays;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_08_10593cls.dex */
public class RoundedCornersDrawable extends cl3 implements Rounded {
    public int K;
    public int L;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public float f29970a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @VisibleForTesting
    public final Paint f1610a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final Path f1611a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final RectF f1612a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @VisibleForTesting
    public Type f1613a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public boolean f1614a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final float[] f1615a;
    public float b;

    /* JADX INFO: renamed from: b, reason: collision with other field name */
    public final Path f1616b;

    /* JADX INFO: renamed from: b, reason: collision with other field name */
    @VisibleForTesting
    public final float[] f1617b;

    public enum Type {
        OVERLAY_COLOR,
        CLIPPING
    }

    public static /* synthetic */ class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f29971a;

        static {
            int[] iArr = new int[Type.values().length];
            f29971a = iArr;
            try {
                iArr[Type.CLIPPING.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f29971a[Type.OVERLAY_COLOR.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
        }
    }

    public RoundedCornersDrawable(Drawable drawable) {
        super((Drawable) ax6.i(drawable));
        this.f1613a = Type.OVERLAY_COLOR;
        this.f1615a = new float[8];
        this.f1617b = new float[8];
        this.f1610a = new Paint(1);
        this.f1614a = false;
        this.f29970a = 0.0f;
        this.K = 0;
        this.L = 0;
        this.b = 0.0f;
        this.f1611a = new Path();
        this.f1616b = new Path();
        this.f1612a = new RectF();
    }

    @Override // com.facebook.drawee.drawable.Rounded
    public int b() {
        return this.K;
    }

    @Override // com.facebook.drawee.drawable.Rounded
    public float c() {
        return this.f29970a;
    }

    @Override // com.facebook.drawee.drawable.Rounded
    public void d(float[] fArr) {
        if (fArr == null) {
            Arrays.fill(this.f1615a, 0.0f);
        } else {
            ax6.e(fArr.length == 8, "radii should have exactly 8 values");
            System.arraycopy(fArr, 0, this.f1615a, 0, 8);
        }
        u();
        invalidateSelf();
    }

    @Override // com.zj.adlib.cl3, android.graphics.drawable.Drawable
    public void draw(Canvas canvas) {
        Rect bounds = getBounds();
        int i = a.f29971a[this.f1613a.ordinal()];
        if (i == 1) {
            int iSave = canvas.save();
            this.f1611a.setFillType(Path.FillType.EVEN_ODD);
            canvas.clipPath(this.f1611a);
            super.draw(canvas);
            canvas.restoreToCount(iSave);
        } else if (i == 2) {
            super.draw(canvas);
            this.f1610a.setColor(this.L);
            this.f1610a.setStyle(Paint.Style.FILL);
            this.f1611a.setFillType(Path.FillType.INVERSE_EVEN_ODD);
            canvas.drawPath(this.f1611a, this.f1610a);
            if (this.f1614a) {
                float fWidth = ((bounds.width() - bounds.height()) + this.f29970a) / 2.0f;
                float fHeight = ((bounds.height() - bounds.width()) + this.f29970a) / 2.0f;
                if (fWidth > 0.0f) {
                    int i2 = bounds.left;
                    canvas.drawRect(i2, bounds.top, i2 + fWidth, bounds.bottom, this.f1610a);
                    int i3 = bounds.right;
                    canvas.drawRect(i3 - fWidth, bounds.top, i3, bounds.bottom, this.f1610a);
                }
                if (fHeight > 0.0f) {
                    float f = bounds.left;
                    int i4 = bounds.top;
                    canvas.drawRect(f, i4, bounds.right, i4 + fHeight, this.f1610a);
                    float f2 = bounds.left;
                    int i5 = bounds.bottom;
                    canvas.drawRect(f2, i5 - fHeight, bounds.right, i5, this.f1610a);
                }
            }
        }
        if (this.K != 0) {
            this.f1610a.setStyle(Paint.Style.STROKE);
            this.f1610a.setColor(this.K);
            this.f1610a.setStrokeWidth(this.f29970a);
            this.f1611a.setFillType(Path.FillType.EVEN_ODD);
            canvas.drawPath(this.f1616b, this.f1610a);
        }
    }

    @Override // com.facebook.drawee.drawable.Rounded
    public boolean e() {
        return this.f1614a;
    }

    @Override // com.facebook.drawee.drawable.Rounded
    public float f() {
        return this.b;
    }

    @Override // com.facebook.drawee.drawable.Rounded
    public void g(int i, float f) {
        this.K = i;
        this.f29970a = f;
        u();
        invalidateSelf();
    }

    @Override // com.facebook.drawee.drawable.Rounded
    public void k(boolean z) {
        this.f1614a = z;
        u();
        invalidateSelf();
    }

    @Override // com.facebook.drawee.drawable.Rounded
    public float[] m() {
        return this.f1615a;
    }

    @Override // com.facebook.drawee.drawable.Rounded
    public void n(float f) {
        this.b = f;
        u();
        invalidateSelf();
    }

    @Override // com.zj.adlib.cl3, android.graphics.drawable.Drawable
    public void onBoundsChange(Rect rect) {
        super.onBoundsChange(rect);
        u();
    }

    public int r() {
        return this.L;
    }

    public void s(int i) {
        this.L = i;
        invalidateSelf();
    }

    @Override // com.facebook.drawee.drawable.Rounded
    public void setRadius(float f) {
        Arrays.fill(this.f1615a, f);
        u();
        invalidateSelf();
    }

    public void t(Type type) {
        this.f1613a = type;
        invalidateSelf();
    }

    public final void u() {
        float[] fArr;
        this.f1611a.reset();
        this.f1616b.reset();
        this.f1612a.set(getBounds());
        RectF rectF = this.f1612a;
        float f = this.b;
        rectF.inset(f, f);
        if (this.f1614a) {
            this.f1611a.addCircle(this.f1612a.centerX(), this.f1612a.centerY(), Math.min(this.f1612a.width(), this.f1612a.height()) / 2.0f, Path.Direction.CW);
        } else {
            this.f1611a.addRoundRect(this.f1612a, this.f1615a, Path.Direction.CW);
        }
        RectF rectF2 = this.f1612a;
        float f2 = this.b;
        rectF2.inset(-f2, -f2);
        RectF rectF3 = this.f1612a;
        float f3 = this.f29970a;
        rectF3.inset(f3 / 2.0f, f3 / 2.0f);
        if (this.f1614a) {
            this.f1616b.addCircle(this.f1612a.centerX(), this.f1612a.centerY(), Math.min(this.f1612a.width(), this.f1612a.height()) / 2.0f, Path.Direction.CW);
        } else {
            int i = 0;
            while (true) {
                fArr = this.f1617b;
                if (i >= fArr.length) {
                    break;
                }
                fArr[i] = (this.f1615a[i] + this.b) - (this.f29970a / 2.0f);
                i++;
            }
            this.f1616b.addRoundRect(this.f1612a, fArr, Path.Direction.CW);
        }
        RectF rectF4 = this.f1612a;
        float f4 = this.f29970a;
        rectF4.inset((-f4) / 2.0f, (-f4) / 2.0f);
    }
}

package com.byazt.tm;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.drawable.GradientDrawable;
import com.bytedance.component.sdk.annotation.ColorInt;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_11_8719cls.dex */
@com.byazt.zqa.c(c = {0, 1, 48, 13})
public class tt extends GradientDrawable {
    public Path c;
    public final Paint tt;

    public tt() {
        this.c = new Path();
        Paint paint = new Paint(1);
        this.tt = paint;
        paint.setColor(-1);
    }

    public void c(Canvas canvas) {
        super.draw(canvas);
    }

    @Override // android.graphics.drawable.GradientDrawable, android.graphics.drawable.Drawable
    public void draw(Canvas canvas) {
        Path path = this.c;
        if (path == null || path.isEmpty()) {
            c(canvas);
            return;
        }
        int iSaveLayer = canvas.saveLayer(0.0f, 0.0f, canvas.getWidth(), canvas.getHeight(), this.tt, 31);
        c(canvas);
        this.tt.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.CLEAR));
        canvas.drawPath(this.c, this.tt);
        this.tt.setXfermode(null);
        canvas.restoreToCount(iSaveLayer);
    }

    public void update(int i, int i2, int i3, int i4) {
        this.c.addRect(i, i2, i3, i4, Path.Direction.CW);
        invalidateSelf();
    }

    public tt(GradientDrawable.Orientation orientation, @ColorInt int[] iArr) {
        super(orientation, iArr);
        this.c = new Path();
        Paint paint = new Paint(1);
        this.tt = paint;
        paint.setColor(-1);
    }
}

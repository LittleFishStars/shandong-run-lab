package com.byazt.ok;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.PaintFlagsDrawFilter;
import android.graphics.Path;
import android.graphics.RectF;
import android.widget.ImageView;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_11_8719cls.dex */
@com.byazt.zqa.c(c = {0, 1, 1585, 1586})
public class ClipImageView extends ImageView {
    public boolean c;
    public float[] n;
    public Path tt;
    public Paint uj;
    public RectF ve;

    public ClipImageView(Context context) {
        super(context);
        this.c = true;
        c(context);
    }

    public void c(Context context) {
        this.tt = new Path();
        this.ve = new RectF();
    }

    @Override // android.widget.ImageView, android.view.View
    public void onDraw(Canvas canvas) {
        if (this.c) {
            this.tt.reset();
            this.ve.set(0.0f, 0.0f, getWidth(), getHeight());
            float[] fArr = this.n;
            if (fArr != null) {
                this.tt.addRoundRect(this.ve, fArr, Path.Direction.CW);
            }
            canvas.setDrawFilter(new PaintFlagsDrawFilter(0, 3));
            canvas.clipPath(this.tt);
            Paint paint = this.uj;
            if (paint != null) {
                canvas.drawPath(this.tt, paint);
            }
        }
        super.onDraw(canvas);
    }

    @Override // android.view.View
    public void setBackgroundColor(int i) {
        Paint paint = new Paint(1);
        this.uj = paint;
        paint.setStyle(Paint.Style.FILL);
        this.uj.setColor(i);
    }

    public void setClip(boolean z) {
        this.c = z;
    }

    public void setRadius(float[] fArr) {
        if (fArr == null || fArr.length != 8) {
            return;
        }
        this.n = fArr;
    }

    public void setRoundRadius(int i) {
        if (i > 0) {
            float f = i;
            setRadius(new float[]{f, f, f, f, f, f, f, f});
        }
    }
}

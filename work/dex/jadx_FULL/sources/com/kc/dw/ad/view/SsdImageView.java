package com.kc.dw.ad.view;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.RectF;
import android.util.AttributeSet;
import androidx.appcompat.widget.AppCompatImageView;
import com.qihoo.SdkProtected.OSETSDK.Keep;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
@Keep
public class SsdImageView extends AppCompatImageView {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public RectF f39178a;
    public Path b;
    public Paint c;
    public int d;
    public float e;

    public SsdImageView(Context context) {
        super(context);
        this.f39178a = new RectF();
        this.b = new Path();
        this.c = new Paint();
        a();
    }

    public SsdImageView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f39178a = new RectF();
        this.b = new Path();
        this.c = new Paint();
        a();
    }

    public SsdImageView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f39178a = new RectF();
        this.b = new Path();
        this.c = new Paint();
        a();
    }

    public final void a() {
        this.d = -1;
        this.e = getResources().getDisplayMetrics().scaledDensity;
        this.c.setAntiAlias(true);
        this.c.setDither(true);
        this.c.setColor(this.d);
        this.c.setStyle(Paint.Style.STROKE);
        this.c.setStrokeWidth(this.e * 6.0f);
    }

    @Override // android.widget.ImageView, android.view.View
    public void onDraw(Canvas canvas) {
        this.f39178a.set(6.0f, 6.0f, getWidth() - 12, getHeight() - 12);
        this.b.reset();
        Path path = this.b;
        RectF rectF = this.f39178a;
        float f = this.e * 6.0f;
        path.addRoundRect(rectF, f, f, Path.Direction.CW);
        canvas.drawPath(this.b, this.c);
        canvas.clipPath(this.b);
        canvas.drawColor(this.d);
        super.onDraw(canvas);
    }
}

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
public class SsdImageView2 extends AppCompatImageView {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public RectF f39179a;
    public Path b;
    public Paint c;
    public float d;

    public SsdImageView2(Context context) {
        super(context);
        this.f39179a = new RectF();
        this.b = new Path();
        this.c = new Paint();
        a();
    }

    public SsdImageView2(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f39179a = new RectF();
        this.b = new Path();
        this.c = new Paint();
        a();
    }

    public SsdImageView2(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f39179a = new RectF();
        this.b = new Path();
        this.c = new Paint();
        a();
    }

    public final void a() {
        this.d = getResources().getDisplayMetrics().scaledDensity;
        this.c.setAntiAlias(true);
        this.c.setDither(true);
        this.c.setStyle(Paint.Style.STROKE);
        this.c.setStrokeWidth(this.d * 0.0f);
    }

    @Override // android.widget.ImageView, android.view.View
    public void onDraw(Canvas canvas) {
        this.f39179a.set(0.0f, 0.0f, getWidth(), getHeight());
        this.b.reset();
        Path path = this.b;
        RectF rectF = this.f39179a;
        float f = this.d * 6.0f;
        path.addRoundRect(rectF, f, f, Path.Direction.CW);
        canvas.clipPath(this.b);
        super.onDraw(canvas);
    }
}

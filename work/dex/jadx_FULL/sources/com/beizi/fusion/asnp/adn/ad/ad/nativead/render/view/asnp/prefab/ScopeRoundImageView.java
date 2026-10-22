package com.beizi.fusion.asnp.adn.ad.ad.nativead.render.view.asnp.prefab;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.RectF;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.widget.ImageView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_10_7392cls.dex */
public class ScopeRoundImageView extends ImageView {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final RectF f27045a;
    private float b;
    private String c;
    private int d;
    private final Paint e;
    private final Paint f;

    public ScopeRoundImageView(@NonNull Context context) {
        super(context);
        this.f27045a = new RectF();
        this.b = 0.0f;
        this.c = null;
        this.d = 0;
        this.e = new Paint();
        this.f = new Paint();
        a();
    }

    private void a() {
        this.e.setAntiAlias(true);
        this.e.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.SRC_IN));
        this.f.setAntiAlias(true);
        this.f.setColor(-1);
    }

    @Override // android.view.View
    public void draw(Canvas canvas) {
        canvas.saveLayer(this.f27045a, this.f, 31);
        RectF rectF = this.f27045a;
        float f = this.b;
        canvas.drawRoundRect(rectF, f, f, this.f);
        canvas.saveLayer(this.f27045a, this.e, 31);
        super.draw(canvas);
        if (this.d > 0 && !TextUtils.isEmpty(this.c) && this.c.startsWith("#")) {
            Paint paint = new Paint();
            paint.setColor(Color.parseColor(this.c));
            paint.setStyle(Paint.Style.STROKE);
            paint.setStrokeWidth(this.d);
            paint.setAntiAlias(true);
            RectF rectF2 = this.f27045a;
            float f2 = this.b;
            canvas.drawRoundRect(rectF2, f2, f2, paint);
        }
        canvas.restore();
    }

    @Override // android.view.View
    public void onLayout(boolean z, int i, int i2, int i3, int i4) {
        super.onLayout(z, i, i2, i3, i4);
        this.f27045a.set(0.0f, 0.0f, getWidth(), getHeight());
    }

    public void setBorderColor(String str) {
        this.c = str;
    }

    public void setBorderWidth(int i) {
        this.d = i;
    }

    public void setRectRadius(float f) {
        this.b = f;
    }

    public ScopeRoundImageView(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f27045a = new RectF();
        this.b = 0.0f;
        this.c = null;
        this.d = 0;
        this.e = new Paint();
        this.f = new Paint();
        a();
    }

    public ScopeRoundImageView(@NonNull Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f27045a = new RectF();
        this.b = 0.0f;
        this.c = null;
        this.d = 0;
        this.e = new Paint();
        this.f = new Paint();
        a();
    }
}

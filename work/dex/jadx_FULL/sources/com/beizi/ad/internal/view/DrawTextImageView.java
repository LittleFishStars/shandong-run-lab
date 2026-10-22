package com.beizi.ad.internal.view;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.util.AttributeSet;
import androidx.appcompat.widget.AppCompatImageView;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_10_7392cls.dex */
public class DrawTextImageView extends AppCompatImageView {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private String f26876a;
    private float b;
    private float c;
    private float d;
    private int e;
    private int f;

    public DrawTextImageView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f26876a = "";
        this.b = 30.0f;
        this.c = -1000.0f;
        this.d = -1000.0f;
        this.e = 0;
        this.f = 3;
    }

    @Override // android.widget.ImageView, android.view.View
    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if (this.f26876a.equals("")) {
            return;
        }
        Paint paint = new Paint();
        paint.setColor(getResources().getColor(this.e));
        paint.setStrokeWidth(this.f);
        paint.setStyle(Paint.Style.FILL);
        paint.setTextSize(this.b);
        String str = this.f26876a;
        float width = this.c;
        if (width == -1000.0f) {
            width = canvas.getWidth() - (this.b * this.f26876a.length());
        }
        float height = this.d;
        if (height == -1000.0f) {
            height = canvas.getHeight() - 50;
        }
        canvas.drawText(str, width, height, paint);
    }

    public void setDrawLocalXY(float f, float f2) {
        this.c = f;
        this.d = f2;
        drawableStateChanged();
    }

    public void setDrawText(String str) {
        this.f26876a = str;
        drawableStateChanged();
    }

    public void setDrawTextColorResourse(int i) {
        this.e = i;
        drawableStateChanged();
    }

    public void setDrawTextSize(float f) {
        this.b = f;
        drawableStateChanged();
    }

    public void setDrawTextStrokeWidth(int i) {
        this.f = i;
        drawableStateChanged();
    }

    public DrawTextImageView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f26876a = "";
        this.b = 30.0f;
        this.c = -1000.0f;
        this.d = -1000.0f;
        this.e = 0;
        this.f = 3;
    }

    public DrawTextImageView(Context context) {
        super(context);
        this.f26876a = "";
        this.b = 30.0f;
        this.c = -1000.0f;
        this.d = -1000.0f;
        this.e = 0;
        this.f = 3;
    }
}

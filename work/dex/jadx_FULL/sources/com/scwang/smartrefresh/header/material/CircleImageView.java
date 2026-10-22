package com.scwang.smartrefresh.header.material;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RadialGradient;
import android.graphics.Shader;
import android.graphics.drawable.ShapeDrawable;
import android.graphics.drawable.shapes.OvalShape;
import android.widget.ImageView;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_05_1888cls.dex */
@SuppressLint({"ViewConstructor"})
public class CircleImageView extends ImageView {
    protected static final int FILL_SHADOW_COLOR = 1023410176;
    protected static final int KEY_SHADOW_COLOR = 503316480;
    protected static final int SHADOW_ELEVATION = 4;
    protected static final float SHADOW_RADIUS = 3.5f;
    protected static final float X_OFFSET = 0.0f;
    protected static final float Y_OFFSET = 1.75f;
    int mShadowRadius;

    public class a extends OvalShape {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public Paint f40389a = new Paint();

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        public RadialGradient f15119a;

        public a(int i) {
            CircleImageView.this.mShadowRadius = i;
            a((int) super.rect().width());
        }

        public final void a(int i) {
            float f = i / 2.0f;
            RadialGradient radialGradient = new RadialGradient(f, f, CircleImageView.this.mShadowRadius, new int[]{CircleImageView.FILL_SHADOW_COLOR, 0}, (float[]) null, Shader.TileMode.CLAMP);
            this.f15119a = radialGradient;
            this.f40389a.setShader(radialGradient);
        }

        @Override // android.graphics.drawable.shapes.OvalShape, android.graphics.drawable.shapes.RectShape, android.graphics.drawable.shapes.Shape
        public void draw(Canvas canvas, Paint paint) {
            CircleImageView circleImageView = CircleImageView.this;
            float width = circleImageView.getWidth() / 2.0f;
            float height = circleImageView.getHeight() / 2.0f;
            canvas.drawCircle(width, height, width, this.f40389a);
            canvas.drawCircle(width, height, width - CircleImageView.this.mShadowRadius, paint);
        }

        @Override // android.graphics.drawable.shapes.RectShape, android.graphics.drawable.shapes.Shape
        public void onResize(float f, float f2) {
            super.onResize(f, f2);
            a((int) f);
        }
    }

    public CircleImageView(Context context, int i) {
        super(context);
        float f = getResources().getDisplayMetrics().density;
        this.mShadowRadius = (int) (SHADOW_RADIUS * f);
        ShapeDrawable shapeDrawable = new ShapeDrawable(new OvalShape());
        setElevation(f * 4.0f);
        shapeDrawable.getPaint().setColor(i);
        setBackground(shapeDrawable);
    }

    @Override // android.widget.ImageView, android.view.View
    public void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
    }
}

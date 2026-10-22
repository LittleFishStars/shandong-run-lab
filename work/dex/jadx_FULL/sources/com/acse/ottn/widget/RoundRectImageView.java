package com.acse.ottn.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Bitmap;
import android.graphics.BitmapShader;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Shader;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.widget.ImageView;
import com.acse.ottn.R;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public class RoundRectImageView extends ImageView {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public Paint f23289a;
    public Paint b;
    public float c;

    public RoundRectImageView(Context context) {
        this(context, null);
    }

    public final void a(Context context, AttributeSet attributeSet) {
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.RoundRectImageView);
        try {
            this.c = typedArrayObtainStyledAttributes.getDimension(R.styleable.RoundRectImageView_image_radius, -1.6711936E7f);
        } finally {
            typedArrayObtainStyledAttributes.recycle();
        }
    }

    @Override // android.widget.ImageView, android.view.View
    public void onDraw(Canvas canvas) {
        Drawable drawable = getDrawable();
        if (drawable == null) {
            super.onDraw(canvas);
            return;
        }
        Bitmap bitmapA = a(a(drawable), this.c);
        Rect rect = new Rect(0, 0, bitmapA.getWidth(), bitmapA.getHeight());
        Rect rect2 = new Rect(0, 0, getWidth(), getHeight());
        this.f23289a.reset();
        this.f23289a.setAntiAlias(true);
        canvas.drawBitmap(bitmapA, rect, rect2, this.f23289a);
    }

    public void setRadius(int i) {
        this.c = a(i);
    }

    public RoundRectImageView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public RoundRectImageView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.c = 0.0f;
        if (!isInEditMode()) {
            a(context, attributeSet);
        }
        Paint paint = new Paint();
        this.f23289a = paint;
        paint.setAntiAlias(true);
        Paint paint2 = new Paint();
        this.b = paint2;
        paint2.setAntiAlias(true);
    }

    public static Bitmap a(Drawable drawable) {
        Bitmap bitmapCreateBitmap = Bitmap.createBitmap(drawable.getIntrinsicWidth(), drawable.getIntrinsicHeight(), drawable.getOpacity() != -1 ? Bitmap.Config.ARGB_8888 : Bitmap.Config.RGB_565);
        drawable.draw(new Canvas(bitmapCreateBitmap));
        return bitmapCreateBitmap;
    }

    public static Bitmap a(Bitmap bitmap, int i, int i2, int i3, int i4) {
        if (bitmap == null) {
            return null;
        }
        float width = (i * 1.0f) / bitmap.getWidth();
        float height = (i2 * 1.0f) / bitmap.getHeight();
        Matrix matrix = new Matrix();
        matrix.setScale(width, height);
        Bitmap bitmapCreateBitmap = Bitmap.createBitmap(i, i2, Bitmap.Config.ARGB_8888);
        Canvas canvas = new Canvas(bitmapCreateBitmap);
        Paint paint = new Paint();
        Shader.TileMode tileMode = Shader.TileMode.CLAMP;
        BitmapShader bitmapShader = new BitmapShader(bitmap, tileMode, tileMode);
        bitmapShader.setLocalMatrix(matrix);
        paint.setShader(bitmapShader);
        float f = i4;
        RectF rectF = new RectF(f, f, i - i4, i2 - i4);
        float f2 = i3;
        canvas.drawRoundRect(rectF, f2, f2, paint);
        if (i4 > 0) {
            Paint paint2 = new Paint(1);
            paint.setAntiAlias(true);
            paint2.setColor(-16711936);
            paint2.setStyle(Paint.Style.STROKE);
            paint2.setStrokeWidth(f);
            canvas.drawRoundRect(rectF, f2, f2, paint2);
        }
        return bitmapCreateBitmap;
    }

    public Bitmap a(Bitmap bitmap, float f) {
        Bitmap bitmapCreateBitmap = Bitmap.createBitmap(bitmap.getWidth(), bitmap.getHeight(), Bitmap.Config.ARGB_8888);
        Canvas canvas = new Canvas(bitmapCreateBitmap);
        Paint paint = new Paint();
        Rect rect = new Rect(0, 0, bitmap.getWidth(), bitmap.getHeight());
        RectF rectF = new RectF(rect);
        paint.setAntiAlias(true);
        canvas.drawARGB(0, 0, 0, 0);
        canvas.drawRoundRect(rectF, f, f, paint);
        paint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.SRC_IN));
        canvas.drawBitmap(bitmap, rect, rect, paint);
        return bitmapCreateBitmap;
    }

    public final int a(int i) {
        return (int) (i * getContext().getResources().getDisplayMetrics().density);
    }
}

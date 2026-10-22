package com.zj.adlib;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.drawable.BitmapDrawable;
import android.view.ViewGroup;
import android.widget.ImageView;
import java.lang.ref.WeakReference;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_10_7392cls.dex */
public class db7 extends BitmapDrawable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public float f41149a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public int f15965a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public Matrix f15966a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public WeakReference<ImageView> f15967a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public boolean f15968a;
    public float b;

    public db7(Resources resources, Bitmap bitmap, ImageView imageView, float f, float f2) {
        super(resources, bitmap);
        this.f15967a = new WeakReference<>(imageView);
        this.f41149a = f;
        this.b = f2;
        imageView.setScaleType(ImageView.ScaleType.MATRIX);
        imageView.setImageMatrix(new Matrix());
        a(imageView, bitmap, false);
    }

    public final void a(ImageView imageView, Bitmap bitmap, boolean z) {
        int iD = d(imageView);
        if (iD <= 0) {
            return;
        }
        int iF = f(bitmap.getWidth(), bitmap.getHeight(), iD) + imageView.getPaddingTop() + imageView.getPaddingBottom();
        ViewGroup.LayoutParams layoutParams = imageView.getLayoutParams();
        if (layoutParams == null) {
            return;
        }
        if (iF != layoutParams.height) {
            layoutParams.height = iF;
            imageView.setLayoutParams(layoutParams);
        }
        if (z) {
            this.f15968a = true;
        }
    }

    public final void b(Canvas canvas, ImageView imageView, Bitmap bitmap) {
        Matrix matrixC = c(imageView, bitmap);
        if (matrixC != null) {
            int paddingTop = imageView.getPaddingTop() + imageView.getPaddingBottom();
            int paddingLeft = imageView.getPaddingLeft() + imageView.getPaddingRight();
            if (paddingTop > 0 || paddingLeft > 0) {
                canvas.clipRect(0, 0, imageView.getWidth() - paddingLeft, imageView.getHeight() - paddingTop);
            }
            canvas.drawBitmap(bitmap, matrixC, getPaint());
        }
        if (this.f15968a) {
            return;
        }
        a(imageView, bitmap, true);
    }

    public final Matrix c(ImageView imageView, Bitmap bitmap) {
        float fE;
        float f;
        int width = bitmap.getWidth();
        Matrix matrix = this.f15966a;
        if (matrix != null && width == this.f15965a) {
            return matrix;
        }
        int height = bitmap.getHeight();
        int iD = d(imageView);
        int iF = f(width, height, iD);
        if (width <= 0 || height <= 0 || iD <= 0 || iF <= 0) {
            return null;
        }
        if (this.f15966a == null || width != this.f15965a) {
            this.f15966a = new Matrix();
            float f2 = 0.0f;
            if (width * iF >= iD * height) {
                f = iF / height;
                fE = 0.0f;
                f2 = (iD - (width * f)) * 0.5f;
            } else {
                float f3 = iD / width;
                fE = (iF - (height * f3)) * e(width, height);
                f = f3;
            }
            this.f15966a.setScale(f, f);
            this.f15966a.postTranslate(f2, fE);
            this.f15965a = width;
        }
        return this.f15966a;
    }

    public final int d(ImageView imageView) {
        ViewGroup.LayoutParams layoutParams = imageView.getLayoutParams();
        int width = layoutParams != null ? layoutParams.width : 0;
        if (width <= 0) {
            width = imageView.getWidth();
        }
        return width > 0 ? (width - imageView.getPaddingLeft()) - imageView.getPaddingRight() : width;
    }

    @Override // android.graphics.drawable.BitmapDrawable, android.graphics.drawable.Drawable
    public void draw(Canvas canvas) {
        WeakReference<ImageView> weakReference = this.f15967a;
        ImageView imageView = weakReference != null ? weakReference.get() : null;
        if (this.f41149a == 0.0f || imageView == null) {
            super.draw(canvas);
        } else {
            b(canvas, imageView, getBitmap());
        }
    }

    public final float e(int i, int i2) {
        float f = this.b;
        return f != Float.MAX_VALUE ? (1.0f - f) / 2.0f : ((1.5f - Math.max(1.0f, Math.min(1.5f, i2 / i))) / 2.0f) + 0.25f;
    }

    public final int f(int i, int i2, int i3) {
        float f = this.f41149a;
        if (f == Float.MAX_VALUE) {
            f = i2 / i;
        }
        return (int) (i3 * f);
    }
}

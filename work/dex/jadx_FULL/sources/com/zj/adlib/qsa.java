package com.zj.adlib;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import com.amap.api.maps.model.BitmapDescriptor;
import com.amap.api.maps.model.BitmapDescriptorFactory;
import com.amap.api.maps.model.MarkerOptions;
import com.amap.api.maps.model.TextOptions;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_10_7392cls.dex */
public final class qsa {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static Paint f44292a = new Paint();

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public static Rect f19169a = new Rect();

    public static float a(int i, boolean z) {
        if (z) {
            if (i != 1) {
                return i != 2 ? 0.5f : 1.0f;
            }
            return 0.0f;
        }
        if (i != 8) {
            return i != 16 ? 0.5f : 1.0f;
        }
        return 0.0f;
    }

    public static MarkerOptions b(TextOptions textOptions) {
        if (textOptions == null) {
            return null;
        }
        MarkerOptions markerOptions = new MarkerOptions();
        markerOptions.position(textOptions.getPosition());
        markerOptions.visible(textOptions.isVisible());
        markerOptions.zIndex(textOptions.getZIndex());
        markerOptions.rotateAngle(textOptions.getRotate());
        markerOptions.icon(c(textOptions));
        markerOptions.anchor(a(textOptions.getAlignX(), true), a(textOptions.getAlignY(), false));
        return markerOptions;
    }

    public static BitmapDescriptor c(TextOptions textOptions) {
        if (textOptions == null) {
            return null;
        }
        f44292a.setTypeface(textOptions.getTypeface());
        f44292a.setSubpixelText(true);
        f44292a.setAntiAlias(true);
        f44292a.setStrokeWidth(5.0f);
        f44292a.setStrokeCap(Paint.Cap.ROUND);
        f44292a.setTextSize(textOptions.getFontSize());
        f44292a.setTextAlign(Paint.Align.CENTER);
        f44292a.setColor(textOptions.getFontColor());
        Paint.FontMetrics fontMetrics = f44292a.getFontMetrics();
        int i = (int) (fontMetrics.descent - fontMetrics.ascent);
        int i2 = (int) (((i - fontMetrics.bottom) - fontMetrics.top) / 2.0f);
        if (textOptions.getText() != null) {
            f44292a.getTextBounds(textOptions.getText(), 0, textOptions.getText().length(), f19169a);
        }
        Bitmap bitmapCreateBitmap = Bitmap.createBitmap(f19169a.width() + 6, i, Bitmap.Config.ARGB_8888);
        Canvas canvas = new Canvas(bitmapCreateBitmap);
        canvas.drawColor(textOptions.getBackgroundColor());
        if (textOptions.getText() != null) {
            canvas.drawText(textOptions.getText(), f19169a.centerX() + 3, i2, f44292a);
        }
        return BitmapDescriptorFactory.fromBitmap(bitmapCreateBitmap);
    }
}

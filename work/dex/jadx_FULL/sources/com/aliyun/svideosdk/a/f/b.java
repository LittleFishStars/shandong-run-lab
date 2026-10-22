package com.aliyun.svideosdk.a.f;

import android.annotation.TargetApi;
import android.graphics.Matrix;
import android.graphics.Rect;
import android.graphics.RectF;
import android.util.Log;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final String f25612a;
    private final Matrix b;
    private RectF c;

    @TargetApi(21)
    public b(int i, Rect rect, int i2, RectF rectF) {
        String simpleName = b.class.getSimpleName();
        this.f25612a = simpleName;
        if (!a(rectF)) {
            throw new IllegalArgumentException("previewRect");
        }
        this.c = new RectF(rect);
        Matrix matrixA = a(i2 == 0, i, rectF);
        this.b = matrixA;
        Log.d(simpleName, "CoordinateTransformer, mDriverRectF = {" + this.c.left + ", " + this.c.right + ", " + this.c.top + ", " + this.c.bottom + "}");
        matrixA.getValues(new float[16]);
    }

    private Matrix a(boolean z, int i, RectF rectF) {
        Matrix matrix = new Matrix();
        matrix.setScale(z ? -1.0f : 1.0f, 1.0f);
        matrix.postRotate(-i);
        matrix.mapRect(rectF);
        Matrix matrix2 = new Matrix();
        matrix2.setRectToRect(rectF, this.c, Matrix.ScaleToFit.FILL);
        matrix.setConcat(matrix2, matrix);
        return matrix;
    }

    private boolean a(RectF rectF) {
        return (rectF.width() == 0.0f || rectF.height() == 0.0f) ? false : true;
    }

    public RectF b(RectF rectF) {
        RectF rectF2 = new RectF();
        this.b.mapRect(rectF2, rectF);
        return rectF2;
    }
}

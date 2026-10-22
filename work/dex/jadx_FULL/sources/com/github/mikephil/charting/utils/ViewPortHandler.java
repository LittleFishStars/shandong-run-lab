package com.github.mikephil.charting.utils;

import android.graphics.Matrix;
import android.graphics.RectF;
import android.view.View;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_08_10593cls.dex */
public class ViewPortHandler {
    protected final Matrix mMatrixTouch = new Matrix();
    protected RectF mContentRect = new RectF();
    protected float mChartWidth = 0.0f;
    protected float mChartHeight = 0.0f;
    private float mMinScaleY = 1.0f;
    private float mMaxScaleY = Float.MAX_VALUE;
    private float mMinScaleX = 1.0f;
    private float mMaxScaleX = Float.MAX_VALUE;
    private float mScaleX = 1.0f;
    private float mScaleY = 1.0f;
    private float mTransX = 0.0f;
    private float mTransY = 0.0f;
    private float mTransOffsetX = 0.0f;
    private float mTransOffsetY = 0.0f;
    protected float[] valsBufferForFitScreen = new float[9];
    protected Matrix mCenterViewPortMatrixBuffer = new Matrix();
    protected final float[] matrixBuffer = new float[9];

    public boolean canZoomInMoreX() {
        return this.mScaleX < this.mMaxScaleX;
    }

    public boolean canZoomInMoreY() {
        return this.mScaleY < this.mMaxScaleY;
    }

    public boolean canZoomOutMoreX() {
        return this.mScaleX > this.mMinScaleX;
    }

    public boolean canZoomOutMoreY() {
        return this.mScaleY > this.mMinScaleY;
    }

    public void centerViewPort(float[] fArr, View view) {
        Matrix matrix = this.mCenterViewPortMatrixBuffer;
        matrix.reset();
        matrix.set(this.mMatrixTouch);
        matrix.postTranslate(-(fArr[0] - offsetLeft()), -(fArr[1] - offsetTop()));
        refresh(matrix, view, true);
    }

    public float contentBottom() {
        return this.mContentRect.bottom;
    }

    public float contentHeight() {
        return this.mContentRect.height();
    }

    public float contentLeft() {
        return this.mContentRect.left;
    }

    public float contentRight() {
        return this.mContentRect.right;
    }

    public float contentTop() {
        return this.mContentRect.top;
    }

    public float contentWidth() {
        return this.mContentRect.width();
    }

    public Matrix fitScreen() {
        Matrix matrix = new Matrix();
        fitScreen(matrix);
        return matrix;
    }

    public float getChartHeight() {
        return this.mChartHeight;
    }

    public float getChartWidth() {
        return this.mChartWidth;
    }

    public MPPointF getContentCenter() {
        return MPPointF.getInstance(this.mContentRect.centerX(), this.mContentRect.centerY());
    }

    public RectF getContentRect() {
        return this.mContentRect;
    }

    public Matrix getMatrixTouch() {
        return this.mMatrixTouch;
    }

    public float getMaxScaleX() {
        return this.mMaxScaleX;
    }

    public float getMaxScaleY() {
        return this.mMaxScaleY;
    }

    public float getMinScaleX() {
        return this.mMinScaleX;
    }

    public float getMinScaleY() {
        return this.mMinScaleY;
    }

    public float getScaleX() {
        return this.mScaleX;
    }

    public float getScaleY() {
        return this.mScaleY;
    }

    public float getSmallestContentExtension() {
        return Math.min(this.mContentRect.width(), this.mContentRect.height());
    }

    public float getTransX() {
        return this.mTransX;
    }

    public float getTransY() {
        return this.mTransY;
    }

    public boolean hasChartDimens() {
        return this.mChartHeight > 0.0f && this.mChartWidth > 0.0f;
    }

    public boolean hasNoDragOffset() {
        return this.mTransOffsetX <= 0.0f && this.mTransOffsetY <= 0.0f;
    }

    public boolean isFullyZoomedOut() {
        return isFullyZoomedOutX() && isFullyZoomedOutY();
    }

    public boolean isFullyZoomedOutX() {
        float f = this.mScaleX;
        float f2 = this.mMinScaleX;
        return f <= f2 && f2 <= 1.0f;
    }

    public boolean isFullyZoomedOutY() {
        float f = this.mScaleY;
        float f2 = this.mMinScaleY;
        return f <= f2 && f2 <= 1.0f;
    }

    public boolean isInBounds(float f, float f2) {
        return isInBoundsX(f) && isInBoundsY(f2);
    }

    public boolean isInBoundsBottom(float f) {
        return this.mContentRect.bottom >= ((float) ((int) (f * 100.0f))) / 100.0f;
    }

    public boolean isInBoundsLeft(float f) {
        return this.mContentRect.left <= f + 1.0f;
    }

    public boolean isInBoundsRight(float f) {
        return this.mContentRect.right >= (((float) ((int) (f * 100.0f))) / 100.0f) - 1.0f;
    }

    public boolean isInBoundsTop(float f) {
        return this.mContentRect.top <= f;
    }

    public boolean isInBoundsX(float f) {
        return isInBoundsLeft(f) && isInBoundsRight(f);
    }

    public boolean isInBoundsY(float f) {
        return isInBoundsTop(f) && isInBoundsBottom(f);
    }

    public void limitTransAndScale(Matrix matrix, RectF rectF) {
        float fWidth;
        float fHeight;
        matrix.getValues(this.matrixBuffer);
        float[] fArr = this.matrixBuffer;
        float f = fArr[2];
        float f2 = fArr[0];
        float f3 = fArr[5];
        float f4 = fArr[4];
        this.mScaleX = Math.min(Math.max(this.mMinScaleX, f2), this.mMaxScaleX);
        this.mScaleY = Math.min(Math.max(this.mMinScaleY, f4), this.mMaxScaleY);
        if (rectF != null) {
            fWidth = rectF.width();
            fHeight = rectF.height();
        } else {
            fWidth = 0.0f;
            fHeight = 0.0f;
        }
        this.mTransX = Math.min(Math.max(f, ((-fWidth) * (this.mScaleX - 1.0f)) - this.mTransOffsetX), this.mTransOffsetX);
        float fMax = Math.max(Math.min(f3, (fHeight * (this.mScaleY - 1.0f)) + this.mTransOffsetY), -this.mTransOffsetY);
        this.mTransY = fMax;
        float[] fArr2 = this.matrixBuffer;
        fArr2[2] = this.mTransX;
        fArr2[0] = this.mScaleX;
        fArr2[5] = fMax;
        fArr2[4] = this.mScaleY;
        matrix.setValues(fArr2);
    }

    public float offsetBottom() {
        return this.mChartHeight - this.mContentRect.bottom;
    }

    public float offsetLeft() {
        return this.mContentRect.left;
    }

    public float offsetRight() {
        return this.mChartWidth - this.mContentRect.right;
    }

    public float offsetTop() {
        return this.mContentRect.top;
    }

    public Matrix refresh(Matrix matrix, View view, boolean z) {
        this.mMatrixTouch.set(matrix);
        limitTransAndScale(this.mMatrixTouch, this.mContentRect);
        if (z) {
            view.invalidate();
        }
        matrix.set(this.mMatrixTouch);
        return matrix;
    }

    public void resetZoom(Matrix matrix) {
        matrix.reset();
        matrix.set(this.mMatrixTouch);
        matrix.postScale(1.0f, 1.0f, 0.0f, 0.0f);
    }

    public void restrainViewPort(float f, float f2, float f3, float f4) {
        this.mContentRect.set(f, f2, this.mChartWidth - f3, this.mChartHeight - f4);
    }

    public void setChartDimens(float f, float f2) {
        float fOffsetLeft = offsetLeft();
        float fOffsetTop = offsetTop();
        float fOffsetRight = offsetRight();
        float fOffsetBottom = offsetBottom();
        this.mChartHeight = f2;
        this.mChartWidth = f;
        restrainViewPort(fOffsetLeft, fOffsetTop, fOffsetRight, fOffsetBottom);
    }

    public void setDragOffsetX(float f) {
        this.mTransOffsetX = Utils.convertDpToPixel(f);
    }

    public void setDragOffsetY(float f) {
        this.mTransOffsetY = Utils.convertDpToPixel(f);
    }

    public void setMaximumScaleX(float f) {
        if (f == 0.0f) {
            f = Float.MAX_VALUE;
        }
        this.mMaxScaleX = f;
        limitTransAndScale(this.mMatrixTouch, this.mContentRect);
    }

    public void setMaximumScaleY(float f) {
        if (f == 0.0f) {
            f = Float.MAX_VALUE;
        }
        this.mMaxScaleY = f;
        limitTransAndScale(this.mMatrixTouch, this.mContentRect);
    }

    public void setMinMaxScaleX(float f, float f2) {
        if (f < 1.0f) {
            f = 1.0f;
        }
        if (f2 == 0.0f) {
            f2 = Float.MAX_VALUE;
        }
        this.mMinScaleX = f;
        this.mMaxScaleX = f2;
        limitTransAndScale(this.mMatrixTouch, this.mContentRect);
    }

    public void setMinMaxScaleY(float f, float f2) {
        if (f < 1.0f) {
            f = 1.0f;
        }
        if (f2 == 0.0f) {
            f2 = Float.MAX_VALUE;
        }
        this.mMinScaleY = f;
        this.mMaxScaleY = f2;
        limitTransAndScale(this.mMatrixTouch, this.mContentRect);
    }

    public void setMinimumScaleX(float f) {
        if (f < 1.0f) {
            f = 1.0f;
        }
        this.mMinScaleX = f;
        limitTransAndScale(this.mMatrixTouch, this.mContentRect);
    }

    public void setMinimumScaleY(float f) {
        if (f < 1.0f) {
            f = 1.0f;
        }
        this.mMinScaleY = f;
        limitTransAndScale(this.mMatrixTouch, this.mContentRect);
    }

    public Matrix setZoom(float f, float f2) {
        Matrix matrix = new Matrix();
        setZoom(f, f2, matrix);
        return matrix;
    }

    public Matrix translate(float[] fArr) {
        Matrix matrix = new Matrix();
        translate(fArr, matrix);
        return matrix;
    }

    public Matrix zoom(float f, float f2) {
        Matrix matrix = new Matrix();
        zoom(f, f2, matrix);
        return matrix;
    }

    public Matrix zoomIn(float f, float f2) {
        Matrix matrix = new Matrix();
        zoomIn(f, f2, matrix);
        return matrix;
    }

    public Matrix zoomOut(float f, float f2) {
        Matrix matrix = new Matrix();
        zoomOut(f, f2, matrix);
        return matrix;
    }

    public void fitScreen(Matrix matrix) {
        this.mMinScaleX = 1.0f;
        this.mMinScaleY = 1.0f;
        matrix.set(this.mMatrixTouch);
        float[] fArr = this.valsBufferForFitScreen;
        for (int i = 0; i < 9; i++) {
            fArr[i] = 0.0f;
        }
        matrix.getValues(fArr);
        fArr[2] = 0.0f;
        fArr[5] = 0.0f;
        fArr[0] = 1.0f;
        fArr[4] = 1.0f;
        matrix.setValues(fArr);
    }

    public void setZoom(float f, float f2, Matrix matrix) {
        matrix.reset();
        matrix.set(this.mMatrixTouch);
        matrix.setScale(f, f2);
    }

    public void translate(float[] fArr, Matrix matrix) {
        matrix.reset();
        matrix.set(this.mMatrixTouch);
        matrix.postTranslate(-(fArr[0] - offsetLeft()), -(fArr[1] - offsetTop()));
    }

    public void zoom(float f, float f2, Matrix matrix) {
        matrix.reset();
        matrix.set(this.mMatrixTouch);
        matrix.postScale(f, f2);
    }

    public void zoomIn(float f, float f2, Matrix matrix) {
        matrix.reset();
        matrix.set(this.mMatrixTouch);
        matrix.postScale(1.4f, 1.4f, f, f2);
    }

    public void zoomOut(float f, float f2, Matrix matrix) {
        matrix.reset();
        matrix.set(this.mMatrixTouch);
        matrix.postScale(0.7f, 0.7f, f, f2);
    }

    public Matrix setZoom(float f, float f2, float f3, float f4) {
        Matrix matrix = new Matrix();
        matrix.set(this.mMatrixTouch);
        matrix.setScale(f, f2, f3, f4);
        return matrix;
    }

    public Matrix zoom(float f, float f2, float f3, float f4) {
        Matrix matrix = new Matrix();
        zoom(f, f2, f3, f4, matrix);
        return matrix;
    }

    public void zoom(float f, float f2, float f3, float f4, Matrix matrix) {
        matrix.reset();
        matrix.set(this.mMatrixTouch);
        matrix.postScale(f, f2, f3, f4);
    }
}

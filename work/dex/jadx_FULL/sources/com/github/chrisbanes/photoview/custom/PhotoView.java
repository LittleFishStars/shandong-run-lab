package com.github.chrisbanes.photoview.custom;

import android.content.Context;
import android.graphics.Matrix;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.util.AttributeSet;
import android.view.GestureDetector;
import android.view.View;
import android.widget.ImageView;
import androidx.annotation.RestrictTo;
import androidx.appcompat.widget.AppCompatImageView;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_08_10593cls.dex */
@RestrictTo({RestrictTo.Scope.LIBRARY})
public class PhotoView extends AppCompatImageView {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public ImageView.ScaleType f30392a;
    protected b attacher;

    public PhotoView(Context context) {
        this(context, null);
    }

    public b getAttacher() {
        return this.attacher;
    }

    public void getDisplayMatrix(Matrix matrix) {
        this.attacher.A(matrix);
    }

    public RectF getDisplayRect() {
        return this.attacher.B();
    }

    @Override // android.widget.ImageView
    public Matrix getImageMatrix() {
        return this.attacher.F();
    }

    public float getMaximumScale() {
        return this.attacher.I();
    }

    public float getMediumScale() {
        return this.attacher.J();
    }

    public float getMinimumScale() {
        return this.attacher.K();
    }

    public float getScale() {
        return this.attacher.L();
    }

    @Override // android.widget.ImageView
    public ImageView.ScaleType getScaleType() {
        return this.attacher.M();
    }

    public void getSuppMatrix(Matrix matrix) {
        this.attacher.N(matrix);
    }

    public final void init() {
        this.attacher = new b(this);
        super.setScaleType(ImageView.ScaleType.MATRIX);
        ImageView.ScaleType scaleType = this.f30392a;
        if (scaleType != null) {
            setScaleType(scaleType);
            this.f30392a = null;
        }
    }

    public boolean isZoomable() {
        return this.attacher.R();
    }

    public void setAllowParentInterceptOnEdge(boolean z) {
        this.attacher.T(z);
    }

    public boolean setDisplayMatrix(Matrix matrix) {
        return this.attacher.V(matrix);
    }

    @Override // android.widget.ImageView
    public boolean setFrame(int i, int i2, int i3, int i4) {
        boolean frame = super.setFrame(i, i2, i3, i4);
        if (frame) {
            this.attacher.update();
        }
        return frame;
    }

    @Override // androidx.appcompat.widget.AppCompatImageView, android.widget.ImageView
    public void setImageDrawable(Drawable drawable) {
        super.setImageDrawable(drawable);
        b bVar = this.attacher;
        if (bVar != null) {
            bVar.update();
        }
    }

    @Override // androidx.appcompat.widget.AppCompatImageView, android.widget.ImageView
    public void setImageResource(int i) {
        super.setImageResource(i);
        b bVar = this.attacher;
        if (bVar != null) {
            bVar.update();
        }
    }

    @Override // androidx.appcompat.widget.AppCompatImageView, android.widget.ImageView
    public void setImageURI(Uri uri) {
        super.setImageURI(uri);
        b bVar = this.attacher;
        if (bVar != null) {
            bVar.update();
        }
    }

    public void setMaximumScale(float f) {
        this.attacher.X(f);
    }

    public void setMediumScale(float f) {
        this.attacher.Y(f);
    }

    public void setMinimumScale(float f) {
        this.attacher.Z(f);
    }

    @Override // android.view.View
    public void setOnClickListener(View.OnClickListener onClickListener) {
        this.attacher.setOnClickListener(onClickListener);
    }

    public void setOnDoubleTapListener(GestureDetector.OnDoubleTapListener onDoubleTapListener) {
        this.attacher.setOnDoubleTapListener(onDoubleTapListener);
    }

    @Override // android.view.View
    public void setOnLongClickListener(View.OnLongClickListener onLongClickListener) {
        this.attacher.setOnLongClickListener(onLongClickListener);
    }

    public void setOnMatrixChangeListener(OnMatrixChangedListener onMatrixChangedListener) {
        this.attacher.setOnMatrixChangeListener(onMatrixChangedListener);
    }

    public void setOnOutsidePhotoTapListener(OnOutsidePhotoTapListener onOutsidePhotoTapListener) {
        this.attacher.setOnOutsidePhotoTapListener(onOutsidePhotoTapListener);
    }

    public void setOnPhotoTapListener(OnPhotoTapListener onPhotoTapListener) {
        this.attacher.setOnPhotoTapListener(onPhotoTapListener);
    }

    public void setOnScaleChangeListener(OnScaleChangedListener onScaleChangedListener) {
        this.attacher.setOnScaleChangeListener(onScaleChangedListener);
    }

    public void setOnSingleFlingListener(OnSingleFlingListener onSingleFlingListener) {
        this.attacher.setOnSingleFlingListener(onSingleFlingListener);
    }

    public void setOnViewDragListener(OnViewDragListener onViewDragListener) {
        this.attacher.setOnViewDragListener(onViewDragListener);
    }

    public void setOnViewTapListener(OnViewTapListener onViewTapListener) {
        this.attacher.setOnViewTapListener(onViewTapListener);
    }

    public void setRotationBy(float f) {
        this.attacher.a0(f);
    }

    public void setRotationTo(float f) {
        this.attacher.b0(f);
    }

    public void setScale(float f) {
        this.attacher.c0(f);
    }

    public void setScaleLevels(float f, float f2, float f3) {
        this.attacher.f0(f, f2, f3);
    }

    @Override // android.widget.ImageView
    public void setScaleType(ImageView.ScaleType scaleType) {
        b bVar = this.attacher;
        if (bVar == null) {
            this.f30392a = scaleType;
        } else {
            bVar.g0(scaleType);
        }
    }

    public boolean setSuppMatrix(Matrix matrix) {
        return this.attacher.V(matrix);
    }

    public void setZoomTransitionDuration(int i) {
        this.attacher.i0(i);
    }

    public void setZoomable(boolean z) {
        this.attacher.j0(z);
    }

    public PhotoView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public void setScale(float f, boolean z) {
        this.attacher.e0(f, z);
    }

    public PhotoView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        init();
    }

    public void setScale(float f, float f2, float f3, boolean z) {
        this.attacher.d0(f, f2, f3, z);
    }
}

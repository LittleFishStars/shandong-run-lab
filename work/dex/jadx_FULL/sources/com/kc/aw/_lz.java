package com.kc.aw;

import android.graphics.Camera;
import android.graphics.Matrix;
import android.view.animation.Animation;
import android.view.animation.Transformation;
import com.qihoo.SdkProtected.OSETSDK.Keep;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
@Keep
public final class _lz extends Animation {
    public final float _a = -35.0f;
    public final float _b = 35.0f;
    public final float _c;
    public final float _d;
    public Camera _e;

    public _lz(float f, float f2) {
        this._c = f;
        this._d = f2;
    }

    @Override // android.view.animation.Animation
    public final void applyTransformation(float f, Transformation transformation) {
        float f2 = this._a;
        float f3 = this._b;
        Matrix matrix = transformation.getMatrix();
        this._e.save();
        this._e.rotateY(((f3 - f2) * f) + f2);
        this._e.getMatrix(matrix);
        this._e.restore();
        matrix.preTranslate(-this._c, -this._d);
        matrix.postTranslate(this._c, this._d);
    }

    @Override // android.view.animation.Animation
    public final void initialize(int i, int i2, int i3, int i4) {
        super.initialize(i, i2, i3, i4);
        this._e = new Camera();
    }
}

package com.zj.adlib;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.RectF;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.airbnb.lottie.LottieDrawable;
import com.airbnb.lottie.LottieProperty;
import com.airbnb.lottie.animation.keyframe.BaseKeyframeAnimation;
import com.airbnb.lottie.model.layer.BaseLayer;
import com.airbnb.lottie.model.layer.Layer;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public class d74 extends BaseLayer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Rect f41115a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @Nullable
    public BaseKeyframeAnimation<ColorFilter, ColorFilter> f15930a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @Nullable
    public final b45 f15931a;
    public final Rect b;

    /* JADX INFO: renamed from: b, reason: collision with other field name */
    @Nullable
    public BaseKeyframeAnimation<Bitmap, Bitmap> f15932b;
    public final Paint g;

    public d74(LottieDrawable lottieDrawable, Layer layer) {
        super(lottieDrawable, layer);
        this.g = new zt4(3);
        this.f41115a = new Rect();
        this.b = new Rect();
        this.f15931a = lottieDrawable.T(layer.m());
    }

    @Nullable
    public final Bitmap O() {
        Bitmap bitmapF;
        BaseKeyframeAnimation<Bitmap, Bitmap> baseKeyframeAnimation = this.f15932b;
        if (baseKeyframeAnimation != null && (bitmapF = baseKeyframeAnimation.f()) != null) {
            return bitmapF;
        }
        Bitmap bitmapL = ((BaseLayer) this).f534a.L(((BaseLayer) this).f538a.m());
        if (bitmapL != null) {
            return bitmapL;
        }
        b45 b45Var = this.f15931a;
        if (b45Var != null) {
            return b45Var.a();
        }
        return null;
    }

    @Override // com.airbnb.lottie.model.layer.BaseLayer, com.airbnb.lottie.animation.content.DrawingContent
    public void a(RectF rectF, Matrix matrix, boolean z) {
        super.a(rectF, matrix, z);
        if (this.f15931a != null) {
            float fE = vj9.e();
            rectF.set(0.0f, 0.0f, this.f15931a.f() * fE, this.f15931a.d() * fE);
            ((BaseLayer) this).f549c.mapRect(rectF);
        }
    }

    @Override // com.airbnb.lottie.model.layer.BaseLayer, com.airbnb.lottie.model.KeyPathElement
    public <T> void i(T t, @Nullable j45<T> j45Var) {
        super.i(t, j45Var);
        if (t == LottieProperty.f343a) {
            if (j45Var == null) {
                this.f15930a = null;
                return;
            } else {
                this.f15930a = new ul9(j45Var);
                return;
            }
        }
        if (t == LottieProperty.f23325a) {
            if (j45Var == null) {
                this.f15932b = null;
            } else {
                this.f15932b = new ul9(j45Var);
            }
        }
    }

    @Override // com.airbnb.lottie.model.layer.BaseLayer
    public void u(@NonNull Canvas canvas, Matrix matrix, int i) {
        Bitmap bitmapO = O();
        if (bitmapO == null || bitmapO.isRecycled() || this.f15931a == null) {
            return;
        }
        float fE = vj9.e();
        this.g.setAlpha(i);
        BaseKeyframeAnimation<ColorFilter, ColorFilter> baseKeyframeAnimation = this.f15930a;
        if (baseKeyframeAnimation != null) {
            this.g.setColorFilter(baseKeyframeAnimation.f());
        }
        canvas.save();
        canvas.concat(matrix);
        this.f41115a.set(0, 0, bitmapO.getWidth(), bitmapO.getHeight());
        if (((BaseLayer) this).f534a.U()) {
            this.b.set(0, 0, (int) (this.f15931a.f() * fE), (int) (this.f15931a.d() * fE));
        } else {
            this.b.set(0, 0, (int) (bitmapO.getWidth() * fE), (int) (bitmapO.getHeight() * fE));
        }
        canvas.drawBitmap(bitmapO, this.f41115a, this.b, this.g);
        canvas.restore();
    }
}

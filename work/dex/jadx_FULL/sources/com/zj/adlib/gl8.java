package com.zj.adlib;

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.ColorFilter;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.RectF;
import androidx.annotation.Nullable;
import com.airbnb.lottie.LottieDrawable;
import com.airbnb.lottie.LottieProperty;
import com.airbnb.lottie.animation.keyframe.BaseKeyframeAnimation;
import com.airbnb.lottie.model.layer.BaseLayer;
import com.airbnb.lottie.model.layer.Layer;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public class gl8 extends BaseLayer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @Nullable
    public BaseKeyframeAnimation<ColorFilter, ColorFilter> f41935a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final float[] f16818a;
    public final Path b;

    /* JADX INFO: renamed from: b, reason: collision with other field name */
    public final Layer f16819b;
    public final RectF f;
    public final Paint g;

    public gl8(LottieDrawable lottieDrawable, Layer layer) {
        super(lottieDrawable, layer);
        this.f = new RectF();
        zt4 zt4Var = new zt4();
        this.g = zt4Var;
        this.f16818a = new float[8];
        this.b = new Path();
        this.f16819b = layer;
        zt4Var.setAlpha(0);
        zt4Var.setStyle(Paint.Style.FILL);
        zt4Var.setColor(layer.o());
    }

    @Override // com.airbnb.lottie.model.layer.BaseLayer, com.airbnb.lottie.animation.content.DrawingContent
    public void a(RectF rectF, Matrix matrix, boolean z) {
        super.a(rectF, matrix, z);
        this.f.set(0.0f, 0.0f, this.f16819b.q(), this.f16819b.p());
        ((BaseLayer) this).f549c.mapRect(this.f);
        rectF.set(this.f);
    }

    @Override // com.airbnb.lottie.model.layer.BaseLayer, com.airbnb.lottie.model.KeyPathElement
    public <T> void i(T t, @Nullable j45<T> j45Var) {
        super.i(t, j45Var);
        if (t == LottieProperty.f343a) {
            if (j45Var == null) {
                this.f41935a = null;
            } else {
                this.f41935a = new ul9(j45Var);
            }
        }
    }

    @Override // com.airbnb.lottie.model.layer.BaseLayer
    public void u(Canvas canvas, Matrix matrix, int i) {
        int iAlpha = Color.alpha(this.f16819b.o());
        if (iAlpha == 0) {
            return;
        }
        int iIntValue = (int) ((i / 255.0f) * (((iAlpha / 255.0f) * (((BaseLayer) this).f536a.h() == null ? 100 : ((BaseLayer) this).f536a.h().f().intValue())) / 100.0f) * 255.0f);
        this.g.setAlpha(iIntValue);
        BaseKeyframeAnimation<ColorFilter, ColorFilter> baseKeyframeAnimation = this.f41935a;
        if (baseKeyframeAnimation != null) {
            this.g.setColorFilter(baseKeyframeAnimation.f());
        }
        if (iIntValue > 0) {
            float[] fArr = this.f16818a;
            fArr[0] = 0.0f;
            fArr[1] = 0.0f;
            fArr[2] = this.f16819b.q();
            float[] fArr2 = this.f16818a;
            fArr2[3] = 0.0f;
            fArr2[4] = this.f16819b.q();
            this.f16818a[5] = this.f16819b.p();
            float[] fArr3 = this.f16818a;
            fArr3[6] = 0.0f;
            fArr3[7] = this.f16819b.p();
            matrix.mapPoints(this.f16818a);
            this.b.reset();
            Path path = this.b;
            float[] fArr4 = this.f16818a;
            path.moveTo(fArr4[0], fArr4[1]);
            Path path2 = this.b;
            float[] fArr5 = this.f16818a;
            path2.lineTo(fArr5[2], fArr5[3]);
            Path path3 = this.b;
            float[] fArr6 = this.f16818a;
            path3.lineTo(fArr6[4], fArr6[5]);
            Path path4 = this.b;
            float[] fArr7 = this.f16818a;
            path4.lineTo(fArr7[6], fArr7[7]);
            Path path5 = this.b;
            float[] fArr8 = this.f16818a;
            path5.lineTo(fArr8[0], fArr8[1]);
            this.b.close();
            canvas.drawPath(this.b, this.g);
        }
    }
}

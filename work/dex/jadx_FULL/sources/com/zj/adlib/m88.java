package com.zj.adlib;

import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.RectF;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.airbnb.lottie.LottieDrawable;
import com.airbnb.lottie.animation.content.a;
import com.airbnb.lottie.model.layer.BaseLayer;
import com.airbnb.lottie.model.layer.Layer;
import java.util.Collections;
import java.util.List;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public class m88 extends BaseLayer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final a f43246a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final com.airbnb.lottie.model.layer.a f18152a;

    public m88(LottieDrawable lottieDrawable, Layer layer, com.airbnb.lottie.model.layer.a aVar) {
        super(lottieDrawable, layer);
        this.f18152a = aVar;
        a aVar2 = new a(lottieDrawable, this, new j88("__container", layer.n(), false));
        this.f43246a = aVar2;
        aVar2.c(Collections.emptyList(), Collections.emptyList());
    }

    @Override // com.airbnb.lottie.model.layer.BaseLayer, com.airbnb.lottie.animation.content.DrawingContent
    public void a(RectF rectF, Matrix matrix, boolean z) {
        super.a(rectF, matrix, z);
        this.f43246a.a(rectF, ((BaseLayer) this).f549c, z);
    }

    @Override // com.airbnb.lottie.model.layer.BaseLayer
    public void resolveChildKeyPath(ds4 ds4Var, int i, List<ds4> list, ds4 ds4Var2) {
        this.f43246a.g(ds4Var, i, list, ds4Var2);
    }

    @Override // com.airbnb.lottie.model.layer.BaseLayer
    public void u(@NonNull Canvas canvas, Matrix matrix, int i) {
        this.f43246a.b(canvas, matrix, i);
    }

    @Override // com.airbnb.lottie.model.layer.BaseLayer
    @Nullable
    public sy0 w() {
        sy0 sy0VarW = super.w();
        return sy0VarW != null ? sy0VarW : this.f18152a.w();
    }

    @Override // com.airbnb.lottie.model.layer.BaseLayer
    @Nullable
    public hs2 y() {
        hs2 hs2VarY = super.y();
        return hs2VarY != null ? hs2VarY : this.f18152a.y();
    }
}

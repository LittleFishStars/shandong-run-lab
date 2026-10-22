package com.zj.adlib;

import android.graphics.PointF;
import com.airbnb.lottie.LottieDrawable;
import com.airbnb.lottie.animation.content.Content;
import com.airbnb.lottie.animation.content.b;
import com.airbnb.lottie.model.animatable.AnimatableValue;
import com.airbnb.lottie.model.animatable.e;
import com.airbnb.lottie.model.content.ContentModel;
import com.airbnb.lottie.model.layer.BaseLayer;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public class hl1 implements ContentModel {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final AnimatableValue<PointF, PointF> f42150a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final e f17012a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final String f17013a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final boolean f17014a;
    public final boolean b;

    public hl1(String str, AnimatableValue<PointF, PointF> animatableValue, e eVar, boolean z, boolean z2) {
        this.f17013a = str;
        this.f42150a = animatableValue;
        this.f17012a = eVar;
        this.f17014a = z;
        this.b = z2;
    }

    @Override // com.airbnb.lottie.model.content.ContentModel
    public Content a(LottieDrawable lottieDrawable, BaseLayer baseLayer) {
        return new b(lottieDrawable, baseLayer, this);
    }

    public String b() {
        return this.f17013a;
    }

    public AnimatableValue<PointF, PointF> c() {
        return this.f42150a;
    }

    public e d() {
        return this.f17012a;
    }

    public boolean e() {
        return this.b;
    }

    public boolean f() {
        return this.f17014a;
    }
}

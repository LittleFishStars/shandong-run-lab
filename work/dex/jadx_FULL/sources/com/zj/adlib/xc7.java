package com.zj.adlib;

import android.graphics.PointF;
import com.airbnb.lottie.LottieDrawable;
import com.airbnb.lottie.animation.content.Content;
import com.airbnb.lottie.animation.content.g;
import com.airbnb.lottie.model.animatable.AnimatableValue;
import com.airbnb.lottie.model.animatable.b;
import com.airbnb.lottie.model.content.ContentModel;
import com.airbnb.lottie.model.layer.BaseLayer;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public class xc7 implements ContentModel {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final AnimatableValue<PointF, PointF> f45793a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final b f20632a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final String f20633a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final boolean f20634a;
    public final AnimatableValue<PointF, PointF> b;

    public xc7(String str, AnimatableValue<PointF, PointF> animatableValue, AnimatableValue<PointF, PointF> animatableValue2, b bVar, boolean z) {
        this.f20633a = str;
        this.f45793a = animatableValue;
        this.b = animatableValue2;
        this.f20632a = bVar;
        this.f20634a = z;
    }

    @Override // com.airbnb.lottie.model.content.ContentModel
    public Content a(LottieDrawable lottieDrawable, BaseLayer baseLayer) {
        return new g(lottieDrawable, baseLayer, this);
    }

    public b b() {
        return this.f20632a;
    }

    public String c() {
        return this.f20633a;
    }

    public AnimatableValue<PointF, PointF> d() {
        return this.f45793a;
    }

    public AnimatableValue<PointF, PointF> e() {
        return this.b;
    }

    public boolean f() {
        return this.f20634a;
    }

    public String toString() {
        return "RectangleShape{position=" + this.f45793a + ", size=" + this.b + '}';
    }
}

package com.zj.adlib;

import androidx.annotation.Nullable;
import com.airbnb.lottie.LottieDrawable;
import com.airbnb.lottie.animation.content.Content;
import com.airbnb.lottie.model.animatable.AnimatableValue;
import com.airbnb.lottie.model.content.ContentModel;
import com.airbnb.lottie.model.layer.BaseLayer;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public class qj7 implements ContentModel {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final AnimatableValue<Float, Float> f44222a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final String f19117a;

    public qj7(String str, AnimatableValue<Float, Float> animatableValue) {
        this.f19117a = str;
        this.f44222a = animatableValue;
    }

    @Override // com.airbnb.lottie.model.content.ContentModel
    @Nullable
    public Content a(LottieDrawable lottieDrawable, BaseLayer baseLayer) {
        return new rj7(lottieDrawable, baseLayer, this);
    }

    public AnimatableValue<Float, Float> b() {
        return this.f44222a;
    }

    public String c() {
        return this.f19117a;
    }
}

package com.zj.adlib;

import androidx.annotation.Nullable;
import com.airbnb.lottie.LottieDrawable;
import com.airbnb.lottie.animation.content.Content;
import com.airbnb.lottie.animation.content.h;
import com.airbnb.lottie.model.animatable.b;
import com.airbnb.lottie.model.content.ContentModel;
import com.airbnb.lottie.model.layer.BaseLayer;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public class we7 implements ContentModel {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final b f45582a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final m60 f20426a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final String f20427a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final boolean f20428a;
    public final b b;

    public we7(String str, b bVar, b bVar2, m60 m60Var, boolean z) {
        this.f20427a = str;
        this.f45582a = bVar;
        this.b = bVar2;
        this.f20426a = m60Var;
        this.f20428a = z;
    }

    @Override // com.airbnb.lottie.model.content.ContentModel
    @Nullable
    public Content a(LottieDrawable lottieDrawable, BaseLayer baseLayer) {
        return new h(lottieDrawable, baseLayer, this);
    }

    public b b() {
        return this.f45582a;
    }

    public String c() {
        return this.f20427a;
    }

    public b d() {
        return this.b;
    }

    public m60 e() {
        return this.f20426a;
    }

    public boolean f() {
        return this.f20428a;
    }
}

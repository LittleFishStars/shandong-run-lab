package com.zj.adlib;

import com.airbnb.lottie.LottieDrawable;
import com.airbnb.lottie.animation.content.Content;
import com.airbnb.lottie.animation.content.i;
import com.airbnb.lottie.model.animatable.g;
import com.airbnb.lottie.model.content.ContentModel;
import com.airbnb.lottie.model.layer.BaseLayer;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public class n88 implements ContentModel {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f43472a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final g f18370a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final String f18371a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final boolean f18372a;

    public n88(String str, int i, g gVar, boolean z) {
        this.f18371a = str;
        this.f43472a = i;
        this.f18370a = gVar;
        this.f18372a = z;
    }

    @Override // com.airbnb.lottie.model.content.ContentModel
    public Content a(LottieDrawable lottieDrawable, BaseLayer baseLayer) {
        return new i(lottieDrawable, baseLayer, this);
    }

    public String b() {
        return this.f18371a;
    }

    public g c() {
        return this.f18370a;
    }

    public boolean d() {
        return this.f18372a;
    }

    public String toString() {
        return "ShapePath{name=" + this.f18371a + ", index=" + this.f43472a + '}';
    }
}

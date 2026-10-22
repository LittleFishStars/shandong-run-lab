package com.zj.adlib;

import com.airbnb.lottie.LottieDrawable;
import com.airbnb.lottie.animation.content.Content;
import com.airbnb.lottie.animation.content.a;
import com.airbnb.lottie.model.content.ContentModel;
import com.airbnb.lottie.model.layer.BaseLayer;
import java.util.Arrays;
import java.util.List;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public class j88 implements ContentModel {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f42530a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final List<ContentModel> f17342a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final boolean f17343a;

    public j88(String str, List<ContentModel> list, boolean z) {
        this.f42530a = str;
        this.f17342a = list;
        this.f17343a = z;
    }

    @Override // com.airbnb.lottie.model.content.ContentModel
    public Content a(LottieDrawable lottieDrawable, BaseLayer baseLayer) {
        return new a(lottieDrawable, baseLayer, this);
    }

    public List<ContentModel> b() {
        return this.f17342a;
    }

    public String c() {
        return this.f42530a;
    }

    public boolean d() {
        return this.f17343a;
    }

    public String toString() {
        return "ShapeGroup{name='" + this.f42530a + "' Shapes: " + Arrays.toString(this.f17342a.toArray()) + '}';
    }
}

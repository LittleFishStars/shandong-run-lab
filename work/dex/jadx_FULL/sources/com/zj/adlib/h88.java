package com.zj.adlib;

import android.graphics.Path;
import androidx.annotation.Nullable;
import com.airbnb.lottie.LottieDrawable;
import com.airbnb.lottie.animation.content.Content;
import com.airbnb.lottie.animation.content.c;
import com.airbnb.lottie.model.animatable.a;
import com.airbnb.lottie.model.animatable.d;
import com.airbnb.lottie.model.content.ContentModel;
import com.airbnb.lottie.model.layer.BaseLayer;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public class h88 implements ContentModel {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Path.FillType f42072a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @Nullable
    public final a f16945a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @Nullable
    public final d f16946a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final String f16947a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final boolean f16948a;
    public final boolean b;

    public h88(String str, boolean z, Path.FillType fillType, @Nullable a aVar, @Nullable d dVar, boolean z2) {
        this.f16947a = str;
        this.f16948a = z;
        this.f42072a = fillType;
        this.f16945a = aVar;
        this.f16946a = dVar;
        this.b = z2;
    }

    @Override // com.airbnb.lottie.model.content.ContentModel
    public Content a(LottieDrawable lottieDrawable, BaseLayer baseLayer) {
        return new c(lottieDrawable, baseLayer, this);
    }

    @Nullable
    public a b() {
        return this.f16945a;
    }

    public Path.FillType c() {
        return this.f42072a;
    }

    public String d() {
        return this.f16947a;
    }

    @Nullable
    public d e() {
        return this.f16946a;
    }

    public boolean f() {
        return this.b;
    }

    public String toString() {
        return "ShapeFill{color=, fillEnabled=" + this.f16948a + '}';
    }
}

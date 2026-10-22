package com.zj.adlib;

import android.graphics.Path;
import androidx.annotation.Nullable;
import com.airbnb.lottie.LottieDrawable;
import com.airbnb.lottie.animation.content.Content;
import com.airbnb.lottie.model.animatable.b;
import com.airbnb.lottie.model.animatable.c;
import com.airbnb.lottie.model.animatable.d;
import com.airbnb.lottie.model.animatable.e;
import com.airbnb.lottie.model.content.ContentModel;
import com.airbnb.lottie.model.content.GradientType;
import com.airbnb.lottie.model.layer.BaseLayer;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public class dw3 implements ContentModel {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Path.FillType f41292a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @Nullable
    public final b f16151a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final c f16152a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final d f16153a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final e f16154a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final GradientType f16155a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final String f16156a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final boolean f16157a;

    @Nullable
    public final b b;

    /* JADX INFO: renamed from: b, reason: collision with other field name */
    public final e f16158b;

    public dw3(String str, GradientType gradientType, Path.FillType fillType, c cVar, d dVar, e eVar, e eVar2, b bVar, b bVar2, boolean z) {
        this.f16155a = gradientType;
        this.f41292a = fillType;
        this.f16152a = cVar;
        this.f16153a = dVar;
        this.f16154a = eVar;
        this.f16158b = eVar2;
        this.f16156a = str;
        this.f16151a = bVar;
        this.b = bVar2;
        this.f16157a = z;
    }

    @Override // com.airbnb.lottie.model.content.ContentModel
    public Content a(LottieDrawable lottieDrawable, BaseLayer baseLayer) {
        return new com.airbnb.lottie.animation.content.d(lottieDrawable, baseLayer, this);
    }

    public e b() {
        return this.f16158b;
    }

    public Path.FillType c() {
        return this.f41292a;
    }

    public c d() {
        return this.f16152a;
    }

    public GradientType e() {
        return this.f16155a;
    }

    public String f() {
        return this.f16156a;
    }

    public d g() {
        return this.f16153a;
    }

    public e h() {
        return this.f16154a;
    }

    public boolean i() {
        return this.f16157a;
    }
}

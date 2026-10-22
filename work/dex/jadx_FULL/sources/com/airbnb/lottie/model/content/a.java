package com.airbnb.lottie.model.content;

import androidx.annotation.Nullable;
import com.airbnb.lottie.LottieDrawable;
import com.airbnb.lottie.animation.content.Content;
import com.airbnb.lottie.model.animatable.b;
import com.airbnb.lottie.model.animatable.c;
import com.airbnb.lottie.model.animatable.d;
import com.airbnb.lottie.model.animatable.e;
import com.airbnb.lottie.model.layer.BaseLayer;
import com.zj.adlib.gw3;
import java.util.List;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public class a implements ContentModel {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final float f23375a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final b f517a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final c f518a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final d f519a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final e f520a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final GradientType f521a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final ShapeStroke.LineCapType f522a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final ShapeStroke.LineJoinType f523a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final String f524a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final List<b> f525a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final boolean f526a;

    @Nullable
    public final b b;

    /* JADX INFO: renamed from: b, reason: collision with other field name */
    public final e f527b;

    public a(String str, GradientType gradientType, c cVar, d dVar, e eVar, e eVar2, b bVar, ShapeStroke.LineCapType lineCapType, ShapeStroke.LineJoinType lineJoinType, float f, List<b> list, @Nullable b bVar2, boolean z) {
        this.f524a = str;
        this.f521a = gradientType;
        this.f518a = cVar;
        this.f519a = dVar;
        this.f520a = eVar;
        this.f527b = eVar2;
        this.f517a = bVar;
        this.f522a = lineCapType;
        this.f523a = lineJoinType;
        this.f23375a = f;
        this.f525a = list;
        this.b = bVar2;
        this.f526a = z;
    }

    @Override // com.airbnb.lottie.model.content.ContentModel
    public Content a(LottieDrawable lottieDrawable, BaseLayer baseLayer) {
        return new gw3(lottieDrawable, baseLayer, this);
    }

    public ShapeStroke.LineCapType b() {
        return this.f522a;
    }

    @Nullable
    public b c() {
        return this.b;
    }

    public e d() {
        return this.f527b;
    }

    public c e() {
        return this.f518a;
    }

    public GradientType f() {
        return this.f521a;
    }

    public ShapeStroke.LineJoinType g() {
        return this.f523a;
    }

    public List<b> h() {
        return this.f525a;
    }

    public float i() {
        return this.f23375a;
    }

    public String j() {
        return this.f524a;
    }

    public d k() {
        return this.f519a;
    }

    public e l() {
        return this.f520a;
    }

    public b m() {
        return this.f517a;
    }

    public boolean n() {
        return this.f526a;
    }
}

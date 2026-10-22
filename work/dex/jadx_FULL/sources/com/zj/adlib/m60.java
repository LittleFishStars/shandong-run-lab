package com.zj.adlib;

import android.graphics.PointF;
import androidx.annotation.Nullable;
import com.airbnb.lottie.LottieDrawable;
import com.airbnb.lottie.animation.content.Content;
import com.airbnb.lottie.animation.content.ModifierContent;
import com.airbnb.lottie.animation.keyframe.k;
import com.airbnb.lottie.model.animatable.AnimatableValue;
import com.airbnb.lottie.model.animatable.b;
import com.airbnb.lottie.model.animatable.d;
import com.airbnb.lottie.model.animatable.f;
import com.airbnb.lottie.model.content.ContentModel;
import com.airbnb.lottie.model.layer.BaseLayer;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public class m60 implements ModifierContent, ContentModel {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @Nullable
    public final AnimatableValue<PointF, PointF> f43228a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @Nullable
    public final b f18136a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @Nullable
    public final d f18137a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @Nullable
    public final f f18138a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @Nullable
    public final h60 f18139a;

    @Nullable
    public final b b;

    @Nullable
    public final b c;

    @Nullable
    public final b d;

    @Nullable
    public final b e;

    public m60() {
        this(null, null, null, null, null, null, null, null, null);
    }

    @Override // com.airbnb.lottie.model.content.ContentModel
    @Nullable
    public Content a(LottieDrawable lottieDrawable, BaseLayer baseLayer) {
        return null;
    }

    public k b() {
        return new k(this);
    }

    @Nullable
    public h60 c() {
        return this.f18139a;
    }

    @Nullable
    public b d() {
        return this.e;
    }

    @Nullable
    public d e() {
        return this.f18137a;
    }

    @Nullable
    public AnimatableValue<PointF, PointF> f() {
        return this.f43228a;
    }

    @Nullable
    public b g() {
        return this.f18136a;
    }

    @Nullable
    public f h() {
        return this.f18138a;
    }

    @Nullable
    public b i() {
        return this.b;
    }

    @Nullable
    public b j() {
        return this.c;
    }

    @Nullable
    public b k() {
        return this.d;
    }

    public m60(@Nullable h60 h60Var, @Nullable AnimatableValue<PointF, PointF> animatableValue, @Nullable f fVar, @Nullable b bVar, @Nullable d dVar, @Nullable b bVar2, @Nullable b bVar3, @Nullable b bVar4, @Nullable b bVar5) {
        this.f18139a = h60Var;
        this.f43228a = animatableValue;
        this.f18138a = fVar;
        this.f18136a = bVar;
        this.f18137a = dVar;
        this.d = bVar2;
        this.e = bVar3;
        this.b = bVar4;
        this.c = bVar5;
    }
}

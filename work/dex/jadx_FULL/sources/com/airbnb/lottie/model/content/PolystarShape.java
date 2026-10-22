package com.airbnb.lottie.model.content;

import android.graphics.PointF;
import com.airbnb.lottie.LottieDrawable;
import com.airbnb.lottie.animation.content.Content;
import com.airbnb.lottie.animation.content.f;
import com.airbnb.lottie.model.animatable.AnimatableValue;
import com.airbnb.lottie.model.animatable.b;
import com.airbnb.lottie.model.layer.BaseLayer;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public class PolystarShape implements ContentModel {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final AnimatableValue<PointF, PointF> f23371a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final b f501a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final Type f502a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final String f503a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final boolean f504a;
    public final b b;

    /* JADX INFO: renamed from: b, reason: collision with other field name */
    public final boolean f505b;
    public final b c;
    public final b d;
    public final b e;
    public final b f;

    public enum Type {
        STAR(1),
        POLYGON(2);

        private final int value;

        Type(int i) {
            this.value = i;
        }

        public static Type forValue(int i) {
            for (Type type : values()) {
                if (type.value == i) {
                    return type;
                }
            }
            return null;
        }
    }

    public PolystarShape(String str, Type type, b bVar, AnimatableValue<PointF, PointF> animatableValue, b bVar2, b bVar3, b bVar4, b bVar5, b bVar6, boolean z, boolean z2) {
        this.f503a = str;
        this.f502a = type;
        this.f501a = bVar;
        this.f23371a = animatableValue;
        this.b = bVar2;
        this.c = bVar3;
        this.d = bVar4;
        this.e = bVar5;
        this.f = bVar6;
        this.f504a = z;
        this.f505b = z2;
    }

    @Override // com.airbnb.lottie.model.content.ContentModel
    public Content a(LottieDrawable lottieDrawable, BaseLayer baseLayer) {
        return new f(lottieDrawable, baseLayer, this);
    }

    public b b() {
        return this.c;
    }

    public b c() {
        return this.e;
    }

    public String d() {
        return this.f503a;
    }

    public b e() {
        return this.d;
    }

    public b f() {
        return this.f;
    }

    public b g() {
        return this.f501a;
    }

    public Type getType() {
        return this.f502a;
    }

    public AnimatableValue<PointF, PointF> h() {
        return this.f23371a;
    }

    public b i() {
        return this.b;
    }

    public boolean j() {
        return this.f504a;
    }

    public boolean k() {
        return this.f505b;
    }
}

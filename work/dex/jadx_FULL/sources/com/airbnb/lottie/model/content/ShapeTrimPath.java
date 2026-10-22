package com.airbnb.lottie.model.content;

import com.airbnb.lottie.LottieDrawable;
import com.airbnb.lottie.animation.content.Content;
import com.airbnb.lottie.model.animatable.b;
import com.airbnb.lottie.model.layer.BaseLayer;
import com.zj.adlib.yc9;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public class ShapeTrimPath implements ContentModel {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final b f23374a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final Type f514a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final String f515a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final boolean f516a;
    public final b b;
    public final b c;

    public enum Type {
        SIMULTANEOUSLY,
        INDIVIDUALLY;

        public static Type forId(int i) {
            if (i == 1) {
                return SIMULTANEOUSLY;
            }
            if (i == 2) {
                return INDIVIDUALLY;
            }
            throw new IllegalArgumentException("Unknown trim path type " + i);
        }
    }

    public ShapeTrimPath(String str, Type type, b bVar, b bVar2, b bVar3, boolean z) {
        this.f515a = str;
        this.f514a = type;
        this.f23374a = bVar;
        this.b = bVar2;
        this.c = bVar3;
        this.f516a = z;
    }

    @Override // com.airbnb.lottie.model.content.ContentModel
    public Content a(LottieDrawable lottieDrawable, BaseLayer baseLayer) {
        return new yc9(baseLayer, this);
    }

    public b b() {
        return this.b;
    }

    public String c() {
        return this.f515a;
    }

    public b d() {
        return this.c;
    }

    public b e() {
        return this.f23374a;
    }

    public boolean f() {
        return this.f516a;
    }

    public Type getType() {
        return this.f514a;
    }

    public String toString() {
        return "Trim Path: {start: " + this.f23374a + ", end: " + this.b + ", offset: " + this.c + "}";
    }
}

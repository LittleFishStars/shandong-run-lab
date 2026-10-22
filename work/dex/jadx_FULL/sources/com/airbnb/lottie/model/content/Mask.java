package com.airbnb.lottie.model.content;

import com.airbnb.lottie.model.animatable.d;
import com.airbnb.lottie.model.animatable.g;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public class Mask {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final d f23369a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final g f496a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final MaskMode f497a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final boolean f498a;

    public enum MaskMode {
        MASK_MODE_ADD,
        MASK_MODE_SUBTRACT,
        MASK_MODE_INTERSECT,
        MASK_MODE_NONE
    }

    public Mask(MaskMode maskMode, g gVar, d dVar, boolean z) {
        this.f497a = maskMode;
        this.f496a = gVar;
        this.f23369a = dVar;
        this.f498a = z;
    }

    public MaskMode a() {
        return this.f497a;
    }

    public g b() {
        return this.f496a;
    }

    public d c() {
        return this.f23369a;
    }

    public boolean d() {
        return this.f498a;
    }
}

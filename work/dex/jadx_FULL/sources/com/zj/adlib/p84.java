package com.zj.adlib;

import com.facebook.imagepipeline.image.QualityInfo;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_08_10593cls.dex */
public class p84 implements QualityInfo {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final QualityInfo f43926a = d(Integer.MAX_VALUE, true, true);

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public int f18805a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public boolean f18806a;
    public boolean b;

    public p84(int i, boolean z, boolean z2) {
        this.f18805a = i;
        this.f18806a = z;
        this.b = z2;
    }

    public static QualityInfo d(int i, boolean z, boolean z2) {
        return new p84(i, z, z2);
    }

    @Override // com.facebook.imagepipeline.image.QualityInfo
    public boolean a() {
        return this.f18806a;
    }

    @Override // com.facebook.imagepipeline.image.QualityInfo
    public int b() {
        return this.f18805a;
    }

    @Override // com.facebook.imagepipeline.image.QualityInfo
    public boolean c() {
        return this.b;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof p84)) {
            return false;
        }
        p84 p84Var = (p84) obj;
        return this.f18805a == p84Var.f18805a && this.f18806a == p84Var.f18806a && this.b == p84Var.b;
    }

    public int hashCode() {
        return (this.f18805a ^ (this.f18806a ? 4194304 : 0)) ^ (this.b ? 8388608 : 0);
    }
}

package com.zj.adlib;

import com.google.android.gms.internal.mlkit_vision_common.zzme;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_08_10593cls.dex */
public final class eed extends zzme {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f41419a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final String f16300a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final boolean f16301a;

    public /* synthetic */ eed(String str, boolean z, int i, tdd tddVar) {
        this.f16300a = str;
        this.f16301a = z;
        this.f41419a = i;
    }

    @Override // com.google.android.gms.internal.mlkit_vision_common.zzme
    public final int a() {
        return this.f41419a;
    }

    @Override // com.google.android.gms.internal.mlkit_vision_common.zzme
    public final String b() {
        return this.f16300a;
    }

    @Override // com.google.android.gms.internal.mlkit_vision_common.zzme
    public final boolean c() {
        return this.f16301a;
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof zzme) {
            zzme zzmeVar = (zzme) obj;
            if (this.f16300a.equals(zzmeVar.b()) && this.f16301a == zzmeVar.c() && this.f41419a == zzmeVar.a()) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        return ((((this.f16300a.hashCode() ^ 1000003) * 1000003) ^ (true != this.f16301a ? 1237 : 1231)) * 1000003) ^ this.f41419a;
    }

    public final String toString() {
        return "MLKitLoggingOptions{libraryName=" + this.f16300a + ", enableFirelog=" + this.f16301a + ", firelogEventType=" + this.f41419a + "}";
    }
}

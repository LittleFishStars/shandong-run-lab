package com.zj.adlib;

import com.google.android.gms.internal.mlkit_common.zzpt;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_08_10593cls.dex */
public final class nmd extends zzpt {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f43563a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final String f18466a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final boolean f18467a;

    public /* synthetic */ nmd(String str, boolean z, int i, lmd lmdVar) {
        this.f18466a = str;
        this.f18467a = z;
        this.f43563a = i;
    }

    @Override // com.google.android.gms.internal.mlkit_common.zzpt
    public final int a() {
        return this.f43563a;
    }

    @Override // com.google.android.gms.internal.mlkit_common.zzpt
    public final String b() {
        return this.f18466a;
    }

    @Override // com.google.android.gms.internal.mlkit_common.zzpt
    public final boolean c() {
        return this.f18467a;
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof zzpt) {
            zzpt zzptVar = (zzpt) obj;
            if (this.f18466a.equals(zzptVar.b()) && this.f18467a == zzptVar.c() && this.f43563a == zzptVar.a()) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        return ((((this.f18466a.hashCode() ^ 1000003) * 1000003) ^ (true != this.f18467a ? 1237 : 1231)) * 1000003) ^ this.f43563a;
    }

    public final String toString() {
        return "MLKitLoggingOptions{libraryName=" + this.f18466a + ", enableFirelog=" + this.f18467a + ", firelogEventType=" + this.f43563a + "}";
    }
}

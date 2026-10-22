package com.zj.adlib;

import com.google.android.gms.internal.mlkit_vision_barcode.zztp;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_08_10593cls.dex */
public final class esd extends zztp {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f41520a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final String f16402a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final boolean f16403a;

    public /* synthetic */ esd(String str, boolean z, int i, dsd dsdVar) {
        this.f16402a = str;
        this.f16403a = z;
        this.f41520a = i;
    }

    @Override // com.google.android.gms.internal.mlkit_vision_barcode.zztp
    public final int a() {
        return this.f41520a;
    }

    @Override // com.google.android.gms.internal.mlkit_vision_barcode.zztp
    public final String b() {
        return this.f16402a;
    }

    @Override // com.google.android.gms.internal.mlkit_vision_barcode.zztp
    public final boolean c() {
        return this.f16403a;
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof zztp) {
            zztp zztpVar = (zztp) obj;
            if (this.f16402a.equals(zztpVar.b()) && this.f16403a == zztpVar.c() && this.f41520a == zztpVar.a()) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        return ((((this.f16402a.hashCode() ^ 1000003) * 1000003) ^ (true != this.f16403a ? 1237 : 1231)) * 1000003) ^ this.f41520a;
    }

    public final String toString() {
        return "MLKitLoggingOptions{libraryName=" + this.f16402a + ", enableFirelog=" + this.f16403a + ", firelogEventType=" + this.f41520a + "}";
    }
}

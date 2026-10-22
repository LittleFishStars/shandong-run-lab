package com.google.mlkit.common.internal.model;

import com.google.android.gms.common.annotation.KeepForSdk;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_03_8012cls.dex */
public final class b extends ModelUtils.ModelLoggingInfo {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final long f32449a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final String f6617a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final boolean f6618a;

    public b(long j, String str, boolean z) {
        this.f32449a = j;
        this.f6617a = str;
        this.f6618a = z;
    }

    @Override // com.google.mlkit.common.internal.model.ModelUtils.ModelLoggingInfo
    @KeepForSdk
    public String a() {
        return this.f6617a;
    }

    @Override // com.google.mlkit.common.internal.model.ModelUtils.ModelLoggingInfo
    @KeepForSdk
    public long b() {
        return this.f32449a;
    }

    @Override // com.google.mlkit.common.internal.model.ModelUtils.ModelLoggingInfo
    @KeepForSdk
    public boolean c() {
        return this.f6618a;
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof ModelUtils.ModelLoggingInfo) {
            ModelUtils.ModelLoggingInfo modelLoggingInfo = (ModelUtils.ModelLoggingInfo) obj;
            if (this.f32449a == modelLoggingInfo.b() && this.f6617a.equals(modelLoggingInfo.a()) && this.f6618a == modelLoggingInfo.c()) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        long j = this.f32449a;
        return ((((((int) (j ^ (j >>> 32))) ^ 1000003) * 1000003) ^ this.f6617a.hashCode()) * 1000003) ^ (true != this.f6618a ? 1237 : 1231);
    }

    public final String toString() {
        return "ModelLoggingInfo{size=" + this.f32449a + ", hash=" + this.f6617a + ", manifestModel=" + this.f6618a + "}";
    }
}

package com.zj.adlib;

import com.google.android.gms.internal.mlkit_common.zzlm;
import com.google.android.gms.internal.mlkit_common.zzls;
import com.google.android.gms.internal.mlkit_common.zzqb;
import com.google.mlkit.common.sdkinternal.ModelType;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_08_10593cls.dex */
public final class tmd extends zzqb {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f44958a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final zzlm f19862a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final zzls f19863a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final ModelType f19864a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final String f19865a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final boolean f19866a;
    public final boolean b;

    public /* synthetic */ tmd(zzlm zzlmVar, String str, boolean z, boolean z2, ModelType modelType, zzls zzlsVar, int i, rmd rmdVar) {
        this.f19862a = zzlmVar;
        this.f19865a = str;
        this.f19866a = z;
        this.b = z2;
        this.f19864a = modelType;
        this.f19863a = zzlsVar;
        this.f44958a = i;
    }

    @Override // com.google.android.gms.internal.mlkit_common.zzqb
    public final int a() {
        return this.f44958a;
    }

    @Override // com.google.android.gms.internal.mlkit_common.zzqb
    public final ModelType b() {
        return this.f19864a;
    }

    @Override // com.google.android.gms.internal.mlkit_common.zzqb
    public final zzlm c() {
        return this.f19862a;
    }

    @Override // com.google.android.gms.internal.mlkit_common.zzqb
    public final zzls d() {
        return this.f19863a;
    }

    @Override // com.google.android.gms.internal.mlkit_common.zzqb
    public final String e() {
        return this.f19865a;
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof zzqb) {
            zzqb zzqbVar = (zzqb) obj;
            if (this.f19862a.equals(zzqbVar.c()) && this.f19865a.equals(zzqbVar.e()) && this.f19866a == zzqbVar.g() && this.b == zzqbVar.f() && this.f19864a.equals(zzqbVar.b()) && this.f19863a.equals(zzqbVar.d()) && this.f44958a == zzqbVar.a()) {
                return true;
            }
        }
        return false;
    }

    @Override // com.google.android.gms.internal.mlkit_common.zzqb
    public final boolean f() {
        return this.b;
    }

    @Override // com.google.android.gms.internal.mlkit_common.zzqb
    public final boolean g() {
        return this.f19866a;
    }

    public final int hashCode() {
        int iHashCode = ((this.f19862a.hashCode() ^ 1000003) * 1000003) ^ this.f19865a.hashCode();
        return (((((((((iHashCode * 1000003) ^ (true != this.f19866a ? 1237 : 1231)) * 1000003) ^ (true == this.b ? 1231 : 1237)) * 1000003) ^ this.f19864a.hashCode()) * 1000003) ^ this.f19863a.hashCode()) * 1000003) ^ this.f44958a;
    }

    public final String toString() {
        return "RemoteModelLoggingOptions{errorCode=" + this.f19862a.toString() + ", tfliteSchemaVersion=" + this.f19865a + ", shouldLogRoughDownloadTime=" + this.f19866a + ", shouldLogExactDownloadTime=" + this.b + ", modelType=" + this.f19864a.toString() + ", downloadStatus=" + this.f19863a.toString() + ", failureStatusCode=" + this.f44958a + "}";
    }
}

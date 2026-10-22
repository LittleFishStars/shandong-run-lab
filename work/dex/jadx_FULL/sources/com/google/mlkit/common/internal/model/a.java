package com.google.mlkit.common.internal.model;

import com.google.android.gms.common.annotation.KeepForSdk;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_03_8012cls.dex */
public final class a extends ModelUtils.AutoMLManifest {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f32448a;
    public final String b;
    public final String c;

    public a(String str, String str2, String str3) {
        if (str == null) {
            throw new NullPointerException("Null modelType");
        }
        this.f32448a = str;
        if (str2 == null) {
            throw new NullPointerException("Null modelFile");
        }
        this.b = str2;
        if (str3 == null) {
            throw new NullPointerException("Null labelsFile");
        }
        this.c = str3;
    }

    @Override // com.google.mlkit.common.internal.model.ModelUtils.AutoMLManifest
    @KeepForSdk
    public String a() {
        return this.c;
    }

    @Override // com.google.mlkit.common.internal.model.ModelUtils.AutoMLManifest
    @KeepForSdk
    public String b() {
        return this.b;
    }

    @Override // com.google.mlkit.common.internal.model.ModelUtils.AutoMLManifest
    @KeepForSdk
    public String c() {
        return this.f32448a;
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof ModelUtils.AutoMLManifest) {
            ModelUtils.AutoMLManifest autoMLManifest = (ModelUtils.AutoMLManifest) obj;
            if (this.f32448a.equals(autoMLManifest.c()) && this.b.equals(autoMLManifest.b()) && this.c.equals(autoMLManifest.a())) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        return ((((this.f32448a.hashCode() ^ 1000003) * 1000003) ^ this.b.hashCode()) * 1000003) ^ this.c.hashCode();
    }

    public final String toString() {
        return "AutoMLManifest{modelType=" + this.f32448a + ", modelFile=" + this.b + ", labelsFile=" + this.c + "}";
    }
}

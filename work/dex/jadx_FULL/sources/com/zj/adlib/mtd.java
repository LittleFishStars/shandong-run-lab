package com.zj.adlib;

import com.google.android.gms.internal.mlkit_vision_barcode.k0;
import com.google.android.gms.internal.mlkit_vision_barcode.zzek;
import com.google.android.gms.internal.mlkit_vision_barcode.zzpk;
import com.google.android.gms.internal.mlkit_vision_barcode.zzuv;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_08_10593cls.dex */
public final class mtd implements zzek {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ float f43381a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final /* synthetic */ k0 f18301a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final /* synthetic */ zzpk f18302a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final /* synthetic */ zzuv f18303a;
    public final /* synthetic */ float b;

    public mtd(k0 k0Var, zzpk zzpkVar, float f, zzuv zzuvVar, float f2) {
        this.f18301a = k0Var;
        this.f18302a = zzpkVar;
        this.f43381a = f;
        this.f18303a = zzuvVar;
        this.b = f2;
    }

    @Override // com.google.android.gms.internal.mlkit_vision_barcode.zzek
    public final /* bridge */ /* synthetic */ void a(Object obj) {
        Float f = (Float) obj;
        if (f.floatValue() >= 1.0f) {
            k0.g(this.f18301a, f.floatValue());
            this.f18301a.q(this.f18302a, this.f43381a, f.floatValue(), this.f18303a);
        }
        this.f18301a.f5770a.set(false);
    }

    @Override // com.google.android.gms.internal.mlkit_vision_barcode.zzek
    public final void b(Throwable th) {
        k0.f31353a.o("AutoZoom", "Unable to set zoom to " + this.b, th);
        this.f18301a.f5770a.set(false);
    }
}

package com.zj.adlib;

import androidx.annotation.NonNull;
import com.google.mlkit.vision.barcode.internal.BarcodeScannerImpl;
import com.google.mlkit.vision.barcode.internal.a;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_03_8012cls.dex */
public final class src {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final bwc f44764a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final g73 f19634a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final hq5 f19635a;

    public src(bwc bwcVar, g73 g73Var, hq5 hq5Var) {
        this.f44764a = bwcVar;
        this.f19634a = g73Var;
        this.f19635a = hq5Var;
    }

    public final BarcodeScannerImpl a() {
        return b(BarcodeScannerImpl.b);
    }

    public final BarcodeScannerImpl b(@NonNull am0 am0Var) {
        return new BarcodeScannerImpl(am0Var, (a) this.f44764a.a(am0Var), this.f19634a.a(am0Var.c()), etd.b(ebc.d()), this.f19635a);
    }
}

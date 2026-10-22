package com.zj.adlib;

import com.google.android.gms.internal.mlkit_vision_barcode.i0;
import com.google.android.gms.internal.mlkit_vision_barcode.zzek;
import com.google.android.gms.internal.mlkit_vision_barcode.zzev;
import java.util.concurrent.Executor;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_08_10593cls.dex */
public final class qmc extends xmc {
    public static zzev a(Object obj) {
        return new anc(obj);
    }

    public static void b(zzev zzevVar, zzek zzekVar, Executor executor) {
        zzevVar.b(new nmc(zzevVar, zzekVar), executor);
    }

    public static zzev c(ktd ktdVar, Executor executor) {
        i0 i0Var = new i0(ktdVar);
        i0Var.run();
        return i0Var;
    }
}

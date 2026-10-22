package com.zj.adlib;

import androidx.annotation.NonNull;
import com.google.mlkit.vision.barcode.BarcodeScanner;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_03_8012cls.dex */
public class bm0 {
    @NonNull
    public static BarcodeScanner a() {
        return ((src) hq5.c().a(src.class)).a();
    }

    @NonNull
    public static BarcodeScanner b(@NonNull am0 am0Var) {
        yw6.m(am0Var, "You must provide a valid BarcodeScannerOptions.");
        return ((src) hq5.c().a(src.class)).b(am0Var);
    }
}

package com.google.mlkit.vision.barcode.bundled.internal;

import android.content.Context;
import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.android.gms.common.util.DynamiteApi;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.dynamic.ObjectWrapper;
import com.google.android.gms.internal.mlkit_vision_barcode_bundled.zzbc;
import com.google.android.gms.internal.mlkit_vision_barcode_bundled.zzbl;
import com.google.android.gms.internal.mlkit_vision_barcode_bundled.zzbn;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_03_8012cls.dex */
@KeepForSdk
@DynamiteApi
public class ThickBarcodeScannerCreator extends zzbn {
    @Override // com.google.android.gms.internal.mlkit_vision_barcode_bundled.zzbo
    public zzbl newBarcodeScanner(IObjectWrapper iObjectWrapper, zzbc zzbcVar) {
        return new zzb((Context) ObjectWrapper.unwrap(iObjectWrapper), zzbcVar);
    }
}

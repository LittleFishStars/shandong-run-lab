package com.google.mlkit.vision.barcode.common.internal;

import android.graphics.Point;
import android.graphics.Rect;
import androidx.annotation.Nullable;
import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.mlkit.vision.barcode.common.Barcode;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_03_8012cls.dex */
@KeepForSdk
public interface BarcodeSource {
    @Nullable
    @KeepForSdk
    String a();

    @Nullable
    @KeepForSdk
    String b();

    @Nullable
    @KeepForSdk
    Barcode.h c();

    @Nullable
    @KeepForSdk
    Barcode.Phone d();

    @Nullable
    @KeepForSdk
    byte[] e();

    @Nullable
    @KeepForSdk
    Barcode.e f();

    @Nullable
    @KeepForSdk
    Barcode.b g();

    @KeepForSdk
    int getFormat();

    @Nullable
    @KeepForSdk
    Barcode.c h();

    @Nullable
    @KeepForSdk
    Rect i();

    @Nullable
    @KeepForSdk
    Barcode.WiFi j();

    @Nullable
    @KeepForSdk
    Barcode.Email k();

    @KeepForSdk
    int l();

    @Nullable
    @KeepForSdk
    Barcode.g m();

    @Nullable
    @KeepForSdk
    Barcode.d n();

    @Nullable
    @KeepForSdk
    Point[] o();
}

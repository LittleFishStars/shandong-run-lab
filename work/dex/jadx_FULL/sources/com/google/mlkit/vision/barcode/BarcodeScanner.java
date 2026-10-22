package com.google.mlkit.vision.barcode;

import androidx.annotation.NonNull;
import androidx.p002lifecycle.Lifecycle;
import androidx.p002lifecycle.OnLifecycleEvent;
import com.google.android.gms.common.api.OptionalModuleApi;
import com.google.android.gms.tasks.Task;
import com.google.android.odml.image.MlImage;
import com.google.mlkit.vision.barcode.common.Barcode;
import com.google.mlkit.vision.common.InputImage;
import com.google.mlkit.vision.interfaces.Detector;
import java.util.List;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_03_8012cls.dex */
public interface BarcodeScanner extends Detector<List<Barcode>>, OptionalModuleApi {
    @NonNull
    Task<List<Barcode>> a0(@NonNull MlImage mlImage);

    @Override // java.io.Closeable, java.lang.AutoCloseable
    @OnLifecycleEvent(Lifecycle.Event.ON_DESTROY)
    void close();

    @NonNull
    Task<List<Barcode>> x(@NonNull InputImage inputImage);
}

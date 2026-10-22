package androidx.camera.core;

import androidx.annotation.NonNull;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_13_8952cls.dex */
public interface SurfaceProcessor {
    void onInputSurface(@NonNull SurfaceRequest surfaceRequest) throws ProcessingException;

    void onOutputSurface(@NonNull SurfaceOutput surfaceOutput) throws ProcessingException;
}

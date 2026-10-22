package androidx.camera.core.impl;

import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_13_8952cls.dex */
@RequiresApi(21)
public abstract class CameraCaptureCallback {
    public void onCaptureCancelled() {
    }

    public void onCaptureCompleted(@NonNull CameraCaptureResult cameraCaptureResult) {
    }

    public void onCaptureFailed(@NonNull CameraCaptureFailure cameraCaptureFailure) {
    }
}

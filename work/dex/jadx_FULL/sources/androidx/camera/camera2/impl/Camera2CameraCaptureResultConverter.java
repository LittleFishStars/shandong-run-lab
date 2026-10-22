package androidx.camera.camera2.impl;

import android.hardware.camera2.CaptureFailure;
import android.hardware.camera2.CaptureResult;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.camera.camera2.internal.Camera2CameraCaptureFailure;
import androidx.camera.camera2.internal.Camera2CameraCaptureResult;
import androidx.camera.core.impl.CameraCaptureFailure;
import androidx.camera.core.impl.CameraCaptureResult;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_13_8952cls.dex */
@RequiresApi(21)
public final class Camera2CameraCaptureResultConverter {
    private Camera2CameraCaptureResultConverter() {
    }

    @Nullable
    public static CaptureFailure getCaptureFailure(@NonNull CameraCaptureFailure cameraCaptureFailure) {
        if (cameraCaptureFailure instanceof Camera2CameraCaptureFailure) {
            return ((Camera2CameraCaptureFailure) cameraCaptureFailure).getCaptureFailure();
        }
        return null;
    }

    @Nullable
    public static CaptureResult getCaptureResult(@Nullable CameraCaptureResult cameraCaptureResult) {
        if (cameraCaptureResult instanceof Camera2CameraCaptureResult) {
            return ((Camera2CameraCaptureResult) cameraCaptureResult).getCaptureResult();
        }
        return null;
    }
}

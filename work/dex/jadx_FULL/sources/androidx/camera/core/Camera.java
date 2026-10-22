package androidx.camera.core;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.annotation.RestrictTo;
import androidx.camera.core.impl.CameraConfig;
import androidx.camera.core.impl.CameraInternal;
import java.util.LinkedHashSet;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_13_8952cls.dex */
@RequiresApi(21)
public interface Camera {
    @NonNull
    CameraControl getCameraControl();

    @NonNull
    CameraInfo getCameraInfo();

    @NonNull
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    LinkedHashSet<CameraInternal> getCameraInternals();

    @NonNull
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    CameraConfig getExtendedConfig();

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    default boolean isUseCasesCombinationSupported(@NonNull UseCase... useCaseArr) {
        return true;
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    void setExtendedConfig(@Nullable CameraConfig cameraConfig);
}

package androidx.camera.core.impl;

import android.content.Context;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.camera.core.CameraSelector;
import androidx.camera.core.CameraUnavailableException;
import androidx.camera.core.InitializationException;
import androidx.camera.core.concurrent.CameraCoordinator;
import java.util.Set;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_13_8952cls.dex */
@RequiresApi(21)
public interface CameraFactory {

    public interface Provider {
        @NonNull
        CameraFactory newInstance(@NonNull Context context, @NonNull CameraThreadConfig cameraThreadConfig, @Nullable CameraSelector cameraSelector) throws InitializationException;
    }

    @NonNull
    Set<String> getAvailableCameraIds();

    @NonNull
    CameraInternal getCamera(@NonNull String str) throws CameraUnavailableException;

    @NonNull
    CameraCoordinator getCameraCoordinator();

    @Nullable
    Object getCameraManager();
}

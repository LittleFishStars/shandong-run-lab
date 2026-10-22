package androidx.camera.core;

import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import java.util.List;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_13_8952cls.dex */
@RequiresApi(21)
public interface CameraProvider {
    @NonNull
    List<CameraInfo> getAvailableCameraInfos();

    boolean hasCamera(@NonNull CameraSelector cameraSelector) throws CameraInfoUnavailableException;
}

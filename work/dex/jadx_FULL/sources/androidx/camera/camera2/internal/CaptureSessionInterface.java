package androidx.camera.camera2.internal;

import android.hardware.camera2.CameraDevice;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.camera.core.impl.CaptureConfig;
import androidx.camera.core.impl.DeferrableSurface;
import androidx.camera.core.impl.SessionConfig;
import com.google.common.util.concurrent.ListenableFuture;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_13_8952cls.dex */
@RequiresApi(21)
interface CaptureSessionInterface {
    void cancelIssuedCaptureRequests();

    void close();

    @NonNull
    List<CaptureConfig> getCaptureConfigs();

    @Nullable
    SessionConfig getSessionConfig();

    void issueCaptureRequests(@NonNull List<CaptureConfig> list);

    @NonNull
    ListenableFuture<Void> open(@NonNull SessionConfig sessionConfig, @NonNull CameraDevice cameraDevice, @NonNull SynchronizedCaptureSessionOpener synchronizedCaptureSessionOpener);

    @NonNull
    ListenableFuture<Void> release(boolean z);

    void setSessionConfig(@Nullable SessionConfig sessionConfig);

    void setStreamUseCaseMap(@NonNull Map<DeferrableSurface, Long> map);
}

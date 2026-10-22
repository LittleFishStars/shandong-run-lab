package androidx.camera.core.impl;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.camera.core.Camera;
import androidx.camera.core.CameraControl;
import androidx.camera.core.CameraInfo;
import androidx.camera.core.UseCase;
import com.google.common.util.concurrent.ListenableFuture;
import java.util.Collection;
import java.util.Collections;
import java.util.LinkedHashSet;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_13_8952cls.dex */
@RequiresApi(21)
public interface CameraInternal extends Camera, UseCase.StateChangeCallback {

    public enum State {
        PENDING_OPEN(false),
        OPENING(true),
        OPEN(true),
        CONFIGURED(true),
        CLOSING(true),
        CLOSED(false),
        RELEASING(true),
        RELEASED(false);

        private final boolean mHoldsCameraSlot;

        State(boolean z) {
            this.mHoldsCameraSlot = z;
        }

        public boolean holdsCameraSlot() {
            return this.mHoldsCameraSlot;
        }
    }

    void attachUseCases(@NonNull Collection<UseCase> collection);

    void close();

    void detachUseCases(@NonNull Collection<UseCase> collection);

    @Override // androidx.camera.core.Camera
    @NonNull
    default CameraControl getCameraControl() {
        return getCameraControlInternal();
    }

    @NonNull
    CameraControlInternal getCameraControlInternal();

    @Override // androidx.camera.core.Camera
    @NonNull
    default CameraInfo getCameraInfo() {
        return getCameraInfoInternal();
    }

    @NonNull
    CameraInfoInternal getCameraInfoInternal();

    @Override // androidx.camera.core.Camera
    @NonNull
    default LinkedHashSet<CameraInternal> getCameraInternals() {
        return new LinkedHashSet<>(Collections.singleton(this));
    }

    @NonNull
    Observable<State> getCameraState();

    @Override // androidx.camera.core.Camera
    @NonNull
    default CameraConfig getExtendedConfig() {
        return CameraConfigs.emptyConfig();
    }

    default boolean getHasTransform() {
        return true;
    }

    default boolean isFrontFacing() {
        return getCameraInfo().getLensFacing() == 0;
    }

    void open();

    @NonNull
    ListenableFuture<Void> release();

    default void setActiveResumingMode(boolean z) {
    }

    @Override // androidx.camera.core.Camera
    default void setExtendedConfig(@Nullable CameraConfig cameraConfig) {
    }
}

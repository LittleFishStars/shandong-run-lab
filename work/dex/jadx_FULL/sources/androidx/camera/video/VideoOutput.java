package androidx.camera.video;

import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.annotation.RestrictTo;
import androidx.camera.core.CameraInfo;
import androidx.camera.core.SurfaceRequest;
import androidx.camera.core.impl.ConstantObservable;
import androidx.camera.core.impl.Observable;
import androidx.camera.core.impl.Timebase;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_13_8952cls.dex */
@RequiresApi(21)
public interface VideoOutput {

    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public enum SourceState {
        ACTIVE_STREAMING,
        ACTIVE_NON_STREAMING,
        INACTIVE
    }

    @NonNull
    @RestrictTo({RestrictTo.Scope.LIBRARY})
    default VideoCapabilities getMediaCapabilities(@NonNull CameraInfo cameraInfo) {
        return VideoCapabilities.EMPTY;
    }

    @NonNull
    @RestrictTo({RestrictTo.Scope.LIBRARY})
    default Observable<MediaSpec> getMediaSpec() {
        return ConstantObservable.withValue(null);
    }

    @NonNull
    @RestrictTo({RestrictTo.Scope.LIBRARY})
    default Observable<StreamInfo> getStreamInfo() {
        return StreamInfo.ALWAYS_ACTIVE_OBSERVABLE;
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY})
    default void onSourceStateChanged(@NonNull SourceState sourceState) {
    }

    void onSurfaceRequested(@NonNull SurfaceRequest surfaceRequest);

    @RestrictTo({RestrictTo.Scope.LIBRARY})
    default void onSurfaceRequested(@NonNull SurfaceRequest surfaceRequest, @NonNull Timebase timebase) {
        onSurfaceRequested(surfaceRequest);
    }
}

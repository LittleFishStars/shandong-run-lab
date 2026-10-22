package androidx.camera.core;

import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.p002lifecycle.LifecycleOwner;
import java.util.List;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_13_8952cls.dex */
@RequiresApi(21)
public class ConcurrentCamera {

    @NonNull
    private List<Camera> mCameras;

    public static final class SingleCameraConfig {

        @NonNull
        private CameraSelector mCameraSelector;

        @NonNull
        private LifecycleOwner mLifecycleOwner;

        @NonNull
        private UseCaseGroup mUseCaseGroup;

        public SingleCameraConfig(@NonNull CameraSelector cameraSelector, @NonNull UseCaseGroup useCaseGroup, @NonNull LifecycleOwner lifecycleOwner) {
            this.mCameraSelector = cameraSelector;
            this.mUseCaseGroup = useCaseGroup;
            this.mLifecycleOwner = lifecycleOwner;
        }

        @NonNull
        public CameraSelector getCameraSelector() {
            return this.mCameraSelector;
        }

        @NonNull
        public LifecycleOwner getLifecycleOwner() {
            return this.mLifecycleOwner;
        }

        @NonNull
        public UseCaseGroup getUseCaseGroup() {
            return this.mUseCaseGroup;
        }
    }

    public ConcurrentCamera(@NonNull List<Camera> list) {
        this.mCameras = list;
    }

    @NonNull
    public List<Camera> getCameras() {
        return this.mCameras;
    }
}

package androidx.camera.core.imagecapture;

import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.camera.core.impl.CaptureConfig;
import java.util.List;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_13_8952cls.dex */
@RequiresApi(api = 21)
public final class CameraRequest {
    private final TakePictureCallback mCallback;
    private final List<CaptureConfig> mCaptureConfigs;

    public CameraRequest(@NonNull List<CaptureConfig> list, @NonNull TakePictureCallback takePictureCallback) {
        this.mCaptureConfigs = list;
        this.mCallback = takePictureCallback;
    }

    @NonNull
    public List<CaptureConfig> getCaptureConfigs() {
        return this.mCaptureConfigs;
    }

    public boolean isAborted() {
        return this.mCallback.isAborted();
    }
}

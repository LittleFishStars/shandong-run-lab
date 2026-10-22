package androidx.camera.core.impl;

import android.util.Size;
import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.camera.core.CameraFilter;
import androidx.camera.core.CameraInfo;
import androidx.camera.core.CameraSelector;
import androidx.camera.core.DynamicRange;
import androidx.camera.core.impl.CameraInfoInternal;
import androidx.core.util.Preconditions;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.concurrent.Executor;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_13_8952cls.dex */
@RequiresApi(21)
public interface CameraInfoInternal extends CameraInfo {
    /* JADX INFO: Access modifiers changed from: private */
    /* synthetic */ default List lambda$getCameraSelector$0(List list) {
        String cameraId = getCameraId();
        Iterator it = list.iterator();
        while (it.hasNext()) {
            CameraInfo cameraInfo = (CameraInfo) it.next();
            Preconditions.checkArgument(cameraInfo instanceof CameraInfoInternal);
            if (((CameraInfoInternal) cameraInfo).getCameraId().equals(cameraId)) {
                return Collections.singletonList(cameraInfo);
            }
        }
        throw new IllegalStateException("Unable to find camera with id " + cameraId + " from list of available cameras.");
    }

    void addSessionCaptureCallback(@NonNull Executor executor, @NonNull CameraCaptureCallback cameraCaptureCallback);

    @NonNull
    String getCameraId();

    @NonNull
    Quirks getCameraQuirks();

    @Override // androidx.camera.core.CameraInfo
    @NonNull
    default CameraSelector getCameraSelector() {
        return new CameraSelector.Builder().addCameraFilter(new CameraFilter(this) { // from class: com.zj.adlib.ec1

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final /* synthetic */ CameraInfoInternal f41400a;

            @Override // androidx.camera.core.CameraFilter
            public final List filter(List list) {
            }
        }).addCameraFilter(new LensFacingCameraFilter(getLensFacing())).build();
    }

    @NonNull
    EncoderProfilesProvider getEncoderProfilesProvider();

    @NonNull
    default CameraInfoInternal getImplementation() {
        return this;
    }

    @NonNull
    Set<DynamicRange> getSupportedDynamicRanges();

    @NonNull
    List<Size> getSupportedHighResolutions(int i);

    @NonNull
    List<Size> getSupportedResolutions(int i);

    @NonNull
    Timebase getTimebase();

    void removeSessionCaptureCallback(@NonNull CameraCaptureCallback cameraCaptureCallback);
}

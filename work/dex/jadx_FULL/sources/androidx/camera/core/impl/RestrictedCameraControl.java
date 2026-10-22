package androidx.camera.core.impl;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.camera.core.FocusMeteringAction;
import androidx.camera.core.FocusMeteringResult;
import androidx.camera.core.impl.utils.futures.Futures;
import com.google.common.util.concurrent.ListenableFuture;
import java.util.ArrayList;
import java.util.Set;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_13_8952cls.dex */
@RequiresApi(21)
public class RestrictedCameraControl extends ForwardingCameraControl {
    public static final int AE_REGION = 3;
    public static final int AF_REGION = 2;
    public static final int AUTO_FOCUS = 1;
    public static final int AWB_REGION = 4;
    public static final int EXPOSURE_COMPENSATION = 7;
    public static final int FLASH = 5;
    public static final int TORCH = 6;
    public static final int ZOOM = 0;
    private final CameraControlInternal mCameraControl;

    @Nullable
    @CameraOperation
    private volatile Set<Integer> mRestrictedCameraOperations;
    private volatile boolean mUseRestrictedCameraOperations;

    public @interface CameraOperation {
    }

    public RestrictedCameraControl(@NonNull CameraControlInternal cameraControlInternal) {
        super(cameraControlInternal);
        this.mUseRestrictedCameraOperations = false;
        this.mCameraControl = cameraControlInternal;
    }

    @Override // androidx.camera.core.impl.ForwardingCameraControl, androidx.camera.core.CameraControl
    @NonNull
    public ListenableFuture<Void> cancelFocusAndMetering() {
        return this.mCameraControl.cancelFocusAndMetering();
    }

    public void enableRestrictedOperations(boolean z, @Nullable @CameraOperation Set<Integer> set) {
        this.mUseRestrictedCameraOperations = z;
        this.mRestrictedCameraOperations = set;
    }

    @Override // androidx.camera.core.impl.ForwardingCameraControl, androidx.camera.core.CameraControl
    @NonNull
    public ListenableFuture<Void> enableTorch(boolean z) {
        return !isOperationSupported(6) ? Futures.immediateFailedFuture(new IllegalStateException("Torch is not supported")) : this.mCameraControl.enableTorch(z);
    }

    @Override // androidx.camera.core.impl.ForwardingCameraControl, androidx.camera.core.impl.CameraControlInternal
    @NonNull
    public CameraControlInternal getImplementation() {
        return this.mCameraControl;
    }

    @Nullable
    public FocusMeteringAction getModifiedFocusMeteringAction(@NonNull FocusMeteringAction focusMeteringAction) {
        boolean z;
        FocusMeteringAction.Builder builder = new FocusMeteringAction.Builder(focusMeteringAction);
        boolean z2 = true;
        if (focusMeteringAction.getMeteringPointsAf().isEmpty() || isOperationSupported(1, 2)) {
            z = false;
        } else {
            builder.removePoints(1);
            z = true;
        }
        if (!focusMeteringAction.getMeteringPointsAe().isEmpty() && !isOperationSupported(3)) {
            builder.removePoints(2);
            z = true;
        }
        if (focusMeteringAction.getMeteringPointsAwb().isEmpty() || isOperationSupported(4)) {
            z2 = z;
        } else {
            builder.removePoints(4);
        }
        if (!z2) {
            return focusMeteringAction;
        }
        FocusMeteringAction focusMeteringActionBuild = builder.build();
        if (focusMeteringActionBuild.getMeteringPointsAf().isEmpty() && focusMeteringActionBuild.getMeteringPointsAe().isEmpty() && focusMeteringActionBuild.getMeteringPointsAwb().isEmpty()) {
            return null;
        }
        return builder.build();
    }

    public boolean isOperationSupported(@NonNull @CameraOperation int... iArr) {
        if (!this.mUseRestrictedCameraOperations || this.mRestrictedCameraOperations == null) {
            return true;
        }
        ArrayList arrayList = new ArrayList(iArr.length);
        for (int i : iArr) {
            arrayList.add(Integer.valueOf(i));
        }
        return this.mRestrictedCameraOperations.containsAll(arrayList);
    }

    @Override // androidx.camera.core.impl.ForwardingCameraControl, androidx.camera.core.CameraControl
    @NonNull
    public ListenableFuture<Integer> setExposureCompensationIndex(int i) {
        return !isOperationSupported(7) ? Futures.immediateFailedFuture(new IllegalStateException("ExposureCompensation is not supported")) : this.mCameraControl.setExposureCompensationIndex(i);
    }

    @Override // androidx.camera.core.impl.ForwardingCameraControl, androidx.camera.core.CameraControl
    @NonNull
    public ListenableFuture<Void> setLinearZoom(float f) {
        return !isOperationSupported(0) ? Futures.immediateFailedFuture(new IllegalStateException("Zoom is not supported")) : this.mCameraControl.setLinearZoom(f);
    }

    @Override // androidx.camera.core.impl.ForwardingCameraControl, androidx.camera.core.CameraControl
    @NonNull
    public ListenableFuture<Void> setZoomRatio(float f) {
        return !isOperationSupported(0) ? Futures.immediateFailedFuture(new IllegalStateException("Zoom is not supported")) : this.mCameraControl.setZoomRatio(f);
    }

    @Override // androidx.camera.core.impl.ForwardingCameraControl, androidx.camera.core.CameraControl
    @NonNull
    public ListenableFuture<FocusMeteringResult> startFocusAndMetering(@NonNull FocusMeteringAction focusMeteringAction) {
        FocusMeteringAction modifiedFocusMeteringAction = getModifiedFocusMeteringAction(focusMeteringAction);
        return modifiedFocusMeteringAction == null ? Futures.immediateFailedFuture(new IllegalStateException("FocusMetering is not supported")) : this.mCameraControl.startFocusAndMetering(modifiedFocusMeteringAction);
    }
}

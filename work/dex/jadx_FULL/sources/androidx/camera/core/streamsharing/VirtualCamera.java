package androidx.camera.core.streamsharing;

import androidx.annotation.IntRange;
import androidx.annotation.MainThread;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.annotation.VisibleForTesting;
import androidx.camera.core.ImageCapture;
import androidx.camera.core.Preview;
import androidx.camera.core.UseCase;
import androidx.camera.core.impl.CameraCaptureCallback;
import androidx.camera.core.impl.CameraCaptureResult;
import androidx.camera.core.impl.CameraControlInternal;
import androidx.camera.core.impl.CameraInfoInternal;
import androidx.camera.core.impl.CameraInternal;
import androidx.camera.core.impl.DeferrableSurface;
import androidx.camera.core.impl.ImageOutputConfig;
import androidx.camera.core.impl.MutableConfig;
import androidx.camera.core.impl.Observable;
import androidx.camera.core.impl.SessionConfig;
import androidx.camera.core.impl.UseCaseConfig;
import androidx.camera.core.impl.UseCaseConfigFactory;
import androidx.camera.core.impl.utils.Threads;
import androidx.camera.core.impl.utils.TransformUtils;
import androidx.camera.core.processing.SurfaceEdge;
import androidx.camera.core.processing.SurfaceProcessorNode;
import androidx.core.util.Preconditions;
import com.google.common.util.concurrent.ListenableFuture;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Set;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_13_8952cls.dex */
@RequiresApi(api = 21)
class VirtualCamera implements CameraInternal {
    private static final String UNSUPPORTED_MESSAGE = "Operation not supported by VirtualCamera.";

    @NonNull
    final Set<UseCase> mChildren;

    @NonNull
    private final CameraInternal mParentCamera;

    @NonNull
    private final UseCaseConfigFactory mUseCaseConfigFactory;

    @NonNull
    private final VirtualCameraControl mVirtualCameraControl;

    @NonNull
    final Map<UseCase, SurfaceEdge> mChildrenEdges = new HashMap();

    @NonNull
    final Map<UseCase, Boolean> mChildrenActiveState = new HashMap();

    @NonNull
    private final CameraCaptureCallback mParentMetadataCallback = createCameraCaptureCallback();

    public VirtualCamera(@NonNull CameraInternal cameraInternal, @NonNull Set<UseCase> set, @NonNull UseCaseConfigFactory useCaseConfigFactory, @NonNull StreamSharing.Control control) {
        this.mParentCamera = cameraInternal;
        this.mUseCaseConfigFactory = useCaseConfigFactory;
        this.mChildren = set;
        this.mVirtualCameraControl = new VirtualCameraControl(cameraInternal.getCameraControlInternal(), control);
        Iterator<UseCase> it = set.iterator();
        while (it.hasNext()) {
            this.mChildrenActiveState.put(it.next(), Boolean.FALSE);
        }
    }

    private void forceSetProvider(@NonNull SurfaceEdge surfaceEdge, @NonNull DeferrableSurface deferrableSurface, @NonNull SessionConfig sessionConfig) {
        surfaceEdge.invalidate();
        try {
            surfaceEdge.setProvider(deferrableSurface);
        } catch (DeferrableSurface.SurfaceClosedException unused) {
            Iterator<SessionConfig.ErrorListener> it = sessionConfig.getErrorListeners().iterator();
            while (it.hasNext()) {
                it.next().onError(sessionConfig, SessionConfig.SessionError.SESSION_ERROR_SURFACE_NEEDS_RESET);
            }
        }
    }

    private static int getChildFormat(@NonNull UseCase useCase) {
        return useCase instanceof ImageCapture ? 256 : 34;
    }

    @IntRange(from = 0, to = 359)
    private int getChildRotationDegrees(@NonNull UseCase useCase) {
        if (useCase instanceof Preview) {
            return this.mParentCamera.getCameraInfo().getSensorRotationDegrees(((Preview) useCase).getTargetRotation());
        }
        return 0;
    }

    @Nullable
    @VisibleForTesting
    public static DeferrableSurface getChildSurface(@NonNull UseCase useCase) {
        List<DeferrableSurface> surfaces = useCase instanceof ImageCapture ? useCase.getSessionConfig().getSurfaces() : useCase.getSessionConfig().getRepeatingCaptureConfig().getSurfaces();
        Preconditions.checkState(surfaces.size() <= 1);
        if (surfaces.size() == 1) {
            return surfaces.get(0);
        }
        return null;
    }

    private static int getChildTargetType(@NonNull UseCase useCase) {
        if (useCase instanceof Preview) {
            return 1;
        }
        return useCase instanceof ImageCapture ? 4 : 2;
    }

    private static int getHighestSurfacePriority(Set<UseCaseConfig<?>> set) {
        Iterator<UseCaseConfig<?>> it = set.iterator();
        int iMax = 0;
        while (it.hasNext()) {
            iMax = Math.max(iMax, it.next().getSurfaceOccupancyPriority());
        }
        return iMax;
    }

    @NonNull
    private SurfaceEdge getUseCaseEdge(@NonNull UseCase useCase) {
        SurfaceEdge surfaceEdge = this.mChildrenEdges.get(useCase);
        Objects.requireNonNull(surfaceEdge);
        return surfaceEdge;
    }

    private boolean isUseCaseActive(@NonNull UseCase useCase) {
        Boolean bool = this.mChildrenActiveState.get(useCase);
        Objects.requireNonNull(bool);
        return bool.booleanValue();
    }

    public static void sendCameraCaptureResultToChild(@NonNull CameraCaptureResult cameraCaptureResult, @NonNull SessionConfig sessionConfig) {
        Iterator<CameraCaptureCallback> it = sessionConfig.getRepeatingCameraCaptureCallbacks().iterator();
        while (it.hasNext()) {
            it.next().onCaptureCompleted(new VirtualCameraCaptureResult(sessionConfig.getRepeatingCaptureConfig().getTagBundle(), cameraCaptureResult));
        }
    }

    @Override // androidx.camera.core.impl.CameraInternal
    public void attachUseCases(@NonNull Collection<UseCase> collection) {
        throw new UnsupportedOperationException(UNSUPPORTED_MESSAGE);
    }

    public void bindChildren() {
        for (UseCase useCase : this.mChildren) {
            useCase.bindToCamera(this, null, useCase.getDefaultConfig(true, this.mUseCaseConfigFactory));
        }
    }

    @Override // androidx.camera.core.impl.CameraInternal
    public void close() {
        throw new UnsupportedOperationException(UNSUPPORTED_MESSAGE);
    }

    public CameraCaptureCallback createCameraCaptureCallback() {
        return new CameraCaptureCallback() { // from class: androidx.camera.core.streamsharing.VirtualCamera.1
            @Override // androidx.camera.core.impl.CameraCaptureCallback
            public void onCaptureCompleted(@NonNull CameraCaptureResult cameraCaptureResult) {
                super.onCaptureCompleted(cameraCaptureResult);
                Iterator<UseCase> it = VirtualCamera.this.mChildren.iterator();
                while (it.hasNext()) {
                    VirtualCamera.sendCameraCaptureResultToChild(cameraCaptureResult, it.next().getSessionConfig());
                }
            }
        };
    }

    @Override // androidx.camera.core.impl.CameraInternal
    public void detachUseCases(@NonNull Collection<UseCase> collection) {
        throw new UnsupportedOperationException(UNSUPPORTED_MESSAGE);
    }

    @Override // androidx.camera.core.impl.CameraInternal
    @NonNull
    public CameraControlInternal getCameraControlInternal() {
        return this.mVirtualCameraControl;
    }

    @Override // androidx.camera.core.impl.CameraInternal
    @NonNull
    public CameraInfoInternal getCameraInfoInternal() {
        return this.mParentCamera.getCameraInfoInternal();
    }

    @Override // androidx.camera.core.impl.CameraInternal
    @NonNull
    public Observable<CameraInternal.State> getCameraState() {
        return this.mParentCamera.getCameraState();
    }

    @NonNull
    public Set<UseCase> getChildren() {
        return this.mChildren;
    }

    @NonNull
    public Map<UseCase, SurfaceProcessorNode.OutConfig> getChildrenOutConfigs(@NonNull SurfaceEdge surfaceEdge) {
        HashMap map = new HashMap();
        for (UseCase useCase : this.mChildren) {
            int childRotationDegrees = getChildRotationDegrees(useCase);
            map.put(useCase, SurfaceProcessorNode.OutConfig.of(getChildTargetType(useCase), getChildFormat(useCase), surfaceEdge.getCropRect(), TransformUtils.getRotatedSize(surfaceEdge.getCropRect(), childRotationDegrees), childRotationDegrees, useCase.isMirroringRequired(this)));
        }
        return map;
    }

    @Override // androidx.camera.core.impl.CameraInternal
    public boolean getHasTransform() {
        return false;
    }

    @NonNull
    public CameraCaptureCallback getParentMetadataCallback() {
        return this.mParentMetadataCallback;
    }

    public void mergeChildrenConfigs(@NonNull MutableConfig mutableConfig) {
        HashSet hashSet = new HashSet();
        for (UseCase useCase : this.mChildren) {
            hashSet.add(useCase.mergeConfigs(this.mParentCamera.getCameraInfoInternal(), null, useCase.getDefaultConfig(true, this.mUseCaseConfigFactory)));
        }
        mutableConfig.insertOption(ImageOutputConfig.OPTION_CUSTOM_ORDERED_RESOLUTIONS, ResolutionUtils.getMergedResolutions(new ArrayList(this.mParentCamera.getCameraInfoInternal().getSupportedResolutions(34)), TransformUtils.rectToSize(this.mParentCamera.getCameraControlInternal().getSensorRect()), hashSet));
        mutableConfig.insertOption(UseCaseConfig.OPTION_SURFACE_OCCUPANCY_PRIORITY, Integer.valueOf(getHighestSurfacePriority(hashSet)));
    }

    public void notifyStateAttached() {
        Iterator<UseCase> it = this.mChildren.iterator();
        while (it.hasNext()) {
            it.next().onStateAttached();
        }
    }

    public void notifyStateDetached() {
        Iterator<UseCase> it = this.mChildren.iterator();
        while (it.hasNext()) {
            it.next().onStateDetached();
        }
    }

    @Override // androidx.camera.core.UseCase.StateChangeCallback
    @MainThread
    public void onUseCaseActive(@NonNull UseCase useCase) {
        Threads.checkMainThread();
        if (isUseCaseActive(useCase)) {
            return;
        }
        this.mChildrenActiveState.put(useCase, Boolean.TRUE);
        DeferrableSurface childSurface = getChildSurface(useCase);
        if (childSurface != null) {
            forceSetProvider(getUseCaseEdge(useCase), childSurface, useCase.getSessionConfig());
        }
    }

    @Override // androidx.camera.core.UseCase.StateChangeCallback
    @MainThread
    public void onUseCaseInactive(@NonNull UseCase useCase) {
        Threads.checkMainThread();
        if (isUseCaseActive(useCase)) {
            this.mChildrenActiveState.put(useCase, Boolean.FALSE);
            getUseCaseEdge(useCase).disconnect();
        }
    }

    @Override // androidx.camera.core.UseCase.StateChangeCallback
    @MainThread
    public void onUseCaseReset(@NonNull UseCase useCase) {
        DeferrableSurface childSurface;
        Threads.checkMainThread();
        SurfaceEdge useCaseEdge = getUseCaseEdge(useCase);
        useCaseEdge.invalidate();
        if (isUseCaseActive(useCase) && (childSurface = getChildSurface(useCase)) != null) {
            forceSetProvider(useCaseEdge, childSurface, useCase.getSessionConfig());
        }
    }

    @Override // androidx.camera.core.UseCase.StateChangeCallback
    @MainThread
    public void onUseCaseUpdated(@NonNull UseCase useCase) {
        Threads.checkMainThread();
        if (isUseCaseActive(useCase)) {
            SurfaceEdge useCaseEdge = getUseCaseEdge(useCase);
            DeferrableSurface childSurface = getChildSurface(useCase);
            if (childSurface != null) {
                forceSetProvider(useCaseEdge, childSurface, useCase.getSessionConfig());
            } else {
                useCaseEdge.disconnect();
            }
        }
    }

    @Override // androidx.camera.core.impl.CameraInternal
    public void open() {
        throw new UnsupportedOperationException(UNSUPPORTED_MESSAGE);
    }

    @Override // androidx.camera.core.impl.CameraInternal
    @NonNull
    public ListenableFuture<Void> release() {
        throw new UnsupportedOperationException(UNSUPPORTED_MESSAGE);
    }

    public void resetChildren() {
        Threads.checkMainThread();
        Iterator<UseCase> it = this.mChildren.iterator();
        while (it.hasNext()) {
            onUseCaseReset(it.next());
        }
    }

    public void setChildrenEdges(@NonNull Map<UseCase, SurfaceEdge> map) {
        this.mChildrenEdges.clear();
        this.mChildrenEdges.putAll(map);
        for (Map.Entry<UseCase, SurfaceEdge> entry : this.mChildrenEdges.entrySet()) {
            UseCase key = entry.getKey();
            SurfaceEdge value = entry.getValue();
            key.setViewPortCropRect(value.getCropRect());
            key.setSensorToBufferTransformMatrix(value.getSensorToBufferTransform());
            key.updateSuggestedStreamSpec(value.getStreamSpec());
            key.notifyState();
        }
    }

    public void unbindChildren() {
        Iterator<UseCase> it = this.mChildren.iterator();
        while (it.hasNext()) {
            it.next().unbindFromCamera(this);
        }
    }
}

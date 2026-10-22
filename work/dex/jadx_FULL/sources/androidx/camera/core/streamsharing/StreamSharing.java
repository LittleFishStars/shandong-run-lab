package androidx.camera.core.streamsharing;

import android.graphics.Matrix;
import android.graphics.Rect;
import android.util.Log;
import android.util.Size;
import androidx.annotation.IntRange;
import androidx.annotation.MainThread;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.annotation.RestrictTo;
import androidx.annotation.VisibleForTesting;
import androidx.camera.core.UseCase;
import androidx.camera.core.impl.CameraInfoInternal;
import androidx.camera.core.impl.CameraInternal;
import androidx.camera.core.impl.Config;
import androidx.camera.core.impl.ImageInputConfig;
import androidx.camera.core.impl.ImageOutputConfig;
import androidx.camera.core.impl.MutableConfig;
import androidx.camera.core.impl.MutableOptionsBundle;
import androidx.camera.core.impl.OptionsBundle;
import androidx.camera.core.impl.SessionConfig;
import androidx.camera.core.impl.StreamSpec;
import androidx.camera.core.impl.UseCaseConfig;
import androidx.camera.core.impl.UseCaseConfigFactory;
import androidx.camera.core.impl.utils.Threads;
import androidx.camera.core.impl.utils.TransformUtils;
import androidx.camera.core.impl.utils.futures.Futures;
import androidx.camera.core.processing.DefaultSurfaceProcessor;
import androidx.camera.core.processing.SurfaceEdge;
import androidx.camera.core.processing.SurfaceProcessorNode;
import androidx.camera.core.streamsharing.StreamSharing;
import androidx.core.util.Preconditions;
import com.google.common.util.concurrent.ListenableFuture;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Objects;
import java.util.Set;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_13_8952cls.dex */
@RequiresApi(api = 21)
public class StreamSharing extends UseCase {
    private static final String TAG = "StreamSharing";

    @Nullable
    private SurfaceEdge mCameraEdge;

    @NonNull
    private final StreamSharingConfig mDefaultConfig;

    @Nullable
    private SurfaceProcessorNode mEffectNode;
    SessionConfig.Builder mSessionConfigBuilder;

    @Nullable
    private SurfaceEdge mSharingInputEdge;

    @Nullable
    private SurfaceProcessorNode mSharingNode;

    @NonNull
    private final VirtualCamera mVirtualCamera;

    public interface Control {
        @NonNull
        ListenableFuture<Void> jpegSnapshot(@IntRange(from = 0, to = 100) int i, @IntRange(from = 0, to = 359) int i2);
    }

    public StreamSharing(@NonNull CameraInternal cameraInternal, @NonNull Set<UseCase> set, @NonNull UseCaseConfigFactory useCaseConfigFactory) {
        super(getDefaultConfig(set));
        this.mDefaultConfig = getDefaultConfig(set);
        this.mVirtualCamera = new VirtualCamera(cameraInternal, set, useCaseConfigFactory, new Control() { // from class: androidx.camera.core.streamsharing.a
            @Override // androidx.camera.core.streamsharing.StreamSharing.Control
            public final ListenableFuture jpegSnapshot(int i, int i2) {
                return this.f21388a.lambda$new$0(i, i2);
            }
        });
    }

    private void addCameraErrorListener(@NonNull SessionConfig.Builder builder, @NonNull final String str, @NonNull final UseCaseConfig<?> useCaseConfig, @NonNull final StreamSpec streamSpec) {
        builder.addErrorListener(new SessionConfig.ErrorListener(this, str, useCaseConfig, streamSpec) { // from class: com.zj.adlib.js8

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final /* synthetic */ StreamSpec f42661a;

            /* JADX INFO: renamed from: a, reason: collision with other field name */
            public final /* synthetic */ UseCaseConfig f17478a;

            /* JADX INFO: renamed from: a, reason: collision with other field name */
            public final /* synthetic */ StreamSharing f17479a;

            /* JADX INFO: renamed from: a, reason: collision with other field name */
            public final /* synthetic */ String f17480a;

            @Override // androidx.camera.core.impl.SessionConfig.ErrorListener
            public final void onError(SessionConfig sessionConfig, SessionConfig.SessionError sessionError) {
            }
        });
    }

    private void clearPipeline() {
        SurfaceEdge surfaceEdge = this.mCameraEdge;
        if (surfaceEdge != null) {
            surfaceEdge.close();
            this.mCameraEdge = null;
        }
        SurfaceEdge surfaceEdge2 = this.mSharingInputEdge;
        if (surfaceEdge2 != null) {
            surfaceEdge2.close();
            this.mSharingInputEdge = null;
        }
        SurfaceProcessorNode surfaceProcessorNode = this.mSharingNode;
        if (surfaceProcessorNode != null) {
            surfaceProcessorNode.release();
            this.mSharingNode = null;
        }
        SurfaceProcessorNode surfaceProcessorNode2 = this.mEffectNode;
        if (surfaceProcessorNode2 != null) {
            surfaceProcessorNode2.release();
            this.mEffectNode = null;
        }
    }

    @NonNull
    @MainThread
    private SessionConfig createPipelineAndUpdateChildrenSpecs(@NonNull String str, @NonNull UseCaseConfig<?> useCaseConfig, @NonNull StreamSpec streamSpec) {
        Threads.checkMainThread();
        CameraInternal cameraInternal = (CameraInternal) Preconditions.checkNotNull(getCamera());
        Matrix sensorToBufferTransformMatrix = getSensorToBufferTransformMatrix();
        boolean hasTransform = cameraInternal.getHasTransform();
        Rect cropRect = getCropRect(streamSpec.getResolution());
        Objects.requireNonNull(cropRect);
        SurfaceEdge surfaceEdge = new SurfaceEdge(3, 34, streamSpec, sensorToBufferTransformMatrix, hasTransform, cropRect, getRelativeRotation(cameraInternal), -1, isMirroringRequired(cameraInternal));
        this.mCameraEdge = surfaceEdge;
        this.mSharingInputEdge = getSharingInputEdge(surfaceEdge, cameraInternal);
        this.mSharingNode = new SurfaceProcessorNode(cameraInternal, DefaultSurfaceProcessor.Factory.newInstance(streamSpec.getDynamicRange()));
        Map<UseCase, SurfaceProcessorNode.OutConfig> childrenOutConfigs = this.mVirtualCamera.getChildrenOutConfigs(this.mSharingInputEdge);
        SurfaceProcessorNode.Out outTransform = this.mSharingNode.transform(SurfaceProcessorNode.In.of(this.mSharingInputEdge, new ArrayList(childrenOutConfigs.values())));
        HashMap map = new HashMap();
        for (Map.Entry<UseCase, SurfaceProcessorNode.OutConfig> entry : childrenOutConfigs.entrySet()) {
            map.put(entry.getKey(), outTransform.get(entry.getValue()));
        }
        this.mVirtualCamera.setChildrenEdges(map);
        SessionConfig.Builder builderCreateFrom = SessionConfig.Builder.createFrom(useCaseConfig, streamSpec.getResolution());
        builderCreateFrom.addSurface(this.mCameraEdge.getDeferrableSurface());
        builderCreateFrom.addRepeatingCameraCaptureCallback(this.mVirtualCamera.getParentMetadataCallback());
        if (streamSpec.getImplementationOptions() != null) {
            builderCreateFrom.addImplementationOptions(streamSpec.getImplementationOptions());
        }
        addCameraErrorListener(builderCreateFrom, str, useCaseConfig, streamSpec);
        this.mSessionConfigBuilder = builderCreateFrom;
        return builderCreateFrom.build();
    }

    @Nullable
    private Rect getCropRect(@NonNull Size size) {
        return getViewPortCropRect() != null ? getViewPortCropRect() : new Rect(0, 0, size.getWidth(), size.getHeight());
    }

    private static StreamSharingConfig getDefaultConfig(Set<UseCase> set) {
        MutableConfig mutableConfig = new StreamSharingBuilder().getMutableConfig();
        mutableConfig.insertOption(ImageInputConfig.OPTION_INPUT_FORMAT, 34);
        mutableConfig.insertOption(UseCaseConfig.OPTION_CAPTURE_TYPE, UseCaseConfigFactory.CaptureType.STREAM_SHARING);
        ArrayList arrayList = new ArrayList();
        for (UseCase useCase : set) {
            if (useCase.getCurrentConfig().containsOption(UseCaseConfig.OPTION_CAPTURE_TYPE)) {
                arrayList.add(useCase.getCurrentConfig().getCaptureType());
            } else {
                Log.e(TAG, "A child does not have capture type.");
            }
        }
        mutableConfig.insertOption(StreamSharingConfig.OPTION_CAPTURE_TYPES, arrayList);
        mutableConfig.insertOption(ImageOutputConfig.OPTION_MIRROR_MODE, 2);
        return new StreamSharingConfig(OptionsBundle.from(mutableConfig));
    }

    @NonNull
    private SurfaceEdge getSharingInputEdge(@NonNull SurfaceEdge surfaceEdge, @NonNull CameraInternal cameraInternal) {
        if (getEffect() == null) {
            return surfaceEdge;
        }
        this.mEffectNode = new SurfaceProcessorNode(cameraInternal, getEffect().createSurfaceProcessorInternal());
        SurfaceProcessorNode.OutConfig outConfigOf = SurfaceProcessorNode.OutConfig.of(surfaceEdge.getTargets(), surfaceEdge.getFormat(), surfaceEdge.getCropRect(), TransformUtils.getRotatedSize(surfaceEdge.getCropRect(), 0), 0, false);
        SurfaceEdge surfaceEdge2 = this.mEffectNode.transform(SurfaceProcessorNode.In.of(surfaceEdge, Collections.singletonList(outConfigOf))).get(outConfigOf);
        Objects.requireNonNull(surfaceEdge2);
        return surfaceEdge2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$addCameraErrorListener$1(String str, UseCaseConfig useCaseConfig, StreamSpec streamSpec, SessionConfig sessionConfig, SessionConfig.SessionError sessionError) {
        clearPipeline();
        if (isCurrentCamera(str)) {
            updateSessionConfig(createPipelineAndUpdateChildrenSpecs(str, useCaseConfig, streamSpec));
            notifyReset();
            this.mVirtualCamera.resetChildren();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ ListenableFuture lambda$new$0(int i, int i2) {
        SurfaceProcessorNode surfaceProcessorNode = this.mSharingNode;
        return surfaceProcessorNode != null ? surfaceProcessorNode.getSurfaceProcessor().snapshot(i, i2) : Futures.immediateFailedFuture(new Exception("Failed to take picture: pipeline is not ready."));
    }

    @Nullable
    @VisibleForTesting
    public SurfaceEdge getCameraEdge() {
        return this.mCameraEdge;
    }

    @NonNull
    public Set<UseCase> getChildren() {
        return this.mVirtualCamera.getChildren();
    }

    @Nullable
    @VisibleForTesting
    public SurfaceProcessorNode getSharingNode() {
        return this.mSharingNode;
    }

    @Override // androidx.camera.core.UseCase
    @NonNull
    public Set<Integer> getSupportedEffectTargets() {
        HashSet hashSet = new HashSet();
        hashSet.add(3);
        return hashSet;
    }

    @Override // androidx.camera.core.UseCase
    @NonNull
    public UseCaseConfig.Builder<?, ?, ?> getUseCaseConfigBuilder(@NonNull Config config) {
        return new StreamSharingBuilder(MutableOptionsBundle.from(config));
    }

    @NonNull
    @VisibleForTesting
    public VirtualCamera getVirtualCamera() {
        return this.mVirtualCamera;
    }

    @Override // androidx.camera.core.UseCase
    public void onBind() {
        super.onBind();
        this.mVirtualCamera.bindChildren();
    }

    @Override // androidx.camera.core.UseCase
    @NonNull
    public UseCaseConfig<?> onMergeConfig(@NonNull CameraInfoInternal cameraInfoInternal, @NonNull UseCaseConfig.Builder<?, ?, ?> builder) {
        this.mVirtualCamera.mergeChildrenConfigs(builder.getMutableConfig());
        return builder.getUseCaseConfig();
    }

    @Override // androidx.camera.core.UseCase
    public void onStateAttached() {
        super.onStateAttached();
        this.mVirtualCamera.notifyStateAttached();
    }

    @Override // androidx.camera.core.UseCase
    public void onStateDetached() {
        super.onStateDetached();
        this.mVirtualCamera.notifyStateDetached();
    }

    @Override // androidx.camera.core.UseCase
    @NonNull
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public StreamSpec onSuggestedStreamSpecImplementationOptionsUpdated(@NonNull Config config) {
        this.mSessionConfigBuilder.addImplementationOptions(config);
        updateSessionConfig(this.mSessionConfigBuilder.build());
        return getAttachedStreamSpec().toBuilder().setImplementationOptions(config).build();
    }

    @Override // androidx.camera.core.UseCase
    @NonNull
    public StreamSpec onSuggestedStreamSpecUpdated(@NonNull StreamSpec streamSpec) {
        updateSessionConfig(createPipelineAndUpdateChildrenSpecs(getCameraId(), getCurrentConfig(), streamSpec));
        notifyActive();
        return streamSpec;
    }

    @Override // androidx.camera.core.UseCase
    public void onUnbind() {
        super.onUnbind();
        clearPipeline();
        this.mVirtualCamera.unbindChildren();
    }

    @Override // androidx.camera.core.UseCase
    @Nullable
    public UseCaseConfig<?> getDefaultConfig(boolean z, @NonNull UseCaseConfigFactory useCaseConfigFactory) {
        Config config = useCaseConfigFactory.getConfig(this.mDefaultConfig.getCaptureType(), 1);
        if (z) {
            config = Config.mergeConfigs(config, this.mDefaultConfig.getConfig());
        }
        if (config == null) {
            return null;
        }
        return getUseCaseConfigBuilder(config).getUseCaseConfig();
    }
}

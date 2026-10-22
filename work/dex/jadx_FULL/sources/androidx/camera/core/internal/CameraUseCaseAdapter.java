package androidx.camera.core.internal;

import android.graphics.Matrix;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.SurfaceTexture;
import android.util.Pair;
import android.util.Size;
import android.view.Surface;
import androidx.annotation.GuardedBy;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.annotation.VisibleForTesting;
import androidx.camera.core.Camera;
import androidx.camera.core.CameraControl;
import androidx.camera.core.CameraEffect;
import androidx.camera.core.CameraInfo;
import androidx.camera.core.ImageCapture;
import androidx.camera.core.Logger;
import androidx.camera.core.Preview;
import androidx.camera.core.SurfaceRequest;
import androidx.camera.core.UseCase;
import androidx.camera.core.ViewPort;
import androidx.camera.core.concurrent.CameraCoordinator;
import androidx.camera.core.impl.AttachedSurfaceInfo;
import androidx.camera.core.impl.CameraConfig;
import androidx.camera.core.impl.CameraConfigs;
import androidx.camera.core.impl.CameraControlInternal;
import androidx.camera.core.impl.CameraDeviceSurfaceManager;
import androidx.camera.core.impl.CameraInfoInternal;
import androidx.camera.core.impl.CameraInternal;
import androidx.camera.core.impl.Config;
import androidx.camera.core.impl.RestrictedCameraControl;
import androidx.camera.core.impl.RestrictedCameraInfo;
import androidx.camera.core.impl.SessionConfig;
import androidx.camera.core.impl.SessionProcessor;
import androidx.camera.core.impl.StreamSpec;
import androidx.camera.core.impl.UseCaseConfig;
import androidx.camera.core.impl.UseCaseConfigFactory;
import androidx.camera.core.impl.utils.TransformUtils;
import androidx.camera.core.impl.utils.executor.CameraXExecutors;
import androidx.camera.core.internal.CameraUseCaseAdapter;
import androidx.camera.core.processing.TargetUtils;
import androidx.camera.core.streamsharing.StreamSharing;
import androidx.core.util.Consumer;
import androidx.core.util.Preconditions;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Set;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_13_8952cls.dex */
@RequiresApi(21)
public final class CameraUseCaseAdapter implements Camera {
    private static final String TAG = "CameraUseCaseAdapter";

    @GuardedBy("mLock")
    private final CameraCoordinator mCameraCoordinator;
    private final CameraDeviceSurfaceManager mCameraDeviceSurfaceManager;

    @NonNull
    private final CameraInternal mCameraInternal;
    private final LinkedHashSet<CameraInternal> mCameraInternals;
    private final CameraId mId;

    @Nullable
    @GuardedBy("mLock")
    private UseCase mPlaceholderForExtensions;

    @NonNull
    private final RestrictedCameraControl mRestrictedCameraControl;

    @NonNull
    private final RestrictedCameraInfo mRestrictedCameraInfo;

    @Nullable
    @GuardedBy("mLock")
    private StreamSharing mStreamSharing;
    private final UseCaseConfigFactory mUseCaseConfigFactory;

    @Nullable
    @GuardedBy("mLock")
    private ViewPort mViewPort;

    @GuardedBy("mLock")
    private final List<UseCase> mAppUseCases = new ArrayList();

    @GuardedBy("mLock")
    private final List<UseCase> mCameraUseCases = new ArrayList();

    @NonNull
    @GuardedBy("mLock")
    private List<CameraEffect> mEffects = Collections.emptyList();

    @NonNull
    @GuardedBy("mLock")
    private CameraConfig mCameraConfig = CameraConfigs.emptyConfig();
    private final Object mLock = new Object();

    @GuardedBy("mLock")
    private boolean mAttached = true;

    @GuardedBy("mLock")
    private Config mInteropConfig = null;

    public static final class CameraException extends Exception {
        public CameraException() {
        }

        public CameraException(@NonNull String str) {
            super(str);
        }

        public CameraException(@NonNull Throwable th) {
            super(th);
        }
    }

    public static final class CameraId {
        private final List<String> mIds = new ArrayList();

        public CameraId(LinkedHashSet<CameraInternal> linkedHashSet) {
            Iterator<CameraInternal> it = linkedHashSet.iterator();
            while (it.hasNext()) {
                this.mIds.add(it.next().getCameraInfoInternal().getCameraId());
            }
        }

        public boolean equals(Object obj) {
            if (obj instanceof CameraId) {
                return this.mIds.equals(((CameraId) obj).mIds);
            }
            return false;
        }

        public int hashCode() {
            return this.mIds.hashCode() * 53;
        }
    }

    public static class ConfigPair {
        UseCaseConfig<?> mCameraConfig;
        UseCaseConfig<?> mExtendedConfig;

        public ConfigPair(UseCaseConfig<?> useCaseConfig, UseCaseConfig<?> useCaseConfig2) {
            this.mExtendedConfig = useCaseConfig;
            this.mCameraConfig = useCaseConfig2;
        }
    }

    public CameraUseCaseAdapter(@NonNull LinkedHashSet<CameraInternal> linkedHashSet, @NonNull CameraCoordinator cameraCoordinator, @NonNull CameraDeviceSurfaceManager cameraDeviceSurfaceManager, @NonNull UseCaseConfigFactory useCaseConfigFactory) {
        CameraInternal next = linkedHashSet.iterator().next();
        this.mCameraInternal = next;
        LinkedHashSet<CameraInternal> linkedHashSet2 = new LinkedHashSet<>(linkedHashSet);
        this.mCameraInternals = linkedHashSet2;
        this.mId = new CameraId(linkedHashSet2);
        this.mCameraCoordinator = cameraCoordinator;
        this.mCameraDeviceSurfaceManager = cameraDeviceSurfaceManager;
        this.mUseCaseConfigFactory = useCaseConfigFactory;
        RestrictedCameraControl restrictedCameraControl = new RestrictedCameraControl(next.getCameraControlInternal());
        this.mRestrictedCameraControl = restrictedCameraControl;
        this.mRestrictedCameraInfo = new RestrictedCameraInfo(next.getCameraInfoInternal(), restrictedCameraControl);
    }

    private void cacheInteropConfig() {
        synchronized (this.mLock) {
            CameraControlInternal cameraControlInternal = this.mCameraInternal.getCameraControlInternal();
            this.mInteropConfig = cameraControlInternal.getInteropConfig();
            cameraControlInternal.clearInteropConfig();
        }
    }

    public static Collection<UseCase> calculateCameraUseCases(@NonNull Collection<UseCase> collection, @Nullable UseCase useCase, @Nullable StreamSharing streamSharing) {
        ArrayList arrayList = new ArrayList(collection);
        if (useCase != null) {
            arrayList.add(useCase);
        }
        if (streamSharing != null) {
            arrayList.add(streamSharing);
            arrayList.removeAll(streamSharing.getChildren());
        }
        return arrayList;
    }

    @NonNull
    private static Matrix calculateSensorToBufferTransformMatrix(@NonNull Rect rect, @NonNull Size size) {
        Preconditions.checkArgument(rect.width() > 0 && rect.height() > 0, "Cannot compute viewport crop rects zero sized sensor rect.");
        RectF rectF = new RectF(rect);
        Matrix matrix = new Matrix();
        matrix.setRectToRect(new RectF(0.0f, 0.0f, size.getWidth(), size.getHeight()), rectF, Matrix.ScaleToFit.CENTER);
        matrix.invert(matrix);
        return matrix;
    }

    private Map<UseCase, StreamSpec> calculateSuggestedStreamSpecs(int i, @NonNull CameraInfoInternal cameraInfoInternal, @NonNull Collection<UseCase> collection, @NonNull Collection<UseCase> collection2, @NonNull Map<UseCase, ConfigPair> map) {
        Rect sensorRect;
        ArrayList arrayList = new ArrayList();
        String cameraId = cameraInfoInternal.getCameraId();
        HashMap map2 = new HashMap();
        HashMap map3 = new HashMap();
        Iterator<UseCase> it = collection2.iterator();
        while (true) {
            if (!it.hasNext()) {
                break;
            }
            UseCase next = it.next();
            AttachedSurfaceInfo attachedSurfaceInfoCreate = AttachedSurfaceInfo.create(this.mCameraDeviceSurfaceManager.transformSurfaceConfig(i, cameraId, next.getImageFormat(), next.getAttachedSurfaceResolution()), next.getImageFormat(), next.getAttachedSurfaceResolution(), ((StreamSpec) Preconditions.checkNotNull(next.getAttachedStreamSpec())).getDynamicRange(), getCaptureTypes(next), next.getAttachedStreamSpec().getImplementationOptions(), next.getCurrentConfig().getTargetFrameRate(null));
            arrayList.add(attachedSurfaceInfoCreate);
            map3.put(attachedSurfaceInfoCreate, next);
            map2.put(next, next.getAttachedStreamSpec());
        }
        if (!collection.isEmpty()) {
            HashMap map4 = new HashMap();
            HashMap map5 = new HashMap();
            try {
                sensorRect = this.mCameraInternal.getCameraControlInternal().getSensorRect();
            } catch (NullPointerException unused) {
                sensorRect = null;
            }
            SupportedOutputSizesSorter supportedOutputSizesSorter = new SupportedOutputSizesSorter(cameraInfoInternal, sensorRect != null ? TransformUtils.rectToSize(sensorRect) : null);
            for (UseCase useCase : collection) {
                ConfigPair configPair = map.get(useCase);
                UseCaseConfig<?> useCaseConfigMergeConfigs = useCase.mergeConfigs(cameraInfoInternal, configPair.mExtendedConfig, configPair.mCameraConfig);
                map4.put(useCaseConfigMergeConfigs, useCase);
                map5.put(useCaseConfigMergeConfigs, supportedOutputSizesSorter.getSortedSupportedOutputSizes(useCaseConfigMergeConfigs));
            }
            Pair<Map<UseCaseConfig<?>, StreamSpec>, Map<AttachedSurfaceInfo, StreamSpec>> suggestedStreamSpecs = this.mCameraDeviceSurfaceManager.getSuggestedStreamSpecs(i, cameraId, arrayList, map5);
            for (Map.Entry entry : map4.entrySet()) {
                map2.put((UseCase) entry.getValue(), (StreamSpec) ((Map) suggestedStreamSpecs.first).get(entry.getKey()));
            }
            for (Map.Entry entry2 : ((Map) suggestedStreamSpecs.second).entrySet()) {
                if (map3.containsKey(entry2.getKey())) {
                    map2.put((UseCase) map3.get(entry2.getKey()), (StreamSpec) entry2.getValue());
                }
            }
        }
        return map2;
    }

    private ImageCapture createExtraImageCapture() {
        return new ImageCapture.Builder().setTargetName("ImageCapture-Extra").build();
    }

    private Preview createExtraPreview() {
        Preview previewBuild = new Preview.Builder().setTargetName("Preview-Extra").build();
        previewBuild.setSurfaceProvider(new Preview.SurfaceProvider() { // from class: com.zj.adlib.uc1
            @Override // androidx.camera.core.Preview.SurfaceProvider
            public final void onSurfaceRequested(SurfaceRequest surfaceRequest) {
                CameraUseCaseAdapter.lambda$createExtraPreview$1(surfaceRequest);
            }
        });
        return previewBuild;
    }

    @Nullable
    private StreamSharing createOrReuseStreamSharing(@NonNull Collection<UseCase> collection, boolean z) {
        synchronized (this.mLock) {
            Set<UseCase> streamSharingChildren = getStreamSharingChildren(collection, z);
            if (streamSharingChildren.size() < 2) {
                return null;
            }
            StreamSharing streamSharing = this.mStreamSharing;
            if (streamSharing != null && streamSharing.getChildren().equals(streamSharingChildren)) {
                StreamSharing streamSharing2 = this.mStreamSharing;
                Objects.requireNonNull(streamSharing2);
                return streamSharing2;
            }
            if (!isStreamSharingChildrenCombinationValid(streamSharingChildren)) {
                return null;
            }
            return new StreamSharing(this.mCameraInternal, streamSharingChildren, this.mUseCaseConfigFactory);
        }
    }

    @NonNull
    public static CameraId generateCameraId(@NonNull LinkedHashSet<CameraInternal> linkedHashSet) {
        return new CameraId(linkedHashSet);
    }

    private int getCameraMode() {
        synchronized (this.mLock) {
            return this.mCameraCoordinator.getCameraOperatingMode() == 2 ? 1 : 0;
        }
    }

    @NonNull
    private static List<UseCaseConfigFactory.CaptureType> getCaptureTypes(UseCase useCase) {
        ArrayList arrayList = new ArrayList();
        if (isStreamSharing(useCase)) {
            Iterator<UseCase> it = ((StreamSharing) useCase).getChildren().iterator();
            while (it.hasNext()) {
                arrayList.add(it.next().getCurrentConfig().getCaptureType());
            }
        } else {
            arrayList.add(useCase.getCurrentConfig().getCaptureType());
        }
        return arrayList;
    }

    private Map<UseCase, ConfigPair> getConfigs(Collection<UseCase> collection, UseCaseConfigFactory useCaseConfigFactory, UseCaseConfigFactory useCaseConfigFactory2) {
        HashMap map = new HashMap();
        for (UseCase useCase : collection) {
            map.put(useCase, new ConfigPair(useCase.getDefaultConfig(false, useCaseConfigFactory), useCase.getDefaultConfig(true, useCaseConfigFactory2)));
        }
        return map;
    }

    private int getSharingTargets(boolean z) {
        int targets;
        synchronized (this.mLock) {
            Iterator<CameraEffect> it = this.mEffects.iterator();
            CameraEffect cameraEffect = null;
            while (true) {
                targets = 0;
                if (!it.hasNext()) {
                    break;
                }
                CameraEffect next = it.next();
                if (TargetUtils.getNumberOfTargets(next.getTargets()) > 1) {
                    Preconditions.checkState(cameraEffect == null, "Can only have one sharing effect.");
                    cameraEffect = next;
                }
            }
            if (cameraEffect != null) {
                targets = cameraEffect.getTargets();
            }
            if (z) {
                targets |= 3;
            }
        }
        return targets;
    }

    @NonNull
    private Set<UseCase> getStreamSharingChildren(@NonNull Collection<UseCase> collection, boolean z) {
        HashSet hashSet = new HashSet();
        int sharingTargets = getSharingTargets(z);
        for (UseCase useCase : collection) {
            Preconditions.checkArgument(!isStreamSharing(useCase), "Only support one level of sharing for now.");
            if (useCase.isEffectTargetsSupported(sharingTargets)) {
                hashSet.add(useCase);
            }
        }
        return hashSet;
    }

    private static boolean hasImplementationOptionChanged(StreamSpec streamSpec, SessionConfig sessionConfig) {
        Config implementationOptions = streamSpec.getImplementationOptions();
        Config implementationOptions2 = sessionConfig.getImplementationOptions();
        if (implementationOptions.listOptions().size() != sessionConfig.getImplementationOptions().listOptions().size()) {
            return true;
        }
        for (Config.Option<?> option : implementationOptions.listOptions()) {
            if (!implementationOptions2.containsOption(option) || !Objects.equals(implementationOptions2.retrieveOption(option), implementationOptions.retrieveOption(option))) {
                return true;
            }
        }
        return false;
    }

    private boolean hasNoExtension() {
        boolean z;
        synchronized (this.mLock) {
            z = this.mCameraConfig == CameraConfigs.emptyConfig();
        }
        return z;
    }

    private boolean isCoexistingPreviewImageCaptureRequired() {
        boolean z;
        synchronized (this.mLock) {
            z = true;
            if (this.mCameraConfig.getUseCaseCombinationRequiredRule() != 1) {
                z = false;
            }
        }
        return z;
    }

    private boolean isExtraImageCaptureRequired(@NonNull Collection<UseCase> collection) {
        boolean z = false;
        boolean z2 = false;
        for (UseCase useCase : collection) {
            if (isPreview(useCase)) {
                z = true;
            } else if (isImageCapture(useCase)) {
                z2 = true;
            }
        }
        return z && !z2;
    }

    private boolean isExtraPreviewRequired(@NonNull Collection<UseCase> collection) {
        boolean z = false;
        boolean z2 = false;
        for (UseCase useCase : collection) {
            if (isPreview(useCase)) {
                z2 = true;
            } else if (isImageCapture(useCase)) {
                z = true;
            }
        }
        return z && !z2;
    }

    private static boolean isImageCapture(@Nullable UseCase useCase) {
        return useCase instanceof ImageCapture;
    }

    private static boolean isPreview(@Nullable UseCase useCase) {
        return useCase instanceof Preview;
    }

    private static boolean isStreamSharing(@Nullable UseCase useCase) {
        return useCase instanceof StreamSharing;
    }

    public static boolean isStreamSharingChildrenCombinationValid(@NonNull Collection<UseCase> collection) {
        int[] iArr = {1, 2, 4};
        HashSet hashSet = new HashSet();
        for (UseCase useCase : collection) {
            for (int i = 0; i < 3; i++) {
                int i2 = iArr[i];
                if (useCase.isEffectTargetsSupported(i2)) {
                    if (hashSet.contains(Integer.valueOf(i2))) {
                        return false;
                    }
                    hashSet.add(Integer.valueOf(i2));
                }
            }
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void lambda$createExtraPreview$0(Surface surface, SurfaceTexture surfaceTexture, SurfaceRequest.Result result) {
        surface.release();
        surfaceTexture.release();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void lambda$createExtraPreview$1(SurfaceRequest surfaceRequest) {
        final SurfaceTexture surfaceTexture = new SurfaceTexture(0);
        surfaceTexture.setDefaultBufferSize(surfaceRequest.getResolution().getWidth(), surfaceRequest.getResolution().getHeight());
        surfaceTexture.detachFromGLContext();
        final Surface surface = new Surface(surfaceTexture);
        surfaceRequest.provideSurface(surface, CameraXExecutors.directExecutor(), new Consumer(surface, surfaceTexture) { // from class: com.zj.adlib.tc1

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final /* synthetic */ SurfaceTexture f44888a;

            /* JADX INFO: renamed from: a, reason: collision with other field name */
            public final /* synthetic */ Surface f19770a;

            @Override // androidx.core.util.Consumer
            public final void accept(Object obj) {
            }
        });
    }

    private void restoreInteropConfig() {
        synchronized (this.mLock) {
            if (this.mInteropConfig != null) {
                this.mCameraInternal.getCameraControlInternal().addInteropConfig(this.mInteropConfig);
            }
        }
    }

    @NonNull
    private static List<CameraEffect> setEffectsOnUseCases(@NonNull List<CameraEffect> list, @NonNull Collection<UseCase> collection) {
        ArrayList arrayList = new ArrayList(list);
        for (UseCase useCase : collection) {
            useCase.setEffect(null);
            for (CameraEffect cameraEffect : list) {
                if (useCase.isEffectTargetsSupported(cameraEffect.getTargets())) {
                    Preconditions.checkState(useCase.getEffect() == null, useCase + " already has effect" + useCase.getEffect());
                    useCase.setEffect(cameraEffect);
                    arrayList.remove(cameraEffect);
                }
            }
        }
        return arrayList;
    }

    @VisibleForTesting
    public static void updateEffects(@NonNull List<CameraEffect> list, @NonNull Collection<UseCase> collection, @NonNull Collection<UseCase> collection2) {
        List<CameraEffect> effectsOnUseCases = setEffectsOnUseCases(list, collection);
        ArrayList arrayList = new ArrayList(collection2);
        arrayList.removeAll(collection);
        List<CameraEffect> effectsOnUseCases2 = setEffectsOnUseCases(effectsOnUseCases, arrayList);
        if (effectsOnUseCases2.size() > 0) {
            Logger.w(TAG, "Unused effects: " + effectsOnUseCases2);
        }
    }

    private void updateViewPort(@NonNull Map<UseCase, StreamSpec> map, @NonNull Collection<UseCase> collection) {
        synchronized (this.mLock) {
            if (this.mViewPort != null) {
                Integer numValueOf = Integer.valueOf(this.mCameraInternal.getCameraInfoInternal().getLensFacing());
                boolean z = true;
                if (numValueOf == null) {
                    Logger.w(TAG, "The lens facing is null, probably an external.");
                } else if (numValueOf.intValue() != 0) {
                    z = false;
                }
                Map<UseCase, Rect> mapCalculateViewPortRects = ViewPorts.calculateViewPortRects(this.mCameraInternal.getCameraControlInternal().getSensorRect(), z, this.mViewPort.getAspectRatio(), this.mCameraInternal.getCameraInfoInternal().getSensorRotationDegrees(this.mViewPort.getRotation()), this.mViewPort.getScaleType(), this.mViewPort.getLayoutDirection(), map);
                for (UseCase useCase : collection) {
                    useCase.setViewPortCropRect((Rect) Preconditions.checkNotNull(mapCalculateViewPortRects.get(useCase)));
                    useCase.setSensorToBufferTransformMatrix(calculateSensorToBufferTransformMatrix(this.mCameraInternal.getCameraControlInternal().getSensorRect(), ((StreamSpec) Preconditions.checkNotNull(map.get(useCase))).getResolution()));
                }
            }
        }
    }

    public void addUseCases(@NonNull Collection<UseCase> collection) throws CameraException {
        synchronized (this.mLock) {
            LinkedHashSet linkedHashSet = new LinkedHashSet(this.mAppUseCases);
            linkedHashSet.addAll(collection);
            try {
                updateUseCases(linkedHashSet);
            } catch (IllegalArgumentException e) {
                throw new CameraException(e.getMessage());
            }
        }
    }

    public void attachUseCases() {
        synchronized (this.mLock) {
            if (!this.mAttached) {
                this.mCameraInternal.attachUseCases(this.mCameraUseCases);
                restoreInteropConfig();
                Iterator<UseCase> it = this.mCameraUseCases.iterator();
                while (it.hasNext()) {
                    it.next().notifyState();
                }
                this.mAttached = true;
            }
        }
    }

    /* JADX WARN: Code duplicated, block: B:18:0x0035  */
    @Nullable
    public UseCase calculatePlaceholderForExtensions(@NonNull Collection<UseCase> collection) {
        UseCase useCaseCreateExtraImageCapture;
        synchronized (this.mLock) {
            if (!isCoexistingPreviewImageCaptureRequired()) {
                useCaseCreateExtraImageCapture = null;
            } else if (isExtraPreviewRequired(collection)) {
                useCaseCreateExtraImageCapture = isPreview(this.mPlaceholderForExtensions) ? this.mPlaceholderForExtensions : createExtraPreview();
            } else if (isExtraImageCaptureRequired(collection)) {
                useCaseCreateExtraImageCapture = isImageCapture(this.mPlaceholderForExtensions) ? this.mPlaceholderForExtensions : createExtraImageCapture();
            } else {
                useCaseCreateExtraImageCapture = null;
            }
        }
        return useCaseCreateExtraImageCapture;
    }

    public void detachUseCases() {
        synchronized (this.mLock) {
            if (this.mAttached) {
                this.mCameraInternal.detachUseCases(new ArrayList(this.mCameraUseCases));
                cacheInteropConfig();
                this.mAttached = false;
            }
        }
    }

    @Override // androidx.camera.core.Camera
    @NonNull
    public CameraControl getCameraControl() {
        return this.mRestrictedCameraControl;
    }

    @NonNull
    public CameraId getCameraId() {
        return this.mId;
    }

    @Override // androidx.camera.core.Camera
    @NonNull
    public CameraInfo getCameraInfo() {
        return this.mRestrictedCameraInfo;
    }

    @Override // androidx.camera.core.Camera
    @NonNull
    public LinkedHashSet<CameraInternal> getCameraInternals() {
        return this.mCameraInternals;
    }

    @NonNull
    @VisibleForTesting
    public Collection<UseCase> getCameraUseCases() {
        ArrayList arrayList;
        synchronized (this.mLock) {
            arrayList = new ArrayList(this.mCameraUseCases);
        }
        return arrayList;
    }

    @Override // androidx.camera.core.Camera
    @NonNull
    public CameraConfig getExtendedConfig() {
        CameraConfig cameraConfig;
        synchronized (this.mLock) {
            cameraConfig = this.mCameraConfig;
        }
        return cameraConfig;
    }

    @NonNull
    public List<UseCase> getUseCases() {
        ArrayList arrayList;
        synchronized (this.mLock) {
            arrayList = new ArrayList(this.mAppUseCases);
        }
        return arrayList;
    }

    public boolean isEquivalent(@NonNull CameraUseCaseAdapter cameraUseCaseAdapter) {
        return this.mId.equals(cameraUseCaseAdapter.getCameraId());
    }

    @Override // androidx.camera.core.Camera
    public boolean isUseCasesCombinationSupported(@NonNull UseCase... useCaseArr) {
        synchronized (this.mLock) {
            try {
                try {
                    calculateSuggestedStreamSpecs(getCameraMode(), this.mCameraInternal.getCameraInfoInternal(), Arrays.asList(useCaseArr), Collections.emptyList(), getConfigs(Arrays.asList(useCaseArr), this.mCameraConfig.getUseCaseConfigFactory(), this.mUseCaseConfigFactory));
                } catch (IllegalArgumentException unused) {
                    return false;
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        return true;
    }

    public void removeUseCases(@NonNull Collection<UseCase> collection) {
        synchronized (this.mLock) {
            LinkedHashSet linkedHashSet = new LinkedHashSet(this.mAppUseCases);
            linkedHashSet.removeAll(collection);
            updateUseCases(linkedHashSet);
        }
    }

    public void setActiveResumingMode(boolean z) {
        this.mCameraInternal.setActiveResumingMode(z);
    }

    public void setEffects(@Nullable List<CameraEffect> list) {
        synchronized (this.mLock) {
            this.mEffects = list;
        }
    }

    @Override // androidx.camera.core.Camera
    public void setExtendedConfig(@Nullable CameraConfig cameraConfig) {
        synchronized (this.mLock) {
            if (cameraConfig == null) {
                cameraConfig = CameraConfigs.emptyConfig();
            }
            if (!this.mAppUseCases.isEmpty() && !this.mCameraConfig.getCompatibilityId().equals(cameraConfig.getCompatibilityId())) {
                throw new IllegalStateException("Need to unbind all use cases before binding with extension enabled");
            }
            this.mCameraConfig = cameraConfig;
            SessionProcessor sessionProcessor = cameraConfig.getSessionProcessor(null);
            if (sessionProcessor != null) {
                this.mRestrictedCameraControl.enableRestrictedOperations(true, sessionProcessor.getSupportedCameraOperations());
            } else {
                this.mRestrictedCameraControl.enableRestrictedOperations(false, null);
            }
            this.mCameraInternal.setExtendedConfig(this.mCameraConfig);
        }
    }

    public void setViewPort(@Nullable ViewPort viewPort) {
        synchronized (this.mLock) {
            this.mViewPort = viewPort;
        }
    }

    public void updateUseCases(@NonNull Collection<UseCase> collection) {
        updateUseCases(collection, false);
    }

    public void updateUseCases(@NonNull Collection<UseCase> collection, boolean z) {
        StreamSpec streamSpec;
        Config implementationOptions;
        synchronized (this.mLock) {
            try {
                UseCase useCaseCalculatePlaceholderForExtensions = calculatePlaceholderForExtensions(collection);
                StreamSharing streamSharingCreateOrReuseStreamSharing = createOrReuseStreamSharing(collection, z);
                Collection<UseCase> collectionCalculateCameraUseCases = calculateCameraUseCases(collection, useCaseCalculatePlaceholderForExtensions, streamSharingCreateOrReuseStreamSharing);
                ArrayList<UseCase> arrayList = new ArrayList(collectionCalculateCameraUseCases);
                arrayList.removeAll(this.mCameraUseCases);
                ArrayList<UseCase> arrayList2 = new ArrayList(collectionCalculateCameraUseCases);
                arrayList2.retainAll(this.mCameraUseCases);
                ArrayList arrayList3 = new ArrayList(this.mCameraUseCases);
                arrayList3.removeAll(collectionCalculateCameraUseCases);
                Map<UseCase, ConfigPair> configs = getConfigs(arrayList, this.mCameraConfig.getUseCaseConfigFactory(), this.mUseCaseConfigFactory);
                try {
                    Map<UseCase, StreamSpec> mapCalculateSuggestedStreamSpecs = calculateSuggestedStreamSpecs(getCameraMode(), this.mCameraInternal.getCameraInfoInternal(), arrayList, arrayList2, configs);
                    updateViewPort(mapCalculateSuggestedStreamSpecs, collectionCalculateCameraUseCases);
                    updateEffects(this.mEffects, collectionCalculateCameraUseCases, collection);
                    Iterator it = arrayList3.iterator();
                    while (it.hasNext()) {
                        ((UseCase) it.next()).unbindFromCamera(this.mCameraInternal);
                    }
                    this.mCameraInternal.detachUseCases(arrayList3);
                    if (!arrayList3.isEmpty()) {
                        for (UseCase useCase : arrayList2) {
                            if (mapCalculateSuggestedStreamSpecs.containsKey(useCase) && (implementationOptions = (streamSpec = mapCalculateSuggestedStreamSpecs.get(useCase)).getImplementationOptions()) != null && hasImplementationOptionChanged(streamSpec, useCase.getSessionConfig())) {
                                useCase.updateSuggestedStreamSpecImplementationOptions(implementationOptions);
                            }
                        }
                    }
                    for (UseCase useCase2 : arrayList) {
                        ConfigPair configPair = configs.get(useCase2);
                        Objects.requireNonNull(configPair);
                        useCase2.bindToCamera(this.mCameraInternal, configPair.mExtendedConfig, configPair.mCameraConfig);
                        useCase2.updateSuggestedStreamSpec((StreamSpec) Preconditions.checkNotNull(mapCalculateSuggestedStreamSpecs.get(useCase2)));
                    }
                    if (this.mAttached) {
                        this.mCameraInternal.attachUseCases(arrayList);
                    }
                    Iterator it2 = arrayList.iterator();
                    while (it2.hasNext()) {
                        ((UseCase) it2.next()).notifyState();
                    }
                    this.mAppUseCases.clear();
                    this.mAppUseCases.addAll(collection);
                    this.mCameraUseCases.clear();
                    this.mCameraUseCases.addAll(collectionCalculateCameraUseCases);
                    this.mPlaceholderForExtensions = useCaseCalculatePlaceholderForExtensions;
                    this.mStreamSharing = streamSharingCreateOrReuseStreamSharing;
                } catch (IllegalArgumentException e) {
                    if (z || !hasNoExtension() || this.mCameraCoordinator.getCameraOperatingMode() == 2) {
                        throw e;
                    }
                    updateUseCases(collection, true);
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }
}

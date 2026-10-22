package androidx.camera.video;

import android.annotation.SuppressLint;
import android.graphics.Rect;
import android.media.MediaCodec;
import android.os.SystemClock;
import android.util.Pair;
import android.util.Range;
import android.util.Size;
import androidx.annotation.MainThread;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.annotation.RestrictTo;
import androidx.annotation.VisibleForTesting;
import androidx.arch.core.util.Function;
import androidx.camera.core.CameraInfo;
import androidx.camera.core.CameraSelector;
import androidx.camera.core.DynamicRange;
import androidx.camera.core.Logger;
import androidx.camera.core.SurfaceRequest;
import androidx.camera.core.UseCase;
import androidx.camera.core.impl.CameraCaptureCallback;
import androidx.camera.core.impl.CameraCaptureResult;
import androidx.camera.core.impl.CameraInfoInternal;
import androidx.camera.core.impl.CameraInternal;
import androidx.camera.core.impl.CaptureConfig;
import androidx.camera.core.impl.Config;
import androidx.camera.core.impl.ConfigProvider;
import androidx.camera.core.impl.DeferrableSurface;
import androidx.camera.core.impl.ImageInputConfig;
import androidx.camera.core.impl.ImageOutputConfig;
import androidx.camera.core.impl.MutableConfig;
import androidx.camera.core.impl.MutableOptionsBundle;
import androidx.camera.core.impl.Observable;
import androidx.camera.core.impl.OptionsBundle;
import androidx.camera.core.impl.SessionConfig;
import androidx.camera.core.impl.StreamSpec;
import androidx.camera.core.impl.Timebase;
import androidx.camera.core.impl.UseCaseConfig;
import androidx.camera.core.impl.UseCaseConfigFactory;
import androidx.camera.core.impl.utils.Threads;
import androidx.camera.core.impl.utils.TransformUtils;
import androidx.camera.core.impl.utils.executor.CameraXExecutors;
import androidx.camera.core.impl.utils.futures.FutureCallback;
import androidx.camera.core.impl.utils.futures.Futures;
import androidx.camera.core.internal.TargetConfig;
import androidx.camera.core.internal.ThreadConfig;
import androidx.camera.core.internal.UseCaseEventConfig;
import androidx.camera.core.processing.DefaultSurfaceProcessor;
import androidx.camera.core.processing.SurfaceEdge;
import androidx.camera.core.processing.SurfaceProcessorNode;
import androidx.camera.core.resolutionselector.ResolutionSelector;
import androidx.camera.video.VideoCapture;
import androidx.camera.video.VideoOutput;
import androidx.camera.video.impl.VideoCaptureConfig;
import androidx.camera.video.internal.VideoValidatedEncoderProfilesProxy;
import androidx.camera.video.internal.compat.quirk.DeviceQuirks;
import androidx.camera.video.internal.compat.quirk.ExtraSupportedResolutionQuirk;
import androidx.camera.video.internal.compat.quirk.ImageCaptureFailedWhenVideoCaptureIsBoundQuirk;
import androidx.camera.video.internal.compat.quirk.PreviewDelayWhenVideoCaptureIsBoundQuirk;
import androidx.camera.video.internal.compat.quirk.PreviewStretchWhenVideoCaptureIsBoundQuirk;
import androidx.camera.video.internal.compat.quirk.VideoQualityQuirk;
import androidx.camera.video.internal.config.VideoConfigUtil;
import androidx.camera.video.internal.encoder.InvalidConfigException;
import androidx.camera.video.internal.encoder.VideoEncoderConfig;
import androidx.camera.video.internal.encoder.VideoEncoderInfo;
import androidx.camera.video.internal.encoder.VideoEncoderInfoImpl;
import androidx.camera.video.internal.workaround.VideoEncoderInfoWrapper;
import androidx.concurrent.futures.CallbackToFutureAdapter;
import androidx.core.util.Preconditions;
import com.google.common.util.concurrent.ListenableFuture;
import com.zj.adlib.c49;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;
import java.util.Set;
import java.util.UUID;
import java.util.concurrent.CancellationException;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executor;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_13_8952cls.dex */
@RequiresApi(21)
public final class VideoCapture<T extends VideoOutput> extends UseCase {
    private static final Defaults DEFAULT_CONFIG = new Defaults();
    private static final String SURFACE_UPDATE_KEY = "androidx.camera.video.VideoCapture.streamUpdate";
    private static final String TAG = "VideoCapture";
    private static final boolean USE_TEMPLATE_PREVIEW_BY_QUIRK;

    @VisibleForTesting
    static boolean sEnableSurfaceProcessingByQuirk;

    @Nullable
    private SurfaceEdge mCameraEdge;

    @Nullable
    private Rect mCropRect;
    DeferrableSurface mDeferrableSurface;
    private boolean mHasCompensatingTransformation;

    @Nullable
    private SurfaceProcessorNode mNode;
    private int mRotationDegrees;

    @NonNull
    SessionConfig.Builder mSessionConfigBuilder;
    VideoOutput.SourceState mSourceState;
    StreamInfo mStreamInfo;
    private final Observable.Observer<StreamInfo> mStreamInfoObserver;
    private SurfaceRequest mSurfaceRequest;
    ListenableFuture<Void> mSurfaceUpdateFuture;

    @Nullable
    private VideoEncoderInfo mVideoEncoderInfo;

    /* JADX INFO: renamed from: androidx.camera.video.VideoCapture$2, reason: invalid class name */
    public class AnonymousClass2 extends CameraCaptureCallback {
        private boolean mIsFirstCaptureResult = true;
        final /* synthetic */ CallbackToFutureAdapter.Completer val$completer;
        final /* synthetic */ SessionConfig.Builder val$sessionConfigBuilder;
        final /* synthetic */ AtomicBoolean val$surfaceUpdateComplete;

        public AnonymousClass2(AtomicBoolean atomicBoolean, CallbackToFutureAdapter.Completer completer, SessionConfig.Builder builder) {
            this.val$surfaceUpdateComplete = atomicBoolean;
            this.val$completer = completer;
            this.val$sessionConfigBuilder = builder;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$onCaptureCompleted$0(SessionConfig.Builder builder) {
            builder.removeCameraCaptureCallback(this);
        }

        @Override // androidx.camera.core.impl.CameraCaptureCallback
        public void onCaptureCompleted(@NonNull CameraCaptureResult cameraCaptureResult) {
            Object tag;
            super.onCaptureCompleted(cameraCaptureResult);
            if (this.mIsFirstCaptureResult) {
                this.mIsFirstCaptureResult = false;
                Logger.d(VideoCapture.TAG, "cameraCaptureResult timestampNs = " + cameraCaptureResult.getTimestamp() + ", current system uptimeMs = " + SystemClock.uptimeMillis() + ", current system realtimeMs = " + SystemClock.elapsedRealtime());
            }
            if (this.val$surfaceUpdateComplete.get() || (tag = cameraCaptureResult.getTagBundle().getTag(VideoCapture.SURFACE_UPDATE_KEY)) == null || ((Integer) tag).intValue() != this.val$completer.hashCode() || !this.val$completer.set(null) || this.val$surfaceUpdateComplete.getAndSet(true)) {
                return;
            }
            ScheduledExecutorService scheduledExecutorServiceMainThreadExecutor = CameraXExecutors.mainThreadExecutor();
            final SessionConfig.Builder builder = this.val$sessionConfigBuilder;
            scheduledExecutorServiceMainThreadExecutor.execute(new Runnable() { // from class: androidx.camera.video.o
                @Override // java.lang.Runnable
                public final void run() {
                    this.f160a.lambda$onCaptureCompleted$0(builder);
                }
            });
        }
    }

    @RequiresApi(21)
    public static final class Builder<T extends VideoOutput> implements UseCaseConfig.Builder<VideoCapture<T>, VideoCaptureConfig<T>, Builder<T>>, ImageOutputConfig.Builder<Builder<T>>, ImageInputConfig.Builder<Builder<T>>, ThreadConfig.Builder<Builder<T>> {
        private final MutableOptionsBundle mMutableConfig;

        public Builder(@NonNull T t) {
            this(createInitialBundle(t));
        }

        @NonNull
        private static <T extends VideoOutput> MutableOptionsBundle createInitialBundle(@NonNull T t) {
            MutableOptionsBundle mutableOptionsBundleCreate = MutableOptionsBundle.create();
            mutableOptionsBundleCreate.insertOption(VideoCaptureConfig.OPTION_VIDEO_OUTPUT, t);
            return mutableOptionsBundleCreate;
        }

        @NonNull
        @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
        public static Builder<? extends VideoOutput> fromConfig(@NonNull Config config) {
            return new Builder<>(MutableOptionsBundle.from(config));
        }

        @Override // androidx.camera.core.ExtendableBuilder
        @NonNull
        @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
        public MutableConfig getMutableConfig() {
            return this.mMutableConfig;
        }

        @Override // androidx.camera.core.impl.ImageOutputConfig.Builder
        @NonNull
        @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
        public /* bridge */ /* synthetic */ Object setCustomOrderedResolutions(@NonNull List list) {
            return setCustomOrderedResolutions((List<Size>) list);
        }

        @Override // androidx.camera.core.impl.ImageOutputConfig.Builder
        @NonNull
        @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
        public /* bridge */ /* synthetic */ Object setSupportedResolutions(@NonNull List list) {
            return setSupportedResolutions((List<Pair<Integer, Size[]>>) list);
        }

        @NonNull
        public Builder<T> setTargetFrameRate(@NonNull Range<Integer> range) {
            getMutableConfig().insertOption(UseCaseConfig.OPTION_TARGET_FRAME_RATE, range);
            return this;
        }

        @NonNull
        public Builder<T> setVideoEncoderInfoFinder(@NonNull Function<VideoEncoderConfig, VideoEncoderInfo> function) {
            getMutableConfig().insertOption(VideoCaptureConfig.OPTION_VIDEO_ENCODER_INFO_FINDER, function);
            return this;
        }

        private Builder(@NonNull MutableOptionsBundle mutableOptionsBundle) {
            this.mMutableConfig = mutableOptionsBundle;
            if (!mutableOptionsBundle.containsOption(VideoCaptureConfig.OPTION_VIDEO_OUTPUT)) {
                throw new IllegalArgumentException("VideoOutput is required");
            }
            Class cls = (Class) mutableOptionsBundle.retrieveOption(TargetConfig.OPTION_TARGET_CLASS, null);
            if (cls == null || cls.equals(VideoCapture.class)) {
                setTargetClass((Class) VideoCapture.class);
                return;
            }
            throw new IllegalArgumentException("Invalid target class configuration for " + this + ": " + cls);
        }

        @NonNull
        @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
        public static <T extends VideoOutput> Builder<T> fromConfig(@NonNull VideoCaptureConfig<T> videoCaptureConfig) {
            return new Builder<>(MutableOptionsBundle.from((Config) videoCaptureConfig));
        }

        @Override // androidx.camera.core.ExtendableBuilder
        @NonNull
        public VideoCapture<T> build() {
            return new VideoCapture<>(getUseCaseConfig());
        }

        @Override // androidx.camera.core.impl.UseCaseConfig.Builder
        @NonNull
        @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
        public VideoCaptureConfig<T> getUseCaseConfig() {
            return new VideoCaptureConfig<>(OptionsBundle.from(this.mMutableConfig));
        }

        @Override // androidx.camera.core.internal.ThreadConfig.Builder
        @NonNull
        @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
        public Builder<T> setBackgroundExecutor(@NonNull Executor executor) {
            getMutableConfig().insertOption(ThreadConfig.OPTION_BACKGROUND_EXECUTOR, executor);
            return this;
        }

        @Override // androidx.camera.core.impl.UseCaseConfig.Builder
        @NonNull
        @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
        public Builder<T> setCameraSelector(@NonNull CameraSelector cameraSelector) {
            getMutableConfig().insertOption(UseCaseConfig.OPTION_CAMERA_SELECTOR, cameraSelector);
            return this;
        }

        @Override // androidx.camera.core.impl.UseCaseConfig.Builder
        @NonNull
        @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
        public Builder<T> setCaptureOptionUnpacker(@NonNull CaptureConfig.OptionUnpacker optionUnpacker) {
            getMutableConfig().insertOption(UseCaseConfig.OPTION_CAPTURE_CONFIG_UNPACKER, optionUnpacker);
            return this;
        }

        @Override // androidx.camera.core.impl.UseCaseConfig.Builder
        @NonNull
        @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
        public Builder<T> setCaptureType(@NonNull UseCaseConfigFactory.CaptureType captureType) {
            getMutableConfig().insertOption(UseCaseConfig.OPTION_CAPTURE_TYPE, captureType);
            return this;
        }

        @Override // androidx.camera.core.impl.ImageOutputConfig.Builder
        @NonNull
        @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
        public Builder<T> setCustomOrderedResolutions(@NonNull List<Size> list) {
            getMutableConfig().insertOption(ImageOutputConfig.OPTION_CUSTOM_ORDERED_RESOLUTIONS, list);
            return this;
        }

        @Override // androidx.camera.core.impl.UseCaseConfig.Builder
        @NonNull
        @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
        public Builder<T> setDefaultCaptureConfig(@NonNull CaptureConfig captureConfig) {
            getMutableConfig().insertOption(UseCaseConfig.OPTION_DEFAULT_CAPTURE_CONFIG, captureConfig);
            return this;
        }

        @Override // androidx.camera.core.impl.ImageOutputConfig.Builder
        @NonNull
        @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
        public Builder<T> setDefaultResolution(@NonNull Size size) {
            getMutableConfig().insertOption(ImageOutputConfig.OPTION_DEFAULT_RESOLUTION, size);
            return this;
        }

        @Override // androidx.camera.core.impl.UseCaseConfig.Builder
        @NonNull
        @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
        public Builder<T> setDefaultSessionConfig(@NonNull SessionConfig sessionConfig) {
            getMutableConfig().insertOption(UseCaseConfig.OPTION_DEFAULT_SESSION_CONFIG, sessionConfig);
            return this;
        }

        @Override // androidx.camera.core.impl.ImageInputConfig.Builder
        @NonNull
        public Builder<T> setDynamicRange(@NonNull DynamicRange dynamicRange) {
            getMutableConfig().insertOption(ImageInputConfig.OPTION_INPUT_DYNAMIC_RANGE, dynamicRange);
            return this;
        }

        @Override // androidx.camera.core.impl.UseCaseConfig.Builder
        @NonNull
        @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
        public Builder<T> setHighResolutionDisabled(boolean z) {
            getMutableConfig().insertOption(UseCaseConfig.OPTION_HIGH_RESOLUTION_DISABLED, Boolean.valueOf(z));
            return this;
        }

        @Override // androidx.camera.core.impl.ImageOutputConfig.Builder
        @NonNull
        @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
        public Builder<T> setMaxResolution(@NonNull Size size) {
            getMutableConfig().insertOption(ImageOutputConfig.OPTION_MAX_RESOLUTION, size);
            return this;
        }

        @Override // androidx.camera.core.impl.ImageOutputConfig.Builder
        @NonNull
        public Builder<T> setMirrorMode(int i) {
            getMutableConfig().insertOption(ImageOutputConfig.OPTION_MIRROR_MODE, Integer.valueOf(i));
            return this;
        }

        @Override // androidx.camera.core.impl.ImageOutputConfig.Builder
        @NonNull
        @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
        public Builder<T> setResolutionSelector(@NonNull ResolutionSelector resolutionSelector) {
            getMutableConfig().insertOption(ImageOutputConfig.OPTION_RESOLUTION_SELECTOR, resolutionSelector);
            return this;
        }

        @Override // androidx.camera.core.impl.UseCaseConfig.Builder
        @NonNull
        @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
        public Builder<T> setSessionOptionUnpacker(@NonNull SessionConfig.OptionUnpacker optionUnpacker) {
            getMutableConfig().insertOption(UseCaseConfig.OPTION_SESSION_CONFIG_UNPACKER, optionUnpacker);
            return this;
        }

        @Override // androidx.camera.core.impl.ImageOutputConfig.Builder
        @NonNull
        @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
        public Builder<T> setSupportedResolutions(@NonNull List<Pair<Integer, Size[]>> list) {
            getMutableConfig().insertOption(ImageOutputConfig.OPTION_SUPPORTED_RESOLUTIONS, list);
            return this;
        }

        @Override // androidx.camera.core.impl.UseCaseConfig.Builder
        @NonNull
        @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
        public Builder<T> setSurfaceOccupancyPriority(int i) {
            getMutableConfig().insertOption(UseCaseConfig.OPTION_SURFACE_OCCUPANCY_PRIORITY, Integer.valueOf(i));
            return this;
        }

        @Override // androidx.camera.core.impl.ImageOutputConfig.Builder
        @NonNull
        @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
        public Builder<T> setTargetAspectRatio(int i) {
            throw new UnsupportedOperationException("setTargetAspectRatio is not supported.");
        }

        @Override // androidx.camera.core.internal.TargetConfig.Builder
        @NonNull
        @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
        public Builder<T> setTargetClass(@NonNull Class<VideoCapture<T>> cls) {
            getMutableConfig().insertOption(TargetConfig.OPTION_TARGET_CLASS, cls);
            if (getMutableConfig().retrieveOption(TargetConfig.OPTION_TARGET_NAME, null) == null) {
                setTargetName(cls.getCanonicalName() + c49.f40900a + UUID.randomUUID());
            }
            return this;
        }

        @Override // androidx.camera.core.internal.TargetConfig.Builder
        @NonNull
        @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
        public Builder<T> setTargetName(@NonNull String str) {
            getMutableConfig().insertOption(TargetConfig.OPTION_TARGET_NAME, str);
            return this;
        }

        @Override // androidx.camera.core.impl.ImageOutputConfig.Builder
        @NonNull
        @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
        public Builder<T> setTargetResolution(@NonNull Size size) {
            throw new UnsupportedOperationException("setTargetResolution is not supported.");
        }

        @Override // androidx.camera.core.impl.ImageOutputConfig.Builder
        @NonNull
        public Builder<T> setTargetRotation(int i) {
            getMutableConfig().insertOption(ImageOutputConfig.OPTION_TARGET_ROTATION, Integer.valueOf(i));
            return this;
        }

        @Override // androidx.camera.core.internal.UseCaseEventConfig.Builder
        @NonNull
        @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
        public Builder<T> setUseCaseEventCallback(@NonNull UseCase.EventCallback eventCallback) {
            getMutableConfig().insertOption(UseCaseEventConfig.OPTION_USE_CASE_EVENT_CALLBACK, eventCallback);
            return this;
        }

        @Override // androidx.camera.core.impl.UseCaseConfig.Builder
        @NonNull
        @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
        public Builder<T> setZslDisabled(boolean z) {
            getMutableConfig().insertOption(UseCaseConfig.OPTION_ZSL_DISABLED, Boolean.valueOf(z));
            return this;
        }
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public static final class Defaults implements ConfigProvider<VideoCaptureConfig<?>> {
        private static final VideoCaptureConfig<?> DEFAULT_CONFIG;
        static final DynamicRange DEFAULT_DYNAMIC_RANGE;
        static final Range<Integer> DEFAULT_FPS_RANGE;
        private static final int DEFAULT_SURFACE_OCCUPANCY_PRIORITY = 5;
        private static final Function<VideoEncoderConfig, VideoEncoderInfo> DEFAULT_VIDEO_ENCODER_INFO_FINDER;
        private static final VideoOutput DEFAULT_VIDEO_OUTPUT;

        static {
            VideoOutput videoOutput = new VideoOutput() { // from class: com.zj.adlib.an9
                @Override // androidx.camera.video.VideoOutput
                public final void onSurfaceRequested(SurfaceRequest surfaceRequest) {
                    surfaceRequest.willNotProvideSurface();
                }
            };
            DEFAULT_VIDEO_OUTPUT = videoOutput;
            Function<VideoEncoderConfig, VideoEncoderInfo> functionCreateFinder = createFinder();
            DEFAULT_VIDEO_ENCODER_INFO_FINDER = functionCreateFinder;
            DEFAULT_FPS_RANGE = new Range<>(30, 30);
            DynamicRange dynamicRange = DynamicRange.SDR;
            DEFAULT_DYNAMIC_RANGE = dynamicRange;
            DEFAULT_CONFIG = new Builder(videoOutput).setSurfaceOccupancyPriority(5).setVideoEncoderInfoFinder(functionCreateFinder).setDynamicRange(dynamicRange).setCaptureType(UseCaseConfigFactory.CaptureType.VIDEO_CAPTURE).getUseCaseConfig();
        }

        @NonNull
        private static Function<VideoEncoderConfig, VideoEncoderInfo> createFinder() {
            return new Function() { // from class: com.zj.adlib.zm9
                @Override // androidx.arch.core.util.Function
                public final Object apply(Object obj) {
                }
            };
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static /* synthetic */ VideoEncoderInfo lambda$createFinder$0(VideoEncoderConfig videoEncoderConfig) {
            try {
                return VideoEncoderInfoImpl.from(videoEncoderConfig);
            } catch (InvalidConfigException e) {
                Logger.w(VideoCapture.TAG, "Unable to find VideoEncoderInfo", e);
                return null;
            }
        }

        @Override // androidx.camera.core.impl.ConfigProvider
        @NonNull
        public VideoCaptureConfig<?> getConfig() {
            return DEFAULT_CONFIG;
        }
    }

    static {
        boolean z = true;
        boolean z2 = DeviceQuirks.get(PreviewStretchWhenVideoCaptureIsBoundQuirk.class) != null;
        boolean z3 = DeviceQuirks.get(PreviewDelayWhenVideoCaptureIsBoundQuirk.class) != null;
        boolean z4 = DeviceQuirks.get(ImageCaptureFailedWhenVideoCaptureIsBoundQuirk.class) != null;
        boolean zHasVideoQualityQuirkAndWorkaroundBySurfaceProcessing = hasVideoQualityQuirkAndWorkaroundBySurfaceProcessing();
        boolean z5 = DeviceQuirks.get(ExtraSupportedResolutionQuirk.class) != null;
        USE_TEMPLATE_PREVIEW_BY_QUIRK = z2 || z3 || z4;
        if (!z3 && !z4 && !zHasVideoQualityQuirkAndWorkaroundBySurfaceProcessing && !z5) {
            z = false;
        }
        sEnableSurfaceProcessingByQuirk = z;
    }

    public VideoCapture(@NonNull VideoCaptureConfig<T> videoCaptureConfig) {
        super(videoCaptureConfig);
        this.mStreamInfo = StreamInfo.STREAM_INFO_ANY_INACTIVE;
        this.mSessionConfigBuilder = new SessionConfig.Builder();
        this.mSurfaceUpdateFuture = null;
        this.mSourceState = VideoOutput.SourceState.INACTIVE;
        this.mHasCompensatingTransformation = false;
        this.mStreamInfoObserver = new Observable.Observer<StreamInfo>() { // from class: androidx.camera.video.VideoCapture.1
            @Override // androidx.camera.core.impl.Observable.Observer
            public void onError(@NonNull Throwable th) {
                Logger.w(VideoCapture.TAG, "Receive onError from StreamState observer", th);
            }

            @Override // androidx.camera.core.impl.Observable.Observer
            public void onNewData(@Nullable StreamInfo streamInfo) {
                if (streamInfo == null) {
                    throw new IllegalArgumentException("StreamInfo can't be null");
                }
                if (VideoCapture.this.mSourceState == VideoOutput.SourceState.INACTIVE) {
                    return;
                }
                Logger.d(VideoCapture.TAG, "Stream info update: old: " + VideoCapture.this.mStreamInfo + " new: " + streamInfo);
                VideoCapture videoCapture = VideoCapture.this;
                StreamInfo streamInfo2 = videoCapture.mStreamInfo;
                videoCapture.mStreamInfo = streamInfo;
                StreamSpec streamSpec = (StreamSpec) Preconditions.checkNotNull(videoCapture.getAttachedStreamSpec());
                if (VideoCapture.this.isStreamIdChanged(streamInfo2.getId(), streamInfo.getId()) || VideoCapture.this.shouldResetCompensatingTransformation(streamInfo2, streamInfo)) {
                    VideoCapture videoCapture2 = VideoCapture.this;
                    videoCapture2.resetPipeline(videoCapture2.getCameraId(), (VideoCaptureConfig) VideoCapture.this.getCurrentConfig(), (StreamSpec) Preconditions.checkNotNull(VideoCapture.this.getAttachedStreamSpec()));
                    return;
                }
                if ((streamInfo2.getId() != -1 && streamInfo.getId() == -1) || (streamInfo2.getId() == -1 && streamInfo.getId() != -1)) {
                    VideoCapture videoCapture3 = VideoCapture.this;
                    videoCapture3.applyStreamInfoAndStreamSpecToSessionConfigBuilder(videoCapture3.mSessionConfigBuilder, streamInfo, streamSpec);
                    VideoCapture videoCapture4 = VideoCapture.this;
                    videoCapture4.updateSessionConfig(videoCapture4.mSessionConfigBuilder.build());
                    VideoCapture.this.notifyReset();
                    return;
                }
                if (streamInfo2.getStreamState() != streamInfo.getStreamState()) {
                    VideoCapture videoCapture5 = VideoCapture.this;
                    videoCapture5.applyStreamInfoAndStreamSpecToSessionConfigBuilder(videoCapture5.mSessionConfigBuilder, streamInfo, streamSpec);
                    VideoCapture videoCapture6 = VideoCapture.this;
                    videoCapture6.updateSessionConfig(videoCapture6.mSessionConfigBuilder.build());
                    VideoCapture.this.notifyUpdated();
                }
            }
        };
    }

    private static void addBySupportedSize(@NonNull Set<Size> set, int i, int i2, @NonNull Size size, @NonNull VideoEncoderInfo videoEncoderInfo) {
        if (i > size.getWidth() || i2 > size.getHeight()) {
            return;
        }
        try {
            set.add(new Size(i, ((Integer) videoEncoderInfo.getSupportedHeightsFor(i).clamp(Integer.valueOf(i2))).intValue()));
        } catch (IllegalArgumentException e) {
            Logger.w(TAG, "No supportedHeights for width: " + i, e);
        }
        try {
            set.add(new Size(((Integer) videoEncoderInfo.getSupportedWidthsFor(i2).clamp(Integer.valueOf(i))).intValue(), i2));
        } catch (IllegalArgumentException e2) {
            Logger.w(TAG, "No supportedWidths for height: " + i2, e2);
        }
    }

    @NonNull
    private static Rect adjustCropRectToValidSize(@NonNull final Rect rect, @NonNull Size size, @NonNull VideoEncoderInfo videoEncoderInfo) {
        Logger.d(TAG, String.format("Adjust cropRect %s by width/height alignment %d/%d and supported widths %s / supported heights %s", TransformUtils.rectToString(rect), Integer.valueOf(videoEncoderInfo.getWidthAlignment()), Integer.valueOf(videoEncoderInfo.getHeightAlignment()), videoEncoderInfo.getSupportedWidths(), videoEncoderInfo.getSupportedHeights()));
        int widthAlignment = videoEncoderInfo.getWidthAlignment();
        int heightAlignment = videoEncoderInfo.getHeightAlignment();
        Range<Integer> supportedWidths = videoEncoderInfo.getSupportedWidths();
        Range<Integer> supportedHeights = videoEncoderInfo.getSupportedHeights();
        int iAlignDown = alignDown(rect.width(), widthAlignment, supportedWidths);
        int iAlignUp = alignUp(rect.width(), widthAlignment, supportedWidths);
        int iAlignDown2 = alignDown(rect.height(), heightAlignment, supportedHeights);
        int iAlignUp2 = alignUp(rect.height(), heightAlignment, supportedHeights);
        HashSet hashSet = new HashSet();
        addBySupportedSize(hashSet, iAlignDown, iAlignDown2, size, videoEncoderInfo);
        addBySupportedSize(hashSet, iAlignDown, iAlignUp2, size, videoEncoderInfo);
        addBySupportedSize(hashSet, iAlignUp, iAlignDown2, size, videoEncoderInfo);
        addBySupportedSize(hashSet, iAlignUp, iAlignUp2, size, videoEncoderInfo);
        if (hashSet.isEmpty()) {
            Logger.w(TAG, "Can't find valid cropped size");
            return rect;
        }
        ArrayList arrayList = new ArrayList(hashSet);
        Logger.d(TAG, "candidatesList = " + arrayList);
        Collections.sort(arrayList, new Comparator(rect) { // from class: com.zj.adlib.sm9

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final /* synthetic */ Rect f44719a;

            @Override // java.util.Comparator
            public final int compare(Object obj, Object obj2) {
            }
        });
        Logger.d(TAG, "sorted candidatesList = " + arrayList);
        Size size2 = (Size) arrayList.get(0);
        int width = size2.getWidth();
        int height = size2.getHeight();
        if (width == rect.width() && height == rect.height()) {
            Logger.d(TAG, "No need to adjust cropRect because crop size is valid.");
            return rect;
        }
        Preconditions.checkState(width % 2 == 0 && height % 2 == 0 && width <= size.getWidth() && height <= size.getHeight());
        Rect rect2 = new Rect(rect);
        if (width != rect.width()) {
            int iMax = Math.max(0, rect.centerX() - (width / 2));
            rect2.left = iMax;
            int i = iMax + width;
            rect2.right = i;
            if (i > size.getWidth()) {
                int width2 = size.getWidth();
                rect2.right = width2;
                rect2.left = width2 - width;
            }
        }
        if (height != rect.height()) {
            int iMax2 = Math.max(0, rect.centerY() - (height / 2));
            rect2.top = iMax2;
            int i2 = iMax2 + height;
            rect2.bottom = i2;
            if (i2 > size.getHeight()) {
                int height2 = size.getHeight();
                rect2.bottom = height2;
                rect2.top = height2 - height;
            }
        }
        Logger.d(TAG, String.format("Adjust cropRect from %s to %s", TransformUtils.rectToString(rect), TransformUtils.rectToString(rect2)));
        return rect2;
    }

    @NonNull
    private Rect adjustCropRectWithInProgressTransformation(@NonNull Rect rect, int i) {
        return shouldCompensateTransformation() ? TransformUtils.sizeToRect(TransformUtils.getRotatedSize(((SurfaceRequest.TransformationInfo) Preconditions.checkNotNull(this.mStreamInfo.getInProgressTransformationInfo())).getCropRect(), i)) : rect;
    }

    @NonNull
    private Size adjustResolutionWithInProgressTransformation(@NonNull Size size, @NonNull Rect rect, @NonNull Rect rect2) {
        if (!shouldCompensateTransformation() || rect2.equals(rect)) {
            return size;
        }
        float fHeight = rect2.height() / rect.height();
        return new Size((int) Math.ceil(size.getWidth() * fHeight), (int) Math.ceil(size.getHeight() * fHeight));
    }

    private int adjustRotationWithInProgressTransformation(int i) {
        return shouldCompensateTransformation() ? TransformUtils.within360(i - this.mStreamInfo.getInProgressTransformationInfo().getRotationDegrees()) : i;
    }

    private static int align(boolean z, int i, int i2, @NonNull Range<Integer> range) {
        int i3 = i % i2;
        if (i3 != 0) {
            i = z ? i - i3 : i + (i2 - i3);
        }
        return ((Integer) range.clamp(Integer.valueOf(i))).intValue();
    }

    private static int alignDown(int i, int i2, @NonNull Range<Integer> range) {
        return align(true, i, i2, range);
    }

    private static int alignUp(int i, int i2, @NonNull Range<Integer> range) {
        return align(false, i, i2, range);
    }

    @NonNull
    private Rect calculateCropRect(@NonNull Size size, @Nullable VideoEncoderInfo videoEncoderInfo) {
        Rect viewPortCropRect = getViewPortCropRect() != null ? getViewPortCropRect() : new Rect(0, 0, size.getWidth(), size.getHeight());
        return (videoEncoderInfo == null || videoEncoderInfo.isSizeSupported(viewPortCropRect.width(), viewPortCropRect.height())) ? viewPortCropRect : adjustCropRectToValidSize(viewPortCropRect, size, videoEncoderInfo);
    }

    @MainThread
    private void clearPipeline() {
        Threads.checkMainThread();
        DeferrableSurface deferrableSurface = this.mDeferrableSurface;
        if (deferrableSurface != null) {
            deferrableSurface.close();
            this.mDeferrableSurface = null;
        }
        SurfaceProcessorNode surfaceProcessorNode = this.mNode;
        if (surfaceProcessorNode != null) {
            surfaceProcessorNode.release();
            this.mNode = null;
        }
        SurfaceEdge surfaceEdge = this.mCameraEdge;
        if (surfaceEdge != null) {
            surfaceEdge.close();
            this.mCameraEdge = null;
        }
        this.mVideoEncoderInfo = null;
        this.mCropRect = null;
        this.mSurfaceRequest = null;
        this.mStreamInfo = StreamInfo.STREAM_INFO_ANY_INACTIVE;
        this.mRotationDegrees = 0;
        this.mHasCompensatingTransformation = false;
    }

    @Nullable
    private SurfaceProcessorNode createNodeIfNeeded(@NonNull CameraInternal cameraInternal, @NonNull Rect rect, @NonNull Size size, @NonNull DynamicRange dynamicRange) {
        if (getEffect() == null && !shouldEnableSurfaceProcessingByQuirk(cameraInternal) && !shouldCrop(rect, size) && !shouldMirror(cameraInternal) && !shouldCompensateTransformation()) {
            return null;
        }
        Logger.d(TAG, "Surface processing is enabled.");
        CameraInternal camera = getCamera();
        Objects.requireNonNull(camera);
        return new SurfaceProcessorNode(camera, getEffect() != null ? getEffect().createSurfaceProcessorInternal() : DefaultSurfaceProcessor.Factory.newInstance(dynamicRange));
    }

    @NonNull
    @SuppressLint({"WrongConstant"})
    @MainThread
    private SessionConfig.Builder createPipeline(@NonNull final String str, @NonNull final VideoCaptureConfig<T> videoCaptureConfig, @NonNull final StreamSpec streamSpec) {
        Threads.checkMainThread();
        final CameraInternal cameraInternal = (CameraInternal) Preconditions.checkNotNull(getCamera());
        Size resolution = streamSpec.getResolution();
        Runnable runnable = new Runnable(this) { // from class: com.zj.adlib.vm9

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final /* synthetic */ VideoCapture f45388a;

            @Override // java.lang.Runnable
            public final void run() {
            }
        };
        Range<Integer> expectedFrameRateRange = streamSpec.getExpectedFrameRateRange();
        if (Objects.equals(expectedFrameRateRange, StreamSpec.FRAME_RATE_RANGE_UNSPECIFIED)) {
            expectedFrameRateRange = Defaults.DEFAULT_FPS_RANGE;
        }
        Range<Integer> range = expectedFrameRateRange;
        MediaSpec mediaSpec = getMediaSpec();
        Objects.requireNonNull(mediaSpec);
        VideoCapabilities videoCapabilities = getVideoCapabilities(cameraInternal.getCameraInfo());
        DynamicRange dynamicRange = streamSpec.getDynamicRange();
        VideoEncoderInfo videoEncoderInfo = getVideoEncoderInfo(videoCaptureConfig.getVideoEncoderInfoFinder(), videoCapabilities, dynamicRange, mediaSpec, resolution, range);
        this.mRotationDegrees = adjustRotationWithInProgressTransformation(getRelativeRotation(cameraInternal, isMirroringRequired(cameraInternal)));
        Rect rectCalculateCropRect = calculateCropRect(resolution, videoEncoderInfo);
        Rect rectAdjustCropRectWithInProgressTransformation = adjustCropRectWithInProgressTransformation(rectCalculateCropRect, this.mRotationDegrees);
        this.mCropRect = rectAdjustCropRectWithInProgressTransformation;
        Size sizeAdjustResolutionWithInProgressTransformation = adjustResolutionWithInProgressTransformation(resolution, rectCalculateCropRect, rectAdjustCropRectWithInProgressTransformation);
        if (shouldCompensateTransformation()) {
            this.mHasCompensatingTransformation = true;
        }
        SurfaceProcessorNode surfaceProcessorNodeCreateNodeIfNeeded = createNodeIfNeeded(cameraInternal, this.mCropRect, resolution, dynamicRange);
        this.mNode = surfaceProcessorNodeCreateNodeIfNeeded;
        final Timebase timebase = (surfaceProcessorNodeCreateNodeIfNeeded == null && cameraInternal.getHasTransform()) ? Timebase.UPTIME : cameraInternal.getCameraInfoInternal().getTimebase();
        Logger.d(TAG, "camera timebase = " + cameraInternal.getCameraInfoInternal().getTimebase() + ", processing timebase = " + timebase);
        StreamSpec streamSpecBuild = streamSpec.toBuilder().setResolution(sizeAdjustResolutionWithInProgressTransformation).setExpectedFrameRateRange(range).build();
        Preconditions.checkState(this.mCameraEdge == null);
        SurfaceEdge surfaceEdge = new SurfaceEdge(2, 34, streamSpecBuild, getSensorToBufferTransformMatrix(), cameraInternal.getHasTransform(), this.mCropRect, this.mRotationDegrees, getAppTargetRotation(), shouldMirror(cameraInternal));
        this.mCameraEdge = surfaceEdge;
        surfaceEdge.addOnInvalidatedListener(runnable);
        if (this.mNode != null) {
            SurfaceProcessorNode.OutConfig outConfigOf = SurfaceProcessorNode.OutConfig.of(this.mCameraEdge);
            final SurfaceEdge surfaceEdge2 = this.mNode.transform(SurfaceProcessorNode.In.of(this.mCameraEdge, Collections.singletonList(outConfigOf))).get(outConfigOf);
            Objects.requireNonNull(surfaceEdge2);
            surfaceEdge2.addOnInvalidatedListener(new Runnable(this, surfaceEdge2, cameraInternal, videoCaptureConfig, timebase) { // from class: com.zj.adlib.wm9

                /* JADX INFO: renamed from: a, reason: collision with root package name */
                public final /* synthetic */ CameraInternal f45631a;

                /* JADX INFO: renamed from: a, reason: collision with other field name */
                public final /* synthetic */ Timebase f20468a;

                /* JADX INFO: renamed from: a, reason: collision with other field name */
                public final /* synthetic */ SurfaceEdge f20469a;

                /* JADX INFO: renamed from: a, reason: collision with other field name */
                public final /* synthetic */ VideoCapture f20470a;

                /* JADX INFO: renamed from: a, reason: collision with other field name */
                public final /* synthetic */ VideoCaptureConfig f20471a;

                @Override // java.lang.Runnable
                public final void run() {
                }
            });
            this.mSurfaceRequest = surfaceEdge2.createSurfaceRequest(cameraInternal);
            final DeferrableSurface deferrableSurface = this.mCameraEdge.getDeferrableSurface();
            this.mDeferrableSurface = deferrableSurface;
            deferrableSurface.getTerminationFuture().addListener(new Runnable(this, deferrableSurface) { // from class: com.zj.adlib.xm9

                /* JADX INFO: renamed from: a, reason: collision with root package name */
                public final /* synthetic */ DeferrableSurface f45854a;

                /* JADX INFO: renamed from: a, reason: collision with other field name */
                public final /* synthetic */ VideoCapture f20688a;

                @Override // java.lang.Runnable
                public final void run() {
                }
            }, CameraXExecutors.mainThreadExecutor());
        } else {
            SurfaceRequest surfaceRequestCreateSurfaceRequest = this.mCameraEdge.createSurfaceRequest(cameraInternal);
            this.mSurfaceRequest = surfaceRequestCreateSurfaceRequest;
            this.mDeferrableSurface = surfaceRequestCreateSurfaceRequest.getDeferrableSurface();
        }
        videoCaptureConfig.getVideoOutput().onSurfaceRequested(this.mSurfaceRequest, timebase);
        sendTransformationInfoIfReady();
        this.mDeferrableSurface.setContainerClass(MediaCodec.class);
        SessionConfig.Builder builderCreateFrom = SessionConfig.Builder.createFrom(videoCaptureConfig, streamSpec.getResolution());
        builderCreateFrom.setExpectedFrameRateRange(streamSpec.getExpectedFrameRateRange());
        builderCreateFrom.addErrorListener(new SessionConfig.ErrorListener(this, str, videoCaptureConfig, streamSpec) { // from class: com.zj.adlib.ym9

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final /* synthetic */ StreamSpec f46070a;

            /* JADX INFO: renamed from: a, reason: collision with other field name */
            public final /* synthetic */ VideoCapture f20890a;

            /* JADX INFO: renamed from: a, reason: collision with other field name */
            public final /* synthetic */ VideoCaptureConfig f20891a;

            /* JADX INFO: renamed from: a, reason: collision with other field name */
            public final /* synthetic */ String f20892a;

            @Override // androidx.camera.core.impl.SessionConfig.ErrorListener
            public final void onError(SessionConfig sessionConfig, SessionConfig.SessionError sessionError) {
            }
        });
        if (USE_TEMPLATE_PREVIEW_BY_QUIRK) {
            builderCreateFrom.setTemplateType(1);
        }
        if (streamSpec.getImplementationOptions() != null) {
            builderCreateFrom.addImplementationOptions(streamSpec.getImplementationOptions());
        }
        return builderCreateFrom;
    }

    @Nullable
    private static <T> T fetchObservableValue(@NonNull Observable<T> observable, @Nullable T t) {
        ListenableFuture<T> listenableFutureFetchData = observable.fetchData();
        if (!listenableFutureFetchData.isDone()) {
            return t;
        }
        try {
            return listenableFutureFetchData.get();
        } catch (InterruptedException | ExecutionException e) {
            throw new IllegalStateException(e);
        }
    }

    @Nullable
    private MediaSpec getMediaSpec() {
        return (MediaSpec) fetchObservableValue(getOutput().getMediaSpec(), null);
    }

    @NonNull
    private VideoCapabilities getVideoCapabilities(@NonNull CameraInfo cameraInfo) {
        return getOutput().getMediaCapabilities(cameraInfo);
    }

    @Nullable
    @MainThread
    private VideoEncoderInfo getVideoEncoderInfo(@NonNull Function<VideoEncoderConfig, VideoEncoderInfo> function, @NonNull VideoCapabilities videoCapabilities, @NonNull DynamicRange dynamicRange, @NonNull MediaSpec mediaSpec, @NonNull Size size, @NonNull Range<Integer> range) {
        VideoEncoderInfo videoEncoderInfo = this.mVideoEncoderInfo;
        if (videoEncoderInfo != null) {
            return videoEncoderInfo;
        }
        VideoValidatedEncoderProfilesProxy videoValidatedEncoderProfilesProxyFindHighestSupportedEncoderProfilesFor = videoCapabilities.findHighestSupportedEncoderProfilesFor(size, dynamicRange);
        VideoEncoderInfo videoEncoderInfoResolveVideoEncoderInfo = resolveVideoEncoderInfo(function, videoValidatedEncoderProfilesProxyFindHighestSupportedEncoderProfilesFor, mediaSpec, size, dynamicRange, range);
        if (videoEncoderInfoResolveVideoEncoderInfo == null) {
            Logger.w(TAG, "Can't find videoEncoderInfo");
            return null;
        }
        VideoEncoderInfo videoEncoderInfoFrom = VideoEncoderInfoWrapper.from(videoEncoderInfoResolveVideoEncoderInfo, videoValidatedEncoderProfilesProxyFindHighestSupportedEncoderProfilesFor != null ? new Size(videoValidatedEncoderProfilesProxyFindHighestSupportedEncoderProfilesFor.getDefaultVideoProfile().getWidth(), videoValidatedEncoderProfilesProxyFindHighestSupportedEncoderProfilesFor.getDefaultVideoProfile().getHeight()) : null);
        this.mVideoEncoderInfo = videoEncoderInfoFrom;
        return videoEncoderInfoFrom;
    }

    private static boolean hasVideoQualityQuirkAndWorkaroundBySurfaceProcessing() {
        Iterator it = DeviceQuirks.getAll(VideoQualityQuirk.class).iterator();
        while (it.hasNext()) {
            if (((VideoQualityQuirk) it.next()).workaroundBySurfaceProcessing()) {
                return true;
            }
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ int lambda$adjustCropRectToValidSize$4(Rect rect, Size size, Size size2) {
        return (Math.abs(size.getWidth() - rect.width()) + Math.abs(size.getHeight() - rect.height())) - (Math.abs(size2.getWidth() - rect.width()) + Math.abs(size2.getHeight() - rect.height()));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$createPipeline$2(DeferrableSurface deferrableSurface) {
        if (deferrableSurface == this.mDeferrableSurface) {
            clearPipeline();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$createPipeline$3(String str, VideoCaptureConfig videoCaptureConfig, StreamSpec streamSpec, SessionConfig sessionConfig, SessionConfig.SessionError sessionError) {
        resetPipeline(str, videoCaptureConfig, streamSpec);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void lambda$setupSurfaceUpdateNotifier$5(AtomicBoolean atomicBoolean, SessionConfig.Builder builder, CameraCaptureCallback cameraCaptureCallback) {
        Preconditions.checkState(Threads.isMainThread(), "Surface update cancellation should only occur on main thread.");
        atomicBoolean.set(true);
        builder.removeCameraCaptureCallback(cameraCaptureCallback);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ Object lambda$setupSurfaceUpdateNotifier$6(final SessionConfig.Builder builder, CallbackToFutureAdapter.Completer completer) throws Exception {
        builder.addTag(SURFACE_UPDATE_KEY, Integer.valueOf(completer.hashCode()));
        final AtomicBoolean atomicBoolean = new AtomicBoolean(false);
        final AnonymousClass2 anonymousClass2 = new AnonymousClass2(atomicBoolean, completer, builder);
        completer.addCancellationListener(new Runnable(atomicBoolean, builder, anonymousClass2) { // from class: com.zj.adlib.tm9

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final /* synthetic */ CameraCaptureCallback f44955a;

            /* JADX INFO: renamed from: a, reason: collision with other field name */
            public final /* synthetic */ SessionConfig.Builder f19858a;

            /* JADX INFO: renamed from: a, reason: collision with other field name */
            public final /* synthetic */ AtomicBoolean f19859a;

            @Override // java.lang.Runnable
            public final void run() {
            }
        }, CameraXExecutors.directExecutor());
        builder.addRepeatingCameraCaptureCallback(anonymousClass2);
        return String.format("%s[0x%x]", SURFACE_UPDATE_KEY, Integer.valueOf(completer.hashCode()));
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: onAppEdgeInvalidated, reason: merged with bridge method [inline-methods] */
    public void lambda$createPipeline$1(@NonNull SurfaceEdge surfaceEdge, @NonNull CameraInternal cameraInternal, @NonNull VideoCaptureConfig<T> videoCaptureConfig, @NonNull Timebase timebase) {
        if (cameraInternal == getCamera()) {
            this.mSurfaceRequest = surfaceEdge.createSurfaceRequest(cameraInternal);
            videoCaptureConfig.getVideoOutput().onSurfaceRequested(this.mSurfaceRequest, timebase);
            sendTransformationInfoIfReady();
        }
    }

    @Nullable
    private static VideoEncoderInfo resolveVideoEncoderInfo(@NonNull Function<VideoEncoderConfig, VideoEncoderInfo> function, @Nullable VideoValidatedEncoderProfilesProxy videoValidatedEncoderProfilesProxy, @NonNull MediaSpec mediaSpec, @NonNull Size size, @NonNull DynamicRange dynamicRange, @NonNull Range<Integer> range) {
        return function.apply(VideoConfigUtil.resolveVideoEncoderConfig(VideoConfigUtil.resolveVideoMimeInfo(mediaSpec, dynamicRange, videoValidatedEncoderProfilesProxy), Timebase.UPTIME, mediaSpec.getVideoSpec(), size, dynamicRange, range));
    }

    private void sendTransformationInfoIfReady() {
        CameraInternal camera = getCamera();
        SurfaceEdge surfaceEdge = this.mCameraEdge;
        if (camera == null || surfaceEdge == null) {
            return;
        }
        int iAdjustRotationWithInProgressTransformation = adjustRotationWithInProgressTransformation(getRelativeRotation(camera, isMirroringRequired(camera)));
        this.mRotationDegrees = iAdjustRotationWithInProgressTransformation;
        surfaceEdge.updateTransformation(iAdjustRotationWithInProgressTransformation, getAppTargetRotation());
    }

    @MainThread
    private void setupSurfaceUpdateNotifier(@NonNull final SessionConfig.Builder builder, final boolean z) {
        ListenableFuture<Void> listenableFuture = this.mSurfaceUpdateFuture;
        if (listenableFuture != null && listenableFuture.cancel(false)) {
            Logger.d(TAG, "A newer surface update is requested. Previous surface update cancelled.");
        }
        final ListenableFuture<Void> future = CallbackToFutureAdapter.getFuture(new CallbackToFutureAdapter.Resolver(this, builder) { // from class: com.zj.adlib.um9

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final /* synthetic */ SessionConfig.Builder f45179a;

            /* JADX INFO: renamed from: a, reason: collision with other field name */
            public final /* synthetic */ VideoCapture f20104a;

            @Override // androidx.concurrent.futures.CallbackToFutureAdapter.Resolver
            public final Object attachCompleter(CallbackToFutureAdapter.Completer completer) {
            }
        });
        this.mSurfaceUpdateFuture = future;
        Futures.addCallback(future, new FutureCallback<Void>() { // from class: androidx.camera.video.VideoCapture.3
            @Override // androidx.camera.core.impl.utils.futures.FutureCallback
            public void onFailure(@NonNull Throwable th) {
                if (th instanceof CancellationException) {
                    return;
                }
                Logger.e(VideoCapture.TAG, "Surface update completed with unexpected exception", th);
            }

            @Override // androidx.camera.core.impl.utils.futures.FutureCallback
            public void onSuccess(@Nullable Void r3) {
                ListenableFuture<Void> listenableFuture2 = future;
                VideoCapture videoCapture = VideoCapture.this;
                if (listenableFuture2 != videoCapture.mSurfaceUpdateFuture || videoCapture.mSourceState == VideoOutput.SourceState.INACTIVE) {
                    return;
                }
                videoCapture.setSourceState(z ? VideoOutput.SourceState.ACTIVE_STREAMING : VideoOutput.SourceState.ACTIVE_NON_STREAMING);
            }
        }, CameraXExecutors.mainThreadExecutor());
    }

    private boolean shouldCompensateTransformation() {
        return this.mStreamInfo.getInProgressTransformationInfo() != null;
    }

    private static boolean shouldCrop(@NonNull Rect rect, @NonNull Size size) {
        return (size.getWidth() == rect.width() && size.getHeight() == rect.height()) ? false : true;
    }

    private static boolean shouldEnableSurfaceProcessingByQuirk(@NonNull CameraInternal cameraInternal) {
        return cameraInternal.getHasTransform() && sEnableSurfaceProcessingByQuirk;
    }

    private boolean shouldMirror(@NonNull CameraInternal cameraInternal) {
        return cameraInternal.getHasTransform() && isMirroringRequired(cameraInternal);
    }

    private void updateCustomOrderedResolutionsByQuality(@NonNull CameraInfoInternal cameraInfoInternal, @NonNull UseCaseConfig.Builder<?, ?, ?> builder) throws IllegalArgumentException {
        MediaSpec mediaSpec = getMediaSpec();
        Preconditions.checkArgument(mediaSpec != null, "Unable to update target resolution by null MediaSpec.");
        DynamicRange dynamicRange = getDynamicRange();
        VideoCapabilities videoCapabilities = getVideoCapabilities(cameraInfoInternal);
        List<Quality> supportedQualities = videoCapabilities.getSupportedQualities(dynamicRange);
        if (supportedQualities.isEmpty()) {
            Logger.w(TAG, "Can't find any supported quality on the device.");
            return;
        }
        VideoSpec videoSpec = mediaSpec.getVideoSpec();
        QualitySelector qualitySelector = videoSpec.getQualitySelector();
        List<Quality> prioritizedQualities = qualitySelector.getPrioritizedQualities(supportedQualities);
        Logger.d(TAG, "Found selectedQualities " + prioritizedQualities + " by " + qualitySelector);
        if (prioritizedQualities.isEmpty()) {
            throw new IllegalArgumentException("Unable to find supported quality by QualitySelector");
        }
        int aspectRatio = videoSpec.getAspectRatio();
        QualityRatioToResolutionsTable qualityRatioToResolutionsTable = new QualityRatioToResolutionsTable(cameraInfoInternal.getSupportedResolutions(getImageFormat()), QualitySelector.getQualityToResolutionMap(videoCapabilities, dynamicRange));
        ArrayList arrayList = new ArrayList();
        Iterator<Quality> it = prioritizedQualities.iterator();
        while (it.hasNext()) {
            arrayList.addAll(qualityRatioToResolutionsTable.getResolutions(it.next(), aspectRatio));
        }
        Logger.d(TAG, "Set custom ordered resolutions = " + arrayList);
        builder.getMutableConfig().insertOption(ImageOutputConfig.OPTION_CUSTOM_ORDERED_RESOLUTIONS, arrayList);
    }

    @NonNull
    public static <T extends VideoOutput> VideoCapture<T> withOutput(@NonNull T t) {
        return new Builder((VideoOutput) Preconditions.checkNotNull(t)).setCaptureType(UseCaseConfigFactory.CaptureType.VIDEO_CAPTURE).build();
    }

    @MainThread
    public void applyStreamInfoAndStreamSpecToSessionConfigBuilder(@NonNull SessionConfig.Builder builder, @NonNull StreamInfo streamInfo, @NonNull StreamSpec streamSpec) {
        boolean z = streamInfo.getId() == -1;
        boolean z2 = streamInfo.getStreamState() == StreamInfo.StreamState.ACTIVE;
        if (z && z2) {
            throw new IllegalStateException("Unexpected stream state, stream is error but active");
        }
        builder.clearSurfaces();
        DynamicRange dynamicRange = streamSpec.getDynamicRange();
        if (!z) {
            if (z2) {
                builder.addSurface(this.mDeferrableSurface, dynamicRange);
            } else {
                builder.addNonRepeatingSurface(this.mDeferrableSurface, dynamicRange);
            }
        }
        setupSurfaceUpdateNotifier(builder, z2);
    }

    @Nullable
    @VisibleForTesting
    public SurfaceEdge getCameraEdge() {
        return this.mCameraEdge;
    }

    @Nullable
    @VisibleForTesting
    public Rect getCropRect() {
        return this.mCropRect;
    }

    @Override // androidx.camera.core.UseCase
    @Nullable
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public UseCaseConfig<?> getDefaultConfig(boolean z, @NonNull UseCaseConfigFactory useCaseConfigFactory) {
        Defaults defaults = DEFAULT_CONFIG;
        Config config = useCaseConfigFactory.getConfig(defaults.getConfig().getCaptureType(), 1);
        if (z) {
            config = Config.mergeConfigs(config, defaults.getConfig());
        }
        if (config == null) {
            return null;
        }
        return getUseCaseConfigBuilder(config).getUseCaseConfig();
    }

    @NonNull
    public DynamicRange getDynamicRange() {
        return getCurrentConfig().hasDynamicRange() ? getCurrentConfig().getDynamicRange() : Defaults.DEFAULT_DYNAMIC_RANGE;
    }

    public int getMirrorMode() {
        return getMirrorModeInternal();
    }

    @Nullable
    @VisibleForTesting
    public SurfaceProcessorNode getNode() {
        return this.mNode;
    }

    @NonNull
    public T getOutput() {
        return (T) ((VideoCaptureConfig) getCurrentConfig()).getVideoOutput();
    }

    @VisibleForTesting
    public int getRotationDegrees() {
        return this.mRotationDegrees;
    }

    @Override // androidx.camera.core.UseCase
    @NonNull
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public Set<Integer> getSupportedEffectTargets() {
        HashSet hashSet = new HashSet();
        hashSet.add(2);
        return hashSet;
    }

    @NonNull
    @VisibleForTesting
    public SurfaceRequest getSurfaceRequest() {
        SurfaceRequest surfaceRequest = this.mSurfaceRequest;
        Objects.requireNonNull(surfaceRequest);
        return surfaceRequest;
    }

    @NonNull
    public Range<Integer> getTargetFrameRate() {
        return getTargetFrameRateInternal();
    }

    public int getTargetRotation() {
        return getTargetRotationInternal();
    }

    @Override // androidx.camera.core.UseCase
    @NonNull
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public UseCaseConfig.Builder<?, ?, ?> getUseCaseConfigBuilder(@NonNull Config config) {
        return Builder.fromConfig(config);
    }

    public boolean isStreamIdChanged(int i, int i2) {
        Set<Integer> set = StreamInfo.NON_SURFACE_STREAM_ID;
        return (set.contains(Integer.valueOf(i)) || set.contains(Integer.valueOf(i2)) || i == i2) ? false : true;
    }

    @Override // androidx.camera.core.UseCase
    @NonNull
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public UseCaseConfig<?> onMergeConfig(@NonNull CameraInfoInternal cameraInfoInternal, @NonNull UseCaseConfig.Builder<?, ?, ?> builder) {
        updateCustomOrderedResolutionsByQuality(cameraInfoInternal, builder);
        return builder.getUseCaseConfig();
    }

    @Override // androidx.camera.core.UseCase
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public void onStateAttached() {
        super.onStateAttached();
        Preconditions.checkNotNull(getAttachedStreamSpec(), "The suggested stream specification should be already updated and shouldn't be null.");
        Preconditions.checkState(this.mSurfaceRequest == null, "The surface request should be null when VideoCapture is attached.");
        StreamSpec streamSpec = (StreamSpec) Preconditions.checkNotNull(getAttachedStreamSpec());
        this.mStreamInfo = (StreamInfo) fetchObservableValue(getOutput().getStreamInfo(), StreamInfo.STREAM_INFO_ANY_INACTIVE);
        SessionConfig.Builder builderCreatePipeline = createPipeline(getCameraId(), (VideoCaptureConfig) getCurrentConfig(), streamSpec);
        this.mSessionConfigBuilder = builderCreatePipeline;
        applyStreamInfoAndStreamSpecToSessionConfigBuilder(builderCreatePipeline, this.mStreamInfo, streamSpec);
        updateSessionConfig(this.mSessionConfigBuilder.build());
        notifyActive();
        getOutput().getStreamInfo().addObserver(CameraXExecutors.mainThreadExecutor(), this.mStreamInfoObserver);
        setSourceState(VideoOutput.SourceState.ACTIVE_NON_STREAMING);
    }

    @Override // androidx.camera.core.UseCase
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public void onStateDetached() {
        Preconditions.checkState(Threads.isMainThread(), "VideoCapture can only be detached on the main thread.");
        setSourceState(VideoOutput.SourceState.INACTIVE);
        getOutput().getStreamInfo().removeObserver(this.mStreamInfoObserver);
        ListenableFuture<Void> listenableFuture = this.mSurfaceUpdateFuture;
        if (listenableFuture != null && listenableFuture.cancel(false)) {
            Logger.d(TAG, "VideoCapture is detached from the camera. Surface update cancelled.");
        }
        clearPipeline();
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
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public StreamSpec onSuggestedStreamSpecUpdated(@NonNull StreamSpec streamSpec) {
        Logger.d(TAG, "onSuggestedStreamSpecUpdated: " + streamSpec);
        List<Size> customOrderedResolutions = ((VideoCaptureConfig) getCurrentConfig()).getCustomOrderedResolutions(null);
        if (customOrderedResolutions != null && !customOrderedResolutions.contains(streamSpec.getResolution())) {
            Logger.w(TAG, "suggested resolution " + streamSpec.getResolution() + " is not in custom ordered resolutions " + customOrderedResolutions);
        }
        return streamSpec;
    }

    @MainThread
    public void resetPipeline(@NonNull String str, @NonNull VideoCaptureConfig<T> videoCaptureConfig, @NonNull StreamSpec streamSpec) {
        clearPipeline();
        if (isCurrentCamera(str)) {
            SessionConfig.Builder builderCreatePipeline = createPipeline(str, videoCaptureConfig, streamSpec);
            this.mSessionConfigBuilder = builderCreatePipeline;
            applyStreamInfoAndStreamSpecToSessionConfigBuilder(builderCreatePipeline, this.mStreamInfo, streamSpec);
            updateSessionConfig(this.mSessionConfigBuilder.build());
            notifyReset();
        }
    }

    @MainThread
    public void setSourceState(@NonNull VideoOutput.SourceState sourceState) {
        if (sourceState != this.mSourceState) {
            this.mSourceState = sourceState;
            getOutput().onSourceStateChanged(sourceState);
        }
    }

    public void setTargetRotation(int i) {
        if (setTargetRotationInternal(i)) {
            sendTransformationInfoIfReady();
        }
    }

    @Override // androidx.camera.core.UseCase
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public void setViewPortCropRect(@NonNull Rect rect) {
        super.setViewPortCropRect(rect);
        sendTransformationInfoIfReady();
    }

    public boolean shouldResetCompensatingTransformation(@NonNull StreamInfo streamInfo, @NonNull StreamInfo streamInfo2) {
        return this.mHasCompensatingTransformation && streamInfo.getInProgressTransformationInfo() != null && streamInfo2.getInProgressTransformationInfo() == null;
    }

    @NonNull
    public String toString() {
        return "VideoCapture:" + getName();
    }
}

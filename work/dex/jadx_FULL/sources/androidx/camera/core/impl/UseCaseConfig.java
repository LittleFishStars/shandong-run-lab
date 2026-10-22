package androidx.camera.core.impl;

import android.util.Range;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.camera.core.CameraSelector;
import androidx.camera.core.ExtendableBuilder;
import androidx.camera.core.UseCase;
import androidx.camera.core.internal.TargetConfig;
import androidx.camera.core.internal.UseCaseEventConfig;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_13_8952cls.dex */
@RequiresApi(21)
public interface UseCaseConfig<T extends UseCase> extends TargetConfig<T>, UseCaseEventConfig, ImageInputConfig {
    public static final Config.Option<UseCaseConfigFactory.CaptureType> OPTION_CAPTURE_TYPE;
    public static final Config.Option<Boolean> OPTION_HIGH_RESOLUTION_DISABLED;
    public static final Config.Option<Boolean> OPTION_ZSL_DISABLED;
    public static final Config.Option<SessionConfig> OPTION_DEFAULT_SESSION_CONFIG = Config.Option.create("camerax.core.useCase.defaultSessionConfig", SessionConfig.class);
    public static final Config.Option<CaptureConfig> OPTION_DEFAULT_CAPTURE_CONFIG = Config.Option.create("camerax.core.useCase.defaultCaptureConfig", CaptureConfig.class);
    public static final Config.Option<SessionConfig.OptionUnpacker> OPTION_SESSION_CONFIG_UNPACKER = Config.Option.create("camerax.core.useCase.sessionConfigUnpacker", SessionConfig.OptionUnpacker.class);
    public static final Config.Option<CaptureConfig.OptionUnpacker> OPTION_CAPTURE_CONFIG_UNPACKER = Config.Option.create("camerax.core.useCase.captureConfigUnpacker", CaptureConfig.OptionUnpacker.class);
    public static final Config.Option<Integer> OPTION_SURFACE_OCCUPANCY_PRIORITY = Config.Option.create("camerax.core.useCase.surfaceOccupancyPriority", Integer.TYPE);
    public static final Config.Option<CameraSelector> OPTION_CAMERA_SELECTOR = Config.Option.create("camerax.core.useCase.cameraSelector", CameraSelector.class);
    public static final Config.Option<Range<Integer>> OPTION_TARGET_FRAME_RATE = Config.Option.create("camerax.core.useCase.targetFrameRate", Range.class);

    public interface Builder<T extends UseCase, C extends UseCaseConfig<T>, B> extends TargetConfig.Builder<T, B>, ExtendableBuilder<T>, UseCaseEventConfig.Builder<B> {
        @NonNull
        C getUseCaseConfig();

        @NonNull
        B setCameraSelector(@NonNull CameraSelector cameraSelector);

        @NonNull
        B setCaptureOptionUnpacker(@NonNull CaptureConfig.OptionUnpacker optionUnpacker);

        @NonNull
        B setCaptureType(@NonNull UseCaseConfigFactory.CaptureType captureType);

        @NonNull
        B setDefaultCaptureConfig(@NonNull CaptureConfig captureConfig);

        @NonNull
        B setDefaultSessionConfig(@NonNull SessionConfig sessionConfig);

        @NonNull
        B setHighResolutionDisabled(boolean z);

        @NonNull
        B setSessionOptionUnpacker(@NonNull SessionConfig.OptionUnpacker optionUnpacker);

        @NonNull
        B setSurfaceOccupancyPriority(int i);

        @NonNull
        B setZslDisabled(boolean z);
    }

    static {
        Class cls = Boolean.TYPE;
        OPTION_ZSL_DISABLED = Config.Option.create("camerax.core.useCase.zslDisabled", cls);
        OPTION_HIGH_RESOLUTION_DISABLED = Config.Option.create("camerax.core.useCase.highResolutionDisabled", cls);
        OPTION_CAPTURE_TYPE = Config.Option.create("camerax.core.useCase.captureType", UseCaseConfigFactory.CaptureType.class);
    }

    @Nullable
    default CameraSelector getCameraSelector(@Nullable CameraSelector cameraSelector) {
        return (CameraSelector) retrieveOption(OPTION_CAMERA_SELECTOR, cameraSelector);
    }

    @Nullable
    default CaptureConfig.OptionUnpacker getCaptureOptionUnpacker(@Nullable CaptureConfig.OptionUnpacker optionUnpacker) {
        return (CaptureConfig.OptionUnpacker) retrieveOption(OPTION_CAPTURE_CONFIG_UNPACKER, optionUnpacker);
    }

    @NonNull
    default UseCaseConfigFactory.CaptureType getCaptureType() {
        return (UseCaseConfigFactory.CaptureType) retrieveOption(OPTION_CAPTURE_TYPE);
    }

    @Nullable
    default CaptureConfig getDefaultCaptureConfig(@Nullable CaptureConfig captureConfig) {
        return (CaptureConfig) retrieveOption(OPTION_DEFAULT_CAPTURE_CONFIG, captureConfig);
    }

    @Nullable
    default SessionConfig getDefaultSessionConfig(@Nullable SessionConfig sessionConfig) {
        return (SessionConfig) retrieveOption(OPTION_DEFAULT_SESSION_CONFIG, sessionConfig);
    }

    @Nullable
    default SessionConfig.OptionUnpacker getSessionOptionUnpacker(@Nullable SessionConfig.OptionUnpacker optionUnpacker) {
        return (SessionConfig.OptionUnpacker) retrieveOption(OPTION_SESSION_CONFIG_UNPACKER, optionUnpacker);
    }

    default int getSurfaceOccupancyPriority(int i) {
        return ((Integer) retrieveOption(OPTION_SURFACE_OCCUPANCY_PRIORITY, Integer.valueOf(i))).intValue();
    }

    @Nullable
    default Range<Integer> getTargetFrameRate(@Nullable Range<Integer> range) {
        return (Range) retrieveOption(OPTION_TARGET_FRAME_RATE, range);
    }

    default boolean isHigResolutionDisabled(boolean z) {
        return ((Boolean) retrieveOption(OPTION_HIGH_RESOLUTION_DISABLED, Boolean.valueOf(z))).booleanValue();
    }

    default boolean isZslDisabled(boolean z) {
        return ((Boolean) retrieveOption(OPTION_ZSL_DISABLED, Boolean.valueOf(z))).booleanValue();
    }

    @NonNull
    default CameraSelector getCameraSelector() {
        return (CameraSelector) retrieveOption(OPTION_CAMERA_SELECTOR);
    }

    @NonNull
    default CaptureConfig.OptionUnpacker getCaptureOptionUnpacker() {
        return (CaptureConfig.OptionUnpacker) retrieveOption(OPTION_CAPTURE_CONFIG_UNPACKER);
    }

    @NonNull
    default CaptureConfig getDefaultCaptureConfig() {
        return (CaptureConfig) retrieveOption(OPTION_DEFAULT_CAPTURE_CONFIG);
    }

    @NonNull
    default SessionConfig getDefaultSessionConfig() {
        return (SessionConfig) retrieveOption(OPTION_DEFAULT_SESSION_CONFIG);
    }

    @NonNull
    default SessionConfig.OptionUnpacker getSessionOptionUnpacker() {
        return (SessionConfig.OptionUnpacker) retrieveOption(OPTION_SESSION_CONFIG_UNPACKER);
    }

    default int getSurfaceOccupancyPriority() {
        return ((Integer) retrieveOption(OPTION_SURFACE_OCCUPANCY_PRIORITY)).intValue();
    }

    @NonNull
    default Range<Integer> getTargetFrameRate() {
        return (Range) retrieveOption(OPTION_TARGET_FRAME_RATE);
    }
}

package androidx.camera.core.streamsharing;

import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.annotation.RestrictTo;
import androidx.camera.core.CameraSelector;
import androidx.camera.core.UseCase;
import androidx.camera.core.impl.CaptureConfig;
import androidx.camera.core.impl.MutableConfig;
import androidx.camera.core.impl.MutableOptionsBundle;
import androidx.camera.core.impl.OptionsBundle;
import androidx.camera.core.impl.SessionConfig;
import androidx.camera.core.impl.UseCaseConfig;
import androidx.camera.core.impl.UseCaseConfigFactory;
import androidx.camera.core.internal.TargetConfig;
import com.zj.adlib.c49;
import java.util.UUID;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_13_8952cls.dex */
@RequiresApi(api = 21)
class StreamSharingBuilder implements UseCaseConfig.Builder<StreamSharing, StreamSharingConfig, StreamSharingBuilder> {
    private static final String UNSUPPORTED_MESSAGE = "Operation not supported by StreamSharingBuilder.";
    private final MutableOptionsBundle mMutableConfig;

    public StreamSharingBuilder() {
        this(MutableOptionsBundle.create());
    }

    @Override // androidx.camera.core.ExtendableBuilder
    @NonNull
    public MutableConfig getMutableConfig() {
        return this.mMutableConfig;
    }

    @Override // androidx.camera.core.internal.TargetConfig.Builder
    @NonNull
    public /* bridge */ /* synthetic */ Object setTargetClass(@NonNull Class cls) {
        return setTargetClass((Class<StreamSharing>) cls);
    }

    public StreamSharingBuilder(@NonNull MutableOptionsBundle mutableOptionsBundle) {
        this.mMutableConfig = mutableOptionsBundle;
        Class cls = (Class) mutableOptionsBundle.retrieveOption(TargetConfig.OPTION_TARGET_CLASS, null);
        if (cls == null || cls.equals(StreamSharing.class)) {
            setTargetClass(StreamSharing.class);
            return;
        }
        throw new IllegalArgumentException("Invalid target class configuration for " + this + ": " + cls);
    }

    @Override // androidx.camera.core.ExtendableBuilder
    @NonNull
    public StreamSharing build() {
        throw new UnsupportedOperationException(UNSUPPORTED_MESSAGE);
    }

    @Override // androidx.camera.core.impl.UseCaseConfig.Builder
    @NonNull
    public StreamSharingConfig getUseCaseConfig() {
        return new StreamSharingConfig(OptionsBundle.from(this.mMutableConfig));
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // androidx.camera.core.impl.UseCaseConfig.Builder
    @NonNull
    public StreamSharingBuilder setCameraSelector(@NonNull CameraSelector cameraSelector) {
        throw new UnsupportedOperationException(UNSUPPORTED_MESSAGE);
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // androidx.camera.core.impl.UseCaseConfig.Builder
    @NonNull
    public StreamSharingBuilder setCaptureOptionUnpacker(@NonNull CaptureConfig.OptionUnpacker optionUnpacker) {
        throw new UnsupportedOperationException(UNSUPPORTED_MESSAGE);
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // androidx.camera.core.impl.UseCaseConfig.Builder
    @NonNull
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public StreamSharingBuilder setCaptureType(@NonNull UseCaseConfigFactory.CaptureType captureType) {
        getMutableConfig().insertOption(UseCaseConfig.OPTION_CAPTURE_TYPE, captureType);
        return this;
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // androidx.camera.core.impl.UseCaseConfig.Builder
    @NonNull
    public StreamSharingBuilder setDefaultCaptureConfig(@NonNull CaptureConfig captureConfig) {
        throw new UnsupportedOperationException(UNSUPPORTED_MESSAGE);
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // androidx.camera.core.impl.UseCaseConfig.Builder
    @NonNull
    public StreamSharingBuilder setDefaultSessionConfig(@NonNull SessionConfig sessionConfig) {
        throw new UnsupportedOperationException(UNSUPPORTED_MESSAGE);
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // androidx.camera.core.impl.UseCaseConfig.Builder
    @NonNull
    public StreamSharingBuilder setHighResolutionDisabled(boolean z) {
        throw new UnsupportedOperationException(UNSUPPORTED_MESSAGE);
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // androidx.camera.core.impl.UseCaseConfig.Builder
    @NonNull
    public StreamSharingBuilder setSessionOptionUnpacker(@NonNull SessionConfig.OptionUnpacker optionUnpacker) {
        throw new UnsupportedOperationException(UNSUPPORTED_MESSAGE);
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // androidx.camera.core.impl.UseCaseConfig.Builder
    @NonNull
    public StreamSharingBuilder setSurfaceOccupancyPriority(int i) {
        throw new UnsupportedOperationException(UNSUPPORTED_MESSAGE);
    }

    @Override // androidx.camera.core.internal.TargetConfig.Builder
    @NonNull
    public StreamSharingBuilder setTargetClass(@NonNull Class<StreamSharing> cls) {
        getMutableConfig().insertOption(TargetConfig.OPTION_TARGET_CLASS, cls);
        if (getMutableConfig().retrieveOption(TargetConfig.OPTION_TARGET_NAME, null) == null) {
            setTargetName(cls.getCanonicalName() + c49.f40900a + UUID.randomUUID());
        }
        return this;
    }

    @Override // androidx.camera.core.internal.TargetConfig.Builder
    @NonNull
    public StreamSharingBuilder setTargetName(@NonNull String str) {
        getMutableConfig().insertOption(TargetConfig.OPTION_TARGET_NAME, str);
        return this;
    }

    @Override // androidx.camera.core.internal.UseCaseEventConfig.Builder
    @NonNull
    public StreamSharingBuilder setUseCaseEventCallback(@NonNull UseCase.EventCallback eventCallback) {
        throw new UnsupportedOperationException(UNSUPPORTED_MESSAGE);
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // androidx.camera.core.impl.UseCaseConfig.Builder
    @NonNull
    public StreamSharingBuilder setZslDisabled(boolean z) {
        throw new UnsupportedOperationException(UNSUPPORTED_MESSAGE);
    }
}

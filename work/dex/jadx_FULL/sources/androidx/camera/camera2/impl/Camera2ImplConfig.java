package androidx.camera.camera2.impl;

import android.hardware.camera2.CameraCaptureSession;
import android.hardware.camera2.CameraDevice;
import android.hardware.camera2.CaptureRequest;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.OptIn;
import androidx.annotation.RequiresApi;
import androidx.annotation.RestrictTo;
import androidx.camera.camera2.interop.CaptureRequestOptions;
import androidx.camera.camera2.interop.ExperimentalCamera2Interop;
import androidx.camera.core.ExtendableBuilder;
import androidx.camera.core.impl.Config;
import androidx.camera.core.impl.MutableConfig;
import androidx.camera.core.impl.MutableOptionsBundle;
import androidx.camera.core.impl.OptionsBundle;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_13_8952cls.dex */
@OptIn(markerClass = {ExperimentalCamera2Interop.class})
@RequiresApi(21)
public final class Camera2ImplConfig extends CaptureRequestOptions {

    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public static final String CAPTURE_REQUEST_ID_STEM = "camera2.captureRequest.option.";

    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public static final Config.Option<Integer> TEMPLATE_TYPE_OPTION = Config.Option.create("camera2.captureRequest.templateType", Integer.TYPE);

    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public static final Config.Option<Long> STREAM_USE_CASE_OPTION = Config.Option.create("camera2.cameraCaptureSession.streamUseCase", Long.TYPE);

    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public static final Config.Option<CameraDevice.StateCallback> DEVICE_STATE_CALLBACK_OPTION = Config.Option.create("camera2.cameraDevice.stateCallback", CameraDevice.StateCallback.class);

    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public static final Config.Option<CameraCaptureSession.StateCallback> SESSION_STATE_CALLBACK_OPTION = Config.Option.create("camera2.cameraCaptureSession.stateCallback", CameraCaptureSession.StateCallback.class);

    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public static final Config.Option<CameraCaptureSession.CaptureCallback> SESSION_CAPTURE_CALLBACK_OPTION = Config.Option.create("camera2.cameraCaptureSession.captureCallback", CameraCaptureSession.CaptureCallback.class);

    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public static final Config.Option<CameraEventCallbacks> CAMERA_EVENT_CALLBACK_OPTION = Config.Option.create("camera2.cameraEvent.callback", CameraEventCallbacks.class);

    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public static final Config.Option<Object> CAPTURE_REQUEST_TAG_OPTION = Config.Option.create("camera2.captureRequest.tag", Object.class);

    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public static final Config.Option<String> SESSION_PHYSICAL_CAMERA_ID_OPTION = Config.Option.create("camera2.cameraCaptureSession.physicalCameraId", String.class);

    public static final class Builder implements ExtendableBuilder<Camera2ImplConfig> {
        private final MutableOptionsBundle mMutableOptionsBundle = MutableOptionsBundle.create();

        @Override // androidx.camera.core.ExtendableBuilder
        @NonNull
        public MutableConfig getMutableConfig() {
            return this.mMutableOptionsBundle;
        }

        @NonNull
        public Builder insertAllOptions(@NonNull Config config) {
            for (Config.Option<?> option : config.listOptions()) {
                this.mMutableOptionsBundle.insertOption(option, config.retrieveOption(option));
            }
            return this;
        }

        /* JADX WARN: Multi-variable type inference failed */
        @NonNull
        public <ValueT> Builder setCaptureRequestOption(@NonNull CaptureRequest.Key<ValueT> key, @NonNull ValueT valuet) {
            this.mMutableOptionsBundle.insertOption(Camera2ImplConfig.createCaptureRequestOption(key), valuet);
            return this;
        }

        /* JADX WARN: Multi-variable type inference failed */
        @NonNull
        public <ValueT> Builder setCaptureRequestOptionWithPriority(@NonNull CaptureRequest.Key<ValueT> key, @NonNull ValueT valuet, @NonNull Config.OptionPriority optionPriority) {
            this.mMutableOptionsBundle.insertOption(Camera2ImplConfig.createCaptureRequestOption(key), optionPriority, valuet);
            return this;
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // androidx.camera.core.ExtendableBuilder
        @NonNull
        public Camera2ImplConfig build() {
            return new Camera2ImplConfig(OptionsBundle.from(this.mMutableOptionsBundle));
        }
    }

    public static final class Extender<T> {
        ExtendableBuilder<T> mBaseBuilder;

        public Extender(@NonNull ExtendableBuilder<T> extendableBuilder) {
            this.mBaseBuilder = extendableBuilder;
        }

        @NonNull
        public Extender<T> setCameraEventCallback(@NonNull CameraEventCallbacks cameraEventCallbacks) {
            this.mBaseBuilder.getMutableConfig().insertOption(Camera2ImplConfig.CAMERA_EVENT_CALLBACK_OPTION, cameraEventCallbacks);
            return this;
        }
    }

    public Camera2ImplConfig(@NonNull Config config) {
        super(config);
    }

    @NonNull
    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public static Config.Option<Object> createCaptureRequestOption(@NonNull CaptureRequest.Key<?> key) {
        return Config.Option.create(CAPTURE_REQUEST_ID_STEM + key.getName(), Object.class, key);
    }

    @Nullable
    public CameraEventCallbacks getCameraEventCallback(@Nullable CameraEventCallbacks cameraEventCallbacks) {
        return (CameraEventCallbacks) getConfig().retrieveOption(CAMERA_EVENT_CALLBACK_OPTION, cameraEventCallbacks);
    }

    @NonNull
    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public CaptureRequestOptions getCaptureRequestOptions() {
        return CaptureRequestOptions.Builder.from(getConfig()).build();
    }

    @Nullable
    public Object getCaptureRequestTag(@Nullable Object obj) {
        return getConfig().retrieveOption(CAPTURE_REQUEST_TAG_OPTION, obj);
    }

    public int getCaptureRequestTemplate(int i) {
        return ((Integer) getConfig().retrieveOption(TEMPLATE_TYPE_OPTION, Integer.valueOf(i))).intValue();
    }

    @Nullable
    public CameraDevice.StateCallback getDeviceStateCallback(@Nullable CameraDevice.StateCallback stateCallback) {
        return (CameraDevice.StateCallback) getConfig().retrieveOption(DEVICE_STATE_CALLBACK_OPTION, stateCallback);
    }

    @Nullable
    public String getPhysicalCameraId(@Nullable String str) {
        return (String) getConfig().retrieveOption(SESSION_PHYSICAL_CAMERA_ID_OPTION, str);
    }

    @Nullable
    public CameraCaptureSession.CaptureCallback getSessionCaptureCallback(@Nullable CameraCaptureSession.CaptureCallback captureCallback) {
        return (CameraCaptureSession.CaptureCallback) getConfig().retrieveOption(SESSION_CAPTURE_CALLBACK_OPTION, captureCallback);
    }

    @Nullable
    public CameraCaptureSession.StateCallback getSessionStateCallback(@Nullable CameraCaptureSession.StateCallback stateCallback) {
        return (CameraCaptureSession.StateCallback) getConfig().retrieveOption(SESSION_STATE_CALLBACK_OPTION, stateCallback);
    }

    public long getStreamUseCase(long j) {
        return ((Long) getConfig().retrieveOption(STREAM_USE_CASE_OPTION, Long.valueOf(j))).longValue();
    }
}

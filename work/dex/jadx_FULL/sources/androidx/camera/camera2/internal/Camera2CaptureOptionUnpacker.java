package androidx.camera.camera2.internal;

import androidx.annotation.NonNull;
import androidx.annotation.OptIn;
import androidx.annotation.RequiresApi;
import androidx.camera.camera2.impl.Camera2ImplConfig;
import androidx.camera.camera2.interop.ExperimentalCamera2Interop;
import androidx.camera.core.impl.CaptureConfig;
import androidx.camera.core.impl.Config;
import androidx.camera.core.impl.OptionsBundle;
import androidx.camera.core.impl.UseCaseConfig;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_13_8952cls.dex */
@RequiresApi(21)
class Camera2CaptureOptionUnpacker implements CaptureConfig.OptionUnpacker {
    static final Camera2CaptureOptionUnpacker INSTANCE = new Camera2CaptureOptionUnpacker();

    @Override // androidx.camera.core.impl.CaptureConfig.OptionUnpacker
    @OptIn(markerClass = {ExperimentalCamera2Interop.class})
    public void unpack(@NonNull UseCaseConfig<?> useCaseConfig, @NonNull CaptureConfig.Builder builder) {
        CaptureConfig defaultCaptureConfig = useCaseConfig.getDefaultCaptureConfig(null);
        Config configEmptyBundle = OptionsBundle.emptyBundle();
        int templateType = CaptureConfig.defaultEmptyCaptureConfig().getTemplateType();
        if (defaultCaptureConfig != null) {
            templateType = defaultCaptureConfig.getTemplateType();
            builder.addAllCameraCaptureCallbacks(defaultCaptureConfig.getCameraCaptureCallbacks());
            configEmptyBundle = defaultCaptureConfig.getImplementationOptions();
        }
        builder.setImplementationOptions(configEmptyBundle);
        Camera2ImplConfig camera2ImplConfig = new Camera2ImplConfig(useCaseConfig);
        builder.setTemplateType(camera2ImplConfig.getCaptureRequestTemplate(templateType));
        builder.addCameraCaptureCallback(CaptureCallbackContainer.create(camera2ImplConfig.getSessionCaptureCallback(Camera2CaptureCallbacks.createNoOpCallback())));
        builder.addImplementationOptions(camera2ImplConfig.getCaptureRequestOptions());
    }
}

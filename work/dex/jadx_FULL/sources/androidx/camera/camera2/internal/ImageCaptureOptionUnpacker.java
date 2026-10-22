package androidx.camera.camera2.internal;

import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.camera.camera2.impl.Camera2ImplConfig;
import androidx.camera.camera2.internal.compat.workaround.ImageCapturePixelHDRPlus;
import androidx.camera.core.impl.CaptureConfig;
import androidx.camera.core.impl.ImageCaptureConfig;
import androidx.camera.core.impl.UseCaseConfig;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_13_8952cls.dex */
@RequiresApi(21)
final class ImageCaptureOptionUnpacker extends Camera2CaptureOptionUnpacker {
    static final ImageCaptureOptionUnpacker INSTANCE = new ImageCaptureOptionUnpacker(new ImageCapturePixelHDRPlus());

    @NonNull
    private final ImageCapturePixelHDRPlus mImageCapturePixelHDRPlus;

    private ImageCaptureOptionUnpacker(@NonNull ImageCapturePixelHDRPlus imageCapturePixelHDRPlus) {
        this.mImageCapturePixelHDRPlus = imageCapturePixelHDRPlus;
    }

    @Override // androidx.camera.camera2.internal.Camera2CaptureOptionUnpacker, androidx.camera.core.impl.CaptureConfig.OptionUnpacker
    public void unpack(@NonNull UseCaseConfig<?> useCaseConfig, @NonNull CaptureConfig.Builder builder) {
        super.unpack(useCaseConfig, builder);
        if (!(useCaseConfig instanceof ImageCaptureConfig)) {
            throw new IllegalArgumentException("config is not ImageCaptureConfig");
        }
        ImageCaptureConfig imageCaptureConfig = (ImageCaptureConfig) useCaseConfig;
        Camera2ImplConfig.Builder builder2 = new Camera2ImplConfig.Builder();
        if (imageCaptureConfig.hasCaptureMode()) {
            this.mImageCapturePixelHDRPlus.toggleHDRPlus(imageCaptureConfig.getCaptureMode(), builder2);
        }
        builder.addImplementationOptions(builder2.build());
    }
}

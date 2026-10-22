package androidx.camera.core.processing;

import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.camera.core.ImageProcessor;
import androidx.camera.core.ImageProxy;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_13_8952cls.dex */
@RequiresApi(api = 21)
public class ImageProcessorRequest implements ImageProcessor.Request {

    @NonNull
    private final ImageProxy mImageProxy;
    private final int mOutputFormat;

    public ImageProcessorRequest(@NonNull ImageProxy imageProxy, int i) {
        this.mImageProxy = imageProxy;
        this.mOutputFormat = i;
    }

    @Override // androidx.camera.core.ImageProcessor.Request
    @NonNull
    public ImageProxy getInputImage() {
        return this.mImageProxy;
    }

    @Override // androidx.camera.core.ImageProcessor.Request
    public int getOutputFormat() {
        return this.mOutputFormat;
    }
}

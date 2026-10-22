package androidx.camera.view.transform;

import android.graphics.Matrix;
import android.graphics.RectF;
import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.camera.core.ImageProxy;
import androidx.camera.core.impl.utils.TransformUtils;
import androidx.camera.view.TransformExperimental;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_13_8952cls.dex */
@RequiresApi(21)
@TransformExperimental
public final class ImageProxyTransformFactory {
    private boolean mUsingCropRect;
    private boolean mUsingRotationDegrees;

    private RectF getCropRect(@NonNull ImageProxy imageProxy) {
        return this.mUsingCropRect ? new RectF(imageProxy.getCropRect()) : new RectF(0.0f, 0.0f, imageProxy.getWidth(), imageProxy.getHeight());
    }

    public static RectF getRotatedCropRect(RectF rectF, int i) {
        return TransformUtils.is90or270(i) ? new RectF(0.0f, 0.0f, rectF.height(), rectF.width()) : new RectF(0.0f, 0.0f, rectF.width(), rectF.height());
    }

    private int getRotationDegrees(@NonNull ImageProxy imageProxy) {
        if (this.mUsingRotationDegrees) {
            return imageProxy.getImageInfo().getRotationDegrees();
        }
        return 0;
    }

    @NonNull
    public OutputTransform getOutputTransform(@NonNull ImageProxy imageProxy) {
        int rotationDegrees = getRotationDegrees(imageProxy);
        RectF cropRect = getCropRect(imageProxy);
        Matrix rectToRect = TransformUtils.getRectToRect(cropRect, getRotatedCropRect(cropRect, rotationDegrees), rotationDegrees);
        rectToRect.preConcat(TransformUtils.getNormalizedToBuffer(imageProxy.getCropRect()));
        return new OutputTransform(rectToRect, TransformUtils.rectToSize(imageProxy.getCropRect()));
    }

    public boolean isUsingCropRect() {
        return this.mUsingCropRect;
    }

    public boolean isUsingRotationDegrees() {
        return this.mUsingRotationDegrees;
    }

    public void setUsingCropRect(boolean z) {
        this.mUsingCropRect = z;
    }

    public void setUsingRotationDegrees(boolean z) {
        this.mUsingRotationDegrees = z;
    }
}

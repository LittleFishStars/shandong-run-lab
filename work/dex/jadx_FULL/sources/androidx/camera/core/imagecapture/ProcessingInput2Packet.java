package androidx.camera.core.imagecapture;

import android.graphics.Matrix;
import android.graphics.Rect;
import android.graphics.RectF;
import android.util.Size;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.camera.core.ImageCaptureException;
import androidx.camera.core.ImageProxy;
import androidx.camera.core.impl.CameraCaptureResult;
import androidx.camera.core.impl.utils.Exif;
import androidx.camera.core.impl.utils.TransformUtils;
import androidx.camera.core.internal.CameraCaptureResultImageInfo;
import androidx.camera.core.processing.Operation;
import androidx.camera.core.processing.Packet;
import androidx.core.util.Preconditions;
import java.io.IOException;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_13_8952cls.dex */
@RequiresApi(api = 21)
final class ProcessingInput2Packet implements Operation<ProcessingNode.InputPacket, Packet<ImageProxy>> {
    private static Packet<ImageProxy> createPacket(@NonNull ProcessingRequest processingRequest, @Nullable Exif exif, @NonNull ImageProxy imageProxy) {
        return Packet.of(imageProxy, exif, processingRequest.getCropRect(), processingRequest.getRotationDegrees(), processingRequest.getSensorToBufferTransform(), getCameraCaptureResult(imageProxy));
    }

    private static Packet<ImageProxy> createPacketWithHalRotation(@NonNull ProcessingRequest processingRequest, @NonNull Exif exif, @NonNull ImageProxy imageProxy) {
        Size size = new Size(imageProxy.getWidth(), imageProxy.getHeight());
        int rotationDegrees = processingRequest.getRotationDegrees() - exif.getRotation();
        Size rotatedSize = getRotatedSize(rotationDegrees, size);
        Matrix rectToRect = TransformUtils.getRectToRect(new RectF(0.0f, 0.0f, size.getWidth(), size.getHeight()), new RectF(0.0f, 0.0f, rotatedSize.getWidth(), rotatedSize.getHeight()), rotationDegrees);
        return Packet.of(imageProxy, exif, rotatedSize, getUpdatedCropRect(processingRequest.getCropRect(), rectToRect), exif.getRotation(), getUpdatedTransform(processingRequest.getSensorToBufferTransform(), rectToRect), getCameraCaptureResult(imageProxy));
    }

    private static CameraCaptureResult getCameraCaptureResult(@NonNull ImageProxy imageProxy) {
        return ((CameraCaptureResultImageInfo) imageProxy.getImageInfo()).getCameraCaptureResult();
    }

    private static Size getRotatedSize(int i, Size size) {
        return TransformUtils.is90or270(TransformUtils.within360(i)) ? new Size(size.getHeight(), size.getWidth()) : size;
    }

    @NonNull
    private static Rect getUpdatedCropRect(@NonNull Rect rect, @NonNull Matrix matrix) {
        RectF rectF = new RectF(rect);
        matrix.mapRect(rectF);
        rectF.sort();
        Rect rect2 = new Rect();
        rectF.round(rect2);
        return rect2;
    }

    @NonNull
    private static Matrix getUpdatedTransform(@NonNull Matrix matrix, @NonNull Matrix matrix2) {
        Matrix matrix3 = new Matrix(matrix);
        matrix3.postConcat(matrix2);
        return matrix3;
    }

    @Override // androidx.camera.core.processing.Operation
    @NonNull
    public Packet<ImageProxy> apply(@NonNull ProcessingNode.InputPacket inputPacket) throws ImageCaptureException {
        Exif exifCreateFromImageProxy;
        ImageProxy imageProxy = inputPacket.getImageProxy();
        ProcessingRequest processingRequest = inputPacket.getProcessingRequest();
        if (imageProxy.getFormat() == 256) {
            try {
                exifCreateFromImageProxy = Exif.createFromImageProxy(imageProxy);
                imageProxy.getPlanes()[0].getBuffer().rewind();
            } catch (IOException e) {
                throw new ImageCaptureException(1, "Failed to extract EXIF data.", e);
            }
        } else {
            exifCreateFromImageProxy = null;
        }
        if (!ImagePipeline.EXIF_ROTATION_AVAILABILITY.shouldUseExifOrientation(imageProxy)) {
            return createPacket(processingRequest, exifCreateFromImageProxy, imageProxy);
        }
        Preconditions.checkNotNull(exifCreateFromImageProxy, "JPEG image must have exif.");
        return createPacketWithHalRotation(processingRequest, exifCreateFromImageProxy, imageProxy);
    }
}

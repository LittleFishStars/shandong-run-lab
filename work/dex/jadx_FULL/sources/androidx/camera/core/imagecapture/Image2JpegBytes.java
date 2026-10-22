package androidx.camera.core.imagecapture;

import android.graphics.Rect;
import android.util.Size;
import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.camera.core.ImageCaptureException;
import androidx.camera.core.ImageProxy;
import androidx.camera.core.impl.Quirks;
import androidx.camera.core.impl.utils.Exif;
import androidx.camera.core.impl.utils.TransformUtils;
import androidx.camera.core.internal.compat.workaround.JpegMetadataCorrector;
import androidx.camera.core.internal.utils.ImageUtil;
import androidx.camera.core.processing.Operation;
import androidx.camera.core.processing.Packet;
import com.google.auto.value.AutoValue;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.util.Objects;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_13_8952cls.dex */
@RequiresApi(api = 21)
final class Image2JpegBytes implements Operation<In, Packet<byte[]>> {
    private final JpegMetadataCorrector mJpegMetadataCorrector;

    @AutoValue
    public static abstract class In {
        @NonNull
        public static In of(@NonNull Packet<ImageProxy> packet, int i) {
            return new AutoValue_Image2JpegBytes_In(packet, i);
        }

        public abstract int getJpegQuality();

        public abstract Packet<ImageProxy> getPacket();
    }

    public Image2JpegBytes(@NonNull Quirks quirks) {
        this.mJpegMetadataCorrector = new JpegMetadataCorrector(quirks);
    }

    private static Exif extractExif(@NonNull byte[] bArr) throws ImageCaptureException {
        try {
            return Exif.createFromInputStream(new ByteArrayInputStream(bArr));
        } catch (IOException e) {
            throw new ImageCaptureException(0, "Failed to extract Exif from YUV-generated JPEG", e);
        }
    }

    private Packet<byte[]> processJpegImage(@NonNull In in) {
        Packet<ImageProxy> packet = in.getPacket();
        byte[] bArrJpegImageToJpegByteArray = this.mJpegMetadataCorrector.jpegImageToJpegByteArray(packet.getData());
        Exif exif = packet.getExif();
        Objects.requireNonNull(exif);
        return Packet.of(bArrJpegImageToJpegByteArray, exif, 256, packet.getSize(), packet.getCropRect(), packet.getRotationDegrees(), packet.getSensorToBufferTransform(), packet.getCameraCaptureResult());
    }

    private Packet<byte[]> processYuvImage(@NonNull In in) throws ImageCaptureException {
        Packet<ImageProxy> packet = in.getPacket();
        ImageProxy data = packet.getData();
        Rect cropRect = packet.getCropRect();
        try {
            byte[] bArrYuvImageToJpegByteArray = ImageUtil.yuvImageToJpegByteArray(data, cropRect, in.getJpegQuality(), packet.getRotationDegrees());
            return Packet.of(bArrYuvImageToJpegByteArray, extractExif(bArrYuvImageToJpegByteArray), 256, new Size(cropRect.width(), cropRect.height()), new Rect(0, 0, cropRect.width(), cropRect.height()), packet.getRotationDegrees(), TransformUtils.updateSensorToBufferTransform(packet.getSensorToBufferTransform(), cropRect), packet.getCameraCaptureResult());
        } catch (ImageUtil.CodecFailedException e) {
            throw new ImageCaptureException(1, "Failed to encode the image to JPEG.", e);
        }
    }

    @Override // androidx.camera.core.processing.Operation
    @NonNull
    public Packet<byte[]> apply(@NonNull In in) throws ImageCaptureException {
        Packet<byte[]> packetProcessYuvImage;
        try {
            int format = in.getPacket().getFormat();
            if (format == 35) {
                packetProcessYuvImage = processYuvImage(in);
            } else {
                if (format != 256) {
                    throw new IllegalArgumentException("Unexpected format: " + format);
                }
                packetProcessYuvImage = processJpegImage(in);
            }
            in.getPacket().getData().close();
            return packetProcessYuvImage;
        } catch (Throwable th) {
            in.getPacket().getData().close();
            throw th;
        }
    }
}

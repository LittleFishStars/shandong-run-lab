package androidx.camera.core;

import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.annotation.RestrictTo;
import java.util.Objects;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_13_8952cls.dex */
@RequiresApi(21)
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
public class ImageCaptureLatencyEstimate {
    public static final long UNDEFINED_CAPTURE_LATENCY = -1;

    @NonNull
    public static final ImageCaptureLatencyEstimate UNDEFINED_IMAGE_CAPTURE_LATENCY = new ImageCaptureLatencyEstimate(-1, -1);
    public static final long UNDEFINED_PROCESSING_LATENCY = -1;
    public final long captureLatencyMillis;
    public final long processingLatencyMillis;

    public ImageCaptureLatencyEstimate(long j, long j2) {
        this.captureLatencyMillis = j;
        this.processingLatencyMillis = j2;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof ImageCaptureLatencyEstimate)) {
            return false;
        }
        ImageCaptureLatencyEstimate imageCaptureLatencyEstimate = (ImageCaptureLatencyEstimate) obj;
        return this.captureLatencyMillis == imageCaptureLatencyEstimate.captureLatencyMillis && this.processingLatencyMillis == imageCaptureLatencyEstimate.processingLatencyMillis;
    }

    public int hashCode() {
        return Objects.hash(Long.valueOf(this.captureLatencyMillis), Long.valueOf(this.processingLatencyMillis));
    }

    @NonNull
    public String toString() {
        return "captureLatencyMillis=" + this.captureLatencyMillis + ", processingLatencyMillis=" + this.processingLatencyMillis;
    }
}

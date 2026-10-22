package androidx.camera.core.internal.compat;

import android.media.Image;
import android.media.ImageWriter;
import android.os.Build;
import android.view.Surface;
import androidx.annotation.IntRange;
import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_13_8952cls.dex */
@RequiresApi(23)
public final class ImageWriterCompat {
    private ImageWriterCompat() {
    }

    public static void close(@NonNull ImageWriter imageWriter) {
        ImageWriterCompatApi23Impl.close(imageWriter);
    }

    @NonNull
    public static Image dequeueInputImage(@NonNull ImageWriter imageWriter) {
        return ImageWriterCompatApi23Impl.dequeueInputImage(imageWriter);
    }

    @NonNull
    public static ImageWriter newInstance(@NonNull Surface surface, @IntRange(from = 1) int i, int i2) {
        return Build.VERSION.SDK_INT >= 29 ? ImageWriterCompatApi29Impl.newInstance(surface, i, i2) : ImageWriterCompatApi26Impl.newInstance(surface, i, i2);
    }

    public static void queueInputImage(@NonNull ImageWriter imageWriter, @NonNull Image image) {
        ImageWriterCompatApi23Impl.queueInputImage(imageWriter, image);
    }

    @NonNull
    public static ImageWriter newInstance(@NonNull Surface surface, @IntRange(from = 1) int i) {
        return ImageWriterCompatApi23Impl.newInstance(surface, i);
    }
}

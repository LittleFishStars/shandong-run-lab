package androidx.camera.core;

import android.annotation.SuppressLint;
import android.graphics.Bitmap;
import android.graphics.Rect;
import android.media.Image;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.camera.core.internal.utils.ImageUtil;
import java.nio.ByteBuffer;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_13_8952cls.dex */
@RequiresApi(21)
public interface ImageProxy extends AutoCloseable {

    public interface PlaneProxy {
        @NonNull
        ByteBuffer getBuffer();

        int getPixelStride();

        int getRowStride();
    }

    @Override // java.lang.AutoCloseable
    void close();

    @NonNull
    Rect getCropRect();

    int getFormat();

    int getHeight();

    @Nullable
    @ExperimentalGetImage
    Image getImage();

    @NonNull
    ImageInfo getImageInfo();

    @NonNull
    @SuppressLint({"ArrayReturn"})
    PlaneProxy[] getPlanes();

    int getWidth();

    void setCropRect(@Nullable Rect rect);

    @NonNull
    default Bitmap toBitmap() {
        return ImageUtil.createBitmapFromImageProxy(this);
    }
}

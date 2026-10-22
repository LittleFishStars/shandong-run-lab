package androidx.camera.core.impl;

import android.view.Surface;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.annotation.RestrictTo;
import androidx.camera.core.ImageProxy;
import java.util.concurrent.Executor;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_13_8952cls.dex */
@RequiresApi(21)
public interface ImageReaderProxy {

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public interface OnImageAvailableListener {
        void onImageAvailable(@NonNull ImageReaderProxy imageReaderProxy);
    }

    @Nullable
    ImageProxy acquireLatestImage();

    @Nullable
    ImageProxy acquireNextImage();

    void clearOnImageAvailableListener();

    void close();

    int getHeight();

    int getImageFormat();

    int getMaxImages();

    @Nullable
    Surface getSurface();

    int getWidth();

    void setOnImageAvailableListener(@NonNull OnImageAvailableListener onImageAvailableListener, @NonNull Executor executor);
}

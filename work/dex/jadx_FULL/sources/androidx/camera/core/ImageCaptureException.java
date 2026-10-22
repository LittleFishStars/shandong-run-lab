package androidx.camera.core;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_13_8952cls.dex */
@RequiresApi(21)
public class ImageCaptureException extends Exception {
    private final int mImageCaptureError;

    public ImageCaptureException(int i, @NonNull String str, @Nullable Throwable th) {
        super(str, th);
        this.mImageCaptureError = i;
    }

    public int getImageCaptureError() {
        return this.mImageCaptureError;
    }
}

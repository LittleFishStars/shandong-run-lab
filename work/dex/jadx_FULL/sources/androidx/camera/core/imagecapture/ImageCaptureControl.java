package androidx.camera.core.imagecapture;

import androidx.annotation.MainThread;
import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.camera.core.impl.CaptureConfig;
import com.google.common.util.concurrent.ListenableFuture;
import java.util.List;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_13_8952cls.dex */
@RequiresApi(api = 21)
public interface ImageCaptureControl {
    @MainThread
    void lockFlashMode();

    @NonNull
    @MainThread
    ListenableFuture<Void> submitStillCaptureRequests(@NonNull List<CaptureConfig> list);

    @MainThread
    void unlockFlashMode();
}

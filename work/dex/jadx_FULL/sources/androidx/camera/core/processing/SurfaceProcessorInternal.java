package androidx.camera.core.processing;

import androidx.annotation.IntRange;
import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.camera.core.SurfaceProcessor;
import androidx.camera.core.impl.utils.futures.Futures;
import com.google.common.util.concurrent.ListenableFuture;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_13_8952cls.dex */
@RequiresApi(api = 21)
public interface SurfaceProcessorInternal extends SurfaceProcessor {
    void release();

    @NonNull
    default ListenableFuture<Void> snapshot(@IntRange(from = 0, to = 100) int i, @IntRange(from = 0, to = 359) int i2) {
        return Futures.immediateFuture(null);
    }
}

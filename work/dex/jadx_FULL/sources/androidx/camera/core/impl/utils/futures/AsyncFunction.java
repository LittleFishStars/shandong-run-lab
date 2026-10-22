package androidx.camera.core.impl.utils.futures;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import com.google.common.util.concurrent.ListenableFuture;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_13_8952cls.dex */
@FunctionalInterface
@RequiresApi(21)
public interface AsyncFunction<I, O> {
    @NonNull
    ListenableFuture<O> apply(@Nullable I i) throws Exception;
}

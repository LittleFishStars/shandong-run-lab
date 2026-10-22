package androidx.camera.video.internal;

import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.camera.core.impl.Observable;
import com.google.common.util.concurrent.ListenableFuture;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_13_8952cls.dex */
@RequiresApi(21)
public interface BufferProvider<T> extends Observable<State> {

    public enum State {
        ACTIVE,
        INACTIVE
    }

    @NonNull
    ListenableFuture<T> acquireBuffer();
}

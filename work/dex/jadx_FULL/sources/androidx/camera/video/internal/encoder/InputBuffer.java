package androidx.camera.video.internal.encoder;

import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import com.google.common.util.concurrent.ListenableFuture;
import java.nio.ByteBuffer;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_13_8952cls.dex */
@RequiresApi(21)
public interface InputBuffer {
    boolean cancel();

    @NonNull
    ByteBuffer getByteBuffer();

    @NonNull
    ListenableFuture<Void> getTerminationFuture();

    void setEndOfStream(boolean z);

    void setPresentationTimeUs(long j);

    boolean submit();
}

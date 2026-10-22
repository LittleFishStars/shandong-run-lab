package androidx.camera.video.internal.encoder;

import android.media.MediaCodec;
import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import com.google.common.util.concurrent.ListenableFuture;
import java.nio.ByteBuffer;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_13_8952cls.dex */
@RequiresApi(21)
public interface EncodedData extends AutoCloseable {
    @Override // java.lang.AutoCloseable
    void close();

    @NonNull
    MediaCodec.BufferInfo getBufferInfo();

    @NonNull
    ByteBuffer getByteBuffer();

    @NonNull
    ListenableFuture<Void> getClosedFuture();

    long getPresentationTimeUs();

    boolean isKeyFrame();

    long size();
}

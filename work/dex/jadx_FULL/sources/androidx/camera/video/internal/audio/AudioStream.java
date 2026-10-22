package androidx.camera.video.internal.audio;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import com.google.auto.value.AutoValue;
import java.nio.ByteBuffer;
import java.util.concurrent.Executor;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_13_8952cls.dex */
@RequiresApi(21)
public interface AudioStream {

    public interface AudioStreamCallback {
        default void onSilenceStateChanged(boolean z) {
        }
    }

    public static class AudioStreamException extends Exception {
        public AudioStreamException() {
        }

        public AudioStreamException(@NonNull String str) {
            super(str);
        }

        public AudioStreamException(@NonNull String str, @NonNull Throwable th) {
            super(str, th);
        }

        public AudioStreamException(@NonNull Throwable th) {
            super(th);
        }
    }

    @AutoValue
    public static abstract class PacketInfo {
        @NonNull
        public static PacketInfo of(int i, long j) {
            return new AutoValue_AudioStream_PacketInfo(i, j);
        }

        public abstract int getSizeInBytes();

        public abstract long getTimestampNs();
    }

    @NonNull
    PacketInfo read(@NonNull ByteBuffer byteBuffer);

    void release();

    void setCallback(@Nullable AudioStreamCallback audioStreamCallback, @Nullable Executor executor);

    void start() throws IllegalStateException, AudioStreamException;

    void stop() throws IllegalStateException;
}

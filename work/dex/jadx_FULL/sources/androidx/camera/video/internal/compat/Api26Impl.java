package androidx.camera.video.internal.compat;

import android.media.MediaMuxer;
import androidx.annotation.DoNotInline;
import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import java.io.FileDescriptor;
import java.io.IOException;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_13_8952cls.dex */
@RequiresApi(26)
public final class Api26Impl {
    private Api26Impl() {
    }

    @NonNull
    @DoNotInline
    public static MediaMuxer createMediaMuxer(@NonNull FileDescriptor fileDescriptor, int i) throws IOException {
        return new MediaMuxer(fileDescriptor, i);
    }
}

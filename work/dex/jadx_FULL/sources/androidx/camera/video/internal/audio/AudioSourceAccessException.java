package androidx.camera.video.internal.audio;

import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_13_8952cls.dex */
@RequiresApi(21)
public class AudioSourceAccessException extends Exception {
    public AudioSourceAccessException(@Nullable String str) {
        super(str);
    }

    public AudioSourceAccessException(@Nullable String str, @Nullable Throwable th) {
        super(str, th);
    }

    public AudioSourceAccessException(@Nullable Throwable th) {
        super(th);
    }
}

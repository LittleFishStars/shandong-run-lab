package androidx.camera.video.internal.encoder;

import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_13_8952cls.dex */
@RequiresApi(21)
public class InvalidConfigException extends Exception {
    public InvalidConfigException(@Nullable String str) {
        super(str);
    }

    public InvalidConfigException(@Nullable String str, @Nullable Throwable th) {
        super(str, th);
    }

    public InvalidConfigException(@Nullable Throwable th) {
        super(th);
    }
}

package androidx.camera.core;

import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_13_8952cls.dex */
@RequiresApi(21)
public class InitializationException extends Exception {
    public InitializationException(@Nullable String str) {
        super(str);
    }

    public InitializationException(@Nullable String str, @Nullable Throwable th) {
        super(str, th);
    }

    public InitializationException(@Nullable Throwable th) {
        super(th);
    }
}

package androidx.camera.core.impl.utils;

import androidx.annotation.NonNull;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_13_8952cls.dex */
public class InterruptedRuntimeException extends RuntimeException {
    public InterruptedRuntimeException() {
    }

    public InterruptedRuntimeException(@NonNull String str) {
        super(str);
    }

    public InterruptedRuntimeException(@NonNull String str, @NonNull Throwable th) {
        super(str, th);
    }

    public InterruptedRuntimeException(@NonNull Throwable th) {
        super(th);
    }
}

package androidx.camera.core;

import androidx.annotation.RequiresApi;
import androidx.annotation.RestrictTo;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_13_8952cls.dex */
@RequiresApi(21)
public final class CameraInfoUnavailableException extends Exception {
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public CameraInfoUnavailableException(String str, Throwable th) {
        super(str, th);
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public CameraInfoUnavailableException(String str) {
        super(str);
    }
}

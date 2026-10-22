package androidx.camera.video.internal.encoder;

import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_13_8952cls.dex */
@RequiresApi(21)
public class EncodeException extends Exception {
    public static final int ERROR_CODEC = 1;
    public static final int ERROR_UNKNOWN = 0;
    private final int mErrorType;

    @Retention(RetentionPolicy.SOURCE)
    public @interface ErrorType {
    }

    public EncodeException(int i, @Nullable String str, @Nullable Throwable th) {
        super(str, th);
        this.mErrorType = i;
    }

    public int getErrorType() {
        return this.mErrorType;
    }
}

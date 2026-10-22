package androidx.camera.core;

import androidx.annotation.NonNull;
import androidx.annotation.RestrictTo;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_13_8952cls.dex */
public interface ImageProcessor {

    @Retention(RetentionPolicy.SOURCE)
    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public @interface OutputFormats {
    }

    public interface Request {
        @NonNull
        ImageProxy getInputImage();

        int getOutputFormat();
    }

    public interface Response {
        @NonNull
        ImageProxy getOutputImage();
    }

    @NonNull
    Response process(@NonNull Request request) throws ProcessingException;
}

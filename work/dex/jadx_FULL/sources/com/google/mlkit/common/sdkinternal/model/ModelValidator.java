package com.google.mlkit.common.sdkinternal.model;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.mlkit.common.model.RemoteModel;
import java.io.File;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_03_8012cls.dex */
@KeepForSdk
public interface ModelValidator {

    @KeepForSdk
    public static class ValidationResult {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        @NonNull
        @KeepForSdk
        public static final ValidationResult f32462a = new ValidationResult(ErrorCode.OK, null);

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        public final ErrorCode f6645a;

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        @Nullable
        public final String f6646a;

        @KeepForSdk
        public enum ErrorCode {
            OK,
            TFLITE_VERSION_INCOMPATIBLE,
            MODEL_FORMAT_INVALID
        }

        @KeepForSdk
        public ValidationResult(@NonNull ErrorCode errorCode, @Nullable String str) {
            this.f6645a = errorCode;
            this.f6646a = str;
        }

        @NonNull
        @KeepForSdk
        public ErrorCode a() {
            return this.f6645a;
        }

        @Nullable
        @KeepForSdk
        public String b() {
            return this.f6646a;
        }

        @KeepForSdk
        public boolean c() {
            return this.f6645a == ErrorCode.OK;
        }
    }

    @NonNull
    @KeepForSdk
    ValidationResult a(@NonNull File file, @NonNull RemoteModel remoteModel);
}

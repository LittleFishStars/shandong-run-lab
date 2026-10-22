package androidx.camera.camera2.internal;

import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import com.google.auto.value.AutoValue;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_13_8952cls.dex */
@AutoValue
@RequiresApi(21)
abstract class CameraDeviceId {
    @NonNull
    public static CameraDeviceId create(@NonNull String str, @NonNull String str2, @NonNull String str3, @NonNull String str4) {
        return new AutoValue_CameraDeviceId(str.toLowerCase(), str2.toLowerCase(), str3.toLowerCase(), str4.toLowerCase());
    }

    @NonNull
    public abstract String getBrand();

    @NonNull
    public abstract String getCameraId();

    @NonNull
    public abstract String getDevice();

    @NonNull
    public abstract String getModel();
}

package androidx.camera.video.internal.config;

import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_13_8952cls.dex */
@RequiresApi(21)
public abstract class MimeInfo {

    public static abstract class Builder<B> {
        @NonNull
        public abstract MimeInfo build();

        @NonNull
        public abstract B setMimeType(@NonNull String str);

        @NonNull
        public abstract B setProfile(int i);
    }

    @NonNull
    public abstract String getMimeType();

    public abstract int getProfile();
}

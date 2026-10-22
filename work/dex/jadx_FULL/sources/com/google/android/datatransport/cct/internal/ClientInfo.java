package com.google.android.datatransport.cct.internal;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.google.auto.value.AutoValue;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_08_10593cls.dex */
@AutoValue
public abstract class ClientInfo {

    @AutoValue.Builder
    public static abstract class Builder {
        @NonNull
        public abstract ClientInfo a();

        @NonNull
        public abstract Builder b(@Nullable AndroidClientInfo androidClientInfo);

        @NonNull
        public abstract Builder c(@Nullable ClientType clientType);
    }

    public enum ClientType {
        UNKNOWN(0),
        ANDROID_FIREBASE(23);

        private final int value;

        ClientType(int i) {
            this.value = i;
        }
    }

    @NonNull
    public static Builder a() {
        return new c.b();
    }

    @Nullable
    public abstract AndroidClientInfo b();

    @Nullable
    public abstract ClientType c();
}

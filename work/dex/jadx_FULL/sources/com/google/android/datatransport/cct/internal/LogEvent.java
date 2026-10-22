package com.google.android.datatransport.cct.internal;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.google.auto.value.AutoValue;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_08_10593cls.dex */
@AutoValue
public abstract class LogEvent {

    @AutoValue.Builder
    public static abstract class Builder {
        @NonNull
        public abstract LogEvent a();

        @NonNull
        public abstract Builder b(@Nullable Integer num);

        @NonNull
        public abstract Builder c(long j);

        @NonNull
        public abstract Builder d(long j);

        @NonNull
        public abstract Builder e(@Nullable NetworkConnectionInfo networkConnectionInfo);

        @NonNull
        public abstract Builder f(@Nullable byte[] bArr);

        @NonNull
        public abstract Builder g(@Nullable String str);

        @NonNull
        public abstract Builder h(long j);
    }

    public static Builder a() {
        return new d.b();
    }

    @NonNull
    public static Builder i(@NonNull String str) {
        return a().g(str);
    }

    @NonNull
    public static Builder j(@NonNull byte[] bArr) {
        return a().f(bArr);
    }

    @Nullable
    public abstract Integer b();

    public abstract long c();

    public abstract long d();

    @Nullable
    public abstract NetworkConnectionInfo e();

    @Nullable
    public abstract byte[] f();

    @Nullable
    public abstract String g();

    public abstract long h();
}

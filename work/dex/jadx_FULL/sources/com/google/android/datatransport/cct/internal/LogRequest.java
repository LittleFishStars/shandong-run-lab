package com.google.android.datatransport.cct.internal;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.google.auto.value.AutoValue;
import com.google.firebase.encoders.annotations.Encodable;
import java.util.List;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_08_10593cls.dex */
@AutoValue
public abstract class LogRequest {

    @AutoValue.Builder
    public static abstract class Builder {
        @NonNull
        public abstract LogRequest a();

        @NonNull
        public abstract Builder b(@Nullable ClientInfo clientInfo);

        @NonNull
        public abstract Builder c(@Nullable List<LogEvent> list);

        @NonNull
        public abstract Builder d(@Nullable Integer num);

        @NonNull
        public abstract Builder e(@Nullable String str);

        @NonNull
        public abstract Builder f(@Nullable QosTier qosTier);

        @NonNull
        public abstract Builder g(long j);

        @NonNull
        public abstract Builder h(long j);

        @NonNull
        public Builder i(int i) {
            return d(Integer.valueOf(i));
        }

        @NonNull
        public Builder j(@NonNull String str) {
            return e(str);
        }
    }

    @NonNull
    public static Builder a() {
        return new e.b();
    }

    @Nullable
    public abstract ClientInfo b();

    @Nullable
    @Encodable.Field(name = "logEvent")
    public abstract List<LogEvent> c();

    @Nullable
    public abstract Integer d();

    @Nullable
    public abstract String e();

    @Nullable
    public abstract QosTier f();

    public abstract long g();

    public abstract long h();
}

package com.google.android.datatransport.runtime;

import androidx.annotation.Nullable;
import com.google.auto.value.AutoValue;
import com.zj.adlib.t13;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_08_10593cls.dex */
@AutoValue
public abstract class EventInternal {

    @AutoValue.Builder
    public static abstract class Builder {
        public final Builder a(String str, int i) {
            getAutoMetadata().put(str, String.valueOf(i));
            return this;
        }

        public final Builder b(String str, long j) {
            getAutoMetadata().put(str, String.valueOf(j));
            return this;
        }

        public final Builder c(String str, String str2) {
            getAutoMetadata().put(str, str2);
            return this;
        }

        public abstract EventInternal d();

        public abstract Builder e(Integer num);

        public abstract Builder f(t13 t13Var);

        public abstract Builder g(long j);

        public abstract Map<String, String> getAutoMetadata();

        public abstract Builder h(String str);

        public abstract Builder i(long j);

        public abstract Builder setAutoMetadata(Map<String, String> map);
    }

    public static Builder a() {
        return new a.b().setAutoMetadata(new HashMap());
    }

    public final String b(String str) {
        String str2 = getAutoMetadata().get(str);
        return str2 == null ? "" : str2;
    }

    @Nullable
    public abstract Integer c();

    public abstract t13 d();

    public abstract long e();

    public final int f(String str) {
        String str2 = getAutoMetadata().get(str);
        if (str2 == null) {
            return 0;
        }
        return Integer.valueOf(str2).intValue();
    }

    public final long g(String str) {
        String str2 = getAutoMetadata().get(str);
        if (str2 == null) {
            return 0L;
        }
        return Long.valueOf(str2).longValue();
    }

    public abstract Map<String, String> getAutoMetadata();

    public final Map<String, String> h() {
        return Collections.unmodifiableMap(getAutoMetadata());
    }

    public final String i(String str, String str2) {
        String str3 = getAutoMetadata().get(str);
        return str3 == null ? str2 : str3;
    }

    @Deprecated
    public byte[] j() {
        return d().a();
    }

    public abstract String k();

    public abstract long l();

    public Builder m() {
        return new a.b().h(k()).e(c()).f(d()).g(e()).i(l()).setAutoMetadata(new HashMap(getAutoMetadata()));
    }
}

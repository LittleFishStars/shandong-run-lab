package com.google.android.datatransport.runtime;

import com.google.android.datatransport.Event;
import com.google.android.datatransport.Transformer;
import com.google.auto.value.AutoValue;
import com.zj.adlib.f33;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_08_10593cls.dex */
@AutoValue
abstract class SendRequest {

    @AutoValue.Builder
    public static abstract class Builder {
        public abstract SendRequest a();

        public abstract Builder b(f33 f33Var);

        public abstract Builder c(Event<?> event);

        public <T> Builder d(Event<T> event, f33 f33Var, Transformer<T, byte[]> transformer) {
            c(event);
            b(f33Var);
            e(transformer);
            return this;
        }

        public abstract Builder e(Transformer<?, byte[]> transformer);

        public abstract Builder f(TransportContext transportContext);

        public abstract Builder g(String str);
    }

    public static Builder a() {
        return new b.C0667b();
    }

    public abstract f33 b();

    public abstract Event<?> c();

    public byte[] d() {
        return e().apply(c().b());
    }

    public abstract Transformer<?, byte[]> e();

    public abstract TransportContext f();

    public abstract String g();
}

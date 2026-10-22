package com.google.android.gms.common.api.internal;

import android.os.Looper;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.google.android.gms.common.annotation.KeepForSdk;
import com.zj.adlib.jy3;
import com.zj.adlib.yw6;
import java.util.concurrent.Executor;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_08_10593cls.dex */
@KeepForSdk
public final class ListenerHolder<L> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @Nullable
    public volatile a f31227a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @Nullable
    public volatile Object f5506a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final Executor f5507a;

    @KeepForSdk
    public interface Notifier<L> {
        @KeepForSdk
        void a();

        @KeepForSdk
        void b(@NonNull L l);
    }

    @KeepForSdk
    public static final class a<L> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final Object f31228a;

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        public final String f5508a;

        @KeepForSdk
        public a(L l, String str) {
            this.f31228a = l;
            this.f5508a = str;
        }

        @NonNull
        @KeepForSdk
        public String a() {
            return this.f5508a + "@" + System.identityHashCode(this.f31228a);
        }

        @KeepForSdk
        public boolean equals(@Nullable Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof a)) {
                return false;
            }
            a aVar = (a) obj;
            return this.f31228a == aVar.f31228a && this.f5508a.equals(aVar.f5508a);
        }

        @KeepForSdk
        public int hashCode() {
            return (System.identityHashCode(this.f31228a) * 31) + this.f5508a.hashCode();
        }
    }

    @KeepForSdk
    public ListenerHolder(@NonNull Looper looper, @NonNull L l, @NonNull String str) {
        this.f5507a = new jy3(looper);
        this.f5506a = yw6.m(l, "Listener must not be null");
        this.f31227a = new a(l, yw6.h(str));
    }

    @KeepForSdk
    public void a() {
        this.f5506a = null;
        this.f31227a = null;
    }

    @Nullable
    @KeepForSdk
    public a<L> b() {
        return this.f31227a;
    }

    @KeepForSdk
    public boolean c() {
        return this.f5506a != null;
    }

    @KeepForSdk
    public void d(@NonNull final Notifier<? super L> notifier) {
        yw6.m(notifier, "Notifier must not be null");
        this.f5507a.execute(new Runnable() { // from class: com.zj.adlib.h2c
            @Override // java.lang.Runnable
            public final void run() {
                this.f16921a.e(notifier);
            }
        });
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void e(Notifier notifier) {
        Object obj = this.f5506a;
        if (obj == null) {
            notifier.a();
            return;
        }
        try {
            notifier.b(obj);
        } catch (RuntimeException e) {
            notifier.a();
            throw e;
        }
    }

    @KeepForSdk
    public ListenerHolder(@NonNull Executor executor, @NonNull L l, @NonNull String str) {
        this.f5507a = (Executor) yw6.m(executor, "Executor must not be null");
        this.f5506a = yw6.m(l, "Listener must not be null");
        this.f31227a = new a(l, yw6.h(str));
    }
}

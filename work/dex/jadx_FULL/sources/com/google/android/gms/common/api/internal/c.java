package com.google.android.gms.common.api.internal;

import androidx.annotation.NonNull;
import com.google.android.gms.common.Feature;
import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.Api.AnyClient;
import com.google.errorprone.annotations.CanIgnoreReturnValue;
import com.zj.adlib.p2c;
import com.zj.adlib.q2c;
import com.zj.adlib.r2c;
import com.zj.adlib.yw6;
import com.zj.adlib.z09;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_08_10593cls.dex */
@KeepForSdk
public class c<A extends Api.AnyClient, L> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @NonNull
    @KeepForSdk
    public final RegisterListenerMethod<A, L> f31236a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final UnregisterListenerMethod f5535a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final Runnable f5536a;

    @KeepForSdk
    public static class a<A extends Api.AnyClient, L> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public int f31237a;

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        public ListenerHolder f5537a;

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        public RemoteCall f5538a;

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        public Runnable f5539a = p2c.f43880a;

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        public boolean f5540a = true;

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        public Feature[] f5541a;
        public RemoteCall b;

        public a() {
        }

        public /* synthetic */ a(q2c q2cVar) {
        }

        @NonNull
        @KeepForSdk
        public c<A, L> a() {
            yw6.b(this.f5538a != null, "Must set register function");
            yw6.b(this.b != null, "Must set unregister function");
            yw6.b(this.f5537a != null, "Must set holder");
            return new c<>(new v(this, this.f5537a, this.f5541a, this.f5540a, this.f31237a), new w(this, (ListenerHolder.a) yw6.m(this.f5537a.b(), "Key must not be null")), this.f5539a, null);
        }

        @NonNull
        @CanIgnoreReturnValue
        @KeepForSdk
        public a<A, L> b(@NonNull Runnable runnable) {
            this.f5539a = runnable;
            return this;
        }

        @NonNull
        @CanIgnoreReturnValue
        @KeepForSdk
        public a<A, L> c(@NonNull RemoteCall<A, z09<Void>> remoteCall) {
            this.f5538a = remoteCall;
            return this;
        }

        @NonNull
        @CanIgnoreReturnValue
        @KeepForSdk
        public a<A, L> d(boolean z) {
            this.f5540a = z;
            return this;
        }

        @NonNull
        @CanIgnoreReturnValue
        @KeepForSdk
        public a<A, L> e(@NonNull Feature... featureArr) {
            this.f5541a = featureArr;
            return this;
        }

        @NonNull
        @CanIgnoreReturnValue
        @KeepForSdk
        public a<A, L> f(int i) {
            this.f31237a = i;
            return this;
        }

        @NonNull
        @CanIgnoreReturnValue
        @KeepForSdk
        public a<A, L> g(@NonNull RemoteCall<A, z09<Boolean>> remoteCall) {
            this.b = remoteCall;
            return this;
        }

        @NonNull
        @CanIgnoreReturnValue
        @KeepForSdk
        public a<A, L> h(@NonNull ListenerHolder<L> listenerHolder) {
            this.f5537a = listenerHolder;
            return this;
        }
    }

    public /* synthetic */ c(RegisterListenerMethod registerListenerMethod, UnregisterListenerMethod unregisterListenerMethod, Runnable runnable, r2c r2cVar) {
        this.f31236a = registerListenerMethod;
        this.f5535a = unregisterListenerMethod;
        this.f5536a = runnable;
    }

    @NonNull
    @KeepForSdk
    public static <A extends Api.AnyClient, L> a<A, L> a() {
        return new a<>(null);
    }
}

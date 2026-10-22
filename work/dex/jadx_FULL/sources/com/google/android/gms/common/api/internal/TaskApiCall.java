package com.google.android.gms.common.api.internal;

import android.os.RemoteException;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.google.android.gms.common.Feature;
import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.Api.AnyClient;
import com.google.android.gms.common.util.BiConsumer;
import com.google.errorprone.annotations.CanIgnoreReturnValue;
import com.zj.adlib.x2c;
import com.zj.adlib.yw6;
import com.zj.adlib.z09;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_08_10593cls.dex */
@KeepForSdk
public abstract class TaskApiCall<A extends Api.AnyClient, ResultT> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f31230a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final boolean f5512a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @Nullable
    public final Feature[] f5513a;

    @KeepForSdk
    public static class a<A extends Api.AnyClient, ResultT> {

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        public RemoteCall f5514a;

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        public Feature[] f5516a;

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        public boolean f5515a = true;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public int f31231a = 0;

        public a() {
        }

        public /* synthetic */ a(x2c x2cVar) {
        }

        @NonNull
        @KeepForSdk
        public TaskApiCall<A, ResultT> a() {
            yw6.b(this.f5514a != null, "execute parameter required");
            return new x(this, this.f5516a, this.f5515a, this.f31231a);
        }

        @NonNull
        @Deprecated
        @CanIgnoreReturnValue
        @KeepForSdk
        public a<A, ResultT> b(@NonNull final BiConsumer<A, z09<ResultT>> biConsumer) {
            this.f5514a = new RemoteCall() { // from class: com.zj.adlib.w2c
                @Override // com.google.android.gms.common.api.internal.RemoteCall
                public final void accept(Object obj, Object obj2) {
                    biConsumer.accept((Api.AnyClient) obj, (z09) obj2);
                }
            };
            return this;
        }

        @NonNull
        @CanIgnoreReturnValue
        @KeepForSdk
        public a<A, ResultT> c(@NonNull RemoteCall<A, z09<ResultT>> remoteCall) {
            this.f5514a = remoteCall;
            return this;
        }

        @NonNull
        @CanIgnoreReturnValue
        @KeepForSdk
        public a<A, ResultT> d(boolean z) {
            this.f5515a = z;
            return this;
        }

        @NonNull
        @CanIgnoreReturnValue
        @KeepForSdk
        public a<A, ResultT> e(@NonNull Feature... featureArr) {
            this.f5516a = featureArr;
            return this;
        }

        @NonNull
        @CanIgnoreReturnValue
        @KeepForSdk
        public a<A, ResultT> f(int i) {
            this.f31231a = i;
            return this;
        }
    }

    @KeepForSdk
    @Deprecated
    public TaskApiCall() {
        this.f5513a = null;
        this.f5512a = false;
        this.f31230a = 0;
    }

    @KeepForSdk
    public TaskApiCall(@Nullable Feature[] featureArr, boolean z, int i) {
        this.f5513a = featureArr;
        boolean z2 = false;
        if (featureArr != null && z) {
            z2 = true;
        }
        this.f5512a = z2;
        this.f31230a = i;
    }

    @NonNull
    @KeepForSdk
    public static <A extends Api.AnyClient, ResultT> a<A, ResultT> a() {
        return new a<>(null);
    }

    @KeepForSdk
    public boolean b() {
        return this.f5512a;
    }

    public final int c() {
        return this.f31230a;
    }

    @Nullable
    public final Feature[] d() {
        return this.f5513a;
    }

    @KeepForSdk
    public abstract void doExecute(@NonNull A a2, @NonNull z09<ResultT> z09Var) throws RemoteException;
}

package com.google.android.gms.common.api;

import android.accounts.Account;
import android.content.Context;
import android.content.Intent;
import android.os.IBinder;
import android.os.Looper;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.common.Feature;
import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.android.gms.common.api.Api.ApiOptions;
import com.google.android.gms.common.api.internal.ConnectionCallbacks;
import com.google.android.gms.common.api.internal.OnConnectionFailedListener;
import com.google.android.gms.common.internal.BaseGmsClient;
import com.google.android.gms.common.internal.IAccountAccessor;
import com.google.android.gms.common.util.VisibleForTesting;
import com.zj.adlib.d0c;
import com.zj.adlib.fm1;
import com.zj.adlib.yw6;
import java.io.FileDescriptor;
import java.io.PrintWriter;
import java.util.Collections;
import java.util.List;
import java.util.Set;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_08_10593cls.dex */
public final class Api<O extends ApiOptions> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final AbstractClientBuilder f31209a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final b f5453a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final String f5454a;

    @VisibleForTesting
    @KeepForSdk
    public static abstract class AbstractClientBuilder<T extends Client, O> extends BaseClientBuilder<T, O> {
        @NonNull
        @KeepForSdk
        @Deprecated
        public T c(@NonNull Context context, @NonNull Looper looper, @NonNull fm1 fm1Var, @NonNull O o, @NonNull GoogleApiClient.ConnectionCallbacks connectionCallbacks, @NonNull GoogleApiClient.OnConnectionFailedListener onConnectionFailedListener) {
            return (T) d(context, looper, fm1Var, o, connectionCallbacks, onConnectionFailedListener);
        }

        @NonNull
        @KeepForSdk
        public T d(@NonNull Context context, @NonNull Looper looper, @NonNull fm1 fm1Var, @NonNull O o, @NonNull ConnectionCallbacks connectionCallbacks, @NonNull OnConnectionFailedListener onConnectionFailedListener) {
            throw new UnsupportedOperationException("buildClient must be implemented");
        }
    }

    @KeepForSdk
    public interface AnyClient {
    }

    public interface ApiOptions {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        @NonNull
        public static final a f31210a = new a(null);

        public interface HasAccountOptions extends HasOptions, NotRequiredOptions {
            @NonNull
            Account getAccount();
        }

        public interface HasGoogleSignInAccountOptions extends HasOptions {
            @Nullable
            GoogleSignInAccount g();
        }

        public interface HasOptions extends ApiOptions {
        }

        public interface NotRequiredOptions extends ApiOptions {
        }

        public interface Optional extends HasOptions, NotRequiredOptions {
        }

        public static final class a implements NotRequiredOptions {
            public a() {
            }

            public /* synthetic */ a(d0c d0cVar) {
            }
        }
    }

    @VisibleForTesting
    @KeepForSdk
    public static abstract class BaseClientBuilder<T extends AnyClient, O> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        @KeepForSdk
        public static final int f31211a = 1;

        @KeepForSdk
        public static final int b = 2;

        @KeepForSdk
        public static final int c = Integer.MAX_VALUE;

        @NonNull
        @KeepForSdk
        public List<Scope> a(@Nullable O o) {
            return Collections.emptyList();
        }

        @KeepForSdk
        public int b() {
            return Integer.MAX_VALUE;
        }
    }

    @KeepForSdk
    public interface Client extends AnyClient {
        @Nullable
        @KeepForSdk
        IBinder a();

        @KeepForSdk
        boolean b();

        @NonNull
        @KeepForSdk
        Feature[] c();

        @KeepForSdk
        void d(@NonNull String str);

        @KeepForSdk
        void disconnect();

        @KeepForSdk
        void dump(@NonNull String str, @Nullable FileDescriptor fileDescriptor, @NonNull PrintWriter printWriter, @Nullable String[] strArr);

        @KeepForSdk
        void e(@Nullable IAccountAccessor iAccountAccessor, @Nullable Set<Scope> set);

        @NonNull
        @KeepForSdk
        Set<Scope> f();

        @KeepForSdk
        void g(@NonNull BaseGmsClient.SignOutCallbacks signOutCallbacks);

        @KeepForSdk
        boolean i();

        @KeepForSdk
        boolean isConnected();

        @KeepForSdk
        boolean isConnecting();

        @KeepForSdk
        void j(@NonNull BaseGmsClient.ConnectionProgressReportCallbacks connectionProgressReportCallbacks);

        @KeepForSdk
        boolean k();

        @KeepForSdk
        int l();

        @NonNull
        @KeepForSdk
        Feature[] n();

        @NonNull
        @KeepForSdk
        String p();

        @KeepForSdk
        boolean q();

        @Nullable
        @KeepForSdk
        String r();

        @NonNull
        @KeepForSdk
        Intent t();
    }

    @KeepForSdk
    public static class a<C extends AnyClient> {
    }

    @VisibleForTesting
    @KeepForSdk
    public static final class b<C extends Client> extends a<C> {
    }

    @KeepForSdk
    public <C extends Client> Api(@NonNull String str, @NonNull AbstractClientBuilder<C, O> abstractClientBuilder, @NonNull b<C> bVar) {
        yw6.m(abstractClientBuilder, "Cannot construct an Api with a null ClientBuilder");
        yw6.m(bVar, "Cannot construct an Api with a null ClientKey");
        this.f5454a = str;
        this.f31209a = abstractClientBuilder;
        this.f5453a = bVar;
    }

    @NonNull
    public final AbstractClientBuilder a() {
        return this.f31209a;
    }

    @NonNull
    public final a b() {
        return this.f5453a;
    }

    @NonNull
    public final BaseClientBuilder c() {
        return this.f31209a;
    }

    @NonNull
    public final String d() {
        return this.f5454a;
    }
}

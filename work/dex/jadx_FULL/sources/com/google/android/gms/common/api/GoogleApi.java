package com.google.android.gms.common.api;

import android.accounts.Account;
import android.app.Activity;
import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import androidx.annotation.MainThread;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.WorkerThread;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.android.gms.common.api.Api.ApiOptions;
import com.google.android.gms.common.api.internal.BaseImplementation;
import com.google.android.gms.common.api.internal.ListenerHolder;
import com.google.android.gms.common.api.internal.RegisterListenerMethod;
import com.google.android.gms.common.api.internal.StatusExceptionMapper;
import com.google.android.gms.common.api.internal.TaskApiCall;
import com.google.android.gms.common.api.internal.UnregisterListenerMethod;
import com.google.android.gms.common.api.internal.c;
import com.google.android.gms.common.api.internal.t;
import com.google.android.gms.common.api.internal.u;
import com.google.android.gms.common.api.internal.zact;
import com.google.android.gms.common.internal.BaseGmsClient;
import com.google.android.gms.tasks.Task;
import com.google.errorprone.annotations.CanIgnoreReturnValue;
import com.zj.adlib.a90;
import com.zj.adlib.c06;
import com.zj.adlib.c90;
import com.zj.adlib.fm1;
import com.zj.adlib.i76;
import com.zj.adlib.is6;
import com.zj.adlib.r0c;
import com.zj.adlib.yw6;
import com.zj.adlib.z09;
import java.lang.reflect.InvocationTargetException;
import java.util.Collections;
import java.util.Set;
import org.checkerframework.checker.initialization.qual.NotOnlyInitialized;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_08_10593cls.dex */
public abstract class GoogleApi<O extends Api.ApiOptions> implements HasApiKey<O> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f31212a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final Context f5455a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final Looper f5456a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final Api.ApiOptions f5457a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final Api f5458a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NotOnlyInitialized
    public final GoogleApiClient f5459a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final StatusExceptionMapper f5460a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final com.google.android.gms.common.api.internal.a f5461a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final c90 f5462a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @Nullable
    public final String f5463a;

    @KeepForSdk
    public static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        @NonNull
        @KeepForSdk
        public static final a f31213a = new C0707a().a();

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        @NonNull
        public final Looper f5464a;

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        @NonNull
        public final StatusExceptionMapper f5465a;

        /* JADX INFO: renamed from: com.google.android.gms.common.api.GoogleApi$a$a, reason: collision with other inner class name */
        @KeepForSdk
        public static class C0707a {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public Looper f31214a;

            /* JADX INFO: renamed from: a, reason: collision with other field name */
            public StatusExceptionMapper f5466a;

            @KeepForSdk
            public C0707a() {
            }

            /* JADX WARN: Multi-variable type inference failed */
            @NonNull
            @KeepForSdk
            public a a() {
                if (this.f5466a == null) {
                    this.f5466a = new a90();
                }
                if (this.f31214a == null) {
                    this.f31214a = Looper.getMainLooper();
                }
                return new a(this.f5466a, this.f31214a);
            }

            @NonNull
            @CanIgnoreReturnValue
            @KeepForSdk
            public C0707a b(@NonNull Looper looper) {
                yw6.m(looper, "Looper must not be null.");
                this.f31214a = looper;
                return this;
            }

            @NonNull
            @CanIgnoreReturnValue
            @KeepForSdk
            public C0707a c(@NonNull StatusExceptionMapper statusExceptionMapper) {
                yw6.m(statusExceptionMapper, "StatusExceptionMapper must not be null.");
                this.f5466a = statusExceptionMapper;
                return this;
            }
        }

        @KeepForSdk
        public a(StatusExceptionMapper statusExceptionMapper, Account account, Looper looper) {
            this.f5465a = statusExceptionMapper;
            this.f5464a = looper;
        }
    }

    @KeepForSdk
    @MainThread
    public GoogleApi(@NonNull Activity activity, @NonNull Api<O> api, @NonNull O o, @NonNull a aVar) {
        this(activity, activity, api, o, aVar);
    }

    public final BaseImplementation.ApiMethodImpl A(int i, @NonNull BaseImplementation.ApiMethodImpl apiMethodImpl) {
        apiMethodImpl.o();
        this.f5461a.J(this, i, apiMethodImpl);
        return apiMethodImpl;
    }

    public final Task B(int i, @NonNull TaskApiCall taskApiCall) {
        z09 z09Var = new z09();
        this.f5461a.K(this, i, taskApiCall, z09Var, this.f5460a);
        return z09Var.a();
    }

    @NonNull
    @KeepForSdk
    public fm1.a createClientSettingsBuilder() {
        Account account;
        GoogleSignInAccount googleSignInAccountG;
        GoogleSignInAccount googleSignInAccountG2;
        fm1.a aVar = new fm1.a();
        Api.ApiOptions apiOptions = this.f5457a;
        if (!(apiOptions instanceof Api.ApiOptions.HasGoogleSignInAccountOptions) || (googleSignInAccountG2 = ((Api.ApiOptions.HasGoogleSignInAccountOptions) apiOptions).g()) == null) {
            Api.ApiOptions apiOptions2 = this.f5457a;
            account = apiOptions2 instanceof Api.ApiOptions.HasAccountOptions ? ((Api.ApiOptions.HasAccountOptions) apiOptions2).getAccount() : null;
        } else {
            account = googleSignInAccountG2.getAccount();
        }
        aVar.d(account);
        Api.ApiOptions apiOptions3 = this.f5457a;
        Set<Scope> setEmptySet = (!(apiOptions3 instanceof Api.ApiOptions.HasGoogleSignInAccountOptions) || (googleSignInAccountG = ((Api.ApiOptions.HasGoogleSignInAccountOptions) apiOptions3).g()) == null) ? Collections.emptySet() : googleSignInAccountG.getRequestedScopes();
        aVar.c(setEmptySet);
        aVar.e(this.f5455a.getClass().getName());
        aVar.b(this.f5455a.getPackageName());
        return aVar;
    }

    @Override // com.google.android.gms.common.api.HasApiKey
    @NonNull
    public final c90<O> d() {
        return this.f5462a;
    }

    @NonNull
    @KeepForSdk
    public Task<Boolean> disconnectService() {
        return this.f5461a.C(this);
    }

    @Nullable
    @KeepForSdk
    public String getContextAttributionTag() {
        return this.f5463a;
    }

    @Nullable
    @KeepForSdk
    @Deprecated
    public String getContextFeatureId() {
        return this.f5463a;
    }

    @NonNull
    @KeepForSdk
    public GoogleApiClient i() {
        return this.f5459a;
    }

    @NonNull
    @KeepForSdk
    public <A extends Api.AnyClient, T extends BaseImplementation.ApiMethodImpl<? extends Result, A>> T j(@NonNull T t) {
        A(2, t);
        return t;
    }

    @NonNull
    @KeepForSdk
    public <TResult, A extends Api.AnyClient> Task<TResult> k(@NonNull TaskApiCall<A, TResult> taskApiCall) {
        return B(2, taskApiCall);
    }

    @NonNull
    @KeepForSdk
    public <A extends Api.AnyClient, T extends BaseImplementation.ApiMethodImpl<? extends Result, A>> T l(@NonNull T t) {
        A(0, t);
        return t;
    }

    @NonNull
    @KeepForSdk
    public <TResult, A extends Api.AnyClient> Task<TResult> m(@NonNull TaskApiCall<A, TResult> taskApiCall) {
        return B(0, taskApiCall);
    }

    @NonNull
    @KeepForSdk
    @Deprecated
    public <A extends Api.AnyClient, T extends RegisterListenerMethod<A, ?>, U extends UnregisterListenerMethod<A, ?>> Task<Void> n(@NonNull T t, @NonNull U u) {
        yw6.l(t);
        yw6.l(u);
        yw6.m(t.b(), "Listener has already been released.");
        yw6.m(u.a(), "Listener has already been released.");
        yw6.b(i76.b(t.b(), u.a()), "Listener registration and unregistration methods must be constructed with the same ListenerHolder.");
        return this.f5461a.D(this, t, u, new Runnable() { // from class: com.zj.adlib.b3c
            @Override // java.lang.Runnable
            public final void run() {
            }
        });
    }

    @NonNull
    @KeepForSdk
    public <A extends Api.AnyClient> Task<Void> o(@NonNull c<A, ?> cVar) {
        yw6.l(cVar);
        yw6.m(cVar.f31236a.b(), "Listener has already been released.");
        yw6.m(cVar.f5535a.a(), "Listener has already been released.");
        return this.f5461a.D(this, cVar.f31236a, cVar.f5535a, cVar.f5536a);
    }

    @NonNull
    @KeepForSdk
    public Task<Boolean> p(@NonNull ListenerHolder.a<?> aVar) {
        return q(aVar, 0);
    }

    @NonNull
    @KeepForSdk
    public Task<Boolean> q(@NonNull ListenerHolder.a<?> aVar, int i) {
        yw6.m(aVar, "Listener key cannot be null.");
        return this.f5461a.E(this, aVar, i);
    }

    @NonNull
    @KeepForSdk
    public <A extends Api.AnyClient, T extends BaseImplementation.ApiMethodImpl<? extends Result, A>> T r(@NonNull T t) {
        A(1, t);
        return t;
    }

    @NonNull
    @KeepForSdk
    public <TResult, A extends Api.AnyClient> Task<TResult> s(@NonNull TaskApiCall<A, TResult> taskApiCall) {
        return B(1, taskApiCall);
    }

    @NonNull
    @KeepForSdk
    public O t() {
        return (O) this.f5457a;
    }

    @NonNull
    @KeepForSdk
    public Context u() {
        return this.f5455a;
    }

    @NonNull
    @KeepForSdk
    public Looper v() {
        return this.f5456a;
    }

    @NonNull
    @KeepForSdk
    public <L> ListenerHolder<L> w(@NonNull L l, @NonNull String str) {
        return com.google.android.gms.common.api.internal.b.a(l, this.f5456a, str);
    }

    public final int x() {
        return this.f31212a;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @WorkerThread
    public final Api.Client y(Looper looper, t tVar) {
        Api.Client clientC = ((Api.AbstractClientBuilder) yw6.l(this.f5458a.a())).c(this.f5455a, looper, createClientSettingsBuilder().a(), this.f5457a, tVar, tVar);
        String contextAttributionTag = getContextAttributionTag();
        if (contextAttributionTag != null && (clientC instanceof BaseGmsClient)) {
            ((BaseGmsClient) clientC).D(contextAttributionTag);
        }
        if (contextAttributionTag != null && (clientC instanceof c06)) {
            ((c06) clientC).w(contextAttributionTag);
        }
        return clientC;
    }

    public final zact z(Context context, Handler handler) {
        return new zact(context, handler, createClientSettingsBuilder().a());
    }

    @KeepForSdk
    @Deprecated
    public GoogleApi(@NonNull Activity activity, @NonNull Api<O> api, @NonNull O o, @NonNull StatusExceptionMapper statusExceptionMapper) {
        a.C0707a c0707a = new a.C0707a();
        c0707a.c(statusExceptionMapper);
        c0707a.b(activity.getMainLooper());
        this(activity, (Api) api, (Api.ApiOptions) o, c0707a.a());
    }

    public GoogleApi(@NonNull Context context, @Nullable Activity activity, Api api, Api.ApiOptions apiOptions, a aVar) {
        yw6.m(context, "Null context is not permitted.");
        yw6.m(api, "Api must not be null.");
        yw6.m(aVar, "Settings must not be null; use Settings.DEFAULT_SETTINGS instead.");
        this.f5455a = context.getApplicationContext();
        String str = null;
        if (is6.q()) {
            try {
                str = (String) Context.class.getMethod("getAttributionTag", new Class[0]).invoke(context, new Object[0]);
            } catch (IllegalAccessException | NoSuchMethodException | InvocationTargetException unused) {
            }
        }
        this.f5463a = str;
        this.f5458a = api;
        this.f5457a = apiOptions;
        this.f5456a = aVar.f5464a;
        c90 c90VarA = c90.a(api, apiOptions, str);
        this.f5462a = c90VarA;
        this.f5459a = new u(this);
        com.google.android.gms.common.api.internal.a aVarZ = com.google.android.gms.common.api.internal.a.z(this.f5455a);
        this.f5461a = aVarZ;
        this.f31212a = aVarZ.n();
        this.f5460a = aVar.f5465a;
        if (activity != null && !(activity instanceof GoogleApiActivity) && Looper.myLooper() == Looper.getMainLooper()) {
            r0c.r(activity, aVarZ, c90VarA);
        }
        aVarZ.c(this);
    }

    @KeepForSdk
    @Deprecated
    public GoogleApi(@NonNull Context context, @NonNull Api<O> api, @NonNull O o, @NonNull Looper looper, @NonNull StatusExceptionMapper statusExceptionMapper) {
        a.C0707a c0707a = new a.C0707a();
        c0707a.b(looper);
        c0707a.c(statusExceptionMapper);
        this(context, api, o, c0707a.a());
    }

    @KeepForSdk
    public GoogleApi(@NonNull Context context, @NonNull Api<O> api, @NonNull O o, @NonNull a aVar) {
        this(context, (Activity) null, api, o, aVar);
    }

    @KeepForSdk
    @Deprecated
    public GoogleApi(@NonNull Context context, @NonNull Api<O> api, @NonNull O o, @NonNull StatusExceptionMapper statusExceptionMapper) {
        a.C0707a c0707a = new a.C0707a();
        c0707a.c(statusExceptionMapper);
        this(context, api, o, c0707a.a());
    }
}

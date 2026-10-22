package com.google.android.gms.common.api;

import android.accounts.Account;
import android.app.Activity;
import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.view.View;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.collection.ArrayMap;
import androidx.fragment.app.FragmentActivity;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.android.gms.common.api.internal.BaseImplementation;
import com.google.android.gms.common.api.internal.ListenerHolder;
import com.google.android.gms.common.api.internal.SignInConnectionListener;
import com.google.android.gms.common.api.internal.p;
import com.google.android.gms.common.util.VisibleForTesting;
import com.google.errorprone.annotations.CanIgnoreReturnValue;
import com.ipd.dsp.internal.i.q;
import com.zj.adlib.c1c;
import com.zj.adlib.ex4;
import com.zj.adlib.fm1;
import com.zj.adlib.g3c;
import com.zj.adlib.i3c;
import com.zj.adlib.n5c;
import com.zj.adlib.o4c;
import com.zj.adlib.pv3;
import com.zj.adlib.yb8;
import com.zj.adlib.ys;
import com.zj.adlib.yw6;
import java.io.FileDescriptor;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.WeakHashMap;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReentrantLock;
import javax.annotation.concurrent.GuardedBy;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_08_10593cls.dex */
@Deprecated
public abstract class GoogleApiClient {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final int f31215a = 1;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    @KeepForSdk
    public static final String f5467a = "<<default account>>";

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @GuardedBy("sAllClients")
    public static final Set f5468a = Collections.newSetFromMap(new WeakHashMap());
    public static final int b = 2;

    @Deprecated
    public interface ConnectionCallbacks extends com.google.android.gms.common.api.internal.ConnectionCallbacks {
        public static final int X2 = 1;
        public static final int Y2 = 2;
    }

    @Deprecated
    public interface OnConnectionFailedListener extends com.google.android.gms.common.api.internal.OnConnectionFailedListener {
    }

    public static void k(@NonNull String str, @NonNull FileDescriptor fileDescriptor, @NonNull PrintWriter printWriter, @NonNull String[] strArr) {
        Set<GoogleApiClient> set = f5468a;
        synchronized (set) {
            String str2 = str + q.a.i;
            int i = 0;
            for (GoogleApiClient googleApiClient : set) {
                printWriter.append((CharSequence) str).append("GoogleApiClient#").println(i);
                googleApiClient.j(str2, fileDescriptor, printWriter, strArr);
                i++;
            }
        }
    }

    @NonNull
    @KeepForSdk
    public static Set<GoogleApiClient> n() {
        Set<GoogleApiClient> set = f5468a;
        synchronized (set) {
        }
        return set;
    }

    public abstract void A(@NonNull ConnectionCallbacks connectionCallbacks);

    @NonNull
    @KeepForSdk
    public <L> ListenerHolder<L> B(@NonNull L l) {
        throw new UnsupportedOperationException();
    }

    public abstract void C(@NonNull FragmentActivity fragmentActivity);

    public abstract void D(@NonNull ConnectionCallbacks connectionCallbacks);

    public void E(i3c i3cVar) {
        throw new UnsupportedOperationException();
    }

    public void F(i3c i3cVar) {
        throw new UnsupportedOperationException();
    }

    @NonNull
    public abstract ConnectionResult d();

    @NonNull
    public abstract ConnectionResult e(long j, @NonNull TimeUnit timeUnit);

    @NonNull
    public abstract PendingResult<Status> f();

    public abstract void g();

    @NonNull
    @KeepForSdk
    public Context getContext() {
        throw new UnsupportedOperationException();
    }

    public void h(int i) {
        throw new UnsupportedOperationException();
    }

    public abstract void i();

    public abstract void j(@NonNull String str, @NonNull FileDescriptor fileDescriptor, @NonNull PrintWriter printWriter, @NonNull String[] strArr);

    @NonNull
    @KeepForSdk
    public <A extends Api.AnyClient, R extends Result, T extends BaseImplementation.ApiMethodImpl<R, A>> T l(@NonNull T t) {
        throw new UnsupportedOperationException();
    }

    @NonNull
    @KeepForSdk
    public <A extends Api.AnyClient, T extends BaseImplementation.ApiMethodImpl<? extends Result, A>> T m(@NonNull T t) {
        throw new UnsupportedOperationException();
    }

    @NonNull
    @KeepForSdk
    public <C extends Api.Client> C o(@NonNull Api.a<C> aVar) {
        throw new UnsupportedOperationException();
    }

    @NonNull
    public abstract ConnectionResult p(@NonNull Api<?> api);

    @NonNull
    @KeepForSdk
    public Looper q() {
        throw new UnsupportedOperationException();
    }

    @KeepForSdk
    public boolean r(@NonNull Api<?> api) {
        throw new UnsupportedOperationException();
    }

    public abstract void registerConnectionFailedListener(@NonNull OnConnectionFailedListener onConnectionFailedListener);

    public abstract boolean s(@NonNull Api<?> api);

    public abstract boolean t();

    public abstract boolean u();

    public abstract void unregisterConnectionFailedListener(@NonNull OnConnectionFailedListener onConnectionFailedListener);

    public abstract boolean v(@NonNull ConnectionCallbacks connectionCallbacks);

    public abstract boolean w(@NonNull OnConnectionFailedListener onConnectionFailedListener);

    @KeepForSdk
    public boolean x(@NonNull SignInConnectionListener signInConnectionListener) {
        throw new UnsupportedOperationException();
    }

    @KeepForSdk
    public void y() {
        throw new UnsupportedOperationException();
    }

    public abstract void z();

    @Deprecated
    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public int f31216a;

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        @Nullable
        public Account f5469a;

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        public final Context f5470a;

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        public Looper f5471a;

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        public View f5472a;

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        public Api.AbstractClientBuilder f5473a;

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        @Nullable
        public OnConnectionFailedListener f5474a;

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        public ex4 f5475a;

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        public pv3 f5476a;

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        public String f5477a;

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        public final ArrayList f5478a;

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        public final Map f5479a;

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        public final Set f5480a;
        public int b;

        /* JADX INFO: renamed from: b, reason: collision with other field name */
        public String f5481b;

        /* JADX INFO: renamed from: b, reason: collision with other field name */
        public final ArrayList f5482b;

        /* JADX INFO: renamed from: b, reason: collision with other field name */
        public final Map f5483b;

        /* JADX INFO: renamed from: b, reason: collision with other field name */
        public final Set f5484b;

        public a(@NonNull Context context) {
            this.f5480a = new HashSet();
            this.f5484b = new HashSet();
            this.f5479a = new ArrayMap();
            this.f5483b = new ArrayMap();
            this.b = -1;
            this.f5476a = pv3.x();
            this.f5473a = g3c.f41814a;
            this.f5478a = new ArrayList();
            this.f5482b = new ArrayList();
            this.f5470a = context;
            this.f5471a = context.getMainLooper();
            this.f5477a = context.getPackageName();
            this.f5481b = context.getClass().getName();
        }

        @NonNull
        @CanIgnoreReturnValue
        public a a(@NonNull Api<? extends Api.ApiOptions.NotRequiredOptions> api) {
            yw6.m(api, "Api must not be null");
            this.f5483b.put(api, null);
            List<Scope> listA = ((Api.BaseClientBuilder) yw6.m(api.c(), "Base client builder must not be null")).a(null);
            this.f5484b.addAll(listA);
            this.f5480a.addAll(listA);
            return this;
        }

        @NonNull
        @CanIgnoreReturnValue
        public <O extends Api.ApiOptions.HasOptions> a b(@NonNull Api<O> api, @NonNull O o) {
            yw6.m(api, "Api must not be null");
            yw6.m(o, "Null options are not permitted for this Api");
            this.f5483b.put(api, o);
            List<Scope> listA = ((Api.BaseClientBuilder) yw6.m(api.c(), "Base client builder must not be null")).a(o);
            this.f5484b.addAll(listA);
            this.f5480a.addAll(listA);
            return this;
        }

        @NonNull
        @CanIgnoreReturnValue
        public <O extends Api.ApiOptions.HasOptions> a c(@NonNull Api<O> api, @NonNull O o, @NonNull Scope... scopeArr) {
            yw6.m(api, "Api must not be null");
            yw6.m(o, "Null options are not permitted for this Api");
            this.f5483b.put(api, o);
            q(api, o, scopeArr);
            return this;
        }

        @NonNull
        @CanIgnoreReturnValue
        public <T extends Api.ApiOptions.NotRequiredOptions> a d(@NonNull Api<? extends Api.ApiOptions.NotRequiredOptions> api, @NonNull Scope... scopeArr) {
            yw6.m(api, "Api must not be null");
            this.f5483b.put(api, null);
            q(api, null, scopeArr);
            return this;
        }

        @NonNull
        @CanIgnoreReturnValue
        public a e(@NonNull ConnectionCallbacks connectionCallbacks) {
            yw6.m(connectionCallbacks, "Listener must not be null");
            this.f5478a.add(connectionCallbacks);
            return this;
        }

        @NonNull
        @CanIgnoreReturnValue
        public a f(@NonNull OnConnectionFailedListener onConnectionFailedListener) {
            yw6.m(onConnectionFailedListener, "Listener must not be null");
            this.f5482b.add(onConnectionFailedListener);
            return this;
        }

        @NonNull
        @CanIgnoreReturnValue
        public a g(@NonNull Scope scope) {
            yw6.m(scope, "Scope must not be null");
            this.f5480a.add(scope);
            return this;
        }

        @NonNull
        public GoogleApiClient h() {
            yw6.b(!this.f5483b.isEmpty(), "must call addApi() to add at least one API");
            fm1 fm1VarP = p();
            Map mapN = fm1VarP.n();
            ArrayMap arrayMap = new ArrayMap();
            ArrayMap arrayMap2 = new ArrayMap();
            ArrayList arrayList = new ArrayList();
            Api api = null;
            boolean z = false;
            for (Api api2 : this.f5483b.keySet()) {
                Object obj = this.f5483b.get(api2);
                boolean z2 = mapN.get(api2) != null;
                arrayMap.put(api2, Boolean.valueOf(z2));
                n5c n5cVar = new n5c(api2, z2);
                arrayList.add(n5cVar);
                Api.AbstractClientBuilder abstractClientBuilder = (Api.AbstractClientBuilder) yw6.l(api2.a());
                Api.Client clientC = abstractClientBuilder.c(this.f5470a, this.f5471a, fm1VarP, obj, n5cVar, n5cVar);
                arrayMap2.put(api2.b(), clientC);
                if (abstractClientBuilder.b() == 1) {
                    z = obj != null;
                }
                if (clientC.k()) {
                    if (api != null) {
                        throw new IllegalStateException(api2.d() + " cannot be used with " + api.d());
                    }
                    api = api2;
                }
            }
            if (api != null) {
                if (z) {
                    throw new IllegalStateException("With using " + api.d() + ", GamesOptions can only be specified within GoogleSignInOptions.Builder");
                }
                yw6.t(this.f5469a == null, "Must not set an account in GoogleApiClient.Builder when using %s. Set account in GoogleSignInOptions.Builder instead", api.d());
                yw6.t(this.f5480a.equals(this.f5484b), "Must not set scopes in GoogleApiClient.Builder when using %s. Set account in GoogleSignInOptions.Builder instead.", api.d());
            }
            p pVar = new p(this.f5470a, new ReentrantLock(), this.f5471a, fm1VarP, this.f5476a, this.f5473a, arrayMap, this.f5478a, this.f5482b, arrayMap2, this.b, p.H(arrayMap2.values(), true), arrayList);
            synchronized (GoogleApiClient.f5468a) {
                GoogleApiClient.f5468a.add(pVar);
            }
            if (this.b >= 0) {
                o4c.q(this.f5475a).r(this.b, pVar, this.f5474a);
            }
            return pVar;
        }

        @NonNull
        public a i(@NonNull FragmentActivity fragmentActivity, int i, @Nullable OnConnectionFailedListener onConnectionFailedListener) {
            ex4 ex4Var = new ex4((Activity) fragmentActivity);
            yw6.b(i >= 0, "clientId must be non-negative");
            this.b = i;
            this.f5474a = onConnectionFailedListener;
            this.f5475a = ex4Var;
            return this;
        }

        @NonNull
        public a j(@NonNull FragmentActivity fragmentActivity, @Nullable OnConnectionFailedListener onConnectionFailedListener) {
            i(fragmentActivity, 0, onConnectionFailedListener);
            return this;
        }

        @NonNull
        @CanIgnoreReturnValue
        public a k(@NonNull String str) {
            this.f5469a = str == null ? null : new Account(str, ys.f46104a);
            return this;
        }

        @NonNull
        @CanIgnoreReturnValue
        public a l(int i) {
            this.f31216a = i;
            return this;
        }

        @NonNull
        @CanIgnoreReturnValue
        public a m(@NonNull Handler handler) {
            yw6.m(handler, "Handler must not be null");
            this.f5471a = handler.getLooper();
            return this;
        }

        @NonNull
        @CanIgnoreReturnValue
        public a n(@NonNull View view) {
            yw6.m(view, "View must not be null");
            this.f5472a = view;
            return this;
        }

        @NonNull
        public a o() {
            k("<<default account>>");
            return this;
        }

        @NonNull
        @VisibleForTesting
        public final fm1 p() {
            yb8 yb8Var = yb8.f45991a;
            Map map = this.f5483b;
            Api api = g3c.f16695a;
            if (map.containsKey(api)) {
                yb8Var = (yb8) this.f5483b.get(api);
            }
            return new fm1(this.f5469a, this.f5480a, this.f5479a, this.f31216a, this.f5472a, this.f5477a, this.f5481b, yb8Var, false);
        }

        public final void q(Api api, @Nullable Api.ApiOptions apiOptions, Scope... scopeArr) {
            HashSet hashSet = new HashSet(((Api.BaseClientBuilder) yw6.m(api.c(), "Base client builder must not be null")).a(apiOptions));
            for (Scope scope : scopeArr) {
                hashSet.add(scope);
            }
            this.f5479a.put(api, new c1c(hashSet));
        }

        public a(@NonNull Context context, @NonNull ConnectionCallbacks connectionCallbacks, @NonNull OnConnectionFailedListener onConnectionFailedListener) {
            this(context);
            yw6.m(connectionCallbacks, "Must provide a connected listener");
            this.f5478a.add(connectionCallbacks);
            yw6.m(onConnectionFailedListener, "Must provide a connection failed listener");
            this.f5482b.add(onConnectionFailedListener);
        }
    }
}

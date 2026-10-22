package com.google.android.gms.common.internal;

import android.accounts.Account;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.DeadObjectException;
import android.os.Handler;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Looper;
import android.os.RemoteException;
import android.text.TextUtils;
import android.util.Log;
import androidx.annotation.CallSuper;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.WorkerThread;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.Feature;
import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.android.gms.common.api.Scope;
import com.google.android.gms.common.util.VisibleForTesting;
import com.zj.adlib.c25;
import com.zj.adlib.chd;
import com.zj.adlib.hj7;
import com.zj.adlib.lq1;
import com.zj.adlib.osd;
import com.zj.adlib.qv3;
import com.zj.adlib.ys;
import com.zj.adlib.yw6;
import java.io.FileDescriptor;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.Locale;
import java.util.Set;
import java.util.concurrent.Executor;
import java.util.concurrent.atomic.AtomicInteger;
import javax.annotation.concurrent.GuardedBy;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_08_10593cls.dex */
@KeepForSdk
public abstract class BaseGmsClient<T extends IInterface> {

    @KeepForSdk
    public static final int O = 1;

    @KeepForSdk
    public static final int P = 4;

    @KeepForSdk
    public static final int Q = 5;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Feature[] f31285a = new Feature[0];

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    @KeepForSdk
    public static final String[] f5652a = {"service_esmobile", "service_googleme"};

    @NonNull
    @KeepForSdk
    public static final String i = "pendingIntent";

    @NonNull
    @KeepForSdk
    public static final String j = "<<default account>>";
    public int K;
    public int L;

    @GuardedBy("mLock")
    public int M;
    public final int N;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public long f5653a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final Context f5654a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final Handler f5655a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @Nullable
    @GuardedBy("mLock")
    public IInterface f5656a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final Looper f5657a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @Nullable
    public ConnectionResult f5658a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @Nullable
    public final BaseConnectionCallbacks f5659a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @Nullable
    public final BaseOnConnectionFailedListener f5660a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    @VisibleForTesting
    public ConnectionProgressReportCallbacks f5661a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final GmsClientSupervisor f5662a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @Nullable
    @GuardedBy("mServiceBrokerLock")
    public IGmsServiceBroker f5663a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @Nullable
    @GuardedBy("mLock")
    public g f5664a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @Nullable
    public volatile zzj f5665a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @VisibleForTesting
    public osd f5666a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final qv3 f5667a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final Object f5668a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final ArrayList f5669a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    @VisibleForTesting
    public AtomicInteger f5670a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public boolean f5671a;
    public long b;

    /* JADX INFO: renamed from: b, reason: collision with other field name */
    public final Object f5672b;
    public long c;

    @Nullable
    public volatile String f;

    @Nullable
    public final String g;

    @Nullable
    public volatile String h;

    @KeepForSdk
    public interface BaseConnectionCallbacks {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        @KeepForSdk
        public static final int f31286a = 1;

        @KeepForSdk
        public static final int b = 3;

        @KeepForSdk
        void onConnected(@Nullable Bundle bundle);

        @KeepForSdk
        void onConnectionSuspended(int i);
    }

    @KeepForSdk
    public interface BaseOnConnectionFailedListener {
        @KeepForSdk
        void onConnectionFailed(@NonNull ConnectionResult connectionResult);
    }

    @KeepForSdk
    public interface ConnectionProgressReportCallbacks {
        @KeepForSdk
        void b(@NonNull ConnectionResult connectionResult);
    }

    @KeepForSdk
    public interface SignOutCallbacks {
        @KeepForSdk
        void a();
    }

    public class a implements ConnectionProgressReportCallbacks {
        @KeepForSdk
        public a() {
        }

        @Override // com.google.android.gms.common.internal.BaseGmsClient.ConnectionProgressReportCallbacks
        public final void b(@NonNull ConnectionResult connectionResult) {
            if (connectionResult.isSuccess()) {
                BaseGmsClient baseGmsClient = BaseGmsClient.this;
                baseGmsClient.e(null, baseGmsClient.getScopes());
            } else if (BaseGmsClient.this.f5660a != null) {
                BaseGmsClient.this.f5660a.onConnectionFailed(connectionResult);
            }
        }
    }

    @VisibleForTesting
    @KeepForSdk
    public BaseGmsClient(@NonNull Context context, @NonNull Handler handler, @NonNull GmsClientSupervisor gmsClientSupervisor, @NonNull qv3 qv3Var, int i2, @Nullable BaseConnectionCallbacks baseConnectionCallbacks, @Nullable BaseOnConnectionFailedListener baseOnConnectionFailedListener) {
        this.f = null;
        this.f5668a = new Object();
        this.f5672b = new Object();
        this.f5669a = new ArrayList();
        this.M = 1;
        this.f5658a = null;
        this.f5671a = false;
        this.f5665a = null;
        this.f5670a = new AtomicInteger(0);
        yw6.m(context, "Context must not be null");
        this.f5654a = context;
        yw6.m(handler, "Handler must not be null");
        this.f5655a = handler;
        this.f5657a = handler.getLooper();
        yw6.m(gmsClientSupervisor, "Supervisor must not be null");
        this.f5662a = gmsClientSupervisor;
        yw6.m(qv3Var, "API availability must not be null");
        this.f5667a = qv3Var;
        this.N = i2;
        this.f5659a = baseConnectionCallbacks;
        this.f5660a = baseOnConnectionFailedListener;
        this.g = null;
    }

    public static /* bridge */ /* synthetic */ void O(BaseGmsClient baseGmsClient, zzj zzjVar) {
        baseGmsClient.f5665a = zzjVar;
        if (baseGmsClient.F()) {
            ConnectionTelemetryConfiguration connectionTelemetryConfiguration = zzjVar.zzd;
            hj7.b().c(connectionTelemetryConfiguration == null ? null : connectionTelemetryConfiguration.zza());
        }
    }

    public static /* bridge */ /* synthetic */ void P(BaseGmsClient baseGmsClient, int i2) {
        int i3;
        int i4;
        synchronized (baseGmsClient.f5668a) {
            i3 = baseGmsClient.M;
        }
        if (i3 == 3) {
            baseGmsClient.f5671a = true;
            i4 = 5;
        } else {
            i4 = 4;
        }
        Handler handler = baseGmsClient.f5655a;
        handler.sendMessage(handler.obtainMessage(i4, baseGmsClient.f5670a.get(), 16));
    }

    public static /* bridge */ /* synthetic */ boolean R(BaseGmsClient baseGmsClient, int i2, int i3, IInterface iInterface) {
        synchronized (baseGmsClient.f5668a) {
            if (baseGmsClient.M != i2) {
                return false;
            }
            baseGmsClient.T(i3, iInterface);
            return true;
        }
    }

    public static /* bridge */ /* synthetic */ boolean S(BaseGmsClient baseGmsClient) {
        if (baseGmsClient.f5671a || TextUtils.isEmpty(baseGmsClient.getServiceDescriptor()) || TextUtils.isEmpty(baseGmsClient.getLocalStartServiceAction())) {
            return false;
        }
        try {
            Class.forName(baseGmsClient.getServiceDescriptor());
            return true;
        } catch (ClassNotFoundException unused) {
            return false;
        }
    }

    @NonNull
    @KeepForSdk
    public final T A() throws DeadObjectException {
        T t;
        synchronized (this.f5668a) {
            if (this.M == 5) {
                throw new DeadObjectException();
            }
            checkConnected();
            t = (T) this.f5656a;
            yw6.m(t, "Client is connected but service is null");
        }
        return t;
    }

    @Nullable
    @KeepForSdk
    public ConnectionTelemetryConfiguration B() {
        zzj zzjVar = this.f5665a;
        if (zzjVar == null) {
            return null;
        }
        return zzjVar.zzd;
    }

    @KeepForSdk
    public boolean C() {
        return this.f5665a != null;
    }

    @KeepForSdk
    public void D(@NonNull String str) {
        this.h = str;
    }

    @KeepForSdk
    public void E(int i2) {
        Handler handler = this.f5655a;
        handler.sendMessage(handler.obtainMessage(6, this.f5670a.get(), i2));
    }

    @KeepForSdk
    public boolean F() {
        return false;
    }

    public final void T(int i2, @Nullable IInterface iInterface) {
        osd osdVar;
        yw6.a((i2 == 4) == (iInterface != null));
        synchronized (this.f5668a) {
            this.M = i2;
            this.f5656a = iInterface;
            if (i2 == 1) {
                g gVar = this.f5664a;
                if (gVar != null) {
                    GmsClientSupervisor gmsClientSupervisor = this.f5662a;
                    String strC = this.f5666a.c();
                    yw6.l(strC);
                    gmsClientSupervisor.e(strC, this.f5666a.b(), this.f5666a.a(), gVar, zze(), this.f5666a.d());
                    this.f5664a = null;
                }
            } else if (i2 == 2 || i2 == 3) {
                g gVar2 = this.f5664a;
                if (gVar2 != null && (osdVar = this.f5666a) != null) {
                    Log.e("GmsClient", "Calling connect() while still connected, missing disconnect() for " + osdVar.c() + " on " + osdVar.b());
                    GmsClientSupervisor gmsClientSupervisor2 = this.f5662a;
                    String strC2 = this.f5666a.c();
                    yw6.l(strC2);
                    gmsClientSupervisor2.e(strC2, this.f5666a.b(), this.f5666a.a(), gVar2, zze(), this.f5666a.d());
                    this.f5670a.incrementAndGet();
                }
                g gVar3 = new g(this, this.f5670a.get());
                this.f5664a = gVar3;
                osd osdVar2 = (this.M != 3 || getLocalStartServiceAction() == null) ? new osd(getStartServicePackage(), getStartServiceAction(), false, GmsClientSupervisor.a(), getUseDynamicLookup()) : new osd(getContext().getPackageName(), getLocalStartServiceAction(), true, GmsClientSupervisor.a(), false);
                this.f5666a = osdVar2;
                if (osdVar2.d() && l() < 17895000) {
                    throw new IllegalStateException("Internal Error, the minimum apk version of this BaseGmsClient is too low to support dynamic lookup. Start service action: ".concat(String.valueOf(this.f5666a.c())));
                }
                GmsClientSupervisor gmsClientSupervisor3 = this.f5662a;
                String strC3 = this.f5666a.c();
                yw6.l(strC3);
                if (!gmsClientSupervisor3.zzc(new chd(strC3, this.f5666a.b(), this.f5666a.a(), this.f5666a.d()), gVar3, zze(), getBindServiceExecutor())) {
                    Log.w("GmsClient", "unable to connect to service: " + this.f5666a.c() + " on " + this.f5666a.b());
                    zzl(16, null, this.f5670a.get());
                }
            } else if (i2 == 4) {
                yw6.l(iInterface);
                onConnectedLocked(iInterface);
            }
        }
    }

    @Nullable
    @KeepForSdk
    public IBinder a() {
        synchronized (this.f5672b) {
            IGmsServiceBroker iGmsServiceBroker = this.f5663a;
            if (iGmsServiceBroker == null) {
                return null;
            }
            return iGmsServiceBroker.asBinder();
        }
    }

    @KeepForSdk
    public boolean b() {
        return true;
    }

    @KeepForSdk
    public final void checkConnected() {
        if (!isConnected()) {
            throw new IllegalStateException("Not connected. Call connect() and wait for onConnected() to be called.");
        }
    }

    @Nullable
    @KeepForSdk
    public abstract T createServiceInterface(@NonNull IBinder iBinder);

    @KeepForSdk
    public void d(@NonNull String str) {
        this.f = str;
        disconnect();
    }

    @KeepForSdk
    public void disconnect() {
        this.f5670a.incrementAndGet();
        synchronized (this.f5669a) {
            int size = this.f5669a.size();
            for (int i2 = 0; i2 < size; i2++) {
                ((zzc) this.f5669a.get(i2)).b();
            }
            this.f5669a.clear();
        }
        synchronized (this.f5672b) {
            this.f5663a = null;
        }
        T(1, null);
    }

    @KeepForSdk
    public void dump(@NonNull String str, @NonNull FileDescriptor fileDescriptor, @NonNull PrintWriter printWriter, @NonNull String[] strArr) {
        int i2;
        IInterface iInterface;
        IGmsServiceBroker iGmsServiceBroker;
        synchronized (this.f5668a) {
            i2 = this.M;
            iInterface = this.f5656a;
        }
        synchronized (this.f5672b) {
            iGmsServiceBroker = this.f5663a;
        }
        printWriter.append((CharSequence) str).append("mConnectState=");
        if (i2 == 1) {
            printWriter.print("DISCONNECTED");
        } else if (i2 == 2) {
            printWriter.print("REMOTE_CONNECTING");
        } else if (i2 == 3) {
            printWriter.print("LOCAL_CONNECTING");
        } else if (i2 == 4) {
            printWriter.print("CONNECTED");
        } else if (i2 != 5) {
            printWriter.print("UNKNOWN");
        } else {
            printWriter.print("DISCONNECTING");
        }
        printWriter.append(" mService=");
        if (iInterface == null) {
            printWriter.append("null");
        } else {
            printWriter.append((CharSequence) getServiceDescriptor()).append("@").append((CharSequence) Integer.toHexString(System.identityHashCode(iInterface.asBinder())));
        }
        printWriter.append(" mServiceBroker=");
        if (iGmsServiceBroker == null) {
            printWriter.println("null");
        } else {
            printWriter.append("IGmsServiceBroker@").println(Integer.toHexString(System.identityHashCode(iGmsServiceBroker.asBinder())));
        }
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(c25.o, Locale.US);
        if (this.b > 0) {
            PrintWriter printWriterAppend = printWriter.append((CharSequence) str).append("lastConnectedTime=");
            long j2 = this.b;
            printWriterAppend.println(j2 + " " + simpleDateFormat.format(new Date(j2)));
        }
        if (this.f5653a > 0) {
            printWriter.append((CharSequence) str).append("lastSuspendedCause=");
            int i3 = this.K;
            if (i3 == 1) {
                printWriter.append("CAUSE_SERVICE_DISCONNECTED");
            } else if (i3 == 2) {
                printWriter.append("CAUSE_NETWORK_LOST");
            } else if (i3 != 3) {
                printWriter.append((CharSequence) String.valueOf(i3));
            } else {
                printWriter.append("CAUSE_DEAD_OBJECT_EXCEPTION");
            }
            PrintWriter printWriterAppend2 = printWriter.append(" lastSuspendedTime=");
            long j3 = this.f5653a;
            printWriterAppend2.println(j3 + " " + simpleDateFormat.format(new Date(j3)));
        }
        if (this.c > 0) {
            printWriter.append((CharSequence) str).append("lastFailedStatus=").append((CharSequence) lq1.a(this.L));
            PrintWriter printWriterAppend3 = printWriter.append(" lastFailedTime=");
            long j4 = this.c;
            printWriterAppend3.println(j4 + " " + simpleDateFormat.format(new Date(j4)));
        }
    }

    @KeepForSdk
    @WorkerThread
    public void e(@Nullable IAccountAccessor iAccountAccessor, @NonNull Set<Scope> set) {
        Bundle getServiceRequestExtraArgs = getGetServiceRequestExtraArgs();
        int i2 = this.N;
        String str = this.h;
        int i3 = qv3.f44306a;
        Scope[] scopeArr = GetServiceRequest.zza;
        Bundle bundle = new Bundle();
        Feature[] featureArr = GetServiceRequest.zzb;
        GetServiceRequest getServiceRequest = new GetServiceRequest(6, i2, i3, null, null, scopeArr, bundle, null, featureArr, featureArr, true, 0, false, str);
        getServiceRequest.zzf = this.f5654a.getPackageName();
        getServiceRequest.zzi = getServiceRequestExtraArgs;
        if (set != null) {
            getServiceRequest.zzh = (Scope[]) set.toArray(new Scope[0]);
        }
        if (q()) {
            Account accountV = v();
            if (accountV == null) {
                accountV = new Account("<<default account>>", ys.f46104a);
            }
            getServiceRequest.zzj = accountV;
            if (iAccountAccessor != null) {
                getServiceRequest.zzg = iAccountAccessor.asBinder();
            }
        } else if (i()) {
            getServiceRequest.zzj = v();
        }
        getServiceRequest.zzk = f31285a;
        getServiceRequest.zzl = w();
        if (F()) {
            getServiceRequest.zzo = true;
        }
        try {
            synchronized (this.f5672b) {
                IGmsServiceBroker iGmsServiceBroker = this.f5663a;
                if (iGmsServiceBroker != null) {
                    iGmsServiceBroker.getService(new zzd(this, this.f5670a.get()), getServiceRequest);
                } else {
                    Log.w("GmsClient", "mServiceBroker is null, client disconnected");
                }
            }
        } catch (DeadObjectException e) {
            Log.w("GmsClient", "IGmsServiceBroker.getService failed", e);
            E(3);
        } catch (RemoteException e2) {
            e = e2;
            Log.w("GmsClient", "IGmsServiceBroker.getService failed", e);
            onPostInitHandler(8, null, null, this.f5670a.get());
        } catch (SecurityException e3) {
            throw e3;
        } catch (RuntimeException e4) {
            e = e4;
            Log.w("GmsClient", "IGmsServiceBroker.getService failed", e);
            onPostInitHandler(8, null, null, this.f5670a.get());
        }
    }

    @KeepForSdk
    public boolean enableLocalFallback() {
        return false;
    }

    @KeepForSdk
    public void g(@NonNull SignOutCallbacks signOutCallbacks) {
        signOutCallbacks.a();
    }

    @Nullable
    @KeepForSdk
    public Executor getBindServiceExecutor() {
        return null;
    }

    @NonNull
    @KeepForSdk
    public final Context getContext() {
        return this.f5654a;
    }

    @NonNull
    @KeepForSdk
    public Bundle getGetServiceRequestExtraArgs() {
        return new Bundle();
    }

    @Nullable
    @KeepForSdk
    public String getLocalStartServiceAction() {
        return null;
    }

    @NonNull
    @KeepForSdk
    public Set<Scope> getScopes() {
        return Collections.emptySet();
    }

    @NonNull
    @KeepForSdk
    public abstract String getServiceDescriptor();

    @NonNull
    @KeepForSdk
    public abstract String getStartServiceAction();

    @NonNull
    @KeepForSdk
    public String getStartServicePackage() {
        return "com.google.android.gms";
    }

    @KeepForSdk
    public boolean getUseDynamicLookup() {
        return l() >= 211700000;
    }

    @KeepForSdk
    public boolean i() {
        return false;
    }

    @KeepForSdk
    public boolean isConnected() {
        boolean z;
        synchronized (this.f5668a) {
            z = this.M == 4;
        }
        return z;
    }

    @KeepForSdk
    public boolean isConnecting() {
        boolean z;
        synchronized (this.f5668a) {
            int i2 = this.M;
            z = true;
            if (i2 != 2 && i2 != 3) {
                z = false;
            }
        }
        return z;
    }

    @KeepForSdk
    public void j(@NonNull ConnectionProgressReportCallbacks connectionProgressReportCallbacks) {
        yw6.m(connectionProgressReportCallbacks, "Connection progress callbacks cannot be null.");
        this.f5661a = connectionProgressReportCallbacks;
        T(2, null);
    }

    @KeepForSdk
    public boolean k() {
        return false;
    }

    @KeepForSdk
    public int l() {
        return qv3.f44306a;
    }

    @Nullable
    @KeepForSdk
    public final Feature[] n() {
        zzj zzjVar = this.f5665a;
        if (zzjVar == null) {
            return null;
        }
        return zzjVar.zzb;
    }

    @KeepForSdk
    @CallSuper
    public void onConnectedLocked(@NonNull T t) {
        this.b = System.currentTimeMillis();
    }

    @KeepForSdk
    @CallSuper
    public void onConnectionFailed(@NonNull ConnectionResult connectionResult) {
        this.L = connectionResult.getErrorCode();
        this.c = System.currentTimeMillis();
    }

    @KeepForSdk
    @CallSuper
    public void onConnectionSuspended(int i2) {
        this.K = i2;
        this.f5653a = System.currentTimeMillis();
    }

    @KeepForSdk
    public void onPostInitHandler(int i2, @Nullable IBinder iBinder, @Nullable Bundle bundle, int i3) {
        Handler handler = this.f5655a;
        handler.sendMessage(handler.obtainMessage(1, i3, -1, new h(this, i2, iBinder, bundle)));
    }

    @NonNull
    @KeepForSdk
    public String p() {
        osd osdVar;
        if (!isConnected() || (osdVar = this.f5666a) == null) {
            throw new RuntimeException("Failed to connect when checking package");
        }
        return osdVar.b();
    }

    @KeepForSdk
    public boolean q() {
        return false;
    }

    @Nullable
    @KeepForSdk
    public String r() {
        return this.f;
    }

    @NonNull
    @KeepForSdk
    public Intent t() {
        throw new UnsupportedOperationException("Not a sign in API");
    }

    @VisibleForTesting
    @KeepForSdk
    public void triggerNotAvailable(@NonNull ConnectionProgressReportCallbacks connectionProgressReportCallbacks, int i2, @Nullable PendingIntent pendingIntent) {
        yw6.m(connectionProgressReportCallbacks, "Connection progress callbacks cannot be null.");
        this.f5661a = connectionProgressReportCallbacks;
        Handler handler = this.f5655a;
        handler.sendMessage(handler.obtainMessage(3, this.f5670a.get(), i2, pendingIntent));
    }

    @KeepForSdk
    public void u() {
        int iK = this.f5667a.k(this.f5654a, l());
        if (iK == 0) {
            j(new a());
        } else {
            T(1, null);
            triggerNotAvailable(new a(), iK, null);
        }
    }

    @Nullable
    @KeepForSdk
    public Account v() {
        return null;
    }

    @NonNull
    @KeepForSdk
    public Feature[] w() {
        return f31285a;
    }

    @Nullable
    @KeepForSdk
    public Bundle x() {
        return null;
    }

    @KeepForSdk
    public int y() {
        return this.N;
    }

    @NonNull
    @KeepForSdk
    public final Looper z() {
        return this.f5657a;
    }

    @NonNull
    public final String zze() {
        String str = this.g;
        return str == null ? this.f5654a.getClass().getName() : str;
    }

    public final void zzl(int i2, @Nullable Bundle bundle, int i3) {
        Handler handler = this.f5655a;
        handler.sendMessage(handler.obtainMessage(7, i3, -1, new i(this, i2, null)));
    }

    /* JADX WARN: Illegal instructions before constructor call */
    @KeepForSdk
    public BaseGmsClient(@NonNull Context context, @NonNull Looper looper, int i2, @Nullable BaseConnectionCallbacks baseConnectionCallbacks, @Nullable BaseOnConnectionFailedListener baseOnConnectionFailedListener, @Nullable String str) {
        GmsClientSupervisor gmsClientSupervisorB = GmsClientSupervisor.b(context);
        qv3 qv3VarI = qv3.i();
        yw6.l(baseConnectionCallbacks);
        yw6.l(baseOnConnectionFailedListener);
        this(context, looper, gmsClientSupervisorB, qv3VarI, i2, baseConnectionCallbacks, baseOnConnectionFailedListener, str);
    }

    @VisibleForTesting
    @KeepForSdk
    public BaseGmsClient(@NonNull Context context, @NonNull Looper looper, @NonNull GmsClientSupervisor gmsClientSupervisor, @NonNull qv3 qv3Var, int i2, @Nullable BaseConnectionCallbacks baseConnectionCallbacks, @Nullable BaseOnConnectionFailedListener baseOnConnectionFailedListener, @Nullable String str) {
        this.f = null;
        this.f5668a = new Object();
        this.f5672b = new Object();
        this.f5669a = new ArrayList();
        this.M = 1;
        this.f5658a = null;
        this.f5671a = false;
        this.f5665a = null;
        this.f5670a = new AtomicInteger(0);
        yw6.m(context, "Context must not be null");
        this.f5654a = context;
        yw6.m(looper, "Looper must not be null");
        this.f5657a = looper;
        yw6.m(gmsClientSupervisor, "Supervisor must not be null");
        this.f5662a = gmsClientSupervisor;
        yw6.m(qv3Var, "API availability must not be null");
        this.f5667a = qv3Var;
        this.f5655a = new f(this, looper);
        this.N = i2;
        this.f5659a = baseConnectionCallbacks;
        this.f5660a = baseOnConnectionFailedListener;
        this.g = str;
    }
}

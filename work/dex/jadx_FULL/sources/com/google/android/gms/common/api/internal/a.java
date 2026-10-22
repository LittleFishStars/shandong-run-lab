package com.google.android.gms.common.api.internal;

import android.app.Application;
import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.util.Log;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.WorkerThread;
import androidx.collection.ArraySet;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.android.gms.common.api.GoogleApi;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.internal.GmsClientSupervisor;
import com.google.android.gms.common.internal.MethodInvocation;
import com.google.android.gms.common.internal.RootTelemetryConfiguration;
import com.google.android.gms.common.internal.ShowFirstParty;
import com.google.android.gms.common.internal.TelemetryData;
import com.google.android.gms.common.internal.TelemetryLoggingClient;
import com.google.android.gms.tasks.Task;
import com.zj.adlib.c90;
import com.zj.adlib.cm2;
import com.zj.adlib.hj7;
import com.zj.adlib.j2c;
import com.zj.adlib.k2c;
import com.zj.adlib.n2c;
import com.zj.adlib.o2c;
import com.zj.adlib.o5c;
import com.zj.adlib.p29;
import com.zj.adlib.p4c;
import com.zj.adlib.pv3;
import com.zj.adlib.r0c;
import com.zj.adlib.r4c;
import com.zj.adlib.s0c;
import com.zj.adlib.v1c;
import com.zj.adlib.yw6;
import com.zj.adlib.z09;
import com.zj.adlib.z3c;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.Executor;
import java.util.concurrent.atomic.AtomicInteger;
import javax.annotation.concurrent.GuardedBy;
import org.checkerframework.checker.initialization.qual.NotOnlyInitialized;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_08_10593cls.dex */
@ShowFirstParty
@KeepForSdk
public class a implements Handler.Callback {

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @Nullable
    @GuardedBy("lock")
    public static a f5517a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final Context f5520a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NotOnlyInitialized
    public final Handler f5521a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @Nullable
    public TelemetryData f5522a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @Nullable
    public TelemetryLoggingClient f5523a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final p4c f5524a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final pv3 f5525a;

    /* JADX INFO: renamed from: b, reason: collision with other field name */
    public volatile boolean f5534b;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @NonNull
    public static final Status f31233a = new Status(4, "Sign-out occurred while this API call was in progress.");
    public static final Status b = new Status(4, "The user must be signed in to make this API call.");

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public static final Object f5518a = new Object();

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public long f5519a = 5000;

    /* JADX INFO: renamed from: b, reason: collision with other field name */
    public long f5531b = com.igexin.push.config.c.l;
    public long c = 10000;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public boolean f5530a = false;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final AtomicInteger f5529a = new AtomicInteger(1);

    /* JADX INFO: renamed from: b, reason: collision with other field name */
    public final AtomicInteger f5533b = new AtomicInteger(0);

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final Map f5527a = new ConcurrentHashMap(5, 0.75f, 1);

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @Nullable
    @GuardedBy("lock")
    public r0c f5526a = null;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @GuardedBy("lock")
    public final Set f5528a = new ArraySet();

    /* JADX INFO: renamed from: b, reason: collision with other field name */
    public final Set f5532b = new ArraySet();

    @KeepForSdk
    public a(Context context, Looper looper, pv3 pv3Var) {
        this.f5534b = true;
        this.f5520a = context;
        o5c o5cVar = new o5c(looper, this);
        this.f5521a = o5cVar;
        this.f5525a = pv3Var;
        this.f5524a = new p4c(pv3Var);
        if (cm2.a(context)) {
            this.f5534b = false;
        }
        o5cVar.sendMessage(o5cVar.obtainMessage(6));
    }

    @KeepForSdk
    public static void a() {
        synchronized (f5518a) {
            a aVar = f5517a;
            if (aVar != null) {
                aVar.f5533b.incrementAndGet();
                Handler handler = aVar.f5521a;
                handler.sendMessageAtFrontOfQueue(handler.obtainMessage(10));
            }
        }
    }

    public static Status i(c90 c90Var, ConnectionResult connectionResult) {
        return new Status(connectionResult, "API: " + c90Var.b() + " is not available on this device. Connection failed with: " + String.valueOf(connectionResult));
    }

    @NonNull
    public static a y() {
        a aVar;
        synchronized (f5518a) {
            yw6.m(f5517a, "Must guarantee manager is non-null before using getInstance");
            aVar = f5517a;
        }
        return aVar;
    }

    @NonNull
    public static a z(@NonNull Context context) {
        a aVar;
        synchronized (f5518a) {
            if (f5517a == null) {
                f5517a = new a(context.getApplicationContext(), GmsClientSupervisor.c().getLooper(), pv3.x());
            }
            aVar = f5517a;
        }
        return aVar;
    }

    @NonNull
    public final Task B(@NonNull Iterable iterable) {
        r4c r4cVar = new r4c(iterable);
        Handler handler = this.f5521a;
        handler.sendMessage(handler.obtainMessage(2, r4cVar));
        return r4cVar.a();
    }

    @NonNull
    public final Task C(@NonNull GoogleApi googleApi) {
        s0c s0cVar = new s0c(googleApi.d());
        Handler handler = this.f5521a;
        handler.sendMessage(handler.obtainMessage(14, s0cVar));
        return s0cVar.b().a();
    }

    @NonNull
    public final Task D(@NonNull GoogleApi googleApi, @NonNull RegisterListenerMethod registerListenerMethod, @NonNull UnregisterListenerMethod unregisterListenerMethod, @NonNull Runnable runnable) {
        z09 z09Var = new z09();
        m(z09Var, registerListenerMethod.d(), googleApi);
        z zVar = new z(new o2c(registerListenerMethod, unregisterListenerMethod, runnable), z09Var);
        Handler handler = this.f5521a;
        handler.sendMessage(handler.obtainMessage(8, new n2c(zVar, this.f5533b.get(), googleApi)));
        return z09Var.a();
    }

    @NonNull
    public final Task E(@NonNull GoogleApi googleApi, @NonNull ListenerHolder.a aVar, int i) {
        z09 z09Var = new z09();
        m(z09Var, i, googleApi);
        a0 a0Var = new a0(aVar, z09Var);
        Handler handler = this.f5521a;
        handler.sendMessage(handler.obtainMessage(13, new n2c(a0Var, this.f5533b.get(), googleApi)));
        return z09Var.a();
    }

    public final void J(@NonNull GoogleApi googleApi, int i, @NonNull BaseImplementation.ApiMethodImpl apiMethodImpl) {
        y yVar = new y(i, apiMethodImpl);
        Handler handler = this.f5521a;
        handler.sendMessage(handler.obtainMessage(4, new n2c(yVar, this.f5533b.get(), googleApi)));
    }

    public final void K(@NonNull GoogleApi googleApi, int i, @NonNull TaskApiCall taskApiCall, @NonNull z09 z09Var, @NonNull StatusExceptionMapper statusExceptionMapper) {
        m(z09Var, taskApiCall.c(), googleApi);
        z3c z3cVar = new z3c(i, taskApiCall, z09Var, statusExceptionMapper);
        Handler handler = this.f5521a;
        handler.sendMessage(handler.obtainMessage(4, new n2c(z3cVar, this.f5533b.get(), googleApi)));
    }

    public final void L(MethodInvocation methodInvocation, int i, long j, int i2) {
        Handler handler = this.f5521a;
        handler.sendMessage(handler.obtainMessage(18, new k2c(methodInvocation, i, j, i2)));
    }

    public final void M(@NonNull ConnectionResult connectionResult, int i) {
        if (h(connectionResult, i)) {
            return;
        }
        Handler handler = this.f5521a;
        handler.sendMessage(handler.obtainMessage(5, i, 0, connectionResult));
    }

    public final void b() {
        Handler handler = this.f5521a;
        handler.sendMessage(handler.obtainMessage(3));
    }

    public final void c(@NonNull GoogleApi googleApi) {
        Handler handler = this.f5521a;
        handler.sendMessage(handler.obtainMessage(7, googleApi));
    }

    public final void d(@NonNull r0c r0cVar) {
        synchronized (f5518a) {
            if (this.f5526a != r0cVar) {
                this.f5526a = r0cVar;
                this.f5528a.clear();
            }
            this.f5528a.addAll(r0cVar.q());
        }
    }

    public final void e(@NonNull r0c r0cVar) {
        synchronized (f5518a) {
            if (this.f5526a == r0cVar) {
                this.f5526a = null;
                this.f5528a.clear();
            }
        }
    }

    @WorkerThread
    public final boolean g() {
        if (this.f5530a) {
            return false;
        }
        RootTelemetryConfiguration rootTelemetryConfigurationA = hj7.b().a();
        if (rootTelemetryConfigurationA != null && !rootTelemetryConfigurationA.getMethodInvocationTelemetryEnabled()) {
            return false;
        }
        int iA = this.f5524a.a(this.f5520a, 203400000);
        return iA == -1 || iA == 0;
    }

    public final boolean h(ConnectionResult connectionResult, int i) {
        return this.f5525a.L(this.f5520a, connectionResult, i);
    }

    /* JADX WARN: Code duplicated, block: B:63:0x01e9  */
    /* JADX WARN: Code duplicated, block: B:65:0x01ef  */
    /* JADX WARN: Code duplicated, block: B:66:0x0220  */
    /* JADX WARN: Code duplicated, block: B:67:0x022d  */
    /* JADX WARN: Instruction removed from duplicated block: B:65:0x01ef, please report this as an issue */
    /* JADX WARN: Instruction removed from duplicated block: B:67:0x022d, please report this as an issue */
    @Override // android.os.Handler.Callback
    @WorkerThread
    public final boolean handleMessage(@NonNull Message message) {
        int i = message.what;
        t tVar = null;
        switch (i) {
            case 1:
                this.c = true == ((Boolean) message.obj).booleanValue() ? 10000L : 300000L;
                this.f5521a.removeMessages(12);
                for (c90 c90Var : this.f5527a.keySet()) {
                    Handler handler = this.f5521a;
                    handler.sendMessageDelayed(handler.obtainMessage(12, c90Var), this.c);
                }
                return true;
            case 2:
                r4c r4cVar = (r4c) message.obj;
                for (c90 c90Var2 : r4cVar.b()) {
                    t tVar2 = (t) this.f5527a.get(c90Var2);
                    if (tVar2 == null) {
                        r4cVar.c(c90Var2, new ConnectionResult(13), null);
                        return true;
                    }
                    if (tVar2.M()) {
                        r4cVar.c(c90Var2, ConnectionResult.RESULT_SUCCESS, tVar2.t().p());
                    } else {
                        ConnectionResult connectionResultR = tVar2.r();
                        if (connectionResultR != null) {
                            r4cVar.c(c90Var2, connectionResultR, null);
                        } else {
                            tVar2.H(r4cVar);
                            tVar2.C();
                        }
                    }
                }
                return true;
            case 3:
                for (t tVar3 : this.f5527a.values()) {
                    tVar3.B();
                    tVar3.C();
                }
                return true;
            case 4:
            case 8:
            case 13:
                n2c n2cVar = (n2c) message.obj;
                t tVarJ = (t) this.f5527a.get(n2cVar.f18338a.d());
                if (tVarJ == null) {
                    tVarJ = j(n2cVar.f18338a);
                }
                if (!tVarJ.N() || this.f5533b.get() == n2cVar.f43432a) {
                    tVarJ.D(n2cVar.f18339a);
                } else {
                    n2cVar.f18339a.a(f31233a);
                    tVarJ.J();
                }
                return true;
            case 5:
                int i2 = message.arg1;
                ConnectionResult connectionResult = (ConnectionResult) message.obj;
                for (t tVar4 : this.f5527a.values()) {
                    if (tVar4.p() == i2) {
                        tVar = tVar4;
                        if (tVar != null) {
                            Log.wtf("GoogleApiManager", "Could not find API instance " + i2 + " while trying to fail enqueued calls.", new Exception());
                        } else if (connectionResult.getErrorCode() == 13) {
                            tVar.d(new Status(17, "Error resolution was canceled by the user, original error message: " + this.f5525a.h(connectionResult.getErrorCode()) + ": " + connectionResult.getErrorMessage()));
                        } else {
                            tVar.d(i(tVar.f5607a, connectionResult));
                        }
                        return true;
                    }
                }
                if (tVar != null) {
                    Log.wtf("GoogleApiManager", "Could not find API instance " + i2 + " while trying to fail enqueued calls.", new Exception());
                } else if (connectionResult.getErrorCode() == 13) {
                    tVar.d(new Status(17, "Error resolution was canceled by the user, original error message: " + this.f5525a.h(connectionResult.getErrorCode()) + ": " + connectionResult.getErrorMessage()));
                } else {
                    tVar.d(i(tVar.f5607a, connectionResult));
                }
                return true;
            case 6:
                if (this.f5520a.getApplicationContext() instanceof Application) {
                    BackgroundDetector.c((Application) this.f5520a.getApplicationContext());
                    BackgroundDetector.b().a(new s(this));
                    if (!BackgroundDetector.b().e(true)) {
                        this.c = 300000L;
                    }
                }
                return true;
            case 7:
                j((GoogleApi) message.obj);
                return true;
            case 9:
                if (this.f5527a.containsKey(message.obj)) {
                    ((t) this.f5527a.get(message.obj)).I();
                }
                return true;
            case 10:
                Iterator it = this.f5532b.iterator();
                while (it.hasNext()) {
                    t tVar5 = (t) this.f5527a.remove((c90) it.next());
                    if (tVar5 != null) {
                        tVar5.J();
                    }
                }
                this.f5532b.clear();
                return true;
            case 11:
                if (this.f5527a.containsKey(message.obj)) {
                    ((t) this.f5527a.get(message.obj)).K();
                }
                return true;
            case 12:
                if (this.f5527a.containsKey(message.obj)) {
                    ((t) this.f5527a.get(message.obj)).a();
                }
                return true;
            case 14:
                s0c s0cVar = (s0c) message.obj;
                c90 c90VarA = s0cVar.a();
                if (this.f5527a.containsKey(c90VarA)) {
                    s0cVar.b().setResult(Boolean.valueOf(((t) this.f5527a.get(c90VarA)).o(false)));
                } else {
                    s0cVar.b().setResult(Boolean.FALSE);
                }
                return true;
            case 15:
                v1c v1cVar = (v1c) message.obj;
                if (this.f5527a.containsKey(v1cVar.f20162a)) {
                    t.z((t) this.f5527a.get(v1cVar.f20162a), v1cVar);
                }
                return true;
            case 16:
                v1c v1cVar2 = (v1c) message.obj;
                if (this.f5527a.containsKey(v1cVar2.f20162a)) {
                    t.A((t) this.f5527a.get(v1cVar2.f20162a), v1cVar2);
                }
                return true;
            case 17:
                l();
                return true;
            case 18:
                k2c k2cVar = (k2c) message.obj;
                if (k2cVar.f17559a == 0) {
                    k().g(new TelemetryData(k2cVar.f42730a, Arrays.asList(k2cVar.f17560a)));
                } else {
                    TelemetryData telemetryData = this.f5522a;
                    if (telemetryData != null) {
                        List listZab = telemetryData.zab();
                        if (telemetryData.zaa() != k2cVar.f42730a || (listZab != null && listZab.size() >= k2cVar.b)) {
                            this.f5521a.removeMessages(17);
                            l();
                        } else {
                            this.f5522a.zac(k2cVar.f17560a);
                        }
                    }
                    if (this.f5522a == null) {
                        ArrayList arrayList = new ArrayList();
                        arrayList.add(k2cVar.f17560a);
                        this.f5522a = new TelemetryData(k2cVar.f42730a, arrayList);
                        Handler handler2 = this.f5521a;
                        handler2.sendMessageDelayed(handler2.obtainMessage(17), k2cVar.f17559a);
                    }
                }
                return true;
            case 19:
                this.f5530a = false;
                return true;
            default:
                Log.w("GoogleApiManager", "Unknown message id: " + i);
                return false;
        }
    }

    @WorkerThread
    public final t j(GoogleApi googleApi) {
        c90 c90VarD = googleApi.d();
        t tVar = (t) this.f5527a.get(c90VarD);
        if (tVar == null) {
            tVar = new t(this, googleApi);
            this.f5527a.put(c90VarD, tVar);
        }
        if (tVar.N()) {
            this.f5532b.add(c90VarD);
        }
        tVar.C();
        return tVar;
    }

    @WorkerThread
    public final TelemetryLoggingClient k() {
        if (this.f5523a == null) {
            this.f5523a = p29.a(this.f5520a);
        }
        return this.f5523a;
    }

    @WorkerThread
    public final void l() {
        TelemetryData telemetryData = this.f5522a;
        if (telemetryData != null) {
            if (telemetryData.zaa() > 0 || g()) {
                k().g(telemetryData);
            }
            this.f5522a = null;
        }
    }

    public final void m(z09 z09Var, int i, GoogleApi googleApi) {
        j2c j2cVarA;
        if (i == 0 || (j2cVarA = j2c.a(this, i, googleApi.d())) == null) {
            return;
        }
        Task taskA = z09Var.a();
        final Handler handler = this.f5521a;
        handler.getClass();
        taskA.f(new Executor() { // from class: com.zj.adlib.p1c
            @Override // java.util.concurrent.Executor
            public final void execute(Runnable runnable) {
                handler.post(runnable);
            }
        }, j2cVarA);
    }

    public final int n() {
        return this.f5529a.getAndIncrement();
    }

    @Nullable
    public final t x(c90 c90Var) {
        return (t) this.f5527a.get(c90Var);
    }
}

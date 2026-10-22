package com.zj.adlib;

import android.os.SystemClock;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.WorkerThread;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.ApiException;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.internal.a;
import com.google.android.gms.common.api.internal.t;
import com.google.android.gms.common.internal.BaseGmsClient;
import com.google.android.gms.common.internal.ConnectionTelemetryConfiguration;
import com.google.android.gms.common.internal.MethodInvocation;
import com.google.android.gms.common.internal.RootTelemetryConfiguration;
import com.google.android.gms.common.util.VisibleForTesting;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_08_10593cls.dex */
public final class j2c implements OnCompleteListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f42494a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final long f17317a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final a f17318a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final c90 f17319a;
    public final long b;

    @VisibleForTesting
    public j2c(a aVar, int i, c90 c90Var, long j, long j2, @Nullable String str, @Nullable String str2) {
        this.f17318a = aVar;
        this.f42494a = i;
        this.f17319a = c90Var;
        this.f17317a = j;
        this.b = j2;
    }

    @Nullable
    public static j2c a(a aVar, int i, c90 c90Var) {
        boolean methodTimingTelemetryEnabled;
        if (!aVar.g()) {
            return null;
        }
        RootTelemetryConfiguration rootTelemetryConfigurationA = hj7.b().a();
        if (rootTelemetryConfigurationA == null) {
            methodTimingTelemetryEnabled = true;
        } else {
            if (!rootTelemetryConfigurationA.getMethodInvocationTelemetryEnabled()) {
                return null;
            }
            methodTimingTelemetryEnabled = rootTelemetryConfigurationA.getMethodTimingTelemetryEnabled();
            t tVarX = aVar.x(c90Var);
            if (tVarX != null) {
                if (!(tVarX.t() instanceof BaseGmsClient)) {
                    return null;
                }
                BaseGmsClient baseGmsClient = (BaseGmsClient) tVarX.t();
                if (baseGmsClient.C() && !baseGmsClient.isConnecting()) {
                    ConnectionTelemetryConfiguration connectionTelemetryConfigurationB = b(tVarX, baseGmsClient, i);
                    if (connectionTelemetryConfigurationB == null) {
                        return null;
                    }
                    tVarX.E();
                    methodTimingTelemetryEnabled = connectionTelemetryConfigurationB.getMethodTimingTelemetryEnabled();
                }
            }
        }
        return new j2c(aVar, i, c90Var, methodTimingTelemetryEnabled ? System.currentTimeMillis() : 0L, methodTimingTelemetryEnabled ? SystemClock.elapsedRealtime() : 0L, null, null);
    }

    @Nullable
    public static ConnectionTelemetryConfiguration b(t tVar, BaseGmsClient baseGmsClient, int i) {
        int[] methodInvocationMethodKeyAllowlist;
        int[] methodInvocationMethodKeyDisallowlist;
        ConnectionTelemetryConfiguration connectionTelemetryConfigurationB = baseGmsClient.B();
        if (connectionTelemetryConfigurationB == null || !connectionTelemetryConfigurationB.getMethodInvocationTelemetryEnabled() || ((methodInvocationMethodKeyAllowlist = connectionTelemetryConfigurationB.getMethodInvocationMethodKeyAllowlist()) != null ? !gb0.c(methodInvocationMethodKeyAllowlist, i) : !((methodInvocationMethodKeyDisallowlist = connectionTelemetryConfigurationB.getMethodInvocationMethodKeyDisallowlist()) == null || !gb0.c(methodInvocationMethodKeyDisallowlist, i))) || tVar.q() >= connectionTelemetryConfigurationB.getMaxMethodInvocationsLogged()) {
            return null;
        }
        return connectionTelemetryConfigurationB;
    }

    @Override // com.google.android.gms.tasks.OnCompleteListener
    @WorkerThread
    public final void onComplete(@NonNull Task task) {
        t tVarX;
        int version;
        int i;
        int i2;
        int errorCode;
        long j;
        long j2;
        int iElapsedRealtime;
        if (this.f17318a.g()) {
            RootTelemetryConfiguration rootTelemetryConfigurationA = hj7.b().a();
            if ((rootTelemetryConfigurationA == null || rootTelemetryConfigurationA.getMethodInvocationTelemetryEnabled()) && (tVarX = this.f17318a.x(this.f17319a)) != null && (tVarX.t() instanceof BaseGmsClient)) {
                BaseGmsClient baseGmsClient = (BaseGmsClient) tVarX.t();
                int i3 = 0;
                boolean methodTimingTelemetryEnabled = this.f17317a > 0;
                int iY = baseGmsClient.y();
                if (rootTelemetryConfigurationA != null) {
                    methodTimingTelemetryEnabled &= rootTelemetryConfigurationA.getMethodTimingTelemetryEnabled();
                    int batchPeriodMillis = rootTelemetryConfigurationA.getBatchPeriodMillis();
                    int maxMethodInvocationsInBatch = rootTelemetryConfigurationA.getMaxMethodInvocationsInBatch();
                    version = rootTelemetryConfigurationA.getVersion();
                    if (baseGmsClient.C() && !baseGmsClient.isConnecting()) {
                        ConnectionTelemetryConfiguration connectionTelemetryConfigurationB = b(tVarX, baseGmsClient, this.f42494a);
                        if (connectionTelemetryConfigurationB == null) {
                            return;
                        }
                        boolean z = connectionTelemetryConfigurationB.getMethodTimingTelemetryEnabled() && this.f17317a > 0;
                        maxMethodInvocationsInBatch = connectionTelemetryConfigurationB.getMaxMethodInvocationsLogged();
                        methodTimingTelemetryEnabled = z;
                    }
                    i2 = batchPeriodMillis;
                    i = maxMethodInvocationsInBatch;
                } else {
                    version = 0;
                    i = 100;
                    i2 = 5000;
                }
                a aVar = this.f17318a;
                if (task.v()) {
                    errorCode = 0;
                } else {
                    if (task.t()) {
                        i3 = 100;
                    } else {
                        Exception excQ = task.q();
                        if (excQ instanceof ApiException) {
                            Status status = ((ApiException) excQ).getStatus();
                            int statusCode = status.getStatusCode();
                            ConnectionResult connectionResult = status.getConnectionResult();
                            errorCode = connectionResult == null ? -1 : connectionResult.getErrorCode();
                            i3 = statusCode;
                        } else {
                            i3 = 101;
                        }
                    }
                    errorCode = -1;
                }
                if (methodTimingTelemetryEnabled) {
                    long j3 = this.f17317a;
                    long jCurrentTimeMillis = System.currentTimeMillis();
                    iElapsedRealtime = (int) (SystemClock.elapsedRealtime() - this.b);
                    j = j3;
                    j2 = jCurrentTimeMillis;
                } else {
                    j = 0;
                    j2 = 0;
                    iElapsedRealtime = -1;
                }
                aVar.L(new MethodInvocation(this.f42494a, i3, errorCode, j, j2, null, null, iY, iElapsedRealtime), version, i2, i);
            }
        }
    }
}

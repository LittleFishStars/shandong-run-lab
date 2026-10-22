package com.zj.adlib;

import android.content.Context;
import android.os.RemoteException;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.GoogleApi;
import com.google.android.gms.common.api.internal.RemoteCall;
import com.google.android.gms.common.api.internal.TaskApiCall;
import com.google.android.gms.common.internal.TelemetryData;
import com.google.android.gms.common.internal.TelemetryLoggingClient;
import com.google.android.gms.common.internal.service.zai;
import com.google.android.gms.tasks.Task;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_08_10593cls.dex */
public final class z4c extends GoogleApi implements TelemetryLoggingClient {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Api.AbstractClientBuilder f46186a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public static final Api.b f20981a;
    public static final /* synthetic */ int b = 0;

    /* JADX INFO: renamed from: b, reason: collision with other field name */
    public static final Api f20982b;

    static {
        Api.b bVar = new Api.b();
        f20981a = bVar;
        v4c v4cVar = new v4c();
        f46186a = v4cVar;
        f20982b = new Api("ClientTelemetry.API", v4cVar, bVar);
    }

    public z4c(Context context, q29 q29Var) {
        super(context, (Api<q29>) f20982b, q29Var, GoogleApi.a.f31213a);
    }

    @Override // com.google.android.gms.common.internal.TelemetryLoggingClient
    public final Task<Void> g(final TelemetryData telemetryData) {
        TaskApiCall.a aVarA = TaskApiCall.a();
        aVarA.e(w3c.f45519a);
        aVarA.d(false);
        aVarA.c(new RemoteCall() { // from class: com.zj.adlib.s4c
            /* JADX WARN: Multi-variable type inference failed */
            @Override // com.google.android.gms.common.api.internal.RemoteCall
            public final void accept(Object obj, Object obj2) throws RemoteException {
                TelemetryData telemetryData2 = telemetryData;
                int i = z4c.b;
                ((zai) ((e5c) obj).A()).zae(telemetryData2);
                ((z09) obj2).setResult(null);
            }
        });
        return k(aVarA.a());
    }
}

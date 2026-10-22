package com.google.android.gms.common.moduleinstall.internal;

import android.app.Activity;
import android.content.Context;
import android.os.RemoteException;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.ApiException;
import com.google.android.gms.common.api.GoogleApi;
import com.google.android.gms.common.api.OptionalModuleApi;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.internal.ListenerHolder;
import com.google.android.gms.common.api.internal.RemoteCall;
import com.google.android.gms.common.api.internal.TaskApiCall;
import com.google.android.gms.common.moduleinstall.InstallStatusListener;
import com.google.android.gms.common.moduleinstall.ModuleAvailabilityResponse;
import com.google.android.gms.common.moduleinstall.ModuleInstallClient;
import com.google.android.gms.common.moduleinstall.ModuleInstallIntentResponse;
import com.google.android.gms.common.moduleinstall.ModuleInstallResponse;
import com.google.android.gms.common.moduleinstall.internal.i;
import com.google.android.gms.tasks.SuccessContinuation;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.a;
import com.zj.adlib.br5;
import com.zj.adlib.f5c;
import com.zj.adlib.q5c;
import com.zj.adlib.y5c;
import com.zj.adlib.yw6;
import com.zj.adlib.z09;
import java.util.Arrays;
import java.util.concurrent.Executor;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_08_10593cls.dex */
public final class i extends GoogleApi implements ModuleInstallClient {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Api.AbstractClientBuilder f31313a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public static final Api.b f5697a;
    public static final /* synthetic */ int b = 0;

    /* JADX INFO: renamed from: b, reason: collision with other field name */
    public static final Api f5698b;

    static {
        Api.b bVar = new Api.b();
        f5697a = bVar;
        f5c f5cVar = new f5c();
        f31313a = f5cVar;
        f5698b = new Api("ModuleInstall.API", f5cVar, bVar);
    }

    public i(Activity activity) {
        super(activity, (Api<Api.ApiOptions.a>) f5698b, Api.ApiOptions.f31210a, GoogleApi.a.f31213a);
    }

    public static final ApiFeatureRequest C(boolean z, OptionalModuleApi... optionalModuleApiArr) {
        yw6.m(optionalModuleApiArr, "Requested APIs must not be null.");
        yw6.b(optionalModuleApiArr.length > 0, "Please provide at least one OptionalModuleApi.");
        for (OptionalModuleApi optionalModuleApi : optionalModuleApiArr) {
            yw6.m(optionalModuleApi, "Requested API must not be null.");
        }
        return ApiFeatureRequest.zaa(Arrays.asList(optionalModuleApiArr), z);
    }

    @Override // com.google.android.gms.common.moduleinstall.ModuleInstallClient
    public final Task<ModuleInstallResponse> a(br5 br5Var) {
        final ApiFeatureRequest apiFeatureRequestFromModuleInstallRequest = ApiFeatureRequest.fromModuleInstallRequest(br5Var);
        final InstallStatusListener installStatusListenerB = br5Var.b();
        Executor executorC = br5Var.c();
        boolean zE = br5Var.e();
        if (apiFeatureRequestFromModuleInstallRequest.getApiFeatures().isEmpty()) {
            return com.google.android.gms.tasks.a.e(new ModuleInstallResponse(0));
        }
        if (installStatusListenerB == null) {
            TaskApiCall.a aVarA = TaskApiCall.a();
            aVarA.e(q5c.f44132a);
            aVarA.d(zE);
            aVarA.f(27304);
            aVarA.c(new RemoteCall() { // from class: com.google.android.gms.common.moduleinstall.internal.g
                /* JADX WARN: Multi-variable type inference failed */
                @Override // com.google.android.gms.common.api.internal.RemoteCall
                public final void accept(Object obj, Object obj2) throws RemoteException {
                    i iVar = this.f5695a;
                    ApiFeatureRequest apiFeatureRequest = apiFeatureRequestFromModuleInstallRequest;
                    ((zaf) ((y5c) obj).A()).zag(new zat(iVar, (z09) obj2), apiFeatureRequest, null);
                }
            });
            return m(aVarA.a());
        }
        yw6.l(installStatusListenerB);
        ListenerHolder listenerHolderW = executorC == null ? w(installStatusListenerB, InstallStatusListener.class.getSimpleName()) : com.google.android.gms.common.api.internal.b.b(installStatusListenerB, executorC, InstallStatusListener.class.getSimpleName());
        final zaab zaabVar = new zaab(listenerHolderW);
        final AtomicReference atomicReference = new AtomicReference();
        RemoteCall remoteCall = new RemoteCall() { // from class: com.google.android.gms.common.moduleinstall.internal.b
            /* JADX WARN: Multi-variable type inference failed */
            @Override // com.google.android.gms.common.api.internal.RemoteCall
            public final void accept(Object obj, Object obj2) throws RemoteException {
                i iVar = this.f5688a;
                AtomicReference atomicReference2 = atomicReference;
                InstallStatusListener installStatusListener = installStatusListenerB;
                ApiFeatureRequest apiFeatureRequest = apiFeatureRequestFromModuleInstallRequest;
                zaab zaabVar2 = zaabVar;
                ((zaf) ((y5c) obj).A()).zag(new zau(iVar, atomicReference2, (z09) obj2, installStatusListener), apiFeatureRequest, zaabVar2);
            }
        };
        RemoteCall remoteCall2 = new RemoteCall() { // from class: com.google.android.gms.common.moduleinstall.internal.c
            /* JADX WARN: Multi-variable type inference failed */
            @Override // com.google.android.gms.common.api.internal.RemoteCall
            public final void accept(Object obj, Object obj2) throws RemoteException {
                i iVar = this.f31307a;
                zaab zaabVar2 = zaabVar;
                ((zaf) ((y5c) obj).A()).zai(new zav(iVar, (z09) obj2), zaabVar2);
            }
        };
        com.google.android.gms.common.api.internal.c.a aVarA2 = com.google.android.gms.common.api.internal.c.a();
        aVarA2.h(listenerHolderW);
        aVarA2.e(q5c.f44132a);
        aVarA2.d(zE);
        aVarA2.c(remoteCall);
        aVarA2.g(remoteCall2);
        aVarA2.f(27305);
        return o(aVarA2.a()).w(new SuccessContinuation() { // from class: com.zj.adlib.m4c
            @Override // com.google.android.gms.tasks.SuccessContinuation
            public final Task a(Object obj) {
                AtomicReference atomicReference2 = atomicReference;
                int i = i.b;
                return atomicReference2.get() != null ? a.e((ModuleInstallResponse) atomicReference2.get()) : a.d(new ApiException(Status.RESULT_INTERNAL_ERROR));
            }
        });
    }

    @Override // com.google.android.gms.common.moduleinstall.ModuleInstallClient
    public final Task<Boolean> b(InstallStatusListener installStatusListener) {
        return q(com.google.android.gms.common.api.internal.b.c(installStatusListener, InstallStatusListener.class.getSimpleName()), 27306);
    }

    @Override // com.google.android.gms.common.moduleinstall.ModuleInstallClient
    public final Task<ModuleAvailabilityResponse> c(OptionalModuleApi... optionalModuleApiArr) {
        final ApiFeatureRequest apiFeatureRequestC = C(false, optionalModuleApiArr);
        if (apiFeatureRequestC.getApiFeatures().isEmpty()) {
            return com.google.android.gms.tasks.a.e(new ModuleAvailabilityResponse(true, 0));
        }
        TaskApiCall.a aVarA = TaskApiCall.a();
        aVarA.e(q5c.f44132a);
        aVarA.f(27301);
        aVarA.d(false);
        aVarA.c(new RemoteCall() { // from class: com.google.android.gms.common.moduleinstall.internal.h
            /* JADX WARN: Multi-variable type inference failed */
            @Override // com.google.android.gms.common.api.internal.RemoteCall
            public final void accept(Object obj, Object obj2) throws RemoteException {
                i iVar = this.f5696a;
                ApiFeatureRequest apiFeatureRequest = apiFeatureRequestC;
                ((zaf) ((y5c) obj).A()).zae(new zar(iVar, (z09) obj2), apiFeatureRequest);
            }
        });
        return m(aVarA.a());
    }

    @Override // com.google.android.gms.common.moduleinstall.ModuleInstallClient
    public final Task<ModuleInstallIntentResponse> e(OptionalModuleApi... optionalModuleApiArr) {
        final ApiFeatureRequest apiFeatureRequestC = C(true, optionalModuleApiArr);
        if (apiFeatureRequestC.getApiFeatures().isEmpty()) {
            return com.google.android.gms.tasks.a.e(new ModuleInstallIntentResponse(null));
        }
        TaskApiCall.a aVarA = TaskApiCall.a();
        aVarA.e(q5c.f44132a);
        aVarA.f(27307);
        aVarA.c(new RemoteCall() { // from class: com.google.android.gms.common.moduleinstall.internal.e
            /* JADX WARN: Multi-variable type inference failed */
            @Override // com.google.android.gms.common.api.internal.RemoteCall
            public final void accept(Object obj, Object obj2) throws RemoteException {
                i iVar = this.f5693a;
                ApiFeatureRequest apiFeatureRequest = apiFeatureRequestC;
                ((zaf) ((y5c) obj).A()).zaf(new zaw(iVar, (z09) obj2), apiFeatureRequest);
            }
        });
        return m(aVarA.a());
    }

    @Override // com.google.android.gms.common.moduleinstall.ModuleInstallClient
    public final Task<Void> f(OptionalModuleApi... optionalModuleApiArr) {
        final ApiFeatureRequest apiFeatureRequestC = C(false, optionalModuleApiArr);
        if (apiFeatureRequestC.getApiFeatures().isEmpty()) {
            return com.google.android.gms.tasks.a.e(null);
        }
        TaskApiCall.a aVarA = TaskApiCall.a();
        aVarA.e(q5c.f44132a);
        aVarA.f(27303);
        aVarA.d(false);
        aVarA.c(new RemoteCall() { // from class: com.google.android.gms.common.moduleinstall.internal.d
            /* JADX WARN: Multi-variable type inference failed */
            @Override // com.google.android.gms.common.api.internal.RemoteCall
            public final void accept(Object obj, Object obj2) throws RemoteException {
                i iVar = this.f5692a;
                ApiFeatureRequest apiFeatureRequest = apiFeatureRequestC;
                ((zaf) ((y5c) obj).A()).zah(new zax(iVar, (z09) obj2), apiFeatureRequest);
            }
        });
        return m(aVarA.a());
    }

    @Override // com.google.android.gms.common.moduleinstall.ModuleInstallClient
    public final Task<Void> h(OptionalModuleApi... optionalModuleApiArr) {
        final ApiFeatureRequest apiFeatureRequestC = C(false, optionalModuleApiArr);
        if (apiFeatureRequestC.getApiFeatures().isEmpty()) {
            return com.google.android.gms.tasks.a.e(null);
        }
        TaskApiCall.a aVarA = TaskApiCall.a();
        aVarA.e(q5c.f44132a);
        aVarA.f(27302);
        aVarA.d(false);
        aVarA.c(new RemoteCall() { // from class: com.google.android.gms.common.moduleinstall.internal.f
            /* JADX WARN: Multi-variable type inference failed */
            @Override // com.google.android.gms.common.api.internal.RemoteCall
            public final void accept(Object obj, Object obj2) throws RemoteException {
                i iVar = this.f5694a;
                ApiFeatureRequest apiFeatureRequest = apiFeatureRequestC;
                ((zaf) ((y5c) obj).A()).zag(new zas(iVar, (z09) obj2), apiFeatureRequest, null);
            }
        });
        return m(aVarA.a());
    }

    public i(Context context) {
        super(context, (Api<Api.ApiOptions.a>) f5698b, Api.ApiOptions.f31210a, GoogleApi.a.f31213a);
    }
}

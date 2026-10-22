package com.zj.adlib;

import android.accounts.Account;
import android.content.Context;
import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Looper;
import android.os.RemoteException;
import android.util.Log;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.internal.BaseGmsClient;
import com.google.android.gms.common.internal.GmsClient;
import com.google.android.gms.common.internal.IAccountAccessor;
import com.google.android.gms.common.internal.zat;
import com.google.android.gms.signin.internal.zaf;
import com.google.android.gms.signin.internal.zai;
import com.google.android.gms.signin.internal.zak;
import com.google.android.gms.signin.zae;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_08_10593cls.dex */
@KeepForSdk
public class xb8 extends GmsClient<zaf> implements zae {
    public static final /* synthetic */ int R = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Bundle f45785a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @Nullable
    public final Integer f20625a;
    public final fm1 b;

    /* JADX INFO: renamed from: b, reason: collision with other field name */
    public final boolean f20626b;

    public xb8(@NonNull Context context, @NonNull Looper looper, boolean z, @NonNull fm1 fm1Var, @NonNull Bundle bundle, @NonNull GoogleApiClient.ConnectionCallbacks connectionCallbacks, @NonNull GoogleApiClient.OnConnectionFailedListener onConnectionFailedListener) {
        super(context, looper, 44, fm1Var, connectionCallbacks, onConnectionFailedListener);
        this.f20626b = true;
        this.b = fm1Var;
        this.f45785a = bundle;
        this.f20625a = fm1Var.l();
    }

    @NonNull
    @KeepForSdk
    public static Bundle V(@NonNull fm1 fm1Var) {
        fm1Var.k();
        Integer numL = fm1Var.l();
        Bundle bundle = new Bundle();
        bundle.putParcelable("com.google.android.gms.signin.internal.clientRequestedAccount", fm1Var.b());
        if (numL != null) {
            bundle.putInt("com.google.android.gms.common.internal.ClientSettings.sessionId", numL.intValue());
        }
        bundle.putBoolean("com.google.android.gms.signin.internal.offlineAccessRequested", false);
        bundle.putBoolean("com.google.android.gms.signin.internal.idTokenRequested", false);
        bundle.putString("com.google.android.gms.signin.internal.serverClientId", null);
        bundle.putBoolean("com.google.android.gms.signin.internal.usePromptModeForAuthCode", true);
        bundle.putBoolean("com.google.android.gms.signin.internal.forceCodeForRefreshToken", false);
        bundle.putString("com.google.android.gms.signin.internal.hostedDomain", null);
        bundle.putString("com.google.android.gms.signin.internal.logSessionId", null);
        bundle.putBoolean("com.google.android.gms.signin.internal.waitForAccessTokenRefresh", false);
        return bundle;
    }

    @Override // com.google.android.gms.common.internal.BaseGmsClient
    @NonNull
    public final /* synthetic */ IInterface createServiceInterface(@NonNull IBinder iBinder) {
        if (iBinder == null) {
            return null;
        }
        IInterface iInterfaceQueryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.signin.internal.ISignInService");
        return iInterfaceQueryLocalInterface instanceof zaf ? (zaf) iInterfaceQueryLocalInterface : new zaf(iBinder);
    }

    @Override // com.google.android.gms.common.internal.BaseGmsClient
    @NonNull
    public final Bundle getGetServiceRequestExtraArgs() {
        if (!getContext().getPackageName().equals(this.b.h())) {
            this.f45785a.putString("com.google.android.gms.signin.internal.realClientPackageName", this.b.h());
        }
        return this.f45785a;
    }

    @Override // com.google.android.gms.common.internal.BaseGmsClient
    @NonNull
    public final String getServiceDescriptor() {
        return "com.google.android.gms.signin.internal.ISignInService";
    }

    @Override // com.google.android.gms.common.internal.BaseGmsClient
    @NonNull
    public final String getStartServiceAction() {
        return "com.google.android.gms.signin.service.START";
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.google.android.gms.signin.zae
    public final void h() {
        try {
            ((zaf) A()).zae(((Integer) yw6.l(this.f20625a)).intValue());
        } catch (RemoteException unused) {
            Log.w("SignInClientImpl", "Remote service probably died when clearAccountFromSessionStore is called");
        }
    }

    @Override // com.google.android.gms.common.internal.BaseGmsClient, com.google.android.gms.common.api.Api.Client
    public final int l() {
        return 12451000;
    }

    @Override // com.google.android.gms.signin.zae
    public final void m() {
        j(new BaseGmsClient.a());
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.google.android.gms.signin.zae
    public final void o(@NonNull IAccountAccessor iAccountAccessor, boolean z) {
        try {
            ((zaf) A()).zaf(iAccountAccessor, ((Integer) yw6.l(this.f20625a)).intValue(), z);
        } catch (RemoteException unused) {
            Log.w("SignInClientImpl", "Remote service probably died when saveDefaultAccount is called");
        }
    }

    @Override // com.google.android.gms.common.internal.BaseGmsClient, com.google.android.gms.common.api.Api.Client
    public final boolean q() {
        return this.f20626b;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.google.android.gms.signin.zae
    public final void s(com.google.android.gms.signin.internal.zae zaeVar) {
        yw6.m(zaeVar, "Expecting a valid ISignInCallbacks");
        try {
            Account accountD = this.b.d();
            ((zaf) A()).zag(new zai(1, new zat(accountD, ((Integer) yw6.l(this.f20625a)).intValue(), "<<default account>>".equals(accountD.name) ? xr8.b(getContext()).c() : null)), zaeVar);
        } catch (RemoteException e) {
            Log.w("SignInClientImpl", "Remote service probably died when signIn is called");
            try {
                zaeVar.zab(new zak(1, new ConnectionResult(8, null), null));
            } catch (RemoteException unused) {
                Log.wtf("SignInClientImpl", "ISignInCallbacks#onSignInComplete should be executed from the same process, unexpected RemoteException.", e);
            }
        }
    }
}

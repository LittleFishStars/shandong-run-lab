package com.zj.adlib;

import android.util.Log;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.WorkerThread;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.internal.a;
import com.google.android.gms.common.api.internal.t;
import com.google.android.gms.common.api.internal.zacs;
import com.google.android.gms.common.internal.BaseGmsClient;
import com.google.android.gms.common.internal.IAccountAccessor;
import java.util.Set;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_08_10593cls.dex */
public final class x1c implements BaseGmsClient.ConnectionProgressReportCallbacks, zacs {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Api.Client f45731a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final /* synthetic */ a f20592a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final c90 f20594a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @Nullable
    public IAccountAccessor f20593a = null;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @Nullable
    public Set f20595a = null;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public boolean f20596a = false;

    public x1c(a aVar, Api.Client client, c90 c90Var) {
        this.f20592a = aVar;
        this.f45731a = client;
        this.f20594a = c90Var;
    }

    @Override // com.google.android.gms.common.api.internal.zacs
    @WorkerThread
    public final void a(ConnectionResult connectionResult) {
        t tVar = (t) this.f20592a.f5527a.get(this.f20594a);
        if (tVar != null) {
            tVar.G(connectionResult);
        }
    }

    @Override // com.google.android.gms.common.internal.BaseGmsClient.ConnectionProgressReportCallbacks
    public final void b(@NonNull ConnectionResult connectionResult) {
        this.f20592a.f5521a.post(new w1c(this, connectionResult));
    }

    @Override // com.google.android.gms.common.api.internal.zacs
    @WorkerThread
    public final void c(@Nullable IAccountAccessor iAccountAccessor, @Nullable Set set) {
        if (iAccountAccessor == null || set == null) {
            Log.wtf("GoogleApiManager", "Received null response from onSignInSuccess", new Exception());
            a(new ConnectionResult(4));
        } else {
            this.f20593a = iAccountAccessor;
            this.f20595a = set;
            h();
        }
    }

    @WorkerThread
    public final void h() {
        IAccountAccessor iAccountAccessor;
        if (!this.f20596a || (iAccountAccessor = this.f20593a) == null) {
            return;
        }
        this.f45731a.e(iAccountAccessor, this.f20595a);
    }
}

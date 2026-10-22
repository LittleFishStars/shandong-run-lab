package com.zj.adlib;

import androidx.annotation.NonNull;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.ResultCallback;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.internal.p;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_08_10593cls.dex */
public final class l1c implements ResultCallback {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ GoogleApiClient f42975a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final /* synthetic */ p f17860a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final /* synthetic */ dr8 f17861a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final /* synthetic */ boolean f17862a;

    public l1c(p pVar, dr8 dr8Var, boolean z, GoogleApiClient googleApiClient) {
        this.f17860a = pVar;
        this.f17861a = dr8Var;
        this.f17862a = z;
        this.f42975a = googleApiClient;
    }

    @Override // com.google.android.gms.common.api.ResultCallback
    public final /* bridge */ /* synthetic */ void a(@NonNull Result result) {
        Status status = (Status) result;
        xr8.b(this.f17860a.f5572a).g();
        if (status.isSuccess() && this.f17860a.t()) {
            p pVar = this.f17860a;
            pVar.i();
            pVar.g();
        }
        this.f17861a.setResult(status);
        if (this.f17862a) {
            this.f42975a.i();
        }
    }
}

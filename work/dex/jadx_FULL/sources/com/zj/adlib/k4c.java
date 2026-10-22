package com.zj.adlib;

import android.util.Log;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.GoogleApiClient;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_08_10593cls.dex */
public final class k4c implements GoogleApiClient.OnConnectionFailedListener {
    public final int K;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @Nullable
    public final GoogleApiClient.OnConnectionFailedListener f42743a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final GoogleApiClient f17581a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final /* synthetic */ o4c f17582a;

    public k4c(o4c o4cVar, int i, @Nullable GoogleApiClient googleApiClient, GoogleApiClient.OnConnectionFailedListener onConnectionFailedListener) {
        this.f17582a = o4cVar;
        this.K = i;
        this.f17581a = googleApiClient;
        this.f42743a = onConnectionFailedListener;
    }

    @Override // com.google.android.gms.common.api.internal.OnConnectionFailedListener
    public final void onConnectionFailed(@NonNull ConnectionResult connectionResult) {
        Log.d("AutoManageHelper", "beginFailureResolution for ".concat(String.valueOf(connectionResult)));
        this.f17582a.p(connectionResult, this.K);
    }
}

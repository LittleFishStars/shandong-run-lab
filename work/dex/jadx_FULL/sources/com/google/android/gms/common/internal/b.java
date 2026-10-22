package com.google.android.gms.common.internal;

import androidx.annotation.NonNull;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.internal.OnConnectionFailedListener;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_08_10593cls.dex */
public final class b implements BaseGmsClient.BaseOnConnectionFailedListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ OnConnectionFailedListener f31295a;

    public b(OnConnectionFailedListener onConnectionFailedListener) {
        this.f31295a = onConnectionFailedListener;
    }

    @Override // com.google.android.gms.common.internal.BaseGmsClient.BaseOnConnectionFailedListener
    public final void onConnectionFailed(@NonNull ConnectionResult connectionResult) {
        this.f31295a.onConnectionFailed(connectionResult);
    }
}

package com.google.android.gms.common.internal;

import android.os.Bundle;
import androidx.annotation.BinderThread;
import androidx.annotation.Nullable;
import com.google.android.gms.common.ConnectionResult;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_08_10593cls.dex */
public final class i extends zza {
    public final /* synthetic */ BaseGmsClient c;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    @BinderThread
    public i(BaseGmsClient baseGmsClient, @Nullable int i, Bundle bundle) {
        super(baseGmsClient, i, null);
        this.c = baseGmsClient;
    }

    @Override // com.google.android.gms.common.internal.zza
    public final void zzb(ConnectionResult connectionResult) {
        if (this.c.enableLocalFallback() && BaseGmsClient.S(this.c)) {
            BaseGmsClient.P(this.c, 16);
        } else {
            this.c.f5661a.b(connectionResult);
            this.c.onConnectionFailed(connectionResult);
        }
    }

    @Override // com.google.android.gms.common.internal.zza
    public final boolean zzd() {
        this.c.f5661a.b(ConnectionResult.RESULT_SUCCESS);
        return true;
    }
}

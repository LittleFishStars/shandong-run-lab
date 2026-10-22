package com.google.android.gms.common.internal;

import android.app.PendingIntent;
import android.os.Bundle;
import androidx.annotation.BinderThread;
import androidx.annotation.Nullable;
import com.google.android.gms.common.ConnectionResult;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_08_10593cls.dex */
abstract class zza extends zzc {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f31302a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @Nullable
    public final Bundle f5684a;
    public final /* synthetic */ BaseGmsClient b;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    @BinderThread
    public zza(BaseGmsClient baseGmsClient, @Nullable int i, Bundle bundle) {
        super(baseGmsClient, Boolean.TRUE);
        this.b = baseGmsClient;
        this.f31302a = i;
        this.f5684a = bundle;
    }

    @Override // com.google.android.gms.common.internal.zzc
    public final /* bridge */ /* synthetic */ void zza(Object obj) {
        if (this.f31302a != 0) {
            this.b.T(1, null);
            Bundle bundle = this.f5684a;
            zzb(new ConnectionResult(this.f31302a, bundle != null ? (PendingIntent) bundle.getParcelable(BaseGmsClient.i) : null));
        } else {
            if (zzd()) {
                return;
            }
            this.b.T(1, null);
            zzb(new ConnectionResult(8, null));
        }
    }

    public abstract void zzb(ConnectionResult connectionResult);

    @Override // com.google.android.gms.common.internal.zzc
    public final void zzc() {
    }

    public abstract boolean zzd();
}

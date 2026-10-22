package com.google.android.gms.common.api.internal;

import androidx.annotation.BinderThread;
import com.google.android.gms.signin.internal.zak;
import java.lang.ref.WeakReference;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_08_10593cls.dex */
final class zaar extends com.google.android.gms.signin.internal.zac {
    private final WeakReference zaa;

    public zaar(n nVar) {
        this.zaa = new WeakReference(nVar);
    }

    @Override // com.google.android.gms.signin.internal.zac, com.google.android.gms.signin.internal.zae
    @BinderThread
    public final void zab(zak zakVar) {
        n nVar = (n) this.zaa.get();
        if (nVar == null) {
            return;
        }
        nVar.f5560a.t(new l(this, nVar, nVar, zakVar));
    }
}

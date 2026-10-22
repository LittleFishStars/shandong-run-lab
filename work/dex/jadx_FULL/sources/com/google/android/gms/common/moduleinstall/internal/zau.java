package com.google.android.gms.common.moduleinstall.internal;

import androidx.annotation.Nullable;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.moduleinstall.InstallStatusListener;
import com.google.android.gms.common.moduleinstall.ModuleInstallResponse;
import com.zj.adlib.f19;
import com.zj.adlib.z09;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_08_10593cls.dex */
final class zau extends zaa {
    final /* synthetic */ AtomicReference zaa;
    final /* synthetic */ z09 zab;
    final /* synthetic */ InstallStatusListener zac;
    final /* synthetic */ i zad;

    public zau(i iVar, AtomicReference atomicReference, z09 z09Var, InstallStatusListener installStatusListener) {
        this.zad = iVar;
        this.zaa = atomicReference;
        this.zab = z09Var;
        this.zac = installStatusListener;
    }

    @Override // com.google.android.gms.common.moduleinstall.internal.zaa, com.google.android.gms.common.moduleinstall.internal.zae
    public final void zad(Status status, @Nullable ModuleInstallResponse moduleInstallResponse) {
        if (moduleInstallResponse != null) {
            this.zaa.set(moduleInstallResponse);
        }
        f19.d(status, null, this.zab);
        if (!status.isSuccess() || (moduleInstallResponse != null && moduleInstallResponse.zaa())) {
            this.zad.q(com.google.android.gms.common.api.internal.b.c(this.zac, InstallStatusListener.class.getSimpleName()), 27306);
        }
    }
}

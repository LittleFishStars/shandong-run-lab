package com.google.android.gms.common.moduleinstall.internal;

import androidx.annotation.Nullable;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.moduleinstall.ModuleInstallIntentResponse;
import com.zj.adlib.f19;
import com.zj.adlib.z09;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_08_10593cls.dex */
final class zaw extends zaa {
    final /* synthetic */ z09 zaa;

    public zaw(i iVar, z09 z09Var) {
        this.zaa = z09Var;
    }

    @Override // com.google.android.gms.common.moduleinstall.internal.zaa, com.google.android.gms.common.moduleinstall.internal.zae
    public final void zac(Status status, @Nullable ModuleInstallIntentResponse moduleInstallIntentResponse) {
        f19.d(status, moduleInstallIntentResponse, this.zaa);
    }
}

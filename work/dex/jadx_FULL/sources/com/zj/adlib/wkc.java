package com.zj.adlib;

import android.content.Context;
import androidx.core.content.PermissionChecker;
import com.google.android.gms.internal.mlkit_common.zzs;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_08_10593cls.dex */
public final class wkc extends zzs {
    @Override // com.google.android.gms.internal.mlkit_common.zzs
    public final int zza(Context context, dpd dpdVar, boolean z) {
        return (dpdVar.f16056a.getAuthority().lastIndexOf(64) < 0 || PermissionChecker.checkSelfPermission(context, "android.permission.INTERACT_ACROSS_USERS") != 0) ? 3 : 2;
    }
}

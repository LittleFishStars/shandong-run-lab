package com.zj.adlib;

import android.app.Activity;
import android.content.Context;
import androidx.annotation.NonNull;
import com.google.android.gms.common.moduleinstall.ModuleInstallClient;
import com.google.android.gms.common.moduleinstall.internal.i;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_08_10593cls.dex */
public final class ar5 {
    @NonNull
    public static ModuleInstallClient a(@NonNull Activity activity) {
        return new i(activity);
    }

    @NonNull
    public static ModuleInstallClient b(@NonNull Context context) {
        return new i(context);
    }
}

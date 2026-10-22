package com.zj.adlib;

import android.content.Context;
import android.content.res.Resources;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import com.google.android.gms.common.R;
import com.google.android.gms.common.annotation.KeepForSdk;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_08_10593cls.dex */
@KeepForSdk
public class ts8 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Resources f44997a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final String f19892a;

    public ts8(@NonNull Context context) {
        yw6.l(context);
        Resources resources = context.getResources();
        this.f44997a = resources;
        this.f19892a = resources.getResourcePackageName(R.string.common_google_play_services_unknown_issue);
    }

    @Nullable
    @KeepForSdk
    public String a(@NonNull String str) {
        int identifier = this.f44997a.getIdentifier(str, TypedValues.Custom.S_STRING, this.f19892a);
        if (identifier == 0) {
            return null;
        }
        return this.f44997a.getString(identifier);
    }
}

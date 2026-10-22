package com.kwad.sdk.b;

import android.content.Context;
import com.kuaishou.weapon.p0.WeaponHI;
import com.kwad.sdk.service.ServiceProvider;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_05_1888cls.dex */
public final class a {
    public static void init(Context context) {
        if (com.kwad.framework.a.a.Oz.booleanValue()) {
            try {
                WeaponHI.init(context, new b());
            } catch (Throwable th) {
                ServiceProvider.reportSdkCaughtException(th);
            }
        }
    }
}

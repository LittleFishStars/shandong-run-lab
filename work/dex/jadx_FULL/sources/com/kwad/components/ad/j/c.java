package com.kwad.components.ad.j;

import android.content.Context;
import androidx.annotation.Nullable;
import com.kwad.components.offline.api.core.adlive.IAdLiveOfflineView;
import com.kwad.sdk.service.ServiceProvider;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_06_4659cls.dex */
public final class c {
    @Nullable
    public static IAdLiveOfflineView a(com.kwad.components.core.offline.a.c.a aVar, Context context, int i) {
        try {
            return aVar.getView(context, i);
        } catch (Throwable th) {
            com.kwad.sdk.core.d.c.printStackTrace(th);
            ServiceProvider.reportSdkCaughtException(th);
            return null;
        }
    }
}

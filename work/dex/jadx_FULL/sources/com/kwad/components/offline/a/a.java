package com.kwad.components.offline.a;

import android.content.Context;
import androidx.annotation.NonNull;
import com.kwad.components.offline.api.adInnerEc.IAdInnerEcOfflineCompo;
import com.kwad.components.offline.api.core.adInnerEc.IAdInnerEcExternalModule;
import com.kwad.sdk.service.ServiceProvider;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_06_4659cls.dex */
public class a implements com.kwad.components.core.offline.a.a.a {
    private final IAdInnerEcOfflineCompo awH;

    public a(@NonNull IAdInnerEcOfflineCompo iAdInnerEcOfflineCompo) {
        this.awH = iAdInnerEcOfflineCompo;
    }

    @Override // com.kwad.sdk.components.b
    public final Class getComponentsType() {
        return a.class;
    }

    @Override // com.kwad.sdk.components.b
    public final void init(Context context) {
    }

    @Override // com.kwad.sdk.components.b
    public final int priority() {
        return this.awH.priority();
    }

    @Override // com.kwad.components.core.offline.a.a.a
    public final boolean tr() {
        return this.awH.getState() == IAdInnerEcOfflineCompo.AdInnerEcState.READY;
    }

    @Override // com.kwad.components.core.offline.a.a.a
    public final IAdInnerEcExternalModule ts() {
        if (!tr()) {
            return null;
        }
        try {
            return this.awH.getAdInnerEcExternalModule();
        } catch (Throwable th) {
            ServiceProvider.reportSdkCaughtException(th);
            return null;
        }
    }
}

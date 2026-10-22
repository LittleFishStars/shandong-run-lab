package com.kwad.components.offline.c;

import android.content.Context;
import androidx.annotation.NonNull;
import com.kwad.components.core.offline.b.a.n;
import com.kwad.components.offline.api.adWaynePlayer.IAdWaynePlayerOfflineCompo;
import com.kwad.components.offline.api.adWaynePlayer.IAdWaynePlayerOfflineCompoInitConfig;
import com.kwad.components.offline.api.core.api.IOfflineCompoWrapper;
import com.kwad.components.offline.api.core.soloader.ISoLoader;
import com.kwad.components.offline.api.core.soloader.SoLoadListener;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_06_4659cls.dex */
public final class c implements IAdWaynePlayerOfflineCompoInitConfig {
    @Override // com.kwad.components.offline.api.adWaynePlayer.IAdWaynePlayerOfflineCompoInitConfig
    public final ISoLoader soLoader() {
        return new ISoLoader() { // from class: com.kwad.components.offline.c.c.1
            @Override // com.kwad.components.offline.api.core.soloader.ISoLoader
            public final void loadSo(Context context, @NonNull SoLoadListener soLoadListener) {
                com.kwad.components.offline.c.a.a.a(context, soLoadListener);
            }
        };
    }

    @Override // com.kwad.components.offline.api.IOfflineCompoInitConfig
    public final IOfflineCompoWrapper wrapper() {
        return new n(IAdWaynePlayerOfflineCompo.PACKAGE_NAME);
    }
}

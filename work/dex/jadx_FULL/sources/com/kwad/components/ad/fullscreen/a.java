package com.kwad.components.ad.fullscreen;

import android.content.Context;
import androidx.annotation.NonNull;
import com.kwad.sdk.api.KsLoadManager;
import com.kwad.sdk.api.KsScene;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_06_4659cls.dex */
public final class a extends com.kwad.components.ad.c implements com.kwad.components.ad.b.e {
    @Override // com.kwad.sdk.components.b
    public final Class getComponentsType() {
        return com.kwad.components.ad.b.e.class;
    }

    @Override // com.kwad.sdk.components.b
    public final void init(Context context) {
    }

    @Override // com.kwad.components.ad.b.e
    public final void loadFullScreenVideoAd(final KsScene ksScene, @NonNull final KsLoadManager.FullScreenVideoAdListener fullScreenVideoAdListener) {
        a(new com.kwad.sdk.g.a<Boolean>() { // from class: com.kwad.components.ad.fullscreen.a.1
            /* JADX INFO: Access modifiers changed from: private */
            @Override // com.kwad.sdk.g.a
            /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
            public void accept(Boolean bool) {
                if (bool.booleanValue()) {
                    KsScene ksScene2 = ksScene;
                    f.a(ksScene2, new e(ksScene2.getPosId(), fullScreenVideoAdListener));
                } else {
                    KsLoadManager.FullScreenVideoAdListener fullScreenVideoAdListener2 = fullScreenVideoAdListener;
                    com.kwad.sdk.core.network.e eVar = com.kwad.sdk.core.network.e.aTn;
                    fullScreenVideoAdListener2.onError(eVar.errorCode, eVar.msg);
                }
            }
        });
    }

    @Override // com.kwad.sdk.components.e, com.kwad.sdk.components.b
    public final int priority() {
        com.kwad.sdk.components.b bVarF = com.kwad.sdk.components.d.f(com.kwad.components.ad.b.h.class);
        if (bVarF != null) {
            return bVarF.priority() + 1;
        }
        return 1;
    }
}

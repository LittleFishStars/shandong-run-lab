package com.kwad.components.ad.draw;

import android.content.Context;
import androidx.annotation.NonNull;
import com.kwad.sdk.api.KsLoadManager;
import com.kwad.sdk.api.KsScene;
import com.kwad.sdk.core.network.e;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_06_4659cls.dex */
public final class a extends com.kwad.components.ad.c implements com.kwad.components.ad.b.c {
    @Override // com.kwad.sdk.components.b
    public final Class getComponentsType() {
        return com.kwad.components.ad.b.c.class;
    }

    @Override // com.kwad.sdk.components.b
    public final void init(Context context) {
    }

    @Override // com.kwad.components.ad.b.c
    public final void loadDrawAd(final KsScene ksScene, @NonNull final KsLoadManager.DrawAdListener drawAdListener) {
        a(new com.kwad.sdk.g.a<Boolean>() { // from class: com.kwad.components.ad.draw.a.1
            /* JADX INFO: Access modifiers changed from: private */
            @Override // com.kwad.sdk.g.a
            /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
            public void accept(Boolean bool) {
                if (bool.booleanValue()) {
                    d.loadDrawAd(ksScene, drawAdListener);
                    return;
                }
                KsLoadManager.DrawAdListener drawAdListener2 = drawAdListener;
                e eVar = e.aTn;
                drawAdListener2.onError(eVar.errorCode, eVar.msg);
            }
        });
    }
}

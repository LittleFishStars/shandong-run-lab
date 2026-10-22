package com.kwad.components.ad.feed;

import android.content.Context;
import androidx.annotation.NonNull;
import com.kwad.sdk.api.KsLoadManager;
import com.kwad.sdk.api.KsScene;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_06_4659cls.dex */
public final class a extends com.kwad.components.ad.c implements com.kwad.components.ad.b.d {
    @Override // com.kwad.sdk.components.b
    public final Class getComponentsType() {
        return com.kwad.components.ad.b.d.class;
    }

    @Override // com.kwad.sdk.components.b
    public final void init(Context context) {
    }

    @Override // com.kwad.components.ad.b.d
    public final void loadConfigFeedAd(KsScene ksScene, @NonNull KsLoadManager.FeedAdListener feedAdListener) {
        e.a(ksScene, feedAdListener, true);
    }

    @Override // com.kwad.components.ad.b.d
    public final void loadFeedAd(final KsScene ksScene, @NonNull final KsLoadManager.FeedAdListener feedAdListener) {
        a(new com.kwad.sdk.g.a<Boolean>() { // from class: com.kwad.components.ad.feed.a.1
            /* JADX INFO: Access modifiers changed from: private */
            @Override // com.kwad.sdk.g.a
            /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
            public void accept(Boolean bool) {
                if (bool.booleanValue()) {
                    e.a(ksScene, feedAdListener, !com.kwad.components.ad.feed.a.b.cm());
                    return;
                }
                KsLoadManager.FeedAdListener feedAdListener2 = feedAdListener;
                com.kwad.sdk.core.network.e eVar = com.kwad.sdk.core.network.e.aTn;
                feedAdListener2.onError(eVar.errorCode, eVar.msg);
            }
        });
    }
}

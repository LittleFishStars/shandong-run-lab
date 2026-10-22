package com.kwad.components.core.webview.jshandler;

import androidx.annotation.NonNull;
import com.ksad.json.annotation.KsJson;
import com.kwad.components.offline.api.core.adlive.model.AdLiveMessageInfo;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_06_4659cls.dex */
public final class WebCardRegisterLiveMessageListener implements com.kwad.sdk.core.webview.c.a {
    private com.kwad.sdk.core.webview.c.c apx;

    @KsJson
    public static final class AdLiveMessageInfoList extends com.kwad.sdk.core.response.a.a implements Serializable {
        private static final long serialVersionUID = -9127181276274466179L;
        public List<AdLiveMessageItemInfo> adLiveMessageInfos;

        @KsJson
        public static final class AdLiveMessageItemInfo extends com.kwad.sdk.core.response.a.a implements Serializable {
            private static final long serialVersionUID = 1943278809007082732L;
            public String content;
            public String userName;
        }
    }

    @Override // com.kwad.sdk.core.webview.c.a
    public final void a(String str, @NonNull com.kwad.sdk.core.webview.c.c cVar) {
        com.kwad.sdk.core.d.c.d("TAGGG", "recive CallBack ");
        this.apx = cVar;
    }

    @Override // com.kwad.sdk.core.webview.c.a
    @NonNull
    public final String getKey() {
        return "registerLiveMessageListener";
    }

    @Override // com.kwad.sdk.core.webview.c.a
    public final void onDestroy() {
        this.apx = null;
    }

    public final void u(List<AdLiveMessageInfo> list) {
        com.kwad.sdk.core.d.c.d("TAGGG", "size " + list.size());
        if (this.apx == null) {
            return;
        }
        AdLiveMessageInfoList adLiveMessageInfoList = new AdLiveMessageInfoList();
        adLiveMessageInfoList.adLiveMessageInfos = new ArrayList();
        for (AdLiveMessageInfo adLiveMessageInfo : list) {
            AdLiveMessageInfoList.AdLiveMessageItemInfo adLiveMessageItemInfo = new AdLiveMessageInfoList.AdLiveMessageItemInfo();
            adLiveMessageItemInfo.userName = adLiveMessageInfo.userName;
            adLiveMessageItemInfo.content = adLiveMessageInfo.content;
            adLiveMessageInfoList.adLiveMessageInfos.add(adLiveMessageItemInfo);
        }
        com.kwad.sdk.core.d.c.d("TAGGG", "size " + adLiveMessageInfoList.toJson().toString());
        this.apx.b(adLiveMessageInfoList);
    }
}

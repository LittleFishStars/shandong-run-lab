package com.kwad.components.ad.reward.k;

import androidx.annotation.NonNull;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_06_4659cls.dex */
public final class h implements com.kwad.sdk.core.webview.c.a {
    private a Ca;

    public interface a {
        void ap(int i);
    }

    public h(a aVar) {
        this.Ca = aVar;
    }

    @Override // com.kwad.sdk.core.webview.c.a
    public final void a(String str, @NonNull com.kwad.sdk.core.webview.c.c cVar) {
        int iOptInt;
        if (this.Ca != null) {
            try {
                iOptInt = new JSONObject(str).optInt("severCheckResult");
            } catch (JSONException e) {
                e.printStackTrace();
                iOptInt = 0;
            }
            this.Ca.ap(iOptInt);
        }
    }

    @Override // com.kwad.sdk.core.webview.c.a
    @NonNull
    public final String getKey() {
        return "hasReward";
    }

    @Override // com.kwad.sdk.core.webview.c.a
    public final void onDestroy() {
        this.Ca = null;
    }
}

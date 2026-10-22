package com.kwad.components.core.liveEnd;

import android.text.TextUtils;
import com.kwad.components.offline.api.core.adlive.IAdLiveEndRequest;
import com.kwad.sdk.core.network.b;
import com.kwad.sdk.utils.bb;
import java.util.Map;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_06_4659cls.dex */
public final class a extends b {
    private IAdLiveEndRequest js;

    public a(IAdLiveEndRequest iAdLiveEndRequest) {
        this.js = iAdLiveEndRequest;
    }

    @Override // com.kwad.sdk.core.network.b
    public final void buildBaseBody() {
    }

    @Override // com.kwad.sdk.core.network.b
    public final void buildBaseHeader() {
    }

    @Override // com.kwad.sdk.core.network.b, com.kwad.sdk.core.network.f
    public final Map<String, String> getBodyMap() {
        return this.js.getBodyMap();
    }

    @Override // com.kwad.sdk.core.network.b, com.kwad.sdk.core.network.f
    public final Map<String, String> getHeader() {
        IAdLiveEndRequest iAdLiveEndRequest = this.js;
        if (iAdLiveEndRequest == null || iAdLiveEndRequest.getHeader() == null || this.js.getHeader().size() <= 0) {
            return super.getHeader();
        }
        for (String str : this.js.getHeader().keySet()) {
            if (!TextUtils.isEmpty(this.js.getHeader().get(str))) {
                addHeader(str, this.js.getHeader().get(str));
            }
        }
        return super.getHeader();
    }

    @Override // com.kwad.sdk.core.network.b, com.kwad.sdk.core.network.f
    public final String getUrl() {
        return bb.appendUrl(this.js.getUrl(), this.js.getUrlParam());
    }
}

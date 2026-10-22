package com.kwad.components.core.urlReplace;

import com.kwad.sdk.core.network.d;
import com.kwad.sdk.i;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_06_4659cls.dex */
public final class b extends d {
    public b(String str) {
        putBody("originalMiMarketUrl", str);
    }

    @Override // com.kwad.sdk.core.network.b, com.kwad.sdk.core.network.f
    public final String getUrl() {
        return i.EZ();
    }
}

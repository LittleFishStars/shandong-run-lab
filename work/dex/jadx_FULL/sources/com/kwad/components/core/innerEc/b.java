package com.kwad.components.core.innerEc;

import com.kwad.sdk.core.request.model.g;
import com.kwad.sdk.i;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_06_4659cls.dex */
public final class b extends com.kwad.sdk.core.network.d {
    public b(String str, String str2) {
        g gVarNw = g.Nw();
        gVarNw.fj(str);
        gVarNw.fl(str2);
        putBody("userInfo", gVarNw);
    }

    @Override // com.kwad.sdk.core.network.b, com.kwad.sdk.core.network.f
    public final String getUrl() {
        return i.Fa();
    }
}

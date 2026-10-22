package com.kwad.components.core.offline.b.a;

import com.kwad.components.offline.api.core.network.IIdc;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_06_4659cls.dex */
public final class p implements IIdc {
    @Override // com.kwad.components.offline.api.core.network.IIdc
    public final String hostForAPI(String str) {
        if (str.equals("api")) {
            return com.kwad.sdk.i.EI();
        }
        return "https://" + com.kwad.sdk.core.network.idc.a.Mo().Z(str, null);
    }
}

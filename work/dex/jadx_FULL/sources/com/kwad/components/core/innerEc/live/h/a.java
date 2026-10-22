package com.kwad.components.core.innerEc.live.h;

import com.kwad.components.core.innerEc.live.base.b;
import com.kwad.sdk.i;
import java.util.Map;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_06_4659cls.dex */
public final class a extends com.kwad.components.core.innerEc.b.a {
    public a(b bVar, Map<String, String> map) {
        super(map);
        putBody("liveParam", bVar);
    }

    @Override // com.kwad.sdk.core.network.b, com.kwad.sdk.core.network.f
    public final String getUrl() {
        return i.Fk();
    }
}

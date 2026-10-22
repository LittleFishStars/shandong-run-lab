package com.kwad.components.core.innerEc.live.g;

import com.kwad.components.core.innerEc.f;
import com.kwad.components.offline.api.core.adInnerEc.fullAdLive.model.PbSCActivityLiveInfo;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_06_4659cls.dex */
public abstract class b extends a<PbSCActivityLiveInfo> {
    private static PbSCActivityLiveInfo f(byte[] bArr) {
        return (PbSCActivityLiveInfo) f.ri().parseFrom(bArr, PbSCActivityLiveInfo.class);
    }

    @Override // com.kwad.components.core.innerEc.live.g.a
    public final /* synthetic */ PbSCActivityLiveInfo e(byte[] bArr) {
        return f(bArr);
    }

    @Override // com.kwad.components.offline.api.core.adInnerEc.longconnection.listener.SCMessageListener
    public int getPayloadType() {
        return f.ri().getPbPayloadType().getScActivityLiveInfo();
    }
}

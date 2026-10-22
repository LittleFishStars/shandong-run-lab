package com.kwad.components.core.innerEc.live.g;

import com.kwad.components.core.innerEc.f;
import com.kwad.components.offline.api.core.adInnerEc.fullAdLive.model.PbSCFeedPush;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_06_4659cls.dex */
public abstract class c extends a<PbSCFeedPush> {
    private static PbSCFeedPush g(byte[] bArr) {
        return (PbSCFeedPush) f.ri().parseFrom(bArr, PbSCFeedPush.class);
    }

    @Override // com.kwad.components.core.innerEc.live.g.a
    public final /* synthetic */ PbSCFeedPush e(byte[] bArr) {
        return g(bArr);
    }

    @Override // com.kwad.components.offline.api.core.adInnerEc.longconnection.listener.SCMessageListener
    public int getPayloadType() {
        return f.ri().getPbPayloadType().getScFeedPush();
    }
}

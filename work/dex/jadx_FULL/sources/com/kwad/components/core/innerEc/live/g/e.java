package com.kwad.components.core.innerEc.live.g;

import com.kwad.components.core.innerEc.f;
import com.kwad.components.offline.api.core.adInnerEc.fullAdLive.model.PbSCShopEntranceControl;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_06_4659cls.dex */
public class e extends a<PbSCShopEntranceControl> {
    private static PbSCShopEntranceControl i(byte[] bArr) {
        return (PbSCShopEntranceControl) f.ri().parseFrom(bArr, PbSCShopEntranceControl.class);
    }

    @Override // com.kwad.components.core.innerEc.live.g.a
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public void g(PbSCShopEntranceControl pbSCShopEntranceControl) {
    }

    @Override // com.kwad.components.core.innerEc.live.g.a
    public final /* synthetic */ PbSCShopEntranceControl e(byte[] bArr) {
        return i(bArr);
    }

    @Override // com.kwad.components.offline.api.core.adInnerEc.longconnection.listener.SCMessageListener
    public int getPayloadType() {
        return f.ri().getPbPayloadType().getScShopEntranceControl();
    }
}

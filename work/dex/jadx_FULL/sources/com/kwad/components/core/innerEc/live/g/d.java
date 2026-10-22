package com.kwad.components.core.innerEc.live.g;

import androidx.annotation.NonNull;
import com.kwad.components.core.innerEc.f;
import com.kwad.components.offline.api.core.adInnerEc.fullAdLive.model.PbKwaishopResourceLivePendantInfo;
import com.kwad.components.offline.api.core.adInnerEc.fullAdLive.model.PbSCKwaishopResourceLivePendantSignalData;
import com.kwad.sdk.utils.br;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_06_4659cls.dex */
public abstract class d extends a<PbSCKwaishopResourceLivePendantSignalData> {
    protected final com.kwad.components.core.innerEc.live.b.a.b Ub;

    public d(com.kwad.components.core.innerEc.live.b.a.b bVar) {
        this.Ub = bVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    @Override // com.kwad.components.core.innerEc.live.g.a
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public void g(@NonNull PbSCKwaishopResourceLivePendantSignalData pbSCKwaishopResourceLivePendantSignalData) {
        List<PbKwaishopResourceLivePendantInfo> pendantInfo;
        com.kwad.sdk.core.d.c.d("SCLiveShopStateMessage", "SC_LIVE_SHOP_STATE onMessageReceived");
        if (aO(pbSCKwaishopResourceLivePendantSignalData.getLiveStreamId()) && (pendantInfo = pbSCKwaishopResourceLivePendantSignalData.getPendantInfo()) != null) {
            com.kwad.components.core.innerEc.live.f.a aVar = new com.kwad.components.core.innerEc.live.f.a();
            aVar.liveStreamId = pbSCKwaishopResourceLivePendantSignalData.getLiveStreamId();
            aVar.Xt = String.valueOf(pbSCKwaishopResourceLivePendantSignalData.getSellerId());
            ArrayList arrayList = new ArrayList();
            for (PbKwaishopResourceLivePendantInfo pbKwaishopResourceLivePendantInfo : pendantInfo) {
                if (pbKwaishopResourceLivePendantInfo != null) {
                    com.kwad.components.core.innerEc.live.f.b bVar = new com.kwad.components.core.innerEc.live.f.b();
                    bVar.Xv = pbKwaishopResourceLivePendantInfo.getAreaCode();
                    bVar.Xw = pbKwaishopResourceLivePendantInfo.getPendantResourceId();
                    bVar.Xx = pbKwaishopResourceLivePendantInfo.getPendantCode();
                    bVar.action = pbKwaishopResourceLivePendantInfo.getAction();
                    bVar.Xy = pbKwaishopResourceLivePendantInfo.getEventData();
                    bVar.Xz = pbKwaishopResourceLivePendantInfo.getThroughInfo();
                    bVar.XA = pbKwaishopResourceLivePendantInfo.isNeedServerProcess();
                    bVar.XB = pbKwaishopResourceLivePendantInfo.isNeedBusinessHandle();
                    bVar.XC = pbKwaishopResourceLivePendantInfo.getCallbackApi();
                    bVar.XD = pbKwaishopResourceLivePendantInfo.isNeedRandomCall();
                    bVar.XE = pbKwaishopResourceLivePendantInfo.getRandomRangeMillis();
                    bVar.XF = pbKwaishopResourceLivePendantInfo.isNeedSignalFallback();
                    bVar.XG = pbKwaishopResourceLivePendantInfo.getCallbackPath();
                    arrayList.add(bVar);
                }
            }
            aVar.Xu = arrayList;
            if (arrayList.isEmpty()) {
                return;
            }
            a(aVar);
        }
    }

    private boolean aO(String str) {
        return br.isEquals(com.kwad.components.core.innerEc.live.i.e.aM(this.Ub.mAdTemplate), str);
    }

    private static PbSCKwaishopResourceLivePendantSignalData h(byte[] bArr) {
        return (PbSCKwaishopResourceLivePendantSignalData) f.ri().parseFrom(bArr, PbSCKwaishopResourceLivePendantSignalData.class);
    }

    public abstract void a(com.kwad.components.core.innerEc.live.f.a aVar);

    @Override // com.kwad.components.core.innerEc.live.g.a
    public final /* synthetic */ PbSCKwaishopResourceLivePendantSignalData e(byte[] bArr) {
        return h(bArr);
    }

    @Override // com.kwad.components.offline.api.core.adInnerEc.longconnection.listener.SCMessageListener
    public int getPayloadType() {
        try {
            return f.ri().getPbPayloadType().getScKwaishopResourceLivePendantSignalData();
        } catch (Exception unused) {
            return 960;
        }
    }
}

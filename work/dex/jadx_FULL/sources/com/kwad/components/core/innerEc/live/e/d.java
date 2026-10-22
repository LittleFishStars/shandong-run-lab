package com.kwad.components.core.innerEc.live.e;

import com.kwad.components.offline.api.core.adInnerEc.longconnection.ChannelException;
import com.kwad.components.offline.api.core.adInnerEc.longconnection.ClientException;
import com.kwad.components.offline.api.core.adInnerEc.longconnection.LiveLongConnectionServerException;
import com.kwad.components.offline.api.core.adInnerEc.longconnection.listener.LongConnectStatusListener;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_06_4659cls.dex */
public class d implements LongConnectStatusListener {
    @Override // com.kwad.components.offline.api.core.adInnerEc.longconnection.listener.LongConnectStatusListener
    public void onChannelException(ChannelException channelException) {
    }

    @Override // com.kwad.components.offline.api.core.adInnerEc.longconnection.listener.LongConnectStatusListener
    public void onClientException(ClientException clientException) {
    }

    @Override // com.kwad.components.offline.api.core.adInnerEc.longconnection.listener.LongConnectStatusListener
    public void onConnectionEstablished() {
    }

    @Override // com.kwad.components.offline.api.core.adInnerEc.longconnection.listener.LongConnectStatusListener
    public void onConnectionExit() {
    }

    @Override // com.kwad.components.offline.api.core.adInnerEc.longconnection.listener.LongConnectStatusListener
    public void onConnectionHorseRaceFail(long j) {
    }

    @Override // com.kwad.components.offline.api.core.adInnerEc.longconnection.listener.LongConnectStatusListener
    public void onConnectionHorseRaceStart() {
    }

    @Override // com.kwad.components.offline.api.core.adInnerEc.longconnection.listener.LongConnectStatusListener
    public void onConnectionHorseRaceSuccess(String str, long j) {
    }

    @Override // com.kwad.components.offline.api.core.adInnerEc.longconnection.listener.LongConnectStatusListener
    public void onConnectionInterrupt() {
    }

    @Override // com.kwad.components.offline.api.core.adInnerEc.longconnection.listener.LongConnectStatusListener
    public void onConnectionStart() {
    }

    @Override // com.kwad.components.offline.api.core.adInnerEc.longconnection.listener.LongConnectStatusListener
    public void onEnterRoomSend(long j) {
    }

    @Override // com.kwad.components.offline.api.core.adInnerEc.longconnection.listener.LongConnectStatusListener
    public void onHeartbeatAckReceived(long j, long j2) {
    }

    @Override // com.kwad.components.offline.api.core.adInnerEc.longconnection.listener.LongConnectStatusListener
    public void onHeartbeatSend(long j) {
    }

    @Override // com.kwad.components.offline.api.core.adInnerEc.longconnection.listener.LongConnectStatusListener
    public void onReconnectOverMaxRetryCount() {
    }

    @Override // com.kwad.components.offline.api.core.adInnerEc.longconnection.listener.LongConnectStatusListener
    public void onServerException(LiveLongConnectionServerException liveLongConnectionServerException) {
    }
}

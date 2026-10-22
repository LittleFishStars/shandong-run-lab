package com.kwad.components.offline.api.core.adInnerEc.longconnection.listener;

import androidx.annotation.Keep;
import com.kwad.components.offline.api.core.adInnerEc.longconnection.ChannelException;
import com.kwad.components.offline.api.core.adInnerEc.longconnection.ClientException;
import com.kwad.components.offline.api.core.adInnerEc.longconnection.LiveLongConnectionServerException;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_06_4659cls.dex */
@Keep
public interface LongConnectStatusListener {
    void onChannelException(ChannelException channelException);

    void onClientException(ClientException clientException);

    void onConnectionEstablished();

    void onConnectionExit();

    void onConnectionHorseRaceFail(long j);

    void onConnectionHorseRaceStart();

    void onConnectionHorseRaceSuccess(String str, long j);

    void onConnectionInterrupt();

    void onConnectionStart();

    void onEnterRoomSend(long j);

    void onHeartbeatAckReceived(long j, long j2);

    void onHeartbeatSend(long j);

    void onReconnectOverMaxRetryCount();

    void onServerException(LiveLongConnectionServerException liveLongConnectionServerException);
}

package com.kwad.components.offline.api.core.adInnerEc.longconnection;

import androidx.annotation.Keep;
import com.kwad.components.offline.api.core.adInnerEc.longconnection.listener.LongConnectStatusListener;
import com.kwad.components.offline.api.core.adInnerEc.longconnection.listener.SCMessageListener;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_06_4659cls.dex */
@Keep
public interface ILiveLongConnection {
    void attached();

    void detached();

    void disconnect();

    void init();

    void registerLongConnectStatusListener(LongConnectStatusListener longConnectStatusListener);

    void registerSCMessageListener(SCMessageListener sCMessageListener);

    void release();

    void resume();

    void unregisterLongConnectStatusListener(LongConnectStatusListener longConnectStatusListener);

    void unregisterSCMessageListener(SCMessageListener sCMessageListener);

    boolean updateSocketData(String str);

    boolean updateStartPlayData(String str);
}

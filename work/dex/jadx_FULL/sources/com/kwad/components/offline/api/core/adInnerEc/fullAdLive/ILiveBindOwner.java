package com.kwad.components.offline.api.core.adInnerEc.fullAdLive;

import com.kwad.components.offline.api.core.adInnerEc.longconnection.ILiveLongConnection;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_06_4659cls.dex */
public interface ILiveBindOwner {
    IHostLivePlayer getLivePlayer();

    ILiveLongConnection getLongConnection();

    void release();
}

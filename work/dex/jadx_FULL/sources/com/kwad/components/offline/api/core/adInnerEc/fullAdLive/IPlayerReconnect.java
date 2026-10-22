package com.kwad.components.offline.api.core.adInnerEc.fullAdLive;

import androidx.annotation.Keep;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_06_4659cls.dex */
@Keep
public interface IPlayerReconnect {
    void fetchDataSource(int i, String str, String str2, ILiveFetchCallback iLiveFetchCallback);

    void stopReconnect();
}

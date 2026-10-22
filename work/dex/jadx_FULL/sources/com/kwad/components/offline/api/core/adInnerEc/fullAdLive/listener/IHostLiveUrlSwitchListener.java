package com.kwad.components.offline.api.core.adInnerEc.fullAdLive.listener;

import androidx.annotation.Keep;
import androidx.annotation.NonNull;
import com.kwad.components.offline.api.core.adInnerEc.fullAdLive.info.HostLiveUrlSwitchReason;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_06_4659cls.dex */
@Keep
public interface IHostLiveUrlSwitchListener {
    void onUrlSwitchFail(@NonNull HostLiveUrlSwitchReason hostLiveUrlSwitchReason);

    void onUrlSwitchSuccess(@NonNull HostLiveUrlSwitchReason hostLiveUrlSwitchReason);
}

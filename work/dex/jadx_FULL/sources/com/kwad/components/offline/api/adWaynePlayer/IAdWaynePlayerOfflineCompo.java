package com.kwad.components.offline.api.adWaynePlayer;

import com.kwad.components.offline.api.IOfflineCompo;
import com.kwad.components.offline.api.core.adWaynePlayer.IAdWaynePlayerPlayModule;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_06_4659cls.dex */
public interface IAdWaynePlayerOfflineCompo extends IOfflineCompo<IAdWaynePlayerOfflineCompoInitConfig> {
    public static final String IMPL = "com.kwad.sdk.AdWaynePlayerOfflineCompoImpl";
    public static final String PACKAGE_NAME = "com.kwad.components.adWaynePlayer";

    public enum AdWaynePlayerState {
        READY,
        SO_FAIL
    }

    IAdWaynePlayerPlayModule getAdWaynePlayerPlayModule(String str, boolean z);

    AdWaynePlayerState getState();
}

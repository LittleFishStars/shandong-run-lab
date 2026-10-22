package com.kwad.components.offline.api.adInnerEc;

import com.kwad.components.offline.api.IOfflineCompo;
import com.kwad.components.offline.api.core.adInnerEc.IAdInnerEcExternalModule;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_06_4659cls.dex */
public interface IAdInnerEcOfflineCompo extends IOfflineCompo<IAdInnerEcOfflineCompoInitConfig> {
    public static final String IMPL = "com.kwad.sdk.AdInnerEcOfflineCompoImpl";
    public static final String PACKAGE_NAME = "com.kwad.components.adInnerEc";

    public enum AdInnerEcState {
        READY,
        SO_FAIL
    }

    IAdInnerEcExternalModule getAdInnerEcExternalModule();

    AdInnerEcState getState();
}

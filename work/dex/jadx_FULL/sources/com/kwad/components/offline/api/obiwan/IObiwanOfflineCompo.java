package com.kwad.components.offline.api.obiwan;

import com.kwad.components.offline.api.IOfflineCompo;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_06_4659cls.dex */
public interface IObiwanOfflineCompo extends IOfflineCompo<IObiwanOfflineCompoInitConfig> {
    public static final String IMPL = "com.kwad.sdk.core.log.ObiwanOfflineCompoImpl";
    public static final String PACKAGE_NAME = "com.kwad.components.obiwan";

    IObiwanLogcat getLog();

    void updateConfigs();
}

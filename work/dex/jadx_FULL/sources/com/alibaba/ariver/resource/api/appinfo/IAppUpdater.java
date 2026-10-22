package com.alibaba.ariver.resource.api.appinfo;

import androidx.annotation.Nullable;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public interface IAppUpdater {
    void updateApp(UpdateAppParam updateAppParam, @Nullable UpdateAppCallback updateAppCallback);

    void updatePlugin(UpdatePluginParam updatePluginParam, @Nullable UpdatePluginCallback updatePluginCallback);
}

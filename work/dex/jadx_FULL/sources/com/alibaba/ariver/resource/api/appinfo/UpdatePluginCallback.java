package com.alibaba.ariver.resource.api.appinfo;

import com.alibaba.ariver.resource.api.models.PluginModel;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public interface UpdatePluginCallback {
    void onError(UpdateAppException updateAppException);

    void onSuccess(PluginModel pluginModel);
}

package com.alibaba.ariver.resource.api;

import com.alibaba.ariver.resource.api.models.PluginModel;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public interface PluginDownloadCallback {
    void onFailed(int i, String str);

    void onSingleFailed(PluginModel pluginModel, int i, String str);

    void onSuccess();
}

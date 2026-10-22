package com.alibaba.triver.resource;

import com.alibaba.ariver.kernel.common.Proxiable;
import com.alibaba.ariver.resource.api.models.PluginModel;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public interface PluginResourceDelegate extends Proxiable {
    String downloadApp(PluginModel pluginModel);

    String downloadAppAsync(PluginModel pluginModel, c cVar);

    String getInstallPath(PluginModel pluginModel);

    boolean isAvailable(PluginModel pluginModel);
}

package com.alibaba.ariver.resource.api.proxy;

import androidx.annotation.Nullable;
import com.alibaba.ariver.kernel.common.Proxiable;
import com.alibaba.ariver.resource.api.PluginDownloadCallback;
import com.alibaba.ariver.resource.api.PluginInstallCallback;
import com.alibaba.ariver.resource.api.models.PluginModel;
import java.util.List;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public interface RVPluginResourceManager extends Proxiable {
    void downloadPlugins(List<PluginModel> list, @Nullable PluginDownloadCallback pluginDownloadCallback);

    String getInstallPath(PluginModel pluginModel);

    PluginModel getRequiredPlugin(String str, String str2);

    void installPlugins(List<PluginModel> list, @Nullable PluginInstallCallback pluginInstallCallback);

    boolean isAvailable(List<PluginModel> list);

    void savePluginModelList(List<PluginModel> list);
}

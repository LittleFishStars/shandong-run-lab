package com.alibaba.triver.open.impl;

import android.text.TextUtils;
import com.alibaba.ariver.app.api.App;
import com.alibaba.ariver.kernel.api.node.NodeAware;
import com.alibaba.ariver.permission.api.extension.OfficialAppPoint;
import com.alibaba.ariver.resource.api.models.AppModel;
import com.alibaba.ariver.resource.api.models.DynamicPluginInfo;
import com.alibaba.ariver.resource.api.models.PluginModel;
import java.lang.ref.WeakReference;
import java.util.List;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public class OfficialAppImpl implements NodeAware<App>, OfficialAppPoint {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private App f25058a;

    @Override // com.alibaba.ariver.kernel.api.node.NodeAware
    public Class<App> getNodeType() {
        return App.class;
    }

    @Override // com.alibaba.ariver.permission.api.extension.OfficialAppPoint
    public boolean isOfficial(String str) {
        AppModel appModel;
        App app = this.f25058a;
        if (app == null || (appModel = (AppModel) app.getData(AppModel.class)) == null) {
            return false;
        }
        if (appModel.getExtendInfos() != null && !"true".equals(appModel.getExtendInfos().getString("official"))) {
            return false;
        }
        if (!TextUtils.equals(appModel.getAppId(), str) && !TextUtils.isEmpty(str)) {
            List<PluginModel> plugins = appModel.getAppInfoModel().getPlugins();
            if (plugins != null) {
                for (PluginModel pluginModel : plugins) {
                    if (TextUtils.equals(pluginModel.getAppId(), str)) {
                        return pluginModel.getExtendInfo() != null && "true".equals(pluginModel.getExtendInfo().getString("official"));
                    }
                }
            }
            DynamicPluginInfo dynamicPluginInfo = (DynamicPluginInfo) this.f25058a.getData(DynamicPluginInfo.class);
            if (dynamicPluginInfo != null && dynamicPluginInfo.getPluginModels() != null) {
                for (PluginModel pluginModel2 : dynamicPluginInfo.getPluginModels()) {
                    if (TextUtils.equals(pluginModel2.getAppId(), str)) {
                        return pluginModel2.getExtendInfo() != null && "true".equals(pluginModel2.getExtendInfo().getString("official"));
                    }
                }
            }
        }
        return appModel.getExtendInfos() != null && "true".equals(appModel.getExtendInfos().getString("official"));
    }

    @Override // com.alibaba.ariver.kernel.api.extension.Extension
    public void onFinalized() {
    }

    @Override // com.alibaba.ariver.kernel.api.extension.Extension
    public void onInitialized() {
    }

    @Override // com.alibaba.ariver.kernel.api.node.NodeAware
    public void setNode(WeakReference<App> weakReference) {
        this.f25058a = weakReference.get();
    }
}

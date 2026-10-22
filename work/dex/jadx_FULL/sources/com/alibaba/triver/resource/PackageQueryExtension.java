package com.alibaba.triver.resource;

import com.alibaba.ariver.resource.api.ResourceContext;
import com.alibaba.ariver.resource.api.content.ResourcePackage;
import com.alibaba.ariver.resource.api.extension.PackageQueryPoint;
import com.alibaba.ariver.resource.api.models.PluginModel;
import com.alibaba.triver.kit.api.common.TRiverConstants;
import com.alibaba.triver.utils.CommonUtils;
import java.util.Set;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public class PackageQueryExtension implements PackageQueryPoint {
    @Override // com.alibaba.ariver.resource.api.extension.PackageQueryPoint
    public ResourcePackage createPluginPackage(PluginModel pluginModel, ResourceContext resourceContext) {
        return new f(pluginModel, resourceContext);
    }

    @Override // com.alibaba.ariver.resource.api.extension.PackageQueryPoint
    public ResourcePackage getMainPackage(ResourceContext resourceContext) {
        return (!CommonUtils.isApkDebug() || resourceContext.getSceneParams() == null || resourceContext.getSceneParams().getSerializable(TRiverConstants.KEY_LOCAL_DEBUG_INFO) == null) ? new h(resourceContext) : new com.alibaba.triver.resource.debug.b(resourceContext.getAppId(), resourceContext);
    }

    @Override // com.alibaba.ariver.resource.api.extension.PackageQueryPoint
    public Set<ResourcePackage> getResourcePackages(ResourceContext resourceContext) {
        return null;
    }

    @Override // com.alibaba.ariver.kernel.api.extension.Extension
    public void onFinalized() {
    }

    @Override // com.alibaba.ariver.kernel.api.extension.Extension
    public void onInitialized() {
    }
}

package com.alibaba.ariver.resource.api.extension;

import com.alibaba.ariver.kernel.api.annotation.AutoExtension;
import com.alibaba.ariver.kernel.api.extension.Extension;
import com.alibaba.ariver.resource.api.ResourceContext;
import com.alibaba.ariver.resource.api.content.ResourcePackage;
import com.alibaba.ariver.resource.api.models.PluginModel;
import java.util.Set;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
@AutoExtension
public interface PackageQueryPoint extends Extension {
    ResourcePackage createPluginPackage(PluginModel pluginModel, ResourceContext resourceContext);

    ResourcePackage getMainPackage(ResourceContext resourceContext);

    Set<ResourcePackage> getResourcePackages(ResourceContext resourceContext);
}

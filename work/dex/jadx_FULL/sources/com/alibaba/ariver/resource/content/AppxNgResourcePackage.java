package com.alibaba.ariver.resource.content;

import androidx.annotation.NonNull;
import com.alibaba.ariver.engine.api.resources.Resource;
import com.alibaba.ariver.kernel.RVConstants;
import com.alibaba.ariver.kernel.common.utils.RVLogger;
import com.alibaba.ariver.resource.api.ResourceContext;
import com.alibaba.ariver.resource.api.content.ResourceQuery;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public class AppxNgResourcePackage extends NormalResourcePackage {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final String f24438a = "https://appx-ng/";

    public AppxNgResourcePackage(ResourceContext resourceContext) {
        super(RVConstants.TINY_APPX_NG_APPID, resourceContext);
    }

    @Override // com.alibaba.ariver.resource.content.NormalResourcePackage, com.alibaba.ariver.resource.content.BaseResourcePackage
    public boolean canHotUpdate(String str) {
        if (count() != 0 && this.mSetupLock.getCount() != 1) {
            return false;
        }
        RVLogger.d(getLogTag(), "canHotUpdate true because no content || mSetupLock.count() == 1");
        return true;
    }

    @Override // com.alibaba.ariver.resource.content.NormalResourcePackage, com.alibaba.ariver.resource.content.BaseStoragePackage, com.alibaba.ariver.resource.api.content.ResourcePackage
    public Resource get(@NonNull ResourceQuery resourceQuery) {
        Resource resource = super.get(resourceQuery);
        if (resourceQuery.pureUrl.startsWith(f24438a) && resource != null) {
            RVLogger.d("AppxNgResourcePackage", "appx-ng get url\t" + resourceQuery.pureUrl + "\t " + version());
        }
        return resource;
    }

    @Override // com.alibaba.ariver.resource.content.BaseResourcePackage, com.alibaba.ariver.resource.api.content.ResourcePackage
    public boolean needWaitForSetup() {
        return true;
    }

    @Override // com.alibaba.ariver.resource.content.NormalResourcePackage, com.alibaba.ariver.resource.content.BaseStoragePackage
    public boolean needWaitSetupWhenGet() {
        return true;
    }
}

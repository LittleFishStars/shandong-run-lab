package com.alibaba.ariver.resource.content;

import android.content.Intent;
import androidx.localbroadcastmanager.content.LocalBroadcastManager;
import com.alibaba.ariver.kernel.RVConstants;
import com.alibaba.ariver.kernel.common.RVProxy;
import com.alibaba.ariver.kernel.common.service.RVEnvironmentService;
import com.alibaba.ariver.kernel.common.utils.RVLogger;
import com.alibaba.ariver.resource.api.ResourceContext;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public class AppxResourcePackage extends NormalResourcePackage {
    public AppxResourcePackage(ResourceContext resourceContext) {
        super(RVConstants.TINY_WEB_COMMON_APPID, resourceContext);
    }

    @Override // com.alibaba.ariver.resource.content.NormalResourcePackage, com.alibaba.ariver.resource.content.BaseResourcePackage
    public boolean canHotUpdate(String str) {
        if (count() != 0 && this.mSetupLock.getCount() != 1) {
            return false;
        }
        RVLogger.d(getLogTag(), "canHotUpdate true because no content || mSetupLock.count() == 1");
        return true;
    }

    @Override // com.alibaba.ariver.resource.content.BaseResourcePackage, com.alibaba.ariver.resource.api.content.ResourcePackage
    public boolean needWaitForSetup() {
        return true;
    }

    @Override // com.alibaba.ariver.resource.content.NormalResourcePackage, com.alibaba.ariver.resource.content.BaseStoragePackage
    public boolean needWaitSetupWhenGet() {
        return true;
    }

    @Override // com.alibaba.ariver.resource.content.BaseResourcePackage, com.alibaba.ariver.resource.content.BaseStoragePackage
    public void onPrepareDone() {
        super.onPrepareDone();
        Intent intent = new Intent(RVConstants.ACTION_APPX_PARSED);
        intent.putExtra("appxVersion", version());
        LocalBroadcastManager.getInstance(((RVEnvironmentService) RVProxy.get(RVEnvironmentService.class)).getApplicationContext()).sendBroadcast(intent);
    }
}

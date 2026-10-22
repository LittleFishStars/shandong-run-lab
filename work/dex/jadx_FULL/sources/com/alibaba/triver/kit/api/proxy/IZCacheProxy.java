package com.alibaba.triver.kit.api.proxy;

import android.os.Bundle;
import com.alibaba.ariver.kernel.api.annotation.Remote;
import com.alibaba.ariver.kernel.api.annotation.ThreadType;
import com.alibaba.ariver.kernel.api.extension.Extension;
import com.alibaba.ariver.kernel.common.Proxiable;
import com.alibaba.ariver.kernel.common.service.executor.ExecutorType;
import com.alibaba.ariver.resource.api.models.AppModel;
import com.alibaba.ariver.resource.api.models.PluginModel;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public interface IZCacheProxy extends Proxiable {

    public interface ZCachePoint extends Extension {
        @ThreadType(ExecutorType.SYNC)
        String getMiniAppFilePath(String str, String str2);

        @ThreadType(ExecutorType.SYNC)
        void syncSubProcessConfig();
    }

    @Remote
    public interface ZCachePointRemote extends Extension {
        @ThreadType(ExecutorType.SYNC)
        String getMiniAppFilePathRemote(String str, String str2);

        @ThreadType(ExecutorType.SYNC)
        void removeAZCacheRemote(String str);

        @ThreadType(ExecutorType.SYNC)
        Bundle updatePackRemote(String str, String str2, int i);
    }

    @ThreadType(ExecutorType.SYNC)
    String getMiniAppFilePath(String str, String str2);

    @ThreadType(ExecutorType.SYNC)
    String getMiniAppFilePathRemote(String str, String str2);

    @ThreadType(ExecutorType.SYNC)
    boolean isZCacheOpenByAppKey(String str);

    @ThreadType(ExecutorType.SYNC)
    void removeAZCacheRemote(String str);

    @ThreadType(ExecutorType.SYNC)
    void setConfig(boolean z, String str);

    @ThreadType(ExecutorType.SYNC)
    void syncSubProcessConfig();

    @ThreadType(ExecutorType.SYNC)
    Bundle updatePackRemote(String str, String str2, int i);

    @ThreadType(ExecutorType.SYNC)
    void updatePackRemoteDiscOnly(AppModel appModel);

    @ThreadType(ExecutorType.SYNC)
    void updatePackRemoteDiscOnly(PluginModel pluginModel);
}

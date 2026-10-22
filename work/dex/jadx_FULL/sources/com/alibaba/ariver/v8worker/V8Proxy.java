package com.alibaba.ariver.v8worker;

import android.os.Bundle;
import android.os.Handler;
import androidx.annotation.Nullable;
import com.alibaba.ariver.engine.api.Render;
import com.alibaba.ariver.kernel.common.Proxiable;
import com.alipay.mobile.jsengine.Delegate;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public interface V8Proxy extends Proxiable {
    void addAssociatedThread(String str);

    Delegate generateDelegate();

    int getAllowCreatedWorkerMaxCount();

    @Nullable
    Handler getDispatchHandler(String str);

    String getPackageName();

    String getSessionId(Render render);

    String[] getV8PluginNameList(String str, Bundle bundle);

    String getWebViewCoreSoPath();

    boolean hasSyncApiPermission(String str);

    int quickVerifyWebViewCoreSo(String str);

    boolean removeWebViewCore();

    boolean unzipWebViewCoreSo();
}

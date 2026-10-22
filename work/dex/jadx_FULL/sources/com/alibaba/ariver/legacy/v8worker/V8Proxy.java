package com.alibaba.ariver.legacy.v8worker;

import android.os.Bundle;
import com.alibaba.ariver.kernel.common.Proxiable;
import com.alipay.mobile.jsengine.Delegate;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public interface V8Proxy extends Proxiable {
    Delegate generateDelegate();

    byte[] getMultiWorkerJS();

    byte[] getV8JS();

    String[] getV8PluginNameList(String str, Bundle bundle);
}

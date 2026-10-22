package com.alibaba.ariver.engine.api.proxy;

import android.os.Bundle;
import com.alibaba.ariver.kernel.api.annotation.DefaultImpl;
import com.alibaba.ariver.kernel.common.Proxiable;
import com.alibaba.fastjson.JSONObject;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
@DefaultImpl("com.alibaba.ariver.integration.proxy.impl.DefaultJsApiHandlerProxyImpl")
public interface RVJSApiHandlerProxy extends Proxiable {
    int getSyncTimeout(String str, Bundle bundle, JSONObject jSONObject);
}

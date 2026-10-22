package com.alibaba.ariver.jsapi.rpc;

import com.alibaba.ariver.app.api.Page;
import com.alibaba.ariver.engine.api.bridge.extension.BridgeCallback;
import com.alibaba.ariver.kernel.common.Proxiable;
import com.alibaba.fastjson.JSONObject;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public interface RpcExceptionHandleProxy extends Proxiable {
    boolean handledRpcException(Page page, JSONObject jSONObject, JSONObject jSONObject2, BridgeCallback bridgeCallback, Throwable th);
}

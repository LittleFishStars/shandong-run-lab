package com.alibaba.ariver.engine.common.track;

import com.alibaba.ariver.engine.api.bridge.model.NativeCallContext;
import com.alibaba.ariver.kernel.api.annotation.DefaultImpl;
import com.alibaba.ariver.kernel.common.Proxiable;
import com.alibaba.fastjson.JSONObject;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
@DefaultImpl("com.alibaba.ariver.engine.common.track.DefaultJSAPIEventTracker")
public interface JSAPIEventTrackerProxy extends Proxiable {
    void trackKeyJSAPIInvoke(NativeCallContext nativeCallContext);

    void trackKeyJSAPIResult(NativeCallContext nativeCallContext, JSONObject jSONObject);
}

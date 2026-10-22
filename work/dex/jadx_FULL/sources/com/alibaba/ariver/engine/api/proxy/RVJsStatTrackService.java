package com.alibaba.ariver.engine.api.proxy;

import com.alibaba.ariver.engine.api.bridge.model.NativeCallContext;
import com.alibaba.ariver.kernel.api.node.Node;
import com.alibaba.ariver.kernel.common.Proxiable;
import java.util.Map;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public interface RVJsStatTrackService extends Proxiable {
    void onCallDispatch(NativeCallContext nativeCallContext);

    void onInvoke(NativeCallContext nativeCallContext);

    void onSendBack(NativeCallContext nativeCallContext);

    void writeJsApiStatToMap(Node node, Map<String, String> map);
}

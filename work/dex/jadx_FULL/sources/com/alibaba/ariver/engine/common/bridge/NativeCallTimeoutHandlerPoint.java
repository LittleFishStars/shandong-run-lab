package com.alibaba.ariver.engine.common.bridge;

import com.alibaba.ariver.engine.api.bridge.BridgeResponseHelper;
import com.alibaba.ariver.engine.api.bridge.model.NativeCallContext;
import com.alibaba.ariver.kernel.api.annotation.AutoExtension;
import com.alibaba.ariver.kernel.api.extension.Extension;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
@AutoExtension
public interface NativeCallTimeoutHandlerPoint extends Extension {
    void monitorTimeout(NativeCallContext nativeCallContext, BridgeResponseHelper bridgeResponseHelper);

    void removeMonitor(NativeCallContext nativeCallContext);
}

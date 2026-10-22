package com.alibaba.ariver.engine.api.bridge;

import com.alibaba.ariver.engine.api.bridge.model.RenderCallContext;
import com.alibaba.ariver.engine.api.bridge.model.SendToRenderCallback;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public interface RenderBridge {
    void sendToRender(RenderCallContext renderCallContext, SendToRenderCallback sendToRenderCallback);

    void sendToRender(RenderCallContext renderCallContext, SendToRenderCallback sendToRenderCallback, boolean z);

    SendToRenderCallback takeCallback(String str);
}

package com.alibaba.triver.impl;

import android.text.TextUtils;
import com.alibaba.ariver.app.api.App;
import com.alibaba.ariver.engine.BaseEngineImpl;
import com.alibaba.ariver.engine.api.EngineFactory;
import com.alibaba.ariver.engine.api.RVEngine;
import com.alibaba.ariver.kernel.api.node.Node;
import com.alibaba.ariver.kernel.common.utils.RVLogger;
import com.alibaba.triver.engine.d;
import com.alibaba.triver.kit.api.common.TRiverConstants;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public class TriverEngineFactory implements EngineFactory {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final String f24968a = "TriverEngineFactory";

    public RVEngine createDefaultEngine(Node node, String str) {
        return new d(str, node);
    }

    @Override // com.alibaba.ariver.engine.api.EngineFactory
    public RVEngine createEngine(String str, Node node, String str2) {
        RVLogger.d(f24968a, "createEngine " + str);
        if (node instanceof App) {
            App app = (App) node;
            if (app.getStartParams() != null) {
                if (!TextUtils.equals("true", app.getStartParams().getString(TRiverConstants.KEY_IS_CANAL))) {
                    return createDefaultEngine(node, str2);
                }
                try {
                    return (BaseEngineImpl) Class.forName("com.alibaba.triver.cannal_engine.engine.TRCanalEngineImpl").getConstructor(String.class, Node.class).newInstance(str2, node);
                } catch (Throwable th) {
                    RVLogger.e(f24968a, th);
                    return null;
                }
            }
        }
        return createDefaultEngine(node, str2);
    }

    @Override // com.alibaba.ariver.engine.api.EngineFactory
    public String getEngineType(String str) {
        return "TINY";
    }
}

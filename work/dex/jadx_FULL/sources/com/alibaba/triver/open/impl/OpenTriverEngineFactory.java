package com.alibaba.triver.open.impl;

import com.alibaba.ariver.engine.api.RVEngine;
import com.alibaba.ariver.kernel.api.node.Node;
import com.alibaba.triver.impl.TriverEngineFactory;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public class OpenTriverEngineFactory extends TriverEngineFactory {
    @Override // com.alibaba.triver.impl.TriverEngineFactory
    public RVEngine createDefaultEngine(Node node, String str) {
        return new a(str, node);
    }
}

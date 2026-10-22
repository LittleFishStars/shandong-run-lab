package com.alibaba.ariver.engine.api;

import com.alibaba.ariver.kernel.api.node.Node;
import com.alibaba.ariver.kernel.common.Proxiable;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public interface EngineFactory extends Proxiable {
    RVEngine createEngine(String str, Node node, String str2);

    String getEngineType(String str);
}

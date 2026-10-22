package com.alibaba.ariver.engine.api.extensions;

import com.alibaba.ariver.kernel.api.annotation.AutoExtension;
import com.alibaba.ariver.kernel.api.extension.Extension;
import com.alibaba.ariver.kernel.api.node.Node;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
@AutoExtension
public interface WorkerCreateConfigPoint extends Extension {
    boolean isAsyncCreateWorker(Node node, String str, String str2);
}

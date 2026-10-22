package com.alibaba.ariver.engine.api.embedview;

import androidx.annotation.Nullable;
import com.alibaba.ariver.kernel.api.annotation.DefaultImpl;
import com.alibaba.ariver.kernel.api.node.Node;
import com.alibaba.ariver.kernel.common.Proxiable;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
@DefaultImpl("com.alibaba.ariver.integration.embedview.DefaultEmbedViewProvider")
public interface EmbedViewProvider extends Proxiable {
    IEmbedView createEmbedView(String str, @Nullable Node node);
}

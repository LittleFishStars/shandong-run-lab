package com.alibaba.ariver.app.api.service;

import androidx.annotation.Nullable;
import com.alibaba.ariver.app.api.App;
import com.alibaba.ariver.app.api.Page;
import com.alibaba.ariver.kernel.common.Proxiable;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public interface TinyAppInnerProxy extends Proxiable {
    boolean isEmbedWebViewInnerAppBlack(@Nullable Page page);

    boolean isInner(App app);
}

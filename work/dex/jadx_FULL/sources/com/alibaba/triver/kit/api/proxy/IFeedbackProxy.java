package com.alibaba.triver.kit.api.proxy;

import android.content.Context;
import com.alibaba.ariver.kernel.api.annotation.DefaultImpl;
import com.alibaba.ariver.kernel.common.Proxiable;
import com.alibaba.triver.kit.api.Page;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
@DefaultImpl("com.alibaba.triver.kit.api.proxy.impl.DefaultFeedbackProxyImpl")
public interface IFeedbackProxy extends Proxiable {
    void openFeedback(Context context, Page page);
}

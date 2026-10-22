package com.alibaba.triver.kit.api.proxy;

import android.content.Context;
import android.os.Bundle;
import com.alibaba.ariver.kernel.api.annotation.DefaultImpl;
import com.alibaba.ariver.kernel.common.Proxiable;
import com.alibaba.triver.kit.api.Page;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
@DefaultImpl("com.alibaba.triver.kit.api.proxy.impl.DefaultRouterProxyImpl")
public interface IRouterProxy extends Proxiable {
    void openURL(Context context, Page page, String str, Bundle bundle, Bundle bundle2);
}

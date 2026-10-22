package com.alibaba.triver.open.proxy;

import android.content.Context;
import android.os.Bundle;
import com.alibaba.triver.kit.api.Page;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public interface IRouterProxy extends com.alibaba.triver.kit.api.proxy.IRouterProxy {
    void downgrade(Context context, Page page, String str, int i);

    void popToHome(Context context, Page page, Bundle bundle);
}

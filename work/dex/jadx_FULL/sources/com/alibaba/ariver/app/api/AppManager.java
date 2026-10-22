package com.alibaba.ariver.app.api;

import android.os.Bundle;
import com.alibaba.ariver.kernel.api.annotation.DefaultImpl;
import com.alibaba.ariver.kernel.api.node.Node;
import com.alibaba.ariver.kernel.common.Proxiable;
import java.util.Stack;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
@DefaultImpl("com.alibaba.ariver.app.AppManagerImpl")
public interface AppManager extends Node, Proxiable {
    void exitApp(long j);

    App findApp(long j);

    App findAppByToken(long j);

    Stack<App> getAppStack();

    App preCreateApp(String str, Bundle bundle, Bundle bundle2);

    App startApp(String str, Bundle bundle, Bundle bundle2);
}

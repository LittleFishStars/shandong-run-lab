package com.alibaba.ariver.remotedebug.extension;

import com.alibaba.ariver.app.api.App;
import com.alibaba.ariver.kernel.api.extension.Extension;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public interface RemoteDebugStatePoint extends Extension {
    boolean onDisconnected(App app);
}

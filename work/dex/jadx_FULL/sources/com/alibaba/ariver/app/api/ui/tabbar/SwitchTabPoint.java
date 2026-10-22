package com.alibaba.ariver.app.api.ui.tabbar;

import com.alibaba.ariver.app.api.App;
import com.alibaba.ariver.kernel.api.annotation.ThreadType;
import com.alibaba.ariver.kernel.api.extension.Extension;
import com.alibaba.ariver.kernel.common.service.executor.ExecutorType;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public interface SwitchTabPoint extends Extension {
    @ThreadType(ExecutorType.UI)
    void onSwitchTab(App app, int i);
}

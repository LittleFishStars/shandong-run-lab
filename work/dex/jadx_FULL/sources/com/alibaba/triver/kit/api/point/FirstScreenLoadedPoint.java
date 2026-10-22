package com.alibaba.triver.kit.api.point;

import com.alibaba.ariver.app.api.App;
import com.alibaba.ariver.app.api.Page;
import com.alibaba.ariver.kernel.api.extension.Extension;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public interface FirstScreenLoadedPoint extends Extension {
    void onScreenAppLoaded(App app);

    boolean onScreenPageLoaded(Page page);
}

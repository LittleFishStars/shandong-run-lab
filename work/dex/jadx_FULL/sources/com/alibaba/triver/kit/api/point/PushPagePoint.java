package com.alibaba.triver.kit.api.point;

import com.alibaba.ariver.app.api.Page;
import com.alibaba.ariver.kernel.api.extension.Extension;
import com.alibaba.triver.kit.api.TinyApp;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public interface PushPagePoint extends Extension {
    boolean navigateToMiniProgram(Page page, String str);

    boolean pushPage(Page page, String str);

    boolean switchTab(TinyApp tinyApp, String str);
}

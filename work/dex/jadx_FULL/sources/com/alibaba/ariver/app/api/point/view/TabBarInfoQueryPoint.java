package com.alibaba.ariver.app.api.point.view;

import com.alibaba.ariver.app.api.ui.tabbar.model.TabBarModel;
import com.alibaba.ariver.kernel.api.annotation.AutoExtension;
import com.alibaba.ariver.kernel.api.extension.Extension;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
@AutoExtension
public interface TabBarInfoQueryPoint extends Extension {

    public interface OnTabBarInfoQueryListener {
        void onTabInfoGot(TabBarModel tabBarModel);
    }

    void queryTabBarInfo(OnTabBarInfoQueryListener onTabBarInfoQueryListener);
}

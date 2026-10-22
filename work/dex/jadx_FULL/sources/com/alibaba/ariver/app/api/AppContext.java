package com.alibaba.ariver.app.api;

import android.content.Context;
import android.content.Intent;
import com.alibaba.ariver.app.api.ui.FontBar;
import com.alibaba.ariver.app.api.ui.ViewSpecProvider;
import com.alibaba.ariver.app.api.ui.loading.SplashView;
import com.alibaba.ariver.app.api.ui.tabbar.TabBar;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public interface AppContext {
    void createTabBar(Page page);

    void destroy();

    void exitPage(Page page, boolean z);

    Intent getActivityStartIntent();

    Context getContext();

    FontBar getFontBar();

    SplashView getSplashView();

    TabBar getTabBar();

    ViewSpecProvider getViewSpecProvider();

    boolean isTaskRoot();

    boolean moveToBackground();

    boolean pushPage(Page page);

    void start(Page page);
}

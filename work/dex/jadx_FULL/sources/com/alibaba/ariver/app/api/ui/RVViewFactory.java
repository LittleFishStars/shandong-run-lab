package com.alibaba.ariver.app.api.ui;

import android.content.Context;
import android.view.ViewGroup;
import com.alibaba.ariver.app.api.App;
import com.alibaba.ariver.app.api.Page;
import com.alibaba.ariver.app.api.ui.fragment.IFragmentManager;
import com.alibaba.ariver.app.api.ui.loading.LoadingView;
import com.alibaba.ariver.app.api.ui.tabbar.TabBar;
import com.alibaba.ariver.app.api.ui.titlebar.TitleBar;
import com.alibaba.ariver.kernel.common.Proxiable;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public interface RVViewFactory extends Proxiable {
    ErrorView createErrorView(Context context);

    LoadingView createLoadingView(Context context, Page page);

    PageContainer createPageContainer(Context context, App app, ViewGroup viewGroup);

    TabBar createTabBar(Context context, App app, IFragmentManager iFragmentManager, ViewGroup viewGroup);

    TitleBar createTitleBar(Context context, App app);

    void preload(Context context);
}

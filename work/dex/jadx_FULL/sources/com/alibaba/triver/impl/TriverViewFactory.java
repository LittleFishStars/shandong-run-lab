package com.alibaba.triver.impl;

import android.content.Context;
import android.view.ViewGroup;
import com.alibaba.ariver.app.api.App;
import com.alibaba.ariver.app.api.Page;
import com.alibaba.ariver.app.api.ui.ErrorView;
import com.alibaba.ariver.app.api.ui.PageContainer;
import com.alibaba.ariver.app.api.ui.RVViewFactory;
import com.alibaba.ariver.app.api.ui.fragment.IFragmentManager;
import com.alibaba.ariver.app.api.ui.loading.LoadingView;
import com.alibaba.ariver.app.api.ui.tabbar.TabBar;
import com.alibaba.ariver.app.api.ui.titlebar.TitleBar;
import com.alibaba.triver.content.b;
import com.alibaba.triver.content.c;
import com.alibaba.triver.content.d;
import com.alibaba.triver.content.e;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public class TriverViewFactory implements RVViewFactory {
    @Override // com.alibaba.ariver.app.api.ui.RVViewFactory
    public ErrorView createErrorView(Context context) {
        return new b(context);
    }

    @Override // com.alibaba.ariver.app.api.ui.RVViewFactory
    public LoadingView createLoadingView(Context context, Page page) {
        return new c(context, page);
    }

    @Override // com.alibaba.ariver.app.api.ui.RVViewFactory
    public PageContainer createPageContainer(Context context, App app, ViewGroup viewGroup) {
        return new com.alibaba.triver.container.b(context, app);
    }

    @Override // com.alibaba.ariver.app.api.ui.RVViewFactory
    public TabBar createTabBar(Context context, App app, IFragmentManager iFragmentManager, ViewGroup viewGroup) {
        if (viewGroup != null) {
            return new d(context, app, iFragmentManager, viewGroup);
        }
        return null;
    }

    @Override // com.alibaba.ariver.app.api.ui.RVViewFactory
    public TitleBar createTitleBar(Context context, App app) {
        return new e(context, app);
    }

    @Override // com.alibaba.ariver.app.api.ui.RVViewFactory
    public void preload(Context context) {
    }
}

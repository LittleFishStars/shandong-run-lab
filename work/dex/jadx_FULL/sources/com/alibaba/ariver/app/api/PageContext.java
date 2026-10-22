package com.alibaba.ariver.app.api;

import android.app.Activity;
import com.alibaba.ariver.app.api.ui.ErrorView;
import com.alibaba.ariver.app.api.ui.PageContainer;
import com.alibaba.ariver.app.api.ui.loading.LoadingView;
import com.alibaba.ariver.app.api.ui.titlebar.TitleBar;
import com.alibaba.ariver.engine.api.embedview.IEmbedViewManager;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public interface PageContext {
    void applyTransparentTitle(boolean z);

    void destroy();

    Activity getActivity();

    int getContentViewHeight();

    int getContentViewWidth();

    IEmbedViewManager getEmbedViewManager();

    ErrorView getErrorView();

    LoadingView getLoadingView();

    PageContainer getPageContainer();

    TitleBar getTitleBar();
}

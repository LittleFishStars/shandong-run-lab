package com.alibaba.ariver.integration.singlepage;

import android.app.Activity;
import androidx.annotation.Keep;
import com.alibaba.ariver.app.api.App;
import com.alibaba.ariver.app.api.PageContext;
import com.alibaba.ariver.app.api.ui.ErrorView;
import com.alibaba.ariver.app.api.ui.PageContainer;
import com.alibaba.ariver.app.api.ui.loading.LoadingView;
import com.alibaba.ariver.app.api.ui.titlebar.TitleBar;
import com.alibaba.ariver.engine.api.embedview.IEmbedViewManager;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
@Keep
public class SinglePageContext implements PageContext {
    private Activity mActivity;

    public SinglePageContext(App app, Activity activity) {
        this.mActivity = activity;
    }

    @Override // com.alibaba.ariver.app.api.PageContext
    public void applyTransparentTitle(boolean z) {
    }

    @Override // com.alibaba.ariver.app.api.PageContext
    public void destroy() {
    }

    @Override // com.alibaba.ariver.app.api.PageContext
    public Activity getActivity() {
        return this.mActivity;
    }

    @Override // com.alibaba.ariver.app.api.PageContext
    public int getContentViewHeight() {
        return 0;
    }

    @Override // com.alibaba.ariver.app.api.PageContext
    public int getContentViewWidth() {
        return 0;
    }

    @Override // com.alibaba.ariver.app.api.PageContext
    public IEmbedViewManager getEmbedViewManager() {
        return null;
    }

    @Override // com.alibaba.ariver.app.api.PageContext
    public ErrorView getErrorView() {
        return null;
    }

    @Override // com.alibaba.ariver.app.api.PageContext
    public LoadingView getLoadingView() {
        return null;
    }

    @Override // com.alibaba.ariver.app.api.PageContext
    public PageContainer getPageContainer() {
        return null;
    }

    @Override // com.alibaba.ariver.app.api.PageContext
    public TitleBar getTitleBar() {
        return null;
    }
}

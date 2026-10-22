package com.alibaba.triver.app;

import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import com.alibaba.ariver.app.api.App;
import com.alibaba.ariver.app.api.model.AppConfigModel;
import com.alibaba.ariver.kernel.common.utils.RVLogger;
import com.alibaba.ariver.kernel.common.utils.UrlUtils;
import com.alibaba.triver.R;
import com.alibaba.triver.kit.api.Page;
import com.alibaba.triver.kit.api.TinyApp;
import com.alibaba.triver.kit.api.model.WindowInfoModel;
import com.alibaba.triver.triver_render.render.WMLTRWebView;
import com.alibaba.triver.utils.CommonUtils;
import com.alibaba.triver.utils.PageUtils;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public class g implements Page {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final String f24624a = "AriverTriver:TriverPageWrapper";
    private com.alibaba.ariver.app.api.Page b;
    private e c;

    public g(com.alibaba.ariver.app.api.Page page, e eVar) {
        this.b = page;
        this.c = eVar;
    }

    @Override // com.alibaba.triver.kit.api.Page
    public void applyTransparentTitle(boolean z) {
        this.b.getPageContext().applyTransparentTitle(z);
    }

    @Override // com.alibaba.triver.kit.api.Page
    public boolean canGoback() {
        com.alibaba.ariver.app.api.Page page = this.b;
        return (page == null || page.getApp() == null || this.b.getApp().getIndexOfChild(this.b) <= 0) ? false : true;
    }

    @Override // com.alibaba.triver.kit.api.Page
    public Bitmap captureView() {
        return com.alibaba.triver.triver_render.utils.b.b(this.b.getRender().getView());
    }

    @Override // com.alibaba.triver.kit.api.Page
    public TinyApp getApp() {
        return this.c;
    }

    @Override // com.alibaba.triver.kit.api.Page
    public int getIndex() {
        try {
            return this.b.getApp().getIndexOfChild(this.b);
        } catch (Exception e) {
            RVLogger.e("Triver:PageWrapper", "getIndex erro", e);
            return 0;
        }
    }

    @Override // com.alibaba.triver.kit.api.Page
    public String getPagePath() {
        return this.b.getPageURI();
    }

    @Override // com.alibaba.triver.kit.api.Page
    public Bundle getSceneParams() {
        return this.b.getSceneParams();
    }

    @Override // com.alibaba.triver.kit.api.Page
    public Bundle getStartParams() {
        return this.b.getStartParams();
    }

    @Override // com.alibaba.triver.kit.api.Page
    public WindowInfoModel getWindowInfo() {
        WindowInfoModel windowInfoModel = (WindowInfoModel) this.b.getData(WindowInfoModel.class);
        if (windowInfoModel != null) {
            return windowInfoModel;
        }
        WindowInfoModel windowInfoModelConvertWindowModel = CommonUtils.convertWindowModel(this.b.getStartParams());
        this.b.setData(WindowInfoModel.class, windowInfoModelConvertWindowModel);
        return windowInfoModelConvertWindowModel;
    }

    @Override // com.alibaba.triver.kit.api.Page
    public boolean isFirstTab() {
        com.alibaba.ariver.app.api.Page page = this.b;
        if (page == null || page.getApp() == null) {
            return false;
        }
        return (this.b.getApp().getAppContext() == null || this.b.getApp().getAppContext().getTabBar() == null) ? isHomePage() : PageUtils.isFirstTab(this.b.getApp().getAppContext().getTabBar().getTabbarModel(), this.b.getPageURI());
    }

    @Override // com.alibaba.triver.kit.api.Page
    public boolean isHomePage() {
        com.alibaba.ariver.app.api.Page page = this.b;
        if (page == null || page.getApp() == null) {
            return true;
        }
        if (this.b.getApp().getAppContext() == null || this.b.getApp().getAppContext().getTabBar() == null || !this.b.getApp().getAppContext().getTabBar().isTabPage(this.b)) {
            return PageUtils.isFirstPage((AppConfigModel) this.b.getApp().getData(AppConfigModel.class), this.b.getPageURI()) && !canGoback();
        }
        return true;
    }

    @Override // com.alibaba.triver.kit.api.Page
    public boolean isStartPage() {
        try {
            String queryParameter = Uri.parse(this.c.getStartUrl()).getQueryParameter("page");
            return !TextUtils.isEmpty(queryParameter) && TextUtils.equals(PageUtils.pageNameFilter(queryParameter), PageUtils.pageNameFilter(UrlUtils.getHash(this.b.getPageURI())));
        } catch (Exception unused) {
            return false;
        }
    }

    @Override // com.alibaba.triver.kit.api.Page
    public boolean isTabPage() {
        com.alibaba.ariver.app.api.Page page = this.b;
        return (page == null || page.getApp() == null || this.b.getApp().getAppContext() == null || this.b.getApp().getAppContext().getTabBar() == null) ? false : true;
    }

    @Override // com.alibaba.triver.kit.api.Page
    public void reload() {
        this.b.getRender().reload();
    }

    @Override // com.alibaba.triver.kit.api.Page
    public void scrollToTop() {
        View coreView;
        com.alibaba.ariver.app.api.Page page = this.b;
        if (page == null || page.getPageContext() == null || this.b.getPageContext().getPageContainer() == null || this.b.getPageContext().getPageContainer().getView() == null) {
            return;
        }
        Object objFindViewById = this.b.getPageContext().getPageContainer().getView().findViewById(R.id.triver_webview_id);
        if (!(objFindViewById instanceof WMLTRWebView) || (coreView = ((WMLTRWebView) objFindViewById).getCoreView()) == null) {
            return;
        }
        coreView.scrollTo(0, 0);
    }

    public g(com.alibaba.ariver.app.api.Page page, App app) {
        this.b = page;
        this.c = new e(app);
    }
}

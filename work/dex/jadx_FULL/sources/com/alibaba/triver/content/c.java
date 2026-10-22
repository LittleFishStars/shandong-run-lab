package com.alibaba.triver.content;

import android.content.Context;
import android.widget.FrameLayout;
import com.alibaba.ariver.app.api.Page;
import com.alibaba.ariver.app.api.ui.loading.LoadingView;
import com.alibaba.ariver.kernel.common.RVProxy;
import com.alibaba.triver.app.g;
import com.alibaba.triver.kit.api.proxy.IPageLoadProxy;
import com.alibaba.triver.kit.api.widget.ILoadingView;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public class c implements LoadingView {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private ILoadingView f24807a;
    private Context b;
    private Page c;
    private boolean d;
    private Runnable e = new Runnable() { // from class: com.alibaba.triver.content.c.1
        @Override // java.lang.Runnable
        public void run() {
            if (c.this.f24807a.getContentView().getVisibility() == 8) {
                c.this.f24807a.getContentView().setVisibility(0);
            }
        }
    };

    public c(Context context, Page page) {
        this.b = context;
        this.c = page;
    }

    @Override // com.alibaba.ariver.app.api.ui.loading.LoadingView
    public boolean backPressed() {
        ILoadingView iLoadingView = this.f24807a;
        if (iLoadingView == null || iLoadingView.getContentView().getVisibility() != 0) {
            return false;
        }
        if (this.d) {
            this.f24807a.getContentView().setVisibility(8);
        }
        return true;
    }

    @Override // com.alibaba.ariver.app.api.ui.loading.LoadingView
    public void dismiss() {
        ILoadingView iLoadingView = this.f24807a;
        if (iLoadingView == null) {
            return;
        }
        iLoadingView.getContentView().removeCallbacks(this.e);
        if (this.f24807a.getContentView().getVisibility() == 0) {
            this.f24807a.getContentView().setVisibility(8);
        }
    }

    @Override // com.alibaba.ariver.app.api.ui.loading.LoadingView
    public void show(String str, int i, boolean z) {
        this.d = z;
        if (this.f24807a == null) {
            IPageLoadProxy iPageLoadProxy = (IPageLoadProxy) RVProxy.get(IPageLoadProxy.class);
            Context context = this.b;
            Page page = this.c;
            this.f24807a = iPageLoadProxy.getLoadingView(context, new g(page, new com.alibaba.triver.app.e(page.getApp())));
            this.c.getPageContext().getPageContainer().getView().addView(this.f24807a.getContentView(), new FrameLayout.LayoutParams(-1, -1));
        }
        ILoadingView iLoadingView = this.f24807a;
        if (iLoadingView != null) {
            iLoadingView.update(str);
            if (i > 0) {
                this.f24807a.getContentView().setVisibility(8);
                this.f24807a.getContentView().postDelayed(this.e, i);
            } else if (this.f24807a.getContentView().getVisibility() == 8) {
                this.f24807a.getContentView().setVisibility(0);
            }
        }
    }
}

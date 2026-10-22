package com.alibaba.triver.open.impl;

import android.R;
import android.app.Activity;
import android.content.Context;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.os.Looper;
import android.taobao.windvane.extra.uc.WVUCWebView;
import android.view.KeyEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.alibaba.ariver.kernel.common.RVProxy;
import com.alibaba.ariver.kernel.common.service.RVEnvironmentService;
import com.alibaba.ariver.kernel.common.service.executor.ExecutorType;
import com.alibaba.ariver.kernel.common.service.executor.RVExecutorService;
import com.alibaba.ariver.kernel.common.utils.RVLogger;
import com.alibaba.triver.kit.api.Page;
import com.alibaba.triver.kit.api.TinyApp;
import com.alibaba.triver.kit.api.model.EntryInfo;
import com.alibaba.triver.kit.api.model.ErrorInfo;
import com.alibaba.triver.kit.api.model.WindowInfoModel;
import com.alibaba.triver.kit.api.proxy.IAppLoadProxy;
import com.alibaba.triver.kit.api.proxy.IPageLoadProxy;
import com.alibaba.triver.kit.api.widget.ITitleBar;
import com.alibaba.triver.kit.api.widget.ITitleView;
import com.alibaba.triver.kit.api.widget.action.ICloseableAction;
import com.alibaba.triver.open.api.DowngradeEnum;
import com.alibaba.triver.open.proxy.IRouterProxy;
import com.alibaba.triver.open.widget.e;
import com.alibaba.triver.open.widget.g;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public class AppLoadProxyImpl implements IAppLoadProxy {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final String f25052a = "AppLoadProxyImpl";

    private Activity a(View view) {
        if (view.getContext() instanceof Activity) {
            return (Activity) view.getContext();
        }
        View viewFindViewById = view.findViewById(R.id.content);
        return (viewFindViewById == null || !(viewFindViewById.getContext() instanceof Activity)) ? ((RVEnvironmentService) RVProxy.get(RVEnvironmentService.class)).getTopActivity().get() : (Activity) viewFindViewById.getContext();
    }

    @Override // com.alibaba.triver.kit.api.proxy.IAppLoadProxy
    public View getErrorView(Context context, Page page, ErrorInfo errorInfo) {
        e eVar = new e();
        eVar.attatchPage(page);
        View view = eVar.getView(context);
        eVar.a(errorInfo, true);
        return view;
    }

    public ITitleView getLoadingView(View view) {
        KeyEvent.Callback callbackFindViewById = ((ViewGroup) view).findViewById(com.alibaba.alibctriver.R.id.app_loading_view);
        if (callbackFindViewById instanceof ITitleView) {
            return (ITitleView) callbackFindViewById;
        }
        return null;
    }

    @Override // com.alibaba.triver.kit.api.proxy.IAppLoadProxy
    public void hideAppLoading(View view) {
        if (view.getContext() instanceof Activity) {
            view.setVisibility(8);
        }
        final ITitleView loadingView = getLoadingView(view);
        if (loadingView == null || loadingView.getContentView().getVisibility() != 0) {
            return;
        }
        if (Looper.myLooper() == Looper.getMainLooper()) {
            loadingView.getContentView().setVisibility(8);
        } else {
            ((RVExecutorService) RVProxy.get(RVExecutorService.class)).getExecutor(ExecutorType.UI).execute(new Runnable() { // from class: com.alibaba.triver.open.impl.AppLoadProxyImpl.4
                @Override // java.lang.Runnable
                public void run() {
                    loadingView.getContentView().setVisibility(8);
                }
            });
        }
    }

    @Override // com.alibaba.triver.kit.api.proxy.IAppLoadProxy
    public boolean isShowError(View view) {
        return ((ViewGroup) view).findViewById(com.alibaba.alibctriver.R.id.app_error_view) != null;
    }

    @Override // com.alibaba.triver.kit.api.proxy.IAppLoadProxy
    public boolean isShowLoading(View view) {
        ITitleView loadingView = getLoadingView(view);
        return loadingView != null && loadingView.getContentView().getVisibility() == 0;
    }

    @Override // com.alibaba.triver.kit.api.proxy.IAppLoadProxy
    public void onAppLoadError(final View view, final TinyApp tinyApp, ErrorInfo errorInfo) {
        if (!WVUCWebView.getUCSDKSupport()) {
            ((IRouterProxy) RVProxy.get(IRouterProxy.class)).downgrade(view.getContext(), null, tinyApp.getStartUrl(), DowngradeEnum.UC_CORE.getKey());
            if (view.getContext() instanceof Activity) {
                view.post(new Runnable() { // from class: com.alibaba.triver.open.impl.AppLoadProxyImpl.2
                    @Override // java.lang.Runnable
                    public void run() {
                        ((Activity) view.getContext()).finish();
                    }
                });
                return;
            }
            return;
        }
        Page page = new Page() { // from class: com.alibaba.triver.open.impl.AppLoadProxyImpl.3
            @Override // com.alibaba.triver.kit.api.Page
            public void applyTransparentTitle(boolean z) {
            }

            @Override // com.alibaba.triver.kit.api.Page
            public boolean canGoback() {
                return false;
            }

            @Override // com.alibaba.triver.kit.api.Page
            public Bitmap captureView() {
                return null;
            }

            @Override // com.alibaba.triver.kit.api.Page
            public TinyApp getApp() {
                return tinyApp;
            }

            @Override // com.alibaba.triver.kit.api.Page
            public int getIndex() {
                return 0;
            }

            @Override // com.alibaba.triver.kit.api.Page
            public String getPagePath() {
                return null;
            }

            @Override // com.alibaba.triver.kit.api.Page
            public Bundle getSceneParams() {
                return null;
            }

            @Override // com.alibaba.triver.kit.api.Page
            public Bundle getStartParams() {
                return null;
            }

            @Override // com.alibaba.triver.kit.api.Page
            public WindowInfoModel getWindowInfo() {
                WindowInfoModel windowInfoModel = new WindowInfoModel();
                windowInfoModel.showNavigationBar = true;
                return windowInfoModel;
            }

            @Override // com.alibaba.triver.kit.api.Page
            public boolean isFirstTab() {
                return false;
            }

            @Override // com.alibaba.triver.kit.api.Page
            public boolean isHomePage() {
                return true;
            }

            @Override // com.alibaba.triver.kit.api.Page
            public boolean isStartPage() {
                return false;
            }

            @Override // com.alibaba.triver.kit.api.Page
            public boolean isTabPage() {
                return false;
            }

            @Override // com.alibaba.triver.kit.api.Page
            public void reload() {
            }

            @Override // com.alibaba.triver.kit.api.Page
            public void scrollToTop() {
            }
        };
        ITitleView loadingView = getLoadingView(view);
        if (loadingView != null) {
            ((ViewGroup) view).removeView(loadingView.getContentView());
        }
        ViewGroup viewGroup = (ViewGroup) view;
        int i = com.alibaba.alibctriver.R.id.app_error_view;
        ViewGroup viewGroup2 = (ViewGroup) viewGroup.findViewById(i);
        if (viewGroup2 != null) {
            viewGroup2.removeViewAt(0);
            viewGroup2.addView(getErrorView(a(view), page, errorInfo), 0, new ViewGroup.LayoutParams(-1, -1));
            view.setVisibility(0);
            return;
        }
        FrameLayout frameLayout = new FrameLayout(a(view));
        frameLayout.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
        frameLayout.addView(getErrorView(a(view), page, errorInfo), new ViewGroup.LayoutParams(-1, -1));
        frameLayout.setId(i);
        ITitleBar titleBar = ((IPageLoadProxy) RVProxy.get(IPageLoadProxy.class)).getTitleBar(a(view), tinyApp);
        titleBar.attachPage(page);
        frameLayout.addView(titleBar.getContentView(), new ViewGroup.LayoutParams(-1, -2));
        ((FrameLayout.LayoutParams) frameLayout.getLayoutParams()).setMargins(0, titleBar.getBarHeight(), 0, 0);
        viewGroup.addView(frameLayout, new FrameLayout.LayoutParams(-1, -1));
        view.setVisibility(0);
    }

    @Override // com.alibaba.triver.kit.api.proxy.IAppLoadProxy
    public void onRenderSuccess(View view) {
    }

    @Override // com.alibaba.triver.kit.api.proxy.IAppLoadProxy
    public void removeAppLoadError(View view, TinyApp tinyApp) {
        try {
            ViewGroup viewGroup = (ViewGroup) view.findViewById(com.alibaba.alibctriver.R.id.app_error_view);
            ((ViewGroup) viewGroup.getParent()).removeView(viewGroup);
        } catch (Exception e) {
            RVLogger.e(f25052a, "removeAppLoadError: ", e);
        }
    }

    @Override // com.alibaba.triver.kit.api.proxy.IAppLoadProxy
    public void showAppLoading(View view, final TinyApp tinyApp, EntryInfo entryInfo) {
        ViewGroup viewGroup = (ViewGroup) view;
        View viewFindViewById = viewGroup.findViewById(com.alibaba.alibctriver.R.id.app_error_view);
        if (viewFindViewById != null) {
            viewGroup.removeView(viewFindViewById);
        }
        ITitleView loadingView = getLoadingView(view);
        if (loadingView != null) {
            loadingView.getContentView().setVisibility(0);
            loadingView.setLogo(entryInfo.appLogo);
            return;
        }
        g gVar = new g(a(view));
        ICloseableAction iCloseableAction = (ICloseableAction) gVar.getAction(ICloseableAction.class);
        if (iCloseableAction != null) {
            iCloseableAction.setOnCloseClickListener(new View.OnClickListener() { // from class: com.alibaba.triver.open.impl.AppLoadProxyImpl.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view2) {
                    TinyApp tinyApp2 = tinyApp;
                    if (tinyApp2 != null) {
                        tinyApp2.exit();
                    }
                }
            });
        }
        gVar.getContentView().setBackgroundResource(R.color.white);
        gVar.setLogo(entryInfo.appLogo);
        gVar.getContentView().setId(com.alibaba.alibctriver.R.id.app_loading_view);
        viewGroup.addView(gVar.getContentView(), new FrameLayout.LayoutParams(-1, -1));
        view.setVisibility(0);
    }

    @Override // com.alibaba.triver.kit.api.proxy.IAppLoadProxy
    public void updateAppInfo(View view, EntryInfo entryInfo) {
        ITitleView loadingView = getLoadingView(view);
        if (loadingView == null || "14".equals(entryInfo.subBizType)) {
            return;
        }
        loadingView.setLogo(entryInfo.appLogo);
    }
}

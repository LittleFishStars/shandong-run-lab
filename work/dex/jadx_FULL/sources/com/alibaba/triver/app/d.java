package com.alibaba.triver.app;

import android.os.Handler;
import android.os.Looper;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import androidx.fragment.app.FragmentActivity;
import com.alibaba.ariver.app.BaseAppContext;
import com.alibaba.ariver.app.api.App;
import com.alibaba.ariver.app.api.Page;
import com.alibaba.ariver.app.api.ui.ViewSpecProvider;
import com.alibaba.ariver.app.api.ui.fragment.IFragmentManager;
import com.alibaba.ariver.app.api.ui.loading.SplashUtils;
import com.alibaba.ariver.app.api.ui.loading.SplashView;
import com.alibaba.ariver.kernel.api.extension.ExtensionPoint;
import com.alibaba.ariver.kernel.common.utils.RVLogger;
import com.alibaba.triver.R;
import com.alibaba.triver.container.TriverSubActivity;
import com.alibaba.triver.kit.api.common.TRiverConstants;
import com.alibaba.triver.kit.api.model.RetryCache;
import com.alibaba.triver.kit.api.point.PushPagePoint;
import com.alibaba.triver.utils.CommonUtils;
import com.alibaba.triver.utils.PageUtils;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public class d extends BaseAppContext {
    private static final String e = "AriverInt:AppContext";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    protected SplashView f24619a;
    protected ViewGroup b;
    protected ViewSpecProvider c;
    protected ViewGroup d;
    private Map<Class, Object> f;
    private App g;
    private Handler h;
    private Runnable i;

    public d(App app, SplashView splashView, ViewGroup viewGroup, ViewGroup viewGroup2, FragmentActivity fragmentActivity) {
        super(app, fragmentActivity);
        this.f = new HashMap();
        this.i = new Runnable() { // from class: com.alibaba.triver.app.d.1
            @Override // java.lang.Runnable
            public void run() {
                if (d.this.getApp() != null) {
                    SplashView splashView2 = d.this.getApp().getAppContext() == null ? null : d.this.getApp().getAppContext().getSplashView();
                    if (splashView2 != null) {
                        splashView2.exit(null);
                    }
                }
            }
        };
        this.f24619a = splashView;
        this.g = app;
        this.c = new com.alibaba.triver.content.f(fragmentActivity, new e(app));
        this.d = viewGroup;
        this.b = viewGroup2;
        RetryCache retryCache = new RetryCache();
        retryCache.retryTime = app.getStartParams() != null ? app.getStartParams().getInt(TRiverConstants.KEY_ERROR_RETRY_TIME, 0) : 0;
        a((Class<RetryCache>) RetryCache.class, retryCache);
    }

    @Override // com.alibaba.ariver.app.BaseAppContext
    public IFragmentManager createFragmentManager() {
        return new com.alibaba.triver.fragment.a(getApp(), R.id.trv_fragment_container, getActivity());
    }

    @Override // com.alibaba.ariver.app.api.AppContext
    public SplashView getSplashView() {
        return this.f24619a;
    }

    @Override // com.alibaba.ariver.app.BaseAppContext
    public ViewGroup getTabBarContainer() {
        return this.b;
    }

    @Override // com.alibaba.ariver.app.BaseAppContext, com.alibaba.ariver.app.api.AppContext
    public ViewSpecProvider getViewSpecProvider() {
        return this.c;
    }

    @Override // com.alibaba.ariver.app.BaseAppContext, com.alibaba.ariver.app.api.AppContext
    public boolean moveToBackground() {
        return (CommonUtils.enableKeepAlive(getApp()) && getActivity() != null && (getActivity() instanceof TriverSubActivity.TriverSubActivityX) && getActivity().isTaskRoot()) ? getActivity().moveTaskToBack(false) : super.moveToBackground();
    }

    @Override // com.alibaba.ariver.app.BaseAppContext
    public void onDestroy() {
        super.onDestroy();
        Handler handler = this.h;
        if (handler != null) {
            handler.removeCallbacks(this.i);
        }
    }

    @Override // com.alibaba.ariver.app.BaseAppContext, com.alibaba.ariver.app.api.AppContext
    public boolean pushPage(Page page) {
        if (!new g(page, new e(page.getApp())).isStartPage() && ((PushPagePoint) ExtensionPoint.as(PushPagePoint.class).create()).pushPage(page, PageUtils.getPageUrl(page))) {
            this.g.removeChild(page);
            page.destroy();
            Page activePage = this.g.getActivePage();
            if (activePage == null) {
                return false;
            }
            activePage.show(null);
            return false;
        }
        return super.pushPage(page);
    }

    @Override // com.alibaba.ariver.app.BaseAppContext, com.alibaba.ariver.app.api.AppContext
    public void start(Page page) {
        super.start(page);
        if (SplashUtils.useSuperSplash(getApp().getStartParams()) && this.h == null) {
            Handler handler = new Handler(Looper.getMainLooper());
            this.h = handler;
            handler.postDelayed(this.i, 3000L);
        }
    }

    public void a(boolean z) {
        RelativeLayout.LayoutParams layoutParams;
        RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) this.d.getLayoutParams();
        if (z) {
            layoutParams = new RelativeLayout.LayoutParams(layoutParams2.width, layoutParams2.height);
            layoutParams.addRule(12);
        } else {
            layoutParams = new RelativeLayout.LayoutParams(layoutParams2.width, layoutParams2.height);
            layoutParams.addRule(2, this.b.getId());
        }
        this.d.setLayoutParams(layoutParams);
    }

    public <T> void a(Class<T> cls, T t) {
        this.f.put(cls, t);
    }

    public <T> T a(Class<T> cls) {
        try {
            T t = (T) this.f.get(cls);
            if (t != null) {
                return t;
            }
            return null;
        } catch (Exception e2) {
            RVLogger.e("AriverTriver:TriverActivity", "getData error", e2);
            return null;
        }
    }
}

package com.alibaba.triver.content;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.BitmapDrawable;
import android.os.Bundle;
import android.os.Looper;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import com.alibaba.ariver.app.api.App;
import com.alibaba.ariver.app.api.Page;
import com.alibaba.ariver.app.api.ui.titlebar.TitleBar;
import com.alibaba.ariver.engine.api.bridge.model.ScrollChangedCallback;
import com.alibaba.ariver.engine.api.extensions.resources.model.ResourceLoadContext;
import com.alibaba.ariver.engine.api.resources.Resource;
import com.alibaba.ariver.engine.api.resources.ResourceLoadPoint;
import com.alibaba.ariver.kernel.RVParams;
import com.alibaba.ariver.kernel.RVStartParams;
import com.alibaba.ariver.kernel.api.extension.ExtensionPoint;
import com.alibaba.ariver.kernel.common.RVProxy;
import com.alibaba.ariver.kernel.common.service.executor.ExecutorType;
import com.alibaba.ariver.kernel.common.service.executor.RVExecutorService;
import com.alibaba.ariver.kernel.common.utils.BundleUtils;
import com.alibaba.ariver.kernel.common.utils.FileUtils;
import com.alibaba.ariver.kernel.common.utils.RVLogger;
import com.alibaba.triver.app.g;
import com.alibaba.triver.kit.api.proxy.IPageLoadProxy;
import com.alibaba.triver.kit.api.utils.TRiverUtils;
import com.alibaba.triver.kit.api.widget.ITitleBar;
import com.alibaba.triver.kit.api.widget.ITransparentTitleView;
import com.alibaba.triver.kit.api.widget.action.ILoadingAction;
import com.alibaba.triver.utils.ResourceUtils;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public class e implements TitleBar {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private ITitleBar f24812a;
    private com.alibaba.triver.app.e b;
    private App c;
    private Page d;
    private int e;
    private int f;
    private int h;
    private int g = 1;
    private boolean i = false;

    public e(Context context, App app) {
        this.c = app;
        this.b = new com.alibaba.triver.app.e(app);
        this.f24812a = ((IPageLoadProxy) RVProxy.get(IPageLoadProxy.class)).getTitleBar(context, this.b);
    }

    @Override // com.alibaba.ariver.app.api.ui.titlebar.TitleBar
    public void attachPage(Page page) {
        this.d = page;
        this.f24812a = ((IPageLoadProxy) RVProxy.get(IPageLoadProxy.class)).attachPage(this.f24812a, new g(page, this.b));
        if (page.getPageContext() != null) {
            page.getPageContext().applyTransparentTitle(this.f24812a.isTranslucent());
        }
        Bundle startParams = page.getStartParams();
        ITitleBar iTitleBar = this.f24812a;
        if (iTitleBar instanceof ITransparentTitleView) {
            if ("auto".equals(((ITransparentTitleView) iTitleBar).getTransparentTitle())) {
                b(startParams);
            }
        } else if ("auto".equals(BundleUtils.getString(startParams, "transparentTitle"))) {
            b(startParams);
        }
        if (page.getOriginalURI() != null && TRiverUtils.isAuthPage(page.getOriginalURI())) {
            this.f24812a.setTitleBarBgColor("#ffffff");
            this.f24812a.setStyle("dark");
        }
        a(startParams);
    }

    @Override // com.alibaba.ariver.app.api.ui.titlebar.TitleBar
    public View getContent() {
        return this.f24812a.getContentView();
    }

    @Override // com.alibaba.ariver.app.api.ui.titlebar.TitleBar
    public View getDivider() {
        return this.f24812a.getDivider();
    }

    @Override // com.alibaba.ariver.app.api.ui.titlebar.TitleBar
    public Bitmap getImgTitle() {
        return null;
    }

    @Override // com.alibaba.ariver.app.api.ui.titlebar.TitleBar
    public String getSubTitle() {
        return null;
    }

    @Override // com.alibaba.ariver.app.api.ui.titlebar.TitleBar
    public String getTitle() {
        return null;
    }

    @Override // com.alibaba.ariver.app.api.ui.titlebar.TitleBar
    public int getTitleColor() {
        try {
            return (int) this.f24812a.getTitleColor();
        } catch (Exception e) {
            Log.e("TriverTitleBar", "parse title color error", e);
            return 0;
        }
    }

    @Override // com.alibaba.ariver.app.api.ui.titlebar.TitleBar
    public String getTransparentTitle() {
        return null;
    }

    @Override // com.alibaba.ariver.app.api.ui.titlebar.TitleBar
    public void onDestroy() {
        if (Looper.getMainLooper() == Looper.myLooper()) {
            this.f24812a.onDestroy();
        } else {
            ((RVExecutorService) RVProxy.get(RVExecutorService.class)).getExecutor(ExecutorType.UI).execute(new Runnable() { // from class: com.alibaba.triver.content.e.2
                @Override // java.lang.Runnable
                public void run() {
                    e.this.f24812a.onDestroy();
                }
            });
        }
    }

    @Override // com.alibaba.ariver.app.api.ui.titlebar.TitleBar
    public void setDivider(View view) {
    }

    @Override // com.alibaba.ariver.app.api.ui.titlebar.TitleBar
    public void setTitle(String str, String str2, String str3, String str4, boolean z) {
        if (TextUtils.isEmpty(str3)) {
            if (!this.i || z) {
                this.i = z;
                this.f24812a.setTitle(str, str2, str3, str4);
                return;
            }
            return;
        }
        String string = BundleUtils.getString(this.c.getStartParams(), "onlineHost");
        if (ResourceUtils.a(str3, string) != ResourceUtils.ResourceType.INTERNAL) {
            this.f24812a.setTitle(str, str2, str3, str4);
            return;
        }
        if (!str3.startsWith(string)) {
            str3 = FileUtils.combinePath(string, str3);
        }
        Resource resourceLoad = ((ResourceLoadPoint) ExtensionPoint.as(ResourceLoadPoint.class).node(this.c).create()).load(ResourceLoadContext.newBuilder().originUrl(str3).build());
        if (resourceLoad != null) {
            byte[] bytes = resourceLoad.getBytes();
            this.f24812a.setTitle(str, str2, new BitmapDrawable(BitmapFactory.decodeByteArray(bytes, 0, bytes.length)), str4);
        }
    }

    @Override // com.alibaba.ariver.app.api.ui.titlebar.TitleBar
    public void setTitleColor(int i, boolean z, boolean z2) {
        this.f24812a.setTitleBarBgColor(String.valueOf(i | (-16777216)));
        if (z) {
            this.f24812a.resetBackground();
        }
        if (z2) {
            this.f24812a.reset();
        }
    }

    @Override // com.alibaba.ariver.app.api.ui.titlebar.TitleBar
    public void setTransparentTitle(String str) {
        if (RVStartParams.TRANSPARENT_TITLE_ALWAYS.equals(str)) {
            this.f24812a.setTranslucent(true);
            return;
        }
        if ("auto".equals(str)) {
            this.f24812a.setTranslucent(true);
            b(this.d.getStartParams());
        } else if ("none".equals(str)) {
            this.f24812a.setTranslucent(false);
        }
    }

    @Override // com.alibaba.ariver.app.api.ui.titlebar.TitleBar
    public void showBackButton(boolean z) {
        if (z) {
            this.f24812a.showBackButton();
        } else {
            this.f24812a.hideBackButton();
        }
    }

    @Override // com.alibaba.ariver.app.api.ui.titlebar.TitleBar
    public void showOptionMenu(boolean z) {
    }

    @Override // com.alibaba.ariver.app.api.ui.titlebar.TitleBar
    public void showTitleLoading(boolean z) {
        ILoadingAction iLoadingAction = (ILoadingAction) this.f24812a.getAction(ILoadingAction.class);
        if (iLoadingAction != null) {
            if (z) {
                iLoadingAction.showLoading();
            } else {
                iLoadingAction.hideLoading();
            }
        }
    }

    private void b(Bundle bundle) {
        int i = BundleUtils.getInt(bundle, RVParams.LONG_TITLE_SCROLLDISTANCE, 255);
        this.e = i;
        int i2 = i / 255;
        if (i2 == 0) {
            i2 = 1;
        }
        this.g = i2;
        this.f = (i * 3) / 4;
        RVLogger.d("TriverTitleBar", "transparentTitleBar finalMaxScrollHeight is " + this.e + ", switchThemePoint is " + this.f);
        this.f24812a.setAlpha(a(this.e, this.g, false));
        this.h = this.d.getRender().getScrollY();
        this.d.getRender().setScrollChangedCallback(new ScrollChangedCallback() { // from class: com.alibaba.triver.content.e.1
            @Override // com.alibaba.ariver.engine.api.bridge.model.ScrollChangedCallback
            public void onScroll(int i3, int i4) {
                e.this.h += i4;
                ITitleBar iTitleBar = e.this.f24812a;
                e eVar = e.this;
                iTitleBar.setAlpha(eVar.a(eVar.e, e.this.g, true));
            }
        });
    }

    public ITitleBar a() {
        return this.f24812a;
    }

    private void a(Bundle bundle) {
        if ("YES".equalsIgnoreCase(BundleUtils.getString(bundle, RVParams.LONG_TITLE_PENETRATE, "NO"))) {
            return;
        }
        this.f24812a.getContentView().setClickable(true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int a(int i, int i2, boolean z) {
        int scrollY = z ? this.h : this.d.getRender().getScrollY();
        if (Math.abs(scrollY) >= i) {
            return scrollY <= 0 ? 0 : 255;
        }
        return Math.abs(scrollY / i2);
    }
}

package com.alibaba.ariver.engine;

import android.app.Activity;
import android.os.Bundle;
import android.webkit.WebView;
import androidx.annotation.CallSuper;
import com.alibaba.ariver.app.api.Page;
import com.alibaba.ariver.app.api.PageContext;
import com.alibaba.ariver.engine.api.EngineUtils;
import com.alibaba.ariver.engine.api.RVEngine;
import com.alibaba.ariver.engine.api.Render;
import com.alibaba.ariver.engine.api.bridge.model.CreateParams;
import com.alibaba.ariver.engine.api.bridge.model.ExitCallback;
import com.alibaba.ariver.engine.api.bridge.model.GoBackCallback;
import com.alibaba.ariver.engine.api.bridge.model.LoadParams;
import com.alibaba.ariver.engine.api.common.CommonBackPerform;
import com.alibaba.ariver.engine.api.common.CommonExitPerform;
import com.alibaba.ariver.engine.api.embedview.IEmbedView;
import com.alibaba.ariver.kernel.api.node.DataNode;
import com.alibaba.ariver.kernel.common.utils.RVLogger;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public abstract class BaseRenderImpl implements Render {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final String f24044a = "AriverEngine:BaseRenderImpl";
    private static AtomicInteger b = new AtomicInteger(1);
    private boolean c;
    protected LoadParams currentLoadParam;
    private CommonBackPerform d;
    private CommonExitPerform e;
    private String g;
    protected Activity mActivity;
    protected CreateParams mCreateParams;
    protected RVEngine mEngineProxy;
    protected DataNode mNode;
    private String h = null;
    private String f = b.addAndGet(1) + "";

    public BaseRenderImpl(RVEngine rVEngine, Activity activity, DataNode dataNode, CreateParams createParams) {
        this.mEngineProxy = rVEngine;
        this.g = rVEngine.getAppId();
        this.mActivity = activity;
        this.mNode = dataNode;
        this.mCreateParams = createParams;
    }

    @Override // com.alibaba.ariver.engine.api.Render
    public final synchronized void destroy() {
        if (this.c) {
            return;
        }
        this.c = true;
        onDestroy();
    }

    @Override // com.alibaba.ariver.engine.api.Render
    public Activity getActivity() {
        return this.mActivity;
    }

    @Override // com.alibaba.ariver.engine.api.Render
    public String getAppId() {
        return this.g;
    }

    public CommonBackPerform getBackPerform() {
        return this.d;
    }

    @Override // com.alibaba.ariver.engine.api.Render
    public String getCurrentUri() {
        LoadParams loadParams = this.currentLoadParam;
        if (loadParams != null) {
            return loadParams.url;
        }
        DataNode page = getPage();
        if (page instanceof Page) {
            return ((Page) page).getOriginalURI();
        }
        return null;
    }

    @Override // com.alibaba.ariver.engine.api.Render
    public RVEngine getEngine() {
        return this.mEngineProxy;
    }

    public CommonExitPerform getExitPerform() {
        return this.e;
    }

    @Override // com.alibaba.ariver.engine.api.Render
    public DataNode getPage() {
        return this.mNode;
    }

    @Override // com.alibaba.ariver.engine.api.Render
    public String getRenderId() {
        return this.f;
    }

    @Override // com.alibaba.ariver.engine.api.Render
    public Bundle getStartParams() {
        return this.mCreateParams.startParams;
    }

    @Override // com.alibaba.ariver.engine.api.Render
    public synchronized String getUserAgent() {
        if (this.h == null) {
            WebView webView = new WebView(this.mActivity);
            this.h = webView.getSettings().getUserAgentString();
            this.h += " " + EngineUtils.getUserAgentSuffix();
            webView.destroy();
        }
        return this.h;
    }

    @Override // com.alibaba.ariver.engine.api.Render
    public void goBack(GoBackCallback goBackCallback) {
        CommonBackPerform commonBackPerform = this.d;
        if (commonBackPerform != null) {
            commonBackPerform.goBack(goBackCallback);
        } else {
            goBackCallback.afterProcess(false);
        }
    }

    @Override // com.alibaba.ariver.engine.api.Render
    public boolean hasTriggeredLoad() {
        return this.currentLoadParam != null;
    }

    @Override // com.alibaba.ariver.engine.api.Render
    public boolean isDestroyed() {
        return this.c;
    }

    @Override // com.alibaba.ariver.engine.api.Render
    @CallSuper
    public void load(LoadParams loadParams) {
        RVLogger.d(f24044a, "load " + loadParams);
        this.currentLoadParam = loadParams;
    }

    public abstract void onDestroy();

    @Override // com.alibaba.ariver.engine.api.Render
    public void onPause() {
        PageContext pageContext;
        List<IEmbedView> listFindAllEmbedView;
        Page page = (Page) getPage();
        if (page == null || page.getPageContext() == null || (pageContext = page.getPageContext()) == null || pageContext.getEmbedViewManager() == null || (listFindAllEmbedView = pageContext.getEmbedViewManager().findAllEmbedView()) == null) {
            return;
        }
        Iterator<IEmbedView> it = listFindAllEmbedView.iterator();
        while (it.hasNext()) {
            it.next().onWebViewPause();
        }
    }

    @Override // com.alibaba.ariver.engine.api.Render
    public void onResume() {
        PageContext pageContext;
        List<IEmbedView> listFindAllEmbedView;
        Page page = (Page) getPage();
        if (page == null || page.getPageContext() == null || (pageContext = page.getPageContext()) == null || pageContext.getEmbedViewManager() == null || (listFindAllEmbedView = pageContext.getEmbedViewManager().findAllEmbedView()) == null) {
            return;
        }
        Iterator<IEmbedView> it = listFindAllEmbedView.iterator();
        while (it.hasNext()) {
            it.next().onWebViewResume();
        }
    }

    @Override // com.alibaba.ariver.engine.api.Render
    public void reload() {
        load(new LoadParams(this.currentLoadParam));
    }

    @Override // com.alibaba.ariver.engine.api.Render
    public void runExit(ExitCallback exitCallback) {
        CommonExitPerform commonExitPerform = this.e;
        if (commonExitPerform != null) {
            commonExitPerform.runExit(exitCallback);
        } else {
            exitCallback.afterProcess(false);
        }
    }

    public void setBackPerform(CommonBackPerform commonBackPerform) {
        this.d = commonBackPerform;
    }

    public void setExitPerform(CommonExitPerform commonExitPerform) {
        this.e = commonExitPerform;
    }

    @Override // com.alibaba.ariver.engine.api.Render
    public void setTextSize(int i) {
    }

    @Override // com.alibaba.ariver.engine.api.Render
    public void triggerSaveSnapshot() {
    }
}

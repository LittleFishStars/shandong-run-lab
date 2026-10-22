package com.alibaba.triver.triver_render.render;

import android.taobao.windvane.extra.uc.WVUCClient;
import android.text.TextUtils;
import com.alibaba.ariver.app.api.App;
import com.alibaba.ariver.app.api.Page;
import com.alibaba.ariver.engine.api.embedview.EmbedViewConstant;
import com.alibaba.ariver.kernel.common.RVProxy;
import com.alibaba.ariver.kernel.common.utils.RVLogger;
import com.alibaba.triver.kit.api.appmonitor.LaunchMonitorData;
import com.alibaba.triver.kit.api.appmonitor.LaunchMonitorUtils;
import com.alibaba.triver.kit.api.monitor.IPerformanceAndErrorTracker;
import com.uc.webview.export.WebView;
import com.uc.webview.export.extension.EmbedViewConfig;
import com.uc.webview.export.extension.IEmbedView;
import com.uc.webview.export.extension.IEmbedViewContainer;
import java.lang.ref.WeakReference;
import java.util.Map;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public class c extends WVUCClient {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final String f25203a = "WMLTRClient";
    private WeakReference<Page> b;

    public c(android.taobao.windvane.d.b bVar, Page page) {
        super(bVar);
        this.b = new WeakReference<>(page);
    }

    @Override // android.taobao.windvane.extra.uc.WVUCClient
    public IEmbedView getEmbedView(final EmbedViewConfig embedViewConfig, IEmbedViewContainer iEmbedViewContainer) {
        try {
            RVLogger.e(f25203a, "getEmbedView in");
            iEmbedViewContainer.setOnStateChangedListener(new IEmbedViewContainer.OnStateChangedListener() { // from class: com.alibaba.triver.triver_render.render.c.1
                public void onAttachedToWebView() {
                    com.alibaba.ariver.engine.api.embedview.IEmbedView iEmbedViewFindViewById = ((Page) c.this.b.get()).getPageContext().getEmbedViewManager().findViewById((String) embedViewConfig.mObjectParam.get("id"));
                    if (iEmbedViewFindViewById != null) {
                        iEmbedViewFindViewById.onAttachedToWebView();
                    }
                }

                public void onDestroy() {
                    com.alibaba.ariver.engine.api.embedview.IEmbedView iEmbedViewFindViewById = ((Page) c.this.b.get()).getPageContext().getEmbedViewManager().findViewById((String) embedViewConfig.mObjectParam.get("id"));
                    if (iEmbedViewFindViewById != null) {
                        iEmbedViewFindViewById.onDestroy();
                    }
                }

                public void onDetachedFromWebView() {
                    com.alibaba.ariver.engine.api.embedview.IEmbedView iEmbedViewFindViewById = ((Page) c.this.b.get()).getPageContext().getEmbedViewManager().findViewById((String) embedViewConfig.mObjectParam.get("id"));
                    if (iEmbedViewFindViewById != null) {
                        iEmbedViewFindViewById.onDetachedToWebView();
                    }
                }
            });
            iEmbedViewContainer.setOnParamChangedListener(new IEmbedViewContainer.OnParamChangedListener() { // from class: com.alibaba.triver.triver_render.render.c.2
                public void onParamChanged(String[] strArr, String[] strArr2) {
                    com.alibaba.ariver.engine.api.embedview.IEmbedView iEmbedViewFindViewById = ((Page) c.this.b.get()).getPageContext().getEmbedViewManager().findViewById((String) embedViewConfig.mObjectParam.get("id"));
                    if (iEmbedViewFindViewById != null) {
                        iEmbedViewFindViewById.onParamChanged(strArr, strArr2);
                    }
                }
            });
            iEmbedViewContainer.setOnVisibilityChangedListener(new IEmbedViewContainer.OnVisibilityChangedListener() { // from class: com.alibaba.triver.triver_render.render.c.3
                public void onVisibilityChanged(int i) {
                    com.alibaba.ariver.engine.api.embedview.IEmbedView iEmbedViewFindViewById = ((Page) c.this.b.get()).getPageContext().getEmbedViewManager().findViewById((String) embedViewConfig.mObjectParam.get("id"));
                    if (iEmbedViewFindViewById != null) {
                        iEmbedViewFindViewById.onEmbedViewVisibilityChanged(i);
                    }
                }
            });
            if (this.b.get() == null) {
                return null;
            }
            String str = (String) embedViewConfig.mObjectParam.get("id");
            String str2 = (String) embedViewConfig.mObjectParam.get("type");
            if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
                RVLogger.w(f25203a, "getEmbedView error params");
            }
            com.alibaba.ariver.engine.api.embedview.IEmbedView iEmbedViewCreateView = this.b.get().getPageContext().getEmbedViewManager().createView(str, str2);
            if (iEmbedViewCreateView == null) {
                RVLogger.e(f25203a, "Create iEmbedView fail");
                return null;
            }
            this.b.get().getSceneParams().putString(EmbedViewConstant.KEY_EMBED_VIEW_ID, str);
            return new com.alibaba.triver.triver_render.view.a(iEmbedViewCreateView.getView(embedViewConfig.mWidth, embedViewConfig.mHeight, String.valueOf(embedViewConfig.mEmbedViewID), embedViewConfig.mType, embedViewConfig.mObjectParam), iEmbedViewCreateView, embedViewConfig);
        } catch (Exception e) {
            RVLogger.e(f25203a, "getEmbedView exception:", e);
            return null;
        }
    }

    @Override // android.taobao.windvane.extra.uc.WVUCClient
    public void onWebViewEvent(WebView webView, int i, Object obj) {
        LaunchMonitorData pageMonitorData;
        LaunchMonitorData launchMonitorData;
        if (i == 9) {
            return;
        }
        if (i == 14 || i == 13) {
            try {
                String str = ((Map) obj).containsKey("ts") ? (String) ((Map) obj).get("ts") : "0";
                ((IPerformanceAndErrorTracker) RVProxy.get(IPerformanceAndErrorTracker.class)).sendPerfStageLog("Render", "uc_t2_time = " + str);
                Page page = this.b.get();
                App app = page != null ? page.getApp() : null;
                if (app != null) {
                    if (app.getData(LaunchMonitorData.class) != null && (launchMonitorData = (LaunchMonitorData) app.getData(LaunchMonitorData.class)) != null && !launchMonitorData.containsKey("uc_t2_time")) {
                        launchMonitorData.addPoint("uc_t2_time", Long.valueOf(Long.parseLong(str)));
                    }
                    if (page == null || (pageMonitorData = LaunchMonitorUtils.getPageMonitorData(page)) == null || pageMonitorData.containsKey("uc_t2_time")) {
                        return;
                    }
                    pageMonitorData.addPoint("uc_t2_time", Long.valueOf(Long.parseLong(str)));
                }
            } catch (Throwable th) {
                RVLogger.w(f25203a, th.getMessage());
            }
        }
    }
}

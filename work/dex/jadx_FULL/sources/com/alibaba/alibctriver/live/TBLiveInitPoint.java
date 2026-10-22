package com.alibaba.alibctriver.live;

import android.util.Log;
import com.alibaba.ariver.app.api.App;
import com.alibaba.ariver.app.api.Page;
import com.alibaba.ariver.app.api.PageContext;
import com.alibaba.ariver.app.api.point.app.AppDestroyPoint;
import com.alibaba.ariver.app.api.point.app.AppPausePoint;
import com.alibaba.ariver.app.api.point.app.AppStartPoint;
import com.alibaba.ariver.app.api.point.page.PageEnterPoint;
import com.alibaba.ariver.app.api.point.page.PageExitPoint;
import com.alibaba.ariver.app.api.point.page.PageHidePoint;
import com.alibaba.ariver.app.api.point.page.PagePausePoint;
import com.alibaba.ariver.app.api.point.page.PageResumePoint;
import com.alibaba.ariver.app.api.point.page.PageShowPoint;
import com.alibaba.ariver.engine.api.bridge.extension.BridgeCallback;
import com.alibaba.ariver.engine.api.bridge.extension.BridgeResponse;
import com.alibaba.ariver.engine.api.embedview.IEmbedView;
import com.alibaba.ariver.engine.api.embedview.IEmbedViewManager;
import com.alibaba.ariver.kernel.common.utils.ExecutorUtils;
import com.alibaba.ariver.kernel.common.utils.RVLogger;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.triver.triver_render.render.WVEmbedViewProvider;
import com.bytedance.sdk.openadsdk.mediation.MediationConstant;
import com.taobao.media.TBLiveEmbedView;
import com.taobao.mediaplay.player.c;
import java.io.Serializable;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public class TBLiveInitPoint implements AppDestroyPoint, AppPausePoint, AppStartPoint, PageEnterPoint, PageExitPoint, PageHidePoint, PagePausePoint, PageResumePoint, PageShowPoint, Serializable {
    public static final String TAOLIVE_SHOW_MINILIVE_ACTION = "com.taobao.taolive.miniLiveRoom.action";

    @Override // com.alibaba.ariver.app.api.point.app.AppDestroyPoint
    public void onAppDestroy(App app) {
        if (app == null || app.getStartParams() == null) {
            return;
        }
        app.getStartParams().putBoolean("isWindowShow", false);
    }

    @Override // com.alibaba.ariver.app.api.point.app.AppPausePoint
    public void onAppPause(App app) {
    }

    @Override // com.alibaba.ariver.app.api.point.app.AppStartPoint
    public void onAppStart(App app) {
        try {
            Class.forName(c.class.getName());
            WVEmbedViewProvider.registerEmebedView("live-player", TBLiveEmbedView.class.getCanonicalName());
        } catch (Throwable th) {
            RVLogger.w("TBLiveInitPoint", Log.getStackTraceString(th));
        }
    }

    @Override // com.alibaba.ariver.kernel.api.extension.Extension
    public void onFinalized() {
    }

    @Override // com.alibaba.ariver.kernel.api.extension.Extension
    public void onInitialized() {
    }

    @Override // com.alibaba.ariver.app.api.point.page.PageEnterPoint
    public void onPageEnter(Page page) {
        RVLogger.e("onPageEnter");
    }

    @Override // com.alibaba.ariver.app.api.point.page.PageExitPoint
    public void onPageExit(Page page) {
        PageContext pageContext = page.getPageContext();
        if (pageContext != null) {
            IEmbedViewManager embedViewManager = pageContext.getEmbedViewManager();
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("isShow", (Object) Boolean.FALSE);
            jSONObject.put(MediationConstant.KEY_USE_POLICY_PAGE_ID, (Object) Long.valueOf(page.getNodeId()));
            embedViewManager.dispatchSendMessage("mLivePlayer", "showFloatingWindow", jSONObject, null);
        }
    }

    @Override // com.alibaba.ariver.app.api.point.page.PageHidePoint
    public void onPageHide(Page page) {
        PageContext pageContext = page.getPageContext();
        if (pageContext != null) {
            IEmbedViewManager embedViewManager = pageContext.getEmbedViewManager();
            final JSONObject jSONObject = new JSONObject();
            jSONObject.put("isShow", (Object) Boolean.TRUE);
            jSONObject.put(MediationConstant.KEY_USE_POLICY_PAGE_ID, (Object) Long.valueOf(page.getNodeId()));
            for (final IEmbedView iEmbedView : embedViewManager.findAllEmbedView()) {
                ExecutorUtils.runOnMain(new Runnable() { // from class: com.alibaba.alibctriver.live.TBLiveInitPoint.2
                    @Override // java.lang.Runnable
                    public void run() {
                        try {
                            iEmbedView.onReceivedMessage("showFloatingWindow", jSONObject, null);
                            iEmbedView.onReceivedMessage("play", jSONObject, null);
                        } catch (Throwable th) {
                            RVLogger.e(th.getMessage());
                        }
                    }
                });
            }
        }
    }

    @Override // com.alibaba.ariver.app.api.point.page.PagePausePoint
    public void onPagePause(Page page) {
        RVLogger.e("onPagePause");
    }

    @Override // com.alibaba.ariver.app.api.point.page.PageResumePoint
    public void onPageResume(Page page) {
        PageContext pageContext = page.getPageContext();
        if (pageContext != null) {
            IEmbedViewManager embedViewManager = pageContext.getEmbedViewManager();
            final JSONObject jSONObject = new JSONObject();
            jSONObject.put("isShow", (Object) Boolean.FALSE);
            jSONObject.put(MediationConstant.KEY_USE_POLICY_PAGE_ID, (Object) Long.valueOf(page.getNodeId()));
            for (final IEmbedView iEmbedView : embedViewManager.findAllEmbedView()) {
                ExecutorUtils.runOnMain(new Runnable() { // from class: com.alibaba.alibctriver.live.TBLiveInitPoint.1
                    @Override // java.lang.Runnable
                    public void run() {
                        try {
                            BridgeCallback bridgeCallback = new BridgeCallback() { // from class: com.alibaba.alibctriver.live.TBLiveInitPoint.1.1
                                @Override // com.alibaba.ariver.engine.api.bridge.extension.BridgeCallback
                                public void sendBridgeResponse(BridgeResponse bridgeResponse) {
                                }

                                @Override // com.alibaba.ariver.engine.api.bridge.extension.BridgeCallback
                                public void sendJSONResponse(JSONObject jSONObject2) {
                                }

                                @Override // com.alibaba.ariver.engine.api.bridge.extension.BridgeCallback
                                public void sendJSONResponse(JSONObject jSONObject2, boolean z) {
                                }
                            };
                            iEmbedView.onReceivedMessage("showFloatingWindow", jSONObject, bridgeCallback);
                            iEmbedView.onReceivedMessage("play", jSONObject, bridgeCallback);
                        } catch (Throwable th) {
                            RVLogger.e(th.getMessage());
                        }
                    }
                });
            }
        }
    }

    @Override // com.alibaba.ariver.app.api.point.page.PageShowPoint
    public void onPageShow(Page page, JSONObject jSONObject) {
        RVLogger.e("onPageShow");
    }
}

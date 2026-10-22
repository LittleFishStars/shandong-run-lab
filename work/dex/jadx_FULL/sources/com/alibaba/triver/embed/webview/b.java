package com.alibaba.triver.embed.webview;

import android.app.Activity;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.taobao.windvane.config.WVServerConfig;
import android.taobao.windvane.jsbridge.WVJsBridge;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import com.alibaba.android.arouter.utils.Consts;
import com.alibaba.ariver.app.PageNode;
import com.alibaba.ariver.app.api.App;
import com.alibaba.ariver.app.api.EmbedType;
import com.alibaba.ariver.app.api.Page;
import com.alibaba.ariver.engine.api.EngineUtils;
import com.alibaba.ariver.engine.api.Render;
import com.alibaba.ariver.engine.api.bridge.extension.BridgeCallback;
import com.alibaba.ariver.engine.api.bridge.extension.BridgeResponse;
import com.alibaba.ariver.engine.api.bridge.model.CreateParams;
import com.alibaba.ariver.engine.api.bridge.model.LoadParams;
import com.alibaba.ariver.engine.api.bridge.model.RenderCallContext;
import com.alibaba.ariver.engine.api.bridge.model.SendToRenderCallback;
import com.alibaba.ariver.engine.api.embedview.IEmbedCallback;
import com.alibaba.ariver.integration.embedview.BaseEmbedView;
import com.alibaba.ariver.kernel.RVConstants;
import com.alibaba.ariver.kernel.common.RVProxy;
import com.alibaba.ariver.kernel.common.utils.BundleUtils;
import com.alibaba.ariver.kernel.common.utils.ExecutorUtils;
import com.alibaba.ariver.kernel.common.utils.JSONUtils;
import com.alibaba.ariver.kernel.common.utils.RVLogger;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.triver.kit.api.appmonitor.TriverLaunchPointer;
import com.alibaba.triver.kit.api.orange.TROrangeController;
import com.alibaba.triver.kit.api.proxy.ITriverAppMonitorProxy;
import com.alipay.sdk.m.y.l;
import com.ut.mini.UTAnalytics;
import com.ut.mini.UTPageStatus;
import com.zj.adlib.u15;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public class b extends BaseEmbedView {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final String f24908a = "postMessage";
    public static final String b = "onToWebViewMessage";
    public static final String c = "web-view";
    private static final String e = "EmbedWVWebView";
    Render d;
    private String f;
    private Page g;
    private boolean h;
    private View.OnLayoutChangeListener i = new View.OnLayoutChangeListener() { // from class: com.alibaba.triver.embed.webview.b.4
        @Override // android.view.View.OnLayoutChangeListener
        public void onLayoutChange(View view, int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8) {
            ExecutorUtils.runOnMain(new Runnable() { // from class: com.alibaba.triver.embed.webview.b.4.1
                @Override // java.lang.Runnable
                public void run() {
                    ViewGroup.LayoutParams layoutParams;
                    if (b.this.h) {
                        try {
                            b bVar = b.this;
                            if (bVar.d == null || ((BaseEmbedView) bVar).mOuterPage == null) {
                                return;
                            }
                            View view2 = ((BaseEmbedView) b.this).mOuterPage.getRender().getView();
                            View view3 = b.this.d.getView();
                            int width = view2.getWidth();
                            int height = view2.getHeight();
                            if ((view3.getWidth() == width && view3.getHeight() == height) || (layoutParams = view3.getLayoutParams()) == null) {
                                return;
                            }
                            if (layoutParams.width == width && layoutParams.height == height) {
                                return;
                            }
                            layoutParams.width = width;
                            layoutParams.height = height;
                            view3.setLayoutParams(layoutParams);
                        } catch (Exception e2) {
                            RVLogger.e(b.e, "onLayoutChange exception:", e2);
                        }
                    }
                }
            }, 16L);
        }
    };

    private boolean a() {
        return true;
    }

    @Override // com.alibaba.ariver.engine.api.embedview.IEmbedView
    public Bitmap getSnapshot() {
        return a(this.d.getView());
    }

    @Override // com.alibaba.ariver.engine.api.embedview.IEmbedView
    public String getType() {
        return "webview";
    }

    @Override // com.alibaba.ariver.engine.api.embedview.IEmbedView
    public View getView(int i, int i2, String str, String str2, Map<String, String> map) {
        RVLogger.d(e, "getView, width:" + i + ", height:" + i2);
        if (map != null && map.containsKey("appId")) {
            this.f = map.get("appId");
        }
        View view = this.d.getView();
        if (i != 0 && i2 != 0) {
            view.setLayoutParams(new ViewGroup.LayoutParams(i, i2));
        }
        return view;
    }

    @Override // com.alibaba.ariver.engine.api.embedview.IEmbedView
    public void onAttachedToWebView() {
    }

    @Override // com.alibaba.ariver.integration.embedview.BaseEmbedView, com.alibaba.ariver.engine.api.embedview.IEmbedView
    public void onCreate(Map<String, String> map) {
        super.onCreate(map);
        RVLogger.e(e, "onCreate in");
        CreateParams createParams = new CreateParams();
        createParams.startParams = this.mOuterPage.getRender().getStartParams();
        createParams.useForEmbed = true;
        Bundle bundleClone = BundleUtils.clone(this.mOuterApp.getStartParams());
        bundleClone.putString("MINI-PROGRAM-WEB-VIEW-TAG", this.mOuterApp.getAppId());
        PageNode pageNode = new PageNode(this.mOuterApp, this.mOuterPage.getPageURI(), bundleClone, BundleUtils.clone(this.mOuterApp.getSceneParams()), EmbedType.FULL);
        this.g = pageNode;
        this.mOuterApp.pushChild(pageNode);
        this.g.bindContext(this.mOuterPage.getPageContext());
        this.g.getSceneParams().putString(RVConstants.EXTRA_EMBED_VIEW_ID, this.mViewId);
        this.d = this.g.getRender();
        this.mOuterPage.setExitListener(new Page.ExitListener() { // from class: com.alibaba.triver.embed.webview.b.1
            @Override // com.alibaba.ariver.app.api.Page.ExitListener
            public void onExit() {
                RVLogger.e(b.e, "OUTER EXIT");
            }
        });
        this.g.setExitListener(new Page.ExitListener() { // from class: com.alibaba.triver.embed.webview.b.2
            @Override // com.alibaba.ariver.app.api.Page.ExitListener
            public void onExit() {
                RVLogger.e(b.e, "IN EXIT");
                if (((BaseEmbedView) b.this).mOuterPage != null) {
                    ((BaseEmbedView) b.this).mOuterPage.exit(true);
                }
            }
        });
    }

    @Override // com.alibaba.ariver.integration.embedview.BaseEmbedView, com.alibaba.ariver.engine.api.embedview.IEmbedView
    public void onDestroy() {
        Page page = this.g;
        if (page != null) {
            page.exit(true);
        }
        super.onDestroy();
        this.d.destroy();
        if (TROrangeController.enableWVJSBridgeEnable()) {
            WVJsBridge.getInstance().setEnabled(true);
        }
    }

    @Override // com.alibaba.ariver.engine.api.embedview.IEmbedView
    public void onDetachedToWebView() {
    }

    @Override // com.alibaba.ariver.engine.api.embedview.IEmbedView
    public void onEmbedViewVisibilityChanged(int i) {
    }

    @Override // com.alibaba.ariver.integration.embedview.BaseEmbedView, com.alibaba.ariver.engine.api.embedview.IEmbedView
    public void onParamChanged(String[] strArr, String[] strArr2) {
        try {
            super.onParamChanged(strArr, strArr2);
            HashMap map = new HashMap();
            for (int i = 0; i < strArr.length; i++) {
                map.put(strArr[i], strArr2[i]);
            }
            a(map);
        } catch (Exception e2) {
            RVLogger.e(e, "onParamChanged exception:", e2);
        }
    }

    @Override // com.alibaba.ariver.engine.api.embedview.IEmbedView
    public void onReceivedMessage(String str, JSONObject jSONObject, BridgeCallback bridgeCallback) {
        RVLogger.e(e, "onReceivedMessage:" + jSONObject.toJSONString());
        if (!f24908a.equals(str)) {
            RVLogger.d(e, "onReceivedMessage...need not process actionType=" + str);
            return;
        }
        if (this.g == null || this.d == null) {
            RVLogger.d(e, "onReceivedMessage...mEmbedPage is null");
            return;
        }
        int i = JSONUtils.getInt(jSONObject, RenderCallContext.TYPE_CALLBACK);
        JSONObject jSONObject2 = JSONUtils.getJSONObject(jSONObject, "res", null);
        JSONObject jSONObject3 = new JSONObject();
        jSONObject3.put(RenderCallContext.TYPE_CALLBACK, (Object) Integer.valueOf(i));
        jSONObject3.put("res", (Object) jSONObject2);
        JSONObject jSONObject4 = new JSONObject();
        jSONObject4.put("data", (Object) jSONObject3);
        EngineUtils.sendToRender(this.d, "onToWebViewMessage", jSONObject4, null);
    }

    @Override // com.alibaba.ariver.engine.api.embedview.IEmbedView
    public void onReceivedRender(JSONObject jSONObject, BridgeCallback bridgeCallback) {
        App app;
        RVLogger.e(e, "onReceivedRender:" + jSONObject.toJSONString());
        String string = jSONObject.getString("src");
        RVLogger.d(e, "onReceivedRender...url=" + string);
        if (!TextUtils.isEmpty(string) && string.indexOf("ignore2006=1") >= 0 && (app = this.mOuterApp) != null && (app.getAppContext().getContext() instanceof Activity)) {
            UTAnalytics.getInstance().getDefaultTracker().updatePageStatus(this.mOuterApp.getAppContext().getContext(), UTPageStatus.UT_H5_IN_WebView);
        }
        if (!TextUtils.isEmpty(this.f)) {
            bridgeCallback.sendBridgeResponse(new BridgeResponse.Error(2, "EmbedID is null"));
            return;
        }
        LoadParams loadParams = new LoadParams();
        loadParams.url = string;
        this.d.load(loadParams);
        try {
            ((ITriverAppMonitorProxy) RVProxy.get(ITriverAppMonitorProxy.class)).commitTriverComponent(TriverLaunchPointer.build().setApp(this.mOuterApp).setStartParams(this.mOuterApp.getStartParams()).setStatus(Double.valueOf(1.0d)).create(), "web-view", string);
        } catch (Throwable th) {
            RVLogger.w(e, th.getMessage());
        }
        if (TROrangeController.enableWVJSBridgeEnable()) {
            if (WVServerConfig.isTrustedUrl(string)) {
                WVJsBridge.getInstance().setEnabled(true);
            } else {
                WVJsBridge.getInstance().setEnabled(false);
            }
        }
        bridgeCallback.sendBridgeResponse(BridgeResponse.SUCCESS);
    }

    @Override // com.alibaba.ariver.engine.api.embedview.IEmbedView
    public void onRequestPermissionResult(int i, String[] strArr, int[] iArr) {
    }

    @Override // com.alibaba.ariver.engine.api.embedview.IEmbedView
    public void onWebViewPause() {
    }

    @Override // com.alibaba.ariver.engine.api.embedview.IEmbedView
    public void onWebViewResume() {
    }

    @Override // com.alibaba.ariver.integration.embedview.BaseEmbedView, com.alibaba.ariver.engine.api.embedview.IEmbedView
    public void sendEvent(String str, JSONObject jSONObject, final IEmbedCallback iEmbedCallback) {
        if (this.mOuterPage == null) {
            throw new IllegalStateException("You should call super.onCreate first!!!");
        }
        JSONObject jSONObject2 = new JSONObject();
        if (!str.equals("onToWebViewMessage")) {
            str = "nbcomponent." + getType() + Consts.DOT + str;
        }
        if (jSONObject != null) {
            jSONObject.put("element", (Object) this.mViewId);
            jSONObject2.put("data", (Object) jSONObject);
        }
        Render render = this.mOuterPage.getRender();
        EngineUtils.sendToRender(render, render.getEngine().getEngineRouter().getWorkerById(EngineUtils.getWorkerId(render)), str, jSONObject2, new SendToRenderCallback() { // from class: com.alibaba.triver.embed.webview.b.3
            @Override // com.alibaba.ariver.engine.api.bridge.model.SendToRenderCallback
            public void onCallBack(JSONObject jSONObject3) {
                IEmbedCallback iEmbedCallback2 = iEmbedCallback;
                if (iEmbedCallback2 != null) {
                    iEmbedCallback2.onResponse(jSONObject3);
                }
            }
        });
    }

    private Bitmap a(View view) {
        if (view == null) {
            return null;
        }
        Bitmap bitmapCreateBitmap = Bitmap.createBitmap(view.getWidth(), view.getHeight(), Bitmap.Config.ARGB_8888);
        Canvas canvas = new Canvas(bitmapCreateBitmap);
        view.layout(view.getLeft(), view.getTop(), view.getRight(), view.getBottom());
        Drawable background = view.getBackground();
        if (background != null) {
            background.draw(canvas);
        } else {
            canvas.drawColor(-1);
        }
        view.draw(canvas);
        return bitmapCreateBitmap;
    }

    private JSONObject a(JSONObject jSONObject) {
        if (jSONObject == null || jSONObject.isEmpty()) {
            return null;
        }
        JSONObject jSONObject2 = new JSONObject();
        jSONObject.put("data", (Object) jSONObject);
        return jSONObject2;
    }

    private void a(Map<String, String> map) {
        boolean zEquals;
        boolean zEquals2;
        String[] strArrSplit;
        if (map == null || !a()) {
            return;
        }
        String str = map.get("style");
        if (!TextUtils.isEmpty(str)) {
            String[] strArrSplit2 = str.split(l.b);
            if (strArrSplit2 != null && strArrSplit2.length > 0) {
                zEquals = false;
                zEquals2 = false;
                for (String str2 : strArrSplit2) {
                    if (zEquals && zEquals2) {
                        break;
                    }
                    String strTrim = str2.trim();
                    if (strTrim.startsWith("width:")) {
                        String[] strArrSplit3 = strTrim.split(u15.f19942b);
                        if (strArrSplit3 != null && strArrSplit3.length == 2) {
                            zEquals = TextUtils.equals(strArrSplit3[1].trim(), "100%");
                        }
                    } else if (strTrim.startsWith("height:") && (strArrSplit = strTrim.split(u15.f19942b)) != null && strArrSplit.length == 2) {
                        zEquals2 = TextUtils.equals(strArrSplit[1].trim(), "100%");
                    }
                }
            } else {
                zEquals = false;
                zEquals2 = false;
            }
            this.h = zEquals && zEquals2;
        }
        if (!this.h || this.d.getView() == null) {
            return;
        }
        this.d.getView().removeOnLayoutChangeListener(this.i);
        this.d.getView().addOnLayoutChangeListener(this.i);
    }
}

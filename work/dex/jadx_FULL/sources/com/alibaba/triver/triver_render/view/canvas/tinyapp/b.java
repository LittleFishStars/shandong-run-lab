package com.alibaba.triver.triver_render.view.canvas.tinyapp;

import android.content.Context;
import android.graphics.Bitmap;
import android.text.TextUtils;
import android.view.View;
import com.alibaba.ariver.app.api.App;
import com.alibaba.ariver.app.api.Page;
import com.alibaba.ariver.engine.api.bridge.extension.BridgeCallback;
import com.alibaba.ariver.engine.api.bridge.extension.BridgeResponse;
import com.alibaba.ariver.integration.embedview.BaseEmbedView;
import com.alibaba.ariver.kernel.common.utils.RVLogger;
import com.alibaba.ariver.resource.api.models.AppInfoModel;
import com.alibaba.ariver.resource.api.models.AppModel;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.mobile.tinycanvas.misc.TinyAppEnv;
import com.alibaba.mobile.tinycanvas.misc.TinyImageCache;
import com.alibaba.mobile.tinycanvas.view.EmbedCanvas;
import com.alibaba.mobile.tinycanvas.widget.TinyCanvasFeature;
import com.alibaba.mobile.tinycanvas.widget.TinyCanvasListener;
import com.alibaba.triver.kit.api.appmonitor.LaunchMonitorUtils;
import com.taobao.phenix.compat.TBScheduler4Phenix;
import com.taobao.phenix.intf.Phenix;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public class b extends BaseEmbedView {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final String f25229a = "canvas";
    public static final String b = "DefaultCanvasSession";
    public static final String c = "H5_PAGE_REF";
    private static final String e = "EmbedGCanvasView";
    private EmbedCanvas f;
    private TinyAppEnv g;
    private String h;
    private Context i;
    private TinyCanvasFeature j;
    private String k = "";
    private boolean l = false;
    TinyCanvasListener d = new TinyCanvasListener() { // from class: com.alibaba.triver.triver_render.view.canvas.tinyapp.b.1
        public void a() {
        }

        public void a(View view, String str, JSONObject jSONObject) {
        }

        public void a(String str, boolean z) {
        }

        public void b() {
            b.this.f.getTinyCanvasWidget().getGCanvasObject().setCanvasDataTrace(new e(b.this.g));
        }

        public void b(String str, boolean z) {
        }

        public void c() {
        }

        public void d() {
        }

        public void e() {
        }

        public void f() {
        }

        public void g() {
        }

        public void h() {
        }
    };

    private TinyAppEnv c() {
        this.h = b;
        String appId = getOuterPage().getApp().getAppId();
        String pageURI = getOuterPage().getPageURI();
        TinyAppEnv tinyAppEnv = new TinyAppEnv();
        tinyAppEnv.setAppId(appId);
        tinyAppEnv.setAppSessionId(this.h);
        tinyAppEnv.setPagePath(pageURI);
        tinyAppEnv.setPageId(getOuterPage().getPageId() + "");
        return tinyAppEnv;
    }

    private TinyCanvasFeature d() {
        return new TinyCanvasFeature();
    }

    private Map<String, Object> e() {
        HashMap map = new HashMap();
        map.put(c, getOuterPage());
        return map;
    }

    private void f() {
        App app;
        AppInfoModel appInfoModel;
        try {
            if (this.l || (app = this.mOuterApp) == null || (appInfoModel = ((AppModel) app.getData(AppModel.class)).getAppInfoModel()) == null) {
                return;
            }
            String str = this.k;
            Page page = this.mOuterPage;
            LaunchMonitorUtils.commitApmCanvas("gcanvas", str, appInfoModel, page != null ? page.getPageURI() : "");
            this.l = true;
        } catch (Exception e2) {
            RVLogger.e(e, e2.getMessage());
        }
    }

    @Override // com.alibaba.ariver.engine.api.embedview.IEmbedView
    public Bitmap getSnapshot() {
        return null;
    }

    @Override // com.alibaba.ariver.engine.api.embedview.IEmbedView
    public String getType() {
        return f25229a;
    }

    @Override // com.alibaba.ariver.engine.api.embedview.IEmbedView
    public View getView(int i, int i2, String str, String str2, Map<String, String> map) {
        HashMap map2 = new HashMap();
        map2.put("width", Integer.valueOf(i));
        map2.put("height", Integer.valueOf(i2));
        map2.put("viewId", str);
        for (String str3 : map.keySet()) {
            map2.put(str3, map.get(str3));
        }
        return this.f.getView(map2);
    }

    @Override // com.alibaba.ariver.engine.api.embedview.IEmbedView
    public void onAttachedToWebView() {
    }

    @Override // com.alibaba.ariver.integration.embedview.BaseEmbedView, com.alibaba.ariver.engine.api.embedview.IEmbedView
    public void onCreate(Map<String, String> map) {
        super.onCreate(map);
        a.a();
        this.i = a();
        b();
        this.j = d();
        this.g = c();
        HashMap map2 = new HashMap();
        map2.put("tinyAppEnv", this.g);
        map2.put("tinyCanvasFeature", this.j);
        map2.put("tinyJsChannel", new f(new WeakReference(this)));
        map2.put("canvasSessionPayload", e());
        EmbedCanvas embedCanvas = new EmbedCanvas(this.i, map2);
        this.f = embedCanvas;
        embedCanvas.getTinyCanvasWidget().setListener(this.d);
    }

    @Override // com.alibaba.ariver.integration.embedview.BaseEmbedView, com.alibaba.ariver.engine.api.embedview.IEmbedView
    public void onDestroy() {
        super.onDestroy();
        this.f.onWebViewDestory();
        TinyImageCache.getInstance().removeGroup(this.h);
    }

    @Override // com.alibaba.ariver.engine.api.embedview.IEmbedView
    public void onDetachedToWebView() {
    }

    @Override // com.alibaba.ariver.engine.api.embedview.IEmbedView
    public void onEmbedViewVisibilityChanged(int i) {
    }

    @Override // com.alibaba.ariver.engine.api.embedview.IEmbedView
    public void onReceivedMessage(String str, JSONObject jSONObject, BridgeCallback bridgeCallback) {
        this.f.onReceivedMessage(str, jSONObject, bridgeCallback);
    }

    @Override // com.alibaba.ariver.engine.api.embedview.IEmbedView
    public void onReceivedRender(JSONObject jSONObject, BridgeCallback bridgeCallback) {
        this.f.onReceivedRender(jSONObject, bridgeCallback);
        bridgeCallback.sendBridgeResponse(BridgeResponse.SUCCESS);
        if (jSONObject != null && !TextUtils.isEmpty(jSONObject.getString("type"))) {
            this.k = jSONObject.getString("type");
        }
        if (this.l) {
            return;
        }
        f();
    }

    @Override // com.alibaba.ariver.engine.api.embedview.IEmbedView
    public void onRequestPermissionResult(int i, String[] strArr, int[] iArr) {
    }

    @Override // com.alibaba.ariver.engine.api.embedview.IEmbedView
    public void onWebViewPause() {
        this.f.onWebViewPause();
    }

    @Override // com.alibaba.ariver.engine.api.embedview.IEmbedView
    public void onWebViewResume() {
        this.f.onWebViewResume();
    }

    private Context a() {
        return this.mOuterApp.getAppContext().getContext();
    }

    private void b() {
        Phenix.instance().with(this.i);
        TBScheduler4Phenix.setupScheduler(true, true);
        Phenix.instance().build();
    }
}

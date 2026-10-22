package com.alibaba.triver.triver_render.view.canvas.tinyapp;

import android.text.TextUtils;
import com.alibaba.ariver.app.api.App;
import com.alibaba.ariver.app.api.Page;
import com.alibaba.ariver.engine.api.bridge.extension.BridgeCallback;
import com.alibaba.ariver.engine.api.bridge.extension.BridgeResponse;
import com.alibaba.ariver.engine.api.bridge.extension.annotation.BindingCallback;
import com.alibaba.ariver.engine.api.bridge.extension.annotation.BindingNode;
import com.alibaba.ariver.engine.api.bridge.extension.annotation.BindingParam;
import com.alibaba.ariver.kernel.api.annotation.ActionFilter;
import com.alibaba.ariver.kernel.api.annotation.ThreadType;
import com.alibaba.ariver.kernel.api.extension.bridge.BridgeExtension;
import com.alibaba.ariver.kernel.api.security.Permission;
import com.alibaba.ariver.kernel.common.service.executor.ExecutorType;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.mobile.tinycanvas.misc.TinyImageBatchLoadParams;
import com.alibaba.mobile.tinycanvas.misc.TinyImageLoader;
import com.alibaba.mobile.tinycanvas.misc.TinyImageLoaderParams;
import com.alibaba.mobile.tinycanvas.plugin.TinyImageLoadResult;
import com.alibaba.mobile.tinycanvas.widget.PreloadImageWidget;
import com.alibaba.triver.kit.api.common.TRiverConstants;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public class CanvasPreloadImageExtension implements BridgeExtension {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private PreloadImageWidget f25227a;
    private String b = b.b;

    private void a(App app, Page page, JSONArray jSONArray, BridgeCallback bridgeCallback) {
        try {
            Class<?> cls = Class.forName("com.alibaba.triver.flutter.canvas.FCanvasPreloadImageExtension");
            cls.getDeclaredMethod("preloadCanvasImage", App.class, Page.class, Object.class, BridgeCallback.class).invoke(cls.newInstance(), app, page, jSONArray, bridgeCallback);
        } catch (Exception unused) {
        }
    }

    private void b(App app, Page page, JSONArray jSONArray, final BridgeCallback bridgeCallback) {
        a(app);
        if (jSONArray.size() <= 0) {
            bridgeCallback.sendBridgeResponse(BridgeResponse.INVALID_PARAM);
        }
        ArrayList arrayList = new ArrayList();
        for (int i = 0; i < jSONArray.size(); i++) {
            String string = jSONArray.getString(i);
            if (!TextUtils.isEmpty(string)) {
                arrayList.add(string);
            }
        }
        TinyImageBatchLoadParams tinyImageBatchLoadParams = new TinyImageBatchLoadParams();
        tinyImageBatchLoadParams.paths = arrayList;
        tinyImageBatchLoadParams.sessionId = this.b;
        tinyImageBatchLoadParams.extParams = new HashMap();
        tinyImageBatchLoadParams.extParams.put("h5pageReference", page);
        this.f25227a.doPreloadImage(tinyImageBatchLoadParams, new TinyImageLoader.ImageBatchLoadCallback() { // from class: com.alibaba.triver.triver_render.view.canvas.tinyapp.CanvasPreloadImageExtension.1
            public void a(List<TinyImageLoadResult> list) {
                if (list != null) {
                    CanvasPreloadImageExtension.this.a(list, bridgeCallback);
                }
            }
        });
    }

    @Override // com.alibaba.ariver.kernel.api.extension.Extension
    public void onFinalized() {
    }

    @Override // com.alibaba.ariver.kernel.api.extension.Extension
    public void onInitialized() {
        this.b = b.b;
    }

    @Override // com.alibaba.ariver.kernel.api.security.Guard
    public Permission permit() {
        return null;
    }

    @ThreadType(ExecutorType.IO)
    @ActionFilter
    public void preloadCanvasImage(@BindingNode(App.class) App app, @BindingNode(Page.class) Page page, @BindingParam({"urls"}) Object obj, @BindingCallback BridgeCallback bridgeCallback) {
        if (obj == null) {
            bridgeCallback.sendBridgeResponse(BridgeResponse.INVALID_PARAM);
        }
        if (!(obj instanceof JSONArray)) {
            bridgeCallback.sendBridgeResponse(BridgeResponse.INVALID_PARAM);
            return;
        }
        JSONArray jSONArray = (JSONArray) obj;
        if (app == null || app.getStartParams() == null || !app.getStartParams().containsKey(TRiverConstants.KEY_ENABLE_SKIA)) {
            b(app, page, jSONArray, bridgeCallback);
            return;
        }
        try {
            a(app, page, jSONArray, bridgeCallback);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(List<TinyImageLoadResult> list, BridgeCallback bridgeCallback) {
        JSONArray jSONArray = new JSONArray();
        for (TinyImageLoadResult tinyImageLoadResult : list) {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("id", (Object) Integer.valueOf(tinyImageLoadResult.id));
            jSONObject.put("width", (Object) Integer.valueOf(tinyImageLoadResult.width));
            jSONObject.put("height", (Object) Integer.valueOf(tinyImageLoadResult.height));
            jSONObject.put("url", (Object) tinyImageLoadResult.path);
            jSONArray.add(jSONObject);
        }
        JSONObject jSONObject2 = new JSONObject();
        jSONObject2.put("data", (Object) jSONArray);
        bridgeCallback.sendJSONResponse(jSONObject2);
    }

    private void a(App app) {
        if (this.f25227a == null) {
            TinyImageLoaderParams tinyImageLoaderParams = new TinyImageLoaderParams();
            tinyImageLoaderParams.enableCache = true;
            tinyImageLoaderParams.traceDomId = "PRELOAD";
            tinyImageLoaderParams.threadHandler = null;
            tinyImageLoaderParams.traceAppId = app.getAppId();
            tinyImageLoaderParams.cube = false;
            this.f25227a = new PreloadImageWidget(tinyImageLoaderParams);
        }
    }
}

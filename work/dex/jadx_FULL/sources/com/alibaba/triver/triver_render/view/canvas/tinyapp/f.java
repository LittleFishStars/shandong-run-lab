package com.alibaba.triver.triver_render.view.canvas.tinyapp;

import com.alibaba.ariver.engine.api.bridge.extension.BridgeCallback;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.mobile.tinycanvas.misc.BaseJsChannel;
import java.lang.ref.WeakReference;
import java.util.Map;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public class f extends BaseJsChannel {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private WeakReference<b> f25236a;

    public f(WeakReference<b> weakReference) {
        this.f25236a = weakReference;
    }

    public void a(Object obj, Map<String, Object> map) {
        if (obj != null && (obj instanceof BridgeCallback) && (map instanceof JSONObject)) {
            ((BridgeCallback) obj).sendJSONResponse((JSONObject) map);
        }
    }

    public void a(String str, Map<String, Object> map) {
        b bVar = this.f25236a.get();
        if (bVar == null || !(map instanceof JSONObject)) {
            return;
        }
        bVar.sendEvent(str, (JSONObject) map, null);
    }
}

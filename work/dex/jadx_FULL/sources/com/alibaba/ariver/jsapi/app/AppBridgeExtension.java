package com.alibaba.ariver.jsapi.app;

import android.text.TextUtils;
import com.alibaba.ariver.app.api.App;
import com.alibaba.ariver.app.api.Page;
import com.alibaba.ariver.engine.api.bridge.extension.annotation.BindingNode;
import com.alibaba.ariver.jsapi.NotificationBridgeExtension;
import com.alibaba.ariver.kernel.api.annotation.ActionFilter;
import com.alibaba.ariver.kernel.api.annotation.AutoCallback;
import com.alibaba.ariver.kernel.api.extension.bridge.BridgeExtension;
import com.alibaba.ariver.kernel.api.security.Permission;
import com.alibaba.ariver.kernel.common.utils.RVLogger;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public class AppBridgeExtension implements BridgeExtension {
    @ActionFilter
    @AutoCallback
    public JSONObject getSceneStackInfo(@BindingNode(App.class) App app, @BindingNode(Page.class) Page page) {
        JSONArray jSONArray = new JSONArray();
        int childCount = app.getChildCount();
        Page activePage = app.getActivePage();
        String pageURI = activePage != null ? activePage.getPageURI() : "";
        String pageURI2 = page.getPageURI();
        int i = -1;
        for (int i2 = 0; i2 < childCount; i2++) {
            String pageURI3 = app.getPageByIndex(i2).getPageURI();
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("url", (Object) pageURI3);
            if (TextUtils.equals(pageURI2, pageURI3)) {
                i = i2;
            }
            if (TextUtils.equals(pageURI, pageURI3)) {
                jSONObject.put("isTop", (Object) Boolean.TRUE);
            } else {
                jSONObject.put("isTop", (Object) Boolean.FALSE);
            }
            jSONArray.add(jSONObject);
        }
        JSONObject jSONObject2 = new JSONObject();
        jSONObject2.put("count", (Object) Integer.valueOf(childCount));
        jSONObject2.put("currentIndex", (Object) Integer.valueOf(i));
        jSONObject2.put("detail", (Object) jSONArray);
        RVLogger.d(NotificationBridgeExtension.TAG, "count = " + childCount + " , currentIndex = " + i + " detail :" + jSONArray);
        return jSONObject2;
    }

    @Override // com.alibaba.ariver.kernel.api.extension.Extension
    public void onFinalized() {
    }

    @Override // com.alibaba.ariver.kernel.api.extension.Extension
    public void onInitialized() {
    }

    @Override // com.alibaba.ariver.kernel.api.security.Guard
    public Permission permit() {
        return null;
    }
}

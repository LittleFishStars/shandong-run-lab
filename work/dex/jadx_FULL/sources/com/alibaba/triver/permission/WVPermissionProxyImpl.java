package com.alibaba.triver.permission;

import android.text.TextUtils;
import com.alibaba.ariver.app.api.Page;
import com.alibaba.ariver.kernel.RVParams;
import com.alibaba.ariver.kernel.common.RVProxy;
import com.alibaba.ariver.permission.api.proxy.EmbedWebViewJsApiPermissionProxy;
import com.alibaba.ariver.v8worker.JSApiCachePoint;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.triver.embed.webview.b;
import com.alibaba.triver.kit.api.common.TRiverConstants;
import com.alibaba.triver.kit.api.proxy.IConfigProxy;
import java.util.Map;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public class WVPermissionProxyImpl implements EmbedWebViewJsApiPermissionProxy {
    private boolean a() {
        Map<String, String> configsByGroup;
        IConfigProxy iConfigProxy = (IConfigProxy) RVProxy.get(IConfigProxy.class);
        if (iConfigProxy == null || (configsByGroup = iConfigProxy.getConfigsByGroup("triver_common_config")) == null || configsByGroup.isEmpty()) {
            return false;
        }
        return "true".equals(configsByGroup.get(TRiverConstants.ORANGE_KEY_WEBVIEW_PERMISSION_DOWNGRADE));
    }

    @Override // com.alibaba.ariver.permission.api.proxy.EmbedWebViewJsApiPermissionProxy
    public boolean shouldInterceptJSApiCall(String str, Page page, String str2, String str3, JSONObject jSONObject) {
        JSONArray array;
        String configsByGroupAndName = ((IConfigProxy) RVProxy.get(IConfigProxy.class)).getConfigsByGroupAndName("triver_common_config", TRiverConstants.ORANGE_KEY_TRIVER_WV_WHITE_LIST, "");
        if (!TextUtils.isEmpty(configsByGroupAndName) && JSON.parseArray(configsByGroupAndName).contains(str2)) {
            return false;
        }
        String configsByGroupAndName2 = ((IConfigProxy) RVProxy.get(IConfigProxy.class)).getConfigsByGroupAndName("triver_common_config", TRiverConstants.ORANGE_KEY_TRIVER_WV_API_LIST, "");
        if (TextUtils.isEmpty(configsByGroupAndName2)) {
            array = new JSONArray();
            array.add("pushWindow");
            array.add("popWindow");
            array.add("switchTab");
            array.add("popTo");
            array.add("imageViewer");
            array.add("alert");
            array.add(RVParams.LONG_SHOW_LOADING);
            array.add("hideLoading");
            array.add("setTinyLocalStorage");
            array.add(JSApiCachePoint.GET_LOCAL_STORAGE);
            array.add("removeTinyLocalStorage");
            array.add("clearTinyLocalStorage");
            array.add("getTinyLocalStorageInfo");
            array.add("getNetworkType");
            array.add("postWebViewMessage");
            array.add("onToWebViewMessage");
        } else {
            array = JSON.parseArray(configsByGroupAndName2);
        }
        if (a()) {
            array.add(b.f24908a);
            array.add("registerWorker");
            array.add("NBComponent.render");
            array.add("NBComponent.remove");
            array.add("NBComponent.sendMessage");
            array.add("NBComponent.setData");
            array.add("internalAPI");
            array.add("sendMtop");
            array.add("sendRemoteDebugMessage");
            array.add("sendSocketMessage");
        }
        if (array == null || array.size() <= 0) {
            return true;
        }
        int size = array.size();
        for (int i = 0; i < size; i++) {
            if (array.getString(i).equalsIgnoreCase(str)) {
                return false;
            }
        }
        return true;
    }
}

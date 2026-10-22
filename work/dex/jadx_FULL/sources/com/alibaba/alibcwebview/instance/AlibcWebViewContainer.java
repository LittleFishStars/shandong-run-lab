package com.alibaba.alibcwebview.instance;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import android.webkit.WebView;
import com.alibaba.alibcprotocol.base.AlibcProtocolConstant;
import com.alibaba.alibcprotocol.base.AlibcTradeContext;
import com.alibaba.alibcprotocol.callback.AlibcComponentReRenderCallback;
import com.alibaba.alibcprotocol.container.AlibcBaseContainer;
import com.alibaba.alibcprotocol.container.callback.AlibcContainerCallback;
import com.alibaba.alibcprotocol.jsbridge.AlibcPluginManager;
import com.alibaba.alibcprotocol.jsbridge.callback.AlibcPluginCallback;
import com.alibaba.alibcprotocol.manager.AlibcSdkManager;
import com.alibaba.alibcprotocol.param.AlibcShowParams;
import com.alibaba.alibcprotocol.route.RouteRequest;
import com.alibaba.alibcprotocol.utils.ResourceUtils;
import com.alibaba.alibcwebview.container.AlibcWebViewActivity;
import com.alibaba.alibcwebview.container.ThirdWebViewActivity;
import com.alibaba.ariver.kernel.api.monitor.PerfId;
import com.alibaba.baichuan.trade.common.ut.AlibcUserTracker;
import com.alibaba.baichuan.trade.common.ut.UserTrackConstant;
import com.alibaba.baichuan.trade.common.utils.AlibcLogger;
import com.alibaba.baichuan.trade.common.utils.StringUtils;
import com.alibaba.fastjson.JSONObject;
import java.lang.ref.WeakReference;
import java.util.Map;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public class AlibcWebViewContainer implements AlibcBaseContainer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final String f23720a = "AlibcWebViewContainer";
    private AlibcTradeContext b;

    @Override // com.alibaba.alibcprotocol.container.AlibcBaseContainer
    public void closeContainer() {
    }

    @Override // com.alibaba.alibcprotocol.container.AlibcBaseContainer
    public String getContainerTag() {
        return "h5";
    }

    @Override // com.alibaba.alibcprotocol.container.AlibcBaseContainer
    public void goBack(boolean z) {
        Activity activity = this.b.mActivity.get();
        WebView webView = this.b.mWebView.get();
        if (activity == null || webView == null || StringUtils.obj2Boolean(webView.getTag(ResourceUtils.getIdentifier(activity, "id", "com_taobao_biz_ultimate_webview_click")))) {
            return;
        }
        if (webView.canGoBack()) {
            webView.goBack();
        } else {
            activity.finish();
        }
    }

    @Override // com.alibaba.alibcprotocol.container.AlibcBaseContainer
    public void initContainer(AlibcTradeContext alibcTradeContext, AlibcPluginCallback alibcPluginCallback, AlibcContainerCallback alibcContainerCallback) {
        this.b = alibcTradeContext;
        AlibcPluginManager.registerPlugin("AliBCBase", "com.alibaba.alibcwebview.jsbridge.plugin.AlibcBasePlugin", alibcPluginCallback);
        AlibcPluginManager.registerPlugin("AliBCNetWork", "com.baichuan.nb_trade.AlibcNetworkPlugin", alibcPluginCallback);
        AlibcPluginManager.registerPlugin("AliBCLogin", "com.alibaba.alibclogin.AlibcLoginPlugin", alibcPluginCallback);
        AlibcPluginManager.registerPlugin("AliBCWebView", "com.alibaba.alibcwebview.jsbridge.plugin.AlibcWebViewPlugin", alibcPluginCallback);
        AlibcPluginManager.registerPlugin("AliBCAppLink", "com.alibaba.alibcapplink.AlibcApplinkPlugin", alibcPluginCallback);
        alibcContainerCallback.onInitSuccess();
    }

    @Override // com.alibaba.alibcprotocol.container.AlibcBaseContainer
    public void reload() {
        WeakReference<WebView> weakReference;
        AlibcTradeContext alibcTradeContext = this.b;
        if (alibcTradeContext == null || (weakReference = alibcTradeContext.mWebView) == null || weakReference.get() == null) {
            return;
        }
        this.b.mWebView.get().reload();
    }

    @Override // com.alibaba.alibcprotocol.container.AlibcBaseContainer
    public void runTask(RouteRequest routeRequest, String str, String str2) {
        Map<String, Object> extParams;
        String str3 = f23720a;
        AlibcLogger.i(str3, "the target load url: " + str);
        if (!AlibcSdkManager.getInstance().supportComponent("webview_sdk")) {
            AlibcLogger.e(str3, "webview component is not supported!");
            return;
        }
        AlibcTradeContext alibcTradeContext = this.b;
        if (alibcTradeContext != null) {
            AlibcShowParams alibcShowParams = alibcTradeContext.showParams;
            if (alibcShowParams != null && alibcShowParams.isNewWindow()) {
                alibcShowParams.setNewWindow(false);
            } else {
                WeakReference<WebView> weakReference = this.b.mWebView;
                if (weakReference != null) {
                    WebView webView = weakReference.get();
                    if (webView != null) {
                        AlibcLogger.i(str3, "load webview page");
                        webView.loadUrl(str);
                        JSONObject jSONObject = new JSONObject();
                        jSONObject.put(UserTrackConstant.URL_TYPE, (Object) getContainerTag());
                        jSONObject.put(UserTrackConstant.ORIGINAL_URL, (Object) str);
                        jSONObject.put(UserTrackConstant.CONTAINER_TYPE, (Object) "h5");
                        AlibcUserTracker.getInstance().trackCounter(UserTrackConstant.E_CONTAINER_LOAD, 1, jSONObject);
                        return;
                    }
                    return;
                }
            }
            WeakReference<Activity> weakReference2 = this.b.mActivity;
            Activity activity = weakReference2 != null ? weakReference2.get() : null;
            if (activity == null) {
                WeakReference<Activity> weakReference3 = this.b.mRawActivity;
                activity = weakReference3 != null ? weakReference3.get() : null;
            }
            if (activity != null) {
                AlibcLogger.i(str3, "load webview page");
                Intent intent = new Intent(activity, (Class<?>) AlibcWebViewActivity.class);
                intent.putExtra(PerfId.loadUrl, str);
                if (routeRequest != null && (extParams = routeRequest.getExtParams()) != null) {
                    String strValueOf = String.valueOf(extParams.get("disableNav"));
                    if (!TextUtils.isEmpty(strValueOf)) {
                        intent.putExtra("disableNav", strValueOf);
                    }
                }
                activity.startActivity(intent);
                JSONObject jSONObject2 = new JSONObject();
                jSONObject2.put(UserTrackConstant.URL_TYPE, (Object) getContainerTag());
                jSONObject2.put(UserTrackConstant.ORIGINAL_URL, (Object) str);
                jSONObject2.put(UserTrackConstant.CONTAINER_TYPE, (Object) "h5");
                AlibcUserTracker.getInstance().trackCounter(UserTrackConstant.E_CONTAINER_LOAD, 1, jSONObject2);
            }
        }
    }

    @Override // com.alibaba.alibcprotocol.container.AlibcBaseContainer
    public void runTask(String str, AlibcComponentReRenderCallback alibcComponentReRenderCallback) {
    }

    @Override // com.alibaba.alibcprotocol.container.AlibcBaseContainer
    public void runTask(String str, String str2) {
    }

    @Override // com.alibaba.alibcprotocol.container.AlibcBaseContainer
    public void runTask(String str, String str2, Context context) {
        if (!AlibcProtocolConstant.THIRD_WEBVIEW.equals(str2) || context == null) {
            return;
        }
        Intent intent = new Intent(context, (Class<?>) ThirdWebViewActivity.class);
        intent.putExtra(PerfId.loadUrl, str);
        context.startActivity(intent);
    }
}

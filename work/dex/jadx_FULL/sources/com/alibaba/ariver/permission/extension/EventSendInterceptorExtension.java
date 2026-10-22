package com.alibaba.ariver.permission.extension;

import com.alibaba.ariver.app.api.Page;
import com.alibaba.ariver.engine.api.security.EventSendInterceptorPoint;
import com.alibaba.ariver.kernel.RVEvents;
import com.alibaba.ariver.kernel.api.node.NodeAware;
import com.alibaba.ariver.kernel.api.security.ApiPermissionCheckResult;
import com.alibaba.ariver.kernel.common.RVProxy;
import com.alibaba.ariver.kernel.common.utils.BundleUtils;
import com.alibaba.ariver.kernel.common.utils.RVLogger;
import com.alibaba.ariver.permission.api.proxy.AuthenticationProxy;
import com.alibaba.fastjson.JSONObject;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public class EventSendInterceptorExtension implements EventSendInterceptorPoint, NodeAware<Page> {
    private static final String TAG = "EventSendInterceptorExtension";
    private static List<String> WHITE_EVENT_LIST;
    private WeakReference<Page> pageReference;
    private AuthenticationProxy rvPermissionServiceProxy;

    static {
        ArrayList arrayList = new ArrayList();
        WHITE_EVENT_LIST = arrayList;
        arrayList.add("JSPlugin_AlipayH5Share");
        WHITE_EVENT_LIST.add(RVEvents.BEFORE_UNLOAD);
        WHITE_EVENT_LIST.add("message");
        WHITE_EVENT_LIST.add(RVEvents.NBCOMPONENT_CANRENDER);
    }

    @Override // com.alibaba.ariver.kernel.api.node.NodeAware
    public Class<Page> getNodeType() {
        return Page.class;
    }

    @Override // com.alibaba.ariver.engine.api.security.EventSendInterceptorPoint
    public boolean needIntercept(String str, JSONObject jSONObject) {
        RVLogger.d(TAG, "send event permission check action=" + str);
        Page page = this.pageReference.get();
        if (page == null) {
            RVLogger.d(TAG, "  page is recycle ,intercept event send");
            return true;
        }
        String string = BundleUtils.getString(page.getStartParams(), "appId");
        ApiPermissionCheckResult apiPermissionCheckResultCheckEventPermission = this.rvPermissionServiceProxy.checkEventPermission(string, str, page);
        RVLogger.d(TAG, "app:" + string + "  send event permission check result is " + apiPermissionCheckResultCheckEventPermission);
        if (apiPermissionCheckResultCheckEventPermission == ApiPermissionCheckResult.IGNORE || WHITE_EVENT_LIST.contains(str)) {
            return false;
        }
        RVLogger.d(TAG, " event is no send permission and not in white list ,intercept");
        return true;
    }

    @Override // com.alibaba.ariver.kernel.api.extension.Extension
    public void onFinalized() {
    }

    @Override // com.alibaba.ariver.kernel.api.extension.Extension
    public void onInitialized() {
        this.rvPermissionServiceProxy = (AuthenticationProxy) RVProxy.get(AuthenticationProxy.class);
    }

    @Override // com.alibaba.ariver.kernel.api.node.NodeAware
    public void setNode(WeakReference<Page> weakReference) {
        this.pageReference = weakReference;
    }
}

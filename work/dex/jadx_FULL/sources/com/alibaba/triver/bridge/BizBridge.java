package com.alibaba.triver.bridge;

import android.content.Intent;
import android.net.Uri;
import android.text.TextUtils;
import androidx.localbroadcastmanager.content.LocalBroadcastManager;
import com.alibaba.ariver.app.api.Page;
import com.alibaba.ariver.engine.api.bridge.extension.BridgeResponse;
import com.alibaba.ariver.engine.api.bridge.extension.annotation.BindingApiContext;
import com.alibaba.ariver.engine.api.bridge.extension.annotation.BindingNode;
import com.alibaba.ariver.engine.api.bridge.extension.annotation.BindingParam;
import com.alibaba.ariver.engine.api.bridge.model.ApiContext;
import com.alibaba.ariver.kernel.api.annotation.ActionFilter;
import com.alibaba.ariver.kernel.api.annotation.AutoCallback;
import com.alibaba.ariver.kernel.api.annotation.ThreadType;
import com.alibaba.ariver.kernel.api.extension.bridge.BridgeExtension;
import com.alibaba.ariver.kernel.api.security.Permission;
import com.alibaba.ariver.kernel.common.RVProxy;
import com.alibaba.ariver.kernel.common.service.executor.ExecutorType;
import com.alibaba.ariver.kernel.common.utils.UrlUtils;
import com.alibaba.ariver.resource.api.models.AppModel;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.triver.app.d;
import com.alibaba.triver.app.g;
import com.alibaba.triver.content.e;
import com.alibaba.triver.impl.TriverLogProxyImpl;
import com.alibaba.triver.kit.api.model.ActionSheetCache;
import com.alibaba.triver.kit.api.proxy.IShareProxy;
import com.alibaba.triver.kit.api.proxy.IUserTrackProxy;
import com.alibaba.triver.kit.api.utils.CommonUtils;
import com.alibaba.triver.kit.api.widget.ITitleBar;
import com.alibaba.triver.kit.api.widget.action.IHideableAction;
import com.alibaba.triver.kit.api.widget.action.IMenuAction;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public class BizBridge implements BridgeExtension {
    private String a(String str) {
        Uri url = UrlUtils.parseUrl(str);
        if (url != null) {
            return url.getFragment();
        }
        return null;
    }

    @ThreadType(ExecutorType.IDLE)
    @ActionFilter
    @AutoCallback
    public BridgeResponse getDeviceId(@BindingApiContext ApiContext apiContext) {
        IUserTrackProxy iUserTrackProxy = (IUserTrackProxy) RVProxy.get(IUserTrackProxy.class);
        if (iUserTrackProxy == null) {
            return BridgeResponse.newError(5, "api not implement");
        }
        String strMd5 = CommonUtils.md5(TriverLogProxyImpl.TLOG_MODULE + iUserTrackProxy.getUtdid(apiContext.getAppContext()));
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("deviceId", (Object) strMd5);
        jSONObject.put("success", (Object) Boolean.TRUE);
        return new BridgeResponse(jSONObject);
    }

    @ThreadType(ExecutorType.UI)
    @ActionFilter
    @AutoCallback
    public BridgeResponse hideOptionMenuItem(@BindingParam({"name"}) String str, @BindingNode(Page.class) Page page) {
        ITitleBar iTitleBarA;
        if (page.getPageContext() == null || !(page.getPageContext().getTitleBar() instanceof e) || !"backToHome".equals(str) || (iTitleBarA = ((e) page.getPageContext().getTitleBar()).a()) == null) {
            return BridgeResponse.FORBIDDEN_ERROR;
        }
        IHideableAction iHideableAction = (IHideableAction) iTitleBarA.getAction(IHideableAction.class);
        if (iHideableAction != null) {
            iHideableAction.hide();
        }
        IMenuAction iMenuAction = (IMenuAction) iTitleBarA.getAction(IMenuAction.class);
        if (iMenuAction != null) {
            iMenuAction.removeItem(IMenuAction.MENU_TYPE.HOME);
        }
        return BridgeResponse.SUCCESS;
    }

    @ThreadType(ExecutorType.UI)
    @ActionFilter
    @AutoCallback
    public BridgeResponse hideShareMenu(@BindingNode(Page.class) Page page) {
        ITitleBar iTitleBarA;
        if (page.getPageContext() == null || !(page.getPageContext().getTitleBar() instanceof e) || (iTitleBarA = ((e) page.getPageContext().getTitleBar()).a()) == null) {
            return BridgeResponse.FORBIDDEN_ERROR;
        }
        IMenuAction iMenuAction = (IMenuAction) iTitleBarA.getAction(IMenuAction.class);
        if (iMenuAction != null) {
            iMenuAction.removeItem(IMenuAction.MENU_TYPE.SHARE);
        }
        return BridgeResponse.SUCCESS;
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

    @ThreadType(ExecutorType.IDLE)
    @ActionFilter
    @AutoCallback
    public BridgeResponse setActionSheet(@BindingParam({"menuList"}) JSONArray jSONArray, @BindingParam({"menuTitle"}) String str, @BindingParam({"menuExtra"}) JSONObject jSONObject, @BindingNode(Page.class) Page page) {
        if (page == null || page.getApp() == null || page.getApp().getAppContext() == null) {
            return BridgeResponse.UNKNOWN_ERROR;
        }
        ActionSheetCache actionSheetCache = (ActionSheetCache) ((d) page.getApp().getAppContext()).a(ActionSheetCache.class);
        if (actionSheetCache == null) {
            actionSheetCache = new ActionSheetCache();
        }
        actionSheetCache.add("menuList", jSONArray);
        actionSheetCache.add("menuTitle", str);
        actionSheetCache.add("menuExtra", jSONObject);
        ((d) page.getApp().getAppContext()).a((Class<ActionSheetCache>) ActionSheetCache.class, actionSheetCache);
        return BridgeResponse.SUCCESS;
    }

    @ThreadType(ExecutorType.IDLE)
    @ActionFilter
    @AutoCallback
    public BridgeResponse shareTinyAppMsg(@BindingParam({"title"}) String str, @BindingParam({"desc"}) String str2, @BindingParam({"imageUrl"}) String str3, @BindingParam({"path"}) String str4, @BindingParam({"content"}) String str5, @BindingParam({"bgImgUrl"}) String str6, @BindingParam({"url"}) String str7, @BindingParam({"targets"}) JSONArray jSONArray, @BindingParam({"extraParams"}) JSONObject jSONObject, @BindingParam({"type"}) String str8, @BindingParam({"from"}) String str9, @BindingParam({"page"}) String str10, @BindingParam({"bizcode"}) String str11, @BindingNode(Page.class) final Page page, @BindingApiContext final ApiContext apiContext) {
        String str12;
        if (page == null || page.getApp() == null || page.getApp().getAppContext() == null) {
            return BridgeResponse.UNKNOWN_ERROR;
        }
        IShareProxy.ShareInfo shareInfo = new IShareProxy.ShareInfo();
        shareInfo.title = str;
        shareInfo.desc = str2;
        shareInfo.imageUrl = str3;
        shareInfo.extraParams = jSONObject;
        shareInfo.from = TextUtils.equals(str9, "menu") ? 1 : 2;
        shareInfo.originFrom = str9;
        shareInfo.path = TextUtils.isEmpty(str10) ? str4 : str10;
        shareInfo.url = str7;
        shareInfo.content = str5;
        shareInfo.bgImgUrl = str6;
        if (jSONObject != null) {
            str12 = !TextUtils.isEmpty(str8) ? str8 : "default";
        } else {
            str12 = null;
        }
        shareInfo.shareType = str12;
        shareInfo.targets = jSONArray;
        shareInfo.bizCode = ((AppModel) page.getApp().getData(AppModel.class)).getPermissionModel() == null ? str11 : "";
        g gVar = new g(page, new com.alibaba.triver.app.e(page.getApp()));
        if (TextUtils.isEmpty(shareInfo.url)) {
            if (TextUtils.isEmpty(shareInfo.path)) {
                shareInfo.path = a(page.getPageURI());
                if (gVar.isHomePage() && gVar.isFirstTab()) {
                    shareInfo.path = null;
                }
                if (gVar.isHomePage() && !gVar.isTabPage()) {
                    shareInfo.path = null;
                }
            }
            shareInfo.url = com.alibaba.triver.utils.CommonUtils.getSharedUrl(gVar.getApp(), shareInfo.path, TextUtils.equals(str9, "menu") ? shareInfo.extraParams : null).toString();
        } else {
            shareInfo.path = null;
        }
        ((IShareProxy) RVProxy.get(IShareProxy.class)).share(page.getPageContext().getActivity(), gVar, shareInfo, new IShareProxy.IShareListener() { // from class: com.alibaba.triver.bridge.BizBridge.1
            @Override // com.alibaba.triver.kit.api.proxy.IShareProxy.IShareListener
            public void onFail(int i, String str13) {
                Intent intent = new Intent(IShareProxy.ACTION_ON_SHARE);
                intent.putExtra("app_id", page.getApp().getAppId());
                LocalBroadcastManager.getInstance(page.getPageContext().getActivity()).sendBroadcast(intent);
            }

            @Override // com.alibaba.triver.kit.api.proxy.IShareProxy.IShareListener
            public void onShare() {
                com.alibaba.triver.app.e eVar = new com.alibaba.triver.app.e(page.getApp());
                ApiContext apiContext2 = apiContext;
                com.alibaba.triver.utils.CommonUtils.monitorApp("TRVTbApiPage", "TRVShare", page.getApp().getAppId(), com.alibaba.triver.utils.CommonUtils.getSpm(apiContext2 != null ? apiContext2.getActivity() : null, eVar.getStartUrl()));
                Intent intent = new Intent(IShareProxy.ACTION_ON_SHARE);
                intent.putExtra("app_id", page.getApp().getAppId());
                intent.putExtra("result_code", -1);
                LocalBroadcastManager.getInstance(page.getPageContext().getActivity()).sendBroadcast(intent);
            }

            @Override // com.alibaba.triver.kit.api.proxy.IShareProxy.IShareListener
            public void onShareFinish(boolean z) {
            }
        });
        JSONObject jSONObject2 = new JSONObject();
        jSONObject2.put("shareResult", (Object) Boolean.TRUE);
        return new BridgeResponse(jSONObject2);
    }
}

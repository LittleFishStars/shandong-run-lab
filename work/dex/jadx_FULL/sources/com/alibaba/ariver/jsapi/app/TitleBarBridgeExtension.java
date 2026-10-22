package com.alibaba.ariver.jsapi.app;

import android.content.Context;
import android.os.Bundle;
import com.alibaba.ariver.app.api.App;
import com.alibaba.ariver.app.api.AppContext;
import com.alibaba.ariver.app.api.Page;
import com.alibaba.ariver.app.api.PageContext;
import com.alibaba.ariver.app.api.point.view.TitleBarTransparentPoint;
import com.alibaba.ariver.app.api.ui.StatusBarUtils;
import com.alibaba.ariver.app.api.ui.ViewUtils;
import com.alibaba.ariver.app.api.ui.titlebar.TitleBar;
import com.alibaba.ariver.engine.api.bridge.extension.BridgeResponse;
import com.alibaba.ariver.engine.api.bridge.extension.annotation.BindingNode;
import com.alibaba.ariver.engine.api.bridge.extension.annotation.BindingParam;
import com.alibaba.ariver.kernel.api.annotation.ActionFilter;
import com.alibaba.ariver.kernel.api.annotation.AutoCallback;
import com.alibaba.ariver.kernel.api.annotation.ThreadType;
import com.alibaba.ariver.kernel.api.extension.ExtensionPoint;
import com.alibaba.ariver.kernel.api.extension.bridge.BridgeExtension;
import com.alibaba.ariver.kernel.api.security.Permission;
import com.alibaba.ariver.kernel.common.service.executor.ExecutorType;
import com.alibaba.ariver.kernel.common.utils.BundleUtils;
import com.alibaba.ariver.kernel.common.utils.ProcessUtils;
import com.alibaba.ariver.kernel.common.utils.RVLogger;
import com.alibaba.fastjson.JSONObject;
import com.bykv.vk.component.ttvideo.player.MediaFormat;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public class TitleBarBridgeExtension implements BridgeExtension {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final String f24122a = "AriverApp:TitleBarBridgeExtension";

    private TitleBar a(Page page) {
        if (page == null || page.getPageContext() == null) {
            return null;
        }
        return page.getPageContext().getTitleBar();
    }

    @ThreadType(ExecutorType.UI)
    @ActionFilter
    @AutoCallback
    public BridgeResponse getTitleAndStatusbarHeight(@BindingNode(App.class) App app) {
        if (app.getAppContext() == null || ProcessUtils.getContext() == null) {
            return BridgeResponse.newError(5, "title bar status error!");
        }
        Context context = ProcessUtils.getContext();
        AppContext appContext = app.getAppContext();
        JSONObject jSONObject = new JSONObject();
        float f = context.getResources().getDisplayMetrics().density;
        float statusBarHeight = StatusBarUtils.getStatusBarHeight(context) / f;
        jSONObject.put("titleBarHeight", (Object) Float.valueOf(appContext.getViewSpecProvider().getTitleBarRawHeight() / f));
        jSONObject.put("density", (Object) Float.valueOf(f));
        jSONObject.put("statusBarHeight", (Object) Float.valueOf(statusBarHeight));
        return new BridgeResponse(jSONObject);
    }

    @ThreadType(ExecutorType.UI)
    @ActionFilter
    @AutoCallback
    public BridgeResponse getTitleColor(@BindingNode(Page.class) Page page) {
        if (page != null && page.isUseForEmbed()) {
            return new BridgeResponse.Error(4, "cannot operate TitleBar in EmbedView!");
        }
        TitleBar titleBarA = a(page);
        return titleBarA != null ? new BridgeResponse.NamedValue("color", Long.valueOf(((long) titleBarA.getTitleColor()) & 4294967295L)) : BridgeResponse.UNKNOWN_ERROR;
    }

    @ThreadType(ExecutorType.UI)
    @ActionFilter
    @AutoCallback
    public BridgeResponse hideBackButton(@BindingNode(Page.class) Page page) {
        if (page != null && page.isUseForEmbed()) {
            return new BridgeResponse.Error(4, "cannot operate TitleBar in EmbedView!");
        }
        TitleBar titleBarA = a(page);
        if (titleBarA != null) {
            titleBarA.showBackButton(false);
        }
        return BridgeResponse.SUCCESS;
    }

    @ThreadType(ExecutorType.UI)
    @ActionFilter
    @AutoCallback
    public BridgeResponse hideOptionMenu(@BindingNode(Page.class) Page page) {
        if (page != null && page.isUseForEmbed()) {
            return new BridgeResponse.Error(4, "cannot operate TitleBar in EmbedView!");
        }
        TitleBar titleBarA = a(page);
        if (titleBarA != null) {
            titleBarA.showOptionMenu(false);
        }
        return BridgeResponse.SUCCESS;
    }

    @ThreadType(ExecutorType.UI)
    @ActionFilter
    @AutoCallback
    public BridgeResponse hideTitleLoading(@BindingNode(Page.class) Page page) {
        if (page != null && page.isUseForEmbed()) {
            return new BridgeResponse.Error(4, "cannot operate TitleBar in EmbedView!");
        }
        TitleBar titleBarA = a(page);
        if (titleBarA != null) {
            titleBarA.showTitleLoading(false);
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

    @ThreadType(ExecutorType.UI)
    @ActionFilter
    @AutoCallback
    public BridgeResponse setBarBottomLineColor(@BindingParam(intDefault = -16777216, value = {"color"}) int i, @BindingNode(Page.class) Page page) {
        if (page != null && page.isUseForEmbed()) {
            return new BridgeResponse.Error(4, "cannot operate TitleBar in EmbedView!");
        }
        TitleBar titleBarA = a(page);
        if (titleBarA != null && titleBarA.getDivider() != null) {
            int i2 = i | (-16777216);
            RVLogger.d(f24122a, "setBarBottomLineColor color is " + i2);
            titleBarA.getDivider().setBackgroundColor(i2);
        }
        return BridgeResponse.SUCCESS;
    }

    @ThreadType(ExecutorType.UI)
    @ActionFilter
    @AutoCallback
    public BridgeResponse setTitle(@BindingParam({"title"}) String str, @BindingParam({MediaFormat.KEY_SUBTITLE}) String str2, @BindingParam({"image"}) String str3, @BindingParam({"contentDesc"}) String str4, @BindingParam(booleanDefault = true, value = {"fromJS"}) boolean z, @BindingNode(Page.class) Page page) {
        if (page != null && page.isUseForEmbed()) {
            return new BridgeResponse.Error(4, "cannot operate TitleBar in EmbedView!");
        }
        TitleBar titleBarA = a(page);
        if (titleBarA != null) {
            titleBarA.setTitle(str, str2, str3, str4, z);
        }
        return BridgeResponse.SUCCESS;
    }

    @ThreadType(ExecutorType.UI)
    @ActionFilter
    @AutoCallback
    public BridgeResponse setTitleColor(@BindingParam(intDefault = -16777216, value = {"color"}) int i, @BindingParam({"reset"}) boolean z, @BindingParam({"resetTransparent"}) boolean z2, @BindingNode(Page.class) Page page) {
        if (page != null && page.isUseForEmbed()) {
            return new BridgeResponse.Error(4, "cannot operate TitleBar in EmbedView!");
        }
        TitleBar titleBarA = a(page);
        if (titleBarA != null) {
            titleBarA.setTitleColor(i, z, z2);
        }
        return BridgeResponse.SUCCESS;
    }

    @ThreadType(ExecutorType.UI)
    @ActionFilter
    @AutoCallback
    public BridgeResponse setTransparentTitle(@BindingParam({"transparentTitle"}) String str, @BindingNode(Page.class) Page page) {
        if (page != null && page.isUseForEmbed()) {
            return new BridgeResponse.Error(4, "cannot operate TitleBar in EmbedView!");
        }
        if (page != null) {
            Bundle startParams = page.getStartParams();
            RVLogger.d(f24122a, "setTransparentTitle originType " + BundleUtils.getString(startParams, "transparentTitle") + ", type: " + str);
            startParams.putString("transparentTitle", str);
            PageContext pageContext = page.getPageContext();
            if (pageContext != null) {
                pageContext.applyTransparentTitle(ViewUtils.isTransparentTitle(page.getStartParams(), str));
            }
            TitleBar titleBarA = a(page);
            if (titleBarA != null) {
                titleBarA.setTransparentTitle(str);
            }
            ((TitleBarTransparentPoint) ExtensionPoint.as(TitleBarTransparentPoint.class).node(page).create()).onTrasparentTitle(str);
        }
        return BridgeResponse.SUCCESS;
    }

    @ThreadType(ExecutorType.UI)
    @ActionFilter
    @AutoCallback
    public BridgeResponse showBackButton(@BindingNode(Page.class) Page page) {
        if (page != null && page.isUseForEmbed()) {
            return new BridgeResponse.Error(4, "cannot operate TitleBar in EmbedView!");
        }
        TitleBar titleBarA = a(page);
        if (titleBarA != null) {
            titleBarA.showBackButton(true);
        }
        return BridgeResponse.SUCCESS;
    }

    @ThreadType(ExecutorType.UI)
    @ActionFilter
    @AutoCallback
    public BridgeResponse showOptionMenu(@BindingNode(Page.class) Page page) {
        if (page != null && page.isUseForEmbed()) {
            return new BridgeResponse.Error(4, "cannot operate TitleBar in EmbedView!");
        }
        TitleBar titleBarA = a(page);
        if (titleBarA != null) {
            titleBarA.showOptionMenu(true);
        }
        return BridgeResponse.SUCCESS;
    }

    @ThreadType(ExecutorType.UI)
    @ActionFilter
    @AutoCallback
    public BridgeResponse showTitleLoading(@BindingNode(Page.class) Page page) {
        if (page != null && page.isUseForEmbed()) {
            return new BridgeResponse.Error(4, "cannot operate TitleBar in EmbedView!");
        }
        TitleBar titleBarA = a(page);
        if (titleBarA != null) {
            titleBarA.showTitleLoading(true);
        }
        return BridgeResponse.SUCCESS;
    }

    public boolean titleBarContainsStatusBarHeight() {
        return StatusBarUtils.isSupport();
    }
}

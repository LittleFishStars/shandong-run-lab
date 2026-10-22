package com.alibaba.ariver.jsapi.app;

import android.os.Bundle;
import android.text.TextUtils;
import com.alibaba.ariver.app.PageNode;
import com.alibaba.ariver.app.api.App;
import com.alibaba.ariver.app.api.Page;
import com.alibaba.ariver.app.api.ParamUtils;
import com.alibaba.ariver.app.api.point.app.PushWindowPoint;
import com.alibaba.ariver.app.api.point.page.PagePushInterceptPoint;
import com.alibaba.ariver.engine.api.bridge.extension.BridgeCallback;
import com.alibaba.ariver.engine.api.bridge.extension.BridgeResponse;
import com.alibaba.ariver.engine.api.bridge.extension.annotation.BindingCallback;
import com.alibaba.ariver.engine.api.bridge.extension.annotation.BindingExecutor;
import com.alibaba.ariver.engine.api.bridge.extension.annotation.BindingNode;
import com.alibaba.ariver.engine.api.bridge.extension.annotation.BindingParam;
import com.alibaba.ariver.jsapi.R;
import com.alibaba.ariver.kernel.RVStartParams;
import com.alibaba.ariver.kernel.api.annotation.ActionFilter;
import com.alibaba.ariver.kernel.api.annotation.AutoCallback;
import com.alibaba.ariver.kernel.api.annotation.ThreadType;
import com.alibaba.ariver.kernel.api.extension.ExtensionPoint;
import com.alibaba.ariver.kernel.api.extension.bridge.BridgeExtension;
import com.alibaba.ariver.kernel.api.extension.resolver.ResultResolver;
import com.alibaba.ariver.kernel.api.security.Permission;
import com.alibaba.ariver.kernel.common.RVProxy;
import com.alibaba.ariver.kernel.common.security.SecurityUtils;
import com.alibaba.ariver.kernel.common.service.RVConfigService;
import com.alibaba.ariver.kernel.common.service.executor.ExecutorType;
import com.alibaba.ariver.kernel.common.utils.BundleUtils;
import com.alibaba.ariver.kernel.common.utils.ExecutorUtils;
import com.alibaba.ariver.kernel.common.utils.FileUtils;
import com.alibaba.ariver.kernel.common.utils.JSONUtils;
import com.alibaba.ariver.kernel.common.utils.LangResourceUtil;
import com.alibaba.ariver.kernel.common.utils.RVLogger;
import com.alibaba.ariver.kernel.common.utils.UrlUtils;
import com.alibaba.ariver.resource.api.models.AppInfoScene;
import com.alibaba.fastjson.JSONObject;
import com.aliyun.tea.logging.DefaultLogger;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.concurrent.Executor;
import java.util.regex.Pattern;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public class WindowBridgeExtension implements BridgeExtension {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final String f24123a = "AriverApp:WindowBridgeExtension";
    private static final String b = "envVersion";

    private int a(App app, String str, boolean z) {
        int childCount = app.getChildCount();
        for (int i = 0; i <= childCount - 1; i++) {
            String pageURI = app.getPageByIndex(i).getPageURI();
            if (!TextUtils.isEmpty(pageURI)) {
                if (z) {
                    Pattern patternCompile = Pattern.compile(str);
                    if (patternCompile != null && patternCompile.matcher(pageURI).find()) {
                        return i;
                    }
                } else if (str.equals(pageURI)) {
                    return i;
                }
            }
        }
        return Integer.MAX_VALUE;
    }

    @ActionFilter
    @AutoCallback
    public BridgeResponse getRunScene(@BindingNode(App.class) App app) {
        if (!AppInfoScene.isDevSource(app.getStartParams())) {
            return BridgeResponse.newValue(b, "release");
        }
        String strName = AppInfoScene.extractScene(app.getStartParams()).name();
        if (TextUtils.isEmpty(strName) || TextUtils.equals("ONLINE", strName) || TextUtils.equals("REVIEW", strName)) {
            return BridgeResponse.newValue(b, "release");
        }
        if (TextUtils.equals(strName, DefaultLogger.DEBUG)) {
            return BridgeResponse.newValue(b, "develop");
        }
        return TextUtils.equals(strName, "TRIAL") ? BridgeResponse.newValue(b, "trial") : BridgeResponse.UNKNOWN_ERROR;
    }

    @Override // com.alibaba.ariver.kernel.api.extension.Extension
    public void onFinalized() {
        RVLogger.d(f24123a, "onFinalized");
    }

    @Override // com.alibaba.ariver.kernel.api.extension.Extension
    public void onInitialized() {
        RVLogger.d(f24123a, "onInitialized");
    }

    @Override // com.alibaba.ariver.kernel.api.security.Guard
    public Permission permit() {
        return null;
    }

    @ActionFilter
    @AutoCallback
    public BridgeResponse popTo(@BindingNode(App.class) App app, @BindingParam({"url"}) String str, @BindingParam({"urlPattern"}) String str2, @BindingParam({"data"}) JSONObject jSONObject, @BindingParam(intDefault = Integer.MAX_VALUE, value = {"index"}) int i) {
        int iA = !TextUtils.isEmpty(str) ? a(app, str, false) : Integer.MAX_VALUE;
        if (!TextUtils.isEmpty(str2)) {
            iA = a(app, str2, true);
        }
        if (iA != Integer.MAX_VALUE) {
            i = iA;
        }
        if (i == Integer.MAX_VALUE) {
            return BridgeResponse.newError(10, "can't find page index");
        }
        if (i < 0 && Math.abs(i) > app.getChildCount() - 1) {
            return BridgeResponse.newError(10, "popTo index overflow!");
        }
        app.popTo(i, true, jSONObject);
        return BridgeResponse.SUCCESS;
    }

    @ActionFilter
    @AutoCallback
    public void popWindow(@BindingNode(App.class) App app, @BindingParam({"data"}) JSONObject jSONObject) {
        app.popPage(jSONObject);
    }

    @ThreadType(ExecutorType.URGENT_DISPLAY)
    @ActionFilter
    @AutoCallback
    public BridgeResponse pushWindow(@BindingParam({"url", "u"}) String str, @BindingParam({"param"}) final JSONObject jSONObject, @BindingNode(Page.class) final Page page, @BindingNode(App.class) App app, @BindingExecutor(ExecutorType.UI) Executor executor, @BindingCallback BridgeCallback bridgeCallback) {
        RVLogger.d(f24123a, "pushWindow，url = " + str + ", param = " + jSONObject);
        String pageURI = page.getPageURI();
        if (str.startsWith("#")) {
            String string = BundleUtils.getString(app.getStartParams(), "onlineHost");
            if (!app.isTinyApp() || TextUtils.isEmpty(string)) {
                int iIndexOf = pageURI.indexOf(35);
                if (iIndexOf != -1) {
                    str = pageURI.substring(0, iIndexOf) + str;
                    RVLogger.d(f24123a, "stripAnchor url:" + str);
                }
            } else {
                str = FileUtils.combinePath(string, "index.html") + str;
                RVLogger.d(f24123a, "stripAnchor url by vhost:" + str);
            }
        } else {
            str = UrlUtils.mergeUrl(pageURI, str);
        }
        if (TextUtils.isEmpty(str)) {
            return BridgeResponse.INVALID_PARAM;
        }
        String strTrim = str.trim();
        if (!SecurityUtils.checkUrlCanStartInPushWindow(strTrim)) {
            RVLogger.d(f24123a, "pushWindow security check failed!");
            return BridgeResponse.INVALID_PARAM;
        }
        final Bundle bundle = new Bundle();
        Bundle startParams = page.getStartParams();
        Bundle bundle2 = JSONUtils.toBundle(jSONObject);
        ParamUtils.unifyAll(bundle2, false);
        if (startParams.getBoolean(RVStartParams.KEY_TRANSPARENT, false) && !startParams.getBoolean("fullscreen", false)) {
            RVLogger.d(f24123a, "can not pushwindow in a transparent window");
            return new BridgeResponse.Error(2, LangResourceUtil.getString(R.string.ariver_jsapi_push_window_in_trans_window));
        }
        bundle.putAll(startParams);
        ParamUtils.filterCreatePageParams(bundle);
        bundle.putAll(bundle2);
        bundle.putString(RVStartParams.KEY_FROM_TYPE, "pushWindow");
        if (((PushWindowPoint) ExtensionPoint.as(PushWindowPoint.class).node(page).resolve(ResultResolver.POSITIVE_RESOLVER).create()).handlePushWindow(page, strTrim, bundle, bundle2)) {
            return BridgeResponse.SUCCESS;
        }
        if (page.getPageContext() == null || page.getApp().getAppContext() == null || page.getApp().getAppContext().getContext() == null) {
            return new BridgeResponse.Error(2, "page or app context null");
        }
        RVLogger.d(f24123a, "pushWindow, oldParams is " + bundle.toString());
        PagePushInterceptPoint pagePushInterceptPoint = (PagePushInterceptPoint) ExtensionPoint.as(PagePushInterceptPoint.class).node(page).nullable().create();
        String strInterceptPushPage = pagePushInterceptPoint != null ? pagePushInterceptPoint.interceptPushPage(app, strTrim, bundle) : null;
        final String str2 = TextUtils.isEmpty(strInterceptPushPage) ? strTrim : strInterceptPushPage;
        executor.execute(new Runnable() { // from class: com.alibaba.ariver.jsapi.app.WindowBridgeExtension.1
            @Override // java.lang.Runnable
            public void run() {
                final App app2 = page.getApp();
                if (app2 == null || app2.isDestroyed()) {
                    RVLogger.e(WindowBridgeExtension.f24123a, "pushWindow, but already destroyed!");
                    return;
                }
                if (JSONUtils.getBoolean(jSONObject, "closeAllWindow", false)) {
                    RVLogger.d(WindowBridgeExtension.f24123a, "pushWindow, relaunch(closeAllWindow)!");
                    bundle.putString(RVStartParams.KEY_FROM_TYPE, RVStartParams.FROM_TYPE_PUSH_RELAUNCH);
                    ExecutorUtils.runOnMain(new Runnable() { // from class: com.alibaba.ariver.jsapi.app.WindowBridgeExtension.1.1
                        @Override // java.lang.Runnable
                        public void run() {
                            App app3 = app2;
                            AnonymousClass1 anonymousClass1 = AnonymousClass1.this;
                            app3.relaunchToUrl(str2, bundle, page.getApp().getSceneParams());
                        }
                    });
                } else {
                    if ("yes".equalsIgnoreCase(((RVConfigService) RVProxy.get(RVConfigService.class)).getConfigWithProcessCache("ta_pushWindowNotShowTabBar", "YES"))) {
                        bundle.putBoolean(RVStartParams.KEY_NEW_PAGE_FROM_PUSH_WINDOW, true);
                    }
                    ExecutorUtils.runOnMain(new Runnable() { // from class: com.alibaba.ariver.jsapi.app.WindowBridgeExtension.1.2
                        @Override // java.lang.Runnable
                        public void run() {
                            App app3 = app2;
                            AnonymousClass1 anonymousClass1 = AnonymousClass1.this;
                            if (!app3.pushPage(str2, bundle, app3.getSceneParams())) {
                                RVLogger.e(WindowBridgeExtension.f24123a, "pushPage not success! not do closeCurrentWindow");
                                return;
                            }
                            if (JSONUtils.getBoolean(jSONObject, "closeCurrentWindow", false)) {
                                RVLogger.d(WindowBridgeExtension.f24123a, "pushWindow closeCurrentWindow");
                                ((Page.AnimStore) page.getData(Page.AnimStore.class, true)).disableExit = true;
                                ArrayList arrayList = new ArrayList();
                                arrayList.add(page);
                                if (page.isUseForEmbed()) {
                                    int indexOfChild = app2.getIndexOfChild(page);
                                    if (indexOfChild > 0) {
                                        arrayList.add(app2.getPageByIndex(indexOfChild - 1));
                                    } else {
                                        int childCount = app2.getChildCount();
                                        for (int i = 0; i < childCount; i++) {
                                            Page pageByIndex = app2.getPageByIndex(i);
                                            if ((pageByIndex instanceof PageNode) && ((PageNode) pageByIndex).getEmbedPage() == page) {
                                                RVLogger.d(WindowBridgeExtension.f24123a, "pushWindow closeCurrentWindow embedPage add parentPage " + pageByIndex);
                                                arrayList.add(pageByIndex);
                                            }
                                        }
                                    }
                                }
                                Iterator it = arrayList.iterator();
                                while (it.hasNext()) {
                                    ((Page) it.next()).exit(false);
                                }
                            }
                        }
                    });
                }
            }
        });
        return BridgeResponse.SUCCESS;
    }
}

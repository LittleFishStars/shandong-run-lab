package com.alibaba.triver.bridge;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.BitmapDrawable;
import android.text.TextUtils;
import android.view.View;
import com.alibaba.ariver.app.api.App;
import com.alibaba.ariver.app.api.Page;
import com.alibaba.ariver.engine.api.EngineUtils;
import com.alibaba.ariver.engine.api.bridge.extension.BridgeResponse;
import com.alibaba.ariver.engine.api.bridge.extension.annotation.BindingNode;
import com.alibaba.ariver.engine.api.bridge.extension.annotation.BindingParam;
import com.alibaba.ariver.engine.api.extensions.resources.model.ResourceLoadContext;
import com.alibaba.ariver.engine.api.resources.Resource;
import com.alibaba.ariver.engine.api.resources.ResourceLoadPoint;
import com.alibaba.ariver.kernel.api.annotation.ActionFilter;
import com.alibaba.ariver.kernel.api.annotation.AutoCallback;
import com.alibaba.ariver.kernel.api.annotation.ThreadType;
import com.alibaba.ariver.kernel.api.extension.ExtensionPoint;
import com.alibaba.ariver.kernel.api.extension.bridge.BridgeExtension;
import com.alibaba.ariver.kernel.api.security.Permission;
import com.alibaba.ariver.kernel.common.service.executor.ExecutorType;
import com.alibaba.ariver.kernel.common.utils.BundleUtils;
import com.alibaba.ariver.kernel.common.utils.FileUtils;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.triver.content.e;
import com.alibaba.triver.kit.api.model.NavigatorBarAnimType;
import com.alibaba.triver.kit.api.utils.CommonUtils;
import com.alibaba.triver.kit.api.widget.ITitleBar;
import com.alibaba.triver.kit.api.widget.action.IFavorAction;
import com.alibaba.triver.kit.api.widget.action.IMenuAction;
import com.alibaba.triver.utils.ResourceUtils;
import com.huawei.hms.push.constant.RemoteMessageConst;
import com.ipd.dsp.internal.l.a;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public class TitleBarBridge implements BridgeExtension {
    @ThreadType(ExecutorType.UI)
    @ActionFilter
    @AutoCallback
    public BridgeResponse addMenu(@BindingParam({"event"}) String str, @BindingParam({"data"}) JSONObject jSONObject, @BindingNode(Page.class) Page page) {
        if (page == null || page.getPageContext() == null || !(page.getPageContext().getTitleBar() instanceof e)) {
            return BridgeResponse.FORBIDDEN_ERROR;
        }
        ITitleBar iTitleBarA = ((e) page.getPageContext().getTitleBar()).a();
        if (iTitleBarA != null) {
            if (iTitleBarA.getAction(IFavorAction.class) != null) {
                return BridgeResponse.FORBIDDEN_ERROR;
            }
            if (iTitleBarA.addRightText(str, jSONObject)) {
                return BridgeResponse.SUCCESS;
            }
        }
        return BridgeResponse.SUCCESS;
    }

    @ThreadType(ExecutorType.UI)
    @ActionFilter
    @AutoCallback
    public BridgeResponse changeFavorStatus(@BindingParam({"status"}) boolean z, @BindingNode(Page.class) Page page) {
        ITitleBar iTitleBarA;
        IFavorAction iFavorAction;
        if (!(page.getPageContext().getTitleBar() instanceof e) || (iTitleBarA = ((e) page.getPageContext().getTitleBar()).a()) == null || (iFavorAction = (IFavorAction) iTitleBarA.getAction(IFavorAction.class)) == null) {
            return BridgeResponse.FORBIDDEN_ERROR;
        }
        iFavorAction.switchFavorStatus(z);
        return BridgeResponse.SUCCESS;
    }

    @ThreadType(ExecutorType.UI)
    @ActionFilter
    @AutoCallback
    public BridgeResponse getStatusBarHeight(@BindingNode(App.class) App app) {
        return (app == null || app.getAppContext() == null) ? BridgeResponse.UNKNOWN_ERROR : new BridgeResponse.NamedValue("data", Integer.valueOf(CommonUtils.getStatusBarHeight(app.getAppContext().getContext())));
    }

    @ThreadType(ExecutorType.UI)
    @ActionFilter
    @AutoCallback
    public BridgeResponse hideBackHome(@BindingNode(Page.class) Page page) {
        ITitleBar iTitleBarA;
        if (!(page.getPageContext().getTitleBar() instanceof e) || (iTitleBarA = ((e) page.getPageContext().getTitleBar()).a()) == null) {
            return BridgeResponse.FORBIDDEN_ERROR;
        }
        return iTitleBarA.hideBackHome() ? BridgeResponse.SUCCESS : BridgeResponse.FORBIDDEN_ERROR;
    }

    @ThreadType(ExecutorType.UI)
    @ActionFilter
    @AutoCallback
    public BridgeResponse hideGlobalMenu(@BindingNode(Page.class) Page page) {
        ITitleBar iTitleBarA;
        IMenuAction iMenuAction;
        if (page == null || page.getApp() == null || !(page.getPageContext().getTitleBar() instanceof e) || (iTitleBarA = ((e) page.getPageContext().getTitleBar()).a()) == null || (iMenuAction = (IMenuAction) iTitleBarA.getAction(IMenuAction.class)) == null) {
            return BridgeResponse.NOT_FOUND;
        }
        iMenuAction.hideMenu();
        return BridgeResponse.SUCCESS;
    }

    @ThreadType(ExecutorType.UI)
    @ActionFilter
    @AutoCallback
    public BridgeResponse hideNavigatorBar(@BindingParam({"animationType"}) String str, @BindingParam({a.l}) String str2, @BindingNode(Page.class) Page page) {
        ITitleBar iTitleBarA;
        NavigatorBarAnimType navigatorBarAnimType;
        if (!(page.getPageContext().getTitleBar() instanceof e) || (iTitleBarA = ((e) page.getPageContext().getTitleBar()).a()) == null) {
            return BridgeResponse.FORBIDDEN_ERROR;
        }
        if (!"true".equals(str2)) {
            navigatorBarAnimType = NavigatorBarAnimType.NULL;
        } else if ("alpha".equals(str)) {
            navigatorBarAnimType = NavigatorBarAnimType.ALPHA;
        } else {
            navigatorBarAnimType = "translate".equals(str) ? NavigatorBarAnimType.TRANS : NavigatorBarAnimType.OTHER;
        }
        if (!iTitleBarA.hideTitleBar(navigatorBarAnimType)) {
            return BridgeResponse.FORBIDDEN_ERROR;
        }
        page.getPageContext().applyTransparentTitle(true);
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
    public BridgeResponse registerFavorEvent(@BindingParam({"event"}) final String str, @BindingParam({"data"}) final JSONObject jSONObject, @BindingNode(Page.class) final Page page) {
        ITitleBar iTitleBarA;
        if ((page.getPageContext().getTitleBar() instanceof e) && (iTitleBarA = ((e) page.getPageContext().getTitleBar()).a()) != null) {
            IFavorAction iFavorAction = (IFavorAction) iTitleBarA.getAction(IFavorAction.class);
            if (iFavorAction == null) {
                iTitleBarA.enableFavor();
                iFavorAction = (IFavorAction) iTitleBarA.getAction(IFavorAction.class);
            }
            if (iFavorAction != null) {
                iFavorAction.setOnClickListener(new View.OnClickListener() { // from class: com.alibaba.triver.bridge.TitleBarBridge.3
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        JSONObject jSONObject2 = new JSONObject();
                        jSONObject2.put("data", (Object) jSONObject);
                        EngineUtils.sendToRender(page.getRender(), str, jSONObject2, null);
                    }
                });
                return BridgeResponse.SUCCESS;
            }
        }
        return BridgeResponse.FORBIDDEN_ERROR;
    }

    @ThreadType(ExecutorType.UI)
    @ActionFilter
    @AutoCallback
    public BridgeResponse setBackButton(@BindingParam({"color"}) String str, @BindingNode(Page.class) Page page) {
        ITitleBar iTitleBarA;
        if (!(page.getPageContext().getTitleBar() instanceof e) || (iTitleBarA = ((e) page.getPageContext().getTitleBar()).a()) == null) {
            return BridgeResponse.FORBIDDEN_ERROR;
        }
        return iTitleBarA.setBackButton(str) ? BridgeResponse.SUCCESS : BridgeResponse.FORBIDDEN_ERROR;
    }

    @ThreadType(ExecutorType.UI)
    @ActionFilter
    @AutoCallback
    public BridgeResponse setLeftItem(@BindingParam({RemoteMessageConst.Notification.ICON}) String str, @BindingParam({"text"}) String str2, @BindingParam({"event"}) final String str3, @BindingNode(Page.class) final Page page) {
        ITitleBar iTitleBarA;
        if (page == null || page.getApp() == null || !(page.getPageContext().getTitleBar() instanceof e) || (iTitleBarA = ((e) page.getPageContext().getTitleBar()).a()) == null) {
            return BridgeResponse.FORBIDDEN_ERROR;
        }
        View.OnClickListener onClickListener = new View.OnClickListener() { // from class: com.alibaba.triver.bridge.TitleBarBridge.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                EngineUtils.sendToRender(page.getRender(), str3, null, null);
            }
        };
        if (!TextUtils.isEmpty(str)) {
            String string = BundleUtils.getString(page.getApp().getStartParams(), "onlineHost");
            if (ResourceUtils.a(str, string) != ResourceUtils.ResourceType.INTERNAL) {
                iTitleBarA.addLeftButton(str, onClickListener);
            } else {
                if (!str.startsWith(string)) {
                    str = FileUtils.combinePath(string, str);
                }
                Resource resourceLoad = ((ResourceLoadPoint) ExtensionPoint.as(ResourceLoadPoint.class).node(page.getApp()).create()).load(ResourceLoadContext.newBuilder().originUrl(str).build());
                if (resourceLoad != null) {
                    byte[] bytes = resourceLoad.getBytes();
                    iTitleBarA.addLeftButton(new BitmapDrawable(BitmapFactory.decodeByteArray(bytes, 0, bytes.length)), onClickListener);
                }
            }
        } else if (!TextUtils.isEmpty(str2)) {
            iTitleBarA.addLeftText(str2, onClickListener);
        }
        return BridgeResponse.SUCCESS;
    }

    /* JADX WARN: Code duplicated, block: B:55:0x0127 A[PHI: r7
      0x0127: PHI (r7v4 java.lang.String) = (r7v3 java.lang.String), (r7v3 java.lang.String), (r7v5 java.lang.String), (r7v5 java.lang.String) binds: [B:47:0x010e, B:49:0x0114, B:52:0x011f, B:54:0x0125] A[DONT_GENERATE, DONT_INLINE]] */
    @ThreadType(ExecutorType.UI)
    @ActionFilter
    @AutoCallback
    public BridgeResponse setNavigationBarStyle(@BindingParam({"backgroundColor"}) String str, @BindingParam({"backgroundBg"}) String str2, @BindingParam({"barTextStyle"}) String str3, @BindingParam(stringDefault = "notSetTitle", value = {"title"}) String str4, @BindingParam({"image"}) String str5, @BindingParam({"borderBottomColor"}) String str6, @BindingParam({"reset"}) boolean z, @BindingNode(Page.class) Page page) {
        ITitleBar iTitleBarA;
        if (page == null || page.getApp() == null || !(page.getPageContext().getTitleBar() instanceof e) || (iTitleBarA = ((e) page.getPageContext().getTitleBar()).a()) == null) {
            return BridgeResponse.FORBIDDEN_ERROR;
        }
        String string = BundleUtils.getString(page.getApp().getStartParams(), "onlineHost");
        if (TextUtils.isEmpty(str2)) {
            if (!TextUtils.isEmpty(str)) {
                iTitleBarA.setTitleBarBgColor(str);
            }
        } else if (ResourceUtils.a(str2, string) != ResourceUtils.ResourceType.INTERNAL) {
            iTitleBarA.setTitleBarBgDrawable(str2);
        } else {
            if (!str2.startsWith(string)) {
                str2 = FileUtils.combinePath(string, str2);
            }
            Resource resourceLoad = ((ResourceLoadPoint) ExtensionPoint.as(ResourceLoadPoint.class).node(page.getApp()).create()).load(ResourceLoadContext.newBuilder().originUrl(str2).build());
            if (resourceLoad != null) {
                byte[] bytes = resourceLoad.getBytes();
                iTitleBarA.setTitleBarBgDrawable(new BitmapDrawable(BitmapFactory.decodeByteArray(bytes, 0, bytes.length)));
            }
        }
        if (!TextUtils.isEmpty(str6)) {
            iTitleBarA.setBorderBottomColor(str6);
        }
        if (TextUtils.isEmpty(str5)) {
            if (!TextUtils.equals(str4, "notSetTitle")) {
                iTitleBarA.setTitle(str4, (String) null, str5, (String) null);
            }
        } else if (ResourceUtils.a(str5, string) == ResourceUtils.ResourceType.INTERNAL) {
            if (!str5.startsWith(string)) {
                str5 = FileUtils.combinePath(string, str5);
            }
            Resource resourceLoad2 = ((ResourceLoadPoint) ExtensionPoint.as(ResourceLoadPoint.class).node(page.getApp()).create()).load(ResourceLoadContext.newBuilder().originUrl(str5).build());
            if (resourceLoad2 != null) {
                byte[] bytes2 = resourceLoad2.getBytes();
                Bitmap bitmapDecodeByteArray = BitmapFactory.decodeByteArray(bytes2, 0, bytes2.length);
                if (!TextUtils.equals(str4, "notSetTitle")) {
                    iTitleBarA.setTitle(str4, (String) null, new BitmapDrawable(bitmapDecodeByteArray), (String) null);
                }
            }
        } else if (!TextUtils.equals(str4, "notSetTitle")) {
            iTitleBarA.setTitle(str4, (String) null, str5, (String) null);
        }
        String str7 = "light";
        if ("white".equals(str3) || "light".equals(str3)) {
            str3 = str7;
        } else {
            str7 = "dark";
            if ("black".equals(str3) || "dark".equals(str3)) {
                str3 = str7;
            }
        }
        if (z) {
            iTitleBarA.reset();
        }
        if (!TextUtils.isEmpty(str3)) {
            iTitleBarA.setStyle(str3);
        }
        return BridgeResponse.SUCCESS;
    }

    @ThreadType(ExecutorType.UI)
    @ActionFilter
    @AutoCallback
    public BridgeResponse setRightItem(@BindingParam({RemoteMessageConst.Notification.ICON}) String str, @BindingParam({"text"}) String str2, @BindingParam({"event"}) final String str3, @BindingNode(Page.class) final Page page) {
        ITitleBar iTitleBarA;
        if (page == null || page.getApp() == null || !(page.getPageContext().getTitleBar() instanceof e) || (iTitleBarA = ((e) page.getPageContext().getTitleBar()).a()) == null) {
            return BridgeResponse.FORBIDDEN_ERROR;
        }
        View.OnClickListener onClickListener = new View.OnClickListener() { // from class: com.alibaba.triver.bridge.TitleBarBridge.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                EngineUtils.sendToRender(page.getRender(), str3, null, null);
            }
        };
        if (!TextUtils.isEmpty(str)) {
            String string = BundleUtils.getString(page.getApp().getStartParams(), "onlineHost");
            if (ResourceUtils.a(str, string) != ResourceUtils.ResourceType.INTERNAL) {
                iTitleBarA.addRightButton(str, onClickListener);
            } else {
                if (!str.startsWith(string)) {
                    str = FileUtils.combinePath(string, str);
                }
                Resource resourceLoad = ((ResourceLoadPoint) ExtensionPoint.as(ResourceLoadPoint.class).node(page.getApp()).create()).load(ResourceLoadContext.newBuilder().originUrl(str).build());
                if (resourceLoad != null) {
                    byte[] bytes = resourceLoad.getBytes();
                    iTitleBarA.addRightButton(new BitmapDrawable(BitmapFactory.decodeByteArray(bytes, 0, bytes.length)), onClickListener);
                }
            }
        } else if (!TextUtils.isEmpty(str2)) {
            iTitleBarA.addRightText(str2, onClickListener);
        }
        return BridgeResponse.SUCCESS;
    }

    @ThreadType(ExecutorType.UI)
    @ActionFilter
    @AutoCallback
    public BridgeResponse showBackToHomepage(@BindingNode(Page.class) Page page) {
        ITitleBar iTitleBarA;
        if (!(page.getPageContext().getTitleBar() instanceof e) || (iTitleBarA = ((e) page.getPageContext().getTitleBar()).a()) == null) {
            return BridgeResponse.FORBIDDEN_ERROR;
        }
        return iTitleBarA.showBackToHomepage() ? BridgeResponse.SUCCESS : BridgeResponse.FORBIDDEN_ERROR;
    }

    @ThreadType(ExecutorType.UI)
    @ActionFilter
    @AutoCallback
    public BridgeResponse showGlobalMenu(@BindingNode(Page.class) Page page) {
        ITitleBar iTitleBarA;
        IMenuAction iMenuAction;
        if (page == null || page.getApp() == null || !(page.getPageContext().getTitleBar() instanceof e) || (iTitleBarA = ((e) page.getPageContext().getTitleBar()).a()) == null || (iMenuAction = (IMenuAction) iTitleBarA.getAction(IMenuAction.class)) == null) {
            return BridgeResponse.NOT_FOUND;
        }
        iMenuAction.showMenu();
        return BridgeResponse.SUCCESS;
    }

    @ThreadType(ExecutorType.UI)
    @ActionFilter
    @AutoCallback
    public BridgeResponse showNavigatorBar(@BindingParam({"animationType"}) String str, @BindingParam({a.l}) String str2, @BindingNode(Page.class) Page page) {
        ITitleBar iTitleBarA;
        NavigatorBarAnimType navigatorBarAnimType;
        if (!(page.getPageContext().getTitleBar() instanceof e) || (iTitleBarA = ((e) page.getPageContext().getTitleBar()).a()) == null) {
            return BridgeResponse.FORBIDDEN_ERROR;
        }
        if (!"true".equals(str2)) {
            navigatorBarAnimType = NavigatorBarAnimType.NULL;
        } else if ("alpha".equals(str)) {
            navigatorBarAnimType = NavigatorBarAnimType.ALPHA;
        } else {
            navigatorBarAnimType = "translate".equals(str) ? NavigatorBarAnimType.TRANS : NavigatorBarAnimType.OTHER;
        }
        if (!iTitleBarA.showTitleBar(navigatorBarAnimType)) {
            return BridgeResponse.FORBIDDEN_ERROR;
        }
        page.getPageContext().applyTransparentTitle(false);
        return BridgeResponse.SUCCESS;
    }
}

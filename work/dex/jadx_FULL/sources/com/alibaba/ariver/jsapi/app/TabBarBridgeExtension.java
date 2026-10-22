package com.alibaba.ariver.jsapi.app;

import android.text.TextUtils;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.AlphaAnimation;
import android.view.animation.AnimationSet;
import android.view.animation.AnimationUtils;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.TranslateAnimation;
import androidx.annotation.Keep;
import com.alibaba.ariver.app.api.App;
import com.alibaba.ariver.app.api.Page;
import com.alibaba.ariver.app.api.ui.tabbar.TabBar;
import com.alibaba.ariver.app.api.ui.tabbar.model.TabBarBadgeModel;
import com.alibaba.ariver.app.api.ui.tabbar.model.TabBarItemModel;
import com.alibaba.ariver.app.api.ui.tabbar.model.TabBarModel;
import com.alibaba.ariver.engine.api.bridge.extension.BridgeResponse;
import com.alibaba.ariver.engine.api.bridge.extension.annotation.BindingNode;
import com.alibaba.ariver.engine.api.bridge.extension.annotation.BindingParam;
import com.alibaba.ariver.engine.api.bridge.extension.annotation.BindingRequest;
import com.alibaba.ariver.kernel.api.annotation.ActionFilter;
import com.alibaba.ariver.kernel.api.annotation.AutoCallback;
import com.alibaba.ariver.kernel.api.annotation.ThreadType;
import com.alibaba.ariver.kernel.api.extension.bridge.BridgeExtension;
import com.alibaba.ariver.kernel.api.security.Permission;
import com.alibaba.ariver.kernel.common.service.executor.ExecutorType;
import com.alibaba.ariver.kernel.common.utils.ExecutorUtils;
import com.alibaba.ariver.kernel.common.utils.JSONUtils;
import com.alibaba.ariver.kernel.common.utils.RVLogger;
import com.alibaba.ariver.kernel.common.utils.TypeUtils;
import com.alibaba.fastjson.JSONObject;
import com.aliyun.credentials.utils.AuthConstant;
import com.huawei.hms.push.constant.RemoteMessageConst;
import com.ipd.dsp.internal.l.a;
import java.util.Iterator;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
@Keep
public class TabBarBridgeExtension implements BridgeExtension {
    private static final String TAG = "AriverApp:TabBarBridgeExtension";
    private static final String TYPE_ANIM_ALPHA = "alpha";
    private static final String TYPE_ANIM_TRANSLATE = "translate";

    private void hideTabBar(@BindingRequest JSONObject jSONObject, final TabBar tabBar) {
        final boolean z = JSONUtils.getBoolean(jSONObject, a.l, false);
        final String string = JSONUtils.getString(jSONObject, "animationType");
        ExecutorUtils.runOnMain(new Runnable() { // from class: com.alibaba.ariver.jsapi.app.TabBarBridgeExtension.1
            @Override // java.lang.Runnable
            public void run() {
                if (tabBar.isShowing()) {
                    tabBar.setAutoShow(false);
                    if (!z) {
                        tabBar.hide(null);
                        return;
                    }
                    AnimationSet animationSet = new AnimationSet(true);
                    animationSet.setInterpolator(new AccelerateInterpolator());
                    animationSet.setStartTime(AnimationUtils.currentAnimationTimeMillis());
                    animationSet.setDuration(300L);
                    if ("alpha".equals(string)) {
                        animationSet.addAnimation(new AlphaAnimation(1.0f, 0.0f));
                    } else if (TabBarBridgeExtension.TYPE_ANIM_TRANSLATE.equals(string)) {
                        animationSet.addAnimation(new TranslateAnimation(2, 0.0f, 2, 0.0f, 2, 0.0f, 2, 1.0f));
                    } else {
                        TranslateAnimation translateAnimation = new TranslateAnimation(2, 0.0f, 2, 0.0f, 2, 0.0f, 2, 1.0f);
                        AlphaAnimation alphaAnimation = new AlphaAnimation(1.0f, 0.0f);
                        animationSet.addAnimation(translateAnimation);
                        animationSet.addAnimation(alphaAnimation);
                    }
                    tabBar.hide(animationSet);
                }
            }
        });
    }

    private void showTabBar(@BindingRequest JSONObject jSONObject, final TabBar tabBar) {
        final boolean z = JSONUtils.getBoolean(jSONObject, a.l, false);
        final String string = JSONUtils.getString(jSONObject, "animationType");
        ExecutorUtils.runOnMain(new Runnable() { // from class: com.alibaba.ariver.jsapi.app.TabBarBridgeExtension.2
            @Override // java.lang.Runnable
            public void run() {
                if (tabBar.isShowing()) {
                    return;
                }
                tabBar.setAutoShow(true);
                if (!z) {
                    tabBar.show(null, null);
                    return;
                }
                AnimationSet animationSet = new AnimationSet(true);
                animationSet.setInterpolator(new DecelerateInterpolator());
                animationSet.setStartTime(AnimationUtils.currentAnimationTimeMillis());
                animationSet.setDuration(300L);
                if ("alpha".equals(string)) {
                    animationSet.addAnimation(new AlphaAnimation(0.0f, 1.0f));
                } else if (TabBarBridgeExtension.TYPE_ANIM_TRANSLATE.equals(string)) {
                    animationSet.addAnimation(new TranslateAnimation(2, 0.0f, 2, 0.0f, 2, 1.0f, 2, 0.0f));
                } else {
                    TranslateAnimation translateAnimation = new TranslateAnimation(2, 0.0f, 2, 0.0f, 2, 1.0f, 2, 0.0f);
                    AlphaAnimation alphaAnimation = new AlphaAnimation(0.0f, 1.0f);
                    animationSet.addAnimation(translateAnimation);
                    animationSet.addAnimation(alphaAnimation);
                }
                tabBar.show(null, animationSet);
            }
        });
    }

    @ThreadType(ExecutorType.UI)
    @ActionFilter
    @AutoCallback
    public BridgeResponse addTabBarItem(@BindingParam({"text"}) String str, @BindingParam({RemoteMessageConst.Notification.ICON}) String str2, @BindingParam({"activeIcon"}) String str3, @BindingParam({"tag"}) String str4, @BindingParam({"index"}) int i, @BindingNode(Page.class) Page page) {
        if (page.getApp() == null || page.getApp().getAppContext() == null) {
            return BridgeResponse.UNKNOWN_ERROR;
        }
        if (TextUtils.isEmpty(str)) {
            return BridgeResponse.newError(2, "empty \"text\" is not allowed!");
        }
        TabBar tabBar = page.getApp().getAppContext().getTabBar();
        if (tabBar == null || tabBar.getTabbarModel() == null || tabBar.getTabbarModel().getItems() == null || tabBar.getTabbarModel().getItems().size() == 0) {
            return BridgeResponse.newError(4, "addTabBarItem but no tabbar!");
        }
        if (i < 0 || i >= 5) {
            return BridgeResponse.newError(14, "index must between [0, 5)");
        }
        TabBarModel tabbarModel = tabBar.getTabbarModel();
        if (tabbarModel.getItems().size() >= 5) {
            return BridgeResponse.newError(2, "already have 5 items!");
        }
        if (i >= tabbarModel.getItems().size()) {
            RVLogger.d(TAG, "addTabBarItem index too large, modify it to last one.");
            i = tabbarModel.getItems().size();
        }
        Iterator<TabBarItemModel> it = tabBar.getTabbarModel().getItems().iterator();
        while (it.hasNext()) {
            if (TextUtils.equals(it.next().getTag(), str4)) {
                return BridgeResponse.newError(2, "already have tag: " + str4);
            }
        }
        TabBarItemModel tabBarItemModel = new TabBarItemModel();
        tabBarItemModel.setName(str);
        tabBarItemModel.setIcon(str2);
        tabBarItemModel.setActiveIcon(str3);
        tabBarItemModel.setTag(str4);
        tabBarItemModel.setLaunchParamsTag(str4);
        tabBarItemModel.setUrl("index.html#" + str4);
        tabbarModel.getItems().add(i, tabBarItemModel);
        tabBar.addTabItem(i, tabBarItemModel, false);
        return BridgeResponse.SUCCESS;
    }

    @Override // com.alibaba.ariver.kernel.api.extension.Extension
    public void onFinalized() {
    }

    @Override // com.alibaba.ariver.kernel.api.extension.Extension
    public void onInitialized() {
        RVLogger.d(TAG, "onInitialized");
    }

    @Override // com.alibaba.ariver.kernel.api.security.Guard
    public Permission permit() {
        return null;
    }

    @ThreadType(ExecutorType.UI)
    @ActionFilter
    @AutoCallback
    public BridgeResponse removeTabBarItem(@BindingParam(required = true, value = {"index"}) int i, @BindingNode(Page.class) Page page) {
        if (page.getApp() == null || page.getApp().getAppContext() == null) {
            return BridgeResponse.UNKNOWN_ERROR;
        }
        TabBar tabBar = page.getApp().getAppContext().getTabBar();
        if (tabBar == null || tabBar.getTabbarModel() == null || tabBar.getTabbarModel().getItems() == null || tabBar.getTabbarModel().getItems().size() == 0) {
            return BridgeResponse.newError(4, "removeTabItem but no tabbar!");
        }
        if (i == tabBar.getCurrentIndex()) {
            return BridgeResponse.newError(13, "cannot delete current item!");
        }
        int size = tabBar.getTabbarModel().getItems().size();
        if (size == 1) {
            return BridgeResponse.newError(16, "item " + i + " cannot deleted!");
        }
        if (i >= 5 || i < 0) {
            return BridgeResponse.newError(14, "index must between [0, 5)");
        }
        if (i < size) {
            TabBarItemModel tabBarItemModel = tabBar.getTabbarModel().getItems().get(i);
            tabBar.removeTabItem(i);
            return BridgeResponse.newValue("pagePath", tabBarItemModel.getTag());
        }
        return BridgeResponse.newError(15, "too large index " + i + "(current: " + size + ")");
    }

    @ThreadType(ExecutorType.UI)
    @ActionFilter
    @AutoCallback
    public BridgeResponse setTabBar(@BindingParam({"actionType"}) String str, @BindingParam({"tag"}) String str2, @BindingParam({"index"}) Integer num, @BindingRequest JSONObject jSONObject, @BindingNode(App.class) App app) {
        Integer colorInt;
        if (app.getAppContext() == null) {
            return BridgeResponse.UNKNOWN_ERROR;
        }
        TabBar tabBar = app.getAppContext().getTabBar();
        if (tabBar == null) {
            RVLogger.w(TAG, "setTabBar but no tabber!");
            return BridgeResponse.SUCCESS;
        }
        if (TextUtils.equals(str, AuthConstant.INI_ENABLE)) {
            tabBar.setEnableTabClick(true);
            return BridgeResponse.SUCCESS;
        }
        if (TextUtils.equals(str, "disable")) {
            tabBar.setEnableTabClick(false);
            return BridgeResponse.SUCCESS;
        }
        if (TextUtils.equals(str, "showTabBar")) {
            showTabBar(jSONObject, tabBar);
            return BridgeResponse.SUCCESS;
        }
        if (TextUtils.equals(str, "hideTabBar")) {
            hideTabBar(jSONObject, tabBar);
            return BridgeResponse.SUCCESS;
        }
        if (TextUtils.equals(str, "setTabBarStyle")) {
            Integer colorInt2 = JSONUtils.getColorInt(jSONObject, "color");
            if (jSONObject.containsKey("color") && colorInt2 == null) {
                return BridgeResponse.newError(2, "color invalid!");
            }
            Integer colorInt3 = JSONUtils.getColorInt(jSONObject, "selectedColor");
            if (jSONObject.containsKey("selectedColor") && colorInt3 == null) {
                return BridgeResponse.newError(2, "selectedColor invalid!");
            }
            Long colorLong = JSONUtils.getColorLong(jSONObject, "backgroundColor");
            if (jSONObject.containsKey("backgroundColor") && colorLong == null) {
                return BridgeResponse.newError(2, "backgroundColor invalid!");
            }
            String string = JSONUtils.getString(jSONObject, "borderStyle");
            if (TextUtils.isEmpty(string)) {
                colorInt = null;
            } else {
                if (TextUtils.equals(string, "white")) {
                    colorInt = -1;
                } else {
                    colorInt = TextUtils.equals(string, "black") ? -1710619 : TypeUtils.parseColorInt(string);
                }
                if (colorInt == null) {
                    return BridgeResponse.newError(2, "borderStyleColor invalid!");
                }
            }
            TabBarModel tabbarModel = tabBar.getTabbarModel();
            if (colorInt2 != null) {
                tabbarModel.setTextColor(colorInt2.intValue());
            }
            if (colorInt3 != null) {
                tabbarModel.setSelectedColor(colorInt3.intValue());
            }
            if (colorLong != null) {
                tabbarModel.setBackgroundColor(colorLong.longValue());
            }
            tabBar.changeTabBarStyle(tabbarModel, colorInt);
            return BridgeResponse.SUCCESS;
        }
        int iIntValue = num != null ? num.intValue() : tabBar.getIndexByPage(str2);
        if (iIntValue < 0 || iIntValue > tabBar.getTabbarModel().getItems().size() - 1) {
            return new BridgeResponse.Error(2, "you should specify index or tag!");
        }
        if (TextUtils.equals(str, "redDot")) {
            TabBarBadgeModel tabBarBadgeModel = new TabBarBadgeModel();
            String string2 = JSONUtils.getString(jSONObject, "redDot");
            int i = JSONUtils.getInt(jSONObject, "redDotColor");
            int i2 = JSONUtils.getInt(jSONObject, "redDotSize");
            tabBarBadgeModel.setBadgeText(string2);
            tabBarBadgeModel.setBadgeColor(i);
            tabBarBadgeModel.setBadgeSize(i2);
            tabBar.setTabBarBadge(iIntValue, tabBarBadgeModel);
        } else if (TextUtils.equals(str, "textColor")) {
            TabBarItemModel tabBarItemModel = new TabBarItemModel(tabBar.getTabbarModel().getItems().get(iIntValue));
            int i3 = JSONUtils.getInt(jSONObject, "textColor");
            int i4 = JSONUtils.getInt(jSONObject, "selectedColor");
            tabBarItemModel.setTextColor(Integer.valueOf(i3));
            tabBarItemModel.setSelectedColor(Integer.valueOf(i4));
            tabBar.setTabItem(iIntValue, tabBarItemModel);
        } else if (TextUtils.equals(str, RemoteMessageConst.Notification.ICON)) {
            TabBarItemModel tabBarItemModel2 = new TabBarItemModel(tabBar.getTabbarModel().getItems().get(iIntValue));
            String string3 = JSONUtils.getString(jSONObject, RemoteMessageConst.Notification.ICON);
            String string4 = JSONUtils.getString(jSONObject, "activeIcon");
            tabBarItemModel2.setIcon(string3);
            tabBarItemModel2.setActiveIcon(string4);
            tabBar.setTabItem(iIntValue, tabBarItemModel2);
        } else if (TextUtils.equals(str, "setTabBarBadge")) {
            TabBarBadgeModel tabBarBadgeModel2 = new TabBarBadgeModel();
            String string5 = JSONUtils.getString(jSONObject, "text");
            if (TextUtils.isEmpty(string5)) {
                return BridgeResponse.INVALID_PARAM;
            }
            tabBarBadgeModel2.setBadgeText(string5);
            tabBar.setTabBarBadge(iIntValue, tabBarBadgeModel2);
        } else if (TextUtils.equals(str, "removeTabBarBadge")) {
            tabBar.removeTabBarBadge(iIntValue);
        } else if (TextUtils.equals(str, "showTabBarRedDot")) {
            tabBar.setTabBarBadge(iIntValue, new TabBarBadgeModel());
        } else if (TextUtils.equals(str, "hideTabBarRedDot")) {
            tabBar.removeTabBarBadge(iIntValue);
        } else if (TextUtils.equals(str, "setTabBarItem")) {
            TabBarItemModel tabBarItemModel3 = new TabBarItemModel(tabBar.getTabbarModel().getItems().get(iIntValue));
            String string6 = JSONUtils.getString(jSONObject, "text");
            if (jSONObject.containsKey("text") && TextUtils.isEmpty(string6)) {
                return BridgeResponse.newError(2, "text invalid!");
            }
            String string7 = JSONUtils.getString(jSONObject, "iconPath");
            if (jSONObject.containsKey("iconPath") && TextUtils.isEmpty(string7)) {
                return BridgeResponse.newError(2, "iconPath invalid!");
            }
            String string8 = JSONUtils.getString(jSONObject, "selectedIconPath");
            if (jSONObject.containsKey("selectedIconPath") && TextUtils.isEmpty(string8)) {
                return BridgeResponse.newError(2, "selectedIconPath invalid!");
            }
            if (!TextUtils.isEmpty(string7)) {
                tabBarItemModel3.setIcon(string7);
            }
            if (!TextUtils.isEmpty(string8)) {
                tabBarItemModel3.setActiveIcon(string8);
            }
            if (!TextUtils.isEmpty(string6)) {
                tabBarItemModel3.setName(string6);
            }
            tabBar.setTabItem(iIntValue, tabBarItemModel3);
        }
        return BridgeResponse.SUCCESS;
    }

    @ThreadType(ExecutorType.UI)
    @ActionFilter
    @AutoCallback
    public BridgeResponse switchTab(@BindingParam({"tag"}) String str, @BindingParam({"recreate"}) boolean z, @BindingNode(Page.class) Page page) {
        if (page.getApp().getAppContext() == null) {
            return BridgeResponse.UNKNOWN_ERROR;
        }
        TabBar tabBar = page.getApp().getAppContext().getTabBar();
        if (tabBar == null) {
            page.getApp().getAppContext().createTabBar(page);
            tabBar = page.getApp().getAppContext().getTabBar();
        }
        tabBar.setEnableTabClick(true);
        if (z) {
            tabBar.recreate(str);
        } else {
            int indexByPage = tabBar.getIndexByPage(str);
            if (indexByPage < 0) {
                return BridgeResponse.INVALID_PARAM;
            }
            tabBar.switchTab(indexByPage, 1);
        }
        return BridgeResponse.SUCCESS;
    }
}

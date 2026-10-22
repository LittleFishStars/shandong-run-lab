package com.alibaba.ariver.app.ui.tabbar;

import android.app.Activity;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.StateListDrawable;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.alibaba.ariver.app.R;
import com.alibaba.ariver.app.api.App;
import com.alibaba.ariver.app.api.Page;
import com.alibaba.ariver.app.api.ui.fragment.IFragmentManager;
import com.alibaba.ariver.app.api.ui.tabbar.model.TabBarBadgeModel;
import com.alibaba.ariver.app.api.ui.tabbar.model.TabBarItemModel;
import com.alibaba.ariver.app.api.ui.tabbar.model.TabBarModel;
import com.alibaba.ariver.app.ui.BaseTabBar;
import com.alibaba.ariver.engine.api.extensions.resources.model.ResourceLoadContext;
import com.alibaba.ariver.engine.api.resources.Resource;
import com.alibaba.ariver.engine.api.resources.ResourceLoadPoint;
import com.alibaba.ariver.kernel.RVEvents;
import com.alibaba.ariver.kernel.api.extension.ExtensionPoint;
import com.alibaba.ariver.kernel.common.RVProxy;
import com.alibaba.ariver.kernel.common.network.RVTransportService;
import com.alibaba.ariver.kernel.common.network.http.RVHttpRequest;
import com.alibaba.ariver.kernel.common.service.RVConfigService;
import com.alibaba.ariver.kernel.common.service.executor.ExecutorType;
import com.alibaba.ariver.kernel.common.utils.ExecutorUtils;
import com.alibaba.ariver.kernel.common.utils.FileUtils;
import com.alibaba.ariver.kernel.common.utils.ImageUtil;
import com.alibaba.ariver.kernel.common.utils.JSONUtils;
import com.alibaba.ariver.kernel.common.utils.RVLogger;
import com.alibaba.ariver.resource.api.models.AppModel;
import com.alibaba.fastjson.JSONArray;
import com.huachenjie.mine.page.dressing_table.DressingTableActivity;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public class RVTabBarImpl extends BaseTabBar {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final String f23835a = "AriverInt:SessionTabBar";
    private static final int c = 500;
    private long b;
    private Activity d;
    private RVTabbarLayout e;
    public boolean enableTabClick;
    private LinearLayout f;
    private String g;
    private View h;
    private boolean i;
    private RVTabbarLayout.Listener j;

    public interface ImageListener {
        void onFailed(String str);

        void onLoad(Bitmap bitmap);
    }

    public RVTabBarImpl(App app, Activity activity, IFragmentManager iFragmentManager, ViewGroup viewGroup) {
        super(app, iFragmentManager);
        this.enableTabClick = true;
        this.b = 0L;
        this.j = new RVTabbarLayout.Listener() { // from class: com.alibaba.ariver.app.ui.tabbar.RVTabBarImpl.1
            @Override // com.alibaba.ariver.app.ui.tabbar.RVTabbarLayout.Listener
            public void onTabItemClicked(int i, View view) {
                RVTabBarImpl rVTabBarImpl = RVTabBarImpl.this;
                if (rVTabBarImpl.enableTabClick) {
                    if (rVTabBarImpl.isFastClick() && RVTabBarImpl.this.getCurrentIndex() == i) {
                        return;
                    }
                    RVLogger.d(RVTabBarImpl.f23835a, "tabClick index:" + i);
                    if (RVTabBarImpl.this.getApp().getActivePage() == null) {
                        return;
                    }
                    RVTabBarImpl.this.clearBadge(i);
                    if (!RVTabBarImpl.this.enableInterceptTabClick()) {
                        RVTabBarImpl.this.setSelectedIndex(i);
                    }
                    RVTabBarImpl.this.switchTab(i, 2);
                }
            }
        };
        this.d = activity;
        LinearLayout linearLayout = new LinearLayout(activity);
        this.f = linearLayout;
        linearLayout.setOrientation(1);
        viewGroup.addView(this.f, new ViewGroup.LayoutParams(-1, activity.getResources().getDimensionPixelSize(R.dimen.ariver_tabbar_height)));
        this.i = a(app.getAppId(), JSONUtils.getJSONArray(((RVConfigService) RVProxy.get(RVConfigService.class)).getConfigJSONObject("h5_eventThroughWorker"), RVEvents.TAB_CLICK, null));
    }

    private boolean a(String str, JSONArray jSONArray) {
        if (jSONArray == null) {
            return false;
        }
        RVLogger.d(f23835a, "isAppIdInWhiteList, appId = " + str + ", appIdWhiteList = " + jSONArray);
        for (int i = 0; i < jSONArray.size(); i++) {
            String string = jSONArray.getString(i);
            if (TextUtils.equals(string, ".*") || TextUtils.equals(string, str)) {
                return true;
            }
        }
        return false;
    }

    private int b() {
        RVTabbarLayout rVTabbarLayout = this.e;
        if (rVTabbarLayout != null) {
            return rVTabbarLayout.getTabSize();
        }
        return 0;
    }

    @Override // com.alibaba.ariver.app.ui.BaseTabBar, com.alibaba.ariver.app.api.ui.tabbar.TabBar
    public void addTabItem(int i, TabBarItemModel tabBarItemModel, boolean z) {
        super.addTabItem(i, tabBarItemModel, z);
        TabBarModel tabbarModel = getTabbarModel();
        if (tabBarItemModel != null) {
            String name = tabBarItemModel.getName();
            String tag = tabBarItemModel.getTag();
            String icon = tabBarItemModel.getIcon();
            String activeIcon = tabBarItemModel.getActiveIcon();
            RVTabBarItem rVTabBarItem = new RVTabBarItem(this.d);
            rVTabBarItem.setTag(tag);
            TextView iconAreaView = rVTabBarItem.getIconAreaView();
            iconAreaView.setText(name);
            Integer textColor = tabBarItemModel.getTextColor() == null ? tabbarModel.getTextColor() : tabBarItemModel.getTextColor();
            if (textColor == null) {
                textColor = -16777216;
            }
            Integer selectedColor = tabBarItemModel.getSelectedColor() == null ? tabbarModel.getSelectedColor() : tabBarItemModel.getSelectedColor();
            if (selectedColor == null) {
                selectedColor = -16777216;
            }
            iconAreaView.setTextColor(TabBarUtils.generateTextColor(textColor.intValue(), selectedColor.intValue()));
            StateListDrawable stateListDrawableGenerateEmptyTopDrawable = TabBarUtils.generateEmptyTopDrawable();
            int iA = a();
            stateListDrawableGenerateEmptyTopDrawable.setBounds(0, 0, iA, iA);
            a(activeIcon, iconAreaView, stateListDrawableGenerateEmptyTopDrawable, this.d, iA, true);
            a(icon, iconAreaView, stateListDrawableGenerateEmptyTopDrawable, this.d, iA, false);
            this.e.addTab(i, rVTabBarItem);
        }
    }

    @Override // com.alibaba.ariver.app.ui.BaseTabBar, com.alibaba.ariver.app.api.ui.tabbar.TabBar
    public void changeTabBarStyle(TabBarModel tabBarModel, @Nullable Integer num) {
        boolean zIsAlphaBackground = isAlphaBackground();
        super.changeTabBarStyle(tabBarModel, num);
        if (this.e != null) {
            if (tabBarModel.getTextColor() != null) {
                tabBarModel.setTextColor(getTabbarModel().getTextColor().intValue());
            }
            if (tabBarModel.getSelectedColor() != null) {
                tabBarModel.setSelectedColor(getTabbarModel().getSelectedColor().intValue());
            }
            if (num != null) {
                this.h.setBackgroundColor(num.intValue());
            }
            if (isAlphaBackground() != zIsAlphaBackground) {
                onBackgroundAlphaStatusChanged(isAlphaBackground());
            }
            int childCount = this.e.getChildCount();
            Integer textColor = tabBarModel.getTextColor();
            Integer selectedColor = tabBarModel.getSelectedColor();
            if (textColor == null || selectedColor == null) {
                RVLogger.d(f23835a, "changeTabBarStyle textColor or selectedColor null.");
                return;
            }
            for (int i = 0; i < childCount; i++) {
                TextView iconAreaView = this.e.getTabBarItemAt(i).getIconAreaView();
                if (iconAreaView != null) {
                    iconAreaView.setTextColor(TabBarUtils.generateTextColor(textColor.intValue(), selectedColor.intValue()));
                }
            }
        }
    }

    public void clearBadge(int i) {
        RVTabBarItem tabBarItemAt = this.e.getTabBarItemAt(i);
        TextView badgeAreaView = tabBarItemAt.getBadgeAreaView();
        if (badgeAreaView != null) {
            badgeAreaView.setVisibility(8);
        }
        RVTabDotView smallDotView = tabBarItemAt.getSmallDotView();
        if (smallDotView != null) {
            smallDotView.setVisibility(8);
        }
    }

    @Override // com.alibaba.ariver.app.ui.BaseTabBar, com.alibaba.ariver.app.api.ui.tabbar.TabBar
    public void create(Page page) {
        super.create(page);
        getApp().getStartParams().putInt(DressingTableActivity.x, getCurrentIndex());
        if (isAlphaBackground()) {
            onBackgroundAlphaStatusChanged(true);
        }
        this.e.selectTab(getCurrentIndex());
        this.e.setTabListener(new RVTabbarLayout.Listener() { // from class: com.alibaba.ariver.app.ui.tabbar.RVTabBarImpl.2
            @Override // com.alibaba.ariver.app.ui.tabbar.RVTabbarLayout.Listener
            public void onTabItemClicked(int i, View view) {
                RVTabBarImpl.this.j.onTabItemClicked(i, view);
            }
        });
    }

    @Override // com.alibaba.ariver.app.ui.BaseTabBar
    public boolean enableInterceptTabClick() {
        return this.i;
    }

    @Override // com.alibaba.ariver.app.ui.BaseTabBar, com.alibaba.ariver.app.api.ui.tabbar.TabBar
    public void hide(@Nullable Animation animation) {
        super.hide(animation);
        LinearLayout linearLayout = this.f;
        if (linearLayout != null) {
            if (animation == null) {
                linearLayout.setVisibility(8);
                return;
            }
            linearLayout.clearAnimation();
            this.f.startAnimation(animation);
            animation.setAnimationListener(new Animation.AnimationListener() { // from class: com.alibaba.ariver.app.ui.tabbar.RVTabBarImpl.6
                @Override // android.view.animation.Animation.AnimationListener
                public void onAnimationEnd(Animation animation2) {
                    RVTabBarImpl.this.f.setVisibility(8);
                }

                @Override // android.view.animation.Animation.AnimationListener
                public void onAnimationRepeat(Animation animation2) {
                }

                @Override // android.view.animation.Animation.AnimationListener
                public void onAnimationStart(Animation animation2) {
                }
            });
        }
    }

    @Override // com.alibaba.ariver.app.ui.BaseTabBar, com.alibaba.ariver.app.api.ui.tabbar.TabBar
    public void init(TabBarModel tabBarModel) {
        super.init(tabBarModel);
        this.f.removeAllViews();
        this.e = new RVTabbarLayout(this.d);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, 1);
        View view = new View(this.d);
        this.h = view;
        view.setBackgroundColor(-5526610);
        this.f.addView(this.h, layoutParams);
        this.f.addView(this.e, new LinearLayout.LayoutParams(-1, -1));
        this.g = "default";
        long backgroundColor = tabBarModel.getBackgroundColor();
        if (backgroundColor <= 16777215) {
            backgroundColor |= -16777216;
        }
        this.e.setBackgroundColor((int) backgroundColor);
    }

    public synchronized boolean isFastClick() {
        boolean z;
        long jCurrentTimeMillis = System.currentTimeMillis();
        if (jCurrentTimeMillis - this.b > 500) {
            this.b = jCurrentTimeMillis;
            z = false;
        } else {
            z = true;
        }
        return z;
    }

    public void loadOnlineImage(final String str, @NonNull final ImageListener imageListener) {
        ExecutorUtils.execute(ExecutorType.NETWORK, new Runnable() { // from class: com.alibaba.ariver.app.ui.tabbar.RVTabBarImpl.5
            @Override // java.lang.Runnable
            public void run() {
                try {
                    imageListener.onLoad(BitmapFactory.decodeStream(((RVTransportService) RVProxy.get(RVTransportService.class)).httpRequest(RVHttpRequest.newBuilder().url(str).build()).getResStream()));
                } catch (Throwable th) {
                    imageListener.onFailed(th.getMessage());
                }
            }
        });
    }

    public void onBackgroundAlphaStatusChanged(boolean z) {
        RVLogger.d(f23835a, "onBackgroundAlphaStatusChanged alpha? " + z);
    }

    @Override // com.alibaba.ariver.app.ui.BaseTabBar
    public void onSwitchTab(int i, int i2) {
        super.onSwitchTab(i, i2);
        setSelectedIndex(i);
    }

    @Override // com.alibaba.ariver.app.ui.BaseTabBar
    public void onThemeChanged(boolean z) {
        super.onThemeChanged(z);
        int iB = b();
        for (int i = 0; i < iB; i++) {
            a(i, getTabbarModel(), getTabbarModel().getItems().get(i));
        }
    }

    @Override // com.alibaba.ariver.app.api.ui.tabbar.TabBar
    public void removeTabBarBadge(int i) {
        RVLogger.d(f23835a, "removeTabBadge " + i);
        RVTabbarLayout rVTabbarLayout = this.e;
        if (rVTabbarLayout != null) {
            RVTabBarItem tabBarItemAt = rVTabbarLayout.getTabBarItemAt(i);
            TextView badgeAreaView = tabBarItemAt.getBadgeAreaView();
            if (badgeAreaView != null) {
                badgeAreaView.setVisibility(8);
            }
            RVTabDotView smallDotView = tabBarItemAt.getSmallDotView();
            if (smallDotView != null) {
                smallDotView.setVisibility(8);
            }
        }
    }

    @Override // com.alibaba.ariver.app.ui.BaseTabBar, com.alibaba.ariver.app.api.ui.tabbar.TabBar
    public void removeTabItem(int i) {
        super.removeTabItem(i);
        RVTabbarLayout rVTabbarLayout = this.e;
        if (rVTabbarLayout != null) {
            rVTabbarLayout.removeTab(i);
        }
    }

    @Override // com.alibaba.ariver.app.ui.BaseTabBar, com.alibaba.ariver.app.api.ui.tabbar.TabBar
    public void reset() {
        super.reset();
        RVTabbarLayout rVTabbarLayout = this.e;
        if (rVTabbarLayout != null) {
            rVTabbarLayout.removeAllViews();
        } else {
            RVLogger.w(f23835a, "reset but not init!");
        }
    }

    public void setSelectedIndex(int i) {
        RVTabbarLayout rVTabbarLayout = this.e;
        if (rVTabbarLayout != null) {
            rVTabbarLayout.selectTab(i);
        } else {
            RVLogger.e(f23835a, "setSelectedIndex but tabHost not null!!!");
        }
    }

    @Override // com.alibaba.ariver.app.api.ui.tabbar.TabBar
    public void setTabBarBadge(int i, TabBarBadgeModel tabBarBadgeModel) {
        RVLogger.d(f23835a, "setTabBadge " + i);
        String badgeText = tabBarBadgeModel.getBadgeText();
        int badgeSize = tabBarBadgeModel.getBadgeSize();
        int badgeColor = tabBarBadgeModel.getBadgeColor();
        if (TextUtils.isEmpty(badgeText)) {
            badgeText = "0";
        }
        if (this.e != null) {
            RVLogger.d(f23835a, "setTabBadge value is " + badgeText);
            RVTabBarItem tabBarItemAt = this.e.getTabBarItemAt(i);
            TextView badgeAreaView = tabBarItemAt.getBadgeAreaView();
            RVTabDotView smallDotView = tabBarItemAt.getSmallDotView();
            if (TextUtils.isEmpty(badgeText)) {
                badgeAreaView.setVisibility(8);
                smallDotView.setVisibility(8);
                return;
            }
            String strTrim = badgeText.trim();
            if (TextUtils.equals("-1", strTrim)) {
                badgeAreaView.setVisibility(8);
                smallDotView.setVisibility(8);
            } else if (!TextUtils.equals("0", strTrim)) {
                badgeAreaView.setText(strTrim);
                badgeAreaView.setVisibility(0);
                smallDotView.setVisibility(8);
            } else {
                badgeAreaView.setVisibility(8);
                smallDotView.setDotColor(badgeColor);
                smallDotView.setDotWidth(badgeSize);
                smallDotView.setVisibility(0);
            }
        }
    }

    @Override // com.alibaba.ariver.app.ui.BaseTabBar, com.alibaba.ariver.app.api.ui.tabbar.TabBar
    public void setTabItem(int i, TabBarItemModel tabBarItemModel) {
        super.setTabItem(i, tabBarItemModel);
        if (this.e != null) {
            a(i, getTabbarModel(), tabBarItemModel);
        }
    }

    @Override // com.alibaba.ariver.app.ui.BaseTabBar, com.alibaba.ariver.app.api.ui.tabbar.TabBar
    public void show(@Nullable Page page, @Nullable Animation animation) {
        super.show(page, animation);
        LinearLayout linearLayout = this.f;
        if (linearLayout != null) {
            if (animation != null) {
                linearLayout.clearAnimation();
                this.f.startAnimation(animation);
            }
            this.f.setVisibility(0);
        }
    }

    private void a(String str, final TextView textView, final StateListDrawable stateListDrawable, final Context context, final int i, final boolean z) {
        String strCombinePath = str;
        RVLogger.d(f23835a, "loadImageAsync: " + str);
        if (TextUtils.isEmpty(str)) {
            return;
        }
        boolean zStartsWith = false;
        if (ImageUtil.isBase64Url(str)) {
            Bitmap bitmapBase64ToBitmap = ImageUtil.base64ToBitmap(str);
            if (bitmapBase64ToBitmap == null) {
                return;
            }
            BitmapDrawable bitmapDrawable = new BitmapDrawable(context.getResources(), bitmapBase64ToBitmap);
            bitmapDrawable.setBounds(0, 0, i, i);
            if (z) {
                TabBarUtils.addCheckedState(stateListDrawable, bitmapDrawable);
            } else {
                TabBarUtils.addNormalState(stateListDrawable, bitmapDrawable);
            }
            textView.setCompoundDrawables(null, stateListDrawable, null, null);
            return;
        }
        AppModel appModel = (AppModel) getApp().getData(AppModel.class);
        if (appModel != null) {
            String vhost = appModel.getAppInfoModel().getVhost();
            if (str.startsWith("http")) {
                zStartsWith = str.startsWith(vhost);
            } else {
                strCombinePath = FileUtils.combinePath(vhost, str);
                zStartsWith = true;
            }
        }
        final String str2 = strCombinePath;
        if (!zStartsWith) {
            loadOnlineImage(str2, new ImageListener() { // from class: com.alibaba.ariver.app.ui.tabbar.RVTabBarImpl.3
                @Override // com.alibaba.ariver.app.ui.tabbar.RVTabBarImpl.ImageListener
                public void onFailed(String str3) {
                    RVLogger.d(RVTabBarImpl.f23835a, "load onlineImage onFailed!" + str3);
                }

                @Override // com.alibaba.ariver.app.ui.tabbar.RVTabBarImpl.ImageListener
                public void onLoad(Bitmap bitmap) {
                    if (bitmap != null) {
                        BitmapDrawable bitmapDrawable2 = new BitmapDrawable(context.getResources(), bitmap);
                        int i2 = i;
                        bitmapDrawable2.setBounds(0, 0, i2, i2);
                        if (z) {
                            TabBarUtils.addCheckedState(stateListDrawable, bitmapDrawable2);
                        } else {
                            TabBarUtils.addNormalState(stateListDrawable, bitmapDrawable2);
                        }
                        ExecutorUtils.runOnMain(new Runnable() { // from class: com.alibaba.ariver.app.ui.tabbar.RVTabBarImpl.3.1
                            @Override // java.lang.Runnable
                            public void run() {
                                AnonymousClass3 anonymousClass3 = AnonymousClass3.this;
                                textView.setCompoundDrawables(null, stateListDrawable, null, null);
                            }
                        });
                    }
                }
            });
        } else {
            ExecutorUtils.execute(ExecutorType.IO, new Runnable() { // from class: com.alibaba.ariver.app.ui.tabbar.RVTabBarImpl.4
                @Override // java.lang.Runnable
                public void run() {
                    Bitmap bitmapDecodeStream;
                    Resource resourceLoad = ((ResourceLoadPoint) ExtensionPoint.as(ResourceLoadPoint.class).node(RVTabBarImpl.this.getApp()).create()).load(ResourceLoadContext.newBuilder().originUrl(str2).canUseFallback(true).build());
                    if (resourceLoad == null || (bitmapDecodeStream = BitmapFactory.decodeStream(resourceLoad.getStream())) == null) {
                        return;
                    }
                    final BitmapDrawable bitmapDrawable2 = new BitmapDrawable(context.getResources(), bitmapDecodeStream);
                    int i2 = i;
                    bitmapDrawable2.setBounds(0, 0, i2, i2);
                    ExecutorUtils.runOnMain(new Runnable() { // from class: com.alibaba.ariver.app.ui.tabbar.RVTabBarImpl.4.1
                        @Override // java.lang.Runnable
                        public void run() {
                            AnonymousClass4 anonymousClass4 = AnonymousClass4.this;
                            if (z) {
                                TabBarUtils.addCheckedState(stateListDrawable, bitmapDrawable2);
                            } else {
                                TabBarUtils.addNormalState(stateListDrawable, bitmapDrawable2);
                            }
                            AnonymousClass4 anonymousClass5 = AnonymousClass4.this;
                            textView.setCompoundDrawables(null, stateListDrawable, null, null);
                        }
                    });
                }
            });
        }
    }

    private int a() {
        if (!TextUtils.isEmpty(this.g) && this.g.equalsIgnoreCase("large")) {
            return this.d.getResources().getDimensionPixelSize(R.dimen.ariver_tabbar_tab_large_icon);
        }
        return this.d.getResources().getDimensionPixelSize(R.dimen.ariver_tabbar_tab_icon);
    }

    private void a(int i, TabBarModel tabBarModel, TabBarItemModel tabBarItemModel) {
        RVLogger.d(f23835a, "setTabBarItem ");
        Bundle startParams = getApp().getStartParams();
        String icon = tabBarItemModel.getIcon();
        String activeIcon = tabBarItemModel.getActiveIcon();
        if (this.e != null) {
            try {
                if (ImageUtil.base64ToBitmap(icon) == null) {
                    icon = TabBarUtils.getAbsoluteUrl(icon, startParams);
                }
            } catch (Throwable unused) {
                icon = TabBarUtils.getAbsoluteUrl(icon, startParams);
            }
            String str = icon;
            try {
                if (ImageUtil.base64ToBitmap(activeIcon) == null) {
                    activeIcon = TabBarUtils.getAbsoluteUrl(activeIcon, startParams);
                }
            } catch (Throwable unused2) {
                activeIcon = TabBarUtils.getAbsoluteUrl(activeIcon, startParams);
            }
            RVLogger.d(f23835a, "setTabBarItem iconURL is " + str + ", activeIconURL is " + activeIcon);
            TextView iconAreaView = this.e.getTabBarItemAt(i).getIconAreaView();
            if (iconAreaView != null) {
                iconAreaView.setText(tabBarItemModel.getName());
            }
            Integer textColor = tabBarItemModel.getTextColor() == null ? tabBarModel.getTextColor() : tabBarItemModel.getTextColor();
            if (textColor == null) {
                textColor = -16777216;
            }
            Integer selectedColor = tabBarItemModel.getSelectedColor() == null ? tabBarModel.getSelectedColor() : tabBarItemModel.getSelectedColor();
            if (selectedColor == null) {
                selectedColor = -16777216;
            }
            if (iconAreaView != null) {
                iconAreaView.setTextColor(TabBarUtils.generateTextColor(textColor.intValue(), selectedColor.intValue()));
            }
            StateListDrawable stateListDrawableGenerateEmptyTopDrawable = TabBarUtils.generateEmptyTopDrawable();
            int iA = a();
            stateListDrawableGenerateEmptyTopDrawable.setBounds(0, 0, iA, iA);
            a(activeIcon, iconAreaView, stateListDrawableGenerateEmptyTopDrawable, this.d, iA, true);
            a(str, iconAreaView, stateListDrawableGenerateEmptyTopDrawable, this.d, iA, false);
        }
    }
}

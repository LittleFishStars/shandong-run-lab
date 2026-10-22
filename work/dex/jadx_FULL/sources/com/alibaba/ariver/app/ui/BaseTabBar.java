package com.alibaba.ariver.app.ui;

import android.content.res.Configuration;
import android.graphics.Color;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.SparseArray;
import android.view.animation.Animation;
import androidx.annotation.CallSuper;
import androidx.annotation.Keep;
import androidx.annotation.Nullable;
import com.alibaba.ariver.app.api.App;
import com.alibaba.ariver.app.api.Page;
import com.alibaba.ariver.app.api.ParamUtils;
import com.alibaba.ariver.app.api.point.app.AppOnConfigurationChangedPoint;
import com.alibaba.ariver.app.api.point.page.PageExitPoint;
import com.alibaba.ariver.app.api.ui.darkmode.ThemeUtils;
import com.alibaba.ariver.app.api.ui.fragment.IFragmentManager;
import com.alibaba.ariver.app.api.ui.fragment.RVFragment;
import com.alibaba.ariver.app.api.ui.tabbar.SwitchTabPoint;
import com.alibaba.ariver.app.api.ui.tabbar.TabBar;
import com.alibaba.ariver.app.api.ui.tabbar.model.TabBarItemModel;
import com.alibaba.ariver.app.api.ui.tabbar.model.TabBarModel;
import com.alibaba.ariver.app.proxy.RVPageFactory;
import com.alibaba.ariver.engine.api.EngineUtils;
import com.alibaba.ariver.engine.api.bridge.model.SendToRenderCallback;
import com.alibaba.ariver.kernel.RVConstants;
import com.alibaba.ariver.kernel.RVEvents;
import com.alibaba.ariver.kernel.RVStartParams;
import com.alibaba.ariver.kernel.api.extension.ExtensionManager;
import com.alibaba.ariver.kernel.api.extension.ExtensionPoint;
import com.alibaba.ariver.kernel.common.RVProxy;
import com.alibaba.ariver.kernel.common.log.AppLogContext;
import com.alibaba.ariver.kernel.common.log.AppLogUtils;
import com.alibaba.ariver.kernel.common.log.PageSource;
import com.alibaba.ariver.kernel.common.service.RVExtensionService;
import com.alibaba.ariver.kernel.common.utils.BundleUtils;
import com.alibaba.ariver.kernel.common.utils.ExecutorUtils;
import com.alibaba.ariver.kernel.common.utils.FileUtils;
import com.alibaba.ariver.kernel.common.utils.JSONUtils;
import com.alibaba.ariver.kernel.common.utils.RVLogger;
import com.alibaba.ariver.kernel.common.utils.UrlUtils;
import com.alibaba.fastjson.JSONObject;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
@Keep
public abstract class BaseTabBar implements TabBar {
    protected static final String TAG = "AriverInt:TabBar";
    private App mApp;
    private IFragmentManager mFragmentManager;
    private Page mSelectedPage;
    private TabBarModel mTabBarItemModel;
    private final Set<Page> mTabPages = new HashSet();
    private final SparseArray<Page> mPageIndexArray = new SparseArray<>();
    private boolean mAlphaBackground = false;
    private boolean mEnableTabClick = true;
    private boolean mIsCreating = false;
    private boolean mAlreadyCreated = false;
    private boolean mIsInReset = false;
    private boolean mIsShowing = false;
    private boolean mAutoShow = true;
    private int mCreateIndex = -1;
    private int mCurrentIndex = -1;
    private boolean mCurrentUsingDarkMode = false;

    public class TabBarManageExtension implements AppOnConfigurationChangedPoint, PageExitPoint {
        public TabBarManageExtension() {
        }

        @Override // com.alibaba.ariver.app.api.point.app.AppOnConfigurationChangedPoint
        public void onConfigurationChanged(App app, Configuration configuration, String str) {
            boolean zIsDarkMode;
            RVLogger.d(BaseTabBar.TAG, "onConfigurationChanged colorScheme: " + str);
            if (!ThemeUtils.isSupportDarkTheme(BaseTabBar.this.mApp) || BaseTabBar.this.mCurrentUsingDarkMode == (zIsDarkMode = ThemeUtils.isDarkMode(BaseTabBar.this.mApp.getAppContext().getContext()))) {
                return;
            }
            BaseTabBar.this.mCurrentUsingDarkMode = zIsDarkMode;
            BaseTabBar.this.onThemeChanged(zIsDarkMode);
        }

        @Override // com.alibaba.ariver.kernel.api.extension.Extension
        public void onFinalized() {
        }

        @Override // com.alibaba.ariver.kernel.api.extension.Extension
        public void onInitialized() {
        }

        @Override // com.alibaba.ariver.app.api.point.page.PageExitPoint
        public void onPageExit(Page page) {
            RVLogger.d(BaseTabBar.TAG, "handle page exit! isInReset: " + BaseTabBar.this.mIsInReset);
            if (BaseTabBar.this.mIsInReset || page.getApp() == null || page.getApp().isExited()) {
                return;
            }
            int size = BaseTabBar.this.mPageIndexArray.size();
            for (int i = 0; i < size; i++) {
                if (BaseTabBar.this.mPageIndexArray.get(i) == page) {
                    BaseTabBar.this.mPageIndexArray.delete(i);
                }
            }
            if (BaseTabBar.this.mTabPages.remove(page) && BaseTabBar.this.mTabPages.size() == 0) {
                BaseTabBar.this.reset();
            }
        }
    }

    public BaseTabBar(App app, IFragmentManager iFragmentManager) {
        this.mApp = app;
        this.mFragmentManager = iFragmentManager;
        ExtensionManager extensionManager = ((RVExtensionService) RVProxy.get(RVExtensionService.class)).getExtensionManager();
        extensionManager.registerExtensionByPoint(this.mApp, PageExitPoint.class, new TabBarManageExtension());
        extensionManager.registerExtensionByPoint(this.mApp, AppOnConfigurationChangedPoint.class, new TabBarManageExtension());
    }

    private void deviceLogSwitchTab(Page page, int i) {
        Page page2;
        if (page == null || (page2 = this.mSelectedPage) == null) {
            return;
        }
        String parentId = AppLogUtils.getParentId(page2);
        PageSource pageSource = ((AppLogContext) page.getData(AppLogContext.class, true)).getPageSource();
        pageSource.sourcePageAppLogToken = parentId;
        PageSource.SourceType sourceType = PageSource.SourceType.UNKNOWN;
        if (i == 0) {
            sourceType = PageSource.SourceType.TAB_INIT;
        } else if (i == 1) {
            sourceType = PageSource.SourceType.SWITCH_TAB;
        } else if (i == 2) {
            sourceType = PageSource.SourceType.TAB_CLICK;
        } else if (i == 3) {
            sourceType = PageSource.SourceType.TAB_PUSH;
        }
        pageSource.sourceType = sourceType;
        Page page3 = this.mSelectedPage;
        if (page3 != null) {
            pageSource.sourceDesc = page3.getPageURI();
        }
    }

    private synchronized void handleSwitchTab(Page page, boolean z, int i) {
        boolean z2;
        if (isCreated()) {
            z2 = false;
        } else {
            RVLogger.d(TAG, "handleSwitchTab but not created! createTabBar for " + page);
            create(page);
            z2 = true;
        }
        if (z2 || page != this.mSelectedPage) {
            deviceLogSwitchTab(page, i);
            RVLogger.d(TAG, "handleSwitchTab newPage: " + page + " selectedPage: " + this.mSelectedPage);
            this.mSelectedPage = page;
            while (this.mApp.peekChild() != null) {
                Page page2 = (Page) this.mApp.peekChild();
                page2.hide();
                if (!isTabPage(page2)) {
                    RVLogger.d(TAG, "handleSwitchTab exit notTabPage " + page2);
                    page2.exit(false);
                }
                this.mApp.removeChild(page2);
            }
            this.mApp.pushChild(page);
            if (z) {
                this.mTabPages.add(page);
            } else {
                page.show(null);
            }
            RVFragment rVFragmentFindFragmentForPage = this.mFragmentManager.findFragmentForPage(page);
            if (rVFragmentFindFragmentForPage == null) {
                rVFragmentFindFragmentForPage = this.mFragmentManager.createFragment();
                Bundle bundle = new Bundle();
                bundle.putLong(RVConstants.EXTRA_APP_INSTANCE_ID, this.mApp.getNodeId());
                bundle.putLong(RVConstants.EXTRA_PAGE_INSTANCE_ID, page.getNodeId());
                rVFragmentFindFragmentForPage.setArguments(bundle);
                this.mFragmentManager.pushPage(page, rVFragmentFindFragmentForPage, false);
            } else {
                this.mFragmentManager.attachFragment(rVFragmentFindFragmentForPage, false);
            }
            this.mFragmentManager.resetFragmentToTop(rVFragmentFindFragmentForPage);
            if (this.mApp.getEngineProxy() != null && this.mApp.getEngineProxy().getEngineRouter() != null && page.getRender() != null) {
                this.mApp.getEngineProxy().getEngineRouter().resetRenderToTop(page.getRender());
            }
            Set<RVFragment> fragments = this.mFragmentManager.getFragments();
            if (fragments != null) {
                for (RVFragment rVFragment : fragments) {
                    if (rVFragment != rVFragmentFindFragmentForPage) {
                        this.mFragmentManager.detachFragment(rVFragment, false);
                    }
                }
            }
        }
    }

    private void setAlphaBackground(long j) {
        if (j <= 16777215) {
            j |= -16777216;
        }
        if (Color.alpha((int) j) != 255) {
            this.mAlphaBackground = true;
        }
    }

    @Override // com.alibaba.ariver.app.api.ui.tabbar.TabBar
    public void addTabItem(int i, TabBarItemModel tabBarItemModel, boolean z) {
        RVLogger.d(TAG, "addTabItem with model, index: " + i + " model: " + tabBarItemModel);
        if (this.mIsCreating) {
            return;
        }
        for (int size = this.mTabBarItemModel.getItems().size() - 1; size >= i; size--) {
            Page page = this.mPageIndexArray.get(size);
            if (page != null) {
                this.mPageIndexArray.remove(size);
                this.mPageIndexArray.put(size + 1, page);
            }
        }
        int i2 = this.mCurrentIndex;
        if (i <= i2) {
            this.mCurrentIndex = i2 + 1;
        }
    }

    @Override // com.alibaba.ariver.app.api.ui.tabbar.TabBar
    public void changeTabBarStyle(TabBarModel tabBarModel, @Nullable Integer num) {
        setAlphaBackground(tabBarModel.getBackgroundColor());
    }

    @Override // com.alibaba.ariver.app.api.ui.tabbar.TabBar
    public void create(Page page) {
        this.mAlreadyCreated = true;
        this.mIsCreating = true;
        this.mSelectedPage = page;
        TabBarModel tabBarModel = this.mTabBarItemModel;
        if (tabBarModel != null) {
            List<TabBarItemModel> items = tabBarModel.getItems();
            String hash = UrlUtils.getHash(page.getPageURI());
            int i = -1;
            if (items != null && !items.isEmpty()) {
                int size = items.size();
                int i2 = 0;
                while (i2 < size && i2 < 5) {
                    TabBarItemModel tabBarItemModel = items.get(i2);
                    if (TextUtils.equals(hash, tabBarItemModel.getLaunchParamsTag())) {
                        i = i2;
                    }
                    addTabItem(i2, tabBarItemModel, i2 == i);
                    i2++;
                }
            }
            this.mCreateIndex = i;
            this.mCurrentIndex = i;
            this.mTabPages.add(page);
            this.mPageIndexArray.put(i, page);
        }
        this.mIsCreating = false;
    }

    public Page createPage(String str, Bundle bundle, Bundle bundle2) {
        RVPageFactory rVPageFactory = (RVPageFactory) RVProxy.get(RVPageFactory.class);
        Bundle bundleClone = BundleUtils.clone(bundle);
        Bundle bundleClone2 = BundleUtils.clone(bundle2);
        ParamUtils.filterCreatePageParams(bundleClone);
        bundleClone.putString(RVStartParams.KEY_FRAGMENT_TYPE, RVStartParams.FRAGMENT_TYPE_SUB_TAB);
        return rVPageFactory.createPage(this.mApp, str, bundleClone, bundleClone2);
    }

    public boolean enableInterceptTabClick() {
        return false;
    }

    public App getApp() {
        return this.mApp;
    }

    @Override // com.alibaba.ariver.app.api.ui.tabbar.TabBar
    public int getCreateIndex() {
        return this.mCreateIndex;
    }

    @Override // com.alibaba.ariver.app.api.ui.tabbar.TabBar
    public int getCurrentIndex() {
        return this.mCurrentIndex;
    }

    @Override // com.alibaba.ariver.app.api.ui.tabbar.TabBar
    public int getIndexByPage(String str) {
        List<TabBarItemModel> items;
        TabBarModel tabBarModel = this.mTabBarItemModel;
        if (tabBarModel != null && (items = tabBarModel.getItems()) != null && items.size() != 0) {
            int size = items.size();
            for (int i = 0; i < size; i++) {
                if (TextUtils.equals(str, items.get(i).getLaunchParamsTag())) {
                    return i;
                }
            }
        }
        return -1;
    }

    public Page getPageAt(int i) {
        return this.mPageIndexArray.get(i);
    }

    @Override // com.alibaba.ariver.app.api.ui.tabbar.TabBar
    public int getPageCount() {
        return this.mTabPages.size();
    }

    @Override // com.alibaba.ariver.app.api.ui.tabbar.TabBar
    public synchronized Page getSelectedPage() {
        return this.mSelectedPage;
    }

    @Override // com.alibaba.ariver.app.api.ui.tabbar.TabBar
    public Set<Page> getTabPages() {
        return this.mTabPages;
    }

    @Override // com.alibaba.ariver.app.api.ui.tabbar.TabBar
    public TabBarModel getTabbarModel() {
        return this.mTabBarItemModel;
    }

    @Override // com.alibaba.ariver.app.api.ui.tabbar.TabBar
    @CallSuper
    public void hide(@Nullable Animation animation) {
        RVLogger.d(TAG, "tabbar hide!");
        this.mIsShowing = false;
    }

    @Override // com.alibaba.ariver.app.api.ui.tabbar.TabBar
    public void init(TabBarModel tabBarModel) {
        if (tabBarModel == null || this.mApp.getAppContext() == null) {
            return;
        }
        this.mTabBarItemModel = tabBarModel;
        this.mCurrentUsingDarkMode = ThemeUtils.isDarkMode(this.mApp.getAppContext().getContext());
        setAlphaBackground(getTabbarModel().getBackgroundColor());
        boolean zIsDisableOnInit = this.mTabBarItemModel.isDisableOnInit();
        RVLogger.d(TAG, "TabBar.init usingDarkMode: " + this.mCurrentUsingDarkMode + " disableOnInit " + zIsDisableOnInit);
        if (zIsDisableOnInit) {
            this.mEnableTabClick = false;
        }
    }

    public boolean isAlphaBackground() {
        return this.mAlphaBackground;
    }

    @Override // com.alibaba.ariver.app.api.ui.tabbar.TabBar
    public boolean isAutoShow() {
        return this.mAutoShow;
    }

    @Override // com.alibaba.ariver.app.api.ui.tabbar.TabBar
    public boolean isCreated() {
        return this.mAlreadyCreated;
    }

    @Override // com.alibaba.ariver.app.api.ui.tabbar.TabBar
    public boolean isEnableTabClick() {
        return this.mEnableTabClick;
    }

    @Override // com.alibaba.ariver.app.api.ui.tabbar.TabBar
    public boolean isShowing() {
        return this.mIsShowing;
    }

    @Override // com.alibaba.ariver.app.api.ui.tabbar.TabBar
    public boolean isTabPage(Page page) {
        if (this.mTabPages.contains(page)) {
            return true;
        }
        if (BundleUtils.getBoolean(page.getStartParams(), RVStartParams.KEY_NEW_PAGE_FROM_PUSH_WINDOW, false)) {
            return false;
        }
        String hash = UrlUtils.getHash(page.getPageURI());
        TabBarModel tabBarModel = this.mTabBarItemModel;
        if (tabBarModel != null && tabBarModel.getItems() != null) {
            Iterator<TabBarItemModel> it = this.mTabBarItemModel.getItems().iterator();
            while (it.hasNext()) {
                if (TextUtils.equals(it.next().getLaunchParamsTag(), hash)) {
                    return true;
                }
            }
        }
        return false;
    }

    @Override // com.alibaba.ariver.app.api.ui.tabbar.TabBar
    public void onDestroy() {
        reset();
    }

    public void onSwitchTab(int i, int i2) {
        TabBarItemModel tabBarItemModel = this.mTabBarItemModel.getItems().get(i);
        Page pageAt = getPageAt(i);
        if (pageAt != null) {
            handleSwitchTab(pageAt, false, i2);
        } else {
            Bundle startParams = this.mApp.getStartParams();
            Page pageCreatePage = createPage(FileUtils.combinePath(BundleUtils.getString(startParams, "onlineHost"), tabBarItemModel.getUrl()), startParams, this.mApp.getSceneParams());
            this.mPageIndexArray.put(i, pageCreatePage);
            handleSwitchTab(pageCreatePage, true, i2);
        }
        ((SwitchTabPoint) ExtensionPoint.as(SwitchTabPoint.class).node(this.mApp).create()).onSwitchTab(this.mApp, i);
    }

    public void onThemeChanged(boolean z) {
        setAlphaBackground(getTabbarModel().getBackgroundColor());
        RVLogger.d(TAG, "onThemeChanged! useDarkMode: " + z);
    }

    @Override // com.alibaba.ariver.app.api.ui.tabbar.TabBar
    public void recreate(String str) {
        String pageURI;
        int iIndexOf;
        if (this.mApp.getActivePage() == null || (iIndexOf = (pageURI = this.mApp.getActivePage().getPageURI()).indexOf(35)) == -1) {
            return;
        }
        String str2 = pageURI.substring(0, iIndexOf + 1) + str;
        Bundle bundleClone = BundleUtils.clone(this.mApp.getStartParams());
        bundleClone.putString(RVStartParams.KEY_FROM_TYPE, RVStartParams.FROM_TYPE_PUSH_RELAUNCH);
        this.mApp.relaunchToUrl(str2, bundleClone, BundleUtils.clone(this.mApp.getSceneParams()));
    }

    @Override // com.alibaba.ariver.app.api.ui.tabbar.TabBar
    public void removeTabItem(int i) {
        RVLogger.d(TAG, "removeTabItem: " + i);
        int size = this.mTabBarItemModel.getItems().size();
        Page pageAt = getPageAt(i);
        int i2 = i;
        while (i2 < size - 1) {
            int i3 = i2 + 1;
            Page page = this.mPageIndexArray.get(i3);
            if (page != null) {
                this.mPageIndexArray.remove(i3);
                this.mPageIndexArray.put(i2, page);
            }
            i2 = i3;
        }
        if (pageAt != null) {
            this.mTabPages.remove(pageAt);
            pageAt.exit(false);
        }
        this.mTabBarItemModel.getItems().remove(i);
        int i4 = this.mCurrentIndex;
        if (i <= i4) {
            this.mCurrentIndex = i4 - 1;
        }
    }

    @Override // com.alibaba.ariver.app.api.ui.tabbar.TabBar
    public void reset() {
        this.mIsInReset = true;
        try {
            this.mCurrentIndex = -1;
            this.mAlreadyCreated = false;
            for (Page page : this.mTabPages) {
                ((Page.AnimStore) page.getData(Page.AnimStore.class, true)).disableExit = true;
                page.exit(this.mApp.isExited());
            }
            this.mTabPages.clear();
            this.mPageIndexArray.clear();
        } finally {
            this.mIsInReset = false;
        }
    }

    @Override // com.alibaba.ariver.app.api.ui.tabbar.TabBar
    public void setAutoShow(boolean z) {
        this.mAutoShow = z;
    }

    @Override // com.alibaba.ariver.app.api.ui.tabbar.TabBar
    public void setEnableTabClick(boolean z) {
        this.mEnableTabClick = z;
    }

    @Override // com.alibaba.ariver.app.api.ui.tabbar.TabBar
    public synchronized void setSelectedPage(Page page) {
        this.mSelectedPage = page;
    }

    @Override // com.alibaba.ariver.app.api.ui.tabbar.TabBar
    @CallSuper
    public void setTabItem(int i, TabBarItemModel tabBarItemModel) {
        TabBarModel tabBarModel;
        if (i < 0 || tabBarItemModel == null || (tabBarModel = this.mTabBarItemModel) == null) {
            return;
        }
        tabBarModel.getItems().set(i, tabBarItemModel);
    }

    @Override // com.alibaba.ariver.app.api.ui.tabbar.TabBar
    @CallSuper
    public void show(@Nullable Page page, @Nullable Animation animation) {
        RVLogger.d(TAG, "tabbar show!");
        this.mIsShowing = true;
        if (page != null) {
            if (this.mAlreadyCreated) {
                handleSwitchTab(page, false, 0);
            } else {
                create(page);
            }
        }
    }

    @Override // com.alibaba.ariver.app.api.ui.tabbar.TabBar
    public void showDefaultTab(int i) {
    }

    @Override // com.alibaba.ariver.app.api.ui.tabbar.TabBar
    public boolean switchTab(final int i, final int i2) {
        RVLogger.d(TAG, "switchTab to index: " + i + " fromType: " + i2);
        if (i2 == 2 && !isEnableTabClick()) {
            return false;
        }
        if (i2 == 1) {
            setEnableTabClick(true);
        }
        if (i >= getTabbarModel().getItems().size()) {
            return false;
        }
        if (this.mAlreadyCreated) {
            ArrayList<Page> arrayList = new ArrayList();
            for (int alivePageCount = this.mApp.getAlivePageCount() - 1; alivePageCount >= 0; alivePageCount--) {
                Page pageByIndex = this.mApp.getPageByIndex(alivePageCount);
                if (!pageByIndex.isUseForEmbed() && !this.mTabPages.contains(pageByIndex)) {
                    RVLogger.d(TAG, "switchTab exit nonTabBar Page: " + pageByIndex);
                    arrayList.add(pageByIndex);
                }
            }
            for (Page page : arrayList) {
                ((Page.AnimStore) page.getData(Page.AnimStore.class, true)).disableExit = true;
                page.exit(false);
            }
        }
        final int i3 = this.mCurrentIndex;
        if (i == i3) {
            RVLogger.e(TAG, "switchTab already in this index!!!");
            return false;
        }
        this.mCurrentIndex = i;
        if (this.mTabBarItemModel == null) {
            RVLogger.e(TAG, "switchTab but not inflate yet!!!");
        }
        if (i2 != 2) {
            RVLogger.d(TAG, "switchTabDirect!");
            onSwitchTab(i, i2);
            return true;
        }
        TabBarItemModel tabBarItemModel = getTabbarModel().getItems().get(i);
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("tag", (Object) tabBarItemModel.getTag());
        jSONObject.put("index", (Object) Integer.valueOf(i));
        jSONObject.put("pagePath", (Object) tabBarItemModel.getTag());
        jSONObject.put("text", (Object) getTabbarModel().getItems().get(i).getName());
        JSONObject jSONObject2 = new JSONObject();
        jSONObject2.put("data", (Object) jSONObject);
        Page activePage = getApp().getActivePage();
        if (activePage != null && activePage.getRender() != null) {
            RVLogger.d(TAG, "switchTab with tabClick!");
            final boolean zEnableInterceptTabClick = enableInterceptTabClick();
            EngineUtils.sendToRender(activePage.getRender(), RVEvents.TAB_CLICK, jSONObject2, new SendToRenderCallback() { // from class: com.alibaba.ariver.app.ui.BaseTabBar.1
                @Override // com.alibaba.ariver.engine.api.bridge.model.SendToRenderCallback
                public void onCallBack(JSONObject jSONObject3) {
                    if (zEnableInterceptTabClick) {
                        if (!JSONUtils.getBoolean(jSONObject3, RVConstants.EXTRA_PREVENTED, false)) {
                            ExecutorUtils.runOnMain(new Runnable() { // from class: com.alibaba.ariver.app.ui.BaseTabBar.1.1
                                @Override // java.lang.Runnable
                                public void run() {
                                    if (BaseTabBar.this.getApp() == null || BaseTabBar.this.getApp().isExited()) {
                                        return;
                                    }
                                    AnonymousClass1 anonymousClass1 = AnonymousClass1.this;
                                    BaseTabBar.this.onSwitchTab(i, i2);
                                }
                            });
                            return;
                        }
                        RVLogger.d(BaseTabBar.TAG, "sendTabClickEventToWeb prevented change current to origin: " + i3);
                        BaseTabBar.this.mCurrentIndex = i3;
                    }
                }
            });
            if (!zEnableInterceptTabClick) {
                onSwitchTab(i, i2);
            }
        }
        return true;
    }

    @Override // com.alibaba.ariver.app.api.ui.tabbar.TabBar
    public int getIndexByPage(Page page) {
        return getIndexByPage(UrlUtils.getHash(page.getPageURI()));
    }
}

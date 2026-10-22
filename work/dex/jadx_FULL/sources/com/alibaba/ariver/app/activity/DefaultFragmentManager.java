package com.alibaba.ariver.app.activity;

import android.os.Bundle;
import androidx.annotation.IdRes;
import androidx.annotation.Keep;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import com.alibaba.ariver.app.api.App;
import com.alibaba.ariver.app.api.Page;
import com.alibaba.ariver.app.api.R;
import com.alibaba.ariver.app.api.activity.AnimUtils;
import com.alibaba.ariver.app.api.ui.fragment.IFragmentManager;
import com.alibaba.ariver.app.api.ui.fragment.RVFragment;
import com.alibaba.ariver.app.api.ui.tabbar.TabBar;
import com.alibaba.ariver.kernel.RVConstants;
import com.alibaba.ariver.kernel.common.utils.ExecutorUtils;
import com.alibaba.ariver.kernel.common.utils.RVKernelUtils;
import com.alibaba.ariver.kernel.common.utils.RVLogger;
import com.alibaba.ariver.kernel.common.utils.RVTraceKey;
import com.alibaba.ariver.kernel.common.utils.RVTraceUtils;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.Stack;
import java.util.concurrent.atomic.AtomicInteger;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
@Keep
public class DefaultFragmentManager implements IFragmentManager {
    protected static final String READY_TAG = "mReadyFragment";
    private static final String TAG = "AriverInt:FragmentManager";
    protected FragmentActivity mActivity;
    protected App mApp;
    protected int mContentId;
    protected FragmentManager mFragmentManager;
    protected final Stack<RVFragment> mFragmentStack;
    protected Map<Page, RVFragment> mPageFragmentMap;
    protected final AtomicInteger mReadyCounter;
    protected RVFragment mReadyFragment;

    public DefaultFragmentManager(App app, @IdRes int i, FragmentActivity fragmentActivity) {
        AtomicInteger atomicInteger = new AtomicInteger(0);
        this.mReadyCounter = atomicInteger;
        this.mPageFragmentMap = new HashMap();
        this.mFragmentStack = new Stack<>();
        RVTraceUtils.traceBeginSection(RVTraceKey.RV_FragmentManager_constructor);
        if (RVKernelUtils.isDebug()) {
            FragmentManager.enableDebugLogging(true);
        }
        this.mApp = app;
        this.mActivity = fragmentActivity;
        this.mFragmentManager = fragmentActivity.getSupportFragmentManager();
        this.mContentId = i;
        this.mReadyFragment = createFragment();
        Bundle bundle = new Bundle();
        bundle.putLong(RVConstants.EXTRA_APP_INSTANCE_ID, app.getNodeId());
        this.mReadyFragment.setArguments(bundle);
        this.mReadyFragment.setAlreadyScheduleAdded(true);
        this.mFragmentManager.beginTransaction().add(i, this.mReadyFragment, READY_TAG + atomicInteger.addAndGet(1)).hide(this.mReadyFragment).commitAllowingStateLoss();
        RVTraceUtils.traceEndSection(RVTraceKey.RV_FragmentManager_constructor);
    }

    @Override // com.alibaba.ariver.app.api.ui.fragment.IFragmentManager
    public synchronized boolean attachFragment(RVFragment rVFragment, boolean z) {
        if (!this.mActivity.isFinishing() && this.mApp.getAppContext() != null) {
            if (rVFragment != null && !rVFragment.isVisible()) {
                RVLogger.d(TAG, "attachFragment: " + rVFragment);
                checkTabBar(rVFragment.getPage());
                FragmentTransaction fragmentTransactionBeginTransaction = this.mFragmentManager.beginTransaction();
                if (z) {
                    rVFragment.setShouldResumeWebView(true);
                    int animResId = AnimUtils.getAnimResId(this.mActivity, RVFragment.TRANSLATE_IN_RIGHT_ID);
                    if (animResId == 0) {
                        animResId = R.anim.ariver_fragment_translate_in_right_default;
                    }
                    fragmentTransactionBeginTransaction.setCustomAnimations(animResId, 0);
                }
                fragmentTransactionBeginTransaction.attach(rVFragment).commitAllowingStateLoss();
                return true;
            }
            return false;
        }
        RVLogger.d(TAG, "activity is finishing");
        return false;
    }

    public void checkTabBar(Page page) {
        TabBar tabBar;
        if (this.mApp.getAppContext() == null || (tabBar = this.mApp.getAppContext().getTabBar()) == null || page == null) {
            return;
        }
        boolean zIsTabPage = tabBar.isTabPage(page);
        if (zIsTabPage && !tabBar.isShowing() && tabBar.isAutoShow()) {
            tabBar.show(null, null);
        } else {
            if (zIsTabPage || !tabBar.isShowing()) {
                return;
            }
            tabBar.hide(null);
        }
    }

    @Override // com.alibaba.ariver.app.api.ui.fragment.IFragmentManager
    public RVFragment createFragment() {
        return new RVFragment();
    }

    @Override // com.alibaba.ariver.app.api.ui.fragment.IFragmentManager
    public synchronized boolean detachFragment(RVFragment rVFragment, boolean z) {
        if (this.mActivity.isFinishing()) {
            RVLogger.d(TAG, "activity is finishing");
            return false;
        }
        if (rVFragment != null && !rVFragment.isHidden()) {
            RVLogger.d(TAG, "attachFragment: " + rVFragment);
            FragmentTransaction fragmentTransactionBeginTransaction = this.mFragmentManager.beginTransaction();
            if (z) {
                try {
                    int animResId = AnimUtils.getAnimResId(this.mActivity, RVFragment.TRANSLATE_OUT_LEFT_ID);
                    if (animResId == 0) {
                        animResId = R.anim.ariver_fragment_translate_out_left_default;
                    }
                    fragmentTransactionBeginTransaction.setCustomAnimations(0, animResId);
                } catch (Throwable th) {
                    RVLogger.e(TAG, th);
                }
            }
            fragmentTransactionBeginTransaction.detach(rVFragment).commitAllowingStateLoss();
            return true;
        }
        return false;
    }

    @Override // com.alibaba.ariver.app.api.ui.fragment.IFragmentManager
    public synchronized boolean exitPage(Page page, boolean z, boolean z2) {
        if (this.mApp.getAppContext() != null && !this.mActivity.isFinishing() && !this.mFragmentManager.isDestroyed()) {
            RVFragment rVFragmentRemove = this.mPageFragmentMap.remove(page);
            if (rVFragmentRemove == null) {
                return false;
            }
            if (this.mFragmentStack.size() <= 1 && z2) {
                return false;
            }
            if (rVFragmentRemove.getActivity() != null && rVFragmentRemove.getActivity().isFinishing()) {
                return true;
            }
            RVLogger.d(TAG, "exitPage: " + page + " " + rVFragmentRemove + " fragmentStack: " + this.mFragmentStack.size() + " useTranslateAnim: " + z);
            boolean z3 = rVFragmentRemove == this.mFragmentStack.peek();
            this.mFragmentStack.remove(rVFragmentRemove);
            FragmentTransaction fragmentTransactionBeginTransaction = this.mFragmentManager.beginTransaction();
            if (z) {
                int animResId = AnimUtils.getAnimResId(this.mActivity, RVFragment.TRANSLATE_OUT_RIGHT_ID);
                if (animResId == 0) {
                    animResId = R.anim.ariver_fragment_translate_out_right_default;
                }
                int animResId2 = AnimUtils.getAnimResId(this.mActivity, RVFragment.TRANSLATE_IN_RIGHT_ID);
                if (animResId2 == 0) {
                    animResId2 = R.anim.ariver_fragment_translate_in_right_default;
                }
                fragmentTransactionBeginTransaction.setCustomAnimations(animResId2, animResId);
            }
            if (this.mFragmentStack.size() > 0) {
                RVFragment rVFragmentPeek = this.mFragmentStack.peek();
                if (z) {
                    rVFragmentPeek.setShouldResumeWebView(true);
                }
                fragmentTransactionBeginTransaction.attach(rVFragmentPeek);
            }
            fragmentTransactionBeginTransaction.remove(rVFragmentRemove);
            fragmentTransactionBeginTransaction.commitAllowingStateLoss();
            Page activePage = this.mApp.getActivePage();
            if (activePage != null && z3 && !this.mFragmentStack.isEmpty()) {
                checkTabBar(activePage);
            }
            return true;
        }
        RVLogger.d(TAG, "activity is finishing");
        return false;
    }

    @Override // com.alibaba.ariver.app.api.ui.fragment.IFragmentManager
    public RVFragment findFragmentForPage(Page page) {
        return this.mPageFragmentMap.get(page);
    }

    @Override // com.alibaba.ariver.app.api.ui.fragment.IFragmentManager
    public Set<RVFragment> getFragments() {
        return new HashSet(this.mFragmentStack);
    }

    @Override // com.alibaba.ariver.app.api.ui.fragment.IFragmentManager
    public FragmentManager getInnerManager() {
        return this.mFragmentManager;
    }

    @Override // com.alibaba.ariver.app.api.ui.fragment.IFragmentManager
    public synchronized RVFragment getReadyFragment() {
        Fragment fragmentFindFragmentByTag = null;
        if (this.mReadyFragment != null) {
            if ((READY_TAG + this.mReadyCounter.get()).equals(this.mReadyFragment.getTag())) {
                StringBuilder sb = new StringBuilder();
                sb.append("getReadyFragment hit field: ");
                sb.append(this.mReadyCounter);
                sb.append(" ");
                sb.append(this.mReadyFragment != null);
                RVLogger.d(TAG, sb.toString());
                RVFragment rVFragment = this.mReadyFragment;
                this.mReadyFragment = null;
                fragmentFindFragmentByTag = rVFragment;
            }
        }
        if (fragmentFindFragmentByTag == null) {
            fragmentFindFragmentByTag = this.mFragmentManager.findFragmentByTag(READY_TAG + this.mReadyCounter.get());
        }
        if (fragmentFindFragmentByTag == null) {
            RVLogger.d(TAG, "getReadyFragment miss! mReadyCounter: " + this.mReadyCounter);
            return createFragment();
        }
        RVLogger.d(TAG, "getReadyFragment hit! mReadyCounter: " + this.mReadyCounter);
        this.mReadyCounter.incrementAndGet();
        return (RVFragment) fragmentFindFragmentByTag;
    }

    @Override // com.alibaba.ariver.app.api.ui.fragment.IFragmentManager
    public synchronized void pushPage(Page page, RVFragment rVFragment, boolean z) {
        pushPage(page, rVFragment, this.mContentId, z);
    }

    @Override // com.alibaba.ariver.app.api.ui.fragment.IFragmentManager
    public synchronized void release() {
        this.mPageFragmentMap.clear();
        this.mFragmentStack.clear();
        this.mReadyFragment = null;
    }

    @Override // com.alibaba.ariver.app.api.ui.fragment.IFragmentManager
    public synchronized void resetFragmentToTop(RVFragment rVFragment) {
        if (!this.mFragmentStack.empty() && this.mFragmentStack.remove(rVFragment)) {
            this.mFragmentStack.push(rVFragment);
        }
    }

    public void pushPage(final Page page, RVFragment rVFragment, int i, boolean z) {
        if (this.mApp.getAppContext() != null && !this.mActivity.isFinishing() && rVFragment != null && !this.mFragmentStack.contains(rVFragment)) {
            RVLogger.d(TAG, "pushPage: " + page + " " + rVFragment + " useTranslateAnim: " + z);
            this.mPageFragmentMap.put(page, rVFragment);
            if (!this.mFragmentStack.isEmpty()) {
                RVFragment rVFragmentPeek = this.mFragmentStack.peek();
                rVFragmentPeek.pauseRender();
                detachFragment(rVFragmentPeek, z);
            }
            if (!this.mFragmentStack.contains(rVFragment)) {
                this.mFragmentStack.push(rVFragment);
            }
            if (this.mActivity.isFinishing()) {
                return;
            }
            RVTraceUtils.traceBeginSection(RVTraceKey.RV_FragmentManager_addFragment);
            FragmentTransaction fragmentTransactionBeginTransaction = this.mFragmentManager.beginTransaction();
            RVLogger.d(TAG, "add fragment");
            if (z) {
                try {
                    RVLogger.d(TAG, "fragment use translate anim.");
                    rVFragment.setShouldResumeWebView(true);
                    int animResId = AnimUtils.getAnimResId(this.mActivity, RVFragment.TRANSLATE_IN_LEFT_ID);
                    if (animResId == 0) {
                        animResId = R.anim.ariver_fragment_translate_in_left_default;
                    }
                    fragmentTransactionBeginTransaction.setCustomAnimations(animResId, 0);
                } catch (Throwable th) {
                    try {
                        RVLogger.e(TAG, "catch fragment exception ", th);
                    } finally {
                        RVTraceUtils.traceEndSection(RVTraceKey.RV_FragmentManager_addFragment);
                    }
                }
            }
            if (!rVFragment.isAdded() && !rVFragment.isAlreadyScheduleAdded()) {
                fragmentTransactionBeginTransaction.add(i, rVFragment);
            } else {
                fragmentTransactionBeginTransaction.show(rVFragment);
            }
            fragmentTransactionBeginTransaction.commitAllowingStateLoss();
            ExecutorUtils.runOnMain(new Runnable() { // from class: com.alibaba.ariver.app.activity.DefaultFragmentManager.1
                @Override // java.lang.Runnable
                public void run() {
                    if (DefaultFragmentManager.this.mApp.isDestroyed()) {
                        return;
                    }
                    DefaultFragmentManager.this.checkTabBar(page);
                }
            });
            return;
        }
        RVLogger.e(TAG, "pushPage with illegal state!!!");
    }

    public DefaultFragmentManager(App app, @IdRes int i, Fragment fragment) {
        AtomicInteger atomicInteger = new AtomicInteger(0);
        this.mReadyCounter = atomicInteger;
        this.mPageFragmentMap = new HashMap();
        this.mFragmentStack = new Stack<>();
        this.mApp = app;
        this.mActivity = fragment.getActivity();
        this.mFragmentManager = fragment.getChildFragmentManager();
        this.mContentId = i;
        this.mReadyFragment = createFragment();
        Bundle bundle = new Bundle();
        bundle.putLong(RVConstants.EXTRA_APP_INSTANCE_ID, app.getNodeId());
        this.mReadyFragment.setArguments(bundle);
        this.mReadyFragment.setAlreadyScheduleAdded(true);
        this.mFragmentManager.beginTransaction().add(i, this.mReadyFragment, READY_TAG + atomicInteger.addAndGet(1)).hide(this.mReadyFragment).commitAllowingStateLoss();
    }
}

package com.alibaba.ariver.app.api.ui.fragment;

import android.app.Activity;
import android.content.Context;
import android.content.res.Configuration;
import android.os.Bundle;
import android.os.SystemClock;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.FrameLayout;
import android.widget.RelativeLayout;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import com.alibaba.ariver.app.api.App;
import com.alibaba.ariver.app.api.AppManager;
import com.alibaba.ariver.app.api.Page;
import com.alibaba.ariver.app.api.PageContext;
import com.alibaba.ariver.app.api.ParamUtils;
import com.alibaba.ariver.app.api.R;
import com.alibaba.ariver.app.api.activity.AnimUtils;
import com.alibaba.ariver.app.api.ui.ErrorView;
import com.alibaba.ariver.app.api.ui.PageContainer;
import com.alibaba.ariver.app.api.ui.RVViewFactory;
import com.alibaba.ariver.app.api.ui.ViewSpecProvider;
import com.alibaba.ariver.app.api.ui.ViewUtils;
import com.alibaba.ariver.app.api.ui.loading.LoadingView;
import com.alibaba.ariver.app.api.ui.titlebar.TitleBar;
import com.alibaba.ariver.engine.api.EngineUtils;
import com.alibaba.ariver.engine.api.embedview.IEmbedViewManager;
import com.alibaba.ariver.ipc.RemoteCallClient;
import com.alibaba.ariver.kernel.RVConstants;
import com.alibaba.ariver.kernel.RVEvents;
import com.alibaba.ariver.kernel.RVStartParams;
import com.alibaba.ariver.kernel.api.track.EventTrackStore;
import com.alibaba.ariver.kernel.api.track.EventTracker;
import com.alibaba.ariver.kernel.api.track.TrackId;
import com.alibaba.ariver.kernel.common.RVProxy;
import com.alibaba.ariver.kernel.common.utils.BundleUtils;
import com.alibaba.ariver.kernel.common.utils.DimensionUtil;
import com.alibaba.ariver.kernel.common.utils.ExecutorUtils;
import com.alibaba.ariver.kernel.common.utils.ProcessUtils;
import com.alibaba.ariver.kernel.common.utils.RVLogger;
import com.alibaba.ariver.kernel.common.utils.RVTraceKey;
import com.alibaba.ariver.kernel.common.utils.RVTraceUtils;
import com.alibaba.fastjson.JSONObject;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public class RVFragment extends Fragment implements PageContext {
    private static final String TAG = "AriverApp:RVFragment";
    public static final String TRANSLATE_IN_LEFT_ID = "ariver_fragment_translate_in_left";
    public static final String TRANSLATE_IN_RIGHT_ID = "ariver_fragment_translate_in_right";
    public static final String TRANSLATE_OUT_LEFT_ID = "ariver_fragment_translate_out_left";
    public static final String TRANSLATE_OUT_RIGHT_ID = "ariver_fragment_translate_out_right";
    private IEmbedViewManager mEmbedViewManager;
    private ErrorView mErrorView;
    private LoadingView mLoadingView;

    @Nullable
    private Page mPage;
    private PageContainer mPageContainer;
    private RelativeLayout mRootView;
    private TitleBar mTitleBar;
    private ViewSpecProvider mViewSpecProvider;
    private Page mPendingSetPage = null;
    private boolean mIsFragmentStarted = false;
    private boolean mIsBetweenStartPause = false;
    private boolean mAlreadyScheduleAdded = false;
    private long mOnViewCreatedTime = 0;
    private boolean mShouldResumeWebView = false;

    /* JADX INFO: Access modifiers changed from: private */
    public void setPageOnMain(Page page) {
        boolean zIsTransparentTitle;
        RVTraceUtils.traceBeginSection(RVTraceKey.RV_Fragment_bindContext);
        try {
            if (this.mPage != null) {
                RVLogger.e(TAG, "cannot attachPage twice in NebulaFragment!");
                RVTraceUtils.traceEndSection(RVTraceKey.RV_Fragment_bindContext);
                return;
            }
            ((EventTracker) RVProxy.get(EventTracker.class)).stub(page, TrackId.Stub_FragmentOnViewCreated, this.mOnViewCreatedTime);
            this.mPage = page;
            this.mLoadingView = ((RVViewFactory) RVProxy.get(RVViewFactory.class)).createLoadingView(getActivity(), page);
            page.bindContext(this);
            RVTraceUtils.traceEndSection(RVTraceKey.RV_Fragment_bindContext);
            try {
                RVTraceUtils.traceBeginSection(RVTraceKey.RV_Fragment_UICreate);
                this.mPageContainer.attachPage(page);
                ((EventTracker) RVProxy.get(EventTracker.class)).stub(page, TrackId.Stub_PageShow);
                ((EventTrackStore) page.getData(EventTrackStore.class, true)).whiteScreenAttrMap.put(TrackId.Stub_PageShow, Long.valueOf(SystemClock.elapsedRealtime()));
                RVTraceUtils.traceBeginSection(RVTraceKey.RV_Fragment_applyTransparentTitle);
                if (!BundleUtils.getBoolean(page.getStartParams(), RVStartParams.KEY_TRANSPARENT, false)) {
                    if (page.getStartParams() == null || !page.getStartParams().containsKey("transparentTitle")) {
                        zIsTransparentTitle = false;
                    } else {
                        zIsTransparentTitle = ViewUtils.isTransparentTitle(page.getStartParams(), BundleUtils.getString(page.getStartParams(), "transparentTitle"));
                    }
                    applyTransparentTitle(zIsTransparentTitle);
                }
                RVTraceUtils.traceEndSection(RVTraceKey.RV_Fragment_applyTransparentTitle);
                ViewGroup view = this.mPageContainer.getView();
                this.mPageContainer.addRenderView(page.getRender().getView());
                this.mRootView.addView(view, 0);
                if (this.mTitleBar != null) {
                    RVTraceUtils.traceBeginSection(RVTraceKey.RV_Fragment_titleBarAttachPage);
                    this.mTitleBar.attachPage(page);
                    RVTraceUtils.traceEndSection(RVTraceKey.RV_Fragment_titleBarAttachPage);
                }
                Page page2 = this.mPage;
                if (page2 != null) {
                    ParamUtils.processTransparent(page2.getStartParams());
                }
                RVTraceUtils.traceBeginSection(RVTraceKey.RV_Fragment_pageEnter);
                page.enter();
                RVTraceUtils.traceEndSection(RVTraceKey.RV_Fragment_pageEnter);
            } finally {
                RVTraceUtils.traceEndSection(RVTraceKey.RV_Fragment_UICreate);
            }
        } catch (Throwable th) {
            RVTraceUtils.traceEndSection(RVTraceKey.RV_Fragment_bindContext);
            throw th;
        }
    }

    @Override // com.alibaba.ariver.app.api.PageContext
    public void applyTransparentTitle(boolean z) {
        ViewGroup view = this.mPageContainer.getView();
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(ViewUtils.specToLayoutParam(-1), ViewUtils.specToLayoutParam(this.mViewSpecProvider.getPageHeightSpec(z)));
        if (z) {
            RVLogger.d(TAG, "transTitle: true");
            layoutParams.addRule(6);
            layoutParams.height = ViewUtils.specToLayoutParam(this.mViewSpecProvider.getHeightSpec());
        } else {
            TitleBar titleBar = this.mTitleBar;
            if (titleBar != null && titleBar.getContent() != null) {
                layoutParams.addRule(3, this.mTitleBar.getContent().getId());
            }
        }
        view.setLayoutParams(layoutParams);
    }

    @Override // com.alibaba.ariver.app.api.PageContext
    public void destroy() {
        IEmbedViewManager embedViewManager = getEmbedViewManager();
        if (embedViewManager != null) {
            embedViewManager.releaseViews();
        }
    }

    @Override // com.alibaba.ariver.app.api.PageContext
    public /* bridge */ /* synthetic */ Activity getActivity() {
        return super.getActivity();
    }

    @Override // com.alibaba.ariver.app.api.PageContext
    public int getContentViewHeight() {
        if (this.mPageContainer.getView() != null) {
            return this.mPageContainer.getView().getHeight();
        }
        return 0;
    }

    @Override // com.alibaba.ariver.app.api.PageContext
    public int getContentViewWidth() {
        if (this.mPageContainer.getView() != null) {
            return this.mPageContainer.getView().getWidth();
        }
        return 0;
    }

    @Override // com.alibaba.ariver.app.api.PageContext
    public synchronized IEmbedViewManager getEmbedViewManager() {
        if (this.mEmbedViewManager == null) {
            this.mEmbedViewManager = new DefaultEmbedViewManager(this.mPage);
        }
        return this.mEmbedViewManager;
    }

    @Override // com.alibaba.ariver.app.api.PageContext
    public ErrorView getErrorView() {
        if (this.mErrorView == null) {
            RVViewFactory rVViewFactory = (RVViewFactory) RVProxy.get(RVViewFactory.class);
            if (rVViewFactory == null) {
                return null;
            }
            this.mErrorView = rVViewFactory.createErrorView(getActivity());
        }
        return this.mErrorView;
    }

    @Override // com.alibaba.ariver.app.api.PageContext
    public LoadingView getLoadingView() {
        return this.mLoadingView;
    }

    public Page getPage() {
        return this.mPage;
    }

    @Override // com.alibaba.ariver.app.api.PageContext
    public PageContainer getPageContainer() {
        return this.mPageContainer;
    }

    public RelativeLayout getRootView() {
        return this.mRootView;
    }

    @Override // com.alibaba.ariver.app.api.PageContext
    public TitleBar getTitleBar() {
        return this.mTitleBar;
    }

    public boolean isAlreadyScheduleAdded() {
        return this.mAlreadyScheduleAdded;
    }

    @Override // androidx.fragment.app.Fragment
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context == null || ProcessUtils.isMainProcess()) {
            return;
        }
        RemoteCallClient.bindContext(context);
    }

    @Override // androidx.fragment.app.Fragment, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        DimensionUtil.resetDimensions();
        RVLogger.d(TAG, "window resize onConfigurationChanged " + configuration);
        FragmentActivity activity = getActivity();
        if (activity == null || this.mPage == null || configuration == null) {
            return;
        }
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("windowWidth", (Object) Integer.valueOf(DimensionUtil.dip2px(activity, configuration.screenWidthDp)));
        jSONObject.put("windowHeight", (Object) Integer.valueOf(DimensionUtil.dip2px(activity, configuration.screenHeightDp)));
        EngineUtils.sendToRender(this.mPage.getRender(), RVEvents.WINDOW_RESIZE, jSONObject, null);
    }

    @Override // androidx.fragment.app.Fragment
    public void onCreate(@Nullable Bundle bundle) {
        super.onCreate(bundle);
        RVLogger.d(TAG, "onCreate " + this);
    }

    @Override // androidx.fragment.app.Fragment
    public Animation onCreateAnimation(int i, boolean z, int i2) {
        int animResId = AnimUtils.getAnimResId(getActivity(), TRANSLATE_IN_RIGHT_ID);
        if (animResId == 0) {
            animResId = R.anim.ariver_fragment_translate_in_right_default;
        }
        if (animResId != i2) {
            return super.onCreateAnimation(i, z, i2);
        }
        Animation animationLoadAnimation = AnimationUtils.loadAnimation(getActivity(), i2);
        animationLoadAnimation.setAnimationListener(new Animation.AnimationListener() { // from class: com.alibaba.ariver.app.api.ui.fragment.RVFragment.2
            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationEnd(Animation animation) {
                RVLogger.d(RVFragment.TAG, "onAnimationEnd");
                if (RVFragment.this.mPage == null || !RVFragment.this.mShouldResumeWebView || RVFragment.this.mPage.getRender() == null) {
                    return;
                }
                RVFragment.this.mShouldResumeWebView = false;
                RVFragment.this.mPage.getRender().onResume();
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationRepeat(Animation animation) {
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationStart(Animation animation) {
            }
        });
        return animationLoadAnimation;
    }

    @Override // androidx.fragment.app.Fragment
    @Nullable
    public View onCreateView(LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, @Nullable Bundle bundle) {
        RVTraceUtils.traceBeginSection(RVTraceKey.RV_Fragment_onCreateView);
        try {
            RVLogger.d(TAG, "onCreateView " + this);
            Page page = this.mPage;
            App appFindApp = null;
            if (page != null && page.isExited()) {
                return null;
            }
            RelativeLayout relativeLayout = this.mRootView;
            if (relativeLayout != null) {
                ViewParent parent = relativeLayout.getParent();
                if (parent instanceof ViewGroup) {
                    ((ViewGroup) parent).endViewTransition(this.mRootView);
                    ((ViewGroup) parent).removeAllViews();
                }
                return this.mRootView;
            }
            long j = BundleUtils.getLong(getArguments(), RVConstants.EXTRA_APP_INSTANCE_ID, 0L);
            RVLogger.d(TAG, "onCreateView with appInstanceId: " + j);
            if (j != 0) {
                appFindApp = ((AppManager) RVProxy.get(AppManager.class)).findApp(j);
                RVLogger.d(TAG, "findApp: " + appFindApp);
            }
            if (appFindApp != null && appFindApp.getAppContext() != null) {
                RelativeLayout relativeLayout2 = new RelativeLayout(getActivity());
                this.mRootView = relativeLayout2;
                relativeLayout2.setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
                this.mRootView.setBackgroundColor(0);
                if (!BundleUtils.getBoolean(appFindApp.getStartParams(), RVStartParams.KEY_TRANSPARENT, false)) {
                    this.mRootView.setBackgroundColor(-1);
                }
                this.mViewSpecProvider = appFindApp.getAppContext().getViewSpecProvider();
                PageContainer pageContainerCreatePageContainer = ((RVViewFactory) RVProxy.get(RVViewFactory.class)).createPageContainer(getActivity(), appFindApp, viewGroup);
                this.mPageContainer = pageContainerCreatePageContainer;
                pageContainerCreatePageContainer.getView().setLayoutParams(new ViewGroup.LayoutParams(-1, ViewUtils.specToLayoutParam(this.mViewSpecProvider.getHeightSpec())));
                TitleBar titleBarCreateTitleBar = ((RVViewFactory) RVProxy.get(RVViewFactory.class)).createTitleBar(getActivity(), appFindApp);
                this.mTitleBar = titleBarCreateTitleBar;
                if (titleBarCreateTitleBar != null && titleBarCreateTitleBar.getContent() != null) {
                    RVLogger.d(TAG, "add nav bar");
                    RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -2);
                    layoutParams.addRule(10);
                    this.mRootView.addView(this.mTitleBar.getContent(), 0, layoutParams);
                }
                long j2 = BundleUtils.getLong(getArguments(), RVConstants.EXTRA_PAGE_INSTANCE_ID, -1L);
                if (j2 > 0) {
                    Page page2 = getPage(appFindApp, j2);
                    RVLogger.d(TAG, "setPage in fragment onCreateView: " + page2 + ", " + this);
                    if (page2 != null) {
                        setPage(page2);
                    } else {
                        RVLogger.w(TAG, "mPage already existed!");
                    }
                }
                return this.mRootView;
            }
            return new FrameLayout(getActivity());
        } finally {
            RVTraceUtils.traceEndSection(RVTraceKey.RV_Fragment_onCreateView);
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onDestroy() {
        RVLogger.d(TAG, "onDestroy " + this);
        super.onDestroy();
        if (this.mIsFragmentStarted) {
            this.mIsFragmentStarted = false;
            Page page = this.mPage;
            if (page != null && !page.isExited()) {
                this.mPage.exit(true);
            }
            TitleBar titleBar = this.mTitleBar;
            if (titleBar != null) {
                titleBar.onDestroy();
            }
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onDestroyView() {
        super.onDestroyView();
        RVLogger.d(TAG, "onDestroyView " + this);
    }

    @Override // androidx.fragment.app.Fragment
    public void onDetach() {
        super.onDetach();
        RVLogger.d(TAG, "onDetach " + this);
    }

    @Override // androidx.fragment.app.Fragment
    public void onPause() {
        RVLogger.d(TAG, "pause " + this);
        super.onPause();
        this.mIsBetweenStartPause = false;
    }

    @Override // androidx.fragment.app.Fragment
    public void onResume() {
        RVLogger.d(TAG, "resume " + this);
        RVTraceUtils.traceBeginSection(RVTraceKey.RV_Fragment_onResume);
        super.onResume();
        Page page = this.mPage;
        if (page != null && !page.isExited() && BundleUtils.getBoolean(this.mPage.getStartParams(), "fullscreen", false) && !this.mIsBetweenStartPause) {
            this.mPage.resume();
        }
        RVTraceUtils.traceEndSection(RVTraceKey.RV_Fragment_onResume);
    }

    @Override // androidx.fragment.app.Fragment
    public void onStart() {
        RVLogger.d(TAG, "onStart " + this);
        RVTraceUtils.traceBeginSection(RVTraceKey.RV_Fragment_onStart);
        super.onStart();
        this.mIsBetweenStartPause = true;
        if (this.mIsFragmentStarted) {
            Page page = this.mPage;
            if (page != null && !page.isExited()) {
                this.mPage.resume();
            }
        } else {
            this.mIsFragmentStarted = true;
        }
        RVTraceUtils.traceEndSection(RVTraceKey.RV_Fragment_onStart);
    }

    @Override // androidx.fragment.app.Fragment
    public void onStop() {
        RVLogger.d(TAG, "onStop " + this);
        super.onStop();
        Page page = this.mPage;
        if (page == null || page.isExited()) {
            return;
        }
        this.mPage.pause();
    }

    @Override // androidx.fragment.app.Fragment
    public void onViewCreated(View view, @Nullable Bundle bundle) {
        super.onViewCreated(view, bundle);
        this.mOnViewCreatedTime = SystemClock.elapsedRealtime();
        Page page = this.mPendingSetPage;
        if (page != null) {
            setPage(page);
            this.mPendingSetPage = null;
        }
    }

    public void pauseRender() {
        Page page = this.mPage;
        if (page == null || page.getRender() == null) {
            return;
        }
        this.mPage.getRender().onPause();
    }

    public void setAlreadyScheduleAdded(boolean z) {
        this.mAlreadyScheduleAdded = z;
    }

    public void setPage(final Page page) {
        ExecutorUtils.runOnMain(new Runnable() { // from class: com.alibaba.ariver.app.api.ui.fragment.RVFragment.1
            @Override // java.lang.Runnable
            public void run() {
                if (RVFragment.this.mRootView != null) {
                    RVFragment.this.setPageOnMain(page);
                } else {
                    RVFragment.this.mPendingSetPage = page;
                }
            }
        });
    }

    public void setShouldResumeWebView(boolean z) {
        this.mShouldResumeWebView = z;
    }

    public Page getPage(App app, long j) {
        Page pageByNodeId = app.getPageByNodeId(j);
        if (pageByNodeId != null) {
            return pageByNodeId;
        }
        return null;
    }
}

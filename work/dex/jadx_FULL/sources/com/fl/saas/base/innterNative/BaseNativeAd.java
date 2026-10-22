package com.fl.saas.base.innterNative;

import android.app.Activity;
import android.content.Context;
import android.graphics.Color;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AlphaAnimation;
import android.view.animation.DecelerateInterpolator;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.arch.core.util.Function;
import com.fl.saas.api.AdParams;
import com.fl.saas.api.mixNative.NativeAd;
import com.fl.saas.api.mixNative.NativeAdView;
import com.fl.saas.api.mixNative.NativeClickCallbackListener;
import com.fl.saas.api.mixNative.NativeEventListener;
import com.fl.saas.api.mixNative.NativeLoadListener;
import com.fl.saas.api.mixNative.NativeMaterial;
import com.fl.saas.api.mixNative.NativePrepareInfo;
import com.fl.saas.base.adapter.base.ReportEventListener;
import com.fl.saas.base.bidding.BiddingResult;
import com.fl.saas.base.innterNative.BaseNativeAd;
import com.fl.saas.base.interfaces.MixNativeCycleDataListener;
import com.fl.saas.base.manager.MixNativeManager;
import com.fl.saas.base.widget.AdInfo;
import com.fl.saas.base.widget.FingerSlidingAndTwistingView;
import com.fl.saas.base.widget.FingerSlidingView;
import com.fl.saas.base.widget.InclineView;
import com.fl.saas.base.widget.ShakeView;
import com.fl.saas.base.widget.WinAdInfo;
import com.fl.saas.common.saas.bean.AdSource;
import com.fl.saas.common.util.CommConstant;
import com.fl.saas.common.util.ImageLoader;
import com.fl.saas.common.util.ViewHelper;
import com.fl.saas.common.util.feature.Consumer;
import com.fl.saas.common.util.feature.Optional;
import com.fl.saas.common.util.feature.Supplier;
import com.fl.saas.common.widget.VisibilityLayout;
import com.fl.saas.config.exception.YdError;
import com.fl.saas.config.utils.DeviceUtil;
import com.fl.saas.config.utils.LogcatUtil;
import com.fl.saas.s2s.R;
import com.fl.saas.ydsdk.api.YdSDK;
import com.ipd.dsp.internal.e1.i;
import com.zj.adlib.dp0;
import java.lang.ref.WeakReference;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_08_10593cls.dex */
public abstract class BaseNativeAd<T> implements NativeAd, MixNativeCycleDataListener {
    private int cycleIndex;
    private NativeAdView cycleNativeAdView;
    private AdInfoMapper mAdInfoMapper;
    private NativeClickCallbackListener mClickCallBackListener;
    private WeakReference<Context> mContext;
    private List<NativeAd> mCycleNativeAds;
    private int mCycleNativeTime;
    private Timer mCycleTimer;
    private EcpmMapper mEcpmMapper;
    private NativeEventListener mEventListener;

    @Nullable
    private T mNativeAd;
    private NativeAdView mNativeAdView;
    private NativeMaterial mNativeMaterial;
    private ReportEventListener mReportEventListener;
    private Timer mTimer;
    private WinAdInfoMapper mWinAdInfoMapper;
    private MixNativeManager.OnNativeReleaseListener onNativeReleaseListener;
    private ViewGroup parentViewGroup;
    private NativeAd refreshNativeAD;
    private AdParams requestParams;
    private View selfRenderView;
    private WeakReference<Activity> showActivityRef;
    private final String TAG = CommConstant.getObjTag(i.g, this);
    private boolean isReportExposure = false;
    private boolean nativeAdViewVisibility = true;
    private boolean mCanRefresh = true;
    private boolean isShowOriginalView = true;
    private boolean hasDestroy = false;
    private boolean hasRelease = false;

    /* JADX INFO: renamed from: com.fl.saas.base.innterNative.BaseNativeAd$2, reason: invalid class name */
    public class AnonymousClass2 extends TimerTask {
        public AnonymousClass2() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$run$0() {
            if (BaseNativeAd.this.mCycleNativeAds == null) {
                return;
            }
            if (BaseNativeAd.this.isShowOriginalView) {
                BaseNativeAd.this.cycleIndex = 0;
            } else if (BaseNativeAd.this.cycleIndex >= BaseNativeAd.this.mCycleNativeAds.size()) {
                BaseNativeAd.this.isShowOriginalView = true;
                BaseNativeAd.this.cycleIndex = 0;
                if (BaseNativeAd.this.cycleNativeAdView != null) {
                    BaseNativeAd baseNativeAd = BaseNativeAd.this;
                    baseNativeAd.cycleAnimal(baseNativeAd.mNativeAdView, BaseNativeAd.this.cycleNativeAdView);
                    return;
                }
                return;
            }
            BaseNativeAd.this.showNextCycleView();
        }

        @Override // java.util.TimerTask, java.lang.Runnable
        public void run() {
            try {
                if (BaseNativeAd.this.showActivityRef == null || BaseNativeAd.this.showActivityRef.get() == null || ((Activity) BaseNativeAd.this.showActivityRef.get()).isFinishing()) {
                    BaseNativeAd.this.showActivityRef = new WeakReference(DeviceUtil.getTopActivity());
                }
                if (BaseNativeAd.this.showActivityRef == null || BaseNativeAd.this.showActivityRef.get() == null || ((Activity) BaseNativeAd.this.showActivityRef.get()).isFinishing() || !BaseNativeAd.this.nativeAdViewVisibility) {
                    return;
                }
                DeviceUtil.postUI(new Runnable() { // from class: com.fl.saas.base.innterNative.a
                    @Override // java.lang.Runnable
                    public final void run() {
                        this.f30134a.lambda$run$0();
                    }
                });
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    /* JADX INFO: renamed from: com.fl.saas.base.innterNative.BaseNativeAd$4, reason: invalid class name */
    public class AnonymousClass4 extends TimerTask {
        public AnonymousClass4() {
        }

        @Override // java.util.TimerTask, java.lang.Runnable
        public void run() {
            try {
                if (BaseNativeAd.this.showActivityRef == null || BaseNativeAd.this.showActivityRef.get() == null || ((Activity) BaseNativeAd.this.showActivityRef.get()).isFinishing()) {
                    BaseNativeAd.this.showActivityRef = new WeakReference(DeviceUtil.getTopActivity());
                }
                if (BaseNativeAd.this.showActivityRef == null || BaseNativeAd.this.showActivityRef.get() == null || ((Activity) BaseNativeAd.this.showActivityRef.get()).isFinishing() || !BaseNativeAd.this.nativeAdViewVisibility) {
                    return;
                }
                YdSDK.loadMixNative((Context) BaseNativeAd.this.showActivityRef.get(), BaseNativeAd.this.requestParams, new NativeLoadListener() { // from class: com.fl.saas.base.innterNative.BaseNativeAd.4.1

                    /* JADX INFO: renamed from: com.fl.saas.base.innterNative.BaseNativeAd$4$1$1, reason: invalid class name and collision with other inner class name */
                    public class C06421 implements NativeEventListener {
                        public C06421() {
                        }

                        /* JADX INFO: Access modifiers changed from: private */
                        public /* synthetic */ void lambda$onAdClicked$1(NativeEventListener nativeEventListener) {
                            nativeEventListener.onAdClicked(BaseNativeAd.this.mNativeAdView);
                        }

                        /* JADX INFO: Access modifiers changed from: private */
                        public /* synthetic */ void lambda$onAdClose$2(NativeEventListener nativeEventListener) {
                            nativeEventListener.onAdClose(BaseNativeAd.this.mNativeAdView);
                        }

                        /* JADX INFO: Access modifiers changed from: private */
                        public /* synthetic */ void lambda$onAdImpressed$0(NativeEventListener nativeEventListener) {
                            nativeEventListener.onAdImpressed(BaseNativeAd.this.mNativeAdView);
                        }

                        /* JADX INFO: Access modifiers changed from: private */
                        public /* synthetic */ void lambda$onAdVideoEnd$4(NativeEventListener nativeEventListener) {
                            nativeEventListener.onAdVideoEnd(BaseNativeAd.this.mNativeAdView);
                        }

                        /* JADX INFO: Access modifiers changed from: private */
                        public /* synthetic */ void lambda$onAdVideoProgress$5(long j, NativeEventListener nativeEventListener) {
                            nativeEventListener.onAdVideoProgress(BaseNativeAd.this.mNativeAdView, j);
                        }

                        /* JADX INFO: Access modifiers changed from: private */
                        public /* synthetic */ void lambda$onAdVideoStart$3(NativeEventListener nativeEventListener) {
                            nativeEventListener.onAdVideoStart(BaseNativeAd.this.mNativeAdView);
                        }

                        @Override // com.fl.saas.api.mixNative.NativeEventListener
                        public void onAdClicked(NativeAdView nativeAdView) {
                            BaseNativeAd.this.getEventListener().ifPresent(new Consumer() { // from class: com.fl.saas.base.innterNative.d
                                @Override // com.fl.saas.common.util.feature.Consumer
                                public final void accept(Object obj) {
                                    this.f30137a.lambda$onAdClicked$1((NativeEventListener) obj);
                                }
                            });
                        }

                        @Override // com.fl.saas.api.mixNative.NativeEventListener
                        public void onAdClose(NativeAdView nativeAdView) {
                            BaseNativeAd.this.getEventListener().ifPresent(new Consumer() { // from class: com.fl.saas.base.innterNative.e
                                @Override // com.fl.saas.common.util.feature.Consumer
                                public final void accept(Object obj) {
                                    this.f30138a.lambda$onAdClose$2((NativeEventListener) obj);
                                }
                            });
                            BaseNativeAd.this.stopRefresh();
                        }

                        @Override // com.fl.saas.api.mixNative.NativeEventListener
                        public void onAdFailed(NativeAdView nativeAdView, YdError ydError) {
                        }

                        @Override // com.fl.saas.api.mixNative.NativeEventListener
                        public void onAdImpressed(NativeAdView nativeAdView) {
                            BaseNativeAd.this.getEventListener().ifPresent(new Consumer() { // from class: com.fl.saas.base.innterNative.g
                                @Override // com.fl.saas.common.util.feature.Consumer
                                public final void accept(Object obj) {
                                    this.f30140a.lambda$onAdImpressed$0((NativeEventListener) obj);
                                }
                            });
                        }

                        @Override // com.fl.saas.api.mixNative.NativeEventListener
                        public void onAdVideoEnd(NativeAdView nativeAdView) {
                            BaseNativeAd.this.getEventListener().ifPresent(new Consumer() { // from class: com.fl.saas.base.innterNative.c
                                @Override // com.fl.saas.common.util.feature.Consumer
                                public final void accept(Object obj) {
                                    this.f30136a.lambda$onAdVideoEnd$4((NativeEventListener) obj);
                                }
                            });
                        }

                        @Override // com.fl.saas.api.mixNative.NativeEventListener
                        public void onAdVideoProgress(NativeAdView nativeAdView, final long j) {
                            BaseNativeAd.this.getEventListener().ifPresent(new Consumer() { // from class: com.fl.saas.base.innterNative.f
                                @Override // com.fl.saas.common.util.feature.Consumer
                                public final void accept(Object obj) {
                                    this.f1753a.lambda$onAdVideoProgress$5(j, (NativeEventListener) obj);
                                }
                            });
                        }

                        @Override // com.fl.saas.api.mixNative.NativeEventListener
                        public void onAdVideoStart(NativeAdView nativeAdView) {
                            BaseNativeAd.this.getEventListener().ifPresent(new Consumer() { // from class: com.fl.saas.base.innterNative.b
                                @Override // com.fl.saas.common.util.feature.Consumer
                                public final void accept(Object obj) {
                                    this.f30135a.lambda$onAdVideoStart$3((NativeEventListener) obj);
                                }
                            });
                        }
                    }

                    @Override // com.fl.saas.base.interfaces.AdViewListener
                    public void onAdFailed(YdError ydError) {
                    }

                    @Override // com.fl.saas.api.mixNative.NativeLoadListener
                    public void onNativeAdLoaded(NativeAd nativeAd) {
                        View adMediaView;
                        if (nativeAd == null || !nativeAd.isNativeExpress()) {
                            return;
                        }
                        if (BaseNativeAd.this.refreshNativeAD != null) {
                            BaseNativeAd.this.refreshNativeAD.release();
                        }
                        BaseNativeAd.this.refreshNativeAD = nativeAd;
                        nativeAd.setCanRefresh(false);
                        nativeAd.setNativeEventListener(new C06421());
                        if (nativeAd.getAdMaterial() == null || nativeAd.getAdMaterial().getAdMediaView() == null || (adMediaView = nativeAd.getAdMaterial().getAdMediaView()) == null || BaseNativeAd.this.mNativeAdView == null) {
                            return;
                        }
                        BaseNativeAd.this.mNativeAdView.removeAllViews();
                        BaseNativeAd.this.mNativeAdView.addView(adMediaView, ViewHelper.getMatchParent());
                        nativeAd.renderAdContainer(BaseNativeAd.this.mNativeAdView, null);
                        NativePrepareInfo nativePrepareInfo = new NativePrepareInfo();
                        nativePrepareInfo.setActivity((Activity) BaseNativeAd.this.showActivityRef.get());
                        nativeAd.prepare(nativePrepareInfo);
                    }
                });
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public interface AdInfoMapper {
        AdInfo getAdInfo();

        AdSource getSource();
    }

    public interface EcpmMapper {
        int getECPM();
    }

    public interface WinAdInfoMapper {
        WinAdInfo getAdInfo();
    }

    public BaseNativeAd(@NonNull Context context) {
        this.mContext = new WeakReference<>(context);
    }

    public BaseNativeAd(@NonNull Context context, @NonNull T t) {
        try {
            this.mNativeAd = t;
            this.mContext = new WeakReference<>(context);
            init(this.mNativeAd);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static /* synthetic */ int access$610(BaseNativeAd baseNativeAd) {
        int i = baseNativeAd.cycleIndex;
        baseNativeAd.cycleIndex = i - 1;
        return i;
    }

    private void checkCycleAd() {
        List<NativeAd> list;
        if (this.mCycleTimer != null || this.mCycleNativeTime <= 0 || (list = this.mCycleNativeAds) == null || list.isEmpty()) {
            return;
        }
        Timer timer = new Timer();
        this.mCycleTimer = timer;
        AnonymousClass2 anonymousClass2 = new AnonymousClass2();
        long j = 1000 * ((long) this.mCycleNativeTime);
        timer.schedule(anonymousClass2, j, j);
    }

    private void checkDataUpdate() {
        try {
            NativeAdView nativeAdView = this.mNativeAdView;
            if (nativeAdView != null) {
                nativeAdView.setOnViewWindowChangedListener(new VisibilityLayout.OnViewWindowChangedListener() { // from class: com.fl.saas.base.innterNative.BaseNativeAd.1
                    @Override // com.fl.saas.common.widget.VisibilityLayout.OnViewWindowChangedListener
                    public void onDetachedFromWindow() {
                        BaseNativeAd.this.nativeAdViewVisibility = false;
                        BaseNativeAd.this.stopRefresh();
                        BaseNativeAd.this.stopCycle();
                    }

                    @Override // com.fl.saas.common.widget.VisibilityLayout.OnViewWindowChangedListener
                    public void onViewWindowVisibility(boolean z) {
                        BaseNativeAd.this.nativeAdViewVisibility = z;
                    }
                });
            }
            checkRefreshAd();
            checkCycleAd();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void checkRefreshAd() {
        AdInfoMapper adInfoMapper;
        if (this.mTimer == null && isNativeExpress() && this.mCanRefresh && (adInfoMapper = this.mAdInfoMapper) != null && adInfoMapper.getSource() != null) {
            AdSource source = this.mAdInfoMapper.getSource();
            if (source.refresh != 1 || source.refresh_time <= 0) {
                return;
            }
            Timer timer = new Timer();
            this.mTimer = timer;
            AnonymousClass4 anonymousClass4 = new AnonymousClass4();
            long j = ((long) source.refresh_time) * 1000;
            timer.schedule(anonymousClass4, j, j);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cycleAnimal(View view, View view2) {
        if (view == null || view2 == null) {
            return;
        }
        view2.setVisibility(8);
        view.setVisibility(0);
        AlphaAnimation alphaAnimation = new AlphaAnimation(0.0f, 1.0f);
        alphaAnimation.setDuration(600L);
        alphaAnimation.setInterpolator(new DecelerateInterpolator());
        view.startAnimation(alphaAnimation);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public Optional<NativeEventListener> getEventListener() {
        return Optional.ofNullable(this.mEventListener);
    }

    private Optional<ReportEventListener> getReportEventListener() {
        return Optional.ofNullable(this.mReportEventListener);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ NativeMaterial lambda$getAdMaterial$1() {
        return (NativeMaterial) getNativeAdOpt().map(new Function() { // from class: com.zj.adlib.tp0
            @Override // androidx.arch.core.util.Function
            public final Object apply(Object obj) {
                return this.f44974a.createNativeMaterial(obj);
            }
        }).orElse(null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void lambda$listenInclineView$11(InclineView.InclineListener inclineListener, ActionView.Type type, View view, int i, int i2, int i3) {
        if (inclineListener != null) {
            inclineListener.onIncline(i, i2, i3);
        }
        if (type != ActionView.Type.Spread) {
            ViewHelper.removeParent(view);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void lambda$listenShakeView$10(ShakeView.ShakeListener shakeListener, ActionView.Type type, View view, int i, int i2, int i3) {
        if (shakeListener != null) {
            shakeListener.onShake(i, i2, i3);
        }
        if (type != ActionView.Type.Spread) {
            ViewHelper.removeParent(view);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$onAdClickedEvent$4(NativeEventListener nativeEventListener) {
        nativeEventListener.onAdClicked(this.mNativeAdView);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$onAdClickedEvent$5(NativeEventListener nativeEventListener) {
        nativeEventListener.onAdClicked(this.mNativeAdView);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$onAdCloseEvent$6(NativeEventListener nativeEventListener) {
        nativeEventListener.onAdClose(this.mNativeAdView);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$onAdFailedEvent$2(YdError ydError, NativeEventListener nativeEventListener) {
        nativeEventListener.onAdFailed(this.mNativeAdView, ydError);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$onAdImpressedEvent$3(NativeEventListener nativeEventListener) {
        nativeEventListener.onAdImpressed(this.mNativeAdView);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$onAdVideoEndEvent$8(NativeEventListener nativeEventListener) {
        nativeEventListener.onAdVideoEnd(this.mNativeAdView);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$onAdVideoProgress$9(long j, NativeEventListener nativeEventListener) {
        nativeEventListener.onAdVideoProgress(this.mNativeAdView, j);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$onAdVideoStartEvent$7(NativeEventListener nativeEventListener) {
        nativeEventListener.onAdVideoStart(this.mNativeAdView);
    }

    private void loadCycleView() {
        List<NativeAd> list = this.mCycleNativeAds;
        if (list == null || this.cycleIndex < 0) {
            return;
        }
        int size = list.size();
        int i = this.cycleIndex;
        if (size < i + 1) {
            return;
        }
        this.mCycleNativeAds.get(i).setNativeEventListener(new NativeEventListener() { // from class: com.fl.saas.base.innterNative.BaseNativeAd.3
            @Override // com.fl.saas.api.mixNative.NativeEventListener
            public void onAdClicked(NativeAdView nativeAdView) {
                BaseNativeAd.this.onAdClickedEvent();
                if (BaseNativeAd.this.mCycleNativeAds == null) {
                    return;
                }
                if (BaseNativeAd.this.mCycleNativeAds.size() != 1) {
                    if (BaseNativeAd.this.mCycleNativeAds.size() > 1) {
                        if (BaseNativeAd.this.parentViewGroup == null || BaseNativeAd.this.cycleNativeAdView == null) {
                            return;
                        }
                        BaseNativeAd.this.parentViewGroup.removeView(BaseNativeAd.this.cycleNativeAdView);
                        BaseNativeAd.this.mNativeAdView.setVisibility(0);
                        BaseNativeAd.this.cycleNativeAdView = null;
                        if (BaseNativeAd.this.cycleIndex > 0) {
                            if (BaseNativeAd.this.mCycleNativeAds == null || BaseNativeAd.this.mCycleNativeAds.size() < BaseNativeAd.this.cycleIndex) {
                                return;
                            }
                            BaseNativeAd.this.mCycleNativeAds.remove(BaseNativeAd.this.cycleIndex - 1);
                            BaseNativeAd.access$610(BaseNativeAd.this);
                            return;
                        }
                        if (BaseNativeAd.this.cycleIndex == 0) {
                        }
                    } else {
                        if (BaseNativeAd.this.parentViewGroup == null || BaseNativeAd.this.cycleNativeAdView == null) {
                            return;
                        }
                        BaseNativeAd.this.parentViewGroup.removeView(BaseNativeAd.this.cycleNativeAdView);
                        BaseNativeAd.this.mNativeAdView.setVisibility(0);
                        BaseNativeAd.this.cycleNativeAdView = null;
                    }
                    BaseNativeAd.this.stopCycle();
                }
                if (BaseNativeAd.this.parentViewGroup == null || BaseNativeAd.this.cycleNativeAdView == null) {
                    return;
                }
                BaseNativeAd.this.parentViewGroup.removeView(BaseNativeAd.this.cycleNativeAdView);
                BaseNativeAd.this.cycleNativeAdView = null;
                BaseNativeAd.this.mNativeAdView.setVisibility(0);
                BaseNativeAd.this.mCycleNativeAds.clear();
                BaseNativeAd.this.stopCycle();
            }

            @Override // com.fl.saas.api.mixNative.NativeEventListener
            public void onAdClose(NativeAdView nativeAdView) {
                if (BaseNativeAd.this.parentViewGroup != null) {
                    BaseNativeAd.this.parentViewGroup.removeAllViews();
                }
                BaseNativeAd.this.onAdCloseEvent();
            }

            @Override // com.fl.saas.api.mixNative.NativeEventListener
            public void onAdFailed(NativeAdView nativeAdView, YdError ydError) {
                BaseNativeAd.this.onAdFailedEvent(ydError);
            }

            @Override // com.fl.saas.api.mixNative.NativeEventListener
            public void onAdImpressed(NativeAdView nativeAdView) {
            }

            @Override // com.fl.saas.api.mixNative.NativeEventListener
            public void onAdVideoEnd(NativeAdView nativeAdView) {
                BaseNativeAd.this.onAdVideoEndEvent();
            }

            @Override // com.fl.saas.api.mixNative.NativeEventListener
            public void onAdVideoProgress(NativeAdView nativeAdView, long j) {
            }

            @Override // com.fl.saas.api.mixNative.NativeEventListener
            public void onAdVideoStart(NativeAdView nativeAdView) {
                BaseNativeAd.this.onAdVideoStartEvent();
            }
        });
        NativePrepareInfo nativePrepareInfo = new NativePrepareInfo();
        NativeAdView cycleView = CycleNativeAdUtil.getCycleView(this.showActivityRef.get(), this.mCycleNativeAds.get(this.cycleIndex), this.requestParams, nativePrepareInfo);
        if (cycleView != null) {
            this.mNativeAdView.setVisibility(8);
            this.parentViewGroup.addView(cycleView);
            cycleAnimal(cycleView, this.cycleNativeAdView);
            nativePrepareInfo.setActivity(this.showActivityRef.get());
            this.mCycleNativeAds.get(this.cycleIndex).prepare(nativePrepareInfo);
            ViewHelper.removeParent(this.cycleNativeAdView);
            this.cycleNativeAdView = cycleView;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void showNextCycleView() {
        try {
            NativeAdView nativeAdView = this.mNativeAdView;
            if (nativeAdView != null && (nativeAdView.getParent() instanceof ViewGroup)) {
                this.isShowOriginalView = false;
                this.parentViewGroup = (ViewGroup) this.mNativeAdView.getParent();
                if (this.cycleNativeAdView != null && this.mCycleNativeAds.size() == 1) {
                    cycleAnimal(this.cycleNativeAdView, this.mNativeAdView);
                } else {
                    loadCycleView();
                }
            }
            this.cycleIndex++;
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void stopCycle() {
        Timer timer = this.mCycleTimer;
        if (timer != null) {
            timer.cancel();
            this.mCycleTimer = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void stopRefresh() {
        Timer timer = this.mTimer;
        if (timer != null) {
            timer.cancel();
            this.mTimer = null;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.fl.saas.ydsdk.api.MediaExtraInfo
    public void biddingResultUpload(boolean z, int i, int i2) {
        LogcatUtil.d(this.TAG, "biddingResultUpload");
        try {
            if (this instanceof BiddingResult) {
                ((BiddingResult) this).biddingResult(z, i, i2, 0);
            }
        } catch (Exception e) {
            LogcatUtil.d(this.TAG, "biddingResultUploadError:" + e.getMessage());
            e.printStackTrace();
        }
    }

    public void bindContainer(ViewGroup viewGroup) {
        if (this.mNativeAdView == null) {
            onAdFailedEvent(YdError.create(20405, "NativeAdView is null"));
            return;
        }
        LogcatUtil.d(this.TAG, "bindContainer");
        ViewGroup.LayoutParams layoutParams = this.selfRenderView.getLayoutParams();
        if (layoutParams == null) {
            layoutParams = ViewHelper.getMatchParent();
        }
        this.mNativeAdView.removeAllViews();
        this.mNativeAdView.addView(viewGroup, layoutParams);
        ViewHelper.removeParent(this.selfRenderView);
        viewGroup.addView(this.selfRenderView, ViewHelper.getMatchParent());
    }

    public void bindNativeAd(@NonNull T t) {
        try {
            this.mNativeAd = t;
            init(t);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public abstract NativeMaterial createNativeMaterial(@NonNull T t);

    @Override // com.fl.saas.api.mixNative.NativeAd
    public void destroy() {
        if (this.hasDestroy) {
            return;
        }
        this.hasDestroy = true;
        LogcatUtil.d(this.TAG, "destroy");
        NativeAd nativeAd = this.refreshNativeAD;
        if (nativeAd != null) {
            nativeAd.release();
            this.refreshNativeAD = null;
        }
        stopRefresh();
        stopCycle();
        NativeAdView nativeAdView = this.mNativeAdView;
        if (nativeAdView != null && this.mCanRefresh) {
            nativeAdView.removeAllViews();
            ViewHelper.removeParent(this.mNativeAdView);
            this.mNativeAdView.detachedView();
        }
        this.mEventListener = null;
        this.mClickCallBackListener = null;
    }

    @Override // com.fl.saas.ydsdk.api.MediaExtraInfo
    public AdInfo getAdInfo() {
        AdInfoMapper adInfoMapper = this.mAdInfoMapper;
        if (adInfoMapper != null) {
            return adInfoMapper.getAdInfo();
        }
        return null;
    }

    @Override // com.fl.saas.api.mixNative.NativeAd
    public NativeMaterial getAdMaterial() {
        NativeMaterial nativeMaterial = (NativeMaterial) Optional.ofNullable(this.mNativeMaterial).orElseGet(new Supplier() { // from class: com.zj.adlib.dq0
            @Override // com.fl.saas.common.util.feature.Supplier
            public final Object get() {
                return this.f41249a.lambda$getAdMaterial$1();
            }
        });
        this.mNativeMaterial = nativeMaterial;
        return nativeMaterial;
    }

    public View getAreaShakesView() {
        View viewInflate = ViewHelper.inflate(getContext(), R.layout.yd_saas_view_area_shake_spread);
        ImageLoader.loadImage("https://creative.medproad.com/medpro/imgs/944e91c4ed73a3267d43f9b9eee5bea.png", (ImageView) viewInflate.findViewById(R.id.iv_bg));
        return viewInflate;
    }

    public Context getContext() {
        WeakReference<Activity> weakReference;
        WeakReference<Context> weakReference2 = this.mContext;
        Activity activity = weakReference2 != null ? weakReference2.get() : null;
        if (activity == null && (weakReference = this.showActivityRef) != null) {
            activity = weakReference.get();
        }
        return activity == null ? DeviceUtil.getTopActivity() : activity;
    }

    @Override // com.fl.saas.base.interfaces.MixNativeCycleDataListener
    public NativeAd getCycleNativeAd() {
        return null;
    }

    @Override // com.fl.saas.ydsdk.api.MediaExtraInfo
    public int getECPM() {
        return ((Integer) Optional.ofNullable(this.mEcpmMapper).map(new Function() { // from class: com.zj.adlib.hq0
            @Override // androidx.arch.core.util.Function
            public final Object apply(Object obj) {
                return Integer.valueOf(((BaseNativeAd.EcpmMapper) obj).getECPM());
            }
        }).orElse(0)).intValue();
    }

    public View getInterstitalShakesView() {
        return ViewHelper.inflate(getContext(), R.layout.yd_saas_view_shake_interstital);
    }

    @Nullable
    public T getNativeAd() {
        return this.mNativeAd;
    }

    public Optional<T> getNativeAdOpt() {
        return Optional.ofNullable(this.mNativeAd);
    }

    public NativeAdView getNativeAdView() {
        return this.mNativeAdView;
    }

    @Override // com.fl.saas.api.mixNative.NativeAd
    public String getReqId() {
        AdInfoMapper adInfoMapper = this.mAdInfoMapper;
        return (adInfoMapper == null || adInfoMapper.getSource() == null) ? "" : this.mAdInfoMapper.getSource().req_id;
    }

    public View getSelfRenderView() {
        return this.selfRenderView;
    }

    public View getShakeTipsView() {
        return ViewHelper.inflate(getContext(), R.layout.yd_saas_view_shake_template);
    }

    public View getSpreadInlineView() {
        return ViewHelper.inflate(getContext(), R.layout.yd_saas_view_incline_spread);
    }

    public View getSpreadShakesView() {
        return ViewHelper.inflate(getContext(), R.layout.yd_saas_view_shake_spread);
    }

    public View getSpreadSlidingTwistingView(int i, boolean z, int i2, FingerSlidingAndTwistingView.SlidingListener slidingListener) {
        FingerSlidingAndTwistingView fingerSlidingAndTwistingView = new FingerSlidingAndTwistingView(getContext());
        fingerSlidingAndTwistingView.setScale_type(i);
        fingerSlidingAndTwistingView.setSlidingListener(i2, slidingListener);
        fingerSlidingAndTwistingView.createView(z);
        return fingerSlidingAndTwistingView;
    }

    public View getSpreadSlidingView(int i, int i2, FingerSlidingView.SlidingListener slidingListener) {
        FingerSlidingView fingerSlidingView = new FingerSlidingView(getContext());
        fingerSlidingView.setScale_type(i);
        fingerSlidingView.setSlidingListener(i2, slidingListener);
        fingerSlidingView.createView();
        return fingerSlidingView;
    }

    public View getTemplateShakesView() {
        return ViewHelper.inflate(getContext(), R.layout.yd_saas_view_shake_template);
    }

    public View getTipsView(int i) {
        float f;
        TextView textView = new TextView(getContext());
        int iDip2px = DeviceUtil.dip2px(280.0f);
        int iDip2px2 = DeviceUtil.dip2px(80.0f);
        if (i != 1) {
            if (i == 2) {
                iDip2px = DeviceUtil.dip2px(320.0f);
                f = 100.0f;
            }
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(iDip2px, iDip2px2);
            layoutParams.gravity = 81;
            layoutParams.bottomMargin = DeviceUtil.dip2px(30.0f);
            textView.setTextSize(16.0f);
            textView.setLayoutParams(layoutParams);
            textView.setGravity(17);
            textView.setBackgroundResource(R.drawable.yd_saas_shake_bg_template);
            textView.setText("点击跳转详情页面或第三方应用>");
            textView.setTextColor(Color.parseColor("#ffffff"));
            return textView;
        }
        iDip2px = DeviceUtil.dip2px(300.0f);
        f = 90.0f;
        iDip2px2 = DeviceUtil.dip2px(f);
        FrameLayout.LayoutParams layoutParams2 = new FrameLayout.LayoutParams(iDip2px, iDip2px2);
        layoutParams2.gravity = 81;
        layoutParams2.bottomMargin = DeviceUtil.dip2px(30.0f);
        textView.setTextSize(16.0f);
        textView.setLayoutParams(layoutParams2);
        textView.setGravity(17);
        textView.setBackgroundResource(R.drawable.yd_saas_shake_bg_template);
        textView.setText("点击跳转详情页面或第三方应用>");
        textView.setTextColor(Color.parseColor("#ffffff"));
        return textView;
    }

    public WinAdInfo getWinAdInfo() {
        WinAdInfoMapper winAdInfoMapper = this.mWinAdInfoMapper;
        if (winAdInfoMapper != null) {
            return winAdInfoMapper.getAdInfo();
        }
        return null;
    }

    public abstract void init(@NonNull T t);

    @Override // com.fl.saas.api.mixNative.NativeAd
    public boolean isShakeType() {
        return false;
    }

    public void listenInclineView(final View view, boolean z, final ActionView.Type type, int i, final InclineView.InclineListener inclineListener) {
        InclineView inclineView;
        if (view == null || (inclineView = (InclineView) view.findViewById(R.id.yd_incline_view)) == null) {
            return;
        }
        inclineView.setCallback(z);
        inclineView.setInclineListener(i, new InclineView.InclineListener() { // from class: com.zj.adlib.jq0
            @Override // com.fl.saas.base.widget.InclineView.InclineListener
            public final void onIncline(int i2, int i3, int i4) {
                BaseNativeAd.lambda$listenInclineView$11(inclineListener, type, view, i2, i3, i4);
            }
        });
    }

    public void listenShakeView(final View view, boolean z, final ActionView.Type type, int i, final ShakeView.ShakeListener shakeListener) {
        ShakeView shakeView;
        if (view == null || (shakeView = (ShakeView) view.findViewById(R.id.yd_shake_view)) == null) {
            return;
        }
        shakeView.setCallback(z);
        shakeView.setShakeListener(i, new ShakeView.ShakeListener() { // from class: com.zj.adlib.xp0
            @Override // com.fl.saas.base.widget.ShakeView.ShakeListener
            public final void onShake(int i2, int i3, int i4) {
                BaseNativeAd.lambda$listenShakeView$10(shakeListener, type, view, i2, i3, i4);
            }
        });
    }

    public void onAdClickedCallBackEvent(String str) {
        LogcatUtil.d(this.TAG, "onAdClickedCallBackEvent");
        getReportEventListener().ifPresent(new dp0());
        NativeClickCallbackListener nativeClickCallbackListener = this.mClickCallBackListener;
        if (nativeClickCallbackListener != null) {
            nativeClickCallbackListener.onAdClicked(str);
        }
    }

    public void onAdClickedEvent() {
        LogcatUtil.d(this.TAG, "onAdClickedEvent");
        getReportEventListener().ifPresent(new dp0());
        getEventListener().ifPresent(new Consumer() { // from class: com.zj.adlib.rp0
            @Override // com.fl.saas.common.util.feature.Consumer
            public final void accept(Object obj) {
                this.f44502a.lambda$onAdClickedEvent$4((NativeEventListener) obj);
            }
        });
    }

    public void onAdClickedEvent(int i) {
        LogcatUtil.d(this.TAG, "onAdClickedEvent");
        getReportEventListener().ifPresent(new dp0());
        if (i == 1) {
            getEventListener().ifPresent(new Consumer() { // from class: com.zj.adlib.lp0
                @Override // com.fl.saas.common.util.feature.Consumer
                public final void accept(Object obj) {
                    this.f43119a.lambda$onAdClickedEvent$5((NativeEventListener) obj);
                }
            });
        }
    }

    public void onAdCloseEvent() {
        LogcatUtil.d(this.TAG, "onAdCloseEvent");
        this.mCycleNativeAds = null;
        this.mCycleNativeTime = 0;
        stopRefresh();
        stopCycle();
        getEventListener().ifPresent(new Consumer() { // from class: com.zj.adlib.vp0
            @Override // com.fl.saas.common.util.feature.Consumer
            public final void accept(Object obj) {
                this.f45409a.lambda$onAdCloseEvent$6((NativeEventListener) obj);
            }
        });
    }

    public void onAdFailedEvent(final YdError ydError) {
        LogcatUtil.d(this.TAG, "onAdFailed:" + ydError);
        getEventListener().ifPresent(new Consumer() { // from class: com.zj.adlib.pp0
            @Override // com.fl.saas.common.util.feature.Consumer
            public final void accept(Object obj) {
                this.f44033a.lambda$onAdFailedEvent$2(ydError, (NativeEventListener) obj);
            }
        });
    }

    public void onAdImpressedEvent() {
        LogcatUtil.d(this.TAG, "onAdImpressedEvent");
        checkDataUpdate();
        if (this.isReportExposure) {
            return;
        }
        this.isReportExposure = true;
        getReportEventListener().ifPresent(new Consumer() { // from class: com.zj.adlib.zp0
            @Override // com.fl.saas.common.util.feature.Consumer
            public final void accept(Object obj) {
                ((ReportEventListener) obj).onShowEvent();
            }
        });
        getEventListener().ifPresent(new Consumer() { // from class: com.zj.adlib.bq0
            @Override // com.fl.saas.common.util.feature.Consumer
            public final void accept(Object obj) {
                this.f40811a.lambda$onAdImpressedEvent$3((NativeEventListener) obj);
            }
        });
    }

    public void onAdVideoEndEvent() {
        LogcatUtil.d(this.TAG, "onAdVideoEndEvent");
        getEventListener().ifPresent(new Consumer() { // from class: com.zj.adlib.fp0
            @Override // com.fl.saas.common.util.feature.Consumer
            public final void accept(Object obj) {
                this.f41723a.lambda$onAdVideoEndEvent$8((NativeEventListener) obj);
            }
        });
    }

    public void onAdVideoProgress(final long j) {
        LogcatUtil.d(this.TAG, "onAdVideoProgress");
        getEventListener().ifPresent(new Consumer() { // from class: com.zj.adlib.fq0
            @Override // com.fl.saas.common.util.feature.Consumer
            public final void accept(Object obj) {
                this.f16597a.lambda$onAdVideoProgress$9(j, (NativeEventListener) obj);
            }
        });
    }

    public void onAdVideoStartEvent() {
        LogcatUtil.d(this.TAG, "onAdVideoStartEvent");
        getEventListener().ifPresent(new Consumer() { // from class: com.zj.adlib.np0
            @Override // com.fl.saas.common.util.feature.Consumer
            public final void accept(Object obj) {
                this.f43578a.lambda$onAdVideoStartEvent$7((NativeEventListener) obj);
            }
        });
    }

    @Override // com.fl.saas.api.mixNative.NativeAd
    public void onDetachedVideo() {
    }

    @Override // com.fl.saas.api.mixNative.NativeAd
    public void onPause() {
    }

    @Override // com.fl.saas.api.mixNative.NativeAd
    public void onResume() {
    }

    @Override // com.fl.saas.api.mixNative.NativeAd
    public void prepare(final NativePrepareInfo nativePrepareInfo) {
        this.isShowOriginalView = true;
        if (this.mNativeAdView == null) {
            onAdFailedEvent(YdError.create(20405, "Please execute the renderAdContainer() method first."));
            return;
        }
        if (nativePrepareInfo == null || nativePrepareInfo.getActivity() == null) {
            onAdFailedEvent(YdError.create(20404, "prepareInfo or activity is null Please setActivity."));
            return;
        }
        this.showActivityRef = new WeakReference<>(nativePrepareInfo.getActivity());
        getReportEventListener().ifPresent(new Consumer() { // from class: com.zj.adlib.hp0
            @Override // com.fl.saas.common.util.feature.Consumer
            public final void accept(Object obj) {
                ((ReportEventListener) obj).reportRequestShow();
            }
        });
        getNativeAdOpt().ifPresent(new Consumer() { // from class: com.zj.adlib.jp0
            @Override // com.fl.saas.common.util.feature.Consumer
            public final void accept(Object obj) {
                this.f17459a.lambda$prepare$0(nativePrepareInfo, obj);
            }
        });
    }

    @Override // com.fl.saas.api.mixNative.NativeAd
    public void release() {
        if (this.hasRelease) {
            return;
        }
        this.hasRelease = true;
        MixNativeManager.OnNativeReleaseListener onNativeReleaseListener = this.onNativeReleaseListener;
        if (onNativeReleaseListener != null) {
            onNativeReleaseListener.release();
            this.onNativeReleaseListener = null;
        }
    }

    /* JADX INFO: renamed from: render, reason: merged with bridge method [inline-methods] */
    public abstract void lambda$prepare$0(T t, NativePrepareInfo nativePrepareInfo);

    @Override // com.fl.saas.api.mixNative.NativeAd
    public void renderAdContainer(NativeAdView nativeAdView, View view) {
        this.mNativeAdView = nativeAdView;
        this.selfRenderView = view;
    }

    public void setAdInfoMapper(AdInfoMapper adInfoMapper) {
        this.mAdInfoMapper = adInfoMapper;
    }

    @Override // com.fl.saas.api.mixNative.NativeAd
    public void setCanRefresh(boolean z) {
        this.mCanRefresh = z;
    }

    @Override // com.fl.saas.api.mixNative.NativeAd
    public void setClickCallBackListener(NativeClickCallbackListener nativeClickCallbackListener) {
        this.mClickCallBackListener = nativeClickCallbackListener;
    }

    @Override // com.fl.saas.base.interfaces.MixNativeCycleDataListener
    public void setCycleNativeAd(List<NativeAd> list, int i) {
        if (list == null || list.isEmpty() || i <= 0) {
            return;
        }
        this.mCycleNativeAds = list;
        this.mCycleNativeTime = i;
    }

    public void setEcpmMapper(EcpmMapper ecpmMapper) {
        this.mEcpmMapper = ecpmMapper;
    }

    @Override // com.fl.saas.api.mixNative.NativeAd
    public void setNativeAdParams(AdParams adParams) {
        this.requestParams = adParams;
    }

    @Override // com.fl.saas.api.mixNative.NativeAd
    public void setNativeEventListener(NativeEventListener nativeEventListener) {
        this.mEventListener = nativeEventListener;
    }

    @Override // com.fl.saas.api.mixNative.NativeAd
    public void setOnNativeReleaseListener(MixNativeManager.OnNativeReleaseListener onNativeReleaseListener) {
        this.onNativeReleaseListener = onNativeReleaseListener;
    }

    public void setReportEventListener(ReportEventListener reportEventListener) {
        this.mReportEventListener = reportEventListener;
    }

    public void setWinAdInfoMapper(WinAdInfoMapper winAdInfoMapper) {
        this.mWinAdInfoMapper = winAdInfoMapper;
    }
}

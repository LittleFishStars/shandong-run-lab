package com.fl.saas.adx.base.innterNative;

import android.app.Activity;
import android.content.Context;
import android.graphics.Color;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.arch.core.util.Function;
import com.fl.saas.B;
import com.fl.saas.C1415j;
import com.fl.saas.C1428p0;
import com.fl.saas.D0;
import com.fl.saas.R;
import com.fl.saas.adx.api.AdParams;
import com.fl.saas.adx.api.FLSDK;
import com.fl.saas.adx.api.mixNative.NativeAd;
import com.fl.saas.adx.api.mixNative.NativeAdView;
import com.fl.saas.adx.api.mixNative.NativeClickCallbackListener;
import com.fl.saas.adx.api.mixNative.NativeEventListener;
import com.fl.saas.adx.api.mixNative.NativeLoadListener;
import com.fl.saas.adx.api.mixNative.NativeMaterial;
import com.fl.saas.adx.api.mixNative.NativePrepareInfo;
import com.fl.saas.adx.base.bean.AdInfo;
import com.fl.saas.adx.base.bidding.BiddingResult;
import com.fl.saas.adx.base.exception.FLError;
import com.fl.saas.adx.base.innterNative.BaseNativeAd;
import com.fl.saas.adx.base.interfaces.MixNativeCycleDataListener;
import com.fl.saas.adx.base.manager.MixNativeManager;
import com.fl.saas.adx.base.widget.FingerSlidingAndTwistingView;
import com.fl.saas.adx.base.widget.FingerSlidingView;
import com.fl.saas.adx.base.widget.InclineView;
import com.fl.saas.adx.base.widget.ShakeView;
import com.fl.saas.adx.base.widget.VisibilityLayout;
import com.fl.saas.adx.base.widget.WinAdInfo;
import com.fl.saas.adx.util.CommConstant;
import com.fl.saas.adx.util.DeviceUtil;
import com.fl.saas.adx.util.FLImageLoader;
import com.fl.saas.adx.util.LogcatUtil;
import com.fl.saas.adx.util.ViewHelper;
import com.fl.saas.b1;
import com.ipd.dsp.internal.e1.i;
import com.zj.adlib.wp0;
import java.lang.ref.WeakReference;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_08_10593cls.dex */
public abstract class BaseNativeAd<T> implements NativeAd, MixNativeCycleDataListener {
    private AdInfoMapper mAdInfoMapper;
    private NativeClickCallbackListener mClickCallBackListener;
    private WeakReference<Context> mContext;
    private EcpmMapper mEcpmMapper;
    private NativeEventListener mEventListener;

    @Nullable
    private T mNativeAd;
    private NativeAdView mNativeAdView;
    private NativeMaterial mNativeMaterial;
    private D0 mReportEventListener;
    private Timer mTimer;
    private WinAdInfoMapper mWinAdInfoMapper;
    private MixNativeManager.OnNativeReleaseListener onNativeReleaseListener;
    private NativeAd refreshNativeAD;
    private AdParams requestParams;
    private View selfRenderView;
    private WeakReference<Activity> showActivityRef;
    private final String TAG = CommConstant.getObjTag(i.g, this);
    private boolean isReportExposure = false;
    private boolean nativeAdViewVisibility = true;
    private boolean mCanRefresh = true;
    private boolean hasDestroy = false;
    private boolean hasRelease = false;
    public boolean isNativeReady = true;
    public final long responseTime = System.currentTimeMillis();

    /* JADX INFO: renamed from: com.fl.saas.adx.base.innterNative.BaseNativeAd$2, reason: invalid class name */
    public class AnonymousClass2 extends TimerTask {
        public AnonymousClass2() {
        }

        @Override // java.util.TimerTask, java.lang.Runnable
        public void run() {
            if (BaseNativeAd.this.showActivityRef == null || BaseNativeAd.this.showActivityRef.get() == null || ((Activity) BaseNativeAd.this.showActivityRef.get()).isFinishing()) {
                BaseNativeAd.this.showActivityRef = new WeakReference(DeviceUtil.getTopActivity());
            }
            if (BaseNativeAd.this.showActivityRef == null || BaseNativeAd.this.showActivityRef.get() == null || ((Activity) BaseNativeAd.this.showActivityRef.get()).isFinishing() || !BaseNativeAd.this.nativeAdViewVisibility) {
                return;
            }
            FLSDK.loadMixNative((Context) BaseNativeAd.this.showActivityRef.get(), BaseNativeAd.this.requestParams, new NativeLoadListener() { // from class: com.fl.saas.adx.base.innterNative.BaseNativeAd.2.1

                /* JADX INFO: renamed from: com.fl.saas.adx.base.innterNative.BaseNativeAd$2$1$1, reason: invalid class name and collision with other inner class name */
                public class C06401 implements NativeEventListener {
                    public C06401() {
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

                    @Override // com.fl.saas.adx.api.mixNative.NativeEventListener
                    public void onAdClicked(NativeAdView nativeAdView) {
                        BaseNativeAd.this.getEventListener().a(new B() { // from class: com.fl.saas.adx.base.innterNative.e
                            @Override // com.fl.saas.B
                            public final void a(Object obj) {
                                this.f30114a.lambda$onAdClicked$1((NativeEventListener) obj);
                            }
                        });
                    }

                    @Override // com.fl.saas.adx.api.mixNative.NativeEventListener
                    public void onAdClose(NativeAdView nativeAdView) {
                        BaseNativeAd.this.getEventListener().a(new B() { // from class: com.fl.saas.adx.base.innterNative.c
                            @Override // com.fl.saas.B
                            public final void a(Object obj) {
                                this.f30112a.lambda$onAdClose$2((NativeEventListener) obj);
                            }
                        });
                        BaseNativeAd.this.stopRefresh();
                    }

                    @Override // com.fl.saas.adx.api.mixNative.NativeEventListener
                    public void onAdFailed(NativeAdView nativeAdView, FLError fLError) {
                    }

                    @Override // com.fl.saas.adx.api.mixNative.NativeEventListener
                    public void onAdImpressed(NativeAdView nativeAdView) {
                        BaseNativeAd.this.getEventListener().a(new B() { // from class: com.fl.saas.adx.base.innterNative.a
                            @Override // com.fl.saas.B
                            public final void a(Object obj) {
                                this.f30110a.lambda$onAdImpressed$0((NativeEventListener) obj);
                            }
                        });
                    }

                    @Override // com.fl.saas.adx.api.mixNative.NativeEventListener
                    public void onAdVideoEnd(NativeAdView nativeAdView) {
                        BaseNativeAd.this.getEventListener().a(new B() { // from class: com.fl.saas.adx.base.innterNative.b
                            @Override // com.fl.saas.B
                            public final void a(Object obj) {
                                this.f30111a.lambda$onAdVideoEnd$4((NativeEventListener) obj);
                            }
                        });
                    }

                    @Override // com.fl.saas.adx.api.mixNative.NativeEventListener
                    public void onAdVideoProgress(NativeAdView nativeAdView, final long j) {
                        BaseNativeAd.this.getEventListener().a(new B() { // from class: com.fl.saas.adx.base.innterNative.d
                            @Override // com.fl.saas.B
                            public final void a(Object obj) {
                                this.f1742a.lambda$onAdVideoProgress$5(j, (NativeEventListener) obj);
                            }
                        });
                    }

                    @Override // com.fl.saas.adx.api.mixNative.NativeEventListener
                    public void onAdVideoStart(NativeAdView nativeAdView) {
                        BaseNativeAd.this.getEventListener().a(new B() { // from class: com.fl.saas.adx.base.innterNative.f
                            @Override // com.fl.saas.B
                            public final void a(Object obj) {
                                this.f30115a.lambda$onAdVideoStart$3((NativeEventListener) obj);
                            }
                        });
                    }
                }

                @Override // com.fl.saas.adx.base.interfaces.AdViewListener
                public void onAdFailed(FLError fLError) {
                }

                @Override // com.fl.saas.adx.api.mixNative.NativeLoadListener
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
                    nativeAd.setNativeEventListener(new C06401());
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
        }
    }

    public interface AdInfoMapper {
        AdInfo getAdInfo();

        C1415j getSource();
    }

    public interface EcpmMapper {
        int getECPM();
    }

    public interface WinAdInfoMapper {
        WinAdInfo getAdInfo();
    }

    public BaseNativeAd(@NonNull Context context, @NonNull T t) {
        this.mNativeAd = t;
        this.mContext = new WeakReference<>(context);
        init(this.mNativeAd);
    }

    private void checkDataUpdate() {
        try {
            NativeAdView nativeAdView = this.mNativeAdView;
            if (nativeAdView != null) {
                nativeAdView.setOnViewWindowChangedListener(new VisibilityLayout.OnViewWindowChangedListener() { // from class: com.fl.saas.adx.base.innterNative.BaseNativeAd.1
                    @Override // com.fl.saas.adx.base.widget.VisibilityLayout.OnViewWindowChangedListener
                    public void onDetachedFromWindow() {
                        BaseNativeAd.this.stopRefresh();
                    }

                    @Override // com.fl.saas.adx.base.widget.VisibilityLayout.OnViewWindowChangedListener
                    public void onViewWindowVisibility(boolean z) {
                        BaseNativeAd.this.nativeAdViewVisibility = z;
                    }
                });
            }
            checkRefreshAd();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void checkRefreshAd() {
        AdInfoMapper adInfoMapper;
        if (this.mTimer == null && isNativeExpress() && this.mCanRefresh && (adInfoMapper = this.mAdInfoMapper) != null && adInfoMapper.getSource() != null) {
            C1415j source = this.mAdInfoMapper.getSource();
            if (source.e0 != 1 || source.f0 <= 0) {
                return;
            }
            Timer timer = new Timer();
            this.mTimer = timer;
            AnonymousClass2 anonymousClass2 = new AnonymousClass2();
            long j = ((long) source.f0) * 1000;
            timer.schedule(anonymousClass2, j, j);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public C1428p0 getEventListener() {
        return C1428p0.b(this.mEventListener);
    }

    private C1428p0 getReportEventListener() {
        return C1428p0.b(this.mReportEventListener);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ NativeMaterial lambda$getAdMaterial$1() {
        return (NativeMaterial) getNativeAdOpt().a(new Function() { // from class: com.zj.adlib.gp0
            @Override // androidx.arch.core.util.Function
            public final Object apply(Object obj) {
                return this.f41956a.createNativeMaterial(obj);
            }
        }).c(null);
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
    public /* synthetic */ void lambda$onAdFailedEvent$2(FLError fLError, NativeEventListener nativeEventListener) {
        nativeEventListener.onAdFailed(this.mNativeAdView, fLError);
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

    /* JADX INFO: Access modifiers changed from: private */
    public void stopRefresh() {
        Timer timer = this.mTimer;
        if (timer != null) {
            timer.cancel();
            this.mTimer = null;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.fl.saas.adx.api.MediaExtraInfo
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
            onAdFailedEvent(FLError.create(20405, "NativeAdView is null"));
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

    public abstract NativeMaterial createNativeMaterial(@NonNull T t);

    @Override // com.fl.saas.adx.api.mixNative.NativeAd
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
        NativeAdView nativeAdView = this.mNativeAdView;
        if (nativeAdView != null && this.mCanRefresh) {
            nativeAdView.removeAllViews();
            ViewHelper.removeParent(this.mNativeAdView);
            this.mNativeAdView.detachedView();
        }
        this.mEventListener = null;
        this.mClickCallBackListener = null;
    }

    @Override // com.fl.saas.adx.api.MediaExtraInfo
    public AdInfo getAdInfo() {
        AdInfoMapper adInfoMapper = this.mAdInfoMapper;
        if (adInfoMapper != null) {
            return adInfoMapper.getAdInfo();
        }
        return null;
    }

    @Override // com.fl.saas.adx.api.mixNative.NativeAd
    public NativeMaterial getAdMaterial() {
        NativeMaterial nativeMaterial = (NativeMaterial) C1428p0.b(this.mNativeMaterial).b(new b1() { // from class: com.zj.adlib.sp0
            @Override // com.fl.saas.b1
            public final Object a() {
                return this.f44739a.lambda$getAdMaterial$1();
            }
        });
        this.mNativeMaterial = nativeMaterial;
        return nativeMaterial;
    }

    public View getAreaShakesView() {
        View viewInflate = ViewHelper.inflate(getContext(), R.layout.fl_adx_view_area_shake_spread);
        FLImageLoader.getInstance(getContext()).setEnableDiskCache(true).setEnableMemoryCache(true).loadImage((ImageView) viewInflate.findViewById(R.id.iv_bg), "https://creative.medproad.com/medpro/imgs/944e91c4ed73a3267d43f9b9eee5bea.png");
        return viewInflate;
    }

    public Context getContext() {
        WeakReference<Context> weakReference;
        WeakReference<Activity> weakReference2 = this.showActivityRef;
        Activity topActivity = (weakReference2 == null || weakReference2.get().isFinishing()) ? null : this.showActivityRef.get();
        if (topActivity == null) {
            topActivity = DeviceUtil.getTopActivity();
        }
        return (topActivity != null || (weakReference = this.mContext) == null) ? topActivity : weakReference.get();
    }

    @Override // com.fl.saas.adx.base.interfaces.MixNativeCycleDataListener
    public NativeAd getCycleNativeAd() {
        return null;
    }

    @Override // com.fl.saas.adx.api.MediaExtraInfo
    public int getECPM() {
        return ((Integer) C1428p0.b(this.mEcpmMapper).a(new Function() { // from class: com.zj.adlib.op0
            @Override // androidx.arch.core.util.Function
            public final Object apply(Object obj) {
                return Integer.valueOf(((BaseNativeAd.EcpmMapper) obj).getECPM());
            }
        }).c(0)).intValue();
    }

    public View getInterstitalShakesView() {
        return ViewHelper.inflate(getContext(), R.layout.fl_adx_view_shake_interstital);
    }

    @Nullable
    public T getNativeAd() {
        return this.mNativeAd;
    }

    public C1428p0 getNativeAdOpt() {
        return C1428p0.b(this.mNativeAd);
    }

    public NativeAdView getNativeAdView() {
        return this.mNativeAdView;
    }

    @Override // com.fl.saas.adx.api.mixNative.NativeAd
    public String getReqId() {
        AdInfoMapper adInfoMapper = this.mAdInfoMapper;
        return (adInfoMapper == null || adInfoMapper.getSource() == null) ? "" : this.mAdInfoMapper.getSource().g;
    }

    public View getSelfRenderView() {
        return this.selfRenderView;
    }

    public View getShakeTipsView() {
        return ViewHelper.inflate(getContext(), R.layout.fl_adx_view_shake_template);
    }

    public View getSpreadInlineView() {
        return ViewHelper.inflate(getContext(), R.layout.fl_adx_view_incline_spread);
    }

    public View getSpreadShakesView() {
        return ViewHelper.inflate(getContext(), R.layout.fl_adx_view_shake_spread);
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
        return ViewHelper.inflate(getContext(), R.layout.fl_adx_view_shake_template);
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
            textView.setBackgroundResource(R.drawable.fl_adx_shake_bg_template);
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
        textView.setBackgroundResource(R.drawable.fl_adx_shake_bg_template);
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

    @Override // com.fl.saas.adx.api.mixNative.NativeAd
    public boolean isReady() {
        AdInfoMapper adInfoMapper = this.mAdInfoMapper;
        if (adInfoMapper == null || adInfoMapper.getSource() == null) {
            return false;
        }
        return this.isNativeReady && ((((System.currentTimeMillis() - this.responseTime) / 1000) > ((long) this.mAdInfoMapper.getSource().D1) ? 1 : (((System.currentTimeMillis() - this.responseTime) / 1000) == ((long) this.mAdInfoMapper.getSource().D1) ? 0 : -1)) < 0);
    }

    @Override // com.fl.saas.adx.api.mixNative.NativeAd
    public boolean isShakeType() {
        return false;
    }

    public void listenInclineView(final View view, boolean z, final ActionView.Type type, int i, final InclineView.InclineListener inclineListener) {
        InclineView inclineView;
        if (view == null || (inclineView = (InclineView) view.findViewById(R.id.yd_incline_view)) == null) {
            return;
        }
        inclineView.setCallback(z);
        inclineView.setInclineListener(i, new InclineView.InclineListener() { // from class: com.zj.adlib.mp0
            @Override // com.fl.saas.adx.base.widget.InclineView.InclineListener
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
        shakeView.setShakeListener(i, new ShakeView.ShakeListener() { // from class: com.zj.adlib.yp0
            @Override // com.fl.saas.adx.base.widget.ShakeView.ShakeListener
            public final void onShake(int i2, int i3, int i4) {
                BaseNativeAd.lambda$listenShakeView$10(shakeListener, type, view, i2, i3, i4);
            }
        });
    }

    public void onAdClickedCallBackEvent(String str) {
        LogcatUtil.d(this.TAG, "onAdClickedCallBackEvent");
        getReportEventListener().a((B) new wp0());
        NativeClickCallbackListener nativeClickCallbackListener = this.mClickCallBackListener;
        if (nativeClickCallbackListener != null) {
            nativeClickCallbackListener.onAdClicked(str);
        }
    }

    public void onAdClickedEvent() {
        LogcatUtil.d(this.TAG, "onAdClickedEvent");
        getReportEventListener().a((B) new wp0());
        getEventListener().a(new B() { // from class: com.zj.adlib.kq0
            @Override // com.fl.saas.B
            public final void a(Object obj) {
                this.f42884a.lambda$onAdClickedEvent$4((NativeEventListener) obj);
            }
        });
    }

    public void onAdCloseEvent() {
        LogcatUtil.d(this.TAG, "onAdCloseEvent");
        stopRefresh();
        getEventListener().a(new B() { // from class: com.zj.adlib.aq0
            @Override // com.fl.saas.B
            public final void a(Object obj) {
                this.f40582a.lambda$onAdCloseEvent$6((NativeEventListener) obj);
            }
        });
    }

    public void onAdFailedEvent(final FLError fLError) {
        LogcatUtil.d(this.TAG, "onAdFailed:" + fLError);
        getEventListener().a(new B() { // from class: com.zj.adlib.ep0
            @Override // com.fl.saas.B
            public final void a(Object obj) {
                this.f16380a.lambda$onAdFailedEvent$2(fLError, (NativeEventListener) obj);
            }
        });
    }

    public void onAdImpressedEvent() {
        String str = this.TAG;
        StringBuilder sb = new StringBuilder();
        sb.append("onAdImpressedEvent");
        sb.append(this.isReportExposure);
        sb.append(getEventListener() == null);
        LogcatUtil.d(str, sb.toString());
        checkDataUpdate();
        if (this.isReportExposure) {
            return;
        }
        this.isReportExposure = true;
        getReportEventListener().a(new B() { // from class: com.zj.adlib.cq0
            @Override // com.fl.saas.B
            public final void a(Object obj) {
                ((D0) obj).onShowEvent();
            }
        });
        getEventListener().a(new B() { // from class: com.zj.adlib.eq0
            @Override // com.fl.saas.B
            public final void a(Object obj) {
                this.f41496a.lambda$onAdImpressedEvent$3((NativeEventListener) obj);
            }
        });
    }

    public void onAdVideoEndEvent() {
        LogcatUtil.d(this.TAG, "onAdVideoEndEvent");
        getEventListener().a(new B() { // from class: com.zj.adlib.ip0
            @Override // com.fl.saas.B
            public final void a(Object obj) {
                this.f42409a.lambda$onAdVideoEndEvent$8((NativeEventListener) obj);
            }
        });
    }

    public void onAdVideoProgress(final long j) {
        LogcatUtil.d(this.TAG, "onAdVideoProgress");
        getEventListener().a(new B() { // from class: com.zj.adlib.qp0
            @Override // com.fl.saas.B
            public final void a(Object obj) {
                this.f19156a.lambda$onAdVideoProgress$9(j, (NativeEventListener) obj);
            }
        });
    }

    public void onAdVideoStartEvent() {
        LogcatUtil.d(this.TAG, "onAdVideoStartEvent");
        getEventListener().a(new B() { // from class: com.zj.adlib.up0
            @Override // com.fl.saas.B
            public final void a(Object obj) {
                this.f45196a.lambda$onAdVideoStartEvent$7((NativeEventListener) obj);
            }
        });
    }

    @Override // com.fl.saas.adx.api.mixNative.NativeAd
    public void onDetachedVideo() {
    }

    @Override // com.fl.saas.adx.api.mixNative.NativeAd
    public void onPause() {
    }

    @Override // com.fl.saas.adx.api.mixNative.NativeAd
    public void onResume() {
    }

    @Override // com.fl.saas.adx.api.mixNative.NativeAd
    public void prepare(final NativePrepareInfo nativePrepareInfo) {
        if (this.mNativeAdView == null) {
            onAdFailedEvent(FLError.create(20405, "Please execute the renderAdContainer() method first."));
            return;
        }
        if (nativePrepareInfo == null) {
            onAdFailedEvent(FLError.create(20404, "prepareInfo is null"));
            return;
        }
        if (nativePrepareInfo.getActivity() != null) {
            this.showActivityRef = new WeakReference<>(nativePrepareInfo.getActivity());
        }
        getReportEventListener().a(new B() { // from class: com.zj.adlib.gq0
            @Override // com.fl.saas.B
            public final void a(Object obj) {
                ((D0) obj).reportRequestShow();
            }
        });
        getNativeAdOpt().a(new B() { // from class: com.zj.adlib.iq0
            @Override // com.fl.saas.B
            public final void a(Object obj) {
                this.f17254a.lambda$prepare$0(nativePrepareInfo, obj);
            }
        });
    }

    @Override // com.fl.saas.adx.api.mixNative.NativeAd
    public void release() {
        if (this.hasRelease) {
            return;
        }
        this.hasRelease = true;
        destroy();
        LogcatUtil.d(this.TAG, "release");
        MixNativeManager.OnNativeReleaseListener onNativeReleaseListener = this.onNativeReleaseListener;
        if (onNativeReleaseListener != null) {
            onNativeReleaseListener.release();
            this.onNativeReleaseListener = null;
        }
    }

    /* JADX INFO: renamed from: render, reason: merged with bridge method [inline-methods] */
    public abstract void lambda$prepare$0(T t, NativePrepareInfo nativePrepareInfo);

    @Override // com.fl.saas.adx.api.mixNative.NativeAd
    public void renderAdContainer(NativeAdView nativeAdView, View view) {
        this.mNativeAdView = nativeAdView;
        this.selfRenderView = view;
    }

    public void setAdInfoMapper(AdInfoMapper adInfoMapper) {
        this.mAdInfoMapper = adInfoMapper;
    }

    @Override // com.fl.saas.adx.api.mixNative.NativeAd
    public void setCanRefresh(boolean z) {
        this.mCanRefresh = z;
    }

    @Override // com.fl.saas.adx.api.mixNative.NativeAd
    public void setClickCallBackListener(NativeClickCallbackListener nativeClickCallbackListener) {
        this.mClickCallBackListener = nativeClickCallbackListener;
    }

    @Override // com.fl.saas.adx.base.interfaces.MixNativeCycleDataListener
    public void setCycleNativeAd(List<NativeAd> list, int i) {
        if (list != null) {
            list.isEmpty();
        }
    }

    public void setEcpmMapper(EcpmMapper ecpmMapper) {
        this.mEcpmMapper = ecpmMapper;
    }

    @Override // com.fl.saas.adx.api.mixNative.NativeAd
    public void setNativeAdParams(AdParams adParams) {
        this.requestParams = adParams;
    }

    @Override // com.fl.saas.adx.api.mixNative.NativeAd
    public void setNativeEventListener(NativeEventListener nativeEventListener) {
        this.mEventListener = nativeEventListener;
    }

    @Override // com.fl.saas.adx.api.mixNative.NativeAd
    public void setOnNativeReleaseListener(MixNativeManager.OnNativeReleaseListener onNativeReleaseListener) {
        this.onNativeReleaseListener = onNativeReleaseListener;
    }

    public void setReportEventListener(D0 d0) {
        this.mReportEventListener = d0;
    }

    public void setWinAdInfoMapper(WinAdInfoMapper winAdInfoMapper) {
        this.mWinAdInfoMapper = winAdInfoMapper;
    }

    public void onAdClickedEvent(int i) {
        LogcatUtil.d(this.TAG, "onAdClickedEvent");
        getReportEventListener().a((B) new wp0());
        if (i == 1) {
            getEventListener().a(new B() { // from class: com.zj.adlib.kp0
                @Override // com.fl.saas.B
                public final void a(Object obj) {
                    this.f42875a.lambda$onAdClickedEvent$5((NativeEventListener) obj);
                }
            });
        }
    }
}

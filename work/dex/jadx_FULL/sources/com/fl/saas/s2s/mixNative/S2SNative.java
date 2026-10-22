package com.fl.saas.s2s.mixNative;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.text.TextUtils;
import android.view.MotionEvent;
import android.view.View;
import android.widget.FrameLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.alibaba.baichuan.trade.common.constants.AlibcCommonConstant;
import com.fl.saas.api.mixNative.NativeCustomizeVideo;
import com.fl.saas.api.mixNative.NativeMaterial;
import com.fl.saas.api.mixNative.NativePrepareInfo;
import com.fl.saas.base.bean.MediaReturnMaterialBean;
import com.fl.saas.base.bidding.BiddingResult;
import com.fl.saas.base.innterNative.ActionView;
import com.fl.saas.base.innterNative.BaseNativeAd;
import com.fl.saas.base.interfaces.AdChangeCacheData;
import com.fl.saas.base.widget.FingerSlidingAndTwistingView;
import com.fl.saas.base.widget.FingerSlidingView;
import com.fl.saas.base.widget.InclineView;
import com.fl.saas.base.widget.NativeSlidingView;
import com.fl.saas.base.widget.RainTextureView;
import com.fl.saas.base.widget.ShakeView;
import com.fl.saas.common.listener.DeepLinkOpenListener;
import com.fl.saas.common.saas.bean.AdSource;
import com.fl.saas.common.util.CommConstant;
import com.fl.saas.common.util.ViewHelper;
import com.fl.saas.common.util.feature.Consumer;
import com.fl.saas.common.widget.h5.QuickAppHelper;
import com.fl.saas.common.widget.h5.YdH5Activity;
import com.fl.saas.config.exception.YdError;
import com.fl.saas.config.utils.DeepLinkJumpUtil;
import com.fl.saas.config.utils.DeviceUtil;
import com.fl.saas.config.utils.LogcatUtil;
import com.fl.saas.config.utils.json.Yson;
import com.fl.saas.s2s.R;
import com.fl.saas.s2s.mixNative.S2SNative;
import com.fl.saas.s2s.sdk.helper.AdInfoPoJo;
import com.fl.saas.s2s.sdk.helper.CommJumpHelper;
import com.fl.saas.s2s.sdk.helper.CommReportHelper;
import com.fl.saas.s2s.sdk.helper.S2SAdLoadListener;
import com.fl.saas.s2s.sdk.util.AdConfigUtil;
import com.fl.saas.s2s.sdk.util.S2SVideoPlayListener;
import com.fl.saas.s2s.sdk.util.S2SVideoView;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_08_10593cls.dex */
public class S2SNative extends BaseNativeAd<AdInfoPoJo> implements BiddingResult, ActionView, AdChangeCacheData, DeepLinkOpenListener {
    private static final String TAG = CommConstant.getClassTag("S2S", S2SNative.class);
    private List<View> clickViews;
    private final boolean isCache;
    private boolean isReportExposure;
    private final S2SAdLoadListener loadListener;
    private final AdSource mAdSource;
    private ActionView.Type mType;
    private S2SVideoView mediaView;
    private View tempActionView;
    private boolean touchClick;

    public S2SNative(@NonNull Context context, @NonNull AdInfoPoJo adInfoPoJo, AdSource adSource, boolean z, S2SAdLoadListener s2SAdLoadListener) {
        super(context, adInfoPoJo);
        this.isReportExposure = false;
        this.mAdSource = adSource;
        this.isCache = z;
        this.loadListener = s2SAdLoadListener;
    }

    /* JADX WARN: Code duplicated, block: B:12:0x0015 A[Catch: all -> 0x0094, TryCatch #0 {, blocks: (B:7:0x0007, B:10:0x0011, B:12:0x0015, B:13:0x001b, B:15:0x003a, B:17:0x0042, B:18:0x004a, B:20:0x0052, B:22:0x005c, B:24:0x0076, B:23:0x006a, B:9:0x000d), top: B:30:0x0007 }] */
    /* JADX WARN: Code duplicated, block: B:23:0x006a A[Catch: all -> 0x0094, TryCatch #0 {, blocks: (B:7:0x0007, B:10:0x0011, B:12:0x0015, B:13:0x001b, B:15:0x003a, B:17:0x0042, B:18:0x004a, B:20:0x0052, B:22:0x005c, B:24:0x0076, B:23:0x006a, B:9:0x000d), top: B:30:0x0007 }] */
    /* JADX WARN: Code duplicated, block: B:9:0x000d A[Catch: all -> 0x0094, TryCatch #0 {, blocks: (B:7:0x0007, B:10:0x0011, B:12:0x0015, B:13:0x001b, B:15:0x003a, B:17:0x0042, B:18:0x004a, B:20:0x0052, B:22:0x005c, B:24:0x0076, B:23:0x006a, B:9:0x000d), top: B:30:0x0007 }] */
    private synchronized void adViewClickDispose(Activity activity, AdInfoPoJo adInfoPoJo) {
        View view;
        int type;
        AdInfoPoJo.Creative creative;
        if (adInfoPoJo == null) {
            return;
        }
        if (activity == null) {
            activity = DeviceUtil.getTopActivity();
            view = this.tempActionView;
            if (view != null) {
                ViewHelper.removeParent(view);
                this.tempActionView = null;
            }
            DeepLinkJumpUtil.getInstance().setDeepLinkOpenListener(this);
            adInfoPoJo.clickIsDp = "2";
            checkAdShowEvent();
            type = AdConfigUtil.getType(adInfoPoJo);
            adInfoPoJo.type = type;
            CommReportHelper.getInstance().reportClick(adInfoPoJo);
            creative = adInfoPoJo.creative;
            if (creative != null) {
                this.mAdSource.creative_id = adInfoPoJo.creative.cid;
            }
            if (TextUtils.isEmpty(adInfoPoJo.click_url)) {
                CommJumpHelper.getInstance().jump(activity, adInfoPoJo, this.mAdSource);
                onAdClickedEvent(type);
            } else {
                CommJumpHelper.getInstance().jump(activity, adInfoPoJo, this.mAdSource);
                onAdClickedEvent(type);
            }
            adInfoPoJo.clickType = AdInfoPoJo.ClickType.NORMAL;
            adInfoPoJo.down_x = AlibcCommonConstant.HTTP_INVALID_RESPONSE_CODE;
            adInfoPoJo.down_y = AlibcCommonConstant.HTTP_INVALID_RESPONSE_CODE;
            adInfoPoJo.abs_down_x = AlibcCommonConstant.HTTP_INVALID_RESPONSE_CODE;
            adInfoPoJo.abs_down_y = AlibcCommonConstant.HTTP_INVALID_RESPONSE_CODE;
            adInfoPoJo.up_x = AlibcCommonConstant.HTTP_INVALID_RESPONSE_CODE;
            adInfoPoJo.up_y = AlibcCommonConstant.HTTP_INVALID_RESPONSE_CODE;
            adInfoPoJo.abs_up_x = AlibcCommonConstant.HTTP_INVALID_RESPONSE_CODE;
            adInfoPoJo.abs_up_y = AlibcCommonConstant.HTTP_INVALID_RESPONSE_CODE;
            adInfoPoJo.shake_x = AlibcCommonConstant.HTTP_INVALID_RESPONSE_CODE;
            adInfoPoJo.shake_y = AlibcCommonConstant.HTTP_INVALID_RESPONSE_CODE;
            adInfoPoJo.shake_z = AlibcCommonConstant.HTTP_INVALID_RESPONSE_CODE;
            return;
        }
        if (activity.isFinishing()) {
            activity = DeviceUtil.getTopActivity();
        }
        view = this.tempActionView;
        if (view != null) {
            ViewHelper.removeParent(view);
            this.tempActionView = null;
        }
        DeepLinkJumpUtil.getInstance().setDeepLinkOpenListener(this);
        adInfoPoJo.clickIsDp = "2";
        checkAdShowEvent();
        type = AdConfigUtil.getType(adInfoPoJo);
        adInfoPoJo.type = type;
        CommReportHelper.getInstance().reportClick(adInfoPoJo);
        creative = adInfoPoJo.creative;
        if (creative != null && !TextUtils.isEmpty(creative.cid)) {
            this.mAdSource.creative_id = adInfoPoJo.creative.cid;
        }
        if (TextUtils.isEmpty(adInfoPoJo.click_url) || !adInfoPoJo.click_url.startsWith("ECHARGINGCUSTOM")) {
            CommJumpHelper.getInstance().jump(activity, adInfoPoJo, this.mAdSource);
            onAdClickedEvent(type);
        } else {
            onAdClickedCallBackEvent(adInfoPoJo.click_url.replace("ECHARGINGCUSTOM", ""));
        }
        adInfoPoJo.clickType = AdInfoPoJo.ClickType.NORMAL;
        adInfoPoJo.down_x = AlibcCommonConstant.HTTP_INVALID_RESPONSE_CODE;
        adInfoPoJo.down_y = AlibcCommonConstant.HTTP_INVALID_RESPONSE_CODE;
        adInfoPoJo.abs_down_x = AlibcCommonConstant.HTTP_INVALID_RESPONSE_CODE;
        adInfoPoJo.abs_down_y = AlibcCommonConstant.HTTP_INVALID_RESPONSE_CODE;
        adInfoPoJo.up_x = AlibcCommonConstant.HTTP_INVALID_RESPONSE_CODE;
        adInfoPoJo.up_y = AlibcCommonConstant.HTTP_INVALID_RESPONSE_CODE;
        adInfoPoJo.abs_up_x = AlibcCommonConstant.HTTP_INVALID_RESPONSE_CODE;
        adInfoPoJo.abs_up_y = AlibcCommonConstant.HTTP_INVALID_RESPONSE_CODE;
        adInfoPoJo.shake_x = AlibcCommonConstant.HTTP_INVALID_RESPONSE_CODE;
        adInfoPoJo.shake_y = AlibcCommonConstant.HTTP_INVALID_RESPONSE_CODE;
        adInfoPoJo.shake_z = AlibcCommonConstant.HTTP_INVALID_RESPONSE_CODE;
        return;
        throw th;
    }

    @SuppressLint({"ClickableViewAccessibility"})
    private void bindClickViews(final Activity activity, AdInfoPoJo adInfoPoJo, final List<View> list) {
        if (this.clickViews == null) {
            this.clickViews = new ArrayList();
        }
        LogcatUtil.d(TAG, "bindClickViews" + this.clickViews.size() + activity);
        for (View view : this.clickViews) {
            view.setClickable(true);
            view.setEnabled(true);
            view.setOnTouchListener(new View.OnTouchListener() { // from class: com.zj.adlib.yo7
                @Override // android.view.View.OnTouchListener
                public final boolean onTouch(View view2, MotionEvent motionEvent) {
                    return this.f46084a.lambda$bindClickViews$4(view2, motionEvent);
                }
            });
            ViewHelper.onSingleClickListener(view, new View.OnClickListener() { // from class: com.zj.adlib.zo7
                @Override // android.view.View.OnClickListener
                public final void onClick(View view2) {
                    this.f21097a.lambda$bindClickViews$5(list, activity, view2);
                }
            });
        }
    }

    private void bindMediaViewClick(final Activity activity, @NonNull final AdInfoPoJo adInfoPoJo) {
        S2SVideoView s2SVideoView = this.mediaView;
        if (s2SVideoView == null) {
            return;
        }
        s2SVideoView.setOnClickListener(new View.OnClickListener() { // from class: com.zj.adlib.fp7
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f16594a.lambda$bindMediaViewClick$6(adInfoPoJo, activity, view);
            }
        });
    }

    private void bindNativeView() {
        if (this.isReportExposure) {
            return;
        }
        getNativeAdView().setOnVisibilityChanged(new Consumer() { // from class: com.zj.adlib.cp7
            @Override // com.fl.saas.common.util.feature.Consumer
            public final void accept(Object obj) {
                this.f41017a.lambda$bindNativeView$2((Boolean) obj);
            }
        });
        getNativeAdView().setVisibilityRatioChanged(new Consumer() { // from class: com.zj.adlib.dp7
            @Override // com.fl.saas.common.util.feature.Consumer
            public final void accept(Object obj) {
                this.f41244a.lambda$bindNativeView$3((Integer) obj);
            }
        });
    }

    private void checkAdShowEvent() {
        if (this.isReportExposure) {
            return;
        }
        getNativeAdView().unOnVisibilityChanged();
        this.isReportExposure = true;
        onAdImpressedEvent();
        AdInfoPoJo nativeAd = getNativeAd();
        if (nativeAd != null) {
            nativeAd.showTime = System.currentTimeMillis();
            nativeAd.realWidth = getNativeAdView().getWidth();
            nativeAd.realHeight = getNativeAdView().getHeight();
            CommReportHelper.getInstance().reportDisplay(nativeAd, this.isCache);
            AdInfoPoJo.Creative creative = nativeAd.creative;
            if (creative == null || TextUtils.isEmpty(creative.cid)) {
                return;
            }
            this.mAdSource.creative_id = nativeAd.creative.cid;
        }
    }

    private void createMediaView(AdInfoPoJo adInfoPoJo) {
        S2SAdLoadListener s2SAdLoadListener;
        if (adInfoPoJo == null || this.mediaView != null || TextUtils.isEmpty(adInfoPoJo.video_url) || adInfoPoJo.creative.ctype != 2) {
            S2SAdLoadListener s2SAdLoadListener2 = this.loadListener;
            if (s2SAdLoadListener2 != null) {
                s2SAdLoadListener2.onLoadedSuccess();
                return;
            }
            return;
        }
        S2SVideoView s2SVideoView = new S2SVideoView(getContext());
        this.mediaView = s2SVideoView;
        s2SVideoView.setVideo(adInfoPoJo);
        this.mediaView.setVideoPlayListener(new S2SVideoPlayListener() { // from class: com.fl.saas.s2s.mixNative.S2SNative.2
            @Override // com.fl.saas.s2s.sdk.util.S2SVideoPlayListener
            public void onVideoPlayComplete() {
                S2SNative.this.onAdVideoEndEvent();
            }

            @Override // com.fl.saas.s2s.sdk.util.S2SVideoPlayListener
            public void onVideoPlayError(int i, int i2) {
            }

            @Override // com.fl.saas.s2s.sdk.util.S2SVideoPlayListener
            public void onVideoPlayStart() {
                S2SNative.this.onAdVideoStartEvent();
            }

            @Override // com.fl.saas.s2s.sdk.util.S2SVideoPlayListener
            public void onVideoPrepare() {
                if (DeviceUtil.filling_timing != 1 || S2SNative.this.loadListener == null) {
                    return;
                }
                S2SNative.this.loadListener.onLoadedSuccess();
            }
        });
        if (DeviceUtil.filling_timing != 0 || (s2SAdLoadListener = this.loadListener) == null) {
            return;
        }
        s2SAdLoadListener.onLoadedSuccess();
    }

    private NativeSlidingView getFingerSlidingView(final AdInfoPoJo adInfoPoJo) {
        final NativeSlidingView nativeSlidingView = new NativeSlidingView(getContext());
        nativeSlidingView.setSlidingListener(new NativeSlidingView.SlidingListener() { // from class: com.fl.saas.s2s.mixNative.S2SNative.1
            @Override // com.fl.saas.base.widget.NativeSlidingView.SlidingListener
            public void onDown(int i, int i2) {
                AdInfoPoJo adInfoPoJo2 = adInfoPoJo;
                if (adInfoPoJo2 == null) {
                    return;
                }
                adInfoPoJo2.down_x = i;
                adInfoPoJo2.down_y = i2;
                int[] iArr = new int[2];
                nativeSlidingView.getLocationOnScreen(iArr);
                AdInfoPoJo adInfoPoJo3 = adInfoPoJo;
                adInfoPoJo3.abs_down_x = adInfoPoJo3.down_x + iArr[0];
                adInfoPoJo3.abs_down_y = adInfoPoJo3.down_y + iArr[1];
                adInfoPoJo3.DOWN_TIME = System.currentTimeMillis();
            }

            @Override // com.fl.saas.base.widget.NativeSlidingView.SlidingListener
            public void onSliding() {
                if (S2SNative.this.clickViews != null && !S2SNative.this.clickViews.isEmpty()) {
                    for (View view : S2SNative.this.clickViews) {
                        if (!(view instanceof RainTextureView)) {
                            adInfoPoJo.clickType = AdInfoPoJo.ClickType.SLIDE;
                            view.performClick();
                            break;
                        }
                    }
                }
                ViewHelper.removeParent(nativeSlidingView);
            }

            @Override // com.fl.saas.base.widget.NativeSlidingView.SlidingListener
            public void onUp(int i, int i2) {
                AdInfoPoJo adInfoPoJo2 = adInfoPoJo;
                if (adInfoPoJo2 == null) {
                    return;
                }
                adInfoPoJo2.up_x = i;
                adInfoPoJo2.up_y = i2;
                int[] iArr = new int[2];
                nativeSlidingView.getLocationOnScreen(iArr);
                AdInfoPoJo adInfoPoJo3 = adInfoPoJo;
                adInfoPoJo3.abs_up_x = adInfoPoJo3.up_x + iArr[0];
                adInfoPoJo3.abs_up_y = adInfoPoJo3.up_y + iArr[1];
                adInfoPoJo3.UP_TIME = System.currentTimeMillis();
            }
        });
        nativeSlidingView.createView(adInfoPoJo.display_mask == 1);
        return nativeSlidingView;
    }

    private void handleInclineView(final View view, final ActionView.Type type, final AdInfoPoJo adInfoPoJo) {
        listenInclineView(view, false, type, adInfoPoJo.getShakeSpeed(), new InclineView.InclineListener() { // from class: com.zj.adlib.ep7
            @Override // com.fl.saas.base.widget.InclineView.InclineListener
            public final void onIncline(int i, int i2, int i3) {
                this.f16382a.lambda$handleInclineView$9(adInfoPoJo, type, view, i, i2, i3);
            }
        });
    }

    private void handleSharkView(final View view, final ActionView.Type type, final AdInfoPoJo adInfoPoJo) {
        listenShakeView(view, false, type, adInfoPoJo.getShakeSpeed(), new ShakeView.ShakeListener() { // from class: com.zj.adlib.xo7
            @Override // com.fl.saas.base.widget.ShakeView.ShakeListener
            public final void onShake(int i, int i2, int i3) {
                this.f20693a.lambda$handleSharkView$8(adInfoPoJo, type, view, i, i2, i3);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void lambda$biddingResult$7(int i, boolean z, int i2, AdInfoPoJo adInfoPoJo) {
        adInfoPoJo.second_price = i;
        if (!z) {
            LogcatUtil.e("ydsdk-reportApiBidFail", "price:" + adInfoPoJo.price + "--winP:" + i2);
            if (i2 > 0) {
                adInfoPoJo.price = i2;
            }
            CommReportHelper.getInstance().reportApiBidFail(adInfoPoJo);
            return;
        }
        LogcatUtil.e("ydsdk-reportApiBidSuccess", "price:" + adInfoPoJo.price + "--winP:" + i2);
        if (i2 > 0 && i2 <= adInfoPoJo.price) {
            adInfoPoJo.price = i2;
        }
        CommReportHelper.getInstance().reportApiBidSuccess(adInfoPoJo);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ boolean lambda$bindClickViews$4(View view, MotionEvent motionEvent) {
        if (motionEvent.getAction() == 0) {
            LogcatUtil.d(TAG, "ACTION_DOWN");
            AdInfoPoJo nativeAd = getNativeAd();
            if (nativeAd != null) {
                nativeAd.down_x = (int) motionEvent.getX();
                nativeAd.down_y = (int) motionEvent.getY();
                int[] iArr = new int[2];
                view.getLocationOnScreen(iArr);
                nativeAd.abs_down_x = nativeAd.down_x + iArr[0];
                nativeAd.abs_down_y = nativeAd.down_y + iArr[1];
                nativeAd.DOWN_TIME = System.currentTimeMillis();
            }
        }
        if (motionEvent.getAction() == 1) {
            LogcatUtil.d(TAG, "ACTION_UP");
            AdInfoPoJo nativeAd2 = getNativeAd();
            if (nativeAd2 != null) {
                nativeAd2.up_x = (int) motionEvent.getX();
                nativeAd2.up_y = (int) motionEvent.getY();
                int[] iArr2 = new int[2];
                view.getLocationOnScreen(iArr2);
                nativeAd2.abs_up_x = nativeAd2.up_x + iArr2[0];
                nativeAd2.abs_up_y = nativeAd2.up_y + iArr2[1];
                nativeAd2.UP_TIME = System.currentTimeMillis();
            }
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$bindClickViews$5(List list, Activity activity, View view) {
        LogcatUtil.d(TAG, "viewClick");
        AdInfoPoJo nativeAd = getNativeAd();
        if (nativeAd != null) {
            nativeAd.clickArea = "1";
            if (list != null && !list.isEmpty()) {
                Iterator it = list.iterator();
                while (it.hasNext()) {
                    if (((View) it.next()) == view) {
                        nativeAd.clickArea = "2";
                        break;
                    }
                }
            }
        }
        adViewClickDispose(activity, nativeAd);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$bindMediaViewClick$6(AdInfoPoJo adInfoPoJo, Activity activity, View view) {
        adInfoPoJo.clickArea = "1";
        adInfoPoJo.PROGRESS = this.mediaView.getProgress();
        adInfoPoJo.PROGRESS_SEC = this.mediaView.getProgress() / 1000;
        adViewClickDispose(activity, adInfoPoJo);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$bindNativeView$2(Boolean bool) {
        if (bool.booleanValue()) {
            checkAdShowEvent();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$bindNativeView$3(Integer num) {
        AdInfoPoJo nativeAd = getNativeAd();
        if (nativeAd == null || num == null) {
            return;
        }
        nativeAd.maxShowRatio = num.intValue();
        if (num.intValue() >= 100) {
            getNativeAdView().unOnVisibilityRatioChanged();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$handleInclineView$9(AdInfoPoJo adInfoPoJo, ActionView.Type type, View view, int i, int i2, int i3) {
        adInfoPoJo.shake_x = i;
        adInfoPoJo.shake_y = i2;
        adInfoPoJo.shake_z = i3;
        List<View> list = this.clickViews;
        if (list != null && !list.isEmpty()) {
            for (View view2 : this.clickViews) {
                if (!(view2 instanceof RainTextureView)) {
                    adInfoPoJo.clickType = AdInfoPoJo.ClickType.SHAKE;
                    view2.performClick();
                    break;
                }
            }
        }
        if (type != ActionView.Type.Spread) {
            ViewHelper.removeParent(view);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$handleSharkView$8(AdInfoPoJo adInfoPoJo, ActionView.Type type, View view, int i, int i2, int i3) {
        adInfoPoJo.shake_x = i;
        adInfoPoJo.shake_y = i2;
        adInfoPoJo.shake_z = i3;
        List<View> list = this.clickViews;
        if (list != null && !list.isEmpty()) {
            for (View view2 : this.clickViews) {
                if (!(view2 instanceof RainTextureView)) {
                    adInfoPoJo.clickType = AdInfoPoJo.ClickType.SHAKE;
                    view2.performClick();
                    break;
                }
            }
        }
        if (type != ActionView.Type.Spread) {
            ViewHelper.removeParent(view);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$render$0(AdInfoPoJo adInfoPoJo, View view, int i, int i2, int i3) {
        adInfoPoJo.shake_x = i;
        adInfoPoJo.shake_y = i2;
        adInfoPoJo.shake_z = i3;
        List<View> list = this.clickViews;
        if (list != null && !list.isEmpty()) {
            for (View view2 : this.clickViews) {
                if (!(view2 instanceof RainTextureView)) {
                    adInfoPoJo.clickType = AdInfoPoJo.ClickType.SHAKE;
                    view2.performClick();
                    break;
                }
            }
        }
        ViewHelper.removeParent(view);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$render$1(View view) {
        LogcatUtil.d(TAG, "onAdClose");
        onAdCloseEvent();
    }

    @Override // com.fl.saas.base.bidding.BiddingResult
    public void biddingResult(final boolean z, final int i, final int i2, int i3) {
        getNativeAdOpt().ifPresent(new Consumer() { // from class: com.zj.adlib.gp7
            @Override // com.fl.saas.common.util.feature.Consumer
            public final void accept(Object obj) {
                S2SNative.lambda$biddingResult$7(i2, z, i, (AdInfoPoJo) obj);
            }
        });
    }

    /* JADX WARN: Code duplicated, block: B:75:0x014d A[PHI: r3
      0x014d: PHI (r3v36 android.view.View) = (r3v18 android.view.View), (r3v45 android.view.View) binds: [B:74:0x014b, B:29:0x007e] A[DONT_GENERATE, DONT_INLINE]] */
    @Override // com.fl.saas.base.innterNative.ActionView
    public View bindActionView(ActionView.Type type) {
        View fingerSlidingView;
        double d;
        View view;
        double d2;
        View templateShakesView;
        this.mType = type;
        final AdInfoPoJo nativeAd = getNativeAd();
        if (nativeAd == null || !nativeAd.isHotArea()) {
            return null;
        }
        if (nativeAd.getHotType() == 2 && DeviceUtil.deviceHasAccelerometerSensor) {
            if (type == ActionView.Type.Spread) {
                View spreadShakesView = getSpreadShakesView();
                this.tempActionView = spreadShakesView;
                if (spreadShakesView != null) {
                    int iDip2px = DeviceUtil.dip2px(280.0f);
                    int iDip2px2 = DeviceUtil.dip2px(80.0f);
                    if (nativeAd.scale_type != 0) {
                        iDip2px = DeviceUtil.dip2px(320.0f);
                        iDip2px2 = DeviceUtil.dip2px(100.0f);
                    }
                    FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(iDip2px, iDip2px2);
                    layoutParams.gravity = 81;
                    layoutParams.setMargins(0, 0, 0, DeviceUtil.dip2px(10.0f) * 3);
                    this.tempActionView.setLayoutParams(layoutParams);
                }
            } else {
                if (type == ActionView.Type.Interstitial) {
                    templateShakesView = getInterstitalShakesView();
                } else if (type == ActionView.Type.Template || type == ActionView.Type.Banner) {
                    templateShakesView = getTemplateShakesView();
                }
                this.tempActionView = templateShakesView;
            }
            view = this.tempActionView;
            if (view != null) {
                handleSharkView(view, type, nativeAd);
            }
        } else {
            if (nativeAd.getHotType() == 1 && type == ActionView.Type.Spread) {
                fingerSlidingView = getTipsView(nativeAd.scale_type);
            } else if (nativeAd.getHotType() == 4 && type == ActionView.Type.Spread && DeviceUtil.deviceHasAccelerometerSensor) {
                this.tempActionView = getSpreadInlineView();
                int mobileHeight = DeviceUtil.getMobileHeight();
                if (mobileHeight <= 0) {
                    mobileHeight = DeviceUtil.dip2px(900.0f);
                }
                double d3 = mobileHeight;
                int i = (int) (d3 * 0.2d);
                int i2 = nativeAd.scale_type;
                if (i2 == 1) {
                    d2 = d3 * 0.3d;
                } else {
                    if (i2 == 2) {
                        d2 = d3 * 0.4d;
                    }
                    FrameLayout.LayoutParams layoutParams2 = new FrameLayout.LayoutParams(-1, i);
                    layoutParams2.gravity = 81;
                    this.tempActionView.setLayoutParams(layoutParams2);
                    handleInclineView(this.tempActionView, type, nativeAd);
                }
                i = (int) d2;
                FrameLayout.LayoutParams layoutParams3 = new FrameLayout.LayoutParams(-1, i);
                layoutParams3.gravity = 81;
                this.tempActionView.setLayoutParams(layoutParams3);
                handleInclineView(this.tempActionView, type, nativeAd);
            } else if (nativeAd.getHotType() == 5) {
                if (type == ActionView.Type.Spread) {
                    fingerSlidingView = getSpreadSlidingView(nativeAd.scale_type, nativeAd.getShakeSpeed(), new FingerSlidingView.SlidingListener() { // from class: com.fl.saas.s2s.mixNative.S2SNative.3
                        @Override // com.fl.saas.base.widget.FingerSlidingView.SlidingListener
                        public void onDown(int i3, int i4, View view2) {
                            AdInfoPoJo adInfoPoJo = (AdInfoPoJo) S2SNative.this.getNativeAd();
                            if (adInfoPoJo == null) {
                                return;
                            }
                            adInfoPoJo.down_x = i3;
                            adInfoPoJo.down_y = i4;
                            int[] iArr = new int[2];
                            view2.getLocationOnScreen(iArr);
                            adInfoPoJo.abs_down_x = adInfoPoJo.down_x + iArr[0];
                            adInfoPoJo.abs_down_y = adInfoPoJo.down_y + iArr[1];
                            adInfoPoJo.DOWN_TIME = System.currentTimeMillis();
                        }

                        @Override // com.fl.saas.base.widget.FingerSlidingView.SlidingListener
                        public void onSliding() {
                            if (S2SNative.this.clickViews == null || S2SNative.this.clickViews.isEmpty()) {
                                return;
                            }
                            for (View view2 : S2SNative.this.clickViews) {
                                if (!(view2 instanceof RainTextureView)) {
                                    nativeAd.clickType = AdInfoPoJo.ClickType.SLIDE;
                                    view2.performClick();
                                    return;
                                }
                            }
                        }

                        @Override // com.fl.saas.base.widget.FingerSlidingView.SlidingListener
                        public void onUp(int i3, int i4, View view2) {
                            AdInfoPoJo adInfoPoJo = (AdInfoPoJo) S2SNative.this.getNativeAd();
                            if (adInfoPoJo == null) {
                                return;
                            }
                            adInfoPoJo.up_x = i3;
                            adInfoPoJo.up_y = i4;
                            int[] iArr = new int[2];
                            view2.getLocationOnScreen(iArr);
                            adInfoPoJo.abs_up_x = adInfoPoJo.up_x + iArr[0];
                            adInfoPoJo.abs_up_y = adInfoPoJo.up_y + iArr[1];
                            adInfoPoJo.UP_TIME = System.currentTimeMillis();
                        }
                    });
                }
            } else if (nativeAd.getHotType() == 6 && type == ActionView.Type.Spread && DeviceUtil.deviceHasAccelerometerSensor) {
                this.tempActionView = getAreaShakesView();
                int mobileHeight2 = DeviceUtil.getMobileHeight();
                if (mobileHeight2 <= 0) {
                    mobileHeight2 = DeviceUtil.dip2px(900.0f);
                }
                double d4 = mobileHeight2;
                int i3 = (int) (d4 * 0.2d);
                int i4 = nativeAd.scale_type;
                if (i4 == 1) {
                    d = d4 * 0.3d;
                } else if (i4 == 2) {
                    d = d4 * 0.4d;
                } else {
                    FrameLayout.LayoutParams layoutParams4 = new FrameLayout.LayoutParams(-1, i3);
                    layoutParams4.gravity = 80;
                    layoutParams4.setMargins(0, 0, 0, 0);
                    this.tempActionView.setLayoutParams(layoutParams4);
                    view = this.tempActionView;
                    if (view != null) {
                        handleSharkView(view, type, nativeAd);
                    }
                }
                i3 = (int) d;
                FrameLayout.LayoutParams layoutParams5 = new FrameLayout.LayoutParams(-1, i3);
                layoutParams5.gravity = 80;
                layoutParams5.setMargins(0, 0, 0, 0);
                this.tempActionView.setLayoutParams(layoutParams5);
                view = this.tempActionView;
                if (view != null) {
                    handleSharkView(view, type, nativeAd);
                }
            } else if (nativeAd.getHotType() == 7 && type == ActionView.Type.Spread && DeviceUtil.deviceHasAccelerometerSensor) {
                fingerSlidingView = getSpreadSlidingTwistingView(nativeAd.scale_type, true, nativeAd.getShakeSpeed(), new FingerSlidingAndTwistingView.SlidingListener() { // from class: com.fl.saas.s2s.mixNative.S2SNative.4
                    @Override // com.fl.saas.base.widget.FingerSlidingAndTwistingView.SlidingListener
                    public void onDown(int i5, int i6, View view2) {
                        AdInfoPoJo adInfoPoJo = (AdInfoPoJo) S2SNative.this.getNativeAd();
                        if (adInfoPoJo == null) {
                            return;
                        }
                        adInfoPoJo.down_x = i5;
                        adInfoPoJo.down_y = i6;
                        int[] iArr = new int[2];
                        view2.getLocationOnScreen(iArr);
                        adInfoPoJo.abs_down_x = adInfoPoJo.down_x + iArr[0];
                        adInfoPoJo.abs_down_y = adInfoPoJo.down_y + iArr[1];
                        adInfoPoJo.DOWN_TIME = System.currentTimeMillis();
                    }

                    @Override // com.fl.saas.base.widget.FingerSlidingAndTwistingView.SlidingListener
                    public void onShake(int i5, int i6, int i7) {
                        AdInfoPoJo adInfoPoJo = nativeAd;
                        adInfoPoJo.shake_x = i5;
                        adInfoPoJo.shake_y = i6;
                        adInfoPoJo.shake_z = i7;
                        if (S2SNative.this.clickViews == null || S2SNative.this.clickViews.isEmpty()) {
                            return;
                        }
                        for (View view2 : S2SNative.this.clickViews) {
                            if (!(view2 instanceof RainTextureView)) {
                                nativeAd.clickType = AdInfoPoJo.ClickType.SHAKE;
                                view2.performClick();
                                return;
                            }
                        }
                    }

                    @Override // com.fl.saas.base.widget.FingerSlidingAndTwistingView.SlidingListener
                    public void onSliding() {
                        if (S2SNative.this.clickViews == null || S2SNative.this.clickViews.isEmpty()) {
                            return;
                        }
                        for (View view2 : S2SNative.this.clickViews) {
                            if (!(view2 instanceof RainTextureView)) {
                                nativeAd.clickType = AdInfoPoJo.ClickType.SLIDE;
                                view2.performClick();
                                return;
                            }
                        }
                    }

                    @Override // com.fl.saas.base.widget.FingerSlidingAndTwistingView.SlidingListener
                    public void onUp(int i5, int i6, View view2) {
                        AdInfoPoJo adInfoPoJo = (AdInfoPoJo) S2SNative.this.getNativeAd();
                        if (adInfoPoJo == null) {
                            return;
                        }
                        adInfoPoJo.up_x = i5;
                        adInfoPoJo.up_y = i6;
                        int[] iArr = new int[2];
                        view2.getLocationOnScreen(iArr);
                        adInfoPoJo.abs_up_x = adInfoPoJo.up_x + iArr[0];
                        adInfoPoJo.abs_up_y = adInfoPoJo.up_y + iArr[1];
                        adInfoPoJo.UP_TIME = System.currentTimeMillis();
                    }
                });
            } else if (nativeAd.getHotType() == 8) {
                fingerSlidingView = getFingerSlidingView(nativeAd);
            }
            this.tempActionView = fingerSlidingView;
        }
        return this.tempActionView;
    }

    @Override // com.fl.saas.base.innterNative.BaseNativeAd
    public NativeMaterial createNativeMaterial(@NonNull AdInfoPoJo adInfoPoJo) {
        return S2SMixNativeHandler.adInfoToNativeMaterial(adInfoPoJo, this.mediaView);
    }

    @Override // com.fl.saas.base.innterNative.BaseNativeAd, com.fl.saas.api.mixNative.NativeAd
    public void destroy() {
        super.destroy();
        DeepLinkJumpUtil.getInstance().removeDeepLinkOpenListener();
        S2SVideoView s2SVideoView = this.mediaView;
        if (s2SVideoView != null) {
            s2SVideoView.onDestroy();
        }
        CommJumpHelper.getInstance().dismissDownLoadDialog();
    }

    @Override // com.fl.saas.api.mixNative.NativeAd
    @Nullable
    public NativeCustomizeVideo getCustomizeVideo() {
        final AdInfoPoJo nativeAd = getNativeAd();
        if (nativeAd == null || TextUtils.isEmpty(nativeAd.video_url) || nativeAd.creative.ctype != 2) {
            return null;
        }
        return new NativeCustomizeVideo() { // from class: com.fl.saas.s2s.mixNative.S2SNative.5
            @Override // com.fl.saas.api.mixNative.NativeCustomizeVideo, com.fl.saas.common.pojo.YdNativePojo.CustomizeVideo
            public String getVideoUrl() {
                return nativeAd.video_url;
            }

            @Override // com.fl.saas.api.mixNative.NativeCustomizeVideo, com.fl.saas.common.pojo.YdNativePojo.CustomizeVideo
            public void reportVideoAutoStart() {
            }

            @Override // com.fl.saas.api.mixNative.NativeCustomizeVideo, com.fl.saas.common.pojo.YdNativePojo.CustomizeVideo
            public void reportVideoBreak(long j) {
            }

            @Override // com.fl.saas.api.mixNative.NativeCustomizeVideo, com.fl.saas.common.pojo.YdNativePojo.CustomizeVideo
            public void reportVideoContinue(long j) {
                CommReportHelper.getInstance().reportVideoContinue(nativeAd);
            }

            @Override // com.fl.saas.api.mixNative.NativeCustomizeVideo, com.fl.saas.common.pojo.YdNativePojo.CustomizeVideo
            public void reportVideoError(long j, int i, int i2) {
            }

            @Override // com.fl.saas.api.mixNative.NativeCustomizeVideo, com.fl.saas.common.pojo.YdNativePojo.CustomizeVideo
            public void reportVideoFinish() {
                CommReportHelper.getInstance().reportVideoEnd(nativeAd, 0);
                S2SNative.this.onAdVideoEndEvent();
            }

            @Override // com.fl.saas.api.mixNative.NativeCustomizeVideo
            public void reportVideoFirst() {
                CommReportHelper.getInstance().reportVideoFirst(nativeAd);
            }

            @Override // com.fl.saas.api.mixNative.NativeCustomizeVideo, com.fl.saas.common.pojo.YdNativePojo.CustomizeVideo
            public void reportVideoPause(long j) {
                CommReportHelper.getInstance().reportVideoPause(nativeAd);
            }

            @Override // com.fl.saas.api.mixNative.NativeCustomizeVideo, com.fl.saas.common.pojo.YdNativePojo.CustomizeVideo
            public void reportVideoStart() {
            }

            @Override // com.fl.saas.api.mixNative.NativeCustomizeVideo
            public void reportVideoStart(long j) {
                int i = (int) (j / 1000);
                nativeAd.VIDEO_TIME = i;
                CommReportHelper.getInstance().reportVideoStart(nativeAd, i);
                S2SNative.this.onAdVideoStartEvent();
            }

            @Override // com.fl.saas.api.mixNative.NativeCustomizeVideo, com.fl.saas.common.pojo.YdNativePojo.CustomizeVideo
            public void reportVideoStartError(int i, int i2) {
            }

            @Override // com.fl.saas.api.mixNative.NativeCustomizeVideo
            public void reportVideoThird() {
                CommReportHelper.getInstance().reportVideoThird(nativeAd);
            }

            @Override // com.fl.saas.api.mixNative.NativeCustomizeVideo
            public void reportVideomMidpoint() {
                CommReportHelper.getInstance().reportVideomMidpoint(nativeAd);
            }
        };
    }

    @Override // com.fl.saas.ydsdk.api.MediaExtraInfo
    public String getMaterialJson() {
        if (getNativeAd() == null) {
            return "";
        }
        AdInfoPoJo nativeAd = getNativeAd();
        MediaReturnMaterialBean mediaReturnMaterialBean = new MediaReturnMaterialBean();
        mediaReturnMaterialBean.setImageUrl(nativeAd.img_url);
        mediaReturnMaterialBean.setVideoUrl(nativeAd.video_url);
        mediaReturnMaterialBean.setWidth(nativeAd.width);
        mediaReturnMaterialBean.setHeight(nativeAd.height);
        mediaReturnMaterialBean.setIcon(nativeAd.logo_icon);
        mediaReturnMaterialBean.setTitle(nativeAd.title);
        mediaReturnMaterialBean.setDesc(nativeAd.description);
        mediaReturnMaterialBean.setDeeplinkUrl(nativeAd.deep_url);
        mediaReturnMaterialBean.setLandingPageUrl(nativeAd.click_url);
        mediaReturnMaterialBean.setDownloadUrl(nativeAd.download_url);
        return new Yson().toJson(mediaReturnMaterialBean);
    }

    public void init() {
        createMediaView(getNativeAd());
    }

    @Override // com.fl.saas.base.innterNative.BaseNativeAd
    public void init(@NonNull AdInfoPoJo adInfoPoJo) {
    }

    @Override // com.fl.saas.api.mixNative.NativeAd
    public boolean isNativeExpress() {
        return false;
    }

    @Override // com.fl.saas.base.innterNative.BaseNativeAd, com.fl.saas.api.mixNative.NativeAd
    public boolean isShakeType() {
        AdSource adSource = this.mAdSource;
        return adSource != null && adSource.needShowShakeTips() && this.mType == null && DeviceUtil.deviceHasAccelerometerSensor;
    }

    @Override // com.fl.saas.common.listener.DeepLinkOpenListener
    public void onDeepLinkOpenFailed(Activity activity) {
        try {
            AdInfoPoJo nativeAd = getNativeAd();
            if (nativeAd == null || TextUtils.isEmpty(nativeAd.click_url)) {
                return;
            }
            nativeAd.dp_result = 1;
            nativeAd.dp_reason = 1;
            CommReportHelper.getInstance().reportDeepLinkFail(nativeAd);
            YdH5Activity.launchWithEnableQuickApp(activity, CommReportHelper.getInstance().gdtReplac(nativeAd.click_url, nativeAd), QuickAppHelper.getInstance().enableQuickApp(nativeAd.place_id));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override // com.fl.saas.base.innterNative.BaseNativeAd
    /* JADX INFO: renamed from: render, reason: avoid collision after fix types in other method and merged with bridge method [inline-methods] */
    public void lambda$prepare$0(AdInfoPoJo adInfoPoJo, NativePrepareInfo nativePrepareInfo) {
        final AdInfoPoJo nativeAd = getNativeAd();
        if (nativeAd == null) {
            onAdFailedEvent(YdError.create(20401, "S2SMixNative render but AdInfoPoJo is null"));
            return;
        }
        this.clickViews = nativePrepareInfo.getAllClickViews();
        AdSource adSource = this.mAdSource;
        if (adSource != null && adSource.needShowShakeTips() && this.mType == null && DeviceUtil.deviceHasAccelerometerSensor) {
            final View shakeTipsView = getShakeTipsView();
            if (this.clickViews == null) {
                this.clickViews = new ArrayList();
            }
            this.clickViews.add(shakeTipsView);
            ShakeView shakeView = (ShakeView) shakeTipsView.findViewById(R.id.yd_shake_view);
            shakeView.setCallback(false);
            shakeView.setShakeListener(nativeAd.getShakeSpeed(), new ShakeView.ShakeListener() { // from class: com.zj.adlib.ap7
                @Override // com.fl.saas.base.widget.ShakeView.ShakeListener
                public final void onShake(int i, int i2, int i3) {
                    this.f15327a.lambda$render$0(nativeAd, shakeTipsView, i, i2, i3);
                }
            });
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
            layoutParams.gravity = 17;
            if (nativePrepareInfo.isSelfRenderShake()) {
                shakeTipsView.setAlpha(0.0f);
            }
            getNativeAdView().addView(shakeTipsView, layoutParams);
        }
        AdSource adSource2 = this.mAdSource;
        if (adSource2 != null && adSource2.isLayerSlide() && this.mType == null) {
            getNativeAdView().addView(getFingerSlidingView(nativeAd), ViewHelper.getMatchParent());
        }
        bindNativeView();
        if (nativePrepareInfo.getCloseView() != null) {
            nativePrepareInfo.getCloseView().setOnClickListener(new View.OnClickListener() { // from class: com.zj.adlib.bp7
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    this.f40805a.lambda$render$1(view);
                }
            });
        }
        bindMediaViewClick(nativePrepareInfo.getActivity(), nativeAd);
        bindClickViews(nativePrepareInfo.getActivity(), nativeAd, nativePrepareInfo.getCtaViewList());
    }

    @Override // com.fl.saas.base.interfaces.AdChangeCacheData
    public void setCacheData(String str, AdSource adSource) {
        if (getNativeAd() != null) {
            getNativeAd().trackId = str;
            getNativeAd().place_id = adSource.place_id;
            getNativeAd().global_group_id = adSource.group_id;
            getNativeAd().global_place_id = adSource.place_id;
            getNativeAd().global_test_id = adSource.test_id;
        }
    }
}

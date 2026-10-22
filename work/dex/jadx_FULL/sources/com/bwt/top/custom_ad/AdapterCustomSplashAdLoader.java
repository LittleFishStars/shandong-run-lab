package com.bwt.top.custom_ad;

import android.annotation.SuppressLint;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.bwt.top.AdSdk;
import com.bwt.top.R;
import com.bwt.top.SplashAd;
import com.bwt.top.SplashAdListener;
import com.bwt.top.ad.adapter.AdapterAdLoaderImp;
import com.bwt.top.ad.adapter.AdapterCustomAdLoader;
import com.bwt.top.ad.bean.AdInfo;
import com.bwt.top.ad.bean.BasicAdInfoIpl;
import com.bwt.top.exception.AdError;
import com.bwt.top.h5.AdSdkH5Helper;
import com.bwt.top.image.ImageLoaderCallback;
import com.bwt.top.util.ALog;
import com.bwt.top.util.DisplayUtil;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_10_7392cls.dex */
public class AdapterCustomSplashAdLoader extends AdapterCustomAdLoader<AdInfo, SplashAdListener, SplashAd> {
    private AdCloseListener mCloseListener;
    private ImageView mImgView;
    private FrameLayout mLayoutClick;
    private View mLayoutSkip;
    private RelativeLayout mRootView;
    private TextView mTvCloseTime;
    private long mTemTime = 5;
    private int margin = DisplayUtil.dp2px(10);
    private Handler mCloseHandler = new Handler(Looper.getMainLooper()) { // from class: com.bwt.top.custom_ad.AdapterCustomSplashAdLoader.1
        @Override // android.os.Handler
        public void handleMessage(Message message) {
            super.handleMessage(message);
            try {
                if (message.what == 1) {
                    AdapterCustomSplashAdLoader.this.mTvCloseTime.setText(String.valueOf(AdapterCustomSplashAdLoader.this.mTemTime));
                    AdapterCustomSplashAdLoader adapterCustomSplashAdLoader = AdapterCustomSplashAdLoader.this;
                    adapterCustomSplashAdLoader.onAdTick(adapterCustomSplashAdLoader.mTemTime);
                    if (AdapterCustomSplashAdLoader.this.mTemTime == 0) {
                        AdapterCustomSplashAdLoader.this.adClose();
                    } else {
                        AdapterCustomSplashAdLoader.access$010(AdapterCustomSplashAdLoader.this);
                        AdapterCustomSplashAdLoader.this.mCloseHandler.sendEmptyMessageDelayed(1, 1000L);
                    }
                }
            } catch (Exception unused) {
            }
        }
    };

    public interface AdCloseListener {
        void onAdClose();
    }

    public static /* synthetic */ long access$010(AdapterCustomSplashAdLoader adapterCustomSplashAdLoader) {
        long j = adapterCustomSplashAdLoader.mTemTime;
        adapterCustomSplashAdLoader.mTemTime = j - 1;
        return j;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void ddksa(View view) {
        adSkip();
    }

    private void hiedAd() {
        RelativeLayout relativeLayout = this.mRootView;
        if (relativeLayout != null) {
            relativeLayout.setVisibility(8);
        }
        Handler handler = this.mCloseHandler;
        if (handler != null) {
            handler.removeCallbacksAndMessages(null);
            this.mCloseHandler = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void kdsksdda(View view) {
        adClick();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ boolean kdsksdda(View view, MotionEvent motionEvent) {
        if (motionEvent.getAction() != 0) {
            return false;
        }
        adClick();
        return true;
    }

    private void loadImg() {
        if (((SplashAd) this.mAd).getContainer().getVisibility() != 0) {
            ((SplashAd) this.mAd).getContainer().setVisibility(0);
        }
        this.mImageLoader.loadImage(this.mAdObject.getImgUrl(), this.mImgView, new ImageLoaderCallback() { // from class: com.bwt.top.custom_ad.AdapterCustomSplashAdLoader.3
            @Override // com.bwt.top.image.ImageLoaderCallback
            public void onError() {
                ALog.d(((AdapterAdLoaderImp) AdapterCustomSplashAdLoader.this).TAG, "load img onError");
                AdapterCustomSplashAdLoader.this.onAdFailedListener(new AdError(301, "loadImage error"));
            }

            @Override // com.bwt.top.image.ImageLoaderCallback
            public void onSuccess() {
                ALog.d(((AdapterAdLoaderImp) AdapterCustomSplashAdLoader.this).TAG, "load img success");
                AdapterCustomSplashAdLoader.this.onAdExposeListener();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void onAdTick(long j) {
        T t = this.mAd;
        if (t == 0 || ((SplashAd) t).getAdListener() == null) {
            return;
        }
        ((SplashAd) this.mAd).getAdListener().onAdTick(j);
    }

    private void preLoadImg(String str) {
        if (this.mImgView != null && !TextUtils.isEmpty(str)) {
            this.mImageLoader.preLoadImage(str, new ImageLoaderCallback() { // from class: com.bwt.top.custom_ad.AdapterCustomSplashAdLoader.4
                @Override // com.bwt.top.image.ImageLoaderCallback
                public void onError() {
                }

                @Override // com.bwt.top.image.ImageLoaderCallback
                public void onSuccess() {
                    AdapterCustomSplashAdLoader.this.onAdReadyListener();
                }
            });
            return;
        }
        onAdFailedListener(new AdError(10, "iv is null or imgUrl is empty" + str));
    }

    private void renderAd() {
        RelativeLayout container = ((SplashAd) this.mAd).getContainer();
        if (container != null) {
            container.addView(this.mRootView);
            ViewGroup viewGroup = (ViewGroup) container.getParent();
            if (viewGroup == null) {
                return;
            }
            if (viewGroup.getVisibility() != 0) {
                viewGroup.setVisibility(0);
            }
            for (int i = 0; i < viewGroup.getChildCount(); i++) {
                if (viewGroup.getChildAt(i) != container) {
                    viewGroup.removeViewAt(i);
                }
            }
            if (container.getVisibility() != 0) {
                container.setVisibility(0);
            }
        }
    }

    @SuppressLint({"ClickableViewAccessibility"})
    private void setAdClick() {
        if (this.mAdObject.isKeen()) {
            this.mLayoutSkip.setClickable(false);
            this.mLayoutClick.setOnTouchListener(new View.OnTouchListener() { // from class: com.zj.adlib.l00
                @Override // android.view.View.OnTouchListener
                public final boolean onTouch(View view, MotionEvent motionEvent) {
                    return this.f42956a.kdsksdda(view, motionEvent);
                }
            });
        } else {
            this.mLayoutClick.setOnClickListener(new View.OnClickListener() { // from class: com.zj.adlib.n00
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    this.f43418a.kdsksdda(view);
                }
            });
            this.mLayoutSkip.setOnClickListener(new View.OnClickListener() { // from class: com.zj.adlib.p00
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    this.f43866a.ddksa(view);
                }
            });
        }
    }

    private void setAdSize() {
        int widthPixels;
        int heightPixel;
        T t = this.mAd;
        if (t == 0 || ((SplashAd) t).getAdSize() == null) {
            widthPixels = -1;
            heightPixel = -1;
        } else {
            SplashAd.AdSize adSize = ((SplashAd) this.mAd).getAdSize();
            widthPixels = adSize.getWidthPixels();
            heightPixel = adSize.getHeightPixel();
            if (widthPixels <= 0 || heightPixel <= 0) {
                ALog.e(this.TAG, "set adsize fail ,width or height not 0");
                widthPixels = -1;
                heightPixel = -1;
            }
        }
        this.mRootView.setLayoutParams(new ViewGroup.LayoutParams(widthPixels, heightPixel));
    }

    private void setClickRect() {
        this.mRootView.post(new Runnable() { // from class: com.bwt.top.custom_ad.AdapterCustomSplashAdLoader.2
            @Override // java.lang.Runnable
            public void run() {
                AdapterCustomSplashAdLoader.this.mLayoutClick.getLayoutParams().height = AdapterCustomSplashAdLoader.this.mRootView.getMeasuredHeight() / 4;
            }
        });
    }

    private void setSkipViewMargin() {
        this.mLayoutSkip.setVisibility(0);
        if (((SplashAd) this.mAd).getSkipView() != null) {
            this.mLayoutSkip.setVisibility(8);
            View skipView = ((SplashAd) this.mAd).getSkipView();
            this.mLayoutSkip = skipView;
            this.mRootView.addView(skipView);
        }
        if (((SplashAd) this.mAd).isSkipViewTop()) {
            skipTopConfig();
        } else {
            skipBottomConfig();
        }
    }

    private void skipBottomConfig() {
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.mLayoutSkip.getLayoutParams();
        layoutParams.addRule(11);
        layoutParams.addRule(12);
        int i = this.margin;
        layoutParams.bottomMargin = i;
        layoutParams.rightMargin = i;
    }

    private void skipTopConfig() {
        int statusBarHeight = DisplayUtil.getStatusBarHeight(AdSdk.getInstance().getContext());
        int i = this.margin;
        if (((SplashAd) this.mAd).isImmersive()) {
            i += statusBarHeight;
        }
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.mLayoutSkip.getLayoutParams();
        layoutParams.addRule(11);
        layoutParams.topMargin = i;
        layoutParams.rightMargin = this.margin;
    }

    private void updateIcon() {
        if (this.mAdObject == null || this.mImageLoader == null || this.mAd == 0) {
            return;
        }
        ImageView imageView = (ImageView) this.mRootView.findViewById(R.id.iv_ad_icon);
        if (TextUtils.isEmpty(this.mAdObject.getIconUrl())) {
            return;
        }
        this.mImageLoader.loadIcon(this.mAdObject.getIconUrl(), imageView);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v0, types: [com.bwt.top.ad.bean.AdInfo] */
    public void adSkip() {
        if (hasAdListener()) {
            ((SplashAd) this.mAd).getAdListener().onAdSkip(getAdInfo());
        }
        adClose();
    }

    @Override // com.bwt.top.ad.adapter.AdapterAdLoaderImp
    public AdInfo createAdInfo() {
        return new BasicAdInfoIpl(this.mPosInfo, this);
    }

    @Override // com.bwt.top.ad.adapter.AdapterCustomAdLoader
    public void deeplinkSuccess() {
        super.deeplinkSuccess();
        adClose();
    }

    @Override // com.bwt.top.ad.adapter.AdapterCustomAdLoader
    public void readyAdView() {
        super.readyAdView();
        RelativeLayout relativeLayout = (RelativeLayout) View.inflate(getContext(), R.layout.layout_splash_custom, null);
        this.mRootView = relativeLayout;
        this.mImgView = (ImageView) relativeLayout.findViewById(R.id.iv);
        this.mLayoutSkip = this.mRootView.findViewById(R.id.layout_skip);
        this.mTvCloseTime = (TextView) this.mRootView.findViewById(R.id.tv_close_time);
        this.mLayoutClick = (FrameLayout) this.mRootView.findViewById(R.id.layout_click);
        setAdSize();
        setSkipViewMargin();
        setAdClick();
    }

    @Override // com.bwt.top.ad.adapter.AdapterAdLoaderImp
    public void renderView() {
        super.renderView();
        try {
            if (isShowAd()) {
                this.mTemTime = ((SplashAd) this.mAd).getSkipTime() / 1000;
                this.mCloseHandler.sendEmptyMessage(1);
                loadImg();
                renderAd();
                setClickRect();
                updateIcon();
            } else {
                preLoadImg(this.mAdObject.getImgUrl());
            }
        } catch (Throwable unused) {
        }
    }

    @Override // com.bwt.top.ad.adapter.AdapterAdLoaderImp
    public void runAdClose() {
        super.runAdClose();
        AdSdkH5Helper.releaseSplashAdListener();
        hiedAd();
    }

    @Override // com.bwt.top.ad.adapter.AdapterCustomAdLoader
    public void skipAd() {
        if (this.mAdObject == null) {
            return;
        }
        String jumpUrl = getJumpUrl();
        if (TextUtils.isEmpty(jumpUrl)) {
            return;
        }
        if (this.mCloseListener == null) {
            this.mCloseListener = new AdCloseListener() { // from class: com.bwt.top.custom_ad.AdapterCustomSplashAdLoader.5
                @Override // com.bwt.top.custom_ad.AdapterCustomSplashAdLoader.AdCloseListener
                public void onAdClose() {
                    AdapterCustomSplashAdLoader.this.adClose();
                }
            };
        }
        Handler handler = this.mCloseHandler;
        if (handler != null) {
            handler.removeCallbacksAndMessages(null);
            this.mCloseHandler = null;
        }
        AdSdkH5Helper.skipSplashH5Callback(getContext(), jumpUrl, this.mAdObject.isDownload(), this.mCloseListener);
    }
}

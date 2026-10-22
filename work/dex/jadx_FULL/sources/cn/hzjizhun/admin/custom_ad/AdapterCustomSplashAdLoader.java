package cn.hzjizhun.admin.custom_ad;

import android.annotation.SuppressLint;
import android.graphics.Color;
import android.graphics.drawable.GradientDrawable;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import cn.hzjizhun.admin.JZAdSdk;
import cn.hzjizhun.admin.R;
import cn.hzjizhun.admin.ad.adapter.AdapterAdLoaderImp;
import cn.hzjizhun.admin.ad.adapter.AdapterCustomAdLoader;
import cn.hzjizhun.admin.ad.bean.AdSize;
import cn.hzjizhun.admin.ad.bean.BasicJZAdInfoIpl;
import cn.hzjizhun.admin.ad.bean.Cs;
import cn.hzjizhun.admin.ad.bean.JZAdInfo;
import cn.hzjizhun.admin.ad.impl.JZSplashAd;
import cn.hzjizhun.admin.ad.listener.JZSplashAdListener;
import cn.hzjizhun.admin.custom_ad.http.CustomAdPosResult;
import cn.hzjizhun.admin.exception.JZAdError;
import cn.hzjizhun.admin.h5.AdSdkH5Helper;
import cn.hzjizhun.admin.image.ImageLoaderCallback;
import cn.hzjizhun.admin.util.ALog;
import cn.hzjizhun.admin.util.DisplayUtil;
import com.bumptech.glide.Glide;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public class AdapterCustomSplashAdLoader extends AdapterCustomAdLoader<JZAdInfo, JZSplashAdListener, JZSplashAd> {
    private FrameLayout flShake;
    private ImageView ivShake;
    private AdCloseListener mCloseListener;
    private ImageView mImgView;
    private FrameLayout mLayoutClick;
    private View mLayoutSkip;
    private RelativeLayout mRootView;
    private TextView mTvCloseTime;
    private long mTemTime = 5;
    private int margin = DisplayUtil.dp2px(10);
    private Handler mCloseHandler = new Handler(Looper.getMainLooper()) { // from class: cn.hzjizhun.admin.custom_ad.AdapterCustomSplashAdLoader.1
        @Override // android.os.Handler
        public void handleMessage(Message message) {
            super.handleMessage(message);
            try {
                if (message.what == 1) {
                    if (AdapterCustomSplashAdLoader.this.mTemTime < 0) {
                        AdapterCustomSplashAdLoader.this.adClose();
                        return;
                    }
                    AdapterCustomSplashAdLoader.this.mTvCloseTime.setText("(" + AdapterCustomSplashAdLoader.this.mTemTime + ")");
                    AdapterCustomSplashAdLoader adapterCustomSplashAdLoader = AdapterCustomSplashAdLoader.this;
                    adapterCustomSplashAdLoader.onAdTick(adapterCustomSplashAdLoader.mTemTime);
                    AdapterCustomSplashAdLoader.access$010(AdapterCustomSplashAdLoader.this);
                    AdapterCustomSplashAdLoader.this.mCloseHandler.sendEmptyMessageDelayed(1, 1000L);
                }
            } catch (Throwable unused) {
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

    private void hiedAd() {
        Handler handler = this.mCloseHandler;
        if (handler != null) {
            handler.removeCallbacksAndMessages(null);
            this.mCloseHandler = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$setAdClick$0(View view) {
        adClickSource(Cs.KC);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$setAdClick$1(View view) {
        adClickSource(Cs.KC);
        adSkip();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$setAdClick$2(View view) {
        adClickSource(Cs.MC);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$setAdClick$3(View view) {
        adSkip();
    }

    private void loadImg() {
        if (((JZSplashAd) this.mAd).getContainer().getVisibility() != 0) {
            ((JZSplashAd) this.mAd).getContainer().setVisibility(0);
        }
        this.mImageLoader.loadImage(this.mAdObject.getImgUrl(), this.mImgView, new ImageLoaderCallback() { // from class: cn.hzjizhun.admin.custom_ad.AdapterCustomSplashAdLoader.3
            @Override // cn.hzjizhun.admin.image.ImageLoaderCallback
            public void onError() {
                ALog.d(((AdapterAdLoaderImp) AdapterCustomSplashAdLoader.this).TAG, "load img onError");
                AdapterCustomSplashAdLoader.this.onAdFailedListener(new JZAdError(302, "loadImage error"));
            }

            @Override // cn.hzjizhun.admin.image.ImageLoaderCallback
            public void onSuccess() {
                ALog.d(((AdapterAdLoaderImp) AdapterCustomSplashAdLoader.this).TAG, "load img success");
                AdapterCustomSplashAdLoader.this.onAdExposeListener();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void onAdTick(long j) {
        T t = this.mAd;
        if (t == 0 || ((JZSplashAd) t).getAdListener() == null) {
            return;
        }
        ((JZSplashAd) this.mAd).getAdListener().onAdTick(j);
    }

    private void preLoadImg(String str) {
        if (this.mImgView != null && !TextUtils.isEmpty(str)) {
            this.mImageLoader.preLoadImage(str, new ImageLoaderCallback() { // from class: cn.hzjizhun.admin.custom_ad.AdapterCustomSplashAdLoader.4
                @Override // cn.hzjizhun.admin.image.ImageLoaderCallback
                public void onError() {
                }

                @Override // cn.hzjizhun.admin.image.ImageLoaderCallback
                public void onSuccess() {
                    AdapterCustomSplashAdLoader.this.onAdReadyListener();
                }
            });
            return;
        }
        onAdFailedListener(new JZAdError(10, "iv is null or imgUrl is empty" + str));
    }

    private void renderAd() {
        RelativeLayout container = ((JZSplashAd) this.mAd).getContainer();
        if (container != null) {
            container.addView(this.mRootView);
            setParentVisible(container);
            ViewGroup viewGroup = (ViewGroup) container.getParent();
            if (viewGroup == null) {
                return;
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
            this.mImgView.setOnClickListener(new View.OnClickListener() { // from class: com.zj.adlib.m00
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    this.f43192a.lambda$setAdClick$0(view);
                }
            });
            this.mLayoutSkip.setOnClickListener(new View.OnClickListener() { // from class: com.zj.adlib.o00
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    this.f43637a.lambda$setAdClick$1(view);
                }
            });
        } else {
            this.mLayoutClick.setOnClickListener(new View.OnClickListener() { // from class: com.zj.adlib.q00
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    this.f44093a.lambda$setAdClick$2(view);
                }
            });
            this.mLayoutSkip.setOnClickListener(new View.OnClickListener() { // from class: com.zj.adlib.r00
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    this.f44333a.lambda$setAdClick$3(view);
                }
            });
        }
    }

    private void setAdSize() {
        int widthPixels;
        int heightPixel;
        T t = this.mAd;
        if (t == 0 || ((JZSplashAd) t).getAdSize() == null) {
            widthPixels = -1;
            heightPixel = -1;
        } else {
            AdSize adSize = ((JZSplashAd) this.mAd).getAdSize();
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
        this.mRootView.post(new Runnable() { // from class: cn.hzjizhun.admin.custom_ad.AdapterCustomSplashAdLoader.2
            @Override // java.lang.Runnable
            public void run() {
                int measuredHeight = (int) (AdapterCustomSplashAdLoader.this.mRootView.getMeasuredHeight() * 0.1f);
                ((RelativeLayout.LayoutParams) AdapterCustomSplashAdLoader.this.mLayoutClick.getLayoutParams()).height = measuredHeight;
                GradientDrawable gradientDrawable = new GradientDrawable();
                gradientDrawable.setShape(0);
                gradientDrawable.setCornerRadius(measuredHeight * 0.25f);
                gradientDrawable.setColor(Color.parseColor("#33000000"));
                AdapterCustomSplashAdLoader.this.mLayoutClick.setBackground(gradientDrawable);
            }
        });
    }

    private void setParentVisible(ViewGroup viewGroup) {
        try {
            ViewGroup viewGroup2 = (ViewGroup) viewGroup.getParent();
            if (viewGroup2 != null && viewGroup2.getId() != 16908290) {
                if (viewGroup2.getVisibility() != 0) {
                    viewGroup2.setVisibility(0);
                }
                setParentVisible(viewGroup2);
            }
        } catch (Throwable unused) {
        }
    }

    private void setSkipViewMargin() {
        this.mLayoutSkip.setVisibility(0);
        if (((JZSplashAd) this.mAd).getSkipView() != null) {
            this.mLayoutSkip.setVisibility(8);
            View skipView = ((JZSplashAd) this.mAd).getSkipView();
            this.mLayoutSkip = skipView;
            this.mRootView.addView(skipView);
        }
        JZSplashAd.SkipGravity skipGravity = ((JZSplashAd) this.mAd).getSkipGravity();
        if (((JZSplashAd) this.mAd).isSkipViewTop()) {
            skipGravity = JZSplashAd.SkipGravity.RIGHT_TOP;
        }
        if (skipGravity == JZSplashAd.SkipGravity.LEFT_TOP) {
            skipTopConfig(false);
            return;
        }
        if (skipGravity == JZSplashAd.SkipGravity.LEFT_BOTTOM) {
            skipBottomConfig(false);
        } else if (skipGravity == JZSplashAd.SkipGravity.RIGHT_TOP) {
            skipTopConfig(true);
        } else {
            skipBottomConfig(true);
        }
    }

    private void skipBottomConfig(boolean z) {
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.mLayoutSkip.getLayoutParams();
        layoutParams.addRule(10, 0);
        layoutParams.addRule(12);
        if (z) {
            layoutParams.addRule(9, 0);
            layoutParams.addRule(11);
        } else {
            layoutParams.addRule(11, 0);
            layoutParams.addRule(9);
        }
        int i = this.margin;
        layoutParams.bottomMargin = i;
        layoutParams.rightMargin = i;
    }

    private void skipTopConfig(boolean z) {
        int statusBarHeight = DisplayUtil.getStatusBarHeight(JZAdSdk.getInstance().getContext());
        int i = this.margin;
        if (((JZSplashAd) this.mAd).isImmersive()) {
            i += statusBarHeight;
        }
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.mLayoutSkip.getLayoutParams();
        layoutParams.addRule(10);
        layoutParams.addRule(12, 0);
        if (z) {
            layoutParams.addRule(9, 0);
            layoutParams.addRule(11);
        } else {
            layoutParams.addRule(11, 0);
            layoutParams.addRule(9);
        }
        layoutParams.topMargin = i;
        layoutParams.rightMargin = this.margin;
    }

    private void updateIcon() {
        if (this.mAdObject == null || this.mImageLoader == null || this.mAd == 0) {
            return;
        }
        this.mImageLoader.loadIcon(this.mAdObject.getIconUrl(), (ImageView) this.mRootView.findViewById(R.id.iv_ad_icon));
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v0, types: [cn.hzjizhun.admin.ad.bean.JZAdInfo] */
    public void adSkip() {
        if (hasAdListener()) {
            ((JZSplashAd) this.mAd).getAdListener().onAdSkip(getAdInfo());
        }
        adClose();
    }

    @Override // cn.hzjizhun.admin.ad.adapter.AdapterAdLoaderImp
    public JZAdInfo createAdInfo() {
        return new BasicJZAdInfoIpl(this.mPosInfo, this);
    }

    @Override // cn.hzjizhun.admin.ad.adapter.AdapterCustomAdLoader
    public void deeplinkSuccess() {
        super.deeplinkSuccess();
        adClose();
    }

    @Override // cn.hzjizhun.admin.ad.adapter.AdapterCustomAdLoader, cn.hzjizhun.admin.ad.adapter.AdapterAdLoaderImp
    public void onAdReceiveListener() {
        super.onAdReceiveListener();
        CustomAdPosResult customAdPosResult = this.mAdObject;
        if (customAdPosResult == null || customAdPosResult.getAcceleration() <= 0) {
            return;
        }
        this.flShake.setVisibility(0);
        Glide.with(this.ivShake).asGif().load(Integer.valueOf(R.drawable.jz_icon_splash_shake)).into(this.ivShake);
    }

    @Override // cn.hzjizhun.admin.ad.adapter.AdapterCustomAdLoader
    public void readyAdView() {
        super.readyAdView();
        RelativeLayout relativeLayout = (RelativeLayout) View.inflate(getContext(), R.layout.jz_layout_splash_custom, null);
        this.mRootView = relativeLayout;
        this.mImgView = (ImageView) relativeLayout.findViewById(R.id.iv);
        this.mLayoutSkip = this.mRootView.findViewById(R.id.layout_skip);
        this.mTvCloseTime = (TextView) this.mRootView.findViewById(R.id.tv_close_time);
        this.mLayoutClick = (FrameLayout) this.mRootView.findViewById(R.id.layout_click);
        this.flShake = (FrameLayout) this.mRootView.findViewById(R.id.flShake);
        this.ivShake = (ImageView) this.mRootView.findViewById(R.id.ivShake);
        setAdSize();
        setSkipViewMargin();
        setAdClick();
    }

    @Override // cn.hzjizhun.admin.ad.adapter.AdapterAdLoaderImp
    public void renderView() {
        super.renderView();
        try {
            if (!isShowAd()) {
                preLoadImg(this.mAdObject.getImgUrl());
                return;
            }
            this.mTemTime = ((JZSplashAd) this.mAd).getSkipTime() / 1000;
            this.mCloseHandler.sendEmptyMessage(1);
            loadImg();
            renderAd();
            setClickRect();
            updateIcon();
        } catch (Throwable unused) {
        }
    }

    @Override // cn.hzjizhun.admin.ad.adapter.AdapterAdLoaderImp
    public void runAdClose() {
        super.runAdClose();
        AdSdkH5Helper.releaseSplashAdListener();
        hiedAd();
    }

    @Override // cn.hzjizhun.admin.ad.adapter.AdapterCustomAdLoader
    public void skipAd() {
        if (this.mAdObject == null || TextUtils.isEmpty(getJumpUrl())) {
            return;
        }
        if (this.mCloseListener == null) {
            this.mCloseListener = new AdCloseListener() { // from class: cn.hzjizhun.admin.custom_ad.AdapterCustomSplashAdLoader.5
                @Override // cn.hzjizhun.admin.custom_ad.AdapterCustomSplashAdLoader.AdCloseListener
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
        AdSdkH5Helper.skipSplashH5Callback(new AdSdkH5Helper.SkipH5Params(getContext(), this.mAdObject, this.mReport), this.mCloseListener);
    }
}

package com.bwt.top.custom_ad;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.text.TextUtils;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ImageView;
import com.bwt.top.InterstitialAd;
import com.bwt.top.InterstitialAdListener;
import com.bwt.top.R;
import com.bwt.top.ad.adapter.AdapterAdLoaderImp;
import com.bwt.top.ad.adapter.AdapterCustomAdLoader;
import com.bwt.top.ad.bean.InterstitialAdInfo;
import com.bwt.top.ad.bean.kdsksdda;
import com.bwt.top.custom_ad.http.CustomAdPosResult;
import com.bwt.top.exception.AdError;
import com.bwt.top.image.ImageLoaderCallback;
import com.bwt.top.util.ALog;
import com.bwt.top.view.AdDialog;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_10_7392cls.dex */
public class AdapterCustomInterstitialAdLoader extends AdapterCustomAdLoader<InterstitialAdInfo, InterstitialAdListener, InterstitialAd> {
    private ImageView iconIv;
    private AdDialog mAdDialog;
    private ImageView mCloseIv;
    private View mContentView;
    private boolean mIsShow;
    private ImageView mPicIv;

    private void autoClose() {
        T t = this.mAd;
        if (t == 0 || ((InterstitialAd) t).getCloseTime() <= 0) {
            return;
        }
        ((InterstitialAd) this.mAd).getCloseHandler().postDelayed(new Runnable() { // from class: com.zj.adlib.b00
            @Override // java.lang.Runnable
            public final void run() {
                this.f40646a.kdsksdda();
            }
        }, ((InterstitialAd) this.mAd).getCloseTime());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void kdsksdda() {
        adClose();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ boolean kdsksdda(View view, MotionEvent motionEvent) {
        if (motionEvent.getAction() != 0) {
            return false;
        }
        adClick();
        return true;
    }

    @SuppressLint({"ClickableViewAccessibility"})
    private boolean keenClick() {
        CustomAdPosResult customAdPosResult = this.mAdObject;
        if (customAdPosResult == null || !customAdPosResult.isKeen() || this.mPicIv == null) {
            return false;
        }
        this.mAdDialog.setCancelable(false);
        ImageView imageView = this.mCloseIv;
        if (imageView != null) {
            imageView.setClickable(false);
        }
        this.mPicIv.setOnTouchListener(new View.OnTouchListener() { // from class: com.zj.adlib.d00
            @Override // android.view.View.OnTouchListener
            public final boolean onTouch(View view, MotionEvent motionEvent) {
                return this.f41077a.kdsksdda(view, motionEvent);
            }
        });
        return true;
    }

    @SuppressLint({"ClickableViewAccessibility"})
    private void setClick() {
        if (keenClick()) {
            return;
        }
        ImageView imageView = this.mPicIv;
        if (imageView != null) {
            imageView.setOnClickListener(new View.OnClickListener() { // from class: com.bwt.top.custom_ad.AdapterCustomInterstitialAdLoader.4
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    AdapterCustomInterstitialAdLoader.this.adClick();
                }
            });
        }
        ImageView imageView2 = this.mCloseIv;
        if (imageView2 != null) {
            imageView2.setOnClickListener(new View.OnClickListener() { // from class: com.bwt.top.custom_ad.AdapterCustomInterstitialAdLoader.5
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    AdapterCustomInterstitialAdLoader.this.adClose();
                }
            });
        }
    }

    private void updateIcon() {
        CustomAdPosResult customAdPosResult = this.mAdObject;
        if (customAdPosResult == null || this.mImageLoader == null || this.mAd == 0 || TextUtils.isEmpty(customAdPosResult.getIconUrl())) {
            return;
        }
        this.mImageLoader.loadIcon(this.mAdObject.getIconUrl(), this.iconIv);
    }

    @Override // com.bwt.top.ad.adapter.AdapterCustomAdLoader, com.bwt.top.ad.adapter.AdapterAdLoaderImp
    public void adClick() {
        try {
            super.adClick();
        } finally {
            adClose();
        }
    }

    @Override // com.bwt.top.ad.adapter.AdapterAdLoaderImp
    public InterstitialAdInfo createAdInfo() {
        return new kdsksdda(this.mPosInfo, this) { // from class: com.bwt.top.custom_ad.AdapterCustomInterstitialAdLoader.2
            @Override // com.bwt.top.ad.bean.InterstitialAdInfo
            public boolean hasExpired() {
                return isReleased();
            }

            @Override // com.bwt.top.ad.bean.InterstitialAdInfo
            public boolean hasShown() {
                return AdapterCustomInterstitialAdLoader.this.mIsShow;
            }

            @Override // com.bwt.top.ad.bean.InterstitialAdInfo
            public void showInterstitial(Activity activity) {
                AdapterCustomInterstitialAdLoader.this.showInterstitialAd(activity);
            }
        };
    }

    @Override // com.bwt.top.ad.adapter.AdapterCustomAdLoader
    public void readyAdView() {
        super.readyAdView();
        View viewInflate = View.inflate(getContext(), R.layout.layout_channel_insert, null);
        this.mContentView = viewInflate;
        this.mPicIv = (ImageView) viewInflate.findViewById(R.id.channel_insert_pic_iv);
        this.mCloseIv = (ImageView) this.mContentView.findViewById(R.id.channel_insert_close_iv);
        this.iconIv = (ImageView) this.mContentView.findViewById(R.id.iv_ad_icon);
    }

    @Override // com.bwt.top.ad.adapter.AdapterCustomAdLoader, com.bwt.top.ad.adapter.AdapterAdLoaderImp, com.bwt.top.ad.adapter.AdapterAdLoader
    public void release() {
        super.release();
        T t = this.mAd;
        if (t != 0 && ((InterstitialAd) t).getCloseHandler() != null) {
            ((InterstitialAd) this.mAd).getCloseHandler().removeCallbacksAndMessages(null);
        }
        AdDialog adDialog = this.mAdDialog;
        if (adDialog != null) {
            adDialog.dismiss();
            this.mAdDialog = null;
            this.mPicIv = null;
            this.mCloseIv = null;
        }
    }

    @Override // com.bwt.top.ad.adapter.AdapterAdLoaderImp
    public void renderView() {
        super.renderView();
        this.mImageLoader.preLoadImage(this.mAdObject.getImgUrl(), new ImageLoaderCallback() { // from class: com.bwt.top.custom_ad.AdapterCustomInterstitialAdLoader.1
            @Override // com.bwt.top.image.ImageLoaderCallback
            public void onError() {
            }

            @Override // com.bwt.top.image.ImageLoaderCallback
            public void onSuccess() {
                if (((AdapterAdLoaderImp) AdapterCustomInterstitialAdLoader.this).mAd == null || ((InterstitialAd) ((AdapterAdLoaderImp) AdapterCustomInterstitialAdLoader.this).mAd).getAdListener() == null) {
                    return;
                }
                ((InterstitialAd) ((AdapterAdLoaderImp) AdapterCustomInterstitialAdLoader.this).mAd).getAdListener().onAdReady((InterstitialAdInfo) AdapterCustomInterstitialAdLoader.this.getAdInfo());
            }
        });
        updateIcon();
    }

    @Override // com.bwt.top.ad.adapter.AdapterAdLoaderImp
    public void runAdClose() {
        super.runAdClose();
        try {
            AdDialog adDialog = this.mAdDialog;
            if (adDialog == null || !adDialog.isShowing()) {
                return;
            }
            this.mAdDialog.dismiss();
        } catch (Exception unused) {
        }
    }

    public void showInterstitialAd(Activity activity) {
        ALog.d(this.TAG, "showInterstitial");
        if (this.mIsShow) {
            return;
        }
        this.mIsShow = true;
        AdDialog adDialog = new AdDialog(activity);
        this.mAdDialog = adDialog;
        adDialog.setContentView(this.mContentView);
        autoClose();
        this.mAdDialog.show();
        setClick();
        this.mImageLoader.loadImage(this.mAdObject.getImgUrl(), this.mPicIv, new ImageLoaderCallback() { // from class: com.bwt.top.custom_ad.AdapterCustomInterstitialAdLoader.3
            @Override // com.bwt.top.image.ImageLoaderCallback
            public void onError() {
                AdapterCustomInterstitialAdLoader.this.onAdFailedListener(new AdError(301, "preload img failed"));
            }

            @Override // com.bwt.top.image.ImageLoaderCallback
            public void onSuccess() {
                AdapterCustomInterstitialAdLoader.this.onAdExposeListener();
            }
        });
    }
}

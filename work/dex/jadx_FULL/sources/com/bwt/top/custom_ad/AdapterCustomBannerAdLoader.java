package com.bwt.top.custom_ad;

import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import androidx.annotation.NonNull;
import com.bwt.top.BannerAd;
import com.bwt.top.BannerAdListener;
import com.bwt.top.R;
import com.bwt.top.ServiceAd;
import com.bwt.top.ad.adapter.AdapterCustomAdLoader;
import com.bwt.top.ad.bean.AdInfo;
import com.bwt.top.ad.bean.BasicAdInfoIpl;
import com.bwt.top.exception.AdError;
import com.bwt.top.image.ImageLoaderCallback;
import com.bwt.top.util.ALog;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_10_7392cls.dex */
public class AdapterCustomBannerAdLoader extends AdapterCustomAdLoader<AdInfo, BannerAdListener, BannerAd> {
    private RelativeLayout mBannerView;
    private ImageView mCloseImgView;
    private ImageView mImgView;

    private void addAdView(@NonNull View view) {
        T t = this.mAd;
        if (t == 0 || ((BannerAd) t).getContainer() == null) {
            ALog.i(this.TAG, "addAdView is failed ");
            return;
        }
        RelativeLayout container = ((BannerAd) this.mAd).getContainer();
        if (container != null) {
            container.addView(view);
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

    private void closeEvent() {
        try {
            ImageView imageView = (ImageView) this.mBannerView.findViewById(R.id.channel_banner_close_iv);
            this.mCloseImgView = imageView;
            imageView.setVisibility(((BannerAd) this.mAd).isShowCloseView() ? 0 : 8);
            this.mCloseImgView.setOnClickListener(new View.OnClickListener() { // from class: com.zj.adlib.zz
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    this.f46371a.kdsksdda(view);
                }
            });
        } catch (Exception unused) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void kdsksdda(View view) {
        RelativeLayout relativeLayout = this.mBannerView;
        if (relativeLayout != null) {
            relativeLayout.setVisibility(8);
        }
        onAdCloseListener();
    }

    private void preImgView(String str) {
        if (this.mImgView != null && !TextUtils.isEmpty(str)) {
            this.mImageLoader.preLoadImage(str, new ImageLoaderCallback() { // from class: com.bwt.top.custom_ad.AdapterCustomBannerAdLoader.3
                @Override // com.bwt.top.image.ImageLoaderCallback
                public void onError() {
                }

                @Override // com.bwt.top.image.ImageLoaderCallback
                public void onSuccess() {
                    AdapterCustomBannerAdLoader.this.onAdReadyListener();
                }
            });
            return;
        }
        onAdFailedListener(new AdError(10, "iv is null or imgUrl is empty" + str));
    }

    private void renderImgView(String str) {
        if (this.mImgView != null && !TextUtils.isEmpty(str)) {
            this.mImageLoader.loadImage(str, this.mImgView, new ImageLoaderCallback() { // from class: com.bwt.top.custom_ad.AdapterCustomBannerAdLoader.2
                @Override // com.bwt.top.image.ImageLoaderCallback
                public void onError() {
                    AdapterCustomBannerAdLoader.this.onAdFailedListener(new AdError(301, "loadImage error"));
                }

                @Override // com.bwt.top.image.ImageLoaderCallback
                public void onSuccess() {
                    AdapterCustomBannerAdLoader.this.onAdExposeListener();
                }
            });
            return;
        }
        onAdFailedListener(new AdError(10, "iv is null or imgUrl is empty" + str));
    }

    private void updateIcon() {
        RelativeLayout relativeLayout;
        if (this.mAdObject == null || this.mImageLoader == null || (relativeLayout = this.mBannerView) == null || (this.mAd instanceof ServiceAd)) {
            return;
        }
        ImageView imageView = (ImageView) relativeLayout.findViewById(R.id.channel_banner_ic_iv);
        imageView.setVisibility(0);
        if (TextUtils.isEmpty(this.mAdObject.getIconUrl())) {
            return;
        }
        this.mImageLoader.loadIcon(this.mAdObject.getIconUrl(), imageView);
    }

    @Override // com.bwt.top.ad.adapter.AdapterAdLoaderImp
    public AdInfo createAdInfo() {
        return new BasicAdInfoIpl(this.mPosInfo, this);
    }

    @Override // com.bwt.top.ad.adapter.AdapterCustomAdLoader
    public void readyAdView() {
        RelativeLayout relativeLayout = (RelativeLayout) View.inflate(getContext(), R.layout.layout_channel_banner, null);
        this.mBannerView = relativeLayout;
        this.mImgView = (ImageView) relativeLayout.findViewById(R.id.channel_banner_iv);
        closeEvent();
        this.mBannerView.setOnClickListener(new View.OnClickListener() { // from class: com.bwt.top.custom_ad.AdapterCustomBannerAdLoader.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                AdapterCustomBannerAdLoader.this.adClick();
            }
        });
    }

    @Override // com.bwt.top.ad.adapter.AdapterAdLoaderImp
    public void renderView() {
        super.renderView();
        try {
            if (this.mBannerView == null) {
                return;
            }
            String imgUrl = this.mAdObject.getImgUrl();
            if (isShowAd()) {
                addAdView(this.mBannerView);
                renderImgView(imgUrl);
                updateIcon();
            } else {
                preImgView(imgUrl);
            }
        } catch (Throwable unused) {
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v0, types: [com.bwt.top.ad.bean.AdInfo] */
    @Override // com.bwt.top.ad.adapter.AdapterCustomAdLoader
    public void skipH5Listener(String str) {
        super.skipH5Listener(str);
        T t = this.mAd;
        if (t == 0 || ((BannerAd) t).getAdListener() == null) {
            return;
        }
        ((BannerAd) this.mAd).getAdListener().onAdClick(getAdInfo(), str);
    }
}

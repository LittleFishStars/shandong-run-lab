package com.fl.saas.base.inner.banner;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import com.fl.saas.api.mixNative.NativeAdView;
import com.fl.saas.api.mixNative.NativeMaterial;
import com.fl.saas.base.inner.InnerNativeCustomView;
import com.fl.saas.base.inner.InnerNativeView;
import com.fl.saas.base.inner.banner.customView.BannerSingleImgView;
import com.fl.saas.common.util.Check;
import com.fl.saas.common.util.ImageLoader;
import com.fl.saas.common.util.ViewHelper;
import com.fl.saas.common.util.feature.Consumer;
import com.fl.saas.config.exception.YdError;
import com.fl.saas.config.utils.DeviceUtil;
import com.fl.saas.s2s.R;
import java.util.Objects;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_08_10593cls.dex */
public class BannerViewHelper implements InnerNativeView {
    private final FrameLayout bannerContainer;
    private final int height;
    private final ImageView mAdLogo;
    private InnerNativeCustomView mBannerView;
    private final Context mContext;
    private final BannerViewEvent mEvent;
    private final NativeMaterial material;
    private NativeAdView nativeAdView;
    private final int width;

    public BannerViewHelper(Context context, NativeMaterial nativeMaterial, int i, int i2, BannerViewEvent bannerViewEvent) {
        this.mContext = context;
        this.material = nativeMaterial;
        this.width = i;
        this.height = i2;
        this.mEvent = bannerViewEvent;
        FrameLayout frameLayout = (FrameLayout) ViewHelper.inflate(context, R.layout.yd_saas_banner);
        this.bannerContainer = frameLayout;
        this.mAdLogo = (ImageView) frameLayout.findViewById(R.id.iv_ad_logo);
        frameLayout.findViewById(R.id.iv_close).setOnClickListener(new View.OnClickListener() { // from class: com.zj.adlib.ol0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f43771a.lambda$new$0(view);
            }
        });
        loadView();
    }

    private void bindMediaView(InnerNativeCustomView innerNativeCustomView, Drawable drawable) {
        try {
            this.mBannerView.setTitle(this.material.getTitle()).setCAT(this.material.getCallToAction()).setDes(this.material.getDescription());
        } catch (Exception unused) {
        }
        innerNativeCustomView.setMediaView((this.material.getAdType() != 3 || this.material.getAdMediaView() == null) ? null : this.material.getAdMediaView(), drawable);
        this.bannerContainer.addView(this.mBannerView.getAdView(), 0, ViewHelper.getMatchParent());
        loadAdIcon();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$loadView$1(Drawable drawable) {
        bindMediaView(this.mBannerView, drawable);
        if (DeviceUtil.filling_timing != 0) {
            this.mEvent.onLoaded(this);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$new$0(View view) {
        this.mEvent.onDismiss();
    }

    private void loadAdIcon() {
        if (this.material.getAdLogo() != null) {
            this.mAdLogo.setImageBitmap(this.material.getAdLogo());
        } else {
            if (TextUtils.isEmpty(this.material.getAdLogoUrl())) {
                return;
            }
            ImageLoader.loadImage(this.material.getAdLogoUrl(), this.mAdLogo);
        }
    }

    private void loadView() {
        View adMediaView = this.material.getAdMediaView();
        String mainImageUrl = !TextUtils.isEmpty(this.material.getMainImageUrl()) ? this.material.getMainImageUrl() : (String) Check.findFirstNonNull(this.material.getImageUrlList());
        if (TextUtils.isEmpty(mainImageUrl)) {
            if (adMediaView == null) {
                this.mEvent.onAdFailed(YdError.create(20405, "media and imgUrl is empty"));
                return;
            }
            BannerSingleImgView bannerSingleImgView = new BannerSingleImgView(this.mContext, this.width, this.height);
            this.mBannerView = bannerSingleImgView;
            bindMediaView(bannerSingleImgView, null);
            this.mEvent.onLoaded(this);
            return;
        }
        this.mBannerView = new BannerSingleImgView(this.mContext, this.width, this.height);
        if (DeviceUtil.filling_timing == 0) {
            this.mEvent.onLoaded(this);
        }
        Consumer consumer = new Consumer() { // from class: com.zj.adlib.ql0
            @Override // com.fl.saas.common.util.feature.Consumer
            public final void accept(Object obj) {
                this.f44235a.lambda$loadView$1((Drawable) obj);
            }
        };
        final BannerViewEvent bannerViewEvent = this.mEvent;
        Objects.requireNonNull(bannerViewEvent);
        ImageLoader.loadImageDrawable(mainImageUrl, consumer, new Consumer() { // from class: com.zj.adlib.rl0
            @Override // com.fl.saas.common.util.feature.Consumer
            public final void accept(Object obj) {
                bannerViewEvent.onAdFailed((YdError) obj);
            }
        });
    }

    @Override // com.fl.saas.base.inner.InnerNativeView
    public View getCATView() {
        return null;
    }

    @Override // com.fl.saas.base.inner.InnerNativeView
    public View[] getClicks() {
        return new View[]{this.mBannerView.getAdView()};
    }

    @Override // com.fl.saas.base.inner.InnerNativeView
    public NativeAdView getNativeAdView() {
        if (this.nativeAdView == null) {
            ViewGroup.LayoutParams layoutParams = new ViewGroup.LayoutParams(this.width, this.height);
            NativeAdView nativeAdView = new NativeAdView(this.mContext);
            this.nativeAdView = nativeAdView;
            nativeAdView.setLayoutParams(layoutParams);
            this.nativeAdView.removeAllViews();
            this.nativeAdView.addView(getSelfView(), layoutParams);
        }
        return this.nativeAdView;
    }

    @Override // com.fl.saas.base.inner.InnerNativeView
    public ViewGroup getSelfView() {
        return this.bannerContainer;
    }

    @Override // com.fl.saas.base.inner.InnerNativeView
    public void onClicked() {
    }
}

package com.kc.dw.gather.ks.splash;

import android.content.Context;
import android.content.DialogInterface;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.kc.dw.ad.splash.SplashSkipView;
import com.kc.dw.ad.splash.SsdSplashRootView;
import com.kc.dw.core.ad.SsdAdSlot;
import com.kc.dw.core.bquery.d;
import com.kc.dw.core.exception.b;
import com.kc.dw.core.safe.j;
import com.kc.dw.core.utils.LogUtil;
import com.kc.dw.core.utils.SdkHandler;
import com.kc.dw.core.view.gif.GifImageView;
import com.kc.dw.platform.custom.CustomInfo;
import com.kc.dw.platform.custom.splash.MsCustomSplashAdapter;
import com.kc.openset.R;
import com.kwad.sdk.api.KsAdSDK;
import com.kwad.sdk.api.KsAdVideoPlayConfig;
import com.kwad.sdk.api.KsImage;
import com.kwad.sdk.api.KsLoadManager;
import com.kwad.sdk.api.KsNativeAd;
import com.kwad.sdk.api.KsScene;
import com.qihoo.SdkProtected.OSETSDK.Keep;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
@Keep
public class KSFeedSplashAdapter extends MsCustomSplashAdapter {
    private static final String TAG = "KSFeedSplashAdapter";
    private SsdSplashRootView adRoot;
    private boolean showed;
    private SplashSkipView splashSkipView;

    /* JADX INFO: renamed from: com.kc.dw.gather.ks.splash.KSFeedSplashAdapter$1, reason: invalid class name */
    @Keep
    public class AnonymousClass1 implements KsLoadManager.NativeAdListener {
        public final KSFeedSplashAdapter this$0;

        public AnonymousClass1(KSFeedSplashAdapter kSFeedSplashAdapter) {
            this.this$0 = kSFeedSplashAdapter;
        }

        @Override // com.kwad.sdk.api.KsLoadManager.NativeAdListener
        public void onError(int i, String str) {
            this.this$0.callLoadedError(i, str);
        }

        @Override // com.kwad.sdk.api.KsLoadManager.NativeAdListener
        public void onNativeAdLoad(List<KsNativeAd> list) {
            try {
                if (list == null) {
                    LogUtil.e(KSFeedSplashAdapter.TAG, "onNativeAdLoad ksNativeAdList is null");
                    this.this$0.callLoadedError(b.i.intValue(), "onNativeAdLoad ksNativeAdList is null");
                } else {
                    KsNativeAd ksNativeAd = list.get(0);
                    this.this$0.sdkAdInfo.setEcpm(String.valueOf(ksNativeAd.getECPM()));
                    SdkHandler.getInstance().runOnUiThread(new j(this, ksNativeAd) { // from class: com.kc.dw.gather.ks.splash.KSFeedSplashAdapter.1.1
                        public final AnonymousClass1 this$1;
                        public final KsNativeAd val$ksNativeAd;

                        {
                            this.this$1 = this;
                            this.val$ksNativeAd = ksNativeAd;
                        }

                        @Override // com.kc.dw.core.safe.j
                        public void safeRun() {
                            this.this$1.this$0.callLoadedSuccess();
                            this.this$1.this$0.showNativeSplash(this.val$ksNativeAd);
                        }
                    });
                }
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void showNativeSplash(KsNativeAd ksNativeAd) {
        SsdSplashRootView ssdSplashRootView = (SsdSplashRootView) LayoutInflater.from(this.context).inflate(R.layout.ssd_layout_native_splash, (ViewGroup) null);
        this.adRoot = ssdSplashRootView;
        LinearLayout linearLayout = (LinearLayout) this.adRoot.findViewById(R.id.ssd_layout_native_splash_ll);
        RelativeLayout relativeLayout = (RelativeLayout) this.adRoot.findViewById(R.id.activity_sdk_splash_mediaContainer);
        GifImageView gifImageView = (GifImageView) this.adRoot.findViewById(R.id.layout_native_splash_imageview);
        TextView textView = (TextView) this.adRoot.findViewById(R.id.layout_native_splash_title);
        ImageView imageView = (ImageView) this.adRoot.findViewById(R.id.layout_native_splash_icon);
        ImageView imageView2 = (ImageView) this.adRoot.findViewById(R.id.layout_native_splash_score);
        TextView textView2 = (TextView) this.adRoot.findViewById(R.id.layout_native_splash_desc);
        TextView textView3 = (TextView) this.adRoot.findViewById(R.id.ssd_layout_native_splash_cid);
        TextView textView4 = (TextView) this.adRoot.findViewById(R.id.ssd_jump_btn);
        Drawable drawable = this.context.getResources().getDrawable(R.drawable.ssd_ksad_sdk_logo);
        int i = 0;
        drawable.setBounds(0, 0, drawable.getMinimumWidth(), drawable.getMinimumHeight());
        textView3.setCompoundDrawables(drawable, null, null, null);
        d dVar = new d(this.adRoot);
        if (TextUtils.isEmpty(ksNativeAd.getAdDescription())) {
            textView2.setVisibility(8);
            imageView2.setVisibility(0);
        } else {
            textView2.setVisibility(0);
            textView2.setText(ksNativeAd.getAdDescription());
        }
        if (TextUtils.isEmpty(ksNativeAd.getAppName())) {
            textView.setVisibility(8);
            imageView2.setVisibility(8);
        } else {
            textView.setVisibility(0);
            textView.setText(ksNativeAd.getAppName());
        }
        if (TextUtils.isEmpty(ksNativeAd.getAppIconUrl())) {
            imageView.setVisibility(8);
        } else {
            imageView.setVisibility(0);
            dVar.d = imageView;
            dVar.a(ksNativeAd.getAppIconUrl(), false);
        }
        textView4.setText(ksNativeAd.getInteractionType() != 1 ? "点击或摇动了解详情" : "点击下载");
        ArrayList arrayList = new ArrayList();
        arrayList.add(linearLayout);
        ksNativeAd.registerViewForInteraction(linearLayout, arrayList, new KsNativeAd.AdInteractionListener(this) { // from class: com.kc.dw.gather.ks.splash.KSFeedSplashAdapter.2
            public final KSFeedSplashAdapter this$0;

            {
                this.this$0 = this;
            }

            @Override // com.kwad.sdk.api.KsNativeAd.AdInteractionListener
            public boolean handleDownloadDialog(DialogInterface.OnClickListener onClickListener) {
                return false;
            }

            @Override // com.kwad.sdk.api.KsNativeAd.AdInteractionListener
            public void onAdClicked(View view, KsNativeAd ksNativeAd2) {
                this.this$0.callAdClicked();
            }

            @Override // com.kwad.sdk.api.KsNativeAd.AdInteractionListener
            public void onAdShow(KsNativeAd ksNativeAd2) {
                this.this$0.callAdExposure();
            }

            @Override // com.kwad.sdk.api.KsNativeAd.AdInteractionListener
            public void onDownloadTipsDialogDismiss() {
            }

            @Override // com.kwad.sdk.api.KsNativeAd.AdInteractionListener
            public void onDownloadTipsDialogShow() {
            }
        });
        DisplayMetrics displayMetrics = this.context.getResources().getDisplayMetrics();
        int i2 = (int) (displayMetrics.widthPixels - (displayMetrics.density * 70.0f));
        if (ksNativeAd.getMaterialType() == 1) {
            View videoView = ksNativeAd.getVideoView(this.context, new KsAdVideoPlayConfig.Builder().videoSoundEnable(false).build());
            if (videoView != null) {
                relativeLayout.removeAllViews();
                int videoWidth = ksNativeAd.getVideoWidth();
                int videoHeight = ksNativeAd.getVideoHeight();
                if (videoWidth > 0 && videoHeight > 0) {
                    int i3 = (videoHeight * i2) / videoWidth;
                }
                relativeLayout.addView(videoView, -1, -1);
            }
        } else {
            List<KsImage> imageList = ksNativeAd.getImageList();
            if (imageList != null && imageList.size() > 0) {
                KsImage ksImage = imageList.get(0);
                int width = ksImage.getWidth();
                int height = ksImage.getHeight();
                String imageUrl = imageList.get(0).getImageUrl();
                dVar.d = gifImageView;
                dVar.a(imageUrl, false);
                if (width > 0 && height > 0) {
                    i = (height * i2) / width;
                }
                ViewGroup.LayoutParams layoutParams = gifImageView.getLayoutParams();
                layoutParams.height = i;
                layoutParams.width = -1;
                gifImageView.setLayoutParams(layoutParams);
            }
        }
        showSkipView(this.adRoot);
    }

    private void showSkipView(SsdSplashRootView ssdSplashRootView) {
        this.splashSkipView = (SplashSkipView) ssdSplashRootView.findViewById(R.id.ssd_skipView);
        this.splashSkipView.setOnSkipListener(new SplashSkipView.b(this) { // from class: com.kc.dw.gather.ks.splash.KSFeedSplashAdapter.3
            public final KSFeedSplashAdapter this$0;

            {
                this.this$0 = this;
            }

            @Override // com.kc.dw.ad.splash.SplashSkipView.b
            public void onSkip() {
                this.this$0.callAdSkip();
            }

            @Override // com.kc.dw.ad.splash.SplashSkipView.b
            public void onTick(long j) {
                this.this$0.callAdTick(j);
            }

            @Override // com.kc.dw.ad.splash.SplashSkipView.b
            public void onTimeOver() {
                this.this$0.callAdTimeOver();
            }
        });
    }

    @Override // com.kc.dw.platform.custom.splash.MsCustomSplashAdapter
    public void loadCustomAd(Context context, SsdAdSlot ssdAdSlot, CustomInfo customInfo) {
        try {
            KsAdSDK.getLoadManager().loadNativeAd(new KsScene.Builder(Long.parseLong(getSdkAdInfo().getPid())).adNum(1).build(), new AnonymousClass1(this));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override // com.kc.dw.platform.custom.splash.MsCustomSplashAdapter
    public void showAd(ViewGroup viewGroup) {
        try {
            if (this.showed || this.adRoot == null) {
                return;
            }
            viewGroup.removeAllViews();
            viewGroup.addView(this.adRoot, -1, -1);
            this.showed = true;
            SplashSkipView splashSkipView = this.splashSkipView;
            if (splashSkipView != null) {
                splashSkipView.c();
            }
        } catch (Throwable th) {
            Integer num = b.f39252a;
            callRenderError(200007, "show ad error");
            th.printStackTrace();
        }
    }
}

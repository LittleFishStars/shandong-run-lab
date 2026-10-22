package com.meishu.sdk.activity;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Matrix;
import android.graphics.drawable.Drawable;
import android.media.MediaMetadataRetriever;
import android.os.Bundle;
import android.os.Handler;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.mobads.sdk.api.NativeResponse;
import com.kwad.sdk.api.KsAdVideoPlayConfig;
import com.kwad.sdk.api.KsImage;
import com.kwad.sdk.api.KsNativeAd;
import com.meishu.sdk.R;
import com.meishu.sdk.core.ad.AdType;
import com.meishu.sdk.core.ad.IAd;
import com.meishu.sdk.core.bquery.d;
import com.meishu.sdk.core.bquery.i;
import com.meishu.sdk.core.bquery.j;
import com.meishu.sdk.core.domain.HttpResponse;
import com.meishu.sdk.core.exception.ErrorCodeUtil;
import com.meishu.sdk.core.safe.SafeActivity;
import com.meishu.sdk.core.safe.l;
import com.meishu.sdk.core.safe.o;
import com.meishu.sdk.core.utils.DownloadDialogBean;
import com.meishu.sdk.core.utils.LogUtil;
import com.meishu.sdk.core.utils.SdkHandler;
import com.meishu.sdk.core.utils.a0;
import com.meishu.sdk.core.utils.f;
import com.meishu.sdk.core.utils.f0;
import com.meishu.sdk.core.utils.h;
import com.meishu.sdk.core.utils.h0;
import com.meishu.sdk.core.utils.j0;
import com.meishu.sdk.core.utils.y;
import com.meishu.sdk.core.view.DownloadView;
import com.meishu.sdk.core.view.TouchAdContainer;
import com.meishu.sdk.core.view.TouchPositionListener;
import com.meishu.sdk.core.view.gif.GifImageView;
import com.meishu.sdk.meishu_ad.interstitial.b;
import com.meishu.sdk.meishu_ad.interstitial.c;
import com.meishu.sdk.meishu_ad.nativ.NormalMediaView;
import com.meishu.sdk.meishu_ad.nativ.e;
import com.meishu.sdk.platform.BasePlatformLoader;
import com.meishu.sdk.platform.ms.splash.ShakeResult;
import com.meishu.sdk.platform.ms.splash.ShakeUtil;
import com.qq.e.ads.cfg.VideoOption;
import com.qq.e.ads.nativ.MediaView;
import com.qq.e.ads.nativ.NativeADEventListener;
import com.qq.e.ads.nativ.NativeADMediaListener;
import com.qq.e.ads.nativ.NativeUnifiedADAppMiitInfo;
import com.qq.e.ads.nativ.NativeUnifiedADData;
import com.qq.e.ads.nativ.widget.NativeAdContainer;
import com.qq.e.comm.util.AdError;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_01_2010cls.dex */
public class SdkInterstitialActivity extends SafeActivity {
    private static final String TAG = "SdkInterstitialActivity";
    private static com.meishu.sdk.meishu_ad.interstitial.a adListener;
    private static BasePlatformLoader adWrapper;
    private static IAd msAd;
    private static Object sdkAd;
    private int act_type = 2;
    private ImageView adLogo;
    private LinearLayout adLogoLL;
    private TextView btn;
    private TextView cid;
    private ImageView closeImage;
    private TextView desc;
    private DownloadDialogBean downloadBean;
    private ImageView imageBg;
    private GifImageView imageView;
    private boolean isClickToClose;
    private boolean isDownloadType;
    private boolean isShake;
    private boolean isVideoAutoPlay;
    private int layout_height;
    private int layout_type;
    private int layout_width;
    private ImageView logo;
    private RelativeLayout mediaContainer;
    private RelativeLayout rl_container;
    private RelativeLayout rootView;
    private int shakeId;
    private boolean showed;
    private GifImageView startActionShakeImage;
    private TextView title;
    private TouchAdContainer touchAdContainer;
    private View view;

    /* JADX INFO: renamed from: com.meishu.sdk.activity.SdkInterstitialActivity$7, reason: invalid class name */
    public class AnonymousClass7 implements j<File> {
        public final /* synthetic */ b val$adSlot;
        public final /* synthetic */ c val$sdkAd;

        public AnonymousClass7(c cVar, b bVar) {
            this.val$sdkAd = cVar;
            this.val$adSlot = bVar;
        }

        public void onFail(int i, String str) {
        }

        public void onSuccess(String str, File file) {
            try {
                if (file.length() >= j0.a()) {
                    return;
                }
                this.val$sdkAd.i = System.currentTimeMillis();
                DisplayMetrics displayMetrics = SdkInterstitialActivity.this.getResources().getDisplayMetrics();
                float f = displayMetrics.widthPixels;
                float f2 = displayMetrics.density;
                int i = (int) (f - (70.0f * f2));
                int i2 = (int) (f2 * 200.0f);
                try {
                    if (SdkInterstitialActivity.this.layout_type == 2) {
                        i2 = (int) (((((double) displayMetrics.widthPixels) * 0.86d) * ((double) SdkInterstitialActivity.this.layout_height)) / ((double) SdkInterstitialActivity.this.layout_width));
                        i = (int) (((double) displayMetrics.widthPixels) * 0.86d);
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
                final View normalMediaView = new NormalMediaView(SdkInterstitialActivity.this);
                normalMediaView.setContainerWidth(i);
                normalMediaView.setContainerHeight(i2);
                normalMediaView.setPlayOnce(true);
                normalMediaView.g();
                normalMediaView.setUseTransform(false);
                normalMediaView.setFromLogoVisibility(8);
                normalMediaView.setFromLogo((String) null);
                normalMediaView.setNativeAdMediaListener(new e() { // from class: com.meishu.sdk.activity.SdkInterstitialActivity.7.1
                    public void onProgressUpdate(long j, long j2) {
                    }

                    public void onVideoComplete() {
                    }

                    public void onVideoError() {
                        LogUtil.d(SdkInterstitialActivity.TAG, "onVideoError");
                    }

                    public void onVideoLoaded() {
                        LogUtil.e(SdkInterstitialActivity.TAG, "onADLoaded");
                        AnonymousClass7.this.val$sdkAd.i = System.currentTimeMillis();
                        normalMediaView.post(new l() { // from class: com.meishu.sdk.activity.SdkInterstitialActivity.7.1.1
                            public void safeRun() {
                                SdkInterstitialActivity.this.showed = true;
                                AnonymousClass7.this.val$sdkAd.d();
                                AnonymousClass7 anonymousClass7 = AnonymousClass7.this;
                                SdkInterstitialActivity.this.startShake(anonymousClass7.val$adSlot);
                            }
                        });
                    }

                    public void onVideoMute() {
                    }

                    public void onVideoOneHalf() {
                    }

                    public void onVideoOneQuarter() {
                    }

                    public void onVideoPause() {
                    }

                    public void onVideoReplay() {
                    }

                    public void onVideoResume() {
                    }

                    public void onVideoStart() {
                    }

                    public void onVideoThreeQuarter() {
                    }

                    public void onVideoUnmute() {
                    }
                });
                SdkInterstitialActivity.this.mediaContainer.removeAllViews();
                normalMediaView.setVideoPath(file.getAbsolutePath());
                if (this.val$adSlot.getScale_type() == 9) {
                    normalMediaView.setDisplayMode(2);
                    SdkInterstitialActivity.this.mediaContainer.addView(normalMediaView, -1, -1);
                } else {
                    normalMediaView.setDisplayMode(1);
                    RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -2);
                    layoutParams.addRule(13, -1);
                    SdkInterstitialActivity.this.mediaContainer.addView(normalMediaView, layoutParams);
                }
                SdkInterstitialActivity.this.imageBg.setVisibility(0);
                ExecutorService executorService = h0.a;
                h0.b.a.a(new l() { // from class: com.meishu.sdk.activity.SdkInterstitialActivity.7.2
                    public void safeRun() {
                        try {
                            final Bitmap videoThumb = normalMediaView.getVideoThumb();
                            if (videoThumb != null) {
                                SdkHandler.getInstance().runOnUiThread(new l() { // from class: com.meishu.sdk.activity.SdkInterstitialActivity.7.2.1
                                    public void safeRun() {
                                        try {
                                            Bitmap bitmap = videoThumb;
                                            if (bitmap != null) {
                                                Bitmap.Config config = bitmap.getConfig();
                                                Bitmap.Config config2 = Bitmap.Config.ARGB_8888;
                                                Bitmap bitmapCopy = config == config2 ? videoThumb : videoThumb.copy(config2, true);
                                                if (bitmapCopy != null) {
                                                    SdkInterstitialActivity.this.getApplicationContext();
                                                    Bitmap bitmapA = f0.a(bitmapCopy, 25);
                                                    if (bitmapA != null) {
                                                        SdkInterstitialActivity.this.imageBg.setImageBitmap(bitmapA);
                                                    }
                                                }
                                            }
                                        } catch (Throwable th) {
                                            th.printStackTrace();
                                        }
                                    }
                                });
                            }
                        } catch (Throwable th) {
                            th.printStackTrace();
                        }
                    }
                });
                normalMediaView.start();
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }
    }

    private void fullHeightImage(Bitmap bitmap, ImageView imageView, int i, int i2, int i3) {
        int i4;
        int width = bitmap.getWidth();
        int height = bitmap.getHeight();
        float f = (i2 * 1.0f) / height;
        Matrix matrix = new Matrix();
        matrix.postScale(f, f);
        Bitmap bitmapCreateBitmap = Bitmap.createBitmap(bitmap, 0, 0, width, height, matrix, false);
        bitmapCreateBitmap.getHeight();
        int width2 = bitmapCreateBitmap.getWidth();
        if (width2 < i) {
            imageView.setScaleType(ImageView.ScaleType.CENTER);
        } else {
            if (i3 == 6 || i3 == 2 || i3 == 1) {
                i4 = (width2 - i) / 2;
            } else {
                i4 = (i3 != 7 && i3 == 8) ? width2 - i : 0;
            }
            imageView.setScaleType(ImageView.ScaleType.MATRIX);
            bitmapCreateBitmap = Bitmap.createBitmap(bitmapCreateBitmap, i4, 0, i, i2, (Matrix) null, false);
        }
        imageView.setImageBitmap(bitmapCreateBitmap);
    }

    private void fullWidthImage(Bitmap bitmap, GifImageView gifImageView, int i, int i2, int i3) {
        int i4;
        int width = bitmap.getWidth();
        int height = bitmap.getHeight();
        float f = (i * 1.0f) / width;
        gifImageView.setScaleType(ImageView.ScaleType.MATRIX);
        Matrix matrix = new Matrix();
        matrix.postScale(f, f);
        Bitmap bitmapCreateBitmap = Bitmap.createBitmap(bitmap, 0, 0, width, height, matrix, false);
        int height2 = bitmapCreateBitmap.getHeight();
        bitmapCreateBitmap.getWidth();
        if (height2 < i2) {
            gifImageView.setScaleType(ImageView.ScaleType.CENTER);
        } else {
            if (i3 == 3 || i3 == 2 || i3 == 1) {
                i4 = (height2 - i2) / 2;
            } else {
                i4 = (i3 != 4 && i3 == 5) ? height2 - i2 : 0;
            }
            gifImageView.setScaleType(ImageView.ScaleType.MATRIX);
            bitmapCreateBitmap = Bitmap.createBitmap(bitmapCreateBitmap, 0, i4, i, i2, (Matrix) null, false);
        }
        gifImageView.setImageBitmap(bitmapCreateBitmap);
    }

    private String getBDImageUrl(NativeResponse nativeResponse) {
        try {
            String imageUrl = nativeResponse.getImageUrl();
            if (!TextUtils.isEmpty(imageUrl)) {
                return imageUrl;
            }
            List multiPicUrls = nativeResponse.getMultiPicUrls();
            if (multiPicUrls == null || multiPicUrls.size() <= 0) {
                return "";
            }
            String str = (String) multiPicUrls.get(0);
            return !TextUtils.isEmpty(str) ? str : "";
        } catch (Throwable th) {
            th.printStackTrace();
            return "";
        }
    }

    private byte[] getImageBytes(Context context, int i) {
        try {
            InputStream inputStreamOpenRawResource = context.getResources().openRawResource(i);
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            byte[] bArr = new byte[4096];
            while (true) {
                int i2 = inputStreamOpenRawResource.read(bArr);
                if (-1 == i2) {
                    return byteArrayOutputStream.toByteArray();
                }
                byteArrayOutputStream.write(bArr, 0, i2);
            }
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    private String getImageUrl(NativeUnifiedADData nativeUnifiedADData) {
        try {
            if (TextUtils.isEmpty(nativeUnifiedADData.getImgUrl())) {
                return (nativeUnifiedADData.getImgList() == null || nativeUnifiedADData.getImgList().size() <= 0) ? "" : (String) nativeUnifiedADData.getImgList().get(0);
            }
            return nativeUnifiedADData.getImgUrl();
        } catch (Throwable th) {
            th.printStackTrace();
            return "";
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    private void handleBdAd() {
        final NativeResponse nativeResponse = (NativeResponse) sdkAd;
        if (nativeResponse.getAdActionType() == 2) {
            this.isDownloadType = true;
        }
        DownloadDialogBean downloadDialogBean = new DownloadDialogBean();
        this.downloadBean = downloadDialogBean;
        downloadDialogBean.setApp_name(nativeResponse.getBrandName());
        this.downloadBean.setApp_ver(nativeResponse.getAppVersion());
        this.downloadBean.setApp_size(((nativeResponse.getAppSize() / 1024) * 1024) + "MB");
        this.downloadBean.setDeveloper(nativeResponse.getPublisher());
        this.downloadBean.setApp_permission_url(nativeResponse.getAppPermissionLink());
        this.downloadBean.setApp_private_agreement(nativeResponse.getAppPrivacyLink());
        this.downloadBean.setApp_intro(nativeResponse.getDesc());
        this.title.setText(nativeResponse.getTitle());
        this.desc.setText(nativeResponse.getDesc());
        i iVar = new i(this);
        if (!TextUtils.isEmpty(nativeResponse.getBaiduLogoUrl())) {
            ((com.meishu.sdk.core.bquery.e) iVar).d = this.adLogo;
            iVar.a(nativeResponse.getBaiduLogoUrl(), false);
        }
        if (!TextUtils.isEmpty(nativeResponse.getIconUrl())) {
            ((com.meishu.sdk.core.bquery.e) iVar).d = this.logo;
            iVar.a(nativeResponse.getIconUrl(), false);
        }
        if (nativeResponse.getAdActionType() != 2) {
            this.btn.setText("点击查看详情");
        } else {
            this.btn.setText("点击下载");
        }
        try {
            if (nativeResponse.getMaterialType().equals(NativeResponse.MaterialType.VIDEO)) {
                ExecutorService executorService = h0.a;
                h0.b.a.a(new l() { // from class: com.meishu.sdk.activity.SdkInterstitialActivity.12
                    public void safeRun() {
                        try {
                            MediaMetadataRetriever mediaMetadataRetriever = new MediaMetadataRetriever();
                            mediaMetadataRetriever.setDataSource(nativeResponse.getVideoUrl());
                            final Bitmap frameAtTime = mediaMetadataRetriever.getFrameAtTime();
                            if (frameAtTime != null) {
                                SdkHandler.getInstance().runOnUiThread(new l() { // from class: com.meishu.sdk.activity.SdkInterstitialActivity.12.1
                                    public void safeRun() {
                                        SdkInterstitialActivity.this.imageView.setImageBitmap(frameAtTime);
                                    }
                                });
                            }
                        } catch (Throwable th) {
                            th.printStackTrace();
                        }
                    }
                });
            } else {
                String bDImageUrl = getBDImageUrl(nativeResponse);
                ((com.meishu.sdk.core.bquery.e) iVar).d = this.imageView;
                iVar.a(bDImageUrl, false);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        ArrayList arrayList = new ArrayList();
        arrayList.add(this.rl_container);
        nativeResponse.registerViewForInteraction(this.rl_container, arrayList, (List) null, new NativeResponse.AdInteractionListener() { // from class: com.meishu.sdk.activity.SdkInterstitialActivity.13
            public void adActReward(int i) {
            }

            public void adActRewardSuccess() {
            }

            public void onADExposed() {
                try {
                    if (SdkInterstitialActivity.this.showed) {
                        return;
                    }
                    if (SdkInterstitialActivity.adWrapper.getLoaderListener() != null) {
                        SdkInterstitialActivity.adWrapper.getLoaderListener().onAdExposure();
                    }
                    if (SdkInterstitialActivity.msAd != null && SdkInterstitialActivity.msAd.getInteractionListener() != null) {
                        SdkInterstitialActivity.msAd.getInteractionListener().onAdExposure();
                    }
                    SdkInterstitialActivity.this.showed = true;
                } catch (Throwable th) {
                    th.printStackTrace();
                }
            }

            public void onADExposureFailed(int i) {
            }

            public void onADStatusChanged() {
            }

            public void onAdClick() {
                try {
                    LogUtil.d(SdkInterstitialActivity.TAG, "send onAdClicked");
                    if (SdkInterstitialActivity.adWrapper != null && SdkInterstitialActivity.adWrapper.getSdkAdInfo() != null && SdkInterstitialActivity.msAd != null) {
                        a0.a(SdkInterstitialActivity.adWrapper.getContext(), f.a(SdkInterstitialActivity.adWrapper.getSdkAdInfo().getClk(), SdkInterstitialActivity.msAd), new com.meishu.sdk.core.utils.i());
                        SdkInterstitialActivity.adWrapper.getSdkAdInfo().getMsLoadedTime();
                        SdkInterstitialActivity.adWrapper.getAdLoader().getPosId();
                    }
                    if (SdkInterstitialActivity.msAd == null || SdkInterstitialActivity.msAd.getInteractionListener() == null) {
                        return;
                    }
                    SdkInterstitialActivity.msAd.getInteractionListener().onAdClicked();
                } catch (Throwable th) {
                    th.printStackTrace();
                }
            }

            public void onAdUnionClick() {
            }
        });
    }

    private void handleButton() {
        try {
            int i = this.act_type;
            if ((i & 4) == 4 || (i & 64) == 64) {
                showShakeInButton();
                if (this.isDownloadType) {
                    this.btn.setText("摇一摇或点击下载三方应用");
                } else {
                    this.btn.setText("摇一摇或点击查看详情");
                }
            } else if (h.e(i)) {
                showShakeInButton();
                if (this.isDownloadType) {
                    this.btn.setText("扭一扭或点击下载三方应用");
                } else {
                    this.btn.setText("扭一扭或点击查看详情");
                }
            } else if (this.isDownloadType) {
                this.btn.setText("点击下载三方应用");
            } else {
                this.btn.setText("点击查看详情");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    private void handleGDTAd() {
        NativeUnifiedADData nativeUnifiedADData = (NativeUnifiedADData) sdkAd;
        NativeUnifiedADAppMiitInfo appMiitInfo = nativeUnifiedADData.getAppMiitInfo();
        if (nativeUnifiedADData.isAppAd()) {
            this.isDownloadType = true;
        }
        if (appMiitInfo != null) {
            DownloadDialogBean downloadDialogBean = new DownloadDialogBean();
            this.downloadBean = downloadDialogBean;
            downloadDialogBean.setApp_name(appMiitInfo.getAppName());
            this.downloadBean.setApp_ver(appMiitInfo.getVersionName());
            this.downloadBean.setApp_size(((appMiitInfo.getPackageSizeBytes() / 1024) * 1024) + "MB");
            this.downloadBean.setDeveloper(appMiitInfo.getAuthorName());
            this.downloadBean.setApp_permission_url(appMiitInfo.getPermissionsUrl());
            this.downloadBean.setApp_private_agreement(appMiitInfo.getPrivacyAgreement());
        }
        nativeUnifiedADData.getPictureWidth();
        nativeUnifiedADData.getPictureHeight();
        this.title.setText(nativeUnifiedADData.getTitle());
        this.desc.setText(nativeUnifiedADData.getDesc());
        float f = getResources().getDisplayMetrics().density;
        new ArrayList().add(this.mediaContainer);
        i iVar = new i(this);
        if (!TextUtils.isEmpty(nativeUnifiedADData.getIconUrl())) {
            ((com.meishu.sdk.core.bquery.e) iVar).d = this.logo;
            iVar.a(nativeUnifiedADData.getIconUrl(), false);
        }
        if (nativeUnifiedADData.isAppAd()) {
            this.btn.setText("点击下载");
        } else {
            this.btn.setText("点击查看详情");
        }
        this.adLogo.setImageResource(R.drawable.ms_gdt_logo);
        NativeAdContainer nativeAdContainer = new NativeAdContainer(this);
        ViewGroup viewGroup = (ViewGroup) this.rl_container.getParent();
        if (viewGroup != null) {
            ViewGroup.LayoutParams layoutParams = this.rl_container.getLayoutParams();
            viewGroup.removeView(this.rl_container);
            nativeAdContainer.addView(this.rl_container, new ViewGroup.LayoutParams(-1, -2));
            viewGroup.addView((View) nativeAdContainer, layoutParams);
        }
        FrameLayout.LayoutParams layoutParams2 = new FrameLayout.LayoutParams(0, 0);
        ArrayList arrayList = new ArrayList();
        arrayList.add(this.rl_container);
        arrayList.add(this.btn);
        nativeUnifiedADData.setNativeAdEventListener(new NativeADEventListener() { // from class: com.meishu.sdk.activity.SdkInterstitialActivity.9
            public void onADClicked() {
                try {
                    if (SdkInterstitialActivity.adWrapper != null && SdkInterstitialActivity.adWrapper.getSdkAdInfo() != null && SdkInterstitialActivity.msAd != null) {
                        LogUtil.d(SdkInterstitialActivity.TAG, "send onADClicked");
                        a0.a(SdkInterstitialActivity.this.getApplicationContext(), f.a(SdkInterstitialActivity.adWrapper.getSdkAdInfo().getClk(), SdkInterstitialActivity.msAd), new com.meishu.sdk.core.utils.i());
                        SdkInterstitialActivity.adWrapper.getSdkAdInfo().getMsLoadedTime();
                        SdkInterstitialActivity.adWrapper.getAdLoader().getPosId();
                    }
                    if (SdkInterstitialActivity.msAd == null || SdkInterstitialActivity.msAd.getInteractionListener() == null) {
                        return;
                    }
                    SdkInterstitialActivity.msAd.getInteractionListener().onAdClicked();
                } catch (Throwable th) {
                    th.printStackTrace();
                }
            }

            public void onADError(AdError adError) {
            }

            public void onADExposed() {
                try {
                    if (SdkInterstitialActivity.adWrapper == null || SdkInterstitialActivity.adWrapper.getLoaderListener() == null || SdkInterstitialActivity.this.showed) {
                        return;
                    }
                    SdkInterstitialActivity.this.showed = true;
                    SdkInterstitialActivity.adWrapper.getLoaderListener().onAdExposure();
                    if (SdkInterstitialActivity.msAd == null || SdkInterstitialActivity.msAd.getInteractionListener() == null) {
                        return;
                    }
                    SdkInterstitialActivity.msAd.getInteractionListener().onAdExposure();
                } catch (Throwable th) {
                    th.printStackTrace();
                }
            }

            public void onADStatusChanged() {
            }
        });
        nativeUnifiedADData.bindAdToView(this, nativeAdContainer, layoutParams2, arrayList);
        if (nativeUnifiedADData.getAdPatternType() != 2) {
            String imageUrl = getImageUrl(nativeUnifiedADData);
            if (TextUtils.isEmpty(imageUrl)) {
                return;
            }
            ((com.meishu.sdk.core.bquery.e) iVar).d = this.imageView;
            iVar.a(imageUrl, false);
            return;
        }
        this.mediaContainer.removeAllViews();
        View mediaView = new MediaView(this);
        ViewGroup.LayoutParams layoutParams3 = mediaView.getLayoutParams();
        if (layoutParams3 == null) {
            layoutParams3 = new ViewGroup.LayoutParams(-1, -2);
        }
        layoutParams3.width = -1;
        layoutParams3.height = -2;
        this.mediaContainer.addView(mediaView, layoutParams3);
        VideoOption.Builder builder = new VideoOption.Builder();
        builder.setAutoPlayPolicy(this.isVideoAutoPlay ? 1 : 2);
        builder.setAutoPlayMuted(true);
        builder.setNeedCoverImage(true);
        builder.setNeedProgressBar(true);
        builder.setEnableDetailPage(true);
        builder.setEnableUserControl(false);
        nativeUnifiedADData.bindMediaView(mediaView, builder.build(), new NativeADMediaListener() { // from class: com.meishu.sdk.activity.SdkInterstitialActivity.10
            public void onVideoClicked() {
            }

            public void onVideoCompleted() {
            }

            public void onVideoError(AdError adError) {
            }

            public void onVideoInit() {
            }

            public void onVideoLoaded(int i) {
            }

            public void onVideoLoading() {
            }

            public void onVideoPause() {
            }

            public void onVideoReady() {
            }

            public void onVideoResume() {
            }

            public void onVideoStart() {
            }

            public void onVideoStop() {
            }
        });
    }

    /* JADX WARN: Multi-variable type inference failed */
    private void handleKsAd() {
        KsNativeAd ksNativeAd = (KsNativeAd) sdkAd;
        if (ksNativeAd.getInteractionType() == 1) {
            this.isDownloadType = true;
        }
        DownloadDialogBean downloadDialogBean = new DownloadDialogBean();
        this.downloadBean = downloadDialogBean;
        downloadDialogBean.setApp_name(ksNativeAd.getAppName());
        this.downloadBean.setApp_ver(ksNativeAd.getAppVersion());
        this.downloadBean.setApp_size(((ksNativeAd.getAppPackageSize() / 1024) * 1024) + "MB");
        this.downloadBean.setDeveloper(ksNativeAd.getCorporationName());
        this.downloadBean.setApp_permission_url(ksNativeAd.getPermissionInfoUrl());
        this.downloadBean.setApp_private_agreement(ksNativeAd.getAppPrivacyUrl());
        this.downloadBean.setApp_intro(ksNativeAd.getAdDescription());
        this.title.setVisibility(8);
        this.desc.setText(ksNativeAd.getAdDescription());
        i iVar = new i(this);
        ((com.meishu.sdk.core.bquery.e) iVar).d = this.logo;
        int i = 0;
        iVar.a(ksNativeAd.getAppIconUrl(), false);
        ((com.meishu.sdk.core.bquery.e) iVar).d = this.adLogo;
        iVar.c(R.drawable.ms_ksad_sdk_logo);
        if (ksNativeAd.getInteractionType() == 1) {
            this.btn.setText("点击下载");
        } else {
            this.btn.setText("点击查看详情");
        }
        ArrayList arrayList = new ArrayList();
        arrayList.add(this.rl_container);
        arrayList.add(this.btn);
        ksNativeAd.registerViewForInteraction(this.rl_container, arrayList, new KsNativeAd.AdInteractionListener() { // from class: com.meishu.sdk.activity.SdkInterstitialActivity.11
            @Override // com.kwad.sdk.api.KsNativeAd.AdInteractionListener
            public boolean handleDownloadDialog(DialogInterface.OnClickListener onClickListener) {
                return false;
            }

            @Override // com.kwad.sdk.api.KsNativeAd.AdInteractionListener
            public void onAdClicked(View view, KsNativeAd ksNativeAd2) {
                try {
                    LogUtil.d(SdkInterstitialActivity.TAG, "send onAdClicked");
                    if (SdkInterstitialActivity.adWrapper != null && SdkInterstitialActivity.adWrapper.getSdkAdInfo() != null && SdkInterstitialActivity.msAd != null) {
                        a0.a(SdkInterstitialActivity.adWrapper.getContext(), f.a(SdkInterstitialActivity.adWrapper.getSdkAdInfo().getClk(), SdkInterstitialActivity.msAd), new com.meishu.sdk.core.utils.i());
                        SdkInterstitialActivity.adWrapper.getSdkAdInfo().getMsLoadedTime();
                        SdkInterstitialActivity.adWrapper.getAdLoader().getPosId();
                    }
                    if (SdkInterstitialActivity.msAd == null || SdkInterstitialActivity.msAd.getInteractionListener() == null) {
                        return;
                    }
                    SdkInterstitialActivity.msAd.getInteractionListener().onAdClicked();
                } catch (Throwable th) {
                    th.printStackTrace();
                }
            }

            @Override // com.kwad.sdk.api.KsNativeAd.AdInteractionListener
            public void onAdShow(KsNativeAd ksNativeAd2) {
                try {
                    if (SdkInterstitialActivity.this.showed) {
                        return;
                    }
                    if (SdkInterstitialActivity.adWrapper.getLoaderListener() != null) {
                        SdkInterstitialActivity.adWrapper.getLoaderListener().onAdExposure();
                    }
                    if (SdkInterstitialActivity.msAd != null && SdkInterstitialActivity.msAd.getInteractionListener() != null) {
                        SdkInterstitialActivity.msAd.getInteractionListener().onAdExposure();
                    }
                    SdkInterstitialActivity.this.showed = true;
                } catch (Throwable th) {
                    th.printStackTrace();
                }
            }

            @Override // com.kwad.sdk.api.KsNativeAd.AdInteractionListener
            public void onDownloadTipsDialogDismiss() {
            }

            @Override // com.kwad.sdk.api.KsNativeAd.AdInteractionListener
            public void onDownloadTipsDialogShow() {
            }
        });
        DisplayMetrics displayMetrics = getResources().getDisplayMetrics();
        float f = displayMetrics.density;
        float f2 = displayMetrics.widthPixels;
        int i2 = (int) (f2 - (70.0f * f));
        if (this.layout_type == 2) {
            i2 = (int) (f2 - (f * 84.0f));
        }
        if (ksNativeAd.getMaterialType() == 1) {
            View videoView = ksNativeAd.getVideoView((Context) this, new KsAdVideoPlayConfig.Builder().videoSoundEnable(false).build());
            if (videoView != null) {
                this.mediaContainer.removeAllViews();
                int videoWidth = ksNativeAd.getVideoWidth();
                int videoHeight = ksNativeAd.getVideoHeight();
                if (videoWidth > 0 && videoHeight > 0) {
                    i = (videoHeight * i2) / videoWidth;
                }
                this.mediaContainer.addView(videoView, -1, i);
                return;
            }
            return;
        }
        List<KsImage> imageList = ksNativeAd.getImageList();
        if (imageList == null || imageList.size() <= 0) {
            return;
        }
        KsImage ksImage = imageList.get(0);
        int width = ksImage.getWidth();
        int height = ksImage.getHeight();
        String imageUrl = imageList.get(0).getImageUrl();
        ((com.meishu.sdk.core.bquery.e) iVar).d = this.imageView;
        iVar.a(imageUrl, false);
        if (width > 0 && height > 0) {
            i = (height * i2) / width;
        }
        ViewGroup.LayoutParams layoutParams = this.imageView.getLayoutParams();
        layoutParams.height = i;
        layoutParams.width = -1;
        this.imageView.setLayoutParams(layoutParams);
    }

    /* JADX WARN: Multi-variable type inference failed */
    private void handleMsAd() {
        ShakeUtil.getInstance().e();
        final c cVar = (c) sdkAd;
        final b bVarC = cVar.c();
        int act_type = bVarC.getAct_type();
        boolean z = true;
        if ((act_type & 1) != 1 && (act_type & 2) != 2) {
            bVarC.setAct_type(act_type | 1);
        }
        AdType adType = AdType.INTERSTITIAL;
        adType.value();
        h.a();
        int iA = h.a(bVarC.getAct_type(), adType.value());
        bVarC.setAct_type(iA);
        this.act_type = iA;
        if (cVar.getInteractionType() == 1) {
            this.isDownloadType = true;
        }
        this.downloadBean = DownloadView.toBean(bVarC);
        i iVar = new i(this);
        if (this.layout_type == 1) {
            if (TextUtils.isEmpty(bVarC.a)) {
                this.title.setText("");
                this.title.setVisibility(8);
            } else {
                this.title.setVisibility(0);
                this.title.setText(bVarC.a);
            }
            if (TextUtils.isEmpty(bVarC.getDesc())) {
                this.desc.setVisibility(8);
                this.desc.setText("");
            } else {
                this.desc.setVisibility(0);
                this.desc.setText(bVarC.getDesc());
            }
        }
        if (this.logo != null) {
            if (TextUtils.isEmpty(bVarC.getIconUrl())) {
                ((com.meishu.sdk.core.bquery.e) iVar).d = this.logo;
                iVar.d(8);
            } else {
                ((com.meishu.sdk.core.bquery.e) iVar).d = this.logo;
                iVar.d(0);
                ((com.meishu.sdk.core.bquery.e) iVar).d = this.logo;
                iVar.a(bVarC.getIconUrl(), false);
            }
        }
        this.adLogoLL.setBackground(getResources().getDrawable(R.drawable.ms_black_oval_gray));
        if (TextUtils.isEmpty(bVarC.getFromLogo())) {
            ((com.meishu.sdk.core.bquery.e) iVar).d = this.adLogo;
            Drawable drawable = getResources().getDrawable(R.drawable.ms_ad);
            View view = ((com.meishu.sdk.core.bquery.e) iVar).d;
            if (view instanceof ImageView) {
                ((ImageView) view).setImageDrawable(drawable);
            }
        } else {
            ((com.meishu.sdk.core.bquery.e) iVar).d = this.adLogo;
            iVar.a(bVarC.getFromLogo(), false);
        }
        if (!TextUtils.isEmpty(bVarC.getCid())) {
            this.cid.setText(bVarC.getCid());
        }
        StringBuilder sbA = a.a("adSlot.getAdPatternType()=");
        sbA.append(bVarC.getAdPatternType());
        LogUtil.d(TAG, sbA.toString());
        if (cVar.g == 0) {
            cVar.g = System.currentTimeMillis();
        }
        if (bVarC.getAdPatternType() == 2) {
            loadNativeVideo(iVar, bVarC, cVar);
        } else {
            com.meishu.sdk.core.cache.a.a(bVarC.getImageUrls()[0], new y() { // from class: com.meishu.sdk.activity.SdkInterstitialActivity.3
                public void onFailure(@NotNull IOException iOException) {
                    if (SdkInterstitialActivity.adListener != null) {
                        SdkInterstitialActivity.adListener.onAdRenderFail("图片加载失败", -1);
                    }
                }

                public void onResponse(HttpResponse<byte[]> httpResponse) throws IOException {
                    byte[] bArr;
                    try {
                        if (!httpResponse.isSuccessful() || (bArr = (byte[]) httpResponse.getResponseBody()) == null || bArr.length <= 0) {
                            return;
                        }
                        if (!SdkInterstitialActivity.this.isGif(bArr)) {
                            Bitmap bitmapDecodeByteArray = BitmapFactory.decodeByteArray(bArr, 0, bArr.length);
                            if (bitmapDecodeByteArray != null) {
                                SdkInterstitialActivity.this.setImageShowType(bVarC.getScale_type(), bitmapDecodeByteArray, SdkInterstitialActivity.this.imageView);
                            } else if (SdkInterstitialActivity.adListener != null) {
                                SdkInterstitialActivity.adListener.onAdRenderFail("bitmap加载失败", ErrorCodeUtil.RES_LOAD_ERROR.intValue());
                            }
                            try {
                                Bitmap bitmapDecodeByteArray2 = BitmapFactory.decodeByteArray(bArr, 0, bArr.length);
                                if (bitmapDecodeByteArray2 != null) {
                                    SdkInterstitialActivity.this.getApplicationContext();
                                    SdkInterstitialActivity.this.imageBg.setImageBitmap(f0.a(bitmapDecodeByteArray2, 25));
                                }
                            } catch (Throwable th) {
                                th.printStackTrace();
                            }
                        } else if (SdkInterstitialActivity.this.imageView != null) {
                            SdkInterstitialActivity.this.imageView.setBytes(bArr);
                            SdkInterstitialActivity.this.imageView.startAnimation();
                        }
                        cVar.i = System.currentTimeMillis();
                        SdkInterstitialActivity.this.view.post(new l() { // from class: com.meishu.sdk.activity.SdkInterstitialActivity.3.1
                            public void safeRun() {
                                SdkInterstitialActivity.this.showed = true;
                                cVar.d();
                                AnonymousClass3 anonymousClass3 = AnonymousClass3.this;
                                SdkInterstitialActivity.this.startShake(bVarC);
                            }
                        });
                    } catch (Throwable th2) {
                        th2.printStackTrace();
                    }
                }
            }, true);
        }
        cVar.setAdView(this.rootView);
        if ((bVarC.getAct_type() & 1) == 1) {
            this.rl_container.setOnClickListener(new o() { // from class: com.meishu.sdk.activity.SdkInterstitialActivity.4
                public void safeOnClick(View view2) {
                    if (SdkInterstitialActivity.this.showed) {
                        if (SdkInterstitialActivity.msAd != null && SdkInterstitialActivity.msAd.getInteractionListener() != null && bVarC.getCbc() == 0) {
                            SdkInterstitialActivity.msAd.getInteractionListener().onAdClicked();
                        }
                        bVarC.setClkActType(1);
                        try {
                            if (SdkInterstitialActivity.this.isClickToClose) {
                                cVar.c().setAdClosed(true);
                            }
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                        f.a(cVar, true);
                        if (SdkInterstitialActivity.this.isClickToClose) {
                            SdkInterstitialActivity.this.finish();
                            if (SdkInterstitialActivity.msAd == null || SdkInterstitialActivity.msAd.getInteractionListener() == null) {
                                return;
                            }
                            SdkInterstitialActivity.msAd.getInteractionListener().onAdClosed();
                        }
                    }
                }
            });
        } else {
            z = false;
        }
        if (z || (bVarC.getAct_type() & 2) != 2) {
            return;
        }
        this.btn.setOnClickListener(new o() { // from class: com.meishu.sdk.activity.SdkInterstitialActivity.5
            public void safeOnClick(View view2) {
                if (SdkInterstitialActivity.this.showed) {
                    if (SdkInterstitialActivity.msAd != null && SdkInterstitialActivity.msAd.getInteractionListener() != null && bVarC.getCbc() == 0) {
                        SdkInterstitialActivity.msAd.getInteractionListener().onAdClicked();
                    }
                    bVarC.setClkActType(2);
                    f.a(cVar, true);
                    if (SdkInterstitialActivity.this.isClickToClose) {
                        SdkInterstitialActivity.this.finish();
                        if (SdkInterstitialActivity.msAd == null || SdkInterstitialActivity.msAd.getInteractionListener() == null) {
                            return;
                        }
                        SdkInterstitialActivity.msAd.getInteractionListener().onAdClosed();
                    }
                }
            }
        });
    }

    private void handleSdk() {
        Object obj = sdkAd;
        if (obj != null) {
            try {
                if (obj instanceof NativeUnifiedADData) {
                    handleGDTAd();
                }
            } catch (Throwable th) {
                th.printStackTrace();
            }
            try {
                if (sdkAd instanceof KsNativeAd) {
                    handleKsAd();
                }
            } catch (Throwable th2) {
                th2.printStackTrace();
            }
            try {
                if (sdkAd instanceof c) {
                    handleMsAd();
                }
            } catch (Throwable th3) {
                th3.printStackTrace();
            }
            try {
                if (sdkAd instanceof NativeResponse) {
                    handleBdAd();
                }
            } catch (Throwable th4) {
                th4.printStackTrace();
            }
            handleButton();
            handleDownloadView();
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    private void initView() {
        TouchAdContainer touchAdContainer;
        try {
            this.touchAdContainer = findViewById(R.id.ms_activity_sdk_interstitial_touchAdContainer);
            this.startActionShakeImage = findViewById(R.id.ms_action_shakeImage);
            this.mediaContainer = (RelativeLayout) findViewById(R.id.ms_activity_sdk_interstitial_mediaContainer);
            this.imageView = findViewById(R.id.ms_activity_sdk_interstitial_imageview);
            this.imageBg = (ImageView) findViewById(R.id.ms_activity_sdk_interstitial_imageBg);
            this.closeImage = (ImageView) findViewById(R.id.ms_activity_sdk_interstitial_cacel);
            this.adLogo = (ImageView) findViewById(R.id.ms_activity_sdk_interstitial_adLogo);
            this.cid = (TextView) findViewById(R.id.ms_layout_native_interstitial_cid);
            this.rl_container = (RelativeLayout) findViewById(R.id.ms_activity_sdk_interstitial_rl_container);
            this.adLogoLL = (LinearLayout) findViewById(R.id.ms_activity_sdk_interstitial_adLogoLL);
            this.logo = (ImageView) findViewById(R.id.ms_activity_sdk_interstitial_logo);
            this.title = (TextView) findViewById(R.id.ms_activity_sdk_interstitial_title);
            this.desc = (TextView) findViewById(R.id.ms_activity_sdk_interstitial_desc);
            this.btn = (TextView) findViewById(R.id.ms_activity_sdk_interstitial_btn);
            IAd iAd = msAd;
            if (iAd != null && (touchAdContainer = this.touchAdContainer) != null) {
                touchAdContainer.setTouchPositionListener(new TouchPositionListener(iAd));
            }
            this.closeImage.setOnClickListener(new o() { // from class: com.meishu.sdk.activity.SdkInterstitialActivity.1
                public void safeOnClick(View view) {
                    SdkInterstitialActivity.this.finish();
                    if (SdkInterstitialActivity.msAd == null || SdkInterstitialActivity.msAd.getInteractionListener() == null) {
                        return;
                    }
                    SdkInterstitialActivity.msAd.getInteractionListener().onAdClosed();
                }
            });
            this.adLogoLL.post(new Runnable() { // from class: com.meishu.sdk.activity.SdkInterstitialActivity.2
                /* JADX WARN: Type inference failed for: r0v1, types: [android.content.Context, com.meishu.sdk.activity.SdkInterstitialActivity] */
                /* JADX WARN: Type inference fix 'apply assigned field type' failed
                java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$UnknownArg
                	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:596)
                	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
                	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
                	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
                	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
                	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
                	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
                 */
                @Override // java.lang.Runnable
                public void run() {
                    try {
                        ?? r0 = SdkInterstitialActivity.this;
                        int navigationBarHeight = r0.getNavigationBarHeight(r0);
                        if (navigationBarHeight > 0) {
                            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) SdkInterstitialActivity.this.adLogoLL.getLayoutParams();
                            layoutParams.bottomMargin = navigationBarHeight + 15;
                            SdkInterstitialActivity.this.adLogoLL.setLayoutParams(layoutParams);
                        }
                    } catch (Throwable th) {
                        th.printStackTrace();
                    }
                }
            });
        } catch (Exception e) {
            e.printStackTrace();
        }
        try {
            if (this.layout_type == 2) {
                DisplayMetrics displayMetrics = getResources().getDisplayMetrics();
                if (this.layout_width > 0 && this.layout_height > 0) {
                    RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.touchAdContainer.getLayoutParams();
                    double d = ((double) displayMetrics.widthPixels) * 0.86d;
                    layoutParams.width = (int) d;
                    layoutParams.height = (int) ((d * ((double) this.layout_height)) / ((double) this.layout_width));
                    int i = (int) (((double) displayMetrics.heightPixels) * 0.07d);
                    layoutParams.topMargin = i;
                    layoutParams.bottomMargin = i;
                    this.touchAdContainer.setLayoutParams(layoutParams);
                }
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
        try {
            handleSdk();
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean isGif(byte[] bArr) {
        byte[] bArr2 = new byte[4];
        System.arraycopy(bArr, 0, bArr2, 0, 4);
        return new BigInteger(1, bArr2).toString(16).startsWith("47494638");
    }

    private void loadNativeVideo(i iVar, b bVar, c cVar) {
        String str = bVar.getImageUrls()[0];
        AnonymousClass7 anonymousClass7 = new AnonymousClass7(cVar, bVar);
        iVar.getClass();
        iVar.a(str, 86400000, true, new d(iVar, anonymousClass7));
    }

    public static void setAdListener(com.meishu.sdk.meishu_ad.interstitial.a aVar) {
        try {
            adListener = aVar;
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void setAdWrapper(BasePlatformLoader basePlatformLoader) {
        adWrapper = basePlatformLoader;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public void setImageShowType(int i, Bitmap bitmap, GifImageView gifImageView) {
        int i2;
        int i3;
        int i4;
        DisplayMetrics displayMetrics = getResources().getDisplayMetrics();
        int i5 = displayMetrics.widthPixels;
        float f = displayMetrics.density;
        int i6 = (int) (i5 - (70.0f * f));
        int i7 = (int) (f * 200.0f);
        try {
            if (this.layout_type == 2) {
                double d = ((double) i5) * 0.86d;
                i2 = (int) ((((double) this.layout_height) * d) / ((double) this.layout_width));
                i6 = (int) d;
                try {
                    i7 = (int) (((double) displayMetrics.heightPixels) * 0.86d);
                } catch (Exception e) {
                    e = e;
                    e.printStackTrace();
                }
                i4 = i6;
                i3 = i7;
                i7 = i2;
            } else {
                i4 = i6;
                i3 = i7;
            }
        } catch (Exception e2) {
            e = e2;
            i2 = i7;
        }
        if (i7 < i3) {
            gifImageView.setImageBitmap(bitmap);
            return;
        }
        try {
            switch (i) {
                case 1:
                    if ((bitmap.getHeight() * 1.0f) / i3 <= (bitmap.getWidth() * 1.0f) / i4) {
                        fullHeightImage(bitmap, gifImageView, i4, i3, i);
                    } else {
                        fullWidthImage(bitmap, gifImageView, i4, i3, i);
                    }
                    break;
                case 2:
                default:
                    if ((bitmap.getWidth() * 1.0f) / i4 <= (bitmap.getHeight() * 1.0f) / i3) {
                        fullHeightImage(bitmap, gifImageView, i4, i3, i);
                    } else {
                        fullWidthImage(bitmap, gifImageView, i4, i3, i);
                    }
                    break;
                case 3:
                case 4:
                case 5:
                    fullWidthImage(bitmap, gifImageView, i4, i3, i);
                    break;
                case 6:
                case 7:
                case 8:
                    fullHeightImage(bitmap, gifImageView, i4, i3, i);
                    break;
                case 9:
                    gifImageView.setScaleType(ImageView.ScaleType.FIT_XY);
                    gifImageView.setImageBitmap(bitmap);
                    break;
            }
        } catch (Throwable th) {
            th.printStackTrace();
            gifImageView.setScaleType(ImageView.ScaleType.FIT_XY);
            gifImageView.setImageBitmap(bitmap);
        }
    }

    public static void setMsAd(IAd iAd) {
        msAd = iAd;
    }

    public static void setSdkAd(Object obj) {
        sdkAd = obj;
    }

    /* JADX WARN: Multi-variable type inference failed */
    private void showShakeInButton() {
        Drawable drawable = getResources().getDrawable(R.drawable.ms_shake_angle);
        drawable.setBounds(0, 0, 100, 100);
        this.btn.setPadding(20, 0, 60, 0);
        this.btn.setCompoundDrawables(drawable, null, null, null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    private void showStartShakeImage() {
        this.startActionShakeImage.setVisibility(0);
        byte[] imageBytes = getImageBytes(this, R.raw.ms_new_shake);
        if (imageBytes != null && imageBytes.length > 0) {
            this.startActionShakeImage.setBytes(imageBytes, 1);
            this.startActionShakeImage.startAnimation();
        }
        new Handler().postDelayed(new l() { // from class: com.meishu.sdk.activity.SdkInterstitialActivity.6
            public void safeRun() {
                SdkInterstitialActivity.this.startActionShakeImage.clear();
                SdkInterstitialActivity.this.startActionShakeImage.setVisibility(8);
            }
        }, 2000L);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void startShake(final b bVar) {
        this.rootView.post(new l() { // from class: com.meishu.sdk.activity.SdkInterstitialActivity.8
            public void safeRun() {
                try {
                    if (h.c(bVar.getAct_type())) {
                        SdkInterstitialActivity.this.isShake = true;
                        int power_index = bVar.getPower_index();
                        int power_index2 = bVar.getPower_index2();
                        SdkInterstitialActivity.this.shakeId = ShakeUtil.getInstance().b();
                        int iB = h.b(bVar.getAct_type());
                        final long jCurrentTimeMillis = System.currentTimeMillis();
                        ShakeUtil.getInstance().a(bVar.getPosId(), bVar.getLoadedTime(), bVar.getDclk());
                        ShakeUtil.getInstance().a(power_index2, power_index, iB, bVar.getPower_delay(), bVar.getPower_count(), SdkInterstitialActivity.this.shakeId, bVar.getEcpm(), new ShakeUtil.c() { // from class: com.meishu.sdk.activity.SdkInterstitialActivity.8.1
                            public void onShake(int i, boolean z, int i2, ShakeResult shakeResult) {
                                ShakeUtil.getInstance().a(SdkInterstitialActivity.this.shakeId);
                                if (SdkInterstitialActivity.msAd != null && SdkInterstitialActivity.msAd.getInteractionListener() != null && bVar.getCbc() == 0) {
                                    SdkInterstitialActivity.msAd.getInteractionListener().onAdClicked();
                                }
                                if (shakeResult != null) {
                                    shakeResult.setTotalTurnTime(System.currentTimeMillis() - jCurrentTimeMillis);
                                }
                                c cVar = (c) SdkInterstitialActivity.sdkAd;
                                b bVarC = cVar.c();
                                bVarC.setClkActType(i);
                                bVarC.setClkPower(i2);
                                bVarC.setShakeResult(shakeResult);
                                try {
                                    if (SdkInterstitialActivity.this.isClickToClose) {
                                        cVar.c().setAdClosed(true);
                                    }
                                } catch (Exception e) {
                                    e.printStackTrace();
                                }
                                f.a(cVar, i2 >= 50);
                                if (SdkInterstitialActivity.this.isClickToClose) {
                                    SdkInterstitialActivity.this.finish();
                                    if (SdkInterstitialActivity.msAd == null || SdkInterstitialActivity.msAd.getInteractionListener() == null) {
                                        return;
                                    }
                                    SdkInterstitialActivity.msAd.getInteractionListener().onAdClosed();
                                }
                            }
                        });
                        ShakeUtil.getInstance().a(true);
                    }
                } catch (Throwable th) {
                    th.printStackTrace();
                }
            }
        });
    }

    public int getNavigationBarHeight(Context context) {
        Resources resources = context.getResources();
        int identifier = resources.getIdentifier(com.gyf.immersionbar.b.f6803b, "dimen", "android");
        if (identifier > 0) {
            return resources.getDimensionPixelSize(identifier);
        }
        return 0;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void handleDownloadView() {
        try {
            LogUtil.d(TAG, "handleDownloadView: interactionType=" + this.isDownloadType);
            if (this.isDownloadType) {
                TextView textView = (TextView) findViewById(R.id.ms_download_layer_textview);
                textView.setVisibility(0);
                DownloadView.bindClickableDownloadInfo(textView, this.downloadBean);
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public void onBackPressed() {
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void onConfigurationChanged(Configuration configuration) {
        initView();
        super/*android.app.Activity*/.onConfigurationChanged(configuration);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void safeOnCreate(Bundle bundle) {
        super.safeOnCreate(bundle);
        setContentView(R.layout.ms_activity_sdk_interstitial);
        try {
            getWindow().getDecorView().setSystemUiVisibility(1792);
            getWindow().setNavigationBarColor(0);
            getWindow().setStatusBarColor(0);
        } catch (Throwable th) {
            th.printStackTrace();
        }
        Intent intent = getIntent();
        this.isVideoAutoPlay = intent.getBooleanExtra("isVideoAutoPlay", true);
        this.isClickToClose = intent.getBooleanExtra("isClickToClose", false);
        this.act_type = intent.getIntExtra("act_type", 2);
        this.layout_type = intent.getIntExtra("layout_type", 1);
        this.layout_width = intent.getIntExtra("layout_width", 0);
        this.layout_height = intent.getIntExtra("layout_height", 0);
        this.rootView = (RelativeLayout) findViewById(R.id.ms_activity_sdk_interstitial_rootView);
        this.view = View.inflate(this, R.layout.ms_layout_sdk_interstitial_1, null);
        if (this.layout_type == 2) {
            this.view = View.inflate(this, R.layout.ms_layout_sdk_interstitial_2, null);
        }
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -1);
        layoutParams.addRule(13);
        this.rootView.addView(this.view, layoutParams);
        initView();
    }

    public void safeOnDestroy() {
        super.safeOnDestroy();
        sdkAd = null;
        adWrapper = null;
        msAd = null;
        adListener = null;
        ShakeUtil.getInstance().a(this.shakeId);
    }

    public void safeOnPause() {
        super.safeOnPause();
        if (this.isShake) {
            ShakeUtil.getInstance().e();
        }
    }

    public void safeOnResume() {
        super.safeOnResume();
        if (this.isShake) {
            ShakeUtil.getInstance().f();
        }
    }
}

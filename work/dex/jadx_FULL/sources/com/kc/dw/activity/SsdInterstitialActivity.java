package com.kc.dw.activity;

import android.app.Activity;
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
import com.kc.dw.ad.interstitial.b;
import com.kc.dw.ad.interstitial.g;
import com.kc.dw.ad.nativ.NormalMediaView;
import com.kc.dw.ad.nativ.c;
import com.kc.dw.core.ad.AdType;
import com.kc.dw.core.ad.IAd;
import com.kc.dw.core.ad.recycler.FeedInteractionListener;
import com.kc.dw.core.bquery.d;
import com.kc.dw.core.domain.HttpResponse;
import com.kc.dw.core.domain.SsdAdInfo;
import com.kc.dw.core.router.log.bean.ShowAdState;
import com.kc.dw.core.safe.SafeActivity;
import com.kc.dw.core.safe.j;
import com.kc.dw.core.safe.m;
import com.kc.dw.core.utils.DownloadDialogBean;
import com.kc.dw.core.utils.LogUtil;
import com.kc.dw.core.utils.SdkHandler;
import com.kc.dw.core.utils.c0;
import com.kc.dw.core.utils.d0;
import com.kc.dw.core.utils.f;
import com.kc.dw.core.utils.f0;
import com.kc.dw.core.utils.h;
import com.kc.dw.core.utils.x;
import com.kc.dw.core.utils.z;
import com.kc.dw.core.view.TouchAdContainer;
import com.kc.dw.core.view.TouchPositionListener;
import com.kc.dw.core.view.gif.GifImageView;
import com.kc.dw.platform.BasePlatformLoader;
import com.kc.dw.platform.ad_adapter.splash.ShakeResult;
import com.kc.dw.platform.ad_adapter.splash.ShakeUtil;
import com.kc.dw.platform.custom.ca.intertitial.IntertitialChangeAdapter;
import com.kc.dw.platform.custom.recycler.MsCustomRecyclerFeedAd;
import com.kc.openset.R;
import com.kwad.sdk.api.KsAdVideoPlayConfig;
import com.kwad.sdk.api.KsImage;
import com.kwad.sdk.api.KsNativeAd;
import com.qihoo.SdkProtected.OSETSDK.Keep;
import com.qq.e.ads.cfg.VideoOption;
import com.qq.e.ads.nativ.MediaView;
import com.qq.e.ads.nativ.NativeADEventListener;
import com.qq.e.ads.nativ.NativeADMediaListener;
import com.qq.e.ads.nativ.NativeUnifiedADAppMiitInfo;
import com.qq.e.ads.nativ.NativeUnifiedADData;
import com.qq.e.ads.nativ.widget.NativeAdContainer;
import com.qq.e.comm.util.AdError;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
@Keep
public class SsdInterstitialActivity extends SafeActivity {
    private static final String TAG = "SdkInterstitialActivity";
    private static com.kc.dw.ad.interstitial.a adListener;
    private static BasePlatformLoader adWrapper;
    private static IntertitialChangeAdapter intertitialChangeAdapter;
    private static IAd msAd;
    private static Object sdkAd;
    private int act_type = 2;
    private ImageView adLogo;
    private LinearLayout adLogoLL;
    private TextView btn;
    private TextView cid;
    private ImageView closeImage;
    private TextView desc;
    private String downloadAppDeveloper;
    private String downloadAppIntroString;
    private String downloadAppIntroUrl;
    private String downloadAppName;
    private String downloadAppPaymentTypes;
    private List<SsdAdInfo.PermissionBean> downloadAppPermissionList;
    private String downloadAppPermissionUrl;
    private String downloadAppPrivacyAgreement;
    private String downloadAppSize;
    private String downloadAppVersion;
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

    /* JADX INFO: renamed from: com.kc.dw.activity.SsdInterstitialActivity$13, reason: invalid class name */
    @Keep
    public class AnonymousClass13 extends j {
        public final SsdInterstitialActivity this$0;
        public final NativeResponse val$sdkAd;

        public AnonymousClass13(SsdInterstitialActivity ssdInterstitialActivity, NativeResponse nativeResponse) {
            this.this$0 = ssdInterstitialActivity;
            this.val$sdkAd = nativeResponse;
        }

        @Override // com.kc.dw.core.safe.j
        public void safeRun() {
            try {
                MediaMetadataRetriever mediaMetadataRetriever = new MediaMetadataRetriever();
                mediaMetadataRetriever.setDataSource(this.val$sdkAd.getVideoUrl());
                Bitmap frameAtTime = mediaMetadataRetriever.getFrameAtTime();
                if (frameAtTime != null) {
                    SdkHandler.getInstance().runOnUiThread(new j(this, frameAtTime) { // from class: com.kc.dw.activity.SsdInterstitialActivity.13.1
                        public final AnonymousClass13 this$1;
                        public final Bitmap val$videoBitmap;

                        {
                            this.this$1 = this;
                            this.val$videoBitmap = frameAtTime;
                        }

                        @Override // com.kc.dw.core.safe.j
                        public void safeRun() {
                            this.this$1.this$0.imageView.setImageBitmap(this.val$videoBitmap);
                        }
                    });
                }
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }
    }

    /* JADX INFO: renamed from: com.kc.dw.activity.SsdInterstitialActivity$17, reason: invalid class name */
    @Keep
    public class AnonymousClass17 implements x {
        public final SsdInterstitialActivity this$0;
        public final float val$density;
        public final DisplayMetrics val$dm;

        public AnonymousClass17(SsdInterstitialActivity ssdInterstitialActivity, DisplayMetrics displayMetrics, float f) {
            this.this$0 = ssdInterstitialActivity;
            this.val$dm = displayMetrics;
            this.val$density = f;
        }

        @Override // com.kc.dw.core.utils.x
        public void onFailure(IOException iOException) {
            if (SsdInterstitialActivity.intertitialChangeAdapter != null) {
                SsdInterstitialActivity.intertitialChangeAdapter.changeRenderError(200002, "图片加载错误");
            }
        }

        /* JADX WARN: Code duplicated, block: B:34:0x00b4  */
        @Override // com.kc.dw.core.utils.x
        public void onResponse(HttpResponse<byte[]> httpResponse) throws IOException {
            byte[] responseBody;
            try {
                if (!httpResponse.isSuccessful() || (responseBody = httpResponse.getResponseBody()) == null || responseBody.length <= 0) {
                    return;
                }
                Bitmap bitmapDecodeByteArray = BitmapFactory.decodeByteArray(responseBody, 0, responseBody.length);
                if (bitmapDecodeByteArray != null) {
                    int width = bitmapDecodeByteArray.getWidth();
                    int height = bitmapDecodeByteArray.getHeight();
                    int i = (int) (this.val$dm.widthPixels - (this.val$density * 70.0f));
                    if (this.this$0.layout_type == 2) {
                        i = (int) (this.val$dm.widthPixels - (this.val$density * 84.0f));
                    }
                    this.this$0.imageView.post(new Runnable(this, (width <= 0 || height <= 0) ? 0 : (height * i) / width) { // from class: com.kc.dw.activity.SsdInterstitialActivity.17.1
                        public final AnonymousClass17 this$1;
                        public final int val$finalContainerHeight;

                        {
                            this.this$1 = this;
                            this.val$finalContainerHeight = i;
                        }

                        @Override // java.lang.Runnable
                        public void run() {
                            ViewGroup.LayoutParams layoutParams = this.this$1.this$0.imageView.getLayoutParams();
                            layoutParams.height = this.val$finalContainerHeight;
                            layoutParams.width = -1;
                            this.this$1.this$0.imageView.setLayoutParams(layoutParams);
                        }
                    });
                    com.kc.dw.core.service.logrecord.a.a(5, "e7", SsdInterstitialActivity.adWrapper);
                    this.this$0.imageView.setImageBitmap(bitmapDecodeByteArray);
                    if (SsdInterstitialActivity.intertitialChangeAdapter != null) {
                        SsdInterstitialActivity.intertitialChangeAdapter.changeRenderSuccess();
                    }
                } else if (SsdInterstitialActivity.intertitialChangeAdapter != null) {
                    SsdInterstitialActivity.intertitialChangeAdapter.changeRenderError(200002, "图片加载错误");
                }
                try {
                    Bitmap bitmapDecodeByteArray2 = BitmapFactory.decodeByteArray(responseBody, 0, responseBody.length);
                    if (bitmapDecodeByteArray2 != null) {
                        this.this$0.getApplicationContext();
                        this.this$0.imageBg.setImageBitmap(d0.a(bitmapDecodeByteArray2, 25));
                        return;
                    }
                    return;
                } catch (Throwable th) {
                    th.printStackTrace();
                    return;
                }
                if (SsdInterstitialActivity.intertitialChangeAdapter != null) {
                    SsdInterstitialActivity.intertitialChangeAdapter.changeRenderError(200002, "图片加载错误");
                }
                th.printStackTrace();
            } catch (Throwable th2) {
                if (SsdInterstitialActivity.intertitialChangeAdapter != null) {
                    SsdInterstitialActivity.intertitialChangeAdapter.changeRenderError(200002, "图片加载错误");
                }
                th2.printStackTrace();
            }
        }
    }

    /* JADX INFO: renamed from: com.kc.dw.activity.SsdInterstitialActivity$3, reason: invalid class name */
    @Keep
    public class AnonymousClass3 implements x {
        public final SsdInterstitialActivity this$0;
        public final b val$adSlot;
        public final g val$sdkAd;

        public AnonymousClass3(SsdInterstitialActivity ssdInterstitialActivity, b bVar, g gVar) {
            this.this$0 = ssdInterstitialActivity;
            this.val$adSlot = bVar;
            this.val$sdkAd = gVar;
        }

        @Override // com.kc.dw.core.utils.x
        public void onFailure(IOException iOException) {
            if (SsdInterstitialActivity.adListener != null) {
                ((com.kc.dw.platform.ad_adapter.interstitial.a) SsdInterstitialActivity.adListener).onAdRenderFail("图片加载失败", -1);
            }
        }

        @Override // com.kc.dw.core.utils.x
        public void onResponse(HttpResponse<byte[]> httpResponse) throws IOException {
            byte[] responseBody;
            try {
                if (!httpResponse.isSuccessful() || (responseBody = httpResponse.getResponseBody()) == null || responseBody.length <= 0) {
                    return;
                }
                if (!this.this$0.isGif(responseBody)) {
                    Bitmap bitmapDecodeByteArray = BitmapFactory.decodeByteArray(responseBody, 0, responseBody.length);
                    if (bitmapDecodeByteArray != null) {
                        this.this$0.setImageShowType(this.val$adSlot.getScale_type(), bitmapDecodeByteArray, this.this$0.imageView);
                    } else if (SsdInterstitialActivity.adListener != null) {
                        ((com.kc.dw.platform.ad_adapter.interstitial.a) SsdInterstitialActivity.adListener).onAdRenderFail("bitmap加载失败", com.kc.dw.core.exception.b.c.intValue());
                    }
                    try {
                        Bitmap bitmapDecodeByteArray2 = BitmapFactory.decodeByteArray(responseBody, 0, responseBody.length);
                        if (bitmapDecodeByteArray2 != null) {
                            this.this$0.getApplicationContext();
                            this.this$0.imageBg.setImageBitmap(d0.a(bitmapDecodeByteArray2, 25));
                        }
                    } catch (Throwable th) {
                        th.printStackTrace();
                    }
                } else if (this.this$0.imageView != null) {
                    this.this$0.imageView.setBytes(responseBody);
                    this.this$0.imageView.startAnimation();
                }
                this.val$sdkAd.j = System.currentTimeMillis();
                this.this$0.view.post(new j(this) { // from class: com.kc.dw.activity.SsdInterstitialActivity.3.1
                    public final AnonymousClass3 this$1;

                    {
                        this.this$1 = this;
                    }

                    @Override // com.kc.dw.core.safe.j
                    public void safeRun() {
                        this.this$1.this$0.showed = true;
                        this.this$1.val$sdkAd.d();
                        AnonymousClass3 anonymousClass3 = this.this$1;
                        anonymousClass3.this$0.startShake(anonymousClass3.val$adSlot);
                    }
                });
            } catch (Throwable th2) {
                th2.printStackTrace();
            }
        }
    }

    /* JADX INFO: renamed from: com.kc.dw.activity.SsdInterstitialActivity$7, reason: invalid class name */
    @Keep
    public class AnonymousClass7 implements c {
        public final SsdInterstitialActivity this$0;
        public final b val$adSlot;
        public final NormalMediaView val$mediaView;
        public final g val$sdkAd;

        public AnonymousClass7(SsdInterstitialActivity ssdInterstitialActivity, g gVar, NormalMediaView normalMediaView, b bVar) {
            this.this$0 = ssdInterstitialActivity;
            this.val$sdkAd = gVar;
            this.val$mediaView = normalMediaView;
            this.val$adSlot = bVar;
        }

        @Override // com.kc.dw.ad.nativ.c
        public void onPrepareError(int i, String str) {
        }

        @Override // com.kc.dw.ad.nativ.c
        public void onPreparedStartPlay(int i, int i2, boolean z) {
            LogUtil.e(SsdInterstitialActivity.TAG, "onADLoaded");
            this.val$sdkAd.j = System.currentTimeMillis();
            this.val$mediaView.post(new j(this) { // from class: com.kc.dw.activity.SsdInterstitialActivity.7.1
                public final AnonymousClass7 this$1;

                {
                    this.this$1 = this;
                }

                @Override // com.kc.dw.core.safe.j
                public void safeRun() {
                    this.this$1.this$0.showed = true;
                    this.this$1.val$mediaView.start();
                    this.this$1.val$sdkAd.d();
                    AnonymousClass7 anonymousClass7 = this.this$1;
                    anonymousClass7.this$0.startShake(anonymousClass7.val$adSlot);
                }
            });
        }

        @Override // com.kc.dw.ad.nativ.c
        public void onStartDownload() {
        }
    }

    /* JADX INFO: renamed from: com.kc.dw.activity.SsdInterstitialActivity$8, reason: invalid class name */
    @Keep
    public class AnonymousClass8 extends j {
        public final SsdInterstitialActivity this$0;
        public final NormalMediaView val$mediaView;

        public AnonymousClass8(SsdInterstitialActivity ssdInterstitialActivity, NormalMediaView normalMediaView) {
            this.this$0 = ssdInterstitialActivity;
            this.val$mediaView = normalMediaView;
        }

        @Override // com.kc.dw.core.safe.j
        public void safeRun() {
            try {
                Bitmap videoThumb = this.val$mediaView.getVideoThumb();
                if (videoThumb != null) {
                    SdkHandler.getInstance().runOnUiThread(new j(this, videoThumb) { // from class: com.kc.dw.activity.SsdInterstitialActivity.8.1
                        public final AnonymousClass8 this$1;
                        public final Bitmap val$videoThumb;

                        {
                            this.this$1 = this;
                            this.val$videoThumb = videoThumb;
                        }

                        @Override // com.kc.dw.core.safe.j
                        public void safeRun() {
                            try {
                                Bitmap bitmap = this.val$videoThumb;
                                if (bitmap != null) {
                                    Bitmap.Config config = bitmap.getConfig();
                                    Bitmap.Config config2 = Bitmap.Config.ARGB_8888;
                                    Bitmap bitmapCopy = config == config2 ? this.val$videoThumb : this.val$videoThumb.copy(config2, true);
                                    if (bitmapCopy != null) {
                                        this.this$1.this$0.getApplicationContext();
                                        Bitmap bitmapA = d0.a(bitmapCopy, 25);
                                        if (bitmapA != null) {
                                            this.this$1.this$0.imageBg.setImageBitmap(bitmapA);
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
    }

    /* JADX INFO: renamed from: com.kc.dw.activity.SsdInterstitialActivity$9, reason: invalid class name */
    @Keep
    public class AnonymousClass9 extends j {
        public final SsdInterstitialActivity this$0;
        public final b val$adSlot;

        public AnonymousClass9(SsdInterstitialActivity ssdInterstitialActivity, b bVar) {
            this.this$0 = ssdInterstitialActivity;
            this.val$adSlot = bVar;
        }

        @Override // com.kc.dw.core.safe.j
        public void safeRun() {
            try {
                if (h.c(this.val$adSlot.getAct_type())) {
                    this.this$0.isShake = true;
                    int power_index = this.val$adSlot.getPower_index();
                    int power_index2 = this.val$adSlot.getPower_index2();
                    this.this$0.shakeId = ShakeUtil.getInstance().b();
                    int iB = h.b(this.val$adSlot.getAct_type());
                    long jCurrentTimeMillis = System.currentTimeMillis();
                    ShakeUtil.getInstance().a(this.val$adSlot.getPosId(), this.val$adSlot.getLoadedTime(), this.val$adSlot.getDclk());
                    ShakeUtil.getInstance().a(power_index2, power_index, iB, this.val$adSlot.getPower_delay(), this.val$adSlot.getPower_count(), this.this$0.shakeId, this.val$adSlot.getEcpm(), new ShakeUtil.c(this, jCurrentTimeMillis) { // from class: com.kc.dw.activity.SsdInterstitialActivity.9.1
                        public final AnonymousClass9 this$1;
                        public final long val$startShakeTime;

                        {
                            this.this$1 = this;
                            this.val$startShakeTime = jCurrentTimeMillis;
                        }

                        @Override // com.kc.dw.platform.ad_adapter.splash.ShakeUtil.c
                        public void onShake(int i, boolean z, int i2, ShakeResult shakeResult) {
                            ShakeUtil.getInstance().a(this.this$1.this$0.shakeId);
                            if (shakeResult != null) {
                                shakeResult.setTotalTurnTime(System.currentTimeMillis() - this.val$startShakeTime);
                            }
                            g gVar = (g) SsdInterstitialActivity.sdkAd;
                            b bVarC = gVar.a();
                            bVarC.setClkActType(i);
                            bVarC.setClkPower(i2);
                            bVarC.setShakeResult(shakeResult);
                            try {
                                if (this.this$1.this$0.isClickToClose) {
                                    gVar.a().setAdClosed(true);
                                }
                            } catch (Exception e) {
                                e.printStackTrace();
                            }
                            if (SsdInterstitialActivity.msAd != null && SsdInterstitialActivity.msAd.getInteractionListener() != null && this.this$1.val$adSlot.getCbc() == 0) {
                                SsdInterstitialActivity.msAd.getInteractionListener().onAdClicked();
                            }
                            f.a(gVar, i2 >= 50);
                            if (this.this$1.this$0.isClickToClose) {
                                this.this$1.this$0.finish();
                                if (SsdInterstitialActivity.msAd == null || SsdInterstitialActivity.msAd.getInteractionListener() == null) {
                                    return;
                                }
                                SsdInterstitialActivity.msAd.getInteractionListener().onAdClosed();
                            }
                        }
                    });
                    ShakeUtil.getInstance().a(true);
                }
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

    private void handleBdAd() {
        TextView textView;
        String str;
        NativeResponse nativeResponse = (NativeResponse) sdkAd;
        if (nativeResponse.getAdActionType() == 2) {
            this.isDownloadType = true;
        }
        this.downloadAppName = nativeResponse.getBrandName();
        this.downloadAppVersion = nativeResponse.getAppVersion();
        this.downloadAppSize = ((nativeResponse.getAppSize() / 1024) * 1024) + "MB";
        this.downloadAppDeveloper = nativeResponse.getPublisher();
        this.downloadAppPermissionUrl = nativeResponse.getAppPermissionLink();
        this.downloadAppPrivacyAgreement = nativeResponse.getAppPrivacyLink();
        this.downloadAppIntroString = nativeResponse.getDesc();
        this.title.setText(nativeResponse.getTitle());
        this.desc.setText(nativeResponse.getDesc());
        d dVar = new d((Activity) this);
        if (!TextUtils.isEmpty(nativeResponse.getBaiduLogoUrl())) {
            dVar.d = this.adLogo;
            dVar.a(nativeResponse.getBaiduLogoUrl(), false);
        }
        if (!TextUtils.isEmpty(nativeResponse.getIconUrl())) {
            dVar.d = this.logo;
            dVar.a(nativeResponse.getIconUrl(), false);
        }
        if (nativeResponse.getAdActionType() != 2) {
            textView = this.btn;
            str = "点击查看详情";
        } else {
            textView = this.btn;
            str = "点击下载";
        }
        textView.setText(str);
        try {
            if (nativeResponse.getMaterialType().equals(NativeResponse.MaterialType.VIDEO)) {
                ExecutorService executorService = f0.f39362a;
                f0.b.f39363a.a(new AnonymousClass13(this, nativeResponse));
            } else {
                String bDImageUrl = getBDImageUrl(nativeResponse);
                dVar.d = this.imageView;
                dVar.a(bDImageUrl, false);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        ArrayList arrayList = new ArrayList();
        arrayList.add(this.rl_container);
        nativeResponse.registerViewForInteraction(this.rl_container, arrayList, (List) null, new NativeResponse.AdInteractionListener(this) { // from class: com.kc.dw.activity.SsdInterstitialActivity.14
            public final SsdInterstitialActivity this$0;

            {
                this.this$0 = this;
            }

            public void onADExposed() {
                try {
                    if (this.this$0.showed) {
                        return;
                    }
                    if (SsdInterstitialActivity.msAd != null && SsdInterstitialActivity.msAd.getInteractionListener() != null) {
                        SsdInterstitialActivity.msAd.getInteractionListener().onAdExposure();
                    }
                    this.this$0.showed = true;
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
                    LogUtil.d(SsdInterstitialActivity.TAG, "send onAdClicked");
                    if (SsdInterstitialActivity.adWrapper != null && SsdInterstitialActivity.adWrapper.getSdkAdInfo() != null && SsdInterstitialActivity.msAd != null) {
                        z.a(SsdInterstitialActivity.adWrapper.getContext(), f.a(SsdInterstitialActivity.adWrapper.getSdkAdInfo().getClk(), SsdInterstitialActivity.msAd), new com.kc.dw.core.utils.j());
                    }
                    if (SsdInterstitialActivity.msAd == null || SsdInterstitialActivity.msAd.getInteractionListener() == null) {
                        return;
                    }
                    SsdInterstitialActivity.msAd.getInteractionListener().onAdClicked();
                } catch (Throwable th) {
                    th.printStackTrace();
                }
            }

            public void onAdUnionClick() {
            }
        });
    }

    private void handleButton() {
        TextView textView;
        String str;
        try {
            int i = this.act_type;
            if ((i & 4) == 4 || (i & 64) == 64) {
                showShakeInButton();
                if (this.isDownloadType) {
                    textView = this.btn;
                    str = "摇一摇或点击下载三方应用";
                } else {
                    textView = this.btn;
                    str = "摇一摇或点击查看详情";
                }
            } else if (h.e(i)) {
                showShakeInButton();
                if (this.isDownloadType) {
                    textView = this.btn;
                    str = "扭一扭或点击下载三方应用";
                } else {
                    textView = this.btn;
                    str = "扭一扭或点击查看详情";
                }
            } else if (this.isDownloadType) {
                textView = this.btn;
                str = "点击下载三方应用";
            } else {
                textView = this.btn;
                str = "点击查看详情";
            }
            textView.setText(str);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void handleCustomAd() {
        TextView textView;
        String str;
        MsCustomRecyclerFeedAd msCustomRecyclerFeedAd = (MsCustomRecyclerFeedAd) sdkAd;
        if (msCustomRecyclerFeedAd.getInteractionType() == 1) {
            this.isDownloadType = true;
        }
        this.downloadAppName = msCustomRecyclerFeedAd.getAppName();
        this.downloadAppVersion = msCustomRecyclerFeedAd.getAppVersion();
        this.downloadAppSize = msCustomRecyclerFeedAd.getAppSize();
        this.downloadAppDeveloper = msCustomRecyclerFeedAd.getDeveloper();
        this.downloadAppPermissionUrl = msCustomRecyclerFeedAd.getAppPremissionUrl();
        this.downloadAppPrivacyAgreement = msCustomRecyclerFeedAd.getPrivacyAgreement();
        this.downloadAppIntroString = msCustomRecyclerFeedAd.getAppIntroUrl();
        this.title.setVisibility(8);
        this.desc.setText(msCustomRecyclerFeedAd.getDesc());
        int i = 0;
        if (msCustomRecyclerFeedAd.getFromLogo() == null || TextUtils.isEmpty(msCustomRecyclerFeedAd.getFromLogo())) {
            this.logo.setVisibility(8);
        } else {
            this.logo.setVisibility(0);
        }
        d dVar = new d((Activity) this);
        dVar.d = this.logo;
        dVar.a(msCustomRecyclerFeedAd.getFromLogo(), false);
        if (msCustomRecyclerFeedAd.getInteractionType() == 1) {
            textView = this.btn;
            str = "点击下载";
        } else {
            textView = this.btn;
            str = "点击查看详情";
        }
        textView.setText(str);
        ArrayList arrayList = new ArrayList();
        arrayList.add(this.rl_container);
        arrayList.add(this.btn);
        msCustomRecyclerFeedAd.bindAdToView(this, this.rl_container, arrayList, new FeedInteractionListener(this) { // from class: com.kc.dw.activity.SsdInterstitialActivity.16
            public final SsdInterstitialActivity this$0;

            {
                this.this$0 = this;
            }

            @Override // com.kc.dw.core.loader.InteractionListener
            public void onAdClicked() {
                if (SsdInterstitialActivity.intertitialChangeAdapter != null) {
                    SsdInterstitialActivity.intertitialChangeAdapter.changeAdClicked();
                }
            }

            @Override // com.kc.dw.core.loader.InteractionListener
            public void onAdClosed() {
                if (SsdInterstitialActivity.intertitialChangeAdapter != null) {
                    SsdInterstitialActivity.intertitialChangeAdapter.changeAdClosed();
                }
            }

            @Override // com.kc.dw.core.loader.InteractionListener
            public void onAdExposure() {
                com.kc.dw.core.service.logrecord.a.a(5, "s7", SsdInterstitialActivity.adWrapper, new ShowAdState().setSuccess(this.this$0.act_type, 1));
                if (SsdInterstitialActivity.intertitialChangeAdapter != null) {
                    SsdInterstitialActivity.intertitialChangeAdapter.changeAdExposure();
                }
            }
        });
        DisplayMetrics displayMetrics = getResources().getDisplayMetrics();
        float f = displayMetrics.density;
        float f2 = displayMetrics.widthPixels;
        int i2 = (int) (f2 - (70.0f * f));
        if (this.layout_type == 2) {
            i2 = (int) (f2 - (84.0f * f));
        }
        if (msCustomRecyclerFeedAd.getAdPatternType() != 2) {
            String[] imgUrls = msCustomRecyclerFeedAd.getImgUrls();
            if (imgUrls == null || imgUrls.length <= 0) {
                return;
            }
            c0.a(imgUrls[0], new AnonymousClass17(this, displayMetrics, f));
            return;
        }
        View mediaView = msCustomRecyclerFeedAd.getMediaView();
        if (mediaView != null) {
            this.mediaContainer.removeAllViews();
            int width = msCustomRecyclerFeedAd.getWidth();
            int height = msCustomRecyclerFeedAd.getHeight();
            if (width > 0 && height > 0) {
                i = (height * i2) / width;
            }
            this.mediaContainer.addView(mediaView, -1, i);
            IntertitialChangeAdapter intertitialChangeAdapter2 = intertitialChangeAdapter;
            if (intertitialChangeAdapter2 != null) {
                intertitialChangeAdapter2.changeRenderSuccess();
            }
        }
    }

    private void handleGDTAd() {
        TextView textView;
        String str;
        NativeUnifiedADData nativeUnifiedADData = (NativeUnifiedADData) sdkAd;
        NativeUnifiedADAppMiitInfo appMiitInfo = nativeUnifiedADData.getAppMiitInfo();
        if (nativeUnifiedADData.isAppAd()) {
            this.isDownloadType = true;
        }
        if (appMiitInfo != null) {
            this.downloadAppName = appMiitInfo.getAppName();
            this.downloadAppVersion = appMiitInfo.getVersionName();
            this.downloadAppSize = ((appMiitInfo.getPackageSizeBytes() / 1024) * 1024) + "MB";
            this.downloadAppDeveloper = appMiitInfo.getAuthorName();
            this.downloadAppPermissionUrl = appMiitInfo.getPermissionsUrl();
            this.downloadAppPrivacyAgreement = appMiitInfo.getPrivacyAgreement();
        }
        nativeUnifiedADData.getPictureWidth();
        nativeUnifiedADData.getPictureHeight();
        this.title.setText(nativeUnifiedADData.getTitle());
        this.desc.setText(nativeUnifiedADData.getDesc());
        float f = getResources().getDisplayMetrics().density;
        new ArrayList().add(this.mediaContainer);
        d dVar = new d((Activity) this);
        if (!TextUtils.isEmpty(nativeUnifiedADData.getIconUrl())) {
            dVar.d = this.logo;
            dVar.a(nativeUnifiedADData.getIconUrl(), false);
        }
        if (nativeUnifiedADData.isAppAd()) {
            textView = this.btn;
            str = "点击下载";
        } else {
            textView = this.btn;
            str = "点击查看详情";
        }
        textView.setText(str);
        this.adLogo.setImageResource(R.drawable.ssd_gdt_logo);
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
        nativeUnifiedADData.setNativeAdEventListener(new NativeADEventListener(this) { // from class: com.kc.dw.activity.SsdInterstitialActivity.10
            public final SsdInterstitialActivity this$0;

            {
                this.this$0 = this;
            }

            public void onADClicked() {
                try {
                    if (SsdInterstitialActivity.adWrapper != null && SsdInterstitialActivity.adWrapper.getSdkAdInfo() != null && SsdInterstitialActivity.msAd != null) {
                        LogUtil.d(SsdInterstitialActivity.TAG, "send onADClicked");
                        z.a(this.this$0.getApplicationContext(), f.a(SsdInterstitialActivity.adWrapper.getSdkAdInfo().getClk(), SsdInterstitialActivity.msAd), new com.kc.dw.core.utils.j());
                    }
                    if (SsdInterstitialActivity.msAd == null || SsdInterstitialActivity.msAd.getInteractionListener() == null) {
                        return;
                    }
                    SsdInterstitialActivity.msAd.getInteractionListener().onAdClicked();
                } catch (Throwable th) {
                    th.printStackTrace();
                }
            }

            public void onADError(AdError adError) {
            }

            public void onADExposed() {
                try {
                    if (SsdInterstitialActivity.adWrapper == null || SsdInterstitialActivity.adWrapper.getLoaderListener() == null || this.this$0.showed) {
                        return;
                    }
                    this.this$0.showed = true;
                    if (SsdInterstitialActivity.msAd == null || SsdInterstitialActivity.msAd.getInteractionListener() == null) {
                        return;
                    }
                    SsdInterstitialActivity.msAd.getInteractionListener().onAdExposure();
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
            dVar.d = this.imageView;
            dVar.a(imageUrl, false);
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
        nativeUnifiedADData.bindMediaView(mediaView, builder.build(), new NativeADMediaListener(this) { // from class: com.kc.dw.activity.SsdInterstitialActivity.11
            public final SsdInterstitialActivity this$0;

            {
                this.this$0 = this;
            }

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

    private void handleKsAd() {
        TextView textView;
        String str;
        KsNativeAd ksNativeAd = (KsNativeAd) sdkAd;
        if (ksNativeAd.getInteractionType() == 1) {
            this.isDownloadType = true;
        }
        this.downloadAppName = ksNativeAd.getAppName();
        this.downloadAppVersion = ksNativeAd.getAppVersion();
        this.downloadAppSize = ((ksNativeAd.getAppPackageSize() / 1024) * 1024) + "MB";
        this.downloadAppDeveloper = ksNativeAd.getCorporationName();
        this.downloadAppPermissionUrl = ksNativeAd.getPermissionInfoUrl();
        this.downloadAppPrivacyAgreement = ksNativeAd.getAppPrivacyUrl();
        this.downloadAppIntroString = ksNativeAd.getAdDescription();
        this.title.setVisibility(8);
        this.desc.setText(ksNativeAd.getAdDescription());
        d dVar = new d((Activity) this);
        dVar.d = this.logo;
        int i = 0;
        dVar.a(ksNativeAd.getAppIconUrl(), false);
        dVar.d = this.adLogo;
        dVar.c(R.drawable.ssd_ksad_sdk_logo);
        if (ksNativeAd.getInteractionType() == 1) {
            textView = this.btn;
            str = "点击下载";
        } else {
            textView = this.btn;
            str = "点击查看详情";
        }
        textView.setText(str);
        ArrayList arrayList = new ArrayList();
        arrayList.add(this.rl_container);
        arrayList.add(this.btn);
        ksNativeAd.registerViewForInteraction(this.rl_container, arrayList, new KsNativeAd.AdInteractionListener(this) { // from class: com.kc.dw.activity.SsdInterstitialActivity.12
            public final SsdInterstitialActivity this$0;

            {
                this.this$0 = this;
            }

            @Override // com.kwad.sdk.api.KsNativeAd.AdInteractionListener
            public boolean handleDownloadDialog(DialogInterface.OnClickListener onClickListener) {
                return false;
            }

            @Override // com.kwad.sdk.api.KsNativeAd.AdInteractionListener
            public void onAdClicked(View view, KsNativeAd ksNativeAd2) {
                try {
                    LogUtil.d(SsdInterstitialActivity.TAG, "send onAdClicked");
                    if (SsdInterstitialActivity.adWrapper != null && SsdInterstitialActivity.adWrapper.getSdkAdInfo() != null && SsdInterstitialActivity.msAd != null) {
                        z.a(SsdInterstitialActivity.adWrapper.getContext(), f.a(SsdInterstitialActivity.adWrapper.getSdkAdInfo().getClk(), SsdInterstitialActivity.msAd), new com.kc.dw.core.utils.j());
                    }
                    if (SsdInterstitialActivity.msAd == null || SsdInterstitialActivity.msAd.getInteractionListener() == null) {
                        return;
                    }
                    SsdInterstitialActivity.msAd.getInteractionListener().onAdClicked();
                } catch (Throwable th) {
                    th.printStackTrace();
                }
            }

            @Override // com.kwad.sdk.api.KsNativeAd.AdInteractionListener
            public void onAdShow(KsNativeAd ksNativeAd2) {
                try {
                    if (this.this$0.showed) {
                        return;
                    }
                    if (SsdInterstitialActivity.msAd != null && SsdInterstitialActivity.msAd.getInteractionListener() != null) {
                        SsdInterstitialActivity.msAd.getInteractionListener().onAdExposure();
                    }
                    this.this$0.showed = true;
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
            View videoView = ksNativeAd.getVideoView(this, new KsAdVideoPlayConfig.Builder().videoSoundEnable(false).build());
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
        dVar.d = this.imageView;
        dVar.a(imageUrl, false);
        if (width > 0 && height > 0) {
            i = (height * i2) / width;
        }
        ViewGroup.LayoutParams layoutParams = this.imageView.getLayoutParams();
        layoutParams.height = i;
        layoutParams.width = -1;
        this.imageView.setLayoutParams(layoutParams);
    }

    private void handleMsAd() {
        TextView textView;
        ShakeUtil.getInstance().e();
        g gVar = (g) sdkAd;
        b bVarC = gVar.a();
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
        if (gVar.getInteractionType() == 1) {
            this.isDownloadType = true;
        }
        this.downloadAppName = bVarC.getAppName();
        this.downloadAppVersion = bVarC.getApp_ver();
        this.downloadAppSize = bVarC.getApp_size();
        this.downloadAppDeveloper = bVarC.getDeveloper();
        this.downloadAppPermissionUrl = bVarC.getApp_permission_url();
        this.downloadAppPermissionList = bVarC.getApp_permission();
        this.downloadAppPrivacyAgreement = bVarC.getPrivacy_agreement();
        this.downloadAppIntroString = bVarC.getApp_intro();
        this.downloadAppIntroUrl = bVarC.getApp_intor_url();
        this.downloadAppPaymentTypes = bVarC.getPayment_types();
        d dVar = new d((Activity) this);
        if (this.layout_type == 1) {
            String desc = "";
            if (TextUtils.isEmpty(bVarC.f39094a)) {
                this.title.setText("");
                this.title.setVisibility(8);
            } else {
                this.title.setVisibility(0);
                this.title.setText(bVarC.f39094a);
            }
            if (TextUtils.isEmpty(bVarC.getDesc())) {
                this.desc.setVisibility(8);
                textView = this.desc;
            } else {
                this.desc.setVisibility(0);
                textView = this.desc;
                desc = bVarC.getDesc();
            }
            textView.setText(desc);
        }
        if (this.logo != null) {
            if (TextUtils.isEmpty(bVarC.getIconUrl())) {
                dVar.d = this.logo;
                dVar.d(8);
            } else {
                dVar.d = this.logo;
                dVar.d(0);
                dVar.d = this.logo;
                dVar.a(bVarC.getIconUrl(), false);
            }
        }
        this.adLogoLL.setBackground(getResources().getDrawable(R.drawable.ssd_black_oval_gray));
        if (TextUtils.isEmpty(bVarC.getFromLogo())) {
            dVar.d = this.adLogo;
            Drawable drawable = getResources().getDrawable(R.drawable.ssd_ad);
            View view = dVar.d;
            if (view instanceof ImageView) {
                ((ImageView) view).setImageDrawable(drawable);
            }
        } else {
            dVar.d = this.adLogo;
            dVar.a(bVarC.getFromLogo(), false);
        }
        if (!TextUtils.isEmpty(bVarC.getCid())) {
            this.cid.setText(bVarC.getCid());
        }
        StringBuilder sbA = a.a("adSlot.getAdPatternType()=");
        sbA.append(bVarC.getAdPatternType());
        LogUtil.d(TAG, sbA.toString());
        if (gVar.h == 0) {
            gVar.h = System.currentTimeMillis();
        }
        if (bVarC.getAdPatternType() == 2) {
            loadNativeVideo(dVar, bVarC, gVar);
        } else {
            c0.a(bVarC.getImageUrls()[0], new AnonymousClass3(this, bVarC, gVar));
        }
        gVar.setAdView(this.rootView);
        if ((bVarC.getAct_type() & 1) == 1) {
            this.rl_container.setOnClickListener(new m(this, bVarC, gVar) { // from class: com.kc.dw.activity.SsdInterstitialActivity.4
                public final SsdInterstitialActivity this$0;
                public final b val$adSlot;
                public final g val$sdkAd;

                {
                    this.this$0 = this;
                    this.val$adSlot = bVarC;
                    this.val$sdkAd = gVar;
                }

                @Override // com.kc.dw.core.safe.m
                public void safeOnClick(View view2) {
                    if (this.this$0.showed) {
                        this.val$adSlot.setClkActType(1);
                        try {
                            if (this.this$0.isClickToClose) {
                                this.val$sdkAd.a().setAdClosed(true);
                            }
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                        if (SsdInterstitialActivity.msAd != null && SsdInterstitialActivity.msAd.getInteractionListener() != null && this.val$adSlot.getCbc() == 0) {
                            SsdInterstitialActivity.msAd.getInteractionListener().onAdClicked();
                        }
                        f.a((com.kc.dw.platform.ad_adapter.c) this.val$sdkAd, true);
                        if (this.this$0.isClickToClose) {
                            this.this$0.finish();
                            if (SsdInterstitialActivity.msAd == null || SsdInterstitialActivity.msAd.getInteractionListener() == null) {
                                return;
                            }
                            SsdInterstitialActivity.msAd.getInteractionListener().onAdClosed();
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
        this.btn.setOnClickListener(new m(this, bVarC, gVar) { // from class: com.kc.dw.activity.SsdInterstitialActivity.5
            public final SsdInterstitialActivity this$0;
            public final b val$adSlot;
            public final g val$sdkAd;

            {
                this.this$0 = this;
                this.val$adSlot = bVarC;
                this.val$sdkAd = gVar;
            }

            @Override // com.kc.dw.core.safe.m
            public void safeOnClick(View view2) {
                if (this.this$0.showed) {
                    this.val$adSlot.setClkActType(2);
                    if (SsdInterstitialActivity.msAd != null && SsdInterstitialActivity.msAd.getInteractionListener() != null && this.val$adSlot.getCbc() == 0) {
                        SsdInterstitialActivity.msAd.getInteractionListener().onAdClicked();
                    }
                    f.a((com.kc.dw.platform.ad_adapter.c) this.val$sdkAd, true);
                    if (this.this$0.isClickToClose) {
                        this.this$0.finish();
                        if (SsdInterstitialActivity.msAd == null || SsdInterstitialActivity.msAd.getInteractionListener() == null) {
                            return;
                        }
                        SsdInterstitialActivity.msAd.getInteractionListener().onAdClosed();
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
                if (sdkAd instanceof g) {
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
            try {
                if (sdkAd instanceof MsCustomRecyclerFeedAd) {
                    handleCustomAd();
                }
            } catch (Throwable th5) {
                th5.printStackTrace();
            }
            handleButton();
            handleDownloadView();
        }
    }

    private void initView() {
        TouchAdContainer touchAdContainer;
        try {
            this.touchAdContainer = (TouchAdContainer) findViewById(R.id.ssd_activity_sdk_interstitial_touchAdContainer);
            this.startActionShakeImage = (GifImageView) findViewById(R.id.ms_action_shakeImage);
            this.mediaContainer = (RelativeLayout) findViewById(R.id.ssd_activity_sdk_interstitial_mediaContainer);
            this.imageView = (GifImageView) findViewById(R.id.ssd_activity_sdk_interstitial_imageview);
            this.imageBg = (ImageView) findViewById(R.id.ssd_activity_sdk_interstitial_imageBg);
            this.closeImage = (ImageView) findViewById(R.id.ssd_activity_sdk_interstitial_cacel);
            this.adLogo = (ImageView) findViewById(R.id.ms_activity_sdk_interstitial_adLogo);
            this.cid = (TextView) findViewById(R.id.ms_layout_native_interstitial_cid);
            this.rl_container = (RelativeLayout) findViewById(R.id.ssd_activity_sdk_interstitial_rl_container);
            this.adLogoLL = (LinearLayout) findViewById(R.id.ms_activity_sdk_interstitial_adLogoLL);
            this.logo = (ImageView) findViewById(R.id.ssd_activity_sdk_interstitial_logo);
            this.title = (TextView) findViewById(R.id.ssd_activity_sdk_interstitial_title);
            this.desc = (TextView) findViewById(R.id.ssd_activity_sdk_interstitial_desc);
            this.btn = (TextView) findViewById(R.id.ssd_activity_sdk_interstitial_btn);
            IAd iAd = msAd;
            if (iAd != null && (touchAdContainer = this.touchAdContainer) != null) {
                touchAdContainer.setTouchPositionListener(new TouchPositionListener(iAd));
            }
            this.closeImage.setOnClickListener(new m(this) { // from class: com.kc.dw.activity.SsdInterstitialActivity.1
                public final SsdInterstitialActivity this$0;

                {
                    this.this$0 = this;
                }

                @Override // com.kc.dw.core.safe.m
                public void safeOnClick(View view) {
                    this.this$0.finish();
                    if (SsdInterstitialActivity.msAd == null || SsdInterstitialActivity.msAd.getInteractionListener() == null) {
                        return;
                    }
                    SsdInterstitialActivity.msAd.getInteractionListener().onAdClosed();
                }
            });
        } catch (Exception e) {
            e.printStackTrace();
        }
        this.adLogoLL.post(new Runnable(this) { // from class: com.kc.dw.activity.SsdInterstitialActivity.2
            public final SsdInterstitialActivity this$0;

            {
                this.this$0 = this;
            }

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
                    SsdInterstitialActivity ssdInterstitialActivity = this.this$0;
                    int navigationBarHeight = ssdInterstitialActivity.getNavigationBarHeight(ssdInterstitialActivity);
                    if (navigationBarHeight > 0) {
                        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.this$0.adLogoLL.getLayoutParams();
                        layoutParams.bottomMargin = navigationBarHeight + 15;
                        this.this$0.adLogoLL.setLayoutParams(layoutParams);
                    }
                } catch (Throwable th) {
                    th.printStackTrace();
                }
            }
        });
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

    private void loadNativeVideo(d dVar, b bVar, g gVar) {
        try {
            gVar.j = System.currentTimeMillis();
            DisplayMetrics displayMetrics = getResources().getDisplayMetrics();
            int i = displayMetrics.widthPixels;
            float f = i;
            float f2 = displayMetrics.density;
            int i2 = (int) (f - (70.0f * f2));
            int i3 = (int) (f2 * 200.0f);
            try {
                if (this.layout_type == 2) {
                    double d = ((double) i) * 0.86d;
                    i3 = (int) ((((double) this.layout_height) * d) / ((double) this.layout_width));
                    i2 = (int) d;
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
            NormalMediaView normalMediaView = new NormalMediaView(this);
            normalMediaView.setContainerWidth(i2);
            normalMediaView.setContainerHeight(i3);
            normalMediaView.setPlayOnce(true);
            normalMediaView.f();
            normalMediaView.setUseTransform(false);
            normalMediaView.setFromLogoVisibility(8);
            normalMediaView.setFromLogo(null);
            normalMediaView.setPreparedStartPlayListener(new AnonymousClass7(this, gVar, normalMediaView, bVar));
            this.mediaContainer.removeAllViews();
            normalMediaView.setVideoPath(bVar.getImageUrls()[0]);
            if (bVar.getScale_type() == 9) {
                normalMediaView.setDisplayMode(2);
                this.mediaContainer.addView(normalMediaView, -1, -1);
            } else {
                normalMediaView.setDisplayMode(1);
                RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -2);
                layoutParams.addRule(13, -1);
                this.mediaContainer.addView(normalMediaView, layoutParams);
            }
            this.imageBg.setVisibility(0);
            ExecutorService executorService = f0.f39362a;
            f0.b.f39363a.a(new AnonymousClass8(this, normalMediaView));
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public static void setAdListener(com.kc.dw.ad.interstitial.a aVar) {
        try {
            adListener = aVar;
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void setAdWrapper(BasePlatformLoader basePlatformLoader) {
        adWrapper = basePlatformLoader;
    }

    public static void setCustomAd(IntertitialChangeAdapter intertitialChangeAdapter2) {
        intertitialChangeAdapter = intertitialChangeAdapter2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code restructure failed: missing block: B:32:0x008d, code lost:
    
        if (((r12.getWidth() * 1.0f) / r7) > ((r12.getHeight() * 1.0f) / r8)) goto L24;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
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
        }
        try {
            switch (i) {
                case 1:
                    if ((bitmap.getHeight() * 1.0f) / i3 > (bitmap.getWidth() * 1.0f) / i4) {
                        fullWidthImage(bitmap, gifImageView, i4, i3, i);
                    }
                    fullHeightImage(bitmap, gifImageView, i4, i3, i);
                    break;
                case 2:
                default:
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

    private void showShakeInButton() {
        Drawable drawable = getResources().getDrawable(R.drawable.ssd_shake_angle);
        drawable.setBounds(0, 0, 100, 100);
        this.btn.setPadding(20, 0, 60, 0);
        this.btn.setCompoundDrawables(drawable, null, null, null);
    }

    private void showStartShakeImage() {
        this.startActionShakeImage.setVisibility(0);
        byte[] imageBytes = getImageBytes(this, R.raw.ssd_new_shake);
        if (imageBytes != null && imageBytes.length > 0) {
            this.startActionShakeImage.setBytes(imageBytes, 1);
            this.startActionShakeImage.startAnimation();
        }
        new Handler().postDelayed(new j(this) { // from class: com.kc.dw.activity.SsdInterstitialActivity.6
            public final SsdInterstitialActivity this$0;

            {
                this.this$0 = this;
            }

            @Override // com.kc.dw.core.safe.j
            public void safeRun() {
                this.this$0.startActionShakeImage.clear();
                this.this$0.startActionShakeImage.setVisibility(8);
            }
        }, 2000L);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void startShake(b bVar) {
        this.rootView.post(new AnonymousClass9(this, bVar));
    }

    public int getNavigationBarHeight(Context context) {
        try {
            Resources resources = context.getResources();
            int identifier = resources.getIdentifier(com.gyf.immersionbar.b.f6803b, "dimen", "android");
            if (identifier > 0) {
                return resources.getDimensionPixelSize(identifier);
            }
            return 0;
        } catch (Throwable th) {
            th.printStackTrace();
            return 0;
        }
    }

    public void handleDownloadView() {
        try {
            LogUtil.d(TAG, "handleDownloadView: interactionType=" + this.isDownloadType);
            if (this.isDownloadType) {
                TextView textView = (TextView) findViewById(R.id.ssd_download_layer_textview);
                textView.setVisibility(0);
                StringBuilder sb = new StringBuilder();
                if (!TextUtils.isEmpty(this.downloadAppName)) {
                    sb.append("应用名称：");
                    sb.append(this.downloadAppName);
                    sb.append(" |");
                }
                if (!TextUtils.isEmpty(this.downloadAppVersion)) {
                    sb.append(" 应用版本：");
                    sb.append(this.downloadAppVersion);
                    sb.append(" |");
                }
                if (!TextUtils.isEmpty(this.downloadAppSize)) {
                    sb.append(" 应用大小：");
                    sb.append(this.downloadAppSize);
                    sb.append(" |");
                }
                if (!TextUtils.isEmpty(this.downloadAppDeveloper)) {
                    sb.append(" 开发者：");
                    sb.append(this.downloadAppDeveloper);
                    sb.append(" |");
                }
                if (!TextUtils.isEmpty(this.downloadAppPermissionUrl) || this.downloadAppPermissionList != null) {
                    sb.append(" 权限详情>");
                    sb.append(" |");
                }
                if (!TextUtils.isEmpty(this.downloadAppPrivacyAgreement)) {
                    sb.append(" 隐私协议 > ");
                    sb.append(" |");
                }
                if (!TextUtils.isEmpty(this.downloadAppIntroUrl) || !TextUtils.isEmpty(this.downloadAppIntroString)) {
                    sb.append(" 功能介绍>");
                }
                String string = sb.toString();
                if (TextUtils.isEmpty(string)) {
                    textView.setVisibility(8);
                } else if (string.endsWith("|")) {
                    string = string.substring(0, string.length() - 1);
                }
                textView.setText(string);
                textView.setOnClickListener(new m(this) { // from class: com.kc.dw.activity.SsdInterstitialActivity.15
                    public final SsdInterstitialActivity this$0;

                    {
                        this.this$0 = this;
                    }

                    @Override // com.kc.dw.core.safe.m
                    public void safeOnClick(View view) {
                        try {
                            DownloadDialogBean downloadDialogBean = new DownloadDialogBean();
                            downloadDialogBean.setApp_name(this.this$0.downloadAppName);
                            downloadDialogBean.setApp_size(this.this$0.downloadAppSize);
                            downloadDialogBean.setDeveloper(this.this$0.downloadAppDeveloper);
                            downloadDialogBean.setPayment_types(this.this$0.downloadAppPaymentTypes);
                            downloadDialogBean.setApp_permission(this.this$0.downloadAppPermissionList);
                            downloadDialogBean.setApp_permission_url(this.this$0.downloadAppPermissionUrl);
                            downloadDialogBean.setApp_intro(this.this$0.downloadAppIntroString);
                            downloadDialogBean.setApp_intor_url(this.this$0.downloadAppIntroUrl);
                            downloadDialogBean.setApp_private_agreement(this.this$0.downloadAppPrivacyAgreement);
                            SsdDownloadDetailActivity.startActivity(this.this$0, downloadDialogBean);
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                    }
                });
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    @Override // android.app.Activity
    public void onBackPressed() {
    }

    @Override // android.app.Activity, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
        initView();
        super.onConfigurationChanged(configuration);
    }

    @Override // com.kc.dw.core.safe.SafeActivity
    public void safeOnCreate(Bundle bundle) {
        super.safeOnCreate(bundle);
        setContentView(R.layout.ssd_activity_sdk_interstitial);
        try {
            getWindow().getDecorView().setSystemUiVisibility(1792);
            getWindow().setNavigationBarColor(0);
            getWindow().setStatusBarColor(0);
        } catch (Throwable th) {
            th.printStackTrace();
        }
        com.kc.dw.core.service.logrecord.a.a(5, "e7", adWrapper);
        Intent intent = getIntent();
        this.isVideoAutoPlay = intent.getBooleanExtra("isVideoAutoPlay", true);
        this.isClickToClose = intent.getBooleanExtra("isClickToClose", false);
        this.act_type = intent.getIntExtra("act_type", 2);
        this.layout_type = intent.getIntExtra("layout_type", 1);
        this.layout_width = intent.getIntExtra("layout_width", 0);
        this.layout_height = intent.getIntExtra("layout_height", 0);
        this.rootView = (RelativeLayout) findViewById(R.id.ms_activity_sdk_interstitial_rootView);
        this.view = View.inflate(this, R.layout.ssd_layout_sdk_interstitial_1, null);
        if (this.layout_type == 2) {
            this.view = View.inflate(this, R.layout.ssd_layout_sdk_interstitial_2, null);
        }
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -1);
        layoutParams.addRule(13);
        this.rootView.addView(this.view, layoutParams);
        initView();
    }

    @Override // com.kc.dw.core.safe.SafeActivity
    public void safeOnDestroy() {
        super.safeOnDestroy();
        sdkAd = null;
        adWrapper = null;
        msAd = null;
        adListener = null;
        ShakeUtil.getInstance().a(this.shakeId);
    }

    @Override // com.kc.dw.core.safe.SafeActivity
    public void safeOnPause() {
        super.safeOnPause();
        if (this.isShake) {
            ShakeUtil.getInstance().e();
        }
    }

    @Override // com.kc.dw.core.safe.SafeActivity
    public void safeOnResume() {
        super.safeOnResume();
        if (this.isShake) {
            ShakeUtil.getInstance().f();
        }
    }
}

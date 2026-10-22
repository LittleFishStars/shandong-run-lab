package com.kc.dw.gather.gdt.splash;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.google.gson.Gson;
import com.kc.dw.activity.SsdDownloadDetailActivity;
import com.kc.dw.activity.SsdWebviewActivity;
import com.kc.dw.ad.splash.SplashSkipView;
import com.kc.dw.ad.splash.SsdSplashRootView;
import com.kc.dw.core.ad.SsdAdSlot;
import com.kc.dw.core.bquery.d;
import com.kc.dw.core.domain.HttpResponse;
import com.kc.dw.core.exception.b;
import com.kc.dw.core.loader.serverbidding.S2sbResultBean;
import com.kc.dw.core.safe.m;
import com.kc.dw.core.utils.DownloadDialogBean;
import com.kc.dw.core.utils.c0;
import com.kc.dw.core.utils.d0;
import com.kc.dw.core.utils.h;
import com.kc.dw.core.utils.h0;
import com.kc.dw.core.utils.x;
import com.kc.dw.core.view.gif.GifImageView;
import com.kc.dw.platform.custom.CustomInfo;
import com.kc.dw.platform.custom.splash.MsCustomSplashAdapter;
import com.kc.openset.R;
import com.qihoo.SdkProtected.OSETSDK.Keep;
import com.qq.e.ads.cfg.VideoOption;
import com.qq.e.ads.nativ.MediaView;
import com.qq.e.ads.nativ.NativeADEventListener;
import com.qq.e.ads.nativ.NativeADMediaListener;
import com.qq.e.ads.nativ.NativeADUnifiedListener;
import com.qq.e.ads.nativ.NativeUnifiedAD;
import com.qq.e.ads.nativ.NativeUnifiedADAppMiitInfo;
import com.qq.e.ads.nativ.NativeUnifiedADData;
import com.qq.e.ads.nativ.widget.NativeAdContainer;
import com.qq.e.comm.util.AdError;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
@Keep
public class GDTFeedSplashAdapter extends MsCustomSplashAdapter {
    private SsdSplashRootView adRoot;
    private Bitmap bitmapBlur;
    private int height;
    private Bitmap imgBitmap;
    private boolean isVertical;
    private boolean showed;
    private SplashSkipView splashSkipView;
    private int width;

    private String getImageUrl(NativeUnifiedADData nativeUnifiedADData) {
        if (TextUtils.isEmpty(nativeUnifiedADData.getImgUrl())) {
            return (nativeUnifiedADData.getImgList() == null || nativeUnifiedADData.getImgList().size() <= 0) ? "" : (String) nativeUnifiedADData.getImgList().get(0);
        }
        return nativeUnifiedADData.getImgUrl();
    }

    private void handleDownloadView(SsdSplashRootView ssdSplashRootView, NativeUnifiedADData nativeUnifiedADData) {
        if (nativeUnifiedADData.isAppAd()) {
            ((RelativeLayout) ssdSplashRootView.findViewById(R.id.ms_download_layer_root_view)).setVisibility(0);
            TextView textView = (TextView) ssdSplashRootView.findViewById(R.id.ms_download_layer_app_name);
            TextView textView2 = (TextView) ssdSplashRootView.findViewById(R.id.ms_download_layer_app_version);
            TextView textView3 = (TextView) ssdSplashRootView.findViewById(R.id.ms_download_layer_app_size);
            TextView textView4 = (TextView) ssdSplashRootView.findViewById(R.id.ms_download_layer_app_owner);
            TextView textView5 = (TextView) ssdSplashRootView.findViewById(R.id.ms_download_layer_app_privacy);
            TextView textView6 = (TextView) ssdSplashRootView.findViewById(R.id.ms_download_layer_app_permission);
            TextView textView7 = (TextView) ssdSplashRootView.findViewById(R.id.ms_download_layer_app_introduce);
            NativeUnifiedADAppMiitInfo appMiitInfo = nativeUnifiedADData.getAppMiitInfo();
            textView.setText(appMiitInfo.getAppName());
            textView2.setText(appMiitInfo.getVersionName());
            textView3.setText(((appMiitInfo.getPackageSizeBytes() / 1024) * 1024) + "Mb");
            textView4.setText(appMiitInfo.getAuthorName());
            textView5.setOnClickListener(new m(this, appMiitInfo, ssdSplashRootView) { // from class: com.kc.dw.gather.gdt.splash.GDTFeedSplashAdapter.7
                public final GDTFeedSplashAdapter this$0;
                public final SsdSplashRootView val$adRoot;
                public final NativeUnifiedADAppMiitInfo val$appInfo;

                {
                    this.this$0 = this;
                    this.val$appInfo = appMiitInfo;
                    this.val$adRoot = ssdSplashRootView;
                }

                @Override // com.kc.dw.core.safe.m
                public void safeOnClick(View view) {
                    try {
                        String privacyAgreement = this.val$appInfo.getPrivacyAgreement();
                        Intent intent = new Intent(this.val$adRoot.getContext(), (Class<?>) SsdWebviewActivity.class);
                        intent.putExtra("EXTRA_AD_DURL_KEY", new String[]{privacyAgreement});
                        this.val$adRoot.getContext().startActivity(intent);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            });
            textView6.setOnClickListener(new m(this, appMiitInfo, ssdSplashRootView) { // from class: com.kc.dw.gather.gdt.splash.GDTFeedSplashAdapter.8
                public final GDTFeedSplashAdapter this$0;
                public final SsdSplashRootView val$adRoot;
                public final NativeUnifiedADAppMiitInfo val$appInfo;

                {
                    this.this$0 = this;
                    this.val$appInfo = appMiitInfo;
                    this.val$adRoot = ssdSplashRootView;
                }

                @Override // com.kc.dw.core.safe.m
                public void safeOnClick(View view) {
                    try {
                        DownloadDialogBean downloadDialogBean = new DownloadDialogBean();
                        downloadDialogBean.setApp_name(this.val$appInfo.getAppName());
                        downloadDialogBean.setApp_intro(this.val$appInfo.getDescriptionUrl());
                        downloadDialogBean.setApp_privacy(this.val$appInfo.getPrivacyAgreement());
                        downloadDialogBean.setApp_size(((this.val$appInfo.getPackageSizeBytes() / 1024) * 1024) + "Mb");
                        downloadDialogBean.setDeveloper(this.val$appInfo.getAuthorName());
                        downloadDialogBean.setApp_intor_url(this.val$appInfo.getDescriptionUrl());
                        SsdDownloadDetailActivity.startActivity(this.val$adRoot.getContext(), downloadDialogBean);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            });
            textView7.setOnClickListener(new m(this, appMiitInfo, ssdSplashRootView) { // from class: com.kc.dw.gather.gdt.splash.GDTFeedSplashAdapter.9
                public final GDTFeedSplashAdapter this$0;
                public final SsdSplashRootView val$adRoot;
                public final NativeUnifiedADAppMiitInfo val$appInfo;

                {
                    this.this$0 = this;
                    this.val$appInfo = appMiitInfo;
                    this.val$adRoot = ssdSplashRootView;
                }

                @Override // com.kc.dw.core.safe.m
                public void safeOnClick(View view) {
                    try {
                        DownloadDialogBean downloadDialogBean = new DownloadDialogBean();
                        downloadDialogBean.setApp_name(this.val$appInfo.getAppName());
                        downloadDialogBean.setApp_intro(this.val$appInfo.getDescriptionUrl());
                        downloadDialogBean.setApp_privacy(this.val$appInfo.getPrivacyAgreement());
                        downloadDialogBean.setApp_size(((this.val$appInfo.getPackageSizeBytes() / 1024) * 1024) + "Mb");
                        downloadDialogBean.setDeveloper(this.val$appInfo.getAuthorName());
                        downloadDialogBean.setApp_intor_url(this.val$appInfo.getDescriptionUrl());
                        SsdDownloadDetailActivity.startActivity(this.val$adRoot.getContext(), downloadDialogBean);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code duplicated, block: B:38:0x01fd  */
    /* JADX WARN: Code duplicated, block: B:41:0x0225  */
    /* JADX WARN: Code duplicated, block: B:42:0x0229  */
    /* JADX WARN: Code duplicated, block: B:45:0x0242  */
    /* JADX WARN: Code duplicated, block: B:47:0x0252  */
    /* JADX WARN: Code duplicated, block: B:48:0x025a  */
    /* JADX WARN: Code duplicated, block: B:51:0x028b  */
    public void showNativeLayout(NativeUnifiedADData nativeUnifiedADData) {
        RelativeLayout relativeLayout;
        TextView textView;
        int i;
        NativeAdContainer nativeAdContainer;
        ViewGroup viewGroup;
        ArrayList arrayList;
        Bitmap bitmap;
        ViewGroup.LayoutParams layoutParams;
        int i2;
        SsdSplashRootView ssdSplashRootView = (SsdSplashRootView) LayoutInflater.from(this.context).inflate(R.layout.ssd_layout_native_splash, (ViewGroup) null);
        this.adRoot = ssdSplashRootView;
        showSkipView(ssdSplashRootView);
        if (this.loadListener != null && getSdkAdInfo() != null) {
            setEcpm(nativeUnifiedADData.getECPM());
        }
        DisplayMetrics displayMetrics = this.context.getResources().getDisplayMetrics();
        ImageView imageView = (ImageView) this.adRoot.findViewById(R.id.ssd_layout_native_splash_bg);
        RelativeLayout relativeLayout2 = (RelativeLayout) this.adRoot.findViewById(R.id.ssd_native_splash_ad_container);
        View viewInflate = View.inflate(this.context, R.layout.ssd_layout_native_splash_1, null);
        if (this.isVertical) {
            viewInflate = View.inflate(this.context, R.layout.ssd_layout_native_splash_2, null);
        }
        relativeLayout2.addView(viewInflate, -1, -1);
        RelativeLayout relativeLayout3 = (RelativeLayout) viewInflate.findViewById(R.id.activity_sdk_splash_mediaContainer);
        LinearLayout linearLayout = (LinearLayout) viewInflate.findViewById(R.id.ssd_layout_native_splash_ll);
        GifImageView gifImageView = (GifImageView) viewInflate.findViewById(R.id.layout_native_splash_imageview);
        TextView textView2 = (TextView) viewInflate.findViewById(R.id.layout_native_splash_title);
        ImageView imageView2 = (ImageView) viewInflate.findViewById(R.id.layout_native_splash_icon);
        ImageView imageView3 = (ImageView) viewInflate.findViewById(R.id.layout_native_splash_score);
        TextView textView3 = (TextView) viewInflate.findViewById(R.id.layout_native_splash_desc);
        ImageView imageView4 = (ImageView) this.adRoot.findViewById(R.id.ssd_layout_native_splash_logo);
        TextView textView4 = (TextView) this.adRoot.findViewById(R.id.ssd_layout_native_splash_cid);
        TextView textView5 = (TextView) viewInflate.findViewById(R.id.ssd_jump_btn);
        imageView4.setImageDrawable(this.context.getResources().getDrawable(R.drawable.ssd_gdt_logo));
        textView4.setVisibility(8);
        SsdSplashRootView ssdSplashRootView2 = this.adRoot;
        d dVar = new d(ssdSplashRootView2);
        handleDownloadView(ssdSplashRootView2, nativeUnifiedADData);
        textView5.setText(!nativeUnifiedADData.isAppAd() ? "点击跳转到详情页" : "点击下载第三方应用");
        if (h.c(this.sdkAdInfo.getAct_type())) {
            Drawable drawable = this.context.getResources().getDrawable(R.drawable.ssd_shake_angle);
            int i3 = (int) (displayMetrics.density * 30.0f);
            drawable.setBounds(0, 0, i3, i3);
            textView5.setPadding(60, 0, 60, 0);
            textView5.setCompoundDrawables(drawable, null, null, null);
            textView5.setText(!nativeUnifiedADData.isAppAd() ? "点击或摇一摇跳转详情页" : "点击/摇一摇下载第三方应用");
        }
        if (!this.isVertical) {
            relativeLayout = relativeLayout3;
            textView = textView5;
            RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) linearLayout.getLayoutParams();
            layoutParams2.width = (int) (((double) displayMetrics.widthPixels) * 0.86d);
            layoutParams2.height = -2;
            int i4 = (int) (((double) displayMetrics.heightPixels) * 0.07d);
            layoutParams2.topMargin = i4;
            layoutParams2.bottomMargin = i4;
            linearLayout.setLayoutParams(layoutParams2);
            if (TextUtils.isEmpty(nativeUnifiedADData.getDesc())) {
                i = 8;
                textView3.setVisibility(8);
                imageView3.setVisibility(0);
            } else {
                textView3.setVisibility(0);
                textView3.setText(nativeUnifiedADData.getDesc());
                i = 8;
            }
            if (TextUtils.isEmpty(nativeUnifiedADData.getTitle())) {
                textView2.setVisibility(i);
                imageView3.setVisibility(i);
            } else {
                textView2.setVisibility(0);
                textView2.setText(nativeUnifiedADData.getTitle());
            }
            if (!TextUtils.isEmpty(nativeUnifiedADData.getIconUrl())) {
                imageView2.setVisibility(0);
                dVar.d = imageView2;
                dVar.a(nativeUnifiedADData.getIconUrl(), false);
            }
            nativeAdContainer = new NativeAdContainer(this.context);
            viewGroup = (ViewGroup) linearLayout.getParent();
            if (viewGroup != null) {
                ViewGroup.LayoutParams layoutParams3 = linearLayout.getLayoutParams();
                viewGroup.removeView(linearLayout);
                nativeAdContainer.addView(linearLayout, new ViewGroup.LayoutParams(-1, -2));
                viewGroup.addView((View) nativeAdContainer, layoutParams3);
            }
            FrameLayout.LayoutParams layoutParams4 = new FrameLayout.LayoutParams(0, 0);
            arrayList = new ArrayList();
            if ((this.sdkAdInfo.getAct_type() & 1) == 1) {
                arrayList.add(linearLayout);
            } else {
                arrayList.add(textView);
            }
            nativeUnifiedADData.setNativeAdEventListener(new NativeADEventListener(this) { // from class: com.kc.dw.gather.gdt.splash.GDTFeedSplashAdapter.4
                public final GDTFeedSplashAdapter this$0;

                {
                    this.this$0 = this;
                }

                public void onADClicked() {
                    this.this$0.callAdClicked();
                }

                public void onADError(AdError adError) {
                    this.this$0.callRenderError(adError.getErrorCode(), adError.getErrorMsg());
                }

                public void onADExposed() {
                    this.this$0.callAdExposure();
                }

                public void onADStatusChanged() {
                }
            });
            nativeUnifiedADData.bindAdToView(this.context, nativeAdContainer, layoutParams4, arrayList);
            if (nativeUnifiedADData.getAdPatternType() != 2) {
                relativeLayout.removeAllViews();
                MediaView mediaView = new MediaView(this.context);
                layoutParams = mediaView.getLayoutParams();
                if (layoutParams == null) {
                    i2 = -1;
                    layoutParams = new ViewGroup.LayoutParams(-1, -2);
                } else {
                    i2 = -1;
                }
                layoutParams.width = i2;
                layoutParams.height = i2;
                relativeLayout.addView((View) mediaView, layoutParams);
                VideoOption.Builder builder = new VideoOption.Builder();
                builder.setAutoPlayPolicy(1);
                builder.setAutoPlayMuted(true);
                builder.setNeedCoverImage(true);
                builder.setNeedProgressBar(true);
                builder.setEnableDetailPage(true);
                builder.setEnableUserControl(false);
                nativeUnifiedADData.bindMediaView(mediaView, builder.build(), new NativeADMediaListener(this) { // from class: com.kc.dw.gather.gdt.splash.GDTFeedSplashAdapter.5
                    public final GDTFeedSplashAdapter this$0;

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

                    public void onVideoLoaded(int i5) {
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
            } else {
                bitmap = this.imgBitmap;
                if (bitmap != null || this.bitmapBlur == null) {
                    c0.a(getImageUrl(nativeUnifiedADData), new x(this, gifImageView, imageView) { // from class: com.kc.dw.gather.gdt.splash.GDTFeedSplashAdapter.6
                        public final GDTFeedSplashAdapter this$0;
                        public final ImageView val$splashBg;
                        public final GifImageView val$splashImageView;

                        {
                            this.this$0 = this;
                            this.val$splashImageView = gifImageView;
                            this.val$splashBg = imageView;
                        }

                        @Override // com.kc.dw.core.utils.x
                        public void onFailure(IOException iOException) {
                            this.this$0.callRenderError(-1, "image load error");
                        }

                        @Override // com.kc.dw.core.utils.x
                        public void onResponse(HttpResponse<byte[]> httpResponse) throws IOException {
                            try {
                                if (!httpResponse.isSuccessful()) {
                                    this.this$0.callRenderError(-1, "image load error");
                                    return;
                                }
                                byte[] responseBody = httpResponse.getResponseBody();
                                if (responseBody == null || responseBody.length <= 0) {
                                    this.this$0.callRenderError(-1, "image load error");
                                    return;
                                }
                                if (responseBody.length >= h0.a()) {
                                    this.this$0.callRenderError(-1, "image load error");
                                    return;
                                }
                                Bitmap bitmapDecodeByteArray = BitmapFactory.decodeByteArray(responseBody, 0, responseBody.length);
                                if (bitmapDecodeByteArray == null) {
                                    this.this$0.callRenderError(-1, "image load error");
                                    return;
                                }
                                this.val$splashImageView.setImageBitmap(bitmapDecodeByteArray);
                                Bitmap bitmapDecodeByteArray2 = BitmapFactory.decodeByteArray(responseBody, 0, responseBody.length);
                                if (bitmapDecodeByteArray2 != null) {
                                    this.this$0.context.getApplicationContext();
                                    this.val$splashBg.setImageBitmap(d0.a(bitmapDecodeByteArray2, 20));
                                }
                                this.this$0.callRenderSuccess();
                            } catch (Throwable th) {
                                this.this$0.callRenderError(-1, "image load error");
                                th.printStackTrace();
                            }
                        }
                    });
                    return;
                } else {
                    gifImageView.setImageBitmap(bitmap);
                    this.context.getApplicationContext();
                    imageView.setImageBitmap(d0.a(this.bitmapBlur, 20));
                }
            }
            callRenderSuccess();
        }
        RelativeLayout.LayoutParams layoutParams5 = (RelativeLayout.LayoutParams) linearLayout.getLayoutParams();
        double d = ((double) displayMetrics.widthPixels) * 0.86d;
        layoutParams5.width = (int) d;
        relativeLayout = relativeLayout3;
        textView = textView5;
        layoutParams5.height = (int) ((d * ((double) this.height)) / ((double) this.width));
        int i5 = (int) (((double) displayMetrics.heightPixels) * 0.07d);
        layoutParams5.topMargin = i5;
        layoutParams5.bottomMargin = i5;
        linearLayout = linearLayout;
        linearLayout.setLayoutParams(layoutParams5);
        i = 8;
        textView2.setVisibility(8);
        textView3.setVisibility(8);
        imageView3.setVisibility(8);
        imageView2.setVisibility(i);
        nativeAdContainer = new NativeAdContainer(this.context);
        viewGroup = (ViewGroup) linearLayout.getParent();
        if (viewGroup != null) {
            ViewGroup.LayoutParams layoutParams6 = linearLayout.getLayoutParams();
            viewGroup.removeView(linearLayout);
            nativeAdContainer.addView(linearLayout, new ViewGroup.LayoutParams(-1, -2));
            viewGroup.addView((View) nativeAdContainer, layoutParams6);
        }
        FrameLayout.LayoutParams layoutParams7 = new FrameLayout.LayoutParams(0, 0);
        arrayList = new ArrayList();
        if ((this.sdkAdInfo.getAct_type() & 1) == 1) {
            arrayList.add(linearLayout);
        } else {
            arrayList.add(textView);
        }
        nativeUnifiedADData.setNativeAdEventListener(new NativeADEventListener(this) { // from class: com.kc.dw.gather.gdt.splash.GDTFeedSplashAdapter.4
            public final GDTFeedSplashAdapter this$0;

            {
                this.this$0 = this;
            }

            public void onADClicked() {
                this.this$0.callAdClicked();
            }

            public void onADError(AdError adError) {
                this.this$0.callRenderError(adError.getErrorCode(), adError.getErrorMsg());
            }

            public void onADExposed() {
                this.this$0.callAdExposure();
            }

            public void onADStatusChanged() {
            }
        });
        nativeUnifiedADData.bindAdToView(this.context, nativeAdContainer, layoutParams7, arrayList);
        if (nativeUnifiedADData.getAdPatternType() != 2) {
            bitmap = this.imgBitmap;
            if (bitmap != null) {
            }
            c0.a(getImageUrl(nativeUnifiedADData), new x(this, gifImageView, imageView) { // from class: com.kc.dw.gather.gdt.splash.GDTFeedSplashAdapter.6
                public final GDTFeedSplashAdapter this$0;
                public final ImageView val$splashBg;
                public final GifImageView val$splashImageView;

                {
                    this.this$0 = this;
                    this.val$splashImageView = gifImageView;
                    this.val$splashBg = imageView;
                }

                @Override // com.kc.dw.core.utils.x
                public void onFailure(IOException iOException) {
                    this.this$0.callRenderError(-1, "image load error");
                }

                @Override // com.kc.dw.core.utils.x
                public void onResponse(HttpResponse<byte[]> httpResponse) throws IOException {
                    try {
                        if (!httpResponse.isSuccessful()) {
                            this.this$0.callRenderError(-1, "image load error");
                            return;
                        }
                        byte[] responseBody = httpResponse.getResponseBody();
                        if (responseBody == null || responseBody.length <= 0) {
                            this.this$0.callRenderError(-1, "image load error");
                            return;
                        }
                        if (responseBody.length >= h0.a()) {
                            this.this$0.callRenderError(-1, "image load error");
                            return;
                        }
                        Bitmap bitmapDecodeByteArray = BitmapFactory.decodeByteArray(responseBody, 0, responseBody.length);
                        if (bitmapDecodeByteArray == null) {
                            this.this$0.callRenderError(-1, "image load error");
                            return;
                        }
                        this.val$splashImageView.setImageBitmap(bitmapDecodeByteArray);
                        Bitmap bitmapDecodeByteArray2 = BitmapFactory.decodeByteArray(responseBody, 0, responseBody.length);
                        if (bitmapDecodeByteArray2 != null) {
                            this.this$0.context.getApplicationContext();
                            this.val$splashBg.setImageBitmap(d0.a(bitmapDecodeByteArray2, 20));
                        }
                        this.this$0.callRenderSuccess();
                    } catch (Throwable th) {
                        this.this$0.callRenderError(-1, "image load error");
                        th.printStackTrace();
                    }
                }
            });
            return;
        }
        relativeLayout.removeAllViews();
        MediaView mediaView2 = new MediaView(this.context);
        layoutParams = mediaView2.getLayoutParams();
        if (layoutParams == null) {
            i2 = -1;
            layoutParams = new ViewGroup.LayoutParams(-1, -2);
        } else {
            i2 = -1;
        }
        layoutParams.width = i2;
        layoutParams.height = i2;
        relativeLayout.addView((View) mediaView2, layoutParams);
        VideoOption.Builder builder2 = new VideoOption.Builder();
        builder2.setAutoPlayPolicy(1);
        builder2.setAutoPlayMuted(true);
        builder2.setNeedCoverImage(true);
        builder2.setNeedProgressBar(true);
        builder2.setEnableDetailPage(true);
        builder2.setEnableUserControl(false);
        nativeUnifiedADData.bindMediaView(mediaView2, builder2.build(), new NativeADMediaListener(this) { // from class: com.kc.dw.gather.gdt.splash.GDTFeedSplashAdapter.5
            public final GDTFeedSplashAdapter this$0;

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

            public void onVideoLoaded(int i6) {
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
        callRenderSuccess();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void showNativeSplash(NativeUnifiedADData nativeUnifiedADData) {
        String imgUrl;
        if (nativeUnifiedADData.getAdPatternType() == 4 || nativeUnifiedADData.getAdPatternType() == 1 || nativeUnifiedADData.getAdPatternType() == 3) {
            if (TextUtils.isEmpty(nativeUnifiedADData.getImgUrl())) {
                imgUrl = (nativeUnifiedADData.getImgList() == null || nativeUnifiedADData.getImgList().size() <= 0) ? "" : (String) nativeUnifiedADData.getImgList().get(0);
            } else {
                imgUrl = nativeUnifiedADData.getImgUrl();
            }
            c0.a(imgUrl, new x(this, nativeUnifiedADData) { // from class: com.kc.dw.gather.gdt.splash.GDTFeedSplashAdapter.3
                public final GDTFeedSplashAdapter this$0;
                public final NativeUnifiedADData val$adData;

                {
                    this.this$0 = this;
                    this.val$adData = nativeUnifiedADData;
                }

                @Override // com.kc.dw.core.utils.x
                public void onFailure(IOException iOException) {
                    this.this$0.callRenderError(-1, "image load error");
                }

                @Override // com.kc.dw.core.utils.x
                public void onResponse(HttpResponse<byte[]> httpResponse) throws IOException {
                    byte[] responseBody;
                    try {
                        if (!httpResponse.isSuccessful() || (responseBody = httpResponse.getResponseBody()) == null || responseBody.length <= 0) {
                            return;
                        }
                        if (responseBody.length >= h0.a()) {
                            this.this$0.callRenderError(-1, "图片加载失败");
                            return;
                        }
                        Bitmap bitmapDecodeByteArray = BitmapFactory.decodeByteArray(responseBody, 0, responseBody.length);
                        if (bitmapDecodeByteArray != null) {
                            this.this$0.width = bitmapDecodeByteArray.getWidth();
                            this.this$0.height = bitmapDecodeByteArray.getHeight();
                            this.this$0.imgBitmap = bitmapDecodeByteArray;
                            if ((this.this$0.width * 1.0f) / this.this$0.height < 0.67d) {
                                this.this$0.isVertical = true;
                            }
                        }
                        this.this$0.bitmapBlur = BitmapFactory.decodeByteArray(responseBody, 0, responseBody.length);
                        this.this$0.showNativeLayout(this.val$adData);
                    } catch (Throwable th) {
                        th.printStackTrace();
                    }
                }
            });
            return;
        }
        try {
            showNativeLayout(nativeUnifiedADData);
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    private void showSkipView(SsdSplashRootView ssdSplashRootView) {
        this.splashSkipView = (SplashSkipView) ssdSplashRootView.findViewById(R.id.ssd_skipView);
        this.splashSkipView.setOnSkipListener(new SplashSkipView.b(this) { // from class: com.kc.dw.gather.gdt.splash.GDTFeedSplashAdapter.10
            public final GDTFeedSplashAdapter this$0;

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
        NativeUnifiedAD nativeUnifiedAD;
        if (TextUtils.isEmpty(this.sdkAdInfo.getS2sb())) {
            nativeUnifiedAD = null;
        } else {
            try {
                nativeUnifiedAD = new NativeUnifiedAD(getContext().getApplicationContext(), this.sdkAdInfo.getPid(), new NativeADUnifiedListener(this) { // from class: com.kc.dw.gather.gdt.splash.GDTFeedSplashAdapter.1
                    public final GDTFeedSplashAdapter this$0;

                    {
                        this.this$0 = this;
                    }

                    public void onADLoaded(List<NativeUnifiedADData> list) {
                        if (list != null) {
                            try {
                                if (list.size() != 0) {
                                    NativeUnifiedADData nativeUnifiedADData = list.get(0);
                                    this.this$0.callLoadedSuccess();
                                    this.this$0.showNativeSplash(nativeUnifiedADData);
                                    return;
                                }
                            } catch (Throwable th) {
                                th.printStackTrace();
                                return;
                            }
                        }
                        this.this$0.callLoadedError(-1, "返回数据为空");
                    }

                    public void onNoAD(AdError adError) {
                        this.this$0.callLoadedError(adError.getErrorCode(), adError.getErrorMsg());
                    }
                }, ((S2sbResultBean) new Gson().fromJson(this.sdkAdInfo.getS2sb(), S2sbResultBean.class)).getToken());
            } catch (Exception e) {
                e.printStackTrace();
                nativeUnifiedAD = null;
            }
        }
        if (nativeUnifiedAD == null) {
            nativeUnifiedAD = new NativeUnifiedAD(getContext().getApplicationContext(), this.sdkAdInfo.getPid(), new NativeADUnifiedListener(this) { // from class: com.kc.dw.gather.gdt.splash.GDTFeedSplashAdapter.2
                public final GDTFeedSplashAdapter this$0;

                {
                    this.this$0 = this;
                }

                public void onADLoaded(List<NativeUnifiedADData> list) {
                    if (list != null) {
                        try {
                            if (list.size() != 0) {
                                NativeUnifiedADData nativeUnifiedADData = list.get(0);
                                this.this$0.callLoadedSuccess();
                                this.this$0.showNativeSplash(nativeUnifiedADData);
                                return;
                            }
                        } catch (Throwable th) {
                            th.printStackTrace();
                            return;
                        }
                    }
                    this.this$0.callLoadedError(-1, "返回数据为空");
                }

                public void onNoAD(AdError adError) {
                    this.this$0.callLoadedError(adError.getErrorCode(), adError.getErrorMsg());
                }
            });
        }
        nativeUnifiedAD.loadData(1);
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
            callRenderError(200006, "show ad error");
            th.printStackTrace();
        }
    }
}

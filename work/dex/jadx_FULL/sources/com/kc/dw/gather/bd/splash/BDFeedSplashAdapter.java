package com.kc.dw.gather.bd.splash;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.mobads.sdk.api.BaiduNativeManager;
import com.baidu.mobads.sdk.api.NativeResponse;
import com.baidu.mobads.sdk.api.RequestParameters;
import com.baidu.mobads.sdk.api.XNativeView;
import com.kc.dw.activity.SsdDownloadDetailActivity;
import com.kc.dw.activity.SsdWebviewActivity;
import com.kc.dw.ad.splash.SplashSkipView;
import com.kc.dw.ad.splash.SsdSplashRootView;
import com.kc.dw.core.ad.SsdAdSlot;
import com.kc.dw.core.bquery.d;
import com.kc.dw.core.domain.HttpResponse;
import com.kc.dw.core.exception.b;
import com.kc.dw.core.safe.m;
import com.kc.dw.core.utils.DownloadDialogBean;
import com.kc.dw.core.utils.c0;
import com.kc.dw.core.utils.d0;
import com.kc.dw.core.utils.h0;
import com.kc.dw.core.utils.x;
import com.kc.dw.core.view.gif.GifImageView;
import com.kc.dw.platform.custom.CustomInfo;
import com.kc.dw.platform.custom.splash.MsCustomSplashAdapter;
import com.kc.openset.R;
import com.qihoo.SdkProtected.OSETSDK.Keep;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
@Keep
public class BDFeedSplashAdapter extends MsCustomSplashAdapter {
    private SsdSplashRootView adRoot;
    private boolean showed;
    private SplashSkipView splashSkipView;

    private String getImageUrl(NativeResponse nativeResponse) {
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

    private void handleDownloadView(SsdSplashRootView ssdSplashRootView, NativeResponse nativeResponse) {
        try {
            if (nativeResponse.getAdActionType() == 2) {
                ((RelativeLayout) ssdSplashRootView.findViewById(R.id.ms_download_layer_root_view)).setVisibility(0);
                TextView textView = (TextView) ssdSplashRootView.findViewById(R.id.ms_download_layer_app_name);
                TextView textView2 = (TextView) ssdSplashRootView.findViewById(R.id.ms_download_layer_app_version);
                TextView textView3 = (TextView) ssdSplashRootView.findViewById(R.id.ms_download_layer_app_size);
                TextView textView4 = (TextView) ssdSplashRootView.findViewById(R.id.ms_download_layer_app_owner);
                TextView textView5 = (TextView) ssdSplashRootView.findViewById(R.id.ms_download_layer_app_privacy);
                TextView textView6 = (TextView) ssdSplashRootView.findViewById(R.id.ms_download_layer_app_permission);
                TextView textView7 = (TextView) ssdSplashRootView.findViewById(R.id.ms_download_layer_app_introduce);
                textView.setText(nativeResponse.getBrandName());
                textView2.setText(nativeResponse.getAppVersion());
                textView3.setText(((nativeResponse.getAppSize() / 1024) * 1024) + "Mb");
                textView4.setText(nativeResponse.getPublisher());
                textView5.setOnClickListener(new m(this, nativeResponse, ssdSplashRootView) { // from class: com.kc.dw.gather.bd.splash.BDFeedSplashAdapter.4
                    public final BDFeedSplashAdapter this$0;
                    public final NativeResponse val$adData;
                    public final SsdSplashRootView val$adRoot;

                    {
                        this.this$0 = this;
                        this.val$adData = nativeResponse;
                        this.val$adRoot = ssdSplashRootView;
                    }

                    @Override // com.kc.dw.core.safe.m
                    public void safeOnClick(View view) {
                        try {
                            String appPrivacyLink = this.val$adData.getAppPrivacyLink();
                            Intent intent = new Intent(this.val$adRoot.getContext(), (Class<?>) SsdWebviewActivity.class);
                            intent.putExtra("EXTRA_AD_DURL_KEY", new String[]{appPrivacyLink});
                            this.val$adRoot.getContext().startActivity(intent);
                        } catch (Throwable th) {
                            th.printStackTrace();
                        }
                    }
                });
                textView6.setOnClickListener(new m(this, nativeResponse, ssdSplashRootView) { // from class: com.kc.dw.gather.bd.splash.BDFeedSplashAdapter.5
                    public final BDFeedSplashAdapter this$0;
                    public final NativeResponse val$adData;
                    public final SsdSplashRootView val$adRoot;

                    {
                        this.this$0 = this;
                        this.val$adData = nativeResponse;
                        this.val$adRoot = ssdSplashRootView;
                    }

                    @Override // com.kc.dw.core.safe.m
                    public void safeOnClick(View view) {
                        try {
                            DownloadDialogBean downloadDialogBean = new DownloadDialogBean();
                            downloadDialogBean.setApp_name(this.val$adData.getBrandName());
                            downloadDialogBean.setApp_intro(this.val$adData.getDesc());
                            downloadDialogBean.setApp_privacy(this.val$adData.getAppPrivacyLink());
                            downloadDialogBean.setApp_size(((this.val$adData.getAppSize() / 1024) * 1024) + "Mb");
                            downloadDialogBean.setDeveloper(this.val$adData.getPublisher());
                            downloadDialogBean.setApp_permission_url(this.val$adData.getAppPermissionLink());
                            SsdDownloadDetailActivity.startActivity(this.val$adRoot.getContext(), downloadDialogBean);
                        } catch (Throwable th) {
                            th.printStackTrace();
                        }
                    }
                });
                textView7.setOnClickListener(new m(this, nativeResponse, ssdSplashRootView) { // from class: com.kc.dw.gather.bd.splash.BDFeedSplashAdapter.6
                    public final BDFeedSplashAdapter this$0;
                    public final NativeResponse val$adData;
                    public final SsdSplashRootView val$adRoot;

                    {
                        this.this$0 = this;
                        this.val$adData = nativeResponse;
                        this.val$adRoot = ssdSplashRootView;
                    }

                    @Override // com.kc.dw.core.safe.m
                    public void safeOnClick(View view) {
                        try {
                            DownloadDialogBean downloadDialogBean = new DownloadDialogBean();
                            downloadDialogBean.setApp_name(this.val$adData.getBrandName());
                            downloadDialogBean.setApp_intro(this.val$adData.getDesc());
                            downloadDialogBean.setApp_privacy(this.val$adData.getAppPrivacyLink());
                            downloadDialogBean.setApp_size(((this.val$adData.getAppSize() / 1024) * 1024) + "Mb");
                            downloadDialogBean.setDeveloper(this.val$adData.getPublisher());
                            downloadDialogBean.setApp_permission_url(this.val$adData.getAppPermissionLink());
                            SsdDownloadDetailActivity.startActivity(this.val$adRoot.getContext(), downloadDialogBean);
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

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code duplicated, block: B:29:0x018d A[Catch: Exception -> 0x01ed, TRY_LEAVE, TryCatch #0 {Exception -> 0x01ed, blocks: (B:27:0x0181, B:29:0x018d), top: B:52:0x0181 }] */
    /* JADX WARN: Code duplicated, block: B:33:0x01ad A[Catch: Exception -> 0x01eb, TryCatch #1 {Exception -> 0x01eb, blocks: (B:31:0x0191, B:33:0x01ad, B:35:0x01b6, B:36:0x01bd, B:39:0x01c7, B:43:0x01da, B:41:0x01cd), top: B:54:0x018b }] */
    /* JADX WARN: Code duplicated, block: B:34:0x01b5  */
    /* JADX WARN: Code duplicated, block: B:37:0x01c1  */
    /* JADX WARN: Code duplicated, block: B:39:0x01c7 A[Catch: Exception -> 0x01eb, TryCatch #1 {Exception -> 0x01eb, blocks: (B:31:0x0191, B:33:0x01ad, B:35:0x01b6, B:36:0x01bd, B:39:0x01c7, B:43:0x01da, B:41:0x01cd), top: B:54:0x018b }] */
    /* JADX WARN: Code duplicated, block: B:41:0x01cd A[Catch: Exception -> 0x01eb, TryCatch #1 {Exception -> 0x01eb, blocks: (B:31:0x0191, B:33:0x01ad, B:35:0x01b6, B:36:0x01bd, B:39:0x01c7, B:43:0x01da, B:41:0x01cd), top: B:54:0x018b }] */
    /* JADX WARN: Code duplicated, block: B:43:0x01da A[Catch: Exception -> 0x01eb, TRY_LEAVE, TryCatch #1 {Exception -> 0x01eb, blocks: (B:31:0x0191, B:33:0x01ad, B:35:0x01b6, B:36:0x01bd, B:39:0x01c7, B:43:0x01da, B:41:0x01cd), top: B:54:0x018b }] */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v3 */
    /* JADX WARN: Type inference failed for: r1v4, types: [boolean, int] */
    /* JADX WARN: Type inference failed for: r1v5 */
    public void showNativeLayout(NativeResponse nativeResponse, boolean z, boolean z2, Bitmap bitmap, Bitmap bitmap2, int i, int i2) {
        ImageView imageView;
        int i3;
        ?? r1;
        BDFeedSplashAdapter bDFeedSplashAdapter;
        NativeResponse.MaterialType materialType;
        ViewGroup.LayoutParams layoutParams;
        int i4;
        SsdSplashRootView ssdSplashRootView = (SsdSplashRootView) LayoutInflater.from(this.context).inflate(R.layout.ssd_layout_native_splash, (ViewGroup) null);
        this.adRoot = ssdSplashRootView;
        ImageView imageView2 = (ImageView) ssdSplashRootView.findViewById(R.id.ssd_layout_native_splash_bg);
        RelativeLayout relativeLayout = (RelativeLayout) this.adRoot.findViewById(R.id.ssd_native_splash_ad_container);
        View viewInflate = View.inflate(this.context, R.layout.ssd_layout_native_splash_1, null);
        if (z2) {
            viewInflate = View.inflate(this.context, R.layout.ssd_layout_native_splash_2, null);
        }
        relativeLayout.addView(viewInflate, -1, -1);
        RelativeLayout relativeLayout2 = (RelativeLayout) viewInflate.findViewById(R.id.activity_sdk_splash_mediaContainer);
        LinearLayout linearLayout = (LinearLayout) viewInflate.findViewById(R.id.ssd_layout_native_splash_ll);
        GifImageView gifImageView = (GifImageView) viewInflate.findViewById(R.id.layout_native_splash_imageview);
        TextView textView = (TextView) viewInflate.findViewById(R.id.layout_native_splash_title);
        ImageView imageView3 = (ImageView) viewInflate.findViewById(R.id.layout_native_splash_icon);
        ImageView imageView4 = (ImageView) viewInflate.findViewById(R.id.layout_native_splash_score);
        TextView textView2 = (TextView) viewInflate.findViewById(R.id.layout_native_splash_desc);
        SsdSplashRootView ssdSplashRootView2 = this.adRoot;
        int i5 = R.id.ssd_layout_native_splash_logo;
        TextView textView3 = (TextView) this.adRoot.findViewById(R.id.ssd_layout_native_splash_cid);
        TextView textView4 = (TextView) viewInflate.findViewById(R.id.ssd_jump_btn);
        textView3.setVisibility(8);
        textView4.setText(nativeResponse.getAdActionType() != 2 ? "点击或摇动了解详情" : "点击下载");
        handleDownloadView(this.adRoot, nativeResponse);
        d dVar = new d(this.adRoot);
        if (!TextUtils.isEmpty(nativeResponse.getAdLogoUrl())) {
            ((d) dVar.b(i5)).a(nativeResponse.getBaiduLogoUrl(), false);
        }
        DisplayMetrics displayMetrics = this.context.getResources().getDisplayMetrics();
        try {
            try {
                if (!z2) {
                    imageView = imageView2;
                    i3 = 8;
                    if (TextUtils.isEmpty(nativeResponse.getDesc())) {
                        r1 = 0;
                        textView2.setVisibility(8);
                        imageView4.setVisibility(0);
                    } else {
                        r1 = 0;
                        textView2.setVisibility(0);
                        textView2.setText(nativeResponse.getDesc());
                    }
                    if (TextUtils.isEmpty(nativeResponse.getTitle())) {
                        textView.setVisibility(8);
                        imageView4.setVisibility(8);
                    } else {
                        textView.setVisibility(r1);
                        textView.setText(nativeResponse.getTitle());
                    }
                    if (!TextUtils.isEmpty(nativeResponse.getIconUrl())) {
                        imageView3.setVisibility(r1);
                        dVar.d = imageView3;
                        dVar.a(nativeResponse.getIconUrl(), r1);
                    }
                    materialType = nativeResponse.getMaterialType();
                    bDFeedSplashAdapter = NativeResponse.MaterialType.VIDEO;
                    if (materialType.equals(bDFeedSplashAdapter)) {
                        bDFeedSplashAdapter = this;
                        XNativeView xNativeView = new XNativeView(bDFeedSplashAdapter.context);
                        xNativeView.setNativeItem(nativeResponse);
                        xNativeView.setUseDownloadFrame(true);
                        xNativeView.setVideoMute(false);
                        xNativeView.render();
                        relativeLayout2.removeAllViews();
                        layoutParams = xNativeView.getLayoutParams();
                        if (layoutParams == null) {
                            i4 = -1;
                            layoutParams = new ViewGroup.LayoutParams(-1, -2);
                        } else {
                            i4 = -1;
                        }
                        layoutParams.width = i4;
                        layoutParams.height = i4;
                        relativeLayout2.addView((View) xNativeView, layoutParams);
                    } else {
                        bDFeedSplashAdapter = this;
                        if (bitmap != null) {
                            gifImageView.setImageBitmap(bitmap);
                        } else {
                            String imageUrl = getImageUrl(nativeResponse);
                            dVar.d = gifImageView;
                            dVar.a(imageUrl, false);
                        }
                        if (bitmap2 != null) {
                            bDFeedSplashAdapter.context.getApplicationContext();
                            imageView.setImageBitmap(d0.a(bitmap2, 20));
                        }
                    }
                    callRenderSuccess();
                    ArrayList arrayList = new ArrayList();
                    arrayList.add(linearLayout);
                    nativeResponse.registerViewForInteraction(linearLayout, arrayList, (List) null, new NativeResponse.AdInteractionListener(bDFeedSplashAdapter) { // from class: com.kc.dw.gather.bd.splash.BDFeedSplashAdapter.3
                        public final BDFeedSplashAdapter this$0;

                        {
                            this.this$0 = bDFeedSplashAdapter;
                        }

                        public void onADExposed() {
                            this.this$0.callAdExposure();
                        }

                        public void onADExposureFailed(int i6) {
                            this.this$0.callRenderError(i6, "onADExposureFailed");
                        }

                        public void onADStatusChanged() {
                        }

                        public void onAdClick() {
                            this.this$0.callAdClicked();
                        }

                        public void onAdUnionClick() {
                        }
                    });
                    bDFeedSplashAdapter.showSkipView(bDFeedSplashAdapter.adRoot);
                }
                RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) linearLayout.getLayoutParams();
                imageView = imageView2;
                double d = ((double) displayMetrics.widthPixels) * 0.86d;
                layoutParams2.width = (int) d;
                layoutParams2.height = (int) ((d * ((double) i2)) / ((double) i));
                int i6 = (int) (((double) displayMetrics.heightPixels) * 0.07d);
                layoutParams2.topMargin = i6;
                layoutParams2.bottomMargin = i6;
                linearLayout.setLayoutParams(layoutParams2);
                i3 = 8;
                textView.setVisibility(8);
                textView2.setVisibility(8);
                imageView4.setVisibility(8);
                if (materialType.equals(bDFeedSplashAdapter)) {
                    bDFeedSplashAdapter = this;
                    XNativeView xNativeView2 = new XNativeView(bDFeedSplashAdapter.context);
                    xNativeView2.setNativeItem(nativeResponse);
                    xNativeView2.setUseDownloadFrame(true);
                    xNativeView2.setVideoMute(false);
                    xNativeView2.render();
                    relativeLayout2.removeAllViews();
                    layoutParams = xNativeView2.getLayoutParams();
                    if (layoutParams == null) {
                        i4 = -1;
                        layoutParams = new ViewGroup.LayoutParams(-1, -2);
                    } else {
                        i4 = -1;
                    }
                    layoutParams.width = i4;
                    layoutParams.height = i4;
                    relativeLayout2.addView((View) xNativeView2, layoutParams);
                } else {
                    bDFeedSplashAdapter = this;
                    if (bitmap != null) {
                        gifImageView.setImageBitmap(bitmap);
                    } else {
                        String imageUrl2 = getImageUrl(nativeResponse);
                        dVar.d = gifImageView;
                        dVar.a(imageUrl2, false);
                    }
                    if (bitmap2 != null) {
                        bDFeedSplashAdapter.context.getApplicationContext();
                        imageView.setImageBitmap(d0.a(bitmap2, 20));
                    }
                }
                callRenderSuccess();
            } catch (Exception e) {
                e = e;
                e.printStackTrace();
            }
            materialType = nativeResponse.getMaterialType();
            bDFeedSplashAdapter = NativeResponse.MaterialType.VIDEO;
        } catch (Exception e2) {
            e = e2;
            bDFeedSplashAdapter = this;
        }
        imageView3.setVisibility(i3);
        ArrayList arrayList2 = new ArrayList();
        arrayList2.add(linearLayout);
        nativeResponse.registerViewForInteraction(linearLayout, arrayList2, (List) null, new NativeResponse.AdInteractionListener(bDFeedSplashAdapter) { // from class: com.kc.dw.gather.bd.splash.BDFeedSplashAdapter.3
            public final BDFeedSplashAdapter this$0;

            {
                this.this$0 = bDFeedSplashAdapter;
            }

            public void onADExposed() {
                this.this$0.callAdExposure();
            }

            public void onADExposureFailed(int i7) {
                this.this$0.callRenderError(i7, "onADExposureFailed");
            }

            public void onADStatusChanged() {
            }

            public void onAdClick() {
                this.this$0.callAdClicked();
            }

            public void onAdUnionClick() {
            }
        });
        bDFeedSplashAdapter.showSkipView(bDFeedSplashAdapter.adRoot);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void showNativeSplash(NativeResponse nativeResponse) {
        String imageUrl;
        if (nativeResponse.getMaterialType() != NativeResponse.MaterialType.VIDEO && nativeResponse.getMaterialType() == NativeResponse.MaterialType.NORMAL) {
            if (TextUtils.isEmpty(nativeResponse.getImageUrl())) {
                imageUrl = (nativeResponse.getMultiPicUrls() == null || nativeResponse.getMultiPicUrls().size() <= 0) ? "" : (String) nativeResponse.getMultiPicUrls().get(0);
            } else {
                imageUrl = nativeResponse.getImageUrl();
            }
            c0.a(imageUrl, new x(this, nativeResponse) { // from class: com.kc.dw.gather.bd.splash.BDFeedSplashAdapter.2
                public final BDFeedSplashAdapter this$0;
                public final NativeResponse val$adData;

                {
                    this.this$0 = this;
                    this.val$adData = nativeResponse;
                }

                @Override // com.kc.dw.core.utils.x
                public void onFailure(IOException iOException) {
                    BDFeedSplashAdapter bDFeedSplashAdapter = this.this$0;
                    Integer num = b.f39252a;
                    bDFeedSplashAdapter.callRenderError(200004, "图片加载失败");
                }

                @Override // com.kc.dw.core.utils.x
                public void onResponse(HttpResponse<byte[]> httpResponse) throws IOException {
                    byte[] responseBody;
                    boolean z;
                    int i;
                    int i2;
                    try {
                        if (!httpResponse.isSuccessful() || (responseBody = httpResponse.getResponseBody()) == null || responseBody.length <= 0) {
                            return;
                        }
                        if (responseBody.length >= h0.a()) {
                            BDFeedSplashAdapter bDFeedSplashAdapter = this.this$0;
                            Integer num = b.f39252a;
                            bDFeedSplashAdapter.callRenderError(200004, "图片加载失败");
                            return;
                        }
                        Bitmap bitmapDecodeByteArray = BitmapFactory.decodeByteArray(responseBody, 0, responseBody.length);
                        if (bitmapDecodeByteArray != null) {
                            int width = bitmapDecodeByteArray.getWidth();
                            int height = bitmapDecodeByteArray.getHeight();
                            if ((width * 1.0f) / height < 0.67d) {
                                i = width;
                                i2 = height;
                                z = true;
                            } else {
                                i = width;
                                z = false;
                                i2 = height;
                            }
                        } else {
                            z = false;
                            i = 0;
                            i2 = 0;
                        }
                        this.this$0.showNativeLayout(this.val$adData, true, z, bitmapDecodeByteArray, BitmapFactory.decodeByteArray(responseBody, 0, responseBody.length), i, i2);
                    } catch (Throwable th) {
                        th.printStackTrace();
                    }
                }
            });
        }
    }

    private void showSkipView(SsdSplashRootView ssdSplashRootView) {
        this.splashSkipView = (SplashSkipView) ssdSplashRootView.findViewById(R.id.ssd_skipView);
        this.splashSkipView.setOnSkipListener(new SplashSkipView.b(this) { // from class: com.kc.dw.gather.bd.splash.BDFeedSplashAdapter.7
            public final BDFeedSplashAdapter this$0;

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
        BaiduNativeManager baiduNativeManager = new BaiduNativeManager(getContext().getApplicationContext(), this.sdkAdInfo.getPid());
        baiduNativeManager.setAppSid(this.sdkAdInfo.getApp_id());
        baiduNativeManager.setCacheVideoOnlyWifi(true);
        baiduNativeManager.loadFeedAd(new RequestParameters.Builder().downloadAppConfirmPolicy(3).build(), new BaiduNativeManager.FeedAdListener(this) { // from class: com.kc.dw.gather.bd.splash.BDFeedSplashAdapter.1
            public final BDFeedSplashAdapter this$0;

            {
                this.this$0 = this;
            }

            public void onLpClosed() {
            }

            public void onNativeFail(int i, String str) {
                this.this$0.callLoadedError(i, str);
            }

            public void onNativeFail(int i, String str, NativeResponse nativeResponse) {
                this.this$0.callLoadedError(i, str);
            }

            public void onNativeLoad(List<NativeResponse> list) {
                if (list != null) {
                    try {
                        if (list.size() != 0) {
                            NativeResponse nativeResponse = list.get(0);
                            try {
                                this.this$0.setEcpm(Integer.parseInt(nativeResponse.getECPMLevel()));
                            } catch (Exception e) {
                                e.printStackTrace();
                            }
                            this.this$0.callLoadedSuccess();
                            this.this$0.showNativeSplash(nativeResponse);
                            return;
                        }
                    } catch (Throwable th) {
                        th.printStackTrace();
                        return;
                    }
                }
                BDFeedSplashAdapter bDFeedSplashAdapter = this.this$0;
                Integer num = b.f39252a;
                bDFeedSplashAdapter.callLoadedError(200008, "");
            }

            public void onNoAd(int i, String str) {
                this.this$0.callLoadedError(i, str);
            }

            public void onNoAd(int i, String str, NativeResponse nativeResponse) {
                this.this$0.callLoadedError(i, str);
            }

            public void onVideoDownloadFailed() {
            }

            public void onVideoDownloadSuccess() {
            }
        });
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
            th.printStackTrace();
            Integer num = b.f39252a;
            callRenderError(200004, "show ad error");
        }
    }
}

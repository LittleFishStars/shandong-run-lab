package com.kc.dw.gather.csj.splash;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.bytedance.sdk.openadsdk.AdSlot;
import com.bytedance.sdk.openadsdk.ComplianceInfo;
import com.bytedance.sdk.openadsdk.TTAdNative;
import com.bytedance.sdk.openadsdk.TTAdSdk;
import com.bytedance.sdk.openadsdk.TTFeedAd;
import com.bytedance.sdk.openadsdk.TTImage;
import com.bytedance.sdk.openadsdk.TTNativeAd;
import com.kc.dw.activity.SsdDownloadDetailActivity;
import com.kc.dw.activity.SsdWebviewActivity;
import com.kc.dw.ad.splash.SplashSkipView;
import com.kc.dw.ad.splash.SsdSplashRootView;
import com.kc.dw.core.ad.SsdAdSlot;
import com.kc.dw.core.ad.splash.SplashCommonAdLoader;
import com.kc.dw.core.bquery.d;
import com.kc.dw.core.domain.HttpResponse;
import com.kc.dw.core.exception.b;
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
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
@Keep
public class CSJFeedSplashAdapter extends MsCustomSplashAdapter {
    private SsdSplashRootView adRoot;
    private boolean showed;
    private SplashSkipView splashSkipView;

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
        } catch (Throwable th) {
            th.printStackTrace();
            return null;
        }
    }

    private void handleDownloadView(SsdSplashRootView ssdSplashRootView, TTFeedAd tTFeedAd) {
        ComplianceInfo complianceInfo;
        try {
            if (tTFeedAd.getInteractionType() != 4 || (complianceInfo = tTFeedAd.getComplianceInfo()) == null) {
                return;
            }
            ((RelativeLayout) ssdSplashRootView.findViewById(R.id.ms_download_layer_root_view)).setVisibility(0);
            TextView textView = (TextView) ssdSplashRootView.findViewById(R.id.ms_download_layer_app_name);
            TextView textView2 = (TextView) ssdSplashRootView.findViewById(R.id.ms_download_layer_app_version);
            TextView textView3 = (TextView) ssdSplashRootView.findViewById(R.id.ms_download_layer_app_owner);
            TextView textView4 = (TextView) ssdSplashRootView.findViewById(R.id.ms_download_layer_app_privacy);
            TextView textView5 = (TextView) ssdSplashRootView.findViewById(R.id.ms_download_layer_app_permission);
            TextView textView6 = (TextView) ssdSplashRootView.findViewById(R.id.ms_download_layer_app_introduce);
            textView.setText(complianceInfo.getAppName());
            textView2.setText(complianceInfo.getAppVersion());
            textView3.setText(complianceInfo.getDeveloperName());
            textView4.setOnClickListener(new m(this, complianceInfo, ssdSplashRootView) { // from class: com.kc.dw.gather.csj.splash.CSJFeedSplashAdapter.4
                public final CSJFeedSplashAdapter this$0;
                public final SsdSplashRootView val$adRoot;
                public final ComplianceInfo val$complianceInfo;

                {
                    this.this$0 = this;
                    this.val$complianceInfo = complianceInfo;
                    this.val$adRoot = ssdSplashRootView;
                }

                @Override // com.kc.dw.core.safe.m
                public void safeOnClick(View view) {
                    try {
                        String privacyUrl = this.val$complianceInfo.getPrivacyUrl();
                        Intent intent = new Intent(this.val$adRoot.getContext(), (Class<?>) SsdWebviewActivity.class);
                        intent.putExtra("EXTRA_AD_DURL_KEY", new String[]{privacyUrl});
                        this.val$adRoot.getContext().startActivity(intent);
                    } catch (Throwable th) {
                        th.printStackTrace();
                    }
                }
            });
            textView5.setOnClickListener(new m(this, complianceInfo, ssdSplashRootView) { // from class: com.kc.dw.gather.csj.splash.CSJFeedSplashAdapter.5
                public final CSJFeedSplashAdapter this$0;
                public final SsdSplashRootView val$adRoot;
                public final ComplianceInfo val$complianceInfo;

                {
                    this.this$0 = this;
                    this.val$complianceInfo = complianceInfo;
                    this.val$adRoot = ssdSplashRootView;
                }

                @Override // com.kc.dw.core.safe.m
                public void safeOnClick(View view) {
                    try {
                        DownloadDialogBean downloadDialogBean = new DownloadDialogBean();
                        downloadDialogBean.setApp_name(this.val$complianceInfo.getAppName());
                        downloadDialogBean.setApp_privacy(this.val$complianceInfo.getPrivacyUrl());
                        downloadDialogBean.setDeveloper(this.val$complianceInfo.getDeveloperName());
                        downloadDialogBean.setApp_permission_url(this.val$complianceInfo.getPermissionUrl());
                        SsdDownloadDetailActivity.startActivity(this.val$adRoot.getContext(), downloadDialogBean);
                    } catch (Throwable th) {
                        th.printStackTrace();
                    }
                }
            });
            textView6.setOnClickListener(new m(this, complianceInfo, ssdSplashRootView) { // from class: com.kc.dw.gather.csj.splash.CSJFeedSplashAdapter.6
                public final CSJFeedSplashAdapter this$0;
                public final SsdSplashRootView val$adRoot;
                public final ComplianceInfo val$complianceInfo;

                {
                    this.this$0 = this;
                    this.val$complianceInfo = complianceInfo;
                    this.val$adRoot = ssdSplashRootView;
                }

                @Override // com.kc.dw.core.safe.m
                public void safeOnClick(View view) {
                    try {
                        DownloadDialogBean downloadDialogBean = new DownloadDialogBean();
                        downloadDialogBean.setApp_name(this.val$complianceInfo.getAppName());
                        downloadDialogBean.setApp_privacy(this.val$complianceInfo.getPrivacyUrl());
                        downloadDialogBean.setDeveloper(this.val$complianceInfo.getDeveloperName());
                        downloadDialogBean.setApp_permission_url(this.val$complianceInfo.getPermissionUrl());
                        SsdDownloadDetailActivity.startActivity(this.val$adRoot.getContext(), downloadDialogBean);
                    } catch (Throwable th) {
                        th.printStackTrace();
                    }
                }
            });
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v25, types: [com.kc.dw.core.bquery.a, com.kc.dw.core.bquery.d] */
    /* JADX WARN: Type inference failed for: r10v10 */
    /* JADX WARN: Type inference failed for: r10v5 */
    /* JADX WARN: Type inference failed for: r10v6, types: [boolean, int] */
    /* JADX WARN: Type inference failed for: r11v2, types: [android.widget.ImageView] */
    /* JADX WARN: Type inference failed for: r13v3, types: [android.view.View, android.widget.ImageView] */
    /* JADX WARN: Type inference failed for: r30v0, types: [com.bytedance.sdk.openadsdk.TTFeedAd, com.bytedance.sdk.openadsdk.TTNativeAd] */
    /* JADX WARN: Type inference failed for: r4v3, types: [android.view.View, android.widget.TextView] */
    /* JADX WARN: Type inference failed for: r5v22 */
    /* JADX WARN: Type inference failed for: r5v23 */
    /* JADX WARN: Type inference failed for: r5v26 */
    /* JADX WARN: Type inference failed for: r5v27, types: [com.kc.dw.core.bquery.a] */
    /* JADX WARN: Type inference failed for: r5v39 */
    /* JADX WARN: Type inference failed for: r5v48 */
    /* JADX WARN: Type inference failed for: r6v6, types: [android.view.View, android.widget.TextView] */
    public void showNativeAd(TTFeedAd tTFeedAd) {
        List<TTImage> imageList;
        String imageUrl;
        int width;
        boolean z;
        int i;
        ?? r10;
        ?? r5;
        ?? r6;
        CSJFeedSplashAdapter cSJFeedSplashAdapter = this;
        cSJFeedSplashAdapter.adRoot = (SsdSplashRootView) View.inflate(cSJFeedSplashAdapter.context, R.layout.ssd_layout_native_splash, null);
        DisplayMetrics displayMetrics = cSJFeedSplashAdapter.context.getResources().getDisplayMetrics();
        ImageView imageView = (ImageView) cSJFeedSplashAdapter.adRoot.findViewById(R.id.ssd_layout_native_splash_bg);
        RelativeLayout relativeLayout = (RelativeLayout) cSJFeedSplashAdapter.adRoot.findViewById(R.id.ssd_native_splash_ad_container);
        try {
            cSJFeedSplashAdapter.handleDownloadView(cSJFeedSplashAdapter.adRoot, tTFeedAd);
        } catch (Throwable th) {
            th.printStackTrace();
        }
        View viewInflate = View.inflate(cSJFeedSplashAdapter.context, R.layout.ssd_layout_native_splash_1, null);
        if ((tTFeedAd.getImageMode() == 3 || tTFeedAd.getImageMode() == 2 || tTFeedAd.getImageMode() == 4 || tTFeedAd.getImageMode() == 16) && (imageList = tTFeedAd.getImageList()) != null && imageList.size() > 0) {
            TTImage tTImage = imageList.get(0);
            imageUrl = tTImage.getImageUrl();
            width = tTImage.getWidth();
            int height = tTImage.getHeight();
            if ((tTImage.getWidth() * 1.0f) / tTImage.getHeight() < 0.67d) {
                viewInflate = View.inflate(cSJFeedSplashAdapter.context, R.layout.ssd_layout_native_splash_2, null);
                i = height;
                z = true;
            } else {
                z = false;
                i = height;
            }
        } else {
            imageUrl = "";
            i = 0;
            z = false;
            width = 0;
        }
        RelativeLayout relativeLayout2 = (RelativeLayout) viewInflate.findViewById(R.id.activity_sdk_splash_mediaContainer);
        LinearLayout linearLayout = (LinearLayout) viewInflate.findViewById(R.id.ssd_layout_native_splash_ll);
        GifImageView gifImageView = (GifImageView) viewInflate.findViewById(R.id.layout_native_splash_imageview);
        ?? r4 = (TextView) viewInflate.findViewById(R.id.layout_native_splash_title);
        ?? r13 = (ImageView) viewInflate.findViewById(R.id.layout_native_splash_icon);
        ?? r11 = (ImageView) viewInflate.findViewById(R.id.layout_native_splash_score);
        ?? r7 = (TextView) viewInflate.findViewById(R.id.layout_native_splash_desc);
        String str = imageUrl;
        ImageView imageView2 = (ImageView) cSJFeedSplashAdapter.adRoot.findViewById(R.id.ssd_layout_native_splash_logo);
        TextView textView = (TextView) viewInflate.findViewById(R.id.ssd_jump_btn);
        View view = viewInflate;
        ArrayList arrayList = new ArrayList();
        if ((cSJFeedSplashAdapter.sdkAdInfo.getAct_type() & 1) == 1) {
            arrayList.add(linearLayout);
        } else {
            arrayList.add(textView);
        }
        tTFeedAd.registerViewForInteraction(linearLayout, arrayList, arrayList, new TTNativeAd.AdInteractionListener(cSJFeedSplashAdapter) { // from class: com.kc.dw.gather.csj.splash.CSJFeedSplashAdapter.2
            public final CSJFeedSplashAdapter this$0;

            {
                this.this$0 = cSJFeedSplashAdapter;
            }

            @Override // com.bytedance.sdk.openadsdk.TTNativeAd.AdInteractionListener
            public void onAdClicked(View view2, TTNativeAd tTNativeAd) {
                this.this$0.callAdClicked();
            }

            @Override // com.bytedance.sdk.openadsdk.TTNativeAd.AdInteractionListener
            public void onAdCreativeClick(View view2, TTNativeAd tTNativeAd) {
                this.this$0.callAdClicked();
            }

            @Override // com.bytedance.sdk.openadsdk.TTNativeAd.AdInteractionListener
            public void onAdShow(TTNativeAd tTNativeAd) {
                this.this$0.callAdExposure();
            }
        });
        if (h.c(cSJFeedSplashAdapter.sdkAdInfo.getAct_type())) {
            Drawable drawable = cSJFeedSplashAdapter.context.getResources().getDrawable(R.drawable.ssd_shake_angle);
            int i2 = (int) (displayMetrics.density * 30.0f);
            r10 = 0;
            drawable.setBounds(0, 0, i2, i2);
            textView.setPadding(60, 0, 60, 0);
            textView.setCompoundDrawables(drawable, null, null, null);
        } else {
            r10 = 0;
        }
        ?? dVar = new d(cSJFeedSplashAdapter.adRoot);
        if (TextUtils.isEmpty(tTFeedAd.getDescription())) {
            r7.setVisibility(8);
            r11.setVisibility(r10);
        } else {
            r7.setVisibility(r10);
            r7.setText(tTFeedAd.getDescription());
        }
        if (TextUtils.isEmpty(tTFeedAd.getTitle())) {
            r4.setVisibility(8);
            r11.setVisibility(8);
        } else {
            r4.setVisibility(r10);
            r4.setText(tTFeedAd.getTitle());
        }
        if (TextUtils.isEmpty(tTFeedAd.getIcon().getImageUrl())) {
            r13.setVisibility(8);
        } else {
            r13.setVisibility(r10);
            dVar.d = r13;
            dVar.a(tTFeedAd.getIcon().getImageUrl(), r10);
        }
        if (tTFeedAd.getImageMode() == 3 || tTFeedAd.getImageMode() == 2 || tTFeedAd.getImageMode() == 4 || tTFeedAd.getImageMode() == 16) {
            if (z) {
                RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) linearLayout.getLayoutParams();
                double d = ((double) displayMetrics.widthPixels) * 0.86d;
                layoutParams.width = (int) d;
                r5 = dVar;
                layoutParams.height = (int) ((d * ((double) i)) / ((double) width));
                int i3 = (int) (((double) displayMetrics.heightPixels) * 0.07d);
                layoutParams.topMargin = i3;
                layoutParams.bottomMargin = i3;
                linearLayout.setLayoutParams(layoutParams);
                r4.setVisibility(8);
                r7.setVisibility(8);
                r11.setVisibility(8);
                r13.setVisibility(8);
            } else {
                r5 = dVar;
                RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) linearLayout.getLayoutParams();
                layoutParams2.width = (int) (((double) displayMetrics.widthPixels) * 0.86d);
                layoutParams2.height = -2;
                int i4 = (int) (((double) displayMetrics.heightPixels) * 0.07d);
                layoutParams2.topMargin = i4;
                layoutParams2.bottomMargin = i4;
                linearLayout.setLayoutParams(layoutParams2);
            }
            cSJFeedSplashAdapter = this;
            c0.a(str, new x(cSJFeedSplashAdapter, gifImageView, imageView) { // from class: com.kc.dw.gather.csj.splash.CSJFeedSplashAdapter.3
                public final CSJFeedSplashAdapter this$0;
                public final ImageView val$splashBg;
                public final GifImageView val$splashImageView;

                {
                    this.this$0 = cSJFeedSplashAdapter;
                    this.val$splashImageView = gifImageView;
                    this.val$splashBg = imageView;
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
                            this.this$0.callRenderError(-1, "image load error");
                            return;
                        }
                        Bitmap bitmapDecodeByteArray = BitmapFactory.decodeByteArray(responseBody, 0, responseBody.length);
                        if (bitmapDecodeByteArray == null) {
                            this.this$0.callRenderError(-1, "image load error");
                        }
                        if (bitmapDecodeByteArray != null) {
                            this.val$splashImageView.setImageBitmap(bitmapDecodeByteArray);
                        }
                        Bitmap bitmapDecodeByteArray2 = BitmapFactory.decodeByteArray(responseBody, 0, responseBody.length);
                        if (bitmapDecodeByteArray2 != null) {
                            this.this$0.context.getApplicationContext();
                            this.val$splashBg.setImageBitmap(d0.a(bitmapDecodeByteArray2, 20));
                        }
                        this.this$0.callRenderSuccess();
                    } catch (Throwable unused) {
                    }
                }
            });
            r6 = r5;
        } else {
            if (tTFeedAd.getImageMode() == 15 || tTFeedAd.getImageMode() == 5) {
                View adView = tTFeedAd.getAdView();
                RelativeLayout.LayoutParams layoutParams3 = (RelativeLayout.LayoutParams) linearLayout.getLayoutParams();
                layoutParams3.width = (int) (((double) displayMetrics.widthPixels) * 0.86d);
                layoutParams3.height = -2;
                int i5 = (int) (((double) displayMetrics.heightPixels) * 0.07d);
                layoutParams3.topMargin = i5;
                layoutParams3.bottomMargin = i5;
                linearLayout.setLayoutParams(layoutParams3);
                relativeLayout2.removeAllViews();
                relativeLayout2.addView(adView);
                callRenderSuccess();
            }
            r6 = dVar;
        }
        if (tTFeedAd.getAdLogo() != null) {
            imageView2.setVisibility(0);
            r6.d = imageView2;
            Bitmap adLogo = tTFeedAd.getAdLogo();
            View view2 = r6.d;
            if (view2 instanceof ImageView) {
                ((ImageView) view2).setImageBitmap(adLogo);
            }
        } else {
            imageView2.setVisibility(8);
        }
        ViewGroup.LayoutParams layoutParams4 = textView.getLayoutParams();
        layoutParams4.width = (int) (((double) displayMetrics.widthPixels) * 0.86d * 0.77d);
        textView.setLayoutParams(layoutParams4);
        textView.setText(tTFeedAd.getInteractionType() == 4 ? "点击/摇一摇下载第三方应用" : "点击或摇一摇跳转详情页");
        relativeLayout.addView(view, -1, -1);
        cSJFeedSplashAdapter.showSkipView(cSJFeedSplashAdapter.adRoot);
    }

    private void showSkipView(SsdSplashRootView ssdSplashRootView) {
        try {
            this.splashSkipView = (SplashSkipView) ssdSplashRootView.findViewById(R.id.ssd_skipView);
            this.splashSkipView.setOnSkipListener(new SplashSkipView.b(this) { // from class: com.kc.dw.gather.csj.splash.CSJFeedSplashAdapter.7
                public final CSJFeedSplashAdapter this$0;

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
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    @Override // com.kc.dw.platform.custom.splash.MsCustomSplashAdapter
    public void loadCustomAd(Context context, SsdAdSlot ssdAdSlot, CustomInfo customInfo) {
        TTAdSdk.getAdManager().createAdNative(((SplashCommonAdLoader) this.adLoader).getContext().getApplicationContext()).loadFeedAd(new AdSlot.Builder().setCodeId(getSdkAdInfo().getPid()).setSupportDeepLink(true).setIsAutoPlay(true).setAdCount(1).build(), new TTAdNative.FeedAdListener(this) { // from class: com.kc.dw.gather.csj.splash.CSJFeedSplashAdapter.1
            public final CSJFeedSplashAdapter this$0;

            {
                this.this$0 = this;
            }

            @Override // com.bytedance.sdk.openadsdk.TTAdNative.FeedAdListener
            public void onError(int i, String str) {
                this.this$0.callLoadedError(i, str);
            }

            @Override // com.bytedance.sdk.openadsdk.TTAdNative.FeedAdListener
            public void onFeedAdLoad(List<TTFeedAd> list) {
                if (list != null) {
                    try {
                        if (list.size() > 0) {
                            TTFeedAd tTFeedAd = list.get(0);
                            this.this$0.callLoadedSuccess();
                            this.this$0.showNativeAd(tTFeedAd);
                        }
                    } catch (Throwable th) {
                        th.printStackTrace();
                    }
                }
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
            Integer num = b.f39252a;
            callRenderError(200005, "show ad error");
            th.printStackTrace();
        }
    }
}

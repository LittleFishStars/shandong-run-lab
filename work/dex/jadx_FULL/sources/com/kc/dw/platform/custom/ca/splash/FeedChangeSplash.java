package com.kc.dw.platform.custom.ca.splash;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.kc.dw.activity.SsdDownloadDetailActivity;
import com.kc.dw.activity.SsdWebviewActivity;
import com.kc.dw.ad.splash.SplashSkipView;
import com.kc.dw.ad.splash.SsdSplashRootView;
import com.kc.dw.core.ad.recycler.FeedInteractionListener;
import com.kc.dw.core.bquery.d;
import com.kc.dw.core.domain.HttpResponse;
import com.kc.dw.core.domain.SsdAdInfo;
import com.kc.dw.core.router.log.bean.LoadResState;
import com.kc.dw.core.safe.m;
import com.kc.dw.core.service.logrecord.a;
import com.kc.dw.core.service.logrecord.b;
import com.kc.dw.core.utils.DownloadDialogBean;
import com.kc.dw.core.utils.LogUtil;
import com.kc.dw.core.utils.c0;
import com.kc.dw.core.utils.d0;
import com.kc.dw.core.utils.h;
import com.kc.dw.core.utils.h0;
import com.kc.dw.core.utils.x;
import com.kc.dw.core.view.gif.GifImageView;
import com.kc.dw.platform.custom.recycler.MsCustomRecyclerFeedAd;
import com.kc.openset.R;
import com.qihoo.SdkProtected.OSETSDK.Keep;
import java.io.IOException;
import java.util.ArrayList;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
@Keep
public class FeedChangeSplash implements ISplashChangeAd<MsCustomRecyclerFeedAd> {
    private static final String TAG = "FeedChangeSplash";
    private MsCustomRecyclerFeedAd ad;
    private SsdSplashRootView adRoot;
    private Context context;
    private boolean isRenderSucc;
    private boolean isStartRender;
    private int loadType;
    private final SsdAdInfo msAdInfo;
    private int rs = 0;
    private boolean showed;
    private final SplashChangeAdapter splashChangeAdapter;
    private SplashSkipView splashSkipView;

    public FeedChangeSplash(SplashChangeAdapter splashChangeAdapter, SsdAdInfo ssdAdInfo) {
        this.splashChangeAdapter = splashChangeAdapter;
        this.msAdInfo = ssdAdInfo;
    }

    private void handleDownloadView(SsdSplashRootView ssdSplashRootView, MsCustomRecyclerFeedAd msCustomRecyclerFeedAd) {
        try {
            if (msCustomRecyclerFeedAd.getInteractionType() == 1) {
                ((RelativeLayout) ssdSplashRootView.findViewById(R.id.ms_download_layer_root_view)).setVisibility(0);
                TextView textView = (TextView) ssdSplashRootView.findViewById(R.id.ms_download_layer_app_name);
                TextView textView2 = (TextView) ssdSplashRootView.findViewById(R.id.ms_download_layer_app_version);
                TextView textView3 = (TextView) ssdSplashRootView.findViewById(R.id.ms_download_layer_app_owner);
                TextView textView4 = (TextView) ssdSplashRootView.findViewById(R.id.ms_download_layer_app_privacy);
                TextView textView5 = (TextView) ssdSplashRootView.findViewById(R.id.ms_download_layer_app_permission);
                TextView textView6 = (TextView) ssdSplashRootView.findViewById(R.id.ms_download_layer_app_introduce);
                textView.setText(msCustomRecyclerFeedAd.getAppName());
                textView2.setText(msCustomRecyclerFeedAd.getAppVersion());
                textView3.setText(msCustomRecyclerFeedAd.getDeveloper());
                textView4.setOnClickListener(new m(this, msCustomRecyclerFeedAd, ssdSplashRootView) { // from class: com.kc.dw.platform.custom.ca.splash.FeedChangeSplash.4
                    public final FeedChangeSplash this$0;
                    public final SsdSplashRootView val$adRoot;
                    public final MsCustomRecyclerFeedAd val$feedAd;

                    {
                        this.this$0 = this;
                        this.val$feedAd = msCustomRecyclerFeedAd;
                        this.val$adRoot = ssdSplashRootView;
                    }

                    @Override // com.kc.dw.core.safe.m
                    public void safeOnClick(View view) {
                        try {
                            String privacyAgreement = this.val$feedAd.getPrivacyAgreement();
                            Intent intent = new Intent(this.val$adRoot.getContext(), (Class<?>) SsdWebviewActivity.class);
                            intent.putExtra("EXTRA_AD_DURL_KEY", new String[]{privacyAgreement});
                            this.val$adRoot.getContext().startActivity(intent);
                        } catch (Throwable th) {
                            th.printStackTrace();
                        }
                    }
                });
                textView5.setOnClickListener(new m(this, msCustomRecyclerFeedAd, ssdSplashRootView) { // from class: com.kc.dw.platform.custom.ca.splash.FeedChangeSplash.5
                    public final FeedChangeSplash this$0;
                    public final SsdSplashRootView val$adRoot;
                    public final MsCustomRecyclerFeedAd val$feedAd;

                    {
                        this.this$0 = this;
                        this.val$feedAd = msCustomRecyclerFeedAd;
                        this.val$adRoot = ssdSplashRootView;
                    }

                    @Override // com.kc.dw.core.safe.m
                    public void safeOnClick(View view) {
                        try {
                            DownloadDialogBean downloadDialogBean = new DownloadDialogBean();
                            downloadDialogBean.setApp_name(this.val$feedAd.getAppName());
                            downloadDialogBean.setApp_privacy(this.val$feedAd.getPrivacyAgreement());
                            downloadDialogBean.setDeveloper(this.val$feedAd.getDeveloper());
                            downloadDialogBean.setApp_permission_url(this.val$feedAd.getAppPremissionUrl());
                            SsdDownloadDetailActivity.startActivity(this.val$adRoot.getContext(), downloadDialogBean);
                        } catch (Throwable th) {
                            th.printStackTrace();
                        }
                    }
                });
                textView6.setOnClickListener(new m(this, msCustomRecyclerFeedAd, ssdSplashRootView) { // from class: com.kc.dw.platform.custom.ca.splash.FeedChangeSplash.6
                    public final FeedChangeSplash this$0;
                    public final SsdSplashRootView val$adRoot;
                    public final MsCustomRecyclerFeedAd val$feedAd;

                    {
                        this.this$0 = this;
                        this.val$feedAd = msCustomRecyclerFeedAd;
                        this.val$adRoot = ssdSplashRootView;
                    }

                    @Override // com.kc.dw.core.safe.m
                    public void safeOnClick(View view) {
                        try {
                            DownloadDialogBean downloadDialogBean = new DownloadDialogBean();
                            downloadDialogBean.setApp_name(this.val$feedAd.getAppName());
                            downloadDialogBean.setApp_privacy(this.val$feedAd.getPrivacyAgreement());
                            downloadDialogBean.setDeveloper(this.val$feedAd.getDeveloper());
                            downloadDialogBean.setApp_permission_url(this.val$feedAd.getAppPremissionUrl());
                            SsdDownloadDetailActivity.startActivity(this.val$adRoot.getContext(), downloadDialogBean);
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

    private boolean recordedStartShowAdLog() {
        try {
            return this.splashChangeAdapter.getSdkAdInfo().getAppendInfo().getEventTimes(b.a(this.splashChangeAdapter.getSdkAdInfo())).containsKey("e7");
        } catch (Exception unused) {
            return false;
        }
    }

    /* JADX WARN: Code duplicated, block: B:101:0x0397  */
    /* JADX WARN: Code duplicated, block: B:104:0x03a0  */
    /* JADX WARN: Code duplicated, block: B:105:0x03ae  */
    /* JADX WARN: Code duplicated, block: B:107:0x03b4  */
    /* JADX WARN: Code duplicated, block: B:108:0x03bc  */
    /* JADX WARN: Code duplicated, block: B:111:0x03dd  */
    /* JADX WARN: Code duplicated, block: B:112:0x03e1  */
    /* JADX WARN: Code duplicated, block: B:42:0x0160  */
    /* JADX WARN: Code duplicated, block: B:44:0x0175  */
    /* JADX WARN: Code duplicated, block: B:45:0x0181  */
    /* JADX WARN: Code duplicated, block: B:48:0x0199  */
    /* JADX WARN: Code duplicated, block: B:50:0x01b8  */
    /* JADX WARN: Code duplicated, block: B:52:0x01c0  */
    /* JADX WARN: Code duplicated, block: B:53:0x01dc  */
    /* JADX WARN: Code duplicated, block: B:55:0x01ee  */
    /* JADX WARN: Code duplicated, block: B:60:0x0202  */
    /* JADX WARN: Code duplicated, block: B:68:0x0250  */
    /* JADX WARN: Code duplicated, block: B:69:0x025c  */
    /* JADX WARN: Code duplicated, block: B:72:0x026f  */
    /* JADX WARN: Code duplicated, block: B:73:0x027a  */
    /* JADX WARN: Code duplicated, block: B:76:0x028c  */
    /* JADX WARN: Code duplicated, block: B:77:0x02a5  */
    /* JADX WARN: Code duplicated, block: B:80:0x02af  */
    /* JADX WARN: Code duplicated, block: B:82:0x02b5  */
    /* JADX WARN: Code duplicated, block: B:83:0x02bd  */
    /* JADX WARN: Code duplicated, block: B:85:0x02c1  */
    /* JADX WARN: Code duplicated, block: B:87:0x02c9  */
    /* JADX WARN: Code duplicated, block: B:88:0x02f2  */
    /* JADX WARN: Code duplicated, block: B:90:0x02fc  */
    /* JADX WARN: Code duplicated, block: B:93:0x0330  */
    /* JADX WARN: Code duplicated, block: B:95:0x033b  */
    /* JADX WARN: Code duplicated, block: B:97:0x035a  */
    /* JADX WARN: Code duplicated, block: B:99:0x0362  */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v26, types: [com.kc.dw.core.bquery.a, com.kc.dw.core.bquery.d] */
    /* JADX WARN: Type inference failed for: r0v72, types: [com.kc.dw.core.bquery.d] */
    /* JADX WARN: Type inference failed for: r11v46 */
    /* JADX WARN: Type inference failed for: r11v47 */
    /* JADX WARN: Type inference failed for: r11v48 */
    /* JADX WARN: Type inference failed for: r11v5 */
    /* JADX WARN: Type inference failed for: r11v6, types: [com.kc.dw.core.bquery.a] */
    /* JADX WARN: Type inference failed for: r11v7 */
    /* JADX WARN: Type inference failed for: r11v8 */
    /* JADX WARN: Type inference failed for: r12v3, types: [android.view.View, android.widget.ImageView] */
    /* JADX WARN: Type inference failed for: r13v3, types: [android.view.View, android.widget.TextView] */
    /* JADX WARN: Type inference failed for: r33v0, types: [com.kc.dw.core.ad.recycler.FeedAd, com.kc.dw.platform.custom.recycler.MsCustomRecyclerFeedAd] */
    /* JADX WARN: Type inference failed for: r4v20 */
    /* JADX WARN: Type inference failed for: r4v5 */
    /* JADX WARN: Type inference failed for: r4v6, types: [boolean, int] */
    private void showNativeAd(Context context, MsCustomRecyclerFeedAd msCustomRecyclerFeedAd) {
        boolean z;
        boolean z2;
        String str;
        SplashChangeAdapter splashChangeAdapter;
        ?? dVar;
        ?? r4;
        ?? r13;
        ?? r11;
        String str2;
        String str3;
        ?? r12;
        String str4;
        ViewGroup.LayoutParams layoutParams;
        ?? r14;
        ViewGroup.LayoutParams layoutParams2;
        int i;
        int i2;
        ViewGroup.LayoutParams layoutParams3;
        FeedChangeSplash feedChangeSplash = this;
        if (feedChangeSplash.isStartRender) {
            return;
        }
        LogUtil.d(TAG, "开始渲染广告");
        feedChangeSplash.isStartRender = true;
        SsdAdInfo ssdAdInfo = feedChangeSplash.msAdInfo;
        feedChangeSplash.rs = (ssdAdInfo == null || ssdAdInfo.getRs() == null) ? com.kc.dw.core.utils.b.d() : feedChangeSplash.msAdInfo.getRs().intValue();
        if (feedChangeSplash.rs == 1 && !feedChangeSplash.isRenderSucc && feedChangeSplash.splashChangeAdapter != null) {
            feedChangeSplash.isRenderSucc = true;
            LogUtil.d(TAG, "渲染成功");
            feedChangeSplash.splashChangeAdapter.changeRenderSuccess();
        }
        feedChangeSplash.adRoot = (SsdSplashRootView) View.inflate(context, R.layout.ssd_layout_native_splash, null);
        DisplayMetrics displayMetrics = context.getResources().getDisplayMetrics();
        ImageView imageView = (ImageView) feedChangeSplash.adRoot.findViewById(R.id.ssd_layout_native_splash_bg);
        feedChangeSplash.splashSkipView = (SplashSkipView) feedChangeSplash.adRoot.findViewById(R.id.ssd_skipView);
        RelativeLayout relativeLayout = (RelativeLayout) feedChangeSplash.adRoot.findViewById(R.id.ssd_native_splash_ad_container);
        try {
            feedChangeSplash.handleDownloadView(feedChangeSplash.adRoot, msCustomRecyclerFeedAd);
        } catch (Throwable th) {
            th.printStackTrace();
        }
        View viewInflate = View.inflate(context, R.layout.ssd_layout_native_splash_1, null);
        if (msCustomRecyclerFeedAd.getAdPatternType() == 2 || msCustomRecyclerFeedAd.getWidth() <= 0 || msCustomRecyclerFeedAd.getHeight() <= 0 || (msCustomRecyclerFeedAd.getWidth() * 1.0f) / msCustomRecyclerFeedAd.getHeight() >= 0.67d) {
            z = false;
        } else {
            viewInflate = View.inflate(context, R.layout.ssd_layout_native_splash_2, null);
            z = true;
        }
        RelativeLayout relativeLayout2 = (RelativeLayout) viewInflate.findViewById(R.id.activity_sdk_splash_mediaContainer);
        LinearLayout linearLayout = (LinearLayout) viewInflate.findViewById(R.id.ssd_layout_native_splash_ll);
        GifImageView gifImageView = (GifImageView) viewInflate.findViewById(R.id.layout_native_splash_imageview);
        TextView textView = (TextView) viewInflate.findViewById(R.id.layout_native_splash_title);
        ?? r15 = (ImageView) viewInflate.findViewById(R.id.layout_native_splash_icon);
        ImageView imageView2 = (ImageView) viewInflate.findViewById(R.id.layout_native_splash_score);
        TextView textView2 = (TextView) viewInflate.findViewById(R.id.layout_native_splash_desc);
        ImageView imageView3 = (ImageView) feedChangeSplash.adRoot.findViewById(R.id.ssd_layout_native_splash_logo);
        TextView textView3 = (TextView) viewInflate.findViewById(R.id.ssd_jump_btn);
        View view = viewInflate;
        ArrayList arrayList = new ArrayList();
        SplashChangeAdapter splashChangeAdapter2 = feedChangeSplash.splashChangeAdapter;
        if (splashChangeAdapter2 != null) {
            z2 = z;
            if ((splashChangeAdapter2.getSdkAdInfo().getAct_type() & 1) == 1) {
                arrayList.add(linearLayout);
            }
            str = "e4";
            if (msCustomRecyclerFeedAd.getAdPatternType() == 2) {
                LogUtil.d(TAG, "LogEvent.START_LOAD_RES");
                a.a(5, "e4", feedChangeSplash.splashChangeAdapter);
                View mediaView = msCustomRecyclerFeedAd.getMediaView();
                layoutParams2 = mediaView.getLayoutParams();
                if (layoutParams2 == null) {
                    i = -1;
                    i2 = -2;
                    layoutParams2 = new ViewGroup.LayoutParams(-1, -2);
                } else {
                    i = -1;
                    i2 = -2;
                }
                layoutParams2.width = i;
                layoutParams2.height = i2;
                relativeLayout2.removeAllViews();
                relativeLayout2.addView(mediaView, layoutParams2);
                if (linearLayout.getLayoutParams() instanceof FrameLayout.LayoutParams) {
                    FrameLayout.LayoutParams layoutParams4 = (FrameLayout.LayoutParams) linearLayout.getLayoutParams();
                    layoutParams4.width = (int) (((double) displayMetrics.widthPixels) * 0.86d);
                    layoutParams4.height = -2;
                    int i3 = (int) (((double) displayMetrics.heightPixels) * 0.07d);
                    layoutParams4.topMargin = i3;
                    layoutParams4.bottomMargin = i3;
                    layoutParams3 = layoutParams4;
                } else if (linearLayout.getLayoutParams() instanceof RelativeLayout.LayoutParams) {
                    RelativeLayout.LayoutParams layoutParams5 = (RelativeLayout.LayoutParams) linearLayout.getLayoutParams();
                    layoutParams5.width = (int) (((double) displayMetrics.widthPixels) * 0.86d);
                    layoutParams5.height = -2;
                    int i4 = (int) (((double) displayMetrics.heightPixels) * 0.07d);
                    layoutParams5.topMargin = i4;
                    layoutParams5.bottomMargin = i4;
                    layoutParams3 = layoutParams5;
                } else {
                    LogUtil.d(TAG, "LogEvent.LOAD_RES_SUCCESS");
                    a.a(5, "s4", feedChangeSplash.splashChangeAdapter);
                    if (feedChangeSplash.rs == 0 && !feedChangeSplash.isRenderSucc && feedChangeSplash.splashChangeAdapter != null) {
                        feedChangeSplash.isRenderSucc = true;
                        LogUtil.d(TAG, "渲染成功");
                        feedChangeSplash.splashChangeAdapter.changeRenderSuccess();
                    }
                }
                linearLayout.setLayoutParams(layoutParams3);
                LogUtil.d(TAG, "LogEvent.LOAD_RES_SUCCESS");
                a.a(5, "s4", feedChangeSplash.splashChangeAdapter);
                if (feedChangeSplash.rs == 0) {
                    feedChangeSplash.isRenderSucc = true;
                    LogUtil.d(TAG, "渲染成功");
                    feedChangeSplash.splashChangeAdapter.changeRenderSuccess();
                }
            } else {
                str = "e4";
                textView = textView;
            }
            msCustomRecyclerFeedAd.bindAdToView(context, linearLayout, arrayList, new FeedInteractionListener(feedChangeSplash) { // from class: com.kc.dw.platform.custom.ca.splash.FeedChangeSplash.1
                public final FeedChangeSplash this$0;

                {
                    this.this$0 = feedChangeSplash;
                }

                @Override // com.kc.dw.core.loader.InteractionListener
                public void onAdClicked() {
                    if (this.this$0.splashChangeAdapter != null) {
                        this.this$0.splashChangeAdapter.changeAdClicked();
                    }
                }

                @Override // com.kc.dw.core.loader.InteractionListener
                public void onAdClosed() {
                }

                @Override // com.kc.dw.core.loader.InteractionListener
                public void onAdExposure() {
                    if (this.this$0.splashChangeAdapter != null) {
                        this.this$0.splashChangeAdapter.changeAdExposure();
                    }
                }
            });
            splashChangeAdapter = feedChangeSplash.splashChangeAdapter;
            if (splashChangeAdapter != null && h.c(splashChangeAdapter.getSdkAdInfo().getAct_type())) {
                Drawable drawable = context.getResources().getDrawable(R.drawable.ssd_shake_angle);
                int i5 = (int) (displayMetrics.density * 30.0f);
                drawable.setBounds(0, 0, i5, i5);
                textView3.setPadding(60, 0, 60, 0);
                textView3.setCompoundDrawables(drawable, null, null, null);
            }
            dVar = new d(feedChangeSplash.adRoot);
            if (TextUtils.isEmpty(msCustomRecyclerFeedAd.getDesc())) {
                r4 = 0;
                textView2.setVisibility(8);
                imageView2.setVisibility(0);
            } else {
                r4 = 0;
                textView2.setVisibility(0);
                textView2.setText(msCustomRecyclerFeedAd.getDesc());
            }
            r13 = textView;
            if (TextUtils.isEmpty(msCustomRecyclerFeedAd.getTitle())) {
                r13.setVisibility(8);
                imageView2.setVisibility(8);
            } else {
                r13.setVisibility(r4);
                r13.setText(msCustomRecyclerFeedAd.getTitle());
            }
            if (TextUtils.isEmpty(msCustomRecyclerFeedAd.getIconUrl())) {
                r15.setVisibility(8);
            } else {
                r15.setVisibility(r4);
                dVar.d = r15;
                dVar.a(msCustomRecyclerFeedAd.getIconUrl(), r4);
                c0.a(msCustomRecyclerFeedAd.getIconUrl(), new x(feedChangeSplash, r15) { // from class: com.kc.dw.platform.custom.ca.splash.FeedChangeSplash.2
                    public final FeedChangeSplash this$0;
                    public final ImageView val$splashIcon;

                    {
                        this.this$0 = feedChangeSplash;
                        this.val$splashIcon = r15;
                    }

                    @Override // com.kc.dw.core.utils.x
                    public void onFailure(IOException iOException) {
                        this.val$splashIcon.setVisibility(8);
                    }

                    @Override // com.kc.dw.core.utils.x
                    public void onResponse(HttpResponse<byte[]> httpResponse) throws IOException {
                        byte[] responseBody;
                        Bitmap bitmapDecodeByteArray;
                        if (!httpResponse.isSuccessful() || (responseBody = httpResponse.getResponseBody()) == null || responseBody.length <= 0 || (bitmapDecodeByteArray = BitmapFactory.decodeByteArray(responseBody, 0, responseBody.length)) == null) {
                            return;
                        }
                        this.val$splashIcon.setImageBitmap(bitmapDecodeByteArray);
                    }
                });
            }
            if (msCustomRecyclerFeedAd.getAdPatternType() != 2) {
                if (msCustomRecyclerFeedAd.getImgUrls() != null) {
                    str3 = msCustomRecyclerFeedAd.getImgUrls()[0];
                } else {
                    str3 = "";
                }
                if (z2) {
                    if (linearLayout.getLayoutParams() instanceof FrameLayout.LayoutParams) {
                        FrameLayout.LayoutParams layoutParams6 = (FrameLayout.LayoutParams) linearLayout.getLayoutParams();
                        double d = ((double) displayMetrics.widthPixels) * 0.86d;
                        layoutParams6.width = (int) d;
                        str4 = str3;
                        double d2 = 0;
                        layoutParams6.height = (int) ((d * d2) / d2);
                        int i6 = (int) (((double) displayMetrics.heightPixels) * 0.07d);
                        layoutParams6.topMargin = i6;
                        layoutParams6.bottomMargin = i6;
                        linearLayout.setLayoutParams(layoutParams6);
                    } else {
                        str4 = str3;
                        if (linearLayout.getLayoutParams() instanceof RelativeLayout.LayoutParams) {
                            RelativeLayout.LayoutParams layoutParams7 = (RelativeLayout.LayoutParams) linearLayout.getLayoutParams();
                            double d3 = ((double) displayMetrics.widthPixels) * 0.86d;
                            layoutParams7.width = (int) d3;
                            double d4 = 0;
                            layoutParams7.height = (int) ((d3 * d4) / d4);
                            int i7 = (int) (((double) displayMetrics.heightPixels) * 0.07d);
                            layoutParams7.topMargin = i7;
                            layoutParams7.bottomMargin = i7;
                            linearLayout.setLayoutParams(layoutParams7);
                        }
                        r13.setVisibility(8);
                        textView2.setVisibility(8);
                        imageView2.setVisibility(8);
                        r15.setVisibility(8);
                        r14 = dVar;
                    }
                    r13.setVisibility(8);
                    textView2.setVisibility(8);
                    imageView2.setVisibility(8);
                    r15.setVisibility(8);
                    r14 = dVar;
                } else {
                    r12 = dVar;
                    str4 = str3;
                    if (linearLayout.getLayoutParams() instanceof FrameLayout.LayoutParams) {
                        FrameLayout.LayoutParams layoutParams8 = (FrameLayout.LayoutParams) linearLayout.getLayoutParams();
                        layoutParams8.width = (int) (((double) displayMetrics.widthPixels) * 0.86d);
                        layoutParams8.height = -2;
                        int i8 = (int) (((double) displayMetrics.heightPixels) * 0.07d);
                        layoutParams8.topMargin = i8;
                        layoutParams8.bottomMargin = i8;
                        layoutParams = layoutParams8;
                    } else if (linearLayout.getLayoutParams() instanceof RelativeLayout.LayoutParams) {
                        r14 = r12;
                        RelativeLayout.LayoutParams layoutParams9 = (RelativeLayout.LayoutParams) linearLayout.getLayoutParams();
                        layoutParams9.width = (int) (((double) displayMetrics.widthPixels) * 0.86d);
                        layoutParams9.height = -2;
                        int i9 = (int) (((double) displayMetrics.heightPixels) * 0.07d);
                        layoutParams9.topMargin = i9;
                        layoutParams9.bottomMargin = i9;
                        layoutParams = layoutParams9;
                    }
                    linearLayout.setLayoutParams(layoutParams);
                    r14 = r12;
                }
                r14 = r12;
                feedChangeSplash = this;
                a.a(5, str, feedChangeSplash.splashChangeAdapter);
                c0.a(str4, new x(feedChangeSplash, gifImageView, context, imageView) { // from class: com.kc.dw.platform.custom.ca.splash.FeedChangeSplash.3
                    public final FeedChangeSplash this$0;
                    public final Context val$context;
                    public final ImageView val$splashBg;
                    public final GifImageView val$splashImageView;

                    {
                        this.this$0 = feedChangeSplash;
                        this.val$splashImageView = gifImageView;
                        this.val$context = context;
                        this.val$splashBg = imageView;
                    }

                    @Override // com.kc.dw.core.utils.x
                    public void onFailure(IOException iOException) {
                        a.a(5, "f4", this.this$0.splashChangeAdapter, new LoadResState().setFail(2));
                        if (this.this$0.splashChangeAdapter != null) {
                            this.this$0.splashChangeAdapter.changeRenderError(-1, "image load error");
                        }
                    }

                    @Override // com.kc.dw.core.utils.x
                    public void onResponse(HttpResponse<byte[]> httpResponse) throws IOException {
                        FeedChangeSplash feedChangeSplash2;
                        try {
                            if (httpResponse.isSuccessful()) {
                                a.a(5, "s4", this.this$0.splashChangeAdapter, new LoadResState().setSuccess(1, 1, 0));
                                if (this.this$0.rs == 2 && !this.this$0.isRenderSucc && this.this$0.splashChangeAdapter != null) {
                                    this.this$0.isRenderSucc = true;
                                    LogUtil.d(FeedChangeSplash.TAG, "渲染成功");
                                    this.this$0.splashChangeAdapter.changeRenderSuccess();
                                }
                                byte[] responseBody = httpResponse.getResponseBody();
                                if (responseBody == null || responseBody.length <= 0) {
                                    return;
                                }
                                if (responseBody.length < h0.a()) {
                                    Bitmap bitmapDecodeByteArray = BitmapFactory.decodeByteArray(responseBody, 0, responseBody.length);
                                    if (bitmapDecodeByteArray == null && this.this$0.splashChangeAdapter != null) {
                                        this.this$0.splashChangeAdapter.changeRenderError(-1, "image load error");
                                    }
                                    if (bitmapDecodeByteArray != null) {
                                        this.val$splashImageView.setImageBitmap(bitmapDecodeByteArray);
                                    }
                                    Bitmap bitmapDecodeByteArray2 = BitmapFactory.decodeByteArray(responseBody, 0, responseBody.length);
                                    if (bitmapDecodeByteArray2 != null) {
                                        this.val$context.getApplicationContext();
                                        this.val$splashBg.setImageBitmap(d0.a(bitmapDecodeByteArray2, 20));
                                    }
                                    if (this.this$0.rs != 0 || this.this$0.isRenderSucc || this.this$0.splashChangeAdapter == null) {
                                        return;
                                    }
                                    this.this$0.isRenderSucc = true;
                                    LogUtil.d(FeedChangeSplash.TAG, "渲染成功");
                                    this.this$0.splashChangeAdapter.changeRenderSuccess();
                                    return;
                                }
                                if (this.this$0.splashChangeAdapter == null) {
                                    return;
                                } else {
                                    feedChangeSplash2 = this.this$0;
                                }
                            } else if (this.this$0.splashChangeAdapter == null) {
                                return;
                            } else {
                                feedChangeSplash2 = this.this$0;
                            }
                            feedChangeSplash2.splashChangeAdapter.changeRenderError(-1, "image load error");
                        } catch (Throwable unused) {
                            if (this.this$0.splashChangeAdapter != null) {
                                this.this$0.splashChangeAdapter.changeRenderError(-1, "image load error");
                            }
                        }
                    }
                });
                r11 = r14;
            } else {
                r11 = dVar;
            }
            if (msCustomRecyclerFeedAd.getFromLogo() != null) {
                imageView3.setVisibility(0);
                r11.d = imageView3;
                r11.a(msCustomRecyclerFeedAd.getFromLogo(), false);
            } else if (msCustomRecyclerFeedAd.getFromLogoBitmap() != null) {
                imageView3.setImageBitmap(msCustomRecyclerFeedAd.getFromLogoBitmap());
            } else {
                imageView3.setVisibility(8);
            }
            ViewGroup.LayoutParams layoutParams10 = textView3.getLayoutParams();
            layoutParams10.width = (int) (((double) displayMetrics.widthPixels) * 0.86d * 0.77d);
            textView3.setLayoutParams(layoutParams10);
            if (msCustomRecyclerFeedAd.getInteractionType() == 1) {
                str2 = "点击/摇一摇下载第三方应用";
            } else {
                str2 = "点击或摇一摇跳转详情页";
            }
            textView3.setText(str2);
            relativeLayout.addView(view, -1, -1);
            feedChangeSplash.showSkipView(feedChangeSplash.adRoot);
        }
        z2 = z;
        arrayList.add(textView3);
        str = "e4";
        if (msCustomRecyclerFeedAd.getAdPatternType() == 2) {
            LogUtil.d(TAG, "LogEvent.START_LOAD_RES");
            a.a(5, "e4", feedChangeSplash.splashChangeAdapter);
            View mediaView2 = msCustomRecyclerFeedAd.getMediaView();
            layoutParams2 = mediaView2.getLayoutParams();
            if (layoutParams2 == null) {
                i = -1;
                i2 = -2;
                layoutParams2 = new ViewGroup.LayoutParams(-1, -2);
            } else {
                i = -1;
                i2 = -2;
            }
            layoutParams2.width = i;
            layoutParams2.height = i2;
            relativeLayout2.removeAllViews();
            relativeLayout2.addView(mediaView2, layoutParams2);
            if (linearLayout.getLayoutParams() instanceof FrameLayout.LayoutParams) {
                FrameLayout.LayoutParams layoutParams11 = (FrameLayout.LayoutParams) linearLayout.getLayoutParams();
                layoutParams11.width = (int) (((double) displayMetrics.widthPixels) * 0.86d);
                layoutParams11.height = -2;
                int i10 = (int) (((double) displayMetrics.heightPixels) * 0.07d);
                layoutParams11.topMargin = i10;
                layoutParams11.bottomMargin = i10;
                layoutParams3 = layoutParams11;
            } else if (linearLayout.getLayoutParams() instanceof RelativeLayout.LayoutParams) {
                RelativeLayout.LayoutParams layoutParams12 = (RelativeLayout.LayoutParams) linearLayout.getLayoutParams();
                layoutParams12.width = (int) (((double) displayMetrics.widthPixels) * 0.86d);
                layoutParams12.height = -2;
                int i11 = (int) (((double) displayMetrics.heightPixels) * 0.07d);
                layoutParams12.topMargin = i11;
                layoutParams12.bottomMargin = i11;
                layoutParams3 = layoutParams12;
            } else {
                LogUtil.d(TAG, "LogEvent.LOAD_RES_SUCCESS");
                a.a(5, "s4", feedChangeSplash.splashChangeAdapter);
                if (feedChangeSplash.rs == 0) {
                    feedChangeSplash.isRenderSucc = true;
                    LogUtil.d(TAG, "渲染成功");
                    feedChangeSplash.splashChangeAdapter.changeRenderSuccess();
                }
            }
            linearLayout.setLayoutParams(layoutParams3);
            LogUtil.d(TAG, "LogEvent.LOAD_RES_SUCCESS");
            a.a(5, "s4", feedChangeSplash.splashChangeAdapter);
            if (feedChangeSplash.rs == 0) {
                feedChangeSplash.isRenderSucc = true;
                LogUtil.d(TAG, "渲染成功");
                feedChangeSplash.splashChangeAdapter.changeRenderSuccess();
            }
        } else {
            str = "e4";
            textView = textView;
        }
        msCustomRecyclerFeedAd.bindAdToView(context, linearLayout, arrayList, new FeedInteractionListener(feedChangeSplash) { // from class: com.kc.dw.platform.custom.ca.splash.FeedChangeSplash.1
            public final FeedChangeSplash this$0;

            {
                this.this$0 = feedChangeSplash;
            }

            @Override // com.kc.dw.core.loader.InteractionListener
            public void onAdClicked() {
                if (this.this$0.splashChangeAdapter != null) {
                    this.this$0.splashChangeAdapter.changeAdClicked();
                }
            }

            @Override // com.kc.dw.core.loader.InteractionListener
            public void onAdClosed() {
            }

            @Override // com.kc.dw.core.loader.InteractionListener
            public void onAdExposure() {
                if (this.this$0.splashChangeAdapter != null) {
                    this.this$0.splashChangeAdapter.changeAdExposure();
                }
            }
        });
        splashChangeAdapter = feedChangeSplash.splashChangeAdapter;
        if (splashChangeAdapter != null) {
            Drawable drawable2 = context.getResources().getDrawable(R.drawable.ssd_shake_angle);
            int i12 = (int) (displayMetrics.density * 30.0f);
            drawable2.setBounds(0, 0, i12, i12);
            textView3.setPadding(60, 0, 60, 0);
            textView3.setCompoundDrawables(drawable2, null, null, null);
        }
        dVar = new d(feedChangeSplash.adRoot);
        if (TextUtils.isEmpty(msCustomRecyclerFeedAd.getDesc())) {
            r4 = 0;
            textView2.setVisibility(0);
            textView2.setText(msCustomRecyclerFeedAd.getDesc());
        } else {
            r4 = 0;
            textView2.setVisibility(8);
            imageView2.setVisibility(0);
        }
        r13 = textView;
        if (TextUtils.isEmpty(msCustomRecyclerFeedAd.getTitle())) {
            r13.setVisibility(r4);
            r13.setText(msCustomRecyclerFeedAd.getTitle());
        } else {
            r13.setVisibility(8);
            imageView2.setVisibility(8);
        }
        if (TextUtils.isEmpty(msCustomRecyclerFeedAd.getIconUrl())) {
            r15.setVisibility(r4);
            dVar.d = r15;
            dVar.a(msCustomRecyclerFeedAd.getIconUrl(), r4);
            c0.a(msCustomRecyclerFeedAd.getIconUrl(), new x(feedChangeSplash, r15) { // from class: com.kc.dw.platform.custom.ca.splash.FeedChangeSplash.2
                public final FeedChangeSplash this$0;
                public final ImageView val$splashIcon;

                {
                    this.this$0 = feedChangeSplash;
                    this.val$splashIcon = r15;
                }

                @Override // com.kc.dw.core.utils.x
                public void onFailure(IOException iOException) {
                    this.val$splashIcon.setVisibility(8);
                }

                @Override // com.kc.dw.core.utils.x
                public void onResponse(HttpResponse<byte[]> httpResponse) throws IOException {
                    byte[] responseBody;
                    Bitmap bitmapDecodeByteArray;
                    if (!httpResponse.isSuccessful() || (responseBody = httpResponse.getResponseBody()) == null || responseBody.length <= 0 || (bitmapDecodeByteArray = BitmapFactory.decodeByteArray(responseBody, 0, responseBody.length)) == null) {
                        return;
                    }
                    this.val$splashIcon.setImageBitmap(bitmapDecodeByteArray);
                }
            });
        } else {
            r15.setVisibility(8);
        }
        if (msCustomRecyclerFeedAd.getAdPatternType() != 2) {
            if (msCustomRecyclerFeedAd.getImgUrls() != null) {
                str3 = msCustomRecyclerFeedAd.getImgUrls()[0];
            } else {
                str3 = "";
            }
            if (z2) {
                if (linearLayout.getLayoutParams() instanceof FrameLayout.LayoutParams) {
                    FrameLayout.LayoutParams layoutParams13 = (FrameLayout.LayoutParams) linearLayout.getLayoutParams();
                    double d5 = ((double) displayMetrics.widthPixels) * 0.86d;
                    layoutParams13.width = (int) d5;
                    str4 = str3;
                    double d6 = 0;
                    layoutParams13.height = (int) ((d5 * d6) / d6);
                    int i13 = (int) (((double) displayMetrics.heightPixels) * 0.07d);
                    layoutParams13.topMargin = i13;
                    layoutParams13.bottomMargin = i13;
                    linearLayout.setLayoutParams(layoutParams13);
                } else {
                    str4 = str3;
                    if (linearLayout.getLayoutParams() instanceof RelativeLayout.LayoutParams) {
                        RelativeLayout.LayoutParams layoutParams14 = (RelativeLayout.LayoutParams) linearLayout.getLayoutParams();
                        double d7 = ((double) displayMetrics.widthPixels) * 0.86d;
                        layoutParams14.width = (int) d7;
                        double d8 = 0;
                        layoutParams14.height = (int) ((d7 * d8) / d8);
                        int i14 = (int) (((double) displayMetrics.heightPixels) * 0.07d);
                        layoutParams14.topMargin = i14;
                        layoutParams14.bottomMargin = i14;
                        linearLayout.setLayoutParams(layoutParams14);
                    }
                    r13.setVisibility(8);
                    textView2.setVisibility(8);
                    imageView2.setVisibility(8);
                    r15.setVisibility(8);
                    r14 = dVar;
                }
                r13.setVisibility(8);
                textView2.setVisibility(8);
                imageView2.setVisibility(8);
                r15.setVisibility(8);
                r14 = dVar;
            } else {
                r12 = dVar;
                str4 = str3;
                if (linearLayout.getLayoutParams() instanceof FrameLayout.LayoutParams) {
                    FrameLayout.LayoutParams layoutParams15 = (FrameLayout.LayoutParams) linearLayout.getLayoutParams();
                    layoutParams15.width = (int) (((double) displayMetrics.widthPixels) * 0.86d);
                    layoutParams15.height = -2;
                    int i15 = (int) (((double) displayMetrics.heightPixels) * 0.07d);
                    layoutParams15.topMargin = i15;
                    layoutParams15.bottomMargin = i15;
                    layoutParams = layoutParams15;
                } else if (linearLayout.getLayoutParams() instanceof RelativeLayout.LayoutParams) {
                    r14 = r12;
                    RelativeLayout.LayoutParams layoutParams16 = (RelativeLayout.LayoutParams) linearLayout.getLayoutParams();
                    layoutParams16.width = (int) (((double) displayMetrics.widthPixels) * 0.86d);
                    layoutParams16.height = -2;
                    int i16 = (int) (((double) displayMetrics.heightPixels) * 0.07d);
                    layoutParams16.topMargin = i16;
                    layoutParams16.bottomMargin = i16;
                    layoutParams = layoutParams16;
                }
                linearLayout.setLayoutParams(layoutParams);
                r14 = r12;
            }
            r14 = r12;
            feedChangeSplash = this;
            a.a(5, str, feedChangeSplash.splashChangeAdapter);
            c0.a(str4, new x(feedChangeSplash, gifImageView, context, imageView) { // from class: com.kc.dw.platform.custom.ca.splash.FeedChangeSplash.3
                public final FeedChangeSplash this$0;
                public final Context val$context;
                public final ImageView val$splashBg;
                public final GifImageView val$splashImageView;

                {
                    this.this$0 = feedChangeSplash;
                    this.val$splashImageView = gifImageView;
                    this.val$context = context;
                    this.val$splashBg = imageView;
                }

                @Override // com.kc.dw.core.utils.x
                public void onFailure(IOException iOException) {
                    a.a(5, "f4", this.this$0.splashChangeAdapter, new LoadResState().setFail(2));
                    if (this.this$0.splashChangeAdapter != null) {
                        this.this$0.splashChangeAdapter.changeRenderError(-1, "image load error");
                    }
                }

                @Override // com.kc.dw.core.utils.x
                public void onResponse(HttpResponse<byte[]> httpResponse) throws IOException {
                    FeedChangeSplash feedChangeSplash2;
                    try {
                        if (httpResponse.isSuccessful()) {
                            a.a(5, "s4", this.this$0.splashChangeAdapter, new LoadResState().setSuccess(1, 1, 0));
                            if (this.this$0.rs == 2 && !this.this$0.isRenderSucc && this.this$0.splashChangeAdapter != null) {
                                this.this$0.isRenderSucc = true;
                                LogUtil.d(FeedChangeSplash.TAG, "渲染成功");
                                this.this$0.splashChangeAdapter.changeRenderSuccess();
                            }
                            byte[] responseBody = httpResponse.getResponseBody();
                            if (responseBody == null || responseBody.length <= 0) {
                                return;
                            }
                            if (responseBody.length < h0.a()) {
                                Bitmap bitmapDecodeByteArray = BitmapFactory.decodeByteArray(responseBody, 0, responseBody.length);
                                if (bitmapDecodeByteArray == null && this.this$0.splashChangeAdapter != null) {
                                    this.this$0.splashChangeAdapter.changeRenderError(-1, "image load error");
                                }
                                if (bitmapDecodeByteArray != null) {
                                    this.val$splashImageView.setImageBitmap(bitmapDecodeByteArray);
                                }
                                Bitmap bitmapDecodeByteArray2 = BitmapFactory.decodeByteArray(responseBody, 0, responseBody.length);
                                if (bitmapDecodeByteArray2 != null) {
                                    this.val$context.getApplicationContext();
                                    this.val$splashBg.setImageBitmap(d0.a(bitmapDecodeByteArray2, 20));
                                }
                                if (this.this$0.rs != 0 || this.this$0.isRenderSucc || this.this$0.splashChangeAdapter == null) {
                                    return;
                                }
                                this.this$0.isRenderSucc = true;
                                LogUtil.d(FeedChangeSplash.TAG, "渲染成功");
                                this.this$0.splashChangeAdapter.changeRenderSuccess();
                                return;
                            }
                            if (this.this$0.splashChangeAdapter == null) {
                                return;
                            } else {
                                feedChangeSplash2 = this.this$0;
                            }
                        } else if (this.this$0.splashChangeAdapter == null) {
                            return;
                        } else {
                            feedChangeSplash2 = this.this$0;
                        }
                        feedChangeSplash2.splashChangeAdapter.changeRenderError(-1, "image load error");
                    } catch (Throwable unused) {
                        if (this.this$0.splashChangeAdapter != null) {
                            this.this$0.splashChangeAdapter.changeRenderError(-1, "image load error");
                        }
                    }
                }
            });
            r11 = r14;
        } else {
            r11 = dVar;
        }
        if (msCustomRecyclerFeedAd.getFromLogo() != null) {
            imageView3.setVisibility(0);
            r11.d = imageView3;
            r11.a(msCustomRecyclerFeedAd.getFromLogo(), false);
        } else if (msCustomRecyclerFeedAd.getFromLogoBitmap() != null) {
            imageView3.setImageBitmap(msCustomRecyclerFeedAd.getFromLogoBitmap());
        } else {
            imageView3.setVisibility(8);
        }
        ViewGroup.LayoutParams layoutParams17 = textView3.getLayoutParams();
        layoutParams17.width = (int) (((double) displayMetrics.widthPixels) * 0.86d * 0.77d);
        textView3.setLayoutParams(layoutParams17);
        if (msCustomRecyclerFeedAd.getInteractionType() == 1) {
            str2 = "点击/摇一摇下载第三方应用";
        } else {
            str2 = "点击或摇一摇跳转详情页";
        }
        textView3.setText(str2);
        relativeLayout.addView(view, -1, -1);
        feedChangeSplash.showSkipView(feedChangeSplash.adRoot);
    }

    private void showSkipView(SsdSplashRootView ssdSplashRootView) {
        try {
            this.splashSkipView = (SplashSkipView) ssdSplashRootView.findViewById(R.id.ssd_skipView);
            this.splashSkipView.setOnSkipListener(new SplashSkipView.b(this) { // from class: com.kc.dw.platform.custom.ca.splash.FeedChangeSplash.7
                public final FeedChangeSplash this$0;

                {
                    this.this$0 = this;
                }

                @Override // com.kc.dw.ad.splash.SplashSkipView.b
                public void onSkip() {
                    if (this.this$0.splashChangeAdapter != null) {
                        this.this$0.splashChangeAdapter.changeAdSkip();
                    }
                }

                @Override // com.kc.dw.ad.splash.SplashSkipView.b
                public void onTick(long j) {
                    if (this.this$0.splashChangeAdapter != null) {
                        this.this$0.splashChangeAdapter.changeAdTick(j);
                    }
                }

                @Override // com.kc.dw.ad.splash.SplashSkipView.b
                public void onTimeOver() {
                    if (this.this$0.splashChangeAdapter != null) {
                        this.this$0.splashChangeAdapter.changeAdTimeOver();
                    }
                }
            });
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    @Override // com.kc.dw.platform.custom.ca.splash.ISplashChangeAd
    public void createSplashAd(Context context, MsCustomRecyclerFeedAd msCustomRecyclerFeedAd) {
        LogUtil.d(TAG, "createSplashAd--");
        this.context = context;
        this.ad = msCustomRecyclerFeedAd;
        try {
            this.splashChangeAdapter.getAdLoader().getAdSlot().isAutoRender();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override // com.kc.dw.platform.custom.ca.splash.ISplashChangeAd
    public void render() {
        LogUtil.d(TAG, "调用render接口");
        if (this.rs == 1 && !this.isRenderSucc && this.splashChangeAdapter != null) {
            this.isRenderSucc = true;
            LogUtil.d(TAG, "渲染成功");
            this.splashChangeAdapter.changeRenderSuccess();
        }
        try {
            showNativeAd(this.context, this.ad);
        } catch (Exception e) {
            SplashChangeAdapter splashChangeAdapter = this.splashChangeAdapter;
            if (splashChangeAdapter != null) {
                splashChangeAdapter.changeRenderError(200002, "show ad error");
            }
            e.printStackTrace();
        }
    }

    @Override // com.kc.dw.platform.custom.ca.splash.ISplashChangeAd
    public void showAd(ViewGroup viewGroup) {
        try {
            LogUtil.d(TAG, "showAd--");
            if (viewGroup == null) {
                SplashChangeAdapter splashChangeAdapter = this.splashChangeAdapter;
                if (splashChangeAdapter != null) {
                    splashChangeAdapter.changeRenderError(200002, "container is null");
                    return;
                }
                return;
            }
            try {
                showNativeAd(this.context, this.ad);
            } catch (Exception e) {
                SplashChangeAdapter splashChangeAdapter2 = this.splashChangeAdapter;
                if (splashChangeAdapter2 != null) {
                    splashChangeAdapter2.changeRenderError(200002, "show ad error");
                }
                e.printStackTrace();
            }
            if (this.showed || this.adRoot == null) {
                return;
            }
            if (!recordedStartShowAdLog()) {
                a.a(5, "e7", this.splashChangeAdapter);
            }
            viewGroup.removeAllViews();
            viewGroup.addView(this.adRoot, -1, -1);
            this.showed = true;
            LogUtil.d(TAG, "splashSkipView=" + this.splashSkipView);
            SplashSkipView splashSkipView = this.splashSkipView;
            if (splashSkipView != null) {
                splashSkipView.c();
            }
        } catch (Throwable th) {
            SplashChangeAdapter splashChangeAdapter3 = this.splashChangeAdapter;
            if (splashChangeAdapter3 != null) {
                splashChangeAdapter3.changeRenderError(200002, "show ad error");
            }
            th.printStackTrace();
        }
    }
}

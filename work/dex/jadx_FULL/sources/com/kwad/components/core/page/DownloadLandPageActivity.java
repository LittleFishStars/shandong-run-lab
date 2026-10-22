package com.kwad.components.core.page;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.BitmapFactory;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.Keep;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.kwad.components.core.video.DetailVideoView;
import com.kwad.components.core.video.l;
import com.kwad.components.core.video.m;
import com.kwad.components.core.widget.ComplianceTextView;
import com.kwad.components.core.widget.KsLogoView;
import com.kwad.sdk.R;
import com.kwad.sdk.api.KsVideoPlayConfig;
import com.kwad.sdk.api.core.KsAdSdkDynamicImpl;
import com.kwad.sdk.api.proxy.app.AdWebViewActivity;
import com.kwad.sdk.api.proxy.app.KsFullScreenLandScapeVideoActivity;
import com.kwad.sdk.core.imageloader.KSImageLoader;
import com.kwad.sdk.core.imageloader.core.DisplayImageOptionsCompat;
import com.kwad.sdk.core.imageloader.core.decode.DecodedResult;
import com.kwad.sdk.core.imageloader.core.listener.SimpleImageLoadingListener;
import com.kwad.sdk.core.imageloader.utils.BlurUtils;
import com.kwad.sdk.core.page.widget.RoundAngleImageView;
import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.mvp.Presenter;
import com.kwad.sdk.service.ServiceProvider;
import com.kwad.sdk.utils.as;
import com.kwad.sdk.utils.bi;
import com.kwad.sdk.widget.DownloadProgressBar;
import com.kwad.sdk.widget.KSLinearLayout;
import com.kwad.sdk.widget.KSRelativeLayout;
import java.io.InputStream;
import org.json.JSONObject;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_06_4659cls.dex */
@KsAdSdkDynamicImpl(AdWebViewActivity.class)
@Keep
public class DownloadLandPageActivity extends com.kwad.components.core.n.b<com.kwad.components.core.page.d.e> {
    private static final String KEY_AD_RESULT_CACHE_IDX = "key_ad_result_cache_idx";
    public static final String KEY_NEED_CLOSE_REWARD = "key_close_reward";
    private static final String TAG = "DownloadLandPageActivity";
    public static boolean showingAdWebViewLandPage = false;
    private AdInfo mAdInfo;
    private AdTemplate mAdTemplate;
    private com.kwad.components.core.e.d.d mApkDownloadHelper;
    private ImageView mBackIcon;
    private ImageView mCloseIcon;
    private DetailVideoView mDetailVideoView;
    private boolean mIsRewardLandPage;
    private KSRelativeLayout mKsadVideoContainer;
    private com.kwad.components.core.page.e.a mPlayModule;
    private ImageView mVideoBlurBg;
    private ImageView mVideoCover;
    private l mVideoPlayStateListener;

    private void buildView(ComplianceTextView complianceTextView, KSLinearLayout kSLinearLayout, KsLogoView ksLogoView) {
        if (com.kwad.sdk.core.response.helper.a.bi(com.kwad.sdk.core.response.helper.e.eO(this.mAdTemplate))) {
            return;
        }
        ((FrameLayout.LayoutParams) complianceTextView.getLayoutParams()).gravity = 80;
        if (!as.VM()) {
            ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) ksLogoView.getLayoutParams();
            marginLayoutParams.setMargins(0, 0, 0, com.kwad.sdk.c.a.a.a(this.mContext, 100.0f));
            ksLogoView.setLayoutParams(marginLayoutParams);
        }
        ksLogoView.setVisibility(0);
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) kSLinearLayout.getLayoutParams();
        layoutParams.gravity = 17;
        kSLinearLayout.setLayoutParams(layoutParams);
    }

    private l getVideoPlayStateListener() {
        m mVar = new m() { // from class: com.kwad.components.core.page.DownloadLandPageActivity.6
            @Override // com.kwad.components.core.video.m, com.kwad.components.core.video.i
            public final void onMediaPlayCompleted() {
                DownloadLandPageActivity.this.mVideoCover.setVisibility(0);
            }

            @Override // com.kwad.components.core.video.m, com.kwad.components.core.video.i
            public final void onMediaPlayError(int i, int i2) {
            }

            @Override // com.kwad.components.core.video.m, com.kwad.components.core.video.i
            public final void onMediaPlayStart() {
                DownloadLandPageActivity.this.mVideoCover.setVisibility(8);
            }
        };
        this.mVideoPlayStateListener = mVar;
        return mVar;
    }

    @NonNull
    private com.kwad.components.core.page.d.g.a getWebViewStateListener() {
        return new com.kwad.components.core.page.d.g.a() { // from class: com.kwad.components.core.page.DownloadLandPageActivity.3
            @Override // com.kwad.components.core.page.d.g.a
            public final void bw(int i) {
                if (i != 1) {
                    DownloadLandPageActivity.this.initNativeLandPage();
                }
            }
        };
    }

    private void handleCloseBtn() {
        long jAq = com.kwad.sdk.core.response.helper.a.aq(this.mAdInfo);
        if (jAq == 0) {
            this.mCloseIcon.setVisibility(0);
        } else {
            this.mCloseIcon.postDelayed(new bi() { // from class: com.kwad.components.core.page.DownloadLandPageActivity.7
                @Override // com.kwad.sdk.utils.bi
                public final void doTask() {
                    if (DownloadLandPageActivity.this.getActivity() == null || DownloadLandPageActivity.this.getActivity().isFinishing()) {
                        return;
                    }
                    DownloadLandPageActivity.this.mCloseIcon.setVisibility(0);
                    DownloadLandPageActivity.this.mCloseIcon.setAlpha(0.0f);
                    DownloadLandPageActivity.this.mCloseIcon.animate().alpha(1.0f).setDuration(500L).start();
                }
            }, jAq);
        }
        this.mCloseIcon.setOnClickListener(new View.OnClickListener() { // from class: com.kwad.components.core.page.DownloadLandPageActivity.8
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                try {
                    com.kwad.components.core.t.c.wG().wH();
                    DownloadLandPageActivity.this.finish();
                } catch (Throwable th) {
                    ServiceProvider.reportSdkCaughtException(th);
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void initNativeLandPage() {
        findViewById(R.id.ksad_ad_land_page_native).setVisibility(0);
        ComplianceTextView complianceTextView = (ComplianceTextView) findViewById(R.id.ksad_compliance_view);
        complianceTextView.setVisibility(0);
        complianceTextView.setAdTemplate(this.mAdTemplate);
        RoundAngleImageView roundAngleImageView = (RoundAngleImageView) findViewById(R.id.ksad_ad_cover);
        TextView textView = (TextView) findViewById(R.id.ksad_ad_title);
        TextView textView2 = (TextView) findViewById(R.id.ksad_ad_info);
        KSLinearLayout kSLinearLayout = (KSLinearLayout) findViewById(R.id.ksad_info_container);
        KsLogoView ksLogoView = (KsLogoView) findViewById(R.id.ksad_land_page_logo);
        DownloadProgressBar downloadProgressBar = (DownloadProgressBar) findViewById(R.id.ksad_web_download_progress);
        AdInfo adInfoEO = com.kwad.sdk.core.response.helper.e.eO(this.mAdTemplate);
        setAdTitle(textView, adInfoEO);
        textView2.setText(adInfoEO.adBaseInfo.adDescription);
        roundAngleImageView.setRadius(32.0f);
        if (!TextUtils.isEmpty(com.kwad.sdk.core.response.helper.a.cv(adInfoEO))) {
            KSImageLoader.loadImage(roundAngleImageView, com.kwad.sdk.core.response.helper.a.cv(adInfoEO), this.mAdTemplate);
        }
        setAdkDownload(downloadProgressBar, adInfoEO);
        buildView(complianceTextView, kSLinearLayout, ksLogoView);
    }

    public static void launch(@NonNull Context context, @NonNull AdTemplate adTemplate, boolean z) {
        Class cls = as.VM() ? AdWebViewActivity.class : KsFullScreenLandScapeVideoActivity.class;
        com.kwad.sdk.service.c.putComponentProxy(cls, DownloadLandPageActivity.class);
        Intent intent = new Intent(context, (Class<?>) cls);
        if (!(context instanceof Activity)) {
            intent.setFlags(268435456);
        }
        intent.putExtra("key_ad_result_cache_idx", com.kwad.components.core.c.f.oU().l(adTemplate.createAdResultData()));
        intent.putExtra(KEY_NEED_CLOSE_REWARD, z);
        context.startActivity(intent);
    }

    private void loadBlurImage(String str, ImageView imageView) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        imageView.setVisibility(0);
        KSImageLoader.loadImage(imageView, str, this.mAdTemplate, new DisplayImageOptionsCompat.Builder().setBlurRadius(50).build(), new SimpleImageLoadingListener() { // from class: com.kwad.components.core.page.DownloadLandPageActivity.2
            @Override // com.kwad.sdk.core.imageloader.core.listener.SimpleImageLoadingListener, com.kwad.sdk.core.imageloader.core.listener.ImageLoadingListener
            public final boolean onDecode(String str2, InputStream inputStream, DecodedResult decodedResult) {
                decodedResult.mBitmap = BlurUtils.stackBlur(BitmapFactory.decodeStream(inputStream), 50, false);
                return true;
            }
        });
    }

    private void setAdTitle(TextView textView, AdInfo adInfo) {
        if (!TextUtils.isEmpty(adInfo.adBaseInfo.appName)) {
            textView.setText(adInfo.adBaseInfo.appName);
        } else {
            if (TextUtils.isEmpty(adInfo.advertiserInfo.rawUserName)) {
                return;
            }
            textView.setText(adInfo.advertiserInfo.rawUserName);
        }
    }

    private void setAdkDownload(final DownloadProgressBar downloadProgressBar, final AdInfo adInfo) {
        if (com.kwad.sdk.core.response.helper.a.aL(adInfo)) {
            this.mApkDownloadHelper = new com.kwad.components.core.e.d.d(this.mAdTemplate, new com.kwad.sdk.core.download.a.a() { // from class: com.kwad.components.core.page.DownloadLandPageActivity.4
                @Override // com.kwad.sdk.api.KsAppDownloadListener
                public final void onDownloadFailed() {
                    downloadProgressBar.setProgress(100.0f);
                    downloadProgressBar.setText(com.kwad.sdk.core.response.helper.a.aK(adInfo));
                }

                @Override // com.kwad.sdk.api.KsAppDownloadListener
                public final void onDownloadFinished() {
                    downloadProgressBar.setProgress(100.0f);
                    downloadProgressBar.setText(com.kwad.sdk.core.response.helper.a.cK(DownloadLandPageActivity.this.mAdTemplate));
                }

                @Override // com.kwad.sdk.api.KsAppDownloadListener
                public final void onIdle() {
                    downloadProgressBar.setProgress(100.0f);
                    downloadProgressBar.setText(com.kwad.sdk.core.response.helper.a.aK(adInfo));
                }

                @Override // com.kwad.sdk.api.KsAppDownloadListener
                public final void onInstalled() {
                    downloadProgressBar.setProgress(100.0f);
                    downloadProgressBar.setText(com.kwad.sdk.core.response.helper.a.af(adInfo));
                }

                @Override // com.kwad.sdk.core.download.a.a
                public final void onPaused(int i) {
                    downloadProgressBar.setProgress(i);
                    downloadProgressBar.setText(com.kwad.sdk.core.response.helper.a.eG(i));
                }

                @Override // com.kwad.sdk.api.KsAppDownloadListener
                public final void onProgressUpdate(int i) {
                    downloadProgressBar.setProgress(i);
                    downloadProgressBar.setText(com.kwad.sdk.core.response.helper.a.eF(i));
                }
            });
            downloadProgressBar.setOnClickListener(new View.OnClickListener() { // from class: com.kwad.components.core.page.DownloadLandPageActivity.5
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    com.kwad.sdk.core.adlog.c.t(DownloadLandPageActivity.this.mAdTemplate, 152);
                    DownloadLandPageActivity.this.mApkDownloadHelper.v(new com.kwad.components.core.e.d.a.C1201a(DownloadLandPageActivity.this.getActivity()).as(true).at(false).aJ(DownloadLandPageActivity.this.mAdTemplate).av(false));
                    if (DownloadLandPageActivity.this.mIsRewardLandPage) {
                        com.kwad.sdk.core.adlog.c.a(DownloadLandPageActivity.this.mAdTemplate, new com.kwad.sdk.core.adlog.c.b(), (JSONObject) null);
                    }
                }
            });
        }
    }

    private void setVideoData() {
        ViewGroup.LayoutParams layoutParams = this.mKsadVideoContainer.getLayoutParams();
        if (as.VM()) {
            layoutParams.height = (com.kwad.sdk.c.a.a.getScreenWidth(this.mContext) * 9) / 16;
            layoutParams.width = -1;
        } else {
            layoutParams.width = com.kwad.sdk.c.a.a.getScreenWidth(this.mContext) / 2;
            layoutParams.height = -1;
        }
        this.mKsadVideoContainer.setLayoutParams(layoutParams);
        this.mKsadVideoContainer.setVisibility(0);
        KSImageLoader.loadImage(this.mVideoCover, com.kwad.sdk.core.response.helper.a.bA(this.mAdInfo).getUrl(), this.mAdTemplate);
    }

    @Override // com.kwad.components.core.proxy.f
    public boolean checkIntentData(@Nullable Intent intent) {
        try {
            this.mAdTemplate = com.kwad.components.core.c.f.oU().d(getIntent().getIntExtra("key_ad_result_cache_idx", 0), true).getFirstAdTemplate();
        } catch (Throwable th) {
            com.kwad.sdk.core.d.c.printStackTraceOnly(th);
        }
        return this.mAdTemplate != null;
    }

    @Override // com.kwad.components.core.proxy.f
    public int getLayoutId() {
        return as.VM() ? R.layout.ksad_activity_ad_land_page : R.layout.ksad_activity_land_page_horizontal;
    }

    @Override // com.kwad.components.core.proxy.f
    public String getPageName() {
        return TAG;
    }

    @Override // com.kwad.components.core.proxy.f
    public void initData() {
        showingAdWebViewLandPage = true;
        this.mIsRewardLandPage = getIntent().getBooleanExtra(KEY_NEED_CLOSE_REWARD, false);
        this.mAdInfo = com.kwad.sdk.core.response.helper.e.eO(this.mAdTemplate);
    }

    @Override // com.kwad.components.core.proxy.f
    public void initView() {
        KSRelativeLayout kSRelativeLayout = (KSRelativeLayout) findViewById(R.id.ksad_root_container);
        this.mKsadVideoContainer = (KSRelativeLayout) findViewById(R.id.ksad_video_container);
        DetailVideoView detailVideoView = (DetailVideoView) kSRelativeLayout.findViewById(R.id.ksad_video_player);
        this.mDetailVideoView = detailVideoView;
        detailVideoView.g(true, com.kwad.sdk.core.config.e.Ky());
        this.mVideoBlurBg = (ImageView) kSRelativeLayout.findViewById(R.id.ksad_video_blur_bg);
        this.mBackIcon = (ImageView) kSRelativeLayout.findViewById(R.id.ksad_back_icon);
        this.mCloseIcon = (ImageView) kSRelativeLayout.findViewById(R.id.ksad_right_close);
        this.mVideoCover = (ImageView) kSRelativeLayout.findViewById(R.id.ksad_video_cover);
        if (this.mAdTemplate.adInfoList.size() > 0) {
            loadBlurImage(com.kwad.sdk.core.response.helper.a.aa(this.mAdTemplate.adInfoList.get(0)), this.mVideoBlurBg);
        }
        this.mBackIcon.setOnClickListener(new View.OnClickListener() { // from class: com.kwad.components.core.page.DownloadLandPageActivity.1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                try {
                    com.kwad.sdk.core.adlog.c.t(DownloadLandPageActivity.this.mAdTemplate, 153);
                    DownloadLandPageActivity.this.finish();
                } catch (Throwable th) {
                    ServiceProvider.reportSdkCaughtException(th);
                }
            }
        });
        if (com.kwad.sdk.core.response.helper.a.bi(com.kwad.sdk.core.response.helper.e.eO(this.mAdTemplate))) {
            setVideoData();
        }
        if (this.mIsRewardLandPage) {
            handleCloseBtn();
        }
    }

    @Override // com.kwad.components.core.n.b
    public Presenter onCreatePresenter() {
        Presenter presenter = new Presenter();
        if (com.kwad.sdk.core.response.helper.a.bi(com.kwad.sdk.core.response.helper.e.eO(this.mAdTemplate))) {
            presenter.a(new com.kwad.components.core.page.d.f());
        }
        presenter.a(new com.kwad.components.core.page.d.g(getWebViewStateListener(), this.mIsRewardLandPage));
        return presenter;
    }

    @Override // com.kwad.components.core.n.b, com.kwad.components.core.proxy.f, com.kwad.sdk.api.proxy.IActivityProxy
    public void onDestroy() {
        try {
            super.onDestroy();
            showingAdWebViewLandPage = false;
            com.kwad.components.core.e.d.d dVar = this.mApkDownloadHelper;
            if (dVar != null) {
                dVar.clear();
            }
            com.kwad.components.core.page.e.a aVar = this.mPlayModule;
            if (aVar != null) {
                aVar.release();
            }
        } catch (Throwable th) {
            ServiceProvider.reportSdkCaughtException(th);
        }
    }

    @Override // com.kwad.components.core.n.b
    public com.kwad.components.core.page.d.e onCreateCallerContext() {
        com.kwad.components.core.page.d.e eVar = new com.kwad.components.core.page.d.e(this);
        AdTemplate adTemplate = this.mAdTemplate;
        eVar.mAdTemplate = adTemplate;
        if (com.kwad.sdk.core.response.helper.a.bi(com.kwad.sdk.core.response.helper.e.eO(adTemplate))) {
            com.kwad.components.core.t.a.aO(this.mContext).bd(true);
            com.kwad.components.core.page.e.a aVar = new com.kwad.components.core.page.e.a(this.mAdTemplate, this.mDetailVideoView, new KsVideoPlayConfig.Builder().videoSoundEnable(true).build());
            this.mPlayModule = aVar;
            eVar.mPlayModule = aVar;
            aVar.a(getVideoPlayStateListener());
            eVar.abk.add(this.mPlayModule);
        }
        return eVar;
    }
}

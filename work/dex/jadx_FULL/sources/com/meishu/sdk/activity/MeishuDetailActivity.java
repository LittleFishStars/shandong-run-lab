package com.meishu.sdk.activity;

import android.content.Intent;
import android.graphics.SurfaceTexture;
import android.media.MediaPlayer;
import android.os.Build;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.Surface;
import android.view.TextureView;
import android.view.View;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.meishu.sdk.R;
import com.meishu.sdk.core.ad.AdSlot;
import com.meishu.sdk.core.bquery.e;
import com.meishu.sdk.core.bquery.i;
import com.meishu.sdk.core.safe.SafeAppCompatActivity;
import com.meishu.sdk.core.safe.g;
import com.meishu.sdk.core.safe.k;
import com.meishu.sdk.core.safe.o;
import com.meishu.sdk.core.utils.LogUtil;
import com.meishu.sdk.core.utils.f;
import com.meishu.sdk.core.utils.p0;
import com.meishu.sdk.core.webview.m;
import com.meishu.sdk.meishu_ad.nativ.NormalMediaView;
import com.meishu.sdk.meishu_ad.view.MeishuVideoTextureView;
import com.meishu.sdk.platform.ms.c;
import java.text.DecimalFormat;
import java.util.HashMap;
import java.util.Locale;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_01_2010cls.dex */
public class MeishuDetailActivity extends SafeAppCompatActivity {
    public static final String EXTRA_APP_NAME = "EXTRA_APP_NAME";
    public static final String EXTRA_COMMENTS = "EXTRA_COMMENTS";
    public static final String EXTRA_CONTENT = "EXTRA_CONTENT";
    public static final String EXTRA_DOWN_NUM = "EXTRA_DOWN_NUM";
    public static final String EXTRA_DURL = "EXTRA_DURL";
    public static final String EXTRA_ICON_URL = "EXTRA_ICON_URL";
    public static final String EXTRA_INTERACTION_TYPE = "EXTRA_INTERACTION_TYPE";
    public static final String EXTRA_SCORE = "EXTRA_SCORE";
    public static final String EXTRA_STRONG_ACTION = "EXTRA_STRONG_ACTION";
    public static final String EXTRA_VIDEO_COVER = "EXTRA_VIDEO_COVER";
    public static final String EXTRA_VIDEO_END_COVER = "EXTRA_VIDEO_END_COVER";
    public static final String EXTRA_VIDEO_HEIGHT = "EXTRA_VIDEO_HEIGHT";
    public static final String EXTRA_VIDEO_WIDTH = "EXTRA_VIDEO_WIDTH";
    private static c nativeAd;
    private static NormalMediaView normalMediaView;
    private boolean isFinished;
    private RelativeLayout mAppDetailRL;
    private ProgressBar mProgressBar;
    private int textureHeight;
    private int textureWidth;
    private NormalMediaView thisNormalMediaView;
    private String videoCover;
    private WebView webView;
    private final String TAG = getClass().getSimpleName();
    private int interactionType = -1;
    private HashMap<String, Integer> whiteList = new HashMap<>();
    private i bQuery = new i(this);
    private boolean strongAction = true;
    private MediaPlayer.OnInfoListener onInfoListener = new g() { // from class: com.meishu.sdk.activity.MeishuDetailActivity.4
        public boolean safeOnInfo(MediaPlayer mediaPlayer, int i, int i2) {
            if (i == 701) {
                MeishuDetailActivity.this.mProgressBar.setVisibility(0);
                return true;
            }
            if (i != 702) {
                return true;
            }
            MeishuDetailActivity.this.mProgressBar.setVisibility(8);
            return true;
        }
    };

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public void gotoFinish() {
        this.isFinished = true;
        finish();
    }

    private void loadAppDetail(String str, String str2, String str3, float f, int i, int i2) {
        if (TextUtils.isEmpty(str)) {
            this.bQuery.b(R.id.ms_layout_app_detail_info).d(8);
            if (TextUtils.isEmpty(str3)) {
                this.bQuery.b(R.id.ms_img_icon).d(8);
            } else {
                this.bQuery.b(R.id.ms_img_icon).a(str3, false);
            }
        } else {
            View view = ((e) this.bQuery.b(R.id.ms_text_title)).d;
            if (view instanceof TextView) {
                ((TextView) view).setText(str);
            }
            if (TextUtils.isEmpty(str2)) {
                this.bQuery.b(R.id.ms_text_content).d(8);
            } else {
                View view2 = ((e) this.bQuery.b(R.id.ms_text_content)).d;
                if (view2 instanceof TextView) {
                    ((TextView) view2).setText(str2);
                }
            }
            if (!TextUtils.isEmpty(str3)) {
                this.bQuery.b(R.id.ms_img_icon).a(str3, false);
            }
            if (f > 0.0f) {
                this.bQuery.b(R.id.ms_text_rank).a(String.format(Locale.CHINA, "评分: %.1f", Float.valueOf(f)));
            } else {
                this.bQuery.b(R.id.ms_text_rank).d(8);
            }
            if (i > 0) {
                this.bQuery.b(R.id.ms_text_download_count).a(String.format(Locale.CHINA, "下载量: %s", new DecimalFormat("#,###").format(i)));
            } else {
                this.bQuery.b(R.id.ms_text_download_count).d(8);
            }
            if (i2 > 0) {
                this.bQuery.b(R.id.ms_text_comments).a(String.format(Locale.CHINA, "评论数: %d", Integer.valueOf(i)));
            } else {
                this.bQuery.b(R.id.ms_text_comments).d(8);
            }
        }
        i iVarB = this.bQuery.b(R.id.ms_button_download);
        View.OnClickListener onClickListener = new o() { // from class: com.meishu.sdk.activity.MeishuDetailActivity.5
            public void safeOnClick(View view3) {
                f.b(MeishuDetailActivity.this, MeishuDetailActivity.nativeAd);
            }
        };
        View view3 = ((e) iVarB).d;
        if (view3 != null) {
            view3.setOnClickListener(onClickListener);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    private void loadWeb(String str) {
        this.mAppDetailRL.setVisibility(8);
        this.webView.setVisibility(0);
        this.webView.setScrollBarStyle(0);
        WebSettings settings = this.webView.getSettings();
        settings.setJavaScriptEnabled(true);
        settings.setDomStorageEnabled(true);
        settings.setSavePassword(false);
        settings.setAllowFileAccess(false);
        if (Build.VERSION.SDK_INT < 31) {
            settings.setAppCachePath(getCacheDir().getAbsolutePath());
            settings.setAppCacheEnabled(true);
        }
        this.webView.setWebViewClient(new m(this));
        this.webView.loadUrl(str);
    }

    public static void setMeishuVideoView(NormalMediaView normalMediaView2) {
        try {
            NormalMediaView normalMediaView3 = normalMediaView;
            if (normalMediaView3 != null && normalMediaView3.getMeishuVideoView().b()) {
                normalMediaView.getMeishuVideoView().getMediaPlayer().pause();
            }
            normalMediaView = normalMediaView2;
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void setNativeAdData(c cVar) {
        nativeAd = cVar;
    }

    /* JADX WARN: Multi-variable type inference failed */
    private void tryJumpDeepLink() {
        c cVar = nativeAd;
        AdSlot adSlotA = cVar != null ? cVar.a() : null;
        if (nativeAd == null || adSlotA == null || TextUtils.isEmpty(adSlotA.getDeep_link())) {
            return;
        }
        try {
            Intent uri = Intent.parseUri(adSlotA.getDeep_link(), 0);
            uri.addCategory("android.intent.category.BROWSABLE");
            uri.setComponent(null);
            uri.setSelector(null);
            if (uri.resolveActivity(getPackageManager()) != null) {
                f.a(getApplicationContext(), adSlotA, nativeAd, this.interactionType == 0, this.strongAction, (p0.a) null);
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    private void tryShowVideoCover() {
        try {
            NormalMediaView normalMediaView2 = this.thisNormalMediaView;
            if (normalMediaView2 == null || normalMediaView2.e() || TextUtils.isEmpty(this.videoCover)) {
                return;
            }
            this.bQuery.b(R.id.ms_video_cover).a(this.videoCover, false).d(0);
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void safeOnCreate(Bundle bundle) {
        super.safeOnCreate(bundle);
        setContentView(R.layout.ms_activity_meishu_detail);
        NormalMediaView normalMediaView2 = normalMediaView;
        if (normalMediaView2 == null) {
            gotoFinish();
            return;
        }
        this.thisNormalMediaView = normalMediaView2;
        MeishuVideoTextureView meishuVideoView = normalMediaView2.getMeishuVideoView();
        meishuVideoView.getClass();
        try {
            MediaPlayer mediaPlayer = meishuVideoView.b;
            if (mediaPlayer != null && meishuVideoView.g) {
                mediaPlayer.seekTo(0);
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
        this.thisNormalMediaView.setOnInfoListener(this.onInfoListener);
        int intExtra = getIntent().getIntExtra("EXTRA_INTERACTION_TYPE", -1);
        this.interactionType = intExtra;
        if (intExtra == -1) {
            LogUtil.d(this.TAG, "参数 EXTRA_INTERACTION_TYPE 错误");
            gotoFinish();
            return;
        }
        String[] stringArrayExtra = getIntent().getStringArrayExtra("EXTRA_DURL");
        if (stringArrayExtra == null || stringArrayExtra.length == 0) {
            LogUtil.d(this.TAG, "参数 EXTRA_DURL 错误");
            gotoFinish();
            return;
        }
        String stringExtra = getIntent().getStringExtra("EXTRA_APP_NAME");
        String stringExtra2 = getIntent().getStringExtra("EXTRA_CONTENT");
        String stringExtra3 = getIntent().getStringExtra("EXTRA_ICON_URL");
        float floatExtra = getIntent().getFloatExtra("EXTRA_SCORE", 0.0f);
        int intExtra2 = getIntent().getIntExtra("EXTRA_DOWN_NUM", 0);
        int intExtra3 = getIntent().getIntExtra("EXTRA_COMMENTS", 0);
        getIntent().getIntExtra("EXTRA_VIDEO_WIDTH", 0);
        getIntent().getIntExtra("EXTRA_VIDEO_HEIGHT", 0);
        this.strongAction = getIntent().getBooleanExtra("EXTRA_STRONG_ACTION", true);
        String stringExtra4 = getIntent().getStringExtra("EXTRA_VIDEO_END_COVER");
        this.videoCover = stringExtra4;
        if (TextUtils.isEmpty(stringExtra4)) {
            this.videoCover = getIntent().getStringExtra("EXTRA_VIDEO_COVER");
        }
        ProgressBar progressBar = (ProgressBar) findViewById(R.id.ms_progress_loading);
        this.mProgressBar = progressBar;
        progressBar.setVisibility(8);
        this.mAppDetailRL = (RelativeLayout) findViewById(R.id.ms_layout_app_detail);
        this.webView = (WebView) findViewById(R.id.ms_web_view);
        int i = this.interactionType;
        if (i == 0) {
            loadWeb(stringArrayExtra[0]);
        } else {
            if (i != 1) {
                LogUtil.d(this.TAG, "不支持的 InteractionType");
                gotoFinish();
                return;
            }
            loadAppDetail(stringExtra, stringExtra2, stringExtra3, floatExtra, intExtra2, intExtra3);
        }
        findViewById(R.id.ms_img_close).setOnClickListener(new o() { // from class: com.meishu.sdk.activity.MeishuDetailActivity.1
            public void safeOnClick(View view) {
                MeishuDetailActivity.this.gotoFinish();
            }
        });
        final TextureView textureView = (TextureView) findViewById(R.id.ms_texture_view);
        int i2 = getResources().getDisplayMetrics().widthPixels;
        textureView.setLayoutParams(new RelativeLayout.LayoutParams(i2, (int) (i2 / 1.7777778f)));
        textureView.requestLayout();
        textureView.setSurfaceTextureListener(new com.meishu.sdk.core.safe.m() { // from class: com.meishu.sdk.activity.MeishuDetailActivity.2
            public void safeOnSurfaceTextureAvailable(SurfaceTexture surfaceTexture, int i3, int i4) {
                MeishuDetailActivity.this.textureWidth = i3;
                MeishuDetailActivity.this.textureHeight = i4;
                if (MeishuDetailActivity.this.thisNormalMediaView != null) {
                    Surface surface = new Surface(surfaceTexture);
                    MeishuVideoTextureView meishuVideoView2 = MeishuDetailActivity.this.thisNormalMediaView.getMeishuVideoView();
                    meishuVideoView2.getClass();
                    try {
                        MediaPlayer mediaPlayer2 = meishuVideoView2.b;
                        if (mediaPlayer2 != null) {
                            meishuVideoView2.l = surface;
                            mediaPlayer2.setSurface(surface);
                        }
                    } catch (Throwable th2) {
                        th2.printStackTrace();
                    }
                    textureView.setTransform(MeishuDetailActivity.this.thisNormalMediaView.getMeishuVideoView().a(i3, i4));
                    textureView.postInvalidate();
                }
            }

            public boolean safeOnSurfaceTextureDestroyed(SurfaceTexture surfaceTexture) {
                return true;
            }

            public void safeOnSurfaceTextureSizeChanged(SurfaceTexture surfaceTexture, int i3, int i4) {
            }

            public void safeOnSurfaceTextureUpdated(SurfaceTexture surfaceTexture) {
            }
        });
        this.thisNormalMediaView.getMeishuVideoView().setOnVideoSizeChangedListener(new k() { // from class: com.meishu.sdk.activity.MeishuDetailActivity.3
            public void safeOnVideoSizeChanged(MediaPlayer mediaPlayer2, int i3, int i4) {
                if (MeishuDetailActivity.this.thisNormalMediaView != null) {
                    textureView.setTransform(MeishuDetailActivity.this.thisNormalMediaView.getMeishuVideoView().a(MeishuDetailActivity.this.textureWidth, MeishuDetailActivity.this.textureHeight));
                    textureView.postInvalidate();
                }
            }
        });
        tryJumpDeepLink();
        tryShowVideoCover();
    }

    public void safeOnDestroy() {
        super.safeOnDestroy();
        try {
            nativeAd = null;
            NormalMediaView normalMediaView2 = this.thisNormalMediaView;
            if (normalMediaView2 != null) {
                normalMediaView2.o = false;
                normalMediaView2.setOnInfoListener((MediaPlayer.OnInfoListener) null);
                if (!normalMediaView2.n) {
                    normalMediaView2.d();
                }
                MeishuVideoTextureView meishuVideoView = this.thisNormalMediaView.getMeishuVideoView();
                meishuVideoView.getClass();
                try {
                    MediaPlayer mediaPlayer = meishuVideoView.b;
                    if (mediaPlayer != null) {
                        meishuVideoView.l = null;
                        mediaPlayer.setSurface(meishuVideoView.h);
                    }
                } catch (Throwable th) {
                    th.printStackTrace();
                }
                this.thisNormalMediaView = null;
                normalMediaView = null;
            }
            WebView webView = this.webView;
            if (webView != null) {
                webView.destroy();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void safeOnPause() {
        super.safeOnPause();
        NormalMediaView normalMediaView2 = this.thisNormalMediaView;
        if (normalMediaView2 != null && normalMediaView2.getMeishuVideoView() != null) {
            this.thisNormalMediaView.getMeishuVideoView().c();
            this.thisNormalMediaView.g();
        }
        WebView webView = this.webView;
        if (webView != null) {
            webView.onPause();
        }
    }

    public void safeOnResume() {
        super.safeOnResume();
        NormalMediaView normalMediaView2 = this.thisNormalMediaView;
        if (normalMediaView2 != null && normalMediaView2.getMeishuVideoView() != null) {
            this.thisNormalMediaView.getMeishuVideoView().d();
            this.thisNormalMediaView.j();
        }
        WebView webView = this.webView;
        if (webView != null) {
            webView.onResume();
        }
    }
}

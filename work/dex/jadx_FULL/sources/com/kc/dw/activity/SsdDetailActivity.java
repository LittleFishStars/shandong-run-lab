package com.kc.dw.activity;

import android.app.Activity;
import android.content.Intent;
import android.graphics.SurfaceTexture;
import android.media.MediaPlayer;
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
import com.kc.dw.ad.nativ.NormalMediaView;
import com.kc.dw.ad.view.SsdVideoTextureView;
import com.kc.dw.core.ad.AdSlot;
import com.kc.dw.core.bquery.d;
import com.kc.dw.core.safe.SafeAppCompatActivity;
import com.kc.dw.core.safe.g;
import com.kc.dw.core.safe.i;
import com.kc.dw.core.safe.m;
import com.kc.dw.core.utils.LogUtil;
import com.kc.dw.core.utils.f;
import com.kc.dw.core.webview.k;
import com.kc.dw.platform.ad_adapter.c;
import com.kc.openset.R;
import com.qihoo.SdkProtected.OSETSDK.Keep;
import java.text.DecimalFormat;
import java.util.HashMap;
import java.util.Locale;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
@Keep
public class SsdDetailActivity extends SafeAppCompatActivity {
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
    private d bQuery = new d((Activity) this);
    private boolean strongAction = true;
    private MediaPlayer.OnInfoListener onInfoListener = new g(this) { // from class: com.kc.dw.activity.SsdDetailActivity.4
        public final SsdDetailActivity this$0;

        {
            this.this$0 = this;
        }

        @Override // com.kc.dw.core.safe.g
        public boolean safeOnInfo(MediaPlayer mediaPlayer, int i, int i2) {
            ProgressBar progressBar;
            int i3;
            if (i == 701) {
                progressBar = this.this$0.mProgressBar;
                i3 = 0;
            } else {
                if (i != 702) {
                    return true;
                }
                progressBar = this.this$0.mProgressBar;
                i3 = 8;
            }
            progressBar.setVisibility(i3);
            return true;
        }
    };

    /* JADX INFO: Access modifiers changed from: private */
    public void gotoFinish() {
        this.isFinished = true;
        finish();
    }

    private void loadAppDetail(String str, String str2, String str3, float f, int i, int i2) {
        d dVar;
        int i3;
        if (TextUtils.isEmpty(str)) {
            this.bQuery.b(R.id.ms_layout_app_detail_info).d(8);
            if (TextUtils.isEmpty(str3)) {
                dVar = this.bQuery;
                i3 = R.id.ms_img_icon;
                dVar.b(i3).d(8);
            } else {
                this.bQuery.b(R.id.ms_img_icon).a(str3, false);
            }
        } else {
            View view = this.bQuery.b(R.id.ms_text_title).d;
            if (view instanceof TextView) {
                ((TextView) view).setText(str);
            }
            if (TextUtils.isEmpty(str2)) {
                this.bQuery.b(R.id.ms_text_content).d(8);
            } else {
                View view2 = this.bQuery.b(R.id.ms_text_content).d;
                if (view2 instanceof TextView) {
                    ((TextView) view2).setText(str2);
                }
            }
            if (!TextUtils.isEmpty(str3)) {
                this.bQuery.b(R.id.ms_img_icon).a(str3, false);
            }
            if (f > 0.0f) {
                this.bQuery.b(R.id.ms_text_rank).a((CharSequence) String.format(Locale.CHINA, "评分: %.1f", Float.valueOf(f)));
            } else {
                this.bQuery.b(R.id.ms_text_rank).d(8);
            }
            if (i > 0) {
                this.bQuery.b(R.id.ms_text_download_count).a((CharSequence) String.format(Locale.CHINA, "下载量: %s", new DecimalFormat("#,###").format(i)));
            } else {
                this.bQuery.b(R.id.ms_text_download_count).d(8);
            }
            dVar = this.bQuery;
            if (i2 > 0) {
                dVar.b(R.id.ms_text_comments).a((CharSequence) String.format(Locale.CHINA, "评论数: %d", Integer.valueOf(i)));
            } else {
                i3 = R.id.ms_text_comments;
                dVar.b(i3).d(8);
            }
        }
        d dVarB = this.bQuery.b(R.id.ms_button_download);
        m mVar = new m(this) { // from class: com.kc.dw.activity.SsdDetailActivity.5
            public final SsdDetailActivity this$0;

            {
                this.this$0 = this;
            }

            @Override // com.kc.dw.core.safe.m
            public void safeOnClick(View view3) {
                f.b(this.this$0, SsdDetailActivity.nativeAd);
            }
        };
        View view3 = dVarB.d;
        if (view3 != null) {
            view3.setOnClickListener(mVar);
        }
    }

    private void loadWeb(String str) {
        this.mAppDetailRL.setVisibility(8);
        this.webView.setVisibility(0);
        this.webView.setScrollBarStyle(0);
        WebSettings settings = this.webView.getSettings();
        settings.setJavaScriptEnabled(true);
        settings.setDomStorageEnabled(true);
        settings.setSavePassword(false);
        settings.setAllowFileAccess(false);
        this.webView.setWebViewClient(new k(this));
        this.webView.loadUrl(str);
    }

    public static void setNativeAdData(c cVar) {
        nativeAd = cVar;
    }

    public static void setOwnVideoView(NormalMediaView normalMediaView2) {
        try {
            NormalMediaView normalMediaView3 = normalMediaView;
            if (normalMediaView3 != null && normalMediaView3.getOwnVideoView().b()) {
                normalMediaView.getOwnVideoView().getMediaPlayer().pause();
            }
            normalMediaView = normalMediaView2;
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

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
                f.a(getApplicationContext(), adSlotA, nativeAd, this.interactionType == 0, this.strongAction, null);
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    private void tryShowVideoCover() {
        try {
            NormalMediaView normalMediaView2 = this.thisNormalMediaView;
            if (normalMediaView2 == null || normalMediaView2.d() || TextUtils.isEmpty(this.videoCover)) {
                return;
            }
            this.bQuery.b(R.id.ms_video_cover).a(this.videoCover, false).d(0);
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    @Override // com.kc.dw.core.safe.SafeAppCompatActivity
    public void safeOnCreate(Bundle bundle) {
        super.safeOnCreate(bundle);
        setContentView(R.layout.ssd_activity_detail);
        NormalMediaView normalMediaView2 = normalMediaView;
        if (normalMediaView2 == null) {
            gotoFinish();
            return;
        }
        this.thisNormalMediaView = normalMediaView2;
        SsdVideoTextureView ownVideoView = normalMediaView2.getOwnVideoView();
        ownVideoView.getClass();
        try {
            MediaPlayer mediaPlayer = ownVideoView.b;
            if (mediaPlayer != null && ownVideoView.j) {
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
        findViewById(R.id.ms_img_close).setOnClickListener(new m(this) { // from class: com.kc.dw.activity.SsdDetailActivity.1
            public final SsdDetailActivity this$0;

            {
                this.this$0 = this;
            }

            @Override // com.kc.dw.core.safe.m
            public void safeOnClick(View view) {
                this.this$0.gotoFinish();
            }
        });
        TextureView textureView = (TextureView) findViewById(R.id.ms_texture_view);
        int i2 = getResources().getDisplayMetrics().widthPixels;
        textureView.setLayoutParams(new RelativeLayout.LayoutParams(i2, (int) (i2 / 1.7777778f)));
        textureView.requestLayout();
        textureView.setSurfaceTextureListener(new com.kc.dw.core.safe.k(this, textureView) { // from class: com.kc.dw.activity.SsdDetailActivity.2
            public final SsdDetailActivity this$0;
            public final TextureView val$textureView;

            {
                this.this$0 = this;
                this.val$textureView = textureView;
            }

            @Override // com.kc.dw.core.safe.k
            public void safeOnSurfaceTextureAvailable(SurfaceTexture surfaceTexture, int i3, int i4) {
                this.this$0.textureWidth = i3;
                this.this$0.textureHeight = i4;
                if (this.this$0.thisNormalMediaView != null) {
                    Surface surface = new Surface(surfaceTexture);
                    SsdVideoTextureView ownVideoView2 = this.this$0.thisNormalMediaView.getOwnVideoView();
                    ownVideoView2.getClass();
                    try {
                        MediaPlayer mediaPlayer2 = ownVideoView2.b;
                        if (mediaPlayer2 != null) {
                            ownVideoView2.o = surface;
                            mediaPlayer2.setSurface(surface);
                        }
                    } catch (Throwable th2) {
                        th2.printStackTrace();
                    }
                    this.val$textureView.setTransform(this.this$0.thisNormalMediaView.getOwnVideoView().a(i3, i4));
                    this.val$textureView.postInvalidate();
                }
            }

            @Override // com.kc.dw.core.safe.k
            public boolean safeOnSurfaceTextureDestroyed(SurfaceTexture surfaceTexture) {
                return true;
            }

            @Override // com.kc.dw.core.safe.k
            public void safeOnSurfaceTextureSizeChanged(SurfaceTexture surfaceTexture, int i3, int i4) {
            }

            @Override // com.kc.dw.core.safe.k
            public void safeOnSurfaceTextureUpdated(SurfaceTexture surfaceTexture) {
            }
        });
        this.thisNormalMediaView.getOwnVideoView().setOnVideoSizeChangedListener(new i(this, textureView) { // from class: com.kc.dw.activity.SsdDetailActivity.3
            public final SsdDetailActivity this$0;
            public final TextureView val$textureView;

            {
                this.this$0 = this;
                this.val$textureView = textureView;
            }

            @Override // com.kc.dw.core.safe.i
            public void safeOnVideoSizeChanged(MediaPlayer mediaPlayer2, int i3, int i4) {
                if (this.this$0.thisNormalMediaView != null) {
                    this.val$textureView.setTransform(this.this$0.thisNormalMediaView.getOwnVideoView().a(this.this$0.textureWidth, this.this$0.textureHeight));
                    this.val$textureView.postInvalidate();
                }
            }
        });
        tryJumpDeepLink();
        tryShowVideoCover();
    }

    @Override // com.kc.dw.core.safe.SafeAppCompatActivity
    public void safeOnDestroy() {
        super.safeOnDestroy();
        try {
            nativeAd = null;
            NormalMediaView normalMediaView2 = this.thisNormalMediaView;
            if (normalMediaView2 != null) {
                normalMediaView2.n = false;
                normalMediaView2.setOnInfoListener(null);
                if (!normalMediaView2.m) {
                    normalMediaView2.c();
                }
                SsdVideoTextureView ownVideoView = this.thisNormalMediaView.getOwnVideoView();
                ownVideoView.getClass();
                try {
                    MediaPlayer mediaPlayer = ownVideoView.b;
                    if (mediaPlayer != null) {
                        ownVideoView.o = null;
                        mediaPlayer.setSurface(ownVideoView.k);
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

    @Override // com.kc.dw.core.safe.SafeAppCompatActivity
    public void safeOnPause() {
        super.safeOnPause();
        NormalMediaView normalMediaView2 = this.thisNormalMediaView;
        if (normalMediaView2 != null && normalMediaView2.getOwnVideoView() != null) {
            this.thisNormalMediaView.getOwnVideoView().c();
            this.thisNormalMediaView.f();
        }
        WebView webView = this.webView;
        if (webView != null) {
            webView.onPause();
        }
    }

    @Override // com.kc.dw.core.safe.SafeAppCompatActivity
    public void safeOnResume() {
        super.safeOnResume();
        NormalMediaView normalMediaView2 = this.thisNormalMediaView;
        if (normalMediaView2 != null && normalMediaView2.getOwnVideoView() != null) {
            this.thisNormalMediaView.getOwnVideoView().d();
            this.thisNormalMediaView.i();
        }
        WebView webView = this.webView;
        if (webView != null) {
            webView.onResume();
        }
    }
}

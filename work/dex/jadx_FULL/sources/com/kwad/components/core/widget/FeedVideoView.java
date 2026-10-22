package com.kwad.components.core.widget;

import android.app.Activity;
import android.content.Context;
import android.os.SystemClock;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.view.NestedScrollingChild;
import androidx.core.view.NestedScrollingChildHelper;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import com.kwad.components.core.t.y;
import com.kwad.sdk.R;
import com.kwad.sdk.api.KsAdVideoPlayConfig;
import com.kwad.sdk.api.KsAppDownloadListener;
import com.kwad.sdk.core.imageloader.KSImageLoader;
import com.kwad.sdk.core.response.model.AdResultData;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.core.video.videoview.AdVideoPlayerViewCache;
import com.kwad.sdk.core.view.ScaleAnimSeekBar;
import com.kwad.sdk.utils.al;
import com.kwad.sdk.utils.as;
import com.kwad.sdk.utils.bw;
import com.kwad.sdk.widget.RatioFrameLayout;
import com.kwad.sdk.wrapper.m;
import java.util.Iterator;
import java.util.List;
import org.json.JSONObject;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_06_4659cls.dex */
public class FeedVideoView extends b<AdResultData, AdTemplate> implements NestedScrollingChild {
    private com.kwad.components.core.video.e afG;
    private NestedScrollingChildHelper afp;
    private ViewGroup ahK;
    private RatioFrameLayout avH;
    private TextView avI;
    private TextView avJ;
    private TextView avK;
    private View avL;
    private KSCornerImageView avM;
    private TextView avN;
    private ScaleAnimSeekBar avO;
    private ImageView avP;
    private ImageView avQ;
    private ImageView avR;
    private ViewGroup avS;
    private ViewGroup avT;
    private TextView avU;
    private ViewGroup avV;
    private int avW;
    private boolean avX;
    private boolean avY;
    private long avZ;
    private boolean awa;
    private KsAdVideoPlayConfig awb;
    private a awc;
    private View awd;
    private boolean awe;
    private Runnable awf;
    private y awg;
    private com.kwad.sdk.core.video.videoview.a cB;
    private com.kwad.sdk.core.video.videoview.a.InterfaceC1290a cK;
    private List<Integer> cv;
    private KsAppDownloadListener en;
    private View.OnClickListener gh;
    private TextView hW;
    private ImageView ik;
    private com.kwad.components.core.e.d.d mApkDownloadHelper;

    public interface a {
        void uh();

        void ui();
    }

    public FeedVideoView(@NonNull Context context) {
        super(context);
        this.avW = 100;
        Runnable runnable = new Runnable() { // from class: com.kwad.components.core.widget.FeedVideoView.7
            @Override // java.lang.Runnable
            public final void run() {
                FeedVideoView.this.avS.setVisibility(8);
                FeedVideoView.this.avR.setVisibility(8);
                if (FeedVideoView.this.afG != null) {
                    FeedVideoView.this.afG.be(true);
                }
            }
        };
        this.awf = runnable;
        this.awg = new y(runnable);
    }

    private KsAppDownloadListener getAppDownloadListener() {
        if (this.en == null) {
            this.en = new com.kwad.sdk.core.download.a.a() { // from class: com.kwad.components.core.widget.FeedVideoView.1
                @Override // com.kwad.sdk.api.KsAppDownloadListener
                public final void onDownloadFailed() {
                    FeedVideoView.this.avK.setText(com.kwad.sdk.core.response.helper.a.aK(FeedVideoView.this.mAdInfo));
                }

                @Override // com.kwad.sdk.api.KsAppDownloadListener
                public final void onDownloadFinished() {
                    FeedVideoView.this.avK.setText(com.kwad.sdk.core.response.helper.a.cK(FeedVideoView.this.mAdTemplate));
                }

                @Override // com.kwad.sdk.api.KsAppDownloadListener
                public final void onIdle() {
                    FeedVideoView.this.avK.setText(com.kwad.sdk.core.response.helper.a.aK(FeedVideoView.this.mAdInfo));
                }

                @Override // com.kwad.sdk.api.KsAppDownloadListener
                public final void onInstalled() {
                    FeedVideoView.this.avK.setText(com.kwad.sdk.core.response.helper.a.af(FeedVideoView.this.mAdInfo));
                }

                @Override // com.kwad.sdk.core.download.a.a
                public final void onPaused(int i) {
                    FeedVideoView.this.avK.setText(com.kwad.sdk.core.response.helper.a.eG(i));
                }

                @Override // com.kwad.sdk.api.KsAppDownloadListener
                public final void onProgressUpdate(int i) {
                    FeedVideoView.this.avK.setText(com.kwad.sdk.core.response.helper.a.eF(i));
                }
            };
        }
        return this.en;
    }

    private boolean zR() {
        long jElapsedRealtime = SystemClock.elapsedRealtime();
        long j = jElapsedRealtime - this.avZ;
        if (j > 888) {
            this.avZ = jElapsedRealtime;
        }
        return j > 888;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void zS() {
        a aVar = this.awc;
        if (aVar != null) {
            aVar.uh();
        }
        if ((this.avW == 100) && zR()) {
            this.avT.setVisibility(0);
            this.avU.setText(this.mAdInfo.adBaseInfo.adDescription);
            boolean z = com.kwad.sdk.core.response.helper.a.T(this.mAdInfo) > com.kwad.sdk.core.response.helper.a.S(this.mAdInfo);
            this.avX = as.dC(getContext());
            getContext();
            this.avY = as.VM();
            if (z) {
                as.dF(getContext());
            } else {
                as.dE(getContext());
            }
            ViewGroup viewGroup = (ViewGroup) this.avV.getParent();
            this.ahK = viewGroup;
            if (viewGroup != null) {
                viewGroup.removeView(this.avV);
                View view = new View(this.avV.getContext());
                this.awd = view;
                view.setLayoutParams(new ViewGroup.LayoutParams(this.avV.getWidth(), this.avV.getHeight()));
                viewGroup.addView(this.awd);
            }
            as.i(getContext(), false);
            Activity activityFromContext = m.getActivityFromContext(getContext());
            if (activityFromContext != null) {
                ViewGroup viewGroup2 = (ViewGroup) activityFromContext.getWindow().getDecorView();
                this.avV.setLayoutParams(new ViewGroup.LayoutParams(viewGroup2.getWidth(), viewGroup2.getHeight()));
                if (z && viewGroup2.getWidth() != 0) {
                    this.avH.setRatio(viewGroup2.getHeight() / viewGroup2.getWidth());
                }
                viewGroup2.addView(this.avV, new FrameLayout.LayoutParams(-1, -1));
                setUIWithStateAndMode(101);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void zT() {
        if ((this.avW == 101) & zR()) {
            this.avT.setVisibility(8);
            if (this.avX) {
                as.dC(getContext());
            } else {
                as.dD(getContext());
            }
            if (this.avY) {
                as.dF(getContext());
            } else {
                as.dE(getContext());
            }
            as.i(getContext(), true);
            ViewGroup viewGroup = (ViewGroup) this.avV.getParent();
            if (viewGroup != null) {
                viewGroup.removeView(this.avV);
            }
            this.avV.setLayoutParams(new ViewGroup.LayoutParams(this.ahK.getWidth(), this.ahK.getHeight()));
            this.avH.setRatio(0.5600000023841858d);
            View view = this.awd;
            if (view != null) {
                this.ahK.removeView(view);
                this.awd = null;
            }
            this.ahK.addView(this.avV, new FrameLayout.LayoutParams(-1, -2));
            this.avV.requestLayout();
            setUIWithStateAndMode(100);
        }
        a aVar = this.awc;
        if (aVar != null) {
            aVar.ui();
        }
    }

    @Override // com.kwad.sdk.widget.KSFrameLayout, com.kwad.sdk.widget.k
    public final void H(View view) {
        super.H(view);
    }

    @Override // com.kwad.components.core.widget.b, com.kwad.sdk.core.j.c
    public final void bA() {
        super.bA();
        if (this.cB != null) {
            xj();
            if (getHandler() != null) {
                getHandler().removeCallbacks(this.awg);
                getHandler().postDelayed(this.awg, 5000L);
            }
        }
    }

    @Override // com.kwad.components.core.widget.b
    public final void bC() {
        this.afp = new NestedScrollingChildHelper(this);
        RatioFrameLayout ratioFrameLayout = (RatioFrameLayout) findViewById(R.id.ksad_video_container);
        this.avH = ratioFrameLayout;
        ratioFrameLayout.setRatio(0.5600000023841858d);
        this.ik = (ImageView) findViewById(R.id.ksad_video_first_frame_container);
        this.hW = (TextView) findViewById(R.id.ksad_video_text_below);
        ScaleAnimSeekBar scaleAnimSeekBar = (ScaleAnimSeekBar) findViewById(R.id.ksad_web_video_seek_bar);
        this.avO = scaleAnimSeekBar;
        scaleAnimSeekBar.setMaxProgress(100);
        this.avO.setMinProgress(0);
        this.avK = (TextView) findViewById(R.id.ksad_video_text_below_action_bar);
        this.avL = findViewById(R.id.ksad_video_text_below_action_icon_layout);
        this.avN = (TextView) findViewById(R.id.ksad_video_text_below_action_title);
        this.avM = (KSCornerImageView) findViewById(R.id.ksad_video_text_below_action_icon);
        this.avI = (TextView) findViewById(R.id.ksad_video_control_play_total);
        this.avJ = (TextView) findViewById(R.id.ksad_video_control_play_duration);
        this.avP = (ImageView) findViewById(R.id.ksad_video_control_play_button);
        this.avR = (ImageView) findViewById(R.id.ksad_video_control_play_status);
        this.avQ = (ImageView) findViewById(R.id.ksad_video_control_fullscreen);
        this.avS = (ViewGroup) findViewById(R.id.ksad_video_control_container);
        this.avV = (ViewGroup) findViewById(R.id.ksad_feed_video_container);
        this.avT = (ViewGroup) findViewById(R.id.ksad_video_control_fullscreen_container);
        this.avU = (TextView) findViewById(R.id.ksad_video_control_fullscreen_title);
    }

    @Override // com.kwad.components.core.widget.b, com.kwad.sdk.core.j.c
    public final void bz() {
        super.bz();
        com.kwad.sdk.core.video.videoview.a aVar = this.cB;
        if (aVar == null || aVar.isPlaying()) {
            return;
        }
        uT();
        if (getHandler() != null) {
            getHandler().removeCallbacks(this.awg);
            getHandler().postDelayed(this.awg, 5000L);
        }
    }

    @Override // android.view.View, androidx.core.view.NestedScrollingChild
    public boolean dispatchNestedFling(float f, float f2, boolean z) {
        return this.afp.dispatchNestedFling(f, f2, z);
    }

    @Override // android.view.View, androidx.core.view.NestedScrollingChild
    public boolean dispatchNestedPreFling(float f, float f2) {
        return this.afp.dispatchNestedPreFling(f, f2);
    }

    @Override // android.view.View, androidx.core.view.NestedScrollingChild
    public boolean dispatchNestedPreScroll(int i, int i2, int[] iArr, int[] iArr2) {
        return this.afp.dispatchNestedPreScroll(i, i2, iArr, iArr2);
    }

    @Override // android.view.View, androidx.core.view.NestedScrollingChild
    public boolean dispatchNestedScroll(int i, int i2, int i3, int i4, int[] iArr) {
        return this.afp.dispatchNestedScroll(i, i2, i3, i4, iArr);
    }

    @Override // com.kwad.components.core.widget.b
    public int getLayoutId() {
        return R.layout.ksad_feed_video;
    }

    @Override // android.view.View, androidx.core.view.NestedScrollingChild
    public boolean hasNestedScrollingParent() {
        return this.afp.hasNestedScrollingParent();
    }

    public final boolean isComplete() {
        com.kwad.sdk.core.video.videoview.a aVar = this.cB;
        if (aVar != null) {
            return aVar.isCompleted();
        }
        return true;
    }

    @Override // android.view.View, androidx.core.view.NestedScrollingChild
    public boolean isNestedScrollingEnabled() {
        return this.afp.isNestedScrollingEnabled();
    }

    public final void release() {
        com.kwad.components.core.video.e eVar = this.afG;
        if (eVar != null) {
            eVar.release();
        }
    }

    @Override // android.view.View, androidx.core.view.NestedScrollingChild
    public void setNestedScrollingEnabled(boolean z) {
        this.afp.setNestedScrollingEnabled(z);
    }

    public void setOnEndBtnClickListener(View.OnClickListener onClickListener) {
        this.gh = onClickListener;
    }

    public void setUIWithStateAndMode(int i) {
        if (i == 101) {
            this.avQ.setImageDrawable(getContext().getResources().getDrawable(R.drawable.ksad_video_player_exit_fullscreen_btn));
        } else {
            this.avQ.setImageDrawable(getContext().getResources().getDrawable(R.drawable.ksad_video_player_fullscreen_btn));
        }
        this.avW = i;
    }

    public void setWindowFullScreenListener(a aVar) {
        this.awc = aVar;
    }

    @Override // android.view.View, androidx.core.view.NestedScrollingChild
    public boolean startNestedScroll(int i) {
        return this.afp.startNestedScroll(i);
    }

    @Override // android.view.View, androidx.core.view.NestedScrollingChild
    public void stopNestedScroll() {
        this.afp.stopNestedScroll();
    }

    public final void uP() {
        this.afG.xD();
    }

    public final void uT() {
        this.afG.xG();
        this.afG.setVisibility(0);
        this.afG.setAlpha(1.0f);
        this.avP.setImageDrawable(getContext().getResources().getDrawable(R.drawable.ksad_video_player_pause_btn));
        this.avR.setImageDrawable(getContext().getResources().getDrawable(R.drawable.ksad_video_player_pause_center));
    }

    public final void xj() {
        this.afG.xF();
        this.avR.setVisibility(0);
        this.avR.setImageDrawable(getContext().getResources().getDrawable(R.drawable.ksad_video_play_176));
        this.avP.setImageDrawable(getContext().getResources().getDrawable(R.drawable.ksad_video_player_play_btn));
    }

    public final boolean zU() {
        if (this.avW != 101) {
            return false;
        }
        zT();
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(long j) {
        int iCeil = (int) Math.ceil(j / 1000.0f);
        List<Integer> list = this.cv;
        if (list == null || list.isEmpty()) {
            return;
        }
        Iterator<Integer> it = this.cv.iterator();
        while (it.hasNext()) {
            if (iCeil >= it.next().intValue()) {
                com.kwad.sdk.core.adlog.c.a((AdTemplate) this.mAdTemplate, iCeil, (JSONObject) null);
                it.remove();
                return;
            }
        }
    }

    @Override // com.kwad.components.core.widget.b
    public final void d(@NonNull AdResultData adResultData) {
        super.d(adResultData);
    }

    public static /* synthetic */ boolean a(FeedVideoView feedVideoView, boolean z) {
        feedVideoView.awe = true;
        return true;
    }

    public final void a(@NonNull KsAdVideoPlayConfig ksAdVideoPlayConfig, com.kwad.components.core.e.d.d dVar) {
        this.mApkDownloadHelper = dVar;
        this.awe = false;
        com.kwad.sdk.core.response.model.b bVarBA = com.kwad.sdk.core.response.helper.a.bA(this.mAdInfo);
        this.awb = ksAdVideoPlayConfig;
        String url = bVarBA.getUrl();
        if (!TextUtils.isEmpty(url)) {
            this.ik.setImageDrawable(null);
            KSImageLoader.loadImage(this.ik, url, this.mAdTemplate);
            this.ik.setVisibility(0);
        } else {
            this.ik.setVisibility(8);
        }
        this.cv = com.kwad.sdk.core.response.helper.a.bv(this.mAdInfo);
        String strM = com.kwad.sdk.core.response.helper.a.M(this.mAdInfo);
        if (TextUtils.isEmpty(strM)) {
            return;
        }
        this.cB = AdVideoPlayerViewCache.getInstance().ft(strM);
        if (com.kwad.sdk.core.response.helper.a.aw(this.mAdInfo)) {
            this.hW.setVisibility(8);
            View view = this.avL;
            if (view != null) {
                view.setVisibility(0);
                this.avK.setText(com.kwad.sdk.core.response.helper.a.aK(this.mAdInfo));
                this.avN.setText(com.kwad.sdk.core.response.helper.a.cs(this.mAdInfo));
                KSImageLoader.loadAppIcon(this.avM, com.kwad.sdk.core.response.helper.a.cv(this.mAdInfo), this.mAdTemplate, 4);
                com.kwad.components.core.e.d.d dVar2 = this.mApkDownloadHelper;
                if (dVar2 != null) {
                    dVar2.b(getAppDownloadListener());
                }
                this.avK.setOnClickListener(new View.OnClickListener() { // from class: com.kwad.components.core.widget.FeedVideoView.5
                    @Override // android.view.View.OnClickListener
                    public final void onClick(View view2) {
                        if (FeedVideoView.this.gh != null) {
                            FeedVideoView.this.gh.onClick(view2);
                        }
                    }
                });
            }
        } else {
            View view2 = this.avL;
            if (view2 != null) {
                view2.setVisibility(8);
            }
            this.hW.setVisibility(0);
        }
        com.kwad.sdk.core.video.videoview.a aVar = this.cB;
        if (aVar == null) {
            this.cB = new com.kwad.sdk.core.video.videoview.a(getContext());
            com.kwad.sdk.core.response.helper.a.ae(this.mAdInfo);
            this.cB.a(new com.kwad.sdk.contentalliance.a.a.b.a(this.mAdTemplate).a(this.mAdTemplate.mVideoPlayerStatus).dQ(com.kwad.sdk.core.response.helper.e.eQ(this.mAdTemplate)).dR(com.kwad.sdk.core.response.helper.h.b(com.kwad.sdk.core.response.helper.e.eP(this.mAdTemplate))).b(new com.kwad.sdk.contentalliance.a.a.a(this.mAdTemplate, System.currentTimeMillis())).IG(), null);
            com.kwad.sdk.core.video.videoview.a.InterfaceC1290a interfaceC1290a = new com.kwad.sdk.core.video.videoview.a.InterfaceC1290a() { // from class: com.kwad.components.core.widget.FeedVideoView.6
                @Override // com.kwad.sdk.core.video.videoview.a.InterfaceC1290a
                public final com.kwad.sdk.core.video.a.c a(com.kwad.sdk.contentalliance.a.a.b bVar) {
                    if (!((Boolean) com.kwad.sdk.core.config.e.b(com.kwad.sdk.core.config.c.aQq)).booleanValue() || !((Boolean) com.kwad.sdk.core.config.e.b(com.kwad.sdk.core.config.c.aQr)).booleanValue()) {
                        return null;
                    }
                    com.kwad.components.core.video.g gVar = new com.kwad.components.core.video.g(bVar, FeedVideoView.this.mAdTemplate);
                    if (com.kwad.components.core.video.g.isWaynePlayerReady()) {
                        return gVar;
                    }
                    return null;
                }
            };
            this.cK = interfaceC1290a;
            this.cB.setExternalPlayerListener(interfaceC1290a);
            com.kwad.components.core.video.e eVar = new com.kwad.components.core.video.e(this.mContext, this.mAdTemplate, this.cB, ksAdVideoPlayConfig);
            this.afG = eVar;
            eVar.setDataFlowAutoStart(ksAdVideoPlayConfig.isDataFlowAutoStart());
            this.cB.setController(this.afG);
            this.afG.setAutoRelease(false);
            if (com.kwad.sdk.core.config.e.Jk() == 2) {
                AdVideoPlayerViewCache.getInstance().a(strM, this.cB);
            }
        } else {
            if (aVar.getTag() != null) {
                try {
                    this.cv = (List) this.cB.getTag();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
            com.kwad.components.core.video.e eVar2 = (com.kwad.components.core.video.e) this.cB.getController();
            this.afG = eVar2;
            eVar2.setAutoRelease(false);
            this.afG.getAdTemplate().mAdWebVideoPageShowing = true;
        }
        this.cB.setVideoSoundEnable(ksAdVideoPlayConfig.isVideoSoundEnable());
        if (this.cB.getParent() != null) {
            ((ViewGroup) this.cB.getParent()).removeView(this.cB);
            this.afG.xD();
        }
        if (this.avH.getTag() != null) {
            RatioFrameLayout ratioFrameLayout = this.avH;
            ratioFrameLayout.removeView((View) ratioFrameLayout.getTag());
            this.avH.setTag(null);
        }
        this.avH.addView(this.cB);
        this.avH.setTag(this.cB);
        this.avS.setVisibility(8);
        this.avR.setVisibility(8);
        if (this.mAdInfo.adConversionInfo.h5Type == 1) {
            this.hW.setVisibility(8);
        } else {
            this.hW.setVisibility(0);
            this.hW.setText(this.mAdInfo.adBaseInfo.adDescription);
        }
        a(this.afG, this.cB);
    }

    public FeedVideoView(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        this.avW = 100;
        Runnable runnable = new Runnable() { // from class: com.kwad.components.core.widget.FeedVideoView.7
            @Override // java.lang.Runnable
            public final void run() {
                FeedVideoView.this.avS.setVisibility(8);
                FeedVideoView.this.avR.setVisibility(8);
                if (FeedVideoView.this.afG != null) {
                    FeedVideoView.this.afG.be(true);
                }
            }
        };
        this.awf = runnable;
        this.awg = new y(runnable);
    }

    public FeedVideoView(@NonNull Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.avW = 100;
        Runnable runnable = new Runnable() { // from class: com.kwad.components.core.widget.FeedVideoView.7
            @Override // java.lang.Runnable
            public final void run() {
                FeedVideoView.this.avS.setVisibility(8);
                FeedVideoView.this.avR.setVisibility(8);
                if (FeedVideoView.this.afG != null) {
                    FeedVideoView.this.afG.be(true);
                }
            }
        };
        this.awf = runnable;
        this.awg = new y(runnable);
    }

    private void a(com.kwad.components.core.video.a aVar, final com.kwad.sdk.core.video.videoview.a aVar2) {
        this.avV.setOnClickListener(new View.OnClickListener() { // from class: com.kwad.components.core.widget.FeedVideoView.8
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                if (FeedVideoView.this.avS.getVisibility() != 8) {
                    if (FeedVideoView.this.getHandler() != null) {
                        FeedVideoView.this.getHandler().removeCallbacks(FeedVideoView.this.awf);
                        if (FeedVideoView.this.awa) {
                            return;
                        }
                        FeedVideoView.this.getHandler().postDelayed(FeedVideoView.this.awg, 1000L);
                        return;
                    }
                    return;
                }
                if (!FeedVideoView.this.cB.isCompleted()) {
                    FeedVideoView.this.avS.setVisibility(0);
                    FeedVideoView.this.avR.setVisibility(0);
                    if (FeedVideoView.this.afG != null) {
                        FeedVideoView.this.afG.be(false);
                    }
                    if (FeedVideoView.this.getHandler() != null) {
                        FeedVideoView.this.getHandler().removeCallbacks(FeedVideoView.this.awf);
                        FeedVideoView.this.getHandler().postDelayed(FeedVideoView.this.awg, 5000L);
                        return;
                    }
                    return;
                }
                if (FeedVideoView.this.avW != 101) {
                    if (FeedVideoView.this.gh != null) {
                        FeedVideoView.this.gh.onClick(view);
                        return;
                    }
                    return;
                }
                FeedVideoView.this.avS.setVisibility(0);
                FeedVideoView.this.avR.setVisibility(8);
                if (FeedVideoView.this.afG != null) {
                    FeedVideoView.this.afG.be(false);
                }
                if (FeedVideoView.this.getHandler() != null) {
                    FeedVideoView.this.getHandler().removeCallbacks(FeedVideoView.this.awf);
                    FeedVideoView.this.getHandler().postDelayed(FeedVideoView.this.awg, 5000L);
                }
            }
        });
        aVar.setVideoPlayCallback(new com.kwad.components.core.video.a.c() { // from class: com.kwad.components.core.widget.FeedVideoView.9
            private boolean eV = false;

            @Override // com.kwad.components.core.video.a.c
            public final void as() {
                if (!FeedVideoView.this.awe) {
                    FeedVideoView.a(FeedVideoView.this, true);
                    if (com.kwad.sdk.core.response.helper.a.at(FeedVideoView.this.mAdInfo) != 0) {
                        FeedVideoView.this.cB.setVideoSoundEnable(!com.kwad.sdk.core.response.helper.a.av(FeedVideoView.this.mAdInfo));
                    }
                    if (com.kwad.sdk.core.response.helper.a.at(FeedVideoView.this.mAdInfo) != 0) {
                        FeedVideoView.this.cB.setLooping(com.kwad.sdk.core.response.helper.a.au(FeedVideoView.this.mAdInfo));
                    }
                }
                if (this.eV) {
                    return;
                }
                this.eV = true;
                com.kwad.components.core.p.a.vL().a(FeedVideoView.this.mAdTemplate, System.currentTimeMillis(), 1);
            }

            @Override // com.kwad.components.core.video.a.c
            public final void at() {
                com.kwad.sdk.core.adlog.c.cu(FeedVideoView.this.mAdTemplate);
                FeedVideoView.this.avS.setVisibility(8);
                FeedVideoView.this.avR.setVisibility(8);
                FeedVideoView.this.avO.setProgress(100);
                FeedVideoView.this.avJ.setText(bw.aw(aVar2.getDuration()));
            }

            @Override // com.kwad.components.core.video.a.c
            public final void d(long j) {
                FeedVideoView.this.c(j);
                float duration = (j * 100.0f) / aVar2.getDuration();
                if (!FeedVideoView.this.awa) {
                    FeedVideoView.this.avO.setProgress((int) duration);
                    FeedVideoView.this.avJ.setText(bw.aw(j));
                }
                FeedVideoView.this.avI.setText(bw.aw(aVar2.getDuration()));
            }

            @Override // com.kwad.components.core.video.a.c
            public final void onVideoPlayStart() {
                if (!FeedVideoView.this.awe) {
                    FeedVideoView.a(FeedVideoView.this, true);
                    if (com.kwad.sdk.core.response.helper.a.at(FeedVideoView.this.mAdInfo) != 0) {
                        FeedVideoView.this.cB.setVideoSoundEnable(true ^ com.kwad.sdk.core.response.helper.a.av(FeedVideoView.this.mAdInfo));
                    }
                    if (com.kwad.sdk.core.response.helper.a.at(FeedVideoView.this.mAdInfo) != 0) {
                        FeedVideoView.this.cB.setLooping(com.kwad.sdk.core.response.helper.a.au(FeedVideoView.this.mAdInfo));
                    }
                }
                com.kwad.sdk.core.adlog.c.ct(FeedVideoView.this.mAdTemplate);
                FeedVideoView.this.avI.setText(bw.aw(aVar2.getDuration()));
            }
        });
        this.afG.setAdClickListener(new com.kwad.components.core.video.a.InterfaceC1231a() { // from class: com.kwad.components.core.widget.FeedVideoView.10
            @Override // com.kwad.components.core.video.a.InterfaceC1231a
            public final void a(int i, al.a aVar3) {
                int i2 = MediaPlayer.MEDIA_PLAYER_OPTION_BIT_RATE;
                int i3 = 2;
                boolean z = false;
                if (i != 1) {
                    if (i != 2) {
                        if (i == 3) {
                            i2 = com.kwad.sdk.core.response.helper.a.at(FeedVideoView.this.mAdInfo) != 0 ? 50 : 83;
                            i3 = 1;
                            z = true;
                        } else if (com.kwad.sdk.core.response.helper.a.at(FeedVideoView.this.mAdInfo) == 0) {
                            i2 = 108;
                        }
                    } else if (com.kwad.sdk.core.response.helper.a.at(FeedVideoView.this.mAdInfo) == 0) {
                        i2 = 82;
                    }
                } else if (com.kwad.sdk.core.response.helper.a.at(FeedVideoView.this.mAdInfo) == 0) {
                    i2 = 13;
                }
                com.kwad.components.core.e.d.a.a(new com.kwad.components.core.e.d.a.C1201a(FeedVideoView.this.getContext()).aJ(FeedVideoView.this.mAdTemplate).ax(true).b(FeedVideoView.this.mApkDownloadHelper).aN(i3).as(z).au(true).aM(i2).d(aVar3).a(new com.kwad.components.core.e.d.a.b() { // from class: com.kwad.components.core.widget.FeedVideoView.10.1
                    @Override // com.kwad.components.core.e.d.a.b
                    public final void onAdClicked() {
                        FeedVideoView.this.zN();
                    }
                }));
            }
        });
        this.avO.setOnSeekBarChangeListener(new ScaleAnimSeekBar.a() { // from class: com.kwad.components.core.widget.FeedVideoView.11
            @Override // com.kwad.sdk.core.view.ScaleAnimSeekBar.a
            public final void a(ScaleAnimSeekBar scaleAnimSeekBar, boolean z) {
                if (z) {
                    FeedVideoView.this.avO.bL(true);
                    FeedVideoView.this.getHandler().removeCallbacks(FeedVideoView.this.awg);
                    FeedVideoView.this.awa = true;
                    FeedVideoView.this.avJ.setText(bw.aw((int) ((aVar2.getDuration() * ((long) scaleAnimSeekBar.getProgress())) / ((long) scaleAnimSeekBar.getMaxProgress()))));
                }
            }

            @Override // com.kwad.sdk.core.view.ScaleAnimSeekBar.a
            public final void zV() {
                FeedVideoView.this.avO.bL(true);
                FeedVideoView.this.getHandler().removeCallbacks(FeedVideoView.this.awg);
                FeedVideoView.this.awa = true;
            }

            @Override // com.kwad.sdk.core.view.ScaleAnimSeekBar.a
            public final void a(ScaleAnimSeekBar scaleAnimSeekBar) {
                FeedVideoView.this.avO.bL(false);
                aVar2.seekTo((int) ((aVar2.getDuration() * ((long) scaleAnimSeekBar.getProgress())) / ((long) scaleAnimSeekBar.getMaxProgress())));
                if (FeedVideoView.this.getHandler() != null) {
                    FeedVideoView.this.getHandler().removeCallbacks(FeedVideoView.this.awg);
                    FeedVideoView.this.getHandler().postDelayed(FeedVideoView.this.awg, 5000L);
                }
                FeedVideoView.this.awa = false;
            }
        });
        this.avP.setOnClickListener(new View.OnClickListener() { // from class: com.kwad.components.core.widget.FeedVideoView.12
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                if (aVar2.isPaused() || aVar2.isIdle()) {
                    FeedVideoView.this.afG.xG();
                    FeedVideoView.this.avP.setImageDrawable(FeedVideoView.this.getResources().getDrawable(R.drawable.ksad_video_player_pause_btn));
                    FeedVideoView.this.avR.setImageDrawable(FeedVideoView.this.getResources().getDrawable(R.drawable.ksad_video_player_pause_center));
                } else if (aVar2.isPlaying()) {
                    FeedVideoView.this.afG.xF();
                    FeedVideoView.this.avR.setVisibility(0);
                    FeedVideoView.this.avR.setImageDrawable(FeedVideoView.this.getContext().getResources().getDrawable(R.drawable.ksad_video_play_176));
                    FeedVideoView.this.avP.setImageDrawable(FeedVideoView.this.getContext().getResources().getDrawable(R.drawable.ksad_video_player_play_btn));
                }
                if (FeedVideoView.this.getHandler() != null) {
                    FeedVideoView.this.getHandler().removeCallbacks(FeedVideoView.this.awg);
                    FeedVideoView.this.getHandler().postDelayed(FeedVideoView.this.awg, 5000L);
                }
            }
        });
        this.avR.setOnClickListener(new View.OnClickListener() { // from class: com.kwad.components.core.widget.FeedVideoView.2
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                if (FeedVideoView.this.cB.isPaused() || FeedVideoView.this.cB.isIdle()) {
                    FeedVideoView.this.uT();
                } else if (FeedVideoView.this.cB.isPlaying()) {
                    FeedVideoView.this.xj();
                }
                if (FeedVideoView.this.getHandler() != null) {
                    FeedVideoView.this.getHandler().removeCallbacks(FeedVideoView.this.awg);
                    FeedVideoView.this.getHandler().postDelayed(FeedVideoView.this.awg, 5000L);
                }
            }
        });
        this.avT.setOnClickListener(new View.OnClickListener() { // from class: com.kwad.components.core.widget.FeedVideoView.3
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                FeedVideoView.this.zT();
            }
        });
        this.avQ.setOnClickListener(new View.OnClickListener() { // from class: com.kwad.components.core.widget.FeedVideoView.4
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                if (FeedVideoView.this.avW == 100) {
                    FeedVideoView.this.zS();
                } else if (FeedVideoView.this.avW == 101) {
                    FeedVideoView.this.zT();
                }
            }
        });
    }
}

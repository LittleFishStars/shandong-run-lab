package com.kwad.components.core.video;

import android.annotation.SuppressLint;
import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.UiThread;
import com.kwad.sdk.R;
import com.kwad.sdk.core.imageloader.KSImageLoader;
import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.service.ServiceProvider;
import com.kwad.sdk.utils.al;
import com.kwad.sdk.utils.aq;
import com.kwad.sdk.utils.bw;
import com.kwad.sdk.widget.KSRelativeLayout;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_06_4659cls.dex */
@SuppressLint({"ViewConstructor"})
@Deprecated
public class a extends com.kwad.sdk.core.video.videoview.b implements View.OnClickListener {
    protected ImageView ED;
    protected TextView EE;
    protected boolean amb;
    private boolean amc;
    protected boolean amd;
    private int ame;
    private int amf;
    private boolean amg;
    private KSRelativeLayout amh;
    private RelativeLayout ami;
    private boolean amj;
    private boolean amk;
    private LinearLayout aml;
    private LinearLayout amm;
    private ImageView amn;
    public ViewGroup amo;
    protected TextView amp;
    private c amq;
    private InterfaceC1231a amr;
    protected com.kwad.components.core.video.a.a ams;
    protected View amt;
    protected final com.kwad.sdk.core.download.a.a amu;
    protected AdInfo mAdInfo;

    @NonNull
    protected AdTemplate mAdTemplate;
    protected com.kwad.components.core.e.d.d mApkDownloadHelper;
    protected Context mContext;
    private ProgressBar qA;
    private boolean qP;
    protected ImageView qf;
    protected TextView qg;

    /* JADX INFO: renamed from: com.kwad.components.core.video.a$a, reason: collision with other inner class name */
    public interface InterfaceC1231a {
        void a(int i, al.a aVar);
    }

    public interface b extends c {
        void onVideoPlayError(int i, int i2);
    }

    public interface c {
        void as();

        void at();

        void d(long j);

        void onVideoPlayStart();
    }

    public a(Context context, @NonNull AdTemplate adTemplate, @NonNull com.kwad.sdk.core.video.videoview.c cVar) {
        super(context, cVar);
        this.amc = true;
        this.amd = false;
        this.amk = false;
        this.amu = new com.kwad.sdk.core.download.a.a() { // from class: com.kwad.components.core.video.a.1
            @Override // com.kwad.sdk.api.KsAppDownloadListener
            public final void onDownloadFailed() {
                a aVar = a.this;
                aVar.amp.setText(com.kwad.sdk.core.response.helper.a.aK(aVar.mAdInfo));
            }

            @Override // com.kwad.sdk.api.KsAppDownloadListener
            public final void onDownloadFinished() {
                a aVar = a.this;
                aVar.amp.setText(com.kwad.sdk.core.response.helper.a.cK(aVar.mAdTemplate));
            }

            @Override // com.kwad.sdk.core.download.a.a, com.kwad.sdk.api.KsAppDownloadListener
            public final void onDownloadStarted() {
                a.this.amp.setText(com.kwad.sdk.core.response.helper.a.eF(0));
            }

            @Override // com.kwad.sdk.api.KsAppDownloadListener
            public final void onIdle() {
                a aVar = a.this;
                aVar.bp(com.kwad.sdk.core.response.helper.a.aK(aVar.mAdInfo));
            }

            @Override // com.kwad.sdk.api.KsAppDownloadListener
            public final void onInstalled() {
                a aVar = a.this;
                aVar.amp.setText(com.kwad.sdk.core.response.helper.a.af(aVar.mAdInfo));
            }

            @Override // com.kwad.sdk.core.download.a.a
            public final void onPaused(int i) {
                a.this.amp.setText(com.kwad.sdk.core.response.helper.a.Nx());
            }

            @Override // com.kwad.sdk.api.KsAppDownloadListener
            public final void onProgressUpdate(int i) {
                a.this.amp.setText(com.kwad.sdk.core.response.helper.a.eF(i));
            }
        };
        this.mContext = context;
        this.mAdTemplate = adTemplate;
        this.mAdInfo = com.kwad.sdk.core.response.helper.e.eO(adTemplate);
        init();
    }

    private void bY(int i) {
        try {
            InterfaceC1231a interfaceC1231a = this.amr;
            if (interfaceC1231a != null) {
                interfaceC1231a.a(i, this.amh.getTouchCoords());
            }
        } catch (Throwable th) {
            ServiceProvider.reportSdkCaughtException(th);
        }
    }

    private void fJ() {
        ViewGroup viewGroup = this.amo;
        if (viewGroup != null) {
            viewGroup.setVisibility(8);
        }
    }

    private void init() {
        this.amt = com.kwad.sdk.wrapper.m.inflate(this.mContext, R.layout.ksad_feed_video_palyer_controller, this);
        this.amh = (KSRelativeLayout) findViewById(R.id.ksad_video_root_container);
        this.ami = (RelativeLayout) findViewById(R.id.ksad_data_flow_container);
        this.qg = (TextView) findViewById(R.id.ksad_data_flow_play_tip);
        ImageView imageView = (ImageView) findViewById(R.id.ksad_data_flow_play_btn);
        this.qf = imageView;
        imageView.setOnClickListener(this);
        this.aml = (LinearLayout) findViewById(R.id.ksad_video_network_unavailable);
        this.amm = (LinearLayout) findViewById(R.id.ksad_video_error_container);
        this.qA = (ProgressBar) findViewById(R.id.ksad_video_progress);
        this.amn = (ImageView) findViewById(R.id.ksad_video_thumb_image);
        String url = com.kwad.sdk.core.response.helper.a.bA(this.mAdInfo).getUrl();
        if (TextUtils.isEmpty(url)) {
            this.amn.setVisibility(8);
        } else {
            this.amn.setImageDrawable(null);
            KSImageLoader.loadImage(this.amn, url, this.mAdTemplate);
            this.amn.setVisibility(0);
        }
        this.qg.setText(bw.aw(com.kwad.sdk.core.response.helper.a.N(this.mAdInfo) * 1000));
        this.ams = com.kwad.components.core.video.a.d.a(this.mAdTemplate, this.aZI.getMediaPlayerType(), false);
        xd();
    }

    private void setTopBottomVisible(boolean z) {
        if (this.amk) {
            return;
        }
        this.qA.setVisibility(z ? 0 : 8);
        this.amj = z;
    }

    private void xh() {
        this.ami.setVisibility(8);
    }

    public final void be(boolean z) {
        if (this.amk) {
            return;
        }
        if (!z) {
            this.qA.setVisibility(8);
        } else if (this.amj) {
            this.qA.setVisibility(0);
        }
    }

    public final void bp(String str) {
        TextView textView = (TextView) findViewById(R.id.ksad_app_download);
        if (textView == null) {
            return;
        }
        textView.setText(str);
    }

    public void fI() {
        try {
            if (com.kwad.sdk.core.response.helper.a.aL(this.mAdInfo)) {
                LinearLayout linearLayout = (LinearLayout) findViewById(R.id.ksad_video_complete_app_container);
                this.ED = (ImageView) findViewById(R.id.ksad_video_complete_app_icon);
                this.EE = (TextView) findViewById(R.id.ksad_app_name);
                this.amp = (TextView) findViewById(R.id.ksad_app_download);
                KSImageLoader.loadAppIcon(this.ED, com.kwad.sdk.core.response.helper.e.eT(this.mAdTemplate), this.mAdTemplate, 12);
                this.EE.setText(com.kwad.sdk.core.response.helper.a.cs(this.mAdInfo));
                this.amp.setText(com.kwad.sdk.core.response.helper.a.aK(this.mAdInfo));
                this.amo = linearLayout;
                this.ED.setOnClickListener(this);
                this.EE.setOnClickListener(this);
                this.amp.setOnClickListener(this);
                com.kwad.components.core.e.d.d dVar = new com.kwad.components.core.e.d.d(this.mAdTemplate);
                this.mApkDownloadHelper = dVar;
                dVar.b(this.amu);
            } else {
                LinearLayout linearLayout2 = (LinearLayout) findViewById(R.id.ksad_video_complete_h5_container);
                TextView textView = (TextView) findViewById(R.id.ksad_h5_open);
                this.amp = textView;
                textView.setText(com.kwad.sdk.core.response.helper.a.aK(this.mAdInfo));
                this.amp.setOnClickListener(this);
                this.amo = linearLayout2;
            }
            this.amo.setOnClickListener(this);
            this.amo.setVisibility(0);
        } catch (Exception e) {
            com.kwad.sdk.core.d.c.printStackTraceOnly(e);
        }
    }

    public AdTemplate getAdTemplate() {
        return this.mAdTemplate;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.qf) {
            this.amb = true;
            this.amc = true;
            startPlay();
        } else {
            if (view == this.ED) {
                bY(1);
                return;
            }
            if (view == this.EE) {
                bY(2);
            } else if (view == this.amp) {
                bY(3);
            } else {
                bY(4);
            }
        }
    }

    @Override // com.kwad.sdk.core.video.videoview.b
    public final void onPlayStateChanged(int i) {
        com.kwad.components.core.video.a.a aVar;
        com.kwad.sdk.core.d.c.d("AdVideoPlayerController", "onPlayStateChanged playState=" + i);
        if (i == -1) {
            xr();
            setTopBottomVisible(false);
            this.aml.setVisibility(8);
            this.amm.setVisibility(0);
            c cVar = this.amq;
            if (cVar instanceof f.a) {
                ((f.a) cVar).onVideoPlayError(this.ame, this.amf);
            }
            c cVar2 = this.amq;
            if (cVar2 instanceof b) {
                ((b) cVar2).onVideoPlayError(this.ame, this.amf);
            }
            com.kwad.components.core.p.a.vL().m(this.mAdTemplate, this.ame, this.amf);
            com.kwad.components.core.video.a.a aVar2 = this.ams;
            if (aVar2 != null) {
                aVar2.onMediaPlayError(this.ame, this.amf);
                return;
            }
            return;
        }
        if (i == 9) {
            xr();
            this.mAdTemplate.setmCurPlayTime(-1L);
            setTopBottomVisible(false);
            if (!this.amg) {
                KSImageLoader.loadImage(this.amn, com.kwad.sdk.core.response.helper.a.aa(this.mAdInfo), this.mAdTemplate);
                this.amn.setVisibility(0);
                fI();
            }
            c cVar3 = this.amq;
            if (cVar3 != null) {
                cVar3.at();
            }
            com.kwad.components.core.video.a.a aVar3 = this.ams;
            if (aVar3 != null) {
                aVar3.onMediaPlayCompleted();
                return;
            }
            return;
        }
        if (i == 1) {
            xh();
            this.aml.setVisibility(8);
            this.amm.setVisibility(8);
            this.qA.setVisibility(8);
            fJ();
            return;
        }
        if (i == 2) {
            c cVar4 = this.amq;
            if (cVar4 != null) {
                cVar4.onVideoPlayStart();
            }
            com.kwad.components.core.video.a.a aVar4 = this.ams;
            if (aVar4 != null) {
                aVar4.onMediaPlayStart();
            }
            setTopBottomVisible(true);
            xq();
            return;
        }
        if (i == 4) {
            c cVar5 = this.amq;
            if (cVar5 != null) {
                cVar5.as();
            }
            this.amn.setVisibility(8);
            com.kwad.components.core.video.a.a aVar5 = this.ams;
            if (aVar5 != null) {
                aVar5.qZ();
                this.ams.onMediaPlaying();
                return;
            }
            return;
        }
        if (i == 5) {
            com.kwad.components.core.video.a.a aVar6 = this.ams;
            if (aVar6 != null) {
                aVar6.onMediaPlayPaused();
                return;
            }
            return;
        }
        if (i != 6) {
            if (i == 7 && (aVar = this.ams) != null) {
                aVar.onVideoPlayBufferingPaused();
                return;
            }
            return;
        }
        com.kwad.components.core.video.a.a aVar7 = this.ams;
        if (aVar7 != null) {
            aVar7.onVideoPlayBufferingPlaying();
        }
    }

    @Override // com.kwad.sdk.core.video.videoview.b
    public final void q(int i, int i2) {
        this.amf = i2;
        this.ame = i;
    }

    public void release() {
        this.aZI.release();
        com.kwad.components.core.video.a.a aVar = this.ams;
        if (aVar != null) {
            aVar.onRelease();
        }
    }

    @Override // com.kwad.sdk.core.video.videoview.b
    @UiThread
    public final void reset() {
        xr();
        this.qA.setProgress(0);
        this.qA.setSecondaryProgress(0);
        xh();
        this.aml.setVisibility(8);
        this.amm.setVisibility(8);
        this.qA.setVisibility(8);
        this.amn.setVisibility(8);
        this.ami.setVisibility(8);
        this.mAdTemplate.mVideoPlayerStatus.setVideoPlayerBehavior(1);
        fJ();
    }

    public void setAdClickListener(InterfaceC1231a interfaceC1231a) {
        this.amr = interfaceC1231a;
    }

    public void setCanControlPlay(boolean z) {
        this.amd = z;
    }

    public void setDataAutoStart(boolean z) {
        this.amc = z;
    }

    public void setDataFlowAutoStart(boolean z) {
        this.qP = z;
    }

    public void setHideEnd(boolean z) {
        this.amg = z;
    }

    public void setVideoPlayCallback(c cVar) {
        this.amq = cVar;
    }

    public void startPlay() {
        if (!this.aZI.isIdle()) {
            if (this.aZI.isPaused() || this.aZI.OO()) {
                xi();
                this.aZI.restart();
                return;
            }
            return;
        }
        com.kwad.components.core.video.a.a aVar = this.ams;
        if (aVar != null) {
            aVar.onStart();
        }
        if (!aq.isNetworkConnected(this.mContext)) {
            xe();
            return;
        }
        xf();
        if (this.amd) {
            xi();
            this.aZI.start();
            return;
        }
        if (this.amc && aq.isWifiConnected(this.mContext)) {
            xi();
            this.aZI.start();
        } else if (!this.amc || (!this.qP && !this.amb)) {
            xg();
        } else {
            xi();
            this.aZI.start();
        }
    }

    public void xd() {
    }

    public final void xe() {
        this.aml.setVisibility(0);
    }

    public final void xf() {
        this.aml.setVisibility(8);
    }

    public final void xg() {
        this.ami.setVisibility(0);
        this.amn.setVisibility(0);
        this.mAdTemplate.mVideoPlayerStatus.setVideoPlayerBehavior(2);
    }

    public final void xi() {
        this.aZI.setKsPlayLogParam(com.kwad.sdk.contentalliance.a.a.a.cm(this.mAdTemplate));
    }

    public void xj() {
        this.aZI.pause();
    }

    @Override // com.kwad.sdk.core.video.videoview.b
    public final void xk() {
        long currentPosition = this.aZI.getCurrentPosition();
        long duration = this.aZI.getDuration();
        this.qA.setSecondaryProgress(this.aZI.getBufferPercentage());
        this.mAdTemplate.setmCurPlayTime(currentPosition);
        this.qA.setProgress((int) ((currentPosition * 100.0f) / duration));
        c cVar = this.amq;
        if (cVar != null) {
            cVar.d(currentPosition);
        }
    }

    public final void xl() {
        this.amk = true;
        this.qA.setVisibility(8);
    }
}

package com.kwad.components.core.video;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.GradientDrawable;
import android.os.Message;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import com.kwad.components.core.internal.api.KSAdVideoPlayConfigImpl;
import com.kwad.sdk.R;
import com.kwad.sdk.api.KsAdVideoPlayConfig;
import com.kwad.sdk.core.imageloader.KSImageLoader;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.utils.aq;
import com.kwad.sdk.utils.cb;
import com.kwad.sdk.utils.cc;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_06_4659cls.dex */
@SuppressLint({"ViewConstructor"})
public final class e extends a implements cc.a {
    private View bZ;
    private final cc ca;
    private final AtomicBoolean cb;
    private boolean cc;
    private boolean cd;
    private final KsAdVideoPlayConfig ce;

    public e(Context context, AdTemplate adTemplate, @NonNull com.kwad.sdk.core.video.videoview.c cVar, KsAdVideoPlayConfig ksAdVideoPlayConfig) {
        super(context, adTemplate, cVar);
        this.ca = new cc(this);
        this.cb = new AtomicBoolean(true);
        this.cd = true;
        this.bZ = this;
        this.ce = ksAdVideoPlayConfig;
    }

    private void ae() {
        if (this.cb.getAndSet(false)) {
            com.kwad.sdk.core.d.c.i("FeedVideoPlayerController", "onViewAttached");
            this.ca.sendEmptyMessage(1);
        }
    }

    private boolean ag() {
        KsAdVideoPlayConfig ksAdVideoPlayConfig = this.ce;
        if (ksAdVideoPlayConfig instanceof KSAdVideoPlayConfigImpl) {
            KSAdVideoPlayConfigImpl kSAdVideoPlayConfigImpl = (KSAdVideoPlayConfigImpl) ksAdVideoPlayConfig;
            if (kSAdVideoPlayConfigImpl.getVideoAutoPlayType() == 1) {
                return aq.isNetworkConnected(this.mContext);
            }
            if (kSAdVideoPlayConfigImpl.getVideoAutoPlayType() == 2) {
                return aq.isWifiConnected(this.mContext);
            }
            if (kSAdVideoPlayConfigImpl.getVideoAutoPlayType() == 3) {
                return false;
            }
            if (kSAdVideoPlayConfigImpl.getDataFlowAutoStartValue() != 0) {
                return kSAdVideoPlayConfigImpl.isDataFlowAutoStart() ? aq.isNetworkConnected(this.mContext) : aq.isWifiConnected(this.mContext);
            }
        }
        if (com.kwad.sdk.core.response.helper.a.cj(this.mAdInfo)) {
            return aq.isNetworkConnected(this.mContext);
        }
        if (com.kwad.sdk.core.response.helper.a.ck(this.mAdInfo)) {
            return aq.isWifiConnected(this.mContext);
        }
        return false;
    }

    private boolean xE() {
        AdTemplate adTemplate = this.mAdTemplate;
        if (adTemplate.type != 21) {
            return false;
        }
        int i = adTemplate.defaultType;
        return i == 1 || i == 2;
    }

    @Override // com.kwad.sdk.utils.cc.a
    public final void a(Message message) {
        if (!this.amd && message.what == 1) {
            if (!cb.r(this.bZ, 30)) {
                xj();
            } else if (!this.cc) {
                startPlay();
            }
            this.ca.sendEmptyMessageDelayed(1, 500L);
        }
    }

    public final void af() {
        if (this.cb.getAndSet(true)) {
            return;
        }
        com.kwad.sdk.core.d.c.i("FeedVideoPlayerController", "onViewDetached");
        this.ca.removeCallbacksAndMessages(null);
        if (this.cd) {
            release();
        } else {
            this.aZI.pause();
        }
    }

    @Override // com.kwad.components.core.video.a
    public final void fI() {
        try {
            View viewInflate = com.kwad.sdk.wrapper.m.inflate(this.mContext, R.layout.ksad_feed_video_palyer_controller, null);
            this.amt = viewInflate;
            LinearLayout linearLayout = (LinearLayout) viewInflate.findViewById(R.id.ksad_video_complete_app_container);
            this.ED = (ImageView) this.amt.findViewById(R.id.ksad_video_complete_app_icon);
            this.EE = (TextView) this.amt.findViewById(R.id.ksad_app_name);
            this.amp = (TextView) this.amt.findViewById(R.id.ksad_app_download);
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
            if (xE()) {
                LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.ED.getLayoutParams();
                layoutParams.width = com.kwad.sdk.c.a.a.a(this.mContext, 67.0f);
                layoutParams.height = com.kwad.sdk.c.a.a.a(this.mContext, 67.0f);
                this.ED.setLayoutParams(layoutParams);
                LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) this.EE.getLayoutParams();
                layoutParams2.topMargin = com.kwad.sdk.c.a.a.a(this.mContext, 10.0f);
                this.EE.setLayoutParams(layoutParams2);
                LinearLayout.LayoutParams layoutParams3 = (LinearLayout.LayoutParams) this.amp.getLayoutParams();
                layoutParams3.topMargin = com.kwad.sdk.c.a.a.a(this.mContext, 26.0f);
                layoutParams3.height = com.kwad.sdk.c.a.a.a(this.mContext, 32.0f);
                layoutParams3.width = com.kwad.sdk.c.a.a.a(this.mContext, 72.0f);
                GradientDrawable gradientDrawable = new GradientDrawable();
                gradientDrawable.setColor(Color.parseColor("#FE3666"));
                gradientDrawable.setCornerRadius(com.kwad.sdk.c.a.a.a(this.mContext, 8.0f));
                gradientDrawable.setShape(0);
                this.amp.setTextSize(2, 12.0f);
                this.amp.setLayoutParams(layoutParams3);
                this.amp.setBackground(gradientDrawable);
            }
            this.amo.setOnClickListener(this);
            this.amo.setVisibility(0);
        } catch (Exception e) {
            com.kwad.sdk.core.d.c.printStackTraceOnly(e);
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void onAttachedToWindow() {
        super.onAttachedToWindow();
        com.kwad.sdk.core.d.c.i("FeedVideoPlayerController", "onAttachedToWindow");
        ae();
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        com.kwad.sdk.core.d.c.i("FeedVideoPlayerController", "onDetachedFromWindow");
        af();
    }

    @Override // android.view.View
    public final void onFinishTemporaryDetach() {
        super.onFinishTemporaryDetach();
        com.kwad.sdk.core.d.c.i("FeedVideoPlayerController", "onFinishTemporaryDetach");
        ae();
    }

    @Override // android.view.View
    public final void onStartTemporaryDetach() {
        super.onStartTemporaryDetach();
        com.kwad.sdk.core.d.c.i("FeedVideoPlayerController", "onStartTemporaryDetach");
        af();
    }

    @Override // android.view.View
    public final void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
    }

    @Override // android.view.View
    public final void onWindowVisibilityChanged(int i) {
        super.onWindowVisibilityChanged(i);
    }

    public final void setAutoRelease(boolean z) {
        this.cd = z;
    }

    @Override // com.kwad.components.core.video.a
    public final void startPlay() {
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
        } else if (ag()) {
            xi();
            this.aZI.start();
        } else if (!this.amb) {
            xg();
        } else {
            xi();
            this.aZI.start();
        }
    }

    public final void xD() {
        this.ca.removeCallbacksAndMessages(null);
        if (this.cd) {
            release();
        } else {
            this.aZI.pause();
        }
    }

    public final void xF() {
        this.aZI.pause();
        this.cc = true;
    }

    public final void xG() {
        startPlay();
        this.cc = false;
    }

    public final void xH() {
        this.cc = false;
    }
}

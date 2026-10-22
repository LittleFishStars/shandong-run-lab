package com.kwad.components.ad.c;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.Message;
import android.view.View;
import android.widget.RelativeLayout;
import androidx.annotation.NonNull;
import com.kwad.components.core.internal.api.KSAdVideoPlayConfigImpl;
import com.kwad.sdk.api.KsAdVideoPlayConfig;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.utils.aq;
import com.kwad.sdk.utils.cb;
import com.kwad.sdk.utils.cc;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_06_4659cls.dex */
@SuppressLint({"ViewConstructor"})
public final class e extends com.kwad.components.core.video.a implements cc.a {
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
            com.kwad.sdk.core.d.c.i("BannerVideoPlayerController", "onViewAttached");
            this.ca.sendEmptyMessage(1);
        }
    }

    private void af() {
        if (this.cb.getAndSet(true)) {
            return;
        }
        com.kwad.sdk.core.d.c.i("BannerVideoPlayerController", "onViewDetached");
        this.ca.removeCallbacksAndMessages(null);
        if (this.cd) {
            release();
        } else {
            this.aZI.pause();
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
        if (com.kwad.sdk.core.response.helper.a.cf(this.mAdInfo)) {
            return aq.isNetworkConnected(this.mContext);
        }
        if (com.kwad.sdk.core.response.helper.a.cg(this.mAdInfo)) {
            return aq.isWifiConnected(this.mContext);
        }
        return false;
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

    @Override // android.view.ViewGroup, android.view.View
    public final void onAttachedToWindow() {
        super.onAttachedToWindow();
        com.kwad.sdk.core.d.c.i("BannerVideoPlayerController", "onAttachedToWindow");
        ae();
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        com.kwad.sdk.core.d.c.i("BannerVideoPlayerController", "onDetachedFromWindow");
        af();
    }

    @Override // android.view.View
    public final void onFinishTemporaryDetach() {
        super.onFinishTemporaryDetach();
        com.kwad.sdk.core.d.c.i("BannerVideoPlayerController", "onFinishTemporaryDetach");
        ae();
    }

    @Override // android.view.View
    public final void onStartTemporaryDetach() {
        super.onStartTemporaryDetach();
        com.kwad.sdk.core.d.c.i("BannerVideoPlayerController", "onStartTemporaryDetach");
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
            return;
        }
        if (ag()) {
            xi();
            this.aZI.start();
        } else {
            if (this.amb) {
                xi();
                this.aZI.start();
                return;
            }
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(60, 60);
            layoutParams.addRule(13, -1);
            this.qg.setVisibility(8);
            this.qf.setLayoutParams(layoutParams);
            xg();
        }
    }
}

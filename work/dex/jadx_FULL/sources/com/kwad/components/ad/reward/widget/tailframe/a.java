package com.kwad.components.ad.reward.widget.tailframe;

import android.content.Context;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import com.kwad.components.ad.reward.g;
import com.kwad.components.core.page.widget.TextProgressBar;
import com.kwad.components.core.widget.KsLogoView;
import com.kwad.sdk.R;
import com.kwad.sdk.core.response.helper.SlideConvertHelper;
import com.kwad.sdk.core.response.helper.e;
import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.widget.d;
import com.kwad.sdk.widget.h;
import com.kwad.sdk.wrapper.m;
import org.json.JSONObject;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_06_4659cls.dex */
public abstract class a implements d {
    protected View FW;
    protected ImageView FX;
    private com.kwad.components.ad.widget.tailframe.appbar.a FY;
    private TailFrameBarH5View FZ;
    private b Ga;
    private TextProgressBar Gb;
    private View Gc;
    private int Gd;
    private TextView gX;
    protected AdInfo mAdInfo;
    protected AdTemplate mAdTemplate;
    private com.kwad.components.core.e.d.d mApkDownloadHelper;
    protected KsLogoView mLogoView;
    private JSONObject mReportExtData;
    private g uj;

    public a(int i) {
        this.Gd = i;
    }

    private void bindDownloadListener() {
        this.mApkDownloadHelper = new com.kwad.components.core.e.d.d(this.mAdTemplate, this.mReportExtData, new com.kwad.sdk.core.download.a.a() { // from class: com.kwad.components.ad.reward.widget.tailframe.a.1
            @Override // com.kwad.sdk.api.KsAppDownloadListener
            public final void onDownloadFailed() {
                a.this.FY.E(a.this.mAdInfo);
                a.this.Gb.e(com.kwad.sdk.core.response.helper.a.aK(a.this.mAdInfo), 0);
            }

            @Override // com.kwad.sdk.api.KsAppDownloadListener
            public final void onDownloadFinished() {
                a.this.FY.E(a.this.mAdInfo);
                a.this.Gb.e(com.kwad.sdk.core.response.helper.a.cK(a.this.mAdTemplate), 0);
            }

            @Override // com.kwad.sdk.api.KsAppDownloadListener
            public final void onIdle() {
                a.this.FY.E(a.this.mAdInfo);
                a.this.Gb.e(com.kwad.sdk.core.response.helper.a.aK(a.this.mAdInfo), 0);
            }

            @Override // com.kwad.sdk.api.KsAppDownloadListener
            public final void onInstalled() {
                a.this.FY.E(a.this.mAdInfo);
                a.this.Gb.e(com.kwad.sdk.core.response.helper.a.af(a.this.mAdInfo), 0);
            }

            @Override // com.kwad.sdk.core.download.a.a
            public final void onPaused(int i) {
                a.this.FY.E(a.this.mAdInfo);
                a.this.Gb.e(com.kwad.sdk.core.response.helper.a.eG(i), i);
            }

            @Override // com.kwad.sdk.api.KsAppDownloadListener
            public final void onProgressUpdate(int i) {
                a.this.FY.E(a.this.mAdInfo);
                a.this.Gb.e(com.kwad.sdk.core.response.helper.a.eF(i), i);
            }
        });
    }

    /* JADX WARN: Code restructure failed: missing block: B:16:0x002d, code lost:
    
        r1 = 1;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private void d(View view, final boolean z) {
        int i = 2;
        if (e.S(this.mAdTemplate)) {
            this.uj.a(1, this.FW.getContext(), z ? 1 : 153, view == this.Gc ? 1 : 2);
        } else {
            if (com.kwad.sdk.core.response.helper.a.aL(this.mAdInfo)) {
            }
            com.kwad.components.core.e.d.a.a(new com.kwad.components.core.e.d.a.C1201a(view.getContext()).aJ(this.mAdTemplate).b(this.mApkDownloadHelper).aM(i == 1 ? 1 : 0).aL(1).as(view == this.Gb).aN(i).a(new com.kwad.components.core.e.d.a.b() { // from class: com.kwad.components.ad.reward.widget.tailframe.a.2
                @Override // com.kwad.components.core.e.d.a.b
                public final void onAdClicked() {
                    if (a.this.Ga != null) {
                        a.this.Ga.P(z);
                    }
                }
            }));
        }
    }

    private void lN() {
        this.FW.setOnClickListener(null);
        this.mApkDownloadHelper = null;
    }

    private void lP() {
        if (!com.kwad.sdk.core.response.helper.a.aL(this.mAdInfo) && !e.S(this.mAdTemplate)) {
            this.FZ.n(this.mAdTemplate);
            TextView h5OpenBtn = this.FZ.getH5OpenBtn();
            this.gX = h5OpenBtn;
            h5OpenBtn.setClickable(true);
            this.FZ.setVisibility(0);
            new h(this.gX, this);
            return;
        }
        this.FY.n(this.mAdTemplate);
        this.FY.setVisibility(0);
        this.Gb = this.FY.getTextProgressBar();
        if (!e.S(this.mAdTemplate)) {
            this.Gb.setClickable(true);
            new h(this.Gb, this);
            bindDownloadListener();
        } else {
            View btnInstallContainer = this.FY.getBtnInstallContainer();
            this.Gc = btnInstallContainer;
            btnInstallContainer.setClickable(true);
            new h(this.Gc, this);
        }
    }

    public void B(Context context) {
        View viewA = m.a(context, this.Gd, null, false);
        this.FW = viewA;
        this.FX = (ImageView) viewA.findViewById(R.id.ksad_video_thumb_img);
        this.mLogoView = (KsLogoView) this.FW.findViewById(R.id.ksad_video_tf_logo);
        this.FY = (com.kwad.components.ad.widget.tailframe.appbar.a) this.FW.findViewById(R.id.ksad_video_app_tail_frame);
        this.FZ = (TailFrameBarH5View) this.FW.findViewById(R.id.ksad_video_h5_tail_frame);
    }

    public final void destroy() {
        com.kwad.components.ad.widget.tailframe.appbar.a aVar = this.FY;
        if (aVar != null) {
            aVar.lR();
            this.FY.setVisibility(8);
        }
        TailFrameBarH5View tailFrameBarH5View = this.FZ;
        if (tailFrameBarH5View != null) {
            tailFrameBarH5View.lR();
            this.FZ.setVisibility(8);
        }
        lN();
    }

    public final void g(boolean z, boolean z2) {
        this.FZ.h(z, z2);
    }

    public final View lO() {
        return this.FW;
    }

    public final void lw() {
        com.kwad.components.ad.widget.tailframe.appbar.a aVar = this.FY;
        if (aVar != null) {
            aVar.lR();
        }
        TailFrameBarH5View tailFrameBarH5View = this.FZ;
        if (tailFrameBarH5View != null) {
            tailFrameBarH5View.lR();
        }
    }

    public final void setCallerContext(g gVar) {
        this.uj = gVar;
    }

    public void a(@NonNull AdTemplate adTemplate, JSONObject jSONObject, b bVar) {
        this.mAdTemplate = adTemplate;
        this.mAdInfo = e.eO(adTemplate);
        this.mReportExtData = jSONObject;
        this.Ga = bVar;
        this.mLogoView.bl(this.mAdTemplate);
        lP();
        this.FW.setClickable(true);
        new h(this.FW, this);
    }

    @Override // com.kwad.sdk.widget.d
    public final void a(View view) {
        d(view, true);
    }

    @Override // com.kwad.sdk.widget.d
    public final void a(View view, float f, float f2, float f3, float f4) {
        if (SlideConvertHelper.a(this.mAdTemplate, f, f2, f3, f4)) {
            d(view, false);
        }
    }
}

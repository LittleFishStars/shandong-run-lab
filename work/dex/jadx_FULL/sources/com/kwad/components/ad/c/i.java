package com.kwad.components.ad.c;

import android.content.Context;
import android.os.SystemClock;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.annotation.NonNull;
import com.kwad.components.offline.api.tk.model.StyleTemplate;
import com.kwad.sdk.R;
import com.kwad.sdk.api.KsAdVideoPlayConfig;
import com.kwad.sdk.api.KsBannerAd;
import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.core.response.model.AdMatrixInfo;
import com.kwad.sdk.core.response.model.AdResultData;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.internal.api.SceneImpl;
import com.kwad.sdk.mvp.Presenter;
import java.util.List;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_06_4659cls.dex */
public final class i extends com.kwad.components.core.n.d<b> {
    private KsAdVideoPlayConfig bS;
    private List<AdTemplate> bT;
    private KsBannerAd.BannerAdInteractionListener bV;
    private d bW;
    private Context context;
    private f cp;
    private AdInfo mAdInfo;
    private AdResultData mAdResultData;
    private SceneImpl mAdScene;
    private AdTemplate mAdTemplate;
    private long mStartRenderTime;

    public i(Context context, AdResultData adResultData, KsAdVideoPlayConfig ksAdVideoPlayConfig) {
        super(context);
        this.mStartRenderTime = -1L;
        this.context = context;
        this.mAdResultData = adResultData;
        AdTemplate adTemplateR = com.kwad.sdk.core.response.helper.c.r(adResultData);
        this.mAdTemplate = adTemplateR;
        this.mAdScene = adTemplateR.mAdScene;
        this.bT = this.mAdResultData.getAdTemplateList();
        this.bS = ksAdVideoPlayConfig;
        tp();
    }

    /* JADX INFO: Access modifiers changed from: private */
    @Override // com.kwad.components.core.n.d
    /* JADX INFO: renamed from: am, reason: merged with bridge method [inline-methods] */
    public b an() {
        f fVar = new f(this.oC, (int) (com.kwad.sdk.core.config.e.Kd() * 100.0f));
        this.cp = fVar;
        fVar.Aa();
        b bVar = new b();
        bVar.a(this.mAdResultData);
        bVar.a(this.bV);
        bVar.setBannerUpdateAdResultDataListener(this.bW);
        bVar.mAdScene = this.mAdScene;
        bVar.bQ = (FrameLayout) findViewById(R.id.ksad_banner_base_content);
        bVar.bX = c(this.mAdTemplate);
        bVar.bT = this.bT;
        bVar.mContext = this.context;
        bVar.bS = this.bS;
        bVar.bU = this.mStartRenderTime;
        bVar.a(new b.a() { // from class: com.kwad.components.ad.c.i.1
            @Override // com.kwad.components.ad.c.b.a
            public final void ad() {
                i.this.mPresenter.a(new com.kwad.components.ad.c.d.c(), true);
            }
        });
        return bVar;
    }

    private static StyleTemplate c(AdTemplate adTemplate) {
        AdMatrixInfo.MatrixTemplate matrixTemplateT = com.kwad.sdk.core.response.helper.b.t(adTemplate, com.kwad.sdk.core.response.helper.b.eo(adTemplate));
        StyleTemplate styleTemplate = new StyleTemplate();
        if (matrixTemplateT != null) {
            styleTemplate.templateId = matrixTemplateT.templateId;
            styleTemplate.templateMd5 = matrixTemplateT.templateMd5;
            styleTemplate.templateUrl = matrixTemplateT.templateUrl;
            styleTemplate.templateVersionCode = (int) matrixTemplateT.templateVersionCode;
        }
        return styleTemplate;
    }

    @Override // com.kwad.components.core.n.d
    public final void a(@NonNull ViewGroup viewGroup) {
    }

    @Override // com.kwad.components.core.n.d, com.kwad.sdk.widget.KSFrameLayout
    public final void ae() {
        this.mStartRenderTime = SystemClock.elapsedRealtime();
        super.ae();
    }

    @Override // com.kwad.components.core.n.d
    public final boolean al() {
        return true;
    }

    @Override // com.kwad.components.core.n.d
    public final int getLayoutId() {
        return R.layout.ksad_banner_base;
    }

    @Override // com.kwad.components.core.n.d
    public final void initData() {
        this.mAdInfo = com.kwad.sdk.core.response.helper.e.eO(this.mAdTemplate);
    }

    @Override // com.kwad.components.core.n.d
    @NonNull
    public final Presenter onCreatePresenter() {
        return a(getContext(), this.mAdTemplate);
    }

    public final void setBannerAdListener(KsBannerAd.BannerAdInteractionListener bannerAdInteractionListener) {
        this.bV = bannerAdInteractionListener;
    }

    public final void setBannerUpdateAdResultDataListener(d dVar) {
        this.bW = dVar;
    }

    private static Presenter a(Context context, AdTemplate adTemplate) {
        com.kwad.sdk.core.response.helper.e.eO(adTemplate);
        Presenter presenter = new Presenter();
        if (b.a(adTemplate)) {
            presenter.a(new com.kwad.components.ad.c.e.a(context));
        } else {
            presenter.a(new com.kwad.components.ad.c.d.c());
        }
        return presenter;
    }
}

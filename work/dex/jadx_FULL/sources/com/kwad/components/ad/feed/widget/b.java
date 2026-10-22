package com.kwad.components.ad.feed.widget;

import android.content.Context;
import android.os.SystemClock;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import com.kwad.components.ad.widget.DownloadProgressView;
import com.kwad.components.core.widget.KsLogoView;
import com.kwad.components.model.FeedType;
import com.kwad.sdk.R;
import com.kwad.sdk.core.imageloader.KSImageLoader;
import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.core.response.model.AdResultData;
import com.kwad.sdk.utils.bi;
import com.kwad.sdk.widget.RatioFrameLayout;
import java.util.List;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_06_4659cls.dex */
public abstract class b extends a implements View.OnClickListener, com.kwad.sdk.widget.d {
    protected TextView ev;
    protected ImageView gQ;
    protected TextView gX;
    protected TextView hW;
    protected ImageView hX;
    protected ImageView hY;
    protected RatioFrameLayout hZ;
    protected TextView ia;
    protected TextView ib;
    protected View ic;
    protected DownloadProgressView ie;

    /* JADX INFO: renamed from: if, reason: not valid java name */
    protected boolean f15069if;
    protected int ig;
    protected com.kwad.components.core.e.d.d mApkDownloadHelper;
    protected KsLogoView mLogoView;

    public b(@NonNull Context context) {
        super(context);
        this.f15069if = true;
        this.ig = 8;
    }

    private void cs() {
        this.ib = (TextView) findViewById(R.id.ksad_h5_desc);
        this.gX = (TextView) findViewById(R.id.ksad_h5_open_btn);
        this.ic = findViewById(R.id.ksad_h5_open_cover);
        this.ib.setText(com.kwad.components.ad.feed.f.p(this.mAdTemplate));
        this.gX.setText(com.kwad.sdk.core.response.helper.a.aK(this.mAdInfo));
        this.ic.setOnClickListener(this);
        this.ib.setOnClickListener(this);
        this.gX.setOnClickListener(this);
        new com.kwad.sdk.widget.h(getContext(), this.ic, this);
        new com.kwad.sdk.widget.h(getContext(), this.ib, this);
        new com.kwad.sdk.widget.h(getContext(), this.gX, this);
    }

    private void ct() {
        this.gQ = (ImageView) findViewById(R.id.ksad_app_icon);
        this.ev = (TextView) findViewById(R.id.ksad_app_title);
        TextView textView = (TextView) findViewById(R.id.ksad_app_desc);
        this.ia = textView;
        com.kwad.sdk.c.a.a.a(this, this.gQ, this.ev, textView);
        new com.kwad.sdk.widget.h(getContext(), this.gQ, this);
        new com.kwad.sdk.widget.h(getContext(), this.ev, this);
        new com.kwad.sdk.widget.h(getContext(), this.ia, this);
        if (cu()) {
            this.ev.setText(com.kwad.sdk.core.response.helper.a.cs(this.mAdInfo));
        } else {
            this.ev.setText(com.kwad.sdk.core.response.helper.a.aB(this.mAdInfo));
        }
        this.gQ.setImageResource(R.drawable.ksad_default_app_icon);
        KSImageLoader.loadAppIcon(this.gQ, com.kwad.sdk.core.response.helper.a.cv(this.mAdInfo), this.mAdTemplate, this.ig);
        this.ia.setText(com.kwad.components.ad.feed.f.p(this.mAdTemplate));
        if (this.f15069if) {
            cq();
        }
    }

    private boolean cu() {
        if (FeedType.isNewVerticalType(com.kwad.sdk.core.response.helper.e.fj(this.mAdTemplate))) {
            return com.kwad.sdk.core.response.helper.e.fk(this.mAdTemplate) == FeedType.FeedDefaultType.FEED_VERTICAL_NOVEL_DEFAULT.getDefaultType() || com.kwad.sdk.core.response.helper.e.fk(this.mAdTemplate) == FeedType.FeedDefaultType.FEED_VERTICAL_BISERIAL_DEFAULT.getDefaultType();
        }
        return false;
    }

    private void cv() {
        this.ie.aA(this.mAdTemplate);
        this.ie.setOnClickListener(this);
        com.kwad.components.core.e.d.d dVar = new com.kwad.components.core.e.d.d(this.mAdTemplate, null, this.ie.getAppDownloadListener());
        this.mApkDownloadHelper = dVar;
        dVar.d(this.ie.getAppDownloadListener());
        this.mApkDownloadHelper.setOnShowListener(this);
        this.mApkDownloadHelper.setOnDismissListener(this);
        new com.kwad.sdk.widget.h(getContext(), this.ie, this);
    }

    @Override // com.kwad.components.core.widget.b, com.kwad.sdk.widget.KSFrameLayout
    public final void ae() {
        DownloadProgressView downloadProgressView;
        super.ae();
        com.kwad.components.core.e.d.d dVar = this.mApkDownloadHelper;
        if (dVar == null || (downloadProgressView = this.ie) == null) {
            return;
        }
        dVar.b(downloadProgressView.getAppDownloadListener());
    }

    @Override // com.kwad.components.core.widget.b
    public void bC() {
        this.hW = (TextView) findViewById(R.id.ksad_ad_desc);
        RatioFrameLayout ratioFrameLayout = (RatioFrameLayout) findViewById(R.id.ksad_image_container);
        this.hZ = ratioFrameLayout;
        ratioFrameLayout.setRatio(0.5600000023841858d);
        this.hX = (ImageView) findViewById(R.id.ksad_ad_image);
        this.hY = (ImageView) findViewById(R.id.ksad_ad_dislike);
        this.mLogoView = (KsLogoView) findViewById(R.id.ksad_ad_dislike_logo);
        this.ie = (DownloadProgressView) findViewById(R.id.ksad_app_download_btn);
    }

    public void cr() {
        this.hX.post(new bi() { // from class: com.kwad.components.ad.feed.widget.b.1
            @Override // com.kwad.sdk.utils.bi
            public final void doTask() {
                AdInfo adInfoEO = com.kwad.sdk.core.response.helper.e.eO(b.this.mAdTemplate);
                if (com.kwad.sdk.core.response.helper.a.ba(adInfoEO).height > com.kwad.sdk.core.response.helper.a.ba(adInfoEO).width) {
                    ViewGroup.LayoutParams layoutParams = b.this.hZ.getLayoutParams();
                    layoutParams.width = b.this.getWidth() / 2;
                    b.this.hZ.setRatio(1.7857142686843872d);
                    b.this.hZ.setLayoutParams(layoutParams);
                }
                List<String> listBg = com.kwad.sdk.core.response.helper.a.bg(b.this.mAdInfo);
                if (listBg.size() <= 0) {
                    com.kwad.sdk.core.d.c.e("BaseFeedTextImageView", "getImageUrlList size less than one");
                    return;
                }
                b.this.hP = SystemClock.elapsedRealtime();
                KSImageLoader.loadFeeImage(b.this.hX, listBg.get(0), b.this.mAdTemplate, b.this.hU);
            }
        });
    }

    @Override // com.kwad.components.core.widget.b
    public final void cw() {
        super.cw();
        com.kwad.components.core.e.d.d dVar = this.mApkDownloadHelper;
        if (dVar != null) {
            dVar.c(this.ie.getAppDownloadListener());
        }
    }

    @Override // com.kwad.components.core.widget.b
    public final void d(@NonNull AdResultData adResultData) {
        super.d(adResultData);
        this.hW.setText(com.kwad.components.ad.feed.f.p(this.mAdTemplate));
        this.mLogoView.bl(this.mAdTemplate);
        cr();
        if (com.kwad.sdk.core.response.helper.a.aL(this.mAdInfo)) {
            findViewById(R.id.ksad_ad_download_container).setVisibility(0);
            findViewById(R.id.ksad_ad_h5_container).setVisibility(8);
            ct();
            cv();
        } else {
            findViewById(R.id.ksad_ad_h5_container).setVisibility(0);
            findViewById(R.id.ksad_ad_download_container).setVisibility(8);
            if (cu()) {
                ct();
            }
            cs();
        }
        com.kwad.sdk.c.a.a.a(this, this.hW, this.hX, this.hY);
        new com.kwad.sdk.widget.h(getContext(), this.hW, this);
        new com.kwad.sdk.widget.h(getContext(), this.hX, this);
        new com.kwad.sdk.widget.h(getContext(), this.hY, this);
        setOnClickListener(this);
    }

    public int getDefaultClickArea() {
        return 2;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        int i;
        if (view == this.hW) {
            i = 25;
        } else if (view == this.hX) {
            i = 100;
        } else if (view == this.ie || view == this.gX || view == this.ic) {
            i = 1;
        } else if (view == this.gQ) {
            i = 13;
        } else if (view == this.ev) {
            i = 14;
        } else {
            i = (view == this.ia || view == this.ib) ? 101 : 35;
        }
        b(view, i);
    }

    public void setRadiusDp(int i) {
        this.ig = i;
    }

    public void setmIsShowComplianceView(boolean z) {
        this.f15069if = z;
    }

    private void b(View view, final int i) {
        if (view == this.hY) {
            zO();
        } else {
            cp();
            com.kwad.components.core.e.d.a.a(new com.kwad.components.core.e.d.a.C1201a(getContext()).aJ(this.mAdTemplate).aL(5).aM(i).b(this.mApkDownloadHelper).aN((view == this.ie || view == this.gX || view == this.ic) ? 1 : getDefaultClickArea()).as(view == this.ie).a(new com.kwad.components.core.e.d.a.b() { // from class: com.kwad.components.ad.feed.widget.b.2
                @Override // com.kwad.components.core.e.d.a.b
                public final void onAdClicked() {
                    b.this.bY(i);
                }
            }));
        }
    }

    @Override // com.kwad.sdk.widget.d
    public final void a(View view) {
        onClick(view);
    }

    @Override // com.kwad.sdk.widget.d
    public final void a(View view, float f, float f2, float f3, float f4) {
        if (com.kwad.sdk.core.response.helper.d.eD(this.mAdTemplate)) {
            b(view, 153);
        }
    }
}

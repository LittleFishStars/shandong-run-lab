package com.kwad.components.ad.feed.widget;

import android.content.Context;
import android.os.SystemClock;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import com.kwad.components.ad.widget.DownloadProgressView;
import com.kwad.components.core.widget.KsLogoView;
import com.kwad.sdk.R;
import com.kwad.sdk.core.imageloader.KSImageLoader;
import com.kwad.sdk.core.page.widget.RoundAngleImageView;
import com.kwad.sdk.core.response.model.AdResultData;
import com.kwad.sdk.widget.RatioFrameLayout;
import java.util.List;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_06_4659cls.dex */
public final class o extends a implements View.OnClickListener, com.kwad.sdk.widget.d {
    private TextView hW;
    private ImageView hY;
    private RoundAngleImageView iQ;
    private DownloadProgressView ie;
    private com.kwad.components.core.e.d.d mApkDownloadHelper;
    private KsLogoView mLogoView;

    public o(@NonNull Context context) {
        super(context);
    }

    private void ct() {
        this.mLogoView.bl(this.mAdTemplate);
        this.ie.aA(this.mAdTemplate);
        com.kwad.sdk.c.a.a.a(this, this.hW, this.iQ, this.ie);
        new com.kwad.sdk.widget.h(getContext(), this.hW, this);
        new com.kwad.sdk.widget.h(getContext(), this.iQ, this);
        new com.kwad.sdk.widget.h(getContext(), this.ie, this);
        if (com.kwad.sdk.core.response.helper.a.aL(this.mAdInfo)) {
            com.kwad.components.core.e.d.d dVar = new com.kwad.components.core.e.d.d(this.mAdTemplate, null, this.ie.getAppDownloadListener());
            this.mApkDownloadHelper = dVar;
            dVar.d(this.ie.getAppDownloadListener());
            this.mApkDownloadHelper.setOnShowListener(this);
            this.mApkDownloadHelper.setOnDismissListener(this);
            cq();
        }
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
    public final void bC() {
        this.hW = (TextView) findViewById(R.id.ksad_ad_desc);
        ((RatioFrameLayout) findViewById(R.id.ksad_image_container)).setRatio(0.6600000262260437d);
        RoundAngleImageView roundAngleImageView = (RoundAngleImageView) findViewById(R.id.ksad_ad_image);
        this.iQ = roundAngleImageView;
        roundAngleImageView.setRadius(com.kwad.sdk.c.a.a.a(getContext(), 3.0f));
        this.hY = (ImageView) findViewById(R.id.ksad_ad_dislike);
        this.ie = (DownloadProgressView) findViewById(R.id.ksad_app_download_btn);
        this.mLogoView = (KsLogoView) findViewById(R.id.ksad_feed_logo);
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
        List<String> listBg = com.kwad.sdk.core.response.helper.a.bg(this.mAdInfo);
        if (listBg.size() > 0) {
            this.hP = SystemClock.elapsedRealtime();
            KSImageLoader.loadFeeImage(this.iQ, listBg.get(0), this.mAdTemplate, this.hU);
        } else {
            com.kwad.sdk.core.d.c.e("FeedTextLeftImageView", "getImageUrlList size less than one");
        }
        ct();
        this.hY.setOnClickListener(this);
        setOnClickListener(this);
    }

    @Override // com.kwad.components.core.widget.b
    public final int getLayoutId() {
        return R.layout.ksad_feed_text_left_image;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        int i;
        if (view == this.hW) {
            i = 25;
        } else if (view == this.iQ) {
            i = 100;
        } else {
            i = view == this.ie ? 1 : 35;
        }
        d(view, i);
    }

    @Override // com.kwad.sdk.widget.d
    public final void a(View view) {
        onClick(view);
    }

    @Override // com.kwad.sdk.widget.d
    public final void a(View view, float f, float f2, float f3, float f4) {
        if (com.kwad.sdk.core.response.helper.d.eD(this.mAdTemplate)) {
            d(view, 153);
        }
    }

    private void d(View view, final int i) {
        if (view == this.hY) {
            zO();
        } else {
            com.kwad.components.core.e.d.a.a(new com.kwad.components.core.e.d.a.C1201a(getContext()).aL(5).aM(i).aJ(this.mAdTemplate).b(this.mApkDownloadHelper).aN(view == this.ie ? 1 : 2).as(view == this.ie).a(new com.kwad.components.core.e.d.a.b() { // from class: com.kwad.components.ad.feed.widget.o.1
                @Override // com.kwad.components.core.e.d.a.b
                public final void onAdClicked() {
                    o.this.bY(i);
                }
            }));
        }
    }
}

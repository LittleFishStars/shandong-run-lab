package com.kwad.components.ad.interstitial.h;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.kwad.components.core.page.widget.TextProgressBar;
import com.kwad.components.core.widget.KsLogoView;
import com.kwad.sdk.R;
import com.kwad.sdk.core.imageloader.KSImageLoader;
import com.kwad.sdk.core.response.helper.SlideConvertHelper;
import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.core.response.model.AdProductInfo;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.utils.as;
import com.kwad.sdk.utils.br;
import com.kwad.sdk.widget.KSFrameLayout;
import com.kwad.sdk.widget.h;
import com.kwad.sdk.wrapper.m;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_06_4659cls.dex */
public final class d extends KSFrameLayout implements com.kwad.sdk.widget.d {
    private KSFrameLayout fT;
    private ImageView gQ;
    private TextView ia;
    private ImageView ik;
    private AdTemplate mAdTemplate;
    private KsLogoView mLogoView;
    private KSFrameLayout ns;
    private String oE;

    @Nullable
    private View oF;
    private ImageView oG;
    private TextProgressBar oH;
    private ViewGroup oI;
    private ViewGroup oJ;
    private ImageView oK;
    private View oL;
    private View oM;
    private TextView oN;
    private ImageView oO;
    private TextView oP;
    private TextView oQ;
    private TextView oR;
    private TextProgressBar oS;
    private TextView oT;
    private e oU;
    private final a oV;
    private boolean oW;

    public static class a {
        private boolean oY = false;
        private boolean oZ = false;
        private int pa = 0;
        private boolean pb = true;

        public final void ac(int i) {
            this.pa = i;
        }

        public final int fr() {
            return this.pa;
        }

        public final boolean fs() {
            return this.pb;
        }

        public final void w(boolean z) {
            this.oY = z;
        }

        public final void x(boolean z) {
            this.oZ = z;
        }

        public final void y(boolean z) {
            this.pb = z;
        }
    }

    public d(@NonNull Context context, a aVar) {
        super(context);
        this.oE = "%s秒后进入试玩页";
        this.oW = false;
        this.oV = aVar;
        m.inflate(context, aVar.fs() ? R.layout.ksad_interstitial_native_above : R.layout.ksad_interstitial_native, this);
        t(aVar.oY);
    }

    private void e(View view, int i) {
        com.kwad.sdk.c.a.a.c(view, 0, com.kwad.sdk.c.a.a.a(getContext(), i), 0, 0);
    }

    private void fl() {
        a(this.oO, 40, 40);
        a(this.oS, 130, 30);
        this.oQ.setTextSize(14.0f);
        e(this.oS, 11);
        e(this.oQ, 7);
        e(this.oR, 7);
    }

    private void t(boolean z) {
        setClickable(true);
        this.ns = (KSFrameLayout) findViewById(R.id.ksad_interstitial_native_container);
        this.fT = (KSFrameLayout) findViewById(R.id.ksad_interstitial_native_video_container);
        this.oF = findViewById(R.id.ksad_interstitial_full_bg);
        this.oG = (ImageView) findViewById(R.id.ksad_interstitial_tail_frame);
        this.ik = (ImageView) findViewById(R.id.ksad_video_first_frame_container);
        this.mLogoView = (KsLogoView) findViewById(R.id.ksad_ad_interstitial_logo);
        this.oI = (ViewGroup) findViewById(R.id.ksad_interstitial_playing);
        this.oJ = (ViewGroup) findViewById(R.id.ksad_interstitial_play_end);
        this.oH = (TextProgressBar) findViewById(R.id.ksad_interstitial_download_btn);
        this.oL = findViewById(R.id.ksad_interstitial_close_outer);
        TextProgressBar textProgressBar = this.oH;
        if (textProgressBar != null) {
            textProgressBar.setTextDimen(com.kwad.sdk.c.a.a.a(getContext(), 10.0f));
            this.oH.setTextColor(-1);
        }
        this.oK = (ImageView) findViewById(R.id.ksad_interstitial_mute);
        this.oN = (TextView) findViewById(R.id.ksad_interstitial_count_down);
        this.oO = (ImageView) findViewById(R.id.ksad_interstitial_logo);
        this.oQ = (TextView) findViewById(R.id.ksad_interstitial_name);
        this.oR = (TextView) findViewById(R.id.ksad_interstitial_desc);
        this.oS = (TextProgressBar) findViewById(R.id.ksad_app_download_btn);
        this.oM = findViewById(R.id.ksad_ad_download_container);
        this.gQ = (ImageView) findViewById(R.id.ksad_app_icon);
        this.oP = (TextView) findViewById(R.id.ksad_app_title);
        this.ia = (TextView) findViewById(R.id.ksad_app_desc);
        new h(this, this);
        new h(this.ik, this);
        new h(this.oH, this);
        new h(this.oS, this);
        new h(this.oL, this);
        new h(this.oJ, this);
        new h(this.oN, this);
        new h(this.oM, this);
        new h(this.gQ, this);
        new h(this.oP, this);
        new h(this.ia, this);
        new h(this.oO, this);
        new h(this.oQ, this);
        new h(this.oR, this);
        this.oK.setOnClickListener(new View.OnClickListener() { // from class: com.kwad.components.ad.interstitial.h.d.1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                d.this.oK.setSelected(!d.this.oK.isSelected());
                if (d.this.oU != null) {
                    d.this.oU.p(d.this.oK.isSelected());
                }
            }
        });
        this.oT = (TextView) findViewById(R.id.ksad_interstitial_playable_timer);
        a(this.fT, z);
        if (as.isOrientationPortrait()) {
            return;
        }
        fl();
    }

    public final void C(String str) {
        TextView textView = this.oN;
        if (textView == null) {
            return;
        }
        if (str != null) {
            textView.setText(str);
        }
        if (!this.oV.oZ || this.oW || this.oN.getVisibility() == 0) {
            return;
        }
        this.oN.setVisibility(0);
    }

    public final void L(AdTemplate adTemplate) {
        this.mLogoView.bl(adTemplate);
    }

    public final void c(String str, AdTemplate adTemplate) {
        if (br.isNullString(str)) {
            return;
        }
        this.ik.setImageDrawable(null);
        KSImageLoader.loadImage(this.ik, str, adTemplate);
    }

    public final void d(boolean z, boolean z2) {
        ImageView imageView = this.ik;
        if (imageView != null) {
            imageView.setVisibility(z ? 0 : 8);
            this.ik.setClickable(z2);
        }
    }

    public final void f(String str, int i) {
        TextProgressBar textProgressBar = this.oH;
        if (textProgressBar != null) {
            textProgressBar.e(str, 0);
        }
        TextProgressBar textProgressBar2 = this.oS;
        if (textProgressBar2 != null) {
            textProgressBar2.e(str, 0);
        }
    }

    public final void fm() {
        TextView textView = this.oN;
        if (textView != null) {
            textView.setVisibility(8);
            this.oW = true;
        }
    }

    public final void fn() {
        View view = this.oL;
        if (view != null) {
            view.setVisibility(8);
        }
    }

    public final void fo() {
        u(false);
        this.oJ.setVisibility(0);
        this.oG.setVisibility(0);
    }

    public final void fp() {
        this.oJ.setVisibility(8);
        this.oG.setVisibility(8);
        u(true);
    }

    public final boolean fq() {
        ViewGroup viewGroup = this.oJ;
        return viewGroup != null && viewGroup.getVisibility() == 0;
    }

    @Nullable
    public final View getBlurBgView() {
        return this.oF;
    }

    public final ImageView getTailFrameView() {
        return this.oG;
    }

    public final void setAdTemplate(AdTemplate adTemplate) {
        this.mAdTemplate = adTemplate;
    }

    public final void setViewListener(e eVar) {
        this.oU = eVar;
    }

    public final void u(boolean z) {
        ViewGroup viewGroup = this.oI;
        if (viewGroup != null) {
            viewGroup.setVisibility(z ? 0 : 8);
        }
    }

    public final void v(boolean z) {
        ImageView imageView = this.oK;
        if (imageView != null) {
            imageView.setSelected(z);
        }
    }

    private void a(KSFrameLayout kSFrameLayout, boolean z) {
        kSFrameLayout.setClickable(true);
        new h(kSFrameLayout, this);
        this.fT.setWidthBasedRatio(!z);
    }

    public final void b(boolean z, int i) {
        TextView textView = this.oT;
        if (textView == null) {
            return;
        }
        textView.setVisibility(0);
        if (i >= 0) {
            this.oT.setText(String.format(this.oE, String.valueOf(i)));
        }
    }

    private void d(View view, boolean z) {
        e eVar;
        e eVar2;
        e eVar3 = this.oU;
        if (eVar3 != null) {
            eVar3.q(z);
            this.oU.a(this.ns);
        }
        if (view.equals(this)) {
            e eVar4 = this.oU;
            if (eVar4 != null) {
                eVar4.ep();
                return;
            }
            return;
        }
        if (view.equals(this.oL)) {
            if (!(1 == this.oV.fr()) || (eVar2 = this.oU) == null) {
                return;
            }
            eVar2.eo();
            return;
        }
        if (view.equals(this.oS)) {
            e eVar5 = this.oU;
            if (eVar5 != null) {
                eVar5.eq();
                return;
            }
            return;
        }
        if (view.equals(this.oJ)) {
            e eVar6 = this.oU;
            if (eVar6 != null) {
                eVar6.eB();
                return;
            }
            return;
        }
        if (view.equals(this.oH)) {
            e eVar7 = this.oU;
            if (eVar7 != null) {
                eVar7.er();
                return;
            }
            return;
        }
        if (view.equals(this.oM)) {
            e eVar8 = this.oU;
            if (eVar8 != null) {
                eVar8.eu();
                return;
            }
            return;
        }
        if (view.equals(this.fT)) {
            e eVar9 = this.oU;
            if (eVar9 != null) {
                eVar9.es();
                return;
            }
            return;
        }
        if (view.equals(this.ik)) {
            e eVar10 = this.oU;
            if (eVar10 != null) {
                eVar10.et();
                return;
            }
            return;
        }
        if (view.equals(this.gQ)) {
            e eVar11 = this.oU;
            if (eVar11 != null) {
                eVar11.ev();
                return;
            }
            return;
        }
        if (view.equals(this.oP)) {
            e eVar12 = this.oU;
            if (eVar12 != null) {
                eVar12.ew();
                return;
            }
            return;
        }
        if (view.equals(this.ia)) {
            e eVar13 = this.oU;
            if (eVar13 != null) {
                eVar13.ex();
                return;
            }
            return;
        }
        if (view.equals(this.oO)) {
            e eVar14 = this.oU;
            if (eVar14 != null) {
                eVar14.ey();
                return;
            }
            return;
        }
        if (view.equals(this.oQ)) {
            e eVar15 = this.oU;
            if (eVar15 != null) {
                eVar15.ez();
                return;
            }
            return;
        }
        if (!view.equals(this.oR) || (eVar = this.oU) == null) {
            return;
        }
        eVar.eA();
    }

    private void a(View view, int i, int i2) {
        ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
        layoutParams.width = com.kwad.sdk.c.a.a.a(getContext(), i);
        layoutParams.height = com.kwad.sdk.c.a.a.a(getContext(), i2);
        view.setLayoutParams(layoutParams);
    }

    public final void f(int i, int i2) {
        ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) getLayoutParams();
        marginLayoutParams.width = i;
        marginLayoutParams.height = i2;
        setLayoutParams(marginLayoutParams);
    }

    public final void a(AdTemplate adTemplate, AdInfo adInfo) {
        ImageView imageView = this.oO;
        int i = R.drawable.ksad_default_app_icon;
        imageView.setImageResource(i);
        if (com.kwad.sdk.core.response.helper.a.cp(adInfo) == 2) {
            KSImageLoader.loadCircleIcon(this.oO, com.kwad.sdk.core.response.helper.a.cV(adInfo), getContext().getResources().getDrawable(i));
            this.oQ.setText(com.kwad.sdk.core.response.helper.a.cu(adInfo));
            this.oR.setText(com.kwad.sdk.core.response.helper.a.aA(adInfo));
            if (com.kwad.sdk.core.response.helper.a.cR(adInfo)) {
                this.oS.e(com.kwad.components.ad.e.b.aH(), 0);
                return;
            } else {
                this.oS.e(com.kwad.components.ad.e.b.aK(), 0);
                return;
            }
        }
        if (com.kwad.components.ad.interstitial.b.b.dU() && com.kwad.sdk.core.response.helper.a.cp(adInfo) == 3) {
            AdProductInfo adProductInfoDc = com.kwad.sdk.core.response.helper.a.dc(adInfo);
            KSImageLoader.loadWithRadius(this.oO, adProductInfoDc.icon, adTemplate, 4);
            this.oQ.setText(adProductInfoDc.name);
            this.oR.setVisibility(8);
            this.oS.e(com.kwad.components.ad.e.b.aI(), 0);
            return;
        }
        if (com.kwad.sdk.core.response.helper.a.aL(adInfo)) {
            KSImageLoader.loadWithRadius(this.oO, com.kwad.sdk.core.response.helper.a.cv(adInfo), adTemplate, 4);
            this.oQ.setText(com.kwad.sdk.core.response.helper.a.aB(adInfo));
            this.oR.setText(com.kwad.sdk.core.response.helper.a.aA(adInfo));
            this.oS.e(com.kwad.sdk.core.response.helper.a.aK(adInfo), 0);
            return;
        }
        KSImageLoader.loadWithRadius(this.oO, com.kwad.sdk.core.response.helper.e.eT(adTemplate), adTemplate, 4);
        this.oQ.setText(com.kwad.sdk.core.response.helper.a.cs(adInfo));
        this.oR.setText(com.kwad.sdk.core.response.helper.a.aA(adInfo));
        this.oS.e(com.kwad.sdk.core.response.helper.a.aK(adInfo), 0);
    }

    public final void a(float f, com.kwad.sdk.core.video.videoview.a aVar) {
        this.fT.setRatio(f);
        this.fT.addView(aVar);
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) aVar.getLayoutParams();
        layoutParams.topMargin = 0;
        layoutParams.width = -1;
        layoutParams.height = -1;
        layoutParams.gravity = 17;
        aVar.setLayoutParams(layoutParams);
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

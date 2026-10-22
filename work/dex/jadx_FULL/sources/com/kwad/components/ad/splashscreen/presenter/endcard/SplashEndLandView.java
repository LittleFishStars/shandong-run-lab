package com.kwad.components.ad.splashscreen.presenter.endcard;

import android.content.Context;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import com.kwad.components.ad.splashscreen.widget.CloseCountDownView;
import com.kwad.components.core.widget.KsLogoView;
import com.kwad.sdk.R;
import com.kwad.sdk.core.imageloader.KSImageLoader;
import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.utils.am;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_06_4659cls.dex */
public class SplashEndLandView extends FrameLayout {
    private CloseCountDownView JL;
    private ViewGroup JM;
    private ViewGroup JN;
    private ImageView JO;
    private TextView JP;
    private TextView JQ;
    private ImageView Kb;
    private TextView Kc;
    private TextView Kd;
    private TextView Ke;
    private int Kf;
    private KsLogoView cI;

    public SplashEndLandView(@NonNull Context context) {
        super(context);
        this.Kf = 24;
    }

    private void b(AdTemplate adTemplate, AdInfo adInfo, com.kwad.components.core.e.d.d dVar) {
        if (dVar == null) {
            return;
        }
        String strA = com.kwad.components.ad.splashscreen.d.a(adTemplate, adInfo, dVar.qn(), 0);
        if (TextUtils.isEmpty(strA)) {
            this.Kd.setText(com.kwad.sdk.core.response.helper.a.aK(adInfo));
        } else {
            this.Kd.setText(strA);
        }
    }

    public final void a(AdTemplate adTemplate, com.kwad.components.core.e.d.d dVar, float f) {
        a(new g(getContext(), f));
        AdInfo adInfoEO = com.kwad.sdk.core.response.helper.e.eO(adTemplate);
        this.JO.setImageResource(R.drawable.ksad_default_app_icon);
        com.kwad.sdk.core.d.c.d("SplashEndLandView", "bindView, appIconRadius: " + this.Kf);
        KSImageLoader.loadAppIcon(this.JO, com.kwad.sdk.core.response.helper.a.cv(adInfoEO), adTemplate, this.Kf);
        this.JP.setText(com.kwad.sdk.core.response.helper.a.cs(adInfoEO));
        this.JQ.setText(com.kwad.sdk.core.response.helper.a.aA(adInfoEO));
        this.cI.bl(adTemplate);
        if (com.kwad.sdk.core.response.helper.a.aL(adInfoEO)) {
            b(adTemplate, adInfoEO, dVar);
        } else {
            this.Kd.setText("点击查看");
            this.Ke.setVisibility(0);
            this.Ke.setText("跳转详情页/第三方应用");
        }
        this.JL.a(adInfoEO, f);
    }

    public final void af(String str) {
        TextView textView = this.Kd;
        if (textView == null || str == null) {
            return;
        }
        textView.setText(str);
    }

    public final void bA() {
        CloseCountDownView closeCountDownView = this.JL;
        if (closeCountDownView != null) {
            closeCountDownView.bA();
        }
    }

    public final void bz() {
        CloseCountDownView closeCountDownView = this.JL;
        if (closeCountDownView != null) {
            closeCountDownView.bz();
        }
    }

    public ViewGroup getActionBarView() {
        return this.JN;
    }

    public TextView getAppDesc() {
        return this.JQ;
    }

    public ImageView getAppIcon() {
        return this.JO;
    }

    public TextView getAppName() {
        return this.JP;
    }

    public CloseCountDownView getCloseView() {
        return this.JL;
    }

    public ViewGroup getGiftBoxView() {
        return this.JM;
    }

    public final void no() {
        CloseCountDownView closeCountDownView = this.JL;
        if (closeCountDownView != null) {
            closeCountDownView.cw();
        }
    }

    public final void t(boolean z) {
        View.inflate(getContext(), z ? R.layout.ksad_splash_end_card_area_land : R.layout.ksad_splash_end_card_area, this);
        this.Kb = (ImageView) findViewById(R.id.ksad_ad_endcard_title_view);
        this.JM = (ViewGroup) findViewById(R.id.ksad_splash_end_card_giftbox_view);
        this.JO = (ImageView) findViewById(R.id.ksad_ad_endcard_icon);
        this.JP = (TextView) findViewById(R.id.ksad_ad_endcard_appname);
        this.Kc = (TextView) findViewById(R.id.ksad_ad_endcard_appversion);
        this.JQ = (TextView) findViewById(R.id.ksad_ad_endcard_appdesc);
        this.cI = (KsLogoView) findViewById(R.id.ksad_ad_endcard_logo);
        this.Kd = (TextView) findViewById(R.id.ksad_ad_btn_title);
        this.Ke = (TextView) findViewById(R.id.ksad_ad_btn_sub_title);
        this.JL = (CloseCountDownView) findViewById(R.id.ksad_ad_endcard_close_root);
        this.JN = (ViewGroup) findViewById(R.id.ksad_splash_endcard_actionbar);
    }

    public SplashEndLandView(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        this.Kf = 24;
    }

    public SplashEndLandView(@NonNull Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.Kf = 24;
    }

    @RequiresApi(api = 21)
    public SplashEndLandView(@NonNull Context context, @Nullable AttributeSet attributeSet, int i, int i2) {
        super(context, attributeSet, i, i2);
        this.Kf = 24;
    }

    private void a(g gVar) {
        am.a(this.Kb, gVar.np());
        am.a(this.JM, gVar.nq());
        am.a(this.JO, gVar.nr());
        am.a(this.JN, gVar.nt());
        am.a(this.JP, gVar.nu());
        am.a(this.Kc, gVar.nv());
        am.a(this.JQ, gVar.nw());
        am.a(this.JL, gVar.nx());
        TextView textView = this.JP;
        if (textView != null) {
            textView.setTextSize(0, gVar.ny());
        }
        TextView textView2 = this.Kc;
        if (textView2 != null) {
            textView2.setTextSize(0, gVar.nz());
        }
        TextView textView3 = this.JQ;
        if (textView3 != null) {
            textView3.setTextSize(0, gVar.nA());
        }
        TextView textView4 = this.Kd;
        if (textView4 != null) {
            textView4.setTextSize(0, gVar.nB());
        }
        TextView textView5 = this.Ke;
        if (textView5 != null) {
            textView5.setTextSize(0, gVar.nC());
        }
        this.Kf = gVar.ns();
    }
}

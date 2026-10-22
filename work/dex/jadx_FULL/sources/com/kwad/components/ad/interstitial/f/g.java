package com.kwad.components.ad.interstitial.f;

import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.kwad.components.ad.widget.KsPriceView;
import com.kwad.sdk.R;
import com.kwad.sdk.core.imageloader.KSImageLoader;
import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.core.response.model.AdProductInfo;
import com.kwad.sdk.core.response.model.AdTemplate;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_06_4659cls.dex */
public final class g extends com.kwad.components.ad.interstitial.f.b {
    private static int nT = 4;
    private AdInfo mAdInfo;
    private AdTemplate mAdTemplate;
    private c mN;
    private a nR = new a();
    private b nS = new b();

    public static class a {
        private ImageView nU;
        private TextView nV;
        private TextView nW;
        private KsPriceView nX;
    }

    public static class b {
        private String appIconUrl;
        private String nY;
        private CharSequence nZ;
        private String oa;
        private String ob;
        private String price;

        public final void A(String str) {
            this.oa = str;
        }

        public final void B(String str) {
            this.ob = str;
        }

        public final void a(CharSequence charSequence) {
            this.nZ = charSequence;
        }

        public final String eG() {
            return this.nY;
        }

        public final CharSequence eH() {
            return this.nZ;
        }

        public final String eI() {
            return this.oa;
        }

        public final String eJ() {
            return this.ob;
        }

        public final String getAppIconUrl() {
            return this.appIconUrl;
        }

        public final String getPrice() {
            return this.price;
        }

        public final void setPrice(String str) {
            this.price = str;
        }

        public final void y(String str) {
            this.appIconUrl = str;
        }

        public final void z(String str) {
            this.nY = str;
        }
    }

    private void a(a aVar, b bVar, AdInfo adInfo, AdTemplate adTemplate) {
        ImageView imageView = aVar.nU;
        if (TextUtils.isEmpty(bVar.getAppIconUrl())) {
            imageView.setVisibility(8);
        } else {
            imageView.setVisibility(0);
            if (com.kwad.sdk.core.response.helper.a.co(adInfo) == 2) {
                KSImageLoader.loadCircleIcon(imageView, bVar.getAppIconUrl(), getContext().getResources().getDrawable(R.drawable.ksad_default_app_icon));
            } else {
                imageView.setImageResource(R.drawable.ksad_default_app_icon);
                KSImageLoader.loadWithRadius(imageView, bVar.getAppIconUrl(), adTemplate, nT);
            }
        }
        aVar.nV.setText(bVar.eG());
        if (com.kwad.components.ad.interstitial.b.b.dU() && com.kwad.sdk.core.response.helper.a.co(adInfo) == 3) {
            aVar.nX.d(bVar.getPrice(), bVar.eI(), true);
            aVar.nX.setVisibility(0);
            aVar.nW.setVisibility(8);
            eF();
        } else {
            aVar.nW.setText(bVar.eH());
        }
        this.mN.mO.f(bVar.eJ(), 0);
    }

    private void d(AdInfo adInfo) {
        if (com.kwad.sdk.core.response.helper.a.co(adInfo) == 2) {
            this.nS.y(com.kwad.sdk.core.response.helper.a.cV(adInfo));
            this.nS.z(com.kwad.sdk.core.response.helper.a.cu(adInfo));
            CharSequence charSequenceB = com.kwad.sdk.core.response.helper.a.b(adInfo, com.kwad.components.core.widget.e.aww);
            if (TextUtils.isEmpty(charSequenceB)) {
                charSequenceB = com.kwad.sdk.core.response.helper.a.cU(adInfo);
            }
            this.nS.a(charSequenceB);
            if (com.kwad.sdk.core.response.helper.a.cR(adInfo)) {
                this.nS.B(com.kwad.components.ad.e.b.aH());
                return;
            } else {
                this.nS.B(com.kwad.components.ad.e.b.aK());
                return;
            }
        }
        if (com.kwad.components.ad.interstitial.b.b.dU() && com.kwad.sdk.core.response.helper.a.co(adInfo) == 3) {
            AdProductInfo adProductInfoDc = com.kwad.sdk.core.response.helper.a.dc(adInfo);
            this.nS.y(adProductInfoDc.icon);
            this.nS.z(adProductInfoDc.name);
            this.nS.A(adProductInfoDc.originPrice);
            this.nS.setPrice(adProductInfoDc.price);
            this.nS.B(com.kwad.components.ad.e.b.aI());
            return;
        }
        if (com.kwad.sdk.core.response.helper.a.aL(adInfo)) {
            this.nS.y(com.kwad.sdk.core.response.helper.a.cv(adInfo));
            if (!TextUtils.isEmpty(com.kwad.sdk.core.response.helper.a.aB(adInfo))) {
                this.nS.z(com.kwad.sdk.core.response.helper.a.aB(adInfo));
            } else if (TextUtils.isEmpty(adInfo.advertiserInfo.adAuthorText)) {
                this.nS.z(getContext().getString(R.string.ksad_ad_default_username_normal));
            } else {
                this.nS.z(adInfo.advertiserInfo.adAuthorText);
            }
            this.nS.a(com.kwad.sdk.core.response.helper.a.aA(adInfo));
            this.nS.B(com.kwad.sdk.core.response.helper.a.aK(adInfo));
            return;
        }
        this.nS.y(com.kwad.sdk.core.response.helper.a.cv(adInfo));
        if (!TextUtils.isEmpty(com.kwad.sdk.core.response.helper.a.aD(adInfo))) {
            this.nS.z(com.kwad.sdk.core.response.helper.a.aD(adInfo));
        } else if (TextUtils.isEmpty(adInfo.advertiserInfo.adAuthorText)) {
            this.nS.z(getContext().getString(R.string.ksad_ad_default_username_normal));
        } else {
            this.nS.z(adInfo.advertiserInfo.adAuthorText);
        }
        this.nS.a(com.kwad.sdk.core.response.helper.a.aA(adInfo));
        this.nS.B(com.kwad.sdk.core.response.helper.a.aK(adInfo));
    }

    private void eF() {
        View viewFindViewById = this.mN.mO.findViewById(R.id.ksad_ad_desc_layout);
        View viewFindViewById2 = this.mN.mO.findViewById(R.id.ksad_space);
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) viewFindViewById.getLayoutParams();
        layoutParams.weight = 2.68f;
        viewFindViewById.setLayoutParams(layoutParams);
        viewFindViewById2.setVisibility(8);
    }

    @Override // com.kwad.components.ad.interstitial.f.b, com.kwad.sdk.mvp.Presenter
    public final void ay() {
        super.ay();
        c cVar = (c) SB();
        this.mN = cVar;
        AdTemplate adTemplate = cVar.mAdTemplate;
        this.mAdTemplate = adTemplate;
        this.mAdInfo = com.kwad.sdk.core.response.helper.e.eO(adTemplate);
        this.nR.nU = (ImageView) this.mN.mO.findViewById(R.id.ksad_app_icon);
        this.nR.nV = (TextView) this.mN.mO.findViewById(R.id.ksad_app_title);
        this.nR.nW = (TextView) this.mN.mO.findViewById(R.id.ksad_app_desc);
        this.nR.nX = (KsPriceView) this.mN.mO.findViewById(R.id.ksad_product_price);
        d(this.mAdInfo);
        a(this.nR, this.nS, this.mAdInfo, this.mAdTemplate);
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public final void onCreate() {
        super.onCreate();
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public final void onUnbind() {
        super.onUnbind();
    }
}

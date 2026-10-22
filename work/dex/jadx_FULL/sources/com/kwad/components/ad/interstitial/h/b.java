package com.kwad.components.ad.interstitial.h;

import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.TextView;
import androidx.annotation.Nullable;
import com.kwad.components.core.proxy.j;
import com.kwad.components.core.widget.KSCornerImageView;
import com.kwad.sdk.R;
import com.kwad.sdk.core.imageloader.KSImageLoader;
import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.core.response.model.AdTemplate;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_06_4659cls.dex */
public final class b extends j implements View.OnClickListener {
    private static boolean oz;
    private TextView fM;
    private TextView kO;
    private AdTemplate mAdTemplate;
    private com.kwad.components.ad.interstitial.f.c mN;
    private KSCornerImageView ov;
    private TextView ow;
    private TextView ox;
    private TextView oy;

    public static void f(com.kwad.components.ad.interstitial.f.c cVar) {
        if (oz) {
            return;
        }
        oz = true;
        b bVar = new b();
        Bundle bundle = new Bundle();
        bundle.putString("KEY_TEMPLATE", cVar.mAdTemplate.toJson().toString());
        bVar.setArguments(bundle);
        bVar.g(cVar);
        bVar.show(cVar.lx.getOwnerActivity().getFragmentManager(), "interstitialCloseDialog");
    }

    private void g(com.kwad.components.ad.interstitial.f.c cVar) {
        this.mN = cVar;
    }

    private void i(View view) {
        this.ov = (KSCornerImageView) view.findViewById(R.id.ksad_interstitial_intercept_app_icon);
        this.kO = (TextView) view.findViewById(R.id.ksad_interstitial_intercept_app_title);
        this.fM = (TextView) view.findViewById(R.id.ksad_interstitial_intercept_dialog_desc);
        this.ow = (TextView) view.findViewById(R.id.ksad_interstitial_intercept_dialog_detail);
        this.ox = (TextView) view.findViewById(R.id.ksad_interstitial_intercept_dialog_btn_continue);
        TextView textView = (TextView) view.findViewById(R.id.ksad_interstitial_intercept_dialog_btn_deny);
        this.oy = textView;
        com.kwad.sdk.c.a.a.a(this, this.ov, this.kO, this.fM, this.ow, this.ox, textView);
    }

    private void initData() {
        AdInfo adInfoEO = com.kwad.sdk.core.response.helper.e.eO(this.mAdTemplate);
        KSImageLoader.loadAppIcon(this.ov, com.kwad.sdk.core.response.helper.a.cv(adInfoEO), this.mAdTemplate, 12);
        this.kO.setText(com.kwad.sdk.core.response.helper.a.cs(adInfoEO));
        this.fM.setText(com.kwad.sdk.core.response.helper.a.aA(adInfoEO));
        if (com.kwad.sdk.core.response.helper.a.cN(this.mAdTemplate)) {
            this.ow.setText(com.kwad.sdk.core.response.helper.a.aK(adInfoEO));
        }
    }

    @Override // com.kwad.components.core.proxy.j
    public final View a(LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup) {
        String string = getArguments().getString("KEY_TEMPLATE");
        try {
            AdTemplate adTemplate = new AdTemplate();
            this.mAdTemplate = adTemplate;
            adTemplate.parseJson(new JSONObject(string));
        } catch (JSONException e) {
            e.printStackTrace();
        }
        View viewInflate = layoutInflater.inflate(R.layout.ksad_interstitial_exit_intercept_dialog, viewGroup);
        i(viewInflate);
        initData();
        return viewInflate;
    }

    @Override // android.app.DialogFragment, android.app.Fragment
    public final void onActivityCreated(Bundle bundle) {
        super.onActivityCreated(bundle);
        Window window = getDialog().getWindow();
        if (window == null) {
            return;
        }
        getDialog().setCanceledOnTouchOutside(false);
        window.setLayout(-1, -1);
        getDialog().getWindow().setBackgroundDrawable(new ColorDrawable(0));
        setCancelable(false);
        com.kwad.components.ad.interstitial.f.c cVar = this.mN;
        if (cVar != null) {
            com.kwad.sdk.core.adlog.c.d(cVar.mAdTemplate, new JSONObject(), new com.kwad.sdk.core.adlog.c.b().ee(149).ej(9));
        }
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        if (this.mN != null) {
            if (view.equals(this.ov)) {
                com.kwad.components.ad.interstitial.f.c cVar = this.mN;
                cVar.a(cVar.lx.getContext(), 127, 2, 9);
            } else if (view.equals(this.kO)) {
                com.kwad.components.ad.interstitial.f.c cVar2 = this.mN;
                cVar2.a(cVar2.lx.getContext(), 128, 2, 9);
            } else if (view.equals(this.fM)) {
                com.kwad.components.ad.interstitial.f.c cVar3 = this.mN;
                cVar3.a(cVar3.lx.getContext(), 129, 2, 9);
            } else if (view.equals(this.ow)) {
                com.kwad.components.ad.interstitial.f.c cVar4 = this.mN;
                cVar4.a(cVar4.lx.getContext(), 131, 2, 9);
            } else if (view.equals(this.ox)) {
                com.kwad.sdk.core.adlog.c.c(this.mN.mAdTemplate, (JSONObject) null, new com.kwad.sdk.core.adlog.c.b().ej(9));
            } else if (view.equals(this.oy)) {
                com.kwad.components.ad.interstitial.f.c cVar5 = this.mN;
                cVar5.a(false, -1, cVar5.cB);
                this.mN.lx.dismiss();
                com.kwad.sdk.core.adlog.c.e(this.mN.mAdTemplate, null, new com.kwad.sdk.core.adlog.c.b().ee(151).ej(9));
            }
        }
        dismiss();
        oz = false;
    }
}

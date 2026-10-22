package com.kwad.components.core.page.d.a;

import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import com.kwad.sdk.R;
import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.core.webview.KsAdWebView;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_06_4659cls.dex */
public final class e extends a {
    private LinearLayout adg;
    private TextView adh;
    private ImageView adi;

    private void us() {
        this.adg = (LinearLayout) findViewById(R.id.ksad_web_tip_bar);
        if (!TextUtils.isEmpty(this.adZ.mPageTitle)) {
            this.adg.setVisibility(8);
            return;
        }
        this.adh = (TextView) findViewById(R.id.ksad_web_tip_bar_textview);
        ImageView imageView = (ImageView) findViewById(R.id.ksad_web_tip_close_btn);
        this.adi = imageView;
        imageView.setOnClickListener(new View.OnClickListener() { // from class: com.kwad.components.core.page.d.a.e.1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                e.this.adg.setVisibility(8);
            }
        });
        AdInfo adInfoEO = com.kwad.sdk.core.response.helper.e.eO(this.adZ.mAdTemplate);
        boolean zBF = com.kwad.sdk.core.response.helper.a.bF(adInfoEO);
        String strBB = com.kwad.sdk.core.response.helper.a.bB(adInfoEO);
        if (zBF) {
            this.adg.setVisibility(0);
            this.adh.setText(strBB);
            this.adh.setSelected(true);
        } else {
            this.adg.setVisibility(8);
        }
        this.adZ.a(ut());
    }

    @NonNull
    private KsAdWebView.c ut() {
        return new KsAdWebView.c() { // from class: com.kwad.components.core.page.d.a.e.2
            @Override // com.kwad.sdk.core.webview.KsAdWebView.c
            public final void uu() {
                if (e.this.adZ.tV() && e.this.adg.getVisibility() == 0) {
                    e.this.adg.setVisibility(8);
                }
            }
        };
    }

    @Override // com.kwad.components.core.page.d.a.a, com.kwad.sdk.mvp.Presenter
    public final void ay() {
        super.ay();
        us();
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public final void onCreate() {
        super.onCreate();
    }
}

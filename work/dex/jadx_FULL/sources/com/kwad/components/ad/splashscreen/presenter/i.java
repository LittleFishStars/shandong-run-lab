package com.kwad.components.ad.splashscreen.presenter;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.Vibrator;
import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.utils.by;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_06_4659cls.dex */
public abstract class i extends e implements com.kwad.sdk.core.j.c {
    private static long oe = 400;
    private com.kwad.components.ad.splashscreen.e.a HV;
    private Vibrator hw;

    private void mO() {
        com.kwad.components.ad.splashscreen.h hVar = this.HC;
        if (hVar != null) {
            com.kwad.components.ad.splashscreen.e.a aVar = this.HV;
            if (aVar == null) {
                this.HV = new com.kwad.components.ad.splashscreen.e.a(getContext(), this.HC.mAdTemplate) { // from class: com.kwad.components.ad.splashscreen.presenter.i.1
                    {
                        super(adTemplate);
                    }

                    @Override // com.kwad.components.ad.splashscreen.e.a
                    @SuppressLint({"SetTextI18n"})
                    public final void k(int i, String str) {
                        i.this.j(i, str);
                    }
                };
            } else {
                aVar.setAdTemplate(hVar.mAdTemplate);
            }
            com.kwad.components.core.e.d.d dVar = this.HC.mApkDownloadHelper;
            if (dVar != null) {
                dVar.b(this.HV);
            }
        }
    }

    @Override // com.kwad.components.ad.splashscreen.presenter.e, com.kwad.sdk.mvp.Presenter
    public void ay() {
        super.ay();
        com.kwad.components.ad.splashscreen.h hVar = this.HC;
        if (hVar == null) {
            return;
        }
        AdInfo adInfoEO = com.kwad.sdk.core.response.helper.e.eO(hVar.mAdTemplate);
        mL();
        mJ();
        if (com.kwad.sdk.core.response.helper.a.aL(adInfoEO)) {
            mO();
        }
        mK();
        fY();
        this.HC.GP.a(this);
    }

    @Override // com.kwad.sdk.core.j.c
    public final void bA() {
        mN();
    }

    @Override // com.kwad.sdk.core.j.c
    public final void bz() {
        if (this.HC.GS) {
            return;
        }
        mM();
    }

    public abstract void fY();

    public abstract void initView();

    public abstract void j(int i, String str);

    public abstract void mJ();

    public abstract void mK();

    public abstract void mL();

    public abstract void mM();

    public abstract void mN();

    public final void mP() {
        Context context = getContext();
        if (context != null) {
            this.hw = (Vibrator) context.getSystemService("vibrator");
        }
        by.a(getContext(), this.hw);
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public void onCreate() {
        super.onCreate();
        initView();
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public void onUnbind() {
        com.kwad.sdk.core.j.a aVar;
        super.onUnbind();
        com.kwad.components.ad.splashscreen.h hVar = this.HC;
        if (hVar != null && (aVar = hVar.GP) != null) {
            aVar.b(this);
        }
        mN();
        by.b(getContext(), this.hw);
    }
}

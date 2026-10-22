package com.kwad.components.ad.splashscreen.presenter.endcard;

import android.graphics.BitmapFactory;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewStub;
import android.widget.ImageView;
import com.kwad.sdk.R;
import com.kwad.sdk.core.imageloader.KSImageLoader;
import com.kwad.sdk.core.imageloader.core.DisplayImageOptionsCompat;
import com.kwad.sdk.core.imageloader.core.decode.DecodedResult;
import com.kwad.sdk.core.imageloader.core.listener.SimpleImageLoadingListener;
import com.kwad.sdk.core.imageloader.utils.BlurUtils;
import com.kwad.sdk.core.response.model.AdTemplate;
import java.io.InputStream;
import org.json.JSONObject;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_06_4659cls.dex */
public final class d extends com.kwad.components.ad.splashscreen.presenter.e implements com.kwad.sdk.core.j.c {
    private ViewGroup JU;
    private ImageView JV;
    private SplashEndLandView JW;

    /* JADX INFO: Access modifiers changed from: private */
    public void af(String str) {
        SplashEndLandView splashEndLandView = this.JW;
        if (splashEndLandView == null || str == null) {
            return;
        }
        splashEndLandView.af(str);
    }

    private void initView() {
        ViewStub viewStub = (ViewStub) findViewById(R.id.ksad_splash_endcard_view_stub);
        if (viewStub != null) {
            this.JU = (ViewGroup) viewStub.inflate();
        } else {
            this.JU = (ViewGroup) findViewById(R.id.ksad_splash_end_card_native_root);
        }
        boolean zDv = com.kwad.sdk.core.response.helper.a.dv(com.kwad.sdk.core.response.helper.e.eO(this.HC.mAdTemplate));
        if (zDv) {
            this.JU.post(new Runnable() { // from class: com.kwad.components.ad.splashscreen.presenter.endcard.d.2
                @Override // java.lang.Runnable
                public final void run() {
                    d.this.JU.getWidth();
                    d.this.JW.a(d.this.HC.mAdTemplate, d.this.HC.mApkDownloadHelper, com.kwad.sdk.c.a.a.px2dip(d.this.getContext(), d.this.JU.getHeight()) / 414.0f);
                }
            });
        }
        this.JV = (ImageView) findViewById(R.id.ksad_splash_end_card_native_bg);
        SplashEndLandView splashEndLandView = (SplashEndLandView) findViewById(R.id.ksad_splash_end_card_native_dialog_root);
        this.JW = splashEndLandView;
        splashEndLandView.t(zDv);
        SplashEndLandView splashEndLandView2 = this.JW;
        com.kwad.components.ad.splashscreen.h hVar = this.HC;
        splashEndLandView2.a(hVar.mAdTemplate, hVar.mApkDownloadHelper, 1.0f);
    }

    private void nm() {
        if (com.kwad.sdk.core.response.helper.a.aL(com.kwad.sdk.core.response.helper.e.eO(this.HC.mAdTemplate))) {
            com.kwad.components.ad.splashscreen.e.a aVar = new com.kwad.components.ad.splashscreen.e.a(getContext(), this.HC.mAdTemplate) { // from class: com.kwad.components.ad.splashscreen.presenter.endcard.d.1
                {
                    super(adTemplate);
                }

                @Override // com.kwad.components.ad.splashscreen.e.a
                public final void k(int i, String str) {
                    d.this.af(str);
                }
            };
            com.kwad.components.core.e.d.d dVar = this.HC.mApkDownloadHelper;
            if (dVar != null) {
                dVar.b(aVar);
            }
        }
    }

    private void nn() {
        this.JU.setVisibility(0);
        a(this.JV, com.kwad.sdk.core.response.helper.a.ba(com.kwad.sdk.core.response.helper.e.eO(this.HC.mAdTemplate)).materialUrl, this.HC.mAdTemplate);
    }

    @Override // com.kwad.components.ad.splashscreen.presenter.e, com.kwad.sdk.mvp.Presenter
    public final void ay() {
        super.ay();
        initView();
        this.HC.GP.a(this);
        com.kwad.sdk.core.adlog.c.d(this.HC.mAdTemplate, (JSONObject) null, new com.kwad.sdk.core.adlog.c.b().ee(87).el(6));
        nm();
        nn();
    }

    @Override // com.kwad.sdk.core.j.c
    public final void bA() {
        SplashEndLandView splashEndLandView = this.JW;
        if (splashEndLandView != null) {
            splashEndLandView.bA();
        }
    }

    @Override // com.kwad.sdk.core.j.c
    public final void bz() {
        SplashEndLandView splashEndLandView = this.JW;
        if (splashEndLandView != null) {
            splashEndLandView.bz();
        }
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public final void onCreate() {
        super.onCreate();
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public final void onUnbind() {
        super.onUnbind();
        SplashEndLandView splashEndLandView = this.JW;
        if (splashEndLandView != null) {
            splashEndLandView.no();
        }
        this.HC.GP.b(this);
    }

    private static void a(ImageView imageView, String str, AdTemplate adTemplate) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        KSImageLoader.loadImage(imageView, str, adTemplate, new DisplayImageOptionsCompat.Builder().setBlurRadius(20).build(), new SimpleImageLoadingListener() { // from class: com.kwad.components.ad.splashscreen.presenter.endcard.d.3
            @Override // com.kwad.sdk.core.imageloader.core.listener.SimpleImageLoadingListener, com.kwad.sdk.core.imageloader.core.listener.ImageLoadingListener
            public final boolean onDecode(String str2, InputStream inputStream, DecodedResult decodedResult) {
                decodedResult.mBitmap = BlurUtils.stackBlur(BitmapFactory.decodeStream(inputStream), 20, false);
                return true;
            }

            @Override // com.kwad.sdk.core.imageloader.core.listener.SimpleImageLoadingListener, com.kwad.sdk.core.imageloader.core.listener.ImageLoadingListener
            public final void onLoadingComplete(String str2, View view, DecodedResult decodedResult) {
            }
        });
    }
}

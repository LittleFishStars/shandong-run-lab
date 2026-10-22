package com.kwad.components.ad.reward.presenter;

import android.graphics.BitmapFactory;
import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;
import com.kwad.sdk.R;
import com.kwad.sdk.core.imageloader.KSImageLoader;
import com.kwad.sdk.core.imageloader.core.DisplayImageOptionsCompat;
import com.kwad.sdk.core.imageloader.core.decode.DecodedResult;
import com.kwad.sdk.core.imageloader.core.listener.SimpleImageLoadingListener;
import com.kwad.sdk.core.imageloader.utils.BlurUtils;
import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.utils.as;
import java.io.InputStream;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_06_4659cls.dex */
public class c extends b {
    private ImageView ww;
    private AdInfo wx;

    public c(AdInfo adInfo) {
        this.wx = adInfo;
    }

    private static void a(ImageView imageView, String str, AdTemplate adTemplate) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        KSImageLoader.loadImage(imageView, str, adTemplate, new DisplayImageOptionsCompat.Builder().setBlurRadius(50).build(), new SimpleImageLoadingListener() { // from class: com.kwad.components.ad.reward.presenter.c.1
            @Override // com.kwad.sdk.core.imageloader.core.listener.SimpleImageLoadingListener, com.kwad.sdk.core.imageloader.core.listener.ImageLoadingListener
            public final boolean onDecode(String str2, InputStream inputStream, DecodedResult decodedResult) {
                decodedResult.mBitmap = BlurUtils.stackBlur(BitmapFactory.decodeStream(inputStream), 50, false);
                return true;
            }

            @Override // com.kwad.sdk.core.imageloader.core.listener.SimpleImageLoadingListener, com.kwad.sdk.core.imageloader.core.listener.ImageLoadingListener
            public final void onLoadingComplete(String str2, View view, DecodedResult decodedResult) {
            }
        });
    }

    @Override // com.kwad.components.ad.reward.presenter.b, com.kwad.sdk.mvp.Presenter
    public final void ay() {
        super.ay();
        AdTemplate adTemplate = this.uj.mAdTemplate;
        if (iN() || adTemplate.adInfoList.size() <= 0) {
            return;
        }
        String strAa = com.kwad.sdk.core.response.helper.a.aa(adTemplate.adInfoList.get(0));
        this.ww.setVisibility(iP());
        try {
            a(this.ww, strAa, adTemplate);
        } catch (Throwable th) {
            com.kwad.sdk.core.d.c.printStackTrace(th);
        }
    }

    public int iO() {
        return R.id.ksad_blur_video_cover;
    }

    public int iP() {
        getContext();
        if (com.kwad.components.ad.reward.g.S(this.uj.mAdTemplate) && !as.VM()) {
            return 0;
        }
        if (com.kwad.components.ad.reward.g.R(this.uj.mAdTemplate) && !as.VM()) {
            return 0;
        }
        if ((!com.kwad.sdk.core.response.helper.e.fa(this.uj.mAdTemplate) || as.VM()) && !com.kwad.components.ad.reward.g.g(this.wx)) {
            return (com.kwad.sdk.core.response.helper.a.cQ(this.wx) && com.kwad.components.ad.reward.a.b.hY() && !as.VM()) ? 0 : 8;
        }
        return 0;
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public final void onCreate() {
        super.onCreate();
        this.ww = (ImageView) findViewById(iO());
    }
}

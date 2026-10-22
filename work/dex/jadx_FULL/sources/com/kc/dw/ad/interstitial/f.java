package com.kc.dw.ad.interstitial;

import android.app.Activity;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import com.kc.dw.core.ad.interstitial.InterstitialAdListener;
import com.kc.dw.core.domain.HttpResponse;
import com.kc.dw.core.router.log.bean.LoadResState;
import com.kc.dw.core.utils.x;
import com.kc.dw.core.view.gif.GifImageView;
import com.qihoo.SdkProtected.OSETSDK.Keep;
import java.io.IOException;
import java.math.BigInteger;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
@Keep
public class f implements x {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f39102a;
    public final Activity b;
    public final g c;

    public f(g gVar, String str, Activity activity) {
        this.c = gVar;
        this.f39102a = str;
        this.b = activity;
    }

    @Override // com.kc.dw.core.utils.x
    public void onFailure(IOException iOException) {
        com.kc.dw.core.service.logrecord.a.a(5, "f4", this.c.f39103a, new LoadResState().setFail(2));
        a aVar = this.c.b;
        if (aVar != null) {
            ((com.kc.dw.platform.ad_adapter.interstitial.a) aVar).onAdRenderFail("load image error", -1);
        }
    }

    @Override // com.kc.dw.core.utils.x
    public void onResponse(HttpResponse<byte[]> httpResponse) throws IOException {
        InterstitialAdListener interstitialAdListener;
        try {
            if (!httpResponse.isSuccessful()) {
                com.kc.dw.core.service.logrecord.a.a(5, "f4", this.c.f39103a, new LoadResState().setFail(3));
                a aVar = this.c.b;
                if (aVar != null) {
                    ((com.kc.dw.platform.ad_adapter.interstitial.a) aVar).onAdRenderFail("load image error", httpResponse.getErrorCode());
                    return;
                }
                return;
            }
            try {
                byte[] responseBody = httpResponse.getResponseBody();
                if (responseBody == null || responseBody.length <= 0) {
                    com.kc.dw.core.service.logrecord.a.a(5, "f4", this.c.f39103a, new LoadResState().setFail(4));
                    a aVar2 = this.c.b;
                    if (aVar2 != null) {
                        ((com.kc.dw.platform.ad_adapter.interstitial.a) aVar2).onAdRenderFail("load image error", httpResponse.getErrorCode());
                        return;
                    }
                    return;
                }
                com.kc.dw.core.service.logrecord.a.a(5, "s4", this.c.f39103a, new LoadResState().setSuccess(1, g.a(this.c, this.f39102a) ? 2 : 1, 0));
                this.c.getClass();
                byte[] bArr = new byte[4];
                System.arraycopy(responseBody, 0, bArr, 0, 4);
                if (new BigInteger(1, bArr).toString(16).startsWith("47494638")) {
                    GifImageView gifImageView = new GifImageView(this.b);
                    gifImageView.setBytes(responseBody);
                    this.c.f = gifImageView.getGifHeight();
                    this.c.g = gifImageView.getGifWidth();
                    gifImageView.clear();
                } else {
                    Bitmap bitmapDecodeByteArray = BitmapFactory.decodeByteArray(responseBody, 0, responseBody.length);
                    this.c.g = bitmapDecodeByteArray.getWidth();
                    this.c.f = bitmapDecodeByteArray.getHeight();
                }
                g gVar = this.c;
                if (gVar.f > gVar.g) {
                    gVar.e = 2;
                }
                a aVar3 = gVar.b;
                if (aVar3 == null || (interstitialAdListener = ((com.kc.dw.platform.ad_adapter.interstitial.a) aVar3).f39478a) == null) {
                    return;
                }
                interstitialAdListener.onAdReady(null);
            } catch (Throwable th) {
                com.kc.dw.core.service.logrecord.a.a(5, "f4", this.c.f39103a, new LoadResState().setFail(9));
                a aVar4 = this.c.b;
                if (aVar4 != null) {
                    ((com.kc.dw.platform.ad_adapter.interstitial.a) aVar4).onAdRenderFail("load image error", httpResponse.getErrorCode());
                }
                th.printStackTrace();
            }
        } catch (Throwable th2) {
            com.kc.dw.core.service.logrecord.a.a(5, "f4", this.c.f39103a, new LoadResState().setFail(9));
            a aVar5 = this.c.b;
            if (aVar5 != null) {
                ((com.kc.dw.platform.ad_adapter.interstitial.a) aVar5).onAdRenderFail("load image error", httpResponse.getErrorCode());
            }
            th2.printStackTrace();
        }
    }
}

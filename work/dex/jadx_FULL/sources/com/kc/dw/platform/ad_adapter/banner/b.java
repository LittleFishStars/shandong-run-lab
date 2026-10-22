package com.kc.dw.platform.ad_adapter.banner;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.view.View;
import android.view.ViewGroup;
import com.kc.dw.ad.banner.SsdBannerRootView;
import com.kc.dw.core.bquery.d;
import com.kc.dw.core.domain.HttpResponse;
import com.kc.dw.core.router.log.bean.LoadResState;
import com.kc.dw.core.safe.m;
import com.kc.dw.core.utils.d0;
import com.kc.dw.core.utils.f;
import com.kc.dw.core.utils.g0;
import com.kc.dw.core.utils.h0;
import com.kc.dw.core.utils.x;
import com.kc.dw.core.view.gif.GifImageView;
import com.kc.openset.R;
import com.qihoo.SdkProtected.OSETSDK.Keep;
import java.io.IOException;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
@Keep
public class b implements x {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final com.kc.dw.ad.banner.a f39453a;
    public final SsdBannerRootView b;
    public final GifImageView c;
    public final d d;
    public final c e;

    @Keep
    public class a extends m {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final b f39454a;

        public a(b bVar) {
            this.f39454a = bVar;
        }

        @Override // com.kc.dw.core.safe.m
        public void safeOnClick(View view) {
            if (this.f39454a.b.getParent() != null) {
                ((ViewGroup) this.f39454a.b.getParent()).removeView(this.f39454a.b);
            }
            if (this.f39454a.e.i.getInteractionListener() != null) {
                this.f39454a.e.i.getInteractionListener().onAdClosed();
            }
        }
    }

    /* JADX INFO: renamed from: com.kc.dw.platform.ad_adapter.banner.b$b, reason: collision with other inner class name */
    @Keep
    public class C1067b extends m {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final b f39455a;

        public C1067b(b bVar) {
            this.f39455a = bVar;
        }

        @Override // com.kc.dw.core.safe.m
        public void safeOnClick(View view) {
            this.f39455a.f39453a.setClkActType(1);
            if (this.f39455a.e.i.getInteractionListener() != null && this.f39455a.f39453a.getCbc() == 0) {
                this.f39455a.e.i.getInteractionListener().onAdClicked();
            }
            f.a((com.kc.dw.platform.ad_adapter.c) this.f39455a.e.i, true);
        }
    }

    public b(c cVar, com.kc.dw.ad.banner.a aVar, SsdBannerRootView ssdBannerRootView, GifImageView gifImageView, d dVar) {
        this.e = cVar;
        this.f39453a = aVar;
        this.b = ssdBannerRootView;
        this.c = gifImageView;
        this.d = dVar;
    }

    @Override // com.kc.dw.core.utils.x
    public void onFailure(IOException iOException) {
        this.e.a("图片资源加载错误", com.kc.dw.core.exception.b.c.intValue());
        com.kc.dw.core.service.logrecord.a.a(5, "f4", this.e, new LoadResState().setFail(2));
    }

    @Override // com.kc.dw.core.utils.x
    public void onResponse(HttpResponse<byte[]> httpResponse) throws IOException {
        c cVar;
        Integer num;
        try {
            if (httpResponse.isSuccessful()) {
                com.kc.dw.core.service.logrecord.a.a(5, "s4", this.e, new LoadResState().setSuccess(1, 1, 0));
                byte[] responseBody = httpResponse.getResponseBody();
                if (responseBody != null && responseBody.length > 0 && responseBody.length < h0.a()) {
                    this.e.g = System.currentTimeMillis();
                    com.kc.dw.ad.banner.a aVar = this.f39453a;
                    aVar.setMonitorUrl(g0.b(aVar.getMonitorUrl(), this.e.b()));
                    this.b.setBannerAd(this.e.i);
                    if (d0.b(responseBody)) {
                        GifImageView gifImageView = this.c;
                        if (gifImageView != null) {
                            gifImageView.setBytes(responseBody);
                            this.c.startAnimation();
                        }
                    } else {
                        Bitmap bitmapDecodeByteArray = BitmapFactory.decodeByteArray(responseBody, 0, responseBody.length);
                        if (bitmapDecodeByteArray == null) {
                            this.e.a("图片资源加载错误", com.kc.dw.core.exception.b.c.intValue());
                            return;
                        }
                        this.c.setImageBitmap(bitmapDecodeByteArray);
                    }
                    c cVar2 = this.e;
                    c.a(cVar2, this.b, cVar2.i);
                    d dVarB = this.d.b(R.id.ms_banner_close_button);
                    a aVar2 = new a(this);
                    View view = dVarB.d;
                    if (view != null) {
                        view.setOnClickListener(aVar2);
                    }
                    d dVarB2 = this.d.b(R.id.ms_banner_image);
                    C1067b c1067b = new C1067b(this);
                    View view2 = dVarB2.d;
                    if (view2 != null) {
                        view2.setOnClickListener(c1067b);
                        return;
                    }
                    return;
                }
                cVar = this.e;
                num = com.kc.dw.core.exception.b.c;
            } else {
                com.kc.dw.core.service.logrecord.a.a(5, "f4", this.e, new LoadResState().setFail(3));
                cVar = this.e;
                num = com.kc.dw.core.exception.b.c;
            }
            cVar.a("图片资源加载错误", num.intValue());
        } catch (Throwable unused) {
            com.kc.dw.core.service.logrecord.a.a(5, "f4", this.e, new LoadResState().setFail(9));
            this.e.a("图片资源加载错误", com.kc.dw.core.exception.b.c.intValue());
        }
    }
}

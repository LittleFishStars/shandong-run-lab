package com.kc.dw.ad;

import android.graphics.Bitmap;
import android.view.View;
import android.widget.ImageView;
import com.google.gson.Gson;
import com.kc.dw.ad.splash.SsdSplashRootView;
import com.kc.dw.core.ad.BaseAdSlot;
import com.kc.dw.core.router.log.bean.LoadResState;
import com.kc.dw.core.utils.LogUtil;
import com.kc.dw.core.utils.d0;
import com.kc.dw.core.utils.g0;
import com.kc.dw.core.utils.h0;
import com.kc.dw.core.utils.m1;
import com.kc.dw.core.utils.s1;
import com.kc.dw.core.view.gif.GifImageView;
import com.qihoo.SdkProtected.OSETSDK.Keep;
import java.io.IOException;
import java.util.HashMap;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
@Keep
public class r implements com.kc.dw.core.utils.w {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final com.kc.dw.ad.splash.d f39148a;
    public final byte[] b;
    public final int c;
    public final long d;
    public final com.kc.dw.ad.splash.a e;
    public final int f;
    public final int g;
    public final int h;
    public final GifImageView i;
    public final com.kc.dw.ad.splash.c j;
    public final SsdSplashRootView k;
    public final View l;
    public final int m;
    public final ImageView n;
    public final k o;

    @Keep
    public class a extends com.kc.dw.core.safe.j {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final byte[] f39149a;
        public final r b;

        public a(r rVar, byte[] bArr) {
            this.b = rVar;
            this.f39149a = bArr;
        }

        @Override // com.kc.dw.core.safe.j
        public void safeRun() {
            this.b.i.setBytes(this.f39149a);
            r rVar = this.b;
            rVar.j.setWidth(Integer.valueOf(rVar.i.getGifWidth()));
            r rVar2 = this.b;
            rVar2.j.setHeight(Integer.valueOf(rVar2.i.getGifHeight()));
            this.b.i.startAnimation();
        }
    }

    public r(k kVar, com.kc.dw.ad.splash.d dVar, byte[] bArr, int i, long j, com.kc.dw.ad.splash.a aVar, int i2, int i3, int i4, GifImageView gifImageView, com.kc.dw.ad.splash.c cVar, SsdSplashRootView ssdSplashRootView, View view, int i5, ImageView imageView) {
        this.o = kVar;
        this.f39148a = dVar;
        this.b = bArr;
        this.c = i;
        this.d = j;
        this.e = aVar;
        this.f = i2;
        this.g = i3;
        this.h = i4;
        this.i = gifImageView;
        this.j = cVar;
        this.k = ssdSplashRootView;
        this.l = view;
        this.m = i5;
        this.n = imageView;
    }

    @Override // com.kc.dw.core.utils.w
    public void a(int i, IOException iOException) {
        if (k.a(this.o, this.f39148a, this.b) || this.o.n != null) {
            return;
        }
        LogUtil.dev("AdNative", "wait defImage");
        this.o.a(((long) this.c) - (System.currentTimeMillis() - this.d));
    }

    /* JADX WARN: Code duplicated, block: B:18:0x0057  */
    @Override // com.kc.dw.core.utils.w
    public void a(byte[] bArr, Bitmap bitmap, Bitmap bitmap2, boolean z) throws IOException {
        int i;
        k kVar;
        if (bArr != null) {
            try {
                if (bArr.length > 0) {
                    if (!k.a(this.o, this.f39148a, this.b)) {
                        s1.a(this.f39148a.getEventUrl(), 13, 200, "图片资源加载成功");
                    }
                    if (bArr.length >= h0.a()) {
                        b(9, new IOException("image error. by memory "));
                        return;
                    }
                    com.kc.dw.platform.ad_adapter.splash.j jVar = this.o.w;
                    LoadResState loadResState = new LoadResState();
                    com.kc.dw.ad.splash.d dVar = this.f39148a;
                    if (dVar != null) {
                        try {
                            if (dVar.getAdPatternType() == 2) {
                                i = 2;
                            } else {
                                i = 1;
                            }
                        } catch (Exception unused) {
                        }
                    } else {
                        i = 1;
                    }
                    com.kc.dw.core.service.logrecord.a.a(5, "s4", jVar, loadResState.setSuccess(i, com.kc.dw.core.service.logrecord.b.a(this.f39148a), z ? 1 : 0));
                    if (z) {
                        this.o.b(2);
                    }
                    if (!d0.b(bArr)) {
                        k.a(this.o, this.j, this.k, this.e, this.l);
                        if (bitmap == null) {
                            k kVar2 = this.o;
                            com.kc.dw.ad.splash.a aVar = this.e;
                            Integer num = com.kc.dw.core.exception.b.c;
                            kVar2.a(aVar, "图片资源加载错误7", num);
                            s1.a(this.f39148a.getEventUrl(), 13, num.intValue(), "图片资源加载错误8 cid:" + this.f39148a.getCid());
                            return;
                        }
                        try {
                            Gson gson = new Gson();
                            HashMap map = new HashMap();
                            map.put("stepNum", 3);
                            map.put("msg", "image succ,bitmap not null");
                            map.put("creativeType", Integer.valueOf(this.f39148a.getAdPatternType()));
                            s1.a(this.j.b.getErrorUrl(), gson.toJson(map));
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                        k.a(this.o, this.m, bitmap, this.i, this.n, bitmap2);
                        this.j.setWidth(Integer.valueOf(bitmap.getWidth()));
                        this.j.setHeight(Integer.valueOf(bitmap.getHeight()));
                        this.o.s = System.currentTimeMillis();
                        this.o.t.b(2);
                        com.kc.dw.ad.splash.d dVar2 = this.f39148a;
                        dVar2.setMonitorUrl(g0.b(dVar2.getMonitorUrl(), this.o.a()));
                        kVar = this.o;
                    } else {
                        if (this.i == null) {
                            k kVar3 = this.o;
                            com.kc.dw.ad.splash.a aVar2 = this.e;
                            Integer num2 = com.kc.dw.core.exception.b.c;
                            kVar3.a(aVar2, "图片资源加载错误5", num2);
                            s1.a(this.f39148a.getEventUrl(), 13, num2.intValue(), "图片资源加载错误6 cid:" + this.f39148a.getCid());
                            return;
                        }
                        this.o.s = System.currentTimeMillis();
                        k.a(this.o, this.j, this.k, this.e, this.l);
                        this.i.post(new a(this, bArr));
                        try {
                            Gson gson2 = new Gson();
                            HashMap map2 = new HashMap();
                            map2.put("stepNum", 3);
                            map2.put("msg", "image succ, gif not null");
                            map2.put("creativeType", Integer.valueOf(this.f39148a.getAdPatternType()));
                            s1.a(this.j.b.getErrorUrl(), gson2.toJson(map2));
                        } catch (Exception e2) {
                            e2.printStackTrace();
                        }
                        this.o.s = System.currentTimeMillis();
                        this.o.t.b(2);
                        kVar = this.o;
                    }
                    k.b(kVar);
                    return;
                }
            } catch (Throwable th) {
                try {
                    th.printStackTrace();
                    b(9, new IOException("图片资源加载错误10,"));
                    return;
                } catch (Throwable th2) {
                    b(9, new IOException("图片资源加载错误11."));
                    th2.printStackTrace();
                    return;
                }
            }
        }
        b(3, new IOException("图片资源加载错误9"));
    }

    @Override // com.kc.dw.core.utils.w
    public void b(int i, IOException iOException) {
        String message;
        try {
            String message2 = "";
            if (!k.a(this.o, this.f39148a, this.b)) {
                String[] eventUrl = this.f39148a.getEventUrl();
                int iIntValue = com.kc.dw.core.exception.b.c.intValue();
                StringBuilder sb = new StringBuilder();
                this.o.getClass();
                if (iOException != null) {
                    try {
                        message = iOException.getMessage();
                    } catch (Exception unused) {
                        message = "";
                    }
                } else {
                    message = "";
                }
                sb.append(message);
                sb.append(" image error cid:");
                sb.append(this.f39148a.getCid());
                s1.a(eventUrl, 13, iIntValue, sb.toString());
            }
            if (this.o.a((BaseAdSlot) this.f39148a)) {
                com.kc.dw.core.service.logrecord.a.a(5, "f4", this.o.w, new LoadResState().setFail(i));
                k kVar = this.o;
                com.kc.dw.ad.splash.a aVar = this.e;
                StringBuilder sb2 = new StringBuilder();
                sb2.append("图片资源加载错误1:");
                this.o.getClass();
                if (iOException != null) {
                    try {
                        message2 = iOException.getMessage();
                    } catch (Exception unused2) {
                    }
                }
                sb2.append(message2);
                kVar.a(aVar, sb2.toString(), com.kc.dw.core.exception.b.c);
                return;
            }
            byte[] bArrC = com.kc.dw.core.utils.i.c(this.f39148a.getDefImage());
            if (bArrC != null && bArrC.length > 0) {
                Bitmap bitmapA = d0.a(bArrC);
                if (bitmapA != null) {
                    this.f39148a.getImageUrls()[0] = this.f39148a.getDefImage();
                    Bitmap[] bitmapArrA = m1.a(bitmapA, bArrC, this.f, this.g, this.h);
                    a(bArrC, bitmapArrA[0], bitmapArrA[1], true);
                    return;
                }
                com.kc.dw.core.utils.i.a(this.f39148a.getDefImage());
            }
            com.kc.dw.core.service.logrecord.a.a(5, "f4", this.o.w, new LoadResState().setFail(i));
            this.o.a(this.e, "图片资源加载错误2:" + iOException, com.kc.dw.core.exception.b.c);
        } catch (IOException e) {
            Integer num = com.kc.dw.core.exception.b.c;
            this.o.a(this.e, "图片资源加载错误3:" + e, num);
            com.kc.dw.core.service.logrecord.a.a(5, "f4", this.o.w, new LoadResState().setFail(i));
            String[] eventUrl2 = this.f39148a.getEventUrl();
            int iIntValue2 = num.intValue();
            StringBuilder sbA = com.kc.dw.activity.a.a("图片资源加载错误4 cid:");
            sbA.append(this.f39148a.getCid());
            s1.a(eventUrl2, 13, iIntValue2, sbA.toString());
        }
    }

    @Override // com.kc.dw.core.utils.w
    public void onStartDownload() {
        this.o.b(2);
    }
}

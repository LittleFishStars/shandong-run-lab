package com.byazt.xs;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.ImageDecoder;
import android.graphics.drawable.AnimatedImageDrawable;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.text.TextUtils;
import android.widget.ImageView;
import com.byazt.ete.f;
import com.byazt.nr.m;
import com.byazt.nr.t;
import com.byazt.omf.gt;
import com.byazt.oq.GifView;
import com.byazt.sz.yp;
import com.byazt.yj.gr;
import java.io.File;
import java.io.FileOutputStream;
import java.util.Arrays;
import java.util.Map;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_11_8719cls.dex */
@com.byazt.zqa.c(c = {0, 1, 468, 15})
public class uj implements com.byazt.sa.c {

    public interface c {
        void c(Drawable drawable);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public Drawable ve(byte[] bArr) {
        FileOutputStream fileOutputStream;
        try {
            boolean zC = com.byazt.ue.tt.c();
            File fileTt = com.byazt.nr.x.tt(gt.getContext(), zC, zC ? "UGEN_GIF_AD_CACHE/" : "/UGEN_GIF_CACHE/", "TT_UGEN_GIF_FILE");
            fileOutputStream = new FileOutputStream(fileTt);
            try {
                fileOutputStream.write(bArr, 0, bArr.length);
                if (Build.VERSION.SDK_INT >= 28) {
                    Drawable drawableDecodeDrawable = ImageDecoder.decodeDrawable(ImageDecoder.createSource(fileTt));
                    try {
                        fileOutputStream.close();
                    } catch (Throwable unused) {
                    }
                    return drawableDecodeDrawable;
                }
                BitmapDrawable bitmapDrawable = new BitmapDrawable(gt.getContext().getResources(), BitmapFactory.decodeByteArray(bArr, 0, bArr.length));
                try {
                    fileOutputStream.close();
                } catch (Throwable unused2) {
                }
                return bitmapDrawable;
            } catch (Throwable th) {
                th = th;
                try {
                    m.ve("ImageLoaderProvider", "GifView  getSourceByFile fail : ", th);
                    return null;
                } finally {
                    if (fileOutputStream != null) {
                        try {
                            fileOutputStream.close();
                        } catch (Throwable unused3) {
                        }
                    }
                }
            }
        } catch (Throwable th2) {
            th = th2;
            fileOutputStream = null;
        }
    }

    public void tt(yp ypVar, String str, final com.byazt.sa.c.InterfaceC0516c interfaceC0516c) {
        com.byazt.yj.yp ypVarType = com.byazt.xky.tt.c(str).type(1);
        c(ypVar, ypVarType, str);
        ypVarType.to(new gr() { // from class: com.byazt.xs.uj.3
            @Override // com.byazt.yj.gr
            public void onFailed(int i, String str2, Throwable th) {
                com.byazt.sa.c.InterfaceC0516c interfaceC0516c2 = interfaceC0516c;
                if (interfaceC0516c2 != null) {
                    interfaceC0516c2.c(null);
                }
            }

            @Override // com.byazt.yj.gr
            public void onSuccess(com.byazt.yj.m mVar) {
                if (mVar == null) {
                    interfaceC0516c.c(null);
                    return;
                }
                com.byazt.sa.c.InterfaceC0516c interfaceC0516c2 = interfaceC0516c;
                if (interfaceC0516c2 == null) {
                    interfaceC0516c2.c(null);
                    return;
                }
                if (mVar.getResult() instanceof Bitmap) {
                    interfaceC0516c.c((Bitmap) mVar.getResult());
                } else if (mVar.getResult() instanceof byte[]) {
                    try {
                        interfaceC0516c.c(BitmapFactory.decodeByteArray((byte[]) mVar.getResult(), 0, ((byte[]) mVar.getResult()).length));
                    } catch (Throwable unused) {
                    }
                }
            }
        });
    }

    @Override // com.byazt.sa.c
    public void c(yp ypVar, String str, ImageView imageView, com.byazt.sa.c.InterfaceC0516c interfaceC0516c) {
        if (imageView instanceof GifView) {
            final GifView gifView = (GifView) imageView;
            gifView.setAdjustViewBounds(true);
            gifView.setBackgroundColor(0);
            com.byazt.xky.tt.c(str).type(3).config(Bitmap.Config.RGB_565).to(new gr() { // from class: com.byazt.xs.uj.1
                @Override // com.byazt.yj.gr
                public void onFailed(int i, String str2, Throwable th) {
                }

                @Override // com.byazt.yj.gr
                public void onSuccess(com.byazt.yj.m mVar) {
                    try {
                        Object result = mVar.getResult();
                        if (!(result instanceof byte[])) {
                            if (result instanceof Bitmap) {
                                gifView.setImageBitmap((Bitmap) result);
                            }
                        } else if (!mVar.isGif()) {
                            gifView.setImageDrawable(com.byazt.aas.m.c((byte[]) result, 0));
                        } else {
                            gifView.c((byte[]) result, false);
                            gifView.setRepeatConfig(true);
                            gifView.tt();
                        }
                    } catch (Throwable th) {
                        onFailed(1002, "", th);
                    }
                }
            });
            return;
        }
        com.byazt.yj.yp ypVarC = com.byazt.xky.tt.c(str);
        c(ypVar, ypVarC, str);
        ypVarC.to(imageView);
    }

    public boolean tt(byte[] bArr) {
        return TextUtils.equals("png", t.c(Arrays.copyOfRange(bArr, 0, t.c()))) && com.byazt.or.a.c(bArr);
    }

    @Override // com.byazt.sa.c
    public void c(yp ypVar, String str, final ImageView imageView, int i, int i2, com.byazt.sa.c.InterfaceC0516c interfaceC0516c) {
        com.byazt.yj.yp ypVarType = com.byazt.xky.tt.c(str).type(3);
        c(ypVar, ypVarType, str);
        ypVarType.to(new gr() { // from class: com.byazt.xs.uj.2
            @Override // com.byazt.yj.gr
            public void onFailed(int i3, String str2, Throwable th) {
            }

            @Override // com.byazt.yj.gr
            public void onSuccess(final com.byazt.yj.m mVar) {
                if (imageView.isAttachedToWindow()) {
                    uj.this.c(mVar, imageView);
                } else {
                    imageView.post(new Runnable() { // from class: com.byazt.xs.uj.2.1
                        @Override // java.lang.Runnable
                        public void run() {
                            AnonymousClass2 anonymousClass2 = AnonymousClass2.this;
                            uj.this.c(mVar, imageView);
                        }
                    });
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(com.byazt.yj.m mVar, ImageView imageView) {
        Object result = mVar.getResult();
        if (result instanceof byte[]) {
            if (!mVar.isGif()) {
                byte[] bArr = (byte[]) result;
                if (!tt(bArr)) {
                    if (c(bArr)) {
                        com.byazt.or.a.c(imageView, bArr, imageView.getWidth(), imageView.getHeight());
                        return;
                    }
                    int iC = f.c(imageView.getWidth(), imageView.getHeight());
                    Bitmap bitmapC = new com.byazt.ib.c(imageView.getWidth(), imageView.getHeight(), imageView.getScaleType(), Bitmap.Config.RGB_565, imageView.getWidth() / iC, imageView.getHeight() / iC).c(bArr);
                    if (bitmapC != null) {
                        imageView.setImageBitmap(bitmapC);
                        return;
                    }
                    return;
                }
            }
            if (Build.VERSION.SDK_INT <= 30) {
                c((byte[]) result, imageView);
                return;
            } else {
                com.byazt.or.a.c(imageView, (byte[]) result, imageView.getWidth(), imageView.getHeight());
                return;
            }
        }
        if (result instanceof Bitmap) {
            imageView.setImageBitmap((Bitmap) result);
        }
    }

    @Override // com.byazt.sa.c
    public void c(yp ypVar, String str, com.byazt.sa.c.InterfaceC0516c interfaceC0516c) {
        tt(ypVar, str, interfaceC0516c);
    }

    private void c(yp ypVar, com.byazt.yj.yp ypVar2, String str) {
        Map<String, Object> mapTt;
        if (ypVar == null || (mapTt = ypVar.tt()) == null) {
            return;
        }
        Object obj = mapTt.get("image_info");
        if (obj instanceof Map) {
            ypVar2.key((String) ((Map) obj).get(str));
        }
        String str2 = (String) mapTt.get("cache_dir");
        if (TextUtils.isEmpty(str2)) {
            return;
        }
        ypVar2.cacheDir(str2);
    }

    private void c(byte[] bArr, final ImageView imageView) {
        try {
            m.uj("ImageLoaderProvider", "load animation image");
            c(bArr, new c() { // from class: com.byazt.xs.uj.4
                @Override // com.byazt.xs.uj.c
                public void c(final Drawable drawable) {
                    com.byazt.bzd.x.c(new Runnable() { // from class: com.byazt.xs.uj.4.1
                        @Override // java.lang.Runnable
                        public void run() {
                            if (Build.VERSION.SDK_INT >= 28) {
                                Drawable drawable2 = drawable;
                                if (drawable2 instanceof AnimatedImageDrawable) {
                                    ((AnimatedImageDrawable) drawable2).start();
                                }
                            }
                            imageView.setImageDrawable(drawable);
                        }
                    });
                }
            });
        } catch (Exception e) {
            m.c(e);
        }
    }

    private void c(final byte[] bArr, final c cVar) {
        com.byazt.bwm.n.tt(new com.byazt.bwm.sp("csj_animation_drawable") { // from class: com.byazt.xs.uj.5
            @Override // java.lang.Runnable
            public void run() {
                Drawable drawableVe = uj.this.ve(bArr);
                c cVar2 = cVar;
                if (cVar2 != null) {
                    cVar2.c(drawableVe);
                }
            }
        });
    }

    public boolean c(byte[] bArr) {
        return com.byazt.or.a.c(bArr, 0);
    }
}

package com.byazt.pn;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.util.Base64;
import android.view.View;
import com.byazt.ga.i;
import com.byazt.ga.uj;
import com.byazt.kk.a;
import com.byazt.kk.da;
import java.io.IOException;
import java.util.Map;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_11_8719cls.dex */
@com.byazt.zqa.c(c = {0, 1, 1195, 13})
public class tt {
    public static final Object c = new Object();
    public final Map<String, i> n;
    public final Context tt;
    public uj uj;
    public final String ve;

    public tt(Drawable.Callback callback, String str, uj ujVar, Map<String, i> map) {
        if (TextUtils.isEmpty(str) || str.charAt(str.length() - 1) == '/') {
            this.ve = str;
        } else {
            this.ve = str + '/';
        }
        this.n = map;
        c(ujVar);
        if (callback instanceof View) {
            this.tt = ((View) callback).getContext().getApplicationContext();
        } else {
            this.tt = null;
        }
    }

    private Bitmap tt(String str, Bitmap bitmap) {
        synchronized (c) {
        }
        return bitmap;
    }

    public void c(uj ujVar) {
        this.uj = ujVar;
    }

    public Bitmap c(String str, Bitmap bitmap) {
        if (bitmap != null) {
            return this.n.get(str).z();
        }
        i iVar = this.n.get(str);
        Bitmap bitmapZ = iVar.z();
        iVar.c(null);
        return bitmapZ;
    }

    public Bitmap c(String str) {
        i iVar = this.n.get(str);
        if (iVar == null) {
            return null;
        }
        Bitmap bitmapZ = iVar.z();
        if (bitmapZ != null) {
            return bitmapZ;
        }
        uj ujVar = this.uj;
        if (ujVar != null) {
            return ujVar.c(iVar);
        }
        Context context = this.tt;
        if (context == null) {
            return null;
        }
        String strU = iVar.u();
        BitmapFactory.Options options = new BitmapFactory.Options();
        options.inScaled = true;
        options.inDensity = 160;
        if (strU.startsWith("data:") && strU.indexOf("base64,") > 0) {
            try {
                byte[] bArrDecode = Base64.decode(strU.substring(strU.indexOf(44) + 1), 0);
                return tt(str, BitmapFactory.decodeByteArray(bArrDecode, 0, bArrDecode.length, options));
            } catch (IllegalArgumentException e) {
                a.c("data URL did not have correct base64 format.", e);
                return null;
            }
        }
        try {
            if (!TextUtils.isEmpty(this.ve)) {
                try {
                    Bitmap bitmapDecodeStream = BitmapFactory.decodeStream(context.getAssets().open(this.ve + strU), null, options);
                    if (bitmapDecodeStream == null) {
                        a.tt("Decoded image `" + str + "` is null.");
                        return null;
                    }
                    return tt(str, da.c(bitmapDecodeStream, iVar.c(), iVar.tt()));
                } catch (IllegalArgumentException e2) {
                    a.c("Unable to decode image `" + str + "`.", e2);
                    return null;
                }
            }
            throw new IllegalStateException("You must set an images folder before loading an image. Set it with LottieComposition#setImagesFolder or LottieDrawable#setImagesFolder");
        } catch (IOException e3) {
            a.c("Unable to open asset.", e3);
            return null;
        }
    }

    public boolean c(Context context) {
        return (context == null && this.tt == null) || this.tt.equals(context);
    }
}

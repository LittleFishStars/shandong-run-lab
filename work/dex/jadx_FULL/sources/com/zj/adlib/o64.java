package com.zj.adlib;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.util.Base64;
import android.view.View;
import androidx.annotation.Nullable;
import com.airbnb.lottie.ImageAssetDelegate;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public class o64 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Object f43679a = new Object();

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final Context f18571a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @Nullable
    public ImageAssetDelegate f18572a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final String f18573a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final Map<String, b45> f18574a;

    public o64(Drawable.Callback callback, String str, ImageAssetDelegate imageAssetDelegate, Map<String, b45> map) {
        if (TextUtils.isEmpty(str) || str.charAt(str.length() - 1) == '/') {
            this.f18573a = str;
        } else {
            this.f18573a = str + '/';
        }
        if (callback instanceof View) {
            this.f18571a = ((View) callback).getContext();
            this.f18574a = map;
            e(imageAssetDelegate);
        } else {
            g25.e("LottieDrawable must be inside of a view for images to work.");
            this.f18574a = new HashMap();
            this.f18571a = null;
        }
    }

    @Nullable
    public Bitmap a(String str) {
        b45 b45Var = this.f18574a.get(str);
        if (b45Var == null) {
            return null;
        }
        Bitmap bitmapA = b45Var.a();
        if (bitmapA != null) {
            return bitmapA;
        }
        ImageAssetDelegate imageAssetDelegate = this.f18572a;
        if (imageAssetDelegate != null) {
            Bitmap bitmapA2 = imageAssetDelegate.a(b45Var);
            if (bitmapA2 != null) {
                d(str, bitmapA2);
            }
            return bitmapA2;
        }
        String strC = b45Var.c();
        BitmapFactory.Options options = new BitmapFactory.Options();
        options.inScaled = true;
        options.inDensity = 160;
        if (strC.startsWith("data:") && strC.indexOf("base64,") > 0) {
            try {
                byte[] bArrDecode = Base64.decode(strC.substring(strC.indexOf(44) + 1), 0);
                return d(str, BitmapFactory.decodeByteArray(bArrDecode, 0, bArrDecode.length, options));
            } catch (IllegalArgumentException e) {
                g25.f("data URL did not have correct base64 format.", e);
                return null;
            }
        }
        try {
            if (TextUtils.isEmpty(this.f18573a)) {
                throw new IllegalStateException("You must set an images folder before loading an image. Set it with LottieComposition#setImagesFolder or LottieDrawable#setImagesFolder");
            }
            try {
                return d(str, vj9.m(BitmapFactory.decodeStream(this.f18571a.getAssets().open(this.f18573a + strC), null, options), b45Var.f(), b45Var.d()));
            } catch (IllegalArgumentException e2) {
                g25.f("Unable to decode image.", e2);
                return null;
            }
        } catch (IOException e3) {
            g25.f("Unable to open asset.", e3);
            return null;
        }
    }

    @Nullable
    public b45 b(String str) {
        return this.f18574a.get(str);
    }

    public boolean c(Context context) {
        return (context == null && this.f18571a == null) || this.f18571a.equals(context);
    }

    public final Bitmap d(String str, @Nullable Bitmap bitmap) {
        synchronized (f43679a) {
            this.f18574a.get(str).h(bitmap);
        }
        return bitmap;
    }

    public void e(@Nullable ImageAssetDelegate imageAssetDelegate) {
        this.f18572a = imageAssetDelegate;
    }

    @Nullable
    public Bitmap f(String str, @Nullable Bitmap bitmap) {
        if (bitmap != null) {
            Bitmap bitmapA = this.f18574a.get(str).a();
            d(str, bitmap);
            return bitmapA;
        }
        b45 b45Var = this.f18574a.get(str);
        Bitmap bitmapA2 = b45Var.a();
        b45Var.h(null);
        return bitmapA2;
    }
}

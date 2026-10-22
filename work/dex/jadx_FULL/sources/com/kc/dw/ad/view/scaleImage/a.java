package com.kc.dw.ad.view.scaleImage;

import android.net.Uri;
import android.taobao.windvane.util.WVNativeCallbackUtil;
import com.kc.dw.ad.w;
import com.qihoo.SdkProtected.OSETSDK.Keep;
import java.io.File;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
@Keep
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Uri f39206a;
    public final Integer b;
    public boolean c;

    public a(int i) {
        this.f39206a = null;
        this.b = Integer.valueOf(i);
        this.c = true;
    }

    public a(Uri uri) {
        String string = uri.toString();
        if (string.startsWith("file:///") && !new File(string.substring(7)).exists()) {
            try {
                uri = Uri.parse(URLDecoder.decode(string, "UTF-8"));
            } catch (UnsupportedEncodingException unused) {
            }
        }
        this.f39206a = uri;
        this.b = null;
        this.c = true;
    }

    public static a a(int i) {
        return new a(i);
    }

    public static a a(String str) {
        String strA = w.a(com.ipd.dsp.internal.n.a.d, str);
        if (strA == null) {
            throw new NullPointerException("Uri must not be null");
        }
        if (!strA.contains("://")) {
            if (strA.startsWith(WVNativeCallbackUtil.SEPERATER)) {
                strA = strA.substring(1);
            }
            strA = w.a("file:///", strA);
        }
        return new a(Uri.parse(strA));
    }

    public a a() {
        this.c = true;
        return this;
    }
}

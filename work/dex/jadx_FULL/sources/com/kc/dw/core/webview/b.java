package com.kc.dw.core.webview;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.webkit.DownloadListener;
import com.qihoo.SdkProtected.OSETSDK.Keep;
import java.lang.reflect.Constructor;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
@Keep
public class b implements DownloadListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public Context f39436a;
    public a b;

    @Keep
    public interface a {
        void a();
    }

    public b(Context context) {
        this.f39436a = context;
    }

    public static b a(Context context) {
        try {
            if (com.kc.dw.base.a.adConfig() != null && com.kc.dw.base.a.adConfig().webViewDownloadListener() != null) {
                Constructor<? extends b> declaredConstructor = com.kc.dw.base.a.adConfig().webViewDownloadListener().getDeclaredConstructor(Context.class);
                declaredConstructor.setAccessible(true);
                return declaredConstructor.newInstance(context);
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
        return new b(context);
    }

    @Override // android.webkit.DownloadListener
    public void onDownloadStart(String str, String str2, String str3, String str4, long j) {
        try {
            this.f39436a.startActivity(new Intent("android.intent.action.VIEW", Uri.parse(str)));
            a aVar = this.b;
            if (aVar != null) {
                aVar.a();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

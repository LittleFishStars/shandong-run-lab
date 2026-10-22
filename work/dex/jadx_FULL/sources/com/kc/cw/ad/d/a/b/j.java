package com.kc.cw.ad.d.a.b;

import android.content.ContentProviderClient;
import android.content.Context;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import com.qihoo.SdkProtected.OSETSDK.Keep;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
@Keep
public class j implements com.kc.cw.ad.d.a.d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Context f38797a;

    public j(Context context) {
        this.f38797a = context;
    }

    @Override // com.kc.cw.ad.d.a.d
    public void a(com.kc.cw.ad.d.a.c cVar) {
        if (this.f38797a == null || cVar == null) {
            return;
        }
        if (!a()) {
            com.kc.cw.ad.d.a.f.a("Only supports Android 10.0 and above for Nubia");
            cVar.a(new com.kc.cw.ad.d.a.e("Only supports Android 10.0 and above for Nubia"));
            return;
        }
        try {
            ContentProviderClient contentProviderClientAcquireContentProviderClient = this.f38797a.getContentResolver().acquireContentProviderClient(Uri.parse("content://cn.nubia.identity/identity"));
            if (contentProviderClientAcquireContentProviderClient == null) {
                return;
            }
            Bundle bundleCall = contentProviderClientAcquireContentProviderClient.call("getOAID", null, null);
            contentProviderClientAcquireContentProviderClient.close();
            if (bundleCall == null) {
                throw new com.kc.cw.ad.d.a.e("OAID query failed: bundle is null");
            }
            String string = bundleCall.getInt("code", -1) == 0 ? bundleCall.getString("id") : null;
            if (string == null || string.length() == 0) {
                throw new com.kc.cw.ad.d.a.e("OAID query failed: " + bundleCall.getString("message"));
            }
            com.kc.cw.ad.d.a.f.a("OAID query success: " + string);
            cVar.a(string);
        } catch (Exception e) {
            com.kc.cw.ad.d.a.f.a(e);
            cVar.a(e);
        }
    }

    @Override // com.kc.cw.ad.d.a.d
    public boolean a() {
        return Build.VERSION.SDK_INT >= 29;
    }
}

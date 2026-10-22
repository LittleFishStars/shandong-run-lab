package com.beizi.fusion;

import android.content.ContentProviderClient;
import android.content.Context;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_10_7392cls.dex */
class pj implements yd {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Context f27657a;

    public pj(Context context) {
        this.f27657a = context;
    }

    @Override // com.beizi.fusion.yd
    public boolean a() {
        return Build.VERSION.SDK_INT >= 29;
    }

    @Override // com.beizi.fusion.yd
    public void a(kc kcVar) {
        if (this.f27657a == null || kcVar == null) {
            return;
        }
        if (!a()) {
            yj.a("Only supports Android 10.0 and above for Nubia");
            kcVar.a(new tj("Only supports Android 10.0 and above for Nubia"));
            return;
        }
        try {
            ContentProviderClient contentProviderClientAcquireContentProviderClient = this.f27657a.getContentResolver().acquireContentProviderClient(Uri.parse("content://cn.nubia.identity/identity"));
            if (contentProviderClientAcquireContentProviderClient == null) {
                return;
            }
            Bundle bundleCall = contentProviderClientAcquireContentProviderClient.call("getOAID", null, null);
            contentProviderClientAcquireContentProviderClient.close();
            if (bundleCall == null) {
                throw new tj("OAID query failed: bundle is null");
            }
            String string = bundleCall.getInt("code", -1) == 0 ? bundleCall.getString("id") : null;
            if (string == null || string.length() == 0) {
                throw new tj("OAID query failed: " + bundleCall.getString("message"));
            }
            yj.a("OAID query success: " + string);
            kcVar.a(string);
        } catch (Exception e) {
            yj.a(e);
            kcVar.a(e);
        }
    }
}

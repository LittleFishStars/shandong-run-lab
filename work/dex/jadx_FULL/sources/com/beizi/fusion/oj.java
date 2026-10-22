package com.beizi.fusion;

import android.content.ContentProviderClient;
import android.content.Context;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_10_7392cls.dex */
class oj implements xd {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Context f27617a;

    public oj(Context context) {
        this.f27617a = context;
    }

    @Override // com.beizi.fusion.xd
    public boolean a() {
        return Build.VERSION.SDK_INT >= 29;
    }

    @Override // com.beizi.fusion.xd
    public void a(jc jcVar) {
        if (this.f27617a == null || jcVar == null) {
            return;
        }
        if (!a()) {
            xj.a("Only supports Android 10.0 and above for Nubia");
            jcVar.a(new sj("Only supports Android 10.0 and above for Nubia"));
            return;
        }
        try {
            ContentProviderClient contentProviderClientAcquireContentProviderClient = this.f27617a.getContentResolver().acquireContentProviderClient(Uri.parse("content://cn.nubia.identity/identity"));
            if (contentProviderClientAcquireContentProviderClient == null) {
                return;
            }
            Bundle bundleCall = contentProviderClientAcquireContentProviderClient.call("getOAID", null, null);
            contentProviderClientAcquireContentProviderClient.close();
            if (bundleCall == null) {
                throw new sj("OAID query failed: bundle is null");
            }
            String string = bundleCall.getInt("code", -1) == 0 ? bundleCall.getString("id") : null;
            if (string == null || string.length() == 0) {
                throw new sj("OAID query failed: " + bundleCall.getString("message"));
            }
            xj.a("OAID query success: " + string);
            jcVar.a(string);
        } catch (Exception e) {
            xj.a(e);
            jcVar.a(e);
        }
    }
}

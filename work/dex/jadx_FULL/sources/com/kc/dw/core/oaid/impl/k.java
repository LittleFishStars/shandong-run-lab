package com.kc.dw.core.oaid.impl;

import android.content.ContentProviderClient;
import android.content.Context;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import com.kc.dw.core.oaid.OAIDException;
import com.qihoo.SdkProtected.OSETSDK.Keep;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
@Keep
public class k implements com.kc.dw.core.oaid.b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Context f39288a;

    public k(Context context) {
        this.f39288a = context;
    }

    @Override // com.kc.dw.core.oaid.b
    public void a(com.kc.dw.core.oaid.a aVar) {
        if (this.f39288a == null || aVar == null) {
            return;
        }
        if (!a()) {
            ((com.kc.dw.core.utils.n) aVar).a(new OAIDException("Only supports Android 10.0 and above for Nubia"));
            return;
        }
        try {
            ContentProviderClient contentProviderClientAcquireContentProviderClient = this.f39288a.getContentResolver().acquireContentProviderClient(Uri.parse("content://cn.nubia.identity/identity"));
            if (contentProviderClientAcquireContentProviderClient == null) {
                return;
            }
            Bundle bundleCall = contentProviderClientAcquireContentProviderClient.call("getOAID", null, null);
            contentProviderClientAcquireContentProviderClient.close();
            if (bundleCall == null) {
                throw new OAIDException("OAID query failed: bundle is null");
            }
            String string = bundleCall.getInt("code", -1) == 0 ? bundleCall.getString("id") : null;
            if (string != null && string.length() != 0) {
                ((com.kc.dw.core.utils.n) aVar).a(string);
                return;
            }
            throw new OAIDException("OAID query failed: " + bundleCall.getString("message"));
        } catch (Exception e) {
            ((com.kc.dw.core.utils.n) aVar).a(e);
        }
    }

    @Override // com.kc.dw.core.oaid.b
    public boolean a() {
        return Build.VERSION.SDK_INT >= 29;
    }
}

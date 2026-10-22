package com.zj.adlib;

import android.content.ContentProviderClient;
import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import cn.hzjizhun.admin.cn_oaid.OAIDException;
import cn.hzjizhun.admin.ddakd;
import cn.hzjizhun.admin.dddssad;
import cn.hzjizhun.admin.sdkdda;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public class oja implements sdkdda {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Context f43762a;

    public oja(Context context) {
        this.f43762a = context;
    }

    @Override // cn.hzjizhun.admin.sdkdda
    public boolean a() {
        return true;
    }

    @Override // cn.hzjizhun.admin.sdkdda
    public void b(ddakd ddakdVar) {
        if (this.f43762a == null || ddakdVar == null) {
            return;
        }
        if (!a()) {
            dddssad.a("Only supports Android 10.0 and above for Nubia");
            ddakdVar.b(new OAIDException("Only supports Android 10.0 and above for Nubia"));
            return;
        }
        try {
            ContentProviderClient contentProviderClientAcquireContentProviderClient = this.f43762a.getContentResolver().acquireContentProviderClient(Uri.parse("content://cn.nubia.identity/identity"));
            if (contentProviderClientAcquireContentProviderClient == null) {
                return;
            }
            Bundle bundleCall = contentProviderClientAcquireContentProviderClient.call("getOAID", null, null);
            contentProviderClientAcquireContentProviderClient.close();
            if (bundleCall == null) {
                throw new OAIDException("OAID query failed: bundle is null");
            }
            String string = bundleCall.getInt("code", -1) == 0 ? bundleCall.getString("id") : null;
            if (string == null || string.length() == 0) {
                throw new OAIDException("OAID query failed: " + bundleCall.getString("message"));
            }
            dddssad.a("OAID query success: " + string);
            ddakdVar.a(string);
        } catch (Throwable th) {
            dddssad.a(th);
            ddakdVar.b(th);
        }
    }
}

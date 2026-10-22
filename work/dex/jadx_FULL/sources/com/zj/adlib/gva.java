package com.zj.adlib;

import android.annotation.SuppressLint;
import android.content.ContentProviderClient;
import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import com.bwt.top.cn_oaid.OAIDException;
import com.bwt.top.cn_oaid.ddksa;
import com.bwt.top.cn_oaid.dkkd;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_10_7392cls.dex */
public class gva implements dkkd {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Context f41996a;

    public gva(Context context) {
        this.f41996a = context;
    }

    @Override // com.bwt.top.cn_oaid.dkkd
    @SuppressLint({"AnnotateVersionCheck"})
    public boolean a() {
        return true;
    }

    @Override // com.bwt.top.cn_oaid.dkkd
    public void b(ddksa ddksaVar) {
        if (this.f41996a == null || ddksaVar == null) {
            return;
        }
        if (!a()) {
            ija.a("Only supports Android 10.0 and above for Nubia");
            ddksaVar.b(new OAIDException("Only supports Android 10.0 and above for Nubia"));
            return;
        }
        try {
            ContentProviderClient contentProviderClientAcquireContentProviderClient = this.f41996a.getContentResolver().acquireContentProviderClient(Uri.parse("content://cn.nubia.identity/identity"));
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
            ija.a("OAID query success: " + string);
            ddksaVar.a(string);
        } catch (Exception e) {
            ija.a(e);
            ddksaVar.b(e);
        }
    }
}

package com.beizi.fusion;

import android.content.ContentProviderClient;
import android.content.Context;
import android.net.Uri;
import android.os.Bundle;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_10_7392cls.dex */
public class nj {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private Context f27563a;

    public nj(Context context) {
        this.f27563a = context;
    }

    public String a() {
        try {
            ContentProviderClient contentProviderClientAcquireContentProviderClient = this.f27563a.getContentResolver().acquireContentProviderClient(Uri.parse("content://cn.nubia.identity/identity"));
            Bundle bundleCall = contentProviderClientAcquireContentProviderClient.call("getOAID", null, null);
            contentProviderClientAcquireContentProviderClient.close();
            if (bundleCall.getInt("code", -1) == 0) {
                return bundleCall.getString("id");
            }
            bundleCall.getString("message");
            return null;
        } catch (Exception e) {
            om.a(e);
            return null;
        }
    }
}

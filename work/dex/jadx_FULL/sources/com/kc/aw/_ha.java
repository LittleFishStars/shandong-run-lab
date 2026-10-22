package com.kc.aw;

import android.content.ContentProviderClient;
import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import com.qihoo.SdkProtected.OSETSDK.Keep;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
@Keep
public final class _ha implements _ek {
    public Context _a;

    public _ha(Context context) {
        this._a = context;
    }

    @Override // com.kc.aw._ek
    public final void _a(_a3 _a3Var) {
        String string;
        try {
            ContentProviderClient contentProviderClientAcquireContentProviderClient = this._a.getContentResolver().acquireContentProviderClient(Uri.parse("content://cn.nubia.identity/identity"));
            Bundle bundleCall = contentProviderClientAcquireContentProviderClient.call("getOAID", null, null);
            contentProviderClientAcquireContentProviderClient.close();
            string = bundleCall.getInt("code", -1) == 0 ? bundleCall.getString("id") : "";
        } catch (Throwable th) {
            th.printStackTrace();
        }
        if (_a3Var != null) {
            _a3Var._a(string);
        }
    }
}

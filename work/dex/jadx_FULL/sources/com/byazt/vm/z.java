package com.byazt.vm;

import android.content.ContentProviderClient;
import android.content.Context;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.text.TextUtils;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_11_8719cls.dex */
@com.byazt.zqa.c(c = {0, 1, 165, 133})
public final class z implements nu {
    @Override // com.byazt.vm.nu
    public boolean tt(Context context) {
        return Build.VERSION.SDK_INT > 28;
    }

    @Override // com.byazt.vm.nu
    public nu.c ve(Context context) {
        try {
            ContentProviderClient contentProviderClientAcquireContentProviderClient = context.getContentResolver().acquireContentProviderClient(Uri.parse("content://cn.nubia.identity/identity"));
            if (contentProviderClientAcquireContentProviderClient == null) {
                return null;
            }
            Bundle bundleCall = contentProviderClientAcquireContentProviderClient.call("getOAID", null, null);
            contentProviderClientAcquireContentProviderClient.close();
            if (bundleCall == null) {
                return null;
            }
            if (bundleCall.getInt("code", -1) == 0) {
                nu.c cVar = new nu.c();
                cVar.tt = bundleCall.getString("id");
                return cVar;
            }
            String string = bundleCall.getString("message");
            if (!TextUtils.isEmpty(string)) {
                com.byazt.yv.da.tt(string);
            }
            return null;
        } catch (Exception e) {
            com.byazt.yv.da.c(e);
            return null;
        }
    }
}

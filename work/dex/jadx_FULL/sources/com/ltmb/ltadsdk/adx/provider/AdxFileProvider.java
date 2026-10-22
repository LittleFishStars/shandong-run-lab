package com.ltmb.ltadsdk.adx.provider;

import android.app.Application;
import com.ltmb.ltadsdk.core.AdFileProvider;
import com.ltmb.ltadsdk.pkg.d9;
import com.ltmb.ltadsdk.pkg.u6;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_07_1493cls.dex */
public class AdxFileProvider extends AdFileProvider {
    @Override // com.ltmb.ltadsdk.core.AdFileProvider, android.content.ContentProvider
    public boolean onCreate() {
        try {
            d9 d9Var = d9.d;
            Intrinsics.checkNotNullParameter("afilep onCreate", "message");
            d9Var.a("SYAd", "afilep onCreate");
            if (getContext() instanceof Application) {
                u6.n.a((Application) getContext(), true, false);
            }
        } catch (Throwable unused) {
        }
        return true;
    }
}

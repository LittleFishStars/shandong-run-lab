package com.alipay.sdk.m.u0;

import android.database.ContentObserver;
import android.util.Log;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public class d extends ContentObserver {
    public static final String d = "VMS_IDLG_SDK_Observer";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public String f25514a;
    public int b;
    public c c;

    public d(c cVar, int i, String str) {
        super(null);
        this.c = cVar;
        this.b = i;
        this.f25514a = str;
    }

    @Override // android.database.ContentObserver
    public void onChange(boolean z) {
        c cVar = this.c;
        if (cVar != null) {
            cVar.a(this.b, this.f25514a);
        } else {
            Log.e(d, "mIdentifierIdClient is null");
        }
    }
}

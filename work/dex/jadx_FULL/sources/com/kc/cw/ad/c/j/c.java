package com.kc.cw.ad.c.j;

import android.database.ContentObserver;
import com.kc.cw.ad.d.b.f;
import com.qihoo.SdkProtected.OSETSDK.Keep;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
@Keep
public class c extends ContentObserver {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private String f38759a;
    private int b;
    private b c;

    public c(b bVar, int i, String str) {
        super(null);
        this.c = bVar;
        this.b = i;
        this.f38759a = str;
    }

    @Override // android.database.ContentObserver
    public void onChange(boolean z) {
        b bVar = this.c;
        if (bVar != null) {
            bVar.b(this.b, this.f38759a);
        } else {
            f.c("VMS_SDK_Observer", "mIdentifierIdClient is null");
        }
    }
}

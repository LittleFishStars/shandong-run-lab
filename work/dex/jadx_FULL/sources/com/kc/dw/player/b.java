package com.kc.dw.player;

import com.kc.dw.core.safe.j;
import com.qihoo.SdkProtected.OSETSDK.Keep;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
@Keep
public class b extends j {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f39566a;
    public final boolean b;
    public final a.C1092a c;

    public b(a.C1092a c1092a, String str, boolean z) {
        this.c = c1092a;
        this.f39566a = str;
        this.b = z;
    }

    @Override // com.kc.dw.core.safe.j
    public void safeRun() {
        a.b bVar = this.c.f39563a;
        if (bVar != null) {
            bVar.a(this.f39566a, null, this.b);
        }
    }
}

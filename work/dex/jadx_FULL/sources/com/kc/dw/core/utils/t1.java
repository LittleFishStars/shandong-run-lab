package com.kc.dw.core.utils;

import com.qihoo.SdkProtected.OSETSDK.Keep;
import java.io.File;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
@Keep
public class t1 extends com.kc.dw.core.safe.j {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final x1.a f39407a;
    public final String b;
    public final File c;

    public t1(x1.a aVar, String str, File file) {
        this.f39407a = aVar;
        this.b = str;
        this.c = file;
    }

    @Override // com.kc.dw.core.safe.j
    public void safeRun() {
        x1.a aVar = this.f39407a;
        if (aVar != null) {
            aVar.a(this.b, this.c, true);
        }
    }
}

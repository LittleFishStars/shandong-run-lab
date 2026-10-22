package com.kc.cw.ad.internal.d;

import com.qihoo.SdkProtected.OSETSDK.Keep;
import java.io.File;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
@Keep
class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final File f38960a;
    public final com.kc.cw.ad.internal.d.a.c b;
    public final com.kc.cw.ad.internal.d.a.a c;
    public final com.kc.cw.ad.internal.d.b.c d;
    public final f e;

    public c(File file, com.kc.cw.ad.internal.d.a.c cVar, com.kc.cw.ad.internal.d.a.a aVar, com.kc.cw.ad.internal.d.b.c cVar2, f fVar) {
        this.f38960a = file;
        this.b = cVar;
        this.c = aVar;
        this.d = cVar2;
        this.e = fVar;
    }

    public File a(String str) {
        return new File(this.f38960a, this.b.a(str));
    }
}

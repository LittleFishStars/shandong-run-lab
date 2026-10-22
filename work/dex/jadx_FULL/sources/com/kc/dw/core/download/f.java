package com.kc.dw.core.download;

import com.kc.dw.core.safe.j;
import com.qihoo.SdkProtected.OSETSDK.Keep;
import java.util.Iterator;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
@Keep
public class f extends j {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final b f39249a;
    public final d b;

    public f(d dVar, b bVar) {
        this.b = dVar;
        this.f39249a = bVar;
    }

    @Override // com.kc.dw.core.safe.j
    public void safeRun() {
        Iterator<h> it = this.b.e.values().iterator();
        while (it.hasNext()) {
            it.next().b(this.f39249a);
        }
    }
}

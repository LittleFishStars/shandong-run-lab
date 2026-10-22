package com.zj.adlib;

import cn.hzjizhun.admin.base.d;
import cn.hzjizhun.admin.base.g;
import java.util.HashMap;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public final class c8b implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ hyb f40924a;

    public c8b(hyb hybVar) {
        this.f40924a = hybVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        try {
            kha khaVar = new kha();
            m3b.b(khaVar);
            jha.b(khaVar);
            c0b.b(khaVar);
            try {
                rvb rvbVarA = rvb.a();
                khaVar.f42822a = rvbVarA.b;
                khaVar.b = rvbVarA.f19444a;
            } catch (Throwable unused) {
            }
            String strC = g.c(khaVar.b().toString());
            String str = d.b;
            hyb hybVar = this.f40924a;
            HashMap map = new HashMap();
            m3b.c().getClass();
            map.put("User-Agent", m3b.g());
            mib.a().g("POST", str, map, strC, hybVar);
        } catch (Throwable unused2) {
        }
    }
}

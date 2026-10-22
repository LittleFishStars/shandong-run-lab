package com.zj.adlib;

import cn.hzjizhun.admin.base.r1;
import java.util.ArrayList;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public final class xjb extends r1 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ dqb f45834a;

    public xjb(dqb dqbVar) {
        this.f45834a = dqbVar;
    }

    @Override // cn.hzjizhun.admin.base.r1
    public final void b() {
        ira iraVar;
        dqb dqbVar = this.f45834a;
        ArrayList arrayList = dqbVar.f16060a.f20551b;
        if (arrayList != null) {
            try {
                if (!arrayList.isEmpty()) {
                    for (int i = 0; i < arrayList.size(); i++) {
                        String strA = dqb.a((String) arrayList.get(i));
                        mib.e(strA, dqbVar.f16060a, new ngb(new clb(), strA));
                    }
                }
            } catch (Throwable unused) {
            }
        }
        dqb dqbVar2 = this.f45834a;
        ArrayList arrayList2 = dqbVar2.f16060a.f20567j;
        if (arrayList2 != null) {
            try {
                if (arrayList2.isEmpty()) {
                    return;
                }
                for (int i2 = 0; i2 < arrayList2.size() && (iraVar = (ira) arrayList2.get(i2)) != null; i2++) {
                    mib.f(iraVar.f42431a, dqbVar2.f16060a, iraVar.b, new amb());
                }
            } catch (Throwable unused2) {
            }
        }
    }
}

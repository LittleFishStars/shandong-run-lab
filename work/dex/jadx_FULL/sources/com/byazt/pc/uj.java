package com.byazt.pc;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_11_8719cls.dex */
@com.byazt.zqa.c(c = {0, 1, 695, 15})
public class uj extends c {
    @Override // com.byazt.pc.i
    public String c() {
        return "cache_policy";
    }

    @Override // com.byazt.pc.i
    public void c(com.byazt.oz.ve veVar) {
        com.byazt.yj.tt ttVarYp = veVar.yp();
        if (veVar.i()) {
            if (ttVarYp.isMemoryCache()) {
                veVar.c(new da());
                return;
            } else if (ttVarYp.isRawMemoryCache()) {
                veVar.c(new t());
                return;
            } else {
                veVar.c(new u());
                return;
            }
        }
        if (ttVarYp != null) {
            if (ttVarYp.isMemoryCache()) {
                veVar.c(new da());
                return;
            } else if (ttVarYp.isDiskCache()) {
                veVar.c(new a());
                return;
            }
        }
        veVar.c(new sl());
    }
}

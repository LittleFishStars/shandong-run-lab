package com.efs.sdk.memleaksdk.monitor.shark;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_08_10593cls.dex */
public class ad extends ae {
    private String b;

    @Override // com.efs.sdk.memleaksdk.monitor.shark.ae
    public boolean b() {
        ah.a aVar = ah.i;
        if (aVar.e > a().getForceDumpJavaHeapMaxThreshold()) {
            this.b = "high watermark";
            g.d("UMonitor.HugeMem", "match: huge memory allocated detected, high memory watermark, force dump analysis!");
            return true;
        }
        ah.a aVar2 = ah.j;
        if (aVar2.f29647a == 0 || aVar.d - aVar2.d <= ai.b.a(a().getForceDumpJavaHeapDeltaThreshold())) {
            return false;
        }
        this.b = "delta";
        g.d("UMonitor.HugeMem", "match: huge memory allocated detected, over the delta threshold!");
        return true;
    }

    @Override // com.efs.sdk.memleaksdk.monitor.shark.ae
    public String d() {
        return "reason_huge_memory_" + this.b;
    }
}

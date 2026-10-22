package cj.mobile.wm;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public class q8<R> implements n8<R> {
    public final p8.dexa dexa;
    public m8<R> dexb;

    public q8(p8.dexa dexaVar) {
        this.dexa = dexaVar;
    }

    @Override // cj.mobile.wm.n8
    public m8<R> dexa(boolean z, boolean z2) {
        if (z || !z2) {
            return o8.dexb();
        }
        if (this.dexb == null) {
            this.dexb = new p8(this.dexa);
        }
        return this.dexb;
    }
}

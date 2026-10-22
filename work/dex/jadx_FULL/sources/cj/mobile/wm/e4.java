package cj.mobile.wm;

import android.annotation.SuppressLint;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public class e4 extends b9<r2, n3<?>> implements f4 {
    public f4.dexa dexe;

    public e4(int i) {
        super(i);
    }

    @Override // cj.mobile.wm.f4
    @SuppressLint({"InlinedApi"})
    public void a(int i) {
        if (i >= 60) {
            a();
        } else if (i >= 40) {
            dexa(dexa() / 2);
        }
    }

    @Override // cj.mobile.wm.b9
    /* JADX INFO: renamed from: dexa, reason: merged with bridge method [inline-methods] */
    public int dexb(n3<?> n3Var) {
        return n3Var.getSize();
    }

    @Override // cj.mobile.wm.f4
    public /* bridge */ /* synthetic */ n3 dexa(r2 r2Var) {
        return (n3) super.dexc(r2Var);
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // cj.mobile.wm.f4
    public /* bridge */ /* synthetic */ n3 dexa(r2 r2Var, n3 n3Var) {
        return (n3) super.dexb(r2Var, n3Var);
    }

    @Override // cj.mobile.wm.f4
    public void dexa(f4.dexa dexaVar) {
        this.dexe = dexaVar;
    }

    @Override // cj.mobile.wm.b9
    /* JADX INFO: renamed from: dexb, reason: merged with bridge method [inline-methods] */
    public void dexa(r2 r2Var, n3<?> n3Var) {
        f4.dexa dexaVar = this.dexe;
        if (dexaVar != null) {
            dexaVar.dexa(n3Var);
        }
    }
}

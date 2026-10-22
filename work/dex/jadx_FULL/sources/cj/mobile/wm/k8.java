package cj.mobile.wm;

import android.graphics.drawable.Drawable;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public class k8<T extends Drawable> implements n8<T> {
    public final q8<T> dexa;
    public final int dexb;
    public l8<T> dexc;
    public l8<T> dexd;

    public static class dexa implements p8.dexa {
        public final int dexa;

        public dexa(int i) {
            this.dexa = i;
        }
    }

    public k8() {
        this(300);
    }

    public k8(int i) {
        this(new q8(new dexa(i)), i);
    }

    public k8(q8<T> q8Var, int i) {
        this.dexa = q8Var;
        this.dexb = i;
    }

    private m8<T> dexa() {
        if (this.dexc == null) {
            this.dexc = new l8<>(this.dexa.dexa(false, true), this.dexb);
        }
        return this.dexc;
    }

    private m8<T> dexb() {
        if (this.dexd == null) {
            this.dexd = new l8<>(this.dexa.dexa(false, false), this.dexb);
        }
        return this.dexd;
    }

    @Override // cj.mobile.wm.n8
    public m8<T> dexa(boolean z, boolean z2) {
        if (z) {
            return o8.dexb();
        }
        return z2 ? dexa() : dexb();
    }
}

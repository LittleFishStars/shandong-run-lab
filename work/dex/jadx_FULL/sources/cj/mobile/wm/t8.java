package cj.mobile.wm;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public abstract class t8<Z> extends r8<Z> {
    public final int dexb;
    public final int dexc;

    public t8() {
        this(Integer.MIN_VALUE, Integer.MIN_VALUE);
    }

    public t8(int i, int i2) {
        this.dexb = i;
        this.dexc = i2;
    }

    @Override // cj.mobile.wm.v8
    public final void dexa(u8 u8Var) {
        if (e9.dexa(this.dexb, this.dexc)) {
            u8Var.a(this.dexb, this.dexc);
            return;
        }
        throw new IllegalArgumentException("Width and height must both be > 0 or Target#SIZE_ORIGINAL, but given width: " + this.dexb + " and height: " + this.dexc + ", either provide dimensions in the constructor or call override()");
    }
}

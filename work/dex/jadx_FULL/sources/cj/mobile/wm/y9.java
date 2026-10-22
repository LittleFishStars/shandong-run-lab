package cj.mobile.wm;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public class y9 implements ha {
    public int dexa;
    public int dexb;
    public final int dexc;
    public final float dexd;

    public y9() {
        this(2500, 1, 1.0f);
    }

    public y9(int i, int i2, float f) {
        this.dexa = i;
        this.dexc = i2;
        this.dexd = f;
    }

    @Override // cj.mobile.wm.ha
    public int a() {
        return this.dexa;
    }

    @Override // cj.mobile.wm.ha
    public int b() {
        return this.dexb;
    }

    /* JADX INFO: Thrown type has an unknown type hierarchy: com.wangmai.insightvision.openadsdk.j.j.t */
    @Override // cj.mobile.wm.ha
    public void dexa(com.wangmai.insightvision.openadsdk.j.j.t tVar) throws com.wangmai.insightvision.openadsdk.j.j.t {
        this.dexb++;
        int i = this.dexa;
        this.dexa = i + ((int) (i * this.dexd));
        if (!dexa()) {
            throw tVar;
        }
    }

    public boolean dexa() {
        return this.dexb <= this.dexc;
    }
}

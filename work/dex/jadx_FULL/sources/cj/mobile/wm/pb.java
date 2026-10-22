package cj.mobile.wm;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public class pb {
    public static final pb dexc = new pb();
    public rb dexa;
    public boolean dexb = false;

    public static pb dexc() {
        return dexc;
    }

    public rb dexa() {
        dexb();
        rb rbVar = new rb(this.dexb);
        this.dexa = rbVar;
        rbVar.dexa(this.dexb);
        return this.dexa;
    }

    public void dexa(boolean z) {
        this.dexb = z;
    }

    public void dexb() {
        try {
            rb rbVar = this.dexa;
            if (rbVar != null) {
                rbVar.stop();
                this.dexa.dexa();
                this.dexa.d();
                this.dexa = null;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

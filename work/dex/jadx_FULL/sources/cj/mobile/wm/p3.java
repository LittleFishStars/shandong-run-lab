package cj.mobile.wm;

import android.graphics.Bitmap;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public class p3 implements v3 {
    public final dexb dexa = new dexb();
    public final t3<dexa, Bitmap> dexb = new t3<>();

    public static class dexa implements w3 {
        public final dexb dexa;
        public int dexb;
        public int dexc;
        public Bitmap.Config dexd;

        public dexa(dexb dexbVar) {
            this.dexa = dexbVar;
        }

        @Override // cj.mobile.wm.w3
        public void a() {
            this.dexa.dexa(this);
        }

        public void dexa(int i, int i2, Bitmap.Config config) {
            this.dexb = i;
            this.dexc = i2;
            this.dexd = config;
        }

        public boolean equals(Object obj) {
            if (!(obj instanceof dexa)) {
                return false;
            }
            dexa dexaVar = (dexa) obj;
            return this.dexb == dexaVar.dexb && this.dexc == dexaVar.dexc && this.dexd == dexaVar.dexd;
        }

        public int hashCode() {
            int i = ((this.dexb * 31) + this.dexc) * 31;
            Bitmap.Config config = this.dexd;
            return i + (config != null ? config.hashCode() : 0);
        }

        public String toString() {
            return p3.dexd(this.dexb, this.dexc, this.dexd);
        }
    }

    public static class dexb extends q3<dexa> {
        public dexa dexa(int i, int i2, Bitmap.Config config) {
            dexa dexaVarDexb = dexb();
            dexaVarDexb.dexa(i, i2, config);
            return dexaVarDexb;
        }

        @Override // cj.mobile.wm.q3
        /* JADX INFO: renamed from: dexc, reason: merged with bridge method [inline-methods] */
        public dexa dexa() {
            return new dexa(this);
        }
    }

    public static String dexc(Bitmap bitmap) {
        return dexd(bitmap.getWidth(), bitmap.getHeight(), bitmap.getConfig());
    }

    public static String dexd(int i, int i2, Bitmap.Config config) {
        return "[" + i + "x" + i2 + "], " + config;
    }

    @Override // cj.mobile.wm.v3
    public Bitmap a() {
        return this.dexb.dexa();
    }

    @Override // cj.mobile.wm.v3
    public void a(Bitmap bitmap) {
        this.dexb.dexa(this.dexa.dexa(bitmap.getWidth(), bitmap.getHeight(), bitmap.getConfig()), bitmap);
    }

    @Override // cj.mobile.wm.v3
    public Bitmap dexa(int i, int i2, Bitmap.Config config) {
        return this.dexb.dexa(this.dexa.dexa(i, i2, config));
    }

    @Override // cj.mobile.wm.v3
    public String dexa(Bitmap bitmap) {
        return dexc(bitmap);
    }

    @Override // cj.mobile.wm.v3
    public int dexb(Bitmap bitmap) {
        return e9.dexa(bitmap);
    }

    @Override // cj.mobile.wm.v3
    public String dexb(int i, int i2, Bitmap.Config config) {
        return dexd(i, i2, config);
    }

    public String toString() {
        return "AttributeStrategy:\n  " + this.dexb;
    }
}

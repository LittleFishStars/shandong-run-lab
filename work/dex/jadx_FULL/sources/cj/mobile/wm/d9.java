package cj.mobile.wm;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public class d9 {
    public Class<?> dexa;
    public Class<?> dexb;

    public d9() {
    }

    public d9(Class<?> cls, Class<?> cls2) {
        dexa(cls, cls2);
    }

    public void dexa(Class<?> cls, Class<?> cls2) {
        this.dexa = cls;
        this.dexb = cls2;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || d9.class != obj.getClass()) {
            return false;
        }
        d9 d9Var = (d9) obj;
        return this.dexa.equals(d9Var.dexa) && this.dexb.equals(d9Var.dexb);
    }

    public int hashCode() {
        return (this.dexa.hashCode() * 31) + this.dexb.hashCode();
    }

    public String toString() {
        return "MultiClassKey{first=" + this.dexa + ", second=" + this.dexb + '}';
    }
}

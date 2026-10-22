package cj.mobile.wm;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public class p5<T> implements n3<T> {
    public final T dexa;

    public p5(T t) {
        if (t == null) {
            throw new NullPointerException("Data must not be null");
        }
        this.dexa = t;
    }

    @Override // cj.mobile.wm.n3
    public void b() {
    }

    @Override // cj.mobile.wm.n3
    public final T get() {
        return this.dexa;
    }

    @Override // cj.mobile.wm.n3
    public final int getSize() {
        return 1;
    }
}

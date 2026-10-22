package cj.mobile.wm;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public class fa<T> {
    public final T dexa;
    public final w9.dexa dexb;
    public final com.wangmai.insightvision.openadsdk.j.j.t dexc;
    public boolean dexd;

    public interface dexa {
        void dexa(com.wangmai.insightvision.openadsdk.j.j.t tVar);
    }

    public interface dexb<T> {
        void a(T t);
    }

    public fa(com.wangmai.insightvision.openadsdk.j.j.t tVar) {
        this.dexd = false;
        this.dexa = null;
        this.dexb = null;
        this.dexc = tVar;
    }

    public fa(T t, w9.dexa dexaVar) {
        this.dexd = false;
        this.dexa = t;
        this.dexb = dexaVar;
        this.dexc = null;
    }

    public static <T> fa<T> dexa(com.wangmai.insightvision.openadsdk.j.j.t tVar) {
        return new fa<>(tVar);
    }

    public static <T> fa<T> dexa(T t, w9.dexa dexaVar) {
        return new fa<>(t, dexaVar);
    }

    public boolean dexa() {
        return this.dexc == null;
    }
}

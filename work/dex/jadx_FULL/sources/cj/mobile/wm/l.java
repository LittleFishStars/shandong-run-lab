package cj.mobile.wm;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public abstract class l implements l0 {
    public static final ThreadLocal<z> dexa = new ThreadLocal<>();
    public static final ThreadLocal<Character> dexb = new ThreadLocal<>();
    public static final Character dexc = ',';

    public final char dexa(z zVar, Object obj, char c) {
        ThreadLocal<z> threadLocal = dexa;
        threadLocal.set(zVar);
        ThreadLocal<Character> threadLocal2 = dexb;
        threadLocal2.set(Character.valueOf(c));
        dexa(obj);
        threadLocal.set(null);
        return threadLocal2.get().charValue();
    }

    public abstract void dexa(Object obj);
}

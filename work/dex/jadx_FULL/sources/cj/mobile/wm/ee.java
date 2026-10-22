package cj.mobile.wm;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public class ee {
    public static long dexa;

    public static boolean dexa() {
        long jCurrentTimeMillis = System.currentTimeMillis();
        if (jCurrentTimeMillis - dexa < 500) {
            return true;
        }
        dexa = jCurrentTimeMillis;
        return false;
    }
}

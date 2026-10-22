package cj.mobile.wm;

import java.util.List;
import java.util.Vector;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public class t0 {
    public static volatile t0 dexb;
    public final List<c1> dexa = new Vector();

    public static t0 dexa() {
        if (dexb == null) {
            synchronized (t0.class) {
                if (dexb == null) {
                    dexb = new t0();
                }
            }
        }
        return dexb;
    }

    public void dexa(c1 c1Var) {
    }
}

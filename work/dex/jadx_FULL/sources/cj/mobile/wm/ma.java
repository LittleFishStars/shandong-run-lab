package cj.mobile.wm;

import java.util.LinkedHashMap;
import java.util.Map;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public class ma implements w9 {
    public final Map<String, ?> dexa;
    public long dexb;
    public final dexa dexc;
    public final int dexd;

    public interface dexa {
    }

    public ma(dexa dexaVar) {
        this(dexaVar, 5242880);
    }

    public ma(dexa dexaVar, int i) {
        this.dexa = new LinkedHashMap(16, 0.75f, true);
        this.dexb = 0L;
        this.dexc = dexaVar;
        this.dexd = i;
    }
}

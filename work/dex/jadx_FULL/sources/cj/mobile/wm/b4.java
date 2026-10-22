package cj.mobile.wm;

import java.io.File;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public class b4 implements y3.dexa {
    public final int dexa;
    public final dexa dexb;

    public interface dexa {
        File a();
    }

    public b4(dexa dexaVar, int i) {
        this.dexa = i;
        this.dexb = dexaVar;
    }

    @Override // cj.mobile.wm.y3.dexa
    public y3 a() {
        File fileA = this.dexb.a();
        if (fileA == null) {
            return null;
        }
        if (fileA.mkdirs() || (fileA.exists() && fileA.isDirectory())) {
            return c4.dexa(fileA, this.dexa);
        }
        return null;
    }
}

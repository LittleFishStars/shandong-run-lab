package cj.mobile.wm;

import android.util.Log;
import java.io.File;
import java.io.IOException;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public class c4 implements y3 {
    public static c4 dexf;
    public final a4 dexa = new a4();
    public final h4 dexb = new h4();
    public final File dexc;
    public final int dexd;
    public g2 dexe;

    public c4(File file, int i) {
        this.dexc = file;
        this.dexd = i;
    }

    private synchronized g2 dexa() {
        if (this.dexe == null) {
            this.dexe = g2.dexa(this.dexc, 1, 1, this.dexd);
        }
        return this.dexe;
    }

    public static synchronized y3 dexa(File file, int i) {
        if (dexf == null) {
            dexf = new c4(file, i);
        }
        return dexf;
    }

    @Override // cj.mobile.wm.y3
    public File dexa(r2 r2Var) {
        try {
            g2.dexe dexeVarDexb = dexa().dexb(this.dexb.dexa(r2Var));
            if (dexeVarDexb != null) {
                return dexeVarDexb.dexa(0);
            }
        } catch (IOException e) {
            if (Log.isLoggable(com.ipd.dsp.internal.k.e.f, 5)) {
                Log.w(com.ipd.dsp.internal.k.e.f, "Unable to get from disk cache", e);
            }
        }
        return null;
    }

    @Override // cj.mobile.wm.y3
    public void dexa(r2 r2Var, y3.dexb dexbVar) {
        String strDexa = this.dexb.dexa(r2Var);
        this.dexa.dexa(r2Var);
        try {
            try {
                g2.dexc dexcVarDexa = dexa().dexa(strDexa);
                if (dexcVarDexa != null) {
                    try {
                        if (dexbVar.a(dexcVarDexa.dexa(0))) {
                            dexcVarDexa.dexc();
                        }
                        dexcVarDexa.dexb();
                    } catch (Throwable th) {
                        dexcVarDexa.dexb();
                        throw th;
                    }
                }
            } catch (IOException e) {
                if (Log.isLoggable(com.ipd.dsp.internal.k.e.f, 5)) {
                    Log.w(com.ipd.dsp.internal.k.e.f, "Unable to put to disk cache", e);
                }
            }
            this.dexa.dexb(r2Var);
        } catch (Throwable th2) {
            this.dexa.dexb(r2Var);
            throw th2;
        }
    }

    @Override // cj.mobile.wm.y3
    public void dexb(r2 r2Var) {
        try {
            dexa().dexc(this.dexb.dexa(r2Var));
        } catch (IOException e) {
            if (Log.isLoggable(com.ipd.dsp.internal.k.e.f, 5)) {
                Log.w(com.ipd.dsp.internal.k.e.f, "Unable to delete from disk cache", e);
            }
        }
    }
}

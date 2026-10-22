package cj.mobile.wm;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public class m6<T> implements t2<File, T> {
    public static final dexa dexc = new dexa();
    public t2<InputStream, T> dexa;
    public final dexa dexb;

    public static class dexa {
        public InputStream dexa(File file) {
            return new FileInputStream(file);
        }
    }

    public m6(t2<InputStream, T> t2Var) {
        this(t2Var, dexc);
    }

    public m6(t2<InputStream, T> t2Var, dexa dexaVar) {
        this.dexa = t2Var;
        this.dexb = dexaVar;
    }

    @Override // cj.mobile.wm.t2
    public n3<T> dexa(File file, int i, int i2) {
        InputStream inputStreamDexa = null;
        try {
            inputStreamDexa = this.dexb.dexa(file);
            return this.dexa.dexa(inputStreamDexa, i, i2);
        } finally {
            if (inputStreamDexa != null) {
                try {
                    inputStreamDexa.close();
                } catch (IOException unused) {
                }
            }
        }
    }

    @Override // cj.mobile.wm.t2
    public String getId() {
        return "";
    }
}

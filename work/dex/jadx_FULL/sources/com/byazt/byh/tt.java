package com.byazt.byh;

import android.content.Context;
import com.byazt.utw.uj;
import java.io.File;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_11_8719cls.dex */
@com.byazt.zqa.c(c = {0, 1, 791, 13})
public class tt extends c {
    public final File c;

    public void c() {
        com.byazt.nxx.c.c(new Runnable() { // from class: com.byazt.byh.tt.1
            @Override // java.lang.Runnable
            public void run() {
                tt.this.tt();
            }
        });
    }

    public File n(String str) {
        return new File(this.c, str);
    }

    public void tt() {
        com.byazt.utw.ve.c().tt();
        Context context = uj.getContext();
        if (context != null) {
            com.byazt.emg.ve.c(context).c(1);
        }
        for (File file : this.c.listFiles()) {
            try {
                file.delete();
            } catch (Throwable unused) {
            }
        }
    }

    @Override // com.byazt.byh.c
    public File uj(String str) {
        return n(str);
    }

    @Override // com.byazt.byh.c
    public File ve(String str) {
        return n(str);
    }
}

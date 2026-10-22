package com.byazt.fh;

import android.text.TextUtils;
import com.byazt.bwm.sp;
import com.byazt.nr.m;
import com.byazt.nr.x;
import com.byazt.nr.z;
import com.byazt.nr.zb;
import com.byazt.omf.gt;
import java.io.File;
import java.io.IOException;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_11_8719cls.dex */
@com.byazt.zqa.c(c = {0, 1, 505, 46})
public class n {
    public static volatile n c;
    public String tt;
    public AtomicBoolean uj = new AtomicBoolean(false);
    public String ve;

    /* JADX INFO: Access modifiers changed from: private */
    public void n() {
        try {
            String strVe = ve();
            if (tt(strVe)) {
                ve(strVe);
            }
        } catch (Throwable th) {
            m.uj("LocalDrawableResCacheManager", "processUpdate reszip failed：" + th.getMessage());
        }
    }

    public String uj() {
        String strVe = ve();
        String str = this.tt;
        if (str != null && str.equalsIgnoreCase(strVe)) {
            return this.ve;
        }
        String strC = com.byazt.as.ve.c(strVe);
        this.ve = strC;
        this.tt = strVe;
        return strC;
    }

    public String ve() {
        String strW = gt.tt().w();
        return TextUtils.isEmpty(strW) ? "https://sf3-fe-tos.pglstatp-toutiao.com/obj/csj-sdk-static/csj_assets/3f0fb79faf3171023734d003d2a64219-MjAyNjAxMTg.zip" : strW;
    }

    public void tt() {
        new com.byazt.xo.tt(131072).c(new Runnable() { // from class: com.byazt.fh.n.1
            @Override // java.lang.Runnable
            public void run() {
                n.this.n();
            }
        });
    }

    public static n c() {
        if (c == null) {
            synchronized (n.class) {
                if (c == null) {
                    c = new n();
                }
            }
        }
        return c;
    }

    private boolean tt(String str) {
        File[] fileArrListFiles;
        String strTt = com.byazt.nr.a.tt(str);
        if (TextUtils.isEmpty(strTt)) {
            return false;
        }
        File file = new File(z.c(gt.getContext()), strTt);
        return !file.exists() || !file.isDirectory() || (fileArrListFiles = file.listFiles()) == null || fileArrListFiles.length <= 0;
    }

    private void ve(final String str) {
        if (this.uj.get()) {
            return;
        }
        this.uj.set(true);
        com.byazt.bwm.n.tt(new sp("downloadZip") { // from class: com.byazt.fh.n.3
            @Override // java.lang.Runnable
            public void run() {
                n.this.uj(str);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void uj(final String str) {
        final String strTt = com.byazt.nr.a.tt(str);
        if (TextUtils.isEmpty(strTt)) {
            return;
        }
        com.byazt.va.tt ttVarUj = com.byazt.hy.n.c().tt().uj();
        ttVarUj.c(str);
        ttVarUj.c(z.c(gt.getContext()).getAbsolutePath(), strTt + ".temp");
        ttVarUj.c(new com.byazt.mh.c() { // from class: com.byazt.fh.n.4
            @Override // com.byazt.mh.c
            public void c(com.byazt.va.uj ujVar, com.byazt.hm.tt ttVar) {
                n.this.uj.set(false);
                String strTt2 = com.byazt.nr.a.tt(n.this.ve());
                if (TextUtils.isEmpty(strTt2) || strTt2.equalsIgnoreCase(strTt)) {
                    if (!ttVar.i() || ttVar.x() == null || !ttVar.x().exists()) {
                        m.uj("LocalDrawableResCacheManager", "download reszip failed 1：" + str);
                        return;
                    }
                    try {
                        File fileC = z.c(gt.getContext());
                        ttVar.x().getAbsolutePath();
                        File file = new File(fileC.getAbsolutePath(), strTt);
                        if (!file.exists()) {
                            file.mkdirs();
                        }
                        zb.c(ttVar.x().getAbsolutePath(), file.getAbsolutePath());
                        File[] fileArrListFiles = fileC.listFiles();
                        if (fileArrListFiles != null) {
                            for (File file2 : fileArrListFiles) {
                                if (!strTt.equalsIgnoreCase(file2.getName()) || !file2.isDirectory()) {
                                    x.ve(file2);
                                }
                            }
                        }
                    } catch (Throwable th) {
                        m.ve("LocalDrawableResCacheManager", "unzip reszip failed：", th);
                    }
                }
            }

            @Override // com.byazt.mh.c
            public void c(com.byazt.va.uj ujVar, IOException iOException) {
                n.this.uj.set(false);
                m.uj("LocalDrawableResCacheManager", "download resources failed 2：" + str);
            }
        });
    }

    public void c(String str) {
        try {
            String strVe = ve();
            if (TextUtils.isEmpty(str) || str.equalsIgnoreCase(strVe)) {
                return;
            }
            new com.byazt.xo.tt(262144).c(new Runnable() { // from class: com.byazt.fh.n.2
                @Override // java.lang.Runnable
                public void run() {
                    n.this.n();
                }
            });
        } catch (Throwable th) {
            m.uj("LocalDrawableResCacheManager", "doUpdateWhenSetting reszip failed：" + th.getMessage());
        }
    }
}

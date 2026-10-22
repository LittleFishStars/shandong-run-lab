package com.byazt.yi;

import android.os.Bundle;
import android.os.RemoteException;
import com.byazt.bwm.sp;
import com.byazt.bwm.x;
import com.byazt.nr.m;
import com.byazt.omf.gt;
import com.byazt.omf.yp;
import com.byazt.ymw.n;
import com.byazt.ymw.uj;
import java.util.HashMap;
import java.util.concurrent.ExecutorService;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_11_8719cls.dex */
@com.byazt.zqa.c(c = {0, 1, 216, 20})
public class c {
    public static HashMap<Integer, yp> c = new HashMap<>();
    public static final ExecutorService tt = com.byazt.bwm.tt.c(new x("RewardFullCallback"));

    public static void c(final int i, final String str, final String str2, final Bundle bundle) {
        tt.execute(new sp("executeMultiProcessCallback") { // from class: com.byazt.yi.c.1
            @Override // java.lang.Runnable
            public void run() {
                yp ypVarC = c.c.get(Integer.valueOf(i));
                if (ypVarC == null) {
                    ypVarC = yp.c.c(com.byazt.wzi.c.c(gt.getContext()).c(i));
                    c.c.put(Integer.valueOf(i), ypVarC);
                }
                if (ypVarC == null) {
                    return;
                }
                try {
                    int i2 = i;
                    if (i2 == 0) {
                        ypVarC.c(str, str2, bundle);
                    } else if (i2 == 1) {
                        ypVarC.tt(str, str2, bundle);
                    } else {
                        if (i2 != 5) {
                            return;
                        }
                        ypVarC.ve(str, str2, bundle);
                    }
                } catch (RemoteException e) {
                    m.c(e);
                }
            }
        });
    }

    public static void c(final String str, final com.byazt.tn.c cVar) {
        tt.execute(new sp("registerMultiProcessListener") { // from class: com.byazt.yi.c.2
            @Override // java.lang.Runnable
            public void run() {
                com.byazt.wzi.c cVarC = com.byazt.wzi.c.c(gt.getContext());
                if (cVar != null) {
                    n nVar = new n(cVar);
                    yp ypVarC = yp.c.c(cVarC.c(0));
                    if (ypVarC != null) {
                        try {
                            ypVarC.c(str, nVar);
                        } catch (RemoteException e) {
                            m.c(e);
                        }
                    }
                }
            }
        });
    }

    public static void c(final String str, final com.byazt.tn.tt ttVar) {
        tt.execute(new sp("registerMultiProcessListener") { // from class: com.byazt.yi.c.3
            @Override // java.lang.Runnable
            public void run() {
                com.byazt.wzi.c cVarC = com.byazt.wzi.c.c(gt.getContext());
                if (ttVar != null) {
                    uj ujVar = new uj(ttVar);
                    yp ypVarC = yp.c.c(cVarC.c(5));
                    if (ypVarC != null) {
                        try {
                            ypVarC.c(str, ujVar);
                        } catch (RemoteException e) {
                            m.c(e);
                        }
                    }
                }
            }
        });
    }

    public static void c(final String str, final com.byazt.gl.c cVar) {
        tt.execute(new sp("registerMultiProcessListener") { // from class: com.byazt.yi.c.4
            @Override // java.lang.Runnable
            public void run() {
                com.byazt.wzi.c cVarC = com.byazt.wzi.c.c(gt.getContext());
                if (cVar != null) {
                    com.byazt.ymw.ve veVar = new com.byazt.ymw.ve(cVar);
                    yp ypVarC = yp.c.c(cVarC.c(1));
                    if (ypVarC != null) {
                        try {
                            ypVarC.c(str, veVar);
                        } catch (RemoteException e) {
                            m.c(e);
                        }
                    }
                }
            }
        });
    }
}

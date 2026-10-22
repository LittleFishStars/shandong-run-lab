package com.byazt.yih;

import android.text.TextUtils;
import android.util.LruCache;
import com.ali.auth.third.login.LoginConstants;
import com.byazt.aas.nb;
import com.byazt.ete.ic;
import com.byazt.omf.gt;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_11_8719cls.dex */
@com.byazt.zqa.c(c = {0, 1, 730, 20})
public class c {
    public static final LruCache<String, com.byazt.ete.uj> c = new LruCache<>(10);

    public static void c(String str, com.byazt.ete.uj ujVar) {
        if (TextUtils.isEmpty(str) || ujVar == null || !ujVar.sp()) {
            return;
        }
        c.put(str, ujVar);
    }

    public static void tt(final ic icVar) {
        if (ve(icVar) && com.byazt.wz.x.n(icVar)) {
            final String strTt = icVar.z() != null ? icVar.z().tt() : "";
            com.byazt.bzd.x.c(new com.byazt.bwm.sp("preloadAppInfo") { // from class: com.byazt.yih.c.1
                @Override // java.lang.Runnable
                public void run() {
                    gt.c().c(icVar, strTt);
                }
            });
        }
    }

    public static boolean uj(ic icVar) {
        if (icVar == null) {
            return false;
        }
        if (!TextUtils.isEmpty(icVar.z() != null ? icVar.z().tt() : "") && icVar.i() == 4 && TextUtils.isEmpty(icVar.gr())) {
            return (icVar.u_() == null || icVar.u_().tt() == 0) && !nb.tt(nb.p(icVar));
        }
        return false;
    }

    public static boolean ve(ic icVar) {
        return uj(icVar) && com.byazt.wz.x.c(icVar) == 2;
    }

    public static com.byazt.ete.uj c(ic icVar) {
        if (icVar == null) {
            return null;
        }
        String strSy = icVar.sy();
        String strP = nb.p(icVar);
        com.byazt.ete.n nVarZ = icVar.z();
        return c(strSy + LoginConstants.UNDER_LINE + strP + LoginConstants.UNDER_LINE + (nVarZ != null ? nVarZ.tt() : null));
    }

    public static com.byazt.ete.uj c(String str) {
        com.byazt.ete.uj ujVar = c.get(str);
        if (ujVar == null || !ujVar.sp()) {
            return null;
        }
        return ujVar;
    }

    public static void c(com.byazt.ete.c cVar) {
        List<ic> listTt;
        if (cVar == null || (listTt = cVar.tt()) == null || listTt.isEmpty()) {
            return;
        }
        Iterator<ic> it = listTt.iterator();
        while (it.hasNext()) {
            tt(it.next());
        }
    }
}

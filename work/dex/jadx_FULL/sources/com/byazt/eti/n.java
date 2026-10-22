package com.byazt.eti;

import android.text.TextUtils;
import com.byazt.aas.nb;
import com.byazt.ete.ic;
import com.byazt.ete.x;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import org.json.JSONObject;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_11_8719cls.dex */
@com.byazt.zqa.c(c = {0, 1, 384, 46})
public class n {
    public final sp i;
    public static final n c = new n(7);
    public static final n tt = new n(8);
    public static final n ve = new n(3);
    public static final n uj = new n(1);
    public static final n n = new n(5);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final n f28526a = new n(9);
    public static final n sp = new n(6);
    public static final n x = new n(0);

    private n(int i) {
        this.i = new sp(i);
    }

    public static n c(int i) {
        if (i == 1) {
            return uj;
        }
        if (i == 3) {
            return ve;
        }
        switch (i) {
            case 5:
                return n;
            case 6:
                return sp;
            case 7:
                return c;
            case 8:
                return tt;
            case 9:
                return f28526a;
            default:
                return x;
        }
    }

    public long n(String str) {
        sp.tt ttVarC = this.i.c(str, false, 0L);
        if (ttVarC == null || !ttVarC.c()) {
            return 0L;
        }
        long jCurrentTimeMillis = ttVarC.tt - System.currentTimeMillis();
        if (jCurrentTimeMillis <= 0) {
            return 0L;
        }
        return jCurrentTimeMillis / 1000;
    }

    public void tt(String str) {
        this.i.tt(str);
    }

    public boolean uj(String str) {
        return this.i.uj(str);
    }

    public void ve(String str) {
        this.i.ve(str);
    }

    public static void tt(int i) {
        c(i).i.c(i);
    }

    public void c(com.byazt.dj.tt ttVar, ic icVar, boolean z) {
        if (ttVar == null || icVar == null) {
            return;
        }
        ttVar.uj();
        if (x.c(nb.sl(icVar)).c("forbid_save_cache", new x.tt.c().c(ttVar).c(icVar).c())) {
            return;
        }
        if ((icVar.ym() != null ? icVar.ym().optInt("save_type") : 0) == 1) {
            return;
        }
        String strUj = ttVar.uj();
        String strTt = com.byazt.nr.c.tt(icVar.yg().toString());
        long jCurrentTimeMillis = ((((System.currentTimeMillis() / 1000) / 60) / 60) / 3) + ((long) nb.rh(icVar));
        long jUv = icVar.uv();
        int iFq = icVar.fq();
        if (icVar.ul() > 0) {
            jUv = Math.min(jUv, icVar.ul());
        }
        this.i.c(strUj, new sp.tt(strTt, icVar.xg(), jUv * 1000, icVar.sf()), z, jCurrentTimeMillis, iFq);
    }

    public ic c(String str, boolean z, long j) {
        sp.tt ttVarC = this.i.c(str, z, j);
        if (ttVarC == null) {
            return null;
        }
        try {
            JSONObject jSONObject = new JSONObject(com.byazt.nr.c.ve(ttVarC.ve));
            if (x.c(this.i.c.tt()).c("forbid_read_cache", new x.tt.c().c(jSONObject).c())) {
                this.i.c(str, ttVarC.n);
                return null;
            }
            ic icVarC = com.byazt.omf.c.c(jSONObject);
            icVarC.da(true);
            icVarC.sp(ttVarC.c);
            icVarC.p(ttVarC.n);
            icVarC.bn().tt(2);
            return icVarC;
        } catch (Exception unused) {
            return null;
        }
    }

    public List<ic> c(String str, boolean z, long j, int i, double d) {
        System.currentTimeMillis();
        List<sp.tt> listC = this.i.c(str, z, j, i, d);
        if (listC != null && !listC.isEmpty()) {
            listC.size();
            System.currentTimeMillis();
            ArrayList arrayList = new ArrayList();
            for (sp.tt ttVar : listC) {
                try {
                    JSONObject jSONObject = new JSONObject(com.byazt.nr.c.ve(ttVar.ve));
                    if (x.c(this.i.c.tt()).c("forbid_read_cache", new x.tt.c().c(jSONObject).c())) {
                        this.i.c(str, ttVar.n);
                    } else {
                        ic icVarC = com.byazt.omf.c.c(jSONObject);
                        icVarC.da(true);
                        icVarC.sp(ttVar.c);
                        icVarC.p(ttVar.n);
                        icVarC.bn().tt(2);
                        arrayList.add(icVarC);
                    }
                } catch (Exception unused) {
                }
            }
            return arrayList;
        }
        return Collections.emptyList();
    }

    public void c(String str) {
        this.i.c(str);
    }

    public void c(String str, String str2) {
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            return;
        }
        this.i.c(str, str2);
    }

    public void c(String str, String str2, boolean z) {
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            return;
        }
        this.i.c(str, str2, z);
    }

    public void c() {
        this.i.c();
    }

    public static boolean c(ic icVar) {
        if (icVar == null) {
            return false;
        }
        return (icVar.ym() != null ? icVar.ym().optInt("save_type") : 0) != 1;
    }
}

package com.kuaishou.weapon.p0;

import android.content.Context;
import java.util.Date;
import java.util.List;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_06_4659cls.dex */
public class cw {
    private static volatile cw b;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private Context f40101a;

    private cw(Context context) {
        this.f40101a = context;
    }

    public static cw a(Context context) {
        if (b == null) {
            synchronized (cw.class) {
                if (b == null) {
                    b = new cw(context);
                }
            }
        }
        return b;
    }

    public void a(final int i) {
        try {
            h hVarA = h.a(this.f40101a, "re_po_rt");
            final boolean zE = hVarA.e("a1_p_s_p_s");
            final boolean zE2 = hVarA.e("a1_p_s_p_s_c_b");
            if ((zE || zE2) && WeaponHI.as) {
                n.a().a(new Runnable() { // from class: com.kuaishou.weapon.p0.cw.1
                    @Override // java.lang.Runnable
                    public void run() {
                        int i2;
                        try {
                            h hVarA2 = h.a(cw.this.f40101a, "re_po_rt");
                            if (hVarA2.b(dd.o, 0) == 1) {
                                if (zE || zE2) {
                                    long jA = dd.a(cw.this.f40101a).a(dd.bi);
                                    long jCurrentTimeMillis = System.currentTimeMillis();
                                    long jB = ((long) hVarA2.b(dd.p, 8)) * 3600000;
                                    int iB = hVarA2.b(dd.q, 0);
                                    if (jA > 0 && jCurrentTimeMillis - jA < ((long) WeaponHI.ii) * 3600000 && WeaponHI.isList != null) {
                                        int hours = new Date(jCurrentTimeMillis).getHours();
                                        List<Integer> list = WeaponHI.isList;
                                        StringBuilder sb = new StringBuilder();
                                        sb.append(hours);
                                        if (list.contains(sb.toString())) {
                                            return;
                                        }
                                    }
                                    if (jCurrentTimeMillis - jA >= jB || (((i2 = i) == 100 && iB == 1) || i2 == 106)) {
                                        cn.a(cw.this.f40101a, new cg(cw.this.f40101a, i).a(ci.e), ci.e, true, true);
                                    }
                                }
                            }
                        } catch (Throwable unused) {
                        }
                    }
                });
            }
        } catch (Throwable unused) {
        }
    }
}

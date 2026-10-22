package com.kuaishou.weapon.p0;

import android.content.Context;
import java.util.Date;
import java.util.List;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_06_4659cls.dex */
public class cv {
    private static volatile cv b;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private Context f40099a;

    private cv(Context context) {
        this.f40099a = context;
    }

    public static cv a(Context context) {
        if (b == null) {
            synchronized (cv.class) {
                if (b == null) {
                    b = new cv(context);
                }
            }
        }
        return b;
    }

    public void a(final int i) {
        n.a().a(new Runnable() { // from class: com.kuaishou.weapon.p0.cv.1
            @Override // java.lang.Runnable
            public void run() {
                int i2;
                try {
                    h hVarA = h.a(cv.this.f40099a, "re_po_rt");
                    if (hVarA.b(dd.y, 0) == 1) {
                        long jA = dd.a(cv.this.f40099a).a(dd.bh);
                        long jCurrentTimeMillis = System.currentTimeMillis();
                        long jB = ((long) hVarA.b(dd.z, 8)) * 3600000;
                        int iB = hVarA.b(dd.q, 0);
                        if (jA > 0 && jCurrentTimeMillis - jA < ((long) WeaponHI.ii) * 3600000 && WeaponHI.isList != null) {
                            int hours = new Date(jCurrentTimeMillis).getHours();
                            List<Integer> list = WeaponHI.isList;
                            StringBuilder sb = new StringBuilder();
                            sb.append(hours);
                            if (list.contains(sb.toString())) {
                                return;
                            }
                        }
                        if (jCurrentTimeMillis - jA >= jB || (i2 = i) == 106 || (i2 == 100 && iB == 1)) {
                            cn.a(cv.this.f40099a, new cf(cv.this.f40099a, i).a(ci.f40084a), ci.f40084a, false, true);
                        }
                    }
                } catch (Throwable unused) {
                }
            }
        });
    }
}

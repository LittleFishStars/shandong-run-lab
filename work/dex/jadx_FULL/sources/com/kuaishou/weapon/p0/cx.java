package com.kuaishou.weapon.p0;

import android.content.Context;
import java.util.Date;
import java.util.List;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_06_4659cls.dex */
public class cx {
    private static volatile cx b;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private Context f40103a;

    private cx(Context context) {
        this.f40103a = context;
    }

    public static cx a(Context context) {
        if (b == null) {
            synchronized (cx.class) {
                if (b == null) {
                    b = new cx(context);
                }
            }
        }
        return b;
    }

    public void a(final int i) {
        n.a().a(new Runnable() { // from class: com.kuaishou.weapon.p0.cx.1
            @Override // java.lang.Runnable
            public void run() {
                try {
                    h hVarA = h.a(cx.this.f40103a, "re_po_rt");
                    if (hVarA.b(dd.G, 1) == 1) {
                        long jA = dd.a(cx.this.f40103a).a(dd.bm);
                        long jCurrentTimeMillis = System.currentTimeMillis();
                        long jB = ((long) hVarA.b(dd.I, 12)) * 3600000;
                        if (jA > 0 && jCurrentTimeMillis - jA < ((long) WeaponHI.ii) * 3600000 && WeaponHI.isList != null) {
                            int hours = new Date(jCurrentTimeMillis).getHours();
                            List<Integer> list = WeaponHI.isList;
                            StringBuilder sb = new StringBuilder();
                            sb.append(hours);
                            if (list.contains(sb.toString())) {
                                return;
                            }
                        }
                        if (jCurrentTimeMillis - jA >= jB || i == 106) {
                            cn.a(cx.this.f40103a, new ch(cx.this.f40103a).a(ci.h), ci.h, true, true);
                        }
                    }
                } catch (Throwable unused) {
                }
            }
        });
    }
}

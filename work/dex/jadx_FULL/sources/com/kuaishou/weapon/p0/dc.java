package com.kuaishou.weapon.p0;

import android.content.Context;
import com.kc.openset.advertisers.hl.HLADNID;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_06_4659cls.dex */
public class dc {
    private static volatile dc b;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private Context f40116a;

    private dc(Context context) {
        this.f40116a = context;
    }

    public static dc a(Context context) {
        if (b == null) {
            synchronized (dc.class) {
                if (b == null) {
                    b = new dc(context);
                }
            }
        }
        return b;
    }

    public void a(final int i) {
        n.a().a(new Runnable() { // from class: com.kuaishou.weapon.p0.dc.1
            @Override // java.lang.Runnable
            public void run() {
                try {
                    h hVarA = h.a(dc.this.f40116a, "re_po_rt");
                    if (hVarA.b(dd.B, 0) == 1) {
                        long jA = dd.a(dc.this.f40116a).a(dd.bn);
                        long jCurrentTimeMillis = System.currentTimeMillis();
                        if (jCurrentTimeMillis - jA >= ((long) hVarA.b(dd.E, 2)) * 3600000 || i == 106) {
                            try {
                                String strA = new cm(dc.this.f40116a).a(ci.i);
                                int iIntValue = Integer.valueOf(ci.i).intValue();
                                if (strA != null && strA.length() > 10) {
                                    new ba(dc.this.f40116a, strA, iIntValue).a(HLADNID.Reason.OTHER);
                                }
                            } catch (Throwable unused) {
                            }
                            dd.a(dc.this.f40116a).a(dd.bn, jCurrentTimeMillis);
                        }
                    }
                } catch (Throwable unused2) {
                }
            }
        });
    }
}

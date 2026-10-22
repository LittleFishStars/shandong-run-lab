package com.byazt.ouz;

import android.view.View;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_11_8719cls.dex */
@com.byazt.zqa.c(c = {0, 1, 27, 20})
public abstract class c {
    public static c c(final com.byazt.nc.yp ypVar, final com.byazt.ft.tt ttVar) {
        return new c() { // from class: com.byazt.ouz.c.1
            @Override // com.byazt.ouz.c
            public void c(View view, int i) {
                com.byazt.nc.yp ypVar2 = ypVar;
                if (ypVar2 != null) {
                    com.byazt.rgb.tt.ve(ypVar2.getLifecycleId());
                }
                com.byazt.ft.tt ttVar2 = ttVar;
                if (ttVar2 != null) {
                    ttVar2.c(view, i);
                }
            }

            @Override // com.byazt.ouz.c
            public void tt(View view, int i) {
                com.byazt.nc.yp ypVar2 = ypVar;
                if (ypVar2 != null) {
                    com.byazt.rgb.tt.c(ypVar2.getLifecycleId(), false);
                }
                com.byazt.ft.tt ttVar2 = ttVar;
                if (ttVar2 != null) {
                    ttVar2.tt(view, i);
                }
            }

            @Override // com.byazt.ouz.c
            public void c(View view, String str, int i) {
                com.byazt.ft.tt ttVar2 = ttVar;
                if (ttVar2 != null) {
                    ttVar2.c(view, str, i);
                }
            }

            @Override // com.byazt.ouz.c
            public void c(View view, float f, float f2) {
                com.byazt.ft.tt ttVar2 = ttVar;
                if (ttVar2 != null) {
                    ttVar2.c(view, f, f2);
                }
            }
        };
    }

    public void c(View view, float f, float f2) {
    }

    public void c(View view, int i) {
    }

    public void c(View view, String str, int i) {
    }

    public void tt(View view, int i) {
    }

    public static c c(final com.byazt.nc.yp ypVar, final com.byazt.ft.c cVar) {
        return new c() { // from class: com.byazt.ouz.c.2
            @Override // com.byazt.ouz.c
            public void c(View view, int i) {
                com.byazt.nc.yp ypVar2 = ypVar;
                if (ypVar2 != null) {
                    com.byazt.rgb.tt.ve(ypVar2.getLifecycleId());
                }
                com.byazt.ft.c cVar2 = cVar;
                if (cVar2 != null) {
                    cVar2.c(view, i);
                }
            }

            @Override // com.byazt.ouz.c
            public void tt(View view, int i) {
                com.byazt.nc.yp ypVar2 = ypVar;
                if (ypVar2 != null) {
                    com.byazt.rgb.tt.c(ypVar2.getLifecycleId(), false);
                }
                com.byazt.ft.c cVar2 = cVar;
                if (cVar2 != null) {
                    cVar2.tt(view, i);
                }
            }

            @Override // com.byazt.ouz.c
            public void c(View view, String str, int i) {
                com.byazt.ft.c cVar2 = cVar;
                if (cVar2 != null) {
                    cVar2.c(view, str, i);
                }
            }

            @Override // com.byazt.ouz.c
            public void c(View view, float f, float f2) {
                com.byazt.ft.c cVar2 = cVar;
                if (cVar2 != null) {
                    cVar2.c(view, f, f2);
                }
            }
        };
    }
}

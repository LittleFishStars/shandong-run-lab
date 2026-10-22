package com.byazt.mtp;

import com.byazt.ip.x;
import com.byazt.nr.da;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_11_8719cls.dex */
@com.byazt.zqa.c(c = {0, 1, 253, 13})
public class tt extends com.byazt.ip.ve<com.byazt.hi.tt, com.byazt.ha.tt> {

    /* JADX INFO: renamed from: com.byazt.mtp.tt$2, reason: invalid class name */
    @com.byazt.zqa.c(c = {0, 1, 253, 92})
    public static /* synthetic */ class AnonymousClass2 {
        public static final /* synthetic */ int[] c;

        static {
            int[] iArr = new int[com.byazt.hi.tt.values().length];
            c = iArr;
            try {
                iArr[com.byazt.hi.tt.STARTED.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                c[com.byazt.hi.tt.REQED.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                c[com.byazt.hi.tt.RECEIVED.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                c[com.byazt.hi.tt.LOADED.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
        }
    }

    public tt(String str, String str2) {
        this.ve = new com.byazt.ha.tt(str, str2);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void c(final com.byazt.hi.tt ttVar, final x xVar) {
        this.tt = ttVar;
        if (xVar == null) {
            xVar = new x(System.currentTimeMillis());
        }
        da.ve().post(new Runnable() { // from class: com.byazt.mtp.tt.1
            @Override // java.lang.Runnable
            public void run() {
                for (com.byazt.ip.a aVar : tt.this.c) {
                    if (aVar instanceof com.byazt.zyd.tt) {
                        int i = AnonymousClass2.c[ttVar.ordinal()];
                        if (i == 1) {
                            ((com.byazt.zyd.tt) aVar).c(tt.this.getContext(), xVar);
                        } else if (i == 2) {
                            ((com.byazt.zyd.tt) aVar).tt(tt.this.getContext(), xVar);
                        } else if (i == 3) {
                            ((com.byazt.zyd.tt) aVar).ve(tt.this.getContext(), xVar);
                        } else if (i == 4) {
                            ((com.byazt.zyd.tt) aVar).uj(tt.this.getContext(), xVar);
                        }
                    }
                }
            }
        });
    }
}

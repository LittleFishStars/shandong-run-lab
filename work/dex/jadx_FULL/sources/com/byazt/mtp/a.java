package com.byazt.mtp;

import com.byazt.ip.x;
import com.byazt.nr.da;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_11_8719cls.dex */
@com.byazt.zqa.c(c = {0, 1, 253, 34})
public class a extends com.byazt.ip.ve<com.byazt.hi.a, com.byazt.ha.a> {

    /* JADX INFO: renamed from: com.byazt.mtp.a$2, reason: invalid class name */
    @com.byazt.zqa.c(c = {0, 1, 253, 254})
    public static /* synthetic */ class AnonymousClass2 {
        public static final /* synthetic */ int[] c;

        static {
            int[] iArr = new int[com.byazt.hi.a.values().length];
            c = iArr;
            try {
                iArr[com.byazt.hi.a.STARTED.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                c[com.byazt.hi.a.FOREGROUNDED.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                c[com.byazt.hi.a.BACKGROUNDED.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                c[com.byazt.hi.a.END.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
        }
    }

    public a(String str, String str2) {
        this.ve = new com.byazt.ha.a(str, str2);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void c(final com.byazt.hi.a aVar, final x xVar) {
        this.tt = aVar;
        if (xVar == null) {
            xVar = new x(System.currentTimeMillis());
        }
        da.ve().post(new Runnable() { // from class: com.byazt.mtp.a.1
            @Override // java.lang.Runnable
            public void run() {
                for (com.byazt.ip.a aVar2 : a.this.c) {
                    if (aVar2 instanceof com.byazt.zyd.a) {
                        int i = AnonymousClass2.c[aVar.ordinal()];
                        if (i == 1) {
                            ((com.byazt.zyd.a) aVar2).c(a.this.getContext(), xVar);
                        } else if (i == 2) {
                            ((com.byazt.zyd.a) aVar2).tt(a.this.getContext(), xVar);
                        } else if (i == 3) {
                            ((com.byazt.zyd.a) aVar2).ve(a.this.getContext(), xVar);
                        } else if (i == 4) {
                            ((com.byazt.zyd.a) aVar2).uj(a.this.getContext(), xVar);
                        }
                    }
                }
            }
        });
    }
}

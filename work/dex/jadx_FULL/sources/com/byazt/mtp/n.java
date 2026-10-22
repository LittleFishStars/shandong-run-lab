package com.byazt.mtp;

import com.byazt.ip.x;
import com.byazt.nr.da;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_11_8719cls.dex */
@com.byazt.zqa.c(c = {0, 1, 253, 46})
public class n extends com.byazt.ip.ve<com.byazt.hi.n, com.byazt.ha.n> {

    /* JADX INFO: renamed from: com.byazt.mtp.n$2, reason: invalid class name */
    @com.byazt.zqa.c(c = {0, 1, 253, 514})
    public static /* synthetic */ class AnonymousClass2 {
        public static final /* synthetic */ int[] c;

        static {
            int[] iArr = new int[com.byazt.hi.n.values().length];
            c = iArr;
            try {
                iArr[com.byazt.hi.n.CREATED.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                c[com.byazt.hi.n.ATTACHED.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                c[com.byazt.hi.n.FOCUSED.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                c[com.byazt.hi.n.VISIBLED.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                c[com.byazt.hi.n.INVISIBLED.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                c[com.byazt.hi.n.DETACHED.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                c[com.byazt.hi.n.END.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
        }
    }

    public n(String str, String str2) {
        this.ve = new com.byazt.ha.n(str, str2);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void c(final com.byazt.hi.n nVar, final x xVar) {
        this.tt = nVar;
        if (xVar == null) {
            xVar = new x(System.currentTimeMillis());
        }
        da.ve().post(new Runnable() { // from class: com.byazt.mtp.n.1
            @Override // java.lang.Runnable
            public void run() {
                for (com.byazt.ip.a aVar : n.this.c) {
                    if (aVar instanceof com.byazt.zyd.n) {
                        switch (AnonymousClass2.c[nVar.ordinal()]) {
                            case 1:
                                ((com.byazt.zyd.n) aVar).c(n.this.getContext(), xVar);
                                break;
                            case 2:
                                ((com.byazt.zyd.n) aVar).tt(n.this.getContext(), xVar);
                                break;
                            case 3:
                                ((com.byazt.zyd.n) aVar).ve(n.this.getContext(), xVar);
                                break;
                            case 4:
                                ((com.byazt.zyd.n) aVar).uj(n.this.getContext(), xVar);
                                break;
                            case 5:
                                ((com.byazt.zyd.n) aVar).n(n.this.getContext(), xVar);
                                break;
                            case 6:
                                ((com.byazt.zyd.n) aVar).a(n.this.getContext(), xVar);
                                break;
                            case 7:
                                ((com.byazt.zyd.n) aVar).sp(n.this.getContext(), xVar);
                                break;
                        }
                    }
                }
            }
        });
    }
}

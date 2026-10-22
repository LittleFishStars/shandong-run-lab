package com.byazt.mtp;

import com.byazt.ip.x;
import com.byazt.nr.da;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_11_8719cls.dex */
@com.byazt.zqa.c(c = {0, 1, 253, 15})
public class uj extends com.byazt.ip.ve<com.byazt.hi.uj, com.byazt.ha.uj> {

    /* JADX INFO: renamed from: com.byazt.mtp.uj$2, reason: invalid class name */
    @com.byazt.zqa.c(c = {0, 1, 253, 97})
    public static /* synthetic */ class AnonymousClass2 {
        public static final /* synthetic */ int[] c;

        static {
            int[] iArr = new int[com.byazt.hi.uj.values().length];
            c = iArr;
            try {
                iArr[com.byazt.hi.uj.CREATED.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                c[com.byazt.hi.uj.INITIALIZED.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                c[com.byazt.hi.uj.STARTED.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                c[com.byazt.hi.uj.PREPARED.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                c[com.byazt.hi.uj.PLAYED.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                c[com.byazt.hi.uj.BUFFERED.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                c[com.byazt.hi.uj.PAUSED.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                c[com.byazt.hi.uj.STOPPED.ordinal()] = 8;
            } catch (NoSuchFieldError unused8) {
            }
            try {
                c[com.byazt.hi.uj.COMPLETED.ordinal()] = 9;
            } catch (NoSuchFieldError unused9) {
            }
            try {
                c[com.byazt.hi.uj.END.ordinal()] = 10;
            } catch (NoSuchFieldError unused10) {
            }
        }
    }

    public uj(String str, String str2) {
        this.ve = new com.byazt.ha.uj(str, str2);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void c(final com.byazt.hi.uj ujVar, final x xVar) {
        this.tt = ujVar;
        if (xVar == null) {
            xVar = new x(System.currentTimeMillis());
        }
        da.ve().post(new Runnable() { // from class: com.byazt.mtp.uj.1
            @Override // java.lang.Runnable
            public void run() {
                for (com.byazt.ip.a aVar : uj.this.c) {
                    if (aVar instanceof com.byazt.zyd.uj) {
                        switch (AnonymousClass2.c[ujVar.ordinal()]) {
                            case 1:
                                ((com.byazt.zyd.uj) aVar).c(uj.this.getContext(), xVar);
                                break;
                            case 2:
                                ((com.byazt.zyd.uj) aVar).tt(uj.this.getContext(), xVar);
                                break;
                            case 3:
                                ((com.byazt.zyd.uj) aVar).ve(uj.this.getContext(), xVar);
                                break;
                            case 4:
                                ((com.byazt.zyd.uj) aVar).uj(uj.this.getContext(), xVar);
                                break;
                            case 5:
                                ((com.byazt.zyd.uj) aVar).n(uj.this.getContext(), xVar);
                                break;
                            case 6:
                                ((com.byazt.zyd.uj) aVar).a(uj.this.getContext(), xVar);
                                break;
                            case 7:
                                ((com.byazt.zyd.uj) aVar).sp(uj.this.getContext(), xVar);
                                break;
                            case 8:
                                ((com.byazt.zyd.uj) aVar).x(uj.this.getContext(), xVar);
                                break;
                            case 9:
                                ((com.byazt.zyd.uj) aVar).i(uj.this.getContext(), xVar);
                                break;
                            case 10:
                                ((com.byazt.zyd.uj) aVar).da(uj.this.getContext(), xVar);
                                break;
                        }
                    }
                }
            }
        });
    }
}

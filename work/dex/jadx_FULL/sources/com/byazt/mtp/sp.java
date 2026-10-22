package com.byazt.mtp;

import com.byazt.ha.x;
import com.byazt.nr.da;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_11_8719cls.dex */
@com.byazt.zqa.c(c = {0, 1, 253, 91})
public class sp extends com.byazt.ip.ve<com.byazt.hi.sp, x> {

    /* JADX INFO: renamed from: com.byazt.mtp.sp$2, reason: invalid class name */
    @com.byazt.zqa.c(c = {0, 1, 253, 592})
    public static /* synthetic */ class AnonymousClass2 {
        public static final /* synthetic */ int[] c;

        static {
            int[] iArr = new int[com.byazt.hi.sp.values().length];
            c = iArr;
            try {
                iArr[com.byazt.hi.sp.CREATED.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                c[com.byazt.hi.sp.STARTED.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                c[com.byazt.hi.sp.LOADED.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                c[com.byazt.hi.sp.RENDER_STARTED.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                c[com.byazt.hi.sp.RENDERED.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                c[com.byazt.hi.sp.SHOWED.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                c[com.byazt.hi.sp.CLICKED.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                c[com.byazt.hi.sp.END.ordinal()] = 8;
            } catch (NoSuchFieldError unused8) {
            }
        }
    }

    public sp(String str, String str2) {
        this.ve = new x(str, str2);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void c(final com.byazt.hi.sp spVar, final com.byazt.ip.x xVar) {
        this.tt = spVar;
        if (xVar == null) {
            xVar = new com.byazt.ip.x(System.currentTimeMillis());
        }
        da.ve().post(new Runnable() { // from class: com.byazt.mtp.sp.1
            @Override // java.lang.Runnable
            public void run() {
                for (com.byazt.ip.a aVar : sp.this.c) {
                    if (aVar instanceof com.byazt.zyd.sp) {
                        switch (AnonymousClass2.c[spVar.ordinal()]) {
                            case 1:
                                ((com.byazt.zyd.sp) aVar).c(sp.this.getContext(), xVar);
                                break;
                            case 2:
                                ((com.byazt.zyd.sp) aVar).tt(sp.this.getContext(), xVar);
                                break;
                            case 3:
                                ((com.byazt.zyd.sp) aVar).ve(sp.this.getContext(), xVar);
                                break;
                            case 4:
                                ((com.byazt.zyd.sp) aVar).uj(sp.this.getContext(), xVar);
                                break;
                            case 5:
                                ((com.byazt.zyd.sp) aVar).n(sp.this.getContext(), xVar);
                                break;
                            case 6:
                                ((com.byazt.zyd.sp) aVar).a(sp.this.getContext(), xVar);
                                break;
                            case 7:
                                ((com.byazt.zyd.sp) aVar).sp(sp.this.getContext(), xVar);
                                break;
                            case 8:
                                ((com.byazt.zyd.sp) aVar).x(sp.this.getContext(), xVar);
                                break;
                        }
                    }
                }
            }
        });
    }
}

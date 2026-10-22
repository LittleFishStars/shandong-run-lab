package com.byazt.mtp;

import com.byazt.ip.x;
import com.byazt.nr.da;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_11_8719cls.dex */
@com.byazt.zqa.c(c = {0, 1, 253, 54})
public class ve extends com.byazt.ip.ve<com.byazt.hi.ve, com.byazt.ha.ve> {

    /* JADX INFO: renamed from: com.byazt.mtp.ve$2, reason: invalid class name */
    @com.byazt.zqa.c(c = {0, 1, 253, MediaPlayer.MEDIA_PLAYER_OPTION_DROP_AUDIO_COST_TIME})
    public static /* synthetic */ class AnonymousClass2 {
        public static final /* synthetic */ int[] c;

        static {
            int[] iArr = new int[com.byazt.hi.ve.values().length];
            c = iArr;
            try {
                iArr[com.byazt.hi.ve.CREATED.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                c[com.byazt.hi.ve.STARTED.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                c[com.byazt.hi.ve.SHOWED.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                c[com.byazt.hi.ve.VISIBLED.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                c[com.byazt.hi.ve.INVISIBLED.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                c[com.byazt.hi.ve.CLICKED.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                c[com.byazt.hi.ve.END.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
        }
    }

    public ve(String str, String str2) {
        this.ve = new com.byazt.ha.ve(str, str2);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void c(final com.byazt.hi.ve veVar, final x xVar) {
        this.tt = veVar;
        if (xVar == null) {
            xVar = new x(System.currentTimeMillis());
        }
        da.ve().post(new Runnable() { // from class: com.byazt.mtp.ve.1
            @Override // java.lang.Runnable
            public void run() {
                for (com.byazt.ip.a aVar : ve.this.c) {
                    if (aVar instanceof com.byazt.zyd.ve) {
                        switch (AnonymousClass2.c[veVar.ordinal()]) {
                            case 1:
                                ((com.byazt.zyd.ve) aVar).c(ve.this.getContext(), xVar);
                                break;
                            case 2:
                                ((com.byazt.zyd.ve) aVar).tt(ve.this.getContext(), xVar);
                                break;
                            case 3:
                                ((com.byazt.zyd.ve) aVar).ve(ve.this.getContext(), xVar);
                                break;
                            case 4:
                                ((com.byazt.zyd.ve) aVar).uj(ve.this.getContext(), xVar);
                                break;
                            case 5:
                                ((com.byazt.zyd.ve) aVar).n(ve.this.getContext(), xVar);
                                break;
                            case 6:
                                ((com.byazt.zyd.ve) aVar).a(ve.this.getContext(), xVar);
                                break;
                            case 7:
                                ((com.byazt.zyd.ve) aVar).sp(ve.this.getContext(), xVar);
                                break;
                        }
                    }
                }
            }
        });
    }
}

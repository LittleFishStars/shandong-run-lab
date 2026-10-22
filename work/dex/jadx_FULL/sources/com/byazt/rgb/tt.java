package com.byazt.rgb;

import android.text.TextUtils;
import android.util.SparseArray;
import com.byazt.ete.ic;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_11_8719cls.dex */
@com.byazt.zqa.c(c = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_VIDEO_OUTLET_DROPCOUNT_ONCE, 13})
public class tt {
    public static Map<String, SparseArray<Object>> c = new ConcurrentHashMap();

    public static void c(final ic icVar, final com.byazt.dj.tt ttVar, final int i, String str) {
        if (icVar == null || ttVar == null) {
            return;
        }
        com.byazt.lh.ve veVarC = c();
        veVarC.tt(str, ttVar.or());
        veVarC.c(str, new com.byazt.ky.uj());
        if (com.byazt.wi.a.c().c(i)) {
            veVarC.c(str, new com.byazt.wi.uj());
        }
        veVarC.c(str, new com.byazt.ip.uj.c() { // from class: com.byazt.rgb.tt.1
            @Override // com.byazt.ip.uj.c
            public void c(com.byazt.ip.tt ttVar2) {
                if (ttVar2 instanceof com.byazt.ha.ve) {
                    com.byazt.ha.ve veVar = (com.byazt.ha.ve) ttVar2;
                    veVar.i = icVar;
                    com.byazt.dj.tt ttVar3 = ttVar;
                    if (ttVar3 != null) {
                        veVar.sp = i;
                        veVar.x = ttVar3.uj();
                    }
                }
            }
        });
        c(str);
    }

    private static void n(String str) {
        synchronized (c) {
            if (TextUtils.isEmpty(str)) {
                return;
            }
            if (c.get(str) == null) {
                c.put(str, new SparseArray<>());
            }
        }
    }

    public static void tt(String str) {
        com.byazt.lh.ve veVarC = c();
        if (veVarC != null) {
            veVarC.c(str, com.byazt.hi.ve.STARTED);
        }
    }

    public static Object uj(String str, int i) {
        Object obj;
        synchronized (c) {
            n(str);
            obj = c.get(str).get(i);
        }
        return obj;
    }

    public static void ve(String str) {
        com.byazt.lh.ve veVarC = c();
        if (veVarC != null) {
            veVarC.c(str, com.byazt.hi.ve.CLICKED);
        }
    }

    public static void tt(String str, final int i) {
        com.byazt.lh.ve veVarC = c();
        if (veVarC != null) {
            veVarC.c(str, new com.byazt.ip.uj.c() { // from class: com.byazt.rgb.tt.5
                @Override // com.byazt.ip.uj.c
                public void c(com.byazt.ip.tt ttVar) {
                    if (ttVar instanceof com.byazt.ha.ve) {
                        ((com.byazt.ha.ve) ttVar).ve = i;
                    }
                }
            });
            veVarC.c(str, com.byazt.hi.ve.INVISIBLED);
        }
    }

    public static void ve(String str, final int i) {
        com.byazt.lh.ve veVarC = c();
        if (veVarC != null) {
            veVarC.c(str, new com.byazt.ip.uj.c() { // from class: com.byazt.rgb.tt.6
                @Override // com.byazt.ip.uj.c
                public void c(com.byazt.ip.tt ttVar) {
                    if (ttVar instanceof com.byazt.ha.ve) {
                        ((com.byazt.ha.ve) ttVar).tt = i;
                    }
                }
            });
            veVarC.c(str, com.byazt.hi.ve.END);
        }
        if (i == 1 || i == 2) {
            uj.tt(str, i);
        }
    }

    public static void uj(String str) {
        synchronized (c) {
            if (TextUtils.isEmpty(str)) {
                return;
            }
            c.remove(str);
        }
    }

    public static void c(String str) {
        if (c() != null) {
            c().c(str, com.byazt.hi.ve.CREATED);
        }
    }

    public static void c(String str, final boolean z, final boolean z2) {
        com.byazt.lh.ve veVarC = c();
        if (veVarC != null) {
            veVarC.c(str, new com.byazt.ip.uj.c() { // from class: com.byazt.rgb.tt.2
                @Override // com.byazt.ip.uj.c
                public void c(com.byazt.ip.tt ttVar) {
                    if (ttVar instanceof com.byazt.ha.ve) {
                        com.byazt.ha.ve veVar = (com.byazt.ha.ve) ttVar;
                        veVar.uj = z;
                        veVar.n = z2 ? 1 : 0;
                    }
                }
            });
            veVarC.c(str, com.byazt.hi.ve.SHOWED);
        }
    }

    public static void c(String str, final boolean z) {
        com.byazt.lh.ve veVarC = c();
        if (veVarC != null) {
            veVarC.c(str, new com.byazt.ip.uj.c() { // from class: com.byazt.rgb.tt.3
                @Override // com.byazt.ip.uj.c
                public void c(com.byazt.ip.tt ttVar) {
                    if (ttVar instanceof com.byazt.ha.ve) {
                        ((com.byazt.ha.ve) ttVar).uj = z;
                    }
                }
            });
            veVarC.c(str, com.byazt.hi.ve.SHOWED);
        }
    }

    public static void c(String str, final int i) {
        com.byazt.lh.ve veVarC = c();
        if (veVarC != null) {
            veVarC.c(str, new com.byazt.ip.uj.c() { // from class: com.byazt.rgb.tt.4
                @Override // com.byazt.ip.uj.c
                public void c(com.byazt.ip.tt ttVar) {
                    if (ttVar instanceof com.byazt.ha.ve) {
                        ((com.byazt.ha.ve) ttVar).ve = i;
                    }
                }
            });
            veVarC.c(str, com.byazt.hi.ve.VISIBLED);
        }
    }

    public static com.byazt.lh.ve c() {
        return (com.byazt.lh.ve) com.byazt.ip.n.c(1);
    }

    public static void c(String str, int i, Object obj) {
        synchronized (c) {
            n(str);
            c.get(str).put(i, obj);
        }
    }
}

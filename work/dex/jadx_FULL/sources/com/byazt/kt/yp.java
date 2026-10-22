package com.byazt.kt;

import com.huachenjie.base.interact.bean.WorksInteractEventBean;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_11_8719cls.dex */
@com.byazt.zqa.c(c = {0, 1, 166, 215})
public class yp {
    public final com.byazt.kpm.c<RecyclerView.gu, c> c = new com.byazt.kpm.c<>();
    public final com.byazt.kpm.ve<RecyclerView.gu> tt = new com.byazt.kpm.ve<>();

    public interface tt {
        void c(RecyclerView.gu guVar);

        void c(RecyclerView.gu guVar, RecyclerView.a.tt ttVar, RecyclerView.a.tt ttVar2);

        void tt(RecyclerView.gu guVar, RecyclerView.a.tt ttVar, RecyclerView.a.tt ttVar2);

        void ve(RecyclerView.gu guVar, RecyclerView.a.tt ttVar, RecyclerView.a.tt ttVar2);
    }

    public void a(RecyclerView.gu guVar) {
        c cVar = this.c.get(guVar);
        if (cVar != null) {
            cVar.c &= -2;
        }
    }

    public void c() {
        this.c.clear();
        this.tt.ve();
    }

    public void n(RecyclerView.gu guVar) {
        c cVarC = this.c.get(guVar);
        if (cVarC == null) {
            cVarC = c.c();
            this.c.put(guVar, cVarC);
        }
        cVarC.c |= 1;
    }

    public void sp(RecyclerView.gu guVar) {
        for (int iTt = this.tt.tt() - 1; iTt >= 0; iTt--) {
            if (guVar == this.tt.ve(iTt)) {
                this.tt.c(iTt);
                break;
            }
        }
        c cVarRemove = this.c.remove(guVar);
        if (cVarRemove != null) {
            c.c(cVarRemove);
        }
    }

    public RecyclerView.a.tt tt(RecyclerView.gu guVar) {
        return c(guVar, 4);
    }

    public boolean uj(RecyclerView.gu guVar) {
        c cVar = this.c.get(guVar);
        return (cVar == null || (cVar.c & 4) == 0) ? false : true;
    }

    public RecyclerView.a.tt ve(RecyclerView.gu guVar) {
        return c(guVar, 8);
    }

    public void x(RecyclerView.gu guVar) {
        a(guVar);
    }

    @com.byazt.zqa.c(c = {0, 1, 166, WorksInteractEventBean.EVENT_TYPE_COMMENT_ALUMNI_SAY_NOTIFY_UNLIKE})
    public static class c {
        public static com.byazt.kpm.uj.c<c> uj = new com.byazt.kpm.uj.tt(20);
        public int c;
        public RecyclerView.a.tt tt;
        public RecyclerView.a.tt ve;

        private c() {
        }

        public static c c() {
            c cVarC = uj.c();
            return cVarC == null ? new c() : cVarC;
        }

        public static void tt() {
            while (uj.c() != null) {
            }
        }

        public static void c(c cVar) {
            cVar.c = 0;
            cVar.tt = null;
            cVar.ve = null;
            uj.c(cVar);
        }
    }

    public void tt(RecyclerView.gu guVar, RecyclerView.a.tt ttVar) {
        c cVarC = this.c.get(guVar);
        if (cVarC == null) {
            cVarC = c.c();
            this.c.put(guVar, cVarC);
        }
        cVarC.c |= 2;
        cVarC.tt = ttVar;
    }

    public void ve(RecyclerView.gu guVar, RecyclerView.a.tt ttVar) {
        c cVarC = this.c.get(guVar);
        if (cVarC == null) {
            cVarC = c.c();
            this.c.put(guVar, cVarC);
        }
        cVarC.ve = ttVar;
        cVarC.c |= 8;
    }

    public void c(RecyclerView.gu guVar, RecyclerView.a.tt ttVar) {
        c cVarC = this.c.get(guVar);
        if (cVarC == null) {
            cVarC = c.c();
            this.c.put(guVar, cVarC);
        }
        cVarC.tt = ttVar;
        cVarC.c |= 4;
    }

    public void tt() {
        c.tt();
    }

    public boolean c(RecyclerView.gu guVar) {
        c cVar = this.c.get(guVar);
        return (cVar == null || (cVar.c & 1) == 0) ? false : true;
    }

    private RecyclerView.a.tt c(RecyclerView.gu guVar, int i) {
        c cVarTt;
        RecyclerView.a.tt ttVar;
        int iC = this.c.c(guVar);
        if (iC >= 0 && (cVarTt = this.c.tt(iC)) != null) {
            int i2 = cVarTt.c;
            if ((i2 & i) != 0) {
                int i3 = (~i) & i2;
                cVarTt.c = i3;
                if (i == 4) {
                    ttVar = cVarTt.tt;
                } else if (i == 8) {
                    ttVar = cVarTt.ve;
                } else {
                    throw new IllegalArgumentException("Must provide flag PRE or POST");
                }
                if ((i3 & 12) == 0) {
                    this.c.ve(iC);
                    c.c(cVarTt);
                }
                return ttVar;
            }
        }
        return null;
    }

    public void c(long j, RecyclerView.gu guVar) {
        this.tt.tt(j, guVar);
    }

    public RecyclerView.gu c(long j) {
        return this.tt.c(j);
    }

    public void c(tt ttVar) {
        for (int size = this.c.size() - 1; size >= 0; size--) {
            RecyclerView.gu guVarC = this.c.c(size);
            c cVarVe = this.c.ve(size);
            int i = cVarVe.c;
            if ((i & 3) == 3) {
                ttVar.c(guVarC);
            } else if ((i & 1) != 0) {
                RecyclerView.a.tt ttVar2 = cVarVe.tt;
                if (ttVar2 == null) {
                    ttVar.c(guVarC);
                } else {
                    ttVar.c(guVarC, ttVar2, cVarVe.ve);
                }
            } else if ((i & 14) == 14) {
                ttVar.tt(guVarC, cVarVe.tt, cVarVe.ve);
            } else if ((i & 12) == 12) {
                ttVar.ve(guVarC, cVarVe.tt, cVarVe.ve);
            } else if ((i & 4) != 0) {
                ttVar.c(guVarC, cVarVe.tt, null);
            } else if ((i & 8) != 0) {
                ttVar.tt(guVarC, cVarVe.tt, cVarVe.ve);
            }
            c.c(cVarVe);
        }
    }
}

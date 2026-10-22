package com.byazt.kt;

import java.util.List;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_11_8719cls.dex */
@com.byazt.zqa.c(c = {0, 1, 166, 91})
public class sp {
    public final c c;

    public interface c {
        com.byazt.kt.c.tt c(int i, int i2, int i3, Object obj);

        void c(com.byazt.kt.c.tt ttVar);
    }

    public sp(c cVar) {
        this.c = cVar;
    }

    private void ve(List<com.byazt.kt.c.tt> list, int i, com.byazt.kt.c.tt ttVar, int i2, com.byazt.kt.c.tt ttVar2) {
        int i3 = ttVar.uj;
        int i4 = ttVar2.tt;
        int i5 = i3 < i4 ? -1 : 0;
        int i6 = ttVar.tt;
        if (i6 < i4) {
            i5++;
        }
        if (i4 <= i6) {
            ttVar.tt = i6 + ttVar2.uj;
        }
        int i7 = ttVar2.tt;
        if (i7 <= i3) {
            ttVar.uj = i3 + ttVar2.uj;
        }
        ttVar2.tt = i7 + i5;
        list.set(i, ttVar2);
        list.set(i2, ttVar);
    }

    public void c(List<com.byazt.kt.c.tt> list) {
        while (true) {
            int iTt = tt(list);
            if (iTt == -1) {
                return;
            } else {
                c(list, iTt, iTt + 1);
            }
        }
    }

    /* JADX WARN: Code duplicated, block: B:11:0x0027  */
    /* JADX WARN: Code duplicated, block: B:12:0x002b  */
    /* JADX WARN: Code duplicated, block: B:14:0x0031  */
    /* JADX WARN: Code duplicated, block: B:17:0x0048  */
    /* JADX WARN: Code duplicated, block: B:18:0x004c  */
    /* JADX WARN: Code duplicated, block: B:20:0x0056  */
    /* JADX WARN: Code duplicated, block: B:22:0x005b  */
    /* JADX WARN: Code duplicated, block: B:24:? A[RETURN, SYNTHETIC] */
    public void tt(List<com.byazt.kt.c.tt> list, int i, com.byazt.kt.c.tt ttVar, int i2, com.byazt.kt.c.tt ttVar2) {
        com.byazt.kt.c.tt ttVarC;
        int i3;
        int i4;
        int i5;
        int i6 = ttVar.uj;
        int i7 = ttVar2.tt;
        com.byazt.kt.c.tt ttVarC2 = null;
        if (i6 >= i7) {
            int i8 = ttVar2.uj;
            if (i6 < i7 + i8) {
                ttVar2.uj = i8 - 1;
                ttVarC = this.c.c(4, ttVar.tt, 1, ttVar2.ve);
            }
            i3 = ttVar.tt;
            i4 = ttVar2.tt;
            if (i3 <= i4) {
                ttVar2.tt = i4 + 1;
            } else {
                i5 = ttVar2.uj;
                if (i3 < i4 + i5) {
                    int i9 = (i4 + i5) - i3;
                    ttVarC2 = this.c.c(4, i3 + 1, i9, ttVar2.ve);
                    ttVar2.uj -= i9;
                }
            }
            list.set(i2, ttVar);
            if (ttVar2.uj > 0) {
                list.set(i, ttVar2);
            } else {
                list.remove(i);
                this.c.c(ttVar2);
            }
            if (ttVarC != null) {
                list.add(i, ttVarC);
            }
            if (ttVarC2 != null) {
                list.add(i, ttVarC2);
            }
        }
        ttVar2.tt = i7 - 1;
        ttVarC = null;
        i3 = ttVar.tt;
        i4 = ttVar2.tt;
        if (i3 <= i4) {
            ttVar2.tt = i4 + 1;
        } else {
            i5 = ttVar2.uj;
            if (i3 < i4 + i5) {
                int i10 = (i4 + i5) - i3;
                ttVarC2 = this.c.c(4, i3 + 1, i10, ttVar2.ve);
                ttVar2.uj -= i10;
            }
        }
        list.set(i2, ttVar);
        if (ttVar2.uj > 0) {
            list.set(i, ttVar2);
        } else {
            list.remove(i);
            this.c.c(ttVar2);
        }
        if (ttVarC != null) {
            list.add(i, ttVarC);
        }
        if (ttVarC2 != null) {
            list.add(i, ttVarC2);
        }
    }

    private void c(List<com.byazt.kt.c.tt> list, int i, int i2) {
        com.byazt.kt.c.tt ttVar = list.get(i);
        com.byazt.kt.c.tt ttVar2 = list.get(i2);
        int i3 = ttVar2.c;
        if (i3 == 1) {
            ve(list, i, ttVar, i2, ttVar2);
        } else if (i3 == 2) {
            c(list, i, ttVar, i2, ttVar2);
        } else {
            if (i3 != 4) {
                return;
            }
            tt(list, i, ttVar, i2, ttVar2);
        }
    }

    public void c(List<com.byazt.kt.c.tt> list, int i, com.byazt.kt.c.tt ttVar, int i2, com.byazt.kt.c.tt ttVar2) {
        boolean z;
        int i3 = ttVar.tt;
        int i4 = ttVar.uj;
        boolean z2 = false;
        if (i3 < i4) {
            if (ttVar2.tt == i3 && ttVar2.uj == i4 - i3) {
                z = false;
                z2 = true;
            } else {
                z = false;
            }
        } else if (ttVar2.tt == i4 + 1 && ttVar2.uj == i3 - i4) {
            z = true;
            z2 = true;
        } else {
            z = true;
        }
        int i5 = ttVar2.tt;
        if (i4 < i5) {
            ttVar2.tt = i5 - 1;
        } else {
            int i6 = ttVar2.uj;
            if (i4 < i5 + i6) {
                ttVar2.uj = i6 - 1;
                ttVar.c = 2;
                ttVar.uj = 1;
                if (ttVar2.uj == 0) {
                    list.remove(i2);
                    this.c.c(ttVar2);
                    return;
                }
                return;
            }
        }
        int i7 = ttVar.tt;
        int i8 = ttVar2.tt;
        com.byazt.kt.c.tt ttVarC = null;
        if (i7 <= i8) {
            ttVar2.tt = i8 + 1;
        } else {
            int i9 = ttVar2.uj;
            if (i7 < i8 + i9) {
                ttVarC = this.c.c(2, i7 + 1, (i8 + i9) - i7, null);
                ttVar2.uj = ttVar.tt - ttVar2.tt;
            }
        }
        if (z2) {
            list.set(i, ttVar2);
            list.remove(i2);
            this.c.c(ttVar);
            return;
        }
        if (z) {
            if (ttVarC != null) {
                int i10 = ttVar.tt;
                if (i10 > ttVarC.tt) {
                    ttVar.tt = i10 - ttVarC.uj;
                }
                int i11 = ttVar.uj;
                if (i11 > ttVarC.tt) {
                    ttVar.uj = i11 - ttVarC.uj;
                }
            }
            int i12 = ttVar.tt;
            if (i12 > ttVar2.tt) {
                ttVar.tt = i12 - ttVar2.uj;
            }
            int i13 = ttVar.uj;
            if (i13 > ttVar2.tt) {
                ttVar.uj = i13 - ttVar2.uj;
            }
        } else {
            if (ttVarC != null) {
                int i14 = ttVar.tt;
                if (i14 >= ttVarC.tt) {
                    ttVar.tt = i14 - ttVarC.uj;
                }
                int i15 = ttVar.uj;
                if (i15 >= ttVarC.tt) {
                    ttVar.uj = i15 - ttVarC.uj;
                }
            }
            int i16 = ttVar.tt;
            if (i16 >= ttVar2.tt) {
                ttVar.tt = i16 - ttVar2.uj;
            }
            int i17 = ttVar.uj;
            if (i17 >= ttVar2.tt) {
                ttVar.uj = i17 - ttVar2.uj;
            }
        }
        list.set(i, ttVar2);
        if (ttVar.tt != ttVar.uj) {
            list.set(i2, ttVar);
        } else {
            list.remove(i2);
        }
        if (ttVarC != null) {
            list.add(i, ttVarC);
        }
    }

    private int tt(List<com.byazt.kt.c.tt> list) {
        boolean z = false;
        for (int size = list.size() - 1; size >= 0; size--) {
            if (list.get(size).c != 8) {
                z = true;
            } else if (z) {
                return size;
            }
        }
        return -1;
    }
}

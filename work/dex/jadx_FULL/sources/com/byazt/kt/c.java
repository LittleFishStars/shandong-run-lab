package com.byazt.kt;

import com.beizi.fusion.widget.ScrollClickView;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_11_8719cls.dex */
@com.byazt.zqa.c(c = {0, 1, 166, 20})
public class c implements sp.c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final sp f28746a;
    public final ArrayList<tt> c;
    public final boolean n;
    public com.byazt.kpm.uj.c<tt> sp;
    public final ArrayList<tt> tt;
    public Runnable uj;
    public final InterfaceC0456c ve;
    public int x;

    /* JADX INFO: renamed from: com.byazt.kt.c$c, reason: collision with other inner class name */
    public interface InterfaceC0456c {
        RecyclerView.gu c(int i);

        void c(int i, int i2);

        void c(int i, int i2, Object obj);

        void tt(int i, int i2);

        void uj(int i, int i2);

        void ve(int i, int i2);
    }

    @com.byazt.zqa.c(c = {0, 1, 166, MediaPlayer.MEDIA_PLAYER_OPTION_ABR_AVERAGE_PLAY_SPEED})
    public static class tt {
        public int c;
        public int tt;
        public int uj;
        public Object ve;

        public tt(int i, int i2, int i3, Object obj) {
            this.c = i;
            this.tt = i2;
            this.uj = i3;
            this.ve = obj;
        }

        public String c() {
            int i = this.c;
            if (i == 1) {
                return "add";
            }
            if (i == 2) {
                return com.kuaishou.weapon.p0.t.w;
            }
            if (i != 4) {
                return i != 8 ? "??" : "mv";
            }
            return ScrollClickView.DIR_UP;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj == null || getClass() != obj.getClass()) {
                return false;
            }
            tt ttVar = (tt) obj;
            int i = this.c;
            if (i != ttVar.c) {
                return false;
            }
            if (i == 8 && Math.abs(this.uj - this.tt) == 1 && this.uj == ttVar.tt && this.tt == ttVar.uj) {
                return true;
            }
            if (this.uj != ttVar.uj || this.tt != ttVar.tt) {
                return false;
            }
            Object obj2 = this.ve;
            if (obj2 != null) {
                if (!obj2.equals(ttVar.ve)) {
                    return false;
                }
            } else if (ttVar.ve != null) {
                return false;
            }
            return true;
        }

        public int hashCode() {
            return (((this.c * 31) + this.tt) * 31) + this.uj;
        }

        public String toString() {
            return Integer.toHexString(System.identityHashCode(this)) + "[" + c() + ",s:" + this.tt + "c:" + this.uj + ",p:" + this.ve + "]";
        }
    }

    public c(InterfaceC0456c interfaceC0456c) {
        this(interfaceC0456c, false);
    }

    private void a(tt ttVar) {
        sp(ttVar);
    }

    private void n(tt ttVar) {
        int i;
        int i2 = ttVar.c;
        if (i2 == 1 || i2 == 8) {
            throw new IllegalArgumentException("should not dispatch add or move for pre layout");
        }
        int iTt = tt(ttVar.tt, i2);
        int i3 = ttVar.tt;
        int i4 = ttVar.c;
        if (i4 == 2) {
            i = 0;
        } else {
            if (i4 != 4) {
                throw new IllegalArgumentException("op should be remove or update.".concat(String.valueOf(ttVar)));
            }
            i = 1;
        }
        int i5 = 1;
        for (int i6 = 1; i6 < ttVar.uj; i6++) {
            int iTt2 = tt(ttVar.tt + (i * i6), ttVar.c);
            int i7 = ttVar.c;
            if (i7 == 2 ? iTt2 == iTt : i7 == 4 && iTt2 == iTt + 1) {
                i5++;
            } else {
                tt ttVarC = c(i7, iTt, i5, ttVar.ve);
                c(ttVarC, i3);
                c(ttVarC);
                if (ttVar.c == 4) {
                    i3 += i5;
                }
                i5 = 1;
                iTt = iTt2;
            }
        }
        Object obj = ttVar.ve;
        c(ttVar);
        if (i5 > 0) {
            tt ttVarC2 = c(ttVar.c, iTt, i5, obj);
            c(ttVarC2, i3);
            c(ttVarC2);
        }
    }

    private void sp(tt ttVar) {
        this.tt.add(ttVar);
        int i = ttVar.c;
        if (i == 1) {
            this.ve.ve(ttVar.tt, ttVar.uj);
            return;
        }
        if (i == 2) {
            this.ve.tt(ttVar.tt, ttVar.uj);
        } else if (i == 4) {
            this.ve.c(ttVar.tt, ttVar.uj, ttVar.ve);
        } else {
            if (i != 8) {
                throw new IllegalArgumentException("Unknown update op type for ".concat(String.valueOf(ttVar)));
            }
            this.ve.uj(ttVar.tt, ttVar.uj);
        }
    }

    private void uj(tt ttVar) {
        int i = ttVar.tt;
        int i2 = ttVar.uj + i;
        int i3 = 0;
        byte b = -1;
        int i4 = i;
        while (i < i2) {
            if (this.ve.c(i) != null || uj(i)) {
                if (b == 0) {
                    n(c(4, i4, i3, ttVar.ve));
                    i4 = i;
                    i3 = 0;
                }
                b = 1;
            } else {
                if (b == 1) {
                    sp(c(4, i4, i3, ttVar.ve));
                    i4 = i;
                    i3 = 0;
                }
                b = 0;
            }
            i3++;
            i++;
        }
        if (i3 != ttVar.uj) {
            Object obj = ttVar.ve;
            c(ttVar);
            ttVar = c(4, i4, i3, obj);
        }
        if (b == 0) {
            n(ttVar);
        } else {
            sp(ttVar);
        }
    }

    public void c() {
        c(this.c);
        c(this.tt);
        this.x = 0;
    }

    public void tt() {
        this.f28746a.c(this.c);
        int size = this.c.size();
        for (int i = 0; i < size; i++) {
            tt ttVar = this.c.get(i);
            int i2 = ttVar.c;
            if (i2 == 1) {
                a(ttVar);
            } else if (i2 == 2) {
                ve(ttVar);
            } else if (i2 == 4) {
                uj(ttVar);
            } else if (i2 == 8) {
                tt(ttVar);
            }
            Runnable runnable = this.uj;
            if (runnable != null) {
                runnable.run();
            }
        }
        this.c.clear();
    }

    public void ve() {
        int size = this.tt.size();
        for (int i = 0; i < size; i++) {
            this.tt.get(i);
        }
        c(this.tt);
        this.x = 0;
    }

    public c(InterfaceC0456c interfaceC0456c, boolean z) {
        this.sp = new com.byazt.kpm.uj.tt(30);
        this.c = new ArrayList<>();
        this.tt = new ArrayList<>();
        this.x = 0;
        this.ve = interfaceC0456c;
        this.n = z;
        this.f28746a = new sp(this);
    }

    public boolean a() {
        return (this.tt.isEmpty() || this.c.isEmpty()) ? false : true;
    }

    public void c(tt ttVar, int i) {
        int i2 = ttVar.c;
        if (i2 == 2) {
            this.ve.c(i, ttVar.uj);
        } else {
            if (i2 == 4) {
                this.ve.c(i, ttVar.uj, ttVar.ve);
                return;
            }
            throw new IllegalArgumentException("only remove and update ops can be dispatched in first pass");
        }
    }

    private void ve(tt ttVar) {
        boolean z;
        byte b;
        int i = ttVar.tt;
        int i2 = ttVar.uj + i;
        byte b2 = -1;
        int i3 = i;
        int i4 = 0;
        while (i3 < i2) {
            if (this.ve.c(i3) != null || uj(i3)) {
                if (b2 == 0) {
                    n(c(2, i, i4, null));
                    z = true;
                } else {
                    z = false;
                }
                b = 1;
            } else {
                if (b2 == 1) {
                    sp(c(2, i, i4, null));
                    z = true;
                } else {
                    z = false;
                }
                b = 0;
            }
            if (z) {
                i3 -= i4;
                i2 -= i4;
                i4 = 1;
            } else {
                i4++;
            }
            i3++;
            b2 = b;
        }
        if (i4 != ttVar.uj) {
            c(ttVar);
            ttVar = c(2, i, i4, null);
        }
        if (b2 == 0) {
            n(ttVar);
        } else {
            sp(ttVar);
        }
    }

    public boolean c(int i) {
        return (i & this.x) != 0;
    }

    public int c(int i, int i2) {
        int size = this.tt.size();
        while (i2 < size) {
            tt ttVar = this.tt.get(i2);
            int i3 = ttVar.c;
            if (i3 == 8) {
                int i4 = ttVar.tt;
                if (i4 == i) {
                    i = ttVar.uj;
                } else {
                    if (i4 < i) {
                        i--;
                    }
                    if (ttVar.uj <= i) {
                        i++;
                    }
                }
            } else {
                int i5 = ttVar.tt;
                if (i5 > i) {
                    continue;
                } else if (i3 == 2) {
                    int i6 = ttVar.uj;
                    if (i < i5 + i6) {
                        return -1;
                    }
                    i -= i6;
                } else if (i3 == 1) {
                    i += ttVar.uj;
                }
            }
            i2++;
        }
        return i;
    }

    private void tt(tt ttVar) {
        sp(ttVar);
    }

    private int tt(int i, int i2) {
        int i3;
        int i4;
        for (int size = this.tt.size() - 1; size >= 0; size--) {
            tt ttVar = this.tt.get(size);
            int i5 = ttVar.c;
            if (i5 == 8) {
                int i6 = ttVar.tt;
                int i7 = ttVar.uj;
                if (i6 < i7) {
                    i4 = i6;
                    i3 = i7;
                } else {
                    i3 = i6;
                    i4 = i7;
                }
                if (i < i4 || i > i3) {
                    if (i < i6) {
                        if (i2 == 1) {
                            ttVar.tt = i6 + 1;
                            ttVar.uj = i7 + 1;
                        } else if (i2 == 2) {
                            ttVar.tt = i6 - 1;
                            ttVar.uj = i7 - 1;
                        }
                    }
                } else if (i4 == i6) {
                    if (i2 == 1) {
                        ttVar.uj = i7 + 1;
                    } else if (i2 == 2) {
                        ttVar.uj = i7 - 1;
                    }
                    i++;
                } else {
                    if (i2 == 1) {
                        ttVar.tt = i6 + 1;
                    } else if (i2 == 2) {
                        ttVar.tt = i6 - 1;
                    }
                    i--;
                }
            } else {
                int i8 = ttVar.tt;
                if (i8 <= i) {
                    if (i5 == 1) {
                        i -= ttVar.uj;
                    } else if (i5 == 2) {
                        i += ttVar.uj;
                    }
                } else if (i2 == 1) {
                    ttVar.tt = i8 + 1;
                } else if (i2 == 2) {
                    ttVar.tt = i8 - 1;
                }
            }
        }
        for (int size2 = this.tt.size() - 1; size2 >= 0; size2--) {
            tt ttVar2 = this.tt.get(size2);
            if (ttVar2.c == 8) {
                int i9 = ttVar2.uj;
                if (i9 == ttVar2.tt || i9 < 0) {
                    this.tt.remove(size2);
                    c(ttVar2);
                }
            } else if (ttVar2.uj <= 0) {
                this.tt.remove(size2);
                c(ttVar2);
            }
        }
        return i;
    }

    private boolean uj(int i) {
        int size = this.tt.size();
        for (int i2 = 0; i2 < size; i2++) {
            tt ttVar = this.tt.get(i2);
            int i3 = ttVar.c;
            if (i3 == 8) {
                if (c(ttVar.uj, i2 + 1) == i) {
                    return true;
                }
            } else if (i3 == 1) {
                int i4 = ttVar.tt;
                int i5 = ttVar.uj + i4;
                while (i4 < i5) {
                    if (c(i4, i2 + 1) == i) {
                        return true;
                    }
                    i4++;
                }
            } else {
                continue;
            }
        }
        return false;
    }

    public boolean c(int i, int i2, Object obj) {
        if (i2 <= 0) {
            return false;
        }
        this.c.add(c(4, i, i2, obj));
        this.x |= 4;
        return this.c.size() == 1;
    }

    public int ve(int i) {
        int size = this.c.size();
        for (int i2 = 0; i2 < size; i2++) {
            tt ttVar = this.c.get(i2);
            int i3 = ttVar.c;
            if (i3 != 1) {
                if (i3 == 2) {
                    int i4 = ttVar.tt;
                    if (i4 <= i) {
                        int i5 = ttVar.uj;
                        if (i4 + i5 > i) {
                            return -1;
                        }
                        i -= i5;
                    } else {
                        continue;
                    }
                } else if (i3 == 8) {
                    int i6 = ttVar.tt;
                    if (i6 == i) {
                        i = ttVar.uj;
                    } else {
                        if (i6 < i) {
                            i--;
                        }
                        if (ttVar.uj <= i) {
                            i++;
                        }
                    }
                }
            } else if (ttVar.tt <= i) {
                i += ttVar.uj;
            }
        }
        return i;
    }

    public void n() {
        ve();
        int size = this.c.size();
        for (int i = 0; i < size; i++) {
            tt ttVar = this.c.get(i);
            int i2 = ttVar.c;
            if (i2 == 1) {
                this.ve.ve(ttVar.tt, ttVar.uj);
            } else if (i2 == 2) {
                this.ve.c(ttVar.tt, ttVar.uj);
            } else if (i2 == 4) {
                this.ve.c(ttVar.tt, ttVar.uj, ttVar.ve);
            } else if (i2 == 8) {
                this.ve.uj(ttVar.tt, ttVar.uj);
            }
            Runnable runnable = this.uj;
            if (runnable != null) {
                runnable.run();
            }
        }
        c(this.c);
        this.x = 0;
    }

    @Override // com.byazt.kt.sp.c
    public tt c(int i, int i2, int i3, Object obj) {
        tt ttVarC = this.sp.c();
        if (ttVarC == null) {
            return new tt(i, i2, i3, obj);
        }
        ttVarC.c = i;
        ttVarC.tt = i2;
        ttVarC.uj = i3;
        ttVarC.ve = obj;
        return ttVarC;
    }

    public boolean uj() {
        return this.c.size() > 0;
    }

    @Override // com.byazt.kt.sp.c
    public void c(tt ttVar) {
        if (this.n) {
            return;
        }
        ttVar.ve = null;
        this.sp.c(ttVar);
    }

    public void c(List<tt> list) {
        int size = list.size();
        for (int i = 0; i < size; i++) {
            c(list.get(i));
        }
        list.clear();
    }

    public int tt(int i) {
        return c(i, 0);
    }
}

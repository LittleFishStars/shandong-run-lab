package com.byazt.du;

import android.text.TextUtils;
import com.alibaba.android.arouter.utils.Consts;
import com.byazt.xl.u;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_11_8719cls.dex */
@com.byazt.zqa.c(c = {0, 1, 441, 46})
public class n {
    public com.byazt.aq.tt c;
    public tt tt;
    public c uj;
    public com.byazt.aq.x ve;

    @com.byazt.zqa.c(c = {0, 1, 441, 151})
    public static class c {
        public float c;
        public float tt;
        public float ve;
    }

    public n(double d, int i, double d2, String str, u uVar) {
        this.tt = new tt(d, i, d2, str, uVar);
    }

    public void c(c cVar) {
        this.uj = cVar;
    }

    public void c() {
        this.tt.c();
    }

    public void c(com.byazt.aq.x xVar, float f, float f2) {
        if (xVar != null) {
            this.ve = xVar;
        }
        com.byazt.aq.x xVar2 = this.ve;
        float fX = xVar2.x();
        float fI = xVar2.i();
        float f3 = TextUtils.equals(xVar2.da().n().p(), "fixed") ? fI : 65536.0f;
        this.tt.c();
        this.tt.ve(xVar2, fX, f3);
        tt.ve veVarC = this.tt.c(xVar2);
        com.byazt.aq.tt ttVar = new com.byazt.aq.tt();
        ttVar.c = f;
        ttVar.tt = f2;
        if (veVarC != null) {
            fX = veVarC.c;
        }
        ttVar.ve = fX;
        if (veVarC != null) {
            fI = veVarC.tt;
        }
        ttVar.uj = fI;
        ttVar.n = "root";
        ttVar.i = 1280.0f;
        ttVar.f28296a = xVar2;
        xVar2.ve(f);
        ttVar.f28296a.uj(ttVar.tt);
        ttVar.f28296a.n(ttVar.ve);
        ttVar.f28296a.a(ttVar.uj);
        com.byazt.aq.tt ttVarC = c(ttVar, 0.0f);
        this.c = ttVarC;
        c(ttVarC);
    }

    public void c(com.byazt.aq.tt ttVar) {
        if (ttVar == null) {
            return;
        }
        ttVar.f28296a.da().getType();
        List<List<com.byazt.aq.tt>> list = ttVar.sp;
        if (list == null || list.size() <= 0) {
            return;
        }
        for (List<com.byazt.aq.tt> list2 : list) {
            if (list2 != null && list2.size() > 0) {
                Iterator<com.byazt.aq.tt> it = list2.iterator();
                while (it.hasNext()) {
                    c(it.next());
                }
            }
        }
    }

    /* JADX WARN: Code duplicated, block: B:137:0x031c  */
    /* JADX WARN: Code duplicated, block: B:36:0x00d1  */
    /* JADX WARN: Code duplicated, block: B:87:0x01ed  */
    public com.byazt.aq.tt c(com.byazt.aq.tt ttVar, float f) {
        float fC;
        float fC2;
        float f2;
        float fC3;
        float fC4;
        com.byazt.aq.tt ttVar2;
        com.byazt.aq.i iVarC;
        float f3;
        com.byazt.aq.i iVar;
        tt.ve veVarC;
        tt.ve veVarC2;
        com.byazt.aq.tt ttVar3 = ttVar;
        com.byazt.aq.x xVar = ttVar3.f28296a;
        if (xVar == null) {
            return ttVar3;
        }
        xVar.rl();
        List<List<com.byazt.aq.x>> listNu = xVar.nu();
        if (listNu == null || listNu.size() <= 0) {
            return ttVar3;
        }
        com.byazt.aq.a aVarN = xVar.da().n();
        float fNu = aVarN.nu();
        float fM = aVarN.m();
        float fYp = aVarN.yp();
        float fZ = aVarN.z();
        float fT = aVarN.t();
        String strSv = aVarN.sv();
        String strAw = aVarN.aw();
        float f4 = ttVar3.c + fZ;
        float f5 = ttVar3.tt + fNu;
        float f6 = fT * 2.0f;
        float f7 = ((ttVar3.ve - fZ) - fM) - f6;
        float f8 = ((ttVar3.uj - fNu) - fYp) - f6;
        com.byazt.aq.i iVar2 = new com.byazt.aq.i(f4, f5);
        if (ttVar3.sp == null) {
            ttVar3.sp = new ArrayList();
        }
        Iterator<List<com.byazt.aq.x>> it = listNu.iterator();
        float f9 = 0.0f;
        while (it.hasNext()) {
            tt.ve veVarC3 = this.tt.c(it.next());
            if (veVarC3 != null) {
                f9 += veVarC3.tt;
            }
        }
        String str = "space-between";
        String str2 = "space-around";
        if (f9 >= f8) {
            fC = 0.0f;
            fC2 = 0.0f;
        } else {
            if (TextUtils.equals(strAw, "center")) {
                fC2 = (f8 - f9) / 2.0f;
            } else if (TextUtils.equals(strAw, "flex-end")) {
                fC2 = f8 - f9;
            } else if (TextUtils.equals(strAw, "space-around")) {
                fC2 = da.c((f8 - f9) / (listNu.size() + 1));
                fC = fC2;
            } else {
                if (!TextUtils.equals(strAw, "space-between") || listNu.size() <= 1) {
                    fC = 0.0f;
                } else {
                    fC = da.c((f8 - f9) / (listNu.size() - 1));
                }
                fC2 = 0.0f;
            }
            fC = 0.0f;
        }
        iVar2.tt += fC2;
        float f10 = f;
        int i = 0;
        while (i < listNu.size()) {
            List<com.byazt.aq.x> list = listNu.get(i);
            i++;
            if (i >= ttVar3.sp.size()) {
                int size = (i - ttVar3.sp.size()) + 1;
                int i2 = 0;
                while (i2 < size) {
                    ttVar3.sp.add(new ArrayList());
                    i2++;
                    size = size;
                    f10 = f10;
                }
            }
            float f11 = f10;
            Iterator<com.byazt.aq.x> it2 = list.iterator();
            float f12 = 0.0f;
            while (true) {
                f2 = fC;
                if (!it2.hasNext()) {
                    break;
                }
                com.byazt.aq.x next = it2.next();
                com.byazt.aq.a aVarN2 = next.da().n();
                String strMd = aVarN2.md();
                Iterator<com.byazt.aq.x> it3 = it2;
                int iB = aVarN2.b();
                if (!TextUtils.equals(strMd, "flex") && iB != 1 && iB != 2 && (veVarC2 = this.tt.c(next)) != null) {
                    f12 += veVarC2.c;
                }
                fC = f2;
                it2 = it3;
            }
            float fMax = Math.max(f7 - f12, 0.0f);
            Iterator<com.byazt.aq.x> it4 = list.iterator();
            float f13 = 0.0f;
            while (it4.hasNext()) {
                com.byazt.aq.x next2 = it4.next();
                com.byazt.aq.a aVarN3 = next2.da().n();
                Iterator<com.byazt.aq.x> it5 = it4;
                if (aVarN3.b() != 1 && aVarN3.b() != 2 && (veVarC = this.tt.c(next2)) != null) {
                    f13 += veVarC.c;
                }
                it4 = it5;
            }
            if (f13 >= f7) {
                fC3 = 0.0f;
                fC4 = 0.0f;
            } else {
                if (TextUtils.equals(strSv, "center")) {
                    fC3 = (f7 - f13) / 2.0f;
                } else if (TextUtils.equals(strSv, "flex-end")) {
                    fC3 = f7 - f13;
                } else if (TextUtils.equals(strSv, str2)) {
                    fC3 = da.c((f7 - f13) / (list.size() + 1));
                    fC4 = fC3;
                } else if (!TextUtils.equals(strSv, str) || list.size() <= 1) {
                    fC3 = 0.0f;
                } else {
                    fC4 = da.c((f7 - f13) / (list.size() - 1.0f));
                    fC3 = 0.0f;
                }
                fC4 = 0.0f;
            }
            iVar2.c += fC3;
            Iterator<com.byazt.aq.x> it6 = list.iterator();
            float fMax2 = 0.0f;
            while (it6.hasNext()) {
                com.byazt.aq.x next3 = it6.next();
                Iterator<com.byazt.aq.x> it7 = it6;
                float f14 = this.tt.c(next3) != null ? this.tt.c(next3).tt : 0.0f;
                com.byazt.aq.a aVarN4 = next3.da().n();
                String str3 = str;
                fMax2 = Math.max(fMax2, (aVarN4.b() == 1 || aVarN4.b() == 2) ? 0.0f : f14);
                it6 = it7;
                str = str3;
            }
            String str4 = str;
            Iterator<com.byazt.aq.x> it8 = list.iterator();
            f10 = f11;
            while (it8.hasNext()) {
                com.byazt.aq.x next4 = it8.next();
                Iterator<com.byazt.aq.x> it9 = it8;
                tt.ve veVarC4 = this.tt.c(next4);
                String str5 = strSv;
                com.byazt.aq.a aVarN5 = next4.da().n();
                float f15 = f10;
                float fBm = aVarN5.bm();
                float f16 = f7;
                float fLo = aVarN5.lo();
                String str6 = str2;
                float fLr = aVarN5.lr();
                float f17 = fC4;
                float fL = aVarN5.l();
                com.byazt.aq.i iVar3 = iVar2;
                float f18 = veVarC4 == null ? 0.0f : veVarC4.c;
                float f19 = veVarC4 == null ? 0.0f : veVarC4.tt;
                com.byazt.aq.x xVar2 = xVar;
                float f20 = TextUtils.equals(xVar.ve(), "root") ? i : f15;
                int i3 = i;
                if (aVarN5.b() == 1) {
                    ttVar2 = ttVar;
                    iVarC = c(ttVar2, aVarN5, (f18 - fLo) - fL, (f19 - fBm) - fLr);
                } else {
                    ttVar2 = ttVar;
                    iVarC = iVar3;
                }
                com.byazt.aq.i iVarC2 = aVarN5.b() == 2 ? c(aVarN5, this.tt.c(this.ve), new tt.ve((f18 - fLo) - fL, (f19 - fBm) - fLr)) : iVarC;
                String strIr = aVarN.ir();
                if (fMax2 <= f19 || TextUtils.equals(strIr, "flex-start")) {
                    f3 = 0.0f;
                } else {
                    strIr.hashCode();
                    if (strIr.equals("center")) {
                        f3 = (fMax2 - f19) / 2.0f;
                    } else if (strIr.equals("flex-end")) {
                        f3 = fMax2 - f19;
                    } else {
                        f3 = 0.0f;
                    }
                }
                com.byazt.aq.tt ttVar4 = new com.byazt.aq.tt();
                ttVar4.c = iVarC2.c + fL;
                ttVar4.tt = iVarC2.tt + fBm + f3;
                ttVar4.ve = (f18 - fLo) - fL;
                ttVar4.uj = (f19 - fBm) - fLr;
                ttVar4.n = ttVar2.n + Consts.DOT + next4.ve();
                ttVar4.x = ttVar2;
                ttVar4.f28296a = next4;
                fMax = fMax;
                ttVar4.i = fMax;
                list = list;
                ttVar4.da = list;
                next4.ve(ttVar4.c);
                ttVar4.f28296a.uj(ttVar4.tt);
                ttVar4.f28296a.n(ttVar4.ve);
                ttVar4.f28296a.a(ttVar4.uj);
                float f21 = f20;
                com.byazt.aq.tt ttVarC = c(ttVar4, f21);
                i = i3;
                ttVar2.sp.get(i).add(ttVarC);
                if (aVarN5.b() == 1) {
                    iVar = iVar3;
                } else if (aVarN5.b() != 2) {
                    iVar = iVar3;
                    iVar.c += f18 + f17;
                } else {
                    iVar = iVar3;
                }
                f10 = f21;
                iVar2 = iVar;
                it8 = it9;
                strSv = str5;
                f7 = f16;
                str2 = str6;
                fC4 = f17;
                xVar = xVar2;
            }
            com.byazt.aq.i iVar4 = iVar2;
            iVar4.c = f4;
            iVar4.tt += fMax2 + f2;
            ttVar3 = ttVar;
            listNu = listNu;
            fC = f2;
            str = str4;
            xVar = xVar;
        }
        return ttVar3;
    }

    private com.byazt.aq.i c(com.byazt.aq.a aVar, tt.ve veVar, tt.ve veVar2) {
        float fDz = aVar.dz();
        float fYf = aVar.yf();
        float fMa = aVar.ma();
        float f = aVar.f();
        boolean zKk = aVar.kk();
        boolean zTx = aVar.tx();
        boolean zV = aVar.v();
        boolean zOs = aVar.os();
        if (!zKk) {
            if (zTx) {
                float f2 = this.uj.c;
                fDz = ((f2 != 0.0f ? Math.min(f2, veVar.c) : veVar.c) - fMa) - veVar2.c;
            } else {
                fDz = 0.0f;
            }
        }
        if (!zV) {
            if (zOs) {
                float f3 = this.uj.tt;
                if (f3 == 0.0f) {
                    f3 = veVar.tt;
                }
                fYf = (f3 - f) - veVar2.tt;
            } else {
                fYf = 0.0f;
            }
        }
        return new com.byazt.aq.i(fDz, fYf);
    }

    private com.byazt.aq.i c(com.byazt.aq.tt ttVar, com.byazt.aq.a aVar, float f, float f2) {
        float f3;
        float f4;
        float f5 = ttVar.c;
        float f6 = ttVar.tt;
        float fDz = aVar.dz();
        float fYf = aVar.yf();
        float fMa = aVar.ma();
        float f7 = aVar.f();
        boolean zKk = aVar.kk();
        boolean zTx = aVar.tx();
        boolean zV = aVar.v();
        boolean zOs = aVar.os();
        String strQ = aVar.q();
        float f8 = ttVar.ve;
        float f9 = ttVar.uj;
        if (TextUtils.equals(strQ, "0")) {
            if (zKk) {
                f5 = ttVar.c + fDz;
            } else if (zTx) {
                f5 = ((ttVar.c + f8) - fMa) - f;
            }
            if (zV) {
                f4 = ttVar.tt;
                f6 = f4 + fYf;
            } else if (zOs) {
                f3 = ttVar.tt;
                f6 = ((f3 + f9) - f7) - f2;
            }
        } else if (TextUtils.equals(strQ, "1")) {
            f5 = ttVar.c + ((f8 - f) / 2.0f);
            if (zV) {
                f4 = ttVar.tt;
                f6 = f4 + fYf;
            } else if (zOs) {
                f3 = ttVar.tt;
                f6 = ((f3 + f9) - f7) - f2;
            }
        } else if (TextUtils.equals(strQ, "2")) {
            f6 = ttVar.tt + ((f9 - f2) / 2.0f);
            if (zKk) {
                f5 = ttVar.c + fDz;
            } else if (zTx) {
                f5 = ((ttVar.c + f8) - fMa) - f;
            }
        } else if (TextUtils.equals(strQ, "3")) {
            f5 = ttVar.c + ((f8 - f) / 2.0f);
            f6 = ttVar.tt + ((f9 - f2) / 2.0f);
        }
        return new com.byazt.aq.i(f5, f6);
    }
}

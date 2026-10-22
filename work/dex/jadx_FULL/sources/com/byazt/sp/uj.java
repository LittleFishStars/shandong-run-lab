package com.byazt.sp;

import com.byazt.nm.a;
import com.byazt.nm.da;
import com.byazt.nm.n;
import com.byazt.nm.sl;
import com.byazt.nm.sp;
import com.byazt.nm.t;
import com.byazt.wn.x;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_11_8719cls.dex */
@com.byazt.zqa.c(c = {0, 1, 91, 15})
public class uj {
    public static com.byazt.db.c c(com.byazt.dv.tt ttVar, com.byazt.db.tt ttVar2) {
        if (ttVar == null) {
            return null;
        }
        int iZ = ttVar.z();
        switch (ttVar.yv()) {
            case 1:
                return new com.byazt.nm.c(ttVar2);
            case 2:
                return new sp(ttVar2);
            case 3:
                return new t(ttVar2);
            case 4:
            case 6:
            default:
                return null;
            case 5:
                if (iZ == 4) {
                    return new da(ttVar2);
                }
                if (iZ == 5) {
                    return new n(ttVar2);
                }
                return iZ == 3 ? new com.byazt.nm.c(ttVar2) : new da(ttVar2);
            case 7:
                if (iZ == 6) {
                    return new sl(ttVar2);
                }
                if (iZ == 7) {
                    return new a(ttVar2);
                }
                return iZ == 8 ? new sp(ttVar2) : new sl(ttVar2);
            case 8:
                return new a(ttVar2);
            case 9:
                return new n(ttVar2);
            case 10:
                if (iZ == 1) {
                    return new sp(ttVar2);
                }
                if (iZ == 2) {
                    return new a(ttVar2);
                }
                return null;
        }
    }

    public static com.byazt.db.c c(String str, com.byazt.dv.tt ttVar, com.byazt.db.tt ttVar2) {
        if (ttVar == null) {
            return null;
        }
        int iZ = ttVar.z();
        switch (ttVar.yv()) {
            case 1:
                return new com.byazt.wn.c(str, ttVar2);
            case 2:
                return new com.byazt.wn.a(str, ttVar2);
            case 3:
                return new x(str, ttVar2);
            case 4:
            case 6:
            default:
                return null;
            case 5:
                if (iZ == 4) {
                    return new com.byazt.wn.uj(str, ttVar2);
                }
                if (iZ == 5) {
                    return new com.byazt.wn.ve(str, ttVar2);
                }
                if (iZ == 3) {
                    return new com.byazt.wn.c(str, ttVar2);
                }
                return new com.byazt.wn.uj(str, ttVar2);
            case 7:
                if (iZ == 6) {
                    return new com.byazt.wn.sp(str, ttVar2);
                }
                if (iZ == 7) {
                    return new com.byazt.wn.n(str, ttVar2);
                }
                if (iZ == 8) {
                    return new com.byazt.wn.a(str, ttVar2);
                }
                return new com.byazt.wn.sp(str, ttVar2);
            case 8:
                return new com.byazt.wn.n(str, ttVar2);
            case 9:
                return new com.byazt.wn.ve(str, ttVar2);
            case 10:
                if (iZ == 1) {
                    return new com.byazt.wn.a(str, ttVar2);
                }
                if (iZ == 2) {
                    return new com.byazt.wn.n(str, ttVar2);
                }
                return null;
        }
    }
}

package cj.mobile.wm;

import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.List;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public class dex16 {
    public final Constructor<?> dexa;
    public final int dexb;
    public final Constructor<?> dexc;
    public final Method dexd;
    public final n0[] dexe;
    public final n0[] dexf;
    public final dex09 dexg;
    public boolean dexh = false;
    public final boolean dexi;
    public final String dexj;
    public final String dexk;
    public final long dexl;
    public final int dexm;
    public final String[] dexn;

    public dex16(Class<?> cls, Constructor<?> constructor, Constructor<?> constructor2, Method method, n0[] n0VarArr, n0[] n0VarArr2, dex09 dex09Var, String[] strArr) {
        int i;
        boolean z;
        int length = 0;
        this.dexa = constructor;
        this.dexc = constructor2;
        this.dexd = method;
        this.dexe = n0VarArr;
        this.dexg = dex09Var;
        if (strArr == null || strArr.length != n0VarArr.length) {
            this.dexn = strArr;
        } else {
            this.dexn = null;
        }
        if (dex09Var != null) {
            String strTypeName = dex09Var.typeName();
            this.dexj = strTypeName.length() <= 0 ? cls.getName() : strTypeName;
            String strTypeKey = dex09Var.typeKey();
            this.dexk = strTypeKey.length() > 0 ? strTypeKey : null;
            i = 0;
            for (com.wangmai.insightvision.openadsdk.d.i.d dVar : dex09Var.parseFeatures()) {
                i |= dVar.t;
            }
        } else {
            this.dexj = cls.getName();
            this.dexk = null;
            i = 0;
        }
        String str = this.dexk;
        this.dexl = str == null ? 0L : q0.dexb(str);
        this.dexm = i;
        if (dex09Var != null) {
            com.wangmai.insightvision.openadsdk.d.i.d[] features = dex09Var.parseFeatures();
            z = false;
            for (com.wangmai.insightvision.openadsdk.d.i.d dVar2 : features) {
                if (dVar2 == com.wangmai.insightvision.openadsdk.d.i.d.n) {
                    z = true;
                }
            }
        } else {
            z = false;
        }
        this.dexi = z;
        n0[] n0VarArrDexa = dexa(n0VarArr, n0VarArr2);
        this.dexf = Arrays.equals(n0VarArr, n0VarArrDexa) ? n0VarArr : n0VarArrDexa;
        if (constructor != null) {
            length = constructor.getParameterTypes().length;
        } else if (method != null) {
            length = method.getParameterTypes().length;
        }
        this.dexb = length;
    }

    /* JADX WARN: Code duplicated, block: B:206:0x045e  */
    /* JADX WARN: Code duplicated, block: B:270:0x0636  */
    /* JADX WARN: Code duplicated, block: B:28:0x006e  */
    /* JADX WARN: Code duplicated, block: B:292:0x06c2  */
    /* JADX WARN: Code duplicated, block: B:294:0x06ca  */
    /* JADX WARN: Code duplicated, block: B:29:0x0075  */
    /* JADX WARN: Code duplicated, block: B:316:0x0709  */
    /* JADX WARN: Code duplicated, block: B:318:0x070d  */
    /* JADX WARN: Code duplicated, block: B:371:0x0811  */
    /* JADX WARN: Code duplicated, block: B:396:0x06cd A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:403:0x0710 A[SYNTHETIC] */
    /*  JADX ERROR: JadxRuntimeException in pass: RegionMakerVisitor
        jadx.core.utils.exceptions.JadxRuntimeException: Not found exit edge by exit block: B:30:0x007d
        	at jadx.core.dex.visitors.regions.maker.LoopRegionMaker.checkLoopExits(LoopRegionMaker.java:272)
        	at jadx.core.dex.visitors.regions.maker.LoopRegionMaker.makeLoopRegion(LoopRegionMaker.java:237)
        	at jadx.core.dex.visitors.regions.maker.LoopRegionMaker.process(LoopRegionMaker.java:80)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:92)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:69)
        	at jadx.core.dex.visitors.regions.maker.IfRegionMaker.process(IfRegionMaker.java:117)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:109)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:69)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeMthRegion(RegionMaker.java:49)
        	at jadx.core.dex.visitors.regions.RegionMakerVisitor.visit(RegionMakerVisitor.java:25)
        */
    public static cj.mobile.wm.dex16 dexa(java.lang.Class<?> r46, int r47, java.lang.reflect.Type r48, boolean r49, boolean r50, boolean r51, boolean r52, com.wangmai.insightvision.openadsdk.d.g r53) {
        /*
            Method dump skipped, instruction units count: 2236
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: cj.mobile.wm.dex16.dexa(java.lang.Class, int, java.lang.reflect.Type, boolean, boolean, boolean, boolean, com.wangmai.insightvision.openadsdk.d.g):cj.mobile.wm.dex16");
    }

    public static boolean dexa(List<n0> list, n0 n0Var, boolean z) {
        if (!z) {
            int size = list.size();
            for (int i = 0; i < size; i++) {
                n0 n0Var2 = list.get(i);
                if (n0Var2.dexa.equals(n0Var.dexa) && (!n0Var2.dexj || n0Var.dexj)) {
                    return false;
                }
            }
        }
        list.add(n0Var);
        return true;
    }

    private n0[] dexa(n0[] n0VarArr, n0[] n0VarArr2) {
        String[] strArrOrders;
        boolean z;
        boolean z2;
        boolean z3;
        boolean z4;
        dex09 dex09Var = this.dexg;
        if (dex09Var != null && (strArrOrders = dex09Var.orders()) != null && strArrOrders.length != 0) {
            int i = 0;
            while (true) {
                if (i >= strArrOrders.length) {
                    z = true;
                    break;
                }
                int i2 = 0;
                while (true) {
                    if (i2 >= n0VarArr2.length) {
                        z4 = false;
                        break;
                    }
                    if (n0VarArr2[i2].dexa.equals(strArrOrders[i])) {
                        z4 = true;
                        break;
                    }
                    i2++;
                }
                if (!z4) {
                    z = false;
                    break;
                }
                i++;
            }
            if (!z) {
                return n0VarArr2;
            }
            if (strArrOrders.length == n0VarArr.length) {
                int i3 = 0;
                while (true) {
                    if (i3 >= strArrOrders.length) {
                        z3 = true;
                        break;
                    }
                    if (!n0VarArr2[i3].dexa.equals(strArrOrders[i3])) {
                        z3 = false;
                        break;
                    }
                    i3++;
                }
                if (z3) {
                    return n0VarArr2;
                }
                n0[] n0VarArr3 = new n0[n0VarArr2.length];
                for (int i4 = 0; i4 < strArrOrders.length; i4++) {
                    for (int i5 = 0; i5 < n0VarArr2.length; i5++) {
                        if (n0VarArr2[i5].dexa.equals(strArrOrders[i4])) {
                            n0VarArr3[i4] = n0VarArr2[i5];
                            break;
                        }
                    }
                }
                this.dexh = true;
                return n0VarArr3;
            }
            int length = n0VarArr2.length;
            n0[] n0VarArr4 = new n0[length];
            for (int i6 = 0; i6 < strArrOrders.length; i6++) {
                for (int i7 = 0; i7 < n0VarArr2.length; i7++) {
                    if (n0VarArr2[i7].dexa.equals(strArrOrders[i6])) {
                        n0VarArr4[i6] = n0VarArr2[i7];
                        break;
                    }
                }
            }
            int length2 = strArrOrders.length;
            for (int i8 = 0; i8 < n0VarArr2.length; i8++) {
                int i9 = 0;
                while (true) {
                    if (i9 >= length || i9 >= length2) {
                        z2 = false;
                        break;
                    }
                    if (n0VarArr4[i8].dexb(n0VarArr2[i9])) {
                        z2 = true;
                        break;
                    }
                    i9++;
                }
                if (!z2) {
                    n0VarArr4[length2] = n0VarArr2[i8];
                    length2++;
                }
            }
            this.dexh = true;
        }
        return n0VarArr2;
    }
}

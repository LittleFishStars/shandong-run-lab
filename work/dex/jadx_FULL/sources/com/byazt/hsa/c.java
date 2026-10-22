package com.byazt.hsa;

import android.util.Pair;
import android.util.SparseArray;
import com.byazt.ut.i;
import com.byazt.ut.sl;
import java.util.Map;
import java.util.function.Function;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_11_8719cls.dex */
@com.byazt.zqa.c(c = {0, 1, 2432, 20})
public class c {
    public final i c;

    public c(i iVar) {
        this.c = iVar;
    }

    public boolean c(sl slVar, Function function) {
        int iC = com.byazt.rj.c.c(function, slVar.f29108a);
        if (iC <= slVar.ve) {
            return false;
        }
        slVar.tt(iC);
        slVar.c(function);
        i iVar = this.c;
        if (iVar == null) {
            return true;
        }
        iVar.c(slVar.f29108a, function, slVar.ve, iC);
        return true;
    }

    public void c(sl slVar, com.byazt.ut.c cVar, Function function) {
        if (slVar.a()) {
            if (!slVar.sp) {
                Object objUj = slVar.uj();
                if (objUj != null) {
                    c(slVar, null, objUj, cVar);
                    return;
                }
                return;
            }
            for (Map.Entry<com.byazt.dna.c, Object> entry : slVar.ve().entrySet()) {
                Object value = entry.getValue();
                if (value != null) {
                    c(slVar, entry.getKey(), value, cVar);
                }
            }
        }
    }

    private void c(sl slVar, com.byazt.dna.c cVar, Object obj, com.byazt.ut.c cVar2) {
        int iC;
        Object obj2;
        Pair<Function, Object> pairC = cVar2.n().c(slVar, cVar);
        if (pairC != null && (iC = com.byazt.rj.c.c((Function) pairC.first, slVar.f29108a)) > slVar.c() && (obj2 = pairC.second) != null && (obj instanceof Function) && (obj2 instanceof Function)) {
            Function function = (Function) obj;
            Function function2 = (Function) obj2;
            if (function.getClass().getClassLoader() == function2.getClass().getClassLoader()) {
                if (this.c != null) {
                    this.c.c(slVar, 3, "source:" + obj + " target:" + function2 + " classloader:" + function.getClass().getClassLoader() + " target classloader:" + function2.getClass().getClassLoader(), (Throwable) null);
                    return;
                }
                return;
            }
            c(function, function2);
            slVar.c(iC);
            i iVar = this.c;
            if (iVar != null) {
                iVar.c(slVar.f29108a, obj, pairC.second, slVar.ve, slVar.n());
            }
            c(function, slVar);
        }
    }

    private boolean c(Function function, sl slVar) {
        Function functionTt = com.byazt.rj.c.tt(function);
        if (functionTt == null) {
            i iVar = this.c;
            if (iVar != null) {
                iVar.c(2, "get origin service impl failed:" + slVar.f29108a, (Throwable) null);
            }
            return false;
        }
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(0, -1);
        functionTt.apply(sparseArray);
        return true;
    }

    private void c(Function function, Function function2) {
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(0, -4);
        sparseArray.put(1, function2);
        function.apply(sparseArray);
    }
}

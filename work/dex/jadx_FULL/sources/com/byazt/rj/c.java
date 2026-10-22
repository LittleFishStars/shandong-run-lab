package com.byazt.rj;

import android.text.TextUtils;
import android.util.SparseArray;
import com.byazt.lk.tt;
import com.byazt.ut.sl;
import com.byazt.ut.uj;
import java.util.function.Function;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_11_8719cls.dex */
@com.byazt.zqa.c(c = {0, 1, 2065, 20})
public class c {
    public final tt c;
    public final com.byazt.ut.c tt;

    public c(tt ttVar, com.byazt.ut.c cVar) {
        this.c = ttVar;
        this.tt = cVar;
    }

    private Object tt(SparseArray sparseArray) {
        Object obj = sparseArray.get(1);
        String str = (String) sparseArray.get(2);
        return this.tt.c((String) obj, !TextUtils.isEmpty(str) ? this.tt.c(str) : null, false);
    }

    private int ve(SparseArray sparseArray) {
        Object obj = sparseArray.get(1);
        if (!(obj instanceof String)) {
            return 0;
        }
        sl slVarC = this.c.c((String) obj);
        if (slVarC == null || !slVarC.n) {
            return -1;
        }
        return slVarC.ve;
    }

    public Object c(SparseArray sparseArray) {
        Object obj = sparseArray.get(0);
        if (!(obj instanceof Integer)) {
            return null;
        }
        int iIntValue = ((Integer) obj).intValue();
        if (iIntValue == 0) {
            this.tt.c(true);
            return null;
        }
        if (iIntValue == 1) {
            return Boolean.valueOf(this.tt.tt());
        }
        if (iIntValue == 2) {
            return Integer.valueOf(ve(sparseArray));
        }
        if (iIntValue == 3) {
            return tt(sparseArray);
        }
        if (iIntValue != 4) {
            return null;
        }
        return Integer.valueOf(uj.getInstance().getVersion());
    }

    public static Function tt(Function function) {
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(0, -5);
        return (Function) function.apply(sparseArray);
    }

    public static int ve(Function function) {
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(0, 4);
        Object objApply = function.apply(sparseArray);
        if (objApply instanceof Integer) {
            return ((Integer) objApply).intValue();
        }
        return 0;
    }

    public static int c(Function function, String str) {
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(0, 2);
        sparseArray.put(1, str);
        Object objApply = function.apply(sparseArray);
        if (objApply instanceof Integer) {
            return ((Integer) objApply).intValue();
        }
        return 0;
    }

    public static Object c(Function function, String str, com.byazt.dna.c cVar) {
        if (ve(function) < 7500) {
            return function.apply(str);
        }
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(0, 3);
        sparseArray.put(1, str);
        if (cVar != null) {
            sparseArray.put(2, cVar.getAppId());
        }
        return function.apply(sparseArray);
    }

    public static Boolean c(Function function) {
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(0, 1);
        Object objApply = function.apply(sparseArray);
        if (objApply instanceof Boolean) {
            return (Boolean) objApply;
        }
        return Boolean.FALSE;
    }
}

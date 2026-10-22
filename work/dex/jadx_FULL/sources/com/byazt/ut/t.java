package com.byazt.ut;

import android.util.Pair;
import android.util.SparseArray;
import com.byazt.dna.or;
import java.util.HashMap;
import java.util.concurrent.atomic.AtomicReference;
import java.util.function.Function;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_11_8719cls.dex */
@ATSKeep
@com.byazt.zqa.c(c = {0, 1, 834, 66})
public class t implements or, Function {
    public HashMap<String, AtomicReference<Object>> c = new HashMap<>();
    public or tt = new com.byazt.cg.ve();

    private Pair<AtomicReference<Object>, Boolean> c(String str) {
        AtomicReference<Object> atomicReference = this.c.get(str);
        if (atomicReference != null) {
            return new Pair<>(atomicReference, Boolean.FALSE);
        }
        AtomicReference<Object> atomicReference2 = new AtomicReference<>();
        this.c.put(str, atomicReference2);
        return new Pair<>(atomicReference2, Boolean.TRUE);
    }

    @Override // java.util.function.Function
    public Object apply(Object obj) {
        SparseArray sparseArray = (SparseArray) obj;
        int iIntValue = ((Integer) sparseArray.get(0)).intValue();
        if (iIntValue == -3) {
            ats_setAtsField((SparseArray) sparseArray.get(1));
            return null;
        }
        if (iIntValue == -2) {
            return ats_getAtsField();
        }
        if (iIntValue == 1) {
            return get((String) sparseArray.get(1));
        }
        if (iIntValue == 2) {
            return Integer.valueOf(getInt((String) sparseArray.get(1)));
        }
        if (iIntValue == 3) {
            return Long.valueOf(getLong((String) sparseArray.get(1)));
        }
        if (iIntValue == 4) {
            return Boolean.valueOf(getBoolean((String) sparseArray.get(1)));
        }
        if (iIntValue != 5) {
            return null;
        }
        set((String) sparseArray.get(1), (String) sparseArray.get(2));
        return null;
    }

    public SparseArray ats_getAtsField() {
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(1, this.c);
        return sparseArray;
    }

    public void ats_setAtsField(SparseArray sparseArray) {
        Object obj = sparseArray.get(1);
        if (obj != null) {
            this.c = (HashMap) obj;
        }
    }

    @Override // com.byazt.dna.or
    public String get(String str) {
        Pair<AtomicReference<Object>, Boolean> pairC = c(str);
        if (((Boolean) pairC.second).booleanValue()) {
            ((AtomicReference) pairC.first).set(this.tt.get(str));
        }
        Object obj = ((AtomicReference) pairC.first).get();
        return obj != null ? obj.toString() : "";
    }

    @Override // com.byazt.dna.or
    public boolean getBoolean(String str) {
        Pair<AtomicReference<Object>, Boolean> pairC = c(str);
        if (((Boolean) pairC.second).booleanValue()) {
            ((AtomicReference) pairC.first).set(Boolean.valueOf(this.tt.getBoolean(str)));
        }
        Object obj = ((AtomicReference) pairC.first).get();
        if (obj instanceof Boolean) {
            return ((Boolean) obj).booleanValue();
        }
        return false;
    }

    @Override // com.byazt.dna.or
    public int getInt(String str) {
        Pair<AtomicReference<Object>, Boolean> pairC = c(str);
        if (((Boolean) pairC.second).booleanValue()) {
            ((AtomicReference) pairC.first).set(Integer.valueOf(this.tt.getInt(str)));
        }
        Object obj = ((AtomicReference) pairC.first).get();
        if (obj instanceof Integer) {
            return ((Integer) obj).intValue();
        }
        return 0;
    }

    @Override // com.byazt.dna.or
    public long getLong(String str) {
        Pair<AtomicReference<Object>, Boolean> pairC = c(str);
        if (((Boolean) pairC.second).booleanValue()) {
            ((AtomicReference) pairC.first).set(Long.valueOf(this.tt.getLong(str)));
        }
        Object obj = ((AtomicReference) pairC.first).get();
        if (obj instanceof Long) {
            return ((Long) obj).longValue();
        }
        return 0L;
    }

    public void release() {
    }

    @Override // com.byazt.dna.or
    public void set(String str, String str2) {
        this.tt.set(str, str2);
    }
}

package com.byazt.dc;

import android.util.SparseArray;
import com.byazt.ut.ATSKeep;
import java.util.Map;
import java.util.Set;
import java.util.function.Function;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_11_8719cls.dex */
@ATSKeep
@com.byazt.zqa.c(c = {0, 1, 2063, 20})
public class c implements com.byazt.xiv.c, Function {
    @Override // java.util.function.Function
    public Object apply(Object obj) {
        SparseArray sparseArray = (SparseArray) obj;
        int iIntValue = ((Integer) sparseArray.get(0)).intValue();
        if (iIntValue == 1) {
            return getAdnStatusMap();
        }
        if (iIntValue == 2) {
            return Boolean.valueOf(getAndUpdateInitStatus((String) sparseArray.get(1)));
        }
        if (iIntValue == 3) {
            com.byazt.xiv.ve dexPluginStrategy = getDexPluginStrategy((String) sparseArray.get(1));
            return dexPluginStrategy != null ? new com.byazt.xiv.uj(dexPluginStrategy) : dexPluginStrategy;
        }
        if (iIntValue != 4) {
            return null;
        }
        return getAdnKeySet();
    }

    @Override // com.byazt.xiv.c
    public Set<String> getAdnKeySet() {
        return uj.c();
    }

    @Override // com.byazt.xiv.c
    public Map<String, Map<String, Object>> getAdnStatusMap() {
        return tt.c();
    }

    @Override // com.byazt.xiv.c
    public boolean getAndUpdateInitStatus(String str) {
        return tt.c(str);
    }

    @Override // com.byazt.xiv.c
    public com.byazt.xiv.ve getDexPluginStrategy(String str) {
        return uj.c(str);
    }
}

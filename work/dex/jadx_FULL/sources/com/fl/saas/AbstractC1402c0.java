package com.fl.saas;

import androidx.arch.core.util.Function;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;

/* JADX INFO: renamed from: com.fl.saas.c0, reason: case insensitive filesystem */
/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_08_10593cls.dex */
public abstract class AbstractC1402c0 {
    public static List a(JSONArray jSONArray, Function function) {
        return a(jSONArray, true, function);
    }

    public static List a(JSONArray jSONArray, boolean z, Function function) {
        ArrayList arrayList = new ArrayList();
        if (jSONArray == null) {
            return arrayList;
        }
        for (int i = 0; i < jSONArray.length(); i++) {
            try {
                Object objOpt = jSONArray.opt(i);
                if ((objOpt != null || !z) && (function == null || (objOpt = function.apply(objOpt)) != null || !z)) {
                    arrayList.add(objOpt);
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return arrayList;
    }
}

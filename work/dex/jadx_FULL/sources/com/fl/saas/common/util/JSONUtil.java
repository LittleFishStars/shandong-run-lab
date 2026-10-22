package com.fl.saas.common.util;

import androidx.annotation.Nullable;
import androidx.arch.core.util.Function;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_08_10593cls.dex */
public class JSONUtil {
    public static <T> List<T> jsonArrayToList(@Nullable JSONArray jSONArray) {
        return jsonArrayToList(jSONArray, null);
    }

    public static <T> List<T> jsonArrayToList(@Nullable JSONArray jSONArray, Function<Object, T> function) {
        return jsonArrayToList(jSONArray, true, function);
    }

    public static <T> List<T> jsonArrayToList(@Nullable JSONArray jSONArray, boolean z, @Nullable Function<Object, T> function) {
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

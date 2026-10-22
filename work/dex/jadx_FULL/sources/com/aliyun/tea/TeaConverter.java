package com.aliyun.tea;

import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_10_7392cls.dex */
public class TeaConverter {
    public static <T> Map<String, T> buildMap(TeaPair... teaPairArr) {
        HashMap map = new HashMap();
        for (TeaPair teaPair : teaPairArr) {
            map.put(teaPair.key, teaPair.value);
        }
        return map;
    }

    public static <T> Map<String, T> merge(Class<T> cls, Map<String, ?>... mapArr) {
        HashMap map = new HashMap();
        for (Map<String, ?> map2 : mapArr) {
            if (map2 != null) {
                for (Map.Entry<String, ?> entry : map2.entrySet()) {
                    if (entry.getValue() != null) {
                        map.put(entry.getKey(), entry.getValue());
                    }
                }
            }
        }
        return map;
    }

    public static <T> Map<String, T> merge(Class<T> cls, Object... objArr) {
        Map<String, Object> mapBuildMap;
        HashMap map = new HashMap();
        for (int i = 0; i < objArr.length; i++) {
            Object obj = objArr[i];
            if (obj != null) {
                if (TeaModel.class.isAssignableFrom(obj.getClass())) {
                    mapBuildMap = TeaModel.buildMap((TeaModel) objArr[i]);
                } else {
                    mapBuildMap = (Map) objArr[i];
                }
                for (Map.Entry<String, Object> entry : mapBuildMap.entrySet()) {
                    if (entry.getValue() != null) {
                        map.put(entry.getKey(), entry.getValue());
                    }
                }
            }
        }
        return map;
    }
}

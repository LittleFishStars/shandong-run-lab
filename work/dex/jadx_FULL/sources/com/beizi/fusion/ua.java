package com.beizi.fusion;

import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_10_7392cls.dex */
public abstract class ua implements ld {
    @Override // com.beizi.fusion.ld
    public Map<String, String> getMacrosReplaceMap() {
        List<Field> listB = pl.b(getClass());
        if (listB.isEmpty()) {
            return null;
        }
        HashMap map = new HashMap((int) ((((double) listB.size()) / 0.75d) + 1.0d));
        for (Field field : listB) {
            field.setAccessible(true);
            try {
                rh rhVar = (rh) field.getAnnotation(rh.class);
                if (rhVar != null) {
                    String strMacros = rhVar.macros();
                    Object obj = field.get(this);
                    map.put(strMacros, obj != null ? obj.toString() : "");
                } else {
                    Object obj2 = field.get(this);
                    if (obj2 instanceof ld) {
                        map.putAll(((ld) obj2).getMacrosReplaceMap());
                    }
                }
            } catch (IllegalAccessException e) {
                om.a(e);
            }
        }
        return map;
    }
}

package com.beizi.fusion;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_10_7392cls.dex */
public abstract class k5 {

    public interface a {
        Object a(Object obj);
    }

    public static Object a(List list, Object obj, pb pbVar) {
        if (list == null || list.isEmpty()) {
            return null;
        }
        for (int i = 0; i < list.size(); i++) {
            Object obj2 = list.get(i);
            if (obj2 != null && pbVar.fetch(obj2, obj)) {
                return obj2;
            }
        }
        return null;
    }

    public static List b(List list, Object obj, pb pbVar) {
        if (list == null || list.isEmpty()) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        Iterator it = list.iterator();
        while (it.hasNext()) {
            Object next = it.next();
            if (next != null && pbVar.fetch(next, obj)) {
                arrayList.add(next);
                it.remove();
            }
        }
        return arrayList;
    }

    public static List a(List list, a aVar) {
        if (list == null || list.isEmpty()) {
            return null;
        }
        ArrayList arrayList = new ArrayList(list.size());
        Iterator it = list.iterator();
        while (it.hasNext()) {
            arrayList.add(aVar.a(it.next()));
        }
        return arrayList;
    }
}

package com.aliyun.darabonba.array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public class Client {
    public static <T> void append(List<T> list, T t) {
        if (list != null) {
            list.add(t);
        }
    }

    public static List<String> ascSort(List<String> list) {
        if (list == null) {
            throw new IllegalArgumentException("not a valid value for parameter");
        }
        String[] strArr = (String[]) list.toArray(new String[list.size()]);
        Arrays.sort(strArr);
        return Arrays.asList(strArr);
    }

    public static List<String> concat(List<String> list, List<String> list2) {
        if (list == null || list2 == null) {
            throw new IllegalArgumentException("not a valid value for parameter");
        }
        ArrayList arrayList = new ArrayList();
        Iterator<String> it = list.iterator();
        while (it.hasNext()) {
            arrayList.add(it.next());
        }
        arrayList.addAll(list2);
        return arrayList;
    }

    public static Boolean contains(List<String> list, String str) {
        if (list == null || str == null) {
            throw new IllegalArgumentException("not a valid value for parameter");
        }
        return Boolean.valueOf(list.contains(str));
    }

    public static List<String> descSort(List<String> list) {
        if (list == null) {
            throw new IllegalArgumentException("not a valid value for parameter");
        }
        String[] strArr = (String[]) list.toArray(new String[list.size()]);
        Arrays.sort(strArr, Collections.reverseOrder());
        return Arrays.asList(strArr);
    }

    public static String get(List<String> list, Integer num) {
        if (list == null || num.intValue() < 0) {
            throw new IllegalArgumentException("not a valid value for parameter");
        }
        return list.get(num.intValue());
    }

    public static Integer index(List<String> list, String str) {
        if (list == null || str == null) {
            throw new IllegalArgumentException("not a valid value for parameter");
        }
        return Integer.valueOf(list.indexOf(str));
    }

    public static String join(List<String> list, String str) {
        if (list == null || str == null) {
            throw new IllegalArgumentException("not a valid value for parameter");
        }
        if (list.size() <= 0) {
            return list.toString();
        }
        String str2 = list.get(0);
        for (int i = 1; i < list.size(); i++) {
            str2 = str2 + str + list.get(i);
        }
        return str2;
    }

    public static Integer size(List<String> list) {
        if (list != null) {
            return Integer.valueOf(list.size());
        }
        throw new IllegalArgumentException("not a valid value for parameter");
    }

    public static List<String> split(List<String> list, Integer num, Integer num2) {
        if (list == null || num.intValue() < 0 || num2.intValue() >= list.size()) {
            throw new IllegalArgumentException("not a valid value for parameter");
        }
        return list.subList(num.intValue(), num.intValue() + num2.intValue());
    }
}

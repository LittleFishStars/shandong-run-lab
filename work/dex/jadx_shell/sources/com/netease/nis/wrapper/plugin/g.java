package com.netease.nis.wrapper.plugin;

import java.io.File;
import java.lang.reflect.Field;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/peek/classes.dex */
final class g {
    private g() {
    }

    static /* synthetic */ void a(ClassLoader classLoader, File file) throws IllegalAccessException, NoSuchFieldException {
        String path = file.getPath();
        Field fieldA = b.a(classLoader, a.auu.a.c("IgwWNQAHDQ=="));
        String[] strArrSplit = ((String) fieldA.get(classLoader)).split(a.auu.a.c("dA=="));
        StringBuilder sb = new StringBuilder(path);
        for (String str : strArrSplit) {
            if (str != null && !path.equals(str)) {
                sb.append(':').append(str);
            }
        }
        fieldA.set(classLoader, sb.toString());
        Field fieldA2 = b.a(classLoader, a.auu.a.c("IgwWFwABHB4EAA0kHwAjABoREg=="));
        List list = (List) fieldA2.get(classLoader);
        Iterator it = list.iterator();
        while (it.hasNext()) {
            if (path.equals((String) it.next())) {
                it.remove();
                break;
            }
        }
        list.add(0, path);
        fieldA2.set(classLoader, list);
    }

    private static void b(ClassLoader classLoader, File file) throws IllegalAccessException, NoSuchFieldException {
        String path = file.getPath();
        Field fieldA = b.a(classLoader, a.auu.a.c("IgwWNQAHDQ=="));
        String[] strArrSplit = ((String) fieldA.get(classLoader)).split(a.auu.a.c("dA=="));
        StringBuilder sb = new StringBuilder(path);
        for (String str : strArrSplit) {
            if (str != null && !path.equals(str)) {
                sb.append(':').append(str);
            }
        }
        fieldA.set(classLoader, sb.toString());
        Field fieldA2 = b.a(classLoader, a.auu.a.c("IgwWFwABHB4EAA0kHwAjABoREg=="));
        List list = (List) fieldA2.get(classLoader);
        Iterator it = list.iterator();
        while (it.hasNext()) {
            if (path.equals((String) it.next())) {
                it.remove();
                break;
            }
        }
        list.add(0, path);
        fieldA2.set(classLoader, list);
    }
}

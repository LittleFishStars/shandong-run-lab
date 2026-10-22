package com.netease.nis.wrapper.plugin;

import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/peek/classes.dex */
final class f {
    private f() {
    }

    static /* synthetic */ void a(ClassLoader classLoader, File file) throws IllegalAccessException {
        Object obj = b.a(classLoader, a.auu.a.c("PgQADS0aFjo=")).get(classLoader);
        List list = (List) b.a(obj, a.auu.a.c("IAQADBcWKScHBgQTCiEnFxEGFRwXJwAH")).get(obj);
        for (int i = 0; i < list.size(); i++) {
            new StringBuilder(a.auu.a.c("IgwWRQUaFxU=")).append(i).append(a.auu.a.c("E18=")).append(((File) list.get(i)).getAbsolutePath());
        }
        List arrayList = list == null ? new ArrayList(2) : list;
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            if (file.equals((File) it.next())) {
                it.remove();
                break;
            }
        }
        arrayList.add(0, file);
        List arrayList2 = (List) b.a(obj, a.auu.a.c("PRwHEQQeKy8RHRMEPwwsFxUXGDcMPAAXEQ4BDCsW")).get(obj);
        if (arrayList2 == null) {
            arrayList2 = new ArrayList(2);
        }
        ArrayList arrayList3 = new ArrayList(arrayList.size() + arrayList2.size() + 1);
        arrayList3.addAll(arrayList);
        arrayList3.addAll(arrayList2);
        b.a(obj, a.auu.a.c("IAQADBcWKScHBgQTCjUvERwgDRYIKwsAFg==")).set(obj, (Object[]) b.a(obj, a.auu.a.c("IwQfADESESYgGAAMFgs6Fg=="), List.class).invoke(obj, arrayList3));
    }

    private static void b(ClassLoader classLoader, File file) throws IllegalAccessException {
        Object obj = b.a(classLoader, a.auu.a.c("PgQADS0aFjo=")).get(classLoader);
        List list = (List) b.a(obj, a.auu.a.c("IAQADBcWKScHBgQTCiEnFxEGFRwXJwAH")).get(obj);
        for (int i = 0; i < list.size(); i++) {
            new StringBuilder(a.auu.a.c("IgwWRQUaFxU=")).append(i).append(a.auu.a.c("E18=")).append(((File) list.get(i)).getAbsolutePath());
        }
        List arrayList = list == null ? new ArrayList(2) : list;
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            if (file.equals((File) it.next())) {
                it.remove();
                break;
            }
        }
        arrayList.add(0, file);
        List arrayList2 = (List) b.a(obj, a.auu.a.c("PRwHEQQeKy8RHRMEPwwsFxUXGDcMPAAXEQ4BDCsW")).get(obj);
        if (arrayList2 == null) {
            arrayList2 = new ArrayList(2);
        }
        ArrayList arrayList3 = new ArrayList(arrayList.size() + arrayList2.size() + 1);
        arrayList3.addAll(arrayList);
        arrayList3.addAll(arrayList2);
        b.a(obj, a.auu.a.c("IAQADBcWKScHBgQTCjUvERwgDRYIKwsAFg==")).set(obj, (Object[]) b.a(obj, a.auu.a.c("IwQfADESESYgGAAMFgs6Fg=="), List.class).invoke(obj, arrayList3));
    }
}

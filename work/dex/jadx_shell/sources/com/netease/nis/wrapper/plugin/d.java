package com.netease.nis.wrapper.plugin;

import java.io.File;
import java.lang.reflect.Field;
import java.util.ArrayList;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/peek/classes.dex */
final class d {
    private d() {
    }

    static /* synthetic */ void a(ClassLoader classLoader, File file) throws IllegalAccessException, NoSuchFieldException {
        Object obj = b.a(classLoader, a.auu.a.c("PgQADS0aFjo=")).get(classLoader);
        Field fieldA = b.a(obj, a.auu.a.c("IAQADBcWKScHBgQTCiEnFxEGFRwXJwAH"));
        File[] fileArr = (File[]) fieldA.get(obj);
        ArrayList arrayList = new ArrayList(fileArr.length + 1);
        arrayList.add(file);
        for (File file2 : fileArr) {
            if (!file.equals(file2)) {
                arrayList.add(file2);
            }
        }
        fieldA.set(obj, arrayList.toArray(new File[0]));
    }

    private static void b(ClassLoader classLoader, File file) throws IllegalAccessException, NoSuchFieldException {
        Object obj = b.a(classLoader, a.auu.a.c("PgQADS0aFjo=")).get(classLoader);
        Field fieldA = b.a(obj, a.auu.a.c("IAQADBcWKScHBgQTCiEnFxEGFRwXJwAH"));
        File[] fileArr = (File[]) fieldA.get(obj);
        ArrayList arrayList = new ArrayList(fileArr.length + 1);
        arrayList.add(file);
        for (File file2 : fileArr) {
            if (!file.equals(file2)) {
                arrayList.add(file2);
            }
        }
        fieldA.set(obj, arrayList.toArray(new File[0]));
    }
}

package com.kuaishou.weapon.p0;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_06_4659cls.dex */
public class cp {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static volatile boolean f40092a = false;
    private static volatile boolean b = true;

    static {
        try {
            f40092a = ((Boolean) Class.forName("dalvik.system.VMRuntime").getDeclaredMethod("is64Bit", new Class[0]).invoke(Class.forName("dalvik.system.VMRuntime").getDeclaredMethod("getRuntime", new Class[0]).invoke(null, new Object[0]), new Object[0])).booleanValue();
        } catch (Exception unused) {
            f40092a = false;
        }
        b = System.getProperty("java.vm.version").startsWith("2");
    }

    public static boolean a() {
        return f40092a;
    }

    public static boolean b() {
        return b;
    }
}

package com.zj.adlib;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_08_10593cls.dex */
public final class drc {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final zqc f41264a;
    public static final zqc b;

    static {
        zqc zqcVar;
        try {
            zqcVar = (zqc) Class.forName("com.google.protobuf.NewInstanceSchemaFull").getDeclaredConstructor(new Class[0]).newInstance(new Object[0]);
        } catch (Exception unused) {
            zqcVar = null;
        }
        f41264a = zqcVar;
        b = new zqc();
    }

    public static zqc a() {
        return f41264a;
    }

    public static zqc b() {
        return b;
    }
}

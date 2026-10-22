package com.zj.adlib;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_08_10593cls.dex */
public final class upc {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final qpc f45203a;
    public static final qpc b;

    static {
        qpc qpcVar;
        try {
            qpcVar = (qpc) Class.forName("com.google.protobuf.MapFieldSchemaFull").getDeclaredConstructor(new Class[0]).newInstance(new Object[0]);
        } catch (Exception unused) {
            qpcVar = null;
        }
        f45203a = qpcVar;
        b = new qpc();
    }

    public static qpc a() {
        return f45203a;
    }

    public static qpc b() {
        return b;
    }
}

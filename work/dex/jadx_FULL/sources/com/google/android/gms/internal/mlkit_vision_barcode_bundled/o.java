package com.google.android.gms.internal.mlkit_vision_barcode_bundled;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_08_10593cls.dex */
public final class o {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final zzdp f31388a = new n();
    public static final zzdp b;

    static {
        zzdp zzdpVar;
        try {
            zzdpVar = (zzdp) Class.forName("com.google.protobuf.ExtensionSchemaFull").getDeclaredConstructor(new Class[0]).newInstance(new Object[0]);
        } catch (Exception unused) {
            zzdpVar = null;
        }
        b = zzdpVar;
    }

    public static zzdp a() {
        zzdp zzdpVar = b;
        if (zzdpVar != null) {
            return zzdpVar;
        }
        throw new IllegalStateException("Protobuf runtime is not correctly loaded.");
    }

    public static zzdp b() {
        return f31388a;
    }
}

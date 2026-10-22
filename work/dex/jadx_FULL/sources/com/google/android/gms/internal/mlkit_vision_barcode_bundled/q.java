package com.google.android.gms.internal.mlkit_vision_barcode_bundled;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_08_10593cls.dex */
public final class q implements zzfm {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final q f31391a = new q();

    public static q c() {
        return f31391a;
    }

    @Override // com.google.android.gms.internal.mlkit_vision_barcode_bundled.zzfm
    public final zzfl a(Class cls) {
        if (!zzed.class.isAssignableFrom(cls)) {
            throw new IllegalArgumentException("Unsupported message type: ".concat(cls.getName()));
        }
        try {
            return (zzfl) zzed.j(cls.asSubclass(zzed.class)).zzg(3, null, null);
        } catch (Exception e) {
            throw new RuntimeException("Unable to get message info for ".concat(cls.getName()), e);
        }
    }

    @Override // com.google.android.gms.internal.mlkit_vision_barcode_bundled.zzfm
    public final boolean b(Class cls) {
        return zzed.class.isAssignableFrom(cls);
    }
}
